package defpackage;

import android.content.DialogInterface;
import com.getsurfboard.ui.service.SurfboardTile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ka1 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int b;

    public /* synthetic */ ka1(int i) {
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        String str;
        switch (this.b) {
            case 0:
                str = "external_resource_update_failed_dialog";
                break;
            case 1:
                str = "import_profile_failed_dialog";
                break;
            case 2:
                str = "delete_profile_dialog";
                break;
            case 3:
                str = "local_managed_config_warning_dialog";
                break;
            default:
                int i = SurfboardTile.X;
                str = "tile_no_valid_profiles_dialog";
                break;
        }
        ha0.u("action", "cancel", str);
    }
}
