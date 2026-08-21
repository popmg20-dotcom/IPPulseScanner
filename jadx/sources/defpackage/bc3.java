package defpackage;

import com.getsurfboard.R;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bc3 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ QRCodeScannerActivity f;

    public /* synthetic */ bc3(QRCodeScannerActivity qRCodeScannerActivity, int i) {
        this.b = i;
        this.f = qRCodeScannerActivity;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        QRCodeScannerActivity qRCodeScannerActivity = this.f;
        switch (i) {
            case 0:
                String str = (String) obj;
                int i2 = QRCodeScannerActivity.Y0;
                str.getClass();
                qRCodeScannerActivity.runOnUiThread(new xy0(17, qRCodeScannerActivity, str));
                return xl4Var;
            default:
                Integer num = (Integer) obj;
                int i3 = QRCodeScannerActivity.Y0;
                if (num != null) {
                    if (num.intValue() == 1) {
                        qRCodeScannerActivity.W0 = true;
                        v92 v92Var = qRCodeScannerActivity.S0;
                        if (v92Var == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((MaterialButton) v92Var.f).setIconResource(R.drawable.ic_round_flash_on_24);
                    } else {
                        qRCodeScannerActivity.W0 = false;
                        v92 v92Var2 = qRCodeScannerActivity.S0;
                        if (v92Var2 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((MaterialButton) v92Var2.f).setIconResource(R.drawable.ic_round_flash_off_24);
                    }
                }
                return xl4Var;
        }
    }
}
