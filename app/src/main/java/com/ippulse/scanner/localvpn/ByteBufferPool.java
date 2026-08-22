package com.ippulse.scanner.localvpn;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ByteBufferPool
{
    private static final int BUFFER_SIZE = 16384;

    private static final ConcurrentLinkedQueue<ByteBuffer> pool =
            new ConcurrentLinkedQueue<>();

    public static ByteBuffer acquire()
    {
        ByteBuffer buffer;

        while ((buffer = pool.poll()) != null)
        {
            /*
             * Only our own 16KB direct buffers may enter the pool.
             */
            if (buffer.capacity() == BUFFER_SIZE
                    && buffer.isDirect())
            {
                buffer.clear();
                return buffer;
            }
        }

        return ByteBuffer.allocateDirect(BUFFER_SIZE);
    }

    public static void release(ByteBuffer buffer)
    {
        if (buffer == null)
            return;

        /*
         * TUN packet buffers are ordinary heap buffers with the exact
         * packet length. They MUST NOT be inserted into this pool.
         */
        if (buffer.capacity() != BUFFER_SIZE
                || !buffer.isDirect())
        {
            return;
        }

        buffer.clear();
        pool.offer(buffer);
    }

    public static void clear()
    {
        pool.clear();
    }
}
