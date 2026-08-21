package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jr4 implements View.OnAttachStateChangeListener {
    public boolean A;
    public c84 b;
    public z14 f;
    public ir4 z;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        ir4 ir4Var = this.z;
        if (ir4Var == null) {
            return;
        }
        this.A = true;
        ir4Var.b.a(ir4Var.f);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ir4 ir4Var = this.z;
        if (ir4Var != null) {
            r92 r92Var = ir4Var.A;
            ir4Var.X.g(null);
            ty1 ty1Var = ir4Var.z;
            if (ty1Var instanceof ca2) {
                r92Var.c(ty1Var);
            }
            r92Var.c(ir4Var);
        }
    }
}
