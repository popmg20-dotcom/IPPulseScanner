package defpackage;

import j$.util.Objects;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class a6 {
    public final nw0 a;
    public final SocketFactory b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final n20 e;
    public final bg f;
    public final Proxy g;
    public final ProxySelector h;
    public final ev1 i;
    public final List j;
    public final List k;

    public a6(String str, int i, nw0 nw0Var, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, n20 n20Var, pr1 pr1Var, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        str.getClass();
        nw0Var.getClass();
        socketFactory.getClass();
        pr1Var.getClass();
        list.getClass();
        list2.getClass();
        proxySelector.getClass();
        this.a = nw0Var;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = n20Var;
        this.f = pr1Var;
        this.g = proxy;
        this.h = proxySelector;
        dv1 dv1Var = new dv1();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            dv1Var.a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                xe.k("unexpected scheme: ".concat(str2));
                throw null;
            }
            dv1Var.a = "https";
        }
        String strB = fz4.b(ez4.N(0, 0, 7, str));
        if (strB == null) {
            xe.k("unexpected host: ".concat(str));
            throw null;
        }
        dv1Var.d = strB;
        if (1 > i || i >= 65536) {
            e04.f(dw2.A(i, "unexpected port: "));
            throw null;
        }
        dv1Var.e = i;
        this.i = dv1Var.a();
        this.j = jz4.j(list);
        this.k = jz4.j(list2);
    }

    public final boolean a(a6 a6Var) {
        return n12.c(this.a, a6Var.a) && this.f.equals(a6Var.f) && this.j.equals(a6Var.j) && this.k.equals(a6Var.k) && n12.c(this.h, a6Var.h) && n12.c(this.g, a6Var.g) && n12.c(this.c, a6Var.c) && n12.c(this.d, a6Var.d) && n12.c(this.e, a6Var.e) && this.i.e == a6Var.i.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a6)) {
            return false;
        }
        a6 a6Var = (a6) obj;
        return this.i.equals(a6Var.i) && a(a6Var);
    }

    public final int hashCode() {
        return Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((Objects.hashCode(this.g) + ((this.h.hashCode() + ((this.k.hashCode() + ((this.j.hashCode() + ((this.f.hashCode() + ((this.a.hashCode() + dw2.w(527, 31, this.i.i)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Address{");
        ev1 ev1Var = this.i;
        sb.append(ev1Var.d);
        sb.append(':');
        sb.append(ev1Var.e);
        sb.append(", ");
        Proxy proxy = this.g;
        if (proxy != null) {
            str = "proxy=" + proxy;
        } else {
            str = "proxySelector=" + this.h;
        }
        return fw.x(sb, str, '}');
    }
}
