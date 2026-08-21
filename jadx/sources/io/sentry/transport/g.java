package io.sentry.transport;

import io.sentry.l0;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface g extends Closeable {
    void a(boolean z);

    void b(long j);

    io.sentry.android.core.internal.tombstone.c d();

    boolean e();

    void k0(io.sentry.internal.debugmeta.c cVar, l0 l0Var);

    void o(io.sentry.internal.debugmeta.c cVar);
}
