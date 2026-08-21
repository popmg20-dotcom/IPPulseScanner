package defpackage;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class il0 extends g61 implements Runnable {
    public static final il0 B0;
    public static final long C0;
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l;
        il0 il0Var = new il0();
        B0 = il0Var;
        il0Var.F0(false);
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        C0 = TimeUnit.MILLISECONDS.toNanos(l.longValue());
    }

    @Override // defpackage.g61, defpackage.on0
    public final zv0 I(long j, Runnable runnable, cf0 cf0Var) {
        long j2 = j > 0 ? j >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j : 0L;
        if (j2 >= 4611686018427387903L) {
            return js2.b;
        }
        long jNanoTime = System.nanoTime();
        d61 d61Var = new d61(runnable, j2 + jNanoTime);
        O0(jNanoTime, d61Var);
        return d61Var;
    }

    @Override // defpackage.g61
    public final void I0(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.I0(runnable);
    }

    @Override // defpackage.g61
    public final Thread L0() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setContextClassLoader(B0.getClass().getClassLoader());
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // defpackage.g61
    public final void N0(long j, e61 e61Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void P0() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            Unsafe unsafe = re.a;
            unsafe.putObjectVolatile(this, g61.z0, (Object) null);
            unsafe.putObjectVolatile(this, g61.Z, (Object) null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zM0;
        qd4.a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    if (zM0) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jG0 = G0();
                    if (jG0 == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j == Long.MAX_VALUE) {
                            j = C0 + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            P0();
                            if (M0()) {
                                return;
                            }
                            L0();
                            return;
                        }
                        if (jG0 > j2) {
                            jG0 = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jG0 > 0) {
                        int i2 = debugStatus;
                        if (i2 == 2 || i2 == 3) {
                            _thread = null;
                            P0();
                            if (M0()) {
                                return;
                            }
                            L0();
                            return;
                        }
                        LockSupport.parkNanos(this, jG0);
                    }
                }
            }
        } finally {
            _thread = null;
            P0();
            if (!M0()) {
                L0();
            }
        }
    }

    @Override // defpackage.g61, defpackage.b61
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // defpackage.ef0
    public final String toString() {
        return "DefaultExecutor";
    }
}
