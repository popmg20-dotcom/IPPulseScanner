package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m72 implements Serializable {
    public final Class A;
    public final boolean X;
    public final Boolean Y;
    public final k72 b;
    public final j72 f;
    public final String z;

    public m72(k72 k72Var, j72 j72Var, String str, Class cls, boolean z, Boolean bool) {
        this.A = cls;
        this.b = k72Var;
        this.f = j72Var;
        this.z = str;
        this.X = z;
        this.Y = bool;
    }

    public static m72 a(k72 k72Var, j72 j72Var, String str, Class cls, boolean z, Boolean bool) {
        if (str == null || str.isEmpty()) {
            str = k72Var != null ? k72Var.b : "";
        }
        String str2 = str;
        if (cls == null || cls.isAnnotation()) {
            cls = null;
        }
        return new m72(k72Var, j72Var, str2, cls, z, bool);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean zEquals;
        boolean zEquals2;
        if (obj != this) {
            if (obj != null && obj.getClass() == m72.class) {
                m72 m72Var = (m72) obj;
                if (this.b == m72Var.b && this.f == m72Var.f && this.A == m72Var.A && this.X == m72Var.X) {
                    String str = m72Var.z;
                    String str2 = this.z;
                    if (str2 == null) {
                        zEquals = str == null;
                        if (zEquals) {
                            Boolean bool = m72Var.Y;
                            Boolean bool2 = this.Y;
                            if (bool2 == null) {
                                zEquals2 = bool == null;
                                if (!zEquals2) {
                                }
                            } else {
                                if (bool != null) {
                                    zEquals2 = bool2.equals(bool);
                                }
                                if (!zEquals2) {
                                }
                            }
                        }
                    } else {
                        if (str != null) {
                            zEquals = str2.equals(str);
                        }
                        if (zEquals) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        k72 k72Var = this.b;
        int iHashCode = ((k72Var != null ? k72Var.hashCode() : 0) + 31) * 31;
        j72 j72Var = this.f;
        int iHashCode2 = (iHashCode + (j72Var != null ? j72Var.hashCode() : 0)) * 31;
        String str = this.z;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Class cls = this.A;
        return ((((iHashCode3 + (cls != null ? cls.hashCode() : 0)) * 31) + (this.Y.booleanValue() ? 11 : -17)) * 31) + (this.X ? 11 : -17);
    }

    public final String toString() {
        Class cls = this.A;
        String name = cls == null ? "NULL" : cls.getName();
        StringBuilder sb = new StringBuilder("JsonTypeInfo.Value(idType=");
        sb.append(this.b);
        sb.append(",includeAs=");
        sb.append(this.f);
        sb.append(",propertyName=");
        ha0.v(sb, this.z, ",defaultImpl=", name, ",idVisible=");
        sb.append(this.X);
        sb.append(",requireTypeIdForSubtypes=");
        sb.append(this.Y);
        sb.append(")");
        return sb.toString();
    }
}
