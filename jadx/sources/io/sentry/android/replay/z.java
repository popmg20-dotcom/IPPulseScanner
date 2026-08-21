package io.sentry.android.replay;

import android.os.Handler;
import defpackage.fw;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.n2;
import io.sentry.p5;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Runnable {
    public v A;
    public final AtomicBoolean X;
    public final SentryAndroidOptions b;
    public final n2 f;
    public u z;

    public z(SentryAndroidOptions sentryAndroidOptions, n2 n2Var) {
        n2Var.getClass();
        this.b = sentryAndroidOptions;
        this.f = n2Var;
        this.X = new AtomicBoolean(true);
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.X.get();
        SentryAndroidOptions sentryAndroidOptions = this.b;
        if (!z) {
            if (sentryAndroidOptions.getSessionReplay().m) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Not capturing frames, recording is not running.", new Object[0]);
                return;
            }
            return;
        }
        try {
            if (sentryAndroidOptions.getSessionReplay().m) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Capturing a frame.", new Object[0]);
            }
            u uVar = this.z;
            if (uVar != null) {
                uVar.b();
            }
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to capture a frame", th);
        }
        if (sentryAndroidOptions.getSessionReplay().m) {
            ILogger logger = sentryAndroidOptions.getLogger();
            p5 p5Var = p5.DEBUG;
            StringBuilder sb = new StringBuilder("Posting the capture runnable again, frame rate is ");
            v vVar = this.A;
            logger.h(p5Var, fw.w(" fps.", sb, vVar != null ? vVar.e : 1), new Object[0]);
        }
        v vVar2 = this.A;
        if (((Handler) this.f.f).postDelayed(this, 1000 / ((long) (vVar2 != null ? vVar2.e : 1)))) {
            return;
        }
        sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to post the capture runnable, main looper is shutting down.", new Object[0]);
    }
}
