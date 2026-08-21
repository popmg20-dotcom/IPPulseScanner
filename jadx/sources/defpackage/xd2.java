package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xd2 {
    public static final /* synthetic */ long b;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ long z;
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    static {
        Unsafe unsafe = re.a;
        b = unsafe.objectFieldOffset(xd2.class.getDeclaredField("_next$volatile"));
        f = unsafe.objectFieldOffset(xd2.class.getDeclaredField("_prev$volatile"));
        z = unsafe.objectFieldOffset(xd2.class.getDeclaredField("_removedRef$volatile"));
    }

    public final boolean d(xd2 xd2Var, int i) {
        xd2 xd2Var2;
        xd2 xd2Var3;
        while (true) {
            xd2 xd2VarI = this.i();
            if (xd2VarI instanceof vb2) {
                return (((vb2) xd2VarI).A & i) == 0 && xd2VarI.d(xd2Var, i);
            }
            Unsafe unsafe = re.a;
            unsafe.putObjectVolatile(xd2Var, f, xd2VarI);
            long j = b;
            unsafe.putObjectVolatile(xd2Var, j, this);
            while (true) {
                Unsafe unsafe2 = re.a;
                xd2Var2 = this;
                xd2Var3 = xd2Var;
                if (unsafe2.compareAndSwapObject(xd2VarI, b, xd2Var2, xd2Var3)) {
                    xd2Var3.f(xd2Var2);
                    return true;
                }
                if (unsafe2.getObjectVolatile(xd2VarI, j) != xd2Var2) {
                    break;
                }
                this = xd2Var2;
                xd2Var = xd2Var3;
            }
            this = xd2Var2;
            xd2Var = xd2Var3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.xd2 e() {
        /*
            r15 = this;
        L0:
            sun.misc.Unsafe r0 = defpackage.re.a
            long r1 = defpackage.xd2.f
            java.lang.Object r0 = r0.getObjectVolatile(r15, r1)
            r7 = r0
            xd2 r7 = (defpackage.xd2) r7
            r0 = 0
            r9 = r0
            r8 = r7
        Le:
            if (r8 == 0) goto L7b
            sun.misc.Unsafe r3 = defpackage.re.a
            long r4 = defpackage.xd2.b
            java.lang.Object r6 = r3.getObjectVolatile(r8, r4)
            if (r6 != r15) goto L36
            if (r7 != r8) goto L1d
            goto L2a
        L1d:
            sun.misc.Unsafe r3 = defpackage.re.a
            long r5 = defpackage.xd2.f
            r4 = r15
            boolean r15 = r3.compareAndSwapObject(r4, r5, r7, r8)
            r14 = r7
            r7 = r4
            if (r15 == 0) goto L2b
        L2a:
            return r8
        L2b:
            java.lang.Object r15 = r3.getObjectVolatile(r7, r1)
            if (r15 == r14) goto L33
        L31:
            r15 = r7
            goto L0
        L33:
            r15 = r7
            r7 = r14
            goto L1d
        L36:
            r14 = r7
            r7 = r15
            boolean r15 = r7.j()
            if (r15 == 0) goto L3f
            return r0
        L3f:
            boolean r15 = r6 instanceof defpackage.pi3
            if (r15 == 0) goto L72
            if (r9 == 0) goto L62
            pi3 r6 = (defpackage.pi3) r6
            xd2 r13 = r6.a
        L49:
            r12 = r8
            sun.misc.Unsafe r8 = defpackage.re.a
            long r10 = defpackage.xd2.b
            boolean r15 = r8.compareAndSwapObject(r9, r10, r12, r13)
            r3 = r8
            r8 = r12
            if (r15 == 0) goto L5b
            r15 = r7
            r8 = r9
            r7 = r14
            r9 = r0
            goto Le
        L5b:
            java.lang.Object r15 = r3.getObjectVolatile(r9, r4)
            if (r15 == r8) goto L49
            goto L31
        L62:
            if (r8 == 0) goto L6e
            java.lang.Object r15 = r3.getObjectVolatile(r8, r1)
            r8 = r15
            xd2 r8 = (defpackage.xd2) r8
        L6b:
            r15 = r7
            r7 = r14
            goto Le
        L6e:
            defpackage.st4.n()
            return r0
        L72:
            r6.getClass()
            r15 = r6
            xd2 r15 = (defpackage.xd2) r15
            r9 = r8
            r8 = r15
            goto L6b
        L7b:
            defpackage.st4.n()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xd2.e():xd2");
    }

    public final void f(xd2 xd2Var) {
        xd2 xd2Var2;
        while (true) {
            Unsafe unsafe = re.a;
            long j = f;
            xd2 xd2Var3 = (xd2) unsafe.getObjectVolatile(xd2Var, j);
            if (this.g() != xd2Var) {
                return;
            }
            while (true) {
                Unsafe unsafe2 = re.a;
                xd2Var2 = this;
                xd2 xd2Var4 = xd2Var;
                if (unsafe2.compareAndSwapObject(xd2Var4, f, xd2Var3, xd2Var2)) {
                    if (xd2Var2.j()) {
                        xd2Var4.e();
                        return;
                    }
                    return;
                } else {
                    xd2Var = xd2Var4;
                    if (unsafe2.getObjectVolatile(xd2Var4, j) != xd2Var3) {
                        break;
                    } else {
                        this = xd2Var2;
                    }
                }
            }
            this = xd2Var2;
        }
    }

    public final Object g() {
        return re.a.getObjectVolatile(this, b);
    }

    public final xd2 h() {
        Object objG = g();
        pi3 pi3Var = objG instanceof pi3 ? (pi3) objG : null;
        if (pi3Var != null) {
            return pi3Var.a;
        }
        objG.getClass();
        return (xd2) objG;
    }

    public final xd2 i() {
        xd2 xd2VarE = e();
        if (xd2VarE != null) {
            return xd2VarE;
        }
        Unsafe unsafe = re.a;
        long j = f;
        Object objectVolatile = unsafe.getObjectVolatile(this, j);
        while (true) {
            xd2 xd2Var = (xd2) objectVolatile;
            if (!xd2Var.j()) {
                return xd2Var;
            }
            objectVolatile = re.a.getObjectVolatile(xd2Var, j);
        }
    }

    public boolean j() {
        return g() instanceof pi3;
    }

    public String toString() {
        return new wd2(this, ek0.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1) + '@' + ek0.l(this);
    }
}
