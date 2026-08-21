package defpackage;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ds0 extends kn1 {
    public int X;
    public Serializable Y = "";
    public List Z = Collections.EMPTY_LIST;
    public hs0 y0;
    public ue1 z0;

    public ds0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.X0;
        vn1Var.a(es0.class, ds0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final es0 q() {
        int i;
        es0 es0Var = new es0(this);
        es0Var.Y = "";
        es0Var.z0 = (byte) -1;
        if ((this.X & 2) != 0) {
            this.Z = DesugarCollections.unmodifiableList(this.Z);
            this.X &= -3;
        }
        es0Var.Z = this.Z;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                es0Var.Y = this.Y;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                ue1 ue1Var = this.z0;
                es0Var.y0 = ue1Var == null ? this.y0 : (hs0) ue1Var.b();
                i |= 2;
            }
            es0Var.X |= i;
        }
        R();
        return es0Var;
    }

    public final void V(es0 es0Var) {
        hs0 hs0Var;
        hs0 hs0Var2;
        if (es0Var == es0.A0) {
            return;
        }
        if ((es0Var.X & 1) != 0) {
            this.Y = es0Var.Y;
            this.X |= 1;
            S();
        }
        if (!es0Var.Z.isEmpty()) {
            if (this.Z.isEmpty()) {
                this.Z = es0Var.Z;
                this.X &= -3;
            } else {
                if ((this.X & 2) == 0) {
                    this.Z = new ArrayList(this.Z);
                    this.X |= 2;
                }
                this.Z.addAll(es0Var.Z);
            }
            S();
        }
        if (es0Var.K()) {
            hs0 hs0VarJ = es0Var.J();
            ue1 ue1Var = this.z0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 4) == 0 || (hs0Var = this.y0) == null || hs0Var == (hs0Var2 = hs0.B0)) {
                    this.y0 = hs0VarJ;
                } else {
                    this.X = i | 4;
                    S();
                    ue1 ue1Var2 = this.z0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            hs0 hs0Var3 = this.y0;
                            if (hs0Var3 != null) {
                                hs0Var2 = hs0Var3;
                            }
                        } else {
                            hs0Var2 = (hs0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(hs0Var2, K(), this.z);
                        this.z0 = ue1Var3;
                        this.y0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((gs0) ue1Var2.j()).a0(hs0VarJ);
                }
            } else {
                ue1Var.o(hs0VarJ);
            }
            if (this.y0 != null) {
                this.X |= 4;
                S();
            }
        }
        A(es0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        hs0 hs0Var;
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
                            rr0 rr0Var = (rr0) m60Var.j(rr0.E0, o91Var);
                            if ((this.X & 2) == 0) {
                                this.Z = new ArrayList(this.Z);
                                this.X |= 2;
                            }
                            this.Z.add(rr0Var);
                        } else if (iS == 26) {
                            ue1 ue1Var = this.z0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    hs0Var = this.y0;
                                    if (hs0Var == null) {
                                        hs0Var = hs0.B0;
                                    }
                                } else {
                                    hs0Var = (hs0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(hs0Var, K(), this.z);
                                this.z0 = ue1Var2;
                                this.y0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.X |= 4;
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
        return es0.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        es0 es0VarQ = q();
        if (es0VarQ.c()) {
            return es0VarQ;
        }
        throw a1.C(es0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        hs0 hs0Var;
        int i = 0;
        while (true) {
            if (i >= this.Z.size()) {
                if ((this.X & 4) == 0) {
                    return true;
                }
                ue1 ue1Var = this.z0;
                if (ue1Var == null) {
                    hs0Var = this.y0;
                    if (hs0Var == null) {
                        hs0Var = hs0.B0;
                    }
                } else {
                    hs0Var = (hs0) ue1Var.l();
                }
                if (!hs0Var.c()) {
                    break;
                }
                return true;
            }
            if (!((rr0) this.Z.get(i)).c()) {
                break;
            }
            i++;
        }
        return false;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.W0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        es0 es0VarQ = q();
        if (es0VarQ.c()) {
            return es0VarQ;
        }
        throw a1.C(es0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof es0) {
            V((es0) c1Var);
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
        if (c1Var instanceof es0) {
            V((es0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
