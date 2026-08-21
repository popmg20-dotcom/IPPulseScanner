package io.sentry;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e3 implements j1 {
    public static final e3 a = new e3();

    @Override // io.sentry.j1
    public final Future b(Runnable runnable, long j) {
        return new FutureTask(new m0(1));
    }

    @Override // io.sentry.j1
    public final boolean isClosed() {
        return false;
    }

    @Override // io.sentry.j1
    public final Future submit(Runnable runnable) {
        return new FutureTask(new m0(2));
    }

    @Override // io.sentry.j1
    public final void a(long j) {
    }
}
