package defpackage;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fr2 extends hk {
    public static final String b = ue2.i("NetworkNotRoamingCtrlr");

    @Override // defpackage.nb0
    public final boolean c(gx4 gx4Var) {
        gx4Var.getClass();
        return gx4Var.j.a == pr2.A;
    }

    @Override // defpackage.hk
    public final int d() {
        return 7;
    }

    @Override // defpackage.hk
    public final boolean e(Object obj) {
        lr2 lr2Var = (lr2) obj;
        lr2Var.getClass();
        boolean z = lr2Var.e;
        boolean z2 = lr2Var.a;
        if (Build.VERSION.SDK_INT >= 24) {
            return (z2 && lr2Var.d && !z) ? false : true;
        }
        ue2.g().a(b, "Not-roaming network constraint is not supported before API 24, only checking for connected state.");
        return !z2 || z;
    }
}
