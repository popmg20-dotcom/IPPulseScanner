package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ls0 extends kn1 {
    public g92 A0;
    public int X;
    public x02 Y;
    public x02 Z;
    public Serializable y0;
    public Serializable z0;

    public ls0() {
        x02 x02Var = x02.X;
        this.Y = x02Var;
        this.Z = x02Var;
        this.y0 = "";
        this.z0 = "";
        this.A0 = g92.z;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.H1;
        vn1Var.a(ms0.class, ls0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ms0 q() {
        int i;
        ms0 ms0Var = new ms0(this);
        x02 x02Var = x02.X;
        ms0Var.Y = x02Var;
        ms0Var.Z = -1;
        ms0Var.y0 = x02Var;
        ms0Var.z0 = -1;
        ms0Var.A0 = "";
        ms0Var.B0 = "";
        ms0Var.C0 = g92.z;
        ms0Var.D0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                this.Y.b();
                ms0Var.Y = this.Y;
            }
            if ((i2 & 2) != 0) {
                this.Z.b();
                ms0Var.y0 = this.Z;
            }
            if ((i2 & 4) != 0) {
                ms0Var.A0 = this.y0;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                ms0Var.B0 = this.z0;
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                this.A0.b();
                ms0Var.C0 = this.A0;
            }
            ms0Var.X |= i;
        }
        R();
        return ms0Var;
    }

    public final void V() {
        x02 x02Var = this.Y;
        if (!x02Var.b) {
            this.Y = (x02) yn1.D(x02Var);
        }
        this.X |= 1;
    }

    public final void W() {
        x02 x02Var = this.Z;
        if (!x02Var.b) {
            this.Z = (x02) yn1.D(x02Var);
        }
        this.X |= 2;
    }

    public final void X(ms0 ms0Var) {
        if (ms0Var == ms0.E0) {
            return;
        }
        if (!ms0Var.Y.isEmpty()) {
            if (this.Y.isEmpty()) {
                x02 x02Var = ms0Var.Y;
                this.Y = x02Var;
                x02Var.b();
                this.X |= 1;
            } else {
                V();
                this.Y.addAll(ms0Var.Y);
            }
            S();
        }
        if (!ms0Var.y0.isEmpty()) {
            if (this.Z.isEmpty()) {
                x02 x02Var2 = ms0Var.y0;
                this.Z = x02Var2;
                x02Var2.b();
                this.X |= 2;
            } else {
                W();
                this.Z.addAll(ms0Var.y0);
            }
            S();
        }
        if ((ms0Var.X & 1) != 0) {
            this.y0 = ms0Var.A0;
            this.X |= 4;
            S();
        }
        if (ms0Var.K()) {
            this.z0 = ms0Var.B0;
            this.X |= 8;
            S();
        }
        if (!ms0Var.C0.isEmpty()) {
            if (this.A0.isEmpty()) {
                this.A0 = ms0Var.C0;
                this.X |= 16;
            } else {
                g92 g92Var = this.A0;
                if (!g92Var.b) {
                    g92Var = new g92(this.A0);
                    this.A0 = g92Var;
                }
                this.X |= 16;
                g92Var.addAll(ms0Var.C0);
            }
            S();
        }
        A(ms0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 8) {
                            int iO = m60Var.o();
                            V();
                            this.Y.d(iO);
                        } else if (iS == 10) {
                            int iF = m60Var.f(m60Var.o());
                            V();
                            while (m60Var.c() > 0) {
                                this.Y.d(m60Var.o());
                            }
                            m60Var.e(iF);
                        } else if (iS == 16) {
                            int iO2 = m60Var.o();
                            W();
                            this.Z.d(iO2);
                        } else if (iS == 18) {
                            int iF2 = m60Var.f(m60Var.o());
                            W();
                            while (m60Var.c() > 0) {
                                this.Z.d(m60Var.o());
                            }
                            m60Var.e(iF2);
                        } else if (iS == 26) {
                            this.y0 = m60Var.h();
                            this.X |= 4;
                        } else if (iS == 34) {
                            this.z0 = m60Var.h();
                            this.X |= 8;
                        } else if (iS == 50) {
                            zt ztVarH = m60Var.h();
                            g92 g92Var = this.A0;
                            if (!g92Var.b) {
                                g92Var = new g92(this.A0);
                                this.A0 = g92Var;
                            }
                            this.X |= 16;
                            g92Var.d(ztVarH);
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
        return ms0.E0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ms0 ms0VarQ = q();
        if (ms0VarQ.c()) {
            return ms0VarQ;
        }
        throw a1.C(ms0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.G1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ms0 ms0VarQ = q();
        if (ms0VarQ.c()) {
            return ms0VarQ;
        }
        throw a1.C(ms0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ms0) {
            X((ms0) c1Var);
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
        if (c1Var instanceof ms0) {
            X((ms0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
