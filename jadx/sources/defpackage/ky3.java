package defpackage;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ky3 extends AbstractMap {
    public static final /* synthetic */ int Y = 0;
    public volatile de A;
    public Map X;
    public List b;
    public Map f;
    public boolean z;

    public static ky3 f() {
        ky3 ky3Var = new ky3();
        ky3Var.b = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        ky3Var.f = map;
        ky3Var.X = map;
        return ky3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.b
            java.lang.Object r2 = r2.get(r1)
            my3 r2 = (defpackage.my3) r2
            java.lang.Comparable r2 = r2.b
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r4 = -r0
            return r4
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.b
            java.lang.Object r3 = r3.get(r2)
            my3 r3 = (defpackage.my3) r3
            java.lang.Comparable r3 = r3.b
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ky3.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.z) {
            vp1.q();
        }
    }

    public final Map.Entry c(int i) {
        return (Map.Entry) this.b.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.f.isEmpty()) {
            return;
        }
        this.f.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f.containsKey(comparable);
    }

    public final Set d() {
        return this.f.isEmpty() ? Collections.EMPTY_SET : this.f.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f.isEmpty() && !(this.f instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f = treeMap;
            this.X = treeMap.descendingMap();
        }
        return (SortedMap) this.f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.A == null) {
            this.A = new de(2, this);
        }
        return this.A;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ky3)) {
            return super.equals(obj);
        }
        ky3 ky3Var = (ky3) obj;
        int size = size();
        if (size == ky3Var.size()) {
            int size2 = this.b.size();
            if (size2 != ky3Var.b.size()) {
                return ((AbstractSet) entrySet()).equals(ky3Var.entrySet());
            }
            for (int i = 0; i < size2; i++) {
                if (c(i).equals(ky3Var.c(i))) {
                }
            }
            if (size2 != size) {
                return this.f.equals(ky3Var.f);
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((my3) this.b.get(iA)).setValue(obj);
        }
        b();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(16);
        }
        int i = -(iA + 1);
        if (i >= 16) {
            return e().put(comparable, obj);
        }
        if (this.b.size() == 16) {
            my3 my3Var = (my3) this.b.remove(15);
            e().put(my3Var.b, my3Var.f);
        }
        this.b.add(i, new my3(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((my3) this.b.get(iA)).f : this.f.get(comparable);
    }

    public final Object h(int i) {
        b();
        Object obj = ((my3) this.b.remove(i)).f;
        if (!this.f.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new my3(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.b.size();
        int iHashCode = 0;
        for (int i = 0; i < size; i++) {
            iHashCode += ((my3) this.b.get(i)).hashCode();
        }
        return this.f.size() > 0 ? this.f.hashCode() + iHashCode : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return h(iA);
        }
        if (this.f.isEmpty()) {
            return null;
        }
        return this.f.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f.size() + this.b.size();
    }
}
