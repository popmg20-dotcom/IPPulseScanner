package io.netty.channel.nio;

import defpackage.vp1;
import defpackage.zo2;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
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
        */
        public final void read() {
            boolean z;
            Throwable th;
            boolean z2;
            ByteBuf byteBufAllocate;
            ChannelConfig channelConfigConfig = AbstractNioByteChannel.this.config();
            boolean zShouldBreakReadReady = AbstractNioByteChannel.this.shouldBreakReadReady(channelConfigConfig);
            AbstractNioByteChannel abstractNioByteChannel = AbstractNioByteChannel.this;
            if (zShouldBreakReadReady) {
                abstractNioByteChannel.clearReadPending();
                return;
            }
            ChannelPipeline channelPipelinePipeline = abstractNioByteChannel.pipeline();
            ByteBufAllocator allocator = channelConfigConfig.getAllocator();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            while (true) {
                z = false;
                try {
                    byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
                } catch (Throwable th2) {
                    th = th2;
                    z2 = z;
                }
                try {
                    handleRecvBufAllocHandle.lastBytesRead(AbstractNioByteChannel.this.doReadBytes(byteBufAllocate));
                    z2 = true;
                    if (handleRecvBufAllocHandle.lastBytesRead() <= 0) {
                        break;
                    }
                    handleRecvBufAllocHandle.incMessagesRead(1);
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                    if (!handleRecvBufAllocHandle.continueReading()) {
                        break;
                    }
                } catch (Throwable th3) {
                    NioByteUnsafe nioByteUnsafe = this;
                    th = th3;
                    z2 = false;
                    try {
                        nioByteUnsafe.handleReadException(channelPipelinePipeline, byteBufAllocate, th, z2, handleRecvBufAllocHandle);
                        if (!AbstractNioByteChannel.this.readPending || channelConfigConfig.isAutoRead()) {
                            return;
                        }
                        nioByteUnsafe.removeReadOp();
                        return;
                    } finally {
                    }
                }
            }
            handleRecvBufAllocHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (z) {
                closeOnRead(channelPipelinePipeline);
            }
            if (AbstractNioByteChannel.this.readPending || channelConfigConfig.isAutoRead()) {
                return;
            }
            removeReadOp();
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
