package defpackage;

import io.netty.handler.ssl.OpenSslSessionTicketKey;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xe4 extends kn1 {
    public static final o84 V0 = new o84(2);
    public static final d84 W0 = new d84(2);
    public int B0;
    public int C0;
    public int D0;
    public int G0;
    public ow3 H0;
    public ue1 I0;
    public List K0;
    public List L0;
    public qg2 M0;
    public qg2 N0;
    public List O0;
    public List P0;
    public List Q0;
    public int R0;
    public boolean S0;
    public p14 T0;
    public ue1 U0;
    public int X;
    public int Y = 0;
    public int Z = 0;
    public String y0 = "";
    public String z0 = "";
    public String A0 = "";
    public String E0 = "";
    public g92 F0 = g92.z;
    public String J0 = "";

    public xe4() {
        List list = Collections.EMPTY_LIST;
        this.K0 = list;
        this.L0 = list;
        this.O0 = list;
        this.P0 = list;
        this.Q0 = list;
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.H0;
        vn1Var.a(af4.class, xe4.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.kn1
    public final ye N(int i) {
        if (i == 16) {
            qg2 qg2Var = this.M0;
            return qg2Var == null ? new qg2(V0) : qg2Var;
        }
        if (i == 25) {
            qg2 qg2Var2 = this.N0;
            return qg2Var2 == null ? new qg2(W0) : qg2Var2;
        }
        zo2.w(dw2.A(i, "Invalid map field number: "));
        return null;
    }

    @Override // defpackage.kn1
    public final ye O(int i) {
        if (i == 16) {
            return W();
        }
        if (i == 25) {
            return V();
        }
        zo2.w(dw2.A(i, "Invalid map field number: "));
        return null;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final af4 q() {
        af4 af4Var = new af4(this);
        int i = 0;
        af4Var.Y = 0;
        af4Var.Z = 0;
        af4Var.y0 = "";
        af4Var.z0 = "";
        af4Var.A0 = "";
        af4Var.B0 = 0;
        af4Var.C0 = 0;
        af4Var.D0 = 0;
        af4Var.E0 = "";
        af4Var.F0 = g92.z;
        af4Var.G0 = 0;
        af4Var.I0 = "";
        af4Var.Q0 = 0;
        af4Var.R0 = false;
        af4Var.T0 = (byte) -1;
        if ((this.X & 8192) != 0) {
            this.K0 = DesugarCollections.unmodifiableList(this.K0);
            this.X &= -8193;
        }
        af4Var.J0 = this.K0;
        if ((this.X & 16384) != 0) {
            this.L0 = DesugarCollections.unmodifiableList(this.L0);
            this.X &= -16385;
        }
        af4Var.K0 = this.L0;
        if ((this.X & 131072) != 0) {
            this.O0 = DesugarCollections.unmodifiableList(this.O0);
            this.X &= -131073;
        }
        af4Var.N0 = this.O0;
        if ((this.X & 262144) != 0) {
            this.P0 = DesugarCollections.unmodifiableList(this.P0);
            this.X &= -262145;
        }
        af4Var.O0 = this.P0;
        if ((this.X & 524288) != 0) {
            this.Q0 = DesugarCollections.unmodifiableList(this.Q0);
            this.X &= -524289;
        }
        af4Var.P0 = this.Q0;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                af4Var.Y = this.Y;
            }
            if ((i2 & 2) != 0) {
                af4Var.Z = this.Z;
            }
            if ((i2 & 4) != 0) {
                af4Var.y0 = this.y0;
            }
            if ((i2 & 8) != 0) {
                af4Var.z0 = this.z0;
            }
            if ((i2 & 16) != 0) {
                af4Var.A0 = this.A0;
            }
            if ((i2 & 32) != 0) {
                af4Var.B0 = this.B0;
            }
            if ((i2 & 64) != 0) {
                af4Var.C0 = this.C0;
            }
            if ((i2 & 128) != 0) {
                af4Var.D0 = this.D0;
            }
            if ((i2 & 256) != 0) {
                af4Var.E0 = this.E0;
            }
            if ((i2 & 512) != 0) {
                this.F0.b();
                af4Var.F0 = this.F0;
            }
            if ((i2 & 1024) != 0) {
                af4Var.G0 = this.G0;
            }
            if ((i2 & 2048) != 0) {
                ue1 ue1Var = this.I0;
                af4Var.H0 = ue1Var == null ? this.H0 : (ow3) ue1Var.b();
                i = 1;
            }
            if ((i2 & 4096) != 0) {
                af4Var.I0 = this.J0;
            }
            if ((32768 & i2) != 0) {
                qg2 qg2Var = this.M0;
                if (qg2Var == null) {
                    qg2Var = new qg2(V0);
                }
                af4Var.L0 = qg2Var.X(ze4.a);
            }
            if ((65536 & i2) != 0) {
                qg2 qg2Var2 = this.N0;
                if (qg2Var2 == null) {
                    qg2Var2 = new qg2(W0);
                }
                af4Var.M0 = qg2Var2.X(ye4.a);
            }
            if ((1048576 & i2) != 0) {
                af4Var.Q0 = this.R0;
            }
            if ((2097152 & i2) != 0) {
                af4Var.R0 = this.S0;
            }
            if ((i2 & 4194304) != 0) {
                ue1 ue1Var2 = this.U0;
                af4Var.S0 = ue1Var2 == null ? this.T0 : (p14) ue1Var2.b();
                i |= 2;
            }
            af4Var.X = i | af4Var.X;
        }
        R();
        return af4Var;
    }

    public final qg2 V() {
        if (this.N0 == null) {
            this.N0 = new qg2(W0);
        }
        this.X |= 65536;
        S();
        return this.N0;
    }

    public final qg2 W() {
        if (this.M0 == null) {
            this.M0 = new qg2(V0);
        }
        this.X |= 32768;
        S();
        return this.M0;
    }

    public final ue1 X() {
        ow3 ow3Var;
        ue1 ue1Var = this.I0;
        if (ue1Var != null) {
            return ue1Var;
        }
        if (ue1Var == null) {
            ow3Var = this.H0;
            if (ow3Var == null) {
                ow3Var = ow3.H0;
            }
        } else {
            ow3Var = (ow3) ue1Var.l();
        }
        ue1 ue1Var2 = new ue1(ow3Var, K(), this.z);
        this.I0 = ue1Var2;
        this.H0 = null;
        return ue1Var2;
    }

    public final ue1 Y() {
        p14 p14Var;
        ue1 ue1Var = this.U0;
        if (ue1Var != null) {
            return ue1Var;
        }
        if (ue1Var == null) {
            p14Var = this.T0;
            if (p14Var == null) {
                p14Var = p14.y0;
            }
        } else {
            p14Var = (p14) ue1Var.l();
        }
        ue1 ue1Var2 = new ue1(p14Var, K(), this.z);
        this.U0 = ue1Var2;
        this.T0 = null;
        return ue1Var2;
    }

    public final void Z(af4 af4Var) {
        p14 p14Var;
        ow3 ow3Var;
        if (af4Var == af4.U0) {
            return;
        }
        int i = af4Var.Y;
        if (i != 0) {
            this.Y = i;
            this.X |= 1;
            S();
        }
        int i2 = af4Var.Z;
        if (i2 != 0) {
            this.Z = i2;
            this.X |= 2;
            S();
        }
        if (!af4Var.J().isEmpty()) {
            this.y0 = af4Var.y0;
            this.X |= 4;
            S();
        }
        if (!af4Var.K().isEmpty()) {
            this.z0 = af4Var.z0;
            this.X |= 8;
            S();
        }
        if (!af4Var.P().isEmpty()) {
            this.A0 = af4Var.A0;
            this.X |= 16;
            S();
        }
        int i3 = af4Var.B0;
        if (i3 != 0) {
            this.B0 = i3;
            this.X |= 32;
            S();
        }
        int i4 = af4Var.C0;
        if (i4 != 0) {
            this.C0 = i4;
            this.X |= 64;
            S();
        }
        int i5 = af4Var.D0;
        if (i5 != 0) {
            this.D0 = i5;
            this.X |= 128;
            S();
        }
        if (!af4Var.L().isEmpty()) {
            this.E0 = af4Var.E0;
            this.X |= 256;
            S();
        }
        if (!af4Var.F0.isEmpty()) {
            if (this.F0.isEmpty()) {
                this.F0 = af4Var.F0;
                this.X |= 512;
            } else {
                g92 g92Var = this.F0;
                if (!g92Var.b) {
                    g92Var = new g92(this.F0);
                    this.F0 = g92Var;
                }
                this.X |= 512;
                g92Var.addAll(af4Var.F0);
            }
            S();
        }
        int i6 = af4Var.G0;
        if (i6 != 0) {
            this.G0 = i6;
            this.X |= 1024;
            S();
        }
        if ((af4Var.X & 1) != 0) {
            ow3 ow3VarN = af4Var.N();
            ue1 ue1Var = this.I0;
            if (ue1Var == null) {
                int i7 = this.X;
                if ((i7 & 2048) == 0 || (ow3Var = this.H0) == null || ow3Var == ow3.H0) {
                    this.H0 = ow3VarN;
                } else {
                    this.X = i7 | 2048;
                    S();
                    ((nw3) X().j()).W(ow3VarN);
                }
            } else {
                ue1Var.o(ow3VarN);
            }
            if (this.H0 != null) {
                this.X |= 2048;
                S();
            }
        }
        if (!af4Var.H().isEmpty()) {
            this.J0 = af4Var.I0;
            this.X |= 4096;
            S();
        }
        if (!af4Var.J0.isEmpty()) {
            if (this.K0.isEmpty()) {
                this.K0 = af4Var.J0;
                this.X &= -8193;
            } else {
                if ((this.X & 8192) == 0) {
                    this.K0 = new ArrayList(this.K0);
                    this.X |= 8192;
                }
                this.K0.addAll(af4Var.J0);
            }
            S();
        }
        if (!af4Var.K0.isEmpty()) {
            if (this.L0.isEmpty()) {
                this.L0 = af4Var.K0;
                this.X &= -16385;
            } else {
                if ((this.X & 16384) == 0) {
                    this.L0 = new ArrayList(this.L0);
                    this.X |= 16384;
                }
                this.L0.addAll(af4Var.K0);
            }
            S();
        }
        W().a0(af4Var.S());
        this.X |= 32768;
        V().a0(af4Var.R());
        this.X |= 65536;
        if (!af4Var.N0.isEmpty()) {
            if (this.O0.isEmpty()) {
                this.O0 = af4Var.N0;
                this.X &= -131073;
            } else {
                if ((this.X & 131072) == 0) {
                    this.O0 = new ArrayList(this.O0);
                    this.X |= 131072;
                }
                this.O0.addAll(af4Var.N0);
            }
            S();
        }
        if (!af4Var.O0.isEmpty()) {
            if (this.P0.isEmpty()) {
                this.P0 = af4Var.O0;
                this.X &= -262145;
            } else {
                if ((this.X & 262144) == 0) {
                    this.P0 = new ArrayList(this.P0);
                    this.X |= 262144;
                }
                this.P0.addAll(af4Var.O0);
            }
            S();
        }
        if (!af4Var.P0.isEmpty()) {
            if (this.Q0.isEmpty()) {
                this.Q0 = af4Var.P0;
                this.X &= -524289;
            } else {
                if ((this.X & 524288) == 0) {
                    this.Q0 = new ArrayList(this.Q0);
                    this.X |= 524288;
                }
                this.Q0.addAll(af4Var.P0);
            }
            S();
        }
        int i8 = af4Var.Q0;
        if (i8 != 0) {
            this.R0 = i8;
            this.X |= 1048576;
            S();
        }
        boolean z = af4Var.R0;
        if (z) {
            this.S0 = z;
            this.X |= 2097152;
            S();
        }
        if (af4Var.Q()) {
            p14 p14VarO = af4Var.O();
            ue1 ue1Var2 = this.U0;
            if (ue1Var2 == null) {
                int i9 = this.X;
                if ((i9 & 4194304) == 0 || (p14Var = this.T0) == null || p14Var == p14.y0) {
                    this.T0 = p14VarO;
                } else {
                    this.X = i9 | 4194304;
                    S();
                    ((o14) Y().j()).V(p14VarO);
                }
            } else {
                ue1Var2.o(p14VarO);
            }
            if (this.T0 != null) {
                this.X |= 4194304;
                S();
            }
        }
        A(af4Var.z);
        S();
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return af4.U0;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
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
                            this.y0 = m60Var.r();
                            this.X |= 4;
                            break;
                        case 26:
                            this.z0 = m60Var.r();
                            this.X |= 8;
                            break;
                        case 34:
                            this.A0 = m60Var.r();
                            this.X |= 16;
                            break;
                        case 40:
                            this.B0 = m60Var.o();
                            this.X |= 32;
                            break;
                        case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            this.C0 = m60Var.o();
                            this.X |= 64;
                            break;
                        case 56:
                            this.D0 = m60Var.o();
                            this.X |= 128;
                            break;
                        case 66:
                            this.E0 = m60Var.r();
                            this.X |= 256;
                            break;
                        case 74:
                            String strR = m60Var.r();
                            g92 g92Var = this.F0;
                            if (!g92Var.b) {
                                g92Var = new g92(this.F0);
                                this.F0 = g92Var;
                            }
                            this.X |= 512;
                            g92Var.e(strR);
                            break;
                        case 82:
                            m60Var.k(X().j(), o91Var);
                            this.X |= 2048;
                            break;
                        case 114:
                            this.J0 = m60Var.r();
                            this.X |= 4096;
                            break;
                        case 122:
                            l20 l20Var = (l20) m60Var.j(l20.A0, o91Var);
                            if ((this.X & 16384) == 0) {
                                this.L0 = new ArrayList(this.L0);
                                this.X |= 16384;
                            }
                            this.L0.add(l20Var);
                            break;
                        case 130:
                            ig2 ig2Var = (ig2) m60Var.j((hg2) ze4.a.X.Z, o91Var);
                            W().Y().put((Integer) ig2Var.z, (sd4) ig2Var.A);
                            this.X |= 32768;
                            break;
                        case 138:
                            fk2 fk2Var = (fk2) m60Var.j(fk2.G0, o91Var);
                            if ((this.X & 131072) == 0) {
                                this.O0 = new ArrayList(this.O0);
                                this.X |= 131072;
                            }
                            this.O0.add(fk2Var);
                            break;
                        case 146:
                            ee2 ee2Var = (ee2) m60Var.j(ee2.z0, o91Var);
                            if ((this.X & 262144) == 0) {
                                this.P0 = new ArrayList(this.P0);
                                this.X |= 262144;
                            }
                            this.P0.add(ee2Var);
                            break;
                        case 154:
                            sa1 sa1Var = (sa1) m60Var.j(sa1.B0, o91Var);
                            if ((this.X & 524288) == 0) {
                                this.Q0 = new ArrayList(this.Q0);
                                this.X |= 524288;
                            }
                            this.Q0.add(sa1Var);
                            break;
                        case 160:
                            this.G0 = m60Var.o();
                            this.X |= 1024;
                            break;
                        case 170:
                            yf0 yf0Var = (yf0) m60Var.j(yf0.z0, o91Var);
                            if ((this.X & 8192) == 0) {
                                this.K0 = new ArrayList(this.K0);
                                this.X |= 8192;
                            }
                            this.K0.add(yf0Var);
                            break;
                        case 176:
                            this.R0 = m60Var.o();
                            this.X |= 1048576;
                            break;
                        case 184:
                            this.S0 = m60Var.g();
                            this.X |= 2097152;
                            break;
                        case 192:
                            this.Z = m60Var.o();
                            this.X |= 2;
                            break;
                        case 202:
                            ig2 ig2Var2 = (ig2) m60Var.j((hg2) ye4.a.X.Z, o91Var);
                            V().Y().put((Integer) ig2Var2.z, (sd4) ig2Var2.A);
                            this.X |= 65536;
                            break;
                        case 210:
                            m60Var.k(Y().j(), o91Var);
                            this.X |= 4194304;
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

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        af4 af4VarQ = q();
        if (af4VarQ.c()) {
            return af4VarQ;
        }
        throw a1.C(af4VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.G0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        af4 af4VarQ = q();
        if (af4VarQ.c()) {
            return af4VarQ;
        }
        throw a1.C(af4VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof af4) {
            Z((af4) c1Var);
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
        if (c1Var instanceof af4) {
            Z((af4) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
