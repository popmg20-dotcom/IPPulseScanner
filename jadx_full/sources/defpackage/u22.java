package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u22 implements Serializable {
    public static final u22 z = new u22(null, null);
    public final Object b;
    public final Boolean f;

    public u22(Object obj, Boolean bool) {
        this.b = obj;
        this.f = bool;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == u22.class) {
            u22 u22Var = (u22) obj;
            Boolean bool = u22Var.f;
            Boolean bool2 = this.f;
            if (bool2 == null ? bool == null : bool2.equals(bool)) {
                Object obj2 = u22Var.b;
                Object obj3 = this.b;
                return obj3 == null ? obj2 == null : obj3.equals(obj2);
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.b;
        int iHashCode = obj != null ? 1 + obj.hashCode() : 1;
        Boolean bool = this.f;
        return bool != null ? bool.hashCode() + iHashCode : iHashCode;
    }

    public final String toString() {
        return String.format("JacksonInject.Value(id=%s,useInput=%s)", this.b, this.f);
    }
}
