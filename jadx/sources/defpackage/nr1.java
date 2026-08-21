package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nr1 extends kn1 {
    public long A0;
    public List B0;
    public int X;
    public long Y;
    public long Z;
    public long y0;
    public List z0;

    public nr1() {
        List list = Collections.EMPTY_LIST;
        this.z0 = list;
        this.B0 = list;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.N0;
        vn1Var.a(or1.class, nr1.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final or1 q() {
        or1 or1Var = new or1(this);
        or1Var.X = 0L;
        or1Var.Y = 0L;
        or1Var.Z = 0L;
        or1Var.z0 = 0L;
        or1Var.B0 = (byte) -1;
        if ((this.X & 8) != 0) {
            this.z0 = DesugarCollections.unmodifiableList(this.z0);
            this.X &= -9;
        }
        or1Var.y0 = this.z0;
        if ((this.X & 32) != 0) {
            this.B0 = DesugarCollections.unmodifiableList(this.B0);
            this.X &= -33;
        }
        or1Var.A0 = this.B0;
        int i = this.X;
        if (i != 0) {
            if ((i & 1) != 0) {
                or1Var.X = this.Y;
            }
            if ((i & 2) != 0) {
                or1Var.Y = this.Z;
            }
            if ((i & 4) != 0) {
                or1Var.Z = this.y0;
            }
            if ((i & 16) != 0) {
                or1Var.z0 = this.A0;
            }
        }
        R();
        return or1Var;
    }

    public final void V(or1 or1Var) {
        if (or1Var == or1.C0) {
            return;
        }
        long j = or1Var.X;
        if (j != 0) {
            this.Y = j;
            this.X |= 1;
            S();
        }
        long j2 = or1Var.Y;
        if (j2 != 0) {
            this.Z = j2;
            this.X |= 2;
            S();
        }
        long j3 = or1Var.Z;
        if (j3 != 0) {
            this.y0 = j3;
            this.X |= 4;
            S();
        }
        if (!or1Var.y0.isEmpty()) {
            if (this.z0.isEmpty()) {
                this.z0 = or1Var.y0;
                this.X &= -9;
            } else {
                if ((this.X & 8) == 0) {
                    this.z0 = new ArrayList(this.z0);
                    this.X |= 8;
                }
                this.z0.addAll(or1Var.y0);
            }
            S();
        }
        long j4 = or1Var.z0;
        if (j4 != 0) {
            this.A0 = j4;
            this.X |= 16;
            S();
        }
        if (!or1Var.A0.isEmpty()) {
            if (this.B0.isEmpty()) {
                this.B0 = or1Var.A0;
                this.X &= -33;
            } else {
                if ((this.X & 32) == 0) {
                    this.B0 = new ArrayList(this.B0);
                    this.X |= 32;
                }
                this.B0.addAll(or1Var.A0);
            }
            S();
        }
        A(or1Var.z);
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
                            hi hiVar = (hi) m60Var.j(hi.F0, o91Var);
                            if ((this.X & 8) == 0) {
                                this.z0 = new ArrayList(this.z0);
                                this.X |= 8;
                            }
                            this.z0.add(hiVar);
                        } else if (iS == 40) {
                            this.A0 = m60Var.p();
                            this.X |= 16;
                        } else if (iS == 50) {
                            hi hiVar2 = (hi) m60Var.j(hi.F0, o91Var);
                            if ((this.X & 32) == 0) {
                                this.B0 = new ArrayList(this.B0);
                                this.X |= 32;
                            }
                            this.B0.add(hiVar2);
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
        return or1.C0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        or1 or1VarQ = q();
        if (or1VarQ.c()) {
            return or1VarQ;
        }
        throw a1.C(or1VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.M0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        or1 or1VarQ = q();
        if (or1VarQ.c()) {
            return or1VarQ;
        }
        throw a1.C(or1VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof or1) {
            V((or1) c1Var);
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
        if (c1Var instanceof or1) {
            V((or1) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
