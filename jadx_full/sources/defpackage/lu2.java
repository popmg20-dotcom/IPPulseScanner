package defpackage;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lu2 {
    public static final List F = jz4.k(new ba3[]{ba3.HTTP_2, ba3.HTTP_1_1});
    public static final List G = jz4.k(new db0[]{db0.e, db0.f});
    public final int A;
    public final long B;
    public final wn1 C;
    public final ab4 D;
    public final zf2 E;
    public final iv1 a;
    public final List b;
    public final List c;
    public final st4 d;
    public final boolean e;
    public final boolean f;
    public final bg g;
    public final boolean h;
    public final boolean i;
    public final ne0 j;
    public final nw0 k;
    public final Proxy l;
    public final ProxySelector m;
    public final pr1 n;
    public final SocketFactory o;
    public final SSLSocketFactory p;
    public final X509TrustManager q;
    public final List r;
    public final List s;
    public final HostnameVerifier t;
    public final n20 u;
    public final ek0 v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    public lu2(ku2 ku2Var) throws NoSuchAlgorithmException, KeyStoreException {
        ProxySelector proxySelector;
        SSLSocketFactory sSLSocketFactory;
        X509TrustManager x509TrustManager;
        ek0 ek0Var;
        this.a = ku2Var.a;
        this.b = jz4.j(ku2Var.c);
        this.c = jz4.j(ku2Var.d);
        this.d = ku2Var.e;
        this.e = ku2Var.f;
        this.f = ku2Var.g;
        this.g = ku2Var.h;
        this.h = ku2Var.i;
        this.i = ku2Var.j;
        this.j = ku2Var.k;
        this.k = ku2Var.l;
        Proxy proxy = ku2Var.m;
        this.l = proxy;
        if (proxy != null) {
            proxySelector = xs2.a;
        } else {
            proxySelector = ku2Var.n;
            if (proxySelector == null && (proxySelector = ProxySelector.getDefault()) == null) {
                proxySelector = xs2.a;
            }
        }
        this.m = proxySelector;
        this.n = ku2Var.o;
        this.o = ku2Var.p;
        List list = ku2Var.s;
        this.r = list;
        this.s = ku2Var.t;
        this.t = ku2Var.u;
        this.w = ku2Var.x;
        this.x = ku2Var.y;
        this.y = ku2Var.z;
        this.z = ku2Var.A;
        this.A = ku2Var.B;
        this.B = ku2Var.C;
        wn1 wn1Var = ku2Var.D;
        this.C = wn1Var == null ? new wn1(17) : wn1Var;
        ab4 ab4Var = ku2Var.E;
        this.D = ab4Var == null ? ab4.l : ab4Var;
        zf2 zf2Var = ku2Var.b;
        if (zf2Var == null) {
            zf2Var = new zf2(15);
            ku2Var.b = zf2Var;
        }
        this.E = zf2Var;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((db0) it.next()).a) {
                    sSLSocketFactory = ku2Var.q;
                    if (sSLSocketFactory == null) {
                        k13 k13Var = k13.a;
                        k13.a.getClass();
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                        trustManagers.getClass();
                        if (trustManagers.length == 1) {
                            TrustManager trustManager = trustManagers[0];
                            if (trustManager instanceof X509TrustManager) {
                                X509TrustManager x509TrustManager2 = (X509TrustManager) trustManager;
                                this.q = x509TrustManager2;
                                k13 k13Var2 = k13.a;
                                k13Var2.getClass();
                                try {
                                    SSLContext sSLContextK = k13Var2.k();
                                    sSLContextK.init(null, new TrustManager[]{x509TrustManager2}, null);
                                    SSLSocketFactory socketFactory = sSLContextK.getSocketFactory();
                                    socketFactory.getClass();
                                    this.p = socketFactory;
                                    ek0 ek0VarC = k13.a.c(x509TrustManager2);
                                    this.v = ek0VarC;
                                    n20 n20Var = ku2Var.v;
                                    n20Var.getClass();
                                    this.u = n12.c(n20Var.b, ek0VarC) ? n20Var : new n20(n20Var.a, ek0VarC);
                                    x509TrustManager = x509TrustManager2;
                                    sSLSocketFactory = socketFactory;
                                    ek0Var = ek0VarC;
                                } catch (GeneralSecurityException e) {
                                    throw new AssertionError("No System TLS: " + e, e);
                                }
                            }
                        }
                        String string = Arrays.toString(trustManagers);
                        string.getClass();
                        g.g("Unexpected default trust managers: ".concat(string));
                        throw null;
                    }
                    this.p = sSLSocketFactory;
                    ek0Var = ku2Var.w;
                    ek0Var.getClass();
                    this.v = ek0Var;
                    x509TrustManager = ku2Var.r;
                    x509TrustManager.getClass();
                    this.q = x509TrustManager;
                    n20 n20Var2 = ku2Var.v;
                    n20Var2.getClass();
                    this.u = n12.c(n20Var2.b, ek0Var) ? n20Var2 : new n20(n20Var2.a, ek0Var);
                }
            }
            this.p = null;
            this.v = null;
            this.q = null;
            this.u = n20.c;
            sSLSocketFactory = null;
            ek0Var = null;
            x509TrustManager = null;
        } else {
            this.p = null;
            this.v = null;
            this.q = null;
            this.u = n20.c;
            sSLSocketFactory = null;
            ek0Var = null;
            x509TrustManager = null;
        }
        List list2 = this.c;
        List list3 = this.b;
        list3.getClass();
        if (list3.contains(null)) {
            zo2.m(list3, "Null interceptor: ");
            throw null;
        }
        list2.getClass();
        if (list2.contains(null)) {
            zo2.m(list2, "Null network interceptor: ");
            throw null;
        }
        List list4 = this.r;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((db0) it2.next()).a) {
                    if (sSLSocketFactory == null) {
                        xe.q("sslSocketFactory == null");
                        throw null;
                    }
                    if (ek0Var == null) {
                        xe.q("certificateChainCleaner == null");
                        throw null;
                    }
                    if (x509TrustManager != null) {
                        return;
                    }
                    xe.q("x509TrustManager == null");
                    throw null;
                }
            }
        }
        if (sSLSocketFactory != null) {
            xe.q("Check failed.");
            throw null;
        }
        if (ek0Var != null) {
            xe.q("Check failed.");
            throw null;
        }
        if (x509TrustManager != null) {
            xe.q("Check failed.");
            throw null;
        }
        if (n12.c(this.u, n20.c)) {
            return;
        }
        xe.q("Check failed.");
        throw null;
    }

    public final ku2 a() {
        ku2 ku2Var = new ku2();
        ku2Var.a = this.a;
        ku2Var.b = this.E;
        d70.U(this.b, ku2Var.c);
        d70.U(this.c, ku2Var.d);
        ku2Var.e = this.d;
        ku2Var.f = this.e;
        ku2Var.g = this.f;
        ku2Var.h = this.g;
        ku2Var.i = this.h;
        ku2Var.j = this.i;
        ku2Var.k = this.j;
        ku2Var.l = this.k;
        ku2Var.m = this.l;
        ku2Var.n = this.m;
        ku2Var.o = this.n;
        ku2Var.p = this.o;
        ku2Var.q = this.p;
        ku2Var.r = this.q;
        ku2Var.s = this.r;
        ku2Var.t = this.s;
        ku2Var.u = this.t;
        ku2Var.v = this.u;
        ku2Var.w = this.v;
        ku2Var.x = this.w;
        ku2Var.y = this.x;
        ku2Var.z = this.y;
        ku2Var.A = this.z;
        ku2Var.B = this.A;
        ku2Var.C = this.B;
        ku2Var.D = this.C;
        ku2Var.E = this.D;
        return ku2Var;
    }
}
