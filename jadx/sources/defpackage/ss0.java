package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ss0 extends kn1 {
    public int X;
    public Serializable Y = "";
    public boolean Z;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.x1;
        vn1Var.a(ts0.class, ss0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ts0 q() {
        ts0 ts0Var = new ts0(this);
        ts0Var.Y = "";
        int i = 0;
        ts0Var.Z = false;
        ts0Var.y0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                ts0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                ts0Var.Z = this.Z;
                i |= 2;
            }
            ts0Var.X = i | ts0Var.X;
        }
        R();
        return ts0Var;
    }

    public final void V(ts0 ts0Var) {
        if (ts0Var == ts0.z0) {
            return;
        }
        if (ts0Var.K()) {
            this.Y = ts0Var.Y;
            this.X |= 1;
            S();
        }
        if (ts0Var.J()) {
            this.Z = ts0Var.Z;
            this.X |= 2;
            S();
        }
        A(ts0Var.z);
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
                        if (iS == 10) {
                            this.Y = m60Var.h();
                            this.X |= 1;
                        } else if (iS == 16) {
                            this.Z = m60Var.g();
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
        return ts0.z0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ts0 ts0VarQ = q();
        if (ts0VarQ.c()) {
            return ts0VarQ;
        }
        throw a1.C(ts0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        int i = this.X;
        return ((i & 1) == 0 || (i & 2) == 0) ? false : true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.w1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ts0 ts0VarQ = q();
        if (ts0VarQ.c()) {
            return ts0VarQ;
        }
        throw a1.C(ts0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ts0) {
            V((ts0) c1Var);
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
        if (c1Var instanceof ts0) {
            V((ts0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
