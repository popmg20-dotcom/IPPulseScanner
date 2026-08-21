package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dg2 implements Map, Serializable, z72 {
    public static final dg2 E0;
    public int[] A;
    public eg2 A0;
    public fg2 B0;
    public eg2 C0;
    public boolean D0;
    public int X;
    public int Y;
    public int Z;
    public Object[] b;
    public Object[] f;
    public int y0;
    public int[] z;
    public int z0;

    static {
        dg2 dg2Var = new dg2(0);
        dg2Var.D0 = true;
        E0 = dg2Var;
    }

    public dg2(int i) {
        if (i < 0) {
            xe.k("capacity must be non-negative.");
            throw null;
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.b = objArr;
        this.f = null;
        this.z = iArr;
        this.A = new int[iHighestOneBit];
        this.X = 2;
        this.Y = 0;
        this.Z = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int i = i(obj);
            int i2 = this.X * 2;
            int length = this.A.length / 2;
            if (i2 > length) {
                i2 = length;
            }
            int i3 = 0;
            while (true) {
                int[] iArr = this.A;
                int i4 = iArr[i];
                if (i4 <= 0) {
                    int i5 = this.Y;
                    Object[] objArr = this.b;
                    if (i5 < objArr.length) {
                        int i6 = i5 + 1;
                        this.Y = i6;
                        objArr[i5] = obj;
                        this.z[i5] = i;
                        iArr[i] = i6;
                        this.z0++;
                        this.y0++;
                        if (i3 > this.X) {
                            this.X = i3;
                        }
                        return i5;
                    }
                    f(1);
                } else {
                    if (n12.c(this.b[i4 - 1], obj)) {
                        return -i4;
                    }
                    i3++;
                    if (i3 > i2) {
                        j(this.A.length * 2);
                        break;
                    }
                    i = i == 0 ? this.A.length - 1 : i - 1;
                }
            }
        }
    }

    public final dg2 b() {
        c();
        this.D0 = true;
        if (this.z0 > 0) {
            return this;
        }
        dg2 dg2Var = E0;
        dg2Var.getClass();
        return dg2Var;
    }

    public final void c() {
        if (this.D0) {
            vp1.q();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i = this.Y - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.z;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.A[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        yr2.h0(this.b, 0, this.Y);
        Object[] objArr = this.f;
        if (objArr != null) {
            yr2.h0(objArr, 0, this.Y);
        }
        this.z0 = 0;
        this.Y = 0;
        this.y0++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public final void d(boolean z) {
        int i;
        Object[] objArr = this.f;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.Y;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.z;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.b;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.A[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        yr2.h0(this.b, i3, i);
        if (objArr != null) {
            yr2.h0(objArr, i3, this.Y);
        }
        this.Y = i3;
    }

    public final boolean e(Collection collection) {
        boolean zC;
        collection.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int iG = g(entry.getKey());
                    if (iG < 0) {
                        zC = false;
                    } else {
                        Object[] objArr = this.f;
                        objArr.getClass();
                        zC = n12.c(objArr[iG], entry.getValue());
                    }
                    if (!zC) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        eg2 eg2Var = this.C0;
        if (eg2Var != null) {
            return eg2Var;
        }
        eg2 eg2Var2 = new eg2(this, 0);
        this.C0 = eg2Var2;
        return eg2Var2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.z0 == map.size() && e(map.entrySet());
    }

    public final void f(int i) {
        Object[] objArr = this.b;
        int length = objArr.length;
        int i2 = this.Y;
        int i3 = length - i2;
        int i4 = i2 - this.z0;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = objArr.length;
            int i6 = length2 + (length2 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : 2147483639;
            }
            this.b = Arrays.copyOf(objArr, i6);
            Object[] objArr2 = this.f;
            this.f = objArr2 != null ? Arrays.copyOf(objArr2, i6) : null;
            this.z = Arrays.copyOf(this.z, i6);
            int iHighestOneBit = Integer.highestOneBit((i6 >= 1 ? i6 : 1) * 3);
            if (iHighestOneBit > this.A.length) {
                j(iHighestOneBit);
            }
        }
    }

    public final int g(Object obj) {
        int i = i(obj);
        int i2 = this.X;
        while (true) {
            int i3 = this.A[i];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (n12.c(this.b[i4], obj)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            i = i == 0 ? this.A.length - 1 : i - 1;
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f;
        objArr.getClass();
        return objArr[iG];
    }

    public final int h(Object obj) {
        int i = this.Y;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.z[i] >= 0) {
                Object[] objArr = this.f;
                objArr.getClass();
                if (n12.c(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        ag2 ag2Var = new ag2(this, 0);
        int i = 0;
        while (ag2Var.hasNext()) {
            int i2 = ag2Var.b;
            dg2 dg2Var = (dg2) ag2Var.A;
            if (i2 >= dg2Var.Y) {
                vp1.g();
                return 0;
            }
            ag2Var.b = i2 + 1;
            ag2Var.f = i2;
            Object obj = dg2Var.b[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = dg2Var.f;
            objArr.getClass();
            Object obj2 = objArr[ag2Var.f];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            ag2Var.e();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.Z;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.z0 == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.z[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(int i) {
        this.y0++;
        int i2 = 0;
        if (this.Y > this.z0) {
            d(false);
        }
        this.A = new int[i];
        this.Z = Integer.numberOfLeadingZeros(i) + 1;
        while (i2 < this.Y) {
            int i3 = i2 + 1;
            int i4 = i(this.b[i2]);
            int i5 = this.X;
            while (true) {
                int[] iArr = this.A;
                if (iArr[i4] == 0) {
                    break;
                }
                i5--;
                if (i5 < 0) {
                    xe.q("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                    return;
                }
                i4 = i4 == 0 ? iArr.length - 1 : i4 - 1;
            }
        }
    }

    public final void k(int i) {
        Object[] objArr = this.b;
        objArr.getClass();
        objArr[i] = null;
        Object[] objArr2 = this.f;
        if (objArr2 != null) {
            objArr2[i] = null;
        }
        int length = this.z[i];
        int i2 = this.X * 2;
        int length2 = this.A.length / 2;
        if (i2 > length2) {
            i2 = length2;
        }
        int i3 = i2;
        int i4 = 0;
        int i5 = length;
        while (true) {
            length = length == 0 ? this.A.length - 1 : length - 1;
            i4++;
            int i6 = this.X;
            int[] iArr = this.A;
            if (i4 > i6) {
                iArr[i5] = 0;
                break;
            }
            int i7 = iArr[length];
            if (i7 == 0) {
                iArr[i5] = 0;
                break;
            }
            if (i7 < 0) {
                iArr[i5] = -1;
                i5 = length;
                i4 = 0;
            } else {
                int i8 = i7 - 1;
                int i9 = i(this.b[i8]) - length;
                int[] iArr2 = this.A;
                if ((i9 & (iArr2.length - 1)) >= i4) {
                    iArr2[i5] = i7;
                    this.z[i8] = i5;
                    i5 = length;
                    i4 = 0;
                }
                iArr = iArr2;
            }
            i3--;
            if (i3 < 0) {
                iArr[i5] = -1;
                break;
            }
        }
        this.z[i] = -1;
        this.z0--;
        this.y0++;
    }

    @Override // java.util.Map
    public final Set keySet() {
        eg2 eg2Var = this.A0;
        if (eg2Var != null) {
            return eg2Var;
        }
        eg2 eg2Var2 = new eg2(this, 1);
        this.A0 = eg2Var2;
        return eg2Var2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.f;
        if (objArr == null) {
            int length = this.b.length;
            if (length < 0) {
                xe.k("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            this.f = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        map.getClass();
        c();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        f(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f;
            if (objArr == null) {
                int length = this.b.length;
                if (length < 0) {
                    xe.k("capacity must be non-negative.");
                    return;
                } else {
                    objArr = new Object[length];
                    this.f = objArr;
                }
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!n12.c(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f;
        objArr.getClass();
        Object obj2 = objArr[iG];
        k(iG);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.z0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.z0 * 3) + 2);
        sb.append("{");
        int i = 0;
        ag2 ag2Var = new ag2(this, 0);
        while (ag2Var.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = ag2Var.b;
            dg2 dg2Var = (dg2) ag2Var.A;
            if (i2 >= dg2Var.Y) {
                vp1.g();
                return null;
            }
            ag2Var.b = i2 + 1;
            ag2Var.f = i2;
            Object obj = dg2Var.b[i2];
            if (obj == dg2Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = dg2Var.f;
            objArr.getClass();
            Object obj2 = objArr[ag2Var.f];
            if (obj2 == dg2Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            ag2Var.e();
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        fg2 fg2Var = this.B0;
        if (fg2Var != null) {
            return fg2Var;
        }
        fg2 fg2Var2 = new fg2(this);
        this.B0 = fg2Var2;
        return fg2Var2;
    }

    public dg2() {
        this(8);
    }
}
