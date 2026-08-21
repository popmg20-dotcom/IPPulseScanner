package io.sentry;

import io.sentry.android.core.SentryAndroidOptions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o4 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ SentryAndroidOptions f;

    public /* synthetic */ o4(SentryAndroidOptions sentryAndroidOptions, int i) {
        this.b = i;
        this.f = sentryAndroidOptions;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        SentryAndroidOptions sentryAndroidOptions = this.f;
        switch (i) {
            case 0:
                sentryAndroidOptions.loadLazyFields();
                return;
            case 1:
                String cacheDirPathWithoutDsn = sentryAndroidOptions.getCacheDirPathWithoutDsn();
                if (cacheDirPathWithoutDsn != null) {
                    File file = new File(cacheDirPathWithoutDsn);
                    File file2 = new File(file, "app_start_profiling_config");
                    try {
                        io.sentry.util.b.g(file2);
                        if (sentryAndroidOptions.isEnableAppStartProfiling() || sentryAndroidOptions.isStartProfilerOnAppStart()) {
                            if (!sentryAndroidOptions.isStartProfilerOnAppStart() && !sentryAndroidOptions.isTracingEnabled()) {
                                sentryAndroidOptions.getLogger().h(p5.INFO, "Tracing is disabled and app start profiling will not start.", new Object[0]);
                                return;
                            }
                            if (!io.sentry.util.b.e(file)) {
                                sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to create cache dir %s", cacheDirPathWithoutDsn);
                                return;
                            }
                            if (file2.createNewFile()) {
                                q4 q4Var = new q4(sentryAndroidOptions, sentryAndroidOptions.isEnableAppStartProfiling() ? sentryAndroidOptions.getInternalTracesSampler().a(new m(new j7("app.launch", io.sentry.protocol.i0.CUSTOM, "profile", null), Double.valueOf(io.sentry.util.n.a().c()))) : new x3(Boolean.FALSE, (Double) null));
                                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                try {
                                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, p4.e));
                                    try {
                                        sentryAndroidOptions.getSerializer().a(q4Var, bufferedWriter);
                                        bufferedWriter.close();
                                        fileOutputStream.close();
                                        return;
                                    } finally {
                                        try {
                                            break;
                                        } catch (Throwable th) {
                                        }
                                    }
                                } finally {
                                    try {
                                        break;
                                    } catch (Throwable th2) {
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        sentryAndroidOptions.getLogger().d(p5.ERROR, "Unable to create app start profiling config file. ", th3);
                        return;
                    }
                }
                return;
            case 2:
                for (z0 z0Var : sentryAndroidOptions.getOptionsObservers()) {
                    z0Var.g(sentryAndroidOptions.getRelease());
                    z0Var.f(sentryAndroidOptions.getProguardUuid());
                    z0Var.b(sentryAndroidOptions.getSdkVersion());
                    z0Var.c(sentryAndroidOptions.getDist());
                    z0Var.e(sentryAndroidOptions.getEnvironment());
                    z0Var.a(sentryAndroidOptions.getTags());
                    z0Var.d(sentryAndroidOptions.getSessionReplay().e);
                }
                io.sentry.cache.e eVarFindPersistingScopeObserver = sentryAndroidOptions.findPersistingScopeObserver();
                if (eVarFindPersistingScopeObserver != null) {
                    try {
                        ((io.sentry.cache.tape.f) eVarFindPersistingScopeObserver.b.a()).clear();
                        break;
                    } catch (IOException e) {
                        eVarFindPersistingScopeObserver.a.getLogger().d(p5.ERROR, "Failed to clear breadcrumbs from file queue", e);
                    }
                    eVarFindPersistingScopeObserver.a("user.json");
                    eVarFindPersistingScopeObserver.a("level.json");
                    eVarFindPersistingScopeObserver.a("request.json");
                    eVarFindPersistingScopeObserver.a("fingerprint.json");
                    eVarFindPersistingScopeObserver.a("contexts.json");
                    eVarFindPersistingScopeObserver.a("extras.json");
                    eVarFindPersistingScopeObserver.a("tags.json");
                    eVarFindPersistingScopeObserver.a("trace.json");
                    eVarFindPersistingScopeObserver.a("transaction.json");
                    return;
                }
                return;
            default:
                p4.b(sentryAndroidOptions.getFlushTimeoutMillis());
                return;
        }
    }
}
