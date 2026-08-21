package defpackage;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jr0 extends ln1 {
    public boolean A0;
    public boolean B0;
    public boolean E0;
    public boolean F0;
    public boolean G0;
    public boolean H0;
    public gq0 Q0;
    public ue1 R0;
    public int Y;
    public boolean z0;
    public Serializable Z = "";
    public Serializable y0 = "";
    public int C0 = 1;
    public Serializable D0 = "";
    public boolean I0 = true;
    public Serializable J0 = "";
    public Serializable K0 = "";
    public Serializable L0 = "";
    public Serializable M0 = "";
    public Serializable N0 = "";
    public Serializable O0 = "";
    public Serializable P0 = "";
    public List S0 = Collections.EMPTY_LIST;

    public jr0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.b1;
        vn1Var.a(lr0.class, jr0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final lr0 q() {
        lr0 lr0Var = new lr0(this);
        lr0Var.Z = "";
        lr0Var.y0 = "";
        int i = 0;
        lr0Var.z0 = false;
        lr0Var.A0 = false;
        lr0Var.B0 = false;
        lr0Var.C0 = 1;
        lr0Var.D0 = "";
        lr0Var.E0 = false;
        lr0Var.F0 = false;
        lr0Var.G0 = false;
        lr0Var.H0 = false;
        lr0Var.I0 = true;
        lr0Var.J0 = "";
        lr0Var.K0 = "";
        lr0Var.L0 = "";
        lr0Var.M0 = "";
        lr0Var.N0 = "";
        lr0Var.O0 = "";
        lr0Var.P0 = "";
        lr0Var.S0 = (byte) -1;
        if ((this.Y & 1048576) != 0) {
            this.S0 = DesugarCollections.unmodifiableList(this.S0);
            this.Y &= -1048577;
        }
        lr0Var.R0 = this.S0;
        int i2 = this.Y;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                lr0Var.Z = this.Z;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                lr0Var.y0 = this.y0;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                lr0Var.z0 = this.z0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                lr0Var.A0 = this.A0;
                i |= 8;
            }
            if ((i2 & 16) != 0) {
                lr0Var.B0 = this.B0;
                i |= 16;
            }
            if ((i2 & 32) != 0) {
                lr0Var.C0 = this.C0;
                i |= 32;
            }
            if ((i2 & 64) != 0) {
                lr0Var.D0 = this.D0;
                i |= 64;
            }
            if ((i2 & 128) != 0) {
                lr0Var.E0 = this.E0;
                i |= 128;
            }
            if ((i2 & 256) != 0) {
                lr0Var.F0 = this.F0;
                i |= 256;
            }
            if ((i2 & 512) != 0) {
                lr0Var.G0 = this.G0;
                i |= 512;
            }
            if ((i2 & 1024) != 0) {
                lr0Var.H0 = this.H0;
                i |= 1024;
            }
            if ((i2 & 2048) != 0) {
                lr0Var.I0 = this.I0;
                i |= 2048;
            }
            if ((i2 & 4096) != 0) {
                lr0Var.J0 = this.J0;
                i |= 4096;
            }
            if ((i2 & 8192) != 0) {
                lr0Var.K0 = this.K0;
                i |= 8192;
            }
            if ((i2 & 16384) != 0) {
                lr0Var.L0 = this.L0;
                i |= 16384;
            }
            if ((i2 & 32768) != 0) {
                lr0Var.M0 = this.M0;
                i |= 32768;
            }
            if ((i2 & 65536) != 0) {
                lr0Var.N0 = this.N0;
                i |= 65536;
            }
            if ((i2 & 131072) != 0) {
                lr0Var.O0 = this.O0;
                i |= 131072;
            }
            if ((i2 & 262144) != 0) {
                lr0Var.P0 = this.P0;
                i |= 262144;
            }
            if ((i2 & 524288) != 0) {
                ue1 ue1Var = this.R0;
                lr0Var.Q0 = ue1Var == null ? this.Q0 : (gq0) ue1Var.b();
                i |= 524288;
            }
            lr0Var.Y |= i;
        }
        R();
        return lr0Var;
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return lr0.T0;
    }

    public final void a0(lr0 lr0Var) {
        gq0 gq0Var;
        gq0 gq0Var2;
        kr0 kr0Var;
        if (lr0Var == lr0.T0) {
            return;
        }
        if ((lr0Var.Y & 1) != 0) {
            this.Z = lr0Var.Z;
            this.Y |= 1;
            S();
        }
        if (lr0Var.f0()) {
            this.y0 = lr0Var.y0;
            this.Y |= 2;
            S();
        }
        if (lr0Var.e0()) {
            this.z0 = lr0Var.z0;
            this.Y |= 4;
            S();
        }
        if (lr0Var.c0()) {
            this.A0 = lr0Var.A0;
            this.Y |= 8;
            S();
        }
        if (lr0Var.g0()) {
            this.B0 = lr0Var.B0;
            this.Y |= 16;
            S();
        }
        if (lr0Var.i0()) {
            int i = lr0Var.C0;
            if (i == 1) {
                kr0Var = kr0.SPEED;
            } else if (i == 2) {
                kr0Var = kr0.CODE_SIZE;
            } else if (i != 3) {
                kr0 kr0Var2 = kr0.SPEED;
                kr0Var = null;
            } else {
                kr0Var = kr0.LITE_RUNTIME;
            }
            if (kr0Var == null) {
                kr0Var = kr0.SPEED;
            }
            this.Y |= 32;
            this.C0 = kr0Var.b;
            S();
        }
        if (lr0Var.b0()) {
            this.D0 = lr0Var.D0;
            this.Y |= 64;
            S();
        }
        if (lr0Var.X()) {
            this.E0 = lr0Var.E0;
            this.Y |= 128;
            S();
        }
        if (lr0Var.d0()) {
            this.F0 = lr0Var.F0;
            this.Y |= 256;
            S();
        }
        if (lr0Var.m0()) {
            this.G0 = lr0Var.G0;
            this.Y |= 512;
            S();
        }
        if (lr0Var.Z()) {
            this.H0 = lr0Var.H0;
            this.Y |= 1024;
            S();
        }
        if (lr0Var.W()) {
            this.I0 = lr0Var.I0;
            this.Y |= 2048;
            S();
        }
        if (lr0Var.h0()) {
            this.J0 = lr0Var.J0;
            this.Y |= 4096;
            S();
        }
        if (lr0Var.Y()) {
            this.K0 = lr0Var.K0;
            this.Y |= 8192;
            S();
        }
        if (lr0Var.o0()) {
            this.L0 = lr0Var.L0;
            this.Y |= 16384;
            S();
        }
        if (lr0Var.j0()) {
            this.M0 = lr0Var.M0;
            this.Y |= 32768;
            S();
        }
        if (lr0Var.l0()) {
            this.N0 = lr0Var.N0;
            this.Y |= 65536;
            S();
        }
        if (lr0Var.k0()) {
            this.O0 = lr0Var.O0;
            this.Y |= 131072;
            S();
        }
        if (lr0Var.n0()) {
            this.P0 = lr0Var.P0;
            this.Y |= 262144;
            S();
        }
        if (lr0Var.a0()) {
            gq0 gq0VarL = lr0Var.L();
            ue1 ue1Var = this.R0;
            if (ue1Var == null) {
                int i2 = this.Y;
                if ((i2 & 524288) == 0 || (gq0Var = this.Q0) == null || gq0Var == (gq0Var2 = gq0.G0)) {
                    this.Q0 = gq0VarL;
                } else {
                    this.Y = i2 | 524288;
                    S();
                    ue1 ue1Var2 = this.R0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            gq0 gq0Var3 = this.Q0;
                            if (gq0Var3 != null) {
                                gq0Var2 = gq0Var3;
                            }
                        } else {
                            gq0Var2 = (gq0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(gq0Var2, K(), this.z);
                        this.R0 = ue1Var3;
                        this.Q0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((xp0) ue1Var2.j()).b0(gq0VarL);
                }
            } else {
                ue1Var.o(gq0VarL);
            }
            if (this.Q0 != null) {
                this.Y |= 524288;
                S();
            }
        }
        if (!lr0Var.R0.isEmpty()) {
            if (this.S0.isEmpty()) {
                this.S0 = lr0Var.R0;
                this.Y &= -1048577;
            } else {
                if ((this.Y & 1048576) == 0) {
                    this.S0 = new ArrayList(this.S0);
                    this.Y |= 1048576;
                }
                this.S0.addAll(lr0Var.R0);
            }
            S();
        }
        W(lr0Var);
        A(lr0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        gq0 gq0Var;
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    kr0 kr0Var = null;
                    switch (iS) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            this.Z = m60Var.h();
                            this.Y |= 1;
                            break;
                        case 66:
                            this.y0 = m60Var.h();
                            this.Y |= 2;
                            break;
                        case 72:
                            int iO = m60Var.o();
                            if (iO == 1) {
                                kr0Var = kr0.SPEED;
                            } else if (iO == 2) {
                                kr0Var = kr0.CODE_SIZE;
                            } else if (iO != 3) {
                                kr0 kr0Var2 = kr0.SPEED;
                            } else {
                                kr0Var = kr0.LITE_RUNTIME;
                            }
                            if (kr0Var == null) {
                                Q(9, iO);
                            } else {
                                this.C0 = iO;
                                this.Y |= 32;
                            }
                            break;
                        case 80:
                            this.z0 = m60Var.g();
                            this.Y |= 4;
                            break;
                        case 90:
                            this.D0 = m60Var.h();
                            this.Y |= 64;
                            break;
                        case 128:
                            this.E0 = m60Var.g();
                            this.Y |= 128;
                            break;
                        case 136:
                            this.F0 = m60Var.g();
                            this.Y |= 256;
                            break;
                        case 144:
                            this.G0 = m60Var.g();
                            this.Y |= 512;
                            break;
                        case 160:
                            this.A0 = m60Var.g();
                            this.Y |= 8;
                            break;
                        case 184:
                            this.H0 = m60Var.g();
                            this.Y |= 1024;
                            break;
                        case 216:
                            this.B0 = m60Var.g();
                            this.Y |= 16;
                            break;
                        case 248:
                            this.I0 = m60Var.g();
                            this.Y |= 2048;
                            break;
                        case 290:
                            this.J0 = m60Var.h();
                            this.Y |= 4096;
                            break;
                        case 298:
                            this.K0 = m60Var.h();
                            this.Y |= 8192;
                            break;
                        case 314:
                            this.L0 = m60Var.h();
                            this.Y |= 16384;
                            break;
                        case 322:
                            this.M0 = m60Var.h();
                            this.Y |= 32768;
                            break;
                        case 330:
                            this.N0 = m60Var.h();
                            this.Y |= 65536;
                            break;
                        case 354:
                            this.O0 = m60Var.h();
                            this.Y |= 131072;
                            break;
                        case 362:
                            this.P0 = m60Var.h();
                            this.Y |= 262144;
                            break;
                        case 402:
                            ue1 ue1Var = this.R0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    gq0Var = this.Q0;
                                    if (gq0Var == null) {
                                        gq0Var = gq0.G0;
                                    }
                                } else {
                                    gq0Var = (gq0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(gq0Var, K(), this.z);
                                this.R0 = ue1Var2;
                                this.Q0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.Y |= 524288;
                            break;
                        case 7994:
                            us0 us0Var = (us0) m60Var.j(us0.F0, o91Var);
                            if ((this.Y & 1048576) == 0) {
                                this.S0 = new ArrayList(this.S0);
                                this.Y |= 1048576;
                            }
                            this.S0.add(us0Var);
                            break;
                        default:
                            if (!X(m60Var, o91Var, iS)) {
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
        lr0 lr0VarQ = q();
        if (lr0VarQ.c()) {
            return lr0VarQ;
        }
        throw a1.C(lr0VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    @Override // defpackage.ol2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c() {
        gq0 gq0Var;
        if ((this.Y & 524288) == 0) {
            int i = 0;
            while (true) {
                if (i >= this.S0.size()) {
                    if (!V()) {
                        break;
                    }
                    return true;
                }
                if (!((us0) this.S0.get(i)).c()) {
                    break;
                }
                i++;
            }
        } else {
            ue1 ue1Var = this.R0;
            if (ue1Var == null) {
                gq0Var = this.Q0;
                if (gq0Var == null) {
                    gq0Var = gq0.G0;
                }
            } else {
                gq0Var = (gq0) ue1Var.l();
            }
            if (gq0Var.c()) {
            }
        }
        return false;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.a1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        lr0 lr0VarQ = q();
        if (lr0VarQ.c()) {
            return lr0VarQ;
        }
        throw a1.C(lr0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof lr0) {
            a0((lr0) c1Var);
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
        if (c1Var instanceof lr0) {
            a0((lr0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
