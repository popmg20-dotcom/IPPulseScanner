package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class he implements Collection {
    public final /* synthetic */ ie b;

    public he(ie ieVar) {
        this.b = ieVar;
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
        this.b.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.b.a(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.b.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new ee(this.b, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        ie ieVar = this.b;
        int iA = ieVar.a(obj);
        if (iA < 0) {
            return false;
        }
        ieVar.g(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        ie ieVar = this.b;
        int i = ieVar.z;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (collection.contains(ieVar.i(i2))) {
                ieVar.g(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        ie ieVar = this.b;
        int i = ieVar.z;
        int i2 = 0;
        boolean z = false;
        while (i2 < i) {
            if (!collection.contains(ieVar.i(i2))) {
                ieVar.g(i2);
                i2--;
                i--;
                z = true;
            }
            i2++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.b.z;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        ie ieVar = this.b;
        int i = ieVar.z;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = ieVar.i(i2);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        ie ieVar = this.b;
        int i = ieVar.z;
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = ieVar.i(i2);
        }
        return objArr;
    }
}
