package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tp1 implements Handler.Callback {
    public static final Status o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status p = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object q = new Object();
    public static tp1 r;
    public long a;
    public boolean b;
    public eb4 c;
    public n05 d;
    public final Context e;
    public final lp1 f;
    public final rz4 g;
    public final AtomicInteger h;
    public final AtomicInteger i;
    public final ConcurrentHashMap j;
    public final me k;
    public final me l;
    public final s05 m;
    public volatile boolean n;

    public tp1(Context context, Looper looper) {
        lp1 lp1Var = lp1.d;
        this.a = 10000L;
        this.b = false;
        this.h = new AtomicInteger(1);
        this.i = new AtomicInteger(0);
        this.j = new ConcurrentHashMap(5, 0.75f, 1);
        this.k = new me(0);
        this.l = new me(0);
        this.n = true;
        this.e = context;
        s05 s05Var = new s05(looper, this);
        Looper.getMainLooper();
        this.m = s05Var;
        this.f = lp1Var;
        this.g = new rz4(1);
        PackageManager packageManager = context.getPackageManager();
        Boolean boolValueOf = tj4.k;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(vf2.v() && packageManager.hasSystemFeature("android.hardware.type.automotive"));
            tj4.k = boolValueOf;
        }
        if (boolValueOf.booleanValue()) {
            this.n = false;
        }
        s05Var.sendMessage(s05Var.obtainMessage(6));
    }

    public static Status b(x9 x9Var, ab0 ab0Var) {
        w7 w7Var = x9Var.b;
        return new Status(17, "API: ClientTelemetry.API is not available on this device. Connection failed with: ".concat(String.valueOf(ab0Var)), ab0Var.z, ab0Var);
    }

    public static tp1 e(Context context) {
        tp1 tp1Var;
        synchronized (q) {
            try {
                tp1Var = r;
                if (tp1Var == null) {
                    Looper looper = bg5.b().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = lp1.c;
                    tp1 tp1Var2 = new tp1(applicationContext, looper);
                    r = tp1Var2;
                    tp1Var = tp1Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tp1Var;
    }

    public final boolean a(ab0 ab0Var, int i) {
        lp1 lp1Var = this.f;
        lp1Var.getClass();
        Context context = this.e;
        if (!v02.r(context)) {
            int i2 = ab0Var.f;
            PendingIntent pendingIntentO = ab0Var.z;
            if (!((i2 == 0 || pendingIntentO == null) ? false : true)) {
                pendingIntentO = null;
                Intent intentA = lp1Var.a(i2, context, null);
                if (intentA != null) {
                    pendingIntentO = l72.o(context, 0, intentA, false);
                }
            }
            if (pendingIntentO != null) {
                int i3 = GoogleApiActivity.f;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntentO);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                lp1Var.f(context, i2, PendingIntent.getActivity(context, 0, intent, p05.a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final sz4 c(kp1 kp1Var) {
        x9 x9Var = kp1Var.e;
        ConcurrentHashMap concurrentHashMap = this.j;
        sz4 sz4Var = (sz4) concurrentHashMap.get(x9Var);
        if (sz4Var == null) {
            sz4Var = new sz4(this, kp1Var);
            concurrentHashMap.put(x9Var, sz4Var);
        }
        if (sz4Var.d.j()) {
            this.l.add(x9Var);
        }
        sz4Var.m();
        return sz4Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r6 = this;
            eb4 r0 = r6.c
            if (r0 == 0) goto L4f
            int r1 = r0.b
            if (r1 > 0) goto L35
            boolean r1 = r6.b
            if (r1 == 0) goto Ld
            goto L4c
        Ld:
            java.lang.Class<wl3> r1 = defpackage.wl3.class
            monitor-enter(r1)
            wl3 r2 = defpackage.wl3.f     // Catch: java.lang.Throwable -> L1d
            if (r2 != 0) goto L1f
            wl3 r2 = new wl3     // Catch: java.lang.Throwable -> L1d
            r3 = 0
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d
            defpackage.wl3.f = r2     // Catch: java.lang.Throwable -> L1d
            goto L1f
        L1d:
            r6 = move-exception
            goto L33
        L1f:
            monitor-exit(r1)
            rz4 r1 = r6.g
            java.lang.Object r1 = r1.f
            android.util.SparseIntArray r1 = (android.util.SparseIntArray) r1
            r2 = 203400000(0xc1fa340, float:1.2298041E-31)
            r3 = -1
            int r1 = r1.get(r2, r3)
            if (r1 == r3) goto L35
            if (r1 != 0) goto L4c
            goto L35
        L33:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1d
            throw r6
        L35:
            n05 r1 = r6.d
            if (r1 != 0) goto L49
            android.content.Context r1 = r6.e
            fb4 r2 = defpackage.fb4.b
            n05 r3 = new n05
            w7 r4 = defpackage.n05.i
            jp1 r5 = defpackage.jp1.b
            r3.<init>(r1, r4, r2, r5)
            r6.d = r3
            r1 = r3
        L49:
            r1.b(r0)
        L4c:
            r0 = 0
            r6.c = r0
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tp1.d():void");
    }

    public final void f(ab0 ab0Var, int i) {
        if (a(ab0Var, i)) {
            return;
        }
        s05 s05Var = this.m;
        s05Var.sendMessage(s05Var.obtainMessage(5, i, 0, ab0Var));
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r13) {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tp1.handleMessage(android.os.Message):boolean");
    }
}
