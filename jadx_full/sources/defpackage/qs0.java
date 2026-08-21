package defpackage;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qs0 extends kn1 {
    public double A0;
    public int X;
    public long y0;
    public long z0;
    public List Y = Collections.EMPTY_LIST;
    public Serializable Z = "";
    public zt B0 = zt.z;
    public Serializable C0 = "";

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.v1;
        vn1Var.a(us0.class, qs0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final us0 q() {
        us0 us0Var = new us0(this);
        us0Var.Z = "";
        us0Var.y0 = 0L;
        us0Var.z0 = 0L;
        us0Var.A0 = 0.0d;
        us0Var.B0 = zt.z;
        us0Var.C0 = "";
        us0Var.D0 = (byte) -1;
        int i = 1;
        if ((this.X & 1) != 0) {
            this.Y = DesugarCollections.unmodifiableList(this.Y);
            this.X &= -2;
        }
        us0Var.Y = this.Y;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 2) != 0) {
                us0Var.Z = this.Z;
            } else {
                i = 0;
            }
            if ((i2 & 4) != 0) {
                us0Var.y0 = this.y0;
                i |= 2;
            }
            if ((i2 & 8) != 0) {
                us0Var.z0 = this.z0;
                i |= 4;
            }
            if ((i2 & 16) != 0) {
                us0Var.A0 = this.A0;
                i |= 8;
            }
            if ((i2 & 32) != 0) {
                us0Var.B0 = this.B0;
                i |= 16;
            }
            if ((i2 & 64) != 0) {
                us0Var.C0 = this.C0;
                i |= 32;
            }
            us0Var.X |= i;
        }
        R();
        return us0Var;
    }

    public final void V(us0 us0Var) {
        if (us0Var == us0.E0) {
            return;
        }
        if (!us0Var.Y.isEmpty()) {
            if (this.Y.isEmpty()) {
                this.Y = us0Var.Y;
                this.X &= -2;
            } else {
                if ((this.X & 1) == 0) {
                    this.Y = new ArrayList(this.Y);
                    this.X |= 1;
                }
                this.Y.addAll(us0Var.Y);
            }
            S();
        }
        if ((us0Var.X & 1) != 0) {
            this.Z = us0Var.Z;
            this.X |= 2;
            S();
        }
        if (us0Var.O()) {
            this.y0 = us0Var.y0;
            this.X |= 4;
            S();
        }
        if (us0Var.N()) {
            this.z0 = us0Var.z0;
            this.X |= 8;
            S();
        }
        if (us0Var.L()) {
            this.A0 = us0Var.A0;
            this.X |= 16;
            S();
        }
        if (us0Var.P()) {
            zt ztVar = us0Var.B0;
            ztVar.getClass();
            this.B0 = ztVar;
            this.X |= 32;
            S();
        }
        if (us0Var.K()) {
            this.C0 = us0Var.C0;
            this.X |= 64;
            S();
        }
        A(us0Var.z);
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
                        if (iS == 18) {
                            ts0 ts0Var = (ts0) m60Var.j(ts0.A0, o91Var);
                            if ((this.X & 1) == 0) {
                                this.Y = new ArrayList(this.Y);
                                this.X = 1 | this.X;
                            }
                            this.Y.add(ts0Var);
                        } else if (iS == 26) {
                            this.Z = m60Var.h();
                            this.X |= 2;
                        } else if (iS == 32) {
                            this.y0 = m60Var.p();
                            this.X |= 4;
                        } else if (iS == 40) {
                            this.z0 = m60Var.p();
                            this.X |= 8;
                        } else if (iS == 49) {
                            this.A0 = Double.longBitsToDouble(m60Var.n());
                            this.X |= 16;
                        } else if (iS == 58) {
                            this.B0 = m60Var.h();
                            this.X |= 32;
                        } else if (iS == 66) {
                            this.C0 = m60Var.h();
                            this.X |= 64;
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
        return us0.E0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        us0 us0VarQ = q();
        if (us0VarQ.c()) {
            return us0VarQ;
        }
        throw a1.C(us0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        for (int i = 0; i < this.Y.size(); i++) {
            if (!((ts0) this.Y.get(i)).c()) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.u1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        us0 us0VarQ = q();
        if (us0VarQ.c()) {
            return us0VarQ;
        }
        throw a1.C(us0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof us0) {
            V((us0) c1Var);
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
        if (c1Var instanceof us0) {
            V((us0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
