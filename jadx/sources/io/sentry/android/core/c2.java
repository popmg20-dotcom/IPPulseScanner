package io.sentry.android.core;

import defpackage.i60;
import io.sentry.h3;
import io.sentry.j3;
import io.sentry.w4;
import io.sentry.x5;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c2 implements io.sentry.android.core.internal.util.p, io.sentry.a1 {
    public static final x5 h = new x5(0, 0);
    public final boolean a;
    public final io.sentry.android.core.internal.util.r c;
    public volatile String d;
    public final io.sentry.util.a b = new io.sentry.util.a();
    public final TreeSet e = new TreeSet(new i60(14));
    public final ConcurrentSkipListSet f = new ConcurrentSkipListSet();
    public long g = 16666666;

    public c2(SentryAndroidOptions sentryAndroidOptions, io.sentry.android.core.internal.util.r rVar) {
        this.c = rVar;
        this.a = sentryAndroidOptions.isEnablePerformanceV2() && sentryAndroidOptions.isEnableFramesTracking();
    }

    public static long g(w4 w4Var) {
        if (w4Var instanceof x5) {
            return w4Var.b(h);
        }
        return System.nanoTime() - ((System.currentTimeMillis() * 1000000) - w4Var.d());
    }

    @Override // io.sentry.android.core.internal.util.p
    public final void b(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
        ConcurrentSkipListSet concurrentSkipListSet = this.f;
        if (concurrentSkipListSet.size() > 3600) {
            return;
        }
        long j5 = (long) (1.0E9d / ((double) f));
        this.g = j5;
        if (z || z2) {
            concurrentSkipListSet.add(new b2(j, j2, j3, j4, z, z2, j5));
        }
    }

    public final void d() {
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            if (this.d != null) {
                this.c.c(this.d);
                this.d = null;
            }
            this.f.clear();
            this.e.clear();
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

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01de A[Catch: all -> 0x00c7, TRY_LEAVE, TryCatch #3 {all -> 0x00c7, blocks: (B:34:0x008f, B:76:0x0144, B:78:0x014e, B:80:0x0152, B:82:0x015a, B:88:0x0167, B:97:0x017f, B:99:0x018b, B:102:0x0197, B:104:0x01a1, B:105:0x01ab, B:100:0x0190, B:106:0x01ad, B:108:0x01de, B:42:0x00ad, B:44:0x00b7, B:46:0x00be, B:58:0x00db, B:66:0x0110, B:68:0x0114, B:70:0x011b), top: B:142:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(io.sentry.n1 r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.c2.e(io.sentry.n1):void");
    }

    public final void f(io.sentry.n1 n1Var) {
        if (!this.a || (n1Var instanceof h3) || (n1Var instanceof j3)) {
            return;
        }
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            this.e.add(n1Var);
            if (this.d == null) {
                this.d = this.c.b(this);
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
