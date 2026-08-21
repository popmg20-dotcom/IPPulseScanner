package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u92 implements ca2 {
    public final v92 b;
    public final da2 f;

    public u92(da2 da2Var, v92 v92Var) {
        this.f = da2Var;
        this.b = v92Var;
    }

    @ev2(p92.ON_DESTROY)
    public void onDestroy(da2 da2Var) {
        this.b.u(da2Var);
    }

    @ev2(p92.ON_START)
    public void onStart(da2 da2Var) {
        this.b.p(da2Var);
    }

    @ev2(p92.ON_STOP)
    public void onStop(da2 da2Var) {
        this.b.q(da2Var);
    }
}
