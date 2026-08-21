package io.sentry.android.core;

import io.sentry.ILogger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f2 extends io.sentry.hints.c implements io.sentry.hints.b, io.sentry.hints.g {
    public final long A;
    public final boolean X;

    public f2(long j, ILogger iLogger, long j2, boolean z) {
        super(j, iLogger);
        this.A = j2;
        this.X = z;
    }

    @Override // io.sentry.hints.b
    public final boolean a() {
        return this.X;
    }

    @Override // io.sentry.hints.c
    public final boolean f(io.sentry.protocol.w wVar) {
        return true;
    }

    @Override // io.sentry.hints.c
    public final void g(io.sentry.protocol.w wVar) {
    }
}
