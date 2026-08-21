package io.sentry.android.core.internal.util;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.android.core.q0;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final Charset g = Charset.forName("UTF-8");
    public final Context a;
    public final q0 b;
    public final ILogger c;
    public final String[] d;
    public final String[] e;
    public final Runtime f;

    public j(Context context, ILogger iLogger, q0 q0Var) {
        Runtime runtime = Runtime.getRuntime();
        this.a = context;
        io.sentry.util.b.r(q0Var, "The BuildInfoProvider is required.");
        this.b = q0Var;
        io.sentry.util.b.r(iLogger, "The Logger is required.");
        this.c = iLogger;
        this.d = new String[]{"/sbin/su", "/data/local/xbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/bin/su", "/system/app/Superuser.apk", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"};
        this.e = new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"};
        io.sentry.util.b.r(runtime, "The Runtime is required.");
        this.f = runtime;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a() {
        /*
            r10 = this;
            io.sentry.android.core.q0 r0 = r10.b
            r0.getClass()
            java.lang.String r0 = android.os.Build.TAGS
            r1 = 1
            if (r0 == 0) goto L14
            java.lang.String r2 = "test-keys"
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L14
            goto Lc1
        L14:
            java.lang.String[] r0 = r10.d
            int r2 = r0.length
            r3 = 0
            r4 = r3
        L19:
            io.sentry.ILogger r5 = r10.c
            if (r4 >= r2) goto L3b
            r6 = r0[r4]
            java.io.File r7 = new java.io.File     // Catch: java.lang.RuntimeException -> L2c
            r7.<init>(r6)     // Catch: java.lang.RuntimeException -> L2c
            boolean r5 = r7.exists()     // Catch: java.lang.RuntimeException -> L2c
            if (r5 == 0) goto L38
            goto Lc1
        L2c:
            r7 = move-exception
            io.sentry.p5 r8 = io.sentry.p5.ERROR
            java.lang.Object[] r9 = new java.lang.Object[r1]
            r9[r3] = r6
            java.lang.String r6 = "Error when trying to check if root file %s exists."
            r5.b(r8, r7, r6, r9)
        L38:
            int r4 = r4 + 1
            goto L19
        L3b:
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r2 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r2}
            r2 = 0
            java.lang.Runtime r4 = r10.f     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            java.lang.Process r2 = r4.exec(r0)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            java.io.InputStream r6 = r2.getInputStream()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            java.nio.charset.Charset r7 = io.sentry.android.core.internal.util.j.g     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            r4.<init>(r6, r7)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            java.lang.String r4 = r0.readLine()     // Catch: java.lang.Throwable -> L6c
            if (r4 == 0) goto L62
            r4 = r1
            goto L63
        L62:
            r4 = r3
        L63:
            r0.close()     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
            r2.destroy()
            goto L92
        L6a:
            r0 = move-exception
            goto L76
        L6c:
            r4 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L71
            goto L75
        L71:
            r0 = move-exception
            r4.addSuppressed(r0)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
        L75:
            throw r4     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L85
        L76:
            io.sentry.p5 r4 = io.sentry.p5.DEBUG     // Catch: java.lang.Throwable -> L83
            java.lang.String r6 = "Error when trying to check if SU exists."
            r5.d(r4, r6, r0)     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L91
        L7f:
            r2.destroy()
            goto L91
        L83:
            r10 = move-exception
            goto Lc2
        L85:
            io.sentry.p5 r0 = io.sentry.p5.DEBUG     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "SU isn't found on this Device."
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L83
            r5.h(r0, r4, r6)     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L91
            goto L7f
        L91:
            r4 = r3
        L92:
            if (r4 != 0) goto Lc1
            java.lang.String r0 = "The ILogger object is required."
            io.sentry.util.b.r(r5, r0)
            android.content.Context r0 = r10.a
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            if (r0 == 0) goto Lc0
            java.lang.String[] r10 = r10.e
            int r2 = r10.length
            r4 = r3
        La5:
            if (r4 >= r2) goto Lc0
            r5 = r10[r4]
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lbd
            r7 = 33
            if (r6 < r7) goto Lb9
            r6 = 0
            android.content.pm.PackageManager$PackageInfoFlags r6 = android.content.pm.PackageManager.PackageInfoFlags.of(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lbd
            r0.getPackageInfo(r5, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lbd
            goto Lc1
        Lb9:
            r0.getPackageInfo(r5, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lbd
            goto Lc1
        Lbd:
            int r4 = r4 + 1
            goto La5
        Lc0:
            r1 = r3
        Lc1:
            return r1
        Lc2:
            if (r2 == 0) goto Lc7
            r2.destroy()
        Lc7:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.util.j.a():boolean");
    }
}
