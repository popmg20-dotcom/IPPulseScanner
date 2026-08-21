package io.sentry;

import com.tencent.mars.xlog.Xlog;
import defpackage.cm2;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.replay.ReplayIntegration;
import java.io.File;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p2 implements Runnable {
    public final /* synthetic */ int b;
    public final Object f;

    public /* synthetic */ p2(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) obj;
                String cacheDirPath = sentryAndroidOptions.getCacheDirPath();
                if (cacheDirPath != null) {
                    io.sentry.cache.c envelopeDiskCache = sentryAndroidOptions.getEnvelopeDiskCache();
                    if (envelopeDiskCache instanceof io.sentry.cache.b) {
                        Charset charset = io.sentry.cache.b.z0;
                        io.sentry.cache.b bVar = (io.sentry.cache.b) envelopeDiskCache;
                        bVar.c(new File(cacheDirPath, "session.json"), new File(cacheDirPath, "previous_session.json"));
                        bVar.X.countDown();
                    }
                } else {
                    sentryAndroidOptions.getLogger().h(p5.INFO, "Cache dir is not set, not moving the previous session.", new Object[0]);
                }
                break;
            case 1:
                int i2 = ReplayIntegration.J0;
                ((ReplayIntegration) obj).Z();
                break;
            case 2:
                ((io.sentry.android.replay.capture.a) obj).a();
                break;
            case 3:
                ((io.sentry.android.replay.capture.a) obj).a();
                break;
            case 4:
                ((io.sentry.android.replay.capture.a) obj).a();
                break;
            case 5:
                ((io.sentry.android.replay.capture.a) obj).a();
                break;
            case 6:
                ((io.sentry.android.replay.capture.c) obj).a();
                break;
            case 7:
                ((io.sentry.android.replay.capture.c) obj).a();
                break;
            case 8:
                ((io.sentry.android.replay.capture.c) obj).a();
                break;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                io.sentry.logger.d dVar = (io.sentry.logger.d) obj;
                ConcurrentLinkedQueue concurrentLinkedQueue = dVar.z;
                do {
                    dVar.c();
                } while (concurrentLinkedQueue.size() >= 100);
                dVar.X.set(false);
                if (!concurrentLinkedQueue.isEmpty()) {
                    dVar.e(false);
                }
                break;
            default:
                cm2 cm2Var = (cm2) obj;
                ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) cm2Var.A;
                do {
                    cm2Var.o();
                } while (concurrentLinkedQueue2.size() >= 1000);
                ((AtomicBoolean) cm2Var.Y).set(false);
                if (!concurrentLinkedQueue2.isEmpty()) {
                    cm2Var.v(false);
                }
                break;
        }
    }
}
