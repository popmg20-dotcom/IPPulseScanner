package androidx.fragment.app;

import android.os.Bundle;
import defpackage.cp3;
import defpackage.hj1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k extends hj1 {
    public final /* synthetic */ o a;

    public k(o oVar) {
        this.a = oVar;
    }

    @Override // defpackage.hj1
    public final void a() {
        o oVar = this.a;
        oVar.mSavedStateRegistryController.a.a();
        cp3.b(oVar);
        Bundle bundle = oVar.mSavedFragmentState;
        oVar.mSavedStateRegistryController.a(bundle != null ? bundle.getBundle("registryState") : null);
    }
}
