package androidx.fragment.app;

import android.view.View;
import defpackage.ha0;
import defpackage.mj1;
import defpackage.xe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l extends mj1 {
    public final /* synthetic */ o b;

    public l(o oVar) {
        this.b = oVar;
    }

    @Override // defpackage.mj1
    public final View e(int i) {
        o oVar = this.b;
        View view = oVar.mView;
        if (view != null) {
            return view.findViewById(i);
        }
        xe.q(ha0.l("Fragment ", oVar, " does not have a view"));
        return null;
    }

    @Override // defpackage.mj1
    public final boolean i() {
        return this.b.mView != null;
    }
}
