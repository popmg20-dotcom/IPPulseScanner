package io.sentry.android.core;

import android.app.ApplicationExitInfo;
import android.content.Context;
import io.sentry.f5;
import io.sentry.p5;
import j$.time.Instant;
import j$.time.format.DateTimeFormatter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g2 implements n0 {
    public final SentryAndroidOptions a;
    public final d1 b;
    public final Context c;

    public g2(Context context, SentryAndroidOptions sentryAndroidOptions) {
        this.a = sentryAndroidOptions;
        this.b = new d1(sentryAndroidOptions);
        this.c = context;
    }

    @Override // io.sentry.android.core.n0
    public final int a() {
        return 5;
    }

    @Override // io.sentry.android.core.n0
    public final Long b() {
        return io.sentry.android.core.cache.c.h(this.a, "last_tombstone_report", "Tombstone");
    }

    @Override // io.sentry.android.core.n0
    public final String c() {
        return "Tombstone";
    }

    @Override // io.sentry.android.core.n0
    public final boolean d() {
        return this.a.isReportHistoricalTombstones();
    }

    @Override // io.sentry.android.core.n0
    public final io.sentry.m e(ApplicationExitInfo applicationExitInfo, boolean z) {
        SentryAndroidOptions sentryAndroidOptions = this.a;
        try {
            boolean zIsAttachRawTombstone = sentryAndroidOptions.isAttachRawTombstone();
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            try {
                if (traceInputStream == null) {
                    sentryAndroidOptions.getLogger().h(p5.WARNING, "No tombstone InputStream available for ApplicationExitInfo from %s", DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochMilli(applicationExitInfo.getTimestamp())));
                    if (traceInputStream == null) {
                        return null;
                    }
                    traceInputStream.close();
                    return null;
                }
                byte[] bArrO = zIsAttachRawTombstone ? io.sentry.config.a.o(traceInputStream) : null;
                io.sentry.android.core.internal.tombstone.c cVar = new io.sentry.android.core.internal.tombstone.c(zIsAttachRawTombstone ? new ByteArrayInputStream(bArrO) : traceInputStream, sentryAndroidOptions.getInAppIncludes(), sentryAndroidOptions.getInAppExcludes(), this.c.getApplicationInfo().nativeLibraryDir);
                try {
                    f5 f5VarS = cVar.s();
                    cVar.close();
                    traceInputStream.close();
                    long timestamp = applicationExitInfo.getTimestamp();
                    f5VarS.G0 = new Date(timestamp);
                    f2 f2Var = new f2(sentryAndroidOptions.getFlushTimeoutMillis(), sentryAndroidOptions.getLogger(), timestamp, z);
                    io.sentry.l0 l0VarF = io.sentry.util.b.f(f2Var);
                    if (bArrO != null) {
                        l0VarF.g = new io.sentry.a("tombstone.pb", "application/x-protobuf", bArrO);
                    }
                    try {
                        f5 f5VarF = f(timestamp, f5VarS, l0VarF);
                        if (f5VarF != null) {
                            f5VarS = f5VarF;
                        }
                    } catch (Throwable th) {
                        sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to merge native event with tombstone, continuing without merge: %s", th.getMessage());
                    }
                    return new io.sentry.m(2, f5VarS, l0VarF, f2Var);
                } finally {
                }
            } finally {
            }
        } catch (Throwable th2) {
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to parse tombstone from %s: %s", DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochMilli(applicationExitInfo.getTimestamp())), th2.getMessage());
            return null;
        }
        sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to parse tombstone from %s: %s", DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochMilli(applicationExitInfo.getTimestamp())), th2.getMessage());
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x012e, code lost:
    
        r13.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x01bd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.f5 f(long r23, io.sentry.f5 r25, io.sentry.l0 r26) {
        /*
            Method dump skipped, instruction units count: 990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.g2.f(long, io.sentry.f5, io.sentry.l0):io.sentry.f5");
    }
}
