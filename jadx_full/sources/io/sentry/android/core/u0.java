package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import defpackage.h6;
import defpackage.sn;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.p6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {
    public static volatile u0 i;
    public static final io.sentry.util.a j = new io.sentry.util.a();
    public final Context a;
    public final SentryAndroidOptions b;
    public final q0 c;
    public final Boolean d;
    public final h6 e;
    public final sn f;
    public final io.sentry.protocol.q g;
    public final Long h;

    public u0(Context context, SentryAndroidOptions sentryAndroidOptions) {
        String str;
        h6 h6Var;
        sn snVar;
        Bundle bundle;
        PackageInfo packageInfoD;
        PackageManager packageManager;
        this.a = context;
        this.b = sentryAndroidOptions;
        this.c = new q0(sentryAndroidOptions.getLogger());
        io.sentry.android.core.internal.util.e.c.a();
        io.sentry.protocol.q qVar = new io.sentry.protocol.q();
        qVar.b = "Android";
        qVar.f = Build.VERSION.RELEASE;
        qVar.A = Build.DISPLAY;
        ILogger logger = sentryAndroidOptions.getLogger();
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (file.canRead()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    property = line;
                } finally {
                }
            } catch (IOException e) {
                logger.d(p5.ERROR, "Exception while attempting to read kernel information", e);
            }
        }
        if (property != null) {
            qVar.X = property;
        }
        if (sentryAndroidOptions.isEnableRootCheck()) {
            qVar.Y = Boolean.valueOf(new io.sentry.android.core.internal.util.j(this.a, sentryAndroidOptions.getLogger(), this.c).a());
        }
        this.g = qVar;
        this.d = this.c.a();
        ILogger logger2 = sentryAndroidOptions.getLogger();
        boolean z = false;
        try {
            packageInfoD = p0.d(context, this.c);
            packageManager = context.getPackageManager();
        } catch (IllegalArgumentException unused) {
            str = null;
        }
        if (packageInfoD == null || packageManager == null) {
            h6Var = null;
        } else {
            str = packageInfoD.packageName;
            try {
                String installerPackageName = packageManager.getInstallerPackageName(str);
                h6Var = new h6(installerPackageName == null, installerPackageName, 2);
            } catch (IllegalArgumentException unused2) {
                logger2.h(p5.DEBUG, "%s package isn't installed.", str);
                h6Var = null;
            }
        }
        this.e = h6Var;
        q0 q0Var = this.c;
        q0Var.getClass();
        ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? (ApplicationInfo) p0.d.a(context) : (ApplicationInfo) p0.e.a(context);
        PackageInfo packageInfoD2 = p0.d(context, q0Var);
        if (packageInfoD2 != null) {
            String[] strArr = packageInfoD2.splitNames;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                z = bundle.getBoolean("com.android.vending.splits.required");
            }
            snVar = new sn();
            snVar.b = z;
            snVar.f = strArr;
        } else {
            snVar = null;
        }
        this.f = snVar;
        ActivityManager.MemoryInfo memoryInfoB = p0.b(context, sentryAndroidOptions.getLogger());
        if (memoryInfoB != null) {
            this.h = Long.valueOf(memoryInfoB.totalMem);
        } else {
            this.h = null;
        }
    }

    public static Float b(Intent intent, p6 p6Var) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "Error getting device battery level.", th);
            return null;
        }
    }

    public static u0 c(Context context, SentryAndroidOptions sentryAndroidOptions) {
        if (i == null) {
            io.sentry.util.a aVar = j;
            aVar.g();
            try {
                if (i == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    i = new u0(context, sentryAndroidOptions);
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        return i;
    }

    public static Boolean d(Intent intent, p6 p6Var) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "Error getting device charging state.", th);
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:0|2|(1:4)|5|(2:160|6)|(1:(21:9|(3:158|15|16)|23|(1:25)|26|142|27|(1:32)|154|33|37|(2:39|(2:41|(1:43)(1:44))(0))(0)|45|(3:152|47|51)|52|(1:54)|55|(1:57)|58|(12:62|(1:64)(1:65)|(5:67|146|68|(1:70)(1:74)|75)|76|(1:(1:79)(1:80))(1:81)|82|(1:85)|86|(7:88|156|89|93|150|94|98)|(7:100|148|101|(4:(1:104)(1:105)|106|(3:108|(1:(1:166)(2:162|164))(2:110|165)|117)|163)(1:118)|119|(1:121)(1:124)|(6:144|126|130|140|131|135))|136|(1:138))|139)(1:10))(1:12)|11|(0)|23|(0)|26|142|27|(0)|154|33|37|(0)(0)|45|(0)|52|(0)|55|(0)|58|(13:60|62|(0)(0)|(0)|76|(0)(0)|82|(1:85)|86|(0)|(0)|136|(0))|139) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        r2.d(io.sentry.p5.ERROR, "Error getting DisplayMetrics.", r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00da, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00db, code lost:
    
        r8.getLogger().b(io.sentry.p5.ERROR, r0, "Error getting the device's boot time.", new java.lang.Object[0]);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final io.sentry.protocol.h a(boolean z, boolean z2) {
        io.sentry.protocol.g gVar;
        Boolean bool;
        DisplayMetrics displayMetrics;
        TimeZone timeZone;
        String strA;
        ArrayList arrayListA;
        boolean zIsCollectExternalStorageContext;
        Intent intentRegisterReceiver;
        ActivityManager.MemoryInfo memoryInfoB;
        File dataDirectory;
        Long lValueOf;
        File file;
        Long lValueOf2;
        Long lValueOf3;
        int intExtra;
        int i2;
        io.sentry.protocol.g gVar2;
        Context context = this.a;
        io.sentry.protocol.h hVar = new io.sentry.protocol.h();
        hVar.f = Build.MANUFACTURER;
        hVar.z = Build.BRAND;
        SentryAndroidOptions sentryAndroidOptions = this.b;
        hVar.A = p0.a(sentryAndroidOptions.getLogger());
        hVar.X = Build.MODEL;
        hVar.Y = Build.ID;
        hVar.Z = Build.SUPPORTED_ABIS;
        this.c.getClass();
        if (Build.VERSION.SDK_INT >= 31) {
            hVar.Y0 = Build.SOC_MANUFACTURER + " " + Build.SOC_MODEL;
        }
        Long lValueOf4 = null;
        try {
            i2 = context.getResources().getConfiguration().orientation;
        } catch (Throwable th) {
            th = th;
            gVar = null;
        }
        if (i2 == 1) {
            gVar2 = io.sentry.protocol.g.PORTRAIT;
        } else {
            if (i2 != 2) {
                gVar = null;
                if (gVar == null) {
                    try {
                        sentryAndroidOptions.getLogger().h(p5.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                        gVar = null;
                    } catch (Throwable th2) {
                        th = th2;
                        sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting device orientation.", th);
                    }
                }
                hVar.B0 = gVar;
                bool = this.d;
                if (bool != null) {
                    hVar.C0 = bool;
                }
                ILogger logger = sentryAndroidOptions.getLogger();
                displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics != null) {
                    hVar.L0 = Integer.valueOf(displayMetrics.widthPixels);
                    hVar.M0 = Integer.valueOf(displayMetrics.heightPixels);
                    hVar.N0 = Float.valueOf(displayMetrics.density);
                    hVar.O0 = Integer.valueOf(displayMetrics.densityDpi);
                }
                Date date = new Date(System.currentTimeMillis() - SystemClock.elapsedRealtime());
                hVar.P0 = date;
                if (Build.VERSION.SDK_INT < 33) {
                    LocaleList locales = context.getResources().getConfiguration().getLocales();
                    if (!locales.isEmpty()) {
                        Locale locale = locales.get(0);
                        timeZone = locale.getUnicodeLocaleType("tz") != null ? Calendar.getInstance(locale).getTimeZone() : TimeZone.getDefault();
                    }
                }
                hVar.Q0 = timeZone;
                if (hVar.R0 == null) {
                    try {
                        strA = y0.a(context);
                    } catch (Throwable th3) {
                        sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting installationId.", th3);
                        strA = null;
                    }
                    hVar.R0 = strA;
                }
                Locale locale2 = Locale.getDefault();
                if (hVar.S0 == null) {
                    hVar.S0 = locale2.toString();
                }
                arrayListA = io.sentry.android.core.internal.util.e.c.a();
                if (!arrayListA.isEmpty()) {
                    hVar.W0 = Double.valueOf(((Integer) Collections.max(arrayListA)).doubleValue());
                    hVar.V0 = Integer.valueOf(arrayListA.size());
                }
                hVar.D0 = this.h;
                if (z && sentryAndroidOptions.isCollectAdditionalContext()) {
                    zIsCollectExternalStorageContext = sentryAndroidOptions.isCollectExternalStorageContext();
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
                    intentRegisterReceiver = Build.VERSION.SDK_INT < 33 ? context.registerReceiver(null, intentFilter, null, null, 4) : context.registerReceiver(null, intentFilter, null, null);
                    if (intentRegisterReceiver != null) {
                        hVar.y0 = b(intentRegisterReceiver, sentryAndroidOptions);
                        hVar.z0 = d(intentRegisterReceiver, sentryAndroidOptions);
                        try {
                            intExtra = intentRegisterReceiver.getIntExtra("temperature", -1);
                        } catch (Throwable th4) {
                            sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting battery temperature.", th4);
                        }
                        Float fValueOf = intExtra != -1 ? Float.valueOf(intExtra / 10.0f) : null;
                        hVar.U0 = fValueOf;
                    }
                    int i3 = t0.a[sentryAndroidOptions.getConnectionStatusProvider().d0().ordinal()];
                    hVar.A0 = i3 == 1 ? i3 != 2 ? null : Boolean.TRUE : Boolean.FALSE;
                    memoryInfoB = p0.b(context, sentryAndroidOptions.getLogger());
                    if (memoryInfoB != null && z2) {
                        hVar.E0 = Long.valueOf(memoryInfoB.availMem);
                        hVar.G0 = Boolean.valueOf(memoryInfoB.lowMemory);
                    }
                    dataDirectory = Environment.getDataDirectory();
                    if (dataDirectory != null) {
                        StatFs statFs = new StatFs(dataDirectory.getPath());
                        try {
                            lValueOf2 = Long.valueOf(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
                        } catch (Throwable th5) {
                            sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting total internal storage amount.", th5);
                            lValueOf2 = null;
                        }
                        hVar.H0 = lValueOf2;
                        try {
                            lValueOf3 = Long.valueOf(statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong());
                        } catch (Throwable th6) {
                            sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting unused internal storage amount.", th6);
                            lValueOf3 = null;
                        }
                        hVar.I0 = lValueOf3;
                    }
                    if (zIsCollectExternalStorageContext) {
                        File externalFilesDir = context.getExternalFilesDir(null);
                        try {
                            File[] externalFilesDirs = context.getExternalFilesDirs(null);
                            if (externalFilesDirs != null) {
                                String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
                                int length = externalFilesDirs.length;
                                for (int i4 = 0; i4 < length; i4++) {
                                    file = externalFilesDirs[i4];
                                    if (file != null) {
                                        if (absolutePath == null || absolutePath.isEmpty() || !file.getAbsolutePath().contains(absolutePath)) {
                                            break;
                                        }
                                    }
                                }
                            } else {
                                sentryAndroidOptions.getLogger().h(p5.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
                            }
                            file = null;
                        } catch (Throwable unused) {
                            sentryAndroidOptions.getLogger().h(p5.INFO, "Not possible to read external files directory", new Object[0]);
                        }
                        StatFs statFs2 = file != null ? new StatFs(file.getPath()) : null;
                        if (statFs2 != null) {
                            try {
                                lValueOf = Long.valueOf(statFs2.getBlockCountLong() * statFs2.getBlockSizeLong());
                            } catch (Throwable th7) {
                                sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting total external storage amount.", th7);
                                lValueOf = null;
                            }
                            hVar.J0 = lValueOf;
                            try {
                                lValueOf4 = Long.valueOf(statFs2.getAvailableBlocksLong() * statFs2.getBlockSizeLong());
                            } catch (Throwable th8) {
                                sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting unused external storage amount.", th8);
                            }
                            hVar.K0 = lValueOf4;
                        }
                    }
                    if (hVar.T0 == null) {
                        hVar.T0 = sentryAndroidOptions.getConnectionStatusProvider().v();
                    }
                }
                return hVar;
            }
            gVar2 = io.sentry.protocol.g.LANDSCAPE;
        }
        gVar = gVar2;
        if (gVar == null) {
        }
        hVar.B0 = gVar;
        bool = this.d;
        if (bool != null) {
        }
        ILogger logger2 = sentryAndroidOptions.getLogger();
        displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
        }
        Date date2 = new Date(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        hVar.P0 = date2;
        if (Build.VERSION.SDK_INT < 33) {
        }
        hVar.Q0 = timeZone;
        if (hVar.R0 == null) {
        }
        Locale locale22 = Locale.getDefault();
        if (hVar.S0 == null) {
        }
        arrayListA = io.sentry.android.core.internal.util.e.c.a();
        if (!arrayListA.isEmpty()) {
        }
        hVar.D0 = this.h;
        if (z) {
            zIsCollectExternalStorageContext = sentryAndroidOptions.isCollectExternalStorageContext();
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            if (Build.VERSION.SDK_INT < 33) {
            }
            if (intentRegisterReceiver != null) {
            }
            int i32 = t0.a[sentryAndroidOptions.getConnectionStatusProvider().d0().ordinal()];
            hVar.A0 = i32 == 1 ? i32 != 2 ? null : Boolean.TRUE : Boolean.FALSE;
            memoryInfoB = p0.b(context, sentryAndroidOptions.getLogger());
            if (memoryInfoB != null) {
                hVar.E0 = Long.valueOf(memoryInfoB.availMem);
                hVar.G0 = Boolean.valueOf(memoryInfoB.lowMemory);
            }
            dataDirectory = Environment.getDataDirectory();
            if (dataDirectory != null) {
            }
            if (zIsCollectExternalStorageContext) {
            }
            if (hVar.T0 == null) {
            }
        }
        return hVar;
    }
}
