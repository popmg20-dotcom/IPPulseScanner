package defpackage;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gr0 extends kn1 {
    public x02 A0;
    public g92 B0;
    public List C0;
    public List D0;
    public List E0;
    public List F0;
    public lr0 G0;
    public ue1 H0;
    public ns0 I0;
    public ue1 J0;
    public Serializable K0;
    public int L0;
    public int X;
    public Serializable Y = "";
    public Object Z = "";
    public g92 y0;
    public x02 z0;

    public gr0() {
        g92 g92Var = g92.z;
        this.y0 = g92Var;
        x02 x02Var = x02.X;
        this.z0 = x02Var;
        this.A0 = x02Var;
        this.B0 = g92Var;
        List list = Collections.EMPTY_LIST;
        this.C0 = list;
        this.D0 = list;
        this.E0 = list;
        this.F0 = list;
        this.K0 = "";
        this.L0 = 0;
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.B0;
        vn1Var.a(hr0.class, gr0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final hr0 q() {
        hr0 hr0Var = new hr0(this);
        hr0Var.Y = "";
        hr0Var.Z = "";
        g92 g92Var = g92.z;
        hr0Var.y0 = g92Var;
        x02 x02Var = x02.X;
        hr0Var.z0 = x02Var;
        hr0Var.A0 = x02Var;
        hr0Var.B0 = g92Var;
        hr0Var.I0 = "";
        int i = 0;
        hr0Var.J0 = 0;
        hr0Var.K0 = (byte) -1;
        if ((this.X & 64) != 0) {
            this.C0 = DesugarCollections.unmodifiableList(this.C0);
            this.X &= -65;
        }
        hr0Var.C0 = this.C0;
        if ((this.X & 128) != 0) {
            this.D0 = DesugarCollections.unmodifiableList(this.D0);
            this.X &= -129;
        }
        hr0Var.D0 = this.D0;
        if ((this.X & 256) != 0) {
            this.E0 = DesugarCollections.unmodifiableList(this.E0);
            this.X &= -257;
        }
        hr0Var.E0 = this.E0;
        if ((this.X & 512) != 0) {
            this.F0 = DesugarCollections.unmodifiableList(this.F0);
            this.X &= -513;
        }
        hr0Var.F0 = this.F0;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                hr0Var.Y = this.Y;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                hr0Var.Z = this.Z;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                this.y0.b();
                hr0Var.y0 = this.y0;
            }
            if ((i2 & 8) != 0) {
                this.z0.b();
                hr0Var.z0 = this.z0;
            }
            if ((i2 & 16) != 0) {
                this.A0.b();
                hr0Var.A0 = this.A0;
            }
            if ((i2 & 32) != 0) {
                this.B0.b();
                hr0Var.B0 = this.B0;
            }
            if ((i2 & 1024) != 0) {
                ue1 ue1Var = this.H0;
                hr0Var.G0 = ue1Var == null ? this.G0 : (lr0) ue1Var.b();
                i |= 4;
            }
            if ((i2 & 2048) != 0) {
                ue1 ue1Var2 = this.J0;
                hr0Var.H0 = ue1Var2 == null ? this.I0 : (ns0) ue1Var2.b();
                i |= 8;
            }
            if ((i2 & 4096) != 0) {
                hr0Var.I0 = this.K0;
                i |= 16;
            }
            if ((i2 & 8192) != 0) {
                hr0Var.J0 = this.L0;
                i |= 32;
            }
            hr0Var.X = i | hr0Var.X;
        }
        R();
        return hr0Var;
    }

    public final void V() {
        if ((this.X & 64) == 0) {
            this.C0 = new ArrayList(this.C0);
            this.X |= 64;
        }
    }

    public final void W() {
        x02 x02Var = this.z0;
        if (!x02Var.b) {
            this.z0 = (x02) yn1.D(x02Var);
        }
        this.X |= 8;
    }

    public final void X() {
        x02 x02Var = this.A0;
        if (!x02Var.b) {
            this.A0 = (x02) yn1.D(x02Var);
        }
        this.X |= 16;
    }

    public final void Y(hr0 hr0Var) {
        ns0 ns0Var;
        ns0 ns0Var2;
        lr0 lr0Var;
        lr0 lr0Var2;
        if (hr0Var == hr0.L0) {
            return;
        }
        if ((hr0Var.X & 1) != 0) {
            this.Y = hr0Var.Y;
            this.X |= 1;
            S();
        }
        if (hr0Var.Q()) {
            this.Z = hr0Var.Z;
            this.X |= 2;
            S();
        }
        if (!hr0Var.y0.isEmpty()) {
            if (this.y0.isEmpty()) {
                this.y0 = hr0Var.y0;
                this.X |= 4;
            } else {
                g92 g92Var = this.y0;
                if (!g92Var.b) {
                    g92Var = new g92(this.y0);
                    this.y0 = g92Var;
                }
                this.X |= 4;
                g92Var.addAll(hr0Var.y0);
            }
            S();
        }
        if (!hr0Var.z0.isEmpty()) {
            if (this.z0.isEmpty()) {
                x02 x02Var = hr0Var.z0;
                this.z0 = x02Var;
                x02Var.b();
                this.X |= 8;
            } else {
                W();
                this.z0.addAll(hr0Var.z0);
            }
            S();
        }
        if (!hr0Var.A0.isEmpty()) {
            if (this.A0.isEmpty()) {
                x02 x02Var2 = hr0Var.A0;
                this.A0 = x02Var2;
                x02Var2.b();
                this.X |= 16;
            } else {
                X();
                this.A0.addAll(hr0Var.A0);
            }
            S();
        }
        if (!hr0Var.B0.isEmpty()) {
            if (this.B0.isEmpty()) {
                this.B0 = hr0Var.B0;
                this.X |= 32;
            } else {
                g92 g92Var2 = this.B0;
                if (!g92Var2.b) {
                    g92Var2 = new g92(this.B0);
                    this.B0 = g92Var2;
                }
                this.X |= 32;
                g92Var2.addAll(hr0Var.B0);
            }
            S();
        }
        if (!hr0Var.C0.isEmpty()) {
            if (this.C0.isEmpty()) {
                this.C0 = hr0Var.C0;
                this.X &= -65;
            } else {
                V();
                this.C0.addAll(hr0Var.C0);
            }
            S();
        }
        if (!hr0Var.D0.isEmpty()) {
            if (this.D0.isEmpty()) {
                this.D0 = hr0Var.D0;
                this.X &= -129;
            } else {
                if ((this.X & 128) == 0) {
                    this.D0 = new ArrayList(this.D0);
                    this.X |= 128;
                }
                this.D0.addAll(hr0Var.D0);
            }
            S();
        }
        if (!hr0Var.E0.isEmpty()) {
            if (this.E0.isEmpty()) {
                this.E0 = hr0Var.E0;
                this.X &= -257;
            } else {
                if ((this.X & 256) == 0) {
                    this.E0 = new ArrayList(this.E0);
                    this.X |= 256;
                }
                this.E0.addAll(hr0Var.E0);
            }
            S();
        }
        if (!hr0Var.F0.isEmpty()) {
            if (this.F0.isEmpty()) {
                this.F0 = hr0Var.F0;
                this.X &= -513;
            } else {
                if ((this.X & 512) == 0) {
                    this.F0 = new ArrayList(this.F0);
                    this.X |= 512;
                }
                this.F0.addAll(hr0Var.F0);
            }
            S();
        }
        if (hr0Var.P()) {
            lr0 lr0VarJ = hr0Var.J();
            ue1 ue1Var = this.H0;
            if (ue1Var == null) {
                int i = this.X;
                if ((i & 1024) == 0 || (lr0Var = this.G0) == null || lr0Var == (lr0Var2 = lr0.T0)) {
                    this.G0 = lr0VarJ;
                } else {
                    this.X = i | 1024;
                    S();
                    ue1 ue1Var2 = this.H0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            lr0 lr0Var3 = this.G0;
                            if (lr0Var3 != null) {
                                lr0Var2 = lr0Var3;
                            }
                        } else {
                            lr0Var2 = (lr0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(lr0Var2, K(), this.z);
                        this.H0 = ue1Var3;
                        this.G0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((jr0) ue1Var2.j()).a0(lr0VarJ);
                }
            } else {
                ue1Var.o(lr0VarJ);
            }
            if (this.G0 != null) {
                this.X |= 1024;
                S();
            }
        }
        if (hr0Var.R()) {
            ns0 ns0VarL = hr0Var.L();
            ue1 ue1Var4 = this.J0;
            if (ue1Var4 == null) {
                int i2 = this.X;
                if ((i2 & 2048) == 0 || (ns0Var = this.I0) == null || ns0Var == (ns0Var2 = ns0.y0)) {
                    this.I0 = ns0VarL;
                } else {
                    this.X = i2 | 2048;
                    S();
                    ue1 ue1Var5 = this.J0;
                    if (ue1Var5 == null) {
                        if (ue1Var5 == null) {
                            ns0 ns0Var3 = this.I0;
                            if (ns0Var3 != null) {
                                ns0Var2 = ns0Var3;
                            }
                        } else {
                            ns0Var2 = (ns0) ue1Var5.l();
                        }
                        ue1 ue1Var6 = new ue1(ns0Var2, K(), this.z);
                        this.J0 = ue1Var6;
                        this.I0 = null;
                        ue1Var5 = ue1Var6;
                    }
                    ((js0) ue1Var5.j()).a0(ns0VarL);
                }
            } else {
                ue1Var4.o(ns0VarL);
            }
            if (this.I0 != null) {
                this.X |= 2048;
                S();
            }
        }
        if (hr0Var.S()) {
            this.K0 = hr0Var.I0;
            this.X |= 4096;
            S();
        }
        if (hr0Var.O()) {
            zo0 zo0VarB = zo0.b(hr0Var.J0);
            if (zo0VarB == null) {
                zo0VarB = zo0.EDITION_UNKNOWN;
            }
            this.X |= 8192;
            this.L0 = zo0VarB.b;
            S();
        }
        A(hr0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        lr0 lr0Var;
        ns0 ns0Var;
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
                            this.Z = m60Var.h();
                            this.X |= 2;
                            break;
                        case 26:
                            zt ztVarH = m60Var.h();
                            g92 g92Var = this.y0;
                            if (!g92Var.b) {
                                g92Var = new g92(this.y0);
                                this.y0 = g92Var;
                            }
                            this.X |= 4;
                            g92Var.d(ztVarH);
                            break;
                        case 34:
                            yo0 yo0Var = (yo0) m60Var.j(yo0.J0, o91Var);
                            V();
                            this.C0.add(yo0Var);
                            break;
                        case 42:
                            fp0 fp0Var = (fp0) m60Var.j(fp0.E0, o91Var);
                            if ((this.X & 128) == 0) {
                                this.D0 = new ArrayList(this.D0);
                                this.X |= 128;
                            }
                            this.D0.add(fp0Var);
                            break;
                        case 50:
                            es0 es0Var = (es0) m60Var.j(es0.B0, o91Var);
                            if ((this.X & 256) == 0) {
                                this.E0 = new ArrayList(this.E0);
                                this.X |= 256;
                            }
                            this.E0.add(es0Var);
                            break;
                        case 58:
                            rq0 rq0Var = (rq0) m60Var.j(rq0.J0, o91Var);
                            if ((this.X & 512) == 0) {
                                this.F0 = new ArrayList(this.F0);
                                this.X |= 512;
                            }
                            this.F0.add(rq0Var);
                            break;
                        case 66:
                            ue1 ue1Var = this.H0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    lr0Var = this.G0;
                                    if (lr0Var == null) {
                                        lr0Var = lr0.T0;
                                    }
                                } else {
                                    lr0Var = (lr0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(lr0Var, K(), this.z);
                                this.H0 = ue1Var2;
                                this.G0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.X |= 1024;
                            break;
                        case 74:
                            ue1 ue1Var3 = this.J0;
                            if (ue1Var3 == null) {
                                if (ue1Var3 == null) {
                                    ns0Var = this.I0;
                                    if (ns0Var == null) {
                                        ns0Var = ns0.y0;
                                    }
                                } else {
                                    ns0Var = (ns0) ue1Var3.l();
                                }
                                ue1 ue1Var4 = new ue1(ns0Var, K(), this.z);
                                this.J0 = ue1Var4;
                                this.I0 = null;
                                ue1Var3 = ue1Var4;
                            }
                            m60Var.k(ue1Var3.j(), o91Var);
                            this.X |= 2048;
                            break;
                        case 80:
                            int iO = m60Var.o();
                            W();
                            this.z0.d(iO);
                            break;
                        case 82:
                            int iF = m60Var.f(m60Var.o());
                            W();
                            while (m60Var.c() > 0) {
                                this.z0.d(m60Var.o());
                            }
                            m60Var.e(iF);
                            break;
                        case 88:
                            int iO2 = m60Var.o();
                            X();
                            this.A0.d(iO2);
                            break;
                        case 90:
                            int iF2 = m60Var.f(m60Var.o());
                            X();
                            while (m60Var.c() > 0) {
                                this.A0.d(m60Var.o());
                            }
                            m60Var.e(iF2);
                            break;
                        case 98:
                            this.K0 = m60Var.h();
                            this.X |= 4096;
                            break;
                        case 112:
                            int iO3 = m60Var.o();
                            if (zo0.b(iO3) == null) {
                                Q(14, iO3);
                            } else {
                                this.L0 = iO3;
                                this.X |= 8192;
                            }
                            break;
                        case 122:
                            zt ztVarH2 = m60Var.h();
                            g92 g92Var2 = this.B0;
                            if (!g92Var2.b) {
                                g92Var2 = new g92(this.B0);
                                this.B0 = g92Var2;
                            }
                            this.X |= 32;
                            g92Var2.d(ztVarH2);
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
        return hr0.L0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        hr0 hr0VarQ = q();
        if (hr0VarQ.c()) {
            return hr0VarQ;
        }
        throw a1.C(hr0VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
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
            java.util.List r2 = r3.C0
            int r2 = r2.size()
            if (r1 >= r2) goto L1d
            java.util.List r2 = r3.C0
            java.lang.Object r2 = r2.get(r1)
            yo0 r2 = (defpackage.yo0) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L1a
            goto Laa
        L1a:
            int r1 = r1 + 1
            goto L2
        L1d:
            r1 = r0
        L1e:
            java.util.List r2 = r3.D0
            int r2 = r2.size()
            if (r1 >= r2) goto L39
            java.util.List r2 = r3.D0
            java.lang.Object r2 = r2.get(r1)
            fp0 r2 = (defpackage.fp0) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L36
            goto Laa
        L36:
            int r1 = r1 + 1
            goto L1e
        L39:
            r1 = r0
        L3a:
            java.util.List r2 = r3.E0
            int r2 = r2.size()
            if (r1 >= r2) goto L54
            java.util.List r2 = r3.E0
            java.lang.Object r2 = r2.get(r1)
            es0 r2 = (defpackage.es0) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L51
            goto Laa
        L51:
            int r1 = r1 + 1
            goto L3a
        L54:
            r1 = r0
        L55:
            java.util.List r2 = r3.F0
            int r2 = r2.size()
            if (r1 >= r2) goto L6f
            java.util.List r2 = r3.F0
            java.lang.Object r2 = r2.get(r1)
            rq0 r2 = (defpackage.rq0) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L6c
            goto Laa
        L6c:
            int r1 = r1 + 1
            goto L55
        L6f:
            int r1 = r3.X
            r1 = r1 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L8d
            ue1 r1 = r3.H0
            if (r1 != 0) goto L80
            lr0 r1 = r3.G0
            if (r1 != 0) goto L86
            lr0 r1 = defpackage.lr0.T0
            goto L86
        L80:
            yn1 r1 = r1.l()
            lr0 r1 = (defpackage.lr0) r1
        L86:
            boolean r1 = r1.c()
            if (r1 != 0) goto L8d
            goto Laa
        L8d:
            int r1 = r3.X
            r1 = r1 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto Lab
            ue1 r1 = r3.J0
            if (r1 != 0) goto L9e
            ns0 r3 = r3.I0
            if (r3 != 0) goto La4
            ns0 r3 = defpackage.ns0.y0
            goto La4
        L9e:
            yn1 r3 = r1.l()
            ns0 r3 = (defpackage.ns0) r3
        La4:
            boolean r3 = r3.c()
            if (r3 != 0) goto Lab
        Laa:
            return r0
        Lab:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gr0.c():boolean");
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.A0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        hr0 hr0VarQ = q();
        if (hr0VarQ.c()) {
            return hr0VarQ;
        }
        throw a1.C(hr0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof hr0) {
            Y((hr0) c1Var);
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
        if (c1Var instanceof hr0) {
            Y((hr0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
