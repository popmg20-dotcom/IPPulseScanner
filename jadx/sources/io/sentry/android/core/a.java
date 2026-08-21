package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.SystemClock;
import defpackage.dw2;
import defpackage.ed;
import defpackage.ga1;
import defpackage.st4;
import defpackage.zo2;
import io.sentry.ILogger;
import io.sentry.f5;
import io.sentry.p4;
import io.sentry.p5;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Thread {
    public final st4 A;
    public final Context A0;
    public final ga1 B0;
    public final long X;
    public final long Y;
    public final ILogger Z;
    public final boolean b;
    public final ed f;
    public volatile long y0;
    public final q0 z;
    public final AtomicBoolean z0;

    public a(long j, boolean z, ed edVar, ILogger iLogger, Context context) {
        st4 st4Var = new st4(19);
        q0 q0Var = new q0(4);
        super("|ANR-WatchDog|");
        this.y0 = 0L;
        this.z0 = new AtomicBoolean(false);
        this.A = st4Var;
        this.Y = j;
        this.X = 500L;
        this.b = z;
        this.f = edVar;
        this.Z = iLogger;
        this.z = q0Var;
        this.A0 = context;
        this.B0 = new ga1(this, st4Var);
        if (j >= 1000) {
            return;
        }
        zo2.p("ANRWatchDog: timeoutIntervalMillis has to be at least %d ms", new Object[]{1000L});
        throw null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        this.B0.run();
        while (!isInterrupted()) {
            ((Handler) this.z.b).post(this.B0);
            try {
                Thread.sleep(this.X);
                this.A.getClass();
                if (SystemClock.uptimeMillis() - this.y0 > this.Y) {
                    if (this.b || !(Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        ActivityManager activityManager = (ActivityManager) this.A0.getSystemService("activity");
                        if (activityManager != null) {
                            try {
                                processesInErrorState = activityManager.getProcessesInErrorState();
                            } catch (Throwable th) {
                                this.Z.d(p5.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", th);
                                processesInErrorState = null;
                            }
                            if (processesInErrorState != null) {
                                Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                                while (it.hasNext()) {
                                    if (it.next().condition == 2) {
                                    }
                                }
                            }
                        }
                        if (this.z0.compareAndSet(false, true)) {
                            ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(dw2.C(new StringBuilder("Application Not Responding for at least "), " ms.", this.Y), ((Handler) this.z.b).getLooper().getThread());
                            ed edVar = this.f;
                            Object obj = edVar.f;
                            SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) edVar.z;
                            a aVar = AnrIntegration.X;
                            sentryAndroidOptions.getLogger().h(p5.INFO, "ANR triggered with message: %s", applicationNotResponding.getMessage());
                            boolean zEquals = Boolean.TRUE.equals(j0.X.A);
                            String strConcat = "ANR for at least " + sentryAndroidOptions.getAnrTimeoutIntervalMillis() + " ms.";
                            if (zEquals) {
                                strConcat = "Background ".concat(strConcat);
                            }
                            Thread thread = applicationNotResponding.b;
                            ApplicationNotResponding applicationNotResponding2 = thread == null ? new ApplicationNotResponding(strConcat) : new ApplicationNotResponding(strConcat, thread);
                            io.sentry.protocol.o oVar = new io.sentry.protocol.o();
                            oVar.b = "ANR";
                            f5 f5Var = new f5(new io.sentry.exception.a(oVar, applicationNotResponding2, thread, true));
                            f5Var.L0 = p5.ERROR;
                            p4.c().B(f5Var, io.sentry.util.b.f(new a0(zEquals)));
                        }
                    } else {
                        this.Z.h(p5.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.z0.set(true);
                    }
                }
            } catch (InterruptedException e) {
                try {
                    Thread.currentThread().interrupt();
                    this.Z.h(p5.WARNING, "Interrupted: %s", e.getMessage());
                    return;
                } catch (SecurityException unused) {
                    this.Z.h(p5.WARNING, "Failed to interrupt due to SecurityException: %s", e.getMessage());
                    return;
                }
            }
        }
    }
}
