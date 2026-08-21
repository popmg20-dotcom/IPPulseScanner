package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gs0 extends ln1 {
    public List A0 = Collections.EMPTY_LIST;
    public int Y;
    public gq0 Z;
    public ue1 y0;
    public boolean z0;

    public gs0() {
        int i = yn1.A;
    }

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.r1;
        vn1Var.a(hs0.class, gs0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final hs0 q() {
        hs0 hs0Var = new hs0(this);
        int i = 0;
        hs0Var.y0 = false;
        hs0Var.A0 = (byte) -1;
        if ((this.Y & 4) != 0) {
            this.A0 = DesugarCollections.unmodifiableList(this.A0);
            this.Y &= -5;
        }
        hs0Var.z0 = this.A0;
        int i2 = this.Y;
        if (i2 != 0) {
            if ((i2 & 1) != 0) {
                ue1 ue1Var = this.y0;
                hs0Var.Z = ue1Var == null ? this.Z : (gq0) ue1Var.b();
                i = 1;
            }
            if ((i2 & 2) != 0) {
                hs0Var.y0 = this.z0;
                i |= 2;
            }
            hs0Var.Y = i | hs0Var.Y;
        }
        R();
        return hs0Var;
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return hs0.B0;
    }

    public final void a0(hs0 hs0Var) {
        gq0 gq0Var;
        gq0 gq0Var2;
        if (hs0Var == hs0.B0) {
            return;
        }
        if (hs0Var.N()) {
            gq0 gq0VarK = hs0Var.K();
            ue1 ue1Var = this.y0;
            if (ue1Var == null) {
                int i = this.Y;
                if ((i & 1) == 0 || (gq0Var = this.Z) == null || gq0Var == (gq0Var2 = gq0.G0)) {
                    this.Z = gq0VarK;
                } else {
                    this.Y = i | 1;
                    S();
                    ue1 ue1Var2 = this.y0;
                    if (ue1Var2 == null) {
                        if (ue1Var2 == null) {
                            gq0 gq0Var3 = this.Z;
                            if (gq0Var3 != null) {
                                gq0Var2 = gq0Var3;
                            }
                        } else {
                            gq0Var2 = (gq0) ue1Var2.l();
                        }
                        ue1 ue1Var3 = new ue1(gq0Var2, K(), this.z);
                        this.y0 = ue1Var3;
                        this.Z = null;
                        ue1Var2 = ue1Var3;
                    }
                    ((xp0) ue1Var2.j()).b0(gq0VarK);
                }
            } else {
                ue1Var.o(gq0VarK);
            }
            if (this.Z != null) {
                this.Y |= 1;
                S();
            }
        }
        if (hs0Var.L()) {
            this.z0 = hs0Var.y0;
            this.Y |= 2;
            S();
        }
        if (!hs0Var.z0.isEmpty()) {
            if (this.A0.isEmpty()) {
                this.A0 = hs0Var.z0;
                this.Y &= -5;
            } else {
                if ((this.Y & 4) == 0) {
                    this.A0 = new ArrayList(this.A0);
                    this.Y |= 4;
                }
                this.A0.addAll(hs0Var.z0);
            }
            S();
        }
        W(hs0Var);
        A(hs0Var.z);
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
                        if (iS == 264) {
                            this.z0 = m60Var.g();
                            this.Y |= 2;
                        } else if (iS == 274) {
                            ue1 ue1Var = this.y0;
                            if (ue1Var == null) {
                                if (ue1Var == null) {
                                    gq0Var = this.Z;
                                    if (gq0Var == null) {
                                        gq0Var = gq0.G0;
                                    }
                                } else {
                                    gq0Var = (gq0) ue1Var.l();
                                }
                                ue1 ue1Var2 = new ue1(gq0Var, K(), this.z);
                                this.y0 = ue1Var2;
                                this.Z = null;
                                ue1Var = ue1Var2;
                            }
                            m60Var.k(ue1Var.j(), o91Var);
                            this.Y |= 1;
                        } else if (iS == 7994) {
                            us0 us0Var = (us0) m60Var.j(us0.F0, o91Var);
                            if ((this.Y & 4) == 0) {
                                this.A0 = new ArrayList(this.A0);
                                this.Y |= 4;
                            }
                            this.A0.add(us0Var);
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
        hs0 hs0VarQ = q();
        if (hs0VarQ.c()) {
            return hs0VarQ;
        }
        throw a1.C(hs0VarQ);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    @Override // defpackage.ol2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c() {
        gq0 gq0Var;
        if ((this.Y & 1) == 0) {
            int i = 0;
            while (true) {
                if (i >= this.A0.size()) {
                    if (!V()) {
                        break;
                    }
                    return true;
                }
                if (!((us0) this.A0.get(i)).c()) {
                    break;
                }
                i++;
            }
        } else {
            ue1 ue1Var = this.y0;
            if (ue1Var == null) {
                gq0Var = this.Z;
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
        return vs0.q1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        hs0 hs0VarQ = q();
        if (hs0VarQ.c()) {
            return hs0VarQ;
        }
        throw a1.C(hs0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof hs0) {
            a0((hs0) c1Var);
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
        if (c1Var instanceof hs0) {
            a0((hs0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
