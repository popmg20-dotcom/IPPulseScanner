package com.ippulse.scanner.localvpn;

import android.util.Log;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.ippulse.scanner.localvpn.TCB.TCBStatus;

/**
 * Reads data from real TCP sockets and converts it back to
 * packets written to the VPN TUN interface.
 *
 * Reads data from already-established outbound TCP sockets.
 */
public class TCPInput implements Runnable {

    private static final String TAG = "TCPInput";

    private static final int HEADER_SIZE =
            Packet.IP4_HEADER_SIZE + Packet.TCP_HEADER_SIZE;

    private final ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private final Selector selector;
    private final int mtu;

    public TCPInput(
            ConcurrentLinkedQueue<ByteBuffer> outputQueue,
            Selector selector,
            int mtu) {

        this.outputQueue = outputQueue;
        this.selector = selector;
        this.mtu = mtu;
    }

    @Override
    public void run() {

        Log.i(TAG, "TCPInput started");

        try {

            while (!Thread.currentThread().isInterrupted()) {

                int readyChannels = selector.select(250);

                if (readyChannels == 0) {
                    continue;
                }

                Set<SelectionKey> keys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = keys.iterator();

                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (!key.isValid()) {
                        continue;
                    }

                    try {

                        /*
                         * TCPOutput performs the physical blocking connect
                         * and registers the socket with OP_READ afterwards.
                         *
                         * TCPInput is therefore strictly network-read only.
                         */
                        if (key.isReadable()) {
                            processInput(key);
                        }

                    } catch (Exception e) {

                        TCB tcb = null;

                        try {
                            tcb = (TCB) key.attachment();
                        } catch (Exception ignored) {
                        }

                        String id =
                                tcb != null
                                        ? tcb.ipAndPort
                                        : "unknown";

                        Log.e(
                                TAG,
                                "TCP selector key error " + id,
                                e
                        );
                    }
                }
            }

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "TCPInput fatal error",
                    e
            );
        }
    }

    /**
     * Complete the outbound non-blocking TCP connection.
     *
     * IMPORTANT:
     * register OP_READ only after finishConnect() succeeds.
     * The selector is woken AFTER registration so the selector
     * thread cannot miss the newly registered key.
     */
    private void processInput(SelectionKey key) {

        TCB tcb = (TCB) key.attachment();

        if (tcb == null) {
            try {
                key.cancel();
            } catch (Exception ignored) {
            }
            return;
        }

        ByteBuffer receiveBuffer =
                ByteBufferPool.acquire();

        receiveBuffer.position(HEADER_SIZE);

        int maxPayload =
                Math.max(
                        1,
                        mtu - HEADER_SIZE
                );

        int maxLimit =
                HEADER_SIZE + maxPayload;

        if (receiveBuffer.capacity() > maxLimit) {
            receiveBuffer.limit(maxLimit);
        }

        try {

            SocketChannel channel =
                    (SocketChannel) key.channel();

            int readBytes;

            synchronized (tcb) {

                readBytes =
                        channel.read(receiveBuffer);

                Log.i(
                        TAG,
                        "TCP NETWORK READ "
                                + tcb.ipAndPort
                                + " bytes="
                                + readBytes
                );

                vpnDebug(
                        "TCP NETWORK READ "
                                + tcb.ipAndPort
                                + " bytes="
                                + readBytes
                );

                Packet referencePacket =
                        tcb.referencePacket;

                if (readBytes < 0) {

                    key.interestOps(0);

                    tcb.waitingForNetworkData = false;

                    ByteBufferPool.release(receiveBuffer);

                    if (tcb.status != TCBStatus.CLOSE_WAIT) {
                        TCB.closeTCB(tcb);
                        return;
                    }

                    receiveBuffer =
                            ByteBufferPool.acquire();

                    receiveBuffer.position(
                            HEADER_SIZE
                    );

                    tcb.status = TCBStatus.LAST_ACK;

                    referencePacket.updateTCPBuffer(
                            receiveBuffer,
                            (byte) Packet.TCPHeader.FIN,
                            tcb.mySequenceNum,
                            tcb.myAcknowledgementNum,
                            0
                    );

                    tcb.mySequenceNum++;

                } else if (readBytes == 0) {

                    ByteBufferPool.release(receiveBuffer);
                    return;

                } else {

                    referencePacket.updateTCPBuffer(
                            receiveBuffer,
                            (byte) (
                                    Packet.TCPHeader.PSH
                                            | Packet.TCPHeader.ACK
                            ),
                            tcb.mySequenceNum,
                            tcb.myAcknowledgementNum,
                            readBytes
                    );

                    tcb.mySequenceNum += readBytes;

                    receiveBuffer.position(
                            HEADER_SIZE + readBytes
                    );
                }
            }

            outputQueue.offer(receiveBuffer);

        } catch (IOException e) {

            Log.e(
                    TAG,
                    "TCP network read error "
                            + tcb.ipAndPort,
                    e
            );

            vpnDebug(
                    "TCP NETWORK READ ERROR "
                            + tcb.ipAndPort
                            + " "
                            + e.getClass().getName()
                            + ": "
                            + String.valueOf(e.getMessage())
            );

            try {

                tcb.referencePacket.updateTCPBuffer(
                        receiveBuffer,
                        (byte) Packet.TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum,
                        0
                );

                outputQueue.offer(receiveBuffer);

            } catch (Exception ignored) {

                ByteBufferPool.release(receiveBuffer);
            }

            TCB.closeTCB(tcb);
        }
    }

    /**
     * Best-effort debug bridge without creating a hard dependency
     * on GamingVpnService from the LocalVPN package.
     */
    private void vpnDebug(String message) {

        try {

            /*
             * TCPOutput already has the service reference, but this
             * class does not. Android logcat still receives all
             * diagnostic information here.
             */
            Log.i(
                    TAG,
                    "VPN_DEBUG " + message
            );

        } catch (Exception ignored) {
        }
    }
}
