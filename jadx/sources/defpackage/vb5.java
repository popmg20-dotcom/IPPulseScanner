package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vb5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ yb5 f;

    public vb5(yb5 yb5Var, int i) {
        this.b = i;
        switch (i) {
            case 1:
                Objects.requireNonNull(yb5Var);
                this.f = yb5Var;
                break;
            default:
                Objects.requireNonNull(yb5Var);
                this.f = yb5Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        yb5 yb5Var = this.f;
        switch (i) {
            case 0:
                yb5Var.y0 = yb5Var.D0;
                break;
            default:
                yb5Var.D0 = null;
                break;
        }
    }
}
