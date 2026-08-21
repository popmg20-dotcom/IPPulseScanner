package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k20 extends kn1 {
    public ck2 Y;
    public int Z;
    public ue1 z0;
    public int X = 0;
    public String y0 = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.R0;
        vn1Var.a(l20.class, k20.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final l20 q() {
        ue1 ue1Var;
        l20 l20Var = new l20(this);
        l20Var.X = 0;
        l20Var.Z = "";
        l20Var.y0 = (byte) -1;
        int i = this.Z;
        if (i != 0 && (i & 1) != 0) {
            l20Var.Z = this.y0;
        }
        int i2 = this.X;
        l20Var.X = i2;
        l20Var.Y = this.Y;
        if (i2 == 2 && (ue1Var = this.z0) != null) {
            l20Var.Y = ue1Var.b();
        }
        R();
        return l20Var;
    }

    public final ue1 V() {
        if (this.z0 == null) {
            if (this.X != 2) {
                this.Y = ck2.A0;
            }
            this.z0 = new ue1(this.Y, K(), this.z);
            this.Y = null;
        }
        this.X = 2;
        S();
        return this.z0;
    }

    public final void W(l20 l20Var) {
        ck2 ck2Var;
        ck2 ck2Var2;
        if (l20Var == l20.z0) {
            return;
        }
        int i = 1;
        if (!l20Var.H().isEmpty()) {
            this.y0 = l20Var.Z;
            this.Z |= 1;
            S();
        }
        int i2 = l20Var.X;
        if (i2 == 0) {
            i = 2;
        } else if (i2 != 2) {
            i = 0;
        }
        if (fw.G(i) == 0) {
            ck2 ck2VarJ = l20Var.J();
            ue1 ue1Var = this.z0;
            int i3 = this.X;
            if (ue1Var == null) {
                if (i3 != 2 || (ck2Var = this.Y) == (ck2Var2 = ck2.A0)) {
                    this.Y = ck2VarJ;
                } else {
                    zj2 zj2VarU = ck2Var2.u();
                    zj2VarU.W(ck2Var);
                    zj2VarU.W(ck2VarJ);
                    this.Y = zj2VarU.q();
                }
                S();
            } else if (i3 == 2) {
                ue1Var.o(ck2VarJ);
            } else {
                ue1Var.x(ck2VarJ);
            }
            this.X = 2;
        }
        A(l20Var.z);
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
                        if (iS == 10) {
                            this.y0 = m60Var.r();
                            this.Z |= 1;
                        } else if (iS == 18) {
                            m60Var.k(V().j(), o91Var);
                            this.X = 2;
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
        return l20.z0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        l20 l20VarQ = q();
        if (l20VarQ.c()) {
            return l20VarQ;
        }
        throw a1.C(l20VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.Q0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        l20 l20VarQ = q();
        if (l20VarQ.c()) {
            return l20VarQ;
        }
        throw a1.C(l20VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof l20) {
            W((l20) c1Var);
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
        if (c1Var instanceof l20) {
            W((l20) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
