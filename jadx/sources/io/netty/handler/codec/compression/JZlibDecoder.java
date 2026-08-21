package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public void decode(io.netty.channel.ChannelHandlerContext r9, io.netty.buffer.ByteBuf r10, java.util.List<java.lang.Object> r11) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.JZlibDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
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
