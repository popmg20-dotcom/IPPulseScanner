package defpackage;

import j$.util.Map;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class gz1 implements Map, Serializable, j$.util.Map {
    public transient di3 b;
    public transient ei3 f;
    public transient fi3 z;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        fi3 fi3Var = this.z;
        if (fi3Var == null) {
            gi3 gi3Var = (gi3) this;
            fi3 fi3Var2 = new fi3(gi3Var.X, 1, gi3Var.Y);
            this.z = fi3Var2;
            fi3Var = fi3Var2;
        }
        return fi3Var.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        di3 di3Var = this.b;
        if (di3Var != null) {
            return di3Var;
        }
        gi3 gi3Var = (gi3) this;
        di3 di3Var2 = new di3(gi3Var, gi3Var.X, gi3Var.Y);
        this.b = di3Var2;
        return di3Var2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        return ((hz1) entrySet()).equals(((java.util.Map) obj).entrySet());
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        di3 di3Var = this.b;
        if (di3Var == null) {
            gi3 gi3Var = (gi3) this;
            di3 di3Var2 = new di3(gi3Var, gi3Var.X, gi3Var.Y);
            this.b = di3Var2;
            di3Var = di3Var2;
        }
        Iterator it = di3Var.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((gi3) this).size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        ei3 ei3Var = this.f;
        if (ei3Var != null) {
            return ei3Var;
        }
        gi3 gi3Var = (gi3) this;
        ei3 ei3Var2 = new ei3(gi3Var, new fi3(gi3Var.X, 0, gi3Var.Y));
        this.f = ei3Var2;
        return ei3Var2;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public final String toString() {
        int i = ((gi3) this).Y;
        if (i < 0) {
            xe.k(dw2.A(i, "size cannot be negative but was: "));
            return null;
        }
        StringBuilder sb = new StringBuilder((int) Math.min(((long) i) * 8, 1073741824L));
        sb.append('{');
        hm4 hm4VarM = ((di3) entrySet()).iterator();
        boolean z = true;
        while (true) {
            cz1 cz1Var = (cz1) hm4VarM;
            if (!cz1Var.hasNext()) {
                sb.append('}');
                return sb.toString();
            }
            Map.Entry entry = (Map.Entry) cz1Var.next();
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        fi3 fi3Var = this.z;
        if (fi3Var != null) {
            return fi3Var;
        }
        gi3 gi3Var = (gi3) this;
        fi3 fi3Var2 = new fi3(gi3Var.X, 1, gi3Var.Y);
        this.z = fi3Var2;
        return fi3Var2;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }
}
