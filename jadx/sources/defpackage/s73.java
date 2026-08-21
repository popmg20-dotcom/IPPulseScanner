package defpackage;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s73 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ d83 f;

    public /* synthetic */ s73(d83 d83Var, int i) {
        this.b = i;
        this.f = d83Var;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        d83 d83Var = this.f;
        switch (i) {
            case 0:
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                ((LinearProgressIndicator) y3Var.g).e();
                break;
            case 1:
                y3 y3Var2 = d83Var.b;
                y3Var2.getClass();
                ((LinearProgressIndicator) y3Var2.g).e();
                break;
            case 2:
                y3 y3Var3 = d83Var.b;
                y3Var3.getClass();
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var3.a;
                coordinatorLayout.getClass();
                r25.R(coordinatorLayout, R.string.webdav_upload_success, new Object[0]);
                break;
            case 3:
                y3 y3Var4 = d83Var.b;
                y3Var4.getClass();
                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var4.a;
                coordinatorLayout2.getClass();
                r25.R(coordinatorLayout2, R.string.webdav_upload_failure, new Object[0]);
                break;
            case 4:
                y3 y3Var5 = d83Var.b;
                y3Var5.getClass();
                CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) y3Var5.a;
                coordinatorLayout3.getClass();
                r25.R(coordinatorLayout3, R.string.webdav_download_success, new Object[0]);
                break;
            default:
                y3 y3Var6 = d83Var.b;
                y3Var6.getClass();
                CoordinatorLayout coordinatorLayout4 = (CoordinatorLayout) y3Var6.a;
                coordinatorLayout4.getClass();
                r25.R(coordinatorLayout4, R.string.webdav_download_failure, new Object[0]);
                break;
        }
        return xl4Var;
    }
}
