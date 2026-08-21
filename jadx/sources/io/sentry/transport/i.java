package io.sentry.transport;

import io.sentry.l0;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i implements io.sentry.cache.c {
    public static final i b = new i();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return Collections.emptyIterator();
    }

    @Override // io.sentry.cache.c
    public final boolean n(io.sentry.internal.debugmeta.c cVar, l0 l0Var) {
        return false;
    }

    @Override // io.sentry.cache.c
    public final void Q(io.sentry.internal.debugmeta.c cVar) {
    }
}
