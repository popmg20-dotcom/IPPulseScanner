package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xr0 extends kn1 {
    public int X;
    public Serializable Y = "";
    public bs0 Z;
    public ue1 y0;

    public xr0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.P0;
        vn1Var.a(yr0.class, xr0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final yr0 q() {
        int i;
        yr0 yr0Var = new yr0(this);
        yr0Var.Y = "";
        yr0Var.y0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                yr0Var.Y = this.Y;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                ue1 ue1Var = this.y0;
                yr0Var.Z = ue1Var == null ? this.Z : (bs0) ue1Var.b();
                i |= 2;
            }
            yr0Var.X |= i;
        }
        R();
        return yr0Var;
    }

    public final void V(yr0 yr0Var) {
        bs0 bs0Var;
        bs0 bs0Var2;
        if (yr0Var == yr0.z0) {
            return;
        }
        if ((yr0Var.X & 1) != 0) {
            this.Y = yr0Var.Y;
            this.X |= 1;
            S();
        }
        if (yr0Var.K()) {
            bs0 bs0VarJ = yr0Var.J();
            ue1 ue1Var = this.y0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 2) == 0 || (bs0Var = this.Z) == null || bs0Var == (bs0Var2 = bs0.A0)) {
                    this.Z = bs0VarJ;
                } else {
                    this.X = i | 2;
                    S();
                    ue1 ue1Var2 = this.y0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            bs0 bs0Var3 = this.Z;
                            if (bs0Var3 != null) {
                                bs0Var2 = bs0Var3;
                            }
                        } else {
                            bs0Var2 = (bs0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(bs0Var2, K(), this.z);
                        this.y0 = ue1Var3;
                        this.Z = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((as0) ue1Var2.j()).a0(bs0VarJ);
                }
            } else {
                ue1Var.o(bs0VarJ);
            }
            if (this.Z != null) {
                this.X |= 2;
                S();
            }
        }
        A(yr0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        bs0 bs0Var;
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
                            ue1 ue1Var = this.y0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    bs0Var = this.Z;
                                    if (bs0Var == null) {
                                        bs0Var = bs0.A0;
                                    }
                                } else {
                                    bs0Var = (bs0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(bs0Var, K(), this.z);
                                this.y0 = ue1Var2;
                                this.Z = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
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
        return yr0.z0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        yr0 yr0VarQ = q();
        if (yr0VarQ.c()) {
            return yr0VarQ;
        }
        throw a1.C(yr0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        bs0 bs0Var;
        if ((this.X & 2) == 0) {
            return true;
        }
        ue1 ue1Var = this.y0;
        if (ue1Var == null) {
            bs0Var = this.Z;
            if (bs0Var == null) {
                bs0Var = bs0.A0;
            }
        } else {
            bs0Var = (bs0) ue1Var.l();
        }
        return bs0Var.c();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.O0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        yr0 yr0VarQ = q();
        if (yr0VarQ.c()) {
            return yr0VarQ;
        }
        throw a1.C(yr0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof yr0) {
            V((yr0) c1Var);
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
        if (c1Var instanceof yr0) {
            V((yr0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
