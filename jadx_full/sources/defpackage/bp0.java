package defpackage;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bp0 extends kn1 {
    public List A0;
    public g92 B0;
    public int C0;
    public int X;
    public Serializable Y = "";
    public List Z;
    public ip0 y0;
    public ue1 z0;

    public bp0() {
        List list = Collections.EMPTY_LIST;
        this.Z = list;
        this.A0 = list;
        this.B0 = g92.z;
        this.C0 = 0;
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.R0;
        vn1Var.a(fp0.class, bp0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final fp0 q() {
        fp0 fp0Var = new fp0(this);
        fp0Var.Y = "";
        fp0Var.A0 = g92.z;
        int i = 0;
        fp0Var.B0 = 0;
        fp0Var.C0 = (byte) -1;
        if ((this.X & 2) != 0) {
            this.Z = DesugarCollections.unmodifiableList(this.Z);
            this.X &= -3;
        }
        fp0Var.Z = this.Z;
        if ((this.X & 8) != 0) {
            this.A0 = DesugarCollections.unmodifiableList(this.A0);
            this.X &= -9;
        }
        fp0Var.z0 = this.A0;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                fp0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 4) != 0) {
                ue1 ue1Var = this.z0;
                fp0Var.y0 = ue1Var == null ? this.y0 : (ip0) ue1Var.b();
                i |= 2;
            }
            if ((i2 & 16) != 0) {
                this.B0.b();
                fp0Var.A0 = this.B0;
            }
            if ((i2 & 32) != 0) {
                fp0Var.B0 = this.C0;
                i |= 4;
            }
            fp0Var.X = i | fp0Var.X;
        }
        R();
        return fp0Var;
    }

    public final void V(fp0 fp0Var) {
        ip0 ip0Var;
        ip0 ip0Var2;
        if (fp0Var == fp0.D0) {
            return;
        }
        if ((fp0Var.X & 1) != 0) {
            this.Y = fp0Var.Y;
            this.X |= 1;
            S();
        }
        if (!fp0Var.Z.isEmpty()) {
            if (this.Z.isEmpty()) {
                this.Z = fp0Var.Z;
                this.X &= -3;
            } else {
                if ((this.X & 2) == 0) {
                    this.Z = new ArrayList(this.Z);
                    this.X |= 2;
                }
                this.Z.addAll(fp0Var.Z);
            }
            S();
        }
        if (fp0Var.K()) {
            ip0 ip0VarJ = fp0Var.J();
            ue1 ue1Var = this.z0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 4) == 0 || (ip0Var = this.y0) == null || ip0Var == (ip0Var2 = ip0.D0)) {
                    this.y0 = ip0VarJ;
                } else {
                    this.X = i | 4;
                    S();
                    ue1 ue1Var2 = this.z0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            ip0 ip0Var3 = this.y0;
                            if (ip0Var3 != null) {
                                ip0Var2 = ip0Var3;
                            }
                        } else {
                            ip0Var2 = (ip0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(ip0Var2, K(), this.z);
                        this.z0 = ue1Var3;
                        this.y0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((hp0) ue1Var2.j()).a0(ip0VarJ);
                }
            } else {
                ue1Var.o(ip0VarJ);
            }
            if (this.y0 != null) {
                this.X |= 4;
                S();
            }
        }
        if (!fp0Var.z0.isEmpty()) {
            if (this.A0.isEmpty()) {
                this.A0 = fp0Var.z0;
                this.X &= -9;
            } else {
                if ((this.X & 8) == 0) {
                    this.A0 = new ArrayList(this.A0);
                    this.X |= 8;
                }
                this.A0.addAll(fp0Var.z0);
            }
            S();
        }
        if (!fp0Var.A0.isEmpty()) {
            if (this.B0.isEmpty()) {
                this.B0 = fp0Var.A0;
                this.X |= 16;
            } else {
                g92 g92Var = this.B0;
                if (!g92Var.b) {
                    g92Var = new g92(this.B0);
                    this.B0 = g92Var;
                }
                this.X |= 16;
                g92Var.addAll(fp0Var.A0);
            }
            S();
        }
        if (fp0Var.L()) {
            os0 os0VarB = os0.b(fp0Var.B0);
            if (os0VarB == null) {
                os0VarB = os0.VISIBILITY_UNSET;
            }
            this.X |= 32;
            this.C0 = os0VarB.b;
            S();
        }
        A(fp0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        ip0 ip0Var;
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 10) {
                            this.Y = m60Var.h();
                            this.X |= 1;
                        } else if (iS == 18) {
                            lp0 lp0Var = (lp0) m60Var.j(lp0.B0, o91Var);
                            if ((this.X & 2) == 0) {
                                this.Z = new ArrayList(this.Z);
                                this.X |= 2;
                            }
                            this.Z.add(lp0Var);
                        } else if (iS == 26) {
                            ue1 ue1Var = this.z0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    ip0Var = this.y0;
                                    if (ip0Var == null) {
                                        ip0Var = ip0.D0;
                                    }
                                } else {
                                    ip0Var = (ip0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(ip0Var, K(), this.z);
                                this.z0 = ue1Var2;
                                this.y0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.X |= 4;
                        } else if (iS == 34) {
                            ep0 ep0Var = (ep0) m60Var.j(ep0.A0, o91Var);
                            if ((this.X & 8) == 0) {
                                this.A0 = new ArrayList(this.A0);
                                this.X |= 8;
                            }
                            this.A0.add(ep0Var);
                        } else if (iS == 42) {
                            zt ztVarH = m60Var.h();
                            g92 g92Var = this.B0;
                            if (!g92Var.b) {
                                g92Var = new g92(this.B0);
                                this.B0 = g92Var;
                            }
                            this.X |= 16;
                            g92Var.d(ztVarH);
                        } else if (iS == 48) {
                            int iO = m60Var.o();
                            if (os0.b(iO) == null) {
                                Q(6, iO);
                            } else {
                                this.C0 = iO;
                                this.X |= 32;
                            }
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
        return fp0.D0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        fp0 fp0VarQ = q();
        if (fp0VarQ.c()) {
            return fp0VarQ;
        }
        throw a1.C(fp0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        ip0 ip0Var;
        int i = 0;
        while (true) {
            if (i >= this.Z.size()) {
                if ((this.X & 4) == 0) {
                    return true;
                }
                ue1 ue1Var = this.z0;
                if (ue1Var == null) {
                    ip0Var = this.y0;
                    if (ip0Var == null) {
                        ip0Var = ip0.D0;
                    }
                } else {
                    ip0Var = (ip0) ue1Var.l();
                }
                if (!ip0Var.c()) {
                    break;
                }
                return true;
            }
            if (!((lp0) this.Z.get(i)).c()) {
                break;
            }
            i++;
        }
        return false;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.Q0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        fp0 fp0VarQ = q();
        if (fp0VarQ.c()) {
            return fp0VarQ;
        }
        throw a1.C(fp0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof fp0) {
            V((fp0) c1Var);
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
        if (c1Var instanceof fp0) {
            V((fp0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
