package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e75 extends BroadcastReceiver {
    public final ff5 a;
    public boolean b;
    public boolean c;

    public e75(ff5 ff5Var) {
        this.a = ff5Var;
    }

    public final void a() {
        ff5 ff5Var = this.a;
        ff5Var.j0();
        ff5Var.C().V0();
        ff5Var.C().V0();
        if (this.b) {
            ff5Var.n().H0.a("Unregistering connectivity change receiver");
            this.b = false;
            this.c = false;
            try {
                ff5Var.C0.b.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                ff5Var.n().z0.b(e, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ff5 ff5Var = this.a;
        ff5Var.j0();
        String action = intent.getAction();
        ff5Var.n().H0.b(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            ff5Var.n().C0.b(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        z65 z65Var = ff5Var.f;
        ff5.R(z65Var);
        boolean zP1 = z65Var.p1();
        if (this.c != zP1) {
            this.c = zP1;
            ff5Var.C().e1(new qz4(this, zP1));
        }
    }
}
