package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import defpackage.ae0;
import defpackage.st4;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.p6;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class p0 {
    public static final ae0 a = new ae0(new st4(22));
    public static final ae0 b = new ae0(new st4(23));
    public static final ae0 c = new ae0(new st4(24));
    public static final ae0 d = new ae0(new st4(25));
    public static final ae0 e = new ae0(new st4(26));

    public static String a(ILogger iLogger) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Throwable th) {
            iLogger.d(p5.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    public static ActivityManager.MemoryInfo b(Context context, ILogger iLogger) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            iLogger.h(p5.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            iLogger.d(p5.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    public static PackageInfo c(Context context, ILogger iLogger, q0 q0Var) {
        try {
            q0Var.getClass();
            return Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(4096L)) : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (Throwable th) {
            iLogger.d(p5.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    public static PackageInfo d(Context context, q0 q0Var) {
        q0Var.getClass();
        return Build.VERSION.SDK_INT >= 33 ? (PackageInfo) a.a(context) : (PackageInfo) b.a(context);
    }

    public static String e(PackageInfo packageInfo, q0 q0Var) {
        q0Var.getClass();
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }

    public static boolean f() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            return runningAppProcessInfo.importance == 100;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ PackageInfo g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ ApplicationInfo h(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.ApplicationInfoFlags.of(128L));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void i(Context context, p6 p6Var, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, Handler handler) {
        io.sentry.util.b.r(p6Var.getLogger(), "The ILogger object is required.");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, null, handler, 4);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, null, handler);
        }
    }
}
