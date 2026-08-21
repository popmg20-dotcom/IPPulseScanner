package defpackage;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iq0 extends kn1 {
    public int X;
    public List Y = Collections.EMPTY_LIST;
    public int Z = 0;
    public int y0 = 0;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = vs0.B1;
        vn1Var.a(mq0.class, iq0.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final mq0 q() {
        mq0 mq0Var = new mq0(this);
        int i = 0;
        mq0Var.Z = 0;
        mq0Var.y0 = 0;
        mq0Var.z0 = (byte) -1;
        if ((this.X & 1) != 0) {
            this.Y = DesugarCollections.unmodifiableList(this.Y);
            this.X &= -2;
        }
        mq0Var.Y = this.Y;
        int i2 = this.X;
        if (i2 != 0) {
            if ((i2 & 2) != 0) {
                mq0Var.Z = this.Z;
                i = 1;
            }
            if ((i2 & 4) != 0) {
                mq0Var.y0 = this.y0;
                i |= 2;
            }
            mq0Var.X = i | mq0Var.X;
        }
        R();
        return mq0Var;
    }

    public final void V(mq0 mq0Var) {
        if (mq0Var == mq0.A0) {
            return;
        }
        if (!mq0Var.Y.isEmpty()) {
            if (this.Y.isEmpty()) {
                this.Y = mq0Var.Y;
                this.X &= -2;
            } else {
                if ((this.X & 1) == 0) {
                    this.Y = new ArrayList(this.Y);
                    this.X |= 1;
                }
                this.Y.addAll(mq0Var.Y);
            }
            S();
        }
        if ((mq0Var.X & 1) != 0) {
            zo0 zo0VarB = zo0.b(mq0Var.Z);
            if (zo0VarB == null) {
                zo0VarB = zo0.EDITION_UNKNOWN;
            }
            this.X |= 2;
            this.Z = zo0VarB.b;
            S();
        }
        if (mq0Var.H()) {
            zo0 zo0VarB2 = zo0.b(mq0Var.y0);
            if (zo0VarB2 == null) {
                zo0VarB2 = zo0.EDITION_UNKNOWN;
            }
            this.X |= 4;
            this.y0 = zo0VarB2.b;
            S();
        }
        A(mq0Var.z);
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
                        if (iS == 10) {
                            lq0 lq0Var = (lq0) m60Var.j(lq0.B0, o91Var);
                            if ((this.X & 1) == 0) {
                                this.Y = new ArrayList(this.Y);
                                this.X = 1 | this.X;
                            }
                            this.Y.add(lq0Var);
                        } else if (iS == 32) {
                            int iO = m60Var.o();
                            if (zo0.b(iO) == null) {
                                Q(4, iO);
                            } else {
                                this.Z = iO;
                                this.X |= 2;
                            }
                        } else if (iS == 40) {
                            int iO2 = m60Var.o();
                            if (zo0.b(iO2) == null) {
                                Q(5, iO2);
                            } else {
                                this.y0 = iO2;
                                this.X |= 4;
                            }
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
        return mq0.A0;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        mq0 mq0VarQ = q();
        if (mq0VarQ.c()) {
            return mq0VarQ;
        }
        throw a1.C(mq0VarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        for (int i = 0; i < this.Y.size(); i++) {
            if (!((lq0) this.Y.get(i)).c()) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return vs0.A1;
    }

    @Override // defpackage.a1
    public final c1 p() {
        mq0 mq0VarQ = q();
        if (mq0VarQ.c()) {
            return mq0VarQ;
        }
        throw a1.C(mq0VarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof mq0) {
            V((mq0) c1Var);
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
        if (c1Var instanceof mq0) {
            V((mq0) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
