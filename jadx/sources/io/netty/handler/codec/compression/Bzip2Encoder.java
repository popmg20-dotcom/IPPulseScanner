package io.netty.handler.codec.compression;

import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.PromiseNotifier;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Bzip2Encoder extends MessageToByteEncoder<ByteBuf> {
    private Bzip2BlockCompressor blockCompressor;
    private volatile ChannelHandlerContext ctx;
    private State currentState;
    private volatile boolean finished;
    private final int streamBlockSize;
    private int streamCRC;
    private final Bzip2BitWriter writer;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Bzip2Encoder$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.INIT_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.WRITE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.CLOSE_BLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum State {
        INIT,
        INIT_BLOCK,
        WRITE_DATA,
        CLOSE_BLOCK
    }

    public Bzip2Encoder(int i) {
        this.currentState = State.INIT;
        this.writer = new Bzip2BitWriter();
        if (i < 1 || i > 9) {
            xe.k(ha0.k("blockSizeMultiplier: ", i, " (expected: 1-9)"));
            throw null;
        }
        this.streamBlockSize = i * 100000;
    }

    private void closeBlock(ByteBuf byteBuf) {
        Bzip2BlockCompressor bzip2BlockCompressor = this.blockCompressor;
        if (bzip2BlockCompressor.isEmpty()) {
            return;
        }
        bzip2BlockCompressor.close(byteBuf);
        int iCrc = bzip2BlockCompressor.crc();
        int i = this.streamCRC;
        this.streamCRC = iCrc ^ ((i >>> 31) | (i << 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        xe.q("not added to a pipeline");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
        closeBlock(byteBufBuffer);
        int i = this.streamCRC;
        Bzip2BitWriter bzip2BitWriter = this.writer;
        try {
            bzip2BitWriter.writeBits(byteBufBuffer, 24, 1536581L);
            bzip2BitWriter.writeBits(byteBufBuffer, 24, 3690640L);
            bzip2BitWriter.writeInt(byteBufBuffer, i);
            bzip2BitWriter.flush(byteBufBuffer);
            this.blockCompressor = null;
            return channelHandlerContext.writeAndFlush(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            this.blockCompressor = null;
            throw th;
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        ChannelFuture channelFutureFinishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        channelFutureFinishEncode.addListener2((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (channelFutureFinishEncode.isDone()) {
            return;
        }
        channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.3
            @Override // java.lang.Runnable
            public void run() {
                channelHandlerContext.close(channelPromise);
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void encode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, io.netty.buffer.ByteBuf r5) {
        /*
            r2 = this;
            boolean r3 = r2.finished
            if (r3 == 0) goto L8
            r5.writeBytes(r4)
            return
        L8:
            int[] r3 = io.netty.handler.codec.compression.Bzip2Encoder.AnonymousClass4.$SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State
            io.netty.handler.codec.compression.Bzip2Encoder$State r0 = r2.currentState
            int r0 = r0.ordinal()
            r3 = r3[r0]
            r0 = 1
            r1 = 4
            if (r3 == r0) goto L23
            r0 = 2
            if (r3 == r0) goto L3b
            r0 = 3
            if (r3 == r0) goto L4a
            if (r3 != r1) goto L1f
            goto L7c
        L1f:
            defpackage.st4.g()
            return
        L23:
            r5.ensureWritable(r1)
            r3 = 4348520(0x425a68, float:6.093574E-39)
            r5.writeMedium(r3)
            int r3 = r2.streamBlockSize
            r0 = 100000(0x186a0, float:1.4013E-40)
            int r3 = r3 / r0
            int r3 = r3 + 48
            r5.writeByte(r3)
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.INIT_BLOCK
            r2.currentState = r3
        L3b:
            io.netty.handler.codec.compression.Bzip2BlockCompressor r3 = new io.netty.handler.codec.compression.Bzip2BlockCompressor
            io.netty.handler.codec.compression.Bzip2BitWriter r0 = r2.writer
            int r1 = r2.streamBlockSize
            r3.<init>(r0, r1)
            r2.blockCompressor = r3
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.WRITE_DATA
            r2.currentState = r3
        L4a:
            boolean r3 = r4.isReadable()
            if (r3 != 0) goto L51
            goto L77
        L51:
            io.netty.handler.codec.compression.Bzip2BlockCompressor r3 = r2.blockCompressor
            int r0 = r4.readableBytes()
            int r1 = r3.availableSize()
            int r0 = java.lang.Math.min(r0, r1)
            int r1 = r4.readerIndex()
            int r0 = r3.write(r4, r1, r0)
            r4.skipBytes(r0)
            boolean r3 = r3.isFull()
            if (r3 != 0) goto L78
            boolean r3 = r4.isReadable()
            if (r3 == 0) goto L77
            goto L8
        L77:
            return
        L78:
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.CLOSE_BLOCK
            r2.currentState = r3
        L7c:
            r2.closeBlock(r5)
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.INIT_BLOCK
            r2.currentState = r3
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2Encoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    public boolean isClosed() {
        return this.finished;
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext channelHandlerContextCtx = ctx();
        EventExecutor eventExecutorExecutor = channelHandlerContextCtx.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            return finishEncode(channelHandlerContextCtx, channelPromise);
        }
        eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.1
            @Override // java.lang.Runnable
            public void run() {
                Bzip2Encoder bzip2Encoder = Bzip2Encoder.this;
                PromiseNotifier.cascade(bzip2Encoder.finishEncode(bzip2Encoder.ctx(), channelPromise), channelPromise);
            }
        });
        return channelPromise;
    }

    public Bzip2Encoder() {
        this(9);
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }
}
