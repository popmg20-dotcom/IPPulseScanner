package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yg2 implements g50, Serializable {
    public final long b;
    public final jl f;

    static {
        t52 t52Var = t52.X;
        e52 e52Var = e52.y0;
    }

    public yg2(zg2 zg2Var, long j) {
        this.f = zg2Var.f;
        this.b = j;
    }

    public static int b(Class cls) {
        int iB = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            la0 la0Var = (la0) obj;
            if (la0Var.a()) {
                iB |= la0Var.b();
            }
        }
        return iB;
    }

    public final nj4 c(Class cls) {
        return this.f.b.b(null, cls, rj4.A);
    }

    public final cu2 d() {
        return f(ah2.USE_ANNOTATIONS) ? this.f.z : ns2.b;
    }

    public abstract boolean e(rj0 rj0Var);

    public final boolean f(ah2 ah2Var) {
        return (ah2Var.f & this.b) != 0;
    }

    public yg2(jl jlVar, long j) {
        this.f = jlVar;
        this.b = j;
    }
}
