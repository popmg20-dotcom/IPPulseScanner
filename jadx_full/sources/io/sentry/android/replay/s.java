package io.sentry.android.replay;

import io.sentry.android.core.h0;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Closeable {
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final io.sentry.util.a f = new io.sentry.util.a();
    public final h0 z = new h0(1, this);
    public final r A = new r(this);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.set(true);
        this.z.clear();
    }
}
