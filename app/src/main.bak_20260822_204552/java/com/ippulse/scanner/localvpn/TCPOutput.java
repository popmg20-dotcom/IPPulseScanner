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

import com.ippulse.scanner.localvpn.Packet.TCPHeader;
import com.ippulse.scanner.localvpn.TCB.TCBStatus;

public class TCPOutput implements Runnable {

    private static final String TAG = "TCPOutput";

    private final GamingVpnService vpnService;
    private final ConcurrentLinkedQueue<Packet> inputQueue;
    private final ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private final Selector selector;

    private final Random random = new Random();

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

        if (!tcpHeader.isSYN()) {
            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.RST,
                    0,
                    tcpHeader.sequenceNumber + 1,
                    0);

            outputQueue.offer(responseBuffer);

            vpnService.debug(
                    "TCP NON-SYN WITHOUT TCB -> RST "
                            + ipAndPort);

            return;
        }

        SocketChannel outputChannel = SocketChannel.open();

        /*
         * LocalVPN model:
         * non-blocking connect + OP_CONNECT
         */
        outputChannel.configureBlocking(false);

        vpnService.debug(
                "TCP SOCKET CREATED "
                        + destinationAddress.getHostAddress()
                        + ":" + destinationPort);

        boolean protectedOrBound =
                vpnService.protectOrBind(outputChannel.socket());

        if (!protectedOrBound) {

            vpnService.debug(
                    "TCP PROTECT/BIND FAILED "
                            + ipAndPort);

            outputChannel.close();

            currentPacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) TCPHeader.RST,
                    0,
                    tcpHeader.sequenceNumber + 1,
                    0);

            outputQueue.offer(responseBuffer);
            return;
        }

        vpnService.debug(
                "TCP PROTECT/BIND OK "
                        + ipAndPort);

        TCB tcb = new TCB(
                ipAndPort,
                random.nextInt(Short.MAX_VALUE + 1),
                tcpHeader.sequenceNumber,
                tcpHeader.sequenceNumber + 1,
                tcpHeader.acknowledgementNumber,
                outputChannel,
                currentPacket);

        /*
         * The outbound physical connection is being attempted.
         */
        tcb.status = TCBStatus.SYN_SENT;

        TCB.putTCB(
                ipAndPort,
                tcb);

        vpnService.debug(
                "TCP CONNECT START "
                        + destinationAddress.getHostAddress()
                        + ":" + destinationPort);

        try {

            outputChannel.connect(
                    new InetSocketAddress(
                            destinationAddress,
                            destinationPort));

            /*
             * Fast path: already connected.
             */
            if (outputChannel.finishConnect()) {

                tcb.status =
                        TCBStatus.SYN_RECEIVED;

                currentPacket.updateTCPBuffer(
                        responseBuffer,
                        (byte) (TCPHeader.SYN | TCPHeader.ACK),
                        tcb.mySequenceNum,
                        tcb.myAcknowledgementNum,
                        0);

                tcb.mySequenceNum++;

                outputQueue.offer(responseBuffer);

                selector.wakeup();

                tcb.selectionKey =
                        outputChannel.register(
                                selector,
                                SelectionKey.OP_READ,
                                tcb);

                tcb.waitingForNetworkData = true;

                vpnService.debug(
                        "TCP CONNECTED FAST "
                                + ipAndPort);

                vpnService.debug(
                        "TCP SYN-ACK QUEUED "
                                + ipAndPort);

            } else {

                /*
                 * Normal non-blocking path.
                 */
                selector.wakeup();

                tcb.selectionKey =
                        outputChannel.register(
                                selector,
                                SelectionKey.OP_CONNECT,
                                tcb);

                vpnService.debug(
                        "TCP CONNECT PENDING -> OP_CONNECT "
                                + ipAndPort);
            }

        } catch (Exception e) {

            vpnService.debug(
                    "TCP CONNECT START FAILED "
                            + ipAndPort
                            + " "
                            + e);

            try {
                currentPacket.updateTCPBuffer(
                        responseBuffer,
                        (byte) TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum,
                        0);

                outputQueue.offer(responseBuffer);

            } finally {
                TCB.closeTCB(tcb);
            }
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
                ByteBufferPool.release(responseBuffer);
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
