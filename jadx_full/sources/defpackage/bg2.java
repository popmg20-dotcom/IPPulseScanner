package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bg2 implements Map.Entry, z72 {
    public final dg2 b;
    public final int f;
    public final int z;

    public bg2(dg2 dg2Var, int i) {
        this.b = dg2Var;
        this.f = i;
        this.z = dg2Var.y0;
    }

    public final void a() {
        if (this.b.y0 != this.z) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return n12.c(entry.getKey(), getKey()) && n12.c(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.b.b[this.f];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.b.f;
        objArr.getClass();
        return objArr[this.f];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        dg2 dg2Var = this.b;
        dg2Var.c();
        Object[] objArr = dg2Var.f;
        if (objArr == null) {
            int length = dg2Var.b.length;
            if (length < 0) {
                xe.k("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            dg2Var.f = objArr;
        }
        int i = this.f;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
