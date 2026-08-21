package defpackage;

import android.util.Size;
import android.view.OrientationEventListener;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dc3 extends OrientationEventListener {
    public final /* synthetic */ QRCodeScannerActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc3(QRCodeScannerActivity qRCodeScannerActivity) {
        super(qRCodeScannerActivity);
        this.a = qRCodeScannerActivity;
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        Size sizeL;
        int i2 = (45 > i || i >= 135) ? (135 > i || i >= 225) ? (225 > i || i >= 315) ? 0 : 1 : 2 : 3;
        lx1 lx1Var = this.a.V0;
        if (lx1Var != null) {
            int iF0 = ((hy1) lx1Var.g).f0(-1);
            if (iF0 == -1 || iF0 != i2) {
                ln4 ln4VarL = lx1Var.l(lx1Var.e);
                qx qxVar = (qx) ln4VarL;
                hy1 hy1Var = (hy1) qxVar.b();
                int iF02 = hy1Var.f0(-1);
                if (iF02 == -1 || iF02 != i2) {
                    qx qxVar2 = (qx) ln4VarL;
                    switch (qxVar2.a) {
                        case 2:
                            qxVar2.b.g(hy1.w, Integer.valueOf(i2));
                            break;
                        case 3:
                            qxVar2.b.g(hy1.w, Integer.valueOf(i2));
                            break;
                        default:
                            qn2 qn2Var = qxVar2.b;
                            qn2Var.g(hy1.w, Integer.valueOf(i2));
                            qn2Var.g(hy1.x, Integer.valueOf(i2));
                            break;
                    }
                }
                if (iF02 != -1 && iF02 != i2) {
                    if (Math.abs(r25.T(i2) - r25.T(iF02)) % 180 == 90 && (sizeL = hy1Var.L()) != null) {
                        qx qxVar3 = (qx) ln4VarL;
                        Size size = new Size(sizeL.getHeight(), sizeL.getWidth());
                        switch (qxVar3.a) {
                            case 2:
                                qxVar3.b.g(hy1.B, size);
                                break;
                            case 3:
                                qxVar3.b.g(hy1.B, size);
                                break;
                            default:
                                qxVar3.b.g(hy1.B, size);
                                break;
                        }
                    }
                }
                lx1Var.e = qxVar.b();
                mz mzVarC = lx1Var.c();
                if (mzVarC == null) {
                    lx1Var.g = lx1Var.e;
                } else {
                    lx1Var.g = lx1Var.n(mzVarC.r(), lx1Var.d, lx1Var.i);
                }
                lx1Var.G();
            }
        }
    }
}
