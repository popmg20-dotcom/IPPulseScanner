package io.netty.util.collection;

import defpackage.vp1;
import io.netty.util.collection.ShortObjectMap;
import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ShortCollections {
    private static final ShortObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private ShortCollections() {
    }

    public static <V> ShortObjectMap<V> emptyMap() {
        return (ShortObjectMap<V>) EMPTY_MAP;
    }

    public static <V> ShortObjectMap<V> unmodifiableMap(ShortObjectMap<V> shortObjectMap) {
        return new UnmodifiableMap(shortObjectMap);
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class EmptyMap implements ShortObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Iterable<ShortObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Short, Object>> entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Map
        public Set<Short> keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Object put(short s, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public int size() {
            return 0;
        }

        @Override // java.util.Map
        public Collection<Object> values() {
            return Collections.EMPTY_LIST;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public boolean containsKey(short s) {
            return false;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Object get(short s) {
            return null;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Object remove(short s) {
            return null;
        }

        @Override // java.util.Map
        public Object put(Short sh, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class UnmodifiableMap<V> implements ShortObjectMap<V> {
        private Iterable<ShortObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Short, V>> entrySet;
        private Set<Short> keySet;
        private final ShortObjectMap<V> map;
        private Collection<V> values;

        /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
        public class EntryImpl implements ShortObjectMap.PrimitiveEntry<V> {
            private final ShortObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(ShortObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.ShortObjectMap.PrimitiveEntry
            public short key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.ShortObjectMap.PrimitiveEntry
            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.ShortObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
        public class IteratorImpl implements Iterator<ShortObjectMap.PrimitiveEntry<V>> {
            final Iterator<ShortObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<ShortObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public ShortObjectMap.PrimitiveEntry<V> next() {
                if (hasNext()) {
                    return new EntryImpl(this.iter.next());
                }
                vp1.g();
                return null;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }
        }

        public UnmodifiableMap(ShortObjectMap<V> shortObjectMap) {
            this.map = shortObjectMap;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public boolean containsKey(short s) {
            return this.map.containsKey(s);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public Iterable<ShortObjectMap.PrimitiveEntry<V>> entries() {
            Iterable<ShortObjectMap.PrimitiveEntry<V>> iterable = this.entries;
            if (iterable != null) {
                return iterable;
            }
            Iterable<ShortObjectMap.PrimitiveEntry<V>> iterable2 = new Iterable<ShortObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.ShortCollections.UnmodifiableMap.1
                @Override // java.lang.Iterable
                public Iterator<ShortObjectMap.PrimitiveEntry<V>> iterator() {
                    UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                    return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                }
            };
            this.entries = iterable2;
            return iterable2;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Short, V>> entrySet() {
            Set<Map.Entry<Short, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<Short, V>> setUnmodifiableSet = DesugarCollections.unmodifiableSet(this.map.entrySet());
            this.entrySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public V get(short s) {
            return this.map.get(s);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set<Short> keySet() {
            Set<Short> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<Short> setUnmodifiableSet = DesugarCollections.unmodifiableSet(this.map.keySet());
            this.keySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public V put(short s, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Short, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.ShortObjectMap
        public V remove(short s) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionUnmodifiableCollection = DesugarCollections.unmodifiableCollection(this.map.values());
            this.values = collectionUnmodifiableCollection;
            return collectionUnmodifiableCollection;
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.map.get(obj);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Map
        public V put(Short sh, V v) {
            throw new UnsupportedOperationException("put");
        }
    }
}
