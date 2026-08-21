package io.sentry;

import com.getsurfboard.ui.SurfboardApp;
import defpackage.ed;
import defpackage.ga1;
import defpackage.x8;
import defpackage.xe;
import io.sentry.android.core.SentryAndroidOptions;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;
import org.conscrypt.BuildConfig;

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
    */
    public static void f(SentryAndroidOptions sentryAndroidOptions) {
        g1 vVar;
        Class clsF;
        List list;
        w2 w2Var = w2.b;
        boolean z = io.sentry.util.j.a;
        if (!z) {
            if (y5.AUTO.equals(sentryAndroidOptions.getOpenTelemetryMode())) {
                if (io.sentry.util.g.d("io.sentry.opentelemetry.agent.AgentMarker", w2Var)) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENT", new Object[0]);
                    sentryAndroidOptions.setOpenTelemetryMode(y5.AGENT);
                } else if (io.sentry.util.g.d("io.sentry.opentelemetry.agent.AgentlessMarker", w2Var)) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS", new Object[0]);
                    sentryAndroidOptions.setOpenTelemetryMode(y5.AGENTLESS);
                } else if (io.sentry.util.g.d("io.sentry.opentelemetry.agent.AgentlessSpringMarker", w2Var)) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "openTelemetryMode has been inferred from AUTO to AGENTLESS_SPRING", new Object[0]);
                    sentryAndroidOptions.setOpenTelemetryMode(y5.AGENTLESS_SPRING);
                }
            }
        }
        y5 y5Var = y5.OFF;
        int i = 1;
        if (y5Var == sentryAndroidOptions.getOpenTelemetryMode()) {
            sentryAndroidOptions.setSpanFactory(new i3(i));
        }
        a.close();
        sentryAndroidOptions.getScopesStorageFactory();
        if (y5Var == sentryAndroidOptions.getOpenTelemetryMode()) {
            a = new v();
        } else if (z || !io.sentry.util.g.d("io.sentry.opentelemetry.OtelContextScopesStorage", w2Var) || (clsF = io.sentry.util.g.f(w2Var, "io.sentry.opentelemetry.OtelContextScopesStorage", true)) == null) {
            vVar = new v();
            a = vVar;
        } else {
            try {
                Object objNewInstance = clsF.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance instanceof g1) {
                    vVar = (g1) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
            a = vVar;
        }
        if (io.sentry.util.j.a) {
            return;
        }
        y5 openTelemetryMode = sentryAndroidOptions.getOpenTelemetryMode();
        if (y5.OFF.equals(openTelemetryMode)) {
            list = Collections.EMPTY_LIST;
        } else {
            ConcurrentHashMap concurrentHashMap = io.sentry.util.o.a;
            ArrayList arrayList = new ArrayList();
            y5 y5Var2 = y5.AGENT;
            if (y5Var2 == openTelemetryMode || y5.AGENTLESS_SPRING == openTelemetryMode) {
                arrayList.add("auto.http.spring_jakarta.webmvc");
                arrayList.add("auto.http.spring.webmvc");
                arrayList.add("auto.http.spring7.webmvc");
                arrayList.add("auto.spring_jakarta.webflux");
                arrayList.add("auto.spring.webflux");
                arrayList.add("auto.spring7.webflux");
                arrayList.add("auto.db.jdbc");
                arrayList.add("auto.http.spring_jakarta.webclient");
                arrayList.add("auto.http.spring.webclient");
                arrayList.add("auto.http.spring7.webclient");
                arrayList.add("auto.http.spring_jakarta.restclient");
                arrayList.add("auto.http.spring.restclient");
                arrayList.add("auto.http.spring7.restclient");
                arrayList.add("auto.http.spring_jakarta.resttemplate");
                arrayList.add("auto.http.spring.resttemplate");
                arrayList.add("auto.http.spring7.resttemplate");
                arrayList.add("auto.http.openfeign");
                arrayList.add("auto.http.ktor-client");
                arrayList.add("auto.queue.spring_jakarta.kafka.producer");
                arrayList.add("auto.queue.spring_jakarta.kafka.consumer");
                arrayList.add("auto.queue.kafka.producer");
                arrayList.add("auto.queue.kafka.consumer");
            }
            if (y5Var2 == openTelemetryMode) {
                arrayList.add("auto.graphql.graphql");
                arrayList.add("auto.graphql.graphql22");
            }
            list = arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sentryAndroidOptions.addIgnoredSpanOrigin((String) it.next());
        }
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
    */
    public static boolean h(SentryAndroidOptions sentryAndroidOptions) {
        Properties properties;
        Properties propertiesB;
        String property;
        Double dValueOf;
        String property2;
        Double dValueOf2;
        String property3;
        Double dValueOf3;
        String property4;
        String property5;
        String property6;
        Iterator it;
        Iterator it2;
        List<String> listC;
        Iterator it3;
        Iterator it4;
        Long lD;
        Long lD2;
        String property7;
        Long lD3;
        Long lD4;
        String property8;
        String property9;
        InputStream resourceAsStream;
        Properties propertiesB2;
        Properties propertiesB3;
        if (sentryAndroidOptions.isEnableExternalConfiguration()) {
            q2 q2Var = new q2();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new io.sentry.config.e("sentry.", System.getProperties()));
            arrayList.add(new io.sentry.config.c());
            String property10 = System.getProperty("sentry.properties.file");
            if (property10 != null && (propertiesB3 = new io.sentry.android.core.d1(property10, q2Var, true).b()) != null) {
                arrayList.add(new io.sentry.config.e(propertiesB3));
            }
            String str = System.getenv("SENTRY_PROPERTIES_FILE");
            if (str != null && (propertiesB2 = new io.sentry.android.core.d1(str, q2Var, true).b()) != null) {
                arrayList.add(new io.sentry.config.e(propertiesB2));
            }
            Double dValueOf4 = null;
            try {
                resourceAsStream = io.sentry.util.b.d(io.sentry.config.a.class.getClassLoader()).getResourceAsStream("sentry.properties");
            } catch (IOException e2) {
                q2Var.b(p5.ERROR, e2, "Failed to load Sentry configuration from classpath resource: %s", "sentry.properties");
            }
            if (resourceAsStream != null) {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                    try {
                        properties = new Properties();
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        resourceAsStream.close();
                        if (properties != null) {
                            arrayList.add(new io.sentry.config.e(properties));
                        }
                        propertiesB = new io.sentry.android.core.d1("sentry.properties", q2Var, false).b();
                        if (propertiesB != null) {
                            arrayList.add(new io.sentry.config.e(propertiesB));
                        }
                        io.sentry.config.b bVar = new io.sentry.config.b(arrayList);
                        ILogger logger = sentryAndroidOptions.getLogger();
                        h0 h0Var = new h0();
                        h0Var.a = bVar.getProperty("dsn");
                        h0Var.b = bVar.getProperty("environment");
                        h0Var.c = bVar.getProperty(BuildConfig.BUILD_TYPE);
                        h0Var.d = bVar.getProperty("dist");
                        h0Var.e = bVar.getProperty("servername");
                        h0Var.f = bVar.b("uncaught.handler.enabled");
                        h0Var.y = bVar.b("uncaught.handler.print-stacktrace");
                        property = bVar.getProperty("sample-rate");
                        if (property == null) {
                            try {
                                dValueOf = Double.valueOf(property);
                            } catch (NumberFormatException unused) {
                                dValueOf = null;
                            }
                            h0Var.i = dValueOf;
                            property2 = bVar.getProperty("traces-sample-rate");
                            if (property2 == null) {
                                try {
                                    dValueOf2 = Double.valueOf(property2);
                                } catch (NumberFormatException unused2) {
                                    dValueOf2 = null;
                                }
                                h0Var.j = dValueOf2;
                                property3 = bVar.getProperty("profiles-sample-rate");
                                if (property3 == null) {
                                    try {
                                        dValueOf3 = Double.valueOf(property3);
                                    } catch (NumberFormatException unused3) {
                                        dValueOf3 = null;
                                    }
                                    h0Var.k = dValueOf3;
                                    h0Var.g = bVar.b("debug");
                                    h0Var.h = bVar.b("enable-deduplication");
                                    h0Var.z = bVar.b("send-client-reports");
                                    h0Var.Q = bVar.b("force-init");
                                    property4 = bVar.getProperty("max-request-body-size");
                                    if (property4 != null) {
                                        h0Var.l = n6.valueOf(property4.toUpperCase(Locale.ROOT));
                                    }
                                    for (Map.Entry entry : ((ConcurrentHashMap) bVar.a()).entrySet()) {
                                        h0Var.m.put((String) entry.getKey(), (String) entry.getValue());
                                    }
                                    property5 = bVar.getProperty("proxy.host");
                                    String property11 = bVar.getProperty("proxy.user");
                                    String property12 = bVar.getProperty("proxy.pass");
                                    property6 = bVar.getProperty("proxy.port");
                                    if (property6 == null) {
                                        property6 = "80";
                                    }
                                    if (property5 != null) {
                                        m6 m6Var = new m6();
                                        m6Var.a = property5;
                                        m6Var.b = property6;
                                        m6Var.c = property11;
                                        m6Var.d = property12;
                                        h0Var.n = m6Var;
                                    }
                                    it = bVar.c("in-app-includes").iterator();
                                    while (it.hasNext()) {
                                        h0Var.p.add((String) it.next());
                                    }
                                    it2 = bVar.c("in-app-excludes").iterator();
                                    while (it2.hasNext()) {
                                        h0Var.o.add((String) it2.next());
                                    }
                                    listC = bVar.getProperty("trace-propagation-targets") == null ? bVar.c("trace-propagation-targets") : null;
                                    if (listC == null && bVar.getProperty("tracing-origins") != null) {
                                        listC = bVar.c("tracing-origins");
                                    }
                                    if (listC != null) {
                                        for (String str2 : listC) {
                                            if (h0Var.q == null) {
                                                h0Var.q = new CopyOnWriteArrayList();
                                            }
                                            if (!str2.isEmpty()) {
                                                h0Var.q.add(str2);
                                            }
                                        }
                                    }
                                    it3 = bVar.c("context-tags").iterator();
                                    while (it3.hasNext()) {
                                        h0Var.r.add((String) it3.next());
                                    }
                                    h0Var.s = bVar.getProperty("proguard-uuid");
                                    it4 = bVar.c("bundle-ids").iterator();
                                    while (it4.hasNext()) {
                                        h0Var.A.add((String) it4.next());
                                    }
                                    h0Var.t = bVar.d("idle-timeout");
                                    h0Var.u = bVar.d("shutdown-timeout-millis");
                                    h0Var.v = bVar.d("session-flush-timeout-millis");
                                    String property13 = bVar.getProperty("ignored-errors");
                                    h0Var.x = property13 == null ? Arrays.asList(property13.split(",")) : null;
                                    h0Var.B = bVar.b("enabled");
                                    h0Var.C = bVar.b("enable-pretty-serialization-output");
                                    h0Var.J = bVar.b("send-modules");
                                    h0Var.K = bVar.b("send-default-pii");
                                    String property14 = bVar.getProperty("ignored-checkins");
                                    h0Var.H = property14 == null ? Arrays.asList(property14.split(",")) : null;
                                    String property15 = bVar.getProperty("ignored-transactions");
                                    h0Var.I = property15 == null ? Arrays.asList(property15.split(",")) : null;
                                    h0Var.L = bVar.b("enable-backpressure-handling");
                                    h0Var.M = bVar.b("enable-database-transaction-tracing");
                                    h0Var.N = bVar.b("enable-cache-tracing");
                                    h0Var.O = bVar.b("enable-queue-tracing");
                                    h0Var.P = bVar.b("global-hub-mode");
                                    h0Var.R = bVar.b("capture-open-telemetry-events");
                                    h0Var.E = bVar.b("logs.enabled");
                                    h0Var.F = bVar.b("metrics.enabled");
                                    for (String str3 : bVar.c("ignored-exceptions-for-type")) {
                                        try {
                                            Class<?> cls = Class.forName(str3);
                                            if (Throwable.class.isAssignableFrom(cls)) {
                                                h0Var.w.add(cls);
                                            } else {
                                                logger.h(p5.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", str3, str3);
                                            }
                                        } catch (ClassNotFoundException unused4) {
                                            logger.h(p5.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", str3, str3);
                                        }
                                    }
                                    lD = bVar.d("cron.default-checkin-margin");
                                    lD2 = bVar.d("cron.default-max-runtime");
                                    property7 = bVar.getProperty("cron.default-timezone");
                                    lD3 = bVar.d("cron.default-failure-issue-threshold");
                                    lD4 = bVar.d("cron.default-recovery-threshold");
                                    if (lD == null || lD2 != null || property7 != null || lD3 != null || lD4 != null) {
                                        f6 f6Var = new f6();
                                        f6Var.a = lD;
                                        f6Var.b = lD2;
                                        f6Var.c = property7;
                                        f6Var.d = lD3;
                                        f6Var.e = lD4;
                                        h0Var.X = f6Var;
                                    }
                                    h0Var.V = bVar.b("enable-strict-trace-continuation");
                                    h0Var.W = bVar.getProperty("org-id");
                                    h0Var.D = bVar.b("enable-spotlight");
                                    h0Var.G = bVar.getProperty("spotlight-connection-url");
                                    property8 = bVar.getProperty("profile-session-sample-rate");
                                    if (property8 != null) {
                                        try {
                                            dValueOf4 = Double.valueOf(property8);
                                        } catch (NumberFormatException unused5) {
                                        }
                                    }
                                    h0Var.S = dValueOf4;
                                    h0Var.T = bVar.getProperty("profiling-traces-dir-path");
                                    property9 = bVar.getProperty("profile-lifecycle");
                                    if (property9 != null && !property9.isEmpty()) {
                                        h0Var.U = u3.valueOf(property9.toUpperCase());
                                    }
                                    sentryAndroidOptions.merge(h0Var);
                                } else {
                                    dValueOf3 = null;
                                    h0Var.k = dValueOf3;
                                    h0Var.g = bVar.b("debug");
                                    h0Var.h = bVar.b("enable-deduplication");
                                    h0Var.z = bVar.b("send-client-reports");
                                    h0Var.Q = bVar.b("force-init");
                                    property4 = bVar.getProperty("max-request-body-size");
                                    if (property4 != null) {
                                    }
                                    while (r5.hasNext()) {
                                    }
                                    property5 = bVar.getProperty("proxy.host");
                                    String property112 = bVar.getProperty("proxy.user");
                                    String property122 = bVar.getProperty("proxy.pass");
                                    property6 = bVar.getProperty("proxy.port");
                                    if (property6 == null) {
                                    }
                                    if (property5 != null) {
                                    }
                                    it = bVar.c("in-app-includes").iterator();
                                    while (it.hasNext()) {
                                    }
                                    it2 = bVar.c("in-app-excludes").iterator();
                                    while (it2.hasNext()) {
                                    }
                                    if (bVar.getProperty("trace-propagation-targets") == null) {
                                    }
                                    if (listC == null) {
                                        listC = bVar.c("tracing-origins");
                                    }
                                    if (listC != null) {
                                    }
                                    it3 = bVar.c("context-tags").iterator();
                                    while (it3.hasNext()) {
                                    }
                                    h0Var.s = bVar.getProperty("proguard-uuid");
                                    it4 = bVar.c("bundle-ids").iterator();
                                    while (it4.hasNext()) {
                                    }
                                    h0Var.t = bVar.d("idle-timeout");
                                    h0Var.u = bVar.d("shutdown-timeout-millis");
                                    h0Var.v = bVar.d("session-flush-timeout-millis");
                                    String property132 = bVar.getProperty("ignored-errors");
                                    h0Var.x = property132 == null ? Arrays.asList(property132.split(",")) : null;
                                    h0Var.B = bVar.b("enabled");
                                    h0Var.C = bVar.b("enable-pretty-serialization-output");
                                    h0Var.J = bVar.b("send-modules");
                                    h0Var.K = bVar.b("send-default-pii");
                                    String property142 = bVar.getProperty("ignored-checkins");
                                    h0Var.H = property142 == null ? Arrays.asList(property142.split(",")) : null;
                                    String property152 = bVar.getProperty("ignored-transactions");
                                    h0Var.I = property152 == null ? Arrays.asList(property152.split(",")) : null;
                                    h0Var.L = bVar.b("enable-backpressure-handling");
                                    h0Var.M = bVar.b("enable-database-transaction-tracing");
                                    h0Var.N = bVar.b("enable-cache-tracing");
                                    h0Var.O = bVar.b("enable-queue-tracing");
                                    h0Var.P = bVar.b("global-hub-mode");
                                    h0Var.R = bVar.b("capture-open-telemetry-events");
                                    h0Var.E = bVar.b("logs.enabled");
                                    h0Var.F = bVar.b("metrics.enabled");
                                    while (r5.hasNext()) {
                                    }
                                    lD = bVar.d("cron.default-checkin-margin");
                                    lD2 = bVar.d("cron.default-max-runtime");
                                    property7 = bVar.getProperty("cron.default-timezone");
                                    lD3 = bVar.d("cron.default-failure-issue-threshold");
                                    lD4 = bVar.d("cron.default-recovery-threshold");
                                    if (lD == null) {
                                        f6 f6Var2 = new f6();
                                        f6Var2.a = lD;
                                        f6Var2.b = lD2;
                                        f6Var2.c = property7;
                                        f6Var2.d = lD3;
                                        f6Var2.e = lD4;
                                        h0Var.X = f6Var2;
                                        h0Var.V = bVar.b("enable-strict-trace-continuation");
                                        h0Var.W = bVar.getProperty("org-id");
                                        h0Var.D = bVar.b("enable-spotlight");
                                        h0Var.G = bVar.getProperty("spotlight-connection-url");
                                        property8 = bVar.getProperty("profile-session-sample-rate");
                                        if (property8 != null) {
                                        }
                                        h0Var.S = dValueOf4;
                                        h0Var.T = bVar.getProperty("profiling-traces-dir-path");
                                        property9 = bVar.getProperty("profile-lifecycle");
                                        if (property9 != null) {
                                            h0Var.U = u3.valueOf(property9.toUpperCase());
                                        }
                                        sentryAndroidOptions.merge(h0Var);
                                    }
                                }
                            } else {
                                dValueOf2 = null;
                                h0Var.j = dValueOf2;
                                property3 = bVar.getProperty("profiles-sample-rate");
                                if (property3 == null) {
                                }
                            }
                        } else {
                            dValueOf = null;
                            h0Var.i = dValueOf;
                            property2 = bVar.getProperty("traces-sample-rate");
                            if (property2 == null) {
                            }
                        }
                    } finally {
                    }
                } finally {
                }
            } else if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            properties = null;
            if (properties != null) {
            }
            propertiesB = new io.sentry.android.core.d1("sentry.properties", q2Var, false).b();
            if (propertiesB != null) {
            }
            io.sentry.config.b bVar2 = new io.sentry.config.b(arrayList);
            ILogger logger2 = sentryAndroidOptions.getLogger();
            h0 h0Var2 = new h0();
            h0Var2.a = bVar2.getProperty("dsn");
            h0Var2.b = bVar2.getProperty("environment");
            h0Var2.c = bVar2.getProperty(BuildConfig.BUILD_TYPE);
            h0Var2.d = bVar2.getProperty("dist");
            h0Var2.e = bVar2.getProperty("servername");
            h0Var2.f = bVar2.b("uncaught.handler.enabled");
            h0Var2.y = bVar2.b("uncaught.handler.print-stacktrace");
            property = bVar2.getProperty("sample-rate");
            if (property == null) {
            }
        }
        String dsn = sentryAndroidOptions.getDsn();
        if (!sentryAndroidOptions.isEnabled() || (dsn != null && dsn.isEmpty())) {
            a();
            return false;
        }
        if (dsn != null) {
            sentryAndroidOptions.retrieveParsedDsn();
            return true;
        }
        xe.k("DSN is required. Use empty string or set enabled to false in SentryOptions to disable SDK.");
        return false;
    }
}
