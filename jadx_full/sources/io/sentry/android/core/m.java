package io.sentry.android.core;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ g0 f;

    public /* synthetic */ m(g0 g0Var, int i) {
        this.b = i;
        this.f = g0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        g0 g0Var = this.f;
        switch (i) {
            case 0:
                ((n) g0Var).b(5000L);
                break;
            default:
                ((p) g0Var).b(5000L);
                break;
        }
    }
}
