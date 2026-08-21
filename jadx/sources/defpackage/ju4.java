package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ju4 extends pu4 {
    public final WindowInsets.Builder e;

    public ju4(bv4 bv4Var) {
        super(bv4Var);
        WindowInsets windowInsetsF = bv4Var.f();
        this.e = windowInsetsF != null ? f04.b(windowInsetsF) : f04.a();
    }

    @Override // defpackage.pu4
    public bv4 b() {
        a();
        bv4 bv4VarG = bv4.g(this.e.build(), null);
        t02[] t02VarArr = this.b;
        yu4 yu4Var = bv4VarG.a;
        yu4Var.v(t02VarArr);
        yu4Var.u(null);
        yu4Var.z(this.c);
        yu4Var.A(this.d);
        return bv4VarG;
    }

    @Override // defpackage.pu4
    public void e(t02 t02Var) {
        this.e.setMandatorySystemGestureInsets(t02Var.e());
    }

    @Override // defpackage.pu4
    public void f(t02 t02Var) {
        this.e.setStableInsets(t02Var.e());
    }

    @Override // defpackage.pu4
    public void g(t02 t02Var) {
        this.e.setSystemGestureInsets(t02Var.e());
    }

    @Override // defpackage.pu4
    public void h(t02 t02Var) {
        this.e.setSystemWindowInsets(t02Var.e());
    }

    @Override // defpackage.pu4
    public void i(t02 t02Var) {
        this.e.setTappableElementInsets(t02Var.e());
    }

    public ju4() {
        this.e = f04.a();
    }
}
