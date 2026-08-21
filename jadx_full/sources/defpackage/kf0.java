package defpackage;

import java.io.Closeable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kf0 implements Executor, Closeable {
    public final String A;
    public final fp1 X;
    public final fp1 Y;
    public final rj3 Z;
    private volatile /* synthetic */ int _isTerminated$volatile;
    public final int b;
    private volatile /* synthetic */ long controlState$volatile;
    public final int f;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;
    public final long z;
    public static final /* synthetic */ AtomicLongFieldUpdater y0 = AtomicLongFieldUpdater.newUpdater(kf0.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater z0 = AtomicLongFieldUpdater.newUpdater(kf0.class, "controlState$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater A0 = AtomicIntegerFieldUpdater.newUpdater(kf0.class, "_isTerminated$volatile");
    public static final br1 B0 = new br1("NOT_IN_STACK", 3);

    public kf0(int i, int i2, long j, String str) {
        this.b = i;
        this.f = i2;
        this.z = j;
        this.A = str;
        if (i < 1) {
            e04.f(ha0.k("Core pool size ", i, " should be at least 1"));
            throw null;
        }
        if (i2 < i) {
            e04.f(fw.s(i2, i, "Max pool size ", " should be greater than or equals to core pool size "));
            throw null;
        }
        if (i2 > 2097150) {
            e04.f(ha0.k("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150"));
            throw null;
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.X = new fp1();
        this.Y = new fp1();
        this.Z = new rj3((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
    }

    public static /* synthetic */ void s(kf0 kf0Var, Runnable runnable, int i) {
        kf0Var.n(runnable, false, (i & 4) == 0);
    }

    public final boolean C(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.b;
        if (i < i2) {
            int iG = g();
            if (iG == 1 && i2 > 1) {
                g();
            }
            if (iG > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean F() {
        kf0 kf0Var;
        br1 br1Var;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = y0;
            long j = atomicLongFieldUpdater.get(this);
            if0 if0Var = (if0) this.Z.b((int) (2097151 & j));
            if (if0Var == null) {
                if0Var = null;
                kf0Var = this;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object objC = if0Var.c();
                while (true) {
                    br1Var = B0;
                    if (objC == br1Var) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    if0 if0Var2 = (if0) objC;
                    iB = if0Var2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = if0Var2.c();
                    atomicLongFieldUpdater = atomicLongFieldUpdater;
                    this = this;
                }
                if (iB >= 0) {
                    kf0 kf0Var2 = this;
                    boolean zCompareAndSet = atomicLongFieldUpdater.compareAndSet(kf0Var2, j, j2 | ((long) iB));
                    kf0Var = kf0Var2;
                    if (zCompareAndSet) {
                        if0Var.g(br1Var);
                    }
                    this = kf0Var;
                } else {
                    continue;
                }
            }
            if (if0Var == null) {
                return false;
            }
            if (if0.z0.compareAndSet(if0Var, -1, 0)) {
                LockSupport.unpark(if0Var);
                return true;
            }
            this = kf0Var;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0085  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void close() throws InterruptedException {
        int i;
        va4 va4VarA;
        if (A0.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            if0 if0Var = threadCurrentThread instanceof if0 ? (if0) threadCurrentThread : null;
            if (if0Var == null || if0Var.y0 != this) {
                if0Var = null;
            }
            synchronized (this.Z) {
                i = (int) (z0.get(this) & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    Object objB = this.Z.b(i2);
                    objB.getClass();
                    if0 if0Var2 = (if0) objB;
                    if (if0Var2 != if0Var) {
                        while (if0Var2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(if0Var2);
                            if0Var2.join(10000L);
                        }
                        dx4 dx4Var = if0Var2.b;
                        fp1 fp1Var = this.Y;
                        dx4Var.getClass();
                        va4 va4Var = (va4) re.a(dx4Var, dx4.f, null);
                        if (va4Var != null) {
                            fp1Var.a(va4Var);
                        }
                        while (true) {
                            va4 va4VarC = dx4Var.c();
                            if (va4VarC == null) {
                                break;
                            } else {
                                fp1Var.a(va4VarC);
                            }
                        }
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.Y.b();
            this.X.b();
            while (true) {
                if (if0Var == null) {
                    va4VarA = (va4) this.X.d();
                    if (va4VarA == null && (va4VarA = (va4) this.Y.d()) == null) {
                        break;
                    }
                } else {
                    va4VarA = if0Var.a(true);
                    if (va4VarA == null) {
                    }
                }
                try {
                    va4VarA.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (if0Var != null) {
                if0Var.h(jf0.X);
            }
            y0.set(this, 0L);
            z0.set(this, 0L);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        s(this, runnable, 6);
    }

    public final int g() {
        synchronized (this.Z) {
            try {
                if (A0.get(this) == 1) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = z0;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.b) {
                    return 0;
                }
                if (i >= this.f) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.Z.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                if0 if0Var = new if0(this, i3);
                this.Z.c(i3, if0Var);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                if0Var.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(Runnable runnable, boolean z, boolean z2) {
        va4 ya4Var;
        jf0 jf0Var;
        bb4.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof va4) {
            ya4Var = (va4) runnable;
            ya4Var.b = jNanoTime;
            ya4Var.f = z;
        } else {
            ya4Var = new ya4(runnable, jNanoTime, z);
        }
        boolean z3 = ya4Var.f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = z0;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        if0 if0Var = threadCurrentThread instanceof if0 ? (if0) threadCurrentThread : null;
        if (if0Var == null || if0Var.y0 != this) {
            if0Var = null;
        }
        if (if0Var != null && (jf0Var = if0Var.z) != jf0.X && (ya4Var.f || jf0Var != jf0.f)) {
            if0Var.Z = true;
            dx4 dx4Var = if0Var.b;
            if (z2) {
                ya4Var = dx4Var.a(ya4Var);
            } else {
                dx4Var.getClass();
                va4 va4Var = (va4) re.a(dx4Var, dx4.f, ya4Var);
                ya4Var = va4Var == null ? null : dx4Var.a(va4Var);
            }
        }
        if (ya4Var != null) {
            if (!(ya4Var.f ? this.Y.a(ya4Var) : this.X.a(ya4Var))) {
                throw new RejectedExecutionException(fw.y(new StringBuilder(), this.A, " was terminated"));
            }
        }
        if (z3) {
            if (F() || C(jAddAndGet)) {
                return;
            }
            F();
            return;
        }
        if (F() || C(atomicLongFieldUpdater.get(this))) {
            return;
        }
        F();
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        rj3 rj3Var = this.Z;
        int iA = rj3Var.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iA; i6++) {
            if0 if0Var = (if0) rj3Var.b(i6);
            if (if0Var != null) {
                dx4 dx4Var = if0Var.b;
                dx4Var.getClass();
                Object objectVolatile = re.a.getObjectVolatile(dx4Var, dx4.f);
                int iB = dx4Var.b();
                if (objectVolatile != null) {
                    iB++;
                }
                int iOrdinal = if0Var.z.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iB);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iB);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i3++;
                } else if (iOrdinal == 3) {
                    i4++;
                    if (iB > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iB);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        g.d();
                        return null;
                    }
                    i5++;
                }
            }
        }
        long j = z0.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.A);
        sb4.append('@');
        sb4.append(ek0.l(this));
        sb4.append("[Pool Size {core = ");
        int i7 = this.b;
        sb4.append(i7);
        sb4.append(", max = ");
        sb4.append(this.f);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.X.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.Y.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i7 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final void x(if0 if0Var, int i, int i2) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = y0;
            long j = atomicLongFieldUpdater.get(this);
            int i3 = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (i3 == i) {
                if (i2 == 0) {
                    Object objC = if0Var.c();
                    while (true) {
                        if (objC == B0) {
                            i3 = -1;
                            break;
                        }
                        if (objC == null) {
                            i3 = 0;
                            break;
                        }
                        if0 if0Var2 = (if0) objC;
                        int iB = if0Var2.b();
                        if (iB != 0) {
                            i3 = iB;
                            break;
                        }
                        objC = if0Var2.c();
                    }
                } else {
                    i3 = i2;
                }
            }
            if (i3 >= 0) {
                long j3 = j2 | ((long) i3);
                kf0 kf0Var = this;
                if (atomicLongFieldUpdater.compareAndSet(kf0Var, j, j3)) {
                    return;
                } else {
                    this = kf0Var;
                }
            }
        }
    }
}
