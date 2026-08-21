package defpackage;

import j$.util.DesugarCollections;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g92 extends k1 implements RandomAccess, List {
    public static final g92 z = new g92();
    public final List f;

    public g92(g92 g92Var) {
        super(true);
        this.f = new ArrayList(g92Var.f.size());
        addAll(g92Var);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        a();
        this.f.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        a();
        if (collection instanceof g92) {
            collection = DesugarCollections.unmodifiableList(((g92) collection).f);
        }
        boolean zAddAll = this.f.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // defpackage.k1
    public final k1 c(int i) {
        List list = this.f;
        if (i < list.size()) {
            s53.d();
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(list);
        return new g92(arrayList);
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.f.clear();
        ((AbstractList) this).modCount++;
    }

    public final void d(zt ztVar) {
        a();
        this.f.add(ztVar);
        ((AbstractList) this).modCount++;
    }

    public final void e(String str) {
        a();
        this.f.add(str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        List list = this.f;
        Object obj = list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zt) {
            zt ztVar = (zt) obj;
            String strI = ztVar.i();
            if (ztVar.g()) {
                list.set(i, strI);
            }
            return strI;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, i12.a);
        if (zn4.a.G(0, bArr.length, bArr) == 0) {
            list.set(i, str);
        }
        return str;
    }

    @Override // defpackage.k1, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        a();
        Object objRemove = this.f.remove(i);
        ((AbstractList) this).modCount++;
        return objRemove instanceof String ? (String) objRemove : objRemove instanceof zt ? ((zt) objRemove).i() : new String((byte[]) objRemove, i12.a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        a();
        Object obj2 = this.f.set(i, (String) obj);
        return obj2 instanceof String ? (String) obj2 : obj2 instanceof zt ? ((zt) obj2).i() : new String((byte[]) obj2, i12.a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e((String) obj);
        return true;
    }

    public g92(ArrayList arrayList) {
        super(true);
        this.f = arrayList;
    }

    public g92() {
        super(false);
        this.f = Collections.EMPTY_LIST;
    }

    @Override // defpackage.k1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f.size(), collection);
    }
}
