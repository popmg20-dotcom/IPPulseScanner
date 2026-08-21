package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mr2 extends bc0 {
    public final ConnectivityManager f;
    public final Object g;
    public volatile boolean h;
    public final wz1 i;

    public mr2(Context context, ih4 ih4Var) {
        super(context, ih4Var);
        Object systemService = this.b.getSystemService("connectivity");
        systemService.getClass();
        this.f = (ConnectivityManager) systemService;
        this.g = new Object();
        this.i = new wz1(1, this);
    }

    @Override // defpackage.bc0
    public final Object a() {
        if (Build.VERSION.SDK_INT >= 28) {
            ConnectivityManager connectivityManager = this.f;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return nr2.b(networkCapabilities, this.h);
            }
        }
        return nr2.a(this.f, this.h);
    }

    @Override // defpackage.bc0
    public final void c() {
        try {
            ue2.g().a(nr2.a, "Registering network callback");
            ga5.z(this.f, this.i);
        } catch (IllegalArgumentException e) {
            ue2.g().f(nr2.a, "Received exception while registering network callback", e);
        } catch (SecurityException e2) {
            ue2.g().f(nr2.a, "Received exception while registering network callback", e2);
        }
    }

    @Override // defpackage.bc0
    public final void d() {
        try {
            ue2.g().a(nr2.a, "Unregistering network callback");
            this.f.unregisterNetworkCallback(this.i);
        } catch (IllegalArgumentException e) {
            ue2.g().f(nr2.a, "Received exception while unregistering network callback", e);
        } catch (SecurityException e2) {
            ue2.g().f(nr2.a, "Received exception while unregistering network callback", e2);
        }
    }
}
