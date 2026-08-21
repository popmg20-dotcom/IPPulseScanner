package io.sentry;

import defpackage.ha0;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t implements n {
    public final boolean f;
    public final p6 g;
    public final io.sentry.util.a a = new io.sentry.util.a();
    public volatile Timer b = null;
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final ArrayList d = new ArrayList();
    public final ArrayList e = new ArrayList();

    public t(p6 p6Var) {
        boolean z = false;
        this.g = p6Var;
        for (a1 a1Var : p6Var.getPerformanceCollectors()) {
            if (a1Var instanceof b1) {
                this.d.add((b1) a1Var);
            }
            if (a1Var instanceof io.sentry.android.core.c2) {
                this.e.add((io.sentry.android.core.c2) a1Var);
            }
        }
        if (this.d.isEmpty() && this.e.isEmpty()) {
            z = true;
        }
        this.f = z;
    }

    @Override // io.sentry.n
    public final void a(String str) {
        if (this.f) {
            this.g.getLogger().h(p5.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        if (!this.c.containsKey(str)) {
            this.c.put(str, new s(this, null));
        }
        if (this.h.getAndSet(true)) {
            return;
        }
        io.sentry.util.a aVar = this.a;
        aVar.g();
        try {
            if (this.b == null) {
                this.b = new Timer(true);
            }
            this.b.schedule(new q(this), 0L);
            this.b.schedule(new r(this, new ArrayList()), 100L, 100L);
            aVar.close();
        } finally {
        }
    }

    @Override // io.sentry.n
    public final void b(a7 a7Var) throws Throwable {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((io.sentry.android.core.c2) it.next()).e(a7Var);
        }
    }

    @Override // io.sentry.n
    public final List c(String str) {
        ConcurrentHashMap concurrentHashMap = this.c;
        s sVar = (s) concurrentHashMap.remove(str);
        this.g.getLogger().h(p5.DEBUG, ha0.n("stop collecting performance info for ", str), new Object[0]);
        if (concurrentHashMap.isEmpty()) {
            close();
        }
        if (sVar != null) {
            return sVar.a;
        }
        return null;
    }

    @Override // io.sentry.n
    public final void close() {
        this.g.getLogger().h(p5.DEBUG, "stop collecting all performance info for transactions", new Object[0]);
        this.c.clear();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((io.sentry.android.core.c2) it.next()).d();
        }
        if (this.h.getAndSet(false)) {
            io.sentry.util.a aVar = this.a;
            aVar.g();
            try {
                if (this.b != null) {
                    this.b.cancel();
                    this.b = null;
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
    }

    @Override // io.sentry.n
    public final void d(a7 a7Var) {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((io.sentry.android.core.c2) it.next()).f(a7Var);
        }
    }

    @Override // io.sentry.n
    public final void e(x6 x6Var) {
        if (this.f) {
            this.g.getLogger().h(p5.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((io.sentry.android.core.c2) it.next()).f(x6Var);
        }
        String strA = x6Var.a.a();
        ConcurrentHashMap concurrentHashMap = this.c;
        if (!concurrentHashMap.containsKey(strA)) {
            concurrentHashMap.put(strA, new s(this, x6Var));
        }
        a(strA);
    }

    @Override // io.sentry.n
    public final List f(p1 p1Var) {
        this.g.getLogger().h(p5.DEBUG, "stop collecting performance info for transactions %s (%s)", p1Var.getName(), p1Var.r().b.a());
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((io.sentry.android.core.c2) it.next()).e(p1Var);
        }
        return c(p1Var.n().a());
    }
}
