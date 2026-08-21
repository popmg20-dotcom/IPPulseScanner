package defpackage;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xd5 extends AbstractMap {
    public boolean A;
    public volatile de X;
    public Map Y;
    public Object[] b;
    public int f;
    public Map z;

    public xd5() {
        Map map = Collections.EMPTY_MAP;
        this.z = map;
        this.Y = map;
    }

    public final yd5 a(int i) {
        if (i < this.f) {
            return (yd5) this.b[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final Set b() {
        return this.z.isEmpty() ? Collections.EMPTY_SET : this.z.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        f();
        int iE = e(comparable);
        if (iE >= 0) {
            return ((yd5) this.b[iE]).setValue(obj);
        }
        f();
        Object[] objArr = this.b;
        if (objArr == null) {
            objArr = new Object[16];
            this.b = objArr;
        }
        int i = -(iE + 1);
        if (i >= 16) {
            return g().put(comparable, obj);
        }
        if (this.f == 16) {
            yd5 yd5Var = (yd5) objArr[15];
            this.f = 15;
            g().put(yd5Var.b, yd5Var.f);
        }
        Object[] objArr2 = this.b;
        int length = objArr2.length;
        System.arraycopy(objArr2, i, objArr2, i + 1, 15 - i);
        this.b[i] = new yd5(this, comparable, obj);
        this.f++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        f();
        if (this.f != 0) {
            this.b = null;
            this.f = 0;
        }
        if (this.z.isEmpty()) {
            return;
        }
        this.z.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return e(comparable) >= 0 || this.z.containsKey(comparable);
    }

    public final Object d(int i) {
        f();
        Object[] objArr = this.b;
        Object obj = ((yd5) objArr[i]).f;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f - i) - 1);
        this.f--;
        if (!this.z.isEmpty()) {
            Iterator it = g().entrySet().iterator();
            Object[] objArr2 = this.b;
            int i2 = this.f;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i2] = new yd5(this, (Comparable) entry.getKey(), entry.getValue());
            this.f++;
            it.remove();
        }
        return obj;
    }

    public final int e(Comparable comparable) {
        int i = this.f;
        int i2 = i - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int iCompareTo = comparable.compareTo(((yd5) this.b[i2]).b);
            if (iCompareTo > 0) {
                return -(i + 1);
            }
            if (iCompareTo == 0) {
                return i2;
            }
        }
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int iCompareTo2 = comparable.compareTo(((yd5) this.b[i4]).b);
            if (iCompareTo2 < 0) {
                i2 = i4 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i4;
                }
                i3 = i4 + 1;
            }
        }
        return -(i3 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.X == null) {
            this.X = new de(3, this);
        }
        return this.X;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xd5)) {
            return super.equals(obj);
        }
        xd5 xd5Var = (xd5) obj;
        int size = size();
        if (size == xd5Var.size()) {
            int i = this.f;
            if (i != xd5Var.f) {
                return entrySet().equals(xd5Var.entrySet());
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (a(i2).equals(xd5Var.a(i2))) {
                }
            }
            if (i != size) {
                return this.z.equals(xd5Var.z);
            }
            return true;
        }
        return false;
    }

    public final void f() {
        if (this.A) {
            vp1.q();
        }
    }

    public final SortedMap g() {
        f();
        if (this.z.isEmpty() && !(this.z instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.z = treeMap;
            this.Y = treeMap.descendingMap();
        }
        return (SortedMap) this.z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        return iE >= 0 ? ((yd5) this.b[iE]).f : this.z.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.f;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.b[i2].hashCode();
        }
        return this.z.size() > 0 ? this.z.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iE = e(comparable);
        if (iE >= 0) {
            return d(iE);
        }
        if (this.z.isEmpty()) {
            return null;
        }
        return this.z.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.z.size() + this.f;
    }
}
