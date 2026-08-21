package defpackage;

import j$.util.Objects;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nb2 extends AbstractSet {
    public final /* synthetic */ int b;
    public final /* synthetic */ pb2 f;

    public /* synthetic */ nb2(pb2 pb2Var, int i) {
        this.b = i;
        this.f = pb2Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.b;
        pb2 pb2Var = this.f;
        switch (i) {
            case 0:
                pb2Var.clear();
                break;
            default:
                pb2Var.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        ob2 ob2VarA;
        int i = this.b;
        pb2 pb2Var = this.f;
        switch (i) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                ob2 ob2Var = null;
                if (key != null) {
                    try {
                        ob2VarA = pb2Var.a(key, false);
                    } catch (ClassCastException unused) {
                        ob2VarA = null;
                    }
                    break;
                } else {
                    ob2VarA = null;
                }
                if (ob2VarA != null && Objects.equals(ob2VarA.y0, entry.getValue())) {
                    ob2Var = ob2VarA;
                }
                return ob2Var != null;
            default:
                return pb2Var.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        int i = this.b;
        pb2 pb2Var = this.f;
        switch (i) {
            case 0:
                return new mb2(pb2Var, 0);
            default:
                return new mb2(pb2Var, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        ob2 ob2VarA;
        int i = this.b;
        ob2 ob2VarA2 = null;
        pb2 pb2Var = this.f;
        switch (i) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    if (key != null) {
                        try {
                            ob2VarA = pb2Var.a(key, false);
                        } catch (ClassCastException unused) {
                            ob2VarA = null;
                        }
                    } else {
                        ob2VarA = null;
                    }
                    if (ob2VarA != null && Objects.equals(ob2VarA.y0, entry.getValue())) {
                        ob2VarA2 = ob2VarA;
                    }
                    if (ob2VarA2 != null) {
                        pb2Var.c(ob2VarA2, true);
                        break;
                    }
                    break;
                }
                break;
            default:
                if (obj != null) {
                    try {
                        ob2VarA2 = pb2Var.a(obj, false);
                        break;
                    } catch (ClassCastException unused2) {
                    }
                }
                if (ob2VarA2 != null) {
                    pb2Var.c(ob2VarA2, true);
                }
                if (ob2VarA2 != null) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        int i = this.b;
        pb2 pb2Var = this.f;
        switch (i) {
        }
        return pb2Var.A;
    }
}
