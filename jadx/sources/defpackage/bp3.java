package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bp3 implements aa2, AutoCloseable {
    public final String b;
    public final ap3 f;
    public boolean z;

    public bp3(String str, ap3 ap3Var) {
        this.b = str;
        this.f = ap3Var;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        if (p92Var == p92.ON_DESTROY) {
            this.z = false;
            da2Var.getLifecycle().c(this);
        }
    }

    public final void x(hp3 hp3Var, r92 r92Var) {
        hp3Var.getClass();
        r92Var.getClass();
        if (this.z) {
            xe.q("Already attached to lifecycleOwner");
            return;
        }
        this.z = true;
        r92Var.a(this);
        hp3Var.c(this.b, (c90) this.f.a.X);
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }
}
