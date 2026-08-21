package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p93 extends kn1 {
    public int A0;
    public int X;
    public int Y;
    public int Z;
    public String y0 = "";
    public String z0 = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = u93.H0;
        vn1Var.a(q93.class, p93.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final q93 q() {
        q93 q93Var = new q93(this);
        q93Var.X = 0;
        q93Var.Y = 0;
        q93Var.Z = "";
        q93Var.y0 = "";
        q93Var.z0 = 0;
        q93Var.A0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                q93Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                q93Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                q93Var.Z = this.y0;
            }
            if ((i & 8) != 0) {
                q93Var.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                q93Var.z0 = this.A0;
            }
        }
        R();
        return q93Var;
    }

    public final void V(q93 q93Var) {
        if (q93Var == q93.B0) {
            return;
        }
        int i = q93Var.X;
        if (i != 0) {
            Y(i);
        }
        int i2 = q93Var.Y;
        if (i2 != 0) {
            this.Z = i2;
            this.X |= 2;
            S();
        }
        if (!q93Var.H().isEmpty()) {
            this.y0 = q93Var.Z;
            this.X |= 4;
            S();
        }
        if (!q93Var.J().isEmpty()) {
            this.z0 = q93Var.y0;
            this.X |= 8;
            S();
        }
        int i3 = q93Var.z0;
        if (i3 != 0) {
            X(i3);
        }
        A(q93Var.z);
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
                        } else if (iS == 26) {
                            this.y0 = m60Var.r();
                            this.X |= 4;
                        } else if (iS == 34) {
                            this.z0 = m60Var.r();
                            this.X |= 8;
                        } else if (iS == 40) {
                            this.A0 = m60Var.o();
                            this.X |= 16;
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

    public final void X(int i) {
        this.A0 = i;
        this.X |= 16;
        S();
    }

    public final void Y(int i) {
        this.Y = i;
        this.X |= 1;
        S();
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return q93.B0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        q93 q93VarQ = q();
        if (q93VarQ.c()) {
            return q93VarQ;
        }
        throw a1.C(q93VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return u93.G0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        q93 q93VarQ = q();
        if (q93VarQ.c()) {
            return q93VarQ;
        }
        throw a1.C(q93VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof q93) {
            V((q93) c1Var);
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
        if (c1Var instanceof q93) {
            V((q93) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
