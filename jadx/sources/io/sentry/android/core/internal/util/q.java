package io.sentry.android.core.internal.util;

import android.os.Build;
import android.os.Handler;
import android.view.Window;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class q {
    public static void a(Window window, m mVar, Handler handler) {
        if (mVar == null) {
            return;
        }
        window.addOnFrameMetricsAvailableListener(mVar, handler);
    }

    public static void b(Window window, m mVar) {
        if (mVar == null) {
            return;
        }
        window.removeOnFrameMetricsAvailableListener(mVar);
    }

    public static /* synthetic */ void c(io.sentry.android.replay.util.i iVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || iVar != ForkJoinPool.commonPool()) && !(zIsTerminated = iVar.isTerminated())) {
            iVar.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = iVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        iVar.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static /* synthetic */ void d(io.sentry.transport.n nVar) {
        boolean zIsTerminated;
        if ((Build.VERSION.SDK_INT <= 23 || nVar != ForkJoinPool.commonPool()) && !(zIsTerminated = nVar.isTerminated())) {
            nVar.shutdown();
            boolean z = false;
            while (!zIsTerminated) {
                try {
                    zIsTerminated = nVar.awaitTermination(1L, TimeUnit.DAYS);
                } catch (InterruptedException unused) {
                    if (!z) {
                        nVar.shutdownNow();
                        z = true;
                    }
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
