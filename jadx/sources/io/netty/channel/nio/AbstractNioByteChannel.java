package io.netty.channel.nio;

import defpackage.vp1;
import defpackage.zo2;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.internal.ChannelUtils;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private final Runnable flushTask;
    private boolean inputClosedSeenErrorOnRead;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        public NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            boolean zIsInputShutdown0 = AbstractNioByteChannel.this.isInputShutdown0();
            AbstractNioByteChannel abstractNioByteChannel = AbstractNioByteChannel.this;
            if (zIsInputShutdown0) {
                if (abstractNioByteChannel.inputClosedSeenErrorOnRead) {
                    return;
                }
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
                return;
            }
            if (!AbstractNioByteChannel.isAllowHalfClosure(abstractNioByteChannel.config())) {
                close(voidPromise());
            } else {
                AbstractNioByteChannel.this.shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof OutOfMemoryError) || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        
            r5.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            if (r8.lastBytesRead() >= 0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
        
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        
            if (r7 == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
        
            r9.this$0.readPending = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
        
            r6 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
        
            r5 = null;
            r3 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
        
            r2 = r7;
         */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void read() {
            /*
                r9 = this;
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelConfig r1 = r0.config()
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.shouldBreakReadReady(r1)
                io.netty.channel.nio.AbstractNioByteChannel r2 = io.netty.channel.nio.AbstractNioByteChannel.this
                if (r0 == 0) goto L14
                r2.clearReadPending()
                return
            L14:
                io.netty.channel.ChannelPipeline r4 = r2.pipeline()
                io.netty.buffer.ByteBufAllocator r0 = r1.getAllocator()
                io.netty.channel.RecvByteBufAllocator$Handle r8 = r9.recvBufAllocHandle()
                r8.reset(r1)
            L23:
                r2 = 0
                r3 = 0
                io.netty.buffer.ByteBuf r5 = r8.allocate(r0)     // Catch: java.lang.Throwable -> L52
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L56
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> L56
                r8.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L56
                int r6 = r8.lastBytesRead()     // Catch: java.lang.Throwable -> L56
                r7 = 1
                if (r6 > 0) goto L5b
                r5.release()     // Catch: java.lang.Throwable -> L56
                int r0 = r8.lastBytesRead()     // Catch: java.lang.Throwable -> L52
                if (r0 >= 0) goto L43
                goto L44
            L43:
                r7 = r2
            L44:
                if (r7 == 0) goto L50
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L4b
                r0.readPending = r2     // Catch: java.lang.Throwable -> L4b
                goto L50
            L4b:
                r0 = move-exception
                r6 = r0
            L4d:
                r5 = r3
                r3 = r9
                goto L86
            L50:
                r2 = r7
                goto L6b
            L52:
                r0 = move-exception
                r6 = r0
                r7 = r2
                goto L4d
            L56:
                r0 = move-exception
                r3 = r9
                r6 = r0
                r7 = r2
                goto L86
            L5b:
                r8.incMessagesRead(r7)     // Catch: java.lang.Throwable -> L56
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L56
                r6.readPending = r2     // Catch: java.lang.Throwable -> L56
                r4.fireChannelRead(r5)     // Catch: java.lang.Throwable -> L56
                boolean r5 = r8.continueReading()     // Catch: java.lang.Throwable -> L52
                if (r5 != 0) goto L23
            L6b:
                r8.readComplete()     // Catch: java.lang.Throwable -> L52
                r4.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L52
                if (r2 == 0) goto L76
                r9.closeOnRead(r4)     // Catch: java.lang.Throwable -> L52
            L76:
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.readPending
                if (r0 != 0) goto L98
                boolean r0 = r1.isAutoRead()
                if (r0 != 0) goto L98
                r9.removeReadOp()
                return
            L86:
                r3.handleReadException(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L99
                io.netty.channel.nio.AbstractNioByteChannel r9 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r9 = r9.readPending
                if (r9 != 0) goto L98
                boolean r9 = r1.isAutoRead()
                if (r9 != 0) goto L98
                r3.removeReadOp()
            L98:
                return
            L99:
                r0 = move-exception
                r9 = r0
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.readPending
                if (r0 != 0) goto Laa
                boolean r0 = r1.isAutoRead()
                if (r0 != 0) goto Laa
                r3.removeReadOp()
            Laa:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe.read():void");
        }
    }

    public AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
        this.flushTask = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
            }
        };
    }

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int iDoWriteBytes = doWriteBytes(byteBuf);
            if (iDoWriteBytes <= 0) {
                return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            }
            channelOutboundBuffer.progress(iDoWriteBytes);
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        }
        if (!(obj instanceof FileRegion)) {
            zo2.g();
            return 0;
        }
        FileRegion fileRegion = (FileRegion) obj;
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long jDoWriteFileRegion = doWriteFileRegion(fileRegion);
        if (jDoWriteFileRegion <= 0) {
            return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
        channelOutboundBuffer.progress(jDoWriteFileRegion);
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    public final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) != 0) {
                selectionKey.interestOps(iInterestOps & (-5));
            }
        }
    }

    public abstract int doReadBytes(ByteBuf byteBuf);

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(channelOutboundBuffer, objCurrent);
        } while (writeSpinCount > 0);
        incompleteWrite(writeSpinCount < 0);
    }

    public final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    public abstract int doWriteBytes(ByteBuf byteBuf);

    public abstract long doWriteFileRegion(FileRegion fileRegion);

    @Override // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        vp1.j("unsupported message type: ", StringUtil.simpleClassName(obj), EXPECTED_TYPES);
        return null;
    }

    public final void incompleteWrite(boolean z) {
        if (z) {
            setOpWrite();
        } else {
            clearOpWrite();
            eventLoop().execute(this.flushTask);
        }
    }

    public boolean isInputShutdown0() {
        return false;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }

    public final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) == 0) {
                selectionKey.interestOps(iInterestOps | 4);
            }
        }
    }

    public final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        if (isInputShutdown0()) {
            return this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig);
        }
        return false;
    }

    public abstract ChannelFuture shutdownInput();
}
