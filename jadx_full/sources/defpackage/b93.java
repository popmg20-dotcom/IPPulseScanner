package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b93 extends ke0 {
    public final Class e;
    public final b72 f;

    public b93(ke0 ke0Var, Class cls, b72 b72Var) {
        this.e = cls;
        this.f = b72Var;
    }

    @Override // defpackage.ke0
    public final b72 A(Class cls) {
        if (cls == this.e) {
            return this.f;
        }
        return null;
    }

    @Override // defpackage.ke0
    public final ke0 n(Class cls, b72 b72Var) {
        return new y83(this, this.e, this.f, cls, b72Var);
    }
}
