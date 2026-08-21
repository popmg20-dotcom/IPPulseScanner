package defpackage;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import android.util.Log;
import io.sentry.android.core.a1;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class j7 extends k13 implements be0 {
    public static final boolean e;
    public Context c;
    public final ArrayList d;

    static {
        e = Build.VERSION.SDK_INT >= 29;
    }

    public j7() {
        ArrayList arrayListL0 = qe.l0(new xy3[]{Build.VERSION.SDK_INT >= 29 ? new k7() : null, new in0(a8.f), new in0(ib0.a), new in0(wo.a)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListL0) {
            if (((xy3) obj).g()) {
                arrayList.add(obj);
            }
        }
        this.d = arrayList;
    }

    @Override // defpackage.be0
    public final void a(Context context) {
        this.c = context;
    }

    @Override // defpackage.be0
    public final Context b() {
        return this.c;
    }

    @Override // defpackage.k13
    public final ek0 c(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        n7 n7Var = x509TrustManagerExtensions != null ? new n7(x509TrustManager, x509TrustManagerExtensions) : null;
        if (n7Var != null) {
            return n7Var;
        }
        StrictMode.noteSlowCall("buildTrustRootIndex");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        return new vl(new gm((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length)));
    }

    @Override // defpackage.k13
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object next;
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((xy3) next).b(sSLSocket)) {
                    break;
                }
            }
        }
        xy3 xy3Var = (xy3) next;
        if (xy3Var != null) {
            xy3Var.c(sSLSocket, str, list);
        }
    }

    @Override // defpackage.k13
    public final String f(SSLSocket sSLSocket) {
        Object next;
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((xy3) next).b(sSLSocket)) {
                break;
            }
        }
        xy3 xy3Var = (xy3) next;
        if (xy3Var != null) {
            return xy3Var.a(sSLSocket);
        }
        return null;
    }

    @Override // defpackage.k13
    public final Object g() {
        if (Build.VERSION.SDK_INT < 30) {
            return super.g();
        }
        CloseGuard closeGuard = new CloseGuard();
        closeGuard.open("response.body().close()");
        return closeGuard;
    }

    @Override // defpackage.k13
    public final boolean h(String str) {
        str.getClass();
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // defpackage.k13
    public final void i(int i, String str, Throwable th) {
        if (i == 5) {
            boolean z = y7.e;
            a1.o("OkHttp", str, th);
        } else {
            boolean z2 = y7.e;
            Log.i("OkHttp", str, th);
        }
    }

    @Override // defpackage.k13
    public final void j(Object obj, String str) {
        if (Build.VERSION.SDK_INT < 30) {
            super.j(obj, str);
        } else {
            obj.getClass();
            ((CloseGuard) obj).warnIfOpen();
        }
    }

    @Override // defpackage.k13
    public final SSLContext k() throws NoSuchAlgorithmException {
        StrictMode.noteSlowCall("newSSLContext");
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.getClass();
        return sSLContext;
    }
}
