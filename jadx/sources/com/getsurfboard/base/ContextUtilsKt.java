package com.getsurfboard.base;

import android.app.ActivityManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import defpackage.e04;
import defpackage.ha0;
import defpackage.k2;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ContextUtilsKt {
    public static final ActivityManager a() {
        Object systemService = getContext().getSystemService("activity");
        systemService.getClass();
        return (ActivityManager) systemService;
    }

    public static final ConnectivityManager b() {
        Object systemService = getContext().getSystemService("connectivity");
        systemService.getClass();
        return (ConnectivityManager) systemService;
    }

    public static final int c(float f) {
        return (int) TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics());
    }

    public static final int d(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.getClass();
        theme.resolveAttribute(i, typedValue, true);
        int i2 = typedValue.resourceId;
        return i2 != 0 ? context.getColor(i2) : typedValue.data;
    }

    public static final int e(int i) {
        return getContext().getResources().getDimensionPixelSize(i);
    }

    public static final LayoutInflater f(View view) {
        view.getClass();
        Context context = view.getContext();
        context.getClass();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        layoutInflaterFrom.getClass();
        return layoutInflaterFrom;
    }

    public static PackageInfo g(String str) {
        str.getClass();
        try {
            return k2.e(h(), str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final Context getContext() {
        try {
            Object objInvoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
            objInvoke.getClass();
            return (Context) objInvoke;
        } catch (Exception e) {
            e04.l("Get context from activity thread failed", e);
            return null;
        }
    }

    public static final PackageManager h() {
        PackageManager packageManager = getContext().getPackageManager();
        packageManager.getClass();
        return packageManager;
    }

    public static final String i(int i, int i2) {
        String quantityString = getContext().getResources().getQuantityString(i, i2, Integer.valueOf(i2));
        quantityString.getClass();
        return quantityString;
    }

    public static final String j() {
        String strK;
        Object systemService = getContext().getSystemService("power");
        systemService.getClass();
        PowerManager powerManager = (PowerManager) systemService;
        if (Build.VERSION.SDK_INT >= 28) {
            Object systemService2 = getContext().getSystemService("usagestats");
            systemService2.getClass();
            int appStandbyBucket = ((UsageStatsManager) systemService2).getAppStandbyBucket();
            strK = appStandbyBucket != 5 ? appStandbyBucket != 10 ? appStandbyBucket != 20 ? appStandbyBucket != 30 ? appStandbyBucket != 40 ? appStandbyBucket != 45 ? ha0.k("UNKNOWN(", appStandbyBucket, ")") : ha0.k("RESTRICTED(", appStandbyBucket, ")") : ha0.k("RARE(", appStandbyBucket, ")") : ha0.k("FREQUENT(", appStandbyBucket, ")") : ha0.k("WORKING_SET(", appStandbyBucket, ")") : ha0.k("ACTIVE(", appStandbyBucket, ")") : ha0.k("EXEMPTED(", appStandbyBucket, ")");
        } else {
            strK = "n/a";
        }
        return "isDeviceIdleMode=" + powerManager.isDeviceIdleMode() + ", isIgnoringBatteryOptimizations=" + powerManager.isIgnoringBatteryOptimizations(getContext().getPackageName()) + ", standbyBucket=" + strK;
    }

    public static final String k(int i) {
        String string = getContext().getString(i);
        string.getClass();
        return string;
    }

    public static final String l(int i, Object... objArr) {
        String string = getContext().getString(i, Arrays.copyOf(objArr, objArr.length));
        string.getClass();
        return string;
    }

    public static final InputMethodManager m() {
        Object systemService = getContext().getSystemService("input_method");
        systemService.getClass();
        return (InputMethodManager) systemService;
    }
}
