package androidx.fragment.app;

import defpackage.bl1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ o b;

    public /* synthetic */ j(o oVar) {
        this.b = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.b;
        bl1 bl1Var = oVar.mViewLifecycleOwner;
        bl1Var.X.a(oVar.mSavedViewRegistryState);
        oVar.mSavedViewRegistryState = null;
    }
}
