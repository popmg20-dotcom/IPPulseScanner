package defpackage;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.u;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uj1 implements aa2 {
    public final /* synthetic */ ab3 b;
    public final /* synthetic */ r92 f;
    public final /* synthetic */ u z;

    public uj1(u uVar, ab3 ab3Var, r92 r92Var) {
        this.z = uVar;
        this.b = ab3Var;
        this.f = r92Var;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        Bundle bundle;
        u uVar = this.z;
        Map map = uVar.m;
        if (p92Var == p92.ON_START && (bundle = (Bundle) map.get("proxy_group_selection")) != null) {
            this.b.a(bundle);
            map.remove("proxy_group_selection");
            if (u.M(2)) {
                Log.v("FragmentManager", "Clearing fragment result with key proxy_group_selection");
            }
        }
        if (p92Var == p92.ON_DESTROY) {
            this.f.c(this);
            uVar.n.remove("proxy_group_selection");
        }
    }
}
