package io.sentry.transport;

import com.tencent.mars.xlog.Xlog;
import io.sentry.ILogger;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.d5;
import io.sentry.l0;
import io.sentry.l7;
import io.sentry.n0;
import io.sentry.p5;
import io.sentry.w4;
import io.sentry.x4;
import io.sentry.y;
import io.sentry.y4;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements g {
    public final io.sentry.android.core.internal.tombstone.c A;
    public final h X;
    public final e Y;
    public volatile b Z;
    public final n b;
    public final io.sentry.cache.c f;
    public final SentryAndroidOptions z;

    /* JADX WARN: Type inference failed for: r3v0, types: [io.sentry.transport.a] */
    public c(SentryAndroidOptions sentryAndroidOptions, io.sentry.android.core.internal.tombstone.c cVar, h hVar, io.sentry.internal.debugmeta.c cVar2) {
        int maxQueueSize = sentryAndroidOptions.getMaxQueueSize();
        final io.sentry.cache.c envelopeDiskCache = sentryAndroidOptions.getEnvelopeDiskCache();
        final ILogger logger = sentryAndroidOptions.getLogger();
        x4 dateProvider = sentryAndroidOptions.getDateProvider();
        n nVar = new n(maxQueueSize, new n0(4), new RejectedExecutionHandler() { // from class: io.sentry.transport.a
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                if (runnable instanceof b) {
                    b bVar = (b) runnable;
                    l0 l0Var = bVar.f;
                    if (!io.sentry.util.b.j(l0Var, io.sentry.hints.d.class)) {
                        envelopeDiskCache.n(bVar.b, l0Var);
                    }
                    Object objB = l0Var.b("sentry:typeCheckHint");
                    if (io.sentry.hints.k.class.isInstance(l0Var.b("sentry:typeCheckHint")) && objB != null) {
                        ((io.sentry.hints.k) objB).b(false);
                    }
                    Object objB2 = l0Var.b("sentry:typeCheckHint");
                    if (io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) && objB2 != null) {
                        ((io.sentry.hints.h) objB2).c(true);
                    }
                    logger.h(p5.WARNING, "Envelope rejected", new Object[0]);
                }
            }
        }, logger, dateProvider);
        e eVar = new e(sentryAndroidOptions, cVar2, cVar);
        this.Z = null;
        this.b = nVar;
        io.sentry.cache.c envelopeDiskCache2 = sentryAndroidOptions.getEnvelopeDiskCache();
        io.sentry.util.b.r(envelopeDiskCache2, "envelopeCache is required");
        this.f = envelopeDiskCache2;
        this.z = sentryAndroidOptions;
        this.A = cVar;
        io.sentry.util.b.r(hVar, "transportGate is required");
        this.X = hVar;
        this.Y = eVar;
    }

    @Override // io.sentry.transport.g
    public final void a(boolean z) throws IOException {
        this.A.close();
        this.b.shutdown();
        this.z.getLogger().h(p5.DEBUG, "Shutting down", new Object[0]);
        if (z) {
            return;
        }
        try {
            long flushTimeoutMillis = this.z.getFlushTimeoutMillis();
            if (this.b.awaitTermination(flushTimeoutMillis, TimeUnit.MILLISECONDS)) {
                return;
            }
            this.z.getLogger().h(p5.WARNING, "Failed to shutdown the async connection async sender  within " + flushTimeoutMillis + " ms. Trying to force it now.", new Object[0]);
            this.b.shutdownNow();
            if (this.Z != null) {
                this.b.getRejectedExecutionHandler().rejectedExecution(this.Z, this.b);
            }
        } catch (InterruptedException unused) {
            this.z.getLogger().h(p5.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }

    @Override // io.sentry.transport.g
    public final void b(long j) {
        n nVar = this.b;
        try {
            ((p) nVar.X.f).tryAcquireSharedNanos(1, TimeUnit.MILLISECONDS.toNanos(j));
        } catch (InterruptedException e) {
            nVar.z.d(p5.ERROR, "Failed to wait till idle", e);
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a(false);
    }

    @Override // io.sentry.transport.g
    public final io.sentry.android.core.internal.tombstone.c d() {
        return this.A;
    }

    @Override // io.sentry.transport.g
    public final boolean e() {
        boolean z;
        Date date = new Date(System.currentTimeMillis());
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.A.z;
        Iterator it = concurrentHashMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Date date2 = (Date) concurrentHashMap.get((io.sentry.o) it.next());
            if (date2 != null && !date.after(date2)) {
                z = true;
                break;
            }
        }
        n nVar = this.b;
        w4 w4Var = nVar.f;
        return (z || (w4Var != null && (nVar.A.a().b(w4Var) > 2000000000L ? 1 : (nVar.A.a().b(w4Var) == 2000000000L ? 0 : -1)) < 0)) ? false : true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // io.sentry.transport.g
    public final void k0(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        io.sentry.cache.c cVar2;
        boolean z;
        io.sentry.internal.debugmeta.c cVarJ;
        char c;
        byte b;
        List listSingletonList;
        Iterable<d5> iterable = (Iterable) cVar.z;
        boolean zJ = io.sentry.util.b.j(l0Var, io.sentry.hints.d.class);
        SentryAndroidOptions sentryAndroidOptions = this.z;
        io.sentry.cache.c cVar3 = this.f;
        char c2 = 0;
        if (zJ) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Captured Envelope is already cached", new Object[0]);
            cVar2 = i.b;
            z = true;
        } else {
            cVar2 = cVar3;
            z = false;
        }
        io.sentry.android.core.internal.tombstone.c cVar4 = this.A;
        SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions) cVar4.f;
        ArrayList arrayList = null;
        for (d5 d5Var : iterable) {
            String itemType = d5Var.a.X.getItemType();
            itemType.getClass();
            char c3 = c2;
            byte b2 = -1;
            switch (itemType.hashCode()) {
                case -1963501277:
                    c = 1;
                    if (itemType.equals("attachment")) {
                        b2 = c3;
                    }
                    break;
                case -1639516637:
                    c = 1;
                    if (itemType.equals("replay_video")) {
                        b2 = 1;
                    }
                    break;
                case -729715625:
                    c = 1;
                    if (itemType.equals("profile_chunk")) {
                        b2 = 2;
                    }
                    break;
                case -309425751:
                    c = 1;
                    if (itemType.equals("profile")) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case -191501435:
                    c = 1;
                    if (itemType.equals("feedback")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case 107332:
                    c = 1;
                    if (itemType.equals("log")) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3536714:
                    c = 1;
                    if (itemType.equals("span")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 96891546:
                    c = 1;
                    if (itemType.equals("event")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 229505514:
                    c = 1;
                    if (itemType.equals("trace_metric")) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 1536888764:
                    c = 1;
                    if (itemType.equals("check_in")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 1984987798:
                    c = 1;
                    if (itemType.equals("session")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 2141246174:
                    c = 1;
                    if (itemType.equals("transaction")) {
                        b = 11;
                        b2 = b;
                    }
                    break;
                default:
                    c = 1;
                    break;
            }
            switch (b2) {
                case 0:
                    listSingletonList = Collections.singletonList(io.sentry.o.Attachment);
                    break;
                case 1:
                    listSingletonList = Collections.singletonList(io.sentry.o.Replay);
                    break;
                case 2:
                    io.sentry.o[] oVarArr = new io.sentry.o[2];
                    oVarArr[c3] = io.sentry.o.ProfileChunkUi;
                    oVarArr[c] = io.sentry.o.ProfileChunk;
                    listSingletonList = Arrays.asList(oVarArr);
                    break;
                case 3:
                    listSingletonList = Collections.singletonList(io.sentry.o.Profile);
                    break;
                case 4:
                    listSingletonList = Collections.singletonList(io.sentry.o.Feedback);
                    break;
                case 5:
                    io.sentry.o[] oVarArr2 = new io.sentry.o[2];
                    oVarArr2[c3] = io.sentry.o.LogItem;
                    oVarArr2[c] = io.sentry.o.LogByte;
                    listSingletonList = Arrays.asList(oVarArr2);
                    break;
                case 6:
                    listSingletonList = Collections.singletonList(io.sentry.o.Span);
                    break;
                case 7:
                    listSingletonList = Collections.singletonList(io.sentry.o.Error);
                    break;
                case 8:
                    io.sentry.o[] oVarArr3 = new io.sentry.o[2];
                    oVarArr3[c3] = io.sentry.o.TraceMetric;
                    oVarArr3[c] = io.sentry.o.TraceMetricByte;
                    listSingletonList = Arrays.asList(oVarArr3);
                    break;
                case Xlog.COMPRESS_LEVEL9 /* 9 */:
                    listSingletonList = Collections.singletonList(io.sentry.o.Monitor);
                    break;
                case 10:
                    listSingletonList = Collections.singletonList(io.sentry.o.Session);
                    break;
                case 11:
                    listSingletonList = Collections.singletonList(io.sentry.o.Transaction);
                    break;
                default:
                    listSingletonList = Collections.singletonList(io.sentry.o.Unknown);
                    break;
            }
            Iterator it = listSingletonList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (cVar4.n((io.sentry.o) it.next())) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(d5Var);
                    sentryAndroidOptions2.getClientReportRecorder().g(io.sentry.clientreport.d.RATELIMIT_BACKOFF, d5Var);
                }
            }
            c2 = c3;
        }
        int i = c2;
        if (arrayList != null) {
            ILogger logger = sentryAndroidOptions2.getLogger();
            p5 p5Var = p5.WARNING;
            Object[] objArr = new Object[1];
            objArr[i] = Integer.valueOf(arrayList.size());
            logger.h(p5Var, "%d envelope items will be dropped due rate limiting.", objArr);
            ArrayList arrayList2 = new ArrayList();
            for (d5 d5Var2 : iterable) {
                if (!arrayList.contains(d5Var2)) {
                    arrayList2.add(d5Var2);
                }
            }
            if (arrayList2.isEmpty()) {
                sentryAndroidOptions2.getLogger().h(p5.WARNING, "Envelope discarded due all items rate limited.", new Object[i]);
                Object objB = l0Var.b("sentry:typeCheckHint");
                if (io.sentry.hints.k.class.isInstance(l0Var.b("sentry:typeCheckHint")) && objB != null) {
                    ((io.sentry.hints.k) objB).b(i);
                }
                Object objB2 = l0Var.b("sentry:typeCheckHint");
                if (io.sentry.hints.h.class.isInstance(l0Var.b("sentry:typeCheckHint")) && objB2 != null) {
                    ((io.sentry.hints.h) objB2).c(false);
                }
                Object objB3 = l0Var.b("sentry:typeCheckHint");
                if (io.sentry.hints.c.class.isInstance(l0Var.b("sentry:typeCheckHint")) && objB3 != null) {
                    ((io.sentry.hints.c) objB3).b.countDown();
                    sentryAndroidOptions2.getLogger().h(p5.DEBUG, "Disk flush envelope fired due to rate limit", new Object[0]);
                }
                cVarJ = null;
            } else {
                cVarJ = new io.sentry.internal.debugmeta.c((y4) cVar.f, arrayList2);
            }
        } else {
            cVarJ = cVar;
        }
        if (cVarJ == null) {
            if (z) {
                cVar3.Q(cVar);
                return;
            }
            return;
        }
        if (l7.class.isInstance(l0Var.b("sentry:typeCheckHint"))) {
            cVarJ = sentryAndroidOptions.getClientReportRecorder().j(cVarJ);
        }
        Future futureSubmit = this.b.submit(new b(this, cVarJ, l0Var, cVar2));
        if (futureSubmit != null && futureSubmit.isCancelled()) {
            sentryAndroidOptions.getClientReportRecorder().c(io.sentry.clientreport.d.QUEUE_OVERFLOW, cVarJ);
            return;
        }
        Object objB4 = l0Var.b("sentry:typeCheckHint");
        if (!y.class.isInstance(l0Var.b("sentry:typeCheckHint")) || objB4 == null) {
            return;
        }
        y yVar = (y) objB4;
        yVar.Z.add(yVar.Y);
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Envelope enqueued", new Object[0]);
    }

    @Override // io.sentry.transport.g
    public final void o(io.sentry.internal.debugmeta.c cVar) {
        k0(cVar, new l0());
    }
}
