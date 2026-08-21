package io.sentry;

import defpackage.bx1;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {
    public static volatile o0 g;
    public static final io.sentry.util.a h = new io.sentry.util.a();
    public final long a;
    public volatile String b;
    public volatile long c;
    public final AtomicBoolean d;
    public final m0 e;
    public final ExecutorService f;

    public o0() {
        m0 m0Var = new m0(0);
        this.d = new AtomicBoolean(false);
        this.f = Executors.newSingleThreadExecutor(new n0(0));
        this.a = 18000000L;
        this.e = m0Var;
        b();
    }

    public static o0 a() {
        if (g == null) {
            io.sentry.util.a aVar = h;
            aVar.g();
            try {
                if (g == null) {
                    g = new o0();
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
        return g;
    }

    public final void b() {
        try {
            this.f.submit(new bx1(1, this)).get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.c = System.currentTimeMillis() + 1000;
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            this.c = System.currentTimeMillis() + 1000;
        }
    }
}
