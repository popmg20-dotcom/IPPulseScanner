package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wn0 implements Runnable {
    public final /* synthetic */ cp1 A;
    public final /* synthetic */ int b;
    public final /* synthetic */ yn0 f;
    public final /* synthetic */ Runnable z;

    public /* synthetic */ wn0(yn0 yn0Var, Runnable runnable, cp1 cp1Var, int i) {
        this.b = i;
        this.f = yn0Var;
        this.z = runnable;
        this.A = cp1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        final cp1 cp1Var = this.A;
        final Runnable runnable = this.z;
        yn0 yn0Var = this.f;
        switch (i) {
            case 0:
                final int i2 = 0;
                yn0Var.b.execute(new Runnable() { // from class: tn0
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        int i3 = i2;
                        cp1 cp1Var2 = cp1Var;
                        Runnable runnable2 = runnable;
                        switch (i3) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e) {
                                    ((ao0) cp1Var2.f).k(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e2) {
                                    ((ao0) cp1Var2.f).k(e2);
                                    return;
                                }
                            default:
                                ao0 ao0Var = (ao0) cp1Var2.f;
                                try {
                                    runnable2.run();
                                    ao0Var.j(null);
                                    return;
                                } catch (Exception e3) {
                                    ao0Var.k(e3);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                final int i3 = 2;
                yn0Var.b.execute(new Runnable() { // from class: tn0
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        int i32 = i3;
                        cp1 cp1Var2 = cp1Var;
                        Runnable runnable2 = runnable;
                        switch (i32) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e) {
                                    ((ao0) cp1Var2.f).k(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e2) {
                                    ((ao0) cp1Var2.f).k(e2);
                                    return;
                                }
                            default:
                                ao0 ao0Var = (ao0) cp1Var2.f;
                                try {
                                    runnable2.run();
                                    ao0Var.j(null);
                                    return;
                                } catch (Exception e3) {
                                    ao0Var.k(e3);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                final int i4 = 1;
                yn0Var.b.execute(new Runnable() { // from class: tn0
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        int i32 = i4;
                        cp1 cp1Var2 = cp1Var;
                        Runnable runnable2 = runnable;
                        switch (i32) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e) {
                                    ((ao0) cp1Var2.f).k(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e2) {
                                    ((ao0) cp1Var2.f).k(e2);
                                    return;
                                }
                            default:
                                ao0 ao0Var = (ao0) cp1Var2.f;
                                try {
                                    runnable2.run();
                                    ao0Var.j(null);
                                    return;
                                } catch (Exception e3) {
                                    ao0Var.k(e3);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
