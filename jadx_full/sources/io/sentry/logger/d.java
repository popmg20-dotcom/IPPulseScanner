package io.sentry.logger;

import defpackage.x8;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.g;
import io.sentry.clientreport.f;
import io.sentry.j5;
import io.sentry.n2;
import io.sentry.o;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.r5;
import io.sentry.s5;
import io.sentry.transport.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {
    public final j5 A;
    public final AtomicBoolean X;
    public volatile boolean Y;
    public final n2 Z;
    public final SentryAndroidOptions b;
    public final x8 f;
    public final ConcurrentLinkedQueue z;

    public d(SentryAndroidOptions sentryAndroidOptions, x8 x8Var) {
        j5 j5Var = new j5(sentryAndroidOptions);
        this.X = new AtomicBoolean(false);
        this.Y = false;
        this.Z = new n2(8);
        this.b = sentryAndroidOptions;
        this.f = x8Var;
        this.z = new ConcurrentLinkedQueue();
        this.A = j5Var;
    }

    @Override // io.sentry.logger.b
    public void a(boolean z) {
        this.Y = true;
        if (z) {
            e(true);
            this.A.submit(new g(15, this));
        } else {
            this.A.a(this.b.getShutdownTimeoutMillis());
            while (!this.z.isEmpty()) {
                c();
            }
        }
    }

    @Override // io.sentry.logger.b
    public final void b(long j) {
        e(true);
        try {
            ((p) this.Z.f).tryAcquireSharedNanos(1, TimeUnit.MILLISECONDS.toNanos(j));
        } catch (InterruptedException e) {
            this.b.getLogger().d(p5.ERROR, "Failed to flush log events", e);
            Thread.currentThread().interrupt();
        }
    }

    public final void c() {
        ArrayList arrayList = new ArrayList(100);
        do {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.z;
            r5 r5Var = (r5) concurrentLinkedQueue.poll();
            if (r5Var != null) {
                arrayList.add(r5Var);
            }
            if (concurrentLinkedQueue.isEmpty()) {
                break;
            }
        } while (arrayList.size() < 100);
        if (arrayList.isEmpty()) {
            return;
        }
        x8 x8Var = this.f;
        try {
            x8Var.I(x8Var.t(new s5(arrayList)), null);
        } catch (IOException e) {
            ((SentryAndroidOptions) x8Var.b).getLogger().b(p5.WARNING, e, "Capturing logs failed.", new Object[0]);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            p pVar = (p) this.Z.f;
            int i2 = p.b;
            pVar.releaseShared(1);
        }
    }

    @Override // io.sentry.logger.b
    public final void d(r5 r5Var) {
        if (this.Y) {
            return;
        }
        p pVar = (p) this.Z.f;
        int i = p.b;
        if (pVar.a() < 1000) {
            ((p) this.Z.f).b();
            this.z.offer(r5Var);
            e(false);
        } else {
            f clientReportRecorder = this.b.getClientReportRecorder();
            io.sentry.clientreport.d dVar = io.sentry.clientreport.d.QUEUE_OVERFLOW;
            clientReportRecorder.a(dVar, o.LogItem);
            this.b.getClientReportRecorder().e(dVar, o.LogByte, io.sentry.util.d.a(this.b.getSerializer(), this.b.getLogger(), r5Var));
        }
    }

    public final void e(boolean z) {
        AtomicBoolean atomicBoolean = this.X;
        if (z) {
            atomicBoolean.set(true);
        } else if (!atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        try {
            this.A.b(new p2(9, this), z ? 0 : 5000);
        } catch (RejectedExecutionException e) {
            atomicBoolean.set(false);
            this.b.getLogger().d(p5.WARNING, "Logs batch processor flush task rejected", e);
        }
    }
}
