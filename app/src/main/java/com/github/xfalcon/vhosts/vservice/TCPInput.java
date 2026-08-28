package com.github.xfalcon.vhosts.vservice;

import com.github.xfalcon.vhosts.util.LogUtils;
import com.github.xfalcon.vhosts.vservice.TCB;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public class TCPInput implements Runnable {
    private static final String TAG = TCPInput.class.getSimpleName();
    private ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private Selector selector;
    private ReentrantLock tcpSelectorLock;

    public TCPInput(ConcurrentLinkedQueue<ByteBuffer> outputQueue, Selector selector, ReentrantLock tcpSelectorLock) {
        this.outputQueue = outputQueue;
        this.selector = selector;
        this.tcpSelectorLock = tcpSelectorLock;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            LogUtils.i(TAG, "Started");
            while (!Thread.interrupted()) {
                this.tcpSelectorLock.lock();
                this.tcpSelectorLock.unlock();
                int readyChannels = this.selector.select();
                if (readyChannels == 0) {
                    Thread.sleep(11L);
                } else {
                    Set<SelectionKey> keys = this.selector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = keys.iterator();
                    while (keyIterator.hasNext() && !Thread.interrupted()) {
                        SelectionKey key = keyIterator.next();
                        if (key.isValid()) {
                            if (key.isConnectable()) {
                                processConnect(key, keyIterator);
                            } else if (key.isReadable()) {
                                processInput(key, keyIterator);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            LogUtils.w(TAG, e.toString(), e);
        } catch (InterruptedException e2) {
            LogUtils.i(TAG, "Stopping");
        }
    }

    private void processConnect(SelectionKey key, Iterator<SelectionKey> keyIterator) {
        TCB tcb = (TCB) key.attachment();
        Packet referencePacket = tcb.referencePacket;
        try {
            if (tcb.channel.finishConnect()) {
                keyIterator.remove();
                tcb.status = TCB.TCBStatus.SYN_RECEIVED;
                ByteBuffer responseBuffer = ByteBufferPool.acquire();
                referencePacket.updateTCPBuffer(responseBuffer, (byte) 18, tcb.mySequenceNum, tcb.myAcknowledgementNum, 0);
                this.outputQueue.offer(responseBuffer);
                tcb.mySequenceNum++;
                key.interestOps(1);
            }
        } catch (IOException e) {
            LogUtils.e(TAG, "Connection error: " + tcb.ipAndPort, e);
            ByteBuffer responseBuffer2 = ByteBufferPool.acquire();
            referencePacket.updateTCPBuffer(responseBuffer2, (byte) 4, 0L, tcb.myAcknowledgementNum, 0);
            this.outputQueue.offer(responseBuffer2);
            TCB.closeTCB(tcb);
        }
    }

    private void processInput(SelectionKey key, Iterator<SelectionKey> keyIterator) {
        keyIterator.remove();
        ByteBuffer receiveBuffer = ByteBufferPool.acquire();
        TCB tcb = (TCB) key.attachment();
        synchronized (tcb) {
            Packet referencePacket = tcb.referencePacket;
            receiveBuffer.position(referencePacket.IP_TRAN_SIZE);
            SocketChannel inputChannel = (SocketChannel) key.channel();
            try {
                int readBytes = inputChannel.read(receiveBuffer);
                if (readBytes == -1) {
                    key.interestOps(0);
                    tcb.waitingForNetworkData = false;
                    if (tcb.status != TCB.TCBStatus.CLOSE_WAIT) {
                        ByteBufferPool.release(receiveBuffer);
                        return;
                    } else {
                        tcb.status = TCB.TCBStatus.LAST_ACK;
                        referencePacket.updateTCPBuffer(receiveBuffer, (byte) 1, tcb.mySequenceNum, tcb.myAcknowledgementNum, 0);
                        tcb.mySequenceNum++;
                    }
                } else {
                    referencePacket.updateTCPBuffer(receiveBuffer, (byte) 24, tcb.mySequenceNum, tcb.myAcknowledgementNum, readBytes);
                    tcb.mySequenceNum += (long) readBytes;
                    receiveBuffer.position(referencePacket.IP_TRAN_SIZE + readBytes);
                }
                this.outputQueue.offer(receiveBuffer);
            } catch (IOException e) {
                LogUtils.e(TAG, "Network read error: " + tcb.ipAndPort, e);
                referencePacket.updateTCPBuffer(receiveBuffer, (byte) 4, 0L, tcb.myAcknowledgementNum, 0);
                this.outputQueue.offer(receiveBuffer);
                TCB.closeTCB(tcb);
            }
        }
    }
}
