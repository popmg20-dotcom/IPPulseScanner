package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wq0 extends kn1 {
    public int X;
    public int Y = 0;
    public Serializable Z = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.h1;
        vn1Var.a(xq0.class, wq0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final xq0 q() {
        xq0 xq0Var = new xq0(this);
        int i = 0;
        xq0Var.Y = 0;
        xq0Var.Z = "";
        xq0Var.y0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                xq0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                xq0Var.Z = this.Z;
                i |= 2;
            }
            xq0Var.X = i | xq0Var.X;
        }
        R();
        return xq0Var;
    }

    public final void V(xq0 xq0Var) {
        if (xq0Var == xq0.z0) {
            return;
        }
        if ((xq0Var.X & 1) != 0) {
            zo0 zo0VarB = zo0.b(xq0Var.Y);
            if (zo0VarB == null) {
                zo0VarB = zo0.EDITION_UNKNOWN;
            }
            this.X |= 1;
            this.Y = zo0VarB.b;
            S();
        }
        if (xq0Var.J()) {
            this.Z = xq0Var.Z;
            this.X |= 2;
            S();
        }
        A(xq0Var.z);
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
                        if (iS == 18) {
                            this.Z = m60Var.h();
                            this.X |= 2;
                        } else if (iS == 24) {
                            int iO = m60Var.o();
                            if (zo0.b(iO) == null) {
                                Q(3, iO);
                            } else {
                                this.Y = iO;
                                this.X |= 1;
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
        return xq0.z0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        xq0 xq0VarQ = q();
        if (xq0VarQ.c()) {
            return xq0VarQ;
        }
        throw a1.C(xq0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.g1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        xq0 xq0VarQ = q();
        if (xq0VarQ.c()) {
            return xq0VarQ;
        }
        throw a1.C(xq0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof xq0) {
            V((xq0) c1Var);
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
        if (c1Var instanceof xq0) {
            V((xq0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
