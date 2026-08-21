package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class o05 extends v9 {
    public static void A(Context context, vz4 vz4Var, IntentFilter intentFilter) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            context.registerReceiver(vz4Var, intentFilter, i >= 33 ? 2 : 0);
        } else {
            context.registerReceiver(vz4Var, intentFilter);
        }
    }
}
