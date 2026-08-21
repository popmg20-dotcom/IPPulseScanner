package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class or2 extends dp {
    public final ConnectivityManager g;

    public or2(Context context, ih4 ih4Var) {
        super(context, ih4Var);
        Object systemService = this.b.getSystemService("connectivity");
        systemService.getClass();
        this.g = (ConnectivityManager) systemService;
    }

    @Override // defpackage.bc0
    public final Object a() {
        return nr2.a(this.g, false);
    }

    @Override // defpackage.dp
    public final IntentFilter e() {
        return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    }

    @Override // defpackage.dp
    public final void f(Intent intent) {
        if (n12.c(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
            ue2.g().a(nr2.a, "Network broadcast received");
            b(nr2.a(this.g, false));
        }
    }
}
