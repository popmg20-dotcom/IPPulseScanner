package defpackage;

import j$.util.Collection;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class z94 extends ArrayList implements t94 {
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new c92(super.iterator());
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "/" + ((String) Collection.EL.stream(this).map(new hl(18)).collect(Collectors.joining("/")));
    }
}
