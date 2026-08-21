package io.sentry.android.replay.util;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static String a(k kVar) {
        String str;
        kVar.getClass();
        if (Build.VERSION.SDK_INT < 31) {
            return "";
        }
        int i = l.a[kVar.ordinal()];
        if (i == 1) {
            str = Build.SOC_MODEL;
        } else {
            if (i != 2) {
                defpackage.g.d();
                return null;
            }
            str = Build.SOC_MANUFACTURER;
        }
        str.getClass();
        return str;
    }
}
