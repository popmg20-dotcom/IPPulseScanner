package defpackage;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x84 implements ComponentCallbacks2 {
    public boolean A;
    public boolean X = true;
    public final WeakReference b;
    public Context f;
    public gr2 z;

    public x84(te3 te3Var) {
        this.b = new WeakReference(te3Var);
    }

    public final synchronized void a() {
        gr2 vd3Var;
        try {
            te3 te3Var = (te3) this.b.get();
            if (te3Var == null) {
                b();
            } else if (this.z == null) {
                Context context = te3Var.a;
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
                int i = 16;
                if (connectivityManager == null || v9.a(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
                    vd3Var = new vd3(i);
                } else {
                    try {
                        vd3Var = new n02(connectivityManager, this);
                    } catch (Exception unused) {
                        vd3Var = new vd3(i);
                    }
                }
                this.z = vd3Var;
                this.X = vd3Var.i();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b() {
        try {
            if (this.A) {
                return;
            }
            this.A = true;
            Context context = this.f;
            if (context != null) {
                context.unregisterComponentCallbacks(this);
            }
            gr2 gr2Var = this.z;
            if (gr2Var != null) {
                gr2Var.shutdown();
            }
            this.b.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onConfigurationChanged(Configuration configuration) {
        if (((te3) this.b.get()) == null) {
            b();
        }
    }

    @Override // android.content.ComponentCallbacks
    public final synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public final synchronized void onTrimMemory(int i) {
        te3 te3Var = (te3) this.b.get();
        if (te3Var != null) {
            we3 we3Var = (we3) te3Var.c.getValue();
            if (we3Var != null) {
                we3Var.a.j(i);
                we3Var.b.s(i);
            }
        } else {
            b();
        }
    }
}
