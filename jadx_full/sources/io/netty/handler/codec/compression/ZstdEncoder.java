package io.netty.handler.codec.compression;

import defpackage.fw;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ZstdEncoder extends MessageToByteEncoder<ByteBuf> {
    private final int blockSize;
    private ByteBuf buffer;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdEncoder(int i, int i2, int i3) {
        super(true);
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(i2, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(i3, "maxEncodeSize");
    }

    private void flushBufferedData(ByteBuf byteBuf) {
        int i = this.buffer.readableBytes();
        if (i == 0) {
            return;
        }
        byteBuf.ensureWritable((int) com.github.luben.zstd.Zstd.compressBound(i));
        int iWriterIndex = byteBuf.writerIndex();
        try {
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(iWriterIndex, byteBuf.writableBytes());
            ByteBuf byteBuf2 = this.buffer;
            byteBuf.writerIndex(iWriterIndex + com.github.luben.zstd.Zstd.compress(byteBufferInternalNioBuffer, byteBuf2.internalNioBuffer(byteBuf2.readerIndex(), i), this.compressionLevel));
            this.buffer.clear();
        } catch (Exception e) {
            throw new CompressionException(e);
        }
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) {
        if (this.buffer == null) {
            xe.q("not added to a pipeline,or has been removed,buffer is null");
            return null;
        }
        int i = this.buffer.readableBytes() + byteBuf.readableBytes();
        if (i < 0) {
            throw new EncoderException("too much data to allocate a buffer for compression");
        }
        long jCompressBound = 0;
        while (i > 0) {
            int iMin = Math.min(this.blockSize, i);
            i -= iMin;
            jCompressBound += com.github.luben.zstd.Zstd.compressBound(iMin);
        }
        if (jCompressBound > this.maxEncodeSize || 0 > jCompressBound) {
            throw new EncoderException(fw.w(" bytes)", fw.C("requested encode buffer size (", " bytes) exceeds the maximum allowable size (", jCompressBound), this.maxEncodeSize));
        }
        return channelHandlerContext.alloc().directBuffer((int) jCompressBound);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf byteBuf3 = this.buffer;
        if (byteBuf3 == null) {
            xe.q("not added to a pipeline,or has been removed,buffer is null");
            return;
        }
        while (true) {
            int i = byteBuf.readableBytes();
            if (i <= 0) {
                return;
            }
            byteBuf.readBytes(byteBuf3, Math.min(i, byteBuf3.writableBytes()));
            if (!byteBuf3.isWritable()) {
                flushBufferedData(byteBuf2);
            }
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null && byteBuf.isReadable()) {
            ByteBuf byteBufAllocateBuffer = allocateBuffer(channelHandlerContext, Unpooled.EMPTY_BUFFER, isPreferDirect());
            flushBufferedData(byteBufAllocateBuffer);
            channelHandlerContext.write(byteBufAllocateBuffer);
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufDirectBuffer = channelHandlerContext.alloc().directBuffer(this.blockSize);
        this.buffer = byteBufDirectBuffer;
        byteBufDirectBuffer.clear();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        super.handlerRemoved(channelHandlerContext);
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null) {
            byteBuf.release();
            this.buffer = null;
        }
    }

    public ZstdEncoder(int i) {
        this(i, 65536, 33554432);
    }

    public ZstdEncoder(int i, int i2) {
        this(3, i, i2);
    }

    public ZstdEncoder() {
        this(3, 65536, 33554432);
    }
}
