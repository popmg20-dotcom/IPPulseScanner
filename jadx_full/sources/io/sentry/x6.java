package io.sentry;

import defpackage.ed;
import defpackage.m10;
import defpackage.o73;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x6 implements p1 {
    public final a7 b;
    public final k4 d;
    public final String e;
    public volatile Future g;
    public volatile Future h;
    public volatile boolean i;
    public final io.sentry.util.a j;
    public final io.sentry.util.a k;
    public final AtomicBoolean l;
    public final AtomicBoolean m;
    public final io.sentry.protocol.i0 n;
    public final u1 o;
    public final io.sentry.protocol.e p;
    public final n q;
    public final k7 r;
    public final io.sentry.protocol.w a = new io.sentry.protocol.w();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public w6 f = w6.c;

    public x6(j7 j7Var, k4 k4Var, k7 k7Var, n nVar) {
        this.i = false;
        io.sentry.util.a aVar = new io.sentry.util.a();
        this.j = aVar;
        this.k = new io.sentry.util.a();
        this.l = new AtomicBoolean(false);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.m = atomicBoolean;
        io.sentry.protocol.e eVar = new io.sentry.protocol.e();
        this.p = eVar;
        a7 a7Var = new a7(j7Var, this, k4Var, k7Var);
        this.b = a7Var;
        this.e = j7Var.G0;
        this.o = j7Var.C0;
        this.d = k4Var;
        Boolean bool = Boolean.TRUE;
        nVar = bool.equals(A()) ? nVar : null;
        this.q = nVar;
        this.n = j7Var.H0;
        this.r = k7Var;
        B(a7Var);
        io.sentry.protocol.w wVarZ = z();
        if (!wVarZ.equals(io.sentry.protocol.w.f) && bool.equals(A())) {
            eVar.k(new t3(wVarZ), "profile");
        }
        if (nVar != null) {
            nVar.e(this);
        }
        if (k7Var.g == null && k7Var.h == null) {
            return;
        }
        boolean z = true;
        this.i = true;
        Long l = k7Var.h;
        if (l != null) {
            aVar.g();
            try {
                if (this.i) {
                    v();
                    atomicBoolean.set(true);
                    try {
                        this.h = k4Var.getOptions().getTimerExecutorService().b(new v6(this, 1), l.longValue());
                    } catch (Throwable th) {
                        this.d.getOptions().getLogger().d(p5.WARNING, "Failed to schedule finish timer", th);
                        f7 status = getStatus();
                        if (status == null) {
                            status = f7.DEADLINE_EXCEEDED;
                        }
                        if (this.r.g == null) {
                            z = false;
                        }
                        d(status, z, null);
                        this.m.set(false);
                    }
                }
                aVar.close();
            } catch (Throwable th2) {
                try {
                    aVar.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        p();
    }

    public final Boolean A() {
        x3 x3Var = this.b.c.A;
        if (x3Var == null) {
            return null;
        }
        return (Boolean) x3Var.a;
    }

    public final void B(a7 a7Var) {
        io.sentry.util.thread.a threadChecker = this.d.getOptions().getThreadChecker();
        io.sentry.protocol.w wVarZ = z();
        if (!wVarZ.equals(io.sentry.protocol.w.f)) {
            Boolean bool = Boolean.TRUE;
            x3 x3Var = a7Var.c.A;
            if (bool.equals(x3Var == null ? null : (Boolean) x3Var.a)) {
                a7Var.h(wVarZ.a(), "profiler_id");
            }
        }
        a7Var.h(String.valueOf(threadChecker.b()), "thread.id");
        a7Var.h(threadChecker.a(), "thread.name");
    }

    public final void C(c cVar) {
        a7 a7Var = this.b;
        k4 k4Var = this.d;
        io.sentry.util.a aVar = this.k;
        aVar.g();
        try {
            if (cVar.f) {
                AtomicReference atomicReference = new AtomicReference();
                if (k4Var.isEnabled()) {
                    try {
                        atomicReference.set(k4Var.e.b(null).g());
                    } catch (Throwable th) {
                        k4Var.getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th);
                    }
                } else {
                    k4Var.getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
                }
                cVar.e(a7Var.c.b, (io.sentry.protocol.w) atomicReference.get(), k4Var.getOptions(), a7Var.c.A, this.e, this.n);
                cVar.f = false;
            }
            aVar.close();
        } finally {
        }
    }

    @Override // io.sentry.n1
    public final h7 a() {
        c cVar;
        if (!this.d.getOptions().isTraceSampling() || (cVar = this.b.c.D0) == null) {
            return null;
        }
        C(cVar);
        return cVar.f();
    }

    @Override // io.sentry.n1
    public final u6 b() {
        return this.b.b();
    }

    @Override // io.sentry.n1
    public final n1 c(String str, w4 w4Var, u1 u1Var) {
        return l("activity.load", str, w4Var, u1Var, new e7());
    }

    @Override // io.sentry.p1
    public final void d(f7 f7Var, boolean z, l0 l0Var) {
        if (this.b.f) {
            return;
        }
        w4 w4VarA = this.d.getOptions().getDateProvider().a();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.c);
        ListIterator listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            a7 a7Var = (a7) listIterator.previous();
            a7Var.i = null;
            a7Var.t(f7Var, w4VarA);
        }
        y(f7Var, w4VarA, z, l0Var);
    }

    @Override // io.sentry.n1
    public final void e(Number number, String str) {
        this.b.e(number, str);
    }

    @Override // io.sentry.n1
    public final void f(f7 f7Var) {
        t(f7Var, null);
    }

    @Override // io.sentry.n1
    public final void g() {
        t(getStatus(), null);
    }

    @Override // io.sentry.n1
    public final String getDescription() {
        return this.b.c.Y;
    }

    @Override // io.sentry.p1
    public final String getName() {
        return this.e;
    }

    @Override // io.sentry.n1
    public final f7 getStatus() {
        return this.b.c.Z;
    }

    @Override // io.sentry.n1
    public final void h(Object obj, String str) {
        a7 a7Var = this.b;
        if (a7Var.f) {
            this.d.getOptions().getLogger().h(p5.DEBUG, "The transaction is already finished. Data %s cannot be set", str);
        } else {
            a7Var.h(obj, str);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.sentry.n1
    public final d i() {
        c cVar;
        String str;
        int i;
        String str2;
        String str3;
        String str4 = "%20";
        String str5 = "\\+";
        if (!this.d.getOptions().isTraceSampling() || (cVar = this.b.c.D0) == null) {
            return null;
        }
        ILogger iLogger = cVar.h;
        C(cVar);
        char c = 1;
        String str6 = c.a(iLogger, null, true).e;
        ConcurrentHashMap concurrentHashMap = cVar.a;
        StringBuilder sb = new StringBuilder();
        if (str6 == null || str6.isEmpty()) {
            str = "";
            i = 0;
        } else {
            sb.append(str6);
            Charset charset = io.sentry.util.p.a;
            int i2 = 0;
            for (int i3 = 0; i3 < str6.length(); i3++) {
                if (str6.charAt(i3) == ',') {
                    i2++;
                }
            }
            i = i2 + 1;
            str = ",";
        }
        io.sentry.util.a aVar = cVar.b;
        aVar.g();
        try {
            TreeSet<String> treeSet = new TreeSet(Collections.list(concurrentHashMap.keys()));
            aVar.close();
            treeSet.add("sentry-sample_rate");
            treeSet.add("sentry-sample_rand");
            int i4 = i;
            String str7 = str;
            for (String str8 : treeSet) {
                char c2 = c;
                String strC = "sentry-sample_rate".equals(str8) ? c.c(cVar.c) : "sentry-sample_rand".equals(str8) ? c.c(cVar.d) : (String) concurrentHashMap.get(str8);
                c cVar2 = cVar;
                if (strC == null) {
                    str2 = str4;
                    str3 = str5;
                } else if (i4 >= 64) {
                    p5 p5Var = p5.ERROR;
                    Object[] objArr = new Object[2];
                    objArr[0] = str8;
                    objArr[c2] = 64;
                    iLogger.h(p5Var, "Not adding baggage value %s as the total number of list members would exceed the maximum of %s.", objArr);
                    str2 = str4;
                    str3 = str5;
                } else {
                    try {
                        str2 = str4;
                    } catch (Throwable th) {
                        th = th;
                        str2 = str4;
                    }
                    try {
                        String str9 = str7 + URLEncoder.encode(str8, "UTF-8").replaceAll(str5, str4) + "=" + URLEncoder.encode(strC, "UTF-8").replaceAll(str5, str4);
                        if (sb.length() + str9.length() > 8192) {
                            p5 p5Var2 = p5.ERROR;
                            str3 = str5;
                            try {
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = str8;
                                objArr2[c2] = 8192;
                                iLogger.h(p5Var2, "Not adding baggage value %s as the total header value length would exceed the maximum of %s.", objArr2);
                            } catch (Throwable th2) {
                                th = th2;
                                p5 p5Var3 = p5.ERROR;
                                Object[] objArr3 = new Object[2];
                                objArr3[0] = str8;
                                objArr3[c2] = strC;
                                iLogger.b(p5Var3, th, "Unable to encode baggage key value pair (key=%s,value=%s).", objArr3);
                            }
                        } else {
                            str3 = str5;
                            i4++;
                            sb.append(str9);
                            str7 = ",";
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = str5;
                        p5 p5Var32 = p5.ERROR;
                        Object[] objArr32 = new Object[2];
                        objArr32[0] = str8;
                        objArr32[c2] = strC;
                        iLogger.b(p5Var32, th, "Unable to encode baggage key value pair (key=%s,value=%s).", objArr32);
                        c = c2;
                        cVar = cVar2;
                        str4 = str2;
                        str5 = str3;
                    }
                }
                c = c2;
                cVar = cVar2;
                str4 = str2;
                str5 = str3;
            }
            String string = sb.toString();
            if (string.isEmpty()) {
                return null;
            }
            d dVar = new d();
            dVar.a = string;
            return dVar;
        } finally {
        }
    }

    @Override // io.sentry.n1
    public final boolean isFinished() {
        return this.b.f;
    }

    @Override // io.sentry.n1
    public final void j() {
        k4 k4Var = this.d;
        if (!k4Var.isEnabled()) {
            k4Var.getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            k4Var.e.b(null).F(this);
        } catch (Throwable th) {
            k4Var.getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.p1
    public final n1 k() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.c);
        ListIterator listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()) {
            a7 a7Var = (a7) listIterator.previous();
            if (!a7Var.f) {
                return a7Var;
            }
        }
        return null;
    }

    @Override // io.sentry.n1
    public final n1 l(String str, String str2, w4 w4Var, u1 u1Var, e7 e7Var) {
        boolean z = this.b.f;
        h3 h3Var = h3.a;
        if (z || !this.o.equals(u1Var)) {
            return h3Var;
        }
        int size = this.c.size();
        k4 k4Var = this.d;
        if (size < k4Var.getOptions().getMaxSpans()) {
            return this.b.l(str, str2, w4Var, u1Var, e7Var);
        }
        k4Var.getOptions().getLogger().h(p5.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return h3Var;
    }

    @Override // io.sentry.n1
    public final void m(String str) {
        a7 a7Var = this.b;
        if (a7Var.f) {
            this.d.getOptions().getLogger().h(p5.DEBUG, "The transaction is already finished. Description %s cannot be set", str);
        } else {
            a7Var.c.Y = str;
        }
    }

    @Override // io.sentry.p1
    public final io.sentry.protocol.w n() {
        return this.a;
    }

    @Override // io.sentry.n1
    public final n1 o(String str) {
        return l("ui.load", str, null, u1.SENTRY, new e7());
    }

    @Override // io.sentry.p1
    public final void p() {
        Long l;
        io.sentry.util.a aVar = this.j;
        aVar.g();
        try {
            if (this.i && (l = this.r.g) != null) {
                w();
                this.l.set(true);
                try {
                    this.g = this.d.getOptions().getTimerExecutorService().b(new v6(this, 0), l.longValue());
                } catch (Throwable th) {
                    this.d.getOptions().getLogger().d(p5.WARNING, "Failed to schedule finish timer", th);
                    f7 status = getStatus();
                    if (status == null) {
                        status = f7.OK;
                    }
                    f(status);
                    this.l.set(false);
                }
            }
            aVar.close();
        } catch (Throwable th2) {
            try {
                aVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // io.sentry.n1
    public final void q(String str, Long l, o2 o2Var) {
        this.b.q(str, l, o2Var);
    }

    @Override // io.sentry.n1
    public final b7 r() {
        return this.b.c;
    }

    @Override // io.sentry.n1
    public final w4 s() {
        return this.b.b;
    }

    @Override // io.sentry.n1
    public final void t(f7 f7Var, w4 w4Var) {
        y(f7Var, w4Var, true, null);
    }

    @Override // io.sentry.n1
    public final w4 u() {
        return this.b.a;
    }

    public final void v() {
        io.sentry.util.a aVar = this.j;
        aVar.g();
        try {
            if (this.h != null) {
                this.h.cancel(false);
                this.m.set(false);
                this.h = null;
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

    public final void w() {
        io.sentry.util.a aVar = this.j;
        aVar.g();
        try {
            if (this.g != null) {
                this.g.cancel(false);
                this.l.set(false);
                this.g = null;
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

    public final n1 x(b7 b7Var, e7 e7Var) {
        boolean z = this.b.f;
        h3 h3Var = h3.a;
        if (!z && this.o.equals(b7Var.C0)) {
            k4 k4Var = this.d;
            if (!io.sentry.util.o.a(e7Var.d, k4Var.getOptions().getIgnoredSpanOrigins())) {
                d7 d7Var = b7Var.z;
                String str = b7Var.X;
                String str2 = b7Var.Y;
                CopyOnWriteArrayList copyOnWriteArrayList = this.c;
                if (copyOnWriteArrayList.size() >= k4Var.getOptions().getMaxSpans()) {
                    k4Var.getOptions().getLogger().h(p5.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
                    return h3Var;
                }
                io.sentry.util.b.r(d7Var, "parentSpanId is required");
                io.sentry.util.b.r(str, "operation is required");
                w();
                a7 a7Var = new a7(this, this.d, b7Var, e7Var, new o73(17, this));
                B(a7Var);
                copyOnWriteArrayList.add(a7Var);
                n nVar = this.q;
                if (nVar != null) {
                    nVar.d(a7Var);
                }
                return a7Var;
            }
        }
        return h3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(f7 f7Var, w4 w4Var, boolean z, l0 l0Var) {
        v3 v3VarE;
        w4 w4Var2 = this.b.b;
        if (w4Var == null) {
            w4Var = w4Var2;
        }
        if (w4Var == null) {
            w4Var = this.d.getOptions().getDateProvider().a();
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            e7 e7Var = ((a7) it.next()).h;
        }
        this.f = new w6(true, f7Var);
        if (this.b.f) {
            return;
        }
        if (this.r.f) {
            ListIterator listIterator = this.c.listIterator();
            while (listIterator.hasNext()) {
                a7 a7Var = (a7) listIterator.next();
                if (!a7Var.f && a7Var.b == null) {
                    return;
                }
            }
        }
        AtomicReference atomicReference = new AtomicReference();
        a7 a7Var2 = this.b;
        a7Var2.i = new m10(10, this, a7Var2.i, atomicReference);
        a7Var2.t(this.f.b, w4Var);
        Boolean bool = Boolean.TRUE;
        if (bool.equals(A())) {
            x3 x3Var = this.b.c.A;
            if (bool.equals(x3Var == null ? null : (Boolean) x3Var.d)) {
                v3VarE = this.d.getOptions().getTransactionProfiler().e(this, (List) atomicReference.get(), this.d.getOptions());
            }
        } else {
            v3VarE = null;
        }
        if (this.d.getOptions().isContinuousProfilingEnabled()) {
            u3 profileLifecycle = this.d.getOptions().getProfileLifecycle();
            u3 u3Var = u3.TRACE;
            if (profileLifecycle == u3Var && this.b.c.F0.equals(io.sentry.protocol.w.f)) {
                this.d.getOptions().getContinuousProfiler().b(u3Var);
            }
        }
        if (atomicReference.get() != null) {
            ((List) atomicReference.get()).clear();
        }
        k4 k4Var = this.d;
        if (k4Var.isEnabled()) {
            try {
                d1 d1VarB = k4Var.e.b(null);
                d1VarB.D(new ed(22, this, d1VarB));
            } catch (Throwable th) {
                k4Var.getOptions().getLogger().d(p5.ERROR, "Error in the 'configureScope' callback.", th);
            }
        } else {
            k4Var.getOptions().getLogger().h(p5.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
        }
        io.sentry.protocol.f0 f0Var = new io.sentry.protocol.f0(this);
        if (this.i) {
            io.sentry.util.a aVar = this.j;
            aVar.g();
            try {
                if (this.i) {
                    w();
                    v();
                    this.i = false;
                }
                aVar.close();
            } catch (Throwable th2) {
                try {
                    aVar.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (z && this.c.isEmpty() && this.r.g != null) {
            this.d.getOptions().getLogger().h(p5.DEBUG, "Dropping idle transaction %s because it has no child spans", this.e);
        } else {
            f0Var.K0.putAll(this.b.k);
            this.d.z(f0Var, a(), l0Var, v3VarE);
        }
    }

    public final io.sentry.protocol.w z() {
        a7 a7Var = this.b;
        return !a7Var.c.F0.equals(io.sentry.protocol.w.f) ? a7Var.c.F0 : this.d.getOptions().getContinuousProfiler().e();
    }
}
