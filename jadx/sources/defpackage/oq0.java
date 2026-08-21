package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oq0 extends kn1 {
    public int D0;
    public er0 F0;
    public ue1 G0;
    public boolean H0;
    public int X;
    public int Z;
    public Serializable Y = "";
    public int y0 = 1;
    public int z0 = 1;
    public Serializable A0 = "";
    public Serializable B0 = "";
    public Serializable C0 = "";
    public Serializable E0 = "";

    public oq0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.N0;
        vn1Var.a(rq0.class, oq0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final rq0 q() {
        rq0 rq0Var = new rq0(this);
        rq0Var.Y = "";
        int i = 0;
        rq0Var.Z = 0;
        rq0Var.y0 = 1;
        rq0Var.z0 = 1;
        rq0Var.A0 = "";
        rq0Var.B0 = "";
        rq0Var.C0 = "";
        rq0Var.D0 = 0;
        rq0Var.E0 = "";
        rq0Var.G0 = false;
        rq0Var.H0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                rq0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                rq0Var.Z = this.Z;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                rq0Var.y0 = this.y0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                rq0Var.z0 = this.z0;
                i |= 8;
            }
            if ((i2 & 16) != 0) {
                rq0Var.A0 = this.A0;
                i |= 16;
            }
            if ((i2 & 32) != 0) {
                rq0Var.B0 = this.B0;
                i |= 32;
            }
            if ((i2 & 64) != 0) {
                rq0Var.C0 = this.C0;
                i |= 64;
            }
            if ((i2 & 128) != 0) {
                rq0Var.D0 = this.D0;
                i |= 128;
            }
            if ((i2 & 256) != 0) {
                rq0Var.E0 = this.E0;
                i |= 256;
            }
            if ((i2 & 512) != 0) {
                ue1 ue1Var = this.G0;
                rq0Var.F0 = ue1Var == null ? this.F0 : (er0) ue1Var.b();
                i |= 512;
            }
            if ((i2 & 1024) != 0) {
                rq0Var.G0 = this.H0;
                i |= 1024;
            }
            rq0Var.X |= i;
        }
        R();
        return rq0Var;
    }

    public final void V(rq0 rq0Var) {
        er0 er0Var;
        er0 er0Var2;
        pq0 pq0Var;
        if (rq0Var == rq0.I0) {
            return;
        }
        if ((rq0Var.X & 1) != 0) {
            this.Y = rq0Var.Y;
            this.X |= 1;
            S();
        }
        if (rq0Var.T()) {
            this.Z = rq0Var.Z;
            this.X |= 2;
            S();
        }
        if (rq0Var.S()) {
            int i = rq0Var.y0;
            if (i == 1) {
                pq0Var = pq0.LABEL_OPTIONAL;
            } else if (i == 2) {
                pq0Var = pq0.LABEL_REQUIRED;
            } else if (i != 3) {
                pq0 pq0Var2 = pq0.LABEL_OPTIONAL;
                pq0Var = null;
            } else {
                pq0Var = pq0.LABEL_REPEATED;
            }
            if (pq0Var == null) {
                pq0Var = pq0.LABEL_OPTIONAL;
            }
            this.X |= 4;
            this.y0 = pq0Var.b;
            S();
        }
        if (rq0Var.X()) {
            qq0 qq0VarB = qq0.b(rq0Var.z0);
            if (qq0VarB == null) {
                qq0VarB = qq0.TYPE_DOUBLE;
            }
            this.X |= 8;
            this.z0 = qq0VarB.b;
            S();
        }
        if (rq0Var.Y()) {
            this.A0 = rq0Var.A0;
            this.X |= 16;
            S();
        }
        if (rq0Var.Q()) {
            this.B0 = rq0Var.B0;
            this.X |= 32;
            S();
        }
        if (rq0Var.P()) {
            this.C0 = rq0Var.C0;
            this.X |= 64;
            S();
        }
        if (rq0Var.U()) {
            this.D0 = rq0Var.D0;
            this.X |= 128;
            S();
        }
        if (rq0Var.R()) {
            this.E0 = rq0Var.E0;
            this.X |= 256;
            S();
        }
        if (rq0Var.V()) {
            er0 er0VarN = rq0Var.N();
            ue1 ue1Var = this.G0;
            if (ue1Var == null) {
                int i2 = this.X;
                if ((i2 & 512) == 0 || (er0Var = this.F0) == null || er0Var == (er0Var2 = er0.M0)) {
                    this.F0 = er0VarN;
                } else {
                    this.X = i2 | 512;
                    S();
                    ue1 ue1Var2 = this.G0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            er0 er0Var3 = this.F0;
                            if (er0Var3 != null) {
                                er0Var2 = er0Var3;
                            }
                        } else {
                            er0Var2 = (er0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(er0Var2, K(), this.z);
                        this.G0 = ue1Var3;
                        this.F0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((tq0) ue1Var2.j()).c0(er0VarN);
                }
            } else {
                ue1Var.o(er0VarN);
            }
            if (this.F0 != null) {
                this.X |= 512;
                S();
            }
        }
        if (rq0Var.W()) {
            this.H0 = rq0Var.G0;
            this.X |= 1024;
            S();
        }
        A(rq0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        er0 er0Var;
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    pq0 pq0Var = null;
                    switch (iS) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            this.Y = m60Var.h();
                            this.X |= 1;
                            break;
                        case 18:
                            this.B0 = m60Var.h();
                            this.X |= 32;
                            break;
                        case 24:
                            this.Z = m60Var.o();
                            this.X |= 2;
                            break;
                        case 32:
                            int iO = m60Var.o();
                            if (iO == 1) {
                                pq0Var = pq0.LABEL_OPTIONAL;
                            } else if (iO == 2) {
                                pq0Var = pq0.LABEL_REQUIRED;
                            } else if (iO != 3) {
                                pq0 pq0Var2 = pq0.LABEL_OPTIONAL;
                            } else {
                                pq0Var = pq0.LABEL_REPEATED;
                            }
                            if (pq0Var == null) {
                                Q(4, iO);
                            } else {
                                this.y0 = iO;
                                this.X |= 4;
                            }
                            break;
                        case 40:
                            int iO2 = m60Var.o();
                            if (qq0.b(iO2) == null) {
                                Q(5, iO2);
                            } else {
                                this.z0 = iO2;
                                this.X |= 8;
                            }
                            break;
                        case 50:
                            this.A0 = m60Var.h();
                            this.X |= 16;
                            break;
                        case 58:
                            this.C0 = m60Var.h();
                            this.X |= 64;
                            break;
                        case 66:
                            ue1 ue1Var = this.G0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    er0Var = this.F0;
                                    if (er0Var == null) {
                                        er0Var = er0.M0;
                                    }
                                } else {
                                    er0Var = (er0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(er0Var, K(), this.z);
                                this.G0 = ue1Var2;
                                this.F0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.X |= 512;
                            break;
                        case 72:
                            this.D0 = m60Var.o();
                            this.X |= 128;
                            break;
                        case 82:
                            this.E0 = m60Var.h();
                            this.X |= 256;
                            break;
                        case 136:
                            this.H0 = m60Var.g();
                            this.X |= 1024;
                            break;
                        default:
                            if (!u().t(iS, m60Var)) {
                                z = true;
                            }
                            break;
                    }
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
        return rq0.I0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        rq0 rq0VarQ = q();
        if (rq0VarQ.c()) {
            return rq0VarQ;
        }
        throw a1.C(rq0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        er0 er0Var;
        if ((this.X & 512) == 0) {
            return true;
        }
        ue1 ue1Var = this.G0;
        if (ue1Var == null) {
            er0Var = this.F0;
            if (er0Var == null) {
                er0Var = er0.M0;
            }
        } else {
            er0Var = (er0) ue1Var.l();
        }
        return er0Var.c();
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.M0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        rq0 rq0VarQ = q();
        if (rq0VarQ.c()) {
            return rq0VarQ;
        }
        throw a1.C(rq0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof rq0) {
            V((rq0) c1Var);
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
        if (c1Var instanceof rq0) {
            V((rq0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
