package io.sentry.android.core.anr;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.g;
import io.sentry.android.core.g0;
import io.sentry.android.core.j0;
import io.sentry.android.core.z;
import io.sentry.p5;
import io.sentry.util.n;
import io.sentry.v1;
import io.sentry.w2;
import java.io.Closeable;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class AnrProfilingIntegration implements v1, Closeable, g0, Runnable {
    public volatile SentryAndroidOptions A0;
    public volatile Handler E0;
    public volatile Thread F0;
    public volatile d y0;
    public final AtomicBoolean b = new AtomicBoolean(true);
    public final g f = new g(8, this);
    public final io.sentry.util.a z = new io.sentry.util.a();
    public final io.sentry.util.a A = new io.sentry.util.a();
    public volatile long X = SystemClock.uptimeMillis();
    public final AtomicInteger Y = new AtomicInteger();
    public volatile a Z = a.IDLE;
    public volatile ILogger z0 = w2.b;
    public volatile Thread B0 = null;
    public volatile boolean C0 = false;
    public volatile boolean D0 = false;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum a {
        IDLE,
        SUSPICIOUS,
        ANR_DETECTED
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.A0 = sentryAndroidOptions;
        this.z0 = sentryAndroidOptions.getLogger();
        if (this.A0.isAnrProfilingEnabled()) {
            if (this.A0.getCacheDirPath() == null) {
                this.z0.h(p5.WARNING, "ANR Profiling is enabled but cacheDirPath is not set", new Object[0]);
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            this.F0 = mainLooper.getThread();
            this.E0 = new Handler(mainLooper);
            io.sentry.util.b.a("AnrProfiling");
            j0.X.g(this);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.set(false);
        j0.X.x(this);
        Handler handler = this.E0;
        if (handler != null) {
            handler.removeCallbacks(this.f);
        }
        Thread thread = this.B0;
        if (thread != null) {
            synchronized (this) {
                notifyAll();
            }
            thread.interrupt();
        }
        SentryAndroidOptions sentryAndroidOptions = this.A0;
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            d dVar = this.y0;
            this.y0 = null;
            aVar.close();
            if (sentryAndroidOptions != null) {
                try {
                    sentryAndroidOptions.getExecutorService().submit(new z(6, this, dVar));
                } catch (Throwable unused) {
                    this.z0.h(p5.WARNING, "Failed to submit AnrProfileManager close", new Object[0]);
                }
            }
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.android.core.g0
    public final void g() {
        if (this.b.get()) {
            io.sentry.util.a aVar = this.z;
            aVar.g();
            try {
                if (this.D0) {
                    aVar.close();
                    return;
                }
                this.D0 = true;
                this.f.run();
                Thread thread = this.B0;
                if (thread != null && thread.isAlive()) {
                    synchronized (this) {
                        notifyAll();
                    }
                }
                if (thread == null || !thread.isAlive()) {
                    Thread thread2 = new Thread(this, "AnrProfilingIntegration");
                    thread2.setDaemon(true);
                    thread2.start();
                    this.B0 = thread2;
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // io.sentry.android.core.g0
    public final void n() {
        if (this.b.get()) {
            io.sentry.util.a aVar = this.z;
            aVar.g();
            try {
                this.D0 = false;
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler = this.E0;
        Thread thread = this.F0;
        if (handler == null || thread == null) {
            return;
        }
        while (this.b.get() && !Thread.currentThread().isInterrupted()) {
            try {
                try {
                    if (this.D0) {
                        s(thread);
                        handler.removeCallbacks(this.f);
                        handler.post(this.f);
                        Thread.sleep(66L);
                    } else {
                        synchronized (this) {
                            while (!this.D0 && this.b.get()) {
                                try {
                                    wait();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        this.f.run();
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            } catch (Throwable th2) {
                this.z0.d(p5.WARNING, "Failed to execute AnrStacktraceIntegration", th2);
                return;
            }
        }
    }

    public final void s(Thread thread) {
        long jUptimeMillis = SystemClock.uptimeMillis() - this.X;
        if (jUptimeMillis < 1000) {
            this.Z = a.IDLE;
            this.C0 = false;
        }
        if (this.Z == a.IDLE && jUptimeMillis > 1000) {
            ILogger iLogger = this.z0;
            p5 p5Var = p5.DEBUG;
            if (iLogger.i(p5Var)) {
                this.z0.h(p5Var, "ANR: main thread is suspicious", new Object[0]);
            }
            this.Z = a.SUSPICIOUS;
            SentryAndroidOptions sentryAndroidOptions = this.A0;
            Double anrProfilingSampleRate = sentryAndroidOptions != null ? sentryAndroidOptions.getAnrProfilingSampleRate() : null;
            if (anrProfilingSampleRate != null && n.a().c() < anrProfilingSampleRate.doubleValue()) {
                this.C0 = true;
            }
            if (this.C0) {
                this.Y.set(0);
                x().b.clear();
            }
        }
        if (this.C0 && (this.Z == a.SUSPICIOUS || this.Z == a.ANR_DETECTED)) {
            if (this.Y.get() < 151) {
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                f fVar = new f(System.currentTimeMillis(), thread.getStackTrace());
                long jUptimeMillis3 = SystemClock.uptimeMillis() - jUptimeMillis2;
                ILogger iLogger2 = this.z0;
                p5 p5Var2 = p5.DEBUG;
                if (iLogger2.i(p5Var2)) {
                    this.z0.h(p5Var2, "AnrWatchdog: capturing main thread stacktrace took " + jUptimeMillis3 + "ms", new Object[0]);
                }
                if (this.b.get()) {
                    this.Y.incrementAndGet();
                    x().b.g(fVar);
                }
            } else {
                ILogger iLogger3 = this.z0;
                p5 p5Var3 = p5.DEBUG;
                if (iLogger3.i(p5Var3)) {
                    this.z0.h(p5Var3, "ANR: reached maximum number of collected stack traces, skipping further collection", new Object[0]);
                }
            }
        }
        if (this.Z != a.SUSPICIOUS || jUptimeMillis <= 4000) {
            return;
        }
        ILogger iLogger4 = this.z0;
        p5 p5Var4 = p5.DEBUG;
        if (iLogger4.i(p5Var4)) {
            this.z0.h(p5Var4, "ANR: main thread ANR threshold reached", new Object[0]);
        }
        this.Z = a.ANR_DETECTED;
    }

    public final d x() {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            if (this.y0 == null) {
                SentryAndroidOptions sentryAndroidOptions = this.A0;
                io.sentry.util.b.r(sentryAndroidOptions, "Options can't be null");
                String cacheDirPath = sentryAndroidOptions.getCacheDirPath();
                if (cacheDirPath == null) {
                    throw new IllegalStateException("cacheDirPath is required for ANR profiling");
                }
                File file = new File(cacheDirPath);
                e.b(file);
                this.y0 = new d(sentryAndroidOptions, new File(file, "anr_profile"));
            }
            d dVar = this.y0;
            aVar.close();
            return dVar;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
