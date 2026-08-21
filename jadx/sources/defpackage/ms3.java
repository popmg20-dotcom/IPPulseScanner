package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class ms3 {
    public static final /* synthetic */ AtomicLongFieldUpdater A;
    public static final /* synthetic */ AtomicIntegerFieldUpdater X;
    public static final /* synthetic */ long Y;
    public static final /* synthetic */ long Z;
    public static final /* synthetic */ long y0;
    public static final /* synthetic */ AtomicLongFieldUpdater z;
    private volatile /* synthetic */ int _availablePermits$volatile;
    public final int b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    public final op f;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    static {
        Unsafe unsafe = re.a;
        Z = unsafe.objectFieldOffset(ms3.class.getDeclaredField("head$volatile"));
        z = AtomicLongFieldUpdater.newUpdater(ms3.class, "deqIdx$volatile");
        y0 = unsafe.objectFieldOffset(ms3.class.getDeclaredField("tail$volatile"));
        A = AtomicLongFieldUpdater.newUpdater(ms3.class, "enqIdx$volatile");
        X = AtomicIntegerFieldUpdater.newUpdater(ms3.class, "_availablePermits$volatile");
        Y = unsafe.objectFieldOffset(ms3.class.getDeclaredField("_availablePermits$volatile"));
    }

    public ms3(int i) {
        this.b = i;
        if (i <= 0) {
            e04.f(dw2.A(i, "Semaphore should have at least 1 permit, but had "));
            throw null;
        }
        if (i < 0) {
            e04.f(dw2.A(i, "The number of acquired permits should be in 0.."));
            throw null;
        }
        ps3 ps3Var = new ps3(0L, null, 2);
        this.head$volatile = ps3Var;
        this.tail$volatile = ps3Var;
        this._availablePermits$volatile = i;
        this.f = new op(4, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r5.l(r3, r4.f);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.ie0 r5) {
        /*
            r4 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.ms3.X
            int r1 = r0.getAndDecrement(r4)
            int r2 = r4.b
            if (r1 > r2) goto L0
            xl4 r3 = defpackage.xl4.a
            if (r1 <= 0) goto Lf
            goto L3e
        Lf:
            ge0 r5 = defpackage.p95.u(r5)
            z00 r5 = defpackage.vo.t(r5)
            boolean r1 = r4.b(r5)     // Catch: java.lang.Throwable -> L3f
            if (r1 != 0) goto L31
        L1d:
            int r1 = r0.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L3f
            if (r1 > r2) goto L1d
            if (r1 <= 0) goto L2b
            op r4 = r4.f     // Catch: java.lang.Throwable -> L3f
            r5.l(r3, r4)     // Catch: java.lang.Throwable -> L3f
            goto L31
        L2b:
            boolean r1 = r4.b(r5)     // Catch: java.lang.Throwable -> L3f
            if (r1 == 0) goto L1d
        L31:
            java.lang.Object r4 = r5.u()
            mf0 r5 = defpackage.mf0.b
            if (r4 != r5) goto L3a
            goto L3b
        L3a:
            r4 = r3
        L3b:
            if (r4 != r5) goto L3e
            return r4
        L3e:
            return r3
        L3f:
            r4 = move-exception
            r5.D()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ms3.a(ie0):java.lang.Object");
    }

    public final boolean b(xs4 xs4Var) {
        Object objA;
        Unsafe unsafe;
        ms3 ms3Var = this;
        Unsafe unsafe2 = re.a;
        long j = y0;
        ps3 ps3Var = (ps3) unsafe2.getObjectVolatile(ms3Var, j);
        long andIncrement = A.getAndIncrement(ms3Var);
        ks3 ks3Var = ks3.y0;
        long j2 = andIncrement / ((long) os3.f);
        loop0: while (true) {
            objA = fa0.a(ps3Var, j2, ks3Var);
            if (l72.I(objA)) {
                break;
            }
            sr3 sr3VarC = l72.C(objA);
            while (true) {
                sr3 sr3Var = (sr3) re.a.getObjectVolatile(ms3Var, j);
                if (sr3Var.A >= sr3VarC.A) {
                    ms3Var = this;
                    break loop0;
                }
                if (!sr3VarC.j()) {
                    break;
                }
                do {
                    unsafe = re.a;
                    ms3Var = this;
                    if (unsafe.compareAndSwapObject(ms3Var, y0, sr3Var, sr3VarC)) {
                        if (sr3Var.f()) {
                            sr3Var.e();
                        }
                    }
                } while (unsafe.getObjectVolatile(ms3Var, j) == sr3Var);
                if (sr3VarC.f()) {
                    sr3VarC.e();
                }
            }
            ms3Var = this;
        }
        ps3 ps3Var2 = (ps3) l72.C(objA);
        AtomicReferenceArray atomicReferenceArray = ps3Var2.Z;
        int i = (int) (andIncrement % ((long) os3.f));
        while (!atomicReferenceArray.compareAndSet(i, null, xs4Var)) {
            if (atomicReferenceArray.get(i) != null) {
                br1 br1Var = os3.b;
                br1 br1Var2 = os3.c;
                while (!atomicReferenceArray.compareAndSet(i, br1Var, br1Var2)) {
                    if (atomicReferenceArray.get(i) != br1Var) {
                        return false;
                    }
                }
                ((y00) xs4Var).l(xl4.a, ms3Var.f);
                return true;
            }
        }
        xs4Var.a(ps3Var2, i);
        return true;
    }

    public final void c() {
        Unsafe unsafe;
        long j;
        int intVolatile;
        int i;
        Object objA;
        boolean zG;
        Unsafe unsafe2;
        do {
            int andIncrement = X.getAndIncrement(this);
            int i2 = this.b;
            if (andIncrement >= i2) {
                do {
                    unsafe = re.a;
                    j = Y;
                    intVolatile = unsafe.getIntVolatile(this, j);
                    i = this.b;
                    if (intVolatile <= i) {
                        break;
                    }
                } while (!unsafe.compareAndSwapInt(this, j, intVolatile, i));
                s53.f(i2, "The number of released permits cannot be greater than ");
                return;
            }
            if (andIncrement >= 0) {
                return;
            }
            Unsafe unsafe3 = re.a;
            long j2 = Z;
            ps3 ps3Var = (ps3) unsafe3.getObjectVolatile(this, j2);
            long andIncrement2 = z.getAndIncrement(this);
            long j3 = andIncrement2 / ((long) os3.f);
            ls3 ls3Var = ls3.y0;
            while (true) {
                objA = fa0.a(ps3Var, j3, ls3Var);
                if (l72.I(objA)) {
                    break;
                }
                sr3 sr3VarC = l72.C(objA);
                while (true) {
                    sr3 sr3Var = (sr3) re.a.getObjectVolatile(this, j2);
                    if (sr3Var.A >= sr3VarC.A) {
                        break;
                    }
                    if (!sr3VarC.j()) {
                        break;
                    }
                    do {
                        unsafe2 = re.a;
                        if (unsafe2.compareAndSwapObject(this, Z, sr3Var, sr3VarC)) {
                            if (sr3Var.f()) {
                                sr3Var.e();
                            }
                        }
                    } while (unsafe2.getObjectVolatile(this, j2) == sr3Var);
                    if (sr3VarC.f()) {
                        sr3VarC.e();
                    }
                }
            }
            ps3 ps3Var2 = (ps3) l72.C(objA);
            AtomicReferenceArray atomicReferenceArray = ps3Var2.Z;
            ps3Var2.a();
            zG = false;
            if (ps3Var2.A <= j3) {
                int i3 = (int) (andIncrement2 % ((long) os3.f));
                Object andSet = atomicReferenceArray.getAndSet(i3, os3.b);
                if (andSet == null) {
                    int i4 = os3.a;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (atomicReferenceArray.get(i3) == os3.c) {
                            zG = true;
                            break;
                        }
                    }
                    br1 br1Var = os3.b;
                    br1 br1Var2 = os3.d;
                    while (true) {
                        if (!atomicReferenceArray.compareAndSet(i3, br1Var, br1Var2)) {
                            if (atomicReferenceArray.get(i3) != br1Var) {
                                break;
                            }
                        } else {
                            zG = true;
                            break;
                        }
                    }
                    zG = !zG;
                } else if (andSet != os3.e) {
                    boolean z2 = andSet instanceof y00;
                    xl4 xl4Var = xl4.a;
                    if (z2) {
                        y00 y00Var = (y00) andSet;
                        br1 br1VarF = y00Var.f(xl4Var, this.f);
                        if (br1VarF != null) {
                            y00Var.m(br1VarF);
                            zG = true;
                            break;
                            break;
                        }
                    } else {
                        if (!(andSet instanceof xr3)) {
                            ad0.o(andSet, "unexpected: ");
                            return;
                        }
                        zG = ((xr3) andSet).g(this, xl4Var);
                    }
                }
            }
        } while (!zG);
    }
}
