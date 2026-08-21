package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.android.core.EnvelopeFileObserverIntegration;
import io.sentry.android.core.anr.AnrProfilingIntegration;
import io.sentry.android.distribution.DistributionIntegration;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter;
import io.sentry.g3;
import io.sentry.l3;
import io.sentry.n4;
import io.sentry.p5;
import io.sentry.q2;
import io.sentry.r2;
import io.sentry.s2;
import io.sentry.t2;
import io.sentry.y2;
import io.sentry.z5;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {
    public static void a(SentryAndroidOptions sentryAndroidOptions, SurfboardApp surfboardApp, q0 q0Var, io.sentry.util.g gVar, d dVar, boolean z) {
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof io.sentry.transport.i)) {
            sentryAndroidOptions.setEnvelopeDiskCache(new io.sentry.android.core.cache.c(sentryAndroidOptions));
        }
        if (sentryAndroidOptions.getConnectionStatusProvider() instanceof s2) {
            sentryAndroidOptions.setConnectionStatusProvider(new io.sentry.android.core.internal.util.b(surfboardApp, sentryAndroidOptions, q0Var));
        }
        if (sentryAndroidOptions.getCacheDirPath() != null) {
            sentryAndroidOptions.addScopeObserver(new io.sentry.cache.e(sentryAndroidOptions));
            sentryAndroidOptions.addOptionsObserver(new io.sentry.cache.d(sentryAndroidOptions));
            PackageInfo packageInfoD = p0.d(surfboardApp, q0Var);
            if (packageInfoD != null) {
                long j = packageInfoD.lastUpdateTime;
                if (j > 0) {
                    sentryAndroidOptions.addOptionsObserver(new o1(sentryAndroidOptions, j));
                }
            }
        }
        sentryAndroidOptions.addEventProcessor(new io.sentry.p(sentryAndroidOptions, 0));
        sentryAndroidOptions.addEventProcessor(new s0(surfboardApp, q0Var, sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new n1(sentryAndroidOptions, dVar));
        sentryAndroidOptions.addEventProcessor(new ScreenshotEventProcessor(sentryAndroidOptions, q0Var, z));
        sentryAndroidOptions.addEventProcessor(new ViewHierarchyEventProcessor(sentryAndroidOptions));
        sentryAndroidOptions.addEventProcessor(new m0(surfboardApp, q0Var, sentryAndroidOptions));
        if (sentryAndroidOptions.getTransportGate() instanceof io.sentry.transport.k) {
            q0 q0Var2 = new q0();
            q0Var2.b = sentryAndroidOptions;
            sentryAndroidOptions.setTransportGate(q0Var2);
        }
        sentryAndroidOptions.setAppStartExtender(io.sentry.android.core.performance.g.c().L0);
        if (sentryAndroidOptions.getModulesLoader() instanceof io.sentry.internal.modules.e) {
            sentryAndroidOptions.setModulesLoader(new io.sentry.internal.modules.f(surfboardApp, sentryAndroidOptions));
        }
        if (sentryAndroidOptions.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
            sentryAndroidOptions.setDebugMetaLoader(new io.sentry.internal.debugmeta.c(surfboardApp, sentryAndroidOptions.getLogger()));
        }
        if (sentryAndroidOptions.getVersionDetector() instanceof l3) {
            sentryAndroidOptions.setVersionDetector(new io.sentry.w(sentryAndroidOptions));
        }
        io.sentry.util.f fVar = new io.sentry.util.f(new z5(gVar, sentryAndroidOptions));
        boolean zB = io.sentry.util.g.b(sentryAndroidOptions, "androidx.compose.ui.node.Owner");
        if (sentryAndroidOptions.getGestureTargetLocators().isEmpty()) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(new io.sentry.android.core.internal.gestures.a(fVar));
            if (zB && io.sentry.util.g.b(sentryAndroidOptions, "io.sentry.compose.gestures.ComposeGestureTargetLocator")) {
                arrayList.add(new ComposeGestureTargetLocator(sentryAndroidOptions.getLogger()));
            }
            sentryAndroidOptions.setGestureTargetLocators(arrayList);
        }
        if (sentryAndroidOptions.getViewHierarchyExporters().isEmpty() && zB && io.sentry.util.g.b(sentryAndroidOptions, "io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter")) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(new ComposeViewHierarchyExporter(sentryAndroidOptions.getLogger()));
            sentryAndroidOptions.setViewHierarchyExporters(arrayList2);
        }
        if (sentryAndroidOptions.getThreadChecker() instanceof io.sentry.util.thread.b) {
            sentryAndroidOptions.setThreadChecker(io.sentry.android.core.internal.util.d.a);
        }
        if (sentryAndroidOptions.getSocketTagger() instanceof g3) {
            sentryAndroidOptions.setSocketTagger(w.f);
        }
        if (sentryAndroidOptions.getPerformanceCollectors().isEmpty()) {
            sentryAndroidOptions.addPerformanceCollector(new o());
            sentryAndroidOptions.addPerformanceCollector(new j(sentryAndroidOptions.getLogger()));
            if (sentryAndroidOptions.isEnablePerformanceV2()) {
                io.sentry.android.core.internal.util.r frameMetricsCollector = sentryAndroidOptions.getFrameMetricsCollector();
                io.sentry.util.b.r(frameMetricsCollector, "options.getFrameMetricsCollector is required");
                sentryAndroidOptions.addPerformanceCollector(new c2(sentryAndroidOptions, frameMetricsCollector));
            }
        }
        if (sentryAndroidOptions.getCompositePerformanceCollector() instanceof r2) {
            sentryAndroidOptions.setCompositePerformanceCollector(new io.sentry.t(sentryAndroidOptions));
        }
        if (z && (sentryAndroidOptions.getReplayController().X() instanceof y2)) {
            sentryAndroidOptions.getReplayController().F(new io.sentry.android.replay.b(sentryAndroidOptions));
        }
        io.sentry.util.a aVar = io.sentry.android.core.performance.g.O0;
        aVar.g();
        aVar.close();
        sentryAndroidOptions.getCompositePerformanceCollector();
        io.sentry.q1 q1Var = q2.X;
        if (sentryAndroidOptions.isProfilingEnabled() || sentryAndroidOptions.getProfilesSampleRate() != null) {
            sentryAndroidOptions.setContinuousProfiler(t2.b);
            if (!sentryAndroidOptions.isEnableLegacyProfiling()) {
                sentryAndroidOptions.getLogger().h(p5.WARNING, "Transaction-based profiling (profilesSampleRate/profilesSampler) is disabled because enableLegacyProfiling is false. Transaction-based profiling always uses the legacy profiler and is not supported by Perfetto. No profiling data will be collected. Use profileSessionSampleRate for continuous profiling instead.", new Object[0]);
                sentryAndroidOptions.setTransactionProfiler(q1Var);
                return;
            } else {
                io.sentry.android.core.internal.util.r frameMetricsCollector2 = sentryAndroidOptions.getFrameMetricsCollector();
                io.sentry.util.b.r(frameMetricsCollector2, "options.getFrameMetricsCollector is required");
                sentryAndroidOptions.setTransactionProfiler(new x(surfboardApp, sentryAndroidOptions, q0Var, frameMetricsCollector2));
                return;
            }
        }
        sentryAndroidOptions.setTransactionProfiler(q1Var);
        io.sentry.android.core.internal.util.r frameMetricsCollector3 = sentryAndroidOptions.getFrameMetricsCollector();
        io.sentry.util.b.r(frameMetricsCollector3, "options.getFrameMetricsCollector is required");
        if (Build.VERSION.SDK_INT >= 35) {
            Context applicationContext = surfboardApp.getApplicationContext();
            if (applicationContext != null) {
                surfboardApp = applicationContext;
            }
            sentryAndroidOptions.setContinuousProfiler(new k1(sentryAndroidOptions.getLogger(), frameMetricsCollector3, new q(sentryAndroidOptions, 0), new r(surfboardApp, sentryAndroidOptions)));
            return;
        }
        if (sentryAndroidOptions.isEnableLegacyProfiling()) {
            sentryAndroidOptions.setContinuousProfiler(new i(q0Var, frameMetricsCollector3, sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.getProfilingTracesHz(), new q(sentryAndroidOptions, 1)));
        } else {
            sentryAndroidOptions.getLogger().h(p5.WARNING, "enableLegacyProfiling is disabled and device is below API 35. No profiling data will be collected.", new Object[0]);
        }
    }

    public static void b(SurfboardApp surfboardApp, SentryAndroidOptions sentryAndroidOptions, q0 q0Var, io.sentry.util.g gVar, d dVar, boolean z, boolean z2, boolean z3, boolean z4) {
        io.sentry.util.f fVar = new io.sentry.util.f(new q(sentryAndroidOptions, 2));
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new n4(new q(sentryAndroidOptions, 3), 0), fVar));
        sentryAndroidOptions.addIntegration(new NdkIntegration(io.sentry.util.g.f(sentryAndroidOptions.getLogger(), "io.sentry.android.ndk.SentryNdk", true)));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            sentryAndroidOptions.addIntegration(new TombstoneIntegration(surfboardApp));
        }
        sentryAndroidOptions.addIntegration(new EnvelopeFileObserverIntegration.OutboxEnvelopeFileObserverIntegration());
        sentryAndroidOptions.addIntegration(new SendCachedEnvelopeIntegration(new n4(new q(sentryAndroidOptions, 3), 1), fVar));
        sentryAndroidOptions.addIntegration(new AppLifecycleIntegration());
        sentryAndroidOptions.addIntegration(i >= 30 ? new AnrV2Integration(surfboardApp) : new AnrIntegration(surfboardApp));
        sentryAndroidOptions.addIntegration(new AnrProfilingIntegration());
        sentryAndroidOptions.addIntegration(new ActivityLifecycleIntegration(surfboardApp, q0Var, dVar));
        sentryAndroidOptions.addIntegration(new ActivityBreadcrumbsIntegration(surfboardApp));
        sentryAndroidOptions.addIntegration(new UserInteractionIntegration(surfboardApp));
        sentryAndroidOptions.addIntegration(new FeedbackShakeIntegration(surfboardApp));
        if (z) {
            sentryAndroidOptions.addIntegration(new FragmentLifecycleIntegration((Application) surfboardApp, true, true));
        }
        if (z2) {
            sentryAndroidOptions.addIntegration(new SentryTimberIntegration());
        }
        sentryAndroidOptions.addIntegration(new AppComponentsBreadcrumbsIntegration(surfboardApp));
        sentryAndroidOptions.addIntegration(new SystemEventsBreadcrumbsIntegration(surfboardApp));
        sentryAndroidOptions.addIntegration(new NetworkBreadcrumbsIntegration(surfboardApp, q0Var));
        if (z3) {
            ReplayIntegration replayIntegration = new ReplayIntegration(surfboardApp);
            sentryAndroidOptions.addIntegration(replayIntegration);
            sentryAndroidOptions.setReplayController(replayIntegration);
        }
        if (z4) {
            DistributionIntegration distributionIntegration = new DistributionIntegration(surfboardApp);
            sentryAndroidOptions.setDistributionController(distributionIntegration);
            sentryAndroidOptions.addIntegration(distributionIntegration);
        }
        sentryAndroidOptions.getFeedbackOptions().getClass();
    }
}
