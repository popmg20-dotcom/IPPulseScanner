package io.sentry;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v6 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ x6 f;

    public /* synthetic */ v6(x6 x6Var, int i) {
        this.b = i;
        this.f = x6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        x6 x6Var = this.f;
        switch (i) {
            case 0:
                f7 status = x6Var.getStatus();
                if (status == null) {
                    status = f7.OK;
                }
                x6Var.f(status);
                x6Var.l.set(false);
                break;
            default:
                f7 status2 = x6Var.getStatus();
                if (status2 == null) {
                    status2 = f7.DEADLINE_EXCEEDED;
                }
                x6Var.d(status2, x6Var.r.g != null, null);
                x6Var.m.set(false);
                break;
        }
    }
}
