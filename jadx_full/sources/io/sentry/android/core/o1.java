package io.sentry.android.core;

import io.sentry.p6;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o1 implements io.sentry.z0 {
    public final p6 a;
    public final long b;

    public o1(p6 p6Var, long j) {
        this.a = p6Var;
        this.b = j;
    }

    @Override // io.sentry.z0
    public final void g(String str) {
        io.sentry.cache.a.d(this.a, Long.toString(this.b), ".options-cache", "app-last-update-time.json");
    }

    @Override // io.sentry.z0
    public final void a(Map map) {
    }

    @Override // io.sentry.z0
    public final void b(io.sentry.protocol.u uVar) {
    }

    @Override // io.sentry.z0
    public final void c(String str) {
    }

    @Override // io.sentry.z0
    public final void d(Double d) {
    }

    @Override // io.sentry.z0
    public final void e(String str) {
    }

    @Override // io.sentry.z0
    public final void f(String str) {
    }
}
