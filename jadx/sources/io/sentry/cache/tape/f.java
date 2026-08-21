package io.sentry.cache.tape;

import j$.util.DesugarCollections;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements Iterable, Closeable {
    public void clear() {
        x(size());
    }

    public abstract void g(Object obj);

    public final List s() {
        int iMin = Math.min(size(), size());
        ArrayList arrayList = new ArrayList(iMin);
        Iterator it = iterator();
        for (int i = 0; i < iMin; i++) {
            arrayList.add(it.next());
        }
        return DesugarCollections.unmodifiableList(arrayList);
    }

    public abstract int size();

    public abstract void x(int i);
}
