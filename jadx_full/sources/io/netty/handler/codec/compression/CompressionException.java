package io.netty.handler.codec.compression;

import io.netty.handler.codec.EncoderException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class CompressionException extends EncoderException {
    private static final long serialVersionUID = 5603413481274811897L;

    public CompressionException() {
    }

    public CompressionException(String str, Throwable th) {
        super(str, th);
    }

    public CompressionException(String str) {
        super(str);
    }

    public CompressionException(Throwable th) {
        super(th);
    }
}
