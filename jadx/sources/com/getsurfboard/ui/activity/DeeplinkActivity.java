package com.getsurfboard.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.R;
import com.tencent.mars.xlog.Xlog;
import defpackage.ca;
import defpackage.fy4;
import defpackage.hj;
import defpackage.ji0;
import defpackage.le2;
import defpackage.n12;
import defpackage.p95;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vs4;
import defpackage.w44;
import defpackage.ws4;
import defpackage.zw1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DeeplinkActivity extends ca {
    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "DeeplinkActivity", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onCreate");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("DeeplinkActivity", "onCreate", null);
        }
        v9.e(getWindow());
        super.onCreate(bundle);
        moveTaskToBack(true);
        Uri data = getIntent().getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        if (schemeSpecificPart != null && w44.j0(schemeSpecificPart, "///install-config?url=", false)) {
            Intent intentS = p95.s(this, false);
            intentS.setData(getIntent().getData());
            intentS.setFlags(intentS.getFlags() + 67108864);
            intentS.setFlags(intentS.getFlags() + 536870912);
            intentS.setFlags(intentS.getFlags() + 268435456);
            startActivity(intentS);
            finish();
            return;
        }
        if (!n12.c(schemeSpecificPart, "///toggle") && !n12.c(schemeSpecificPart, "///start") && !n12.c(schemeSpecificPart, "///stop")) {
            p95.C(R.string.unknown_deeplink, getIntent().getData());
            finish();
            return;
        }
        vs4 vs4Var = (vs4) ws4.c.d();
        if (vs4Var == null || !vs4Var.b) {
            if (n12.c(schemeSpecificPart, "///stop")) {
                finish();
                return;
            } else {
                ji0.B(uf2.t(this), null, null, new hj(this, this, null, 13), 3);
                return;
            }
        }
        if (!n12.c(schemeSpecificPart, "///start")) {
            p95.C(R.string.stopping_vpn, new Object[0]);
            zw1.d(this);
        }
        finish();
    }
}
