package defpackage;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ng2 implements Map {
    public final og2 b;
    public final Map f;

    public ng2(og2 og2Var, Map map) {
        this.b = og2Var;
        this.f = map;
    }

    @Override // java.util.Map
    public final void clear() {
        this.b.Z();
        this.f.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return new mg2(this.b, this.f.entrySet());
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return this.f.equals(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return new mg2(this.b, this.f.keySet());
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.b.Z();
        Charset charset = i12.a;
        obj.getClass();
        obj2.getClass();
        return this.f.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        this.b.Z();
        for (Object obj : map.keySet()) {
            Charset charset = i12.a;
            obj.getClass();
            map.get(obj).getClass();
        }
        this.f.putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        this.b.Z();
        return this.f.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f.size();
    }

    public final String toString() {
        return this.f.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        return new lg2(this.b, this.f.values());
    }
}
