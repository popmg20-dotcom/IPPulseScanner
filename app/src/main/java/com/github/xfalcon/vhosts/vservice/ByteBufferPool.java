package com.github.xfalcon.vhosts.vservice;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes5.dex */
public class ByteBufferPool {
    private static final int BUFFER_SIZE = 16384;
    private static ConcurrentLinkedQueue<ByteBuffer> pool = new ConcurrentLinkedQueue<>();

    public static ByteBuffer acquire() {
        ByteBuffer buffer = pool.poll();
        if (buffer == null) {
            return ByteBuffer.allocateDirect(16384);
        }
        return buffer;
    }

    public static void release(ByteBuffer buffer) {
        buffer.clear();
        pool.offer(buffer);
    }

    public static void clear() {
        pool.clear();
    }
}
