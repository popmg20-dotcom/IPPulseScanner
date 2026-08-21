package defpackage;

import io.netty.handler.ssl.Ciphers;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class w40 {
    public static final d7 b = new d7(13);
    public static final e1 c = new e1(7);
    public static final LinkedHashMap d = new LinkedHashMap();
    public static final w40 e;
    public static final w40 f;
    public static final w40 g;
    public static final w40 h;
    public static final w40 i;
    public static final w40 j;
    public static final w40 k;
    public static final w40 l;
    public static final w40 m;
    public static final w40 n;
    public static final w40 o;
    public static final w40 p;
    public static final w40 q;
    public static final w40 r;
    public static final w40 s;
    public static final w40 t;
    public final String a;

    static {
        d7.n("SSL_RSA_WITH_NULL_MD5");
        d7.n("SSL_RSA_WITH_NULL_SHA");
        d7.n("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        d7.n("SSL_RSA_WITH_RC4_128_MD5");
        d7.n("SSL_RSA_WITH_RC4_128_SHA");
        d7.n("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        d7.n("SSL_RSA_WITH_DES_CBC_SHA");
        e = d7.n("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        d7.n("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        d7.n("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        d7.n("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        d7.n("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        d7.n("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        d7.n("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        d7.n("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        d7.n("SSL_DH_anon_WITH_RC4_128_MD5");
        d7.n("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        d7.n("SSL_DH_anon_WITH_DES_CBC_SHA");
        d7.n("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        d7.n("TLS_KRB5_WITH_DES_CBC_SHA");
        d7.n("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        d7.n("TLS_KRB5_WITH_RC4_128_SHA");
        d7.n("TLS_KRB5_WITH_DES_CBC_MD5");
        d7.n("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        d7.n("TLS_KRB5_WITH_RC4_128_MD5");
        d7.n("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        d7.n("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        d7.n("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        d7.n("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        f = d7.n(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA);
        d7.n(Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA);
        d7.n(Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA);
        d7.n(Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA);
        g = d7.n(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA);
        d7.n(Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA);
        d7.n(Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA);
        d7.n(Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA);
        d7.n("TLS_RSA_WITH_NULL_SHA256");
        d7.n(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA256);
        d7.n(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA256);
        d7.n(Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA256);
        d7.n("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        d7.n("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        d7.n("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        d7.n(Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA256);
        d7.n(Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA256);
        d7.n(Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA256);
        d7.n(Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA256);
        d7.n(Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA256);
        d7.n("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        d7.n("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        d7.n("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        d7.n("TLS_PSK_WITH_RC4_128_SHA");
        d7.n("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        d7.n(Ciphers.TLS_PSK_WITH_AES_128_CBC_SHA);
        d7.n(Ciphers.TLS_PSK_WITH_AES_256_CBC_SHA);
        d7.n("TLS_RSA_WITH_SEED_CBC_SHA");
        h = d7.n(Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256);
        i = d7.n(Ciphers.TLS_RSA_WITH_AES_256_GCM_SHA384);
        d7.n(Ciphers.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256);
        d7.n(Ciphers.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384);
        d7.n(Ciphers.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256);
        d7.n(Ciphers.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384);
        d7.n(Ciphers.TLS_DH_anon_WITH_AES_128_GCM_SHA256);
        d7.n(Ciphers.TLS_DH_anon_WITH_AES_256_GCM_SHA384);
        d7.n("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        d7.n("TLS_FALLBACK_SCSV");
        d7.n("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        d7.n("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        d7.n("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        d7.n("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        d7.n("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        d7.n("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        d7.n("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        d7.n("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        d7.n(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
        d7.n(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
        d7.n("TLS_ECDH_RSA_WITH_NULL_SHA");
        d7.n("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        d7.n("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        d7.n("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        d7.n("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        d7.n("TLS_ECDHE_RSA_WITH_NULL_SHA");
        d7.n("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        d7.n("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        j = d7.n(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        k = d7.n(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        d7.n("TLS_ECDH_anon_WITH_NULL_SHA");
        d7.n("TLS_ECDH_anon_WITH_RC4_128_SHA");
        d7.n("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        d7.n(Ciphers.TLS_ECDH_anon_WITH_AES_128_CBC_SHA);
        d7.n(Ciphers.TLS_ECDH_anon_WITH_AES_256_CBC_SHA);
        d7.n(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256);
        d7.n(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384);
        d7.n("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        d7.n("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        d7.n(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256);
        d7.n(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384);
        d7.n("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        d7.n("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        l = d7.n(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        m = d7.n(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        d7.n("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        d7.n("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        n = d7.n(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        o = d7.n(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        d7.n("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        d7.n("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        d7.n(Ciphers.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA);
        d7.n(Ciphers.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA);
        p = d7.n(Ciphers.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        q = d7.n(Ciphers.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256);
        d7.n(Ciphers.TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        d7.n(Ciphers.TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256);
        r = d7.n(Ciphers.TLS_AES_128_GCM_SHA256);
        s = d7.n(Ciphers.TLS_AES_256_GCM_SHA384);
        t = d7.n(Ciphers.TLS_CHACHA20_POLY1305_SHA256);
        d7.n("TLS_AES_128_CCM_SHA256");
        d7.n("TLS_AES_128_CCM_8_SHA256");
    }

    public w40(String str) {
        this.a = str;
    }

    public final String toString() {
        return this.a;
    }
}
