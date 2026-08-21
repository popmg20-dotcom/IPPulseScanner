package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wj2 extends kn1 {
    public long A0;
    public ue1 C0;
    public xd Y;
    public int Z;
    public int X = 0;
    public String y0 = "";
    public String z0 = "";
    public zt B0 = zt.z;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.b1;
        vn1Var.a(xj2.class, wj2.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final xj2 q() {
        ue1 ue1Var;
        xj2 xj2Var = new xj2(this);
        xj2Var.X = 0;
        xj2Var.Z = "";
        xj2Var.y0 = "";
        xj2Var.z0 = 0L;
        xj2Var.A0 = zt.z;
        xj2Var.B0 = (byte) -1;
        int i = this.Z;
        if (i != 0) {
            if ((i & 1) != 0) {
                xj2Var.Z = this.y0;
            }
            if ((i & 2) != 0) {
                xj2Var.y0 = this.z0;
            }
            if ((i & 4) != 0) {
                xj2Var.z0 = this.A0;
            }
            if ((i & 8) != 0) {
                xj2Var.A0 = this.B0;
            }
        }
        int i2 = this.X;
        xj2Var.X = i2;
        xj2Var.Y = this.Y;
        if (i2 == 6 && (ue1Var = this.C0) != null) {
            xj2Var.Y = ue1Var.b();
        }
        R();
        return xj2Var;
    }

    public final ue1 V() {
        if (this.C0 == null) {
            if (this.X != 6) {
                this.Y = xd.Z;
            }
            this.C0 = new ue1(this.Y, K(), this.z);
            this.Y = null;
        }
        this.X = 6;
        S();
        return this.C0;
    }

    public final void W(xj2 xj2Var) {
        xd xdVar;
        xd xdVar2;
        if (xj2Var == xj2.C0) {
            return;
        }
        int i = 1;
        if (!xj2Var.K().isEmpty()) {
            this.y0 = xj2Var.Z;
            this.Z |= 1;
            S();
        }
        if (!xj2Var.J().isEmpty()) {
            this.z0 = xj2Var.y0;
            this.Z |= 2;
            S();
        }
        long j = xj2Var.z0;
        if (j != 0) {
            this.A0 = j;
            this.Z |= 4;
            S();
        }
        if (!xj2Var.A0.isEmpty()) {
            zt ztVar = xj2Var.A0;
            ztVar.getClass();
            this.B0 = ztVar;
            this.Z |= 8;
            S();
        }
        int i2 = xj2Var.X;
        if (i2 == 0) {
            i = 2;
        } else if (i2 != 6) {
            i = 0;
        }
        if (fw.G(i) == 0) {
            xd xdVarH = xj2Var.H();
            ue1 ue1Var = this.C0;
            int i3 = this.X;
            if (ue1Var == null) {
                if (i3 != 6 || (xdVar = this.Y) == (xdVar2 = xd.Z)) {
                    this.Y = xdVarH;
                } else {
                    wd wdVarU = xdVar2.u();
                    wdVarU.V(xdVar);
                    wdVarU.V(xdVarH);
                    this.Y = wdVarU.q();
                }
                S();
            } else if (i3 == 6) {
                ue1Var.o(xdVarH);
            } else {
                ue1Var.x(xdVarH);
            }
            this.X = 6;
        }
        A(xj2Var.z);
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
                            this.z0 = m60Var.r();
                            this.Z |= 2;
                        } else if (iS == 24) {
                            this.A0 = m60Var.p();
                            this.Z |= 4;
                        } else if (iS == 34) {
                            this.B0 = m60Var.h();
                            this.Z |= 8;
                        } else if (iS == 50) {
                            m60Var.k(V().j(), o91Var);
                            this.X = 6;
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
        return xj2.C0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        xj2 xj2VarQ = q();
        if (xj2VarQ.c()) {
            return xj2VarQ;
        }
        throw a1.C(xj2VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.a1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        xj2 xj2VarQ = q();
        if (xj2VarQ.c()) {
            return xj2VarQ;
        }
        throw a1.C(xj2VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof xj2) {
            W((xj2) c1Var);
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
        if (c1Var instanceof xj2) {
            W((xj2) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
