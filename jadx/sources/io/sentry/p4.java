package io.sentry;

import com.getsurfboard.ui.SurfboardApp;
import defpackage.ed;
import defpackage.ga1;
import defpackage.x8;
import io.sentry.android.core.SentryAndroidOptions;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class p4 {
    public static volatile g1 a = c3.a;
    public static volatile f1 b = a3.b;
    public static final f4 c = new f4(p6.empty());
    public static volatile boolean d = false;
    public static final Charset e = Charset.forName("UTF-8");
    public static final long f = System.currentTimeMillis();
    public static final io.sentry.util.a g = new io.sentry.util.a();

    public static void a() {
        io.sentry.util.a aVar = g;
        aVar.g();
        try {
            f1 f1VarC = c();
            b = a3.b;
            a.close();
            f1VarC.a(false);
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

    public static void b(long j) {
        c().b(j);
    }

    public static f1 c() {
        if (d) {
            return b;
        }
        f1 f1Var = a.get();
        if (f1Var != null && !f1Var.p()) {
            return f1Var;
        }
        f1 f1VarA = b.A("getCurrentScopes");
        a.a(f1VarA);
        return f1VarA;
    }

    public static void d(io.sentry.android.core.w wVar, io.sentry.android.core.e eVar) {
        SentryAndroidOptions sentryAndroidOptions = new SentryAndroidOptions();
        try {
            io.sentry.android.core.q1.c((io.sentry.android.core.w) eVar.b, (SurfboardApp) eVar.f, (ed) eVar.z, sentryAndroidOptions);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
        io.sentry.util.a aVar = g;
        aVar.g();
        try {
            if (!SentryAndroidOptions.class.getName().equals("io.sentry.android.core.SentryAndroidOptions") && io.sentry.util.j.a) {
                throw new IllegalArgumentException("You are running Android. Please, use SentryAndroid.init. ".concat(SentryAndroidOptions.class.getName()));
            }
            if (h(sentryAndroidOptions)) {
                Boolean boolIsGlobalHubMode = sentryAndroidOptions.isGlobalHubMode();
                int i = 1;
                boolean zBooleanValue = boolIsGlobalHubMode != null ? boolIsGlobalHubMode.booleanValue() : true;
                int i2 = 0;
                sentryAndroidOptions.getLogger().h(p5.INFO, "GlobalHubMode: '%s'", String.valueOf(zBooleanValue));
                d = zBooleanValue;
                if (sentryAndroidOptions.getFatalLogger() instanceof w2) {
                    sentryAndroidOptions.setFatalLogger(new q2());
                }
                f4 f4Var = c;
                if (io.sentry.util.b.t(f4Var.l, sentryAndroidOptions, g())) {
                    if (g()) {
                        sentryAndroidOptions.getLogger().h(p5.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
                    }
                    sentryAndroidOptions.activate();
                    c().a(true);
                    f4Var.l = sentryAndroidOptions;
                    Queue queue = f4Var.g;
                    f4Var.g = f4.a(sentryAndroidOptions.getMaxBreadcrumbs());
                    Iterator it = queue.iterator();
                    while (it.hasNext()) {
                        f4Var.c((g) it.next(), null);
                    }
                    b = new k4(new f4(sentryAndroidOptions), new f4(sentryAndroidOptions), f4Var);
                    if (sentryAndroidOptions.isDebug() && (sentryAndroidOptions.getLogger() instanceof w2)) {
                        sentryAndroidOptions.setLogger(new q2());
                    }
                    f(sentryAndroidOptions);
                    a.a(b);
                    e(sentryAndroidOptions);
                    f4Var.u = new x8(sentryAndroidOptions);
                    if (sentryAndroidOptions.getExecutorService().isClosed()) {
                        sentryAndroidOptions.setExecutorService(new j5(sentryAndroidOptions));
                    }
                    if (sentryAndroidOptions.getTimerExecutorService().isClosed()) {
                        sentryAndroidOptions.setTimerExecutorService(new j5(sentryAndroidOptions, 0));
                    }
                    try {
                        sentryAndroidOptions.getExecutorService().submit(new o4(sentryAndroidOptions, i2));
                    } catch (RejectedExecutionException e2) {
                        sentryAndroidOptions.getLogger().d(p5.DEBUG, "Failed to call the executor. Lazy fields will not be loaded. Did you call Sentry.close()?", e2);
                    }
                    try {
                        sentryAndroidOptions.getExecutorService().submit(new p2(i2, sentryAndroidOptions));
                    } catch (Throwable th2) {
                        sentryAndroidOptions.getLogger().d(p5.DEBUG, "Failed to move previous session.", th2);
                    }
                    for (v1 v1Var : sentryAndroidOptions.getIntegrations()) {
                        try {
                            v1Var.M(sentryAndroidOptions);
                        } catch (Throwable th3) {
                            sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to register the integration " + v1Var.getClass().getName(), th3);
                        }
                    }
                    try {
                        sentryAndroidOptions.getExecutorService().submit(new o4(sentryAndroidOptions, 2));
                    } catch (Throwable th4) {
                        sentryAndroidOptions.getLogger().d(p5.DEBUG, "Failed to notify options observers.", th4);
                    }
                    try {
                        sentryAndroidOptions.getExecutorService().submit(new q3(sentryAndroidOptions));
                    } catch (Throwable th5) {
                        sentryAndroidOptions.getLogger().d(p5.DEBUG, "Failed to finalize previous session.", th5);
                    }
                    try {
                        sentryAndroidOptions.getExecutorService().submit(new o4(sentryAndroidOptions, i));
                    } catch (Throwable th6) {
                        sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to call the executor. App start profiling config will not be changed. Did you call Sentry.close()?", th6);
                    }
                    ILogger logger = sentryAndroidOptions.getLogger();
                    p5 p5Var = p5.DEBUG;
                    logger.h(p5Var, "Using openTelemetryMode %s", sentryAndroidOptions.getOpenTelemetryMode());
                    sentryAndroidOptions.getLogger().h(p5Var, "Using span factory %s", sentryAndroidOptions.getSpanFactory().getClass().getName());
                    sentryAndroidOptions.getLogger().h(p5Var, "Using scopes storage %s", a.getClass().getName());
                } else {
                    sentryAndroidOptions.getLogger().h(p5.WARNING, "This init call has been ignored due to priority being too low.", new Object[0]);
                }
            }
            aVar.close();
        } catch (Throwable th7) {
            try {
                aVar.close();
            } catch (Throwable th8) {
                th7.addSuppressed(th8);
            }
            throw th7;
        }
    }

    public static void e(SentryAndroidOptions sentryAndroidOptions) {
        Iterator it;
        ILogger logger;
        Iterator it2;
        io.sentry.cache.c bVar;
        ILogger logger2 = sentryAndroidOptions.getLogger();
        p5 p5Var = p5.INFO;
        logger2.h(p5Var, "Initializing SDK with DSN: '%s'", sentryAndroidOptions.getDsn());
        if (sentryAndroidOptions.getOutboxPath() == null) {
            logger2.h(p5Var, "No outbox dir path is defined in options.", new Object[0]);
        }
        if (sentryAndroidOptions.getCacheDirPath() != null && (sentryAndroidOptions.getEnvelopeDiskCache() instanceof io.sentry.transport.i)) {
            Charset charset = io.sentry.cache.b.z0;
            String cacheDirPath = sentryAndroidOptions.getCacheDirPath();
            int maxCacheItems = sentryAndroidOptions.getMaxCacheItems();
            if (cacheDirPath == null) {
                sentryAndroidOptions.getLogger().h(p5.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
                bVar = io.sentry.transport.i.b;
            } else {
                bVar = new io.sentry.cache.b(sentryAndroidOptions, cacheDirPath, maxCacheItems);
            }
            sentryAndroidOptions.setEnvelopeDiskCache(bVar);
        }
        String profilingTracesDirPath = sentryAndroidOptions.getProfilingTracesDirPath();
        if ((sentryAndroidOptions.isProfilingEnabled() || sentryAndroidOptions.isContinuousProfilingEnabled()) && profilingTracesDirPath != null) {
            File file = new File(profilingTracesDirPath);
            file.mkdirs();
            try {
                sentryAndroidOptions.getExecutorService().submit(new ga1(27, file));
            } catch (RejectedExecutionException e2) {
                sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", e2);
            }
        }
        io.sentry.internal.modules.a modulesLoader = sentryAndroidOptions.getModulesLoader();
        if (!sentryAndroidOptions.isSendModules()) {
            sentryAndroidOptions.setModulesLoader(io.sentry.internal.modules.e.a);
        } else if (modulesLoader instanceof io.sentry.internal.modules.e) {
            sentryAndroidOptions.setModulesLoader(new io.sentry.internal.modules.f(Arrays.asList(new io.sentry.internal.modules.c(sentryAndroidOptions.getLogger()), new io.sentry.internal.modules.f(sentryAndroidOptions.getLogger())), sentryAndroidOptions.getLogger()));
        }
        if (sentryAndroidOptions.getDebugMetaLoader() instanceof io.sentry.internal.debugmeta.b) {
            sentryAndroidOptions.setDebugMetaLoader(new io.sentry.internal.debugmeta.c(sentryAndroidOptions.getLogger()));
        }
        List<Properties> listF = sentryAndroidOptions.getDebugMetaLoader().f();
        if (listF != null) {
            if (sentryAndroidOptions.getBundleIds().isEmpty()) {
                Iterator it3 = listF.iterator();
                while (it3.hasNext()) {
                    String property = ((Properties) it3.next()).getProperty("io.sentry.bundle-ids");
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Bundle IDs found: %s", property);
                    if (property != null) {
                        for (String str : property.split(",", -1)) {
                            sentryAndroidOptions.addBundleId(str);
                        }
                    }
                }
            }
            if (sentryAndroidOptions.getProguardUuid() == null) {
                Iterator it4 = listF.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    String property2 = ((Properties) it4.next()).getProperty("io.sentry.ProguardUuids");
                    if (property2 != null) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Proguard UUID found: %s", property2);
                        sentryAndroidOptions.setProguardUuid(property2);
                        break;
                    }
                }
            }
            Iterator it5 = listF.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Properties properties = (Properties) it5.next();
                String property3 = properties.getProperty("io.sentry.build-tool");
                if (property3 != null) {
                    String property4 = properties.getProperty("io.sentry.build-tool-version");
                    if (property4 == null) {
                        property4 = "unknown";
                    }
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Build tool found: %s, version %s", property3, property4);
                    n5.d().b(property3, property4);
                }
            }
            for (Properties properties2 : listF) {
                String property5 = properties2.getProperty("io.sentry.distribution.org-slug");
                String property6 = properties2.getProperty("io.sentry.distribution.project-slug");
                String property7 = properties2.getProperty("io.sentry.distribution.auth-token");
                String property8 = properties2.getProperty("io.sentry.distribution.build-configuration");
                String property9 = properties2.getProperty("io.sentry.distribution.install-groups-override");
                if (property5 != null || property6 != null || property7 != null || property8 != null || property9 != null) {
                    g6 distribution = sentryAndroidOptions.getDistribution();
                    if (property5 != null && !property5.isEmpty() && distribution.b.isEmpty()) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Distribution org slug found: %s", property5);
                        distribution.b = property5;
                    }
                    if (property6 != null && !property6.isEmpty() && distribution.c.isEmpty()) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Distribution project slug found: %s", property6);
                        distribution.c = property6;
                    }
                    if (property7 != null && !property7.isEmpty() && distribution.a.isEmpty()) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Distribution org auth token found", new Object[0]);
                        distribution.a = property7;
                    }
                    if (property8 != null && !property8.isEmpty() && distribution.d == null) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Distribution build configuration found: %s", property8);
                        distribution.d = property8;
                    }
                    if (property9 != null && !property9.isEmpty() && distribution.e == null) {
                        String[] strArrSplit = property9.split(",", -1);
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strTrim = str2.trim();
                            if (!strTrim.isEmpty()) {
                                arrayList.add(strTrim);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Distribution install groups override found: %s", arrayList);
                            distribution.e = arrayList;
                        }
                    }
                }
            }
        }
        if (sentryAndroidOptions.getThreadChecker() instanceof io.sentry.util.thread.b) {
            sentryAndroidOptions.setThreadChecker(io.sentry.util.thread.c.b);
        }
        if (sentryAndroidOptions.getPerformanceCollectors().isEmpty()) {
            sentryAndroidOptions.addPerformanceCollector(new w1());
        }
        if (sentryAndroidOptions.isEnableBackpressureHandling() && !io.sentry.util.j.a) {
            if (sentryAndroidOptions.getBackpressureMonitor() instanceof io.sentry.backpressure.c) {
                sentryAndroidOptions.setBackpressureMonitor(new io.sentry.backpressure.a(sentryAndroidOptions));
            }
            sentryAndroidOptions.getBackpressureMonitor().start();
        }
        if (!io.sentry.util.j.a && sentryAndroidOptions.isContinuousProfilingEnabled() && (sentryAndroidOptions.getContinuousProfiler() instanceof t2)) {
            try {
                if (sentryAndroidOptions.getProfilingTracesDirPath() == null) {
                    File file2 = new File(System.getProperty("java.io.tmpdir"), "sentry_profiling_traces");
                    if (file2.mkdirs() || file2.exists()) {
                        sentryAndroidOptions.setProfilingTracesDirPath(file2.getAbsolutePath());
                    } else {
                        io.sentry.android.core.cache.a.c(file2.getAbsolutePath(), "Creating a fallback directory for profiling failed in ");
                    }
                }
                logger = sentryAndroidOptions.getLogger();
                sentryAndroidOptions.getProfilingTracesHz();
                sentryAndroidOptions.getExecutorService();
                try {
                    it2 = ServiceLoader.load(io.sentry.profiling.a.class).iterator();
                } catch (Throwable th) {
                    logger.d(p5.ERROR, "Failed to load continuous profiler provider, using NoOpContinuousProfiler", th);
                }
            } catch (Exception e3) {
                sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to create default profiling traces directory", e3);
            }
            if ((it2.hasNext() ? it2.next() : null) != null) {
                throw new ClassCastException();
            }
            logger.h(p5.DEBUG, "No continuous profiler provider found, using NoOpContinuousProfiler", new Object[0]);
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Could not load profiler, profiling will be disabled. If you are using Spring or Spring Boot with the OTEL Agent profiler init will be retried.", new Object[0]);
            sentryAndroidOptions.getContinuousProfiler();
        } else {
            sentryAndroidOptions.getContinuousProfiler();
        }
        if (!io.sentry.util.j.a && sentryAndroidOptions.isContinuousProfilingEnabled() && (sentryAndroidOptions.getProfilerConverter() instanceof x2)) {
            ILogger logger3 = c.l.getLogger();
            try {
                it = ServiceLoader.load(io.sentry.profiling.b.class).iterator();
            } catch (Throwable th2) {
                logger3.d(p5.ERROR, "Failed to load profile converter provider, using NoOpProfileConverter", th2);
            }
            if ((it.hasNext() ? it.next() : null) != null) {
                throw new ClassCastException();
            }
            logger3.h(p5.DEBUG, "No profile converter provider found, using NoOpProfileConverter", new Object[0]);
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Could not load profile converter. If you are using Spring or Spring Boot with the OTEL Agent, profile converter init will be retried.", new Object[0]);
            sentryAndroidOptions.getProfilerConverter();
        } else {
            sentryAndroidOptions.getProfilerConverter();
        }
        sentryAndroidOptions.getLogger().h(p5.INFO, "Continuous profiler is enabled %s mode: %s", Boolean.valueOf(sentryAndroidOptions.isContinuousProfilingEnabled()), sentryAndroidOptions.getProfileLifecycle());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(io.sentry.android.core.SentryAndroidOptions r6) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.p4.f(io.sentry.android.core.SentryAndroidOptions):void");
    }

    public static boolean g() {
        return c().isEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x025d A[LOOP:4: B:101:0x0257->B:103:0x025d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0281 A[LOOP:5: B:105:0x027b->B:107:0x0281, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018a A[LOOP:0: B:65:0x0184->B:67:0x018a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e0 A[LOOP:1: B:75:0x01da->B:77:0x01e0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01fc A[LOOP:2: B:79:0x01f6->B:81:0x01fc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean h(io.sentry.android.core.SentryAndroidOptions r12) {
        /*
            Method dump skipped, instruction units count: 1077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.p4.h(io.sentry.android.core.SentryAndroidOptions):boolean");
    }
}
