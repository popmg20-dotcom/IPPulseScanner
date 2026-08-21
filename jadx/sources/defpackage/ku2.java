package defpackage;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ku2 {
    public int A;
    public int B;
    public long C;
    public wn1 D;
    public ab4 E;
    public zf2 b;
    public st4 e;
    public boolean f;
    public boolean g;
    public bg h;
    public boolean i;
    public boolean j;
    public ne0 k;
    public nw0 l;
    public Proxy m;
    public ProxySelector n;
    public pr1 o;
    public SocketFactory p;
    public SSLSocketFactory q;
    public X509TrustManager r;
    public List s;
    public List t;
    public HostnameVerifier u;
    public n20 v;
    public ek0 w;
    public int x;
    public int y;
    public int z;
    public iv1 a = new iv1(12);
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();

    public ku2() {
        TimeZone timeZone = jz4.a;
        this.e = new st4(7);
        this.f = true;
        this.g = true;
        pr1 pr1Var = bg.a;
        this.h = pr1Var;
        this.i = true;
        this.j = true;
        this.k = ne0.n;
        this.l = nw0.o;
        this.o = pr1Var;
        SocketFactory socketFactory = SocketFactory.getDefault();
        socketFactory.getClass();
        this.p = socketFactory;
        this.s = lu2.G;
        this.t = lu2.F;
        this.u = ju2.a;
        this.v = n20.c;
        this.y = 10000;
        this.z = 10000;
        this.A = 10000;
        this.B = 60000;
        this.C = 1024L;
    }

    public final void a(nw0 nw0Var) {
        if (!nw0Var.equals(this.l)) {
            this.D = null;
        }
        this.l = nw0Var;
    }

    public final void b(SocketFactory socketFactory) {
        if (socketFactory instanceof SSLSocketFactory) {
            xe.k("socketFactory instanceof SSLSocketFactory");
            return;
        }
        if (!socketFactory.equals(this.p)) {
            this.D = null;
        }
        this.p = socketFactory;
    }
}
