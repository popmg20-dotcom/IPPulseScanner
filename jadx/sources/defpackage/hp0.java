package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hp0 extends ln1 {
    public gq0 A0;
    public ue1 B0;
    public List C0 = Collections.EMPTY_LIST;
    public int Y;
    public boolean Z;
    public boolean y0;
    public boolean z0;

    public hp0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.n1;
        vn1Var.a(ip0.class, hp0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final ip0 q() {
        ip0 ip0Var = new ip0(this);
        int i = 0;
        ip0Var.Z = false;
        ip0Var.y0 = false;
        ip0Var.z0 = false;
        ip0Var.C0 = (byte) -1;
        if ((this.Y & 16) != 0) {
            this.C0 = DesugarCollections.unmodifiableList(this.C0);
            this.Y &= -17;
        }
        ip0Var.B0 = this.C0;
        int i2 = this.Y;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                ip0Var.Z = this.Z;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                ip0Var.y0 = this.y0;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                ip0Var.z0 = this.z0;
                i |= 4;
            }
            if ((i2 & 8) != 0) {
                ue1 ue1Var = this.B0;
                ip0Var.A0 = ue1Var == null ? this.A0 : (gq0) ue1Var.b();
                i |= 8;
            }
            ip0Var.Y = i | ip0Var.Y;
        }
        R();
        return ip0Var;
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return ip0.D0;
    }

    public final void a0(ip0 ip0Var) {
        gq0 gq0Var;
        gq0 gq0Var2;
        if (ip0Var == ip0.D0) {
            return;
        }
        if ((ip0Var.Y & 1) != 0) {
            this.Z = ip0Var.Z;
            this.Y |= 1;
            S();
        }
        if (ip0Var.L()) {
            this.y0 = ip0Var.y0;
            this.Y |= 2;
            S();
        }
        if (ip0Var.N()) {
            this.z0 = ip0Var.z0;
            this.Y |= 4;
            S();
        }
        if (ip0Var.O()) {
            gq0 gq0VarK = ip0Var.K();
            ue1 ue1Var = this.B0;
            if (ue1Var == null) {
                int i = this.Y;
                if ((i & 8) == 0 || (gq0Var = this.A0) == null || gq0Var == (gq0Var2 = gq0.G0)) {
                    this.A0 = gq0VarK;
                } else {
                    this.Y = i | 8;
                    S();
                    ue1 ue1Var2 = this.B0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            gq0 gq0Var3 = this.A0;
                            if (gq0Var3 != null) {
                                gq0Var2 = gq0Var3;
                            }
                        } else {
                            gq0Var2 = (gq0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(gq0Var2, K(), this.z);
                        this.B0 = ue1Var3;
                        this.A0 = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((xp0) ue1Var2.j()).b0(gq0VarK);
                }
            } else {
                ue1Var.o(gq0VarK);
            }
            if (this.A0 != null) {
                this.Y |= 8;
                S();
            }
        }
        if (!ip0Var.B0.isEmpty()) {
            if (this.C0.isEmpty()) {
                this.C0 = ip0Var.B0;
                this.Y &= -17;
            } else {
                if ((this.Y & 16) == 0) {
                    this.C0 = new ArrayList(this.C0);
                    this.Y |= 16;
                }
                this.C0.addAll(ip0Var.B0);
            }
            S();
        }
        W(ip0Var);
        A(ip0Var.z);
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
                        if (iS == 16) {
                            this.Z = m60Var.g();
                            this.Y |= 1;
                        } else if (iS == 24) {
                            this.y0 = m60Var.g();
                            this.Y |= 2;
                        } else if (iS == 48) {
                            this.z0 = m60Var.g();
                            this.Y |= 4;
                        } else if (iS == 58) {
                            ue1 ue1Var = this.B0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    gq0Var = this.A0;
                                    if (gq0Var == null) {
                                        gq0Var = gq0.G0;
                                    }
                                } else {
                                    gq0Var = (gq0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(gq0Var, K(), this.z);
                                this.B0 = ue1Var2;
                                this.A0 = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.Y |= 8;
                        } else if (iS == 7994) {
                            us0 us0Var = (us0) m60Var.j(us0.F0, o91Var);
                            if ((this.Y & 16) == 0) {
                                this.C0 = new ArrayList(this.C0);
                                this.Y |= 16;
                            }
                            this.C0.add(us0Var);
                        } else if (!X(m60Var, o91Var, iS)) {
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
        ip0 ip0VarQ = q();
        if (ip0VarQ.c()) {
            return ip0VarQ;
        }
        throw a1.C(ip0VarQ);
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
            r0 = r0 & 8
            r1 = 0
            if (r0 == 0) goto L1f
            ue1 r0 = r3.B0
            if (r0 != 0) goto L12
            gq0 r0 = r3.A0
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
            java.util.List r2 = r3.C0
            int r2 = r2.size()
            if (r0 >= r2) goto L3a
            java.util.List r2 = r3.C0
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hp0.c():boolean");
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.m1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        ip0 ip0VarQ = q();
        if (ip0VarQ.c()) {
            return ip0VarQ;
        }
        throw a1.C(ip0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ip0) {
            a0((ip0) c1Var);
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
        if (c1Var instanceof ip0) {
            a0((ip0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
