package defpackage;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class x1 implements nc2 {
    public static final boolean A = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger X = Logger.getLogger(x1.class.getName());
    public static final yr2 Y;
    public static final Object Z;
    public volatile Object b;
    public volatile s1 f;
    public volatile w1 z;

    static {
        yr2 v1Var;
        try {
            v1Var = new t1(AtomicReferenceFieldUpdater.newUpdater(w1.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(w1.class, w1.class, "b"), AtomicReferenceFieldUpdater.newUpdater(x1.class, w1.class, "z"), AtomicReferenceFieldUpdater.newUpdater(x1.class, s1.class, "f"), AtomicReferenceFieldUpdater.newUpdater(x1.class, Object.class, "b"));
            th = null;
        } catch (Throwable th) {
            th = th;
            v1Var = new v1();
        }
        Y = v1Var;
        if (th != null) {
            X.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        Z = new Object();
    }

    public static void d(x1 x1Var) {
        w1 w1Var;
        s1 s1Var;
        s1 s1Var2;
        s1 s1Var3;
        do {
            w1Var = x1Var.z;
        } while (!Y.f(x1Var, w1Var, w1.c));
        while (true) {
            s1Var = null;
            if (w1Var == null) {
                break;
            }
            Thread thread = w1Var.a;
            if (thread != null) {
                w1Var.a = null;
                LockSupport.unpark(thread);
            }
            w1Var = w1Var.b;
        }
        x1Var.c();
        do {
            s1Var2 = x1Var.f;
        } while (!Y.d(x1Var, s1Var2, s1.d));
        while (true) {
            s1Var3 = s1Var;
            s1Var = s1Var2;
            if (s1Var == null) {
                break;
            }
            s1Var2 = s1Var.c;
            s1Var.c = s1Var3;
        }
        while (s1Var3 != null) {
            s1 s1Var4 = s1Var3.c;
            Runnable runnable = s1Var3.a;
            if (runnable instanceof u1) {
                st4.n();
                return;
            } else {
                e(runnable, s1Var3.b);
                s1Var3 = s1Var4;
            }
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            X.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static Object f(Object obj) throws ExecutionException {
        if (obj instanceof p1) {
            Throwable th = ((p1) obj).b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof r1) {
            throw new ExecutionException(((r1) obj).a);
        }
        if (obj == Z) {
            return null;
        }
        return obj;
    }

    public static Object g(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // defpackage.nc2
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        s1 s1Var = this.f;
        s1 s1Var2 = s1.d;
        if (s1Var != s1Var2) {
            s1 s1Var3 = new s1(runnable, executor);
            do {
                s1Var3.c = s1Var;
                if (Y.d(this, s1Var, s1Var3)) {
                    return;
                } else {
                    s1Var = this.f;
                }
            } while (s1Var != s1Var2);
        }
        e(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        try {
            Object objG = g(this);
            sb.append("SUCCESS, result=[");
            sb.append(objG == this ? "this future" : String.valueOf(objG));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.b;
        if (obj == null) {
            if (Y.e(this, obj, A ? new p1(new CancellationException("Future.cancel() was called."), z) : z ? p1.c : p1.d)) {
                d(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        w1 w1Var = w1.c;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.b;
        if (obj != null) {
            return f(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            w1 w1Var2 = this.z;
            if (w1Var2 != w1Var) {
                w1 w1Var3 = new w1();
                do {
                    yr2 yr2Var = Y;
                    yr2Var.d0(w1Var3, w1Var2);
                    if (yr2Var.f(this, w1Var2, w1Var3)) {
                        while (true) {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                i(w1Var3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.b;
                            if (obj2 != null) {
                                return f(obj2);
                            }
                            long jNanoTime2 = jNanoTime - System.nanoTime();
                            if (jNanoTime2 < 1000) {
                                i(w1Var3);
                                nanos = jNanoTime2;
                                break;
                            }
                            nanos = jNanoTime2;
                        }
                    } else {
                        w1Var2 = this.z;
                    }
                } while (w1Var2 != w1Var);
            }
            return f(this.b);
        }
        while (nanos > 0) {
            Object obj3 = this.b;
            if (obj3 != null) {
                return f(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        StringBuilder sbC = fw.C("Waited ", " ", j);
        sbC.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sbC.toString();
        if (nanos + 1000 < 0) {
            String strConcat = string3.concat(" (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strConcat2 = strConcat + jConvert + " " + lowerCase;
                if (z) {
                    strConcat2 = strConcat2.concat(",");
                }
                strConcat = strConcat2.concat(" ");
            }
            if (z) {
                strConcat = strConcat + nanos2 + " nanoseconds ";
            }
            string3 = strConcat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(string3.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(ha0.o(string3, " for ", string));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String h() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(w1 w1Var) {
        w1Var.a = null;
        while (true) {
            w1 w1Var2 = this.z;
            if (w1Var2 == w1.c) {
                return;
            }
            w1 w1Var3 = null;
            while (w1Var2 != null) {
                w1 w1Var4 = w1Var2.b;
                if (w1Var2.a != null) {
                    w1Var3 = w1Var2;
                } else if (w1Var3 != null) {
                    w1Var3.b = w1Var4;
                    if (w1Var3.a == null) {
                        break;
                    }
                } else if (!Y.f(this, w1Var2, w1Var4)) {
                    break;
                }
                w1Var2 = w1Var4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.b instanceof p1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b != null;
    }

    public boolean j(Object obj) {
        if (obj == null) {
            obj = Z;
        }
        if (!Y.e(this, null, obj)) {
            return false;
        }
        d(this);
        return true;
    }

    public boolean k(Throwable th) {
        th.getClass();
        if (!Y.e(this, null, new r1(th))) {
            return false;
        }
        d(this);
        return true;
    }

    public final String toString() {
        String strH;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.b instanceof p1) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strH = h();
            } catch (RuntimeException e) {
                strH = "Exception thrown from implementation: " + e.getClass();
            }
            if (strH != null && !strH.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strH);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        w1 w1Var = w1.c;
        if (!Thread.interrupted()) {
            Object obj2 = this.b;
            if (obj2 != null) {
                return f(obj2);
            }
            w1 w1Var2 = this.z;
            if (w1Var2 != w1Var) {
                w1 w1Var3 = new w1();
                do {
                    yr2 yr2Var = Y;
                    yr2Var.d0(w1Var3, w1Var2);
                    if (yr2Var.f(this, w1Var2, w1Var3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.b;
                            } else {
                                i(w1Var3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return f(obj);
                    }
                    w1Var2 = this.z;
                } while (w1Var2 != w1Var);
            }
            return f(this.b);
        }
        throw new InterruptedException();
    }
}
