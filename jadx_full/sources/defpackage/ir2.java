package defpackage;

import android.net.ConnectivityManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ir2 implements nb0 {
    public final ConnectivityManager a;

    public ir2(ConnectivityManager connectivityManager) {
        this.a = connectivityManager;
    }

    @Override // defpackage.nb0
    public final boolean a(gx4 gx4Var) {
        if (!c(gx4Var)) {
            return false;
        }
        xe.q("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
        return false;
    }

    @Override // defpackage.nb0
    public final uv b(mc0 mc0Var) {
        mc0Var.getClass();
        return new uv(new uf(mc0Var, this, null, 14), c41.b, -2, jp.b);
    }

    @Override // defpackage.nb0
    public final boolean c(gx4 gx4Var) {
        gx4Var.getClass();
        return gx4Var.j.a() != null;
    }
}
