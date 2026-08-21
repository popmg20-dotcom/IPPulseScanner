package defpackage;

import android.content.pm.PackageInfo;
import com.getsurfboard.ui.SurfboardApp;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xc implements fd1 {
    public final qt a;

    public xc(int i, SurfboardApp surfboardApp) {
        this.a = new qt(surfboardApp.getApplicationContext(), i);
    }

    @Override // defpackage.fd1
    public final gd1 a(Object obj, rw2 rw2Var) {
        return new yc(rw2Var, this.a, ((PackageInfo) obj).applicationInfo);
    }
}
