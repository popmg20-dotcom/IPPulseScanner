package io.sentry.android.core;

import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ProfilingManager;
import android.os.ProfilingResult;
import defpackage.qd;
import io.sentry.ILogger;
import io.sentry.p5;
import java.io.File;
import java.util.concurrent.RejectedExecutionException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {
    public final ILogger a;
    public final io.sentry.j1 b;
    public final ProfilingManager c;
    public final CancellationSignal d;
    public final Object e;
    public volatile ProfilingResult f;
    public Consumer g;
    public volatile boolean h;

    public m1(Context context, ILogger iLogger, io.sentry.j1 j1Var) {
        ProfilingManager profilingManager = (ProfilingManager) context.getSystemService("profiling");
        this.d = new CancellationSignal();
        this.e = new Object();
        this.f = null;
        this.g = null;
        this.h = false;
        this.a = iLogger;
        this.b = j1Var;
        this.c = profilingManager;
    }

    public static String b(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 7 ? i != 8 ? "UNKNOWN_ERROR_CODE" : "ERROR_UNKNOWN" : "ERROR_FAILED_INVALID_REQUEST" : "ERROR_FAILED_POST_PROCESSING" : "ERROR_FAILED_PROFILING_IN_PROGRESS" : "ERROR_FAILED_RATE_LIMIT_PROCESS" : "ERROR_FAILED_RATE_LIMIT_SYSTEM";
    }

    public final void a(h1 h1Var) {
        if (!this.h) {
            this.a.h(p5.WARNING, "PerfettoProfiler was never started", new Object[0]);
            h1Var.n(null);
            return;
        }
        this.d.cancel();
        synchronized (this.e) {
            try {
                ProfilingResult profilingResult = this.f;
                if (profilingResult != null) {
                    h1Var.n(c(profilingResult));
                    return;
                }
                this.g = h1Var;
                try {
                    this.b.b(new g(5, this), 5000L);
                } catch (RejectedExecutionException e) {
                    this.a.d(p5.DEBUG, "Failed to schedule profiling result timeout.", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final File c(ProfilingResult profilingResult) {
        int errorCode = profilingResult.getErrorCode();
        ILogger iLogger = this.a;
        if (errorCode != 0) {
            if (errorCode == 1 || errorCode == 2) {
                iLogger.h(p5.INFO, "Perfetto profiling failed: %s. To disable during development run: adb shell device_config put profiling_testing rate_limiter.disabled true", b(errorCode));
            } else {
                iLogger.h(p5.WARNING, "Perfetto profiling failed with %s (error code %d): %s. See https://developer.android.com/reference/android/os/ProfilingResult", b(errorCode), Integer.valueOf(errorCode), profilingResult.getErrorMessage());
            }
            return null;
        }
        String resultFilePath = profilingResult.getResultFilePath();
        if (resultFilePath == null) {
            iLogger.h(p5.WARNING, "Perfetto profiling result file path is null.", new Object[0]);
            return null;
        }
        File file = new File(resultFilePath);
        if (file.exists() && file.length() != 0) {
            return file;
        }
        iLogger.h(p5.WARNING, "Perfetto trace file does not exist or is empty.", new Object[0]);
        return null;
    }

    public final boolean d() {
        if (this.h) {
            this.a.h(p5.WARNING, "PerfettoProfiler was already started.", new Object[0]);
            return false;
        }
        this.h = true;
        if (this.c == null) {
            this.a.h(p5.WARNING, "ProfilingManager is not available.", new Object[0]);
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_DURATION_MS", 60000);
        bundle.putInt("KEY_FREQUENCY_HZ", 101);
        try {
            this.c.requestProfiling(3, bundle, "sentry-profiling", this.d, new qd(1), new l1(this, 0));
            return true;
        } catch (Throwable th) {
            this.a.d(p5.ERROR, "Failed to request Profiling.", th);
            return false;
        }
    }
}
