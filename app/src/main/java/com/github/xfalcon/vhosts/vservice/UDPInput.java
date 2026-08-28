package com.github.xfalcon.vhosts.vservice;

import com.github.xfalcon.vhosts.util.LogUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public class UDPInput implements Runnable {
    private static final String TAG = UDPInput.class.getSimpleName();
    private ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private Selector selector;
    private ReentrantLock udpSelectorLock;

    public UDPInput(ConcurrentLinkedQueue<ByteBuffer> outputQueue, Selector selector, ReentrantLock udpSelectorLock) {
        this.outputQueue = outputQueue;
        this.selector = selector;
        this.udpSelectorLock = udpSelectorLock;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        try {
            LogUtils.i(TAG, "Started");
            while (!Thread.interrupted()) {
                this.udpSelectorLock.lock();
                this.udpSelectorLock.unlock();
                int readyChannels = this.selector.select();
                if (readyChannels == 0) {
                    Thread.sleep(11L);
                } else {
                    Set<SelectionKey> keys = this.selector.selectedKeys();
                    Iterator<SelectionKey> keyIterator = keys.iterator();
                    while (keyIterator.hasNext() && !Thread.interrupted()) {
                        SelectionKey key = keyIterator.next();
                        if (key.isValid() && key.isReadable()) {
                            keyIterator.remove();
                            ByteBuffer receiveBuffer = ByteBufferPool.acquire();
                            DatagramChannel inputChannel = (DatagramChannel) key.channel();
                            Packet referencePacket = (Packet) key.attachment();
                            receiveBuffer.position(referencePacket.IP_TRAN_SIZE);
                            int readBytes = 0;
                            try {
                                readBytes = inputChannel.read(receiveBuffer);
                            } catch (Exception e) {
                                LogUtils.e(TAG, "Network read error", e);
                            }
                            referencePacket.updateUDPBuffer(receiveBuffer, readBytes);
                            receiveBuffer.position(referencePacket.IP_TRAN_SIZE + readBytes);
                            this.outputQueue.offer(receiveBuffer);
                        }
                    }
                }
            }
        } catch (IOException e2) {
            LogUtils.w(TAG, e2.toString(), e2);
        } catch (InterruptedException e3) {
            LogUtils.i(TAG, "Stopping");
        }
    }
}
