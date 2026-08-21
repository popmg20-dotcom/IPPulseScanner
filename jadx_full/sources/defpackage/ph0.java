package defpackage;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.service.SurfboardTile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ph0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;

    public /* synthetic */ ph0(int i) {
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.b) {
            case 0:
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putBoolean(ContextUtilsKt.k(R.string.setting_disable_check_notification_key), true);
                editorEdit.apply();
                break;
            case 1:
                ha0.u("action", "positive", "external_resource_update_failed_dialog");
                break;
            case 2:
                xb5.c("import profile url dialog cancel clicked");
                break;
            case 3:
                xb5.c("naming profile dialog cancel clicked");
                break;
            case 4:
                ha0.u("action", "positive", "import_profile_failed_dialog");
                break;
            case 5:
                ha0.u("action", "positive", "local_managed_config_warning_dialog");
                break;
            case 6:
                ha0.u("action", "negative", "delete_profile_dialog");
                break;
            default:
                int i2 = SurfboardTile.X;
                ha0.u("action", "negative", "tile_no_valid_profiles_dialog");
                break;
        }
    }
}
