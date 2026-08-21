package androidx.fragment.app;

import android.view.View;
import defpackage.aa2;
import defpackage.da2;
import defpackage.p92;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m implements aa2 {
    public final /* synthetic */ o b;

    public m(o oVar) {
        this.b = oVar;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        View view;
        if (p92Var != p92.ON_STOP || (view = this.b.mView) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}
