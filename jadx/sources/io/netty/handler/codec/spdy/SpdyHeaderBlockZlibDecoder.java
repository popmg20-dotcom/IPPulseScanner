package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class SpdyHeaderBlockZlibDecoder extends SpdyHeaderBlockRawDecoder {
    private static final int DEFAULT_BUFFER_CAPACITY = 4096;
    private static final SpdyProtocolException INVALID_HEADER_BLOCK = new SpdyProtocolException("Invalid Header Block");
    private ByteBuf decompressed;
    private final Inflater decompressor;

    public SpdyHeaderBlockZlibDecoder(SpdyVersion spdyVersion, int i) {
        super(spdyVersion, i);
        this.decompressor = new Inflater();
    }

    private int decompress(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws SpdyProtocolException {
        ensureBuffer(byteBufAllocator);
        byte[] bArrArray = this.decompressed.array();
        int iWriterIndex = this.decompressed.writerIndex() + this.decompressed.arrayOffset();
        try {
            int iInflate = this.decompressor.inflate(bArrArray, iWriterIndex, this.decompressed.writableBytes());
            if (iInflate == 0 && this.decompressor.needsDictionary()) {
                try {
                    this.decompressor.setDictionary(SpdyCodecUtil.SPDY_DICT);
                    iInflate = this.decompressor.inflate(bArrArray, iWriterIndex, this.decompressed.writableBytes());
                } catch (IllegalArgumentException unused) {
                    throw INVALID_HEADER_BLOCK;
                }
            }
            if (spdyHeadersFrame != null) {
                ByteBuf byteBuf = this.decompressed;
                byteBuf.writerIndex(byteBuf.writerIndex() + iInflate);
                decodeHeaderBlock(this.decompressed, spdyHeadersFrame);
                this.decompressed.discardReadBytes();
            }
            return iInflate;
        } catch (DataFormatException e) {
            throw new SpdyProtocolException("Received invalid header block", e);
        }
    }

    private void ensureBuffer(ByteBufAllocator byteBufAllocator) {
        ByteBuf byteBufHeapBuffer = this.decompressed;
        if (byteBufHeapBuffer == null) {
            byteBufHeapBuffer = byteBufAllocator.heapBuffer(4096);
            this.decompressed = byteBufHeapBuffer;
        }
        byteBufHeapBuffer.ensureWritable(1);
    }

    private void releaseBuffer() {
        ByteBuf byteBuf = this.decompressed;
        if (byteBuf != null) {
            byteBuf.release();
            this.decompressed = null;
        }
    }

    private int setInput(ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        if (!byteBuf.hasArray()) {
            byte[] bArr = new byte[i];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            this.decompressor.setInput(bArr, 0, i);
            return i;
        }
        this.decompressor.setInput(byteBuf.array(), byteBuf.readerIndex() + byteBuf.arrayOffset(), i);
        return i;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder, io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws SpdyProtocolException {
        int input = setInput(byteBuf);
        while (decompress(byteBufAllocator, spdyHeadersFrame) > 0) {
        }
        if (this.decompressor.getRemaining() != 0) {
            throw INVALID_HEADER_BLOCK;
        }
        byteBuf.skipBytes(input);
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder, io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void end() {
        super.end();
        releaseBuffer();
        this.decompressor.end();
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawDecoder, io.netty.handler.codec.spdy.SpdyHeaderBlockDecoder
    public void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) {
        super.endHeaderBlock(spdyHeadersFrame);
        releaseBuffer();
    }
}
