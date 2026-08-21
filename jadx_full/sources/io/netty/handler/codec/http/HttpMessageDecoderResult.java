package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class HttpMessageDecoderResult extends DecoderResult {
    private final int headerSize;
    private final int initialLineLength;

    public HttpMessageDecoderResult(int i, int i2) {
        super(DecoderResult.SIGNAL_SUCCESS);
        this.initialLineLength = i;
        this.headerSize = i2;
    }

    public int headerSize() {
        return this.headerSize;
    }

    public int initialLineLength() {
        return this.initialLineLength;
    }

    public int totalSize() {
        return this.initialLineLength + this.headerSize;
    }
}
