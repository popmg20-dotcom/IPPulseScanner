package defpackage;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tb2 extends f1 implements RandomAccess, Serializable {
    public final tb2 A;
    public final ub2 X;
    public Object[] b;
    public final int f;
    public int z;

    public tb2(Object[] objArr, int i, int i2, tb2 tb2Var, ub2 ub2Var) {
        objArr.getClass();
        this.b = objArr;
        this.f = i;
        this.z = i2;
        this.A = tb2Var;
        this.X = ub2Var;
        ((AbstractList) this).modCount = ((AbstractList) ub2Var).modCount;
    }

    @Override // defpackage.f1
    public final int a() {
        f();
        return this.z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        g();
        f();
        int i2 = this.z;
        if (i < 0 || i > i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
        } else {
            e(this.f + i, obj);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        g();
        f();
        int i2 = this.z;
        if (i < 0 || i > i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return false;
        }
        int size = collection.size();
        d(this.f + i, collection, size);
        return size > 0;
    }

    @Override // defpackage.f1
    public final Object b(int i) {
        g();
        f();
        int i2 = this.z;
        if (i >= 0 && i < i2) {
            return h(this.f + i);
        }
        s53.k(fw.s(i, i2, "index: ", ", size: "));
        return null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.f, this.z);
    }

    public final void d(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        ub2 ub2Var = this.X;
        tb2 tb2Var = this.A;
        if (tb2Var != null) {
            tb2Var.d(i, collection, i2);
        } else {
            ub2 ub2Var2 = ub2.A;
            ub2Var.d(i, collection, i2);
        }
        this.b = ub2Var.b;
        this.z += i2;
    }

    public final void e(int i, Object obj) {
        ((AbstractList) this).modCount++;
        ub2 ub2Var = this.X;
        tb2 tb2Var = this.A;
        if (tb2Var != null) {
            tb2Var.e(i, obj);
        } else {
            ub2 ub2Var2 = ub2.A;
            ub2Var.e(i, obj);
        }
        this.b = ub2Var.b;
        this.z++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.b;
            int i = this.z;
            if (i == list.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (n12.c(objArr[this.f + i2], list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (((AbstractList) this.X).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (this.X.z) {
            vp1.q();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        f();
        int i2 = this.z;
        if (i >= 0 && i < i2) {
            return this.b[this.f + i];
        }
        s53.k(fw.s(i, i2, "index: ", ", size: "));
        return null;
    }

    public final Object h(int i) {
        Object objH;
        ((AbstractList) this).modCount++;
        tb2 tb2Var = this.A;
        if (tb2Var != null) {
            objH = tb2Var.h(i);
        } else {
            ub2 ub2Var = ub2.A;
            objH = this.X.h(i);
        }
        this.z--;
        return objH;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        f();
        Object[] objArr = this.b;
        int i = this.z;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[this.f + i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        tb2 tb2Var = this.A;
        if (tb2Var != null) {
            tb2Var.i(i, i2);
        } else {
            ub2 ub2Var = ub2.A;
            this.X.i(i, i2);
        }
        this.z -= i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i = 0; i < this.z; i++) {
            if (n12.c(this.b[this.f + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        return this.z == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i, int i2, Collection collection, boolean z) {
        int iJ;
        tb2 tb2Var = this.A;
        if (tb2Var != null) {
            iJ = tb2Var.j(i, i2, collection, z);
        } else {
            ub2 ub2Var = ub2.A;
            iJ = this.X.j(i, i2, collection, z);
        }
        if (iJ > 0) {
            ((AbstractList) this).modCount++;
        }
        this.z -= iJ;
        return iJ;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i = this.z - 1; i >= 0; i--) {
            if (n12.c(this.b[this.f + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        f();
        int i2 = this.z;
        if (i >= 0 && i <= i2) {
            return new sb2(this, i);
        }
        s53.k(fw.s(i, i2, "index: ", ", size: "));
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        g();
        f();
        return j(this.f, this.z, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        g();
        f();
        return j(this.f, this.z, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        g();
        f();
        int i2 = this.z;
        if (i < 0 || i >= i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return null;
        }
        Object[] objArr = this.b;
        int i3 = this.f;
        Object obj2 = objArr[i3 + i];
        objArr[i3 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        uf2.g(i, i2, this.z);
        return new tb2(this.b, this.f + i, i2 - i, this, this.X);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        f();
        int length = objArr.length;
        int i = this.z;
        Object[] objArr2 = this.b;
        int i2 = this.f;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i2, i + i2, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        qe.c0(0, i2, i + i2, objArr2, objArr);
        int i3 = this.z;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return yr2.m0(this.b, this.f, this.z, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.f + this.z, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.b;
        int i = this.z;
        int i2 = this.f;
        return qe.i0(objArr, i2, i + i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        g();
        f();
        int size = collection.size();
        d(this.f + this.z, collection, size);
        return size > 0;
    }
}
