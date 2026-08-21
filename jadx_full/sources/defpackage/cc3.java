package defpackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import androidx.camera.view.PreviewView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.QRCodeScannerActivity;
import java.io.FileNotFoundException;
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
    */
    public final Object p(Object obj) {
        int i = this.X;
        int i2 = 0;
        Uri uri = this.y0;
        QRCodeScannerActivity qRCodeScannerActivity = this.Z;
        mf0 mf0Var = mf0.b;
        xl4 xl4Var = xl4.a;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i3 = this.Y;
                int i4 = 2;
                q92 q92Var = q92.b;
                q92 q92Var2 = q92.X;
                cf0 cf0Var = this.f;
                try {
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    fa2 fa2Var = qRCodeScannerActivity.b;
                    gm0 gm0Var = qv0.a;
                    tq1 tq1Var = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ0 = tq1Var.q0(cf0Var);
                    if (zQ0) {
                        jz2 jz2Var = new jz2(3);
                        this.Y = 5;
                        if (ji0.V(fa2Var, q92Var2, zQ0, tq1Var, jz2Var, this) == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        q92 q92Var3 = fa2Var.c;
                        if (q92Var3 == q92Var) {
                            vp1.m();
                        } else if (q92Var3.compareTo(q92Var2) >= 0) {
                            p95.C(R.string.io_error, new Object[0]);
                        }
                    }
                    return xl4Var;
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    fa2 fa2Var2 = qRCodeScannerActivity.b;
                    gm0 gm0Var2 = qv0.a;
                    tq1 tq1Var2 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ02 = tq1Var2.q0(cf0Var);
                    if (zQ02) {
                        jz2 jz2Var2 = new jz2(1);
                        this.Y = 3;
                        if (ji0.V(fa2Var2, q92Var2, zQ02, tq1Var2, jz2Var2, this) == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        q92 q92Var4 = fa2Var2.c;
                        if (q92Var4 == q92Var) {
                            vp1.m();
                        } else if (q92Var4.compareTo(q92Var2) >= 0) {
                            p95.C(R.string.unknown_error, new Object[0]);
                        }
                    }
                    return xl4Var;
                } catch (SecurityException e3) {
                    e3.printStackTrace();
                    fa2 fa2Var3 = qRCodeScannerActivity.b;
                    gm0 gm0Var3 = qv0.a;
                    tq1 tq1Var3 = qf2.a.X;
                    cf0Var.getClass();
                    boolean zQ03 = tq1Var3.q0(cf0Var);
                    if (zQ03) {
                        jz2 jz2Var3 = new jz2(2);
                        this.Y = 4;
                        if (ji0.V(fa2Var3, q92Var2, zQ03, tq1Var3, jz2Var3, this) == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        q92 q92Var5 = fa2Var3.c;
                        if (q92Var5 == q92Var) {
                            vp1.m();
                        } else if (q92Var5.compareTo(q92Var2) >= 0) {
                            p95.C(R.string.unknown_error, new Object[0]);
                        }
                    }
                    return xl4Var;
                }
                if (i3 == 0) {
                    n12.S(obj);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(qRCodeScannerActivity.getContentResolver().openInputStream(uri), null, options);
                    v92 v92Var = qRCodeScannerActivity.S0;
                    if (v92Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    int width = ((PreviewView) v92Var.b).getWidth();
                    v92 v92Var2 = qRCodeScannerActivity.S0;
                    if (v92Var2 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    options.inSampleSize = p95.d(options, width, ((PreviewView) v92Var2.b).getHeight());
                    options.inJustDecodeBounds = false;
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(qRCodeScannerActivity.getContentResolver().openInputStream(uri), null, options);
                    if (bitmapDecodeStream == null) {
                        gm0 gm0Var4 = qv0.a;
                        tq1 tq1Var4 = qf2.a;
                        lt ltVar = new lt(i4, ge0Var, 7);
                        this.Y = 1;
                        if (ji0.b0(tq1Var4, ltVar, this) == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        int width2 = bitmapDecodeStream.getWidth();
                        int height = bitmapDecodeStream.getHeight();
                        int[] iArr = new int[width2 * height];
                        bitmapDecodeStream.getPixels(iArr, 0, width2, 0, 0, width2, height);
                        bitmapDecodeStream.recycle();
                        lb lbVar = new lb(15, new iv1(new dd3(width2, height, iArr)));
                        ki0 ki0Var = new ki0(2);
                        try {
                            ki0Var.g();
                            qRCodeScannerActivity.setResult(-1, new Intent().putExtra("result", ki0Var.c(lbVar).a));
                            qRCodeScannerActivity.finish();
                        } catch (qs2 e4) {
                            e4.printStackTrace();
                            gm0 gm0Var5 = qv0.a;
                            tq1 tq1Var5 = qf2.a;
                            lt ltVar2 = new lt(i4, ge0Var, 8);
                            this.Y = 2;
                            if (ji0.b0(tq1Var5, ltVar2, this) == mf0Var) {
                                return mf0Var;
                            }
                        }
                    }
                    break;
                } else {
                    if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var;
            default:
                int i5 = this.Y;
                if (i5 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    int i6 = QRCodeScannerActivity.Y0;
                    Object objB0 = ji0.b0(qv0.a, new cc3(qRCodeScannerActivity, uri, ge0Var, i2), this);
                    if (objB0 != mf0Var) {
                        objB0 = xl4Var;
                    }
                    if (objB0 == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var;
        }
    }
}
