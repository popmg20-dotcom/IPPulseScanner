package defpackage;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ro0 extends kn1 {
    public List A0;
    public List B0;
    public List C0;
    public or0 D0;
    public ue1 E0;
    public List F0;
    public g92 G0;
    public int H0;
    public int X;
    public Serializable Y = "";
    public List Z;
    public List y0;
    public List z0;

    public ro0() {
        List list = Collections.EMPTY_LIST;
        this.Z = list;
        this.y0 = list;
        this.z0 = list;
        this.A0 = list;
        this.B0 = list;
        this.C0 = list;
        this.F0 = list;
        this.G0 = g92.z;
        this.H0 = 0;
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.D0;
        vn1Var.a(yo0.class, ro0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final yo0 q() {
        yo0 yo0Var = new yo0(this);
        yo0Var.Y = "";
        yo0Var.F0 = g92.z;
        int i = 0;
        yo0Var.G0 = 0;
        yo0Var.H0 = (byte) -1;
        if ((this.X & 2) != 0) {
            this.Z = DesugarCollections.unmodifiableList(this.Z);
            this.X &= -3;
        }
        yo0Var.Z = this.Z;
        if ((this.X & 4) != 0) {
            this.y0 = DesugarCollections.unmodifiableList(this.y0);
            this.X &= -5;
        }
        yo0Var.y0 = this.y0;
        if ((this.X & 8) != 0) {
            this.z0 = DesugarCollections.unmodifiableList(this.z0);
            this.X &= -9;
        }
        yo0Var.z0 = this.z0;
        if ((this.X & 16) != 0) {
            this.A0 = DesugarCollections.unmodifiableList(this.A0);
            this.X &= -17;
        }
        yo0Var.A0 = this.A0;
        if ((this.X & 32) != 0) {
            this.B0 = DesugarCollections.unmodifiableList(this.B0);
            this.X &= -33;
        }
        yo0Var.B0 = this.B0;
        if ((this.X & 64) != 0) {
            this.C0 = DesugarCollections.unmodifiableList(this.C0);
            this.X &= -65;
        }
        yo0Var.C0 = this.C0;
        if ((this.X & 256) != 0) {
            this.F0 = DesugarCollections.unmodifiableList(this.F0);
            this.X &= -257;
        }
        yo0Var.E0 = this.F0;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                yo0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 128) != 0) {
                ue1 ue1Var = this.E0;
                yo0Var.D0 = ue1Var == null ? this.D0 : (or0) ue1Var.b();
                i |= 2;
            }
            if ((i2 & 512) != 0) {
                this.G0.b();
                yo0Var.F0 = this.G0;
            }
            if ((i2 & 1024) != 0) {
                yo0Var.G0 = this.H0;
                i |= 4;
            }
            yo0Var.X = i | yo0Var.X;
        }
        R();
        return yo0Var;
    }

    public final void V() {
        if ((this.X & 32) == 0) {
            this.B0 = new ArrayList(this.B0);
            this.X |= 32;
        }
    }

    public final void W(yo0 yo0Var) {
        or0 or0Var;
        or0 or0Var2;
        if (yo0Var == yo0.I0) {
            return;
        }
        if ((yo0Var.X & 1) != 0) {
            this.Y = yo0Var.Y;
            this.X |= 1;
            S();
        }
        if (!yo0Var.Z.isEmpty()) {
            if (this.Z.isEmpty()) {
                this.Z = yo0Var.Z;
                this.X &= -3;
            } else {
                if ((this.X & 2) == 0) {
                    this.Z = new ArrayList(this.Z);
                    this.X |= 2;
                }
                this.Z.addAll(yo0Var.Z);
            }
            S();
        }
        if (!yo0Var.y0.isEmpty()) {
            if (this.y0.isEmpty()) {
                this.y0 = yo0Var.y0;
                this.X &= -5;
            } else {
                if ((this.X & 4) == 0) {
                    this.y0 = new ArrayList(this.y0);
                    this.X |= 4;
                }
                this.y0.addAll(yo0Var.y0);
            }
            S();
        }
        if (!yo0Var.z0.isEmpty()) {
            if (this.z0.isEmpty()) {
                this.z0 = yo0Var.z0;
                this.X &= -9;
            } else {
                if ((this.X & 8) == 0) {
                    this.z0 = new ArrayList(this.z0);
                    this.X |= 8;
                }
                this.z0.addAll(yo0Var.z0);
            }
            S();
        }
        if (!yo0Var.A0.isEmpty()) {
            if (this.A0.isEmpty()) {
                this.A0 = yo0Var.A0;
                this.X &= -17;
            } else {
                if ((this.X & 16) == 0) {
                    this.A0 = new ArrayList(this.A0);
                    this.X |= 16;
                }
                this.A0.addAll(yo0Var.A0);
            }
            S();
        }
        if (!yo0Var.B0.isEmpty()) {
            if (this.B0.isEmpty()) {
                this.B0 = yo0Var.B0;
                this.X &= -33;
            } else {
                V();
                this.B0.addAll(yo0Var.B0);
            }
            S();
        }
        if (!yo0Var.C0.isEmpty()) {
            if (this.C0.isEmpty()) {
                this.C0 = yo0Var.C0;
                this.X &= -65;
            } else {
                if ((this.X & 64) == 0) {
                    this.C0 = new ArrayList(this.C0);
                    this.X |= 64;
                }
                this.C0.addAll(yo0Var.C0);
            }
            S();
        }
        if (yo0Var.K()) {
            or0 or0VarJ = yo0Var.J();
            ue1 ue1Var = this.E0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 128) == 0 || (or0Var = this.D0) == null || or0Var == (or0Var2 = or0.F0)) {
                    this.D0 = or0VarJ;
                } else {
                    this.X = i | 128;
                    S();
                    ue1 ue1Var2 = this.E0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            or0 or0Var3 = this.D0;
                            if (or0Var3 != null) {
                                or0Var2 = or0Var3;
                            }
                        } else {
                            or0Var2 = (or0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(or0Var2, K(), this.z);
                        this.E0 = ue1Var3;
                        this.D0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((nr0) ue1Var2.j()).a0(or0VarJ);
                }
            } else {
                ue1Var.o(or0VarJ);
            }
            if (this.D0 != null) {
                this.X |= 128;
                S();
            }
        }
        if (!yo0Var.E0.isEmpty()) {
            if (this.F0.isEmpty()) {
                this.F0 = yo0Var.E0;
                this.X &= -257;
            } else {
                if ((this.X & 256) == 0) {
                    this.F0 = new ArrayList(this.F0);
                    this.X |= 256;
                }
                this.F0.addAll(yo0Var.E0);
            }
            S();
        }
        if (!yo0Var.F0.isEmpty()) {
            if (this.G0.isEmpty()) {
                this.G0 = yo0Var.F0;
                this.X |= 512;
            } else {
                g92 g92Var = this.G0;
                if (!g92Var.b) {
                    g92Var = new g92(this.G0);
                    this.G0 = g92Var;
                }
                this.X |= 512;
                g92Var.addAll(yo0Var.F0);
            }
            S();
        }
        if (yo0Var.L()) {
            os0 os0VarB = os0.b(yo0Var.G0);
            if (os0VarB == null) {
                os0VarB = os0.VISIBILITY_UNSET;
            }
            this.X |= 1024;
            this.H0 = os0VarB.b;
            S();
        }
        A(yo0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        or0 or0Var;
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    switch (iS) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            this.Y = m60Var.h();
                            this.X |= 1;
                            break;
                        case 18:
                            rq0 rq0Var = (rq0) m60Var.j(rq0.J0, o91Var);
                            if ((this.X & 2) == 0) {
                                this.Z = new ArrayList(this.Z);
                                this.X |= 2;
                            }
                            this.Z.add(rq0Var);
                            break;
                        case 26:
                            yo0 yo0Var = (yo0) m60Var.j(yo0.J0, o91Var);
                            if ((this.X & 8) == 0) {
                                this.z0 = new ArrayList(this.z0);
                                this.X |= 8;
                            }
                            this.z0.add(yo0Var);
                            break;
                        case 34:
                            fp0 fp0Var = (fp0) m60Var.j(fp0.E0, o91Var);
                            if ((this.X & 16) == 0) {
                                this.A0 = new ArrayList(this.A0);
                                this.X |= 16;
                            }
                            this.A0.add(fp0Var);
                            break;
                        case 42:
                            uo0 uo0Var = (uo0) m60Var.j(uo0.B0, o91Var);
                            V();
                            this.B0.add(uo0Var);
                            break;
                        case 50:
                            rq0 rq0Var2 = (rq0) m60Var.j(rq0.J0, o91Var);
                            if ((this.X & 4) == 0) {
                                this.y0 = new ArrayList(this.y0);
                                this.X |= 4;
                            }
                            this.y0.add(rq0Var2);
                            break;
                        case 58:
                            ue1 ue1Var = this.E0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    or0Var = this.D0;
                                    if (or0Var == null) {
                                        or0Var = or0.F0;
                                    }
                                } else {
                                    or0Var = (or0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(or0Var, K(), this.z);
                                this.E0 = ue1Var2;
                                this.D0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.X |= 128;
                            break;
                        case 66:
                            yr0 yr0Var = (yr0) m60Var.j(yr0.A0, o91Var);
                            if ((this.X & 64) == 0) {
                                this.C0 = new ArrayList(this.C0);
                                this.X |= 64;
                            }
                            this.C0.add(yr0Var);
                            break;
                        case 74:
                            xo0 xo0Var = (xo0) m60Var.j(xo0.A0, o91Var);
                            if ((this.X & 256) == 0) {
                                this.F0 = new ArrayList(this.F0);
                                this.X |= 256;
                            }
                            this.F0.add(xo0Var);
                            break;
                        case 82:
                            zt ztVarH = m60Var.h();
                            g92 g92Var = this.G0;
                            if (!g92Var.b) {
                                g92Var = new g92(this.G0);
                                this.G0 = g92Var;
                            }
                            this.X |= 512;
                            g92Var.d(ztVarH);
                            break;
                        case 88:
                            int iO = m60Var.o();
                            if (os0.b(iO) == null) {
                                Q(11, iO);
                            } else {
                                this.H0 = iO;
                                this.X |= 1024;
                            }
                            break;
                        default:
                            if (!u().t(iS, m60Var)) {
                                z = true;
                            }
                            break;
                    }
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
        return yo0.I0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        yo0 yo0VarQ = q();
        if (yo0VarQ.c()) {
            return yo0VarQ;
        }
        throw a1.C(yo0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        or0 or0Var;
        int i = 0;
        while (true) {
            if (i >= this.Z.size()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.y0.size()) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.z0.size()) {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= this.A0.size()) {
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= this.B0.size()) {
                                                int i6 = 0;
                                                while (true) {
                                                    if (i6 >= this.C0.size()) {
                                                        if ((this.X & 128) == 0) {
                                                            return true;
                                                        }
                                                        ue1 ue1Var = this.E0;
                                                        if (ue1Var == null) {
                                                            or0Var = this.D0;
                                                            if (or0Var == null) {
                                                                or0Var = or0.F0;
                                                            }
                                                        } else {
                                                            or0Var = (or0) ue1Var.l();
                                                        }
                                                        if (!or0Var.c()) {
                                                            break;
                                                        }
                                                        return true;
                                                    }
                                                    if (!((yr0) this.C0.get(i6)).c()) {
                                                        break;
                                                    }
                                                    i6++;
                                                }
                                            } else {
                                                if (!((uo0) this.B0.get(i5)).c()) {
                                                    break;
                                                }
                                                i5++;
                                            }
                                        }
                                    } else {
                                        if (!((fp0) this.A0.get(i4)).c()) {
                                            break;
                                        }
                                        i4++;
                                    }
                                }
                            } else {
                                if (!((yo0) this.z0.get(i3)).c()) {
                                    break;
                                }
                                i3++;
                            }
                        }
                    } else {
                        if (!((rq0) this.y0.get(i2)).c()) {
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                if (!((rq0) this.Z.get(i)).c()) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.C0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        yo0 yo0VarQ = q();
        if (yo0VarQ.c()) {
            return yo0VarQ;
        }
        throw a1.C(yo0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof yo0) {
            W((yo0) c1Var);
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
        if (c1Var instanceof yo0) {
            W((yo0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
