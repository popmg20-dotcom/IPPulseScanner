package io.netty.handler.codec.http.websocketx.extensions;

import io.netty.util.internal.ObjectUtil;
import j$.util.DesugarCollections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class WebSocketExtensionData {
    private final String name;
    private final Map<String, String> parameters;

    public WebSocketExtensionData(String str, Map<String, String> map) {
        this.name = (String) ObjectUtil.checkNotNull(str, "name");
        this.parameters = DesugarCollections.unmodifiableMap((Map) ObjectUtil.checkNotNull(map, "parameters"));
    }

    public String name() {
        return this.name;
    }

    public Map<String, String> parameters() {
        return this.parameters;
    }
}
