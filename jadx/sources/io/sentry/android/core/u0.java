package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import defpackage.h6;
import defpackage.sn;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.p6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.protocol.h a(boolean r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 750
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.u0.a(boolean, boolean):io.sentry.protocol.h");
    }
}
