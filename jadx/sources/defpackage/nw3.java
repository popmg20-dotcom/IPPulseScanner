package defpackage;

import io.netty.handler.ssl.OpenSslSessionTicketKey;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nw3 extends kn1 {
    public boolean A0;
    public int B0;
    public int C0;
    public boolean D0;
    public long E0;
    public xj2 F0;
    public ue1 G0;
    public int X;
    public int Y;
    public int y0;
    public String Z = "";
    public String z0 = "";

    public nw3() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.L0;
        vn1Var.a(ow3.class, nw3.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ow3 q() {
        ow3 ow3Var = new ow3(this);
        int i = 0;
        ow3Var.Y = 0;
        ow3Var.Z = "";
        ow3Var.y0 = 0;
        ow3Var.z0 = "";
        ow3Var.A0 = false;
        ow3Var.B0 = 0;
        ow3Var.C0 = 0;
        ow3Var.D0 = false;
        ow3Var.E0 = 0L;
        ow3Var.G0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                ow3Var.Y = this.Y;
            }
            if ((i2 & 2) != 0) {
                ow3Var.Z = this.Z;
            }
            if ((i2 & 4) != 0) {
                ow3Var.y0 = this.y0;
            }
            if ((i2 & 8) != 0) {
                ow3Var.z0 = this.z0;
            }
            if ((i2 & 16) != 0) {
                ow3Var.A0 = this.A0;
            }
            if ((i2 & 32) != 0) {
                ow3Var.B0 = this.B0;
            }
            if ((i2 & 64) != 0) {
                ow3Var.C0 = this.C0;
            }
            if ((i2 & 128) != 0) {
                ow3Var.D0 = this.D0;
            }
            if ((i2 & 256) != 0) {
                ow3Var.E0 = this.E0;
            }
            if ((i2 & 512) != 0) {
                ue1 ue1Var = this.G0;
                ow3Var.F0 = ue1Var == null ? this.F0 : (xj2) ue1Var.b();
                i = 1;
            }
            ow3Var.X = i | ow3Var.X;
        }
        R();
        return ow3Var;
    }

    public final ue1 V() {
        xj2 xj2Var;
        ue1 ue1Var = this.G0;
        if (ue1Var != null) {
            return ue1Var;
        }
        if (ue1Var == null) {
            xj2Var = this.F0;
            if (xj2Var == null) {
                xj2Var = xj2.C0;
            }
        } else {
            xj2Var = (xj2) ue1Var.l();
        }
        ue1 ue1Var2 = new ue1(xj2Var, K(), this.z);
        this.G0 = ue1Var2;
        this.F0 = null;
        return ue1Var2;
    }

    public final void W(ow3 ow3Var) {
        xj2 xj2Var;
        if (ow3Var == ow3.H0) {
            return;
        }
        int i = ow3Var.Y;
        if (i != 0) {
            this.Y = i;
            this.X |= 1;
            S();
        }
        if (!ow3Var.K().isEmpty()) {
            this.Z = ow3Var.Z;
            this.X |= 2;
            S();
        }
        int i2 = ow3Var.y0;
        if (i2 != 0) {
            this.y0 = i2;
            this.X |= 4;
            S();
        }
        if (!ow3Var.H().isEmpty()) {
            this.z0 = ow3Var.z0;
            this.X |= 8;
            S();
        }
        boolean z = ow3Var.A0;
        if (z) {
            this.A0 = z;
            this.X |= 16;
            S();
        }
        int i3 = ow3Var.B0;
        if (i3 != 0) {
            this.B0 = i3;
            this.X |= 32;
            S();
        }
        int i4 = ow3Var.C0;
        if (i4 != 0) {
            this.C0 = i4;
            this.X |= 64;
            S();
        }
        boolean z2 = ow3Var.D0;
        if (z2) {
            this.D0 = z2;
            this.X |= 128;
            S();
        }
        long j = ow3Var.E0;
        if (j != 0) {
            this.E0 = j;
            this.X |= 256;
            S();
        }
        if ((ow3Var.X & 1) != 0) {
            xj2 xj2VarJ = ow3Var.J();
            ue1 ue1Var = this.G0;
            if (ue1Var == null) {
                int i5 = this.X;
                if ((i5 & 512) == 0 || (xj2Var = this.F0) == null || xj2Var == xj2.C0) {
                    this.F0 = xj2VarJ;
                } else {
                    this.X = i5 | 512;
                    S();
                    ((wj2) V().j()).W(xj2VarJ);
                }
            } else {
                ue1Var.o(xj2VarJ);
            }
            if (this.F0 != null) {
                this.X |= 512;
                S();
            }
        }
        A(ow3Var.z);
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
                    switch (iS) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.Y = m60Var.o();
                            this.X |= 1;
                            break;
                        case 18:
                            this.Z = m60Var.r();
                            this.X |= 2;
                            break;
                        case 24:
                            this.y0 = m60Var.o();
                            this.X |= 4;
                            break;
                        case 34:
                            this.z0 = m60Var.r();
                            this.X |= 8;
                            break;
                        case 40:
                            this.A0 = m60Var.g();
                            this.X |= 16;
                            break;
                        case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            this.B0 = m60Var.o();
                            this.X |= 32;
                            break;
                        case 56:
                            this.C0 = m60Var.o();
                            this.X |= 64;
                            break;
                        case 64:
                            this.D0 = m60Var.g();
                            this.X |= 128;
                            break;
                        case 72:
                            this.E0 = m60Var.p();
                            this.X |= 256;
                            break;
                        case 82:
                            m60Var.k(V().j(), o91Var);
                            this.X |= 512;
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
        return ow3.H0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ow3 ow3VarQ = q();
        if (ow3VarQ.c()) {
            return ow3VarQ;
        }
        throw a1.C(ow3VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.K0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ow3 ow3VarQ = q();
        if (ow3VarQ.c()) {
            return ow3VarQ;
        }
        throw a1.C(ow3VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ow3) {
            W((ow3) c1Var);
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
        if (c1Var instanceof ow3) {
            W((ow3) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
