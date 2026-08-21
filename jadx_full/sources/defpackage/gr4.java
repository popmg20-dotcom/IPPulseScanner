package defpackage;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gr4 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ z00 A;
    public boolean b;
    public final /* synthetic */ cf3 f;
    public final /* synthetic */ ViewTreeObserver z;

    public gr4(cf3 cf3Var, ViewTreeObserver viewTreeObserver, z00 z00Var) {
        this.f = cf3Var;
        this.z = viewTreeObserver;
        this.A = z00Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        cf3 cf3Var = this.f;
        wx3 wx3VarL = qe4.l(cf3Var);
        if (wx3VarL != null) {
            ViewTreeObserver viewTreeObserver = this.z;
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            } else {
                cf3Var.a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            if (!this.b) {
                this.b = true;
                this.A.d(wx3VarL);
            }
        }
        return true;
    }
}
