package io.sentry;

import defpackage.st4;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f4 implements d1 {
    public p1 a;
    public final WeakReference b;
    public io.sentry.protocol.j0 c;
    public String d;
    public io.sentry.protocol.r e;
    public final ArrayList f;
    public volatile Queue g;
    public final ConcurrentHashMap h;
    public final ConcurrentHashMap i;
    public final ConcurrentHashMap j;
    public final CopyOnWriteArrayList k;
    public volatile p6 l;
    public volatile z6 m;
    public final io.sentry.util.a n;
    public final io.sentry.util.a o;
    public final io.sentry.util.a p;
    public final io.sentry.protocol.e q;
    public final CopyOnWriteArrayList r;
    public x3 s;
    public io.sentry.protocol.w t;
    public i1 u;
    public final Map v;
    public final io.sentry.featureflags.b w;

    public f4(f4 f4Var) {
        io.sentry.protocol.j0 j0Var;
        io.sentry.protocol.r rVar;
        this.b = new WeakReference(null);
        this.f = new ArrayList();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.k = new CopyOnWriteArrayList();
        this.n = new io.sentry.util.a();
        this.o = new io.sentry.util.a();
        this.p = new io.sentry.util.a();
        this.q = new io.sentry.protocol.e();
        this.r = new CopyOnWriteArrayList();
        this.t = io.sentry.protocol.w.f;
        this.u = d3.b;
        this.v = DesugarCollections.synchronizedMap(new WeakHashMap());
        this.a = f4Var.a;
        this.b = f4Var.b;
        this.m = f4Var.m;
        this.l = f4Var.l;
        this.u = f4Var.u;
        io.sentry.protocol.j0 j0Var2 = f4Var.c;
        if (j0Var2 != null) {
            j0Var = new io.sentry.protocol.j0();
            j0Var.b = j0Var2.b;
            j0Var.z = j0Var2.z;
            j0Var.f = j0Var2.f;
            j0Var.A = j0Var2.A;
            j0Var.X = j0Var2.X;
            j0Var.Y = j0Var2.Y;
            j0Var.Z = io.sentry.util.b.o(j0Var2.Z);
            j0Var.y0 = io.sentry.util.b.o(j0Var2.y0);
        } else {
            j0Var = null;
        }
        this.c = j0Var;
        this.d = f4Var.d;
        this.t = f4Var.t;
        io.sentry.protocol.r rVar2 = f4Var.e;
        if (rVar2 != null) {
            rVar = new io.sentry.protocol.r();
            rVar.b = rVar2.b;
            rVar.X = rVar2.X;
            rVar.f = rVar2.f;
            rVar.z = rVar2.z;
            rVar.Y = io.sentry.util.b.o(rVar2.Y);
            rVar.Z = io.sentry.util.b.o(rVar2.Z);
            rVar.z0 = io.sentry.util.b.o(rVar2.z0);
            rVar.C0 = io.sentry.util.b.o(rVar2.C0);
            rVar.A = rVar2.A;
            rVar.A0 = rVar2.A0;
            rVar.y0 = rVar2.y0;
            rVar.B0 = rVar2.B0;
        } else {
            rVar = null;
        }
        this.e = rVar;
        this.f = new ArrayList(f4Var.f);
        this.k = new CopyOnWriteArrayList(f4Var.k);
        g[] gVarArr = (g[]) f4Var.g.toArray(new g[0]);
        Queue queueA = a(f4Var.l.getMaxBreadcrumbs());
        for (g gVar : gVarArr) {
            queueA.add(new g(gVar));
        }
        this.g = queueA;
        ConcurrentHashMap concurrentHashMap = f4Var.h;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            if (entry != null) {
                concurrentHashMap2.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.h = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = f4Var.i;
        ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
        for (Map.Entry entry2 : concurrentHashMap3.entrySet()) {
            if (entry2 != null) {
                String str = (String) entry2.getKey();
                if (entry2.getValue() != null) {
                    st4.n();
                    throw null;
                }
                concurrentHashMap4.put(str, null);
            }
        }
        this.i = concurrentHashMap4;
        ConcurrentHashMap concurrentHashMap5 = f4Var.j;
        ConcurrentHashMap concurrentHashMap6 = new ConcurrentHashMap();
        for (Map.Entry entry3 : concurrentHashMap5.entrySet()) {
            if (entry3 != null) {
                concurrentHashMap6.put((String) entry3.getKey(), entry3.getValue());
            }
        }
        this.j = concurrentHashMap6;
        this.q = new io.sentry.protocol.e(f4Var.q);
        this.r = new CopyOnWriteArrayList(f4Var.r);
        this.w = f4Var.w.clone();
        this.s = new x3(f4Var.s);
    }

    public static Queue a(int i) {
        return i > 0 ? new g7(new i(i)) : new b0();
    }

    @Override // io.sentry.d1
    public final io.sentry.protocol.e A() {
        return this.q;
    }

    @Override // io.sentry.d1
    public final x3 B(c4 c4Var) {
        io.sentry.util.a aVar = this.p;
        aVar.g();
        try {
            c4Var.a(this.s);
            x3 x3Var = new x3(this.s);
            aVar.close();
            return x3Var;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.d1
    public final String C() {
        return this.d;
    }

    @Override // io.sentry.d1
    public final void D(e4 e4Var) {
        io.sentry.util.a aVar = this.o;
        aVar.g();
        try {
            e4Var.h(this.a);
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

    @Override // io.sentry.d1
    public final void F(p1 p1Var) {
        io.sentry.util.a aVar = this.o;
        aVar.g();
        try {
            this.a = p1Var;
            for (e1 e1Var : this.l.getScopeObservers()) {
                if (p1Var != null) {
                    e1Var.o(p1Var.getName());
                    e1Var.m(p1Var.r(), this);
                } else {
                    e1Var.o(null);
                    e1Var.m(null, this);
                }
            }
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

    @Override // io.sentry.d1
    public final List G() {
        return this.f;
    }

    @Override // io.sentry.d1
    public final io.sentry.protocol.j0 H() {
        return this.c;
    }

    @Override // io.sentry.d1
    public final io.sentry.protocol.r I() {
        return this.e;
    }

    @Override // io.sentry.d1
    public final List J() {
        return io.sentry.util.b.w(this.k);
    }

    @Override // io.sentry.d1
    public final String K() {
        p1 p1Var = this.a;
        if (p1Var != null) {
            return p1Var.getName();
        }
        return null;
    }

    @Override // io.sentry.d1
    public final void L(x3 x3Var) {
        this.s = x3Var;
        b7 b7Var = new b7((io.sentry.protocol.w) x3Var.b, (d7) x3Var.c, "default", null);
        b7Var.z0 = "auto";
        Iterator<e1> it = this.l.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().m(b7Var, this);
        }
    }

    @Override // io.sentry.d1
    public final void c(g gVar, l0 l0Var) {
        if (gVar == null || (this.g instanceof b0) || io.sentry.util.m.a()) {
            return;
        }
        a6 beforeBreadcrumb = this.l.getBeforeBreadcrumb();
        if (beforeBreadcrumb != null) {
            if (l0Var == null) {
                l0Var = new l0();
            }
            try {
                ThreadLocal threadLocal = io.sentry.util.m.a;
                Integer num = (Integer) threadLocal.get();
                int iIntValue = 1;
                if (num != null) {
                    iIntValue = 1 + num.intValue();
                }
                threadLocal.set(Integer.valueOf(iIntValue));
                io.sentry.util.l lVar = io.sentry.util.m.b;
                try {
                    gVar = ((n2) beforeBreadcrumb).k(gVar, l0Var);
                    if (lVar != null) {
                        lVar.close();
                    }
                } finally {
                }
            } catch (Throwable th) {
                this.l.getLogger().d(p5.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. Exception details will be added to the breadcrumb.", th);
                if (th.getMessage() != null) {
                    gVar.d(th.getMessage(), "sentry:message");
                }
            }
        }
        if (gVar == null) {
            this.l.getLogger().h(p5.INFO, "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
            return;
        }
        this.g.add(gVar);
        for (e1 e1Var : this.l.getScopeObservers()) {
            e1Var.g(gVar);
            e1Var.i(this.g);
        }
    }

    @Override // io.sentry.d1
    public final void clear() {
        this.c = null;
        this.e = null;
        this.d = null;
        this.f.clear();
        this.g.clear();
        Iterator<e1> it = this.l.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().i(this.g);
        }
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.k.clear();
        m();
        this.r.clear();
        Iterator<e1> it2 = this.l.getScopeObservers().iterator();
        while (it2.hasNext()) {
            it2.next().k();
        }
        this.w.clear();
    }

    @Override // io.sentry.d1
    public final d1 clone() {
        return new f4(this);
    }

    @Override // io.sentry.d1
    public final io.sentry.protocol.j d() {
        return this.w.d();
    }

    @Override // io.sentry.d1
    public final io.sentry.protocol.w g() {
        return this.t;
    }

    @Override // io.sentry.d1
    public final Map getAttributes() {
        return io.sentry.util.b.o(this.i);
    }

    @Override // io.sentry.d1
    public final Map getExtras() {
        return this.j;
    }

    @Override // io.sentry.d1
    public final p6 getOptions() {
        return this.l;
    }

    @Override // io.sentry.d1
    public final void h(io.sentry.protocol.w wVar) {
        this.t = wVar;
        Iterator<e1> it = this.l.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().h(wVar);
        }
    }

    @Override // io.sentry.d1
    public final p1 i() {
        return this.a;
    }

    @Override // io.sentry.d1
    public final void j(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = this.h;
        if (str2 == null) {
            concurrentHashMap.remove(str);
            for (e1 e1Var : this.l.getScopeObservers()) {
                e1Var.p(str);
                e1Var.l(this.h);
            }
            return;
        }
        concurrentHashMap.put(str, str2);
        for (e1 e1Var2 : this.l.getScopeObservers()) {
            e1Var2.j(str, str2);
            e1Var2.l(this.h);
        }
    }

    @Override // io.sentry.d1
    public final z6 k() {
        io.sentry.util.a aVar = this.n;
        aVar.g();
        try {
            z6 z6Var = null;
            if (this.m != null) {
                z6 z6Var2 = this.m;
                z6Var2.getClass();
                z6Var2.b(new Date());
                this.l.getContinuousProfiler().d();
                z6 z6VarClone = this.m.clone();
                this.m = null;
                z6Var = z6VarClone;
            }
            aVar.close();
            return z6Var;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.d1
    public final io.sentry.internal.debugmeta.c l() {
        io.sentry.util.a aVar = this.n;
        aVar.g();
        try {
            if (this.m != null) {
                z6 z6Var = this.m;
                z6Var.getClass();
                z6Var.b(new Date());
                this.l.getContinuousProfiler().d();
            }
            z6 z6Var2 = this.m;
            io.sentry.internal.debugmeta.c cVar = null;
            if (this.l.getRelease() != null) {
                String distinctId = this.l.getDistinctId();
                io.sentry.protocol.j0 j0Var = this.c;
                this.m = new z6(y6.Ok, new Date(), new Date(), 0, distinctId, io.sentry.config.a.f(), Boolean.TRUE, null, null, j0Var != null ? j0Var.A : null, null, this.l.getEnvironment(), this.l.getRelease(), null);
                cVar = new io.sentry.internal.debugmeta.c(4, this.m.clone(), z6Var2 != null ? z6Var2.clone() : null);
            } else {
                this.l.getLogger().h(p5.WARNING, "Release is not set on SentryOptions. Session could not be started", new Object[0]);
            }
            aVar.close();
            return cVar;
        } catch (Throwable th) {
            try {
                aVar.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // io.sentry.d1
    public final void m() {
        io.sentry.util.a aVar = this.o;
        aVar.g();
        try {
            this.a = null;
            aVar.close();
            for (e1 e1Var : this.l.getScopeObservers()) {
                e1Var.o(null);
                e1Var.m(null, this);
            }
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.d1
    public final io.sentry.featureflags.b n() {
        return this.w;
    }

    @Override // io.sentry.d1
    public final n1 o() {
        n1 n1VarK;
        n1 n1Var = (n1) this.b.get();
        if (n1Var != null) {
            return n1Var;
        }
        p1 p1Var = this.a;
        return (p1Var == null || (n1VarK = p1Var.k()) == null) ? p1Var : n1VarK;
    }

    @Override // io.sentry.d1
    public final z6 p() {
        return this.m;
    }

    @Override // io.sentry.d1
    public final Queue q() {
        return this.g;
    }

    @Override // io.sentry.d1
    public final p5 r() {
        return null;
    }

    @Override // io.sentry.d1
    public final x3 s() {
        return this.s;
    }

    @Override // io.sentry.d1
    public final z6 t(d4 d4Var) {
        io.sentry.util.a aVar = this.n;
        aVar.g();
        try {
            d4Var.b(this.m);
            z6 z6VarClone = this.m != null ? this.m.clone() : null;
            aVar.close();
            return z6VarClone;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.d1
    public final void u(String str) {
        this.d = str;
        io.sentry.protocol.e eVar = this.q;
        io.sentry.protocol.a aVarD = eVar.d();
        if (aVarD == null) {
            aVarD = new io.sentry.protocol.a();
            eVar.m(aVarD);
        }
        if (str == null) {
            aVarD.z0 = null;
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            aVarD.z0 = arrayList;
        }
        Iterator<e1> it = this.l.getScopeObservers().iterator();
        while (it.hasNext()) {
            it.next().n(eVar);
        }
    }

    @Override // io.sentry.d1
    public final i1 v() {
        return this.u;
    }

    @Override // io.sentry.d1
    public final Map w() {
        return io.sentry.util.b.o(this.h);
    }

    @Override // io.sentry.d1
    public final List x() {
        return this.k;
    }

    @Override // io.sentry.d1
    public final List y() {
        return new CopyOnWriteArrayList(this.r);
    }

    @Override // io.sentry.d1
    public final void z(f5 f5Var) {
        if (!this.l.isTracingEnabled() || f5Var.a() == null) {
            return;
        }
        Map map = this.v;
        Throwable thA = f5Var.a();
        io.sentry.util.b.r(thA, "throwable cannot be null");
        while (thA.getCause() != null && thA.getCause() != thA) {
            thA = thA.getCause();
        }
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public final Object m3clone() {
        return new f4(this);
    }

    @Override // io.sentry.d1
    public final void E(io.sentry.protocol.w wVar) {
    }

    public f4(p6 p6Var) {
        io.sentry.featureflags.b aVar;
        this.b = new WeakReference(null);
        this.f = new ArrayList();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.k = new CopyOnWriteArrayList();
        this.n = new io.sentry.util.a();
        this.o = new io.sentry.util.a();
        this.p = new io.sentry.util.a();
        this.q = new io.sentry.protocol.e();
        this.r = new CopyOnWriteArrayList();
        this.t = io.sentry.protocol.w.f;
        this.u = d3.b;
        this.v = DesugarCollections.synchronizedMap(new WeakHashMap());
        io.sentry.util.b.r(p6Var, "SentryOptions is required.");
        this.l = p6Var;
        this.g = a(this.l.getMaxBreadcrumbs());
        int maxFeatureFlags = p6Var.getMaxFeatureFlags();
        if (maxFeatureFlags > 0) {
            aVar = new io.sentry.featureflags.a(maxFeatureFlags);
        } else {
            aVar = io.sentry.featureflags.c.b;
        }
        this.w = aVar;
        this.s = new x3();
    }
}
