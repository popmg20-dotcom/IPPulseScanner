package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.ft4;
import defpackage.h6;
import defpackage.sn;
import defpackage.st4;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.r4;
import io.sentry.r5;
import io.sentry.r6;
import io.sentry.t4;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements io.sentry.f0 {
    public final Future A;
    public final io.sentry.util.f X = new io.sentry.util.f(new st4(27));
    public final Context b;
    public final q0 f;
    public final SentryAndroidOptions z;

    public s0(SurfboardApp surfboardApp, q0 q0Var, SentryAndroidOptions sentryAndroidOptions) {
        Future futureSubmit;
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
        this.f = q0Var;
        this.z = sentryAndroidOptions;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new r0());
        try {
            futureSubmit = executorServiceNewSingleThreadExecutor.submit(new ft4(8, this, sentryAndroidOptions));
        } catch (RejectedExecutionException e) {
            sentryAndroidOptions.getLogger().d(p5.WARNING, "Device info caching task rejected.", e);
            futureSubmit = null;
        }
        this.A = futureSubmit;
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    public final void a(t4 t4Var, io.sentry.l0 l0Var) {
        Boolean bool;
        io.sentry.protocol.a aVarD = t4Var.f.d();
        if (aVarD == null) {
            aVarD = new io.sentry.protocol.a();
        }
        aVarD.X = (String) p0.c.a(this.b);
        io.sentry.android.core.performance.h hVarB = io.sentry.android.core.performance.g.c().b(this.z);
        u0 u0Var = null;
        if (hVarB.d()) {
            aVarD.f = hVarB.b() == null ? null : new Date((long) (r1.b / 1000000.0d));
        }
        if (!io.sentry.util.b.k(l0Var) && aVarD.B0 == null && (bool = j0.X.A) != null) {
            aVarD.B0 = Boolean.valueOf(!bool.booleanValue());
        }
        Context context = this.b;
        SentryAndroidOptions sentryAndroidOptions = this.z;
        ILogger logger = sentryAndroidOptions.getLogger();
        q0 q0Var = this.f;
        PackageInfo packageInfoC = p0.c(context, logger, q0Var);
        if (packageInfoC != null) {
            String strE = p0.e(packageInfoC, q0Var);
            if (t4Var.C0 == null) {
                t4Var.C0 = strE;
            }
            Future future = this.A;
            if (future != null) {
                try {
                    u0Var = (u0) future.get();
                } catch (Throwable th) {
                    sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to retrieve device info", th);
                }
            } else {
                sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to retrieve device info", new Object[0]);
            }
            aVarD.b = packageInfoC.packageName;
            aVarD.Y = packageInfoC.versionName;
            aVarD.Z = p0.e(packageInfoC, q0Var);
            HashMap map = new HashMap();
            String[] strArr = packageInfoC.requestedPermissions;
            int[] iArr = packageInfoC.requestedPermissionsFlags;
            if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
                for (int i = 0; i < strArr.length; i++) {
                    String str = strArr[i];
                    map.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i] & 2) == 2 ? "granted" : "not_granted");
                }
            }
            aVarD.y0 = map;
            if (u0Var != null) {
                try {
                    sn snVar = u0Var.f;
                    if (snVar != null) {
                        aVarD.C0 = Boolean.valueOf(snVar.b);
                        String[] strArr2 = (String[]) snVar.f;
                        if (strArr2 != null) {
                            aVarD.D0 = Arrays.asList(strArr2);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        t4Var.f.m(aVarD);
    }

    public final void b(t4 t4Var, boolean z, boolean z2) {
        io.sentry.protocol.j0 j0Var = t4Var.z0;
        if (j0Var == null) {
            j0Var = new io.sentry.protocol.j0();
            t4Var.z0 = j0Var;
        }
        if (j0Var.f == null) {
            j0Var.f = y0.a(this.b);
        }
        String str = j0Var.A;
        SentryAndroidOptions sentryAndroidOptions = this.z;
        if (str == null && sentryAndroidOptions.isSendDefaultPii()) {
            j0Var.A = "{{auto}}";
        }
        io.sentry.protocol.e eVar = t4Var.f;
        io.sentry.protocol.h hVarE = eVar.e();
        Future future = this.A;
        if (hVarE == null) {
            if (future != null) {
                try {
                    eVar.o(((u0) future.get()).a(z, z2));
                } catch (Throwable th) {
                    sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to retrieve device info", th);
                }
            } else {
                sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to retrieve device info", new Object[0]);
            }
            io.sentry.protocol.q qVarG = eVar.g();
            if (future != null) {
                try {
                    eVar.r(((u0) future.get()).g);
                } catch (Throwable th2) {
                    sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to retrieve os system", th2);
                }
            } else {
                sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to retrieve device info", new Object[0]);
            }
            if (qVarG != null) {
                String str2 = qVarG.b;
                eVar.k(qVarG, (str2 == null || str2.isEmpty()) ? "os_1" : "os_" + str2.trim().toLowerCase(Locale.ROOT));
            }
        }
        if (future == null) {
            sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to retrieve device info", new Object[0]);
            return;
        }
        try {
            h6 h6Var = ((u0) future.get()).e;
            if (h6Var != null) {
                HashMap map = new HashMap();
                map.put("isSideLoaded", String.valueOf(h6Var.b));
                String str3 = h6Var.c;
                if (str3 != null) {
                    map.put("installerStore", str3);
                }
                for (Map.Entry entry : map.entrySet()) {
                    t4Var.b((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th3) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Error getting side loaded info.", th3);
        }
    }

    public final boolean c(t4 t4Var, io.sentry.l0 l0Var) {
        if (io.sentry.util.b.s(l0Var)) {
            return true;
        }
        this.z.getLogger().h(p5.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", t4Var.b);
        return false;
    }

    @Override // io.sentry.f0
    public final r6 g(r6 r6Var, io.sentry.l0 l0Var) {
        boolean zC = c(r6Var, l0Var);
        if (zC) {
            a(r6Var, l0Var);
        }
        b(r6Var, false, zC);
        return r6Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    @Override // io.sentry.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.f5 n(io.sentry.f5 r9, io.sentry.l0 r10) {
        /*
            r8 = this;
            boolean r0 = r8.c(r9, r10)
            r1 = 1
            if (r0 == 0) goto L5f
            r8.a(r9, r10)
            java.util.ArrayList r2 = r9.e()
            if (r2 == 0) goto L5f
            boolean r10 = io.sentry.util.b.k(r10)
            java.util.ArrayList r2 = r9.e()
            java.util.Iterator r2 = r2.iterator()
        L1c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L5f
            java.lang.Object r3 = r2.next()
            io.sentry.protocol.e0 r3 = (io.sentry.protocol.e0) r3
            io.sentry.android.core.internal.util.d r4 = io.sentry.android.core.internal.util.d.a
            r4.getClass()
            java.lang.Long r4 = r3.b
            if (r4 == 0) goto L47
            long r4 = r4.longValue()
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            java.lang.Thread r6 = r6.getThread()
            long r6 = io.sentry.android.core.internal.util.d.d(r6)
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 != 0) goto L47
            r4 = r1
            goto L48
        L47:
            r4 = 0
        L48:
            java.lang.Boolean r5 = r3.Y
            if (r5 != 0) goto L52
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r3.Y = r5
        L52:
            if (r10 != 0) goto L1c
            java.lang.Boolean r5 = r3.y0
            if (r5 != 0) goto L1c
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.y0 = r4
            goto L1c
        L5f:
            r8.b(r9, r1, r0)
            java.util.ArrayList r8 = r9.d()
            if (r8 == 0) goto La3
            int r10 = r8.size()
            if (r10 <= r1) goto La3
            java.lang.Object r10 = defpackage.fw.r(r8, r1)
            io.sentry.protocol.v r10 = (io.sentry.protocol.v) r10
            java.lang.String r0 = "java.lang"
            java.lang.String r1 = r10.z
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto La3
            io.sentry.protocol.c0 r10 = r10.X
            if (r10 == 0) goto La3
            java.util.List r10 = r10.b
            if (r10 == 0) goto La3
            java.util.Iterator r10 = r10.iterator()
        L8a:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto La3
            java.lang.Object r0 = r10.next()
            io.sentry.protocol.a0 r0 = (io.sentry.protocol.a0) r0
            java.lang.String r1 = "com.android.internal.os.RuntimeInit$MethodAndArgsCaller"
            java.lang.String r0 = r0.Y
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L8a
            java.util.Collections.reverse(r8)
        La3:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.s0.n(io.sentry.f5, io.sentry.l0):io.sentry.f5");
    }

    @Override // io.sentry.f0
    public final io.sentry.protocol.f0 s(io.sentry.protocol.f0 f0Var, io.sentry.l0 l0Var) {
        boolean zC = c(f0Var, l0Var);
        if (zC) {
            a(f0Var, l0Var);
        }
        b(f0Var, false, zC);
        return f0Var;
    }

    @Override // io.sentry.f0
    public final r5 x(r5 r5Var) {
        SentryAndroidOptions sentryAndroidOptions = this.z;
        try {
            r4 r4Var = r4.STRING;
            r5Var.a("device.brand", new io.sentry.protocol.n(r4Var, Build.BRAND));
            r5Var.a("device.model", new io.sentry.protocol.n(r4Var.apiName(), Build.MODEL));
            r5Var.a("device.family", new io.sentry.protocol.n(r4Var.apiName(), this.X.a()));
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to retrieve device info", th);
        }
        try {
            r4 r4Var2 = r4.STRING;
            r5Var.a("os.name", new io.sentry.protocol.n(r4Var2, "Android"));
            r5Var.a("os.version", new io.sentry.protocol.n(r4Var2.apiName(), Build.VERSION.RELEASE));
        } catch (Throwable th2) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to retrieve os system", th2);
        }
        return r5Var;
    }
}
