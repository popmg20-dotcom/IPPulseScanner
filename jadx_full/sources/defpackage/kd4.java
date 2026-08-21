package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kd4 extends kn1 implements sd4 {
    public g92 A0;
    public List B0;
    public List C0;
    public long D0;
    public long E0;
    public int X;
    public int Y;
    public String Z = "";
    public List y0;
    public g92 z0;

    public kd4() {
        List list = Collections.EMPTY_LIST;
        this.y0 = list;
        g92 g92Var = g92.z;
        this.z0 = g92Var;
        this.A0 = g92Var;
        this.B0 = list;
        this.C0 = list;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.V0;
        vn1Var.a(ld4.class, kd4.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final ld4 p() {
        ld4 ld4VarQ = q();
        if (ld4VarQ.c()) {
            return ld4VarQ;
        }
        throw a1.C(ld4VarQ);
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public final ld4 q() {
        ld4 ld4Var = new ld4(this);
        ld4Var.X = 0;
        ld4Var.Y = "";
        g92 g92Var = g92.z;
        ld4Var.y0 = g92Var;
        ld4Var.z0 = g92Var;
        ld4Var.C0 = 0L;
        ld4Var.D0 = 0L;
        ld4Var.E0 = (byte) -1;
        if ((this.X & 4) != 0) {
            this.y0 = DesugarCollections.unmodifiableList(this.y0);
            this.X &= -5;
        }
        ld4Var.Z = this.y0;
        if ((this.X & 32) != 0) {
            this.B0 = DesugarCollections.unmodifiableList(this.B0);
            this.X &= -33;
        }
        ld4Var.A0 = this.B0;
        if ((this.X & 64) != 0) {
            this.C0 = DesugarCollections.unmodifiableList(this.C0);
            this.X &= -65;
        }
        ld4Var.B0 = this.C0;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                ld4Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                ld4Var.Y = this.Z;
            }
            if ((i & 8) != 0) {
                this.z0.b();
                ld4Var.y0 = this.z0;
            }
            if ((i & 16) != 0) {
                this.A0.b();
                ld4Var.z0 = this.A0;
            }
            if ((i & 128) != 0) {
                ld4Var.C0 = this.D0;
            }
            if ((i & 256) != 0) {
                ld4Var.D0 = this.E0;
            }
        }
        R();
        return ld4Var;
    }

    public final void W(ld4 ld4Var) {
        if (ld4Var == ld4.F0) {
            return;
        }
        int i = ld4Var.X;
        if (i != 0) {
            this.Y = i;
            this.X |= 1;
            S();
        }
        if (!ld4Var.H().isEmpty()) {
            this.Z = ld4Var.Y;
            this.X |= 2;
            S();
        }
        if (!ld4Var.Z.isEmpty()) {
            if (this.y0.isEmpty()) {
                this.y0 = ld4Var.Z;
                this.X &= -5;
            } else {
                if ((this.X & 4) == 0) {
                    this.y0 = new ArrayList(this.y0);
                    this.X |= 4;
                }
                this.y0.addAll(ld4Var.Z);
            }
            S();
        }
        if (!ld4Var.y0.isEmpty()) {
            if (this.z0.isEmpty()) {
                this.z0 = ld4Var.y0;
                this.X |= 8;
            } else {
                g92 g92Var = this.z0;
                if (!g92Var.b) {
                    g92Var = new g92(this.z0);
                    this.z0 = g92Var;
                }
                this.X |= 8;
                g92Var.addAll(ld4Var.y0);
            }
            S();
        }
        if (!ld4Var.z0.isEmpty()) {
            if (this.A0.isEmpty()) {
                this.A0 = ld4Var.z0;
                this.X |= 16;
            } else {
                g92 g92Var2 = this.A0;
                if (!g92Var2.b) {
                    g92Var2 = new g92(this.A0);
                    this.A0 = g92Var2;
                }
                this.X |= 16;
                g92Var2.addAll(ld4Var.z0);
            }
            S();
        }
        if (!ld4Var.A0.isEmpty()) {
            if (this.B0.isEmpty()) {
                this.B0 = ld4Var.A0;
                this.X &= -33;
            } else {
                if ((this.X & 32) == 0) {
                    this.B0 = new ArrayList(this.B0);
                    this.X |= 32;
                }
                this.B0.addAll(ld4Var.A0);
            }
            S();
        }
        if (!ld4Var.B0.isEmpty()) {
            if (this.C0.isEmpty()) {
                this.C0 = ld4Var.B0;
                this.X &= -65;
            } else {
                if ((this.X & 64) == 0) {
                    this.C0 = new ArrayList(this.C0);
                    this.X |= 64;
                }
                this.C0.addAll(ld4Var.B0);
            }
            S();
        }
        long j = ld4Var.C0;
        if (j != 0) {
            this.D0 = j;
            this.X |= 128;
            S();
        }
        long j2 = ld4Var.D0;
        if (j2 != 0) {
            this.E0 = j2;
            this.X |= 256;
            S();
        }
        A(ld4Var.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 8) {
                            this.Y = m60Var.o();
                            this.X |= 1;
                        } else if (iS == 18) {
                            this.Z = m60Var.r();
                            this.X |= 2;
                        } else if (iS == 26) {
                            yh3 yh3Var = (yh3) m60Var.j(yh3.z0, o91Var);
                            if ((this.X & 4) == 0) {
                                this.y0 = new ArrayList(this.y0);
                                this.X |= 4;
                            }
                            this.y0.add(yh3Var);
                        } else if (iS == 34) {
                            hi hiVar = (hi) m60Var.j(hi.F0, o91Var);
                            if ((this.X & 32) == 0) {
                                this.B0 = new ArrayList(this.B0);
                                this.X |= 32;
                            }
                            this.B0.add(hiVar);
                        } else if (iS == 42) {
                            xj2 xj2Var = (xj2) m60Var.j(xj2.D0, o91Var);
                            if ((this.X & 64) == 0) {
                                this.C0 = new ArrayList(this.C0);
                                this.X |= 64;
                            }
                            this.C0.add(xj2Var);
                        } else if (iS == 48) {
                            this.D0 = m60Var.p();
                            this.X |= 128;
                        } else if (iS == 58) {
                            String strR = m60Var.r();
                            g92 g92Var = this.z0;
                            if (!g92Var.b) {
                                g92Var = new g92(this.z0);
                                this.z0 = g92Var;
                            }
                            this.X = 8 | this.X;
                            g92Var.e(strR);
                        } else if (iS == 64) {
                            this.E0 = m60Var.p();
                            this.X |= 256;
                        } else if (iS == 74) {
                            String strR2 = m60Var.r();
                            g92 g92Var2 = this.A0;
                            if (!g92Var2.b) {
                                g92Var2 = new g92(this.A0);
                                this.A0 = g92Var2;
                            }
                            this.X |= 16;
                            g92Var2.e(strR2);
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
        return ld4.F0;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.U0;
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof ld4) {
            W((ld4) c1Var);
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
        if (c1Var instanceof ld4) {
            W((ld4) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
