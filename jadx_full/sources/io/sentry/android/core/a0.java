package io.sentry.android.core;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements io.sentry.hints.a, io.sentry.hints.l {
    public final boolean b;

    public a0(boolean z) {
        this.b = z;
    }

    @Override // io.sentry.hints.a
    public final Long b() {
        return null;
    }

    @Override // io.sentry.hints.a
    public final boolean c() {
        return true;
    }

    @Override // io.sentry.hints.a
    public final String e() {
        return this.b ? "anr_background" : "anr_foreground";
    }
}
