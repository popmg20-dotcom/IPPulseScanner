package com.github.xfalcon.vhosts.vservice;

import com.github.xfalcon.vhosts.vservice.LRUCache;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public class UDPOutput implements Runnable {
    private static final int MAX_CACHE_SIZE = 50;
    private static final String TAG = UDPOutput.class.getSimpleName();
    private ConcurrentLinkedQueue<Packet> inputQueue;
    private ConcurrentLinkedQueue<ByteBuffer> outputQueue;
    private Selector selector;
    private ReentrantLock udpSelectorLock;
    private VhostsService vpnService;
    private LRUCache<String, DatagramChannel> channelCache = new LRUCache<>(50, new LRUCache.CleanupCallback<String, DatagramChannel>() { // from class: com.github.xfalcon.vhosts.vservice.UDPOutput.1
        @Override // com.github.xfalcon.vhosts.vservice.LRUCache.CleanupCallback
        public void cleanup(Map.Entry<String, DatagramChannel> eldest) {
            UDPOutput.this.closeChannel(eldest.getValue());
        }
    });
    private StringBuilder stringBuild = new StringBuilder(32);

    public UDPOutput(ConcurrentLinkedQueue<Packet> inputQueue, ConcurrentLinkedQueue<ByteBuffer> outputQueue, Selector selector, ReentrantLock udpSelectorLock, VhostsService vpnService) {
        this.inputQueue = inputQueue;
        this.selector = selector;
        this.vpnService = vpnService;
        this.outputQueue = outputQueue;
        this.udpSelectorLock = udpSelectorLock;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c1 A[Catch: IOException -> 0x00c6, all -> 0x00f2, InterruptedException -> 0x00ff, LOOP:1: B:23:0x00bb->B:25:0x00c1, LOOP_END, TRY_LEAVE, TryCatch #3 {InterruptedException -> 0x00ff, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0017, B:8:0x001d, B:10:0x0025, B:12:0x002b, B:13:0x0031, B:15:0x005d, B:16:0x006b, B:18:0x0075, B:20:0x0097, B:22:0x00b9, B:23:0x00bb, B:25:0x00c1, B:30:0x00e7, B:29:0x00c7), top: B:43:0x0007, outer: #0 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.xfalcon.vhosts.vservice.UDPOutput.run():void");
    }

    private void closeAll() {
        Iterator<Map.Entry<String, DatagramChannel>> it = this.channelCache.entrySet().iterator();
        while (it.hasNext()) {
            closeChannel(it.next().getValue());
            it.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeChannel(DatagramChannel channel) {
        try {
            channel.close();
        } catch (IOException e) {
        }
    }
}
