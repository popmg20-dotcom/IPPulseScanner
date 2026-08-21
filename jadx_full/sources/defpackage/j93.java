package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j93 extends kn1 {
    public int A0;
    public int C0;
    public int X;
    public int Y;
    public int y0;
    public zt Z = zt.z;
    public String z0 = "";
    public String B0 = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = u93.B0;
        vn1Var.a(k93.class, j93.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final k93 q() {
        k93 k93Var = new k93(this);
        k93Var.X = 0;
        k93Var.Y = zt.z;
        k93Var.Z = 0;
        k93Var.y0 = "";
        k93Var.z0 = 0;
        k93Var.A0 = "";
        k93Var.B0 = 0;
        k93Var.C0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                k93Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                k93Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                k93Var.Z = this.y0;
            }
            if ((i & 8) != 0) {
                k93Var.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                k93Var.z0 = this.A0;
            }
            if ((i & 32) != 0) {
                k93Var.A0 = this.B0;
            }
            if ((i & 64) != 0) {
                k93Var.B0 = this.C0;
            }
        }
        R();
        return k93Var;
    }

    public final void V(k93 k93Var) {
        if (k93Var == k93.D0) {
            return;
        }
        int i = k93Var.X;
        if (i != 0) {
            this.Y = i;
            this.X |= 1;
            S();
        }
        if (!k93Var.Y.isEmpty()) {
            zt ztVar = k93Var.Y;
            ztVar.getClass();
            this.Z = ztVar;
            this.X |= 2;
            S();
        }
        int i2 = k93Var.Z;
        if (i2 != 0) {
            this.y0 = i2;
            this.X |= 4;
            S();
        }
        if (!k93Var.J().isEmpty()) {
            this.z0 = k93Var.y0;
            this.X |= 8;
            S();
        }
        int i3 = k93Var.z0;
        if (i3 != 0) {
            this.A0 = i3;
            this.X |= 16;
            S();
        }
        if (!k93Var.H().isEmpty()) {
            this.B0 = k93Var.A0;
            this.X |= 32;
            S();
        }
        int i4 = k93Var.B0;
        if (i4 != 0) {
            this.C0 = i4;
            this.X |= 64;
            S();
        }
        A(k93Var.z);
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
                        } else if (iS == 18) {
                            this.Z = m60Var.h();
                            this.X |= 2;
                        } else if (iS == 24) {
                            this.y0 = m60Var.o();
                            this.X |= 4;
                        } else if (iS == 34) {
                            this.z0 = m60Var.r();
                            this.X |= 8;
                        } else if (iS == 40) {
                            this.A0 = m60Var.o();
                            this.X |= 16;
                        } else if (iS == 50) {
                            this.B0 = m60Var.r();
                            this.X |= 32;
                        } else if (iS == 56) {
                            this.C0 = m60Var.o();
                            this.X |= 64;
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
        return k93.D0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        k93 k93VarQ = q();
        if (k93VarQ.c()) {
            return k93VarQ;
        }
        throw a1.C(k93VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return u93.A0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        k93 k93VarQ = q();
        if (k93VarQ.c()) {
            return k93VarQ;
        }
        throw a1.C(k93VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof k93) {
            V((k93) c1Var);
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
        if (c1Var instanceof k93) {
            V((k93) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
