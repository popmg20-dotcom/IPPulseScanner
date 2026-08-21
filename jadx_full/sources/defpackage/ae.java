package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ae extends f1 {
    public static final Object[] A = new Object[0];
    public int b;
    public Object[] f = A;
    public int z;

    @Override // defpackage.f1
    public final int a() {
        return this.z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2 = this.z;
        if (i < 0 || i > i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return;
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        i();
        d(this.z + 1);
        int iH = h(this.b + i);
        int i3 = this.z;
        if (i < ((i3 + 1) >> 1)) {
            int length = iH == 0 ? this.f.length - 1 : iH - 1;
            int i4 = this.b;
            int length2 = i4 == 0 ? this.f.length - 1 : i4 - 1;
            Object[] objArr = this.f;
            if (length >= i4) {
                objArr[length2] = objArr[i4];
                qe.c0(i4, i4 + 1, length + 1, objArr, objArr);
            } else {
                qe.c0(i4 - 1, i4, objArr.length, objArr, objArr);
                Object[] objArr2 = this.f;
                objArr2[objArr2.length - 1] = objArr2[0];
                qe.c0(0, 1, length + 1, objArr2, objArr2);
            }
            this.f[length] = obj;
            this.b = length2;
        } else {
            int iH2 = h(i3 + this.b);
            Object[] objArr3 = this.f;
            if (iH < iH2) {
                qe.c0(iH + 1, iH, iH2, objArr3, objArr3);
            } else {
                qe.c0(1, 0, iH2, objArr3, objArr3);
                Object[] objArr4 = this.f;
                objArr4[0] = objArr4[objArr4.length - 1];
                qe.c0(iH + 1, iH, objArr4.length - 1, objArr4, objArr4);
            }
            this.f[iH] = obj;
        }
        this.z++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        int i2 = this.z;
        if (i < 0 || i > i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return false;
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.z) {
            return addAll(collection);
        }
        i();
        d(collection.size() + this.z);
        int iH = h(this.z + this.b);
        int iH2 = h(this.b + i);
        int size = collection.size();
        if (i >= ((this.z + 1) >> 1)) {
            int i3 = iH2 + size;
            Object[] objArr = this.f;
            if (iH2 < iH) {
                int i4 = size + iH;
                if (i4 <= objArr.length) {
                    qe.c0(i3, iH2, iH, objArr, objArr);
                } else if (i3 >= objArr.length) {
                    qe.c0(i3 - objArr.length, iH2, iH, objArr, objArr);
                } else {
                    int length = iH - (i4 - objArr.length);
                    qe.c0(0, length, iH, objArr, objArr);
                    Object[] objArr2 = this.f;
                    qe.c0(i3, iH2, length, objArr2, objArr2);
                }
            } else {
                qe.c0(size, 0, iH, objArr, objArr);
                Object[] objArr3 = this.f;
                if (i3 >= objArr3.length) {
                    qe.c0(i3 - objArr3.length, iH2, objArr3.length, objArr3, objArr3);
                } else {
                    qe.c0(0, objArr3.length - size, objArr3.length, objArr3, objArr3);
                    Object[] objArr4 = this.f;
                    qe.c0(i3, iH2, objArr4.length - size, objArr4, objArr4);
                }
            }
            c(iH2, collection);
            return true;
        }
        int i5 = this.b;
        int length2 = i5 - size;
        Object[] objArr5 = this.f;
        if (iH2 < i5) {
            qe.c0(length2, i5, objArr5.length, objArr5, objArr5);
            Object[] objArr6 = this.f;
            if (size >= iH2) {
                qe.c0(objArr6.length - size, 0, iH2, objArr6, objArr6);
            } else {
                qe.c0(objArr6.length - size, 0, size, objArr6, objArr6);
                Object[] objArr7 = this.f;
                qe.c0(0, size, iH2, objArr7, objArr7);
            }
        } else if (length2 >= 0) {
            qe.c0(length2, i5, iH2, objArr5, objArr5);
        } else {
            length2 += objArr5.length;
            int i6 = iH2 - i5;
            int length3 = objArr5.length - length2;
            if (length3 >= i6) {
                qe.c0(length2, i5, iH2, objArr5, objArr5);
            } else {
                qe.c0(length2, i5, i5 + length3, objArr5, objArr5);
                Object[] objArr8 = this.f;
                qe.c0(0, this.b + length3, iH2, objArr8, objArr8);
            }
        }
        this.b = length2;
        c(f(iH2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        i();
        d(this.z + 1);
        int length = this.b;
        if (length == 0) {
            length = this.f.length;
        }
        int i = length - 1;
        this.b = i;
        this.f[i] = obj;
        this.z++;
    }

    public final void addLast(Object obj) {
        i();
        d(this.z + 1);
        this.f[h(this.z + this.b)] = obj;
        this.z++;
    }

    @Override // defpackage.f1
    public final Object b(int i) {
        int i2 = this.z;
        if (i < 0 || i >= i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return null;
        }
        if (i == a() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        i();
        int iH = h(this.b + i);
        Object[] objArr = this.f;
        Object obj = objArr[iH];
        int i3 = this.z >> 1;
        int i4 = this.b;
        if (i < i3) {
            if (iH >= i4) {
                qe.c0(i4 + 1, i4, iH, objArr, objArr);
            } else {
                qe.c0(1, 0, iH, objArr, objArr);
                Object[] objArr2 = this.f;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.b;
                qe.c0(i5 + 1, i5, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f;
            int i6 = this.b;
            objArr3[i6] = null;
            this.b = e(i6);
        } else {
            int iH2 = h((a() - 1) + i4);
            Object[] objArr4 = this.f;
            if (iH <= iH2) {
                qe.c0(iH, iH + 1, iH2 + 1, objArr4, objArr4);
            } else {
                qe.c0(iH, iH + 1, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f;
                objArr5[objArr5.length - 1] = objArr5[0];
                qe.c0(0, 1, iH2 + 1, objArr5, objArr5);
            }
            this.f[iH2] = null;
        }
        this.z--;
        return obj;
    }

    public final void c(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f.length;
        while (i < length && it.hasNext()) {
            this.f[i] = it.next();
            i++;
        }
        int i2 = this.b;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.f[i3] = it.next();
        }
        this.z = collection.size() + this.z;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            i();
            g(this.b, h(this.z + this.b));
        }
        this.b = 0;
        this.z = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0) {
            xe.q("Deque is too big.");
            return;
        }
        Object[] objArr = this.f;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == A) {
            if (i < 10) {
                i = 10;
            }
            this.f = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        qe.c0(0, this.b, objArr.length, objArr, objArr2);
        Object[] objArr3 = this.f;
        int length2 = objArr3.length;
        int i3 = this.b;
        qe.c0(length2 - i3, 0, i3, objArr3, objArr2);
        this.b = 0;
        this.f = objArr2;
    }

    public final int e(int i) {
        if (i == this.f.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int f(int i) {
        return i < 0 ? i + this.f.length : i;
    }

    public final void g(int i, int i2) {
        Object[] objArr = this.f;
        if (i < i2) {
            Arrays.fill(objArr, i, i2, (Object) null);
        } else {
            Arrays.fill(objArr, i, objArr.length, (Object) null);
            Arrays.fill(this.f, 0, i2, (Object) null);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.z;
        if (i >= 0 && i < i2) {
            return this.f[h(this.b + i)];
        }
        s53.k(fw.s(i, i2, "index: ", ", size: "));
        return null;
    }

    public final int h(int i) {
        Object[] objArr = this.f;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void i() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iH = h(this.z + this.b);
        int length = this.b;
        if (length < iH) {
            while (length < iH) {
                if (n12.c(obj, this.f[length])) {
                    i = this.b;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (isEmpty() || (length = this.b) < iH) {
            return -1;
        }
        int length2 = this.f.length;
        while (true) {
            if (length >= length2) {
                for (int i2 = 0; i2 < iH; i2++) {
                    if (n12.c(obj, this.f[i2])) {
                        length = i2 + this.f.length;
                        i = this.b;
                    }
                }
                return -1;
            }
            if (n12.c(obj, this.f[length])) {
                i = this.b;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iH = h(this.z + this.b);
        int i2 = this.b;
        if (i2 < iH) {
            length = iH - 1;
            if (i2 <= length) {
                while (!n12.c(obj, this.f[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.b;
                return length - i;
            }
            return -1;
        }
        if (!isEmpty() && this.b >= iH) {
            while (true) {
                iH--;
                Object[] objArr = this.f;
                if (-1 >= iH) {
                    length = objArr.length - 1;
                    int i3 = this.b;
                    if (i3 <= length) {
                        while (!n12.c(obj, this.f[length])) {
                            if (length != i3) {
                                length--;
                            }
                        }
                        i = this.b;
                    }
                } else if (n12.c(obj, objArr[iH])) {
                    length = iH + this.f.length;
                    i = this.b;
                    break;
                }
            }
            return length - i;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iH;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f.length != 0) {
            int iH2 = h(this.z + this.b);
            int i = this.b;
            if (i < iH2) {
                iH = i;
                while (true) {
                    objArr = this.f;
                    if (i >= iH2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.f[iH] = obj;
                        iH++;
                    }
                    i++;
                }
                Arrays.fill(objArr, iH, iH2, (Object) null);
            } else {
                int length = this.f.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.f;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.f[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iH = h(i2);
                for (int i3 = 0; i3 < iH2; i3++) {
                    Object[] objArr3 = this.f;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.f[iH] = obj3;
                        iH = e(iH);
                    }
                }
                z = z2;
            }
            if (z) {
                i();
                this.z = f(iH - this.b);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            e04.h("ArrayDeque is empty.");
            return null;
        }
        i();
        Object[] objArr = this.f;
        int i = this.b;
        Object obj = objArr[i];
        objArr[i] = null;
        this.b = e(i);
        this.z--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            e04.h("ArrayDeque is empty.");
            return null;
        }
        i();
        int iH = h((a() - 1) + this.b);
        Object[] objArr = this.f;
        Object obj = objArr[iH];
        objArr[iH] = null;
        this.z--;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        uf2.g(i, i2, this.z);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.z) {
            clear();
            return;
        }
        if (i3 == 1) {
            b(i);
            return;
        }
        i();
        int i4 = this.z - i2;
        int i5 = this.b;
        int i6 = this.b;
        if (i < i4) {
            int iH = h((i - 1) + i5);
            int iH2 = h((i2 - 1) + i6);
            while (i > 0) {
                int i7 = iH + 1;
                int iMin = Math.min(i, Math.min(i7, iH2 + 1));
                Object[] objArr = this.f;
                int i8 = iH2 - iMin;
                int i9 = iH - iMin;
                qe.c0(i8 + 1, i9 + 1, i7, objArr, objArr);
                iH = f(i9);
                iH2 = f(i8);
                i -= iMin;
            }
            int iH3 = h(this.b + i3);
            g(this.b, iH3);
            this.b = iH3;
        } else {
            int iH4 = h(i5 + i2);
            int iH5 = h(i6 + i);
            int i10 = this.z;
            while (true) {
                i10 -= i2;
                if (i10 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f;
                i2 = Math.min(i10, Math.min(objArr2.length - iH4, objArr2.length - iH5));
                Object[] objArr3 = this.f;
                int i11 = iH4 + i2;
                qe.c0(iH5, iH4, i11, objArr3, objArr3);
                iH4 = h(i11);
                iH5 = h(iH5 + i2);
            }
            int iH6 = h(this.z + this.b);
            g(f(iH6 - i3), iH6);
        }
        this.z -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iH;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f.length != 0) {
            int iH2 = h(this.z + this.b);
            int i = this.b;
            if (i < iH2) {
                iH = i;
                while (true) {
                    objArr = this.f;
                    if (i >= iH2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.f[iH] = obj;
                        iH++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Arrays.fill(objArr, iH, iH2, (Object) null);
            } else {
                int length = this.f.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.f;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.f[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iH = h(i2);
                for (int i3 = 0; i3 < iH2; i3++) {
                    Object[] objArr3 = this.f;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        this.f[iH] = obj3;
                        iH = e(iH);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                i();
                this.z = f(iH - this.b);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.z;
        if (i < 0 || i >= i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return null;
        }
        int iH = h(this.b + i);
        Object[] objArr = this.f;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i = this.z;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            objNewInstance.getClass();
            objArr = (Object[]) objNewInstance;
        }
        int iH = h(this.z + this.b);
        int i2 = this.b;
        if (i2 < iH) {
            qe.f0(i2, iH, 2, this.f, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f;
            qe.c0(0, this.b, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f;
            qe.c0(objArr3.length - this.b, 0, iH, objArr3, objArr);
        }
        int i3 = this.z;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        i();
        d(collection.size() + this.z);
        c(h(this.z + this.b), collection);
        return true;
    }
}
