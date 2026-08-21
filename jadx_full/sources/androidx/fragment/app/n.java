package androidx.fragment.app;

import defpackage.jm1;
import defpackage.y4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n implements jm1 {
    public final /* synthetic */ o b;

    public n(o oVar) {
        this.b = oVar;
    }

    @Override // defpackage.jm1
    public final Object apply(Object obj) {
        o oVar = this.b;
        Object obj2 = oVar.mHost;
        return obj2 instanceof y4 ? ((y4) obj2).g() : oVar.requireActivity().z0;
    }
}
