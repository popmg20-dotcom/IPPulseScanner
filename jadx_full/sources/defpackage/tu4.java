package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class tu4 extends su4 {
    public t02 s;
    public t02 t;
    public t02 u;

    public tu4(bv4 bv4Var, WindowInsets windowInsets) {
        super(bv4Var, windowInsets);
        this.s = null;
        this.t = null;
        this.u = null;
    }

    @Override // defpackage.yu4
    public t02 j() {
        t02 t02Var = this.t;
        if (t02Var != null) {
            return t02Var;
        }
        t02 t02VarD = t02.d(this.c.getMandatorySystemGestureInsets());
        this.t = t02VarD;
        return t02VarD;
    }

    @Override // defpackage.yu4
    public t02 l() {
        t02 t02Var = this.s;
        if (t02Var != null) {
            return t02Var;
        }
        t02 t02VarD = t02.d(this.c.getSystemGestureInsets());
        this.s = t02VarD;
        return t02VarD;
    }

    @Override // defpackage.yu4
    public t02 n() {
        t02 t02Var = this.u;
        if (t02Var != null) {
            return t02Var;
        }
        t02 t02VarD = t02.d(this.c.getTappableElementInsets());
        this.u = t02VarD;
        return t02VarD;
    }

    @Override // defpackage.qu4, defpackage.yu4
    public bv4 q(int i, int i2, int i3, int i4) {
        return bv4.g(this.c.inset(i, i2, i3, i4), null);
    }

    @Override // defpackage.ru4, defpackage.yu4
    public void x(t02 t02Var) {
    }
}
