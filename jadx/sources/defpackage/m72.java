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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L4
            goto L54
        L4:
            r1 = 0
            if (r5 != 0) goto L8
            goto L55
        L8:
            java.lang.Class r2 = r5.getClass()
            java.lang.Class<m72> r3 = defpackage.m72.class
            if (r2 != r3) goto L55
            m72 r5 = (defpackage.m72) r5
            k72 r2 = r4.b
            k72 r3 = r5.b
            if (r2 != r3) goto L55
            j72 r2 = r4.f
            j72 r3 = r5.f
            if (r2 != r3) goto L55
            java.lang.Class r2 = r4.A
            java.lang.Class r3 = r5.A
            if (r2 != r3) goto L55
            boolean r2 = r4.X
            boolean r3 = r5.X
            if (r2 != r3) goto L55
            java.lang.String r2 = r5.z
            java.lang.String r3 = r4.z
            if (r3 != 0) goto L36
            if (r2 != 0) goto L34
            r2 = r0
            goto L3d
        L34:
            r2 = r1
            goto L3d
        L36:
            if (r2 != 0) goto L39
            goto L34
        L39:
            boolean r2 = r3.equals(r2)
        L3d:
            if (r2 == 0) goto L55
            java.lang.Boolean r5 = r5.Y
            java.lang.Boolean r4 = r4.Y
            if (r4 != 0) goto L4b
            if (r5 != 0) goto L49
            r4 = r0
            goto L52
        L49:
            r4 = r1
            goto L52
        L4b:
            if (r5 != 0) goto L4e
            goto L49
        L4e:
            boolean r4 = r4.equals(r5)
        L52:
            if (r4 == 0) goto L55
        L54:
            return r0
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m72.equals(java.lang.Object):boolean");
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
