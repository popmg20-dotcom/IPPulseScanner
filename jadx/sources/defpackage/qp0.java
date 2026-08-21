package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qp0 extends ln1 {
    public ue1 A0;
    public int B0;
    public int Y;
    public List Z;
    public List y0;
    public gq0 z0;

    public qp0() {
        List list = Collections.EMPTY_LIST;
        this.Z = list;
        this.y0 = list;
        this.B0 = 1;
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.J0;
        vn1Var.a(vp0.class, qp0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final vp0 q() {
        vp0 vp0Var = new vp0(this);
        int i = 1;
        vp0Var.A0 = 1;
        vp0Var.B0 = (byte) -1;
        if ((this.Y & 1) != 0) {
            this.Z = DesugarCollections.unmodifiableList(this.Z);
            this.Y &= -2;
        }
        vp0Var.Z = this.Z;
        if ((this.Y & 2) != 0) {
            this.y0 = DesugarCollections.unmodifiableList(this.y0);
            this.Y &= -3;
        }
        vp0Var.y0 = this.y0;
        int i2 = this.Y;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                ue1 ue1Var = this.A0;
                vp0Var.z0 = ue1Var == null ? this.z0 : (gq0) ue1Var.b();
            } else {
                i = 0;
            }
            if ((i2 & 8) != 0) {
                vp0Var.A0 = this.B0;
                i |= 2;
            }
            vp0Var.Y = i | vp0Var.Y;
        }
        R();
        return vp0Var;
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return vp0.C0;
    }

    public final void a0(vp0 vp0Var) {
        gq0 gq0Var;
        gq0 gq0Var2;
        if (vp0Var == vp0.C0) {
            return;
        }
        if (!vp0Var.Z.isEmpty()) {
            if (this.Z.isEmpty()) {
                this.Z = vp0Var.Z;
                this.Y &= -2;
            } else {
                if ((this.Y & 1) == 0) {
                    this.Z = new ArrayList(this.Z);
                    this.Y |= 1;
                }
                this.Z.addAll(vp0Var.Z);
            }
            S();
        }
        if (!vp0Var.y0.isEmpty()) {
            if (this.y0.isEmpty()) {
                this.y0 = vp0Var.y0;
                this.Y &= -3;
            } else {
                if ((this.Y & 2) == 0) {
                    this.y0 = new ArrayList(this.y0);
                    this.Y |= 2;
                }
                this.y0.addAll(vp0Var.y0);
            }
            S();
        }
        up0 up0Var = null;
        if (vp0Var.L()) {
            gq0 gq0VarK = vp0Var.K();
            ue1 ue1Var = this.A0;
            if (ue1Var == null) {
                int i = this.Y;
                if ((i & 4) == 0 || (gq0Var = this.z0) == null || gq0Var == (gq0Var2 = gq0.G0)) {
                    this.z0 = gq0VarK;
                } else {
                    this.Y = i | 4;
                    S();
                    ue1 ue1Var2 = this.A0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            gq0 gq0Var3 = this.z0;
                            if (gq0Var3 != null) {
                                gq0Var2 = gq0Var3;
                            }
                        } else {
                            gq0Var2 = (gq0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(gq0Var2, K(), this.z);
                        this.A0 = ue1Var3;
                        this.z0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((xp0) ue1Var2.j()).b0(gq0VarK);
                }
            } else {
                ue1Var.o(gq0VarK);
            }
            if (this.z0 != null) {
                this.Y |= 4;
                S();
            }
        }
        if (vp0Var.N()) {
            int i2 = vp0Var.A0;
            if (i2 == 0) {
                up0Var = up0.DECLARATION;
            } else if (i2 != 1) {
                up0 up0Var2 = up0.DECLARATION;
            } else {
                up0Var = up0.UNVERIFIED;
            }
            if (up0Var == null) {
                up0Var = up0.UNVERIFIED;
            }
            this.Y |= 8;
            this.B0 = up0Var.b;
            S();
        }
        W(vp0Var);
        A(vp0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        gq0 gq0Var;
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS != 18) {
                            up0 up0Var = null;
                            if (iS == 24) {
                                int iO = m60Var.o();
                                if (iO == 0) {
                                    up0Var = up0.DECLARATION;
                                } else if (iO != 1) {
                                    up0 up0Var2 = up0.DECLARATION;
                                } else {
                                    up0Var = up0.UNVERIFIED;
                                }
                                if (up0Var == null) {
                                    Q(3, iO);
                                } else {
                                    this.B0 = iO;
                                    this.Y |= 8;
                                }
                            } else if (iS == 402) {
                                ue1 ue1Var = this.A0;
                                if (ue1Var == null) {
                                    if (ue1Var == null) {
                                        gq0Var = this.z0;
                                        if (gq0Var == null) {
                                            gq0Var = gq0.G0;
                                        }
                                    } else {
                                        gq0Var = (gq0) ue1Var.l();
                                    }
                                    ue1 ue1Var2 = new ue1(gq0Var, K(), this.z);
                                    this.A0 = ue1Var2;
                                    this.z0 = null;
                                    ue1Var = ue1Var2;
                                }
                                m60Var.k(ue1Var.j(), o91Var);
                                this.Y |= 4;
                            } else if (iS == 7994) {
                                us0 us0Var = (us0) m60Var.j(us0.F0, o91Var);
                                if ((this.Y & 1) == 0) {
                                    this.Z = new ArrayList(this.Z);
                                    this.Y = 1 | this.Y;
                                }
                                this.Z.add(us0Var);
                            } else if (!X(m60Var, o91Var, iS)) {
                            }
                        } else {
                            tp0 tp0Var = (tp0) m60Var.j(tp0.D0, o91Var);
                            if ((this.Y & 2) == 0) {
                                this.y0 = new ArrayList(this.y0);
                                this.Y |= 2;
                            }
                            this.y0.add(tp0Var);
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

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        vp0 vp0VarQ = q();
        if (vp0VarQ.c()) {
            return vp0VarQ;
        }
        throw a1.C(vp0VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    @Override // defpackage.ol2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r3 = this;
            r0 = 0
            r1 = r0
        L2:
            java.util.List r2 = r3.Z
            int r2 = r2.size()
            if (r1 >= r2) goto L1c
            java.util.List r2 = r3.Z
            java.lang.Object r2 = r2.get(r1)
            us0 r2 = (defpackage.us0) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L19
            goto L40
        L19:
            int r1 = r1 + 1
            goto L2
        L1c:
            int r1 = r3.Y
            r1 = r1 & 4
            if (r1 == 0) goto L3a
            ue1 r1 = r3.A0
            if (r1 != 0) goto L2d
            gq0 r1 = r3.z0
            if (r1 != 0) goto L33
            gq0 r1 = defpackage.gq0.G0
            goto L33
        L2d:
            yn1 r1 = r1.l()
            gq0 r1 = (defpackage.gq0) r1
        L33:
            boolean r1 = r1.c()
            if (r1 != 0) goto L3a
            goto L40
        L3a:
            boolean r3 = r3.V()
            if (r3 != 0) goto L41
        L40:
            return r0
        L41:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qp0.c():boolean");
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.I0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        vp0 vp0VarQ = q();
        if (vp0VarQ.c()) {
            return vp0VarQ;
        }
        throw a1.C(vp0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof vp0) {
            a0((vp0) c1Var);
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
        if (c1Var instanceof vp0) {
            a0((vp0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
