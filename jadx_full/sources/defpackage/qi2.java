package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qi2 implements tg4 {
    public final /* synthetic */ View a;
    public final /* synthetic */ ri2 b;
    public final /* synthetic */ View c;
    public final /* synthetic */ View d;
    public final /* synthetic */ ti2 e;

    public qi2(ti2 ti2Var, View view, ri2 ri2Var, View view2, View view3) {
        this.e = ti2Var;
        this.a = view;
        this.b = ri2Var;
        this.c = view2;
        this.d = view3;
    }

    @Override // defpackage.tg4
    public final void a(vg4 vg4Var) {
        this.a.getOverlay().add(this.b);
        this.c.setAlpha(0.0f);
        this.d.setAlpha(0.0f);
    }

    @Override // defpackage.tg4
    public final void c(vg4 vg4Var) {
        this.e.E(this);
        this.c.setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        this.a.getOverlay().remove(this.b);
    }

    @Override // defpackage.tg4
    public final void d(vg4 vg4Var) {
        a(vg4Var);
    }

    @Override // defpackage.tg4
    public final void e(vg4 vg4Var) {
        c(vg4Var);
    }

    @Override // defpackage.tg4
    public final void b(vg4 vg4Var) {
    }

    @Override // defpackage.tg4
    public final void f(vg4 vg4Var) {
    }

    @Override // defpackage.tg4
    public final void g(vg4 vg4Var) {
    }
}
