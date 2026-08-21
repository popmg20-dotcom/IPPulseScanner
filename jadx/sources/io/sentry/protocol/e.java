package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.b7;
import io.sentry.k2;
import io.sentry.n3;
import io.sentry.t3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class e implements k2 {
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final io.sentry.util.a f = new io.sentry.util.a();

    public e(e eVar) {
        for (Map.Entry entry : eVar.b()) {
            if (entry != null) {
                Object value = entry.getValue();
                if ("app".equals(entry.getKey()) && (value instanceof a)) {
                    a aVar = (a) value;
                    a aVar2 = new a();
                    aVar2.Z = aVar.Z;
                    aVar2.b = aVar.b;
                    aVar2.X = aVar.X;
                    aVar2.f = aVar.f;
                    aVar2.Y = aVar.Y;
                    aVar2.A = aVar.A;
                    aVar2.z = aVar.z;
                    aVar2.y0 = io.sentry.util.b.o(aVar.y0);
                    aVar2.B0 = aVar.B0;
                    List list = aVar.z0;
                    aVar2.z0 = list != null ? new ArrayList(list) : null;
                    aVar2.A0 = aVar.A0;
                    aVar2.C0 = aVar.C0;
                    aVar2.D0 = aVar.D0;
                    aVar2.E0 = io.sentry.util.b.o(aVar.E0);
                    m(aVar2);
                } else if ("browser".equals(entry.getKey()) && (value instanceof d)) {
                    d dVar = (d) value;
                    d dVar2 = new d();
                    dVar2.b = dVar.b;
                    dVar2.f = dVar.f;
                    dVar2.z = io.sentry.util.b.o(dVar.z);
                    n(dVar2);
                } else if ("device".equals(entry.getKey()) && (value instanceof h)) {
                    h hVar = (h) value;
                    h hVar2 = new h();
                    hVar2.b = hVar.b;
                    hVar2.f = hVar.f;
                    hVar2.z = hVar.z;
                    hVar2.A = hVar.A;
                    hVar2.X = hVar.X;
                    hVar2.Y = hVar.Y;
                    hVar2.z0 = hVar.z0;
                    hVar2.A0 = hVar.A0;
                    hVar2.B0 = hVar.B0;
                    hVar2.C0 = hVar.C0;
                    hVar2.D0 = hVar.D0;
                    hVar2.E0 = hVar.E0;
                    hVar2.F0 = hVar.F0;
                    hVar2.G0 = hVar.G0;
                    hVar2.H0 = hVar.H0;
                    hVar2.I0 = hVar.I0;
                    hVar2.J0 = hVar.J0;
                    hVar2.K0 = hVar.K0;
                    hVar2.L0 = hVar.L0;
                    hVar2.M0 = hVar.M0;
                    hVar2.N0 = hVar.N0;
                    hVar2.O0 = hVar.O0;
                    hVar2.P0 = hVar.P0;
                    hVar2.R0 = hVar.R0;
                    hVar2.T0 = hVar.T0;
                    hVar2.U0 = hVar.U0;
                    hVar2.y0 = hVar.y0;
                    String[] strArr = hVar.Z;
                    hVar2.Z = strArr != null ? (String[]) strArr.clone() : null;
                    hVar2.S0 = hVar.S0;
                    TimeZone timeZone = hVar.Q0;
                    hVar2.Q0 = timeZone != null ? (TimeZone) timeZone.clone() : null;
                    hVar2.V0 = hVar.V0;
                    hVar2.W0 = hVar.W0;
                    hVar2.X0 = hVar.X0;
                    hVar2.Y0 = hVar.Y0;
                    hVar2.Z0 = io.sentry.util.b.o(hVar.Z0);
                    o(hVar2);
                } else if ("os".equals(entry.getKey()) && (value instanceof q)) {
                    q qVar = (q) value;
                    q qVar2 = new q();
                    qVar2.b = qVar.b;
                    qVar2.f = qVar.f;
                    qVar2.z = qVar.z;
                    qVar2.A = qVar.A;
                    qVar2.X = qVar.X;
                    qVar2.Y = qVar.Y;
                    qVar2.Z = io.sentry.util.b.o(qVar.Z);
                    r(qVar2);
                } else if ("runtime".equals(entry.getKey()) && (value instanceof y)) {
                    y yVar = (y) value;
                    y yVar2 = new y();
                    yVar2.b = yVar.b;
                    yVar2.f = yVar.f;
                    yVar2.z = yVar.z;
                    yVar2.A = io.sentry.util.b.o(yVar.A);
                    t(yVar2);
                } else if ("feedback".equals(entry.getKey()) && (value instanceof k)) {
                    k kVar = (k) value;
                    k kVar2 = new k();
                    kVar2.b = kVar.b;
                    kVar2.f = kVar.f;
                    kVar2.z = kVar.z;
                    kVar2.A = kVar.A;
                    kVar2.X = kVar.X;
                    kVar2.Y = kVar.Y;
                    kVar2.Z = io.sentry.util.b.o(kVar.Z);
                    k(kVar2, "feedback");
                } else if ("gpu".equals(entry.getKey()) && (value instanceof m)) {
                    m mVar = (m) value;
                    m mVar2 = new m();
                    mVar2.b = mVar.b;
                    mVar2.f = mVar.f;
                    mVar2.z = mVar.z;
                    mVar2.A = mVar.A;
                    mVar2.X = mVar.X;
                    mVar2.Y = mVar.Y;
                    mVar2.Z = mVar.Z;
                    mVar2.y0 = mVar.y0;
                    mVar2.z0 = mVar.z0;
                    mVar2.A0 = io.sentry.util.b.o(mVar.A0);
                    q(mVar2);
                } else if ("trace".equals(entry.getKey()) && (value instanceof b7)) {
                    v(new b7((b7) value));
                } else if ("profile".equals(entry.getKey()) && (value instanceof t3)) {
                    t3 t3Var = (t3) value;
                    t3 t3Var2 = new t3();
                    t3Var2.b = t3Var.b;
                    ConcurrentHashMap concurrentHashMapO = io.sentry.util.b.o(t3Var.f);
                    if (concurrentHashMapO != null) {
                        t3Var2.f = concurrentHashMapO;
                    }
                    k(t3Var2, "profile");
                } else if ("response".equals(entry.getKey()) && (value instanceof s)) {
                    s sVar = (s) value;
                    s sVar2 = new s();
                    sVar2.b = sVar.b;
                    sVar2.f = io.sentry.util.b.o(sVar.f);
                    sVar2.Y = io.sentry.util.b.o(sVar.Y);
                    sVar2.z = sVar.z;
                    sVar2.A = sVar.A;
                    sVar2.X = sVar.X;
                    s(sVar2);
                } else if ("spring".equals(entry.getKey()) && (value instanceof g0)) {
                    g0 g0Var = (g0) value;
                    g0 g0Var2 = new g0();
                    g0Var2.b = g0Var.b;
                    g0Var2.f = io.sentry.util.b.o(g0Var.f);
                    u(g0Var2);
                } else if ("art".equals(entry.getKey()) && (value instanceof c)) {
                    c cVar = (c) value;
                    c cVar2 = new c();
                    cVar2.b = cVar.b;
                    cVar2.f = cVar.f;
                    cVar2.z = cVar.z;
                    cVar2.A = cVar.A;
                    cVar2.X = cVar.X;
                    cVar2.Y = cVar.Y;
                    cVar2.Z = cVar.Z;
                    cVar2.y0 = cVar.y0;
                    cVar2.z0 = cVar.z0;
                    cVar2.A0 = cVar.A0;
                    cVar2.B0 = cVar.B0;
                    cVar2.C0 = io.sentry.util.b.o(cVar.C0);
                    k(cVar2, "art");
                } else {
                    k(value, (String) entry.getKey());
                }
            }
        }
    }

    public boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.b.containsKey(obj);
    }

    public Set b() {
        return this.b.entrySet();
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.b.get(obj);
    }

    public a d() {
        return (a) w(a.class, "app");
    }

    public h e() {
        return (h) w(h.class, "device");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.b.equals(((e) obj).b);
        }
        return false;
    }

    public j f() {
        return (j) w(j.class, "flags");
    }

    public q g() {
        return (q) w(q.class, "os");
    }

    public y h() {
        return (y) w(y.class, "runtime");
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public b7 i() {
        return (b7) w(b7.class, "trace");
    }

    public Enumeration j() {
        return this.b.keys();
    }

    public Object k(Object obj, String str) {
        if (str == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        return obj == null ? concurrentHashMap.remove(str) : concurrentHashMap.put(str, obj);
    }

    public void l(e eVar) {
        if (eVar == null) {
            return;
        }
        this.b.putAll(eVar.b);
    }

    public void m(a aVar) {
        k(aVar, "app");
    }

    public void n(d dVar) {
        k(dVar, "browser");
    }

    public void o(h hVar) {
        k(hVar, "device");
    }

    public void p(j jVar) {
        k(jVar, "flags");
    }

    public void q(m mVar) {
        k(mVar, "gpu");
    }

    public void r(q qVar) {
        k(qVar, "os");
    }

    public void s(s sVar) {
        io.sentry.util.a aVar = this.f;
        aVar.g();
        try {
            k(sVar, "response");
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.k2
    public void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        Enumeration enumerationJ = j();
        int size = this.b.size();
        String[] strArr = size == 0 ? io.sentry.util.b.a : new String[size];
        int i = 0;
        while (enumerationJ.hasMoreElements()) {
            if (i == strArr.length) {
                strArr = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            }
            strArr[i] = (String) enumerationJ.nextElement();
            i++;
        }
        if (i != strArr.length) {
            strArr = (String[]) Arrays.copyOf(strArr, i);
        }
        Arrays.sort(strArr);
        for (String str : strArr) {
            Object objC = c(str);
            if (objC != null) {
                cVar.p(str);
                cVar.v(iLogger, objC);
            }
        }
        cVar.m();
    }

    public void t(y yVar) {
        k(yVar, "runtime");
    }

    public void u(g0 g0Var) {
        k(g0Var, "spring");
    }

    public void v(b7 b7Var) {
        io.sentry.util.b.r(b7Var, "traceContext is required");
        k(b7Var, "trace");
    }

    public final Object w(Class cls, String str) {
        Object objC = c(str);
        if (cls.isInstance(objC)) {
            return cls.cast(objC);
        }
        return null;
    }

    public e() {
    }
}
