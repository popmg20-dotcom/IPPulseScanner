package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class TooLongHttpLineException extends TooLongFrameException {
    private static final long serialVersionUID = 1614751125592211890L;

    public TooLongHttpLineException() {
    }

    public TooLongHttpLineException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpLineException(String str) {
        super(str);
    }

    public TooLongHttpLineException(Throwable th) {
        super(th);
    }
}
