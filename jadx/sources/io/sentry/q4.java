package io.sentry;

import io.sentry.android.core.SentryAndroidOptions;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q4 implements k2 {
    public Double A;
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public u3 D0;
    public ConcurrentHashMap E0;
    public String X;
    public boolean Y;
    public boolean Z;
    public boolean b;
    public Double f;
    public int y0;
    public boolean z;
    public boolean z0;

    public q4(SentryAndroidOptions sentryAndroidOptions, x3 x3Var) {
        this.z = ((Boolean) x3Var.a).booleanValue();
        this.A = (Double) x3Var.b;
        this.b = ((Boolean) x3Var.d).booleanValue();
        this.f = (Double) x3Var.e;
        this.z0 = sentryAndroidOptions.getInternalTracesSampler().b(io.sentry.util.n.a().c());
        this.X = sentryAndroidOptions.getProfilingTracesDirPath();
        this.Y = sentryAndroidOptions.isProfilingEnabled();
        this.Z = sentryAndroidOptions.isContinuousProfilingEnabled();
        this.D0 = sentryAndroidOptions.getProfileLifecycle();
        this.y0 = sentryAndroidOptions.getProfilingTracesHz();
        this.A0 = sentryAndroidOptions.isEnableAppStartProfiling();
        this.B0 = sentryAndroidOptions.isStartProfilerOnAppStart();
        this.C0 = sentryAndroidOptions.isEnableLegacyProfiling();
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("profile_sampled");
        cVar.v(iLogger, Boolean.valueOf(this.b));
        cVar.p("profile_sample_rate");
        cVar.v(iLogger, this.f);
        cVar.p("continuous_profile_sampled");
        cVar.v(iLogger, Boolean.valueOf(this.z0));
        cVar.p("trace_sampled");
        cVar.v(iLogger, Boolean.valueOf(this.z));
        cVar.p("trace_sample_rate");
        cVar.v(iLogger, this.A);
        cVar.p("profiling_traces_dir_path");
        cVar.v(iLogger, this.X);
        cVar.p("is_profiling_enabled");
        cVar.v(iLogger, Boolean.valueOf(this.Y));
        cVar.p("is_continuous_profiling_enabled");
        cVar.v(iLogger, Boolean.valueOf(this.Z));
        cVar.p("profile_lifecycle");
        cVar.v(iLogger, this.D0.name());
        cVar.p("profiling_traces_hz");
        cVar.v(iLogger, Integer.valueOf(this.y0));
        cVar.p("is_enable_app_start_profiling");
        cVar.v(iLogger, Boolean.valueOf(this.A0));
        cVar.p("is_start_profiler_on_app_start");
        cVar.v(iLogger, Boolean.valueOf(this.B0));
        cVar.p("enable_legacy_profiling");
        cVar.v(iLogger, Boolean.valueOf(this.C0));
        ConcurrentHashMap concurrentHashMap = this.E0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.E0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
