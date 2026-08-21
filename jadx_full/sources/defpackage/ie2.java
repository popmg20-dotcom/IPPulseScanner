package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ie2 extends kn1 {
    public int X;
    public int Z;
    public int y0;
    public int z0;
    public String Y = "";
    public String A0 = "";
    public String B0 = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.j1;
        vn1Var.a(je2.class, ie2.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final je2 q() {
        je2 je2Var = new je2(this);
        je2Var.X = "";
        je2Var.Y = 0;
        je2Var.Z = 0;
        je2Var.y0 = 0;
        je2Var.z0 = "";
        je2Var.A0 = "";
        je2Var.B0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                je2Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                je2Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                je2Var.Z = this.y0;
            }
            if ((i & 8) != 0) {
                je2Var.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                je2Var.z0 = this.A0;
            }
            if ((i & 32) != 0) {
                je2Var.A0 = this.B0;
            }
        }
        R();
        return je2Var;
    }

    public final void V(je2 je2Var) {
        if (je2Var == je2.C0) {
            return;
        }
        if (!je2Var.K().isEmpty()) {
            this.Y = je2Var.X;
            this.X |= 1;
            S();
        }
        int i = je2Var.Y;
        if (i != 0) {
            this.Z = i;
            this.X |= 2;
            S();
        }
        int i2 = je2Var.Z;
        if (i2 != 0) {
            this.y0 = i2;
            this.X |= 4;
            S();
        }
        int i3 = je2Var.y0;
        if (i3 != 0) {
            this.z0 = i3;
            this.X |= 8;
            S();
        }
        if (!je2Var.J().isEmpty()) {
            this.A0 = je2Var.z0;
            this.X |= 16;
            S();
        }
        if (!je2Var.H().isEmpty()) {
            this.B0 = je2Var.A0;
            this.X |= 32;
            S();
        }
        A(je2Var.z);
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
                            this.Y = m60Var.r();
                            this.X |= 1;
                        } else if (iS == 16) {
                            this.Z = m60Var.o();
                            this.X |= 2;
                        } else if (iS == 24) {
                            this.y0 = m60Var.o();
                            this.X |= 4;
                        } else if (iS == 32) {
                            this.z0 = m60Var.o();
                            this.X |= 8;
                        } else if (iS == 42) {
                            this.A0 = m60Var.r();
                            this.X |= 16;
                        } else if (iS == 50) {
                            this.B0 = m60Var.r();
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

    @Override // defpackage.ol2
    public final c1 a() {
        return je2.C0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        je2 je2VarQ = q();
        if (je2VarQ.c()) {
            return je2VarQ;
        }
        throw a1.C(je2VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.i1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        je2 je2VarQ = q();
        if (je2VarQ.c()) {
            return je2VarQ;
        }
        throw a1.C(je2VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof je2) {
            V((je2) c1Var);
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
        if (c1Var instanceof je2) {
            V((je2) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
