package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class TooLongHttpHeaderException extends TooLongFrameException {
    private static final long serialVersionUID = -8295159138628369730L;

    public TooLongHttpHeaderException() {
    }

    public TooLongHttpHeaderException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpHeaderException(String str) {
        super(str);
    }

    public TooLongHttpHeaderException(Throwable th) {
        super(th);
    }
}
