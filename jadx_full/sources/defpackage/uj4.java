package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uj4 {
    public final int a;
    public final Class b;
    public final nj4 c;
    public final boolean d;

    public uj4(Class cls, boolean z) {
        this.b = cls;
        this.c = null;
        this.d = z;
        this.a = z ? cls.getName().hashCode() + 1 : cls.getName().hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != uj4.class) {
            return false;
        }
        uj4 uj4Var = (uj4) obj;
        if (uj4Var.d != this.d) {
            return false;
        }
        Class cls = this.b;
        return cls != null ? uj4Var.b == cls : this.c.equals(uj4Var.c);
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        boolean z = this.d;
        Class cls = this.b;
        if (cls != null) {
            return "{class: " + cls.getName() + ", typed? " + z + "}";
        }
        return "{type: " + this.c + ", typed? " + z + "}";
    }

    public uj4(nj4 nj4Var) {
        this.c = nj4Var;
        this.b = null;
        this.d = false;
        this.a = nj4Var.hashCode() - 1;
    }
}
