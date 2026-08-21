package defpackage;

import io.netty.channel.ChannelException;
import j$.util.Optional;
import java.net.ProtocolFamily;
import javax.net.ssl.X509ExtendedTrustManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s53 implements jm1 {
    public final /* synthetic */ int b;

    public /* synthetic */ s53(int i) {
        this.b = i;
    }

    public static /* bridge */ /* synthetic */ ProtocolFamily a(Object obj) {
        return (ProtocolFamily) obj;
    }

    public static /* bridge */ /* synthetic */ X509ExtendedTrustManager c(Object obj) {
        return (X509ExtendedTrustManager) obj;
    }

    public static /* synthetic */ void d() {
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ void e(int i, int i2, Object obj, String str) {
        throw new IllegalStateException(str + i + obj + i2);
    }

    public static /* synthetic */ void f(int i, String str) {
        throw new IllegalStateException((str + i).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(Object obj, int i, String str) {
        throw new IllegalArgumentException(str + obj + ((char) i));
    }

    public static /* synthetic */ void h(Object obj, Object obj2, Object obj3, Object obj4) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(obj3);
        sb.append(obj4);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ void i(Object obj, Object obj2, Object obj3, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        sb.append(obj3);
        throw new IllegalStateException(sb.toString(), th);
    }

    public static /* synthetic */ void j(Object obj, String str) {
        throw new IllegalStateException(str + obj);
    }

    public static /* synthetic */ void k(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    public static /* synthetic */ void l(String str, Object obj, Object obj2) {
        throw new t80(str + obj + obj2);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void n(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        throw new IllegalStateException((str + obj + obj2 + obj3 + obj4).toString());
    }

    public static /* synthetic */ void o(String str, Object obj, Object obj2, Throwable th) {
        throw new IllegalArgumentException(str + obj + obj2, th);
    }

    public static /* synthetic */ void p(String str, Optional optional, String str2, Optional optional2) {
        throw new v90(str, optional, str2, optional2, null);
    }

    public static /* synthetic */ void q(Throwable th) {
        throw new ChannelException(th);
    }

    public static /* synthetic */ void r(int i, String str) {
        throw new IllegalStateException((str + i).toString());
    }

    public static /* synthetic */ void s(Object obj, String str) {
        throw new Error(str + obj);
    }

    public static /* synthetic */ void t(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException((str + obj + obj2).toString());
    }

    @Override // defpackage.jm1
    public Object apply(Object obj) {
        switch (this.b) {
            case 10:
                return obj;
            default:
                return null;
        }
    }
}
