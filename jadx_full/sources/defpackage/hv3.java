package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class hv3 extends a2 implements tn2, zf1, nm1 {
    public long A0;
    public int B0;
    public int C0;
    public final int X;
    public final int Y;
    public final jp Z;
    public Object[] y0;
    public long z0;

    public hv3(int i, int i2, jp jpVar) {
        this.X = i;
        this.Y = i2;
        this.Z = jpVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b9, code lost:
    
        throw r1.F();
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void j(hv3 hv3Var, ag1 ag1Var, ge0 ge0Var) throws Throwable {
        gv3 gv3Var;
        hv3 hv3Var2;
        Throwable th;
        jv3 jv3Var;
        ag1 ag1Var2;
        v32 v32Var;
        if (ge0Var instanceof gv3) {
            gv3Var = (gv3) ge0Var;
            int i = gv3Var.A0;
            if ((i & Integer.MIN_VALUE) != 0) {
                gv3Var.A0 = i - Integer.MIN_VALUE;
            } else {
                gv3Var = new gv3(hv3Var, ge0Var);
            }
        }
        Object obj = gv3Var.y0;
        int i2 = gv3Var.A0;
        mf0 mf0Var = mf0.b;
        if (i2 != 0) {
            if (i2 == 1) {
                jv3Var = gv3Var.Y;
                ag1 ag1Var3 = gv3Var.X;
                hv3 hv3Var3 = gv3Var.A;
                try {
                    n12.S(obj);
                    ag1Var2 = ag1Var3;
                    hv3Var = hv3Var3;
                    try {
                        cf0 cf0Var = gv3Var.f;
                        cf0Var.getClass();
                        v32Var = (v32) cf0Var.Z(pr1.X);
                    } catch (Throwable th2) {
                        hv3Var2 = hv3Var;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    hv3Var2 = hv3Var3;
                }
            } else {
                if (i2 != 2 && i2 != 3) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return;
                }
                v32 v32Var2 = gv3Var.Z;
                jv3Var = gv3Var.Y;
                ag1 ag1Var4 = gv3Var.X;
                hv3Var2 = gv3Var.A;
                try {
                    n12.S(obj);
                    ag1Var2 = ag1Var4;
                    v32Var = v32Var2;
                    hv3Var = hv3Var2;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            hv3Var2.f(jv3Var);
            throw th;
        }
        n12.S(obj);
        jv3 jv3Var2 = (jv3) hv3Var.c();
        try {
            if (ag1Var instanceof d54) {
                gv3Var.A = hv3Var;
                gv3Var.X = ag1Var;
                gv3Var.Y = jv3Var2;
                gv3Var.A0 = 1;
                if (((d54) ag1Var).a(gv3Var) == mf0Var) {
                    return;
                }
            }
            ag1Var2 = ag1Var;
            jv3Var = jv3Var2;
            cf0 cf0Var2 = gv3Var.f;
            cf0Var2.getClass();
            v32Var = (v32) cf0Var2.Z(pr1.X);
        } catch (Throwable th5) {
            hv3Var2 = hv3Var;
            th = th5;
            jv3Var = jv3Var2;
        }
        while (true) {
            Object objS = hv3Var.s(jv3Var);
            if (objS == iv3.a) {
                gv3Var.A = hv3Var;
                gv3Var.X = ag1Var2;
                gv3Var.Y = jv3Var;
                gv3Var.Z = v32Var;
                gv3Var.A0 = 2;
                if (hv3Var.g(jv3Var, gv3Var) == mf0Var) {
                    return;
                }
            } else {
                if (v32Var != null && !v32Var.isActive()) {
                    break;
                }
                gv3Var.A = hv3Var;
                gv3Var.X = ag1Var2;
                gv3Var.Y = jv3Var;
                gv3Var.Z = v32Var;
                gv3Var.A0 = 3;
                if (ag1Var2.h(objS, gv3Var) == mf0Var) {
                    return;
                }
            }
        }
    }

    @Override // defpackage.zf1
    public final Object a(ag1 ag1Var, ge0 ge0Var) throws Throwable {
        j(this, ag1Var, ge0Var);
        return mf0.b;
    }

    @Override // defpackage.nm1
    public final zf1 b(cf0 cf0Var, int i, jp jpVar) {
        return iv3.c(this, cf0Var, i, jpVar);
    }

    @Override // defpackage.a2
    public final b2 d() {
        jv3 jv3Var = new jv3();
        jv3Var.a = -1L;
        return jv3Var;
    }

    @Override // defpackage.a2
    public final b2[] e() {
        return new jv3[2];
    }

    public final Object g(jv3 jv3Var, gv3 gv3Var) {
        z00 z00Var = new z00(1, p95.u(gv3Var));
        z00Var.w();
        synchronized (this) {
            try {
                if (r(jv3Var) < 0) {
                    jv3Var.b = z00Var;
                } else {
                    z00Var.d(xl4.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objU = z00Var.u();
        return objU == mf0.b ? objU : xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) throws Throwable {
        hv3 hv3Var;
        Throwable th;
        ge0[] ge0VarArrM;
        fv3 fv3Var;
        Object objU;
        mf0 mf0Var;
        if (p(obj)) {
            return xl4.a;
        }
        z00 z00Var = new z00(1, p95.u(ge0Var));
        z00Var.w();
        ge0[] ge0VarArrM2 = ye.a;
        synchronized (this) {
            try {
                if (q(obj)) {
                    try {
                        z00Var.d(xl4.a);
                        ge0VarArrM = m(ge0VarArrM2);
                        fv3Var = null;
                        hv3Var = this;
                        if (fv3Var != null) {
                            z00Var.z(new s00(2, fv3Var));
                        }
                        for (ge0 ge0Var2 : ge0VarArrM) {
                            if (ge0Var2 != null) {
                                ge0Var2.d(xl4.a);
                            }
                        }
                        objU = z00Var.u();
                        mf0Var = mf0.b;
                        if (objU != mf0Var) {
                            objU = xl4.a;
                        }
                        return objU != mf0Var ? objU : xl4.a;
                    } catch (Throwable th2) {
                        th = th2;
                        hv3Var = this;
                    }
                } else {
                    try {
                        hv3Var = this;
                        try {
                            fv3 fv3Var2 = new fv3(hv3Var, n() + ((long) (this.B0 + this.C0)), obj, z00Var);
                            hv3Var.l(fv3Var2);
                            hv3Var.C0++;
                            if (hv3Var.Y == 0) {
                                ge0VarArrM2 = hv3Var.m(ge0VarArrM2);
                            }
                            ge0VarArrM = ge0VarArrM2;
                            fv3Var = fv3Var2;
                            if (fv3Var != null) {
                            }
                            while (i < r7) {
                            }
                            objU = z00Var.u();
                            mf0Var = mf0.b;
                            if (objU != mf0Var) {
                            }
                            if (objU != mf0Var) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        hv3Var = this;
                        th = th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                hv3Var = this;
            }
            th = th;
            throw th;
        }
    }

    public final void i() {
        if (this.Y != 0 || this.C0 > 1) {
            Object[] objArr = this.y0;
            objArr.getClass();
            while (this.C0 > 0) {
                long jN = n();
                int i = this.B0;
                int i2 = this.C0;
                if (objArr[((int) ((jN + ((long) (i + i2))) - 1)) & (objArr.length - 1)] != iv3.a) {
                    return;
                }
                this.C0 = i2 - 1;
                iv3.d(objArr, n() + ((long) (this.B0 + this.C0)), null);
            }
        }
    }

    public final void k() {
        b2[] b2VarArr;
        Object[] objArr = this.y0;
        objArr.getClass();
        iv3.d(objArr, n(), null);
        this.B0--;
        long jN = n() + 1;
        if (this.z0 < jN) {
            this.z0 = jN;
        }
        if (this.A0 < jN) {
            if (this.f != 0 && (b2VarArr = this.b) != null) {
                for (b2 b2Var : b2VarArr) {
                    if (b2Var != null) {
                        jv3 jv3Var = (jv3) b2Var;
                        long j = jv3Var.a;
                        if (j >= 0 && j < jN) {
                            jv3Var.a = jN;
                        }
                    }
                }
            }
            this.A0 = jN;
        }
    }

    public final void l(Object obj) {
        int i = this.B0 + this.C0;
        Object[] objArrO = this.y0;
        if (objArrO == null) {
            objArrO = o(null, 0, 2);
        } else if (i >= objArrO.length) {
            objArrO = o(objArrO, i, objArrO.length * 2);
        }
        iv3.d(objArrO, n() + ((long) i), obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [ge0[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    public final ge0[] m(ge0[] ge0VarArr) {
        b2[] b2VarArr;
        jv3 jv3Var;
        z00 z00Var;
        int length = ge0VarArr.length;
        if (this.f != 0 && (b2VarArr = this.b) != null) {
            int length2 = b2VarArr.length;
            int i = 0;
            ge0VarArr = ge0VarArr;
            while (i < length2) {
                b2 b2Var = b2VarArr[i];
                if (b2Var != null && (z00Var = (jv3Var = (jv3) b2Var).b) != null && r(jv3Var) >= 0) {
                    int length3 = ge0VarArr.length;
                    ge0VarArr = ge0VarArr;
                    if (length >= length3) {
                        ge0VarArr = Arrays.copyOf((Object[]) ge0VarArr, Math.max(2, ge0VarArr.length * 2));
                    }
                    ((ge0[]) ge0VarArr)[length] = z00Var;
                    jv3Var.b = null;
                    length++;
                }
                i++;
                ge0VarArr = ge0VarArr;
            }
        }
        return (ge0[]) ge0VarArr;
    }

    public final long n() {
        return Math.min(this.A0, this.z0);
    }

    public final Object[] o(Object[] objArr, int i, int i2) {
        if (i2 <= 0) {
            xe.q("Buffer size overflow");
            return null;
        }
        Object[] objArr2 = new Object[i2];
        this.y0 = objArr2;
        if (objArr != null) {
            long jN = n();
            for (int i3 = 0; i3 < i; i3++) {
                long j = ((long) i3) + jN;
                iv3.d(objArr2, j, objArr[((int) j) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    public final boolean p(Object obj) {
        int i;
        boolean z;
        ge0[] ge0VarArrM = ye.a;
        synchronized (this) {
            if (q(obj)) {
                ge0VarArrM = m(ge0VarArrM);
                z = true;
            } else {
                z = false;
            }
        }
        for (ge0 ge0Var : ge0VarArrM) {
            if (ge0Var != null) {
                ge0Var.d(xl4.a);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean q(Object obj) {
        int i = this.f;
        int i2 = this.X;
        if (i != 0) {
            int i3 = this.B0;
            int i4 = this.Y;
            if (i3 < i4 || this.A0 > this.z0) {
                l(obj);
                int i5 = this.B0 + 1;
                this.B0 = i5;
                if (i5 > i4) {
                    k();
                }
                long jN = n() + ((long) this.B0);
                long j = this.z0;
                if (((int) (jN - j)) > i2) {
                    t(1 + j, this.A0, n() + ((long) this.B0), n() + ((long) this.B0) + ((long) this.C0));
                }
            } else {
                int iOrdinal = this.Z.ordinal();
                if (iOrdinal == 0) {
                    return false;
                }
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        g.d();
                        return false;
                    }
                }
            }
        } else if (i2 != 0) {
            l(obj);
            int i6 = this.B0 + 1;
            this.B0 = i6;
            if (i6 > i2) {
                k();
            }
            this.A0 = n() + ((long) this.B0);
            return true;
        }
        return true;
    }

    public final long r(jv3 jv3Var) {
        long j = jv3Var.a;
        if (j >= n() + ((long) this.B0) && (this.Y > 0 || j > n() || this.C0 == 0)) {
            return -1L;
        }
        return j;
    }

    public final Object s(jv3 jv3Var) {
        Object obj;
        ge0[] ge0VarArrU = ye.a;
        synchronized (this) {
            try {
                long jR = r(jv3Var);
                if (jR < 0) {
                    obj = iv3.a;
                } else {
                    long j = jv3Var.a;
                    Object[] objArr = this.y0;
                    objArr.getClass();
                    Object obj2 = objArr[((int) jR) & (objArr.length - 1)];
                    if (obj2 instanceof fv3) {
                        obj2 = ((fv3) obj2).z;
                    }
                    jv3Var.a = jR + 1;
                    Object obj3 = obj2;
                    ge0VarArrU = u(j);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (ge0 ge0Var : ge0VarArrU) {
            if (ge0Var != null) {
                ge0Var.d(xl4.a);
            }
        }
        return obj;
    }

    public final void t(long j, long j2, long j3, long j4) {
        long jMin = Math.min(j2, j);
        for (long jN = n(); jN < jMin; jN++) {
            Object[] objArr = this.y0;
            objArr.getClass();
            iv3.d(objArr, jN, null);
        }
        this.z0 = j;
        this.A0 = j2;
        this.B0 = (int) (j3 - jMin);
        this.C0 = (int) (j4 - j3);
    }

    public final ge0[] u(long j) {
        long j2;
        long j3;
        long j4;
        ge0[] ge0VarArr;
        ge0[] ge0VarArr2;
        b2[] b2VarArr;
        ge0[] ge0VarArr3 = ye.a;
        if (j <= this.A0) {
            long jN = n();
            long j5 = ((long) this.B0) + jN;
            int i = this.Y;
            if (i == 0 && this.C0 > 0) {
                j5++;
            }
            int i2 = 0;
            if (this.f != 0 && (b2VarArr = this.b) != null) {
                for (b2 b2Var : b2VarArr) {
                    if (b2Var != null) {
                        long j6 = ((jv3) b2Var).a;
                        if (j6 >= 0 && j6 < j5) {
                            j5 = j6;
                        }
                    }
                }
            }
            if (j5 > this.A0) {
                long jN2 = n() + ((long) this.B0);
                int i3 = this.f;
                int iMin = this.C0;
                if (i3 > 0) {
                    iMin = Math.min(iMin, i - ((int) (jN2 - j5)));
                }
                long j7 = ((long) this.C0) + jN2;
                br1 br1Var = iv3.a;
                if (iMin > 0) {
                    j4 = 1;
                    Object[] objArr = this.y0;
                    objArr.getClass();
                    j2 = jN;
                    ge0[] ge0VarArr4 = new ge0[iMin];
                    long j8 = jN2;
                    while (true) {
                        if (jN2 >= j7) {
                            ge0VarArr2 = ge0VarArr4;
                            j3 = j5;
                            break;
                        }
                        ge0VarArr2 = ge0VarArr4;
                        Object obj = objArr[(objArr.length - 1) & ((int) jN2)];
                        if (obj != br1Var) {
                            obj.getClass();
                            fv3 fv3Var = (fv3) obj;
                            int i4 = i2 + 1;
                            j3 = j5;
                            ge0VarArr2[i2] = fv3Var.A;
                            iv3.d(objArr, jN2, br1Var);
                            iv3.d(objArr, j8, fv3Var.z);
                            j8++;
                            if (i4 >= iMin) {
                                break;
                            }
                            i2 = i4;
                        } else {
                            j3 = j5;
                        }
                        jN2++;
                        ge0VarArr4 = ge0VarArr2;
                        j5 = j3;
                    }
                    jN2 = j8;
                    ge0VarArr = ge0VarArr2;
                } else {
                    j2 = jN;
                    j3 = j5;
                    j4 = 1;
                    ge0VarArr = ge0VarArr3;
                }
                int i5 = (int) (jN2 - j2);
                long j9 = this.f == 0 ? jN2 : j3;
                long jMax = Math.max(this.z0, jN2 - ((long) Math.min(this.X, i5)));
                if (i == 0 && jMax < j7) {
                    Object[] objArr2 = this.y0;
                    objArr2.getClass();
                    if (n12.c(objArr2[((int) jMax) & (objArr2.length - 1)], br1Var)) {
                        jN2 += j4;
                        jMax += j4;
                    }
                }
                t(jMax, j9, jN2, j7);
                i();
                return ge0VarArr.length == 0 ? ge0VarArr : m(ge0VarArr);
            }
        }
        return ge0VarArr3;
    }
}
