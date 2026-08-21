package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class if0 extends Thread {
    public long A;
    public long X;
    public int Y;
    public boolean Z;
    public final dx4 b;
    public final bh3 f;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;
    public final /* synthetic */ kf0 y0;
    public jf0 z;
    public static final /* synthetic */ AtomicIntegerFieldUpdater z0 = AtomicIntegerFieldUpdater.newUpdater(if0.class, "workerCtl$volatile");
    public static final /* synthetic */ long A0 = re.a.objectFieldOffset(if0.class.getDeclaredField("workerCtl$volatile"));

    public if0(kf0 kf0Var, int i) {
        this.y0 = kf0Var;
        setDaemon(true);
        setContextClassLoader(kf0.class.getClassLoader());
        this.b = new dx4();
        this.f = new bh3();
        this.z = jf0.A;
        this.nextParkedWorker = kf0.B0;
        int iNanoTime = (int) System.nanoTime();
        this.Y = iNanoTime == 0 ? 42 : iNanoTime;
        f(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        r1 = r4.getIntVolatile(r11, defpackage.dx4.e);
        r2 = r4.getIntVolatile(r11, defpackage.dx4.g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r1 == r2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        if (defpackage.re.a.getIntVolatile(r11, defpackage.dx4.d) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        r2 = r2 - 1;
        r4 = r11.d(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (r4 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r8 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final va4 a(boolean z) {
        va4 va4VarE;
        va4 va4VarE2;
        long j;
        Unsafe unsafe;
        jf0 jf0Var = this.z;
        kf0 kf0Var = this.y0;
        va4 va4Var = null;
        dx4 dx4Var = this.b;
        jf0 jf0Var2 = jf0.b;
        if (jf0Var != jf0Var2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = kf0.z0;
            do {
                j = atomicLongFieldUpdater.get(kf0Var);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    dx4Var.getClass();
                    long j2 = dx4.f;
                    loop1: while (true) {
                        Unsafe unsafe2 = re.a;
                        va4 va4Var2 = (va4) unsafe2.getObjectVolatile(dx4Var, j2);
                        if (va4Var2 == null || !va4Var2.f) {
                            break;
                        }
                        do {
                            unsafe = re.a;
                            if (unsafe.compareAndSwapObject(dx4Var, dx4.f, va4Var2, (Object) null)) {
                                va4Var = va4Var2;
                                break loop1;
                            }
                        } while (unsafe.getObjectVolatile(dx4Var, j2) == va4Var2);
                    }
                    if (va4Var != null) {
                        return va4Var;
                    }
                    va4 va4Var3 = (va4) kf0Var.Y.d();
                    return va4Var3 == null ? i(1) : va4Var3;
                }
            } while (!kf0.z0.compareAndSet(kf0Var, j, j - 4398046511104L));
            this.z = jf0Var2;
        }
        if (z) {
            boolean z2 = d(kf0Var.b * 2) == 0;
            if (z2 && (va4VarE2 = e()) != null) {
                return va4VarE2;
            }
            dx4Var.getClass();
            va4 va4VarC = (va4) re.a(dx4Var, dx4.f, null);
            if (va4VarC == null) {
                va4VarC = dx4Var.c();
            }
            if (va4VarC != null) {
                return va4VarC;
            }
            if (!z2 && (va4VarE = e()) != null) {
                return va4VarE;
            }
        } else {
            va4 va4VarE3 = e();
            if (va4VarE3 != null) {
                return va4VarE3;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.Y;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.Y = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % i;
    }

    public final va4 e() {
        int iD = d(2);
        kf0 kf0Var = this.y0;
        fp1 fp1Var = kf0Var.Y;
        fp1 fp1Var2 = kf0Var.X;
        if (iD == 0) {
            va4 va4Var = (va4) fp1Var2.d();
            return va4Var != null ? va4Var : (va4) fp1Var.d();
        }
        va4 va4Var2 = (va4) fp1Var.d();
        return va4Var2 != null ? va4Var2 : (va4) fp1Var2.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.y0.A);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(jf0 jf0Var) {
        jf0 jf0Var2 = this.z;
        boolean z = jf0Var2 == jf0.b;
        if (z) {
            kf0.z0.addAndGet(this.y0, 4398046511104L);
        }
        if (jf0Var2 != jf0Var) {
            this.z = jf0Var;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
    
        r1 = -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final va4 i(int i) {
        int i2;
        long j;
        va4 va4VarC;
        long j2;
        long j3;
        Unsafe unsafe;
        int i3 = i;
        AtomicLongFieldUpdater atomicLongFieldUpdater = kf0.z0;
        kf0 kf0Var = this.y0;
        int i4 = (int) (atomicLongFieldUpdater.get(kf0Var) & 2097151);
        va4 va4Var = null;
        if (i4 < 2) {
            return null;
        }
        int iD = d(i4);
        int i5 = 0;
        long jMin = Long.MAX_VALUE;
        while (i5 < i4) {
            iD++;
            if (iD > i4) {
                iD = 1;
            }
            if0 if0Var = (if0) kf0Var.Z.b(iD);
            if (if0Var == null || if0Var == this) {
                i2 = i4;
            } else {
                dx4 dx4Var = if0Var.b;
                if (i3 != 3) {
                    dx4Var.getClass();
                    Unsafe unsafe2 = re.a;
                    int intVolatile = unsafe2.getIntVolatile(dx4Var, dx4.e);
                    j = 0;
                    int intVolatile2 = unsafe2.getIntVolatile(dx4Var, dx4.g);
                    boolean z = i3 == 1;
                    while (true) {
                        if (intVolatile == intVolatile2) {
                            i2 = i4;
                            break;
                        }
                        if (z) {
                            i2 = i4;
                            if (re.a.getIntVolatile(dx4Var, dx4.d) == 0) {
                                break;
                            }
                        } else {
                            i2 = i4;
                        }
                        int i6 = intVolatile + 1;
                        va4 va4VarD = dx4Var.d(intVolatile, z);
                        if (va4VarD != null) {
                            va4VarC = va4VarD;
                            break;
                        }
                        intVolatile = i6;
                        i4 = i2;
                    }
                } else {
                    va4VarC = dx4Var.c();
                    i2 = i4;
                    j = 0;
                }
                bh3 bh3Var = this.f;
                if (va4VarC == null) {
                    j2 = -1;
                    long j4 = dx4.f;
                    while (true) {
                        va4 va4Var2 = (va4) re.a.getObjectVolatile(dx4Var, j4);
                        if (va4Var2 == null) {
                            break;
                        }
                        if (((va4Var2.f ? 1 : 2) & i) == 0) {
                            break;
                        }
                        bb4.f.getClass();
                        dx4 dx4Var2 = dx4Var;
                        long jNanoTime = System.nanoTime() - va4Var2.b;
                        long j5 = bb4.b;
                        if (jNanoTime < j5) {
                            j3 = j5 - jNanoTime;
                            break;
                        }
                        do {
                            unsafe = re.a;
                            if (unsafe.compareAndSwapObject(dx4Var2, dx4.f, va4Var2, (Object) null)) {
                                bh3Var.b = va4Var2;
                                j3 = -1;
                                break;
                            }
                        } while (unsafe.getObjectVolatile(dx4Var2, j4) == va4Var2);
                        dx4Var = dx4Var2;
                    }
                } else {
                    bh3Var.b = va4VarC;
                    j3 = -1;
                    j2 = -1;
                }
                if (j3 == j2) {
                    va4 va4Var3 = (va4) bh3Var.b;
                    bh3Var.b = null;
                    return va4Var3;
                }
                if (j3 > j) {
                    jMin = Math.min(jMin, j3);
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
            va4Var = null;
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.X = jMin;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        jf0 jf0Var;
        loop0: while (true) {
            boolean z = false;
            while (kf0.A0.get(this.y0) != 1) {
                jf0 jf0Var2 = this.z;
                jf0 jf0Var3 = jf0.X;
                if (jf0Var2 == jf0Var3) {
                    break loop0;
                }
                va4 va4VarA = a(this.Z);
                if (va4VarA != null) {
                    this.X = 0L;
                    kf0 kf0Var = this.y0;
                    this.A = 0L;
                    if (this.z == jf0.z) {
                        this.z = jf0.f;
                    }
                    if (va4VarA.f) {
                        if (h(jf0.f) && !kf0Var.F() && !kf0Var.C(kf0.z0.get(kf0Var))) {
                            kf0Var.F();
                        }
                        try {
                            va4VarA.run();
                        } catch (Throwable th) {
                            Thread threadCurrentThread = Thread.currentThread();
                            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                        }
                        kf0.z0.addAndGet(kf0Var, -2097152L);
                        if (this.z != jf0Var3) {
                            this.z = jf0.A;
                        }
                    } else {
                        try {
                            va4VarA.run();
                        } catch (Throwable th2) {
                            Thread threadCurrentThread2 = Thread.currentThread();
                            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
                        }
                    }
                } else {
                    this.Z = false;
                    if (this.X == 0) {
                        Object obj = this.nextParkedWorker;
                        br1 br1Var = kf0.B0;
                        if (obj != br1Var) {
                            int i = -1;
                            re.a.putIntVolatile(this, A0, -1);
                            while (this.nextParkedWorker != kf0.B0) {
                                Unsafe unsafe = re.a;
                                long j = A0;
                                if (unsafe.getIntVolatile(this, j) == i) {
                                    kf0 kf0Var2 = this.y0;
                                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = kf0.A0;
                                    if (atomicIntegerFieldUpdater.get(kf0Var2) == 1) {
                                        break;
                                    }
                                    jf0 jf0Var4 = this.z;
                                    jf0 jf0Var5 = jf0.X;
                                    if (jf0Var4 == jf0Var5) {
                                        break;
                                    }
                                    h(jf0.z);
                                    Thread.interrupted();
                                    if (this.A == 0) {
                                        jf0Var = jf0Var5;
                                        this.A = System.nanoTime() + this.y0.z;
                                    } else {
                                        jf0Var = jf0Var5;
                                    }
                                    LockSupport.parkNanos(this.y0.z);
                                    if (System.nanoTime() - this.A >= 0) {
                                        this.A = 0L;
                                        kf0 kf0Var3 = this.y0;
                                        synchronized (kf0Var3.Z) {
                                            try {
                                                if (!(atomicIntegerFieldUpdater.get(kf0Var3) == 1)) {
                                                    AtomicLongFieldUpdater atomicLongFieldUpdater = kf0.z0;
                                                    if (((int) (atomicLongFieldUpdater.get(kf0Var3) & 2097151)) > kf0Var3.b) {
                                                        if (unsafe.compareAndSwapInt(this, j, -1, 1)) {
                                                            int i2 = this.indexInArray;
                                                            f(0);
                                                            kf0Var3.x(this, i2, 0);
                                                            int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(kf0Var3) & 2097151);
                                                            if (andDecrement != i2) {
                                                                Object objB = kf0Var3.Z.b(andDecrement);
                                                                objB.getClass();
                                                                if0 if0Var = (if0) objB;
                                                                kf0Var3.Z.c(i2, if0Var);
                                                                if0Var.f(i2);
                                                                kf0Var3.x(if0Var, andDecrement, i2);
                                                            }
                                                            kf0Var3.Z.c(andDecrement, null);
                                                            this.z = jf0Var;
                                                        }
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                throw th3;
                                            }
                                        }
                                    }
                                    i = -1;
                                }
                            }
                        } else {
                            kf0 kf0Var4 = this.y0;
                            AtomicLongFieldUpdater atomicLongFieldUpdater2 = kf0.y0;
                            if (this.nextParkedWorker == br1Var) {
                                while (true) {
                                    long j2 = atomicLongFieldUpdater2.get(kf0Var4);
                                    int i3 = this.indexInArray;
                                    this.nextParkedWorker = kf0Var4.Z.b((int) (j2 & 2097151));
                                    kf0 kf0Var5 = kf0Var4;
                                    AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
                                    if (atomicLongFieldUpdater3.compareAndSet(kf0Var5, j2, ((j2 + 2097152) & (-2097152)) | ((long) i3))) {
                                        break;
                                    }
                                    atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
                                    kf0Var4 = kf0Var5;
                                }
                            }
                        }
                    } else if (z) {
                        h(jf0.z);
                        Thread.interrupted();
                        LockSupport.parkNanos(this.X);
                        this.X = 0L;
                    } else {
                        z = true;
                    }
                }
            }
            break loop0;
        }
        h(jf0.X);
    }
}
