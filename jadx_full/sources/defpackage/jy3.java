package defpackage;

import j$.util.DesugarCollections;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jy3 extends AbstractMap {
    public static final /* synthetic */ int Z = 0;
    public boolean A;
    public volatile de X;
    public Map Y;
    public Object[] b;
    public int f;
    public Map z;

    public static jy3 g() {
        jy3 jy3Var = new jy3();
        Map map = Collections.EMPTY_MAP;
        jy3Var.z = map;
        jy3Var.Y = map;
        return jy3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Comparable comparable) {
        int i;
        int i2;
        int i3 = this.f;
        int i4 = i3 - 1;
        if (i4 < 0) {
            i = 0;
            while (i <= i4) {
                int i5 = (i + i4) / 2;
                int iCompareTo = comparable.compareTo(((ly3) this.b[i5]).b);
                if (iCompareTo < 0) {
                    i4 = i5 - 1;
                } else {
                    if (iCompareTo <= 0) {
                        return i5;
                    }
                    i = i5 + 1;
                }
            }
            i2 = i + 1;
        } else {
            int iCompareTo2 = comparable.compareTo(((ly3) this.b[i4]).b);
            if (iCompareTo2 > 0) {
                i2 = i3 + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i4;
                }
                i = 0;
                while (i <= i4) {
                }
                i2 = i + 1;
            }
        }
        return -i2;
    }

    public final void b() {
        if (this.A) {
            vp1.q();
        }
    }

    public final ly3 c(int i) {
        if (i < this.f) {
            return (ly3) this.b[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
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
        return a(comparable) >= 0 || this.z.containsKey(comparable);
    }

    public final Set d() {
        return this.z.isEmpty() ? Collections.EMPTY_SET : this.z.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.z.isEmpty() && !(this.z instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.z = treeMap;
            this.Y = treeMap.descendingMap();
        }
        return (SortedMap) this.z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.X == null) {
            this.X = new de(1, this);
        }
        return this.X;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jy3)) {
            return super.equals(obj);
        }
        jy3 jy3Var = (jy3) obj;
        int size = size();
        if (size == jy3Var.size()) {
            int i = this.f;
            if (i != jy3Var.f) {
                return ((AbstractSet) entrySet()).equals(jy3Var.entrySet());
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (c(i2).equals(jy3Var.c(i2))) {
                }
            }
            if (i != size) {
                return this.z.equals(jy3Var.z);
            }
            return true;
        }
        return false;
    }

    public final void f() {
        if (!this.A) {
            for (int i = 0; i < this.f; i++) {
                ly3 ly3VarC = c(i);
                if (((ft0) ly3VarC.b).y()) {
                    ly3VarC.setValue(DesugarCollections.unmodifiableList((List) ly3VarC.f));
                }
            }
            for (Map.Entry entry : d()) {
                if (((ft0) entry.getKey()).y()) {
                    entry.setValue(DesugarCollections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        if (this.A) {
            return;
        }
        this.z = this.z.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(this.z);
        this.Y = this.Y.isEmpty() ? Collections.EMPTY_MAP : DesugarCollections.unmodifiableMap(this.Y);
        this.A = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((ly3) this.b[iA]).f : this.z.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((ly3) this.b[iA]).setValue(obj);
        }
        b();
        Object[] objArr = this.b;
        if (objArr == null) {
            objArr = new Object[16];
            this.b = objArr;
        }
        int i = -(iA + 1);
        if (i >= 16) {
            return e().put(comparable, obj);
        }
        int i2 = this.f;
        if (i2 == 16) {
            ly3 ly3Var = (ly3) objArr[15];
            this.f = i2 - 1;
            e().put(ly3Var.b, ly3Var.f);
        }
        Object[] objArr2 = this.b;
        System.arraycopy(objArr2, i, objArr2, i + 1, (objArr2.length - i) - 1);
        this.b[i] = new ly3(this, comparable, obj);
        this.f++;
        return null;
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

    public final Object i(int i) {
        b();
        Object[] objArr = this.b;
        Object obj = ((ly3) objArr[i]).f;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f - i) - 1);
        this.f--;
        if (!this.z.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            Object[] objArr2 = this.b;
            int i2 = this.f;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i2] = new ly3(this, (Comparable) entry.getKey(), entry.getValue());
            this.f++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return i(iA);
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
