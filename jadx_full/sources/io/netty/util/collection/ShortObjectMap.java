package io.netty.util.collection;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface ShortObjectMap<V> extends Map<Short, V> {

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public interface PrimitiveEntry<V> {
        short key();

        void setValue(V v);

        V value();
    }

    boolean containsKey(short s);

    Iterable<PrimitiveEntry<V>> entries();

    V get(short s);

    V put(short s, V v);

    V remove(short s);
}
