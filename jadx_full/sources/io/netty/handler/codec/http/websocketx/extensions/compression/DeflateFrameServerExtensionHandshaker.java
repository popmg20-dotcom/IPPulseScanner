package io.netty.handler.codec.http.websocketx.extensions.compression;

import defpackage.ha0;
import defpackage.xe;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionFilterProvider;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DeflateFrameServerExtensionHandshaker implements WebSocketServerExtensionHandshaker {
    static final String DEFLATE_FRAME_EXTENSION = "deflate-frame";
    static final String X_WEBKIT_DEFLATE_FRAME_EXTENSION = "x-webkit-deflate-frame";
    private final int compressionLevel;
    private final WebSocketExtensionFilterProvider extensionFilterProvider;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class DeflateFrameServerExtension implements WebSocketServerExtension {
        private final int compressionLevel;
        private final WebSocketExtensionFilterProvider extensionFilterProvider;
        private final String extensionName;

        public DeflateFrameServerExtension(int i, String str, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
            this.extensionName = str;
            this.compressionLevel = i;
            this.extensionFilterProvider = webSocketExtensionFilterProvider;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerFrameDeflateDecoder(false, this.extensionFilterProvider.decoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerFrameDeflateEncoder(this.compressionLevel, 15, false, this.extensionFilterProvider.encoderFilter());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension
        public WebSocketExtensionData newReponseData() {
            return new WebSocketExtensionData(this.extensionName, Collections.EMPTY_MAP);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }
    }

    public DeflateFrameServerExtensionHandshaker(int i, WebSocketExtensionFilterProvider webSocketExtensionFilterProvider) {
        if (i < 0 || i > 9) {
            xe.k(ha0.k("compressionLevel: ", i, " (expected: 0-9)"));
            throw null;
        }
        this.compressionLevel = i;
        this.extensionFilterProvider = (WebSocketExtensionFilterProvider) ObjectUtil.checkNotNull(webSocketExtensionFilterProvider, "extensionFilterProvider");
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker
    public WebSocketServerExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if ((X_WEBKIT_DEFLATE_FRAME_EXTENSION.equals(webSocketExtensionData.name()) || DEFLATE_FRAME_EXTENSION.equals(webSocketExtensionData.name())) && webSocketExtensionData.parameters().isEmpty()) {
            return new DeflateFrameServerExtension(this.compressionLevel, webSocketExtensionData.name(), this.extensionFilterProvider);
        }
        return null;
    }

    public DeflateFrameServerExtensionHandshaker(int i) {
        this(i, WebSocketExtensionFilterProvider.DEFAULT);
    }

    public DeflateFrameServerExtensionHandshaker() {
        this(6);
    }
}
