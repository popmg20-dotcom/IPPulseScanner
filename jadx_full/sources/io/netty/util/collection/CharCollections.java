package io.netty.util.collection;

import defpackage.vp1;
import io.netty.util.collection.CharObjectMap;
import j$.util.DesugarCollections;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class CharCollections {
    private static final CharObjectMap<Object> EMPTY_MAP = new EmptyMap();

    private CharCollections() {
    }

    public static <V> CharObjectMap<V> emptyMap() {
        return (CharObjectMap<V>) EMPTY_MAP;
    }

    public static <V> CharObjectMap<V> unmodifiableMap(CharObjectMap<V> charObjectMap) {
        return new UnmodifiableMap(charObjectMap);
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class EmptyMap implements CharObjectMap<Object> {
        private EmptyMap() {
        }

        @Override // io.netty.util.collection.CharObjectMap
        public boolean containsKey(char c) {
            return false;
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Iterable<CharObjectMap.PrimitiveEntry<Object>> entries() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Character, Object>> entrySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Object get(char c) {
            return null;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.Map
        public Set<Character> keySet() {
            return Collections.EMPTY_SET;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Object put(char c, Object obj) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ?> map) {
            throw new UnsupportedOperationException();
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Object remove(char c) {
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
        public Object put(Character ch, Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class UnmodifiableMap<V> implements CharObjectMap<V> {
        private Iterable<CharObjectMap.PrimitiveEntry<V>> entries;
        private Set<Map.Entry<Character, V>> entrySet;
        private Set<Character> keySet;
        private final CharObjectMap<V> map;
        private Collection<V> values;

        /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
        public class EntryImpl implements CharObjectMap.PrimitiveEntry<V> {
            private final CharObjectMap.PrimitiveEntry<V> entry;

            public EntryImpl(CharObjectMap.PrimitiveEntry<V> primitiveEntry) {
                this.entry = primitiveEntry;
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public char key() {
                return this.entry.key();
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public void setValue(V v) {
                throw new UnsupportedOperationException("setValue");
            }

            @Override // io.netty.util.collection.CharObjectMap.PrimitiveEntry
            public V value() {
                return this.entry.value();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
        public class IteratorImpl implements Iterator<CharObjectMap.PrimitiveEntry<V>> {
            final Iterator<CharObjectMap.PrimitiveEntry<V>> iter;

            public IteratorImpl(Iterator<CharObjectMap.PrimitiveEntry<V>> it) {
                this.iter = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.iter.hasNext();
            }

            @Override // java.util.Iterator
            public CharObjectMap.PrimitiveEntry<V> next() {
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

        public UnmodifiableMap(CharObjectMap<V> charObjectMap) {
            this.map = charObjectMap;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("clear");
        }

        @Override // io.netty.util.collection.CharObjectMap
        public boolean containsKey(char c) {
            return this.map.containsKey(c);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        @Override // io.netty.util.collection.CharObjectMap
        public Iterable<CharObjectMap.PrimitiveEntry<V>> entries() {
            Iterable<CharObjectMap.PrimitiveEntry<V>> iterable = this.entries;
            if (iterable != null) {
                return iterable;
            }
            Iterable<CharObjectMap.PrimitiveEntry<V>> iterable2 = new Iterable<CharObjectMap.PrimitiveEntry<V>>() { // from class: io.netty.util.collection.CharCollections.UnmodifiableMap.1
                @Override // java.lang.Iterable
                public Iterator<CharObjectMap.PrimitiveEntry<V>> iterator() {
                    UnmodifiableMap unmodifiableMap = UnmodifiableMap.this;
                    return new IteratorImpl(unmodifiableMap.map.entries().iterator());
                }
            };
            this.entries = iterable2;
            return iterable2;
        }

        @Override // java.util.Map
        public Set<Map.Entry<Character, V>> entrySet() {
            Set<Map.Entry<Character, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<Character, V>> setUnmodifiableSet = DesugarCollections.unmodifiableSet(this.map.entrySet());
            this.entrySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public V get(char c) {
            return this.map.get(c);
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override // java.util.Map
        public Set<Character> keySet() {
            Set<Character> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<Character> setUnmodifiableSet = DesugarCollections.unmodifiableSet(this.map.keySet());
            this.keySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // io.netty.util.collection.CharObjectMap
        public V put(char c, V v) {
            throw new UnsupportedOperationException("put");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends Character, ? extends V> map) {
            throw new UnsupportedOperationException("putAll");
        }

        @Override // io.netty.util.collection.CharObjectMap
        public V remove(char c) {
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
        public V put(Character ch, V v) {
            throw new UnsupportedOperationException("put");
        }
    }
}
