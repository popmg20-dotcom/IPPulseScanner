package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;
    private final Inflater z;

    public JZlibDecoder(byte[] bArr, int i) {
        super(i);
        Inflater inflater = new Inflater();
        this.z = inflater;
        this.dictionary = (byte[]) ObjectUtil.checkNotNull(bArr, "dictionary");
        int iInflateInit = inflater.inflateInit(JZlib.W_ZLIB);
        if (iInflateInit != 0) {
            ZlibUtil.fail(inflater, "initialization failure", iInflateInit);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c0, code lost:
    
        r8.finished = true;
        r8.z.inflateEnd();
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (this.finished) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        int i = byteBuf.readableBytes();
        if (i == 0) {
            return;
        }
        try {
            this.z.avail_in = i;
            if (byteBuf.hasArray()) {
                this.z.next_in = byteBuf.array();
                this.z.next_in_index = byteBuf.arrayOffset() + byteBuf.readerIndex();
            } else {
                byte[] bArr = new byte[i];
                byteBuf.getBytes(byteBuf.readerIndex(), bArr);
                this.z.next_in = bArr;
                this.z.next_in_index = 0;
            }
            int i2 = this.z.next_in_index;
            ByteBuf byteBufPrepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, null, i << 1);
            while (true) {
                try {
                    byteBufPrepareDecompressBuffer = prepareDecompressBuffer(channelHandlerContext, byteBufPrepareDecompressBuffer, this.z.avail_in << 1);
                    this.z.avail_out = byteBufPrepareDecompressBuffer.writableBytes();
                    this.z.next_out = byteBufPrepareDecompressBuffer.array();
                    this.z.next_out_index = byteBufPrepareDecompressBuffer.arrayOffset() + byteBufPrepareDecompressBuffer.writerIndex();
                    int i3 = this.z.next_out_index;
                    int iInflate = this.z.inflate(2);
                    int i4 = this.z.next_out_index - i3;
                    if (i4 > 0) {
                        byteBufPrepareDecompressBuffer.writerIndex(byteBufPrepareDecompressBuffer.writerIndex() + i4);
                    }
                    if (iInflate != -5) {
                        if (iInflate != 0) {
                            if (iInflate == 1) {
                                break;
                            }
                            if (iInflate != 2) {
                                ZlibUtil.fail(this.z, "decompression failure", iInflate);
                            } else {
                                byte[] bArr2 = this.dictionary;
                                Inflater inflater = this.z;
                                if (bArr2 == null) {
                                    ZlibUtil.fail(inflater, "decompression failure", iInflate);
                                } else {
                                    int iInflateSetDictionary = inflater.inflateSetDictionary(bArr2, bArr2.length);
                                    if (iInflateSetDictionary != 0) {
                                        ZlibUtil.fail(this.z, "failed to set the dictionary", iInflateSetDictionary);
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    } else if (this.z.avail_in <= 0) {
                        break;
                    }
                } finally {
                    byteBuf.skipBytes(this.z.next_in_index - i2);
                    if (byteBufPrepareDecompressBuffer.isReadable()) {
                        list.add(byteBufPrepareDecompressBuffer);
                    } else {
                        byteBufPrepareDecompressBuffer.release();
                    }
                }
            }
            this.z.next_in = null;
            this.z.next_out = null;
        } catch (Throwable th) {
            this.z.next_in = null;
            this.z.next_out = null;
            throw th;
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public void decompressionBufferExhausted(ByteBuf byteBuf) {
        this.finished = true;
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    public JZlibDecoder(int i) {
        this(ZlibWrapper.ZLIB, i);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        this(zlibWrapper, 0);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper, int i) {
        super(i);
        Inflater inflater = new Inflater();
        this.z = inflater;
        ObjectUtil.checkNotNull(zlibWrapper, "wrapper");
        int iInit = inflater.init(ZlibUtil.convertWrapperType(zlibWrapper));
        if (iInit != 0) {
            ZlibUtil.fail(inflater, "initialization failure", iInit);
        }
    }

    public JZlibDecoder(byte[] bArr) {
        this(bArr, 0);
    }

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB, 0);
    }
}
