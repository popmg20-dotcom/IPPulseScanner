package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s83 extends rv implements d82 {
    public final boolean Z;

    public s83(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.Z = false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s83) {
            s83 s83Var = (s83) obj;
            return d().equals(s83Var.d()) && this.A.equals(s83Var.A) && this.X.equals(s83Var.X) && n12.c(this.f, s83Var.f);
        }
        if (obj instanceof d82) {
            return obj.equals(f());
        }
        return false;
    }

    public final y72 f() {
        if (this.Z) {
            return this;
        }
        y72 y72Var = this.b;
        if (y72Var != null) {
            return y72Var;
        }
        y72 y72VarC = c();
        this.b = y72VarC;
        return y72VarC;
    }

    public final int hashCode() {
        return this.X.hashCode() + dw2.w(d().hashCode() * 31, 31, this.A);
    }

    public final String toString() {
        y72 y72VarF = f();
        return y72VarF != this ? y72VarF.toString() : fw.y(new StringBuilder("property "), this.A, " (Kotlin reflection is not available)");
    }
}
