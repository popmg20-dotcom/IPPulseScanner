package io.netty.handler.codec.spdy;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import defpackage.dw2;
import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class SpdyHeaderBlockJZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private boolean finished;
    private final Deflater z;

    public SpdyHeaderBlockJZlibEncoder(SpdyVersion spdyVersion, int i, int i2, int i3) {
        super(spdyVersion);
        Deflater deflater = new Deflater();
        this.z = deflater;
        if (i < 0 || i > 9) {
            xe.k(ha0.k("compressionLevel: ", i, " (expected: 0-9)"));
            throw null;
        }
        if (i2 < 9 || i2 > 15) {
            xe.k(ha0.k("windowBits: ", i2, " (expected: 9-15)"));
            throw null;
        }
        if (i3 < 1 || i3 > 9) {
            xe.k(ha0.k("memLevel: ", i3, " (expected: 1-9)"));
            throw null;
        }
        int iDeflateInit = deflater.deflateInit(i, i2, i3, JZlib.W_ZLIB);
        if (iDeflateInit != 0) {
            throw new CompressionException(dw2.A(iDeflateInit, "failed to initialize an SPDY header block deflater: "));
        }
        byte[] bArr = SpdyCodecUtil.SPDY_DICT;
        int iDeflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
        if (iDeflateSetDictionary != 0) {
            throw new CompressionException(dw2.A(iDeflateSetDictionary, "failed to set the SPDY dictionary: "));
        }
    }

    private ByteBuf encode(ByteBufAllocator byteBufAllocator) throws Throwable {
        ByteBuf byteBufHeapBuffer;
        int i;
        int i2;
        int iCeil;
        try {
            i = this.z.next_in_index;
            i2 = this.z.next_out_index;
            iCeil = ((int) Math.ceil(((double) this.z.next_in.length) * 1.001d)) + 12;
            byteBufHeapBuffer = byteBufAllocator.heapBuffer(iCeil);
        } catch (Throwable th) {
            th = th;
            byteBufHeapBuffer = null;
        }
        try {
            this.z.next_out = byteBufHeapBuffer.array();
            this.z.next_out_index = byteBufHeapBuffer.arrayOffset() + byteBufHeapBuffer.writerIndex();
            this.z.avail_out = iCeil;
            try {
                int iDeflate = this.z.deflate(2);
                if (iDeflate != 0) {
                    throw new CompressionException("compression failure: " + iDeflate);
                }
                int i3 = this.z.next_out_index - i2;
                if (i3 > 0) {
                    byteBufHeapBuffer.writerIndex(byteBufHeapBuffer.writerIndex() + i3);
                }
                this.z.next_in = null;
                this.z.next_out = null;
                return byteBufHeapBuffer;
            } finally {
                byteBufHeapBuffer.skipBytes(this.z.next_in_index - i);
            }
        } catch (Throwable th2) {
            th = th2;
            this.z.next_in = null;
            this.z.next_out = null;
            if (byteBufHeapBuffer != null) {
                byteBufHeapBuffer.release();
            }
            throw th;
        }
    }

    private void setInput(ByteBuf byteBuf) {
        byte[] bArrArray;
        int iArrayOffset;
        int i = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArrArray = byteBuf.array();
            iArrayOffset = byteBuf.readerIndex() + byteBuf.arrayOffset();
        } else {
            bArrArray = new byte[i];
            byteBuf.getBytes(byteBuf.readerIndex(), bArrArray);
            iArrayOffset = 0;
        }
        this.z.next_in = bArrArray;
        this.z.next_in_index = iArrayOffset;
        this.z.avail_in = i;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.z.deflateEnd();
        this.z.next_in = null;
        this.z.next_out = null;
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
            if (!byteBufEncode.isReadable()) {
                return Unpooled.EMPTY_BUFFER;
            }
            setInput(byteBufEncode);
            return encode(byteBufAllocator);
        } finally {
            byteBufEncode.release();
        }
    }
}
