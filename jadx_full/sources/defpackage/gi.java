package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gi extends kn1 {
    public long A0;
    public long C0;
    public int X;
    public long Y;
    public long Z;
    public long y0;
    public String z0 = "";
    public String B0 = "";
    public String D0 = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.X0;
        vn1Var.a(hi.class, gi.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final hi q() {
        hi hiVar = new hi(this);
        hiVar.X = 0L;
        hiVar.Y = 0L;
        hiVar.Z = 0L;
        hiVar.y0 = "";
        hiVar.z0 = 0L;
        hiVar.A0 = "";
        hiVar.B0 = 0L;
        hiVar.C0 = "";
        hiVar.D0 = (byte) -1;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                hiVar.X = this.Y;
            }
            if ((i & 2) != 0) {
                hiVar.Y = this.Z;
            }
            if ((i & 4) != 0) {
                hiVar.Z = this.y0;
            }
            if ((i & 8) != 0) {
                hiVar.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                hiVar.z0 = this.A0;
            }
            if ((i & 32) != 0) {
                hiVar.A0 = this.B0;
            }
            if ((i & 64) != 0) {
                hiVar.B0 = this.C0;
            }
            if ((i & 128) != 0) {
                hiVar.C0 = this.D0;
            }
        }
        R();
        return hiVar;
    }

    public final void V(hi hiVar) {
        if (hiVar == hi.E0) {
            return;
        }
        long j = hiVar.X;
        if (j != 0) {
            this.Y = j;
            this.X |= 1;
            S();
        }
        long j2 = hiVar.Y;
        if (j2 != 0) {
            this.Z = j2;
            this.X |= 2;
            S();
        }
        long j3 = hiVar.Z;
        if (j3 != 0) {
            this.y0 = j3;
            this.X |= 4;
            S();
        }
        if (!hiVar.K().isEmpty()) {
            this.z0 = hiVar.y0;
            this.X |= 8;
            S();
        }
        long j4 = hiVar.z0;
        if (j4 != 0) {
            this.A0 = j4;
            this.X |= 16;
            S();
        }
        if (!hiVar.J().isEmpty()) {
            this.B0 = hiVar.A0;
            this.X |= 32;
            S();
        }
        long j5 = hiVar.B0;
        if (j5 != 0) {
            this.C0 = j5;
            this.X |= 64;
            S();
        }
        if (!hiVar.H().isEmpty()) {
            this.D0 = hiVar.C0;
            this.X |= 128;
            S();
        }
        A(hiVar.z);
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
                        } else if (iS == 34) {
                            this.z0 = m60Var.r();
                            this.X |= 8;
                        } else if (iS == 40) {
                            this.A0 = m60Var.p();
                            this.X |= 16;
                        } else if (iS == 50) {
                            this.B0 = m60Var.r();
                            this.X |= 32;
                        } else if (iS == 56) {
                            this.C0 = m60Var.p();
                            this.X |= 64;
                        } else if (iS == 66) {
                            this.D0 = m60Var.r();
                            this.X |= 128;
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
        return hi.E0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        hi hiVarQ = q();
        if (hiVarQ.c()) {
            return hiVarQ;
        }
        throw a1.C(hiVarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.W0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        hi hiVarQ = q();
        if (hiVarQ.c()) {
            return hiVarQ;
        }
        throw a1.C(hiVarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof hi) {
            V((hi) c1Var);
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
        if (c1Var instanceof hi) {
            V((hi) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
