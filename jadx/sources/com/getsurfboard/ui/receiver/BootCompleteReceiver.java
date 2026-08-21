package com.getsurfboard.ui.receiver;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import defpackage.ao;
import defpackage.d70;
import defpackage.d73;
import defpackage.fy4;
import defpackage.le2;
import defpackage.t23;
import defpackage.zn;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class BootCompleteReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final zn a = new zn(0, this);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        String str = "onReceive() called with: context = " + context + ", intent = " + intent;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "BootCompleteReceiver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("BootCompleteReceiver", str, null);
        }
        if (d70.W(intent != null ? intent.getAction() : null, ao.a)) {
            if (t23.c(R.string.setting_start_when_boot_key, false)) {
                d73.c.f(this.a);
                return;
            }
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "BootCompleteReceiver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "isStartWhenBootedEnabled return false");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("BootCompleteReceiver", "isStartWhenBootedEnabled return false", null);
            }
            ContextUtilsKt.h().setComponentEnabledSetting(new ComponentName(context, (Class<?>) BootCompleteReceiver.class), 2, 1);
        }
    }
}
