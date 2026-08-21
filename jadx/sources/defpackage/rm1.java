package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rm1 implements wv {
    public final /* synthetic */ int b;
    public final /* synthetic */ nc2 f;

    public /* synthetic */ rm1(nc2 nc2Var, int i) {
        this.b = i;
        this.f = nc2Var;
    }

    @Override // defpackage.wv
    public final Object n(vv vvVar) {
        int i = this.b;
        nc2 nc2Var = this.f;
        switch (i) {
            case 0:
                n12.O(false, nc2Var, vvVar, yu0.a());
                return "nonCancellationPropagating[" + nc2Var + "]";
            default:
                nc2Var.a(new ga1(5, vvVar), yu0.a());
                return "transformVoidFuture [" + nc2Var + "]";
        }
    }
}
