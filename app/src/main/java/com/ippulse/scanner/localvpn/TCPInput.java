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

public class TCPInput implements Runnable {

    private static final String TAG = "TCPInput";

    private static final int HEADER_SIZE =
            Packet.IP4_HEADER_SIZE
                    + Packet.TCP_HEADER_SIZE;

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

                int readyChannels =
                        selector.select(250);

                if (readyChannels == 0) {
                    continue;
                }

                Set<SelectionKey> keys =
                        selector.selectedKeys();

                Iterator<SelectionKey> iterator =
                        keys.iterator();

                while (iterator.hasNext()) {

                    SelectionKey key =
                            iterator.next();

                    if (!key.isValid()) {
                        iterator.remove();
                        continue;
                    }

                    try {

                        if (key.isConnectable()) {

                            processConnect(
                                    key,
                                    iterator);

                        } else if (key.isReadable()) {

                            processInput(
                                    key,
                                    iterator);
                        }

                    } catch (Exception e) {

                        Log.e(
                                TAG,
                                "TCP selector key error",
                                e);

                        try {
                            key.cancel();
                        } catch (Exception ignored) {
                        }

                        iterator.remove();
                    }
                }
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        } catch (Exception e) {

            Log.e(
                    TAG,
                    "TCPInput fatal error",
                    e);
        }
    }

    private void processConnect(
            SelectionKey key,
            Iterator<SelectionKey> iterator) {

        TCB tcb =
                (TCB) key.attachment();

        Packet referencePacket =
                tcb.referencePacket;

        try {

            SocketChannel channel =
                    (SocketChannel) key.channel();

            if (!channel.finishConnect()) {
                return;
            }

            iterator.remove();

            tcb.status =
                    TCBStatus.SYN_RECEIVED;

            ByteBuffer responseBuffer =
                    ByteBufferPool.acquire();

            referencePacket.updateTCPBuffer(
                    responseBuffer,
                    (byte)
                            (Packet.TCPHeader.SYN
                                    | Packet.TCPHeader.ACK),
                    tcb.mySequenceNum,
                    tcb.myAcknowledgementNum,
                    0);

            tcb.mySequenceNum++;

            outputQueue.offer(
                    responseBuffer);

            key.interestOps(
                    SelectionKey.OP_READ);

            tcb.selectionKey = key;
            tcb.waitingForNetworkData = true;

            Log.i(
                    TAG,
                    "TCP CONNECTED: "
                            + tcb.ipAndPort);

            Log.i(
                    TAG,
                    "TCP SYN-ACK QUEUED: "
                            + tcb.ipAndPort);

        } catch (IOException e) {

            Log.e(
                    TAG,
                    "TCP connect error: "
                            + tcb.ipAndPort,
                    e);

            ByteBuffer responseBuffer =
                    ByteBufferPool.acquire();

            referencePacket.updateTCPBuffer(
                    responseBuffer,
                    (byte) Packet.TCPHeader.RST,
                    0,
                    tcb.myAcknowledgementNum,
                    0);

            outputQueue.offer(
                    responseBuffer);

            TCB.closeTCB(tcb);
        }
    }

    private void processInput(
            SelectionKey key,
            Iterator<SelectionKey> iterator) {

        iterator.remove();

        TCB tcb =
                (TCB) key.attachment();

        ByteBuffer receiveBuffer =
                ByteBufferPool.acquire();

        receiveBuffer.position(
                HEADER_SIZE);

        int maxPayload =
                Math.max(
                        1,
                        mtu - HEADER_SIZE);

        int maxLimit =
                HEADER_SIZE + maxPayload;

        if (receiveBuffer.capacity()
                > maxLimit) {

            receiveBuffer.limit(
                    maxLimit);
        }

        try {

            SocketChannel channel =
                    (SocketChannel) key.channel();

            int readBytes;

            synchronized (tcb) {

                readBytes =
                        channel.read(
                                receiveBuffer);

                Log.i(
                        TAG,
                        "TCP NETWORK READ "
                                + tcb.ipAndPort
                                + " bytes="
                                + readBytes);

                Packet referencePacket =
                        tcb.referencePacket;

                if (readBytes < 0) {

                    key.interestOps(0);

                    tcb.waitingForNetworkData =
                            false;

                    if (tcb.status
                            != TCBStatus.CLOSE_WAIT) {

                        ByteBufferPool.release(
                                receiveBuffer);

                        return;
                    }

                    tcb.status =
                            TCBStatus.LAST_ACK;

                    referencePacket.updateTCPBuffer(
                            receiveBuffer,
                            (byte) Packet.TCPHeader.FIN,
                            tcb.mySequenceNum,
                            tcb.myAcknowledgementNum,
                            0);

                    tcb.mySequenceNum++;

                } else if (readBytes == 0) {

                    ByteBufferPool.release(
                            receiveBuffer);

                    return;

                } else {

                    referencePacket.updateTCPBuffer(
                            receiveBuffer,
                            (byte)
                                    (Packet.TCPHeader.PSH
                                            | Packet.TCPHeader.ACK),
                            tcb.mySequenceNum,
                            tcb.myAcknowledgementNum,
                            readBytes);

                    tcb.mySequenceNum +=
                            readBytes;

                    receiveBuffer.position(
                            HEADER_SIZE
                                    + readBytes);
                }
            }

            outputQueue.offer(
                    receiveBuffer);

        } catch (IOException e) {

            Log.e(
                    TAG,
                    "TCP network read error "
                            + tcb.ipAndPort,
                    e);

            try {

                Packet referencePacket =
                        tcb.referencePacket;

                referencePacket.updateTCPBuffer(
                        receiveBuffer,
                        (byte) Packet.TCPHeader.RST,
                        0,
                        tcb.myAcknowledgementNum,
                        0);

                outputQueue.offer(
                        receiveBuffer);

            } finally {

                TCB.closeTCB(tcb);
            }
        }
    }
}
