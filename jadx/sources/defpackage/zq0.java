package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zq0 extends kn1 {
    public int X;
    public int Y = 0;
    public int Z = 0;
    public Serializable y0 = "";
    public int z0 = 0;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.j1;
        vn1Var.a(ar0.class, zq0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ar0 q() {
        ar0 ar0Var = new ar0(this);
        int i = 0;
        ar0Var.Y = 0;
        ar0Var.Z = 0;
        ar0Var.y0 = "";
        ar0Var.z0 = 0;
        ar0Var.A0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                ar0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                ar0Var.Z = this.Z;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                ar0Var.y0 = this.y0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                ar0Var.z0 = this.z0;
                i |= 8;
            }
            ar0Var.X = i | ar0Var.X;
        }
        R();
        return ar0Var;
    }

    public final void V(ar0 ar0Var) {
        if (ar0Var == ar0.B0) {
            return;
        }
        if ((ar0Var.X & 1) != 0) {
            zo0 zo0VarB = zo0.b(ar0Var.Y);
            if (zo0VarB == null) {
                zo0VarB = zo0.EDITION_UNKNOWN;
            }
            this.X |= 1;
            this.Y = zo0VarB.b;
            S();
        }
        if (ar0Var.K()) {
            zo0 zo0VarB2 = zo0.b(ar0Var.Z);
            if (zo0VarB2 == null) {
                zo0VarB2 = zo0.EDITION_UNKNOWN;
            }
            this.X |= 2;
            this.Z = zo0VarB2.b;
            S();
        }
        if (ar0Var.J()) {
            this.y0 = ar0Var.y0;
            this.X |= 4;
            S();
        }
        if (ar0Var.L()) {
            zo0 zo0VarB3 = zo0.b(ar0Var.z0);
            if (zo0VarB3 == null) {
                zo0VarB3 = zo0.EDITION_UNKNOWN;
            }
            this.X |= 8;
            this.z0 = zo0VarB3.b;
            S();
        }
        A(ar0Var.z);
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
                    if (iS != 0) {
                        if (iS == 8) {
                            int iO = m60Var.o();
                            if (zo0.b(iO) == null) {
                                Q(1, iO);
                            } else {
                                this.Y = iO;
                                this.X |= 1;
                            }
                        } else if (iS == 16) {
                            int iO2 = m60Var.o();
                            if (zo0.b(iO2) == null) {
                                Q(2, iO2);
                            } else {
                                this.Z = iO2;
                                this.X |= 2;
                            }
                        } else if (iS == 26) {
                            this.y0 = m60Var.h();
                            this.X |= 4;
                        } else if (iS == 32) {
                            int iO3 = m60Var.o();
                            if (zo0.b(iO3) == null) {
                                Q(4, iO3);
                            } else {
                                this.z0 = iO3;
                                this.X |= 8;
                            }
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
        return ar0.B0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ar0 ar0VarQ = q();
        if (ar0VarQ.c()) {
            return ar0VarQ;
        }
        throw a1.C(ar0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.i1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ar0 ar0VarQ = q();
        if (ar0VarQ.c()) {
            return ar0VarQ;
        }
        throw a1.C(ar0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ar0) {
            V((ar0) c1Var);
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
        if (c1Var instanceof ar0) {
            V((ar0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
