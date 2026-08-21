package io.netty.util.collection;

import defpackage.vp1;
import io.netty.util.collection.LongObjectMap;
import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class LongCollections {
    private static final LongObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private LongCollections() {
    }

    public static <V> LongObjectMap<V> emptyMap() {
        return (LongObjectMap<V>) EMPTY_MAP;
    }

    public static <V> LongObjectMap<V> unmodifiableMap(LongObjectMap<V> longObjectMap) {
        return new UnmodifiableMap(longObjectMap);
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class EmptyMap implements LongObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // io.netty.util.collection.LongObjectMap
        public boolean containsKey(long j) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, Object>> entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object get(long j) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Map
        public Set<Long> keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object put(long j, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Object remove(long j) {
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

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return false;
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            return null;
        }

        @Override // java.util.Map
        public Object put(Long l, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class UnmodifiableMap<V> implements LongObjectMap<V> {
        private Iterable<LongObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Long, V>> entrySet;
        private Set<Long> keySet;
        private final LongObjectMap<V> map;
        private Collection<V> values;

        /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
        public class EntryImpl implements LongObjectMap.PrimitiveEntry<V> {
            private final LongObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(LongObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public long key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.LongObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
        public class IteratorImpl implements Iterator<LongObjectMap.PrimitiveEntry<V>> {
            final Iterator<LongObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<LongObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public LongObjectMap.PrimitiveEntry<V> next() {
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

        public UnmodifiableMap(LongObjectMap<V> longObjectMap) {
            this.map = longObjectMap;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // io.netty.util.collection.LongObjectMap
        public boolean containsKey(long j) {
            return this.map.containsKey(j);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.collection.LongObjectMap
        public Iterable<LongObjectMap.PrimitiveEntry<V>> entries() {
            Iterable<LongObjectMap.PrimitiveEntry<V>> iterable = this.entries;
            if (iterable != null) {
                return iterable;
            }
            Iterable<LongObjectMap.PrimitiveEntry<V>> iterable2 = new Iterable<LongObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.LongCollections.UnmodifiableMap.1
                @Override // java.lang.Iterable
                public Iterator<LongObjectMap.PrimitiveEntry<V>> iterator() {
                    UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                    return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                }
            };
            this.entries = iterable2;
            return iterable2;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Long, V>> entrySet() {
            Set<Map.Entry<Long, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<Long, V>> setUnmodifiableSet = DesugarCollections.unmodifiableSet(this.map.entrySet());
            this.entrySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V get(long j) {
            return this.map.get(j);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set<Long> keySet() {
            Set<Long> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<Long> setUnmodifiableSet = DesugarCollections.unmodifiableSet(this.map.keySet());
            this.keySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V put(long j, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Long, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.LongObjectMap
        public V remove(long j) {
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
        public V put(Long l, V v) {
            throw new UnsupportedOperationException("put");
        }
    }
}
