package com.github.xfalcon.vhosts.vservice;

import com.github.xfalcon.vhosts.vservice.LRUCache;
import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class TCB {
    private static final int MAX_CACHE_SIZE = 50;
    private static LRUCache<String, TCB> tcbCache = new LRUCache<>(50, new LRUCache.CleanupCallback<String, TCB>() { // from class: com.github.xfalcon.vhosts.vservice.TCB.1
        @Override // com.github.xfalcon.vhosts.vservice.LRUCache.CleanupCallback
        public void cleanup(Map.Entry<String, TCB> eldest) {
            eldest.getValue().closeChannel();
        }
    });
    public SocketChannel channel;
    public String ipAndPort;
    public long myAcknowledgementNum;
    public long mySequenceNum;
    public Packet referencePacket;
    public SelectionKey selectionKey;
    public TCBStatus status;
    public long theirAcknowledgementNum;
    public long theirSequenceNum;
    public boolean waitingForNetworkData;

    public enum TCBStatus {
        SYN_SENT,
        SYN_RECEIVED,
        ESTABLISHED,
        CLOSE_WAIT,
        LAST_ACK
    }

    public static TCB getTCB(String ipAndPort) {
        TCB tcb;
        synchronized (tcbCache) {
            tcb = tcbCache.get(ipAndPort);
        }
        return tcb;
    }

    public static void putTCB(String ipAndPort, TCB tcb) {
        synchronized (tcbCache) {
            tcbCache.put(ipAndPort, tcb);
        }
    }

    public TCB(String ipAndPort, long mySequenceNum, long theirSequenceNum, long myAcknowledgementNum, long theirAcknowledgementNum, SocketChannel channel, Packet referencePacket) {
        this.ipAndPort = ipAndPort;
        this.mySequenceNum = mySequenceNum;
        this.theirSequenceNum = theirSequenceNum;
        this.myAcknowledgementNum = myAcknowledgementNum;
        this.theirAcknowledgementNum = theirAcknowledgementNum;
        this.channel = channel;
        this.referencePacket = referencePacket;
    }

    public static void closeTCB(TCB tcb) {
        tcb.closeChannel();
        synchronized (tcbCache) {
            tcbCache.remove(tcb.ipAndPort);
        }
    }

    public static void closeAll() {
        synchronized (tcbCache) {
            Iterator<Map.Entry<String, TCB>> it = tcbCache.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().closeChannel();
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeChannel() {
        try {
            this.channel.close();
        } catch (IOException e) {
        }
    }
}
