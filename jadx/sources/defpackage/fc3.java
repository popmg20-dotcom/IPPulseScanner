package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fc3 {
    public final Class a;
    public final Class b;

    public fc3(Class cls, Class cls2) {
        this.a = cls;
        this.b = cls2;
    }

    public static fc3 a(Class cls) {
        return new fc3(ec3.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fc3.class != obj.getClass()) {
            return false;
        }
        fc3 fc3Var = (fc3) obj;
        if (this.b.equals(fc3Var.b)) {
            return this.a.equals(fc3Var.a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.b;
        Class cls2 = this.a;
        if (cls2 == ec3.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
