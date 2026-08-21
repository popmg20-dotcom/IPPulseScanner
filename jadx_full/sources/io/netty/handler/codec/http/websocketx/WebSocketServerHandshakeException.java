package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpRequest;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class WebSocketServerHandshakeException extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1;
    private final HttpRequest request;

    public WebSocketServerHandshakeException(String str, HttpRequest httpRequest) {
        super(str);
        if (httpRequest != null) {
            this.request = new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri(), httpRequest.headers());
        } else {
            this.request = null;
        }
    }

    public HttpRequest request() {
        return this.request;
    }

    public WebSocketServerHandshakeException(String str) {
        this(str, null);
    }
}
