package io.sentry.android.core;

import android.content.Context;
import android.os.Build;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.bx;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.sentry.ILogger;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.v3;
import io.sentry.w3;
import io.sentry.x6;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x implements io.sentry.q1 {
    public final boolean A;
    public final io.sentry.android.core.internal.util.r A0;
    public volatile w3 B0;
    public volatile v C0;
    public long D0;
    public long E0;
    public Date F0;
    public final io.sentry.util.a G0;
    public final int X;
    public final q Y;
    public final q0 Z;
    public final Context b;
    public final ILogger f;
    public boolean y0;
    public final String z;
    public final AtomicBoolean z0;

    public x(SurfboardApp surfboardApp, SentryAndroidOptions sentryAndroidOptions, q0 q0Var, io.sentry.android.core.internal.util.r rVar) {
        ILogger logger = sentryAndroidOptions.getLogger();
        String profilingTracesDirPath = sentryAndroidOptions.getProfilingTracesDirPath();
        boolean zIsProfilingEnabled = sentryAndroidOptions.isProfilingEnabled();
        int profilingTracesHz = sentryAndroidOptions.getProfilingTracesHz();
        q qVar = new q(sentryAndroidOptions, 4);
        this.y0 = false;
        this.z0 = new AtomicBoolean(false);
        this.C0 = null;
        this.G0 = new io.sentry.util.a();
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
        io.sentry.util.b.r(logger, "ILogger is required");
        this.f = logger;
        this.A0 = rVar;
        this.Z = q0Var;
        this.z = profilingTracesDirPath;
        this.A = zIsProfilingEnabled;
        this.X = profilingTracesHz;
        this.Y = qVar;
        this.F0 = new Date();
    }

    public final v3 a(String str, String str2, String str3, boolean z, List list, p6 p6Var) {
        int i = Build.VERSION.SDK_INT;
        if (this.C0 != null) {
            io.sentry.util.a aVar = this.G0;
            aVar.g();
            try {
                w3 w3Var = this.B0;
                if (w3Var == null || !w3Var.b.equals(str2)) {
                    this.f.h(p5.INFO, "Transaction %s (%s) finished, but was not currently being profiled. Skipping", str, str3);
                    aVar.close();
                    return null;
                }
                this.B0 = null;
                aVar.close();
                this.f.h(p5.DEBUG, "Transaction %s (%s) finished.", str, str3);
                u uVarA = this.C0.a(list, false);
                this.z0.set(false);
                if (uVarA != null) {
                    long j = uVarA.a - this.D0;
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(w3Var);
                    long j2 = uVarA.a;
                    long j3 = this.D0;
                    long j4 = uVarA.c;
                    long j5 = this.E0;
                    if (w3Var.X == null) {
                        w3Var.X = Long.valueOf(j2 - j3);
                        w3Var.A = Long.valueOf(w3Var.A.longValue() - j3);
                        w3Var.Z = Long.valueOf(j4 - j5);
                        w3Var.Y = Long.valueOf(w3Var.Y.longValue() - j5);
                    }
                    Long l = p6Var instanceof SentryAndroidOptions ? u0.c(this.b, (SentryAndroidOptions) p6Var).h : null;
                    String string = l != null ? Long.toString(l.longValue()) : "0";
                    String[] strArr = Build.SUPPORTED_ABIS;
                    return new v3((File) uVarA.d, this.F0, arrayList, str, str2, str3, Long.toString(j), i, (strArr == null || strArr.length <= 0) ? "" : strArr[0], new io.sentry.m0(4), Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, this.Z.a(), string, p6Var.getProguardUuid(), p6Var.getRelease(), p6Var.getEnvironment(), (uVarA.b || z) ? RtspHeaders.Values.TIMEOUT : "normal", (HashMap) uVarA.e);
                }
            } finally {
            }
        }
        return null;
    }

    @Override // io.sentry.q1
    public final void c(io.sentry.p1 p1Var) {
        if (this.z0.get() && this.B0 == null) {
            io.sentry.util.a aVar = this.G0;
            aVar.g();
            try {
                if (this.z0.get() && this.B0 == null) {
                    this.B0 = new w3(p1Var, Long.valueOf(this.D0), Long.valueOf(this.E0));
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

    @Override // io.sentry.q1
    public final void close() {
        x xVar;
        w3 w3Var = this.B0;
        if (w3Var != null) {
            xVar = this;
            xVar.a(w3Var.z, w3Var.b, w3Var.f, true, null, p4.c().getOptions());
        } else {
            xVar = this;
        }
        xVar.z0.set(false);
        if (xVar.C0 == null) {
            return;
        }
        v vVar = xVar.C0;
        io.sentry.util.a aVar = vVar.o;
        aVar.g();
        try {
            Future future = vVar.d;
            if (future != null) {
                future.cancel(true);
                vVar.d = null;
            }
            if (vVar.n) {
                vVar.a(null, true);
            }
            aVar.close();
        } finally {
        }
    }

    @Override // io.sentry.q1
    public final v3 e(x6 x6Var, List list, p6 p6Var) {
        return a(x6Var.e, x6Var.a.a(), x6Var.b.c.b.a(), false, list, p6Var);
    }

    @Override // io.sentry.q1
    public final boolean isRunning() {
        return this.z0.get();
    }

    @Override // io.sentry.q1
    public final void start() {
        bx bxVarC;
        if (this.z0.getAndSet(true)) {
            return;
        }
        if (!this.y0) {
            this.y0 = true;
            if (this.A) {
                String str = this.z;
                if (str == null) {
                    this.f.h(p5.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
                } else {
                    int i = this.X;
                    if (i <= 0) {
                        this.f.h(p5.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(i));
                    } else {
                        this.C0 = new v(str, 1000000 / i, this.A0, this.Y, this.f);
                    }
                }
            } else {
                this.f.h(p5.INFO, "Profiling is disabled in options.", new Object[0]);
            }
        }
        if (this.C0 != null && (bxVarC = this.C0.c()) != null) {
            this.D0 = bxVarC.a;
            this.E0 = bxVarC.b;
            this.F0 = (Date) bxVarC.c;
            this.f.h(p5.DEBUG, "Profiler started.", new Object[0]);
            return;
        }
        if (this.C0 != null && this.C0.n) {
            this.f.h(p5.WARNING, "A profile is already running. This profile will be ignored.", new Object[0]);
            return;
        }
        io.sentry.util.a aVar = this.G0;
        aVar.g();
        try {
            this.B0 = null;
            aVar.close();
            this.z0.set(false);
        } finally {
        }
    }
}
