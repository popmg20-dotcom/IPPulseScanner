package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y83 extends ke0 {
    public final Class e;
    public final Class f;
    public final b72 g;
    public final b72 h;

    public y83(b93 b93Var, Class cls, b72 b72Var, Class cls2, b72 b72Var2) {
        this.e = cls;
        this.g = b72Var;
        this.f = cls2;
        this.h = b72Var2;
    }

    @Override // defpackage.ke0
    public final b72 A(Class cls) {
        if (cls == this.e) {
            return this.g;
        }
        if (cls == this.f) {
            return this.h;
        }
        return null;
    }

    @Override // defpackage.ke0
    public final ke0 n(Class cls, b72 b72Var) {
        return new a93(this, new c93[]{new c93(this.e, this.g), new c93(this.f, this.h), new c93(cls, b72Var)});
    }
}
