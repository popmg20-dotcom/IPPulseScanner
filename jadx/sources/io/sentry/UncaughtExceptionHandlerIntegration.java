package io.sentry;

import io.sentry.android.core.SentryAndroidOptions;
import java.io.Closeable;
import java.lang.Thread;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class UncaughtExceptionHandlerIntegration implements v1, Thread.UncaughtExceptionHandler, Closeable {
    public static final io.sentry.util.a X = new io.sentry.util.a();
    public boolean A;
    public Thread.UncaughtExceptionHandler b;
    public f1 f;
    public SentryAndroidOptions z;

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        UncaughtExceptionHandlerIntegration uncaughtExceptionHandlerIntegration;
        f1 f1Var;
        if (this.A) {
            sentryAndroidOptions.getLogger().h(p5.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.A = true;
        this.f = l4.a;
        this.z = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.z.isEnableUncaughtExceptionHandler()));
        if (this.z.isEnableUncaughtExceptionHandler()) {
            io.sentry.util.a aVar = X;
            aVar.g();
            try {
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                if (defaultUncaughtExceptionHandler != null) {
                    this.z.getLogger().h(p5Var, "default UncaughtExceptionHandler class='" + defaultUncaughtExceptionHandler.getClass().getName() + "'", new Object[0]);
                    if ((defaultUncaughtExceptionHandler instanceof UncaughtExceptionHandlerIntegration) && (f1Var = (uncaughtExceptionHandlerIntegration = (UncaughtExceptionHandlerIntegration) defaultUncaughtExceptionHandler).f) != null && p4.c == f1Var.s()) {
                        this.b = uncaughtExceptionHandlerIntegration.b;
                    } else {
                        this.b = defaultUncaughtExceptionHandler;
                    }
                }
                Thread.setDefaultUncaughtExceptionHandler(this);
                aVar.close();
                this.z.getLogger().h(p5Var, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
                io.sentry.util.b.a("UncaughtExceptionHandler");
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.util.a aVar = X;
        aVar.g();
        try {
            if (this == Thread.getDefaultUncaughtExceptionHandler()) {
                Thread.setDefaultUncaughtExceptionHandler(this.b);
                SentryAndroidOptions sentryAndroidOptions = this.z;
                if (sentryAndroidOptions != null) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
                }
            } else {
                g(Thread.getDefaultUncaughtExceptionHandler(), new HashSet());
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

    public final void g(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, HashSet hashSet) {
        if (uncaughtExceptionHandler == null) {
            SentryAndroidOptions sentryAndroidOptions = this.z;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Found no UncaughtExceptionHandler to remove.", new Object[0]);
                return;
            }
            return;
        }
        if (!hashSet.add(uncaughtExceptionHandler)) {
            SentryAndroidOptions sentryAndroidOptions2 = this.z;
            if (sentryAndroidOptions2 != null) {
                sentryAndroidOptions2.getLogger().h(p5.WARNING, "Cycle detected in UncaughtExceptionHandler chain while removing handler.", new Object[0]);
                return;
            }
            return;
        }
        if (uncaughtExceptionHandler instanceof UncaughtExceptionHandlerIntegration) {
            UncaughtExceptionHandlerIntegration uncaughtExceptionHandlerIntegration = (UncaughtExceptionHandlerIntegration) uncaughtExceptionHandler;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = uncaughtExceptionHandlerIntegration.b;
            if (this != uncaughtExceptionHandler2) {
                g(uncaughtExceptionHandler2, hashSet);
                return;
            }
            uncaughtExceptionHandlerIntegration.b = this.b;
            SentryAndroidOptions sentryAndroidOptions3 = this.z;
            if (sentryAndroidOptions3 != null) {
                sentryAndroidOptions3.getLogger().h(p5.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        io.sentry.protocol.w wVar;
        SentryAndroidOptions sentryAndroidOptions = this.z;
        if (sentryAndroidOptions == null || this.f == null) {
            return;
        }
        sentryAndroidOptions.getLogger().h(p5.INFO, "Uncaught exception received.", new Object[0]);
        try {
            l7 l7Var = new l7(this.z.getFlushTimeoutMillis(), this.z.getLogger());
            io.sentry.protocol.o oVar = new io.sentry.protocol.o();
            oVar.A = Boolean.FALSE;
            oVar.b = "UncaughtExceptionHandler";
            f5 f5Var = new f5(new io.sentry.exception.a(oVar, th, thread, false));
            f5Var.L0 = p5.FATAL;
            if (this.f.i() == null && (wVar = f5Var.b) != null) {
                l7Var.g(wVar);
            }
            l0 l0VarF = io.sentry.util.b.f(l7Var);
            boolean zEquals = this.f.B(f5Var, l0VarF).equals(io.sentry.protocol.w.f);
            io.sentry.hints.e eVar = (io.sentry.hints.e) l0VarF.c(io.sentry.hints.e.class, "sentry:eventDropReason");
            if ((!zEquals || io.sentry.hints.e.MULTITHREADED_DEDUPLICATION.equals(eVar)) && !l7Var.d()) {
                this.z.getLogger().h(p5.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", f5Var.b);
            }
        } catch (Throwable th2) {
            this.z.getLogger().d(p5.ERROR, "Error sending uncaught exception to Sentry.", th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        SentryAndroidOptions sentryAndroidOptions2 = this.z;
        if (uncaughtExceptionHandler != null) {
            sentryAndroidOptions2.getLogger().h(p5.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
            this.b.uncaughtException(thread, th);
        } else if (sentryAndroidOptions2.isPrintUncaughtStackTrace()) {
            th.printStackTrace();
        }
    }
}
