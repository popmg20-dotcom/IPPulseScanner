package com.getsurfboard.ui.receiver.appwidget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;
import defpackage.cr2;
import defpackage.fy4;
import defpackage.le2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetRetryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str = "onReceive() called with: context = " + context + ", intent = " + intent;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "WidgetRetryReceiver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("WidgetRetryReceiver", str, null);
        }
        String stringExtra = intent != null ? intent.getStringExtra("type") : null;
        if (stringExtra != null) {
            int iHashCode = stringExtra.hashCode();
            if (iHashCode == -1876051613) {
                if (stringExtra.equals("private_ip")) {
                    cr2.d();
                }
            } else if (iHashCode == 99625) {
                if (stringExtra.equals("dns")) {
                    cr2.b();
                }
            } else if (iHashCode == 1446918845 && stringExtra.equals("public_ip")) {
                cr2.e();
            }
        }
    }
}
