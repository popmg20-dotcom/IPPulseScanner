package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.ft4;
import defpackage.fw;
import defpackage.h6;
import defpackage.sn;
import defpackage.st4;
import io.sentry.ILogger;
import io.sentry.f5;
import io.sentry.p5;
import io.sentry.r4;
import io.sentry.r5;
import io.sentry.r6;
import io.sentry.t4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
    */
    public final f5 n(f5 f5Var, io.sentry.l0 l0Var) {
        io.sentry.protocol.c0 c0Var;
        List list;
        boolean z;
        boolean zC = c(f5Var, l0Var);
        if (zC) {
            a(f5Var, l0Var);
            if (f5Var.e() != null) {
                boolean zK = io.sentry.util.b.k(l0Var);
                for (io.sentry.protocol.e0 e0Var : f5Var.e()) {
                    io.sentry.android.core.internal.util.d.a.getClass();
                    Long l = e0Var.b;
                    if (l != null) {
                        z = io.sentry.android.core.internal.util.d.d(Looper.getMainLooper().getThread()) == l.longValue();
                    }
                    if (e0Var.Y == null) {
                        e0Var.Y = Boolean.valueOf(z);
                    }
                    if (!zK && e0Var.y0 == null) {
                        e0Var.y0 = Boolean.valueOf(z);
                    }
                }
            }
        }
        b(f5Var, true, zC);
        ArrayList arrayListD = f5Var.d();
        if (arrayListD != null && arrayListD.size() > 1) {
            io.sentry.protocol.v vVar = (io.sentry.protocol.v) fw.r(arrayListD, 1);
            if ("java.lang".equals(vVar.z) && (c0Var = vVar.X) != null && (list = c0Var.b) != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if ("com.android.internal.os.RuntimeInit$MethodAndArgsCaller".equals(((io.sentry.protocol.a0) it.next()).Y)) {
                        Collections.reverse(arrayListD);
                        break;
                    }
                }
            }
        }
        return f5Var;
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
