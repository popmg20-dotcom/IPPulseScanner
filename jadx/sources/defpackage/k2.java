package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mars.xlog.Xlog;
import io.netty.channel.internal.ChannelUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class k2 {
    public static t53 a;

    public static final ApplicationInfo a(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 33) {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
            applicationInfo.getClass();
            return applicationInfo;
        }
        ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(str, 0);
        applicationInfo2.getClass();
        return applicationInfo2;
    }

    public static final List b(PackageManager packageManager) {
        if (Build.VERSION.SDK_INT >= 33) {
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(PackageManager.PackageInfoFlags.of(4096L));
            installedPackages.getClass();
            return installedPackages;
        }
        List<PackageInfo> installedPackages2 = packageManager.getInstalledPackages(4096);
        installedPackages2.getClass();
        return installedPackages2;
    }

    public static int c() {
        int i = Build.VERSION.SDK_INT;
        return (i < 33 && (i < 30 || SdkExtensions.getExtensionVersion(30) < 2)) ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : MediaStore.getPickImagesMaxLimit();
    }

    public static PackageInfo d(PackageManager packageManager, Context context) {
        return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
    }

    public static final PackageInfo e(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        str.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i));
            packageInfo.getClass();
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, i);
        packageInfo2.getClass();
        return packageInfo2;
    }

    public static Object f(Bundle bundle, String str, Class cls) {
        return bundle.getParcelable(str, cls);
    }

    public static Object g(Intent intent, String str, Class cls) {
        return intent.getParcelableExtra(str, cls);
    }

    public static final t53 h(FileInputStream fileInputStream) {
        t53 t53Var = a;
        if (t53Var != null) {
            a = null;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "ProfileUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "get profile from holder");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("ProfileUtils", "get profile from holder", null);
            }
            return t53Var;
        }
        a = null;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "ProfileUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "get profile from file");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("ProfileUtils", "get profile from file", null);
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.getClass();
        try {
            SystemClock.elapsedRealtime();
            try {
                byte[] bArrS = l72.S(fileInputStream);
                fileInputStream.close();
                parcelObtain.unmarshall(bArrS, 0, bArrS.length);
                parcelObtain.setDataPosition(0);
                Parcelable parcelable = Build.VERSION.SDK_INT >= 33 ? (Parcelable) parcelObtain.readParcelable(t53.class.getClassLoader(), t53.class) : parcelObtain.readParcelable(t53.class.getClassLoader());
                parcelable.getClass();
                t53 t53Var2 = (t53) parcelable;
                parcelObtain.recycle();
                return t53Var2;
            } finally {
            }
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public static oz0 i(sy syVar) {
        Long l = (Long) syVar.a(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
        if (l != null) {
            return (oz0) pz0.a.get(l);
        }
        return null;
    }

    public static String j(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    public static boolean k(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    public static final void l(FileOutputStream fileOutputStream, t53 t53Var) {
        a = t53Var;
        new Thread(new xy0(16, t53Var, fileOutputStream), "saveProfile").start();
    }
}
