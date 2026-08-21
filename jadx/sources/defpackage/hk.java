package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class hk implements nb0 {
    public final bc0 a;

    public hk(bc0 bc0Var) {
        this.a = bc0Var;
    }

    @Override // defpackage.nb0
    public final boolean a(gx4 gx4Var) {
        return c(gx4Var) && e(this.a.a());
    }

    @Override // defpackage.nb0
    public final uv b(mc0 mc0Var) {
        mc0Var.getClass();
        return new uv(new hj(this, null, 2), c41.b, -2, jp.b);
    }

    public abstract int d();

    public abstract boolean e(Object obj);
}
