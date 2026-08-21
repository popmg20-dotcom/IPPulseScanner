package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v implements g1 {
    public static final ThreadLocal a = new ThreadLocal();

    @Override // io.sentry.g1
    public final k1 a(f1 f1Var) {
        f1 f1Var2 = get();
        a.set(f1Var);
        return new u(f1Var2);
    }

    @Override // io.sentry.g1
    public final void close() {
        a.remove();
    }

    @Override // io.sentry.g1
    public final f1 get() {
        return (f1) a.get();
    }
}
