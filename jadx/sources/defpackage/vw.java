package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vw implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ex f;

    public /* synthetic */ vw(ex exVar, int i) {
        this.b = i;
        this.f = exVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ex exVar = this.f;
        switch (i) {
            case 0:
                exVar.w("Camera is removed. Updating state and cleaning up.", null);
                if (exVar.c1 != 2 && exVar.c1 != 1) {
                    mg mgVar = new mg(null, 8);
                    exVar.Y.S(lz.CLOSED, mgVar);
                    exVar.H(2, mgVar, true);
                    exVar.y0.a();
                    exVar.b1.n();
                    if (exVar.A0 == null) {
                        exVar.x();
                    } else {
                        exVar.t();
                    }
                    break;
                }
                break;
            default:
                exVar.P0 = false;
                exVar.O0 = false;
                exVar.w("OpenCameraConfigAndClose is done, state: ".concat(fw.H(exVar.c1)), null);
                int iG = fw.G(exVar.c1);
                if (iG == 1 || iG == 5) {
                    r25.j(null, exVar.G0.isEmpty());
                    exVar.x();
                } else if (iG == 7) {
                    int i2 = exVar.B0;
                    if (i2 == 0) {
                        exVar.L(false);
                    } else {
                        exVar.w("OpenCameraConfigAndClose in error: ".concat(ex.y(i2)), null);
                        exVar.y0.b();
                    }
                } else {
                    exVar.w("OpenCameraConfigAndClose finished while in state: ".concat(fw.H(exVar.c1)), null);
                }
                break;
        }
    }
}
