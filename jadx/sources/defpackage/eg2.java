package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eg2 extends g1 {
    public final /* synthetic */ int b;
    public final dg2 f;

    public /* synthetic */ eg2(dg2 dg2Var, int i) {
        this.b = i;
        this.f = dg2Var;
    }

    @Override // defpackage.g1
    public final int a() {
        int i = this.b;
        dg2 dg2Var = this.f;
        switch (i) {
        }
        return dg2Var.z0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.b) {
            case 0:
                ((Map.Entry) obj).getClass();
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int i = this.b;
        collection.getClass();
        switch (i) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.b;
        dg2 dg2Var = this.f;
        switch (i) {
            case 0:
                dg2Var.clear();
                break;
            default:
                dg2Var.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int i = this.b;
        dg2 dg2Var = this.f;
        switch (i) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                int iG = dg2Var.g(entry.getKey());
                if (iG < 0) {
                    return false;
                }
                Object[] objArr = dg2Var.f;
                objArr.getClass();
                return n12.c(objArr[iG], entry.getValue());
            default:
                return dg2Var.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.b) {
            case 0:
                collection.getClass();
                return this.f.e(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        int i = this.b;
        dg2 dg2Var = this.f;
        switch (i) {
        }
        return dg2Var.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.b;
        dg2 dg2Var = this.f;
        switch (i) {
            case 0:
                return new ag2(dg2Var, 0);
            default:
                return new ag2(dg2Var, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i = this.b;
        dg2 dg2Var = this.f;
        switch (i) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    dg2Var.c();
                    int iG = dg2Var.g(entry.getKey());
                    if (iG >= 0) {
                        Object[] objArr = dg2Var.f;
                        objArr.getClass();
                        if (n12.c(objArr[iG], entry.getValue())) {
                            dg2Var.k(iG);
                        }
                    }
                }
                break;
            default:
                dg2Var.c();
                int iG2 = dg2Var.g(obj);
                if (iG2 >= 0) {
                    dg2Var.k(iG2);
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        int i = this.b;
        dg2 dg2Var = this.f;
        collection.getClass();
        switch (i) {
            case 0:
                dg2Var.c();
                break;
            default:
                dg2Var.c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int i = this.b;
        dg2 dg2Var = this.f;
        collection.getClass();
        switch (i) {
            case 0:
                dg2Var.c();
                break;
            default:
                dg2Var.c();
                break;
        }
        return super.retainAll(collection);
    }
}
