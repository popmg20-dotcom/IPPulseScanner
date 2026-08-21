package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kq0 extends kn1 {
    public ue1 A0;
    public int X;
    public int Y = 0;
    public gq0 Z;
    public ue1 y0;
    public gq0 z0;

    public kq0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.D1;
        vn1Var.a(lq0.class, kq0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final lq0 q() {
        lq0 lq0Var = new lq0(this);
        int i = 0;
        lq0Var.Y = 0;
        lq0Var.z0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                lq0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                ue1 ue1Var = this.y0;
                lq0Var.Z = ue1Var == null ? this.Z : (gq0) ue1Var.b();
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                ue1 ue1Var2 = this.A0;
                lq0Var.y0 = ue1Var2 == null ? this.z0 : (gq0) ue1Var2.b();
                i |= 4;
            }
            lq0Var.X = i | lq0Var.X;
        }
        R();
        return lq0Var;
    }

    public final void V(lq0 lq0Var) {
        gq0 gq0Var;
        gq0 gq0Var2;
        gq0 gq0Var3;
        gq0 gq0Var4;
        if (lq0Var == lq0.A0) {
            return;
        }
        if ((lq0Var.X & 1) != 0) {
            zo0 zo0VarB = zo0.b(lq0Var.Y);
            if (zo0VarB == null) {
                zo0VarB = zo0.EDITION_UNKNOWN;
            }
            this.X |= 1;
            this.Y = zo0VarB.b;
            S();
        }
        if (lq0Var.L()) {
            gq0 gq0VarJ = lq0Var.J();
            ue1 ue1Var = this.y0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 2) == 0 || (gq0Var3 = this.Z) == null || gq0Var3 == (gq0Var4 = gq0.G0)) {
                    this.Z = gq0VarJ;
                } else {
                    this.X = i | 2;
                    S();
                    ue1 ue1Var2 = this.y0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            gq0 gq0Var5 = this.Z;
                            if (gq0Var5 != null) {
                                gq0Var4 = gq0Var5;
                            }
                        } else {
                            gq0Var4 = (gq0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(gq0Var4, K(), this.z);
                        this.y0 = ue1Var3;
                        this.Z = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((xp0) ue1Var2.j()).b0(gq0VarJ);
                }
            } else {
                ue1Var.o(gq0VarJ);
            }
            if (this.Z != null) {
                this.X |= 2;
                S();
            }
        }
        if (lq0Var.K()) {
            gq0 gq0VarH = lq0Var.H();
            ue1 ue1Var4 = this.A0;
            if (ue1Var4 == null) {
                int i2 = this.X;
                if ((i2 & 4) == 0 || (gq0Var = this.z0) == null || gq0Var == (gq0Var2 = gq0.G0)) {
                    this.z0 = gq0VarH;
                } else {
                    this.X = i2 | 4;
                    S();
                    ue1 ue1Var5 = this.A0;
                    if (ue1Var5 == null) {
                        if (ue1Var5 == null) {
                            gq0 gq0Var6 = this.z0;
                            if (gq0Var6 != null) {
                                gq0Var2 = gq0Var6;
                            }
                        } else {
                            gq0Var2 = (gq0) ue1Var5.l();
                        }
                        ue1 ue1Var6 = new ue1(gq0Var2, K(), this.z);
                        this.A0 = ue1Var6;
                        this.z0 = null;
                        ue1Var5 = ue1Var6;
                    }
                    ((xp0) ue1Var5.j()).b0(gq0VarH);
                }
            } else {
                ue1Var4.o(gq0VarH);
            }
            if (this.z0 != null) {
                this.X |= 4;
                S();
            }
        }
        A(lq0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        gq0 gq0Var;
        gq0 gq0Var2;
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 24) {
                            int iO = m60Var.o();
                            if (zo0.b(iO) == null) {
                                Q(3, iO);
                            } else {
                                this.Y = iO;
                                this.X |= 1;
                            }
                        } else if (iS == 34) {
                            ue1 ue1Var = this.y0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    gq0Var2 = this.Z;
                                    if (gq0Var2 == null) {
                                        gq0Var2 = gq0.G0;
                                    }
                                } else {
                                    gq0Var2 = (gq0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(gq0Var2, K(), this.z);
                                this.y0 = ue1Var2;
                                this.Z = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.X |= 2;
                        } else if (iS == 42) {
                            ue1 ue1Var3 = this.A0;
                            if (ue1Var3 == null) {
                                if (ue1Var3 == null) {
                                    gq0Var = this.z0;
                                    if (gq0Var == null) {
                                        gq0Var = gq0.G0;
                                    }
                                } else {
                                    gq0Var = (gq0) ue1Var3.l();
                                }
                                ue1 ue1Var4 = new ue1(gq0Var, K(), this.z);
                                this.A0 = ue1Var4;
                                this.z0 = null;
                                ue1Var3 = ue1Var4;
                            }
                            m60Var.k(ue1Var3.j(), o91Var);
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
        return lq0.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        lq0 lq0VarQ = q();
        if (lq0VarQ.c()) {
            return lq0VarQ;
        }
        throw a1.C(lq0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        gq0 gq0Var;
        gq0 gq0Var2;
        if ((this.X & 2) != 0) {
            ue1 ue1Var = this.y0;
            if (ue1Var == null) {
                gq0Var2 = this.Z;
                if (gq0Var2 == null) {
                    gq0Var2 = gq0.G0;
                }
            } else {
                gq0Var2 = (gq0) ue1Var.l();
            }
            if (!gq0Var2.c()) {
                return false;
            }
        }
        if ((this.X & 4) == 0) {
            return true;
        }
        ue1 ue1Var2 = this.A0;
        if (ue1Var2 == null) {
            gq0Var = this.z0;
            if (gq0Var == null) {
                gq0Var = gq0.G0;
            }
        } else {
            gq0Var = (gq0) ue1Var2.l();
        }
        return gq0Var.c();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.C1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        lq0 lq0VarQ = q();
        if (lq0VarQ.c()) {
            return lq0VarQ;
        }
        throw a1.C(lq0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof lq0) {
            V((lq0) c1Var);
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
        if (c1Var instanceof lq0) {
            V((lq0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
