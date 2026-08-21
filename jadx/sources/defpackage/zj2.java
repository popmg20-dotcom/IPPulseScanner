package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zj2 extends kn1 {
    public ue1 A0;
    public or1 Y;
    public int Z;
    public int X = 0;
    public int y0 = 0;
    public int z0 = 0;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.P0;
        vn1Var.a(ck2.class, zj2.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ck2 q() {
        ue1 ue1Var;
        ck2 ck2Var = new ck2(this);
        ck2Var.X = 0;
        ck2Var.Z = 0;
        ck2Var.y0 = 0;
        ck2Var.z0 = (byte) -1;
        int i = this.Z;
        if (i != 0) {
            if ((i & 1) != 0) {
                ck2Var.Z = this.y0;
            }
            if ((i & 2) != 0) {
                ck2Var.y0 = this.z0;
            }
        }
        int i2 = this.X;
        ck2Var.X = i2;
        ck2Var.Y = this.Y;
        if (i2 == 3 && (ue1Var = this.A0) != null) {
            ck2Var.Y = ue1Var.b();
        }
        R();
        return ck2Var;
    }

    public final ue1 V() {
        if (this.A0 == null) {
            if (this.X != 3) {
                this.Y = or1.C0;
            }
            this.A0 = new ue1(this.Y, K(), this.z);
            this.Y = null;
        }
        this.X = 3;
        S();
        return this.A0;
    }

    public final void W(ck2 ck2Var) {
        or1 or1Var;
        or1 or1Var2;
        if (ck2Var == ck2.A0) {
            return;
        }
        int i = ck2Var.Z;
        int i2 = 1;
        if (i != 0) {
            this.y0 = i;
            this.Z |= 1;
            S();
        }
        int i3 = ck2Var.y0;
        if (i3 != 0) {
            this.z0 = i3;
            this.Z |= 2;
            S();
        }
        int i4 = ck2Var.X;
        if (i4 == 0) {
            i2 = 2;
        } else if (i4 != 3) {
            i2 = 0;
        }
        if (fw.G(i2) == 0) {
            or1 or1VarH = ck2Var.H();
            ue1 ue1Var = this.A0;
            int i5 = this.X;
            if (ue1Var == null) {
                if (i5 != 3 || (or1Var = this.Y) == (or1Var2 = or1.C0)) {
                    this.Y = or1VarH;
                } else {
                    nr1 nr1VarU = or1Var2.u();
                    nr1VarU.V(or1Var);
                    nr1VarU.V(or1VarH);
                    this.Y = nr1VarU.q();
                }
                S();
            } else if (i5 == 3) {
                ue1Var.o(or1VarH);
            } else {
                ue1Var.x(or1VarH);
            }
            this.X = 3;
        }
        A(ck2Var.z);
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
                            this.y0 = m60Var.o();
                            this.Z |= 1;
                        } else if (iS == 16) {
                            this.z0 = m60Var.o();
                            this.Z |= 2;
                        } else if (iS == 26) {
                            m60Var.k(V().j(), o91Var);
                            this.X = 3;
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
        return ck2.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        ck2 ck2VarQ = q();
        if (ck2VarQ.c()) {
            return ck2VarQ;
        }
        throw a1.C(ck2VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.O0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ck2 ck2VarQ = q();
        if (ck2VarQ.c()) {
            return ck2VarQ;
        }
        throw a1.C(ck2VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ck2) {
            W((ck2) c1Var);
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
        if (c1Var instanceof ck2) {
            W((ck2) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
