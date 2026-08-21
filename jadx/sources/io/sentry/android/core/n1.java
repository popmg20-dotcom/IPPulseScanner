package io.sentry.android.core;

import io.sentry.b7;
import io.sentry.d7;
import io.sentry.f5;
import io.sentry.f7;
import io.sentry.o2;
import io.sentry.r5;
import io.sentry.r6;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n1 implements io.sentry.f0 {
    public final d b;
    public final SentryAndroidOptions f;
    public final io.sentry.util.a z = new io.sentry.util.a();

    public n1(SentryAndroidOptions sentryAndroidOptions, d dVar) {
        this.f = sentryAndroidOptions;
        this.b = dVar;
    }

    public static void a(io.sentry.android.core.performance.g gVar, io.sentry.protocol.f0 f0Var) {
        d7 d7Var;
        if (gVar.b != io.sentry.android.core.performance.f.COLD) {
            return;
        }
        io.sentry.protocol.e eVar = f0Var.f;
        ArrayList arrayList = f0Var.J0;
        b7 b7VarI = eVar.i();
        if (b7VarI == null) {
            return;
        }
        io.sentry.protocol.w wVar = b7VarI.b;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                d7Var = null;
                break;
            }
            io.sentry.protocol.z zVar = (io.sentry.protocol.z) it.next();
            if (zVar.Y.contentEquals("app.start.cold")) {
                d7Var = zVar.A;
                break;
            }
        }
        if (d7Var == null && "app.start".equals(b7VarI.X)) {
            d7Var = b7VarI.f;
        }
        boolean zEquals = "app.start".equals(b7VarI.X);
        io.sentry.android.core.performance.h hVar = new io.sentry.android.core.performance.h();
        io.sentry.android.core.performance.h hVar2 = gVar.A;
        long j = hVar2.f;
        long j2 = hVar2.z;
        long j3 = io.sentry.android.core.performance.g.M0;
        hVar.b = "Process Initialization";
        hVar.f = j;
        hVar.z = j2;
        hVar.A = j3;
        if (hVar.d() && Math.abs(hVar.a()) <= 10000) {
            arrayList.add(d(hVar, d7Var, wVar, "process.load", zEquals));
        }
        ArrayList arrayList2 = new ArrayList(gVar.Z.values());
        Collections.sort(arrayList2);
        if (!arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList.add(d((io.sentry.android.core.performance.h) it2.next(), d7Var, wVar, "contentprovider.load", zEquals));
            }
        }
        io.sentry.android.core.performance.h hVar3 = gVar.Y;
        if (hVar3.e()) {
            arrayList.add(d(hVar3, d7Var, wVar, "application.load", zEquals));
        }
    }

    public static boolean b(io.sentry.protocol.f0 f0Var) {
        for (io.sentry.protocol.z zVar : f0Var.J0) {
            if (zVar.Y.contentEquals("app.start.cold") || zVar.Y.contentEquals("app.start.warm")) {
                return true;
            }
        }
        b7 b7VarI = f0Var.f.i();
        return b7VarI != null && b7VarI.X.equals("app.start");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(io.sentry.protocol.f0 r11) {
        /*
            java.util.ArrayList r11 = r11.J0
            java.util.Iterator r0 = r11.iterator()
            r1 = 0
            r2 = r1
        L8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L2f
            java.lang.Object r3 = r0.next()
            io.sentry.protocol.z r3 = (io.sentry.protocol.z) r3
            java.lang.String r4 = "ui.load.initial_display"
            java.lang.String r5 = r3.Y
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L20
            r1 = r3
            goto L2b
        L20:
            java.lang.String r4 = "ui.load.full_display"
            java.lang.String r5 = r3.Y
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L2b
            r2 = r3
        L2b:
            if (r1 == 0) goto L8
            if (r2 == 0) goto L8
        L2f:
            if (r1 != 0) goto L35
            if (r2 != 0) goto L35
            goto Lc7
        L35:
            java.util.Iterator r11 = r11.iterator()
        L39:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto Lc7
            java.lang.Object r0 = r11.next()
            io.sentry.protocol.z r0 = (io.sentry.protocol.z) r0
            if (r0 == r1) goto L39
            if (r0 != r2) goto L4a
            goto L39
        L4a:
            java.util.Map r3 = r0.B0
            java.lang.Double r4 = r0.b
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L65
            java.lang.String r7 = "thread.name"
            java.lang.Object r3 = r3.get(r7)
            if (r3 == 0) goto L65
            java.lang.String r7 = "main"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L63
            goto L65
        L63:
            r3 = r5
            goto L66
        L65:
            r3 = r6
        L66:
            if (r1 == 0) goto L86
            double r7 = r4.doubleValue()
            java.lang.Double r9 = r1.b
            double r9 = r9.doubleValue()
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L86
            java.lang.Double r9 = r1.f
            if (r9 == 0) goto L82
            double r9 = r9.doubleValue()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 > 0) goto L86
        L82:
            if (r3 == 0) goto L86
            r3 = r6
            goto L87
        L86:
            r3 = r5
        L87:
            if (r2 == 0) goto La4
            double r7 = r4.doubleValue()
            java.lang.Double r4 = r2.b
            double r9 = r4.doubleValue()
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 < 0) goto La4
            java.lang.Double r4 = r2.f
            if (r4 == 0) goto La3
            double r9 = r4.doubleValue()
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 > 0) goto La4
        La3:
            r5 = r6
        La4:
            if (r3 != 0) goto La8
            if (r5 == 0) goto L39
        La8:
            java.util.Map r4 = r0.B0
            if (r4 != 0) goto Lb3
            j$.util.concurrent.ConcurrentHashMap r4 = new j$.util.concurrent.ConcurrentHashMap
            r4.<init>()
            r0.B0 = r4
        Lb3:
            if (r3 == 0) goto Lbc
            java.lang.String r0 = "ui.contributes_to_ttid"
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4.put(r0, r3)
        Lbc:
            if (r5 == 0) goto L39
            java.lang.String r0 = "ui.contributes_to_ttfd"
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4.put(r0, r3)
            goto L39
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.n1.c(io.sentry.protocol.f0):void");
    }

    public static io.sentry.protocol.z d(io.sentry.android.core.performance.h hVar, d7 d7Var, io.sentry.protocol.w wVar, String str, boolean z) {
        long jA;
        HashMap map = new HashMap(2);
        map.put("thread.id", Long.valueOf(io.sentry.android.core.internal.util.d.b));
        map.put("thread.name", "main");
        if (!z) {
            Boolean bool = Boolean.TRUE;
            map.put("ui.contributes_to_ttid", bool);
            map.put("ui.contributes_to_ttfd", bool);
        }
        Double dValueOf = Double.valueOf(hVar.f / 1000.0d);
        if (hVar.d()) {
            jA = hVar.a() + hVar.f;
        } else {
            jA = 0;
        }
        return new io.sentry.protocol.z(dValueOf, Double.valueOf(jA / 1000.0d), wVar, new d7(), d7Var, str, hVar.b, f7.OK, "auto.ui", new ConcurrentHashMap(), new ConcurrentHashMap(), map);
    }

    @Override // io.sentry.f0
    public final io.sentry.protocol.f0 s(io.sentry.protocol.f0 f0Var, io.sentry.l0 l0Var) {
        Map map;
        io.sentry.android.core.performance.h hVarB;
        SentryAndroidOptions sentryAndroidOptions = this.f;
        io.sentry.util.a aVar = this.z;
        aVar.g();
        try {
            if (!sentryAndroidOptions.isTracingEnabled()) {
                aVar.close();
                return f0Var;
            }
            io.sentry.android.core.performance.g gVarC = io.sentry.android.core.performance.g.c();
            boolean zB = b(f0Var);
            HashMap map2 = f0Var.K0;
            io.sentry.protocol.e eVar = f0Var.f;
            if (zB) {
                b7 b7VarI = eVar.i();
                boolean z = true;
                boolean z2 = (b7VarI == null || !(b7VarI != null && "app.start".equals(b7VarI.X)) || b7VarI.A0.containsKey("app.vitals.start.screen")) ? false : true;
                if (gVarC.A0 && (z2 || ((Boolean) gVarC.f.a()).booleanValue())) {
                    if (z2) {
                        hVarB = gVarC.A;
                        if (!hVarB.d() || !hVarB.e()) {
                            hVarB = gVarC.X;
                        }
                    } else {
                        hVarB = gVarC.b(sentryAndroidOptions);
                    }
                    long jA = hVarB.a();
                    io.sentry.util.a aVar2 = (io.sentry.util.a) gVarC.L0.b;
                    aVar2.g();
                    aVar2.close();
                    if (jA == 0) {
                        z = false;
                    }
                    if (z) {
                        if (z) {
                            map2.put(gVarC.b == io.sentry.android.core.performance.f.COLD ? "app_start_cold" : "app_start_warm", new io.sentry.protocol.n(Float.valueOf(jA), o2.MILLISECOND.apiName()));
                        }
                        a(gVarC, f0Var);
                        gVarC.A0 = false;
                        gVarC.Z.clear();
                        gVarC.y0.clear();
                        io.sentry.util.a aVar3 = (io.sentry.util.a) gVarC.L0.b;
                        aVar3.g();
                        aVar3.close();
                    }
                }
                io.sentry.protocol.a aVarD = eVar.d();
                if (aVarD == null) {
                    aVarD = new io.sentry.protocol.a();
                    eVar.m(aVarD);
                }
                aVarD.A0 = gVarC.b == io.sentry.android.core.performance.f.COLD ? "cold" : "warm";
            }
            c(f0Var);
            io.sentry.protocol.w wVar = f0Var.b;
            b7 b7VarI2 = eVar.i();
            if (wVar != null && b7VarI2 != null && b7VarI2.X.contentEquals("ui.load")) {
                d dVar = this.b;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) dVar.d;
                io.sentry.util.a aVar4 = (io.sentry.util.a) dVar.g;
                aVar4.g();
                try {
                    if (dVar.e()) {
                        map = (Map) concurrentHashMap.get(wVar);
                        concurrentHashMap.remove(wVar);
                        aVar4.close();
                    } else {
                        aVar4.close();
                        map = null;
                    }
                    if (map != null) {
                        map2.putAll(map);
                    }
                } finally {
                }
            }
            aVar.close();
            return f0Var;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.f0
    public final r5 x(r5 r5Var) {
        return r5Var;
    }

    @Override // io.sentry.f0
    public final r6 g(r6 r6Var, io.sentry.l0 l0Var) {
        return r6Var;
    }

    @Override // io.sentry.f0
    public final f5 n(f5 f5Var, io.sentry.l0 l0Var) {
        return f5Var;
    }
}
