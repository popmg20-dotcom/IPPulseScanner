package io.sentry;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static void a(f1 f1Var, String str) {
        g gVar = new g();
        gVar.A = str;
        f1Var.g(gVar);
    }

    public static boolean b(String str, ILogger iLogger) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        iLogger.h(p5.INFO, "No cached dir path is defined in options.", new Object[0]);
        return false;
    }

    public static void c(HashMap map, String str, io.sentry.internal.debugmeta.c cVar, String str2, ILogger iLogger) {
        Object obj = map.get(str);
        cVar.p(str2);
        cVar.v(iLogger, obj);
    }

    public static void d(ConcurrentHashMap concurrentHashMap, String str, io.sentry.internal.debugmeta.c cVar, String str2, ILogger iLogger) {
        Object obj = concurrentHashMap.get(str);
        cVar.p(str2);
        cVar.v(iLogger, obj);
    }
}
