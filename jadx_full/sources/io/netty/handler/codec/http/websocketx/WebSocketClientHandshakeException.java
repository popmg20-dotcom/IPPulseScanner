package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponse;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class WebSocketClientHandshakeException extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1;
    private final HttpResponse response;

    public WebSocketClientHandshakeException(String str, HttpResponse httpResponse) {
        super(str);
        if (httpResponse != null) {
            this.response = new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status(), httpResponse.headers());
        } else {
            this.response = null;
        }
    }

    public HttpResponse response() {
        return this.response;
    }

    public WebSocketClientHandshakeException(String str) {
        this(str, null);
    }
}
