package io.netty.handler.proxy;

import java.net.ConnectException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ProxyConnectException extends ConnectException {
    private static final long serialVersionUID = 5211364632246265538L;

    public ProxyConnectException(Throwable th) {
        initCause(th);
    }

    public ProxyConnectException(String str) {
        super(str);
    }

    public ProxyConnectException() {
    }

    public ProxyConnectException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
