package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import io.sentry.r4;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n implements k2 {
    public AbstractMap A;
    public final /* synthetic */ int b = 1;
    public final String f;
    public final Object z;

    public n(String str, Object obj) {
        this.f = str;
        if (obj == null || !str.equals("string")) {
            this.z = obj;
        } else {
            this.z = obj.toString();
        }
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        int i = this.b;
        Object obj = this.z;
        String str = this.f;
        switch (i) {
            case 0:
                io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
                cVar.k();
                cVar.p("value");
                cVar.x((Number) obj);
                if (str != null) {
                    cVar.p("unit");
                    cVar.y(str);
                }
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.A;
                if (concurrentHashMap != null) {
                    for (K k : concurrentHashMap.keySet()) {
                        io.sentry.e.d((ConcurrentHashMap) this.A, k, cVar, k, iLogger);
                    }
                }
                cVar.m();
                break;
            default:
                io.sentry.internal.debugmeta.c cVar2 = (io.sentry.internal.debugmeta.c) n3Var;
                cVar2.k();
                cVar2.p("type");
                cVar2.v(iLogger, str);
                cVar2.p("value");
                cVar2.v(iLogger, obj);
                HashMap map = (HashMap) this.A;
                if (map != null) {
                    for (String str2 : map.keySet()) {
                        io.sentry.e.c((HashMap) this.A, str2, cVar2, str2, iLogger);
                    }
                }
                cVar2.m();
                break;
        }
    }

    public n(r4 r4Var, Object obj) {
        this(r4Var.apiName(), obj);
    }

    public n(Number number, String str) {
        this.z = number;
        this.f = str;
    }
}
