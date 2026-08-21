package defpackage;

import kotlin.Function;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class mm1 extends rv implements lm1, y72, Function {
    public final int Z;

    public mm1(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.Z = i;
    }

    @Override // defpackage.lm1
    public final int b() {
        return this.Z;
    }

    @Override // defpackage.rv
    public final y72 c() {
        dh3.a.getClass();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    public final boolean equals(Object obj) {
        ?? r2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof mm1) {
            mm1 mm1Var = (mm1) obj;
            return this.A.equals(mm1Var.A) && this.X.equals(mm1Var.X) && n12.c(this.f, mm1Var.f) && d().equals(mm1Var.d());
        }
        if (!(obj instanceof mm1)) {
            return false;
        }
        y72 y72Var = this.b;
        if (y72Var == null) {
            c();
            this.b = this;
            this = this;
        } else {
            r2 = y72Var;
        }
        return obj.equals(r2);
    }

    public final int hashCode() {
        d();
        return this.X.hashCode() + dw2.w(d().hashCode() * 31, 31, this.A);
    }

    public final String toString() {
        y72 y72Var = this.b;
        if (y72Var == null) {
            c();
            this.b = this;
            y72Var = this;
        }
        if (y72Var != this) {
            return y72Var.toString();
        }
        String str = this.A;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : ha0.o("function ", str, " (Kotlin reflection is not available)");
    }

    public mm1(int i, Class cls, String str, String str2, int i2) {
        this(i, qv.b, cls, str, str2, i2);
    }
}
