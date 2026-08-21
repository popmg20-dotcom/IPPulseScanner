package defpackage;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w93 extends k1 implements RandomAccess {
    public static final Object[] A;
    public static final w93 X;
    public Object[] f;
    public int z;

    static {
        Object[] objArr = new Object[0];
        A = objArr;
        X = new w93(objArr, 0, false);
    }

    public w93(Object[] objArr, int i, boolean z) {
        super(z);
        this.f = objArr;
        this.z = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.z)) {
            zo2.j(this.z, dw2.D("Index:", i, ", Size:"));
            return;
        }
        Object[] objArr = this.f;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[qe4.q(objArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, objArr2, 0, i);
            System.arraycopy(this.f, i, objArr2, i + 1, this.z - i);
            this.f = objArr2;
        }
        this.f[i] = obj;
        this.z++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.k1
    public final k1 c(int i) {
        if (i >= this.z) {
            return new w93(i == 0 ? A : Arrays.copyOf(this.f, i), this.z, true);
        }
        s53.d();
        return null;
    }

    public final void d(int i) {
        if (i < 0 || i >= this.z) {
            zo2.j(this.z, dw2.D("Index:", i, ", Size:"));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        d(i);
        return this.f[i];
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        d(i);
        Object[] objArr = this.f;
        Object obj = objArr[i];
        if (i < this.z - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.z--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        d(i);
        Object[] objArr = this.f;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.z;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i = this.z;
        Object[] objArrCopyOf = this.f;
        if (i == objArrCopyOf.length) {
            objArrCopyOf = Arrays.copyOf(this.f, qe4.q(objArrCopyOf.length, 3, 2, 1, 10));
            this.f = objArrCopyOf;
        }
        int i2 = this.z;
        this.z = i2 + 1;
        objArrCopyOf[i2] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
