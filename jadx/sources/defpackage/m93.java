package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m93 extends kn1 {
    public int A0;
    public int B0;
    public int X;
    public int Y;
    public zt Z;
    public zt y0;
    public String z0;

    public m93() {
        zt ztVar = zt.z;
        this.Z = ztVar;
        this.y0 = ztVar;
        this.z0 = "";
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = u93.D0;
        vn1Var.a(n93.class, m93.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final n93 p() {
        n93 n93VarQ = q();
        if (n93VarQ.c()) {
            return n93VarQ;
        }
        throw a1.C(n93VarQ);
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final n93 q() {
        n93 n93Var = new n93(this);
        n93Var.X = 0;
        zt ztVar = zt.z;
        n93Var.Y = ztVar;
        n93Var.Z = ztVar;
        n93Var.y0 = "";
        n93Var.z0 = 0;
        n93Var.A0 = 0;
        n93Var.B0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                n93Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                n93Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                n93Var.Z = this.y0;
            }
            if ((i & 8) != 0) {
                n93Var.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                n93Var.z0 = this.A0;
            }
            if ((i & 32) != 0) {
                n93Var.A0 = this.B0;
            }
        }
        R();
        return n93Var;
    }

    public final void W(n93 n93Var) {
        if (n93Var == n93.C0) {
            return;
        }
        int i = n93Var.X;
        if (i != 0) {
            Z(i);
        }
        if (!n93Var.Y.isEmpty()) {
            zt ztVar = n93Var.Y;
            ztVar.getClass();
            this.Z = ztVar;
            this.X |= 2;
            S();
        }
        if (!n93Var.Z.isEmpty()) {
            zt ztVar2 = n93Var.Z;
            ztVar2.getClass();
            this.y0 = ztVar2;
            this.X |= 4;
            S();
        }
        if (!n93Var.H().isEmpty()) {
            this.z0 = n93Var.y0;
            this.X |= 8;
            S();
        }
        int i2 = n93Var.z0;
        if (i2 != 0) {
            Y(i2);
        }
        int i3 = n93Var.A0;
        if (i3 != 0) {
            a0(i3);
        }
        A(n93Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
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
                        } else if (iS == 26) {
                            this.y0 = m60Var.h();
                            this.X |= 4;
                        } else if (iS == 34) {
                            this.z0 = m60Var.r();
                            this.X |= 8;
                        } else if (iS == 40) {
                            this.A0 = m60Var.o();
                            this.X |= 16;
                        } else if (iS == 48) {
                            this.B0 = m60Var.o();
                            this.X |= 32;
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

    public final void Y(int i) {
        this.A0 = i;
        this.X |= 16;
        S();
    }

    public final void Z(int i) {
        this.Y = i;
        this.X |= 1;
        S();
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return n93.C0;
    }

    public final void a0(int i) {
        this.B0 = i;
        this.X |= 32;
        S();
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return u93.C0;
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof n93) {
            W((n93) c1Var);
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
        if (c1Var instanceof n93) {
            W((n93) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
