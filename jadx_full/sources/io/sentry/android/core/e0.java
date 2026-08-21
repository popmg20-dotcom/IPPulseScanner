package io.sentry.android.core;

import android.content.res.Configuration;
import defpackage.d70;
import defpackage.d82;
import defpackage.e70;
import defpackage.n12;
import defpackage.xg3;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.p6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements Runnable {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ long f;
    public final /* synthetic */ Object z;

    public /* synthetic */ e0(AppComponentsBreadcrumbsIntegration appComponentsBreadcrumbsIntegration, long j, Configuration configuration) {
        this.z = appComponentsBreadcrumbsIntegration;
        this.f = j;
        this.A = configuration;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        int i = this.b;
        io.sentry.protocol.g gVar = null;
        long j = this.f;
        Object obj = this.A;
        Object obj2 = this.z;
        switch (i) {
            case 0:
                AppComponentsBreadcrumbsIntegration appComponentsBreadcrumbsIntegration = (AppComponentsBreadcrumbsIntegration) obj2;
                Configuration configuration = (Configuration) obj;
                io.sentry.l0 l0Var = AppComponentsBreadcrumbsIntegration.X;
                if (appComponentsBreadcrumbsIntegration.f != null) {
                    int i2 = appComponentsBreadcrumbsIntegration.b.getResources().getConfiguration().orientation;
                    if (i2 == 1) {
                        gVar = io.sentry.protocol.g.PORTRAIT;
                    } else if (i2 == 2) {
                        gVar = io.sentry.protocol.g.LANDSCAPE;
                    }
                    String lowerCase = gVar != null ? gVar.name().toLowerCase(Locale.ROOT) : "undefined";
                    io.sentry.g gVar2 = new io.sentry.g(j);
                    gVar2.X = "navigation";
                    gVar2.Z = "device.orientation";
                    gVar2.d(lowerCase, "position");
                    gVar2.z0 = p5.INFO;
                    io.sentry.l0 l0Var2 = new io.sentry.l0();
                    l0Var2.d(configuration, "android:configuration");
                    appComponentsBreadcrumbsIntegration.f.c(gVar2, l0Var2);
                    return;
                }
                return;
            default:
                io.sentry.android.replay.capture.g gVar3 = (io.sentry.android.replay.capture.g) obj2;
                io.sentry.android.replay.n nVar = (io.sentry.android.replay.n) obj;
                io.sentry.android.replay.j jVar = gVar3.h;
                if (jVar != null) {
                    nVar.k(jVar, Long.valueOf(j));
                }
                long jC = gVar3.x.c() - gVar3.v.getSessionReplay().h;
                io.sentry.android.replay.j jVar2 = gVar3.h;
                String strC = jVar2 != null ? jVar2.C(jC) : null;
                io.sentry.android.replay.capture.b bVar = gVar3.l;
                d82 d82Var = io.sentry.android.replay.capture.d.u[2];
                bVar.getClass();
                d82Var.getClass();
                Object andSet = bVar.b.getAndSet(strC);
                if (!n12.c(andSet, strC)) {
                    io.sentry.android.replay.capture.c cVar = new io.sentry.android.replay.capture.c(andSet, strC, bVar.d, 2);
                    io.sentry.android.replay.capture.d dVar = bVar.c;
                    p6 p6Var = dVar.a;
                    if (p6Var.getThreadChecker().c()) {
                        dVar.e.submit(new io.sentry.android.replay.util.j(new p2(8, cVar), "CaptureStrategy.runInBackground"));
                    } else {
                        try {
                            cVar.a();
                        } catch (Throwable th) {
                            p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
                        }
                    }
                    break;
                }
                ArrayList arrayList = gVar3.z;
                xg3 xg3Var = new xg3();
                d70.o0(arrayList, new io.sentry.android.replay.i(jC, gVar3, xg3Var, 1));
                if (xg3Var.b) {
                    int i3 = 0;
                    for (Object obj3 : arrayList) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            e70.P();
                            throw null;
                        }
                        io.sentry.android.replay.capture.j jVar3 = (io.sentry.android.replay.capture.j) obj3;
                        jVar3.a.K0 = i3;
                        List<io.sentry.rrweb.b> list = jVar3.b.f;
                        if (list != null) {
                            for (io.sentry.rrweb.b bVar2 : list) {
                                if (bVar2 instanceof io.sentry.rrweb.m) {
                                    ((io.sentry.rrweb.m) bVar2).A = i3;
                                }
                            }
                        }
                        i3 = i4;
                    }
                    return;
                }
                return;
        }
    }

    public /* synthetic */ e0(io.sentry.android.replay.capture.g gVar, io.sentry.android.replay.n nVar, long j) {
        this.z = gVar;
        this.A = nVar;
        this.f = j;
    }
}
