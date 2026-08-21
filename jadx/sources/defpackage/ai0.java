package defpackage;

import android.content.DialogInterface;
import com.getsurfboard.ui.service.SurfboardTile;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ai0 implements DialogInterface.OnShowListener {
    public final /* synthetic */ int a;

    public /* synthetic */ ai0(int i) {
        this.a = i;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        String str;
        switch (this.a) {
            case 0:
                str = "dashboard_toggle_cards_dialog";
                break;
            case 1:
                str = "external_resource_update_failed_dialog";
                break;
            case 2:
                str = "import_profile_failed_dialog";
                break;
            case 3:
                str = "delete_profile_dialog";
                break;
            case 4:
                str = "local_managed_config_warning_dialog";
                break;
            default:
                int i = SurfboardTile.X;
                str = "tile_no_valid_profiles_dialog";
                break;
        }
        ha0.u("action", "open", str);
    }
}
