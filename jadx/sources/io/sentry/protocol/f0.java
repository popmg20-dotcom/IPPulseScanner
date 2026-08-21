package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.a7;
import io.sentry.b7;
import io.sentry.k2;
import io.sentry.n3;
import io.sentry.t4;
import io.sentry.x3;
import io.sentry.x6;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends t4 implements k2 {
    public String G0;
    public Double H0;
    public Double I0;
    public final ArrayList J0;
    public final HashMap K0;
    public h0 L0;
    public ConcurrentHashMap M0;

    public f0(x6 x6Var) {
        super(x6Var.a);
        this.J0 = new ArrayList();
        this.K0 = new HashMap();
        a7 a7Var = x6Var.b;
        this.H0 = Double.valueOf(a7Var.a.d() / 1.0E9d);
        this.I0 = Double.valueOf(a7Var.a.c(a7Var.b) / 1.0E9d);
        this.G0 = x6Var.e;
        for (a7 a7Var2 : x6Var.c) {
            Boolean bool = Boolean.TRUE;
            x3 x3Var = a7Var2.c.A;
            if (bool.equals(x3Var == null ? null : (Boolean) x3Var.a)) {
                this.J0.add(new z(a7Var2));
            }
        }
        e eVar = this.f;
        eVar.l(x6Var.p);
        b7 b7Var = a7Var.c;
        ConcurrentHashMap concurrentHashMap = a7Var.j;
        b7 b7Var2 = new b7(b7Var.b, b7Var.f, b7Var.z, b7Var.X, b7Var.Y, b7Var.A, b7Var.Z, b7Var.z0);
        Iterator it = b7Var.y0.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            b((String) entry.getKey(), (String) entry.getValue());
        }
        for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Object value = entry2.getValue();
            if (str != null) {
                Map map = b7Var2.A0;
                if (value == null) {
                    map.remove(str);
                } else {
                    map.put(str, value);
                }
            }
        }
        b7Var.E0.d();
        eVar.v(b7Var2);
        this.L0 = new h0(x6Var.n.apiName());
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.G0 != null) {
            cVar.p("transaction");
            cVar.y(this.G0);
        }
        cVar.p("start_timestamp");
        cVar.v(iLogger, io.sentry.config.a.c(this.H0.doubleValue()));
        if (this.I0 != null) {
            cVar.p("timestamp");
            cVar.v(iLogger, io.sentry.config.a.c(this.I0.doubleValue()));
        }
        ArrayList arrayList = this.J0;
        if (!arrayList.isEmpty()) {
            cVar.p("spans");
            cVar.v(iLogger, arrayList);
        }
        cVar.p("type");
        cVar.y("transaction");
        HashMap map = this.K0;
        if (!map.isEmpty()) {
            cVar.p("measurements");
            cVar.v(iLogger, map);
        }
        cVar.p("transaction_info");
        cVar.v(iLogger, this.L0);
        io.sentry.config.a.p(this, cVar, iLogger);
        ConcurrentHashMap concurrentHashMap = this.M0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.M0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }

    public f0(ArrayList arrayList, HashMap map, h0 h0Var) {
        Double dValueOf = Double.valueOf(0.0d);
        ArrayList arrayList2 = new ArrayList();
        this.J0 = arrayList2;
        HashMap map2 = new HashMap();
        this.K0 = map2;
        this.G0 = "";
        this.H0 = dValueOf;
        this.I0 = null;
        arrayList2.addAll(arrayList);
        map2.putAll(map);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.K0.putAll(((z) it.next()).C0);
        }
        this.L0 = h0Var;
    }
}
