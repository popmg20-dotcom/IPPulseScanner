package defpackage;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y73 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ d83 f;
    public final /* synthetic */ Throwable z;

    public /* synthetic */ y73(d83 d83Var, Throwable th, int i) {
        this.b = i;
        this.f = d83Var;
        this.z = th;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        Throwable th = this.z;
        d83 d83Var = this.f;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                d83 d83Var2 = this.f;
                CharSequence text = d83Var2.getText(R.string.unknown_error);
                text.getClass();
                d83Var2.o(this.z, text, null, null, null);
                break;
            case 1:
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var.a;
                coordinatorLayout.getClass();
                String message = th.getMessage();
                if (message == null) {
                    message = d83Var.getString(R.string.webdav_upload_failure);
                    message.getClass();
                }
                r25.S(coordinatorLayout, message);
                break;
            default:
                y3 y3Var2 = d83Var.b;
                y3Var2.getClass();
                CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                coordinatorLayout2.getClass();
                String message2 = th.getMessage();
                if (message2 == null) {
                    message2 = d83Var.getString(R.string.webdav_download_failure);
                    message2.getClass();
                }
                r25.S(coordinatorLayout2, message2);
                break;
        }
        return xl4Var;
    }
}
