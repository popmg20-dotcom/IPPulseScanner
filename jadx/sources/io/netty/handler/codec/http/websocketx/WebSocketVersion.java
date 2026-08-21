package io.netty.handler.codec.http.websocketx;

import defpackage.s53;
import io.netty.util.AsciiString;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum WebSocketVersion {
    UNKNOWN(AsciiString.cached("")),
    V00(AsciiString.cached("0")),
    V07(AsciiString.cached("7")),
    V08(AsciiString.cached("8")),
    V13(AsciiString.cached("13"));

    private final AsciiString headerValue;

    WebSocketVersion(AsciiString asciiString) {
        this.headerValue = asciiString;
    }

    public AsciiString toAsciiString() {
        if (this != UNKNOWN) {
            return this.headerValue;
        }
        s53.j(this, "Unknown web socket version: ");
        return null;
    }

    public String toHttpHeaderValue() {
        return toAsciiString().toString();
    }
}
