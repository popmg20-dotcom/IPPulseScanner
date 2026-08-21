package io.netty.handler.ssl;

import javax.net.ssl.SSLException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class NotSslRecordException extends SSLException {
    private static final long serialVersionUID = -4316784434770656841L;

    public NotSslRecordException() {
        super("");
    }

    public NotSslRecordException(String str) {
        super(str);
    }

    public NotSslRecordException(Throwable th) {
        super(th);
    }

    public NotSslRecordException(String str, Throwable th) {
        super(str, th);
    }
}
