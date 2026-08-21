package defpackage;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k85 implements m95 {
    public static volatile k85 V0;
    public final x15 A;
    public final k65 A0;
    public final wl3 B0;
    public final yb5 C0;
    public final ib5 D0;
    public final d45 E0;
    public final mb5 F0;
    public final String G0;
    public i65 H0;
    public dd5 I0;
    public u25 J0;
    public d65 K0;
    public nb5 L0;
    public Boolean N0;
    public long O0;
    public volatile Boolean P0;
    public volatile boolean Q0;
    public int R0;
    public int S0;
    public final long U0;
    public final l75 X;
    public final t65 Y;
    public final f85 Z;
    public final Context b;
    public final boolean f;
    public final zd5 y0;
    public final d84 z;
    public final qf5 z0;
    public boolean M0 = false;
    public final AtomicInteger T0 = new AtomicInteger(0);

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        throw r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k85(defpackage.y95 r11) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k85.<init>(y95):void");
    }

    public static final void e(z45 z45Var) {
        if (z45Var != null) {
            return;
        }
        xe.q("Component not created");
    }

    public static final void f(k70 k70Var) {
        if (k70Var != null) {
            return;
        }
        xe.q("Component not created");
    }

    public static final void g(u55 u55Var) {
        if (u55Var == null) {
            xe.q("Component not created");
        } else {
            if (u55Var.X) {
                return;
            }
            xe.q("Component not initialized: ".concat(String.valueOf(u55Var.getClass())));
        }
    }

    public static final void h(k95 k95Var) {
        if (k95Var == null) {
            xe.q("Component not created");
        } else {
            if (k95Var.X) {
                return;
            }
            xe.q("Component not initialized: ".concat(String.valueOf(k95Var.getClass())));
        }
    }

    public static k85 m(Context context, j45 j45Var, Long l) {
        Bundle bundle;
        if (j45Var != null) {
            Bundle bundle2 = j45Var.A;
            j45Var = new j45(j45Var.b, j45Var.f, j45Var.z, bundle2, null);
        }
        tj4.i(context);
        tj4.i(context.getApplicationContext());
        if (V0 == null) {
            synchronized (k85.class) {
                try {
                    if (V0 == null) {
                        V0 = new k85(new y95(context, j45Var, l));
                    }
                } finally {
                }
            }
        } else if (j45Var != null && (bundle = j45Var.A) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            tj4.i(V0);
            V0.P0 = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        tj4.i(V0);
        return V0;
    }

    @Override // defpackage.m95
    public final f85 C() {
        f85 f85Var = this.Z;
        h(f85Var);
        return f85Var;
    }

    @Override // defpackage.m95
    public final d84 U() {
        return this.z;
    }

    public final boolean a() {
        return b() == 0;
    }

    public final int b() {
        f85 f85Var = this.Z;
        h(f85Var);
        f85Var.V0();
        x15 x15Var = this.A;
        if (x15Var.i1()) {
            return 1;
        }
        h(f85Var);
        f85Var.V0();
        if (!this.Q0) {
            return 8;
        }
        l75 l75Var = this.X;
        f(l75Var);
        l75Var.V0();
        Boolean boolValueOf = l75Var.Z0().contains("measurement_enabled") ? Boolean.valueOf(l75Var.Z0().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        d84 d84Var = ((k85) x15Var.f).z;
        Boolean boolH1 = x15Var.h1("firebase_analytics_collection_enabled");
        return boolH1 != null ? boolH1.booleanValue() ? 0 : 4 : (this.P0 == null || this.P0.booleanValue()) ? 0 : 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r7 = this;
            boolean r0 = r7.M0
            r1 = 0
            if (r0 == 0) goto L96
            f85 r0 = r7.Z
            h(r0)
            r0.V0()
            java.lang.Boolean r0 = r7.N0
            wl3 r2 = r7.B0
            if (r0 == 0) goto L35
            long r3 = r7.O0
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L35
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L8f
            r2.getClass()
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r5 = r7.O0
            long r3 = r3 - r5
            long r3 = java.lang.Math.abs(r3)
            r5 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L8f
        L35:
            r2.getClass()
            long r2 = android.os.SystemClock.elapsedRealtime()
            r7.O0 = r2
            qf5 r0 = r7.z0
            f(r0)
            java.lang.String r2 = "android.permission.INTERNET"
            boolean r2 = r0.u1(r2)
            if (r2 == 0) goto L75
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r2 = r0.u1(r2)
            if (r2 == 0) goto L75
            android.content.Context r2 = r7.b
            ey2 r3 = defpackage.ay4.a(r2)
            boolean r3 = r3.b()
            r4 = 1
            if (r3 != 0) goto L74
            x15 r3 = r7.A
            boolean r3 = r3.Y0()
            if (r3 != 0) goto L74
            boolean r3 = defpackage.qf5.N1(r2)
            if (r3 == 0) goto L75
            boolean r2 = defpackage.qf5.o1(r2)
            if (r2 == 0) goto L75
        L74:
            r1 = r4
        L75:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            r7.N0 = r2
            if (r1 == 0) goto L8f
            d65 r1 = r7.l()
            java.lang.String r1 = r1.c1()
            boolean r0 = r0.Z0(r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.N0 = r0
        L8f:
            java.lang.Boolean r7 = r7.N0
            boolean r7 = r7.booleanValue()
            return r7
        L96:
            java.lang.String r7 = "AppMeasurement is not initialized"
            defpackage.xe.q(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k85.c():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(int r20, java.lang.Throwable r21, byte[] r22) {
        /*
            Method dump skipped, instruction units count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k85.d(int, java.lang.Throwable, byte[]):void");
    }

    public final i65 i() {
        g(this.H0);
        return this.H0;
    }

    public final dd5 j() {
        g(this.I0);
        return this.I0;
    }

    public final u25 k() {
        h(this.J0);
        return this.J0;
    }

    public final d65 l() {
        g(this.K0);
        return this.K0;
    }

    @Override // defpackage.m95
    public final t65 n() {
        t65 t65Var = this.Y;
        h(t65Var);
        return t65Var;
    }

    @Override // defpackage.m95
    public final Context r0() {
        return this.b;
    }

    @Override // defpackage.m95
    public final wl3 z0() {
        return this.B0;
    }
}
