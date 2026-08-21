package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ek2 extends kn1 {
    public boolean A0;
    public boolean B0;
    public String C0 = "";
    public String D0 = "";
    public long E0;
    public int X;
    public long Y;
    public long Z;
    public long y0;
    public boolean z0;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.d1;
        vn1Var.a(fk2.class, ek2.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final fk2 q() {
        fk2 fk2Var = new fk2(this);
        fk2Var.X = 0L;
        fk2Var.Y = 0L;
        fk2Var.Z = 0L;
        fk2Var.y0 = false;
        fk2Var.z0 = false;
        fk2Var.A0 = false;
        fk2Var.B0 = "";
        fk2Var.C0 = "";
        fk2Var.D0 = 0L;
        fk2Var.E0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                fk2Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                fk2Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                fk2Var.Z = this.y0;
            }
            if ((i & 8) != 0) {
                fk2Var.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                fk2Var.z0 = this.A0;
            }
            if ((i & 32) != 0) {
                fk2Var.A0 = this.B0;
            }
            if ((i & 64) != 0) {
                fk2Var.B0 = this.C0;
            }
            if ((i & 128) != 0) {
                fk2Var.C0 = this.D0;
            }
            if ((i & 256) != 0) {
                fk2Var.D0 = this.E0;
            }
        }
        R();
        return fk2Var;
    }

    public final void V(fk2 fk2Var) {
        if (fk2Var == fk2.F0) {
            return;
        }
        long j = fk2Var.X;
        if (j != 0) {
            this.Y = j;
            this.X |= 1;
            S();
        }
        long j2 = fk2Var.Y;
        if (j2 != 0) {
            this.Z = j2;
            this.X |= 2;
            S();
        }
        long j3 = fk2Var.Z;
        if (j3 != 0) {
            this.y0 = j3;
            this.X |= 4;
            S();
        }
        boolean z = fk2Var.y0;
        if (z) {
            this.z0 = z;
            this.X |= 8;
            S();
        }
        boolean z2 = fk2Var.z0;
        if (z2) {
            this.A0 = z2;
            this.X |= 16;
            S();
        }
        boolean z3 = fk2Var.A0;
        if (z3) {
            this.B0 = z3;
            this.X |= 32;
            S();
        }
        if (!fk2Var.J().isEmpty()) {
            this.C0 = fk2Var.B0;
            this.X |= 64;
            S();
        }
        if (!fk2Var.H().isEmpty()) {
            this.D0 = fk2Var.C0;
            this.X |= 128;
            S();
        }
        long j4 = fk2Var.D0;
        if (j4 != 0) {
            this.E0 = j4;
            this.X |= 256;
            S();
        }
        A(fk2Var.z);
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
                            this.Y = m60Var.p();
                            this.X |= 1;
                        } else if (iS == 16) {
                            this.Z = m60Var.p();
                            this.X |= 2;
                        } else if (iS == 24) {
                            this.y0 = m60Var.p();
                            this.X |= 4;
                        } else if (iS == 32) {
                            this.z0 = m60Var.g();
                            this.X |= 8;
                        } else if (iS == 40) {
                            this.A0 = m60Var.g();
                            this.X |= 16;
                        } else if (iS == 48) {
                            this.B0 = m60Var.g();
                            this.X |= 32;
                        } else if (iS == 58) {
                            this.C0 = m60Var.r();
                            this.X |= 64;
                        } else if (iS == 66) {
                            this.D0 = m60Var.r();
                            this.X |= 128;
                        } else if (iS == 72) {
                            this.E0 = m60Var.p();
                            this.X |= 256;
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
        return fk2.F0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        fk2 fk2VarQ = q();
        if (fk2VarQ.c()) {
            return fk2VarQ;
        }
        throw a1.C(fk2VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.c1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        fk2 fk2VarQ = q();
        if (fk2VarQ.c()) {
            return fk2VarQ;
        }
        throw a1.C(fk2VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof fk2) {
            V((fk2) c1Var);
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
        if (c1Var instanceof fk2) {
            V((fk2) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
