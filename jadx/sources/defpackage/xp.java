package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class xp implements y20 {
    public static final /* synthetic */ AtomicLongFieldUpdater A = AtomicLongFieldUpdater.newUpdater(xp.class, "sendersAndCloseStatus$volatile");
    public static final /* synthetic */ long A0;
    public static final /* synthetic */ long B0;
    public static final /* synthetic */ long C0;
    public static final /* synthetic */ long D0;
    public static final /* synthetic */ long E0;
    public static final /* synthetic */ long F0;
    public static final /* synthetic */ long G0;
    public static final /* synthetic */ long H0;
    public static final /* synthetic */ AtomicLongFieldUpdater X;
    public static final /* synthetic */ AtomicLongFieldUpdater Y;
    public static final /* synthetic */ AtomicLongFieldUpdater Z;
    public static final /* synthetic */ AtomicReferenceFieldUpdater y0;
    public static final /* synthetic */ long z0;
    private volatile /* synthetic */ Object _closeCause$volatile;
    public final int b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    public final am1 f;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    public final op z;

    static {
        Unsafe unsafe = re.a;
        H0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("sendersAndCloseStatus$volatile"));
        X = AtomicLongFieldUpdater.newUpdater(xp.class, "receivers$volatile");
        F0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("receivers$volatile"));
        Y = AtomicLongFieldUpdater.newUpdater(xp.class, "bufferEnd$volatile");
        A0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("bufferEnd$volatile"));
        Z = AtomicLongFieldUpdater.newUpdater(xp.class, "completedExpandBuffersAndPauseFlag$volatile");
        D0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("completedExpandBuffersAndPauseFlag$volatile"));
        G0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("sendSegment$volatile"));
        y0 = AtomicReferenceFieldUpdater.newUpdater(xp.class, Object.class, "receiveSegment$volatile");
        E0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("receiveSegment$volatile"));
        B0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("bufferEndSegment$volatile"));
        z0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("_closeCause$volatile"));
        C0 = unsafe.objectFieldOffset(xp.class.getDeclaredField("closeHandler$volatile"));
    }

    public xp(int i, am1 am1Var) {
        this.b = i;
        this.f = am1Var;
        if (i < 0) {
            e04.f(ha0.k("Invalid channel capacity: ", i, ", should be >=0"));
            throw null;
        }
        m30 m30Var = zp.a;
        this.bufferEnd$volatile = i != 0 ? i != Integer.MAX_VALUE ? i : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = o();
        m30 m30Var2 = new m30(0L, null, this, 3);
        this.sendSegment$volatile = m30Var2;
        this.receiveSegment$volatile = m30Var2;
        if (A()) {
            m30Var2 = zp.a;
            m30Var2.getClass();
        }
        this.bufferEndSegment$volatile = m30Var2;
        this.z = am1Var != null ? new op(0, this) : null;
        this._closeCause$volatile = zp.s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object E(defpackage.xp r13, defpackage.ie0 r14) {
        /*
            boolean r0 = r14 instanceof defpackage.vp
            if (r0 == 0) goto L14
            r0 = r14
            vp r0 = (defpackage.vp) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.Y = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            vp r0 = new vp
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.A
            int r0 = r6.Y
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L32
            if (r0 != r2) goto L2c
            defpackage.n12.S(r14)
            l30 r14 = (defpackage.l30) r14
            java.lang.Object r13 = r14.a
            return r13
        L2c:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r13)
            return r1
        L32:
            defpackage.n12.S(r14)
            sun.misc.Unsafe r14 = defpackage.re.a
            long r3 = defpackage.xp.E0
            java.lang.Object r14 = r14.getObjectVolatile(r13, r3)
            m30 r14 = (defpackage.m30) r14
        L3f:
            boolean r0 = r13.x()
            if (r0 == 0) goto L4f
            java.lang.Throwable r13 = r13.p()
            j30 r14 = new j30
            r14.<init>(r13)
            return r14
        L4f:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.xp.X
            long r4 = r0.getAndIncrement(r13)
            int r0 = defpackage.zp.b
            long r7 = (long) r0
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.A
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L6c
            m30 r0 = r13.m(r9, r14)
            if (r0 != 0) goto L6a
            goto L3f
        L6a:
            r8 = r0
            goto L6d
        L6c:
            r8 = r14
        L6d:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.J(r8, r9, r10, r12)
            br1 r14 = defpackage.zp.m
            if (r13 == r14) goto La1
            br1 r14 = defpackage.zp.o
            if (r13 != r14) goto L8b
            long r13 = r7.t()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L88
            r8.a()
        L88:
            r13 = r7
            r14 = r8
            goto L3f
        L8b:
            br1 r14 = defpackage.zp.n
            if (r13 != r14) goto L9d
            r6.Y = r2
            r1 = r7
            r2 = r8
            java.lang.Object r13 = r1.F(r2, r3, r4, r6)
            mf0 r14 = defpackage.mf0.b
            if (r13 != r14) goto L9c
            return r14
        L9c:
            return r13
        L9d:
            r8.a()
            return r13
        La1:
            java.lang.String r13 = "unexpected"
            defpackage.xe.q(r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.E(xp, ie0):java.lang.Object");
    }

    public final boolean A() {
        long jO = o();
        return jO == 0 || jO == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (r5.f() == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        r5.e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(long r7, defpackage.m30 r9) {
        /*
            r6 = this;
        L0:
            long r0 = r9.A
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 >= 0) goto L11
            ga0 r0 = r9.c()
            m30 r0 = (defpackage.m30) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r9 = r0
            goto L0
        L11:
            r5 = r9
        L12:
            boolean r7 = r5.d()
            if (r7 == 0) goto L23
            ga0 r7 = r5.c()
            m30 r7 = (defpackage.m30) r7
            if (r7 != 0) goto L21
            goto L23
        L21:
            r5 = r7
            goto L12
        L23:
            sun.misc.Unsafe r7 = defpackage.re.a
            long r8 = defpackage.xp.B0
            java.lang.Object r7 = r7.getObjectVolatile(r6, r8)
            r4 = r7
            sr3 r4 = (defpackage.sr3) r4
            long r0 = r4.A
            long r2 = r5.A
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 < 0) goto L37
            goto L53
        L37:
            boolean r7 = r5.j()
            if (r7 != 0) goto L3f
            r9 = r5
            goto L11
        L3f:
            sun.misc.Unsafe r0 = defpackage.re.a
            long r2 = defpackage.xp.B0
            r1 = r6
            boolean r6 = r0.compareAndSwapObject(r1, r2, r4, r5)
            if (r6 == 0) goto L54
            boolean r6 = r4.f()
            if (r6 == 0) goto L53
            r4.e()
        L53:
            return
        L54:
            java.lang.Object r6 = r0.getObjectVolatile(r1, r8)
            if (r6 == r4) goto L65
            boolean r6 = r5.f()
            if (r6 == 0) goto L63
            r5.e()
        L63:
            r6 = r1
            goto L23
        L65:
            r6 = r1
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.B(long, m30):void");
    }

    public final Object C(ge0 ge0Var, Object obj) {
        t80 t80VarH;
        z00 z00Var = new z00(1, p95.u(ge0Var));
        z00Var.w();
        am1 am1Var = this.f;
        if (am1Var == null || (t80VarH = ez4.h(am1Var, obj, null)) == null) {
            z00Var.d(new tk3(s()));
        } else {
            ek0.b(t80VarH, s());
            z00Var.d(new tk3(t80VarH));
        }
        Object objU = z00Var.u();
        return objU == mf0.b ? objU : xl4.a;
    }

    public final void D(Object obj, z00 z00Var) {
        am1 am1Var = this.f;
        if (am1Var != null) {
            ez4.g(am1Var, obj, z00Var.X);
        }
        z00Var.d(new tk3(s()));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(defpackage.m30 r15, int r16, long r17, defpackage.ie0 r19) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.F(m30, int, long, ie0):java.lang.Object");
    }

    public final void G(xs4 xs4Var, boolean z) {
        if (xs4Var instanceof y00) {
            ((ge0) xs4Var).d(new tk3(z ? q() : s()));
            return;
        }
        if (xs4Var instanceof ef3) {
            ((ef3) xs4Var).b.d(new l30(new j30(p())));
            return;
        }
        if (!(xs4Var instanceof rp)) {
            if (xs4Var instanceof xr3) {
                ((xr3) xs4Var).g(this, zp.l);
                return;
            } else {
                ad0.o(xs4Var, "Unexpected waiter: ");
                return;
            }
        }
        rp rpVar = (rp) xs4Var;
        z00 z00Var = rpVar.f;
        z00Var.getClass();
        rpVar.f = null;
        rpVar.b = zp.l;
        Throwable thP = rpVar.z.p();
        if (thP == null) {
            z00Var.d(Boolean.FALSE);
        } else {
            z00Var.d(new tk3(thP));
        }
    }

    public final boolean H(Object obj, Object obj2) {
        em1 spVar;
        if (obj instanceof xr3) {
            return ((xr3) obj).g(this, obj2);
        }
        boolean z = obj instanceof ef3;
        am1 am1Var = this.f;
        if (z) {
            z00 z00Var = ((ef3) obj).b;
            l30 l30Var = new l30(obj2);
            spVar = am1Var != null ? new sp(3, this, xp.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, 1) : null;
            m30 m30Var = zp.a;
            br1 br1VarF = z00Var.f(l30Var, spVar);
            if (br1VarF == null) {
                return false;
            }
            z00Var.m(br1VarF);
            return true;
        }
        if (!(obj instanceof rp)) {
            if (!(obj instanceof y00)) {
                ad0.o(obj, "Unexpected receiver type: ");
                return false;
            }
            y00 y00Var = (y00) obj;
            spVar = am1Var != null ? new sp(3, this, xp.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, 0) : null;
            m30 m30Var2 = zp.a;
            br1 br1VarF2 = y00Var.f(obj2, spVar);
            if (br1VarF2 == null) {
                return false;
            }
            y00Var.m(br1VarF2);
            return true;
        }
        rp rpVar = (rp) obj;
        z00 z00Var2 = rpVar.f;
        z00Var2.getClass();
        rpVar.f = null;
        rpVar.b = obj2;
        Boolean bool = Boolean.TRUE;
        am1 am1Var2 = rpVar.z.f;
        spVar = am1Var2 != null ? new pp(am1Var2, obj2) : null;
        m30 m30Var3 = zp.a;
        br1 br1VarF3 = z00Var2.f(bool, spVar);
        if (br1VarF3 == null) {
            return false;
        }
        z00Var2.m(br1VarF3);
        return true;
    }

    public final boolean I(Object obj, m30 m30Var, int i) {
        zh4 zh4Var;
        boolean z = obj instanceof y00;
        xl4 xl4Var = xl4.a;
        if (z) {
            y00 y00Var = (y00) obj;
            m30 m30Var2 = zp.a;
            br1 br1VarF = y00Var.f(xl4Var, null);
            if (br1VarF == null) {
                return false;
            }
            y00Var.m(br1VarF);
            return true;
        }
        if (!(obj instanceof xr3)) {
            ad0.o(obj, "Unexpected waiter: ");
            return false;
        }
        int iH = ((xr3) obj).h(this, xl4Var);
        zh4 zh4Var2 = zh4.b;
        zh4 zh4Var3 = zh4.f;
        if (iH == 0) {
            zh4Var = zh4Var2;
        } else if (iH == 1) {
            zh4Var = zh4Var3;
        } else if (iH == 2) {
            zh4Var = zh4.z;
        } else {
            if (iH != 3) {
                s53.f(iH, "Unexpected internal result: ");
                return false;
            }
            zh4Var = zh4.A;
        }
        if (zh4Var == zh4Var3) {
            m30Var.n(i, null);
        }
        return zh4Var == zh4Var2;
    }

    public final Object J(m30 m30Var, int i, long j, Object obj) {
        Object objL = m30Var.l(i);
        AtomicReferenceArray atomicReferenceArray = m30Var.y0;
        long j2 = H0;
        if (objL == null) {
            if (j >= (re.a.getLongVolatile(this, j2) & 1152921504606846975L)) {
                if (obj == null) {
                    return zp.n;
                }
                if (m30Var.k(i, objL, obj)) {
                    l();
                    return zp.m;
                }
            }
        } else if (objL == zp.d && m30Var.k(i, objL, zp.i)) {
            l();
            Object obj2 = atomicReferenceArray.get(i * 2);
            m30Var.n(i, null);
            return obj2;
        }
        while (true) {
            Object objL2 = m30Var.l(i);
            if (objL2 == null || objL2 == zp.e) {
                if (j < (re.a.getLongVolatile(this, j2) & 1152921504606846975L)) {
                    if (m30Var.k(i, objL2, zp.h)) {
                        l();
                        return zp.o;
                    }
                } else {
                    if (obj == null) {
                        return zp.n;
                    }
                    if (m30Var.k(i, objL2, obj)) {
                        l();
                        return zp.m;
                    }
                }
            } else if (objL2 != zp.d) {
                br1 br1Var = zp.j;
                if (objL2 == br1Var) {
                    return zp.o;
                }
                if (objL2 == zp.h) {
                    return zp.o;
                }
                if (objL2 == zp.l) {
                    l();
                    return zp.o;
                }
                if (objL2 != zp.g && m30Var.k(i, objL2, zp.f)) {
                    boolean z = objL2 instanceof ys4;
                    if (z) {
                        objL2 = ((ys4) objL2).a;
                    }
                    if (I(objL2, m30Var, i)) {
                        m30Var.o(i, zp.i);
                        l();
                        Object obj3 = atomicReferenceArray.get(i * 2);
                        m30Var.n(i, null);
                        return obj3;
                    }
                    m30Var.o(i, br1Var);
                    m30Var.i();
                    if (z) {
                        l();
                    }
                    return zp.o;
                }
            } else if (m30Var.k(i, objL2, zp.i)) {
                l();
                Object obj4 = atomicReferenceArray.get(i * 2);
                m30Var.n(i, null);
                return obj4;
            }
        }
    }

    public final int K(m30 m30Var, int i, Object obj, long j, Object obj2, boolean z) {
        m30Var.n(i, obj);
        if (z) {
            return L(m30Var, i, obj, j, obj2, z);
        }
        Object objL = m30Var.l(i);
        if (objL == null) {
            if (c(j)) {
                if (m30Var.k(i, null, zp.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (m30Var.k(i, null, obj2)) {
                    return 2;
                }
            }
        } else if (objL instanceof xs4) {
            m30Var.n(i, null);
            if (H(objL, obj)) {
                m30Var.o(i, zp.i);
                return 0;
            }
            br1 br1Var = zp.k;
            if (m30Var.y0.getAndSet((i * 2) + 1, br1Var) == br1Var) {
                return 5;
            }
            m30Var.m(i, true);
            return 5;
        }
        return L(m30Var, i, obj, j, obj2, z);
    }

    public final int L(m30 m30Var, int i, Object obj, long j, Object obj2, boolean z) {
        while (true) {
            Object objL = m30Var.l(i);
            if (objL == null) {
                if (!c(j) || z) {
                    if (z) {
                        if (m30Var.k(i, null, zp.j)) {
                            m30Var.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (m30Var.k(i, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (m30Var.k(i, null, zp.d)) {
                    break;
                }
            } else {
                if (objL != zp.e) {
                    br1 br1Var = zp.k;
                    if (objL == br1Var) {
                        m30Var.n(i, null);
                        return 5;
                    }
                    if (objL == zp.h) {
                        m30Var.n(i, null);
                        return 5;
                    }
                    if (objL == zp.l) {
                        m30Var.n(i, null);
                        y();
                        return 4;
                    }
                    m30Var.n(i, null);
                    if (objL instanceof ys4) {
                        objL = ((ys4) objL).a;
                    }
                    if (H(objL, obj)) {
                        m30Var.o(i, zp.i);
                        return 0;
                    }
                    if (m30Var.y0.getAndSet((i * 2) + 1, br1Var) != br1Var) {
                        m30Var.m(i, true);
                    }
                    return 5;
                }
                if (m30Var.k(i, objL, zp.d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void M(long j) {
        xp xpVar = this;
        if (xpVar.A()) {
            return;
        }
        while (xpVar.o() <= j) {
            xpVar = this;
        }
        int i = zp.c;
        int i2 = 0;
        while (true) {
            long j2 = D0;
            if (i2 < i) {
                long jO = xpVar.o();
                if (jO == (re.a.getLongVolatile(xpVar, j2) & 4611686018427387903L) && jO == xpVar.o()) {
                    return;
                } else {
                    i2++;
                }
            } else {
                while (true) {
                    Unsafe unsafe = re.a;
                    long longVolatile = unsafe.getLongVolatile(xpVar, j2);
                    if (unsafe.compareAndSwapLong(xpVar, D0, longVolatile, 4611686018427387904L + (longVolatile & 4611686018427387903L))) {
                        break;
                    } else {
                        xpVar = this;
                    }
                }
                while (true) {
                    long jO2 = xpVar.o();
                    Unsafe unsafe2 = re.a;
                    long longVolatile2 = unsafe2.getLongVolatile(xpVar, j2);
                    long j3 = longVolatile2 & 4611686018427387903L;
                    boolean z = (longVolatile2 & 4611686018427387904L) != 0;
                    if (jO2 == j3 && jO2 == xpVar.o()) {
                        break;
                    }
                    if (z) {
                        xpVar = this;
                    } else {
                        xpVar = this;
                        unsafe2.compareAndSwapLong(xpVar, D0, longVolatile2, j3 + 4611686018427387904L);
                    }
                }
                while (true) {
                    Unsafe unsafe3 = re.a;
                    long longVolatile3 = unsafe3.getLongVolatile(xpVar, j2);
                    if (unsafe3.compareAndSwapLong(xpVar, D0, longVolatile3, longVolatile3 & 4611686018427387903L)) {
                        return;
                    } else {
                        xpVar = this;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0165 A[RETURN] */
    @Override // defpackage.qs3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(defpackage.ge0 r27, java.lang.Object r28) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.a(ge0, java.lang.Object):java.lang.Object");
    }

    @Override // defpackage.qs3
    public final boolean b(Throwable th) {
        return d(th, false);
    }

    public final boolean c(long j) {
        return j < o() || j < r() + ((long) this.b);
    }

    public final boolean d(Throwable th, boolean z) {
        boolean z2;
        Unsafe unsafe;
        long j;
        long longVolatile;
        long j2;
        Object objectVolatile;
        Unsafe unsafe2;
        Unsafe unsafe3;
        long j3;
        long longVolatile2;
        xp xpVar = this;
        if (z) {
            while (true) {
                Unsafe unsafe4 = re.a;
                long j4 = H0;
                long longVolatile3 = unsafe4.getLongVolatile(xpVar, j4);
                if (((int) (longVolatile3 >> 60)) != 0) {
                    break;
                }
                m30 m30Var = zp.a;
                if (unsafe4.compareAndSwapLong(xpVar, j4, longVolatile3, (longVolatile3 & 1152921504606846975L) + 1152921504606846976L)) {
                    break;
                }
                xpVar = this;
            }
        }
        br1 br1Var = zp.s;
        while (true) {
            Unsafe unsafe5 = re.a;
            long j5 = z0;
            if (unsafe5.compareAndSwapObject(this, j5, br1Var, th)) {
                z2 = true;
                break;
            }
            if (unsafe5.getObjectVolatile(this, j5) != br1Var) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                unsafe3 = re.a;
                j3 = H0;
                longVolatile2 = unsafe3.getLongVolatile(this, j3);
            } while (!unsafe3.compareAndSwapLong(this, j3, longVolatile2, (longVolatile2 & 1152921504606846975L) + 3458764513820540928L));
        } else {
            do {
                unsafe = re.a;
                j = H0;
                longVolatile = unsafe.getLongVolatile(this, j);
                int i = (int) (longVolatile >> 60);
                if (i == 0) {
                    j2 = (longVolatile & 1152921504606846975L) + 2305843009213693952L;
                } else {
                    if (i != 1) {
                        break;
                    }
                    j2 = (longVolatile & 1152921504606846975L) + 3458764513820540928L;
                }
            } while (!unsafe.compareAndSwapLong(this, j, longVolatile, j2));
        }
        y();
        if (z2) {
            loop3: while (true) {
                Unsafe unsafe6 = re.a;
                long j6 = C0;
                objectVolatile = unsafe6.getObjectVolatile(this, j6);
                br1 br1Var2 = objectVolatile == null ? zp.q : zp.r;
                do {
                    unsafe2 = re.a;
                    if (unsafe2.compareAndSwapObject(this, C0, objectVolatile, br1Var2)) {
                        break loop3;
                    }
                } while (unsafe2.getObjectVolatile(this, j6) == objectVolatile);
            }
            if (objectVolatile != null) {
                tj4.c(1, objectVolatile);
                ((am1) objectVolatile).g(p());
                return z2;
            }
        }
        return z2;
    }

    @Override // defpackage.qs3
    public Object e(Object obj) {
        xp xpVar = this;
        Unsafe unsafe = re.a;
        long j = 1152921504606846975L;
        boolean z = xpVar.w(unsafe.getLongVolatile(xpVar, H0), false) ? false : !xpVar.c(r2 & 1152921504606846975L);
        k30 k30Var = l30.b;
        if (z) {
            return k30Var;
        }
        Object obj2 = zp.j;
        m30 m30Var = (m30) unsafe.getObjectVolatile(xpVar, G0);
        while (true) {
            long andIncrement = A.getAndIncrement(xpVar);
            long j2 = andIncrement & j;
            boolean zW = xpVar.w(andIncrement, false);
            int i = zp.b;
            long j3 = i;
            long j4 = j2 / j3;
            int i2 = (int) (j2 % j3);
            if (m30Var.A != j4) {
                m30 m30VarN = xpVar.n(j4, m30Var);
                if (m30VarN != null) {
                    m30Var = m30VarN;
                } else {
                    if (zW) {
                        return new j30(xpVar.s());
                    }
                    j = 1152921504606846975L;
                }
            }
            int iK = xpVar.K(m30Var, i2, obj, j2, obj2, zW);
            xl4 xl4Var = xl4.a;
            if (iK == 0) {
                m30Var.a();
                return xl4Var;
            }
            if (iK == 1) {
                return xl4Var;
            }
            if (iK == 2) {
                if (zW) {
                    m30Var.i();
                    return new j30(s());
                }
                xs4 xs4Var = obj2 instanceof xs4 ? (xs4) obj2 : null;
                if (xs4Var != null) {
                    xs4Var.a(m30Var, i2 + i);
                }
                m30Var.i();
                return k30Var;
            }
            if (iK == 3) {
                xe.q("unexpected");
                return null;
            }
            if (iK == 4) {
                if (j2 < r()) {
                    m30Var.a();
                }
                return new j30(s());
            }
            if (iK == 5) {
                m30Var.a();
            }
            j = 1152921504606846975L;
            xpVar = this;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        r0 = (defpackage.m30) ((defpackage.ga0) defpackage.re.a.getObjectVolatile(r0, defpackage.ga0.f));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.m30 f(long r12) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.f(long):m30");
    }

    @Override // defpackage.y20
    public final void g(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        d(cancellationException, true);
    }

    @Override // defpackage.y20
    public final v62 h() {
        tj4.c(3, tp.y0);
        tj4.c(3, up.y0);
        return new v62(this, this.z);
    }

    @Override // defpackage.y20
    public final Object i() {
        m30 m30Var;
        Unsafe unsafe = re.a;
        long longVolatile = unsafe.getLongVolatile(this, F0);
        long longVolatile2 = unsafe.getLongVolatile(this, H0);
        if (w(longVolatile2, true)) {
            return new j30(p());
        }
        long j = longVolatile2 & 1152921504606846975L;
        k30 k30Var = l30.b;
        if (longVolatile >= j) {
            return k30Var;
        }
        Object obj = zp.k;
        m30 m30Var2 = (m30) unsafe.getObjectVolatile(this, E0);
        while (!this.x()) {
            long andIncrement = X.getAndIncrement(this);
            long j2 = zp.b;
            long j3 = andIncrement / j2;
            int i = (int) (andIncrement % j2);
            if (m30Var2.A != j3) {
                m30 m30VarM = this.m(j3, m30Var2);
                if (m30VarM == null) {
                    continue;
                } else {
                    m30Var = m30VarM;
                }
            } else {
                m30Var = m30Var2;
            }
            xp xpVar = this;
            Object objJ = xpVar.J(m30Var, i, andIncrement, obj);
            m30Var2 = m30Var;
            if (objJ == zp.m) {
                xs4 xs4Var = obj instanceof xs4 ? (xs4) obj : null;
                if (xs4Var != null) {
                    xs4Var.a(m30Var2, i);
                }
                xpVar.M(andIncrement);
                m30Var2.i();
                return k30Var;
            }
            if (objJ != zp.o) {
                if (objJ != zp.n) {
                    m30Var2.a();
                    return objJ;
                }
                xe.q("unexpected");
                return null;
            }
            if (andIncrement < xpVar.t()) {
                m30Var2.a();
            }
            this = xpVar;
        }
        return new j30(this.p());
    }

    @Override // defpackage.y20
    public final rp iterator() {
        return new rp(this);
    }

    public final void j(long j) {
        t80 t80VarH;
        m30 m30Var = (m30) re.a.getObjectVolatile(this, E0);
        while (true) {
            Unsafe unsafe = re.a;
            long j2 = F0;
            long longVolatile = unsafe.getLongVolatile(this, j2);
            if (j < Math.max(((long) this.b) + longVolatile, this.o())) {
                return;
            }
            xp xpVar = this;
            if (unsafe.compareAndSwapLong(xpVar, j2, longVolatile, 1 + longVolatile)) {
                long j3 = zp.b;
                long j4 = longVolatile / j3;
                int i = (int) (longVolatile % j3);
                if (m30Var.A != j4) {
                    m30 m30VarM = xpVar.m(j4, m30Var);
                    if (m30VarM != null) {
                        m30Var = m30VarM;
                    }
                }
                m30 m30Var2 = m30Var;
                Object objJ = xpVar.J(m30Var2, i, longVolatile, null);
                if (objJ != zp.o) {
                    m30Var2.a();
                    am1 am1Var = xpVar.f;
                    if (am1Var != null && (t80VarH = ez4.h(am1Var, objJ, null)) != null) {
                        throw t80VarH;
                    }
                } else if (longVolatile < xpVar.t()) {
                    m30Var2.a();
                }
                this = xpVar;
                m30Var = m30Var2;
            }
            this = xpVar;
        }
    }

    @Override // defpackage.y20
    public final Object k(z70 z70Var) {
        return E(this, z70Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0176, code lost:
    
        u(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0179, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.l():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c4, code lost:
    
        if (r8.f() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c6, code lost:
    
        r8.e();
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fb A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.m30 m(long r16, defpackage.m30 r18) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.m(long, m30):m30");
    }

    public final m30 n(long j, m30 m30Var) {
        Object objA;
        m30 m30Var2;
        long j2;
        Unsafe unsafe;
        xp xpVar = this;
        m30 m30Var3 = zp.a;
        yp ypVar = yp.y0;
        loop0: while (true) {
            objA = fa0.a(m30Var, j, ypVar);
            if (!l72.I(objA)) {
                sr3 sr3VarC = l72.C(objA);
                while (true) {
                    Unsafe unsafe2 = re.a;
                    long j3 = G0;
                    sr3 sr3Var = (sr3) unsafe2.getObjectVolatile(xpVar, j3);
                    if (sr3Var.A >= sr3VarC.A) {
                        break loop0;
                    }
                    if (!sr3VarC.j()) {
                        break;
                    }
                    do {
                        unsafe = re.a;
                        if (unsafe.compareAndSwapObject(xpVar, G0, sr3Var, sr3VarC)) {
                            if (sr3Var.f()) {
                                sr3Var.e();
                            }
                        }
                    } while (unsafe.getObjectVolatile(xpVar, j3) == sr3Var);
                    if (sr3VarC.f()) {
                        sr3VarC.e();
                    }
                }
            } else {
                break;
            }
        }
        m30 m30Var4 = null;
        if (l72.I(objA)) {
            xpVar.y();
            if (m30Var.A * ((long) zp.b) >= xpVar.r()) {
                return null;
            }
            m30Var.a();
            return null;
        }
        m30 m30Var5 = (m30) l72.C(objA);
        long j4 = m30Var5.A;
        if (j4 <= j) {
            return m30Var5;
        }
        long j5 = j4 * ((long) zp.b);
        while (true) {
            Unsafe unsafe3 = re.a;
            long j6 = H0;
            long longVolatile = unsafe3.getLongVolatile(xpVar, j6);
            long j7 = 1152921504606846975L & longVolatile;
            if (j7 >= j5) {
                m30Var2 = m30Var4;
                j2 = j4;
                break;
            }
            m30Var2 = m30Var4;
            j2 = j4;
            if (unsafe3.compareAndSwapLong(xpVar, j6, longVolatile, j7 + (((long) ((int) (longVolatile >> 60))) << 60))) {
                break;
            }
            xpVar = this;
            m30Var4 = m30Var2;
            j4 = j2;
        }
        if (j2 * ((long) zp.b) >= r()) {
            return m30Var2;
        }
        m30Var5.a();
        return m30Var2;
    }

    public final long o() {
        return re.a.getLongVolatile(this, A0);
    }

    public final Throwable p() {
        return (Throwable) re.a.getObjectVolatile(this, z0);
    }

    public final Throwable q() {
        Throwable thP = p();
        return thP == null ? new b60("Channel was closed") : thP;
    }

    public final long r() {
        return re.a.getLongVolatile(this, F0);
    }

    public final Throwable s() {
        Throwable thP = p();
        return thP == null ? new c60("Channel was closed") : thP;
    }

    public final long t() {
        return re.a.getLongVolatile(this, H0) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a1, code lost:
    
        r3 = (defpackage.m30) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a8, code lost:
    
        if (r3 != null) goto L90;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.toString():java.lang.String");
    }

    public final void u(long j) {
        if ((Z.addAndGet(this, j) & 4611686018427387904L) != 0) {
            while ((re.a.getLongVolatile(this, D0) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0185, code lost:
    
        defpackage.re.a.compareAndSwapLong(r1, defpackage.xp.F0, r5, 1 + r5);
        r1 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c1, code lost:
    
        r0 = (defpackage.m30) ((defpackage.ga0) defpackage.re.a.getObjectVolatile(r0, defpackage.ga0.f));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w(long r18, boolean r20) {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xp.w(long, boolean):boolean");
    }

    public final boolean x() {
        return w(re.a.getLongVolatile(this, H0), true);
    }

    public final boolean y() {
        return w(re.a.getLongVolatile(this, H0), false);
    }

    public boolean z() {
        return false;
    }
}
