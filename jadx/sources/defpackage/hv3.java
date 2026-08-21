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
        To view partially-correct add '--show-bad-code' argument
    */
    public static void j(defpackage.hv3 r8, defpackage.ag1 r9, defpackage.ge0 r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hv3.j(hv3, ag1, ge0):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.Object r8, defpackage.ge0 r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r7.p(r8)
            if (r0 == 0) goto L9
            xl4 r7 = defpackage.xl4.a
            return r7
        L9:
            z00 r5 = new z00
            ge0 r9 = defpackage.p95.u(r9)
            r6 = 1
            r5.<init>(r6, r9)
            r5.w()
            ge0[] r9 = defpackage.ye.a
            monitor-enter(r7)
            boolean r0 = r7.q(r8)     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L30
            xl4 r8 = defpackage.xl4.a     // Catch: java.lang.Throwable -> L2b
            r5.d(r8)     // Catch: java.lang.Throwable -> L2b
            ge0[] r8 = r7.m(r9)     // Catch: java.lang.Throwable -> L2b
            r9 = 0
            r1 = r7
            goto L59
        L2b:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L8e
        L30:
            fv3 r0 = new fv3     // Catch: java.lang.Throwable -> L8b
            long r1 = r7.n()     // Catch: java.lang.Throwable -> L8b
            int r3 = r7.B0     // Catch: java.lang.Throwable -> L86
            int r4 = r7.C0     // Catch: java.lang.Throwable -> L86
            int r3 = r3 + r4
            long r3 = (long) r3
            long r1 = r1 + r3
            r4 = r8
            r2 = r1
            r1 = r7
            r0.<init>(r1, r2, r4, r5)     // Catch: java.lang.Throwable -> L54
            r1.l(r0)     // Catch: java.lang.Throwable -> L54
            int r7 = r1.C0     // Catch: java.lang.Throwable -> L54
            int r7 = r7 + r6
            r1.C0 = r7     // Catch: java.lang.Throwable -> L54
            int r7 = r1.Y     // Catch: java.lang.Throwable -> L54
            if (r7 != 0) goto L57
            ge0[] r9 = r1.m(r9)     // Catch: java.lang.Throwable -> L54
            goto L57
        L54:
            r0 = move-exception
        L55:
            r8 = r0
            goto L8e
        L57:
            r8 = r9
            r9 = r0
        L59:
            monitor-exit(r1)
            if (r9 == 0) goto L65
            s00 r7 = new s00
            r0 = 2
            r7.<init>(r0, r9)
            r5.z(r7)
        L65:
            int r7 = r8.length
            r9 = 0
        L67:
            if (r9 >= r7) goto L75
            r0 = r8[r9]
            if (r0 == 0) goto L72
            xl4 r1 = defpackage.xl4.a
            r0.d(r1)
        L72:
            int r9 = r9 + 1
            goto L67
        L75:
            java.lang.Object r7 = r5.u()
            mf0 r8 = defpackage.mf0.b
            if (r7 != r8) goto L7e
            goto L80
        L7e:
            xl4 r7 = defpackage.xl4.a
        L80:
            if (r7 != r8) goto L83
            return r7
        L83:
            xl4 r7 = defpackage.xl4.a
            return r7
        L86:
            r0 = move-exception
            r1 = r7
            r7 = r0
            r8 = r7
            goto L8e
        L8b:
            r0 = move-exception
            r1 = r7
            goto L55
        L8e:
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hv3.h(java.lang.Object, ge0):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(java.lang.Object r13) {
        /*
            r12 = this;
            int r1 = r12.f
            int r2 = r12.X
            r9 = 1
            if (r1 != 0) goto L23
            if (r2 != 0) goto Lb
            goto L7e
        Lb:
            r12.l(r13)
            int r1 = r12.B0
            int r1 = r1 + r9
            r12.B0 = r1
            if (r1 <= r2) goto L18
            r12.k()
        L18:
            long r1 = r12.n()
            int r3 = r12.B0
            long r3 = (long) r3
            long r1 = r1 + r3
            r12.A0 = r1
            return r9
        L23:
            int r1 = r12.B0
            int r3 = r12.Y
            if (r1 < r3) goto L46
            long r4 = r12.A0
            long r6 = r12.z0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L46
            jp r1 = r12.Z
            int r1 = r1.ordinal()
            if (r1 == 0) goto L44
            if (r1 == r9) goto L46
            r0 = 2
            if (r1 != r0) goto L3f
            goto L7e
        L3f:
            defpackage.g.d()
            r0 = 0
            return r0
        L44:
            r0 = 0
            return r0
        L46:
            r12.l(r13)
            int r1 = r12.B0
            int r1 = r1 + r9
            r12.B0 = r1
            if (r1 <= r3) goto L53
            r12.k()
        L53:
            long r3 = r12.n()
            int r1 = r12.B0
            long r5 = (long) r1
            long r3 = r3 + r5
            long r5 = r12.z0
            long r3 = r3 - r5
            int r1 = (int) r3
            if (r1 <= r2) goto L7e
            r1 = 1
            long r1 = r1 + r5
            long r3 = r12.A0
            long r5 = r12.n()
            int r7 = r12.B0
            long r7 = (long) r7
            long r5 = r5 + r7
            long r7 = r12.n()
            int r10 = r12.B0
            long r10 = (long) r10
            long r7 = r7 + r10
            int r10 = r12.C0
            long r10 = (long) r10
            long r7 = r7 + r10
            r0 = r12
            r0.t(r1, r3, r5, r7)
        L7e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hv3.q(java.lang.Object):boolean");
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
