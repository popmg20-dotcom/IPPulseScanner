package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qo3 implements Map.Entry {
    public qo3 A;
    public final Object b;
    public final Object f;
    public qo3 z;

    public qo3(Object obj, Object obj2) {
        this.b = obj;
        this.f = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof qo3)) {
            return false;
        }
        qo3 qo3Var = (qo3) obj;
        return this.b.equals(qo3Var.b) && this.f.equals(qo3Var.f);
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
        return this.f.hashCode() ^ this.b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.b + "=" + this.f;
    }
}
