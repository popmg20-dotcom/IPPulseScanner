package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class to0 extends kn1 {
    public int X;
    public int Y;
    public int Z;
    public vp0 y0;
    public ue1 z0;

    public to0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.F0;
        vn1Var.a(uo0.class, to0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final uo0 q() {
        uo0 uo0Var = new uo0(this);
        int i = 0;
        uo0Var.Y = 0;
        uo0Var.Z = 0;
        uo0Var.z0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                uo0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                uo0Var.Z = this.Z;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                ue1 ue1Var = this.z0;
                uo0Var.y0 = ue1Var == null ? this.y0 : (vp0) ue1Var.b();
                i |= 4;
            }
            uo0Var.X = i | uo0Var.X;
        }
        R();
        return uo0Var;
    }

    public final void V(uo0 uo0Var) {
        vp0 vp0Var;
        vp0 vp0Var2;
        if (uo0Var == uo0.A0) {
            return;
        }
        if ((uo0Var.X & 1) != 0) {
            this.Y = uo0Var.Y;
            this.X |= 1;
            S();
        }
        if (uo0Var.J()) {
            this.Z = uo0Var.Z;
            this.X |= 2;
            S();
        }
        if (uo0Var.K()) {
            vp0 vp0VarH = uo0Var.H();
            ue1 ue1Var = this.z0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 4) == 0 || (vp0Var = this.y0) == null || vp0Var == (vp0Var2 = vp0.C0)) {
                    this.y0 = vp0VarH;
                } else {
                    this.X = i | 4;
                    S();
                    ue1 ue1Var2 = this.z0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            vp0 vp0Var3 = this.y0;
                            if (vp0Var3 != null) {
                                vp0Var2 = vp0Var3;
                            }
                        } else {
                            vp0Var2 = (vp0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(vp0Var2, K(), this.z);
                        this.z0 = ue1Var3;
                        this.y0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((qp0) ue1Var2.j()).a0(vp0VarH);
                }
            } else {
                ue1Var.o(vp0VarH);
            }
            if (this.y0 != null) {
                this.X |= 4;
                S();
            }
        }
        A(uo0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        vp0 vp0Var;
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
                        } else if (iS == 26) {
                            ue1 ue1Var = this.z0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    vp0Var = this.y0;
                                    if (vp0Var == null) {
                                        vp0Var = vp0.C0;
                                    }
                                } else {
                                    vp0Var = (vp0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(vp0Var, K(), this.z);
                                this.z0 = ue1Var2;
                                this.y0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
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
        return uo0.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        uo0 uo0VarQ = q();
        if (uo0VarQ.c()) {
            return uo0VarQ;
        }
        throw a1.C(uo0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        vp0 vp0Var;
        if ((this.X & 4) == 0) {
            return true;
        }
        ue1 ue1Var = this.z0;
        if (ue1Var == null) {
            vp0Var = this.y0;
            if (vp0Var == null) {
                vp0Var = vp0.C0;
            }
        } else {
            vp0Var = (vp0) ue1Var.l();
        }
        return vp0Var.c();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.E0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        uo0 uo0VarQ = q();
        if (uo0VarQ.c()) {
            return uo0VarQ;
        }
        throw a1.C(uo0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof uo0) {
            V((uo0) c1Var);
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
        if (c1Var instanceof uo0) {
            V((uo0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
