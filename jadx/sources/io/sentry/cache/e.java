package io.sentry.cache;

import defpackage.b0;
import defpackage.o73;
import io.sentry.android.core.z;
import io.sentry.b7;
import io.sentry.f4;
import io.sentry.g;
import io.sentry.i4;
import io.sentry.i5;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.w;
import io.sentry.util.f;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e extends i4 {
    public static final Charset c = Charset.forName("UTF-8");
    public final p6 a;
    public final f b = new f(new o73(28, this));

    public e(p6 p6Var) {
        this.a = p6Var;
    }

    public final void a(String str) {
        a.a(this.a, ".scope-cache", str);
    }

    public final Object b(p6 p6Var, String str, Class cls) {
        if (!str.equals("breadcrumbs.json")) {
            return a.c(p6Var, ".scope-cache", str, cls);
        }
        try {
            return cls.cast(((io.sentry.cache.tape.f) this.b.a()).s());
        } catch (IOException unused) {
            p6Var.getLogger().h(p5.ERROR, "Unable to read serialized breadcrumbs from QueueFile", new Object[0]);
            return null;
        }
    }

    public final void c(Runnable runnable) {
        p6 p6Var = this.a;
        if (p6Var.isEnableScopePersistence()) {
            if (Thread.currentThread() instanceof i5) {
                try {
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    p6Var.getLogger().d(p5.ERROR, "Serialization task failed", th);
                    return;
                }
            }
            try {
                p6Var.getExecutorService().submit(new z(18, this, runnable));
            } catch (Throwable th2) {
                p6Var.getLogger().d(p5.ERROR, "Serialization task could not be scheduled", th2);
            }
        }
    }

    public final void d(Object obj, String str) {
        a.d(this.a, obj, ".scope-cache", str);
    }

    @Override // io.sentry.e1
    public final void g(g gVar) {
        c(new z(14, this, gVar));
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void h(w wVar) {
        c(new z(16, this, wVar));
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void i(Collection collection) {
        if (collection.isEmpty()) {
            c(new io.sentry.android.core.g(14, this));
        }
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void l(ConcurrentHashMap concurrentHashMap) {
        c(new z(13, this, concurrentHashMap));
    }

    @Override // io.sentry.e1
    public final void m(b7 b7Var, f4 f4Var) {
        c(new b0(21, this, b7Var, f4Var));
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void n(io.sentry.protocol.e eVar) {
        c(new z(15, this, eVar));
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void o(String str) {
        c(new z(17, this, str));
    }
}
