package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x02 extends k1 implements RandomAccess {
    public static final int[] A;
    public static final x02 X;
    public int[] f;
    public int z;

    static {
        int[] iArr = new int[0];
        A = iArr;
        X = new x02(iArr, 0, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public x02(x02 x02Var, boolean z) {
        int i = x02Var.z;
        this(i == 0 ? A : Arrays.copyOf(x02Var.f, i), x02Var.z, z);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.z)) {
            zo2.j(this.z, dw2.D("Index:", i, ", Size:"));
            return;
        }
        int[] iArr = this.f;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[qe4.q(iArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, iArr2, 0, i);
            System.arraycopy(this.f, i, iArr2, i + 1, this.z - i);
            this.f = iArr2;
        }
        this.f[i] = iIntValue;
        this.z++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.k1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = i12.a;
        collection.getClass();
        if (!(collection instanceof x02)) {
            return super.addAll(collection);
        }
        x02 x02Var = (x02) collection;
        int i = x02Var.z;
        if (i == 0) {
            return false;
        }
        int i2 = this.z;
        if (ChannelUtils.WRITE_STATUS_SNDBUF_FULL - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArrCopyOf = this.f;
        if (i3 > iArrCopyOf.length) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i3);
            this.f = iArrCopyOf;
        }
        System.arraycopy(x02Var.f, 0, iArrCopyOf, this.z, x02Var.z);
        this.z = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // defpackage.k1
    public final k1 c(int i) {
        if (i >= this.z) {
            return new x02(i == 0 ? A : Arrays.copyOf(this.f, i), this.z, true);
        }
        s53.d();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        a();
        int i2 = this.z;
        int[] iArr = this.f;
        if (i2 == iArr.length) {
            iArr = new int[qe4.q(iArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, iArr, 0, this.z);
            this.f = iArr;
        }
        int i3 = this.z;
        this.z = i3 + 1;
        iArr[i3] = i;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.z) {
            zo2.j(this.z, dw2.D("Index:", i, ", Size:"));
        }
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x02)) {
            return super.equals(obj);
        }
        x02 x02Var = (x02) obj;
        if (this.z != x02Var.z) {
            return false;
        }
        int[] iArr = x02Var.f;
        for (int i = 0; i < this.z; i++) {
            if (this.f[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int f(int i) {
        e(i);
        return this.f[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return Integer.valueOf(f(i));
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.z; i2++) {
            i = (i * 31) + this.f[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.z;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f[i2] == iIntValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        e(i);
        int[] iArr = this.f;
        int i2 = iArr[i];
        if (i < this.z - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.z--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            s53.k("toIndex < fromIndex");
            return;
        }
        int[] iArr = this.f;
        System.arraycopy(iArr, i2, iArr, i, this.z - i2);
        this.z -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        e(i);
        int[] iArr = this.f;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.z;
    }

    public x02(int[] iArr, int i, boolean z) {
        super(z);
        this.f = iArr;
        this.z = i;
    }

    public x02() {
        this(A, 0, true);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
