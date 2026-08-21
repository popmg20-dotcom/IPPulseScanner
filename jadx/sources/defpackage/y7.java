package defpackage;

import android.content.Context;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.os.StrictMode;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class y7 extends k13 implements be0 {
    public static final boolean e;
    public Context c;
    public final ArrayList d;

    static {
        e = Build.VERSION.SDK_INT < 29;
    }

    public y7() {
        a24 a24Var;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketImpl"));
            Class.forName("com.android.org.conscrypt".concat(".OpenSSLSocketFactoryImpl"));
            Class.forName("com.android.org.conscrypt".concat(".SSLParametersImpl"));
            a24Var = new a24(cls);
        } catch (Exception e2) {
            CopyOnWriteArraySet copyOnWriteArraySet = t7.a;
            t7.a(lu2.class.getName(), 5, "unable to load android socket classes", e2);
            a24Var = null;
        }
        ArrayList arrayListL0 = qe.l0(new xy3[]{a24Var, new in0(a8.f), new in0(ib0.a), new in0(wo.a)});
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
        yh4 gmVar;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        n7 n7Var = x509TrustManagerExtensions != null ? new n7(x509TrustManager, x509TrustManagerExtensions) : null;
        if (n7Var != null) {
            return n7Var;
        }
        try {
            StrictMode.noteSlowCall("buildTrustRootIndex");
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            gmVar = new x7(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused2) {
            X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
            gmVar = new gm((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
        }
        return new vl(gmVar);
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
    public final void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        inetSocketAddress.getClass();
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
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
    public final boolean h(String str) {
        str.getClass();
        return Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str) : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    @Override // defpackage.k13
    public final void i(int i, String str, Throwable th) {
        if (i == 5) {
            a1.o("OkHttp", str, th);
        } else {
            Log.i("OkHttp", str, th);
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
