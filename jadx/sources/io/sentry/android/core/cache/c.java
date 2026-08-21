package io.sentry.android.core.cache;

import android.os.SystemClock;
import defpackage.ha0;
import defpackage.m10;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.b0;
import io.sentry.android.core.f2;
import io.sentry.android.core.performance.g;
import io.sentry.android.core.performance.h;
import io.sentry.l0;
import io.sentry.l7;
import io.sentry.p5;
import io.sentry.p6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c extends io.sentry.cache.b {
    public static final List B0 = Arrays.asList(new b(b0.class, "ANR", "last_anr_report", new a(0)), new b(f2.class, "Tombstone", "last_tombstone_report", new a(1)));
    public final io.sentry.android.core.internal.util.c A0;

    /* JADX WARN: Illegal instructions before constructor call */
    public c(SentryAndroidOptions sentryAndroidOptions) {
        String cacheDirPath = sentryAndroidOptions.getCacheDirPath();
        io.sentry.util.b.r(cacheDirPath, "cacheDirPath must not be null");
        super(sentryAndroidOptions, cacheDirPath, sentryAndroidOptions.getMaxCacheItems());
        this.A0 = io.sentry.android.core.internal.util.c.b;
    }

    public static Long h(p6 p6Var, String str, String str2) {
        String cacheDirPath = p6Var.getCacheDirPath();
        io.sentry.util.b.r(cacheDirPath, "Cache dir path should be set for getting " + str2 + "s reported");
        File file = new File(cacheDirPath, str);
        try {
            String strQ = io.sentry.util.b.q(file);
            if (strQ != null && !strQ.equals("null")) {
                return Long.valueOf(Long.parseLong(strQ.trim()));
            }
            return null;
        } catch (Throwable th) {
            if (th instanceof FileNotFoundException) {
                p6Var.getLogger().h(p5.DEBUG, ha0.o("Last ", str2, " marker does not exist. %s."), file.getAbsolutePath());
                return null;
            }
            p6Var.getLogger().d(p5.ERROR, ha0.o("Error reading last ", str2, " marker"), th);
            return null;
        }
    }

    @Override // io.sentry.cache.b, io.sentry.cache.c
    public final boolean n(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        Long lValueOf;
        boolean zN = super.n(cVar, l0Var);
        p6 p6Var = this.b;
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) p6Var;
        h hVar = g.c().X;
        if (l7.class.isInstance(l0Var.b("sentry:typeCheckHint")) && hVar.d()) {
            this.A0.getClass();
            long jUptimeMillis = SystemClock.uptimeMillis() - hVar.z;
            if (jUptimeMillis <= sentryAndroidOptions.getStartupCrashDurationThresholdMillis()) {
                ILogger logger = sentryAndroidOptions.getLogger();
                p5 p5Var = p5.DEBUG;
                logger.h(p5Var, "Startup Crash detected %d milliseconds after SDK init. Writing a startup crash marker file to disk.", Long.valueOf(jUptimeMillis));
                String outboxPath = p6Var.getOutboxPath();
                if (outboxPath == null) {
                    p6Var.getLogger().h(p5Var, "Outbox path is null, the startup crash marker file will not be written", new Object[0]);
                } else {
                    File file = new File(outboxPath);
                    if (io.sentry.util.b.e(file)) {
                        try {
                            new File(file, "startup_crash").createNewFile();
                        } catch (Throwable th) {
                            p6Var.getLogger().d(p5.ERROR, "Error writing the startup crash marker file to the disk", th);
                        }
                    } else {
                        p6Var.getLogger().h(p5.ERROR, "Failed to create outbox dir %s", outboxPath);
                    }
                }
            }
        }
        for (b bVar : B0) {
            Class cls = bVar.a;
            m10 m10Var = new m10(11, bVar, sentryAndroidOptions, this);
            Object objB = l0Var.b("sentry:typeCheckHint");
            if (cls.isInstance(l0Var.b("sentry:typeCheckHint")) && objB != null) {
                b bVar2 = (b) m10Var.f;
                SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) m10Var.z;
                c cVar2 = (c) m10Var.A;
                switch (bVar2.d.b) {
                    case 0:
                        lValueOf = Long.valueOf(((b0) objB).A);
                        break;
                    default:
                        lValueOf = Long.valueOf(((f2) objB).A);
                        break;
                }
                ILogger logger2 = sentryAndroidOptions2.getLogger();
                p5 p5Var2 = p5.DEBUG;
                String str = bVar2.b;
                logger2.h(p5Var2, "Writing last reported %s marker with timestamp %d", str, lValueOf);
                String str2 = bVar2.c;
                p6 p6Var2 = cVar2.b;
                String cacheDirPath = p6Var2.getCacheDirPath();
                if (cacheDirPath == null) {
                    p6Var2.getLogger().h(p5Var2, ha0.o("Cache dir path is null, the ", str, " marker will not be written"), new Object[0]);
                } else {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(cacheDirPath, str2));
                        try {
                            fileOutputStream.write(String.valueOf(lValueOf).getBytes(io.sentry.cache.b.z0));
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        p6Var2.getLogger().d(p5.ERROR, ha0.o("Error writing the ", str, " marker to the disk"), th4);
                    }
                }
            }
        }
        return zN;
    }
}
