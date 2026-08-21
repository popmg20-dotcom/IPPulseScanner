package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d32 extends kn1 {
    public int X;
    public boolean Y;
    public boolean y0;
    public boolean z0;
    public int Z = 0;
    public int A0 = 0;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = h32.C0;
        vn1Var.a(g32.class, d32.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final g32 q() {
        g32 g32Var = new g32(this);
        int i = 0;
        g32Var.Y = false;
        g32Var.Z = 0;
        g32Var.y0 = false;
        g32Var.z0 = false;
        g32Var.A0 = 0;
        g32Var.B0 = (byte) -1;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                g32Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                g32Var.Z = this.Z;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                g32Var.y0 = this.y0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                g32Var.z0 = this.z0;
                i |= 8;
            }
            if ((i2 & 16) != 0) {
                g32Var.A0 = this.A0;
                i |= 16;
            }
            g32Var.X = i | g32Var.X;
        }
        R();
        return g32Var;
    }

    public final void V(g32 g32Var) {
        f32 f32Var;
        if (g32Var == g32.C0) {
            return;
        }
        if ((g32Var.X & 1) != 0) {
            this.Y = g32Var.Y;
            this.X |= 1;
            S();
        }
        e32 e32Var = null;
        if (g32Var.L()) {
            int i = g32Var.Z;
            if (i == 0) {
                f32Var = f32.UTF8_VALIDATION_UNKNOWN;
            } else if (i == 1) {
                f32Var = f32.DEFAULT;
            } else if (i != 2) {
                f32 f32Var2 = f32.UTF8_VALIDATION_UNKNOWN;
                f32Var = null;
            } else {
                f32Var = f32.VERIFY;
            }
            if (f32Var == null) {
                f32Var = f32.UTF8_VALIDATION_UNKNOWN;
            }
            this.X |= 2;
            this.Z = f32Var.b;
            S();
        }
        if (g32Var.H()) {
            this.y0 = g32Var.y0;
            this.X |= 4;
            S();
        }
        if (g32Var.K()) {
            this.z0 = g32Var.z0;
            this.X |= 8;
            S();
        }
        if (g32Var.J()) {
            int i2 = g32Var.A0;
            if (i2 == 0) {
                e32Var = e32.NEST_IN_FILE_CLASS_UNKNOWN;
            } else if (i2 == 1) {
                e32Var = e32.NO;
            } else if (i2 == 2) {
                e32Var = e32.YES;
            } else if (i2 != 3) {
                e32 e32Var2 = e32.NEST_IN_FILE_CLASS_UNKNOWN;
            } else {
                e32Var = e32.LEGACY;
            }
            if (e32Var == null) {
                e32Var = e32.NEST_IN_FILE_CLASS_UNKNOWN;
            }
            this.X |= 16;
            this.A0 = e32Var.b;
            S();
        }
        A(g32Var.z);
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
                        if (iS != 8) {
                            Enum r3 = null;
                            if (iS == 16) {
                                int iO = m60Var.o();
                                if (iO == 0) {
                                    r3 = f32.UTF8_VALIDATION_UNKNOWN;
                                } else if (iO == 1) {
                                    r3 = f32.DEFAULT;
                                } else if (iO != 2) {
                                    f32 f32Var = f32.UTF8_VALIDATION_UNKNOWN;
                                } else {
                                    r3 = f32.VERIFY;
                                }
                                if (r3 == null) {
                                    Q(2, iO);
                                } else {
                                    this.Z = iO;
                                    this.X |= 2;
                                }
                            } else if (iS == 24) {
                                this.y0 = m60Var.g();
                                this.X |= 4;
                            } else if (iS == 32) {
                                this.z0 = m60Var.g();
                                this.X |= 8;
                            } else if (iS == 40) {
                                int iO2 = m60Var.o();
                                if (iO2 == 0) {
                                    r3 = e32.NEST_IN_FILE_CLASS_UNKNOWN;
                                } else if (iO2 == 1) {
                                    r3 = e32.NO;
                                } else if (iO2 == 2) {
                                    r3 = e32.YES;
                                } else if (iO2 != 3) {
                                    e32 e32Var = e32.NEST_IN_FILE_CLASS_UNKNOWN;
                                } else {
                                    r3 = e32.LEGACY;
                                }
                                if (r3 == null) {
                                    Q(5, iO2);
                                } else {
                                    this.A0 = iO2;
                                    this.X |= 16;
                                }
                            } else if (!u().t(iS, m60Var)) {
                            }
                        } else {
                            this.Y = m60Var.g();
                            this.X |= 1;
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
        return g32.C0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        g32 g32VarQ = q();
        if (g32VarQ.c()) {
            return g32VarQ;
        }
        throw a1.C(g32VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return h32.B0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        g32 g32VarQ = q();
        if (g32VarQ.c()) {
            return g32VarQ;
        }
        throw a1.C(g32VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof g32) {
            V((g32) c1Var);
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
        if (c1Var instanceof g32) {
            V((g32) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
