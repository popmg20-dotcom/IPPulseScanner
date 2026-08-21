package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class me implements Collection, Set, a82 {
    public int[] b;
    public Object[] f;
    public int z;

    public me(int i) {
        this.b = co4.c;
        this.f = co4.d;
        if (i > 0) {
            this.b = new int[i];
            this.f = new Object[i];
        }
    }

    public final Object a(int i) {
        int i2 = this.z;
        Object[] objArr = this.f;
        Object obj = objArr[i];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i3 = i2 - 1;
        int[] iArr = this.b;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i3) {
                int i4 = i + 1;
                qe.e0(iArr, i, iArr, i4, i2);
                Object[] objArr2 = this.f;
                qe.c0(i, i4, i2, objArr2, objArr2);
            }
            this.f[i3] = null;
        } else {
            int i5 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            int[] iArr2 = new int[i5];
            this.b = iArr2;
            this.f = new Object[i5];
            if (i > 0) {
                qe.g0(iArr, 0, iArr2, i, 6);
                qe.f0(0, i, 6, objArr, this.f);
            }
            if (i < i3) {
                int i6 = i + 1;
                qe.e0(iArr, i, this.b, i6, i2);
                qe.c0(i, i6, i2, objArr, this.f);
            }
        }
        if (i2 != this.z) {
            throw new ConcurrentModificationException();
        }
        this.z = i3;
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int iR;
        int i2 = this.z;
        if (obj == null) {
            iR = ek0.r(this, null, 0);
            i = 0;
        } else {
            int iHashCode = obj.hashCode();
            i = iHashCode;
            iR = ek0.r(this, obj, iHashCode);
        }
        if (iR >= 0) {
            return false;
        }
        int i3 = ~iR;
        int[] iArr = this.b;
        if (i2 >= iArr.length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.f;
            int[] iArr2 = new int[i4];
            this.b = iArr2;
            this.f = new Object[i4];
            if (i2 != this.z) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                qe.g0(iArr, 0, iArr2, iArr.length, 6);
                qe.f0(0, objArr.length, 6, objArr, this.f);
            }
        }
        if (i3 < i2) {
            int[] iArr3 = this.b;
            int i5 = i3 + 1;
            qe.e0(iArr3, i5, iArr3, i3, i2);
            Object[] objArr2 = this.f;
            qe.c0(i5, i3, i2, objArr2, objArr2);
        }
        int i6 = this.z;
        if (i2 == i6) {
            int[] iArr4 = this.b;
            if (i3 < iArr4.length) {
                iArr4[i3] = i;
                this.f[i3] = obj;
                this.z = i6 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        collection.getClass();
        int size = collection.size() + this.z;
        int i = this.z;
        int[] iArr = this.b;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f;
            int[] iArr2 = new int[size];
            this.b = iArr2;
            this.f = new Object[size];
            if (i > 0) {
                qe.g0(iArr, 0, iArr2, i, 6);
                qe.f0(0, this.z, 6, objArr, this.f);
            }
        }
        if (this.z != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.z;
        if (i != 0) {
            this.b = co4.c;
            this.f = co4.d;
            i = 0;
            this.z = 0;
        }
        if (i != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? ek0.r(this, null, 0) : ek0.r(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.z != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.z;
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(this.f[i2])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.b;
        int i = this.z;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.z <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new ee(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iR = obj == null ? ek0.r(this, null, 0) : ek0.r(this, obj, obj.hashCode());
        if (iR < 0) {
            return false;
        }
        a(iR);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        boolean z = false;
        for (int i = this.z - 1; -1 < i; i--) {
            if (!d70.W(this.f[i], collection)) {
                a(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.z;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int i = this.z;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        qe.c0(0, 0, this.z, this.f, objArr);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.z * 14);
        sb.append('{');
        int i = this.z;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.f[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return qe.i0(this.f, 0, this.z);
    }
}
