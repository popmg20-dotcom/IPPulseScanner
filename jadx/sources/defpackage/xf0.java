package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xf0 extends kn1 {
    public int X;
    public zt Y;
    public zt Z;

    public xf0() {
        zt ztVar = zt.z;
        this.Y = ztVar;
        this.Z = ztVar;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.B0;
        vn1Var.a(yf0.class, xf0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final yf0 q() {
        yf0 yf0Var = new yf0(this);
        zt ztVar = zt.z;
        yf0Var.X = ztVar;
        yf0Var.Y = ztVar;
        yf0Var.Z = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                yf0Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                yf0Var.Y = this.Z;
            }
        }
        R();
        return yf0Var;
    }

    public final void V(yf0 yf0Var) {
        if (yf0Var == yf0.y0) {
            return;
        }
        if (!yf0Var.X.isEmpty()) {
            zt ztVar = yf0Var.X;
            ztVar.getClass();
            this.Y = ztVar;
            this.X |= 1;
            S();
        }
        if (!yf0Var.Y.isEmpty()) {
            zt ztVar2 = yf0Var.Y;
            ztVar2.getClass();
            this.Z = ztVar2;
            this.X |= 2;
            S();
        }
        A(yf0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 10) {
                            this.Y = m60Var.h();
                            this.X |= 1;
                        } else if (iS == 18) {
                            this.Z = m60Var.h();
                            this.X |= 2;
                        } else if (!u().t(iS, m60Var)) {
                        }
                    }
                    z = true;
                } catch (s12 e) {
                    throw e.c();
                }
            } catch (Throwable th) {
                S();
                throw th;
            }
        }
        S();
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return yf0.y0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        yf0 yf0VarQ = q();
        if (yf0VarQ.c()) {
            return yf0VarQ;
        }
        throw a1.C(yf0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.A0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        yf0 yf0VarQ = q();
        if (yf0VarQ.c()) {
            return yf0VarQ;
        }
        throw a1.C(yf0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof yf0) {
            V((yf0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: w */
    public final /* bridge */ /* synthetic */ a1 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    public final a1 x(c1 c1Var) {
        if (c1Var instanceof yf0) {
            V((yf0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
