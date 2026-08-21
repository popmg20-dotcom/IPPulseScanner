package io.sentry;

import defpackage.o73;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a7 implements n1 {
    public final w4 a;
    public w4 b;
    public final b7 c;
    public final x6 d;
    public final f1 e;
    public final e7 h;
    public c7 i;
    public boolean f = false;
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final ConcurrentHashMap j = new ConcurrentHashMap();
    public final ConcurrentHashMap k = new ConcurrentHashMap();

    public a7(x6 x6Var, k4 k4Var, b7 b7Var, e7 e7Var, o73 o73Var) {
        new ConcurrentHashMap();
        this.c = b7Var;
        b7Var.z0 = e7Var.d;
        this.d = x6Var;
        io.sentry.util.b.r(k4Var, "Scopes are required");
        this.e = k4Var;
        this.h = e7Var;
        this.i = o73Var;
        w4 w4Var = e7Var.a;
        if (w4Var != null) {
            this.a = w4Var;
        } else {
            this.a = k4Var.getOptions().getDateProvider().a();
        }
    }

    @Override // io.sentry.n1
    public final u6 b() {
        b7 b7Var = this.c;
        io.sentry.protocol.w wVar = b7Var.b;
        d7 d7Var = b7Var.f;
        x3 x3Var = b7Var.A;
        return new u6(wVar, d7Var, x3Var == null ? null : (Boolean) x3Var.a);
    }

    @Override // io.sentry.n1
    public final n1 c(String str, w4 w4Var, u1 u1Var) {
        return l("activity.load", str, w4Var, u1Var, new e7());
    }

    @Override // io.sentry.n1
    public final void e(Number number, String str) {
        if (this.f) {
            this.e.getOptions().getLogger().h(p5.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.k.put(str, new io.sentry.protocol.n(number, (String) null));
        x6 x6Var = this.d;
        a7 a7Var = x6Var.b;
        if (a7Var == this || a7Var.k.containsKey(str)) {
            return;
        }
        x6Var.e(number, str);
    }

    @Override // io.sentry.n1
    public final void f(f7 f7Var) {
        t(f7Var, this.e.getOptions().getDateProvider().a());
    }

    @Override // io.sentry.n1
    public final void g() {
        f(this.c.Z);
    }

    @Override // io.sentry.n1
    public final String getDescription() {
        return this.c.Y;
    }

    @Override // io.sentry.n1
    public final f7 getStatus() {
        return this.c.Z;
    }

    @Override // io.sentry.n1
    public final void h(Object obj, String str) {
        ConcurrentHashMap concurrentHashMap = this.j;
        if (obj == null) {
            concurrentHashMap.remove(str);
        } else {
            concurrentHashMap.put(str, obj);
        }
    }

    @Override // io.sentry.n1
    public final boolean isFinished() {
        return this.f;
    }

    @Override // io.sentry.n1
    public final n1 l(String str, String str2, w4 w4Var, u1 u1Var, e7 e7Var) {
        if (this.f) {
            return h3.a;
        }
        d7 d7Var = this.c.f;
        x6 x6Var = this.d;
        b7 b7Var = x6Var.b.c;
        b7 b7Var2 = new b7(b7Var.b, new d7(), d7Var, str, null, b7Var.A, null, "manual");
        b7Var2.Y = str2;
        b7Var2.C0 = u1Var;
        e7Var.a = w4Var;
        return x6Var.x(b7Var2, e7Var);
    }

    @Override // io.sentry.n1
    public final void m(String str) {
        this.c.Y = str;
    }

    @Override // io.sentry.n1
    public final n1 o(String str) {
        if (this.f) {
            return h3.a;
        }
        d7 d7Var = this.c.f;
        e7 e7Var = new e7();
        x6 x6Var = this.d;
        b7 b7Var = x6Var.b.c;
        b7 b7Var2 = new b7(b7Var.b, new d7(), d7Var, "ui.load", null, b7Var.A, null, "manual");
        b7Var2.Y = str;
        b7Var2.C0 = u1.SENTRY;
        return x6Var.x(b7Var2, e7Var);
    }

    @Override // io.sentry.n1
    public final void q(String str, Long l, o2 o2Var) {
        if (this.f) {
            this.e.getOptions().getLogger().h(p5.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.k.put(str, new io.sentry.protocol.n(l, o2Var.apiName()));
        x6 x6Var = this.d;
        a7 a7Var = x6Var.b;
        if (a7Var == this || a7Var.k.containsKey(str)) {
            return;
        }
        x6Var.q(str, l, o2Var);
    }

    @Override // io.sentry.n1
    public final b7 r() {
        return this.c;
    }

    @Override // io.sentry.n1
    public final w4 s() {
        return this.b;
    }

    @Override // io.sentry.n1
    public final void t(f7 f7Var, w4 w4Var) {
        w4 w4Var2;
        w4 w4Var3;
        x6 x6Var = this.d;
        CopyOnWriteArrayList<a7> copyOnWriteArrayList = x6Var.c;
        b7 b7Var = this.c;
        d7 d7Var = b7Var.f;
        if (this.f || !this.g.compareAndSet(false, true)) {
            return;
        }
        b7Var.Z = f7Var;
        if (w4Var == null) {
            w4Var = this.e.getOptions().getDateProvider().a();
        }
        this.b = w4Var;
        e7 e7Var = this.h;
        if (e7Var.c) {
            List<a7> list = copyOnWriteArrayList;
            if (!x6Var.b.c.f.equals(d7Var)) {
                ArrayList arrayList = new ArrayList();
                for (a7 a7Var : copyOnWriteArrayList) {
                    d7 d7Var2 = a7Var.c.z;
                    if (d7Var2 != null && d7Var2.equals(d7Var)) {
                        arrayList.add(a7Var);
                    }
                }
                list = arrayList;
            }
            w4 w4Var4 = null;
            w4 w4Var5 = null;
            for (a7 a7Var2 : list) {
                if (w4Var4 == null || a7Var2.a.b(w4Var4) < 0) {
                    w4Var4 = a7Var2.a;
                }
                if (w4Var5 == null || ((w4Var3 = a7Var2.b) != null && w4Var3.b(w4Var5) > 0)) {
                    w4Var5 = a7Var2.b;
                }
            }
            if (e7Var.c && w4Var5 != null && (((w4Var2 = this.b) == null || w4Var2.b(w4Var5) > 0) && this.b != null)) {
                this.b = w4Var5;
            }
        }
        c7 c7Var = this.i;
        if (c7Var != null) {
            c7Var.d(this);
        }
        this.f = true;
    }

    @Override // io.sentry.n1
    public final w4 u() {
        return this.a;
    }

    public a7(j7 j7Var, x6 x6Var, k4 k4Var, k7 k7Var) {
        new ConcurrentHashMap();
        this.c = j7Var;
        j7Var.z0 = k7Var.d;
        this.d = x6Var;
        this.e = k4Var;
        this.i = null;
        w4 w4Var = k7Var.a;
        if (w4Var != null) {
            this.a = w4Var;
        } else {
            this.a = k4Var.getOptions().getDateProvider().a();
        }
        this.h = k7Var;
    }
}
