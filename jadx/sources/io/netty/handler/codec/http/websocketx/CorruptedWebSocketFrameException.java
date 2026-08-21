package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.CorruptedFrameException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class CorruptedWebSocketFrameException extends CorruptedFrameException {
    private static final long serialVersionUID = 3918055132492988338L;
    private final WebSocketCloseStatus closeStatus;

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, String str, Throwable th) {
        super(str == null ? webSocketCloseStatus.reasonText() : str, th);
        this.closeStatus = webSocketCloseStatus;
    }

    public WebSocketCloseStatus closeStatus() {
        return this.closeStatus;
    }

    public CorruptedWebSocketFrameException() {
        this(WebSocketCloseStatus.PROTOCOL_ERROR, null, null);
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, String str) {
        this(webSocketCloseStatus, str, null);
    }

    public CorruptedWebSocketFrameException(WebSocketCloseStatus webSocketCloseStatus, Throwable th) {
        this(webSocketCloseStatus, null, th);
    }
}
