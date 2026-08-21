package io.sentry.android.core;

import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import io.sentry.ILogger;
import io.sentry.p3;
import io.sentry.p5;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j implements io.sentry.b1 {
    public final ILogger g;
    public long a = 0;
    public long b = 0;
    public long c = 1;
    public long d = 1;
    public double e = 1.0E9d;
    public final File f = new File("/proc/self/stat");
    public boolean h = false;
    public final Pattern i = Pattern.compile("[\n\t\r ]");

    public j(ILogger iLogger) {
        io.sentry.util.b.r(iLogger, "Logger is required.");
        this.g = iLogger;
    }

    @Override // io.sentry.b1
    public final void a(p3 p3Var) {
        if (this.h) {
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j = jElapsedRealtimeNanos - this.a;
            this.a = jElapsedRealtimeNanos;
            long jB = b();
            long j2 = jB - this.b;
            this.b = jB;
            p3Var.a = Double.valueOf(((j2 / j) / this.d) * 100.0d);
        }
    }

    public final long b() {
        String strQ;
        ILogger iLogger = this.g;
        try {
            strQ = io.sentry.util.b.q(this.f);
        } catch (IOException e) {
            this.h = false;
            iLogger.d(p5.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", e);
            strQ = null;
        }
        if (strQ != null) {
            String[] strArrSplit = this.i.split(strQ.trim());
            try {
                long j = Long.parseLong(strArrSplit[13]);
                long j2 = Long.parseLong(strArrSplit[14]);
                return (long) ((j + j2 + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16])) * this.e);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e2) {
                iLogger.d(p5.ERROR, "Error parsing /proc/self/stat file.", e2);
            }
        }
        return 0L;
    }

    @Override // io.sentry.b1
    public final void c() {
        this.h = true;
        this.c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        this.e = 1.0E9d / this.c;
        this.b = b();
    }
}
