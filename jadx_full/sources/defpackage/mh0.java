package defpackage;

import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mh0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ xh0 f;

    public /* synthetic */ mh0(xh0 xh0Var, int i) {
        this.b = i;
        this.f = xh0Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.b;
        xh0 xh0Var = this.f;
        switch (i2) {
            case 0:
                xh0Var.startActivity(new Intent("android.settings.SETTINGS"));
                return;
            case 1:
                r4 r4Var = xh0Var.z;
                if (r4Var != null) {
                    r4Var.a("android.permission.ACCESS_FINE_LOCATION");
                    return;
                } else {
                    n12.T("gpsPermissionLauncher");
                    throw null;
                }
            case 2:
                r4 r4Var2 = xh0Var.z;
                if (r4Var2 != null) {
                    r4Var2.a("android.permission.ACCESS_BACKGROUND_LOCATION");
                    return;
                } else {
                    n12.T("gpsPermissionLauncher");
                    throw null;
                }
            default:
                r4 r4Var3 = xh0Var.A;
                if (r4Var3 != null) {
                    r4Var3.a("android.permission.POST_NOTIFICATIONS");
                    return;
                } else {
                    n12.T("notificationPermissionLauncher");
                    throw null;
                }
        }
    }
}
