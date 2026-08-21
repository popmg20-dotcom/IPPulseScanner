package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xh3 extends kn1 {
    public int X;
    public String Y = "";
    public long Z;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.T0;
        vn1Var.a(yh3.class, xh3.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final yh3 q() {
        yh3 yh3Var = new yh3(this);
        yh3Var.X = "";
        yh3Var.Y = 0L;
        yh3Var.Z = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                yh3Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                yh3Var.Y = this.Z;
            }
        }
        R();
        return yh3Var;
    }

    public final void V(yh3 yh3Var) {
        if (yh3Var == yh3.y0) {
            return;
        }
        if (!yh3Var.H().isEmpty()) {
            this.Y = yh3Var.X;
            this.X |= 1;
            S();
        }
        long j = yh3Var.Y;
        if (j != 0) {
            this.Z = j;
            this.X |= 2;
            S();
        }
        A(yh3Var.z);
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
                            this.Y = m60Var.r();
                            this.X |= 1;
                        } else if (iS == 16) {
                            this.Z = m60Var.p();
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
        return yh3.y0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        yh3 yh3VarQ = q();
        if (yh3VarQ.c()) {
            return yh3VarQ;
        }
        throw a1.C(yh3VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.S0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        yh3 yh3VarQ = q();
        if (yh3VarQ.c()) {
            return yh3VarQ;
        }
        throw a1.C(yh3VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof yh3) {
            V((yh3) c1Var);
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
        if (c1Var instanceof yh3) {
            V((yh3) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
