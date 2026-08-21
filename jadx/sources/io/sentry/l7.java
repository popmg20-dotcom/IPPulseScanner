package io.sentry;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l7 extends io.sentry.hints.c implements io.sentry.hints.i, io.sentry.hints.l {
    public final AtomicReference A;

    public l7(long j, ILogger iLogger) {
        super(j, iLogger);
        this.A = new AtomicReference();
    }

    @Override // io.sentry.hints.c
    public final boolean f(io.sentry.protocol.w wVar) {
        io.sentry.protocol.w wVar2 = (io.sentry.protocol.w) this.A.get();
        return wVar2 != null && wVar2.equals(wVar);
    }

    @Override // io.sentry.hints.c
    public final void g(io.sentry.protocol.w wVar) {
        this.A.set(wVar);
    }
}
