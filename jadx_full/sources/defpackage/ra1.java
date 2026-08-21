package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ra1 extends kn1 {
    public int X;
    public int Y;
    public String Z = "";
    public String y0 = "";
    public long z0;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.f1;
        vn1Var.a(sa1.class, ra1.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final sa1 q() {
        sa1 sa1Var = new sa1(this);
        sa1Var.X = 0;
        sa1Var.Y = "";
        sa1Var.Z = "";
        sa1Var.y0 = 0L;
        sa1Var.z0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                sa1Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                sa1Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                sa1Var.Z = this.y0;
            }
            if ((i & 8) != 0) {
                sa1Var.y0 = this.z0;
            }
        }
        R();
        return sa1Var;
    }

    public final void V(sa1 sa1Var) {
        if (sa1Var == sa1.A0) {
            return;
        }
        int i = sa1Var.X;
        if (i != 0) {
            this.Y = i;
            this.X |= 1;
            S();
        }
        if (!sa1Var.J().isEmpty()) {
            this.Z = sa1Var.Y;
            this.X |= 2;
            S();
        }
        if (!sa1Var.H().isEmpty()) {
            this.y0 = sa1Var.Z;
            this.X |= 4;
            S();
        }
        long j = sa1Var.y0;
        if (j != 0) {
            this.z0 = j;
            this.X |= 8;
            S();
        }
        A(sa1Var.z);
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
                        } else if (iS == 18) {
                            this.Z = m60Var.r();
                            this.X |= 2;
                        } else if (iS == 26) {
                            this.y0 = m60Var.r();
                            this.X |= 4;
                        } else if (iS == 32) {
                            this.z0 = m60Var.p();
                            this.X |= 8;
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
        return sa1.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        sa1 sa1VarQ = q();
        if (sa1VarQ.c()) {
            return sa1VarQ;
        }
        throw a1.C(sa1VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.e1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        sa1 sa1VarQ = q();
        if (sa1VarQ.c()) {
            return sa1VarQ;
        }
        throw a1.C(sa1VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof sa1) {
            V((sa1) c1Var);
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
        if (c1Var instanceof sa1) {
            V((sa1) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
