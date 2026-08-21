package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import defpackage.ue2;
import defpackage.xw4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a = ue2.i("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ue2.g().a(a, "Received intent " + intent);
        try {
            xw4 xw4VarC = xw4.c(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (xw4.m) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = xw4VarC.i;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    xw4VarC.i = pendingResultGoAsync;
                    if (xw4VarC.h) {
                        pendingResultGoAsync.finish();
                        xw4VarC.i = null;
                    }
                } finally {
                }
            }
        } catch (IllegalStateException e) {
            ue2.g().f(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
