package defpackage;

import io.netty.channel.internal.ChannelUtils;
import io.netty.handler.codec.http.HttpConstants;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wc5 extends xa5 implements RandomAccess, lc5, md5 {
    public static final long[] A;
    public static final wc5 X;
    public long[] f;
    public int z;

    static {
        long[] jArr = new long[0];
        A = jArr;
        X = new wc5(jArr, 0, false);
    }

    public wc5(long[] jArr, int i, boolean z) {
        super(z);
        this.f = jArr;
        this.z = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        a();
        if (i < 0 || i > (i2 = this.z)) {
            s53.k(za5.a(this.z, i, HttpConstants.CR, "Index:", ", Size:"));
            return;
        }
        int i3 = i + 1;
        long[] jArr = this.f;
        int length = jArr.length;
        if (i2 < length) {
            System.arraycopy(jArr, i, jArr, i3, i2 - i);
        } else {
            long[] jArr2 = new long[qe4.q(length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, jArr2, 0, i);
            System.arraycopy(this.f, i, jArr2, i3, this.z - i);
            this.f = jArr2;
        }
        this.f[i] = jLongValue;
        this.z++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.xa5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = nc5.a;
        collection.getClass();
        if (!(collection instanceof wc5)) {
            return super.addAll(collection);
        }
        wc5 wc5Var = (wc5) collection;
        int i = wc5Var.z;
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
        System.arraycopy(wc5Var.f, 0, jArrCopyOf, this.z, wc5Var.z);
        this.z = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final long b(int i) {
        e(i);
        return this.f[i];
    }

    @Override // defpackage.mc5
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final wc5 N(int i) {
        if (i >= this.z) {
            return new wc5(i == 0 ? A : Arrays.copyOf(this.f, i), this.z, true);
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
        int length = jArr.length;
        if (i == length) {
            jArr = new long[qe4.q(length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, jArr, 0, this.z);
            this.f = jArr;
        }
        int i2 = this.z;
        this.z = i2 + 1;
        jArr[i2] = j;
    }

    public final void e(int i) {
        if (i < 0 || i >= this.z) {
            s53.k(za5.a(this.z, i, HttpConstants.CR, "Index:", ", Size:"));
        }
    }

    @Override // defpackage.xa5, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wc5)) {
            return super.equals(obj);
        }
        wc5 wc5Var = (wc5) obj;
        if (this.z == wc5Var.z) {
            long[] jArr = wc5Var.f;
            for (int i = 0; i < this.z; i++) {
                if (this.f[i] == jArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Long.valueOf(this.f[i]);
    }

    @Override // defpackage.xa5, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.z; i2++) {
            long j = this.f[i2];
            Charset charset = nc5.a;
            i = (i * 31) + ((int) (j ^ (j >>> 32)));
        }
        return i;
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

    @Override // defpackage.xa5, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
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
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
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

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Long) obj).longValue());
        return true;
    }
}
