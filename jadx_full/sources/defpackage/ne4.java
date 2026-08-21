package defpackage;

import io.netty.handler.ssl.SslProtocols;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public enum ne4 {
    TLS_1_3(SslProtocols.TLS_v1_3),
    TLS_1_2(SslProtocols.TLS_v1_2),
    TLS_1_1(SslProtocols.TLS_v1_1),
    TLS_1_0(SslProtocols.TLS_v1),
    SSL_3_0(SslProtocols.SSL_v3);

    public static final c84 f = new c84(2);
    public final String b;

    ne4(String str) {
        this.b = str;
    }
}
