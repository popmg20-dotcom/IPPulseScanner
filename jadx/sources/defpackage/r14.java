package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r14 extends kn1 {
    public int X;
    public hi Y;
    public ue1 Z;
    public long y0;
    public long z0;

    public r14() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.D0;
        vn1Var.a(s14.class, r14.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final s14 q() {
        int i;
        s14 s14Var = new s14(this);
        s14Var.Z = 0L;
        s14Var.y0 = 0L;
        s14Var.z0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                ue1 ue1Var = this.Z;
                s14Var.Y = ue1Var == null ? this.Y : (hi) ue1Var.b();
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                s14Var.Z = this.y0;
            }
            if ((i2 & 4) != 0) {
                s14Var.y0 = this.z0;
            }
            s14Var.X |= i;
        }
        R();
        return s14Var;
    }

    public final ue1 V() {
        hi hiVar;
        ue1 ue1Var = this.Z;
        if (ue1Var != null) {
            return ue1Var;
        }
        if (ue1Var == null) {
            hiVar = this.Y;
            if (hiVar == null) {
                hiVar = hi.E0;
            }
        } else {
            hiVar = (hi) ue1Var.l();
        }
        ue1 ue1Var2 = new ue1(hiVar, K(), this.z);
        this.Z = ue1Var2;
        this.Y = null;
        return ue1Var2;
    }

    public final void W(s14 s14Var) {
        hi hiVar;
        if (s14Var == s14.A0) {
            return;
        }
        if ((s14Var.X & 1) != 0) {
            hi hiVarH = s14Var.H();
            ue1 ue1Var = this.Z;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 1) == 0 || (hiVar = this.Y) == null || hiVar == hi.E0) {
                    this.Y = hiVarH;
                } else {
                    this.X = i | 1;
                    S();
                    ((gi) V().j()).V(hiVarH);
                }
            } else {
                ue1Var.o(hiVarH);
            }
            if (this.Y != null) {
                this.X |= 1;
                S();
            }
        }
        long j = s14Var.Z;
        if (j != 0) {
            this.y0 = j;
            this.X |= 2;
            S();
        }
        long j2 = s14Var.y0;
        if (j2 != 0) {
            this.z0 = j2;
            this.X |= 4;
            S();
        }
        A(s14Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 10) {
                            m60Var.k(V().j(), o91Var);
                            this.X |= 1;
                        } else if (iS == 16) {
                            this.y0 = m60Var.p();
                            this.X |= 2;
                        } else if (iS == 24) {
                            this.z0 = m60Var.p();
                            this.X |= 4;
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
        return s14.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        s14 s14VarQ = q();
        if (s14VarQ.c()) {
            return s14VarQ;
        }
        throw a1.C(s14VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.C0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        s14 s14VarQ = q();
        if (s14VarQ.c()) {
            return s14VarQ;
        }
        throw a1.C(s14VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof s14) {
            W((s14) c1Var);
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
        if (c1Var instanceof s14) {
            W((s14) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
