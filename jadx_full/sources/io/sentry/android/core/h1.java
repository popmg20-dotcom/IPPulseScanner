package io.sentry.android.core;

import defpackage.iy;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.r3;
import io.sentry.w4;
import j$.util.function.Consumer$CC;
import java.io.File;
import java.util.HashMap;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h1 implements Consumer {
    public final /* synthetic */ k1 a;
    public final /* synthetic */ io.sentry.protocol.w b;
    public final /* synthetic */ io.sentry.protocol.w c;
    public final /* synthetic */ HashMap d;
    public final /* synthetic */ w4 e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ io.sentry.f1 g;
    public final /* synthetic */ p6 h;

    public /* synthetic */ h1(k1 k1Var, io.sentry.protocol.w wVar, io.sentry.protocol.w wVar2, HashMap map, w4 w4Var, boolean z, io.sentry.f1 f1Var, p6 p6Var) {
        this.a = k1Var;
        this.b = wVar;
        this.c = wVar2;
        this.d = map;
        this.e = w4Var;
        this.f = z;
        this.g = f1Var;
        this.h = p6Var;
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final void n(Object obj) {
        File file = (File) obj;
        k1 k1Var = this.a;
        ILogger iLogger = k1Var.b;
        if (file == null) {
            iLogger.h(p5.ERROR, "An error occurred while collecting a profile chunk, and it won't be sent.", new Object[0]);
        } else {
            r3 r3Var = new r3(this.b, this.c, this.d, file, this.e);
            r3Var.f = "application/x-perfetto-trace";
            io.sentry.f1 f1Var = this.g;
            p6 p6Var = this.h;
            iy iyVar = new iy(k1Var, f1Var, r3Var, p6Var, 7);
            try {
                if (Thread.currentThread().getName().startsWith("SentryExecutorServiceThreadFactory")) {
                    iyVar.run();
                } else {
                    k1Var.f.f.getExecutorService().submit(iyVar);
                }
            } catch (Throwable th) {
                p6Var.getLogger().d(p5.DEBUG, "Failed to send profile chunk.", th);
            }
        }
        if (!this.f) {
            iLogger.h(p5.DEBUG, "Profile chunk finished.", new Object[0]);
            return;
        }
        io.sentry.util.a aVar = k1Var.I0;
        aVar.g();
        try {
            if (k1Var.Y || k1Var.C0.get() || k1Var.F0) {
                iLogger.h(p5.DEBUG, "Profile chunk finished, but profiler was already restarted, closed or stopped. Skipping.", new Object[0]);
            } else {
                iLogger.h(p5.DEBUG, "Profile chunk finished. Starting a new one.", new Object[0]);
                k1Var.h();
            }
            aVar.close();
        } finally {
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
