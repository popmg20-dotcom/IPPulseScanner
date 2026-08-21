package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ej4 implements ii4 {
    public final /* synthetic */ Class b;
    public final /* synthetic */ Class f;
    public final /* synthetic */ hi4 z;

    public ej4(Class cls, Class cls2, hi4 hi4Var) {
        this.b = cls;
        this.f = cls2;
        this.z = hi4Var;
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        Class cls = bk4Var.a;
        if (cls == this.b || cls == this.f) {
            return this.z;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f.getName() + "+" + this.b.getName() + ",adapter=" + this.z + "]";
    }
}
