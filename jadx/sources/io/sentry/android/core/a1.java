package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import defpackage.ha0;
import io.sentry.ILogger;
import io.sentry.k5;
import io.sentry.m4;
import io.sentry.n5;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.t5;
import io.sentry.t6;
import io.sentry.u3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 {
    public static void a(String str, p5 p5Var, String str2, Throwable th) {
        io.sentry.g gVar = new io.sentry.g();
        gVar.Z = "Logcat";
        gVar.A = str2;
        gVar.z0 = p5Var;
        if (str != null) {
            gVar.d(str, "tag");
        }
        if (th != null && th.getMessage() != null) {
            gVar.d(th.getMessage(), "throwable");
        }
        p4.c().g(gVar);
    }

    public static void b(t5 t5Var, String str, Throwable th) {
        if (p4.c().getOptions().getLogs().a) {
            String message = th != null ? th.getMessage() : null;
            io.sentry.d dVar = new io.sentry.d();
            dVar.a = "auto.log.logcat";
            if (th == null || message == null) {
                p4.c().q().e(t5Var, dVar, str, new Object[0]);
                return;
            }
            io.sentry.logger.a aVarQ = p4.c().q();
            if (str != null) {
                message = ha0.o(str, "\n", message);
            }
            aVarQ.e(t5Var, dVar, message, new Object[0]);
        }
    }

    public static void c(Context context, SentryAndroidOptions sentryAndroidOptions, q0 q0Var) {
        List listI;
        List listI2;
        List listI3;
        List listI4;
        try {
            Bundle bundleF = f(context, sentryAndroidOptions.getLogger(), q0Var);
            ILogger logger = sentryAndroidOptions.getLogger();
            if (bundleF != null) {
                sentryAndroidOptions.setDebug(g(bundleF, logger, "io.sentry.debug", sentryAndroidOptions.isDebug()));
                if (sentryAndroidOptions.isDebug()) {
                    String strName = sentryAndroidOptions.getDiagnosticLevel().name();
                    Locale locale = Locale.ROOT;
                    String strK = k(bundleF, logger, "io.sentry.debug.level", strName.toLowerCase(locale));
                    if (strK != null) {
                        sentryAndroidOptions.setDiagnosticLevel(p5.valueOf(strK.toUpperCase(locale)));
                    }
                }
                sentryAndroidOptions.setAnrEnabled(g(bundleF, logger, "io.sentry.anr.enable", sentryAndroidOptions.isAnrEnabled()));
                sentryAndroidOptions.setTombstoneEnabled(g(bundleF, logger, "io.sentry.tombstone.enable", sentryAndroidOptions.isTombstoneEnabled()));
                sentryAndroidOptions.setAttachRawTombstone(g(bundleF, logger, "io.sentry.tombstone.attach-raw", sentryAndroidOptions.isAttachRawTombstone()));
                sentryAndroidOptions.setReportHistoricalTombstones(g(bundleF, logger, "io.sentry.tombstone.report-historical", sentryAndroidOptions.isReportHistoricalTombstones()));
                sentryAndroidOptions.setEnableAutoSessionTracking(g(bundleF, logger, "io.sentry.auto-session-tracking.enable", sentryAndroidOptions.isEnableAutoSessionTracking()));
                if (sentryAndroidOptions.getSampleRate() == null) {
                    double dH = h(bundleF, logger, "io.sentry.sample-rate");
                    if (dH != -1.0d) {
                        sentryAndroidOptions.setSampleRate(Double.valueOf(dH));
                    }
                }
                sentryAndroidOptions.setAnrReportInDebug(g(bundleF, logger, "io.sentry.anr.report-debug", sentryAndroidOptions.isAnrReportInDebug()));
                sentryAndroidOptions.setAnrTimeoutIntervalMillis(j(bundleF, logger, "io.sentry.anr.timeout-interval-millis", sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                sentryAndroidOptions.setAttachAnrThreadDump(g(bundleF, logger, "io.sentry.anr.attach-thread-dumps", sentryAndroidOptions.isAttachAnrThreadDump()));
                sentryAndroidOptions.setReportHistoricalAnrs(g(bundleF, logger, "io.sentry.anr.report-historical", sentryAndroidOptions.isReportHistoricalAnrs()));
                sentryAndroidOptions.setEnableNdkAppHangTracking(g(bundleF, logger, "io.sentry.ndk.app-hang.enable", sentryAndroidOptions.isEnableNdkAppHangTracking()));
                sentryAndroidOptions.setNdkAppHangTimeoutIntervalMillis(j(bundleF, logger, "io.sentry.ndk.app-hang.timeout-interval-millis", sentryAndroidOptions.getNdkAppHangTimeoutIntervalMillis()));
                String strK2 = k(bundleF, logger, "io.sentry.dsn", sentryAndroidOptions.getDsn());
                boolean zG = g(bundleF, logger, "io.sentry.enabled", sentryAndroidOptions.isEnabled());
                if (!zG || (strK2 != null && strK2.isEmpty())) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Sentry enabled flag set to false or DSN is empty: disabling sentry-android", new Object[0]);
                } else if (strK2 == null) {
                    sentryAndroidOptions.getLogger().h(p5.FATAL, "DSN is required. Use empty string to disable SDK.", new Object[0]);
                }
                sentryAndroidOptions.setEnabled(zG);
                sentryAndroidOptions.setDsn(strK2);
                sentryAndroidOptions.setEnableNdk(g(bundleF, logger, "io.sentry.ndk.enable", sentryAndroidOptions.isEnableNdk()));
                sentryAndroidOptions.setEnableScopeSync(g(bundleF, logger, "io.sentry.ndk.scope-sync.enable", sentryAndroidOptions.isEnableScopeSync()));
                String strK3 = k(bundleF, logger, "io.sentry.ndk.sdk-name", sentryAndroidOptions.getNativeSdkName());
                if (strK3 != null) {
                    sentryAndroidOptions.setNativeSdkName(strK3);
                }
                sentryAndroidOptions.setRelease(k(bundleF, logger, "io.sentry.release", sentryAndroidOptions.getRelease()));
                sentryAndroidOptions.setDist(k(bundleF, logger, "io.sentry.dist", sentryAndroidOptions.getDist()));
                sentryAndroidOptions.setEnvironment(k(bundleF, logger, "io.sentry.environment", sentryAndroidOptions.getEnvironment()));
                sentryAndroidOptions.setSessionTrackingIntervalMillis(j(bundleF, logger, "io.sentry.session-tracking.timeout-interval-millis", sentryAndroidOptions.getSessionTrackingIntervalMillis()));
                sentryAndroidOptions.setMaxBreadcrumbs((int) j(bundleF, logger, "io.sentry.max-breadcrumbs", sentryAndroidOptions.getMaxBreadcrumbs()));
                sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(g(bundleF, logger, "io.sentry.breadcrumbs.activity-lifecycle", sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(g(bundleF, logger, "io.sentry.breadcrumbs.app-lifecycle", sentryAndroidOptions.isEnableAppLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableSystemEventBreadcrumbs(g(bundleF, logger, "io.sentry.breadcrumbs.system-events", sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                sentryAndroidOptions.setEnableAppComponentBreadcrumbs(g(bundleF, logger, "io.sentry.breadcrumbs.app-components", sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                sentryAndroidOptions.setEnableUserInteractionBreadcrumbs(g(bundleF, logger, "io.sentry.breadcrumbs.user-interaction", sentryAndroidOptions.isEnableUserInteractionBreadcrumbs()));
                sentryAndroidOptions.setEnableNetworkEventBreadcrumbs(g(bundleF, logger, "io.sentry.breadcrumbs.network-events", sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
                sentryAndroidOptions.setEnableUncaughtExceptionHandler(g(bundleF, logger, "io.sentry.uncaught-exception-handler.enable", sentryAndroidOptions.isEnableUncaughtExceptionHandler()));
                sentryAndroidOptions.setAttachThreads(g(bundleF, logger, "io.sentry.attach-threads", sentryAndroidOptions.isAttachThreads()));
                sentryAndroidOptions.setAttachScreenshot(g(bundleF, logger, "io.sentry.attach-screenshot", sentryAndroidOptions.isAttachScreenshot()));
                sentryAndroidOptions.setAttachViewHierarchy(g(bundleF, logger, "io.sentry.attach-view-hierarchy", sentryAndroidOptions.isAttachViewHierarchy()));
                sentryAndroidOptions.setSendClientReports(g(bundleF, logger, "io.sentry.send-client-reports", sentryAndroidOptions.isSendClientReports()));
                if (g(bundleF, logger, "io.sentry.auto-init", true)) {
                    sentryAndroidOptions.setInitPriority(io.sentry.t1.LOW);
                }
                sentryAndroidOptions.setForceInit(g(bundleF, logger, "io.sentry.force-init", sentryAndroidOptions.isForceInit()));
                sentryAndroidOptions.setCollectAdditionalContext(g(bundleF, logger, "io.sentry.additional-context", sentryAndroidOptions.isCollectAdditionalContext()));
                sentryAndroidOptions.setCollectExternalStorageContext(g(bundleF, logger, "io.sentry.external-storage-context", sentryAndroidOptions.isCollectExternalStorageContext()));
                if (sentryAndroidOptions.getTracesSampleRate() == null) {
                    double dH2 = h(bundleF, logger, "io.sentry.traces.sample-rate");
                    if (dH2 != -1.0d) {
                        sentryAndroidOptions.setTracesSampleRate(Double.valueOf(dH2));
                    }
                }
                sentryAndroidOptions.setTraceSampling(g(bundleF, logger, "io.sentry.traces.trace-sampling", sentryAndroidOptions.isTraceSampling()));
                sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(g(bundleF, logger, "io.sentry.traces.activity.enable", sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(g(bundleF, logger, "io.sentry.traces.activity.auto-finish.enable", sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
                if (sentryAndroidOptions.getProfilesSampleRate() == null) {
                    double dH3 = h(bundleF, logger, "io.sentry.traces.profiling.sample-rate");
                    if (dH3 != -1.0d) {
                        sentryAndroidOptions.setProfilesSampleRate(Double.valueOf(dH3));
                    }
                }
                if (sentryAndroidOptions.getProfileSessionSampleRate() == null) {
                    double dH4 = h(bundleF, logger, "io.sentry.traces.profiling.session-sample-rate");
                    if (dH4 != -1.0d) {
                        sentryAndroidOptions.setProfileSessionSampleRate(Double.valueOf(dH4));
                    }
                }
                String strName2 = sentryAndroidOptions.getProfileLifecycle().name();
                Locale locale2 = Locale.ROOT;
                String strK4 = k(bundleF, logger, "io.sentry.traces.profiling.lifecycle", strName2.toLowerCase(locale2));
                if (strK4 != null) {
                    sentryAndroidOptions.setProfileLifecycle(u3.valueOf(strK4.toUpperCase(locale2)));
                }
                sentryAndroidOptions.setStartProfilerOnAppStart(g(bundleF, logger, "io.sentry.traces.profiling.start-on-app-start", sentryAndroidOptions.isStartProfilerOnAppStart()));
                sentryAndroidOptions.setEnableUserInteractionTracing(g(bundleF, logger, "io.sentry.traces.user-interaction.enable", sentryAndroidOptions.isEnableUserInteractionTracing()));
                sentryAndroidOptions.setEnableTimeToFullDisplayTracing(g(bundleF, logger, "io.sentry.traces.time-to-full-display.enable", sentryAndroidOptions.isEnableTimeToFullDisplayTracing()));
                long j = j(bundleF, logger, "io.sentry.traces.idle-timeout", -1L);
                if (j != -1) {
                    sentryAndroidOptions.setIdleTimeout(Long.valueOf(j));
                }
                List<String> listI5 = i(bundleF, logger, "io.sentry.traces.trace-propagation-targets");
                if (bundleF.containsKey("io.sentry.traces.trace-propagation-targets") && listI5 == null) {
                    sentryAndroidOptions.setTracePropagationTargets(Collections.EMPTY_LIST);
                } else if (listI5 != null) {
                    sentryAndroidOptions.setTracePropagationTargets(listI5);
                }
                sentryAndroidOptions.setEnableFramesTracking(g(bundleF, logger, "io.sentry.traces.frames-tracking", true));
                sentryAndroidOptions.setProguardUuid(k(bundleF, logger, "io.sentry.proguard-uuid", sentryAndroidOptions.getProguardUuid()));
                io.sentry.protocol.u sdkVersion = sentryAndroidOptions.getSdkVersion();
                if (sdkVersion == null) {
                    sdkVersion = new io.sentry.protocol.u("", "");
                }
                String strL = l(bundleF, logger, "io.sentry.sdk.name", sdkVersion.b);
                io.sentry.util.b.r(strL, "name is required.");
                sdkVersion.b = strL;
                String strL2 = l(bundleF, logger, "io.sentry.sdk.version", sdkVersion.f);
                io.sentry.util.b.r(strL2, "version is required.");
                sdkVersion.f = strL2;
                sentryAndroidOptions.setSdkVersion(sdkVersion);
                sentryAndroidOptions.setSendDefaultPii(g(bundleF, logger, "io.sentry.send-default-pii", sentryAndroidOptions.isSendDefaultPii()));
                List listI6 = i(bundleF, logger, "io.sentry.gradle-plugin-integrations");
                if (listI6 != null) {
                    Iterator it = listI6.iterator();
                    while (it.hasNext()) {
                        n5.d().a((String) it.next());
                    }
                }
                sentryAndroidOptions.setEnableRootCheck(g(bundleF, logger, "io.sentry.enable-root-check", sentryAndroidOptions.isEnableRootCheck()));
                sentryAndroidOptions.setSendModules(g(bundleF, logger, "io.sentry.send-modules", sentryAndroidOptions.isSendModules()));
                sentryAndroidOptions.setEnablePerformanceV2(g(bundleF, logger, "io.sentry.performance-v2.enable", sentryAndroidOptions.isEnablePerformanceV2()));
                sentryAndroidOptions.setEnableStandaloneAppStartTracing(g(bundleF, logger, "io.sentry.standalone-app-start-tracing.enable", sentryAndroidOptions.isEnableStandaloneAppStartTracing()));
                sentryAndroidOptions.setEnableAppStartProfiling(g(bundleF, logger, "io.sentry.profiling.enable-app-start", sentryAndroidOptions.isEnableAppStartProfiling()));
                sentryAndroidOptions.setEnableLegacyProfiling(g(bundleF, logger, "io.sentry.profiling.enable-legacy-profiling", sentryAndroidOptions.isEnableLegacyProfiling()));
                sentryAndroidOptions.setEnableScopePersistence(g(bundleF, logger, "io.sentry.enable-scope-persistence", sentryAndroidOptions.isEnableScopePersistence()));
                sentryAndroidOptions.setEnableAutoTraceIdGeneration(g(bundleF, logger, "io.sentry.traces.enable-auto-id-generation", sentryAndroidOptions.isEnableAutoTraceIdGeneration()));
                sentryAndroidOptions.setDeadlineTimeout(j(bundleF, logger, "io.sentry.traces.deadline-timeout", sentryAndroidOptions.getDeadlineTimeout()));
                if (sentryAndroidOptions.getSessionReplay().d == null) {
                    double dH5 = h(bundleF, logger, "io.sentry.session-replay.session-sample-rate");
                    if (dH5 != -1.0d) {
                        sentryAndroidOptions.getSessionReplay().F(Double.valueOf(dH5));
                    }
                }
                if (sentryAndroidOptions.getSessionReplay().e == null) {
                    double dH6 = h(bundleF, logger, "io.sentry.session-replay.on-error-sample-rate");
                    if (dH6 != -1.0d) {
                        sentryAndroidOptions.getSessionReplay().E(Double.valueOf(dH6));
                    }
                }
                sentryAndroidOptions.getSessionReplay().v(g(bundleF, logger, "io.sentry.session-replay.mask-all-text", true));
                sentryAndroidOptions.getSessionReplay().u(g(bundleF, logger, "io.sentry.session-replay.mask-all-images", true));
                sentryAndroidOptions.getSessionReplay().m = g(bundleF, logger, "io.sentry.session-replay.debug", false);
                String strK5 = k(bundleF, logger, "io.sentry.session-replay.screenshot-strategy", null);
                if (strK5 != null) {
                    if ("canvas".equals(strK5.toLowerCase(Locale.ROOT))) {
                        sentryAndroidOptions.getSessionReplay().n = m4.CANVAS;
                    } else {
                        sentryAndroidOptions.getSessionReplay().n = m4.PIXEL_COPY;
                    }
                }
                sentryAndroidOptions.getSessionReplay().o = g(bundleF, logger, "io.sentry.session-replay.capture-surface-views", sentryAndroidOptions.getSessionReplay().o);
                if (sentryAndroidOptions.getSessionReplay().p.isEmpty() && (listI4 = i(bundleF, logger, "io.sentry.session-replay.network-detail-allow-urls")) != null && !listI4.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = listI4.iterator();
                    while (it2.hasNext()) {
                        String strTrim = ((String) it2.next()).trim();
                        if (!strTrim.isEmpty()) {
                            arrayList.add(strTrim);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        sentryAndroidOptions.getSessionReplay().A(arrayList);
                    }
                }
                if (sentryAndroidOptions.getSessionReplay().q.isEmpty() && (listI3 = i(bundleF, logger, "io.sentry.session-replay.network-detail-deny-urls")) != null && !listI3.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it3 = listI3.iterator();
                    while (it3.hasNext()) {
                        String strTrim2 = ((String) it3.next()).trim();
                        if (!strTrim2.isEmpty()) {
                            arrayList2.add(strTrim2);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        sentryAndroidOptions.getSessionReplay().B(arrayList2);
                    }
                }
                sentryAndroidOptions.getSessionReplay().r = g(bundleF, logger, "io.sentry.session-replay.network-capture-bodies", sentryAndroidOptions.getSessionReplay().r);
                if (sentryAndroidOptions.getSessionReplay().s.size() == t6.u.size() && (listI2 = i(bundleF, logger, "io.sentry.session-replay.network-request-headers")) != null) {
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it4 = listI2.iterator();
                    while (it4.hasNext()) {
                        String strTrim3 = ((String) it4.next()).trim();
                        if (!strTrim3.isEmpty()) {
                            arrayList3.add(strTrim3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        sentryAndroidOptions.getSessionReplay().C(arrayList3);
                    }
                }
                if (sentryAndroidOptions.getSessionReplay().t.size() == t6.u.size() && (listI = i(bundleF, logger, "io.sentry.session-replay.network-response-headers")) != null && !listI.isEmpty()) {
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it5 = listI.iterator();
                    while (it5.hasNext()) {
                        String strTrim4 = ((String) it5.next()).trim();
                        if (!strTrim4.isEmpty()) {
                            arrayList4.add(strTrim4);
                        }
                    }
                    if (!arrayList4.isEmpty()) {
                        sentryAndroidOptions.getSessionReplay().D(arrayList4);
                    }
                }
                sentryAndroidOptions.setIgnoredErrors(i(bundleF, logger, "io.sentry.ignored-errors"));
                List listI7 = i(bundleF, logger, "io.sentry.in-app-includes");
                if (listI7 != null && !listI7.isEmpty()) {
                    Iterator it6 = listI7.iterator();
                    while (it6.hasNext()) {
                        sentryAndroidOptions.addInAppInclude((String) it6.next());
                    }
                }
                List listI8 = i(bundleF, logger, "io.sentry.in-app-excludes");
                if (listI8 != null && !listI8.isEmpty()) {
                    Iterator it7 = listI8.iterator();
                    while (it7.hasNext()) {
                        sentryAndroidOptions.addInAppExclude((String) it7.next());
                    }
                }
                sentryAndroidOptions.getLogs().a = g(bundleF, logger, "io.sentry.logs.enabled", sentryAndroidOptions.getLogs().a);
                sentryAndroidOptions.getMetrics().a = g(bundleF, logger, "io.sentry.metrics.enabled", sentryAndroidOptions.getMetrics().a);
                k5 feedbackOptions = sentryAndroidOptions.getFeedbackOptions();
                feedbackOptions.a = g(bundleF, logger, "io.sentry.feedback.is-name-required", feedbackOptions.a);
                feedbackOptions.b = g(bundleF, logger, "io.sentry.feedback.show-name", feedbackOptions.b);
                feedbackOptions.c = g(bundleF, logger, "io.sentry.feedback.is-email-required", feedbackOptions.c);
                feedbackOptions.d = g(bundleF, logger, "io.sentry.feedback.show-email", feedbackOptions.d);
                feedbackOptions.e = g(bundleF, logger, "io.sentry.feedback.use-sentry-user", feedbackOptions.e);
                feedbackOptions.f = g(bundleF, logger, "io.sentry.feedback.show-branding", feedbackOptions.f);
                feedbackOptions.g = g(bundleF, logger, "io.sentry.feedback.use-shake-gesture", feedbackOptions.g);
                sentryAndroidOptions.setStrictTraceContinuation(g(bundleF, logger, "io.sentry.strict-trace-continuation.enabled", sentryAndroidOptions.isStrictTraceContinuation()));
                String strK6 = k(bundleF, logger, "io.sentry.org-id", null);
                if (strK6 != null) {
                    sentryAndroidOptions.setOrgId(strK6);
                }
                sentryAndroidOptions.setEnableSpotlight(g(bundleF, logger, "io.sentry.spotlight.enable", sentryAndroidOptions.isEnableSpotlight()));
                String strK7 = k(bundleF, logger, "io.sentry.spotlight.url", null);
                if (strK7 != null) {
                    sentryAndroidOptions.setSpotlightConnectionUrl(strK7);
                }
                sentryAndroidOptions.getScreenshot().v(g(bundleF, logger, "io.sentry.screenshot.mask-all-text", false));
                sentryAndroidOptions.getScreenshot().u(g(bundleF, logger, "io.sentry.screenshot.mask-all-images", false));
                if (sentryAndroidOptions.getAnrProfilingSampleRate() == null) {
                    double dH7 = h(bundleF, logger, "io.sentry.anr.profiling.sample-rate");
                    if (dH7 != -1.0d) {
                        sentryAndroidOptions.setAnrProfilingSampleRate(Double.valueOf(dH7));
                    }
                }
                sentryAndroidOptions.setEnableAnrFingerprinting(g(bundleF, logger, "io.sentry.anr.enable-fingerprinting", sentryAndroidOptions.isEnableAnrFingerprinting()));
            }
            sentryAndroidOptions.getLogger().h(p5.INFO, "Retrieving configuration from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to read configuration from android manifest metadata.", th);
        }
    }

    public static void d(String str, String str2) {
        a(str, p5.ERROR, str2, null);
        b(t5.ERROR, str2, null);
        Log.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        a(str, p5.ERROR, str2, th);
        b(t5.ERROR, str2, th);
        Log.e(str, str2, th);
    }

    public static Bundle f(Context context, ILogger iLogger, q0 q0Var) {
        ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? (ApplicationInfo) p0.d.a(context) : (ApplicationInfo) p0.e.a(context);
        if (applicationInfo != null) {
            return applicationInfo.metaData;
        }
        return null;
    }

    public static boolean g(Bundle bundle, ILogger iLogger, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        p5 p5Var = p5.DEBUG;
        if (iLogger.i(p5Var)) {
            iLogger.h(p5Var, str + " read: " + z2, new Object[0]);
        }
        return z2;
    }

    public static double h(Bundle bundle, ILogger iLogger, String str) {
        double dDoubleValue = Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue();
        if (dDoubleValue == -1.0d) {
            dDoubleValue = Integer.valueOf(bundle.getInt(str, -1)).doubleValue();
        }
        p5 p5Var = p5.DEBUG;
        if (iLogger.i(p5Var)) {
            iLogger.h(p5Var, str + " read: " + dDoubleValue, new Object[0]);
        }
        return dDoubleValue;
    }

    public static List i(Bundle bundle, ILogger iLogger, String str) {
        String string = bundle.getString(str);
        p5 p5Var = p5.DEBUG;
        if (iLogger.i(p5Var)) {
            iLogger.h(p5Var, ha0.o(str, " read: ", string), new Object[0]);
        }
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    public static long j(Bundle bundle, ILogger iLogger, String str, long j) {
        long j2 = bundle.getInt(str, (int) j);
        p5 p5Var = p5.DEBUG;
        if (iLogger.i(p5Var)) {
            iLogger.h(p5Var, str + " read: " + j2, new Object[0]);
        }
        return j2;
    }

    public static String k(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        p5 p5Var = p5.DEBUG;
        if (iLogger.i(p5Var)) {
            iLogger.h(p5Var, ha0.o(str, " read: ", string), new Object[0]);
        }
        return string;
    }

    public static String l(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        p5 p5Var = p5.DEBUG;
        if (iLogger.i(p5Var)) {
            iLogger.h(p5Var, ha0.o(str, " read: ", string), new Object[0]);
        }
        return string;
    }

    public static void m(String str, Exception exc) {
        a(str, p5.WARNING, null, exc);
        b(t5.WARN, null, exc);
        Log.w(str, exc);
    }

    public static void n(String str, String str2) {
        a(str, p5.WARNING, str2, null);
        b(t5.WARN, str2, null);
        Log.w(str, str2);
    }

    public static void o(String str, String str2, Throwable th) {
        a(str, p5.WARNING, str2, th);
        b(t5.WARN, str2, th);
        Log.w(str, str2, th);
    }

    public static void p(String str, String str2, Exception exc) {
        a(str, p5.ERROR, str2, exc);
        b(t5.FATAL, str2, exc);
        Log.wtf(str, str2, exc);
    }
}
