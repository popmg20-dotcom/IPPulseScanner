package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u20 extends xg4 {
    public boolean a = false;
    public final ViewGroup b;

    public u20(ViewGroup viewGroup) {
        this.b = viewGroup;
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void b(vg4 vg4Var) {
        fx3.L(this.b, true);
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void c(vg4 vg4Var) {
        if (!this.a) {
            fx3.L(this.b, false);
        }
        vg4Var.E(this);
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void f(vg4 vg4Var) {
        fx3.L(this.b, false);
    }

    @Override // defpackage.xg4, defpackage.tg4
    public final void g(vg4 vg4Var) {
        fx3.L(this.b, false);
        this.a = true;
    }
}
