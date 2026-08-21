package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nq1 extends jc0 {
    public float p0 = -1.0f;
    public int q0 = -1;
    public int r0 = -1;
    public lb0 s0 = this.I;
    public int t0 = 0;
    public boolean u0;

    public nq1() {
        this.Q.clear();
        this.Q.add(this.s0);
        int length = this.P.length;
        for (int i = 0; i < length; i++) {
            this.P[i] = this.s0;
        }
    }

    @Override // defpackage.jc0
    public final void M(gb2 gb2Var, boolean z) {
        if (this.S == null) {
            return;
        }
        lb0 lb0Var = this.s0;
        gb2Var.getClass();
        int iN = gb2.n(lb0Var);
        if (this.t0 == 1) {
            this.X = iN;
            this.Y = 0;
            H(this.S.i());
            K(0);
            return;
        }
        this.X = 0;
        this.Y = iN;
        K(this.S.o());
        H(0);
    }

    public final void N(int i) {
        this.s0.i(i);
        this.u0 = true;
    }

    public final void O(int i) {
        lb0 lb0Var;
        if (this.t0 == i) {
            return;
        }
        this.t0 = i;
        ArrayList arrayList = this.Q;
        arrayList.clear();
        if (this.t0 == 1) {
            lb0Var = this.H;
            this.s0 = lb0Var;
        } else {
            lb0Var = this.I;
            this.s0 = lb0Var;
        }
        arrayList.add(lb0Var);
        lb0[] lb0VarArr = this.P;
        int length = lb0VarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            lb0VarArr[i2] = this.s0;
        }
    }

    @Override // defpackage.jc0
    public final void b(gb2 gb2Var, boolean z) {
        kc0 kc0Var = this.S;
        if (kc0Var == null) {
            return;
        }
        Object objG = kc0Var.g(2);
        Object objG2 = kc0Var.g(4);
        kc0 kc0Var2 = this.S;
        boolean z2 = kc0Var2 != null && kc0Var2.o0[0] == 2;
        if (this.t0 == 0) {
            objG = kc0Var.g(3);
            objG2 = kc0Var.g(5);
            kc0 kc0Var3 = this.S;
            z2 = kc0Var3 != null && kc0Var3.o0[1] == 2;
        }
        if (this.u0) {
            lb0 lb0Var = this.s0;
            if (lb0Var.c) {
                jz3 jz3VarK = gb2Var.k(lb0Var);
                gb2Var.d(jz3VarK, this.s0.c());
                if (this.q0 != -1) {
                    if (z2) {
                        gb2Var.f(gb2Var.k(objG2), jz3VarK, 0, 5);
                    }
                } else if (this.r0 != -1 && z2) {
                    jz3 jz3VarK2 = gb2Var.k(objG2);
                    gb2Var.f(jz3VarK, gb2Var.k(objG), 0, 5);
                    gb2Var.f(jz3VarK2, jz3VarK, 0, 5);
                }
                this.u0 = false;
                return;
            }
        }
        if (this.q0 != -1) {
            jz3 jz3VarK3 = gb2Var.k(this.s0);
            gb2Var.e(jz3VarK3, gb2Var.k(objG), this.q0, 8);
            if (z2) {
                gb2Var.f(gb2Var.k(objG2), jz3VarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.r0 != -1) {
            jz3 jz3VarK4 = gb2Var.k(this.s0);
            jz3 jz3VarK5 = gb2Var.k(objG2);
            gb2Var.e(jz3VarK4, jz3VarK5, -this.r0, 8);
            if (z2) {
                gb2Var.f(jz3VarK4, gb2Var.k(objG), 0, 5);
                gb2Var.f(jz3VarK5, jz3VarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.p0 != -1.0f) {
            jz3 jz3VarK6 = gb2Var.k(this.s0);
            jz3 jz3VarK7 = gb2Var.k(objG2);
            float f = this.p0;
            ke keVarL = gb2Var.l();
            keVarL.d.g(jz3VarK6, -1.0f);
            keVarL.d.g(jz3VarK7, f);
            gb2Var.c(keVarL);
        }
    }

    @Override // defpackage.jc0
    public final boolean c() {
        return true;
    }

    @Override // defpackage.jc0
    public final lb0 g(int i) {
        int iG = fw.G(i);
        if (iG != 1) {
            if (iG != 2) {
                if (iG != 3) {
                    if (iG != 4) {
                        return null;
                    }
                }
            }
            if (this.t0 == 0) {
                return this.s0;
            }
            return null;
        }
        if (this.t0 == 1) {
            return this.s0;
        }
        return null;
    }

    @Override // defpackage.jc0
    public final boolean y() {
        return this.u0;
    }

    @Override // defpackage.jc0
    public final boolean z() {
        return this.u0;
    }
}
