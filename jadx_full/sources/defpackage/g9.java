package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g9 implements Iterable {
    public LinkedHashMap b;

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        LinkedHashMap linkedHashMap = this.b;
        return linkedHashMap == null ? Collections.emptyIterator() : linkedHashMap.values().iterator();
    }
}
