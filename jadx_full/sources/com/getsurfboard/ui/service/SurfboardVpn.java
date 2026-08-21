package com.getsurfboard.ui.service;

import android.app.PendingIntent;
import android.content.Intent;
import com.getsurfboard.R;
import defpackage.d73;
import defpackage.fj3;
import defpackage.l72;
import defpackage.p95;
import defpackage.t23;
import defpackage.ts2;
import defpackage.us2;
import defpackage.yw1;
import defpackage.zn;
import defpackage.zw1;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SurfboardVpn extends yw1 {
    public static final /* synthetic */ int I0 = 0;
    public final zn H0 = new zn(7, this);

    @Override // defpackage.yw1
    public final PendingIntent d() {
        Intent intentS = p95.s(this, false);
        intentS.setFlags(intentS.getFlags() + 67108864);
        intentS.setFlags(intentS.getFlags() + 536870912);
        PendingIntent pendingIntentO = l72.o(this, fj3.b, intentS, true);
        pendingIntentO.getClass();
        return pendingIntentO;
    }

    @Override // defpackage.yw1
    public final us2 f(us2 us2Var, String str) {
        us2Var.getClass();
        ArrayList arrayList = us2Var.b;
        str.getClass();
        Map map = zw1.a;
        Intent intentPutExtra = new Intent(this, (Class<?>) SurfboardVpn.class).putExtra("stop", true);
        intentPutExtra.getClass();
        PendingIntent service = PendingIntent.getService(this, fj3.a, intentPutExtra, l72.a(0, true));
        us2Var.e = us2.b(str);
        if (t23.c(R.string.setting_accessibility_mode_key, false)) {
            String string = getString(R.string.app_name);
            string.getClass();
            String string2 = getString(R.string.vpn_running_template, string);
            string2.getClass();
            us2Var.c(string2);
            us2Var.l = us2.b(string2);
        } else {
            us2Var.c(getString(R.string.speed_template, "0 Bytes", "0 Bytes"));
            us2Var.l = us2.b(getString(R.string.speed_template, "0 Bytes", "0 Bytes"));
        }
        arrayList.clear();
        arrayList.add(new ts2(R.drawable.ic_round_stop_24, getString(R.string.stop), service));
        return us2Var;
    }

    @Override // defpackage.yw1, android.app.Service
    public final void onCreate() {
        super.onCreate();
        d73.c.f(this.H0);
    }

    @Override // defpackage.yw1, android.app.Service
    public final void onDestroy() {
        d73.c.j(this.H0);
        super.onDestroy();
    }
}
