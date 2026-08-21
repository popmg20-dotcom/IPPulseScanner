package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tr0 extends ln1 {
    public ue1 A0;
    public int Y;
    public boolean Z;
    public gq0 z0;
    public int y0 = 0;
    public List B0 = Collections.EMPTY_LIST;

    public tr0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.t1;
        vn1Var.a(vr0.class, tr0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final vr0 q() {
        vr0 vr0Var = new vr0(this);
        int i = 0;
        vr0Var.Z = false;
        vr0Var.y0 = 0;
        vr0Var.B0 = (byte) -1;
        if ((this.Y & 8) != 0) {
            this.B0 = DesugarCollections.unmodifiableList(this.B0);
            this.Y &= -9;
        }
        vr0Var.A0 = this.B0;
        int i2 = this.Y;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                vr0Var.Z = this.Z;
                i = 1;
            }
            if ((i2 & 2) != 0) {
                vr0Var.y0 = this.y0;
                i |= 2;
            }
            if ((i2 & 4) != 0) {
                ue1 ue1Var = this.A0;
                vr0Var.z0 = ue1Var == null ? this.z0 : (gq0) ue1Var.b();
                i |= 4;
            }
            vr0Var.Y = i | vr0Var.Y;
        }
        R();
        return vr0Var;
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return vr0.C0;
    }

    public final void a0(vr0 vr0Var) {
        gq0 gq0Var;
        gq0 gq0Var2;
        ur0 ur0Var;
        if (vr0Var == vr0.C0) {
            return;
        }
        if ((vr0Var.Y & 1) != 0) {
            this.Z = vr0Var.Z;
            this.Y |= 1;
            S();
        }
        if (vr0Var.N()) {
            int i = vr0Var.y0;
            if (i == 0) {
                ur0Var = ur0.IDEMPOTENCY_UNKNOWN;
            } else if (i == 1) {
                ur0Var = ur0.NO_SIDE_EFFECTS;
            } else if (i != 2) {
                ur0 ur0Var2 = ur0.IDEMPOTENCY_UNKNOWN;
                ur0Var = null;
            } else {
                ur0Var = ur0.IDEMPOTENT;
            }
            if (ur0Var == null) {
                ur0Var = ur0.IDEMPOTENCY_UNKNOWN;
            }
            this.Y |= 2;
            this.y0 = ur0Var.b;
            S();
        }
        if (vr0Var.L()) {
            gq0 gq0VarK = vr0Var.K();
            ue1 ue1Var = this.A0;
            if (ue1Var == null) {
                int i2 = this.Y;
                if ((i2 & 4) == 0 || (gq0Var = this.z0) == null || gq0Var == (gq0Var2 = gq0.G0)) {
                    this.z0 = gq0VarK;
                } else {
                    this.Y = i2 | 4;
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
        if (!vr0Var.A0.isEmpty()) {
            if (this.B0.isEmpty()) {
                this.B0 = vr0Var.A0;
                this.Y &= -9;
            } else {
                if ((this.Y & 8) == 0) {
                    this.B0 = new ArrayList(this.B0);
                    this.Y |= 8;
                }
                this.B0.addAll(vr0Var.A0);
            }
            S();
        }
        W(vr0Var);
        A(vr0Var.z);
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
                        if (iS != 264) {
                            ur0 ur0Var = null;
                            if (iS == 272) {
                                int iO = m60Var.o();
                                if (iO == 0) {
                                    ur0Var = ur0.IDEMPOTENCY_UNKNOWN;
                                } else if (iO == 1) {
                                    ur0Var = ur0.NO_SIDE_EFFECTS;
                                } else if (iO != 2) {
                                    ur0 ur0Var2 = ur0.IDEMPOTENCY_UNKNOWN;
                                } else {
                                    ur0Var = ur0.IDEMPOTENT;
                                }
                                if (ur0Var == null) {
                                    Q(34, iO);
                                } else {
                                    this.y0 = iO;
                                    this.Y |= 2;
                                }
                            } else if (iS == 282) {
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
                                if ((this.Y & 8) == 0) {
                                    this.B0 = new ArrayList(this.B0);
                                    this.Y |= 8;
                                }
                                this.B0.add(us0Var);
                            } else if (!X(m60Var, o91Var, iS)) {
                            }
                        } else {
                            this.Z = m60Var.g();
                            this.Y |= 1;
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
        vr0 vr0VarQ = q();
        if (vr0VarQ.c()) {
            return vr0VarQ;
        }
        throw a1.C(vr0VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    @Override // defpackage.ol2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c() {
        gq0 gq0Var;
        if ((this.Y & 4) == 0) {
            int i = 0;
            while (true) {
                if (i >= this.B0.size()) {
                    if (!V()) {
                        break;
                    }
                    return true;
                }
                if (!((us0) this.B0.get(i)).c()) {
                    break;
                }
                i++;
            }
        } else {
            ue1 ue1Var = this.A0;
            if (ue1Var == null) {
                gq0Var = this.z0;
                if (gq0Var == null) {
                    gq0Var = gq0.G0;
                }
            } else {
                gq0Var = (gq0) ue1Var.l();
            }
            if (gq0Var.c()) {
            }
        }
        return false;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.s1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        vr0 vr0VarQ = q();
        if (vr0VarQ.c()) {
            return vr0VarQ;
        }
        throw a1.C(vr0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof vr0) {
            a0((vr0) c1Var);
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
        if (c1Var instanceof vr0) {
            a0((vr0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
