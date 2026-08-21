package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class il3 extends z0 implements RandomAccess {
    public int A;
    public final Object[] b;
    public final int f;
    public int z;

    public il3(int i, Object[] objArr) {
        this.b = objArr;
        if (i < 0) {
            e04.f(dw2.A(i, "ring buffer filled size should not be negative but it is "));
            throw null;
        }
        if (i <= objArr.length) {
            this.f = objArr.length;
            this.A = i;
        } else {
            StringBuilder sbD = dw2.D("ring buffer filled size: ", i, " cannot be larger than the buffer size: ");
            sbD.append(objArr.length);
            throw new IllegalArgumentException(sbD.toString().toString());
        }
    }

    @Override // defpackage.g0
    public final int a() {
        return this.A;
    }

    public final void b() {
        if (4 > this.A) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = 4, size = " + this.A).toString());
        }
        int i = this.z;
        int i2 = this.f;
        int i3 = (i + 4) % i2;
        Object[] objArr = this.b;
        if (i > i3) {
            Arrays.fill(objArr, i, i2, (Object) null);
            Arrays.fill(objArr, 0, i3, (Object) null);
        } else {
            Arrays.fill(objArr, i, i3, (Object) null);
        }
        this.z = i3;
        this.A -= 4;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.A;
        if (i < 0 || i >= i2) {
            s53.k(fw.s(i, i2, "index: ", ", size: "));
            return null;
        }
        return this.b[(this.z + i) % this.f];
    }

    @Override // defpackage.z0, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new hl3(this);
    }

    @Override // defpackage.g0, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] objArr2;
        objArr.getClass();
        int length = objArr.length;
        int i = this.A;
        if (length < i) {
            objArr = Arrays.copyOf(objArr, i);
        }
        int i2 = this.A;
        int i3 = this.z;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            objArr2 = this.b;
            if (i5 >= i2 || i3 >= this.f) {
                break;
            }
            objArr[i5] = objArr2[i3];
            i5++;
            i3++;
        }
        while (i5 < i2) {
            objArr[i5] = objArr2[i4];
            i5++;
            i4++;
        }
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // defpackage.g0, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }
}
