package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f95 implements ag5 {
    public final Executor b;
    public final Object d;
    public final /* synthetic */ int a = 1;
    public final Object c = new Object();

    public f95(Executor executor, dv2 dv2Var) {
        this.b = executor;
        this.d = dv2Var;
    }

    private final void b(wt2 wt2Var) {
        synchronized (this.c) {
        }
        this.b.execute(new um1(15, (Object) this, (Object) wt2Var, false));
    }

    private final void c(wt2 wt2Var) {
        if (wt2Var.e()) {
            return;
        }
        synchronized (this.c) {
        }
        this.b.execute(new um1(17, (Object) this, (Object) wt2Var, false));
    }

    @Override // defpackage.ag5
    public final void a(wt2 wt2Var) {
        switch (this.a) {
            case 0:
                b(wt2Var);
                return;
            case 1:
                c(wt2Var);
                return;
            default:
                if (wt2Var.e()) {
                    synchronized (this.c) {
                        break;
                    }
                    this.b.execute(new um1(22, (Object) this, (Object) wt2Var, false));
                    return;
                }
                return;
        }
    }

    public f95(Executor executor, e24 e24Var) {
        this.b = executor;
        this.d = e24Var;
    }

    public f95(Executor executor, jf4 jf4Var) {
        this.b = executor;
        this.d = jf4Var;
    }
}
