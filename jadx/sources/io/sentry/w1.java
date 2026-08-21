package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements b1 {
    public final Runtime a = Runtime.getRuntime();

    @Override // io.sentry.b1
    public final void a(p3 p3Var) {
        Runtime runtime = this.a;
        p3Var.b = Long.valueOf(runtime.totalMemory() - runtime.freeMemory());
    }

    @Override // io.sentry.b1
    public final void c() {
    }
}
