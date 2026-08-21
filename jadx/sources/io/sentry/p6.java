package io.sentry;

import defpackage.st4;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.io.File;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class p6 {
    static final p5 DEFAULT_DIAGNOSTIC_LEVEL = p5.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    public static final long MAX_EVENT_SIZE_BYTES = 1048576;
    private q0 appStartExtender;
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;
    private io.sentry.backpressure.b backpressureMonitor;
    private a6 beforeBreadcrumb;
    private b6 beforeEnvelopeCallback;
    private c6 beforeSend;
    private c6 beforeSendFeedback;
    private d6 beforeSendReplay;
    private e6 beforeSendTransaction;
    private String cacheDirPath;
    private boolean captureOpenTelemetryEvents;
    io.sentry.clientreport.f clientReportRecorder;
    private n compositePerformanceCollector;
    private t0 connectionStatusProvider;
    private int connectionTimeoutMillis;
    private final List<String> contextTags;
    private u0 continuousProfiler;
    private f6 cron;
    private final io.sentry.util.f dateProvider;
    private long deadlineTimeout;
    private boolean debug;
    private io.sentry.internal.debugmeta.a debugMetaLoader;
    private j4 defaultScopeType;
    private final List<String> defaultTracePropagationTargets;
    private p5 diagnosticLevel;
    private String dist;
    private String distinctId;
    private g6 distribution;
    private v0 distributionController;
    private String dsn;
    private String dsnHash;
    private boolean enableAppStartProfiling;
    private boolean enableAutoSessionTracking;
    private boolean enableBackpressureHandling;
    private boolean enableCacheTracing;
    private boolean enableDatabaseTransactionTracing;
    private boolean enableDeduplication;
    private boolean enableEventSizeLimiting;
    private boolean enableExternalConfiguration;
    private boolean enableLegacyProfiling;
    private boolean enablePrettySerializationOutput;
    private boolean enableQueueTracing;
    private boolean enableScopePersistence;
    private boolean enableScreenTracking;
    private boolean enableShutdownHook;
    private boolean enableSpotlight;
    private boolean enableTimeToFullDisplayTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private boolean enabled;
    private io.sentry.cache.c envelopeDiskCache;
    private final io.sentry.util.f envelopeReader;
    private String environment;
    private j1 executorService;
    private final g0 experimental;
    private ILogger fatalLogger;
    private k5 feedbackOptions;
    private boolean forceInit;
    private k0 fullyDisplayedReporter;
    private final List<io.sentry.android.core.internal.gestures.a> gestureTargetLocators;
    private Boolean globalHubMode;
    private Long idleTimeout;
    private List<j0> ignoredCheckIns;
    private List<j0> ignoredSpanOrigins;
    private List<j0> ignoredTransactions;
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;
    private t1 initPriority;
    private u1 instrumenter;
    private volatile i7 internalTracesSampler;
    protected final io.sentry.util.a lock;
    private ILogger logger;
    private h6 logs;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxFeatureFlags;
    private int maxQueueSize;
    private n6 maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;
    private i6 metrics;
    private io.sentry.internal.modules.a modulesLoader;
    private final List<e1> observers;
    private j6 onDiscard;
    private k6 onOversizedEvent;
    private y5 openTelemetryMode;
    private final List<z0> optionsObservers;
    private String orgId;
    private final List<a1> performanceCollectors;
    private boolean printUncaughtStackTrace;
    private u3 profileLifecycle;
    private Double profileSessionSampleRate;
    private c1 profilerConverter;
    private Double profilesSampleRate;
    private l6 profilesSampler;
    private String profilingTracesDirPath;
    private int profilingTracesHz;
    private String proguardUuid;
    private boolean propagateTraceparent;
    private m6 proxy;
    private int readTimeoutMillis;
    private String release;
    private z3 replayController;
    private Double sampleRate;
    private h1 scopesStorageFactory;
    private io.sentry.protocol.u sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private boolean sendModules;
    private String sentryClientName;
    private final io.sentry.util.f serializer;
    private String serverName;
    private t6 sessionReplay;
    private long sessionTrackingIntervalMillis;
    private m1 socketTagger;
    private o1 spanFactory;
    private String spotlightConnectionUrl;
    private final AtomicBoolean spotlightIntegrationLoaded;
    private SSLSocketFactory sslSocketFactory;
    private boolean startProfilerOnAppStart;
    private boolean strictTraceContinuation;
    private final Map<String, String> tags;
    private io.sentry.util.thread.a threadChecker;
    private j1 timerExecutorService;
    private boolean traceOptionsRequests;
    private List<String> tracePropagationTargets;
    private boolean traceSampling;
    private Double tracesSampleRate;
    private o6 tracesSampler;
    private q1 transactionProfiler;
    private r1 transportFactory;
    private io.sentry.transport.h transportGate;
    private s1 versionDetector;
    private final List<Object> viewHierarchyExporters;
    private final List<f0> eventProcessors = new CopyOnWriteArrayList();
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType = new CopyOnWriteArraySet();
    private List<j0> ignoredErrors = null;
    private final List<v1> integrations = new CopyOnWriteArrayList();
    private final Set<String> bundleIds = new CopyOnWriteArraySet();
    private final io.sentry.util.f parsedDsn = new io.sentry.util.f(new z5(this, 0));
    private long shutdownTimeoutMillis = 2000;
    private long flushTimeoutMillis = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;
    private long sessionFlushTimeoutMillis = AbstractTrafficShapingHandler.DEFAULT_MAX_TIME;

    /* JADX WARN: Removed duplicated region for block: B:17:0x02a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public p6(boolean r11) {
        /*
            Method dump skipped, instruction units count: 757
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.p6.<init>(boolean):void");
    }

    public static p6 empty() {
        return new p6(true);
    }

    public final /* synthetic */ c0 a() {
        return new c0(this.dsn);
    }

    public void activate() {
        if (this.executorService instanceof e3) {
            this.executorService = new j5(this);
        }
        if (this.timerExecutorService instanceof e3) {
            this.timerExecutorService = new j5(this, 0);
        }
        if (this.spotlightIntegrationLoaded.compareAndSet(false, true)) {
            try {
                this.integrations.add((v1) Class.forName("io.sentry.spotlight.SpotlightIntegration").getConstructor(null).newInstance(null));
            } catch (Throwable unused) {
            }
        }
    }

    public void addBundleId(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            this.bundleIds.add(strTrim);
        }
    }

    public void addContextTag(String str) {
        this.contextTags.add(str);
    }

    public void addEventProcessor(f0 f0Var) {
        this.eventProcessors.add(f0Var);
    }

    public void addIgnoredCheckIn(String str) {
        List arrayList = this.ignoredCheckIns;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.ignoredCheckIns = arrayList;
        }
        arrayList.add(new j0(str));
    }

    public void addIgnoredError(String str) {
        List arrayList = this.ignoredErrors;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.ignoredErrors = arrayList;
        }
        arrayList.add(new j0(str));
    }

    public void addIgnoredExceptionForType(Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    public void addIgnoredSpanOrigin(String str) {
        List arrayList = this.ignoredSpanOrigins;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.ignoredSpanOrigins = arrayList;
        }
        arrayList.add(new j0(str));
    }

    public void addIgnoredTransaction(String str) {
        List arrayList = this.ignoredTransactions;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.ignoredTransactions = arrayList;
        }
        arrayList.add(new j0(str));
    }

    public void addInAppExclude(String str) {
        this.inAppExcludes.add(str);
    }

    public void addInAppInclude(String str) {
        this.inAppIncludes.add(str);
    }

    public void addIntegration(v1 v1Var) {
        this.integrations.add(v1Var);
    }

    public void addOptionsObserver(z0 z0Var) {
        this.optionsObservers.add(z0Var);
    }

    public void addPerformanceCollector(a1 a1Var) {
        this.performanceCollectors.add(a1Var);
    }

    public void addScopeObserver(e1 e1Var) {
        this.observers.add(e1Var);
    }

    public final /* synthetic */ d0 b() {
        return new d0((l1) this.serializer.a());
    }

    public boolean containsIgnoredExceptionForType(Throwable th) {
        return this.ignoredExceptionsForType.contains(th.getClass());
    }

    public io.sentry.cache.e findPersistingScopeObserver() {
        for (e1 e1Var : this.observers) {
            if (e1Var instanceof io.sentry.cache.e) {
                return (io.sentry.cache.e) e1Var;
            }
        }
        return null;
    }

    public q0 getAppStartExtender() {
        return this.appStartExtender;
    }

    public io.sentry.backpressure.b getBackpressureMonitor() {
        return this.backpressureMonitor;
    }

    public a6 getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }

    public b6 getBeforeEnvelopeCallback() {
        return null;
    }

    public c6 getBeforeSend() {
        return null;
    }

    public c6 getBeforeSendFeedback() {
        return null;
    }

    public d6 getBeforeSendReplay() {
        return null;
    }

    public e6 getBeforeSendTransaction() {
        return null;
    }

    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.dsnHash != null ? new File(this.cacheDirPath, this.dsnHash).getAbsolutePath() : this.cacheDirPath;
    }

    public String getCacheDirPathWithoutDsn() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.cacheDirPath;
    }

    public io.sentry.clientreport.f getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    public n getCompositePerformanceCollector() {
        return this.compositePerformanceCollector;
    }

    public t0 getConnectionStatusProvider() {
        return this.connectionStatusProvider;
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public List<String> getContextTags() {
        return this.contextTags;
    }

    public u0 getContinuousProfiler() {
        return this.continuousProfiler;
    }

    public f6 getCron() {
        return this.cron;
    }

    public x4 getDateProvider() {
        return (x4) this.dateProvider.a();
    }

    public long getDeadlineTimeout() {
        return this.deadlineTimeout;
    }

    public io.sentry.internal.debugmeta.a getDebugMetaLoader() {
        return this.debugMetaLoader;
    }

    public j4 getDefaultScopeType() {
        return this.defaultScopeType;
    }

    public p5 getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public String getDist() {
        return this.dist;
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public g6 getDistribution() {
        return this.distribution;
    }

    public v0 getDistributionController() {
        return this.distributionController;
    }

    public String getDsn() {
        return this.dsn;
    }

    public String getEffectiveOrgId() {
        String str = this.orgId;
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                return strTrim;
            }
        }
        try {
            return retrieveParsedDsn().d;
        } catch (Throwable unused) {
            return null;
        }
    }

    public io.sentry.cache.c getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    public w0 getEnvelopeReader() {
        return (w0) this.envelopeReader.a();
    }

    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    public List<f0> getEventProcessors() {
        return this.eventProcessors;
    }

    public j1 getExecutorService() {
        return this.executorService;
    }

    public g0 getExperimental() {
        return this.experimental;
    }

    public ILogger getFatalLogger() {
        return this.fatalLogger;
    }

    public k5 getFeedbackOptions() {
        return this.feedbackOptions;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    public k0 getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public List<io.sentry.android.core.internal.gestures.a> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    public List<j0> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    public List<j0> getIgnoredErrors() {
        return this.ignoredErrors;
    }

    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public List<j0> getIgnoredSpanOrigins() {
        return this.ignoredSpanOrigins;
    }

    public List<j0> getIgnoredTransactions() {
        return this.ignoredTransactions;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public t1 getInitPriority() {
        return this.initPriority;
    }

    public u1 getInstrumenter() {
        return this.instrumenter;
    }

    public List<v1> getIntegrations() {
        return this.integrations;
    }

    public i7 getInternalTracesSampler() {
        if (this.internalTracesSampler == null) {
            io.sentry.util.a aVar = this.lock;
            aVar.g();
            try {
                if (this.internalTracesSampler == null) {
                    this.internalTracesSampler = new i7(this);
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
        return this.internalTracesSampler;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public h6 getLogs() {
        return this.logs;
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public int getMaxFeatureFlags() {
        return this.maxFeatureFlags;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public n6 getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    public int getMaxSpans() {
        return this.maxSpans;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    public i6 getMetrics() {
        return this.metrics;
    }

    public io.sentry.internal.modules.a getModulesLoader() {
        return this.modulesLoader;
    }

    public j6 getOnDiscard() {
        return null;
    }

    public k6 getOnOversizedEvent() {
        return null;
    }

    public y5 getOpenTelemetryMode() {
        return this.openTelemetryMode;
    }

    public List<z0> getOptionsObservers() {
        return this.optionsObservers;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public String getOutboxPath() {
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "outbox").getAbsolutePath();
    }

    public List<a1> getPerformanceCollectors() {
        return this.performanceCollectors;
    }

    public u3 getProfileLifecycle() {
        return this.profileLifecycle;
    }

    public Double getProfileSessionSampleRate() {
        return this.profileSessionSampleRate;
    }

    public c1 getProfilerConverter() {
        return this.profilerConverter;
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public l6 getProfilesSampler() {
        return null;
    }

    public String getProfilingTracesDirPath() {
        String str = this.profilingTracesDirPath;
        if (str != null && !str.isEmpty()) {
            return this.dsnHash != null ? new File(this.profilingTracesDirPath, this.dsnHash).getAbsolutePath() : this.profilingTracesDirPath;
        }
        String cacheDirPath = getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        return new File(cacheDirPath, "profiling_traces").getAbsolutePath();
    }

    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public m6 getProxy() {
        return this.proxy;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public String getRelease() {
        return this.release;
    }

    public z3 getReplayController() {
        return this.replayController;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public List<e1> getScopeObservers() {
        return this.observers;
    }

    public h1 getScopesStorageFactory() {
        return null;
    }

    public io.sentry.protocol.u getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSentryClientName() {
        return this.sentryClientName;
    }

    public l1 getSerializer() {
        return (l1) this.serializer.a();
    }

    public String getServerName() {
        return this.serverName;
    }

    public long getSessionFlushTimeoutMillis() {
        return this.sessionFlushTimeoutMillis;
    }

    public t6 getSessionReplay() {
        return this.sessionReplay;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    public m1 getSocketTagger() {
        return this.socketTagger;
    }

    public o1 getSpanFactory() {
        return this.spanFactory;
    }

    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public io.sentry.util.thread.a getThreadChecker() {
        return this.threadChecker;
    }

    public j1 getTimerExecutorService() {
        return this.timerExecutorService;
    }

    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        return list == null ? this.defaultTracePropagationTargets : list;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public o6 getTracesSampler() {
        return null;
    }

    public q1 getTransactionProfiler() {
        return this.transactionProfiler;
    }

    public r1 getTransportFactory() {
        return this.transportFactory;
    }

    public io.sentry.transport.h getTransportGate() {
        return this.transportGate;
    }

    public s1 getVersionDetector() {
        return this.versionDetector;
    }

    public final List<Object> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public boolean isCaptureOpenTelemetryEvents() {
        return this.captureOpenTelemetryEvents;
    }

    public boolean isContinuousProfilingEnabled() {
        Double d;
        return this.profilesSampleRate == null && (d = this.profileSessionSampleRate) != null && d.doubleValue() > 0.0d;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isEnableAppStartProfiling() {
        return (isProfilingEnabled() || isContinuousProfilingEnabled()) && this.enableAppStartProfiling;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    public boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public boolean isEnableCacheTracing() {
        return this.enableCacheTracing;
    }

    public boolean isEnableDatabaseTransactionTracing() {
        return this.enableDatabaseTransactionTracing;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    public boolean isEnableEventSizeLimiting() {
        return this.enableEventSizeLimiting;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public boolean isEnableLegacyProfiling() {
        return this.enableLegacyProfiling;
    }

    public boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public boolean isEnableQueueTracing() {
        return this.enableQueueTracing;
    }

    public boolean isEnableScopePersistence() {
        return this.enableScopePersistence;
    }

    public boolean isEnableScreenTracking() {
        return this.enableScreenTracking;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    public boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isForceInit() {
        return this.forceInit;
    }

    public Boolean isGlobalHubMode() {
        return this.globalHubMode;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public boolean isProfilingEnabled() {
        Double d = this.profilesSampleRate;
        return d != null && d.doubleValue() > 0.0d;
    }

    public boolean isPropagateTraceparent() {
        return this.propagateTraceparent;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public boolean isSendModules() {
        return this.sendModules;
    }

    public boolean isStartProfilerOnAppStart() {
        return this.startProfilerOnAppStart;
    }

    public boolean isStrictTraceContinuation() {
        return this.strictTraceContinuation;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    public boolean isTracingEnabled() {
        if (getTracesSampleRate() != null) {
            return true;
        }
        getTracesSampler();
        return false;
    }

    public void loadLazyFields() {
        getSerializer();
        retrieveParsedDsn();
        getEnvelopeReader();
        getDateProvider();
    }

    public void merge(h0 h0Var) {
        String str = h0Var.a;
        if (str != null) {
            setDsn(str);
        }
        String str2 = h0Var.b;
        if (str2 != null) {
            setEnvironment(str2);
        }
        String str3 = h0Var.c;
        if (str3 != null) {
            setRelease(str3);
        }
        String str4 = h0Var.d;
        if (str4 != null) {
            setDist(str4);
        }
        String str5 = h0Var.e;
        if (str5 != null) {
            setServerName(str5);
        }
        m6 m6Var = h0Var.n;
        if (m6Var != null) {
            setProxy(m6Var);
        }
        Boolean bool = h0Var.f;
        if (bool != null) {
            setEnableUncaughtExceptionHandler(bool.booleanValue());
        }
        Boolean bool2 = h0Var.y;
        if (bool2 != null) {
            setPrintUncaughtStackTrace(bool2.booleanValue());
        }
        Double d = h0Var.i;
        if (d != null) {
            setSampleRate(d);
        }
        Double d2 = h0Var.j;
        if (d2 != null) {
            setTracesSampleRate(d2);
        }
        Double d3 = h0Var.k;
        if (d3 != null) {
            setProfilesSampleRate(d3);
        }
        Boolean bool3 = h0Var.g;
        if (bool3 != null) {
            setDebug(bool3.booleanValue());
        }
        Boolean bool4 = h0Var.h;
        if (bool4 != null) {
            setEnableDeduplication(bool4.booleanValue());
        }
        Boolean bool5 = h0Var.z;
        if (bool5 != null) {
            setSendClientReports(bool5.booleanValue());
        }
        Boolean bool6 = h0Var.Q;
        if (bool6 != null) {
            setForceInit(bool6.booleanValue());
        }
        for (Map.Entry entry : new HashMap(h0Var.m).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        Iterator it = new ArrayList(h0Var.p).iterator();
        while (it.hasNext()) {
            addInAppInclude((String) it.next());
        }
        Iterator it2 = new ArrayList(h0Var.o).iterator();
        while (it2.hasNext()) {
            addInAppExclude((String) it2.next());
        }
        Iterator it3 = new HashSet(h0Var.w).iterator();
        while (it3.hasNext()) {
            addIgnoredExceptionForType((Class) it3.next());
        }
        if (h0Var.q != null) {
            setTracePropagationTargets(new ArrayList(h0Var.q));
        }
        Iterator it4 = new ArrayList(h0Var.r).iterator();
        while (it4.hasNext()) {
            addContextTag((String) it4.next());
        }
        String str6 = h0Var.s;
        if (str6 != null) {
            setProguardUuid(str6);
        }
        Long l = h0Var.t;
        if (l != null) {
            setIdleTimeout(l);
        }
        Long l2 = h0Var.u;
        if (l2 != null) {
            setShutdownTimeoutMillis(l2.longValue());
        }
        Long l3 = h0Var.v;
        if (l3 != null) {
            setSessionFlushTimeoutMillis(l3.longValue());
        }
        Iterator it5 = h0Var.A.iterator();
        while (it5.hasNext()) {
            addBundleId((String) it5.next());
        }
        Boolean bool7 = h0Var.B;
        if (bool7 != null) {
            setEnabled(bool7.booleanValue());
        }
        Boolean bool8 = h0Var.C;
        if (bool8 != null) {
            setEnablePrettySerializationOutput(bool8.booleanValue());
        }
        Boolean bool9 = h0Var.J;
        if (bool9 != null) {
            setSendModules(bool9.booleanValue());
        }
        if (h0Var.H != null) {
            setIgnoredCheckIns(new ArrayList(h0Var.H));
        }
        if (h0Var.I != null) {
            setIgnoredTransactions(new ArrayList(h0Var.I));
        }
        if (h0Var.x != null) {
            setIgnoredErrors(new ArrayList(h0Var.x));
        }
        Boolean bool10 = h0Var.L;
        if (bool10 != null) {
            setEnableBackpressureHandling(bool10.booleanValue());
        }
        Boolean bool11 = h0Var.M;
        if (bool11 != null) {
            setEnableDatabaseTransactionTracing(bool11.booleanValue());
        }
        Boolean bool12 = h0Var.N;
        if (bool12 != null) {
            setEnableCacheTracing(bool12.booleanValue());
        }
        Boolean bool13 = h0Var.O;
        if (bool13 != null) {
            setEnableQueueTracing(bool13.booleanValue());
        }
        n6 n6Var = h0Var.l;
        if (n6Var != null) {
            setMaxRequestBodySize(n6Var);
        }
        Boolean bool14 = h0Var.K;
        if (bool14 != null) {
            setSendDefaultPii(bool14.booleanValue());
        }
        Boolean bool15 = h0Var.R;
        if (bool15 != null) {
            setCaptureOpenTelemetryEvents(bool15.booleanValue());
        }
        Boolean bool16 = h0Var.D;
        if (bool16 != null) {
            setEnableSpotlight(bool16.booleanValue());
        }
        String str7 = h0Var.G;
        if (str7 != null) {
            setSpotlightConnectionUrl(str7);
        }
        Boolean bool17 = h0Var.P;
        if (bool17 != null) {
            setGlobalHubMode(bool17);
        }
        if (h0Var.X != null) {
            f6 cron = getCron();
            f6 f6Var = h0Var.X;
            if (cron == null) {
                setCron(f6Var);
            } else {
                if (f6Var.a != null) {
                    f6 cron2 = getCron();
                    f6Var = h0Var.X;
                    cron2.a = f6Var.a;
                }
                if (f6Var.b != null) {
                    f6 cron3 = getCron();
                    f6Var = h0Var.X;
                    cron3.b = f6Var.b;
                }
                if (f6Var.c != null) {
                    f6 cron4 = getCron();
                    f6Var = h0Var.X;
                    cron4.c = f6Var.c;
                }
                if (f6Var.d != null) {
                    f6 cron5 = getCron();
                    f6Var = h0Var.X;
                    cron5.d = f6Var.d;
                }
                if (f6Var.e != null) {
                    getCron().e = h0Var.X.e;
                }
            }
        }
        if (h0Var.E != null) {
            getLogs().a = h0Var.E.booleanValue();
        }
        if (h0Var.F != null) {
            getMetrics().a = h0Var.F.booleanValue();
        }
        Double d4 = h0Var.S;
        if (d4 != null) {
            setProfileSessionSampleRate(d4);
        }
        String str8 = h0Var.T;
        if (str8 != null) {
            setProfilingTracesDirPath(str8);
        }
        u3 u3Var = h0Var.U;
        if (u3Var != null) {
            setProfileLifecycle(u3Var);
        }
        Boolean bool18 = h0Var.V;
        if (bool18 != null) {
            setStrictTraceContinuation(bool18.booleanValue());
        }
        String str9 = h0Var.W;
        if (str9 != null) {
            setOrgId(str9);
        }
    }

    public c0 retrieveParsedDsn() {
        return (c0) this.parsedDsn.a();
    }

    public void setAppStartExtender(q0 q0Var) {
        if (q0Var == null) {
            q0Var = q2.b;
        }
        this.appStartExtender = q0Var;
    }

    public void setAttachServerName(boolean z) {
        this.attachServerName = z;
    }

    public void setAttachStacktrace(boolean z) {
        this.attachStacktrace = z;
    }

    public void setAttachThreads(boolean z) {
        this.attachThreads = z;
    }

    public void setBackpressureMonitor(io.sentry.backpressure.b bVar) {
        this.backpressureMonitor = bVar;
    }

    public void setBeforeBreadcrumb(a6 a6Var) {
        this.beforeBreadcrumb = a6Var;
    }

    public void setCacheDirPath(String str) {
        this.cacheDirPath = str;
    }

    public void setCaptureOpenTelemetryEvents(boolean z) {
        this.captureOpenTelemetryEvents = z;
    }

    public void setCompositePerformanceCollector(n nVar) {
        this.compositePerformanceCollector = nVar;
    }

    public void setConnectionStatusProvider(t0 t0Var) {
        this.connectionStatusProvider = t0Var;
    }

    public void setConnectionTimeoutMillis(int i) {
        this.connectionTimeoutMillis = i;
    }

    public void setContinuousProfiler(u0 u0Var) {
        if (this.continuousProfiler != t2.b || u0Var == null) {
            return;
        }
        this.continuousProfiler = u0Var;
    }

    public void setCron(f6 f6Var) {
        this.cron = f6Var;
    }

    public void setDateProvider(x4 x4Var) {
        this.dateProvider.b(x4Var);
    }

    public void setDeadlineTimeout(long j) {
        this.deadlineTimeout = j;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setDebugMetaLoader(io.sentry.internal.debugmeta.a aVar) {
        if (aVar == null) {
            aVar = io.sentry.internal.debugmeta.b.b;
        }
        this.debugMetaLoader = aVar;
    }

    public void setDefaultScopeType(j4 j4Var) {
        this.defaultScopeType = j4Var;
    }

    public void setDiagnosticLevel(p5 p5Var) {
        if (p5Var == null) {
            p5Var = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = p5Var;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public void setDistinctId(String str) {
        this.distinctId = str;
    }

    public void setDistribution(g6 g6Var) {
        if (g6Var == null) {
            g6Var = new g6();
        }
        this.distribution = g6Var;
    }

    public void setDistributionController(v0 v0Var) {
        if (v0Var == null) {
            v0Var = q2.f;
        }
        this.distributionController = v0Var;
    }

    public void setDsn(String str) {
        String string = null;
        this.dsn = str != null ? str.trim() : null;
        io.sentry.util.f fVar = this.parsedDsn;
        io.sentry.util.a aVar = fVar.c;
        aVar.g();
        try {
            fVar.a = null;
            aVar.close();
            String str2 = this.dsn;
            ILogger iLogger = this.logger;
            Charset charset = io.sentry.util.p.a;
            if (str2 != null && !str2.isEmpty()) {
                try {
                    string = new BigInteger(1, MessageDigest.getInstance("SHA-1").digest(str2.getBytes(io.sentry.util.p.a))).toString(16);
                } catch (NoSuchAlgorithmException e) {
                    iLogger.d(p5.INFO, "SHA-1 isn't available to calculate the hash.", e);
                } catch (Throwable th) {
                    iLogger.h(p5.INFO, "string: %s could not calculate its hash", th, str2);
                }
            }
            this.dsnHash = string;
        } catch (Throwable th2) {
            try {
                aVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public void setEnableAppStartProfiling(boolean z) {
        this.enableAppStartProfiling = z;
    }

    public void setEnableAutoSessionTracking(boolean z) {
        this.enableAutoSessionTracking = z;
    }

    public void setEnableBackpressureHandling(boolean z) {
        this.enableBackpressureHandling = z;
    }

    public void setEnableCacheTracing(boolean z) {
        this.enableCacheTracing = z;
    }

    public void setEnableDatabaseTransactionTracing(boolean z) {
        this.enableDatabaseTransactionTracing = z;
    }

    public void setEnableDeduplication(boolean z) {
        this.enableDeduplication = z;
    }

    public void setEnableEventSizeLimiting(boolean z) {
        this.enableEventSizeLimiting = z;
    }

    public void setEnableExternalConfiguration(boolean z) {
        this.enableExternalConfiguration = z;
    }

    public void setEnableLegacyProfiling(boolean z) {
        this.enableLegacyProfiling = z;
    }

    public void setEnablePrettySerializationOutput(boolean z) {
        this.enablePrettySerializationOutput = z;
    }

    public void setEnableQueueTracing(boolean z) {
        this.enableQueueTracing = z;
    }

    public void setEnableScopePersistence(boolean z) {
        this.enableScopePersistence = z;
    }

    public void setEnableScreenTracking(boolean z) {
        this.enableScreenTracking = z;
    }

    public void setEnableShutdownHook(boolean z) {
        this.enableShutdownHook = z;
    }

    public void setEnableSpotlight(boolean z) {
        this.enableSpotlight = z;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z) {
        this.enableTimeToFullDisplayTracing = z;
    }

    public void setEnableUncaughtExceptionHandler(boolean z) {
        this.enableUncaughtExceptionHandler = z;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z) {
        this.enableUserInteractionBreadcrumbs = z;
    }

    public void setEnableUserInteractionTracing(boolean z) {
        this.enableUserInteractionTracing = z;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setEnvelopeDiskCache(io.sentry.cache.c cVar) {
        if (cVar == null) {
            cVar = io.sentry.transport.i.b;
        }
        this.envelopeDiskCache = cVar;
    }

    public void setEnvelopeReader(w0 w0Var) {
        io.sentry.util.f fVar = this.envelopeReader;
        if (w0Var == null) {
            w0Var = u2.a;
        }
        fVar.b(w0Var);
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public void setExecutorService(j1 j1Var) {
        if (j1Var != null) {
            this.executorService = j1Var;
        }
    }

    public void setFatalLogger(ILogger iLogger) {
        if (iLogger == null) {
            iLogger = w2.b;
        }
        this.fatalLogger = iLogger;
    }

    public void setFeedbackOptions(k5 k5Var) {
        this.feedbackOptions = k5Var;
    }

    public void setFlushTimeoutMillis(long j) {
        this.flushTimeoutMillis = j;
    }

    public void setForceInit(boolean z) {
        this.forceInit = z;
    }

    public void setFullyDisplayedReporter(k0 k0Var) {
        this.fullyDisplayedReporter = k0Var;
    }

    public void setGestureTargetLocators(List<io.sentry.android.core.internal.gestures.a> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public void setGlobalHubMode(Boolean bool) {
        this.globalHubMode = bool;
    }

    public void setIdleTimeout(Long l) {
        this.idleTimeout = l;
    }

    public void setIgnoredCheckIns(List<String> list) {
        if (list == null) {
            this.ignoredCheckIns = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredCheckIns = arrayList;
    }

    public void setIgnoredErrors(List<String> list) {
        if (list == null) {
            this.ignoredErrors = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredErrors = arrayList;
    }

    public void setIgnoredSpanOrigins(List<String> list) {
        if (list == null) {
            this.ignoredSpanOrigins = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredSpanOrigins = arrayList;
    }

    public void setIgnoredTransactions(List<String> list) {
        if (list == null) {
            this.ignoredTransactions = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str != null && !str.isEmpty()) {
                arrayList.add(new j0(str));
            }
        }
        this.ignoredTransactions = arrayList;
    }

    public void setInitPriority(t1 t1Var) {
        this.initPriority = t1Var;
    }

    @Deprecated
    public void setInstrumenter(u1 u1Var) {
        this.instrumenter = u1Var;
    }

    public void setLogger(ILogger iLogger) {
        this.logger = iLogger == null ? w2.b : new io.sentry.internal.debugmeta.c(1, this, iLogger);
    }

    public void setLogs(h6 h6Var) {
        this.logs = h6Var;
    }

    public void setMaxAttachmentSize(long j) {
        this.maxAttachmentSize = j;
    }

    public void setMaxBreadcrumbs(int i) {
        this.maxBreadcrumbs = i;
    }

    public void setMaxCacheItems(int i) {
        this.maxCacheItems = i;
    }

    public void setMaxDepth(int i) {
        this.maxDepth = i;
    }

    public void setMaxFeatureFlags(int i) {
        this.maxFeatureFlags = i;
    }

    public void setMaxQueueSize(int i) {
        if (i > 0) {
            this.maxQueueSize = i;
        }
    }

    public void setMaxRequestBodySize(n6 n6Var) {
        this.maxRequestBodySize = n6Var;
    }

    public void setMaxSpans(int i) {
        this.maxSpans = i;
    }

    public void setMaxTraceFileSize(long j) {
        this.maxTraceFileSize = j;
    }

    public void setMetrics(i6 i6Var) {
        this.metrics = i6Var;
    }

    public void setModulesLoader(io.sentry.internal.modules.a aVar) {
        if (aVar == null) {
            aVar = io.sentry.internal.modules.e.a;
        }
        this.modulesLoader = aVar;
    }

    public void setOpenTelemetryMode(y5 y5Var) {
        this.openTelemetryMode = y5Var;
    }

    public void setOrgId(String str) {
        this.orgId = str;
    }

    public void setPrintUncaughtStackTrace(boolean z) {
        this.printUncaughtStackTrace = z;
    }

    public void setProfileLifecycle(u3 u3Var) {
        this.profileLifecycle = u3Var;
        if (u3Var != u3.TRACE || isTracingEnabled()) {
            return;
        }
        this.logger.h(p5.WARNING, "Profiling lifecycle is set to TRACE but tracing is disabled. Profiling will not be started automatically.", new Object[0]);
    }

    public void setProfileSessionSampleRate(Double d) {
        if (io.sentry.util.b.m(d, true)) {
            this.profileSessionSampleRate = d;
        } else {
            st4.p("The value ", d, " is not valid. Use values between 0.0 and 1.0.");
        }
    }

    public void setProfilerConverter(c1 c1Var) {
        this.profilerConverter = c1Var;
    }

    public void setProfilesSampleRate(Double d) {
        if (io.sentry.util.b.m(d, true)) {
            this.profilesSampleRate = d;
        } else {
            st4.p("The value ", d, " is not valid. Use null to disable or values between 0.0 and 1.0.");
        }
    }

    public void setProfilingTracesDirPath(String str) {
        this.profilingTracesDirPath = str;
    }

    public void setProfilingTracesHz(int i) {
        this.profilingTracesHz = i;
    }

    public void setProguardUuid(String str) {
        this.proguardUuid = str;
    }

    public void setPropagateTraceparent(boolean z) {
        this.propagateTraceparent = z;
    }

    public void setProxy(m6 m6Var) {
        this.proxy = m6Var;
    }

    public void setReadTimeoutMillis(int i) {
        this.readTimeoutMillis = i;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public void setReplayController(z3 z3Var) {
        if (z3Var == null) {
            z3Var = q2.A;
        }
        this.replayController = z3Var;
    }

    public void setSampleRate(Double d) {
        if (io.sentry.util.b.m(d, true)) {
            this.sampleRate = d;
        } else {
            st4.p("The value ", d, " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
        }
    }

    public void setSdkVersion(io.sentry.protocol.u uVar) {
        io.sentry.protocol.u uVar2 = getSessionReplay().l;
        io.sentry.protocol.u uVar3 = this.sdkVersion;
        if (uVar3 != null && uVar2 != null && uVar3.equals(uVar2)) {
            getSessionReplay().l = uVar;
        }
        this.sdkVersion = uVar;
    }

    public void setSendClientReports(boolean z) {
        this.sendClientReports = z;
        if (z) {
            this.clientReportRecorder = new io.sentry.internal.debugmeta.c(this);
        } else {
            this.clientReportRecorder = new io.sentry.util.g();
        }
    }

    public void setSendDefaultPii(boolean z) {
        this.sendDefaultPii = z;
    }

    public void setSendModules(boolean z) {
        this.sendModules = z;
    }

    public void setSentryClientName(String str) {
        this.sentryClientName = str;
    }

    public void setSerializer(l1 l1Var) {
        io.sentry.util.f fVar = this.serializer;
        if (l1Var == null) {
            l1Var = f3.a;
        }
        fVar.b(l1Var);
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public void setSessionFlushTimeoutMillis(long j) {
        this.sessionFlushTimeoutMillis = j;
    }

    public void setSessionReplay(t6 t6Var) {
        this.sessionReplay = t6Var;
    }

    public void setSessionTrackingIntervalMillis(long j) {
        this.sessionTrackingIntervalMillis = j;
    }

    public void setShutdownTimeoutMillis(long j) {
        this.shutdownTimeoutMillis = j;
    }

    public void setSocketTagger(m1 m1Var) {
        if (m1Var == null) {
            m1Var = g3.b;
        }
        this.socketTagger = m1Var;
    }

    public void setSpanFactory(o1 o1Var) {
        this.spanFactory = o1Var;
    }

    public void setSpotlightConnectionUrl(String str) {
        this.spotlightConnectionUrl = str;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setStartProfilerOnAppStart(boolean z) {
        this.startProfilerOnAppStart = z;
    }

    public void setStrictTraceContinuation(boolean z) {
        this.strictTraceContinuation = z;
    }

    public void setTag(String str, String str2) {
        if (str == null) {
            return;
        }
        Map<String, String> map = this.tags;
        if (str2 == null) {
            map.remove(str);
        } else {
            map.put(str, str2);
        }
    }

    public void setThreadChecker(io.sentry.util.thread.a aVar) {
        this.threadChecker = aVar;
    }

    public void setTimerExecutorService(j1 j1Var) {
        if (j1Var != null) {
            this.timerExecutorService = j1Var;
        }
    }

    public void setTraceOptionsRequests(boolean z) {
        this.traceOptionsRequests = z;
    }

    public void setTracePropagationTargets(List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.isEmpty()) {
                arrayList.add(str);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    @Deprecated
    public void setTraceSampling(boolean z) {
        this.traceSampling = z;
    }

    public void setTracesSampleRate(Double d) {
        if (io.sentry.util.b.m(d, true)) {
            this.tracesSampleRate = d;
        } else {
            st4.p("The value ", d, " is not valid. Use null to disable or values between 0.0 and 1.0.");
        }
    }

    public void setTransactionProfiler(q1 q1Var) {
        if (this.transactionProfiler != q2.X || q1Var == null) {
            return;
        }
        this.transactionProfiler = q1Var;
    }

    public void setTransportFactory(r1 r1Var) {
        if (r1Var == null) {
            r1Var = k3.b;
        }
        this.transportFactory = r1Var;
    }

    public void setTransportGate(io.sentry.transport.h hVar) {
        if (hVar == null) {
            hVar = io.sentry.transport.k.b;
        }
        this.transportGate = hVar;
    }

    public void setVersionDetector(s1 s1Var) {
        this.versionDetector = s1Var;
    }

    public void setViewHierarchyExporters(List<Object> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll(list);
    }

    public void setBeforeEnvelopeCallback(b6 b6Var) {
    }

    public void setBeforeSend(c6 c6Var) {
    }

    public void setBeforeSendFeedback(c6 c6Var) {
    }

    public void setBeforeSendReplay(d6 d6Var) {
    }

    public void setBeforeSendTransaction(e6 e6Var) {
    }

    public void setOnDiscard(j6 j6Var) {
    }

    public void setOnOversizedEvent(k6 k6Var) {
    }

    public void setProfilesSampler(l6 l6Var) {
    }

    public void setScopesStorageFactory(h1 h1Var) {
    }

    public void setTracesSampler(o6 o6Var) {
    }
}
