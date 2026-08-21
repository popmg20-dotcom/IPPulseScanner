package io.sentry.android.core;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import defpackage.l84;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.r3;
import io.sentry.s3;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p1 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ p1(SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration, io.sentry.f1 f1Var, SentryAndroidOptions sentryAndroidOptions) {
        this.b = 4;
        this.f = systemEventsBreadcrumbsIntegration;
        this.A = f1Var;
        this.z = sentryAndroidOptions;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                SendCachedEnvelopeIntegration sendCachedEnvelopeIntegration = (SendCachedEnvelopeIntegration) this.f;
                SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.z;
                io.sentry.f1 f1Var = (io.sentry.f1) this.A;
                try {
                    if (sendCachedEnvelopeIntegration.z0.get()) {
                        sentryAndroidOptions.getLogger().h(p5.INFO, "SendCachedEnvelopeIntegration, not trying to send after closing.", new Object[0]);
                        return;
                    }
                    if (!sendCachedEnvelopeIntegration.y0.getAndSet(true)) {
                        io.sentry.t0 connectionStatusProvider = sentryAndroidOptions.getConnectionStatusProvider();
                        sendCachedEnvelopeIntegration.A = connectionStatusProvider;
                        connectionStatusProvider.h0(sendCachedEnvelopeIntegration);
                        sendCachedEnvelopeIntegration.Z = sendCachedEnvelopeIntegration.b.a(f1Var, sentryAndroidOptions);
                    }
                    io.sentry.t0 t0Var = sendCachedEnvelopeIntegration.A;
                    if (t0Var != null && t0Var.d0() == io.sentry.r0.DISCONNECTED) {
                        sentryAndroidOptions.getLogger().h(p5.INFO, "SendCachedEnvelopeIntegration, no connection.", new Object[0]);
                        return;
                    }
                    io.sentry.android.core.internal.tombstone.c cVarD = f1Var.d();
                    if (cVarD != null && cVarD.n(io.sentry.o.All)) {
                        sentryAndroidOptions.getLogger().h(p5.INFO, "SendCachedEnvelopeIntegration, rate limiting active.", new Object[0]);
                        return;
                    }
                    l84 l84Var = sendCachedEnvelopeIntegration.Z;
                    if (l84Var == null) {
                        sentryAndroidOptions.getLogger().h(p5.ERROR, "SendCachedEnvelopeIntegration factory is null.", new Object[0]);
                        return;
                    } else {
                        l84Var.a();
                        return;
                    }
                } catch (Throwable th) {
                    sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed trying to send cached events.", th);
                    return;
                }
            case 1:
                d dVar = (d) this.f;
                Runnable runnable = (Runnable) this.z;
                String str = (String) this.A;
                try {
                    runnable.run();
                    return;
                } catch (Throwable unused) {
                    if (str != null) {
                        ((SentryAndroidOptions) dVar.c).getLogger().h(p5.WARNING, "Failed to execute ".concat(str), new Object[0]);
                        return;
                    }
                    return;
                }
            case 2:
                i iVar = (i) this.f;
                p6 p6Var = (p6) this.z;
                io.sentry.f1 f1Var2 = (io.sentry.f1) this.A;
                ArrayList<r3> arrayList = iVar.C0;
                if (iVar.F0.get()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                io.sentry.util.a aVar = iVar.M0;
                aVar.g();
                try {
                    for (r3 r3Var : arrayList) {
                        s3 s3Var = new s3(r3Var.a, r3Var.b, r3Var.d, r3Var.c, Double.valueOf(r3Var.e), p6Var);
                        s3Var.B0 = r3Var.f;
                        arrayList2.add(s3Var);
                    }
                    arrayList.clear();
                    aVar.close();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        f1Var2.h((s3) it.next());
                    }
                    return;
                } catch (Throwable th2) {
                    try {
                        aVar.close();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                }
            case 3:
                EnvelopeFileObserverIntegration envelopeFileObserverIntegration = (EnvelopeFileObserverIntegration) this.f;
                SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) this.z;
                String str2 = (String) this.A;
                io.sentry.util.a aVar2 = envelopeFileObserverIntegration.A;
                aVar2.g();
                try {
                    if (!envelopeFileObserverIntegration.z) {
                        envelopeFileObserverIntegration.g(sentryAndroidOptions2, str2);
                        break;
                    }
                    aVar2.close();
                    return;
                } finally {
                }
            default:
                SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration = (SystemEventsBreadcrumbsIntegration) this.f;
                io.sentry.f1 f1Var3 = (io.sentry.f1) this.A;
                SentryAndroidOptions sentryAndroidOptions3 = (SentryAndroidOptions) this.z;
                io.sentry.util.a aVar3 = systemEventsBreadcrumbsIntegration.B0;
                aVar3.g();
                try {
                    if (!systemEventsBreadcrumbsIntegration.Y && !systemEventsBreadcrumbsIntegration.Z && systemEventsBreadcrumbsIntegration.f == null) {
                        systemEventsBreadcrumbsIntegration.f = new e2(systemEventsBreadcrumbsIntegration, f1Var3, sentryAndroidOptions3);
                        if (systemEventsBreadcrumbsIntegration.y0 == null) {
                            systemEventsBreadcrumbsIntegration.y0 = new IntentFilter();
                            for (String str3 : systemEventsBreadcrumbsIntegration.X) {
                                systemEventsBreadcrumbsIntegration.y0.addAction(str3);
                            }
                        }
                        if (systemEventsBreadcrumbsIntegration.z0 == null) {
                            systemEventsBreadcrumbsIntegration.z0 = new HandlerThread("SystemEventsReceiver", 10);
                            systemEventsBreadcrumbsIntegration.z0.start();
                        }
                        try {
                            p0.i(systemEventsBreadcrumbsIntegration.b, sentryAndroidOptions3, systemEventsBreadcrumbsIntegration.f, systemEventsBreadcrumbsIntegration.y0, new Handler(systemEventsBreadcrumbsIntegration.z0.getLooper()));
                            if (!systemEventsBreadcrumbsIntegration.A0.getAndSet(true)) {
                                sentryAndroidOptions3.getLogger().h(p5.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
                                io.sentry.util.b.a("SystemEventsBreadcrumbs");
                            }
                        } catch (Throwable th4) {
                            sentryAndroidOptions3.setEnableSystemEventBreadcrumbs(false);
                            sentryAndroidOptions3.getLogger().d(p5.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", th4);
                        }
                        break;
                    }
                    aVar3.close();
                    return;
                } catch (Throwable th5) {
                    try {
                        aVar3.close();
                        throw th5;
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                        throw th5;
                    }
                }
        }
    }

    public /* synthetic */ p1(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }
}
