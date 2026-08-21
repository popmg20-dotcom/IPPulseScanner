package defpackage;

import android.os.Bundle;
import android.os.SystemClock;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yb5 extends u55 {
    public k45 A0;
    public volatile boolean B0;
    public volatile rb5 C0;
    public rb5 D0;
    public boolean E0;
    public final Object F0;
    public volatile rb5 Y;
    public volatile rb5 Z;
    public rb5 y0;
    public final ConcurrentHashMap z0;

    public yb5(k85 k85Var) {
        super(k85Var);
        this.F0 = new Object();
        this.z0 = new ConcurrentHashMap();
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return false;
    }

    public final void Z0(rb5 rb5Var, boolean z, long j) {
        k85 k85Var = (k85) this.f;
        d45 d45Var = k85Var.E0;
        k85.e(d45Var);
        k85Var.B0.getClass();
        d45Var.Y0(SystemClock.elapsedRealtime());
        boolean z2 = rb5Var != null && rb5Var.d;
        zd5 zd5Var = k85Var.y0;
        k85.g(zd5Var);
        if (!zd5Var.z0.b(j, z2, z) || rb5Var == null) {
            return;
        }
        rb5Var.d = false;
    }

    public final rb5 a1(k45 k45Var) {
        tj4.i(k45Var);
        Integer numValueOf = Integer.valueOf(k45Var.b);
        ConcurrentHashMap concurrentHashMap = this.z0;
        rb5 rb5Var = (rb5) concurrentHashMap.get(numValueOf);
        if (rb5Var == null) {
            String strC1 = c1(k45Var.f);
            qf5 qf5Var = ((k85) this.f).z0;
            k85.f(qf5Var);
            rb5 rb5Var2 = new rb5(null, strC1, qf5Var.T1());
            concurrentHashMap.put(numValueOf, rb5Var2);
            rb5Var = rb5Var2;
        }
        return this.C0 != null ? this.C0 : rb5Var;
    }

    public final rb5 b1(boolean z) {
        W0();
        V0();
        rb5 rb5Var = this.y0;
        return (z && rb5Var == null) ? this.D0 : rb5Var;
    }

    public final String c1(String str) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        k85 k85Var = (k85) this.f;
        int length2 = str2.length();
        k85Var.A.getClass();
        if (length2 <= 500) {
            return str2;
        }
        k85Var.A.getClass();
        return str2.substring(0, 500);
    }

    public final void d1(k45 k45Var, Bundle bundle) {
        Bundle bundle2;
        if (!((k85) this.f).A.j1() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.z0.put(Integer.valueOf(k45Var.b), new rb5(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void e1(String str, rb5 rb5Var, boolean z) {
        rb5 rb5Var2;
        rb5 rb5Var3 = this.Y == null ? this.Z : this.Y;
        if (rb5Var.b == null) {
            rb5Var2 = new rb5(rb5Var.a, str != null ? c1(str) : null, rb5Var.c, rb5Var.e, rb5Var.f);
        } else {
            rb5Var2 = rb5Var;
        }
        this.Z = this.Y;
        this.Y = rb5Var2;
        k85 k85Var = (k85) this.f;
        k85Var.B0.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.e1(new tb5(this, rb5Var2, rb5Var3, jElapsedRealtime, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f1(defpackage.rb5 r18, defpackage.rb5 r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yb5.f1(rb5, rb5, long, boolean, android.os.Bundle):void");
    }
}
