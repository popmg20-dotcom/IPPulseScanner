package io.sentry.android.core;

import io.sentry.ILogger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends io.sentry.hints.c implements io.sentry.hints.b, io.sentry.hints.a {
    public final long A;
    public final boolean X;
    public final boolean Y;

    public b0(long j, ILogger iLogger, long j2, boolean z, boolean z2) {
        super(j, iLogger);
        this.A = j2;
        this.X = z;
        this.Y = z2;
    }

    @Override // io.sentry.hints.b
    public final boolean a() {
        return this.X;
    }

    @Override // io.sentry.hints.a
    public final Long b() {
        return Long.valueOf(this.A);
    }

    @Override // io.sentry.hints.a
    public final boolean c() {
        return false;
    }

    @Override // io.sentry.hints.a
    public final String e() {
        return this.Y ? "anr_background" : "anr_foreground";
    }

    @Override // io.sentry.hints.c
    public final boolean f(io.sentry.protocol.w wVar) {
        return true;
    }

    @Override // io.sentry.hints.c
    public final void g(io.sentry.protocol.w wVar) {
    }
}
