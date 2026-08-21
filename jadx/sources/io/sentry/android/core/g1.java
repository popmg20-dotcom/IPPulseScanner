package io.sentry.android.core;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.x4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends ConnectivityManager.NetworkCallback {
    public final q0 a;
    public NetworkCapabilities b = null;
    public long c = 0;
    public final x4 d;

    public g1(q0 q0Var, x4 x4Var) {
        this.a = q0Var;
        io.sentry.util.b.r(x4Var, "SentryDateProvider is required");
        this.d = x4Var;
    }

    public static io.sentry.g a(String str) {
        io.sentry.g gVar = new io.sentry.g();
        gVar.X = "system";
        gVar.Z = "network.event";
        gVar.d(str, "action");
        gVar.z0 = p5.INFO;
        return gVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        p4.c().c(a("NETWORK_AVAILABLE"), new io.sentry.l0());
        this.b = null;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        f1 f1Var;
        long jD = this.d.a().d();
        NetworkCapabilities networkCapabilities2 = this.b;
        long j = this.c;
        q0 q0Var = this.a;
        if (networkCapabilities2 == null) {
            f1Var = new f1(networkCapabilities, q0Var, jD);
        } else {
            f1 f1Var2 = new f1(networkCapabilities2, q0Var, j);
            f1Var = new f1(networkCapabilities, q0Var, jD);
            int iAbs = Math.abs(f1Var2.c - f1Var.c);
            int i = f1Var.a;
            int i2 = f1Var2.a;
            int iAbs2 = Math.abs(i2 - i);
            int i3 = f1Var.b;
            int i4 = f1Var2.b;
            int iAbs3 = Math.abs(i4 - i3);
            boolean z = ((double) Math.abs(f1Var2.d - f1Var.d)) / 1000000.0d < 5000.0d;
            boolean z2 = z || iAbs <= 5;
            boolean z3 = z || ((double) iAbs2) <= Math.max(1000.0d, ((double) Math.abs(i2)) * 0.1d);
            boolean z4 = z || ((double) iAbs3) <= Math.max(1000.0d, ((double) Math.abs(i4)) * 0.1d);
            if (f1Var2.e == f1Var.e && f1Var2.f.equals(f1Var.f) && z2 && z3 && z4) {
                f1Var = null;
            }
        }
        if (f1Var == null) {
            return;
        }
        this.b = networkCapabilities;
        this.c = jD;
        io.sentry.g gVarA = a("NETWORK_CAPABILITIES_CHANGED");
        gVarA.d(Integer.valueOf(f1Var.a), "download_bandwidth");
        gVarA.d(Integer.valueOf(f1Var.b), "upload_bandwidth");
        gVarA.d(Boolean.valueOf(f1Var.e), "vpn_active");
        gVarA.d(f1Var.f, "network_type");
        int i5 = f1Var.c;
        if (i5 != 0) {
            gVarA.d(Integer.valueOf(i5), "signal_strength");
        }
        io.sentry.l0 l0Var = new io.sentry.l0();
        l0Var.d(f1Var, "android:networkCapabilities");
        p4.c().c(gVarA, l0Var);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        p4.c().c(a("NETWORK_LOST"), new io.sentry.l0());
        this.b = null;
    }
}
