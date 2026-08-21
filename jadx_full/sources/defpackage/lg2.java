package defpackage;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lg2 implements Collection {
    public final og2 b;
    public final Collection f;

    public lg2(og2 og2Var, Collection collection) {
        this.b = og2Var;
        this.f = collection;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.b.Z();
        this.f.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f.contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return this.f.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new gr1(this.b, this.f.iterator());
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        this.b.Z();
        return this.f.remove(obj);
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        this.b.Z();
        return this.f.removeAll(collection);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        this.b.Z();
        return this.f.retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f.size();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return this.f.toArray();
    }

    public final String toString() {
        return this.f.toString();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f.toArray(objArr);
    }
}
