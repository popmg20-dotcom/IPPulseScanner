package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ww1 extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ yw1 b;

    public /* synthetic */ ww1(yw1 yw1Var, int i) {
        this.a = i;
        this.b = yw1Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        int i = this.a;
        yw1 yw1Var = this.b;
        switch (i) {
            case 0:
                context.getClass();
                if (intent != null) {
                    ez4.X("VpnNetReceiver", new uw1(intent, yw1Var));
                    break;
                }
                break;
            default:
                if (intent != null && (networkInfo = (NetworkInfo) r25.A(intent, "networkInfo", NetworkInfo.class)) != null && networkInfo.getType() == 1) {
                    yw1Var.i();
                    yw1Var.e().a();
                }
                break;
        }
    }
}
