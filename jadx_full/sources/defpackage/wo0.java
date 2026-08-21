package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wo0 extends kn1 {
    public int X;
    public int Y;
    public int Z;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.H0;
        vn1Var.a(xo0.class, wo0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final xo0 q() {
        xo0 xo0Var = new xo0(this);
        int i = 0;
        xo0Var.Y = 0;
        xo0Var.Z = 0;
        xo0Var.y0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                xo0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                xo0Var.Z = this.Z;
                i |= 2;
            }
            xo0Var.X = i | xo0Var.X;
        }
        R();
        return xo0Var;
    }

    public final void V(xo0 xo0Var) {
        if (xo0Var == xo0.z0) {
            return;
        }
        if ((xo0Var.X & 1) != 0) {
            this.Y = xo0Var.Y;
            this.X |= 1;
            S();
        }
        if (xo0Var.H()) {
            this.Z = xo0Var.Z;
            this.X |= 2;
            S();
        }
        A(xo0Var.z);
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
                        if (iS == 8) {
                            this.Y = m60Var.o();
                            this.X |= 1;
                        } else if (iS == 16) {
                            this.Z = m60Var.o();
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
        return xo0.z0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        xo0 xo0VarQ = q();
        if (xo0VarQ.c()) {
            return xo0VarQ;
        }
        throw a1.C(xo0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.G0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        xo0 xo0VarQ = q();
        if (xo0VarQ.c()) {
            return xo0VarQ;
        }
        throw a1.C(xo0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof xo0) {
            V((xo0) c1Var);
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
        if (c1Var instanceof xo0) {
            V((xo0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
