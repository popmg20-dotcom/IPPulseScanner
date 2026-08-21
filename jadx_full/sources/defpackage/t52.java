package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t52 implements Serializable {
    public static final t52 X;
    public final Class A;
    public final s52 b;
    public final s52 f;
    public final Class z;

    static {
        s52 s52Var = s52.X;
        X = new t52(s52Var, s52Var, null, null);
    }

    public t52(s52 s52Var, s52 s52Var2, Class cls, Class cls2) {
        s52 s52Var3 = s52.X;
        this.b = s52Var == null ? s52Var3 : s52Var;
        this.f = s52Var2 == null ? s52Var3 : s52Var2;
        this.z = cls == Void.class ? null : cls;
        this.A = cls2 == Void.class ? null : cls2;
    }

    public final t52 a(t52 t52Var) {
        if (t52Var == null || t52Var == X) {
            return this;
        }
        s52 s52Var = t52Var.b;
        s52 s52Var2 = t52Var.f;
        Class cls = t52Var.z;
        Class cls2 = t52Var.A;
        s52 s52Var3 = s52.X;
        s52 s52Var4 = this.b;
        boolean z = (s52Var == s52Var4 || s52Var == s52Var3) ? false : true;
        s52 s52Var5 = this.f;
        boolean z2 = (s52Var2 == s52Var5 || s52Var2 == s52Var3) ? false : true;
        Class cls3 = this.z;
        return z ? z2 ? new t52(s52Var, s52Var2, cls, cls2) : new t52(s52Var, s52Var5, cls, cls2) : z2 ? new t52(s52Var4, s52Var2, cls, cls2) : (cls == cls3 && cls2 == cls3) ? false : true ? new t52(s52Var4, s52Var5, cls, cls2) : this;
    }

    public final t52 b(s52 s52Var) {
        if (s52Var == this.b) {
            return this;
        }
        return new t52(s52Var, this.f, this.z, this.A);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != t52.class) {
            return false;
        }
        t52 t52Var = (t52) obj;
        return t52Var.b == this.b && t52Var.f == this.f && t52Var.z == this.z && t52Var.A == this.A;
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() << 2);
    }

    public final String toString() {
        StringBuilder sbB = fw.B(80, "JsonInclude.Value(value=");
        sbB.append(this.b);
        sbB.append(",content=");
        sbB.append(this.f);
        Class cls = this.z;
        if (cls != null) {
            sbB.append(",valueFilter=");
            sbB.append(cls.getName());
            sbB.append(".class");
        }
        Class cls2 = this.A;
        if (cls2 != null) {
            sbB.append(",contentFilter=");
            sbB.append(cls2.getName());
            sbB.append(".class");
        }
        sbB.append(')');
        return sbB.toString();
    }
}
