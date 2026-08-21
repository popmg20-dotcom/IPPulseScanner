package defpackage;

import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g61 extends b61 implements on0 {
    public static final /* synthetic */ int A0 = 0;
    public static final /* synthetic */ long Z;
    public static final /* synthetic */ long y0;
    public static final /* synthetic */ long z0;
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile;
    private volatile /* synthetic */ Object _queue$volatile;

    static {
        Unsafe unsafe = re.a;
        z0 = unsafe.objectFieldOffset(g61.class.getDeclaredField("_queue$volatile"));
        Z = unsafe.objectFieldOffset(g61.class.getDeclaredField("_delayed$volatile"));
        y0 = unsafe.objectFieldOffset(g61.class.getDeclaredField("_isCompleted$volatile"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r6 = r3;
        r13 = null;
     */
    @Override // defpackage.b61
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long G0() {
        Unsafe unsafe;
        g61 g61Var;
        Unsafe unsafe2;
        Runnable runnable;
        e61 e61Var;
        br1 br1Var = h61.b;
        long j = z0;
        if (!H0()) {
            J0();
            loop0: while (true) {
                unsafe = re.a;
                Object objectVolatile = unsafe.getObjectVolatile(this, j);
                if (objectVolatile == null) {
                    g61Var = this;
                    break;
                }
                if (objectVolatile instanceof ae2) {
                    ae2 ae2Var = (ae2) objectVolatile;
                    Object objD = ae2Var.d();
                    if (objD != ae2.e) {
                        Runnable runnable2 = (Runnable) objD;
                        g61Var = this;
                        runnable = runnable2;
                        unsafe2 = unsafe;
                        break;
                    }
                    ae2 ae2VarC = ae2Var.c();
                    while (true) {
                        Unsafe unsafe3 = re.a;
                        g61Var = this;
                        if (!unsafe3.compareAndSwapObject(g61Var, z0, objectVolatile, ae2VarC) && unsafe3.getObjectVolatile(g61Var, j) == objectVolatile) {
                            this = g61Var;
                        }
                    }
                    this = g61Var;
                } else {
                    g61Var = this;
                    if (objectVolatile == br1Var) {
                        break;
                    }
                    do {
                        unsafe2 = re.a;
                        if (unsafe2.compareAndSwapObject(g61Var, z0, objectVolatile, (Object) null)) {
                            runnable = (Runnable) objectVolatile;
                            unsafe = unsafe2;
                            break loop0;
                        }
                    } while (unsafe2.getObjectVolatile(g61Var, j) == objectVolatile);
                    this = g61Var;
                }
            }
            if (runnable != null) {
                runnable.run();
                return 0L;
            }
            ae aeVar = g61Var.X;
            if (((aeVar == null || aeVar.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
                Object objectVolatile2 = unsafe.getObjectVolatile(g61Var, j);
                if (objectVolatile2 != null) {
                    if (objectVolatile2 instanceof ae2) {
                        long longVolatile = unsafe2.getLongVolatile((ae2) objectVolatile2, ae2.g);
                        if (((int) (1073741823 & longVolatile)) != ((int) ((longVolatile & 1152921503533105152L) >> 30))) {
                            return 0L;
                        }
                    } else if (objectVolatile2 == br1Var) {
                        return Long.MAX_VALUE;
                    }
                }
                f61 f61Var = (f61) unsafe.getObjectVolatile(g61Var, Z);
                if (f61Var != null) {
                    synchronized (f61Var) {
                        e61[] e61VarArr = f61Var.a;
                        e61Var = e61VarArr != null ? e61VarArr[0] : null;
                    }
                    if (e61Var != null) {
                        long jNanoTime = e61Var.b - System.nanoTime();
                        if (jNanoTime >= 0) {
                            return jNanoTime;
                        }
                    }
                }
                return Long.MAX_VALUE;
            }
        }
        return 0L;
    }

    @Override // defpackage.on0
    public zv0 I(long j, Runnable runnable, cf0 cf0Var) {
        return jl0.a.I(j, runnable, cf0Var);
    }

    public void I0(Runnable runnable) {
        J0();
        if (!K0(runnable)) {
            il0.B0.I0(runnable);
            return;
        }
        Thread threadL0 = L0();
        if (Thread.currentThread() != threadL0) {
            LockSupport.unpark(threadL0);
        }
    }

    public final void J0() {
        e61 e61VarD;
        f61 f61Var = (f61) re.a.getObjectVolatile(this, Z);
        if (f61Var == null || f61Var.b() == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (f61Var) {
                try {
                    e61[] e61VarArr = f61Var.a;
                    e61 e61Var = e61VarArr != null ? e61VarArr[0] : null;
                    if (e61Var != null) {
                        e61VarD = ((jNanoTime - e61Var.b) > 0L ? 1 : ((jNanoTime - e61Var.b) == 0L ? 0 : -1)) >= 0 ? K0(e61Var) : false ? f61Var.d(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (e61VarD != null);
    }

    public final boolean K0(Runnable runnable) {
        Unsafe unsafe;
        Unsafe unsafe2;
        Unsafe unsafe3;
        loop0: while (true) {
            Unsafe unsafe4 = re.a;
            long j = z0;
            Object objectVolatile = unsafe4.getObjectVolatile(this, j);
            if (unsafe4.getIntVolatile(this, y0) == 1) {
                return false;
            }
            if (objectVolatile == null) {
                do {
                    unsafe = re.a;
                    if (unsafe.compareAndSwapObject(this, z0, (Object) null, runnable)) {
                        break loop0;
                    }
                } while (unsafe.getObjectVolatile(this, j) == null);
            } else if (objectVolatile instanceof ae2) {
                ae2 ae2Var = (ae2) objectVolatile;
                int iA = ae2Var.a(runnable);
                if (iA == 0) {
                    break;
                }
                if (iA == 1) {
                    ae2 ae2VarC = ae2Var.c();
                    do {
                        unsafe2 = re.a;
                        if (unsafe2.compareAndSwapObject(this, z0, objectVolatile, ae2VarC)) {
                            break;
                        }
                    } while (unsafe2.getObjectVolatile(this, j) == objectVolatile);
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (objectVolatile == h61.b) {
                    return false;
                }
                ae2 ae2Var2 = new ae2(8, true);
                ae2Var2.a((Runnable) objectVolatile);
                ae2Var2.a(runnable);
                do {
                    unsafe3 = re.a;
                    if (unsafe3.compareAndSwapObject(this, z0, objectVolatile, ae2Var2)) {
                        break loop0;
                    }
                } while (unsafe3.getObjectVolatile(this, j) == objectVolatile);
            }
        }
        return true;
    }

    public abstract Thread L0();

    public final boolean M0() {
        ae aeVar = this.X;
        if (aeVar != null ? aeVar.isEmpty() : true) {
            Unsafe unsafe = re.a;
            f61 f61Var = (f61) unsafe.getObjectVolatile(this, Z);
            if (f61Var != null && f61Var.b() != 0) {
                return false;
            }
            Object objectVolatile = unsafe.getObjectVolatile(this, z0);
            if (objectVolatile != null) {
                if (objectVolatile instanceof ae2) {
                    long longVolatile = unsafe.getLongVolatile((ae2) objectVolatile, ae2.g);
                    return ((int) (1073741823 & longVolatile)) == ((int) ((longVolatile & 1152921503533105152L) >> 30));
                }
                if (objectVolatile == h61.b) {
                }
            }
            return true;
        }
        return false;
    }

    public void N0(long j, e61 e61Var) {
        il0.B0.O0(j, e61Var);
    }

    public final void O0(long j, e61 e61Var) {
        g61 g61Var;
        int iD;
        Unsafe unsafe;
        Thread threadL0;
        long j2 = Z;
        Unsafe unsafe2 = re.a;
        if (unsafe2.getIntVolatile(this, y0) == 1) {
            g61Var = this;
            iD = 1;
        } else {
            f61 f61Var = (f61) unsafe2.getObjectVolatile(this, j2);
            if (f61Var == null) {
                f61 f61Var2 = new f61();
                f61Var2.c = j;
                while (true) {
                    unsafe = re.a;
                    g61Var = this;
                    if (unsafe.compareAndSwapObject(g61Var, Z, (Object) null, f61Var2) || unsafe.getObjectVolatile(g61Var, j2) != null) {
                        break;
                    } else {
                        this = g61Var;
                    }
                }
                Object objectVolatile = unsafe.getObjectVolatile(g61Var, j2);
                objectVolatile.getClass();
                f61Var = (f61) objectVolatile;
                unsafe2 = unsafe;
            } else {
                g61Var = this;
            }
            iD = e61Var.d(j, f61Var, g61Var);
        }
        if (iD != 0) {
            if (iD == 1) {
                g61Var.N0(j, e61Var);
                return;
            } else {
                if (iD == 2) {
                    return;
                }
                xe.q("unexpected result");
                return;
            }
        }
        f61 f61Var3 = (f61) unsafe2.getObjectVolatile(g61Var, j2);
        if (f61Var3 != null) {
            synchronized (f61Var3) {
                e61[] e61VarArr = f61Var3.a;
                e61Var = e61VarArr != null ? e61VarArr[0] : null;
            }
        }
        if (e61Var != e61Var || Thread.currentThread() == (threadL0 = g61Var.L0())) {
            return;
        }
        LockSupport.unpark(threadL0);
    }

    @Override // defpackage.on0
    public final void U(long j, z00 z00Var) {
        long j2 = j > 0 ? j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j : 0L;
        if (j2 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            c61 c61Var = new c61(this, j2 + jNanoTime, z00Var);
            O0(jNanoTime, c61Var);
            z00Var.z(new s00(2, c61Var));
        }
    }

    @Override // defpackage.ef0
    public final void j0(cf0 cf0Var, Runnable runnable) {
        I0(runnable);
    }

    @Override // defpackage.b61
    public void shutdown() {
        br1 br1Var;
        Unsafe unsafe;
        e61 e61VarD;
        qd4.a.set(null);
        re.a.putIntVolatile(this, y0, 1);
        br1 br1Var2 = h61.b;
        long j = z0;
        loop0: while (true) {
            Object objectVolatile = re.a.getObjectVolatile(this, j);
            if (objectVolatile == null) {
                while (true) {
                    Unsafe unsafe2 = re.a;
                    br1Var = br1Var2;
                    if (unsafe2.compareAndSwapObject(this, z0, (Object) null, br1Var2)) {
                        break loop0;
                    } else if (unsafe2.getObjectVolatile(this, j) != null) {
                        break;
                    } else {
                        br1Var2 = br1Var;
                    }
                }
                br1Var2 = br1Var;
            } else {
                br1Var = br1Var2;
                if (objectVolatile instanceof ae2) {
                    ((ae2) objectVolatile).b();
                    break;
                }
                if (objectVolatile == br1Var) {
                    break;
                }
                ae2 ae2Var = new ae2(8, true);
                ae2Var.a((Runnable) objectVolatile);
                do {
                    unsafe = re.a;
                    if (unsafe.compareAndSwapObject(this, z0, objectVolatile, ae2Var)) {
                        break loop0;
                    }
                } while (unsafe.getObjectVolatile(this, j) == objectVolatile);
                br1Var2 = br1Var;
            }
        }
        while (G0() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            f61 f61Var = (f61) re.a.getObjectVolatile(this, Z);
            if (f61Var == null) {
                return;
            }
            synchronized (f61Var) {
                e61VarD = f61Var.b() > 0 ? f61Var.d(0) : null;
            }
            if (e61VarD == null) {
                return;
            } else {
                N0(jNanoTime, e61VarD);
            }
        }
    }
}
