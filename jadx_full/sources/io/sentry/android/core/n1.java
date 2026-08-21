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
    */
    public static void c(io.sentry.protocol.f0 f0Var) {
        Double d;
        Double d2;
        Object obj;
        ArrayList<io.sentry.protocol.z> arrayList = f0Var.J0;
        io.sentry.protocol.z zVar = null;
        io.sentry.protocol.z zVar2 = null;
        for (io.sentry.protocol.z zVar3 : arrayList) {
            if ("ui.load.initial_display".equals(zVar3.Y)) {
                zVar = zVar3;
            } else if ("ui.load.full_display".equals(zVar3.Y)) {
                zVar2 = zVar3;
            }
            if (zVar != null && zVar2 != null) {
                break;
            }
        }
        if (zVar == null && zVar2 == null) {
            return;
        }
        for (io.sentry.protocol.z zVar4 : arrayList) {
            if (zVar4 != zVar && zVar4 != zVar2) {
                Map map = zVar4.B0;
                Double d3 = zVar4.b;
                boolean z = false;
                boolean z2 = map == null || (obj = map.get("thread.name")) == null || "main".equals(obj);
                if (zVar != null) {
                    double dDoubleValue = d3.doubleValue();
                    boolean z3 = dDoubleValue >= zVar.b.doubleValue() && ((d2 = zVar.f) == null || dDoubleValue <= d2.doubleValue()) && z2;
                    if (zVar2 != null) {
                        double dDoubleValue2 = d3.doubleValue();
                        if (dDoubleValue2 >= zVar2.b.doubleValue() && ((d = zVar2.f) == null || dDoubleValue2 <= d.doubleValue())) {
                            z = true;
                        }
                    }
                    if (z3 || z) {
                        Map concurrentHashMap = zVar4.B0;
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                            zVar4.B0 = concurrentHashMap;
                        }
                        if (z3) {
                            concurrentHashMap.put("ui.contributes_to_ttid", Boolean.TRUE);
                        }
                        if (z) {
                            concurrentHashMap.put("ui.contributes_to_ttfd", Boolean.TRUE);
                        }
                    }
                }
            }
        }
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
