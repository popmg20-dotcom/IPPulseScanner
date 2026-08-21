package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ze2 extends k1 implements RandomAccess {
    public static final long[] A;
    public static final ze2 X;
    public long[] f;
    public int z;

    static {
        long[] jArr = new long[0];
        A = jArr;
        X = new ze2(jArr, 0, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ze2(ze2 ze2Var, boolean z) {
        int i = ze2Var.z;
        this(i == 0 ? A : Arrays.copyOf(ze2Var.f, i), ze2Var.z, z);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.z)) {
            zo2.j(this.z, dw2.D("Index:", i, ", Size:"));
            return;
        }
        long[] jArr = this.f;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[qe4.q(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, jArr2, 0, i);
            System.arraycopy(this.f, i, jArr2, i + 1, this.z - i);
            this.f = jArr2;
        }
        this.f[i] = jLongValue;
        this.z++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.k1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = i12.a;
        collection.getClass();
        if (!(collection instanceof ze2)) {
            return super.addAll(collection);
        }
        ze2 ze2Var = (ze2) collection;
        int i = ze2Var.z;
        if (i == 0) {
            return false;
        }
        int i2 = this.z;
        if (ChannelUtils.WRITE_STATUS_SNDBUF_FULL - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArrCopyOf = this.f;
        if (i3 > jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i3);
            this.f = jArrCopyOf;
        }
        System.arraycopy(ze2Var.f, 0, jArrCopyOf, this.z, ze2Var.z);
        this.z = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // defpackage.k1
    public final k1 c(int i) {
        if (i >= this.z) {
            return new ze2(i == 0 ? A : Arrays.copyOf(this.f, i), this.z, true);
        }
        s53.d();
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(long j) {
        a();
        int i = this.z;
        long[] jArr = this.f;
        if (i == jArr.length) {
            jArr = new long[qe4.q(jArr.length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, jArr, 0, this.z);
            this.f = jArr;
        }
        int i2 = this.z;
        this.z = i2 + 1;
        jArr[i2] = j;
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
        if (!(obj instanceof ze2)) {
            return super.equals(obj);
        }
        ze2 ze2Var = (ze2) obj;
        if (this.z != ze2Var.z) {
            return false;
        }
        long[] jArr = ze2Var.f;
        for (int i = 0; i < this.z; i++) {
            if (this.f[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        e(i);
        return Long.valueOf(this.f[i]);
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iB = 1;
        for (int i = 0; i < this.z; i++) {
            iB = (iB * 31) + i12.b(this.f[i]);
        }
        return iB;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i = this.z;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f[i2] == jLongValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        e(i);
        long[] jArr = this.f;
        long j = jArr[i];
        if (i < this.z - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.z--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            s53.k("toIndex < fromIndex");
            return;
        }
        long[] jArr = this.f;
        System.arraycopy(jArr, i2, jArr, i, this.z - i2);
        this.z -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        a();
        e(i);
        long[] jArr = this.f;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.z;
    }

    public ze2(long[] jArr, int i, boolean z) {
        super(z);
        this.f = jArr;
        this.z = i;
    }

    public ze2() {
        this(A, 0, true);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }
}
