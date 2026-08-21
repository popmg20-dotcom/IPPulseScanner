package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dx4 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b;
    public static final /* synthetic */ AtomicIntegerFieldUpdater c;
    public static final /* synthetic */ long d;
    public static final /* synthetic */ long e;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ long g;
    public final AtomicReferenceArray a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    static {
        Unsafe unsafe = re.a;
        f = unsafe.objectFieldOffset(dx4.class.getDeclaredField("lastScheduledTask$volatile"));
        b = AtomicIntegerFieldUpdater.newUpdater(dx4.class, "producerIndex$volatile");
        g = unsafe.objectFieldOffset(dx4.class.getDeclaredField("producerIndex$volatile"));
        e = unsafe.objectFieldOffset(dx4.class.getDeclaredField("consumerIndex$volatile"));
        c = AtomicIntegerFieldUpdater.newUpdater(dx4.class, "blockingTasksInBuffer$volatile");
        d = unsafe.objectFieldOffset(dx4.class.getDeclaredField("blockingTasksInBuffer$volatile"));
    }

    public final va4 a(va4 va4Var) {
        if (b() == 127) {
            return va4Var;
        }
        if (va4Var.f) {
            c.incrementAndGet(this);
        }
        int intVolatile = re.a.getIntVolatile(this, g) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.a;
            if (atomicReferenceArray.get(intVolatile) == null) {
                atomicReferenceArray.lazySet(intVolatile, va4Var);
                b.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final int b() {
        return re.a.getIntVolatile(this, g) - re.a.getIntVolatile(this, e);
    }

    public final va4 c() {
        va4 va4Var;
        while (true) {
            Unsafe unsafe = re.a;
            long j = e;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile - unsafe.getIntVolatile(this, g) == 0) {
                return null;
            }
            int i = intVolatile & 127;
            dx4 dx4Var = this;
            if (unsafe.compareAndSwapInt(dx4Var, j, intVolatile, intVolatile + 1) && (va4Var = (va4) dx4Var.a.getAndSet(i, null)) != null) {
                if (va4Var.f) {
                    c.decrementAndGet(dx4Var);
                }
                return va4Var;
            }
            this = dx4Var;
        }
    }

    public final va4 d(int i, boolean z) {
        int i2 = i & 127;
        AtomicReferenceArray atomicReferenceArray = this.a;
        va4 va4Var = (va4) atomicReferenceArray.get(i2);
        if (va4Var != null && va4Var.f == z) {
            while (!atomicReferenceArray.compareAndSet(i2, va4Var, null)) {
                if (atomicReferenceArray.get(i2) != va4Var) {
                }
            }
            if (z) {
                c.decrementAndGet(this);
            }
            return va4Var;
        }
        return null;
    }
}
