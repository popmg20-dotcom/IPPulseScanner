package defpackage;

import android.content.SharedPreferences;
import android.view.View;
import com.getsurfboard.ui.activity.BypassConfigActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class et implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ BypassConfigActivity f;

    public /* synthetic */ et(BypassConfigActivity bypassConfigActivity, int i) {
        this.b = i;
        this.f = bypassConfigActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        BypassConfigActivity bypassConfigActivity = this.f;
        switch (i) {
            case 0:
                int i2 = BypassConfigActivity.Y0;
                bypassConfigActivity.b().d();
                break;
            case 1:
                int i3 = BypassConfigActivity.Y0;
                bypassConfigActivity.y();
                break;
            case 2:
                int i4 = BypassConfigActivity.Y0;
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putBoolean("bypass_list_compatible_mode", true);
                editorEdit.apply();
                bypassConfigActivity.x();
                bypassConfigActivity.C(null);
                break;
            case 3:
                int i5 = BypassConfigActivity.Y0;
                SharedPreferences.Editor editorEdit2 = t23.l().edit();
                editorEdit2.putBoolean("bypass_list_enabled", true);
                editorEdit2.apply();
                bypassConfigActivity.A();
                bypassConfigActivity.z();
                break;
            default:
                int i6 = BypassConfigActivity.Y0;
                vs4 vs4Var = (vs4) ws4.c.d();
                if (vs4Var != null && vs4Var.b) {
                    bypassConfigActivity.V0 = true;
                    zw1.d(bypassConfigActivity);
                    break;
                }
                break;
        }
    }
}
