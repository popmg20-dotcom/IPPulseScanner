package defpackage;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    */
    public static Object E(xp xpVar, ie0 ie0Var) {
        vp vpVar;
        m30 m30Var;
        if (ie0Var instanceof vp) {
            vpVar = (vp) ie0Var;
            int i = vpVar.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                vpVar.Y = i - Integer.MIN_VALUE;
            } else {
                vpVar = new vp(xpVar, ie0Var);
            }
        }
        vp vpVar2 = vpVar;
        Object obj = vpVar2.A;
        int i2 = vpVar2.Y;
        if (i2 != 0) {
            if (i2 == 1) {
                n12.S(obj);
                return ((l30) obj).a;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        n12.S(obj);
        m30 m30Var2 = (m30) re.a.getObjectVolatile(xpVar, E0);
        while (!xpVar.x()) {
            long andIncrement = X.getAndIncrement(xpVar);
            long j = zp.b;
            long j2 = andIncrement / j;
            int i3 = (int) (andIncrement % j);
            if (m30Var2.A != j2) {
                m30 m30VarM = xpVar.m(j2, m30Var2);
                if (m30VarM == null) {
                    continue;
                } else {
                    m30Var = m30VarM;
                }
            } else {
                m30Var = m30Var2;
            }
            xp xpVar2 = xpVar;
            Object objJ = xpVar2.J(m30Var, i3, andIncrement, null);
            if (objJ == zp.m) {
                xe.q("unexpected");
                return null;
            }
            if (objJ != zp.o) {
                if (objJ != zp.n) {
                    m30Var.a();
                    return objJ;
                }
                vpVar2.Y = 1;
                Object objF = xpVar2.F(m30Var, i3, andIncrement, vpVar2);
                mf0 mf0Var = mf0.b;
                return objF == mf0Var ? mf0Var : objF;
            }
            if (andIncrement < xpVar2.t()) {
                m30Var.a();
            }
            xpVar = xpVar2;
            m30Var2 = m30Var;
        }
        return new j30(xpVar.p());
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
    */
    public final void B(long j, m30 m30Var) {
        xp xpVar;
        m30 m30Var2;
        m30 m30Var3;
        while (m30Var.A < j && (m30Var3 = (m30) m30Var.c()) != null) {
            m30Var = m30Var3;
        }
        while (true) {
            m30 m30Var4 = m30Var;
            while (m30Var4.d() && (m30Var2 = (m30) m30Var4.c()) != null) {
                m30Var4 = m30Var2;
            }
            while (true) {
                Unsafe unsafe = re.a;
                long j2 = B0;
                sr3 sr3Var = (sr3) unsafe.getObjectVolatile(this, j2);
                if (sr3Var.A >= m30Var4.A) {
                    return;
                }
                if (!m30Var4.j()) {
                    break;
                }
                while (true) {
                    Unsafe unsafe2 = re.a;
                    xpVar = this;
                    if (unsafe2.compareAndSwapObject(xpVar, B0, sr3Var, m30Var4)) {
                        if (sr3Var.f()) {
                            sr3Var.e();
                            return;
                        }
                        return;
                    } else if (unsafe2.getObjectVolatile(xpVar, j2) != sr3Var) {
                        break;
                    } else {
                        this = xpVar;
                    }
                }
                this = xpVar;
            }
            m30Var = m30Var4;
        }
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
    */
    public final Object F(m30 m30Var, int i, long j, ie0 ie0Var) {
        wp wpVar;
        l30 l30Var;
        sp spVar;
        if (ie0Var instanceof wp) {
            wpVar = (wp) ie0Var;
            int i2 = wpVar.Y;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                wpVar.Y = i2 - Integer.MIN_VALUE;
            } else {
                wpVar = new wp(this, ie0Var);
            }
        }
        Object objU = wpVar.A;
        int i3 = wpVar.Y;
        sp spVar2 = null;
        if (i3 == 0) {
            n12.S(objU);
            wpVar.Y = 1;
            z00 z00VarT = vo.t(p95.u(wpVar));
            try {
                ef3 ef3Var = new ef3(z00VarT);
                Object objJ = J(m30Var, i, j, ef3Var);
                if (objJ == zp.m) {
                    ef3Var.a(m30Var, i);
                } else {
                    Object obj = zp.o;
                    am1 am1Var = this.f;
                    if (objJ == obj) {
                        if (j < t()) {
                            m30Var.a();
                        }
                        m30 m30Var2 = (m30) re.a.getObjectVolatile(this, E0);
                        while (true) {
                            if (x()) {
                                z00VarT.d(new l30(new j30(p())));
                                break;
                            }
                            long andIncrement = X.getAndIncrement(this);
                            long j2 = zp.b;
                            long j3 = andIncrement / j2;
                            int i4 = (int) (andIncrement % j2);
                            if (m30Var2.A != j3) {
                                m30 m30VarM = m(j3, m30Var2);
                                if (m30VarM != null) {
                                    m30Var2 = m30VarM;
                                }
                            }
                            Object objJ2 = J(m30Var2, i4, andIncrement, ef3Var);
                            if (objJ2 == zp.m) {
                                ef3Var.a(m30Var2, i4);
                                break;
                            }
                            if (objJ2 == zp.o) {
                                if (andIncrement < t()) {
                                    m30Var2.a();
                                }
                            } else {
                                if (objJ2 == zp.n) {
                                    throw new IllegalStateException("unexpected");
                                }
                                m30Var2.a();
                                l30Var = new l30(objJ2);
                                if (am1Var != null) {
                                    spVar = new sp(3, this, xp.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, 1);
                                }
                            }
                        }
                    } else {
                        m30Var.a();
                        l30Var = new l30(objJ);
                        if (am1Var != null) {
                            spVar = new sp(3, this, xp.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0, 1);
                            spVar2 = spVar;
                        }
                        z00VarT.l(l30Var, spVar2);
                    }
                }
                objU = z00VarT.u();
                mf0 mf0Var = mf0.b;
                if (objU == mf0Var) {
                    return mf0Var;
                }
            } catch (Throwable th) {
                z00VarT.D();
                throw th;
            }
        } else {
            if (i3 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objU);
        }
        return ((l30) objU).a;
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
    */
    public Object a(ge0 ge0Var, Object obj) {
        xl4 xl4Var;
        mf0 mf0Var;
        Object objU;
        mf0 mf0Var2;
        String str;
        int i;
        xp xpVar = this;
        Unsafe unsafe = re.a;
        long j = G0;
        m30 m30Var = (m30) unsafe.getObjectVolatile(xpVar, j);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = A;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(xpVar);
            long j2 = andIncrement & 1152921504606846975L;
            boolean zW = xpVar.w(andIncrement, false);
            int i2 = zp.b;
            long j3 = i2;
            long j4 = j2 / j3;
            int i3 = (int) (j2 % j3);
            long j5 = m30Var.A;
            mf0 mf0Var3 = mf0.b;
            xl4Var = xl4.a;
            if (j5 != j4) {
                m30 m30VarN = xpVar.n(j4, m30Var);
                if (m30VarN != null) {
                    m30Var = m30VarN;
                } else if (zW) {
                    Object objC = C(ge0Var, obj);
                    if (objC == mf0Var3) {
                        return objC;
                    }
                }
            }
            int iK = xpVar.K(m30Var, i3, obj, j2, null, zW);
            if (iK == 0) {
                m30Var.a();
                return xl4Var;
            }
            if (iK == 1) {
                break;
            }
            if (iK != 2) {
                if (iK == 3) {
                    z00 z00VarT = vo.t(p95.u(ge0Var));
                    try {
                        int iK2 = K(m30Var, i3, obj, j2, z00VarT, false);
                        if (iK2 != 0) {
                            if (iK2 == 1) {
                                mf0Var = mf0Var3;
                                z00VarT.d(xl4Var);
                            } else if (iK2 != 2) {
                                if (iK2 != 4) {
                                    String str2 = "unexpected";
                                    if (iK2 != 5) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    m30Var.a();
                                    m30 m30Var2 = (m30) re.a.getObjectVolatile(this, j);
                                    while (true) {
                                        long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                        long j6 = andIncrement2 & 1152921504606846975L;
                                        boolean zW2 = w(andIncrement2, false);
                                        int i4 = zp.b;
                                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = atomicLongFieldUpdater;
                                        long j7 = i4;
                                        mf0Var = mf0Var3;
                                        long j8 = j6 / j7;
                                        int i5 = (int) (j6 % j7);
                                        if (m30Var2.A != j8) {
                                            m30 m30VarN2 = n(j8, m30Var2);
                                            if (m30VarN2 != null) {
                                                str = str2;
                                                i = i5;
                                                m30Var2 = m30VarN2;
                                            } else {
                                                if (zW2) {
                                                    break;
                                                }
                                                atomicLongFieldUpdater = atomicLongFieldUpdater2;
                                                mf0Var3 = mf0Var;
                                            }
                                        } else {
                                            str = str2;
                                            i = i5;
                                        }
                                        int iK3 = K(m30Var2, i, obj, j6, z00VarT, zW2);
                                        if (iK3 == 0) {
                                            m30Var2.a();
                                            break;
                                        }
                                        if (iK3 == 1) {
                                            break;
                                        }
                                        if (iK3 != 2) {
                                            if (iK3 == 3) {
                                                throw new IllegalStateException(str);
                                            }
                                            if (iK3 != 4) {
                                                if (iK3 == 5) {
                                                    m30Var2.a();
                                                }
                                                str2 = str;
                                                atomicLongFieldUpdater = atomicLongFieldUpdater2;
                                                mf0Var3 = mf0Var;
                                            } else if (j6 < r()) {
                                                m30Var2.a();
                                            }
                                        } else if (zW2) {
                                            m30Var2.i();
                                        } else {
                                            z00VarT.a(m30Var2, i + i4);
                                        }
                                    }
                                } else {
                                    mf0Var = mf0Var3;
                                    if (j2 < r()) {
                                        m30Var.a();
                                    }
                                }
                                D(obj, z00VarT);
                            } else {
                                mf0Var = mf0Var3;
                                z00VarT.a(m30Var, i3 + i2);
                            }
                            objU = z00VarT.u();
                            mf0Var2 = mf0Var;
                            if (objU != mf0Var2) {
                                objU = xl4Var;
                            }
                            if (objU != mf0Var2) {
                                return objU;
                            }
                        } else {
                            mf0Var = mf0Var3;
                            m30Var.a();
                        }
                        z00VarT.d(xl4Var);
                        objU = z00VarT.u();
                        mf0Var2 = mf0Var;
                        if (objU != mf0Var2) {
                        }
                        if (objU != mf0Var2) {
                            break;
                        }
                    } catch (Throwable th) {
                        z00VarT.D();
                        throw th;
                    }
                } else if (iK != 4) {
                    if (iK == 5) {
                        m30Var.a();
                    }
                    xpVar = this;
                } else {
                    if (j2 < r()) {
                        m30Var.a();
                    }
                    Object objC2 = C(ge0Var, obj);
                    if (objC2 == mf0Var3) {
                        return objC2;
                    }
                }
            } else if (zW) {
                m30Var.i();
                Object objC3 = C(ge0Var, obj);
                if (objC3 == mf0Var3) {
                    return objC3;
                }
            }
        }
        return xl4Var;
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
    */
    public final m30 f(long j) {
        ga0 ga0Var;
        long j2;
        Unsafe unsafe;
        long j3;
        Unsafe unsafe2 = re.a;
        Object objectVolatile = unsafe2.getObjectVolatile(this, B0);
        m30 m30Var = (m30) unsafe2.getObjectVolatile(this, G0);
        if (m30Var.A > ((m30) objectVolatile).A) {
            objectVolatile = m30Var;
        }
        m30 m30Var2 = (m30) unsafe2.getObjectVolatile(this, E0);
        if (m30Var2.A > ((m30) objectVolatile).A) {
            objectVolatile = m30Var2;
        }
        ga0 ga0Var2 = (ga0) objectVolatile;
        loop0: while (true) {
            ga0Var = ga0Var2;
            while (true) {
                int i = ga0.z;
                ga0Var.getClass();
                Object objectVolatile2 = re.a.getObjectVolatile(ga0Var, ga0.b);
                br1 br1Var = fa0.a;
                if (objectVolatile2 == br1Var) {
                    break loop0;
                }
                ga0Var2 = (ga0) objectVolatile2;
                if (ga0Var2 == null) {
                    do {
                        unsafe = re.a;
                        j3 = ga0.b;
                        if (unsafe.compareAndSwapObject(ga0Var, j3, (Object) null, br1Var)) {
                            break loop0;
                        }
                    } while (unsafe.getObjectVolatile(ga0Var, j3) == null);
                }
            }
        }
        m30 m30Var3 = (m30) ga0Var;
        if (z()) {
            m30 m30Var4 = m30Var3;
            loop3: do {
                int i2 = zp.b - 1;
                while (true) {
                    if (-1 >= i2) {
                        break;
                    }
                    j2 = (m30Var4.A * ((long) zp.b)) + ((long) i2);
                    if (j2 < r()) {
                        break loop3;
                    }
                    while (true) {
                        Object objL = m30Var4.l(i2);
                        if (objL != null && objL != zp.e) {
                            if (objL == zp.d) {
                                break loop3;
                            }
                        } else {
                            if (m30Var4.k(i2, objL, zp.l)) {
                                m30Var4.i();
                                break;
                            }
                        }
                    }
                    i2--;
                }
            } while (m30Var4 != null);
            j2 = -1;
            if (j2 != -1) {
                j(j2);
            }
        }
        Object objK = null;
        loop6: for (m30 m30Var5 = m30Var3; m30Var5 != null; m30Var5 = (m30) ((ga0) re.a.getObjectVolatile(m30Var5, ga0.f))) {
            for (int i3 = zp.b - 1; -1 < i3; i3--) {
                if ((m30Var5.A * ((long) zp.b)) + ((long) i3) < j) {
                    break loop6;
                }
                while (true) {
                    Object objL2 = m30Var5.l(i3);
                    if (objL2 != null && objL2 != zp.e) {
                        if (!(objL2 instanceof ys4)) {
                            if (!(objL2 instanceof xs4)) {
                                break;
                            }
                            if (m30Var5.k(i3, objL2, zp.l)) {
                                objK = co4.K(objK, objL2);
                                m30Var5.m(i3, true);
                                break;
                            }
                        } else {
                            if (m30Var5.k(i3, objL2, zp.l)) {
                                objK = co4.K(objK, ((ys4) objL2).a);
                                m30Var5.m(i3, true);
                                break;
                            }
                        }
                    } else {
                        if (m30Var5.k(i3, objL2, zp.l)) {
                            m30Var5.i();
                            break;
                        }
                    }
                }
            }
        }
        if (objK != null) {
            if (!(objK instanceof ArrayList)) {
                G((xs4) objK, true);
                return m30Var3;
            }
            ArrayList arrayList = (ArrayList) objK;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                G((xs4) arrayList.get(size), true);
            }
        }
        return m30Var3;
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
    */
    public final void l() {
        Object objA;
        Unsafe unsafe;
        if (A()) {
            return;
        }
        Unsafe unsafe2 = re.a;
        long j = B0;
        m30 m30Var = (m30) unsafe2.getObjectVolatile(this, j);
        loop0: while (true) {
            long andIncrement = Y.getAndIncrement(this);
            long j2 = andIncrement / ((long) zp.b);
            if (t() <= andIncrement) {
                if (m30Var.A < j2 && m30Var.c() != null) {
                    B(j2, m30Var);
                }
                u(1L);
                return;
            }
            if (m30Var.A != j2) {
                yp ypVar = yp.y0;
                while (true) {
                    objA = fa0.a(m30Var, j2, ypVar);
                    if (!l72.I(objA)) {
                        sr3 sr3VarC = l72.C(objA);
                        while (true) {
                            sr3 sr3Var = (sr3) re.a.getObjectVolatile(this, j);
                            if (sr3Var.A >= sr3VarC.A) {
                                break;
                            }
                            if (!sr3VarC.j()) {
                                break;
                            }
                            do {
                                unsafe = re.a;
                                if (unsafe.compareAndSwapObject(this, B0, sr3Var, sr3VarC)) {
                                    if (sr3Var.f()) {
                                        sr3Var.e();
                                    }
                                }
                            } while (unsafe.getObjectVolatile(this, j) == sr3Var);
                            if (sr3VarC.f()) {
                                sr3VarC.e();
                            }
                        }
                    } else {
                        break;
                    }
                }
                m30 m30Var2 = null;
                if (l72.I(objA)) {
                    y();
                    B(j2, m30Var);
                    u(1L);
                } else {
                    m30 m30Var3 = (m30) l72.C(objA);
                    long j3 = m30Var3.A;
                    if (j3 > j2) {
                        long j4 = ((long) zp.b) * j3;
                        if (re.a.compareAndSwapLong(this, A0, 1 + andIncrement, j4)) {
                            u(j4 - andIncrement);
                        } else {
                            u(1L);
                        }
                    } else {
                        m30Var2 = m30Var3;
                    }
                }
                if (m30Var2 == null) {
                    continue;
                } else {
                    m30Var = m30Var2;
                }
            }
            int i = (int) (andIncrement % ((long) zp.b));
            Object objL = m30Var.l(i);
            boolean z = objL instanceof xs4;
            long j5 = F0;
            if (!z || andIncrement < re.a.getLongVolatile(this, j5) || !m30Var.k(i, objL, zp.g)) {
                while (true) {
                    Object objL2 = m30Var.l(i);
                    if (!(objL2 instanceof xs4)) {
                        if (objL2 != zp.j) {
                            if (objL2 != null) {
                                if (objL2 == zp.d || objL2 == zp.h || objL2 == zp.i || objL2 == zp.k || objL2 == zp.l) {
                                    break loop0;
                                } else if (objL2 != zp.f) {
                                    ad0.o(objL2, "Unexpected cell state: ");
                                    return;
                                }
                            } else if (m30Var.k(i, objL2, zp.e)) {
                                break loop0;
                            }
                        } else {
                            break;
                        }
                    } else if (andIncrement < re.a.getLongVolatile(this, j5)) {
                        if (m30Var.k(i, objL2, new ys4((xs4) objL2))) {
                            break loop0;
                        }
                    } else if (m30Var.k(i, objL2, zp.g)) {
                        if (I(objL2, m30Var, i)) {
                            m30Var.o(i, zp.d);
                            break;
                        } else {
                            m30Var.o(i, zp.j);
                            m30Var.i();
                        }
                    }
                }
            } else if (I(objL, m30Var, i)) {
                m30Var.o(i, zp.d);
                break;
            } else {
                m30Var.o(i, zp.j);
                m30Var.i();
                u(1L);
            }
        }
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
    */
    public final m30 m(long j, m30 m30Var) {
        Object objA;
        m30 m30Var2;
        Unsafe unsafe;
        long j2;
        long longVolatile;
        Unsafe unsafe2;
        m30 m30Var3 = zp.a;
        yp ypVar = yp.y0;
        loop0: while (true) {
            objA = fa0.a(m30Var, j, ypVar);
            if (!l72.I(objA)) {
                sr3 sr3VarC = l72.C(objA);
                while (true) {
                    Unsafe unsafe3 = re.a;
                    long j3 = E0;
                    sr3 sr3Var = (sr3) unsafe3.getObjectVolatile(this, j3);
                    if (sr3Var.A >= sr3VarC.A) {
                        break loop0;
                    }
                    if (!sr3VarC.j()) {
                        break;
                    }
                    do {
                        unsafe2 = re.a;
                        if (unsafe2.compareAndSwapObject(this, E0, sr3Var, sr3VarC)) {
                            if (sr3Var.f()) {
                                sr3Var.e();
                            }
                        }
                    } while (unsafe2.getObjectVolatile(this, j3) == sr3Var);
                    if (sr3VarC.f()) {
                        sr3VarC.e();
                    }
                }
            } else {
                break;
            }
        }
        if (l72.I(objA)) {
            y();
            if (m30Var.A * ((long) zp.b) < t()) {
                m30Var.a();
                return null;
            }
        } else {
            m30 m30Var4 = (m30) l72.C(objA);
            long j4 = m30Var4.A;
            if (A() || j > o() / ((long) zp.b)) {
                m30Var2 = m30Var4;
                if (j4 > j) {
                    return m30Var2;
                }
                long j5 = j4 * ((long) zp.b);
                do {
                    unsafe = re.a;
                    j2 = F0;
                    longVolatile = unsafe.getLongVolatile(this, j2);
                    if (longVolatile >= j5) {
                        break;
                    }
                } while (!unsafe.compareAndSwapLong(this, j2, longVolatile, j5));
                if (j4 * ((long) zp.b) < t()) {
                    m30Var2.a();
                }
            } else {
                while (true) {
                    Unsafe unsafe4 = re.a;
                    long j6 = B0;
                    sr3 sr3Var2 = (sr3) unsafe4.getObjectVolatile(this, j6);
                    if (sr3Var2.A >= j4 || !m30Var4.j()) {
                        break;
                    }
                    while (true) {
                        Unsafe unsafe5 = re.a;
                        m30Var2 = m30Var4;
                        if (unsafe5.compareAndSwapObject(this, B0, sr3Var2, m30Var4)) {
                            if (sr3Var2.f()) {
                                sr3Var2.e();
                            }
                        } else {
                            if (unsafe5.getObjectVolatile(this, j6) != sr3Var2) {
                                break;
                            }
                            m30Var4 = m30Var2;
                        }
                    }
                    m30Var4 = m30Var2;
                }
                if (j4 > j) {
                }
            }
        }
        return null;
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
    */
    public final String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        Unsafe unsafe = re.a;
        int longVolatile = (int) (unsafe.getLongVolatile(this, H0) >> 60);
        if (longVolatile == 2) {
            sb.append("closed,");
        } else if (longVolatile == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.b + StringUtil.COMMA);
        sb.append("data=[");
        int i = 0;
        List listK = e70.K(unsafe.getObjectVolatile(this, E0), unsafe.getObjectVolatile(this, G0), unsafe.getObjectVolatile(this, B0));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (((m30) obj) != zp.a) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            vp1.g();
            return null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((m30) next).A;
            do {
                Object next2 = it.next();
                long j2 = ((m30) next2).A;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        m30 m30Var = (m30) next;
        long jR = r();
        long jT = t();
        loop2: while (true) {
            int i2 = zp.b;
            int i3 = i;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                long j3 = (m30Var.A * ((long) zp.b)) + ((long) i3);
                if (j3 >= jT && j3 >= jR) {
                    break loop2;
                }
                Object objL = m30Var.l(i3);
                Object obj2 = m30Var.y0.get(i3 * 2);
                if (objL instanceof y00) {
                    string = (j3 >= jR || j3 < jT) ? (j3 >= jT || j3 < jR) ? "cont" : "send" : "receive";
                } else if (objL instanceof xr3) {
                    string = (j3 >= jR || j3 < jT) ? (j3 >= jT || j3 < jR) ? "select" : "onSend" : "onReceive";
                } else if (objL instanceof ef3) {
                    string = "receiveCatching";
                } else if (objL instanceof ys4) {
                    string = ha0.m("EB(", objL, ')');
                } else if (n12.c(objL, zp.f) || n12.c(objL, zp.g)) {
                    string = "resuming_sender";
                } else if (objL == null || objL.equals(zp.e) || objL.equals(zp.i) || objL.equals(zp.h) || objL.equals(zp.k) || objL.equals(zp.j) || objL.equals(zp.l)) {
                    i3++;
                } else {
                    string = objL.toString();
                }
                if (obj2 != null) {
                    sb.append("(" + string + StringUtil.COMMA + obj2 + "),");
                } else {
                    sb.append(string + StringUtil.COMMA);
                }
                i3++;
            }
            i = 0;
        }
        if (p44.y0(sb) == ',') {
            sb.deleteCharAt(sb.length() - 1).getClass();
        }
        sb.append("]");
        return sb.toString();
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
    */
    public final boolean w(long j, boolean z) {
        xp xpVar = this;
        int i = (int) (j >> 60);
        if (i != 0 && i != 1) {
            if (i == 2) {
                xpVar.f(j & 1152921504606846975L);
                if (z) {
                    while (true) {
                        Unsafe unsafe = re.a;
                        long j2 = E0;
                        m30 m30VarM = (m30) unsafe.getObjectVolatile(xpVar, j2);
                        long jR = xpVar.r();
                        if (xpVar.t() <= jR) {
                            break;
                        }
                        long j3 = zp.b;
                        long j4 = jR / j3;
                        if (m30VarM.A != j4 && (m30VarM = xpVar.m(j4, m30VarM)) == null) {
                            if (((m30) unsafe.getObjectVolatile(xpVar, j2)).A < j4) {
                                break;
                            }
                        } else {
                            m30VarM.a();
                            int i2 = (int) (jR % j3);
                            while (true) {
                                Object objL = m30VarM.l(i2);
                                if (objL != null && objL != zp.e) {
                                    if (objL == zp.d || (objL != zp.j && objL != zp.l && objL != zp.i && objL != zp.h && (objL == zp.g || (objL != zp.f && jR == xpVar.r())))) {
                                        break;
                                    }
                                } else {
                                    if (m30VarM.k(i2, objL, zp.h)) {
                                        xpVar.l();
                                        break;
                                    }
                                    xpVar = this;
                                }
                            }
                        }
                    }
                }
            } else {
                if (i != 3) {
                    g.g(dw2.A(i, "unexpected close status: "));
                    return false;
                }
                m30 m30VarF = xpVar.f(j & 1152921504606846975L);
                t80 t80VarH = null;
                Object objK = null;
                loop0: do {
                    AtomicReferenceArray atomicReferenceArray = m30VarF.y0;
                    int i3 = zp.b - 1;
                    while (true) {
                        if (-1 >= i3) {
                            break;
                        }
                        long j5 = (m30VarF.A * ((long) zp.b)) + ((long) i3);
                        while (true) {
                            Object objL2 = m30VarF.l(i3);
                            if (objL2 == zp.i) {
                                break loop0;
                            }
                            br1 br1Var = zp.d;
                            am1 am1Var = xpVar.f;
                            if (objL2 == br1Var) {
                                if (j5 < xpVar.r()) {
                                    break loop0;
                                }
                                if (m30VarF.k(i3, objL2, zp.l)) {
                                    if (am1Var != null) {
                                        t80VarH = ez4.h(am1Var, atomicReferenceArray.get(i3 * 2), t80VarH);
                                    }
                                    m30VarF.n(i3, null);
                                    m30VarF.i();
                                }
                            } else if (objL2 == zp.e || objL2 == null) {
                                if (m30VarF.k(i3, objL2, zp.l)) {
                                    m30VarF.i();
                                    break;
                                }
                            } else if (!(objL2 instanceof xs4) && !(objL2 instanceof ys4)) {
                                br1 br1Var2 = zp.g;
                                if (objL2 == br1Var2 || objL2 == zp.f) {
                                    break loop0;
                                }
                                if (objL2 != br1Var2) {
                                    break;
                                }
                            } else {
                                if (j5 < xpVar.r()) {
                                    break loop0;
                                }
                                xs4 xs4Var = objL2 instanceof ys4 ? ((ys4) objL2).a : (xs4) objL2;
                                if (m30VarF.k(i3, objL2, zp.l)) {
                                    if (am1Var != null) {
                                        t80VarH = ez4.h(am1Var, atomicReferenceArray.get(i3 * 2), t80VarH);
                                    }
                                    objK = co4.K(objK, xs4Var);
                                    m30VarF.n(i3, null);
                                    m30VarF.i();
                                }
                            }
                        }
                        i3--;
                    }
                } while (m30VarF != null);
                if (objK != null) {
                    if (objK instanceof ArrayList) {
                        ArrayList arrayList = (ArrayList) objK;
                        for (int size = arrayList.size() - 1; -1 < size; size--) {
                            xpVar.G((xs4) arrayList.get(size), false);
                        }
                    } else {
                        xpVar.G((xs4) objK, false);
                    }
                }
                if (t80VarH != null) {
                    throw t80VarH;
                }
            }
            return true;
        }
        return false;
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
