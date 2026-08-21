package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class s0 implements Runnable {
    public final u0 b;
    public final /* synthetic */ v0 f;

    public s0(v0 v0Var, u0 u0Var) {
        this.f = v0Var;
        this.b = u0Var;
    }

    public abstract Object a();

    public boolean b() {
        return this.f.b != null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (b()) {
            this.b.a(a());
        } else {
            u0 u0Var = this.b;
            synchronized (u0Var) {
                u0Var.e++;
                u0Var.a(null);
            }
        }
    }
}
