package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dp0 extends kn1 {
    public int X;
    public int Y;
    public int Z;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.T0;
        vn1Var.a(ep0.class, dp0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ep0 q() {
        ep0 ep0Var = new ep0(this);
        int i = 0;
        ep0Var.Y = 0;
        ep0Var.Z = 0;
        ep0Var.y0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                ep0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                ep0Var.Z = this.Z;
                i |= 2;
            }
            ep0Var.X = i | ep0Var.X;
        }
        R();
        return ep0Var;
    }

    public final void V(ep0 ep0Var) {
        if (ep0Var == ep0.z0) {
            return;
        }
        if ((ep0Var.X & 1) != 0) {
            this.Y = ep0Var.Y;
            this.X |= 1;
            S();
        }
        if (ep0Var.H()) {
            this.Z = ep0Var.Z;
            this.X |= 2;
            S();
        }
        A(ep0Var.z);
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
                            this.Y = m60Var.o();
                            this.X |= 1;
                        } else if (iS == 16) {
                            this.Z = m60Var.o();
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
        return ep0.z0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ep0 ep0VarQ = q();
        if (ep0VarQ.c()) {
            return ep0VarQ;
        }
        throw a1.C(ep0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.S0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ep0 ep0VarQ = q();
        if (ep0VarQ.c()) {
            return ep0VarQ;
        }
        throw a1.C(ep0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ep0) {
            V((ep0) c1Var);
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
        if (c1Var instanceof ep0) {
            V((ep0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
