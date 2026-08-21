package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ob2 implements Map.Entry {
    public ob2 A;
    public ob2 X;
    public final Object Y;
    public final boolean Z;
    public ob2 b;
    public ob2 f;
    public Object y0;
    public ob2 z;
    public int z0;

    public ob2(boolean z, ob2 ob2Var, Object obj, ob2 ob2Var2, ob2 ob2Var3) {
        this.b = ob2Var;
        this.Y = obj;
        this.Z = z;
        this.z0 = 1;
        this.A = ob2Var2;
        this.X = ob2Var3;
        ob2Var3.A = this;
        ob2Var2.X = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.Y;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.y0;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.Y;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.y0;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.Y;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.y0;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.Z) {
            zo2.n("value == null");
            return null;
        }
        Object obj2 = this.y0;
        this.y0 = obj;
        return obj2;
    }

    public final String toString() {
        return this.Y + "=" + this.y0;
    }

    public ob2(boolean z) {
        this.Y = null;
        this.Z = z;
        this.X = this;
        this.A = this;
    }
}
