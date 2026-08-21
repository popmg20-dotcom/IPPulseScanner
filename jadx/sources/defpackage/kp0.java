package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kp0 extends kn1 {
    public int X;
    public Serializable Y = "";
    public int Z;
    public op0 y0;
    public ue1 z0;

    public kp0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.V0;
        vn1Var.a(lp0.class, kp0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final lp0 q() {
        lp0 lp0Var = new lp0(this);
        lp0Var.Y = "";
        int i = 0;
        lp0Var.Z = 0;
        lp0Var.z0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                lp0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                lp0Var.Z = this.Z;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                ue1 ue1Var = this.z0;
                lp0Var.y0 = ue1Var == null ? this.y0 : (op0) ue1Var.b();
                i |= 4;
            }
            lp0Var.X = i | lp0Var.X;
        }
        R();
        return lp0Var;
    }

    public final void V(lp0 lp0Var) {
        op0 op0Var;
        op0 op0Var2;
        if (lp0Var == lp0.A0) {
            return;
        }
        if ((lp0Var.X & 1) != 0) {
            this.Y = lp0Var.Y;
            this.X |= 1;
            S();
        }
        if (lp0Var.K()) {
            this.Z = lp0Var.Z;
            this.X |= 2;
            S();
        }
        if (lp0Var.L()) {
            op0 op0VarJ = lp0Var.J();
            ue1 ue1Var = this.z0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 4) == 0 || (op0Var = this.y0) == null || op0Var == (op0Var2 = op0.D0)) {
                    this.y0 = op0VarJ;
                } else {
                    this.X = i | 4;
                    S();
                    ue1 ue1Var2 = this.z0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            op0 op0Var3 = this.y0;
                            if (op0Var3 != null) {
                                op0Var2 = op0Var3;
                            }
                        } else {
                            op0Var2 = (op0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(op0Var2, K(), this.z);
                        this.z0 = ue1Var3;
                        this.y0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((np0) ue1Var2.j()).b0(op0VarJ);
                }
            } else {
                ue1Var.o(op0VarJ);
            }
            if (this.y0 != null) {
                this.X |= 4;
                S();
            }
        }
        A(lp0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        op0 op0Var;
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
                        } else if (iS == 16) {
                            this.Z = m60Var.o();
                            this.X |= 2;
                        } else if (iS == 26) {
                            ue1 ue1Var = this.z0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    op0Var = this.y0;
                                    if (op0Var == null) {
                                        op0Var = op0.D0;
                                    }
                                } else {
                                    op0Var = (op0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(op0Var, K(), this.z);
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
        return lp0.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        lp0 lp0VarI = I();
        if (lp0VarI.c()) {
            return lp0VarI;
        }
        throw a1.C(lp0VarI);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        op0 op0Var;
        if ((this.X & 4) == 0) {
            return true;
        }
        ue1 ue1Var = this.z0;
        if (ue1Var == null) {
            op0Var = this.y0;
            if (op0Var == null) {
                op0Var = op0.D0;
            }
        } else {
            op0Var = (op0) ue1Var.l();
        }
        return op0Var.c();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.U0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        lp0 lp0VarI = I();
        if (lp0VarI.c()) {
            return lp0VarI;
        }
        throw a1.C(lp0VarI);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof lp0) {
            V((lp0) c1Var);
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
        if (c1Var instanceof lp0) {
            V((lp0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
