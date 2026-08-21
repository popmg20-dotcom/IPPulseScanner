package io.sentry.exception;

import io.sentry.protocol.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a extends RuntimeException {
    public final boolean A;
    public final o b;
    public final Throwable f;
    public final Thread z;

    public a(o oVar, Throwable th, Thread thread, boolean z) {
        this.b = oVar;
        io.sentry.util.b.r(th, "Throwable is required.");
        this.f = th;
        this.z = thread;
        this.A = z;
    }
}
