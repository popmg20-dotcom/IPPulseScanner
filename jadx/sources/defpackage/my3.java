package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class my3 implements Map.Entry, Comparable {
    public final Comparable b;
    public Object f;
    public final /* synthetic */ ky3 z;

    public my3(ky3 ky3Var, Comparable comparable, Object obj) {
        this.z = ky3Var;
        this.b = comparable;
        this.f = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.b.compareTo(((my3) obj).b);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.b;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.b;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.z.b();
        Object obj2 = this.f;
        this.f = obj;
        return obj2;
    }

    public final String toString() {
        return this.b + "=" + this.f;
    }
}
