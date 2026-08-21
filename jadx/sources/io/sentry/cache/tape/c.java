package io.sentry.cache.tape;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator {
    public final h b;
    public final /* synthetic */ d f;

    public c(d dVar, h hVar) {
        this.f = dVar;
        this.b = hVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f.z.f((byte[]) this.b.next());
    }

    @Override // java.util.Iterator
    public final void remove() throws IOException {
        this.b.remove();
    }
}
