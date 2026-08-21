package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class TooLongHttpContentException extends TooLongFrameException {
    private static final long serialVersionUID = 3238341182129476117L;

    public TooLongHttpContentException() {
    }

    public TooLongHttpContentException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpContentException(String str) {
        super(str);
    }

    public TooLongHttpContentException(Throwable th) {
        super(th);
    }
}
