package defpackage;

import android.view.ActionProvider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uk2 implements ActionProvider.VisibilityListener {
    public ha1 a;
    public final ActionProvider b;

    public uk2(xk2 xk2Var, ActionProvider actionProvider) {
        this.b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        ha1 ha1Var = this.a;
        if (ha1Var != null) {
            nk2 nk2Var = ((sk2) ha1Var.f).n;
            nk2Var.h = true;
            nk2Var.r(true);
        }
    }
}
