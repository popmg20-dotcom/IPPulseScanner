package defpackage;

import io.netty.handler.ssl.OpenSslSessionTicketKey;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tq0 extends ln1 {
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public List H0;
    public gq0 I0;
    public ue1 J0;
    public ar0 K0;
    public ue1 L0;
    public List M0;
    public int Y;
    public boolean y0;
    public int Z = 0;
    public int z0 = 0;
    public int F0 = 0;
    public x02 G0 = x02.X;

    public tq0() {
        List list = Collections.EMPTY_LIST;
        this.H0 = list;
        this.M0 = list;
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.f1;
        vn1Var.a(er0.class, tq0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final er0 q() {
        er0 er0Var = new er0(this);
        int i = 0;
        er0Var.Z = 0;
        er0Var.y0 = false;
        er0Var.z0 = 0;
        er0Var.A0 = false;
        er0Var.B0 = false;
        er0Var.C0 = false;
        er0Var.D0 = false;
        er0Var.E0 = false;
        er0Var.F0 = 0;
        er0Var.G0 = x02.X;
        er0Var.L0 = (byte) -1;
        if ((this.Y & 1024) != 0) {
            this.H0 = DesugarCollections.unmodifiableList(this.H0);
            this.Y &= -1025;
        }
        er0Var.H0 = this.H0;
        if ((this.Y & 8192) != 0) {
            this.M0 = DesugarCollections.unmodifiableList(this.M0);
            this.Y &= -8193;
        }
        er0Var.K0 = this.M0;
        int i2 = this.Y;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                er0Var.Z = this.Z;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                er0Var.y0 = this.y0;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                er0Var.z0 = this.z0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                er0Var.A0 = this.A0;
                i |= 8;
            }
            if ((i2 & 16) != 0) {
                er0Var.B0 = this.B0;
                i |= 16;
            }
            if ((i2 & 32) != 0) {
                er0Var.C0 = this.C0;
                i |= 32;
            }
            if ((i2 & 64) != 0) {
                er0Var.D0 = this.D0;
                i |= 64;
            }
            if ((i2 & 128) != 0) {
                er0Var.E0 = this.E0;
                i |= 128;
            }
            if ((i2 & 256) != 0) {
                er0Var.F0 = this.F0;
                i |= 256;
            }
            if ((i2 & 512) != 0) {
                this.G0.b();
                er0Var.G0 = this.G0;
            }
            if ((i2 & 2048) != 0) {
                ue1 ue1Var = this.J0;
                er0Var.I0 = ue1Var == null ? this.I0 : (gq0) ue1Var.b();
                i |= 512;
            }
            if ((i2 & 4096) != 0) {
                ue1 ue1Var2 = this.L0;
                er0Var.J0 = ue1Var2 == null ? this.K0 : (ar0) ue1Var2.b();
                i |= 1024;
            }
            er0Var.Y = i | er0Var.Y;
        }
        R();
        return er0Var;
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return er0.M0;
    }

    public final void a0() {
        x02 x02Var = this.G0;
        if (!x02Var.b) {
            this.G0 = (x02) yn1.D(x02Var);
        }
        this.Y |= 512;
    }

    public final ue1 b0() {
        ar0 ar0Var;
        ue1 ue1Var = this.L0;
        if (ue1Var != null) {
            return ue1Var;
        }
        if (ue1Var == null) {
            ar0Var = this.K0;
            if (ar0Var == null) {
                ar0Var = ar0.B0;
            }
        } else {
            ar0Var = (ar0) ue1Var.l();
        }
        ue1 ue1Var2 = new ue1(ar0Var, K(), this.z);
        this.L0 = ue1Var2;
        this.K0 = null;
        return ue1Var2;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        er0 er0VarQ = q();
        if (er0VarQ.c()) {
            return er0VarQ;
        }
        throw a1.C(er0VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    @Override // defpackage.ol2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() {
        /*
            r3 = this;
            int r0 = r3.Y
            r0 = r0 & 2048(0x800, float:2.87E-42)
            r1 = 0
            if (r0 == 0) goto L1f
            ue1 r0 = r3.J0
            if (r0 != 0) goto L12
            gq0 r0 = r3.I0
            if (r0 != 0) goto L18
            gq0 r0 = defpackage.gq0.G0
            goto L18
        L12:
            yn1 r0 = r0.l()
            gq0 r0 = (defpackage.gq0) r0
        L18:
            boolean r0 = r0.c()
            if (r0 != 0) goto L1f
            goto L40
        L1f:
            r0 = r1
        L20:
            java.util.List r2 = r3.M0
            int r2 = r2.size()
            if (r0 >= r2) goto L3a
            java.util.List r2 = r3.M0
            java.lang.Object r2 = r2.get(r0)
            us0 r2 = (defpackage.us0) r2
            boolean r2 = r2.c()
            if (r2 != 0) goto L37
            goto L40
        L37:
            int r0 = r0 + 1
            goto L20
        L3a:
            boolean r3 = r3.V()
            if (r3 != 0) goto L41
        L40:
            return r1
        L41:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tq0.c():boolean");
    }

    public final void c0(er0 er0Var) {
        ar0 ar0Var;
        gq0 gq0Var;
        gq0 gq0Var2;
        cr0 cr0Var;
        br0 br0Var;
        uq0 uq0Var;
        if (er0Var == er0.M0) {
            return;
        }
        if ((er0Var.Y & 1) != 0) {
            int i = er0Var.Z;
            if (i == 0) {
                uq0Var = uq0.STRING;
            } else if (i == 1) {
                uq0Var = uq0.CORD;
            } else if (i != 2) {
                uq0 uq0Var2 = uq0.STRING;
                uq0Var = null;
            } else {
                uq0Var = uq0.STRING_PIECE;
            }
            if (uq0Var == null) {
                uq0Var = uq0.STRING;
            }
            this.Y |= 1;
            this.Z = uq0Var.b;
            S();
        }
        if (er0Var.T()) {
            this.y0 = er0Var.y0;
            this.Y |= 2;
            S();
        }
        if (er0Var.R()) {
            int i2 = er0Var.z0;
            if (i2 == 0) {
                br0Var = br0.JS_NORMAL;
            } else if (i2 == 1) {
                br0Var = br0.JS_STRING;
            } else if (i2 != 2) {
                br0 br0Var2 = br0.JS_NORMAL;
                br0Var = null;
            } else {
                br0Var = br0.JS_NUMBER;
            }
            if (br0Var == null) {
                br0Var = br0.JS_NORMAL;
            }
            this.Y |= 4;
            this.z0 = br0Var.b;
            S();
        }
        if (er0Var.S()) {
            this.A0 = er0Var.A0;
            this.Y |= 8;
            S();
        }
        if (er0Var.V()) {
            this.B0 = er0Var.B0;
            this.Y |= 16;
            S();
        }
        if (er0Var.O()) {
            this.C0 = er0Var.C0;
            this.Y |= 32;
            S();
        }
        if (er0Var.W()) {
            this.D0 = er0Var.D0;
            this.Y |= 64;
            S();
        }
        if (er0Var.N()) {
            this.E0 = er0Var.E0;
            this.Y |= 128;
            S();
        }
        if (er0Var.U()) {
            int i3 = er0Var.F0;
            if (i3 == 0) {
                cr0Var = cr0.RETENTION_UNKNOWN;
            } else if (i3 == 1) {
                cr0Var = cr0.RETENTION_RUNTIME;
            } else if (i3 != 2) {
                cr0 cr0Var2 = cr0.RETENTION_UNKNOWN;
                cr0Var = null;
            } else {
                cr0Var = cr0.RETENTION_SOURCE;
            }
            if (cr0Var == null) {
                cr0Var = cr0.RETENTION_UNKNOWN;
            }
            this.Y |= 256;
            this.F0 = cr0Var.b;
            S();
        }
        if (!er0Var.G0.isEmpty()) {
            if (this.G0.isEmpty()) {
                x02 x02Var = er0Var.G0;
                this.G0 = x02Var;
                x02Var.b();
                this.Y |= 512;
            } else {
                a0();
                this.G0.addAll(er0Var.G0);
            }
            S();
        }
        if (!er0Var.H0.isEmpty()) {
            if (this.H0.isEmpty()) {
                this.H0 = er0Var.H0;
                this.Y &= -1025;
            } else {
                if ((this.Y & 1024) == 0) {
                    this.H0 = new ArrayList(this.H0);
                    this.Y |= 1024;
                }
                this.H0.addAll(er0Var.H0);
            }
            S();
        }
        if (er0Var.Q()) {
            gq0 gq0VarL = er0Var.L();
            ue1 ue1Var = this.J0;
            if (ue1Var == null) {
                int i4 = this.Y;
                if ((i4 & 2048) == 0 || (gq0Var = this.I0) == null || gq0Var == (gq0Var2 = gq0.G0)) {
                    this.I0 = gq0VarL;
                } else {
                    this.Y = i4 | 2048;
                    S();
                    ue1 ue1Var2 = this.J0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            gq0 gq0Var3 = this.I0;
                            if (gq0Var3 != null) {
                                gq0Var2 = gq0Var3;
                            }
                        } else {
                            gq0Var2 = (gq0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(gq0Var2, K(), this.z);
                        this.J0 = ue1Var3;
                        this.I0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((xp0) ue1Var2.j()).b0(gq0VarL);
                }
            } else {
                ue1Var.o(gq0VarL);
            }
            if (this.I0 != null) {
                this.Y |= 2048;
                S();
            }
        }
        if (er0Var.P()) {
            ar0 ar0VarK = er0Var.K();
            ue1 ue1Var4 = this.L0;
            if (ue1Var4 == null) {
                int i5 = this.Y;
                if ((i5 & 4096) == 0 || (ar0Var = this.K0) == null || ar0Var == ar0.B0) {
                    this.K0 = ar0VarK;
                } else {
                    this.Y = i5 | 4096;
                    S();
                    ((zq0) b0().j()).V(ar0VarK);
                }
            } else {
                ue1Var4.o(ar0VarK);
            }
            if (this.K0 != null) {
                this.Y |= 4096;
                S();
            }
        }
        if (!er0Var.K0.isEmpty()) {
            if (this.M0.isEmpty()) {
                this.M0 = er0Var.K0;
                this.Y &= -8193;
            } else {
                if ((this.Y & 8192) == 0) {
                    this.M0 = new ArrayList(this.M0);
                    this.Y |= 8192;
                }
                this.M0.addAll(er0Var.K0);
            }
            S();
        }
        W(er0Var);
        A(er0Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        gq0 gq0Var;
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    Enum r3 = null;
                    switch (iS) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            int iO = m60Var.o();
                            if (iO == 0) {
                                r3 = uq0.STRING;
                            } else if (iO == 1) {
                                r3 = uq0.CORD;
                            } else if (iO != 2) {
                                uq0 uq0Var = uq0.STRING;
                            } else {
                                r3 = uq0.STRING_PIECE;
                            }
                            if (r3 == null) {
                                Q(1, iO);
                            } else {
                                this.Z = iO;
                                this.Y |= 1;
                            }
                            break;
                        case 16:
                            this.y0 = m60Var.g();
                            this.Y |= 2;
                            break;
                        case 24:
                            this.C0 = m60Var.g();
                            this.Y |= 32;
                            break;
                        case 40:
                            this.A0 = m60Var.g();
                            this.Y |= 8;
                            break;
                        case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                            int iO2 = m60Var.o();
                            if (iO2 == 0) {
                                r3 = br0.JS_NORMAL;
                            } else if (iO2 == 1) {
                                r3 = br0.JS_STRING;
                            } else if (iO2 != 2) {
                                br0 br0Var = br0.JS_NORMAL;
                            } else {
                                r3 = br0.JS_NUMBER;
                            }
                            if (r3 == null) {
                                Q(6, iO2);
                            } else {
                                this.z0 = iO2;
                                this.Y |= 4;
                            }
                            break;
                        case 80:
                            this.D0 = m60Var.g();
                            this.Y |= 64;
                            break;
                        case 120:
                            this.B0 = m60Var.g();
                            this.Y |= 16;
                            break;
                        case 128:
                            this.E0 = m60Var.g();
                            this.Y |= 128;
                            break;
                        case 136:
                            int iO3 = m60Var.o();
                            if (iO3 == 0) {
                                r3 = cr0.RETENTION_UNKNOWN;
                            } else if (iO3 == 1) {
                                r3 = cr0.RETENTION_RUNTIME;
                            } else if (iO3 != 2) {
                                cr0 cr0Var = cr0.RETENTION_UNKNOWN;
                            } else {
                                r3 = cr0.RETENTION_SOURCE;
                            }
                            if (r3 == null) {
                                Q(17, iO3);
                            } else {
                                this.F0 = iO3;
                                this.Y |= 256;
                            }
                            break;
                        case 152:
                            int iO4 = m60Var.o();
                            if (dr0.b(iO4) == null) {
                                Q(19, iO4);
                            } else {
                                a0();
                                this.G0.d(iO4);
                            }
                            break;
                        case 154:
                            int iF = m60Var.f(m60Var.o());
                            a0();
                            while (m60Var.c() > 0) {
                                int iO5 = m60Var.o();
                                if (dr0.b(iO5) == null) {
                                    Q(19, iO5);
                                } else {
                                    this.G0.d(iO5);
                                }
                            }
                            m60Var.e(iF);
                            break;
                        case 162:
                            xq0 xq0Var = (xq0) m60Var.j(xq0.A0, o91Var);
                            if ((this.Y & 1024) == 0) {
                                this.H0 = new ArrayList(this.H0);
                                this.Y |= 1024;
                            }
                            this.H0.add(xq0Var);
                            break;
                        case 170:
                            ue1 ue1Var = this.J0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    gq0Var = this.I0;
                                    if (gq0Var == null) {
                                        gq0Var = gq0.G0;
                                    }
                                } else {
                                    gq0Var = (gq0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(gq0Var, K(), this.z);
                                this.J0 = ue1Var2;
                                this.I0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.Y |= 2048;
                            break;
                        case 178:
                            m60Var.k(b0().j(), o91Var);
                            this.Y |= 4096;
                            break;
                        case 7994:
                            us0 us0Var = (us0) m60Var.j(us0.F0, o91Var);
                            if ((this.Y & 8192) == 0) {
                                this.M0 = new ArrayList(this.M0);
                                this.Y |= 8192;
                            }
                            this.M0.add(us0Var);
                            break;
                        default:
                            if (!X(m60Var, o91Var, iS)) {
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

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.e1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        er0 er0VarQ = q();
        if (er0VarQ.c()) {
            return er0VarQ;
        }
        throw a1.C(er0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof er0) {
            c0((er0) c1Var);
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
        if (c1Var instanceof er0) {
            c0((er0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
