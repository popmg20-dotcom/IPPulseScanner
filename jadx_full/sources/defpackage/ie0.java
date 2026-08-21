package defpackage;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ie0 extends kk {
    public final cf0 f;
    public transient ge0 z;

    public ie0(ge0 ge0Var) {
        this(ge0Var, ge0Var != null ? ge0Var.j() : null);
    }

    @Override // defpackage.ge0
    public cf0 j() {
        cf0 cf0Var = this.f;
        cf0Var.getClass();
        return cf0Var;
    }

    @Override // defpackage.kk
    public void q() {
        Unsafe unsafe;
        long j;
        ge0 ge0Var = this.z;
        if (ge0Var != null && ge0Var != this) {
            af0 af0VarZ = j().Z(pr1.f);
            af0VarZ.getClass();
            lv0 lv0Var = (lv0) ge0Var;
            do {
                unsafe = re.a;
                j = lv0.y0;
            } while (unsafe.getObjectVolatile(lv0Var, j) == mv0.b);
            Object objectVolatile = unsafe.getObjectVolatile(lv0Var, j);
            z00 z00Var = objectVolatile instanceof z00 ? (z00) objectVolatile : null;
            if (z00Var != null) {
                z00Var.r();
            }
        }
        this.z = q80.f;
    }

    public ie0(ge0 ge0Var, cf0 cf0Var) {
        super(ge0Var);
        this.f = cf0Var;
    }
}
