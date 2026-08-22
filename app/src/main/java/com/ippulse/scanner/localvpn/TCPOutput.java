package com.ippulse.scanner.localvpn;

import android.util.Log;

import com.ippulse.scanner.GamingVpnService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ippulse.scanner.localvpn.Packet.TCPHeader;
import com.ippulse.scanner.localvpn.TCB.TCBStatus;

public class TCPOutput implements Runnable {

    private static final String TAG = "TCPOutput";

    private final GamingVpnService vpnService;
    private final ConcurrentLinkedQueue<Packet> inputQueue;
    private final ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private final Selector selector;

    private final Random random = new Random();

    /*
     * Connection establishment is deliberately separated from the
     * packet/selector worker. A slow physical TCP handshake must not
     * block processing of the next packet.
     */
    private final ExecutorService connectExecutor =
            Executors.newCachedThreadPool();

    public TCPOutput(
            ConcurrentLinkedQueue<Packet> inputQueue,
            ConcurrentLinkedQueue<ByteBuffer> outputQueue,
            Selector selector,
            GamingVpnService vpnService) {

        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
        this.selector = selector;
        this.vpnService = vpnService;
    }

    @Override
    public void run() {
        Log.i(TAG, "Started");

        try {
            while (!Thread.currentThread().isInterrupted()) {

                Packet currentPacket = inputQueue.poll();

                if (currentPacket == null) {
                    Thread.sleep(5);
                    continue;
                }

                ByteBuffer payloadBuffer = currentPacket.backingBuffer;
                currentPacket.backingBuffer = null;

                ByteBuffer responseBuffer = ByteBufferPool.acquire();

                InetAddress destinationAddress =
                        currentPacket.ip4Header.destinationAddress;

                TCPHeader tcpHeader = currentPacket.tcpHeader;

                int destinationPort = tcpHeader.destinationPort;
                int sourcePort = tcpHeader.sourcePort;

                String ipAndPort =
                        destinationAddress.getHostAddress()
                                + ":" + destinationPort
                                + ":" + sourcePort;

                Log.i(
                        TAG,
                        "TCPOutput PACKET RECEIVED "
                                + ipAndPort
                                + " SYN=" + tcpHeader.isSYN()
                                + " ACK=" + tcpHeader.isACK()
                                + " FIN=" + tcpHeader.isFIN()
                                + " RST=" + tcpHeader.isRST());

                TCB tcb = TCB.getTCB(ipAndPort);

                if (tcb == null) {

                    initializeConnection(
                            ipAndPort,
                            destinationAddress,
                            destinationPort,
                            currentPacket,
                            tcpHeader,
                            responseBuffer);

                } else if (tcpHeader.isSYN()) {

                    processDuplicateSYN(
                            tcb,
                            tcpHeader,
                            responseBuffer);

                } else if (tcpHeader.isRST()) {

                    closeCleanly(tcb, responseBuffer);

                } else if (tcpHeader.isFIN()) {

                    processFIN(
                            tcb,
                            tcpHeader,
                            responseBuffer);

                } else if (tcpHeader.isACK()) {

                    processACK(
                            tcb,
                            tcpHeader,
                            payloadBuffer,
                            responseBuffer);
                }

                if (responseBuffer.position() == 0) {
                    ByteBufferPool.release(responseBuffer);
                }

                ByteBufferPool.release(payloadBuffer);
            }

        } catch (InterruptedException e) {
            Log.i(TAG, "Stopping");

        } catch (Exception e) {
            Log.e(TAG, "TCPOutput fatal error", e);

        } finally {
            try {
                connectExecutor.shutdownNow();
            } catch (Exception ignored) {
            }

            TCB.closeAll();
        }
    }

    private void initializeConnection(
            String ipAndPort,
            InetAddress destinationAddress,
            int destinationPort,
            Packet currentPacket,
            TCPHeader tcpHeader,
            ByteBuffer responseBuffer)
            throws IOException {

        currentPacket.swapSourceAndDestination();

        /*
         * A non-SYN packet without a TCB cannot create a new stream.
         */
        if (!tcpHeader.isSYN()) {

            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.RST,
                    0,
                    tcpHeader.sequenceNumber + 1,
                    0
            );

            outputQueue.offer(responseBuffer);

            vpnService.debug(
                    "TCP NON-SYN WITHOUT TCB -> RST "
                            + ipAndPort
            );

            return;
        }

        /*
         * Keep the physical socket alive while the real TCP handshake
         * is performed in the dedicated connection worker.
         */
        SocketChannel outputChannel =
                SocketChannel.open();

        /*
         * Start in blocking mode for the outbound connect itself.
         * The timeout prevents a dead route from hanging forever.
         */
        outputChannel.configureBlocking(true);

