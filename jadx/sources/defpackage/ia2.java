package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ia2 extends ef0 implements on0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater y0 = AtomicIntegerFieldUpdater.newUpdater(ia2.class, "runningWorkers$volatile");
    public static final /* synthetic */ long z0 = re.a.objectFieldOffset(ia2.class.getDeclaredField("runningWorkers$volatile"));
    public final ef0 A;
    public final int X;
    public final yd2 Y;
    public final Object Z;
    private volatile /* synthetic */ int runningWorkers$volatile;
    public final /* synthetic */ on0 z;

    /* JADX WARN: Multi-variable type inference failed */
    public ia2(ef0 ef0Var, int i) {
        on0 on0Var = ef0Var instanceof on0 ? (on0) ef0Var : null;
        this.z = on0Var == null ? jl0.a : on0Var;
        this.A = ef0Var;
        this.X = i;
        this.Y = new yd2();
        this.Z = new Object();
    }

    @Override // defpackage.on0
    public final zv0 I(long j, Runnable runnable, cf0 cf0Var) {
        return this.z.I(j, runnable, cf0Var);
    }

    @Override // defpackage.on0
    public final void U(long j, z00 z00Var) {
        this.z.U(j, z00Var);
    }

    @Override // defpackage.ef0
    public final void j0(cf0 cf0Var, Runnable runnable) {
        Runnable runnableX0;
        this.Y.a(runnable);
        if (re.a.getIntVolatile(this, z0) >= this.X || !z0() || (runnableX0 = x0()) == null) {
            return;
        }
        try {
            mv0.b(this.A, this, new um1(6, (Object) this, (Object) runnableX0, false));
        } catch (Throwable th) {
            y0.decrementAndGet(this);
            throw th;
        }
    }

    @Override // defpackage.ef0
    public final void n0(cf0 cf0Var, Runnable runnable) {
        Runnable runnableX0;
        this.Y.a(runnable);
        if (re.a.getIntVolatile(this, z0) >= this.X || !z0() || (runnableX0 = x0()) == null) {
            return;
        }
        try {
            this.A.n0(this, new um1(6, (Object) this, (Object) runnableX0, false));
        } catch (Throwable th) {
            y0.decrementAndGet(this);
            throw th;
        }
    }

    @Override // defpackage.ef0
    public final ef0 r0(int i) {
        vf2.d(1);
        return 1 >= this.X ? this : super.r0(1);
    }

    @Override // defpackage.ef0
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.A);
        sb.append(".limitedParallelism(");
        return ha0.p(sb, this.X, ')');
    }

    public final Runnable x0() {
        while (true) {
            Runnable runnable = (Runnable) this.Y.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.Z) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = y0;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.Y.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean z0() {
        synchronized (this.Z) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = y0;
            if (re.a.getIntVolatile(this, z0) >= this.X) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
