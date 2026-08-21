package defpackage;

import io.netty.handler.ssl.OpenSslSessionTicketKey;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s93 extends kn1 {
    public int B0;
    public int D0;
    public int E0;
    public int X;
    public int Y;
    public int Z;
    public int y0;
    public String z0 = "";
    public String A0 = "";
    public String C0 = "";
    public String F0 = "";
    public String G0 = "";
    public String H0 = "";
    public String I0 = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = u93.F0;
        vn1Var.a(t93.class, s93.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final t93 q() {
        t93 t93Var = new t93(this);
        t93Var.X = 0;
        t93Var.Y = 0;
        t93Var.Z = 0;
        t93Var.y0 = "";
        t93Var.z0 = "";
        t93Var.A0 = 0;
        t93Var.B0 = "";
        t93Var.C0 = 0;
        t93Var.D0 = 0;
        t93Var.E0 = "";
        t93Var.F0 = "";
        t93Var.G0 = "";
        t93Var.H0 = "";
        t93Var.I0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                t93Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                t93Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                t93Var.Z = this.y0;
            }
            if ((i & 8) != 0) {
                t93Var.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                t93Var.z0 = this.A0;
            }
            if ((i & 32) != 0) {
                t93Var.A0 = this.B0;
            }
            if ((i & 64) != 0) {
                t93Var.B0 = this.C0;
            }
            if ((i & 128) != 0) {
                t93Var.C0 = this.D0;
            }
            if ((i & 256) != 0) {
                t93Var.D0 = this.E0;
            }
            if ((i & 512) != 0) {
                t93Var.E0 = this.F0;
            }
            if ((i & 1024) != 0) {
                t93Var.F0 = this.G0;
            }
            if ((i & 2048) != 0) {
                t93Var.G0 = this.H0;
            }
            if ((i & 4096) != 0) {
                t93Var.H0 = this.I0;
            }
        }
        R();
        return t93Var;
    }

    public final void V(t93 t93Var) {
        if (t93Var == t93.J0) {
            return;
        }
        int i = t93Var.X;
        if (i != 0) {
            this.Y = i;
            this.X |= 1;
            S();
        }
        int i2 = t93Var.Y;
        if (i2 != 0) {
            this.Z = i2;
            this.X |= 2;
            S();
        }
        int i3 = t93Var.Z;
        if (i3 != 0) {
            this.y0 = i3;
            this.X |= 4;
            S();
        }
        if (!t93Var.J().isEmpty()) {
            this.z0 = t93Var.y0;
            this.X |= 8;
            S();
        }
        if (!t93Var.O().isEmpty()) {
            this.A0 = t93Var.z0;
            this.X |= 16;
            S();
        }
        int i4 = t93Var.A0;
        if (i4 != 0) {
            this.B0 = i4;
            this.X |= 32;
            S();
        }
        if (!t93Var.H().isEmpty()) {
            this.C0 = t93Var.B0;
            this.X |= 64;
            S();
        }
        int i5 = t93Var.C0;
        if (i5 != 0) {
            this.D0 = i5;
            this.X |= 128;
            S();
        }
        int i6 = t93Var.D0;
        if (i6 != 0) {
            this.E0 = i6;
            this.X |= 256;
            S();
        }
        if (!t93Var.N().isEmpty()) {
            this.F0 = t93Var.E0;
            this.X |= 512;
            S();
        }
        if (!t93Var.L().isEmpty()) {
            this.G0 = t93Var.F0;
            this.X |= 1024;
            S();
        }
        if (!t93Var.K().isEmpty()) {
            this.H0 = t93Var.G0;
            this.X |= 2048;
            S();
        }
        if (!t93Var.P().isEmpty()) {
            this.I0 = t93Var.H0;
            this.X |= 4096;
            S();
        }
        A(t93Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
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
                        case 16:
                            this.Z = m60Var.o();
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
                        case 42:
                            this.A0 = m60Var.r();
                            this.X |= 16;
                            break;
                        case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            this.B0 = m60Var.o();
                            this.X |= 32;
                            break;
                        case 58:
                            this.C0 = m60Var.r();
                            this.X |= 64;
                            break;
                        case 64:
                            this.D0 = m60Var.o();
                            this.X |= 128;
                            break;
                        case 72:
                            this.E0 = m60Var.o();
                            this.X |= 256;
                            break;
                        case 82:
                            this.F0 = m60Var.r();
                            this.X |= 512;
                            break;
                        case 90:
                            this.G0 = m60Var.r();
                            this.X |= 1024;
                            break;
                        case 98:
                            this.H0 = m60Var.r();
                            this.X |= 2048;
                            break;
                        case 106:
                            this.I0 = m60Var.r();
                            this.X |= 4096;
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
        return t93.J0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        t93 t93VarQ = q();
        if (t93VarQ.c()) {
            return t93VarQ;
        }
        throw a1.C(t93VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return u93.E0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        t93 t93VarQ = q();
        if (t93VarQ.c()) {
            return t93VarQ;
        }
        throw a1.C(t93VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof t93) {
            V((t93) c1Var);
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
        if (c1Var instanceof t93) {
            V((t93) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
