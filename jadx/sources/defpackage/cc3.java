package defpackage;

import android.net.Uri;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cc3 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ QRCodeScannerActivity Z;
    public final /* synthetic */ Uri y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cc3(QRCodeScannerActivity qRCodeScannerActivity, Uri uri, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = qRCodeScannerActivity;
        this.y0 = uri;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((cc3) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Uri uri = this.y0;
        QRCodeScannerActivity qRCodeScannerActivity = this.Z;
        switch (i) {
            case 0:
                return new cc3(qRCodeScannerActivity, uri, ge0Var, 0);
            default:
                return new cc3(qRCodeScannerActivity, uri, ge0Var, 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ef  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r27) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cc3.p(java.lang.Object):java.lang.Object");
    }
}