        vpnService.debug(
                "TCP SOCKET CREATED "
                        + destinationAddress.getHostAddress()
                        + ":"
                        + destinationPort
        );

        boolean protectedOk =
                vpnService.protectOrBind(
                        outputChannel.socket()
                );

        if (!protectedOk) {

            vpnService.debug(
                    "TCP PROTECT FAILED "
                            + ipAndPort
            );

            try {
                outputChannel.close();
            } catch (Exception ignored) {
            }

            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.RST,
                    0,
                    tcpHeader.sequenceNumber + 1,
                    0
            );

            outputQueue.offer(responseBuffer);
            return;
        }

        vpnService.debug(
                "TCP PROTECT OK "
                        + ipAndPort
        );

        TCB tcb =
                new TCB(
                        ipAndPort,
                        random.nextInt(Short.MAX_VALUE + 1),
                        tcpHeader.sequenceNumber,
                        tcpHeader.sequenceNumber + 1,
                        tcpHeader.acknowledgementNumber,
                        outputChannel,
                        currentPacket
                );

        tcb.status =
                TCBStatus.SYN_SENT;

        TCB.putTCB(
                ipAndPort,
                tcb
        );

        vpnService.debug(
                "TCP CONNECT QUEUED "
                        + ipAndPort
        );

        /*
         * The original TCPOutput loop must remain free to process more
         * packets. The actual physical connect happens here.
         */
        try {

            connectExecutor.submit(
                    new Runnable() {
                        @Override
                        public void run() {

                            try {

                                vpnService.debug(
                                        "TCP PHYSICAL CONNECT START "
                                                + ipAndPort
                                );

                                /*
                                 * Use the Socket API timeout while the
                                 * SocketChannel is in blocking mode.
                                 */
                                outputChannel.socket().connect(
                                        new InetSocketAddress(
                                                destinationAddress,
                                                destinationPort
                                        ),
                                        8000
                                );

                                vpnService.debug(
                                        "TCP PHYSICAL CONNECT SUCCESS "
                                                + ipAndPort
                                );

                                /*
                                 * Selector can only work with a non-blocking
                                 * SocketChannel.
                                 */
                                outputChannel.configureBlocking(
                                        false
                                );

                                /*
                                 * IMPORTANT:
                                 * register first, then wake the selector.
                                 */
                                selector.wakeup();

                                SelectionKey key =
                                        outputChannel.register(
                                                selector,
                                                SelectionKey.OP_READ,
                                                tcb
                                        );

                                tcb.selectionKey = key;
                                tcb.waitingForNetworkData = true;
                                tcb.status =
                                        TCBStatus.SYN_RECEIVED;

                                /*
                                 * Build SYN-ACK only after the real
                                 * physical connection succeeds.
                                 */
                                ByteBuffer synAck =
                                        ByteBufferPool.acquire();

                                tcb.referencePacket.updateTCPBuffer(
                                        synAck,
                                        (byte)
                                                (TCPHeader.SYN
                                                        | TCPHeader.ACK),
                                        tcb.mySequenceNum,
                                        tcb.myAcknowledgementNum,
                                        0
                                );

                                tcb.mySequenceNum++;

                                outputQueue.offer(
                                        synAck
                                );

                                /*
                                 * Wake again after all selector state has
                                 * been installed and the response is queued.
                                 */
                                selector.wakeup();

                                vpnService.debug(
                                        "TCP CONNECTED "
                                                + ipAndPort
                                );

                                vpnService.debug(
                                        "TCP SYN-ACK QUEUED "
                                                + ipAndPort
                                );

                            } catch (Exception e) {

                                vpnService.debug(
                                        "TCP PHYSICAL CONNECT FAILED "
                                                + ipAndPort
                                                + " "
                                                + e.getClass().getName()
                                                + ": "
                                                + String.valueOf(
                                                        e.getMessage()
                                                )
                                );

                                /*
                                 * If the VPN is stopping, do not manufacture
                                 * a noisy RST against a connection that is
                                 * already being torn down.
                                 */
                                if (!outputChannel.isOpen()) {
                                    TCB.closeTCB(tcb);
                                    return;
                                }

                                try {

                                    ByteBuffer rst =
                                            ByteBufferPool.acquire();

                                    tcb.referencePacket.updateTCPBuffer(
                                            rst,
                                            (byte) TCPHeader.RST,
                                            0,
                                            tcb.myAcknowledgementNum,
                                            0
                                    );

                                    outputQueue.offer(
                                            rst
                                    );

                                } catch (Exception ignored) {
                                }

                                TCB.closeTCB(
                                        tcb
                                );
                            }
                        }
                    }
            );

        } catch (Exception e) {

            vpnService.debug(
                    "TCP CONNECT QUEUE FAILED "
                            + ipAndPort
                            + " "
                            + e
            );

            TCB.closeTCB(tcb);
        }
    }

    private void processDuplicateSYN(
            TCB tcb,
            TCPHeader tcpHeader,
            ByteBuffer responseBuffer) {

        synchronized (tcb) {

            if (tcb.status == TCBStatus.SYN_SENT) {

                tcb.myAcknowledgementNum =
                        tcpHeader.sequenceNumber + 1;

                ByteBufferPool.release(responseBuffer);
                return;
            }
        }

        sendRST(
                tcb,
                1,
                responseBuffer);
    }

    private void processFIN(
            TCB tcb,
            TCPHeader tcpHeader,
            ByteBuffer responseBuffer) {

        synchronized (tcb) {

            Packet referencePacket =
                    tcb.referencePacket;

            tcb.myAcknowledgementNum =
                    tcpHeader.sequenceNumber + 1;

            tcb.theirAcknowledgementNum =
                    tcpHeader.acknowledgementNumber;

            if (tcb.waitingForNetworkData) {

                tcb.status =
                        TCBStatus.CLOSE_WAIT;

                referencePacket.updateTCPBuffer(
                        responseBuffer,
                        (byte) TCPHeader.ACK,
                        tcb.mySequenceNum,
                        tcb.myAcknowledgementNum,
                        0);

            } else {

                tcb.status =
                        TCBStatus.LAST_ACK;

                referencePacket.updateTCPBuffer(
                        responseBuffer,
                        (byte) (TCPHeader.FIN | TCPHeader.ACK),
                        tcb.mySequenceNum,
                        tcb.myAcknowledgementNum,
                        0);

                tcb.mySequenceNum++;
            }
        }

        outputQueue.offer(responseBuffer);
    }

    private void processACK(
            TCB tcb,
            TCPHeader tcpHeader,
            ByteBuffer payloadBuffer,
            ByteBuffer responseBuffer)
            throws IOException {

        int payloadSize =
                payloadBuffer.limit()
                        - payloadBuffer.position();

        synchronized (tcb) {

            SocketChannel outputChannel =
                    tcb.channel;

            if (tcb.status == TCBStatus.SYN_RECEIVED) {

                tcb.status =
                        TCBStatus.ESTABLISHED;

                tcb.theirAcknowledgementNum =
                        tcpHeader.acknowledgementNumber;

                selector.wakeup();

                if (tcb.selectionKey == null
                        || !tcb.selectionKey.isValid()) {

                    tcb.selectionKey =
                            outputChannel.register(
                                    selector,
                                    SelectionKey.OP_READ,
                                    tcb);

                } else {

                    tcb.selectionKey.interestOps(
                            SelectionKey.OP_READ);
                }

                tcb.waitingForNetworkData = true;

                Log.i(
                        TAG,
                        "TCP ESTABLISHED: "
                                + tcb.ipAndPort);
            }

            if (tcb.status == TCBStatus.LAST_ACK) {

                closeCleanly(
                        tcb,
                        responseBuffer);

                return;
            }

            if (payloadSize == 0) {
                /*
                 * The run() loop owns responseBuffer and will release
                 * it when position() == 0. Never release it here too.
                 */
                return;
            }

            if (!tcb.waitingForNetworkData) {

                selector.wakeup();

                tcb.selectionKey.interestOps(
                        SelectionKey.OP_READ);

                tcb.waitingForNetworkData = true;
            }

            while (payloadBuffer.hasRemaining()) {

                int written =
                        outputChannel.write(payloadBuffer);

                if (written == 0) {
                    /*
                     * Socket is temporarily not writable.
                     * Do not pretend the entire packet was sent.
                     */
                    break;
                }
            }

            tcb.myAcknowledgementNum =
                    tcpHeader.sequenceNumber
                            + payloadSize;

            tcb.theirAcknowledgementNum =
                    tcpHeader.acknowledgementNumber;

            Packet referencePacket =
                    tcb.referencePacket;

            referencePacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.ACK,
                    tcb.mySequenceNum,
                    tcb.myAcknowledgementNum,
                    0);
        }

        outputQueue.offer(responseBuffer);
    }

    private void sendRST(
            TCB tcb,
            int previousPayloadSize,
            ByteBuffer buffer) {

        try {

            synchronized (tcb) {

                tcb.referencePacket.updateTCPBuffer(
                        buffer,
                        (byte) TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum
                                + previousPayloadSize,
                        0);
            }

            outputQueue.offer(buffer);

        } finally {

            TCB.closeTCB(tcb);
        }
    }

    private void closeCleanly(
            TCB tcb,
            ByteBuffer buffer) {

        ByteBufferPool.release(buffer);
        TCB.closeTCB(tcb);
    }
}
