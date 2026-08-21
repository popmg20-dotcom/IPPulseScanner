package defpackage;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d53 extends AbstractSet {
    public final /* synthetic */ int b;
    public final i53 f;
    public final /* synthetic */ i53 z;

    public /* synthetic */ d53(i53 i53Var, int i) {
        this.b = i;
        this.z = i53Var;
        this.f = i53Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        switch (this.b) {
            case 0:
                throw new UnsupportedOperationException("ConcurrentLinkedHashMap does not allow add to be called on entrySet()");
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.b;
        i53 i53Var = this.f;
        switch (i) {
            case 0:
                i53Var.clear();
                break;
            default:
                i53Var.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.b) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    e53 e53Var = (e53) this.f.b.get(entry.getKey());
                    if (e53Var != null && e53Var.a().equals(entry.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                return this.z.b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.b;
        i53 i53Var = this.z;
        switch (i) {
            case 0:
                return new c53(i53Var, 0);
            default:
                return new c53(i53Var, 2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i = this.b;
        i53 i53Var = this.f;
        switch (i) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return i53Var.remove(entry.getKey(), entry.getValue());
            default:
                return i53Var.remove(obj) != null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = this.b;
        i53 i53Var = this.f;
        switch (i) {
        }
        return i53Var.b.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        switch (this.b) {
            case 1:
                return this.f.b.keySet().toArray();
            default:
                return super.toArray();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        switch (this.b) {
            case 1:
                return this.f.b.keySet().toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }
}
