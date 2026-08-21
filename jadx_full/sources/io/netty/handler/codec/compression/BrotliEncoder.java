package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.BrotliEncoderChannel;
import com.aayushatharva.brotli4j.encoder.Encoder;
import defpackage.zo2;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@ChannelHandler.Sharable
public final class BrotliEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final AttributeKey<Writer> ATTR = AttributeKey.valueOf("BrotliEncoderWriter");
    private static final Method FLUSH_METHOD;
    private final boolean isSharable;
    private final Encoder.Parameters parameters;
    private Writer writer;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Writer implements WritableByteChannel {
        private final BrotliEncoderChannel brotliEncoderChannel;
        private final ChannelHandlerContext ctx;
        private boolean isClosed;
        private ByteBuf writableBuffer;

        private Writer(Encoder.Parameters parameters, ChannelHandlerContext channelHandlerContext) {
            this.brotliEncoderChannel = new BrotliEncoderChannel(this, parameters);
            this.ctx = channelHandlerContext;
        }

        private void allocate(boolean z) {
            ChannelHandlerContext channelHandlerContext = this.ctx;
            if (z) {
                this.writableBuffer = channelHandlerContext.alloc().ioBuffer();
            } else {
                this.writableBuffer = channelHandlerContext.alloc().buffer();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void encode(ByteBuf byteBuf, boolean z) throws Exception {
            try {
                allocate(z);
                this.brotliEncoderChannel.write(byteBuf.nioBuffer());
                BrotliEncoder.FLUSH_METHOD.invoke(this.brotliEncoderChannel, null);
            } catch (Exception e) {
                ReferenceCountUtil.release(byteBuf);
                throw e;
            }
        }

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            final ChannelPromise channelPromiseNewPromise = this.ctx.newPromise();
            this.ctx.executor().execute(new Runnable() { // from class: io.netty.handler.codec.compression.BrotliEncoder.Writer.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Writer.this.finish(channelPromiseNewPromise);
                    } catch (IOException e) {
                        channelPromiseNewPromise.setFailure((Throwable) new IllegalStateException("Failed to finish encoding", e));
                    }
                }
            });
        }

        public void finish(ChannelPromise channelPromise) {
            if (this.isClosed) {
                return;
            }
            allocate(true);
            try {
                this.brotliEncoderChannel.close();
                this.isClosed = true;
                this.ctx.writeAndFlush(this.writableBuffer, channelPromise);
            } catch (Exception e) {
                channelPromise.setFailure((Throwable) e);
                ReferenceCountUtil.release(this.writableBuffer);
            }
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return !this.isClosed;
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer byteBuffer) throws ClosedChannelException {
            if (isOpen()) {
                return this.writableBuffer.writeBytes(byteBuffer).readableBytes();
            }
            throw new ClosedChannelException();
        }
    }

    static {
        try {
            Method declaredMethod = Encoder.class.getDeclaredMethod("flush", null);
            declaredMethod.setAccessible(true);
            FLUSH_METHOD = declaredMethod;
        } catch (NoSuchMethodException e) {
            zo2.q(e);
        }
    }

    public BrotliEncoder(Encoder.Parameters parameters, boolean z) {
        this.parameters = (Encoder.Parameters) ObjectUtil.checkNotNull(parameters, "Parameters");
        this.isSharable = z;
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) throws Exception {
        if (!byteBuf.isReadable()) {
            return Unpooled.EMPTY_BUFFER;
        }
        Writer writer = this.isSharable ? (Writer) channelHandlerContext.channel().attr(ATTR).get() : this.writer;
        if (writer == null) {
            return Unpooled.EMPTY_BUFFER;
        }
        writer.encode(byteBuf, z);
        return writer.writableBuffer;
    }

    public void finish(ChannelHandlerContext channelHandlerContext) {
        Writer writer = this.isSharable ? (Writer) channelHandlerContext.channel().attr(ATTR).getAndSet(null) : this.writer;
        if (writer != null) {
            writer.close();
            this.writer = null;
        }
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        Writer writer = new Writer(this.parameters, channelHandlerContext);
        if (this.isSharable) {
            channelHandlerContext.channel().attr(ATTR).set(writer);
        } else {
            this.writer = writer;
        }
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        finish(channelHandlerContext);
        super.handlerRemoved(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter
    public boolean isSharable() {
        return this.isSharable;
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
    }

    public BrotliEncoder(BrotliOptions brotliOptions) {
        this(brotliOptions.parameters());
    }

    public BrotliEncoder(Encoder.Parameters parameters) {
        this(parameters, true);
    }

    public BrotliEncoder() {
        this(BrotliOptions.DEFAULT);
    }
}
