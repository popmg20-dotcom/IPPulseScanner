package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xf4 {
    public final nw a;
    public final on2 b;
    public final on2 c;
    public final boolean d;
    public final at3 e;
    public boolean f;
    public final int g;
    public vv h;
    public boolean i;

    public xf4(nw nwVar, sy syVar, at3 at3Var) {
        this.a = nwVar;
        this.e = at3Var;
        boolean zR = gb4.R(new fx(syVar, 1));
        this.d = zR;
        int iB = (zR && syVar.e()) ? syVar.b() : 0;
        this.g = iB;
        this.b = new on2(0);
        this.c = new on2(Integer.valueOf(iB));
        nwVar.a(new mw() { // from class: wf4
            @Override // defpackage.mw
            public final boolean d(TotalCaptureResult totalCaptureResult) {
                xf4 xf4Var = this.a;
                if (xf4Var.h != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == xf4Var.i) {
                        xf4Var.h.b(null);
                        xf4Var.h = null;
                    }
                }
                return false;
            }
        });
    }

    public final void a(int i) {
        Integer numValueOf = Integer.valueOf(i != 1 ? 0 : 1);
        boolean zE = co4.E();
        on2 on2Var = this.b;
        if (zE) {
            on2Var.l(numValueOf);
        } else {
            on2Var.i(numValueOf);
        }
    }
}
