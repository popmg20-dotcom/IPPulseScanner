package io.sentry.android.core;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import defpackage.a71;
import io.sentry.f5;
import io.sentry.p4;
import io.sentry.p5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements Runnable {
    public final long A;
    public final Context b;
    public final SentryAndroidOptions f;
    public final n0 z;

    public o0(Context context, SentryAndroidOptions sentryAndroidOptions, n0 n0Var) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : context;
        this.f = sentryAndroidOptions;
        this.z = n0Var;
        this.A = System.currentTimeMillis() - 7862400000L;
    }

    public final void a(ApplicationExitInfo applicationExitInfo, boolean z) {
        n0 n0Var = this.z;
        io.sentry.m mVarE = n0Var.e(applicationExitInfo, z);
        if (mVarE == null) {
            return;
        }
        f5 f5Var = (f5) mVarE.b;
        if (p4.c().B(f5Var, (io.sentry.l0) mVarE.c).equals(io.sentry.protocol.w.f) || ((io.sentry.hints.c) mVarE.d).d()) {
            return;
        }
        this.f.getLogger().h(p5.WARNING, "Timed out waiting to flush %s event to disk. Event: %s", n0Var.c(), f5Var.b);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
        SentryAndroidOptions sentryAndroidOptions = this.f;
        if (activityManager == null) {
            sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to retrieve ActivityManager.", new Object[0]);
            return;
        }
        ApplicationExitInfo applicationExitInfo = null;
        List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 0);
        if (historicalProcessExitReasons.isEmpty()) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "No records in historical exit reasons.", new Object[0]);
            return;
        }
        io.sentry.cache.c envelopeDiskCache = sentryAndroidOptions.getEnvelopeDiskCache();
        if ((envelopeDiskCache instanceof io.sentry.cache.b) && sentryAndroidOptions.isEnableAutoSessionTracking()) {
            io.sentry.cache.b bVar = (io.sentry.cache.b) envelopeDiskCache;
            if (!bVar.f()) {
                sentryAndroidOptions.getLogger().h(p5.WARNING, "Timed out waiting to flush previous session to its own file.", new Object[0]);
                bVar.X.countDown();
            }
        }
        ArrayList arrayList = new ArrayList(historicalProcessExitReasons);
        n0 n0Var = this.z;
        Long lB = n0Var.b();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ApplicationExitInfo applicationExitInfoA = a71.a(it.next());
            if (applicationExitInfoA.getReason() == n0Var.a()) {
                it.remove();
                applicationExitInfo = applicationExitInfoA;
                break;
            }
        }
        if (applicationExitInfo == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "No %ss have been found in the historical exit reasons list.", n0Var.c());
            return;
        }
        long timestamp = applicationExitInfo.getTimestamp();
        long j = this.A;
        if (timestamp < j) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Latest %s happened too long ago, returning early.", n0Var.c());
            return;
        }
        if (lB != null && applicationExitInfo.getTimestamp() <= lB.longValue()) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Latest %s has already been reported, returning early.", n0Var.c());
            return;
        }
        if (n0Var.d()) {
            Collections.reverse(arrayList);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ApplicationExitInfo applicationExitInfoA2 = a71.a(it2.next());
                if (applicationExitInfoA2.getReason() == n0Var.a()) {
                    if (applicationExitInfoA2.getTimestamp() < j) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "%s happened too long ago %s.", n0Var.c(), applicationExitInfoA2);
                    } else if (lB == null || applicationExitInfoA2.getTimestamp() > lB.longValue()) {
                        a(applicationExitInfoA2, false);
                    } else {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "%s has already been reported %s.", n0Var.c(), applicationExitInfoA2);
                    }
                }
            }
        }
        a(applicationExitInfo, true);
    }
}
