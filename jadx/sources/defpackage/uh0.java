package defpackage;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uh0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ uh0(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.b;
        Object obj = this.f;
        switch (i2) {
            case 0:
                xh0 xh0Var = (xh0) obj;
                try {
                    xh0Var.requireContext().startActivity(new Intent("android.settings.DATE_SETTINGS"));
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    j80 j80Var = xh0Var.b;
                    j80Var.getClass();
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var.a;
                    coordinatorLayout.getClass();
                    r25.R(coordinatorLayout, R.string.unknown_error, new Object[0]);
                    return;
                }
                break;
            case 1:
                kc2 kc2Var = (kc2) obj;
                kc2Var.P0 = i;
                kc2Var.O0 = -1;
                dialogInterface.dismiss();
                break;
            default:
                co4.k(((String) obj).toString());
                p95.C(R.string.message_copied, new Object[0]);
                break;
        }
    }
}
