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
public final class fc5 extends xa5 implements RandomAccess, kc5, md5 {
    public static final int[] A;
    public static final fc5 X;
    public int[] f;
    public int z;

    static {
        int[] iArr = new int[0];
        A = iArr;
        X = new fc5(iArr, 0, false);
    }

    public fc5(int[] iArr, int i, boolean z) {
        super(z);
        this.f = iArr;
        this.z = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i < 0 || i > (i2 = this.z)) {
            s53.k(za5.a(this.z, i, HttpConstants.CR, "Index:", ", Size:"));
            return;
        }
        int i3 = i + 1;
        int[] iArr = this.f;
        int length = iArr.length;
        if (i2 < length) {
            System.arraycopy(iArr, i, iArr, i3, i2 - i);
        } else {
            int[] iArr2 = new int[qe4.q(length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, iArr2, 0, i);
            System.arraycopy(this.f, i, iArr2, i3, this.z - i);
            this.f = iArr2;
        }
        this.f[i] = iIntValue;
        this.z++;
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.xa5, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        Charset charset = nc5.a;
        collection.getClass();
        if (!(collection instanceof fc5)) {
            return super.addAll(collection);
        }
        fc5 fc5Var = (fc5) collection;
        int i = fc5Var.z;
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
        System.arraycopy(fc5Var.f, 0, iArrCopyOf, this.z, fc5Var.z);
        this.z = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // defpackage.mc5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final fc5 N(int i) {
        if (i >= this.z) {
            return new fc5(i == 0 ? A : Arrays.copyOf(this.f, i), this.z, true);
        }
        s53.d();
        return null;
    }

    public final int c(int i) {
        e(i);
        return this.f[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        a();
        int i2 = this.z;
        int[] iArr = this.f;
        int length = iArr.length;
        if (i2 == length) {
            iArr = new int[qe4.q(length, 3, 2, 1, 10)];
            System.arraycopy(this.f, 0, iArr, 0, this.z);
            this.f = iArr;
        }
        int i3 = this.z;
        this.z = i3 + 1;
        iArr[i3] = i;
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
        if (!(obj instanceof fc5)) {
            return super.equals(obj);
        }
        fc5 fc5Var = (fc5) obj;
        if (this.z == fc5Var.z) {
            int[] iArr = fc5Var.f;
            for (int i = 0; i < this.z; i++) {
                if (this.f[i] == iArr[i]) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        e(i);
        return Integer.valueOf(this.f[i]);
    }

    @Override // defpackage.xa5, java.util.AbstractList, java.util.Collection, java.util.List
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

    @Override // defpackage.xa5, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
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
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
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

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }
}
