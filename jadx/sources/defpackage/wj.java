package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wj extends jc0 {
    public jc0[] p0;
    public int q0;
    public int r0;
    public boolean s0;
    public int t0;
    public boolean u0;

    public final void N(int i, mt4 mt4Var, ArrayList arrayList) {
        for (int i2 = 0; i2 < this.q0; i2++) {
            jc0 jc0Var = this.p0[i2];
            ArrayList arrayList2 = mt4Var.a;
            if (!arrayList2.contains(jc0Var)) {
                arrayList2.add(jc0Var);
            }
        }
        for (int i3 = 0; i3 < this.q0; i3++) {
            vf2.m(this.p0[i3], i, arrayList, mt4Var);
        }
    }

    public final boolean O() {
        int i;
        int i2;
        int i3;
        boolean z = true;
        int i4 = 0;
        while (true) {
            i = this.q0;
            if (i4 >= i) {
                break;
            }
            jc0 jc0Var = this.p0[i4];
            if ((this.s0 || jc0Var.c()) && ((((i2 = this.r0) == 0 || i2 == 1) && !jc0Var.y()) || (((i3 = this.r0) == 2 || i3 == 3) && !jc0Var.z()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.q0; i5++) {
            jc0 jc0Var2 = this.p0[i5];
            if (this.s0 || jc0Var2.c()) {
                if (!z2) {
                    int i6 = this.r0;
                    if (i6 == 0) {
                        iMax = jc0Var2.g(2).c();
                    } else if (i6 == 1) {
                        iMax = jc0Var2.g(4).c();
                    } else if (i6 == 2) {
                        iMax = jc0Var2.g(3).c();
                    } else if (i6 == 3) {
                        iMax = jc0Var2.g(5).c();
                    }
                    z2 = true;
                }
                int i7 = this.r0;
                if (i7 == 0) {
                    iMax = Math.min(iMax, jc0Var2.g(2).c());
                } else if (i7 == 1) {
                    iMax = Math.max(iMax, jc0Var2.g(4).c());
                } else if (i7 == 2) {
                    iMax = Math.min(iMax, jc0Var2.g(3).c());
                } else if (i7 == 3) {
                    iMax = Math.max(iMax, jc0Var2.g(5).c());
                }
            }
        }
        int i8 = iMax + this.t0;
        int i9 = this.r0;
        if (i9 == 0 || i9 == 1) {
            F(i8, i8);
        } else {
            G(i8, i8);
        }
        this.u0 = true;
        return true;
    }

    public final int P() {
        int i = this.r0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // defpackage.jc0
    public final void b(gb2 gb2Var, boolean z) {
        boolean z2;
        int i;
        int i2;
        lb0[] lb0VarArr = this.P;
        lb0 lb0Var = this.H;
        lb0VarArr[0] = lb0Var;
        int i3 = 2;
        lb0 lb0Var2 = this.I;
        lb0VarArr[2] = lb0Var2;
        lb0 lb0Var3 = this.J;
        lb0VarArr[1] = lb0Var3;
        lb0 lb0Var4 = this.K;
        lb0VarArr[3] = lb0Var4;
        for (lb0 lb0Var5 : lb0VarArr) {
            lb0Var5.i = gb2Var.k(lb0Var5);
        }
        int i4 = this.r0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        lb0 lb0Var6 = lb0VarArr[i4];
        if (!this.u0) {
            O();
        }
        if (this.u0) {
            this.u0 = false;
            int i5 = this.r0;
            if (i5 == 0 || i5 == 1) {
                gb2Var.d(lb0Var.i, this.X);
                gb2Var.d(lb0Var3.i, this.X);
                return;
            } else {
                if (i5 == 2 || i5 == 3) {
                    gb2Var.d(lb0Var2.i, this.Y);
                    gb2Var.d(lb0Var4.i, this.Y);
                    return;
                }
                return;
            }
        }
        for (int i6 = 0; i6 < this.q0; i6++) {
            jc0 jc0Var = this.p0[i6];
            if ((this.s0 || jc0Var.c()) && ((((i2 = this.r0) == 0 || i2 == 1) && jc0Var.o0[0] == 3 && jc0Var.H.f != null && jc0Var.J.f != null) || ((i2 == 2 || i2 == 3) && jc0Var.o0[1] == 3 && jc0Var.I.f != null && jc0Var.K.f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = lb0Var.e() || lb0Var3.e();
        boolean z4 = lb0Var2.e() || lb0Var4.e();
        int i7 = !(!z2 && (((i = this.r0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        int i8 = 0;
        while (i8 < this.q0) {
            jc0 jc0Var2 = this.p0[i8];
            if (this.s0 || jc0Var2.c()) {
                jz3 jz3VarK = gb2Var.k(jc0Var2.P[this.r0]);
                lb0[] lb0VarArr2 = jc0Var2.P;
                int i9 = this.r0;
                lb0 lb0Var7 = lb0VarArr2[i9];
                lb0Var7.i = jz3VarK;
                lb0 lb0Var8 = lb0Var7.f;
                int i10 = (lb0Var8 == null || lb0Var8.d != this) ? 0 : lb0Var7.g;
                if (i9 == 0 || i9 == i3) {
                    jz3 jz3Var = lb0Var6.i;
                    int i11 = this.t0 - i10;
                    ke keVarL = gb2Var.l();
                    jz3 jz3VarM = gb2Var.m();
                    jz3VarM.A = 0;
                    keVarL.c(jz3Var, jz3VarK, jz3VarM, i11);
                    gb2Var.c(keVarL);
                } else {
                    jz3 jz3Var2 = lb0Var6.i;
                    int i12 = this.t0 + i10;
                    ke keVarL2 = gb2Var.l();
                    jz3 jz3VarM2 = gb2Var.m();
                    jz3VarM2.A = 0;
                    keVarL2.b(jz3Var2, jz3VarK, jz3VarM2, i12);
                    gb2Var.c(keVarL2);
                }
                gb2Var.e(lb0Var6.i, jz3VarK, this.t0 + i10, i7);
            }
            i8++;
            i3 = 2;
        }
        int i13 = this.r0;
        if (i13 == 0) {
            gb2Var.e(lb0Var3.i, lb0Var.i, 0, 8);
            gb2Var.e(lb0Var.i, this.S.J.i, 0, 4);
            gb2Var.e(lb0Var.i, this.S.H.i, 0, 0);
            return;
        }
        if (i13 == 1) {
            gb2Var.e(lb0Var.i, lb0Var3.i, 0, 8);
            gb2Var.e(lb0Var.i, this.S.H.i, 0, 4);
            gb2Var.e(lb0Var.i, this.S.J.i, 0, 0);
        } else if (i13 == 2) {
            gb2Var.e(lb0Var4.i, lb0Var2.i, 0, 8);
            gb2Var.e(lb0Var2.i, this.S.K.i, 0, 4);
            gb2Var.e(lb0Var2.i, this.S.I.i, 0, 0);
        } else if (i13 == 3) {
            gb2Var.e(lb0Var2.i, lb0Var4.i, 0, 8);
            gb2Var.e(lb0Var2.i, this.S.I.i, 0, 4);
            gb2Var.e(lb0Var2.i, this.S.K.i, 0, 0);
        }
    }

    @Override // defpackage.jc0
    public final boolean c() {
        return true;
    }

    @Override // defpackage.jc0
    public final String toString() {
        String strY = fw.y(new StringBuilder("[Barrier] "), this.g0, " {");
        for (int i = 0; i < this.q0; i++) {
            jc0 jc0Var = this.p0[i];
            if (i > 0) {
                strY = strY.concat(", ");
            }
            strY = strY + jc0Var.g0;
        }
        return strY.concat("}");
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
