package io.netty.handler.codec.spdy;

import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class SpdyHeaderBlockZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private final Deflater compressor;
    private boolean finished;

    public SpdyHeaderBlockZlibEncoder(SpdyVersion spdyVersion, int i) {
        super(spdyVersion);
        if (i < 0 || i > 9) {
            xe.k(ha0.k("compressionLevel: ", i, " (expected: 0-9)"));
            throw null;
        }
        Deflater deflater = new Deflater(i);
        this.compressor = deflater;
        deflater.setDictionary(SpdyCodecUtil.SPDY_DICT);
    }

    private boolean compressInto(ByteBuf byteBuf) {
        byte[] bArrArray = byteBuf.array();
        int iWriterIndex = byteBuf.writerIndex() + byteBuf.arrayOffset();
        int iWritableBytes = byteBuf.writableBytes();
        int iJavaVersion = PlatformDependent.javaVersion();
        Deflater deflater = this.compressor;
        int iDeflate = iJavaVersion >= 7 ? deflater.deflate(bArrArray, iWriterIndex, iWritableBytes, 2) : deflater.deflate(bArrArray, iWriterIndex, iWritableBytes);
        byteBuf.writerIndex(byteBuf.writerIndex() + iDeflate);
        return iDeflate == iWritableBytes;
    }

    private int setInput(ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        if (!byteBuf.hasArray()) {
            byte[] bArr = new byte[i];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            this.compressor.setInput(bArr, 0, i);
            return i;
        }
        this.compressor.setInput(byteBuf.array(), byteBuf.readerIndex() + byteBuf.arrayOffset(), i);
        return i;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) {
        ObjectUtil.checkNotNullWithIAE(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNullWithIAE(spdyHeadersFrame, "frame");
        if (this.finished) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf byteBufEncode = super.encode(byteBufAllocator, spdyHeadersFrame);
        try {
            return !byteBufEncode.isReadable() ? Unpooled.EMPTY_BUFFER : encode(byteBufAllocator, setInput(byteBufEncode));
        } finally {
            byteBufEncode.release();
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.compressor.end();
        super.end();
    }

    private ByteBuf encode(ByteBufAllocator byteBufAllocator, int i) {
        ByteBuf byteBufHeapBuffer = byteBufAllocator.heapBuffer(i);
        while (compressInto(byteBufHeapBuffer)) {
            try {
                byteBufHeapBuffer.ensureWritable(byteBufHeapBuffer.capacity() << 1);
            } catch (Throwable th) {
                byteBufHeapBuffer.release();
                throw th;
            }
        }
        return byteBufHeapBuffer;
    }
}
