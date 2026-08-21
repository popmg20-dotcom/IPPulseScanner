package io.sentry.android.core;

import android.app.Activity;
import android.view.Choreographer;
import com.getsurfboard.ui.SurfboardApp;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.ILogger;
import io.sentry.android.core.anr.AnrProfilingIntegration;
import io.sentry.ndk.NativeScope;
import io.sentry.p5;
import io.sentry.p6;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ z(io.sentry.android.ndk.b bVar, String str, String str2) {
        this.b = 9;
        this.f = str;
        this.z = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strD = null;
        switch (this.b) {
            case 0:
                AnrIntegration anrIntegration = (AnrIntegration) this.f;
                SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.z;
                a aVar = AnrIntegration.X;
                io.sentry.util.a aVar2 = anrIntegration.z;
                aVar2.g();
                try {
                    if (!anrIntegration.f) {
                        anrIntegration.g(sentryAndroidOptions);
                        break;
                    }
                    aVar2.close();
                    return;
                } finally {
                }
            case 1:
                ((j0) this.f).n((ILogger) this.z);
                return;
            case 2:
                FeedbackShakeIntegration feedbackShakeIntegration = (FeedbackShakeIntegration) this.f;
                SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) this.z;
                w1 w1Var = feedbackShakeIntegration.f;
                SurfboardApp surfboardApp = feedbackShakeIntegration.b;
                ILogger logger = sentryAndroidOptions2.getLogger();
                synchronized (w1Var) {
                    w1Var.f = logger;
                    w1Var.b(surfboardApp);
                }
                return;
            case 3:
                FeedbackShakeIntegration feedbackShakeIntegration2 = (FeedbackShakeIntegration) this.f;
                Activity activity = (Activity) this.z;
                if (feedbackShakeIntegration2.X || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                try {
                    feedbackShakeIntegration2.X = true;
                    Runnable runnable = feedbackShakeIntegration2.z.getFeedbackOptions().h;
                    feedbackShakeIntegration2.Y = runnable;
                    feedbackShakeIntegration2.z.getFeedbackOptions().h = new z(4, feedbackShakeIntegration2, runnable);
                    new a2(activity).show();
                    return;
                } catch (Throwable th) {
                    feedbackShakeIntegration2.X = false;
                    feedbackShakeIntegration2.z.getFeedbackOptions().h = feedbackShakeIntegration2.Y;
                    feedbackShakeIntegration2.Y = null;
                    feedbackShakeIntegration2.z.getLogger().d(p5.ERROR, "Failed to show feedback dialog on shake.", th);
                    return;
                }
            case 4:
                FeedbackShakeIntegration feedbackShakeIntegration3 = (FeedbackShakeIntegration) this.f;
                Runnable runnable2 = (Runnable) this.z;
                feedbackShakeIntegration3.X = false;
                feedbackShakeIntegration3.z.getFeedbackOptions().h = runnable2;
                if (runnable2 != null) {
                    runnable2.run();
                }
                feedbackShakeIntegration3.Y = null;
                return;
            case 5:
                a2 a2Var = (a2) this.f;
                Activity activity2 = (Activity) this.z;
                if (activity2.isFinishing() || activity2.isDestroyed()) {
                    return;
                }
                a2Var.show();
                return;
            case 6:
                AnrProfilingIntegration anrProfilingIntegration = (AnrProfilingIntegration) this.f;
                io.sentry.android.core.anr.d dVar = (io.sentry.android.core.anr.d) this.z;
                if (dVar == null) {
                    return;
                }
                try {
                    dVar.close();
                    return;
                } catch (IOException unused) {
                    anrProfilingIntegration.z0.h(p5.WARNING, "Failed to close AnrProfileManager", new Object[0]);
                    return;
                }
            case 7:
                io.sentry.android.core.internal.util.r rVar = (io.sentry.android.core.internal.util.r) this.f;
                w wVar = (w) this.z;
                try {
                    rVar.B0 = Choreographer.getInstance();
                    return;
                } catch (Throwable th2) {
                    wVar.d(p5.ERROR, "Error retrieving Choreographer instance. Slow and frozen frames will not be reported.", th2);
                    return;
                }
            case 8:
                io.sentry.android.ndk.b bVar = (io.sentry.android.ndk.b) this.f;
                io.sentry.g gVar = (io.sentry.g) this.z;
                SentryAndroidOptions sentryAndroidOptions3 = bVar.a;
                p5 p5Var = gVar.z0;
                String lowerCase = p5Var != null ? p5Var.name().toLowerCase(Locale.ROOT) : null;
                String strF = io.sentry.vendor.a.f(gVar.c().getTime());
                try {
                    Map mapB = gVar.b();
                    if (!mapB.isEmpty()) {
                        strD = sentryAndroidOptions3.getSerializer().d(mapB);
                    }
                    break;
                } catch (Throwable th3) {
                    sentryAndroidOptions3.getLogger().b(p5.ERROR, th3, "Breadcrumb data is not serializable.", new Object[0]);
                }
                NativeScope.nativeAddBreadcrumb(lowerCase, gVar.A, gVar.Z, gVar.X, strF, strD);
                return;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                NativeScope.nativeSetTag((String) this.f, (String) this.z);
                return;
            case 10:
                File file = (File) this.f;
                io.sentry.android.replay.capture.g gVar2 = (io.sentry.android.replay.capture.g) this.z;
                io.sentry.util.b.g(file);
                gVar2.k(-1);
                return;
            case 11:
                g gVar3 = (g) this.f;
                p6 p6Var = (p6) this.z;
                try {
                    gVar3.run();
                    return;
                } catch (Throwable th4) {
                    p6Var.getLogger().d(p5.ERROR, "Failed to execute task ReplayIntegration.finalize_previous_replay", th4);
                    return;
                }
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                Runnable runnable3 = (Runnable) this.f;
                io.sentry.android.replay.util.i iVar = (io.sentry.android.replay.util.i) this.z;
                try {
                    runnable3.run();
                    return;
                } catch (Throwable th5) {
                    iVar.f.getLogger().d(p5.ERROR, "Failed to execute task ".concat(runnable3 instanceof io.sentry.android.replay.util.j ? ((io.sentry.android.replay.util.j) runnable3).b : ""), th5);
                    return;
                }
            case 13:
                ((io.sentry.cache.e) this.f).d((Map) this.z, "tags.json");
                return;
            case 14:
                io.sentry.cache.e eVar = (io.sentry.cache.e) this.f;
                try {
                    ((io.sentry.cache.tape.f) eVar.b.a()).g((io.sentry.g) this.z);
                    return;
                } catch (IOException e) {
                    eVar.a.getLogger().d(p5.ERROR, "Failed to add breadcrumb to file queue", e);
                    return;
                }
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                ((io.sentry.cache.e) this.f).d((io.sentry.protocol.e) this.z, "contexts.json");
                return;
            case 16:
                ((io.sentry.cache.e) this.f).d((io.sentry.protocol.w) this.z, "replay.json");
                return;
            case 17:
                io.sentry.cache.e eVar2 = (io.sentry.cache.e) this.f;
                String str = (String) this.z;
                if (str == null) {
                    eVar2.a("transaction.json");
                    return;
                } else {
                    eVar2.d(str, "transaction.json");
                    return;
                }
            default:
                io.sentry.cache.e eVar3 = (io.sentry.cache.e) this.f;
                try {
                    ((Runnable) this.z).run();
                    return;
                } catch (Throwable th6) {
                    eVar3.a.getLogger().d(p5.ERROR, "Serialization task failed", th6);
                    return;
                }
        }
    }

    public /* synthetic */ z(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }
}
