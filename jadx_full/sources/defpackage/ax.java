package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ax implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ed4 f;

    public /* synthetic */ ax(ed4 ed4Var, int i) {
        this.b = i;
        this.f = ed4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ed4 ed4Var = this.f;
        switch (i) {
            case 0:
                int i2 = 1;
                if (!((AtomicBoolean) ed4Var.z).getAndSet(true)) {
                    ((ex) ((lb) ed4Var.A).z).z.execute(new ax(ed4Var, i2));
                    break;
                }
                break;
            default:
                int i3 = ((ex) ((lb) ed4Var.A).z).c1;
                lb lbVar = (lb) ed4Var.A;
                if (i3 == 9) {
                    ((ex) lbVar.z).w("Camera onError timeout, reopen it.", null);
                    ((ex) ((lb) ed4Var.A).z).G(8);
                    ((ex) ((lb) ed4Var.A).z).y0.b();
                } else {
                    ex exVar = (ex) lbVar.z;
                    exVar.w("Camera skip reopen at state: ".concat(fw.H(exVar.c1)), null);
                }
                break;
        }
    }
}
