package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qr0 extends kn1 {
    public ue1 A0;
    public boolean B0;
    public boolean C0;
    public int X;
    public Serializable Y = "";
    public Serializable Z = "";
    public Serializable y0 = "";
    public vr0 z0;

    public qr0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.Z0;
        vn1Var.a(rr0.class, qr0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final rr0 q() {
        rr0 rr0Var = new rr0(this);
        rr0Var.Y = "";
        rr0Var.Z = "";
        rr0Var.y0 = "";
        int i = 0;
        rr0Var.A0 = false;
        rr0Var.B0 = false;
        rr0Var.C0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                rr0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                rr0Var.Z = this.Z;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                rr0Var.y0 = this.y0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                ue1 ue1Var = this.A0;
                rr0Var.z0 = ue1Var == null ? this.z0 : (vr0) ue1Var.b();
                i |= 8;
            }
            if ((i2 & 16) != 0) {
                rr0Var.A0 = this.B0;
                i |= 16;
            }
            if ((i2 & 32) != 0) {
                rr0Var.B0 = this.C0;
                i |= 32;
            }
            rr0Var.X = i | rr0Var.X;
        }
        R();
        return rr0Var;
    }

    public final void V(rr0 rr0Var) {
        vr0 vr0Var;
        vr0 vr0Var2;
        if (rr0Var == rr0.D0) {
            return;
        }
        if ((rr0Var.X & 1) != 0) {
            this.Y = rr0Var.Y;
            this.X |= 1;
            S();
        }
        if (rr0Var.O()) {
            this.Z = rr0Var.Z;
            this.X |= 2;
            S();
        }
        if (rr0Var.Q()) {
            this.y0 = rr0Var.y0;
            this.X |= 4;
            S();
        }
        if (rr0Var.P()) {
            vr0 vr0VarK = rr0Var.K();
            ue1 ue1Var = this.A0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 8) == 0 || (vr0Var = this.z0) == null || vr0Var == (vr0Var2 = vr0.C0)) {
                    this.z0 = vr0VarK;
                } else {
                    this.X = i | 8;
                    S();
                    ue1 ue1Var2 = this.A0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            vr0 vr0Var3 = this.z0;
                            if (vr0Var3 != null) {
                                vr0Var2 = vr0Var3;
                            }
                        } else {
                            vr0Var2 = (vr0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(vr0Var2, K(), this.z);
                        this.A0 = ue1Var3;
                        this.z0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((tr0) ue1Var2.j()).a0(vr0VarK);
                }
            } else {
                ue1Var.o(vr0VarK);
            }
            if (this.z0 != null) {
                this.X |= 8;
                S();
            }
        }
        if (rr0Var.N()) {
            this.B0 = rr0Var.A0;
            this.X |= 16;
            S();
        }
        if (rr0Var.R()) {
            this.C0 = rr0Var.B0;
            this.X |= 32;
            S();
        }
        A(rr0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        vr0 vr0Var;
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
                        } else if (iS == 26) {
                            this.y0 = m60Var.h();
                            this.X |= 4;
                        } else if (iS == 34) {
                            ue1 ue1Var = this.A0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    vr0Var = this.z0;
                                    if (vr0Var == null) {
                                        vr0Var = vr0.C0;
                                    }
                                } else {
                                    vr0Var = (vr0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(vr0Var, K(), this.z);
                                this.A0 = ue1Var2;
                                this.z0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.X |= 8;
                        } else if (iS == 40) {
                            this.B0 = m60Var.g();
                            this.X |= 16;
                        } else if (iS == 48) {
                            this.C0 = m60Var.g();
                            this.X |= 32;
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
        return rr0.D0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        rr0 rr0VarQ = q();
        if (rr0VarQ.c()) {
            return rr0VarQ;
        }
        throw a1.C(rr0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        vr0 vr0Var;
        if ((this.X & 8) == 0) {
            return true;
        }
        ue1 ue1Var = this.A0;
        if (ue1Var == null) {
            vr0Var = this.z0;
            if (vr0Var == null) {
                vr0Var = vr0.C0;
            }
        } else {
            vr0Var = (vr0) ue1Var.l();
        }
        return vr0Var.c();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.Y0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        rr0 rr0VarQ = q();
        if (rr0VarQ.c()) {
            return rr0VarQ;
        }
        throw a1.C(rr0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof rr0) {
            V((rr0) c1Var);
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
        if (c1Var instanceof rr0) {
            V((rr0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
