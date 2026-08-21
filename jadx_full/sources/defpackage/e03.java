package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e03 implements Serializable {
    public final Object b;
    public final Object f;

    public e03(Object obj, Object obj2) {
        this.b = obj;
        this.f = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e03)) {
            return false;
        }
        e03 e03Var = (e03) obj;
        return n12.c(this.b, e03Var.b) && n12.c(this.f, e03Var.f);
    }

    public final int hashCode() {
        Object obj = this.b;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.b + ", " + this.f + ')';
    }
}
