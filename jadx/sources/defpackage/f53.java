package defpackage;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f53 extends AbstractCollection {
    public final /* synthetic */ i53 b;

    public f53(i53 i53Var) {
        this.b = i53Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.b.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.b.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new c53(this.b, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.b.b.size();
    }
}
