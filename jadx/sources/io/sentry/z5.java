package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z5 implements io.sentry.util.e {
    public final /* synthetic */ int b;
    public final /* synthetic */ p6 f;

    public /* synthetic */ z5(io.sentry.util.g gVar, p6 p6Var) {
        this.b = 3;
        this.f = p6Var;
    }

    @Override // io.sentry.util.e
    public final Object e() {
        int i = this.b;
        p6 p6Var = this.f;
        switch (i) {
            case 0:
                return p6Var.a();
            case 1:
                return new l2(p6Var);
            case 2:
                return p6Var.b();
            default:
                return Boolean.valueOf(io.sentry.util.g.b(p6Var, "androidx.core.view.ScrollingView"));
        }
    }

    public /* synthetic */ z5(p6 p6Var, int i) {
        this.b = i;
        this.f = p6Var;
    }
}
