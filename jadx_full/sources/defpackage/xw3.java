package defpackage;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class xw3 {
    public int[] b;
    public Object[] f;
    public int z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public xw3(xw3 xw3Var) {
        this(0);
        int i = xw3Var.z;
        b(this.z + i);
        if (this.z != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(xw3Var.f(i2), xw3Var.i(i2));
            }
        } else if (i > 0) {
            qe.e0(xw3Var.b, 0, this.b, 0, i);
            qe.c0(0, 0, i << 1, xw3Var.f, this.f);
            this.z = i;
        }
    }

    public final int a(Object obj) {
        int i = this.z * 2;
        Object[] objArr = this.f;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i) {
        int i2 = this.z;
        int[] iArr = this.b;
        if (iArr.length < i) {
            this.b = Arrays.copyOf(iArr, i);
            this.f = Arrays.copyOf(this.f, i * 2);
        }
        if (this.z != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i, Object obj) {
        int i2 = this.z;
        if (i2 == 0) {
            return -1;
        }
        int iB = co4.b(i2, i, this.b);
        if (iB < 0 || n12.c(obj, this.f[iB << 1])) {
            return iB;
        }
        int i3 = iB + 1;
        while (i3 < i2 && this.b[i3] == i) {
            if (n12.c(obj, this.f[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iB - 1; i4 >= 0 && this.b[i4] == i; i4--) {
            if (n12.c(obj, this.f[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final void clear() {
        int i = this.z;
        if (i > 0) {
            this.b = co4.c;
            this.f = co4.d;
            i = 0;
            this.z = 0;
        }
        if (i > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i = this.z;
        if (i == 0) {
            return -1;
        }
        int iB = co4.b(i, 0, this.b);
        if (iB < 0 || this.f[iB << 1] == null) {
            return iB;
        }
        int i2 = iB + 1;
        while (i2 < i && this.b[i2] == 0) {
            if (this.f[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iB - 1; i3 >= 0 && this.b[i3] == 0; i3--) {
            if (this.f[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof xw3) {
                int i = this.z;
                if (i != ((xw3) obj).z) {
                    return false;
                }
                xw3 xw3Var = (xw3) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objF = f(i2);
                    Object objI = i(i2);
                    Object obj2 = xw3Var.get(objF);
                    if (objI == null) {
                        if (obj2 != null || !xw3Var.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objI.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.z != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.z;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objF2 = f(i4);
                Object objI2 = i(i4);
                Object obj3 = ((Map) obj).get(objF2);
                if (objI2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!objI2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        boolean z = false;
        if (i >= 0 && i < this.z) {
            z = true;
        }
        if (z) {
            return this.f[i << 1];
        }
        xe.k(dw2.A(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public final Object g(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.z)) {
            xe.k(dw2.A(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        Object[] objArr = this.f;
        int i3 = i << 1;
        Object obj = objArr[i3 + 1];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i4 = i2 - 1;
        int[] iArr = this.b;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                qe.e0(iArr, i, iArr, i5, i2);
                Object[] objArr2 = this.f;
                qe.c0(i3, i5 << 1, i2 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i2 > 8 ? i2 + (i2 >> 1) : 8;
            this.b = Arrays.copyOf(iArr, i7);
            this.f = Arrays.copyOf(this.f, i7 << 1);
            if (i2 != this.z) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                qe.e0(iArr, 0, this.b, 0, i);
                qe.c0(0, 0, i3, objArr, this.f);
            }
            if (i < i4) {
                int i8 = i + 1;
                qe.e0(iArr, i, this.b, i8, i2);
                qe.c0(i3, i8 << 1, i2 << 1, objArr, this.f);
            }
        }
        if (i2 != this.z) {
            throw new ConcurrentModificationException();
        }
        this.z = i4;
        return obj;
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f[(iD << 1) + 1] : obj2;
    }

    public final Object h(int i, Object obj) {
        boolean z = false;
        if (i >= 0 && i < this.z) {
            z = true;
        }
        if (!z) {
            xe.k(dw2.A(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final int hashCode() {
        int[] iArr = this.b;
        Object[] objArr = this.f;
        int i = this.z;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i) {
        boolean z = false;
        if (i >= 0 && i < this.z) {
            z = true;
        }
        if (z) {
            return this.f[(i << 1) + 1];
        }
        xe.k(dw2.A(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public final boolean isEmpty() {
        return this.z <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i = this.z;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i2 = (iC << 1) + 1;
            Object[] objArr = this.f;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iC;
        int[] iArr = this.b;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            this.b = Arrays.copyOf(iArr, i4);
            this.f = Arrays.copyOf(this.f, i4 << 1);
            if (i != this.z) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.b;
            int i5 = i3 + 1;
            qe.e0(iArr2, i5, iArr2, i3, i);
            Object[] objArr2 = this.f;
            qe.c0(i5 << 1, i3 << 1, this.z << 1, objArr2, objArr2);
        }
        int i6 = this.z;
        if (i == i6) {
            int[] iArr3 = this.b;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.f;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.z = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !n12.c(obj2, i(iD))) {
            return false;
        }
        g(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !n12.c(obj2, i(iD))) {
            return false;
        }
        h(iD, obj3);
        return true;
    }

    public final int size() {
        return this.z;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.z * 28);
        sb.append('{');
        int i = this.z;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objF = f(i2);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objI = i(i2);
            if (objI != sb) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return g(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD, obj2);
        }
        return null;
    }

    public xw3(int i) {
        int[] iArr;
        Object[] objArr;
        if (i == 0) {
            iArr = co4.c;
        } else {
            iArr = new int[i];
        }
        this.b = iArr;
        if (i == 0) {
            objArr = co4.d;
        } else {
            objArr = new Object[i << 1];
        }
        this.f = objArr;
    }

    public xw3() {
        this(0);
    }
}
