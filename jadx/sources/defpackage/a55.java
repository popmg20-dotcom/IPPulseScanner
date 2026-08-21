package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a55 implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ a55(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004b A[Catch: all -> 0x0028, RuntimeException -> 0x002c, TryCatch #1 {RuntimeException -> 0x002c, blocks: (B:3:0x0009, B:5:0x0019, B:7:0x001f, B:22:0x004b, B:25:0x0052, B:27:0x0065, B:29:0x006d, B:35:0x007d, B:40:0x008a, B:15:0x0030, B:17:0x0037, B:19:0x0043), top: B:47:0x0009, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(defpackage.k45 r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f
            ib5 r0 = (defpackage.ib5) r0
            java.lang.Object r0 = r0.f
            r1 = r0
            k85 r1 = (defpackage.k85) r1
            t65 r0 = r1.Y     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            defpackage.k85.h(r0)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            q65 r0 = r0.H0     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            java.lang.String r2 = "onActivityCreated"
            r0.a(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            android.content.Intent r0 = r9.z     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r0 == 0) goto L98
            android.net.Uri r2 = r0.getData()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r2 == 0) goto L30
            boolean r3 = r2.isHierarchical()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r3 != 0) goto L26
            goto L30
        L26:
            r5 = r2
            goto L49
        L28:
            r0 = move-exception
            r8 = r0
            goto Lae
        L2c:
            r0 = move-exception
            r8 = r0
            goto La1
        L30:
            android.os.Bundle r2 = r0.getExtras()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            r3 = 0
            if (r2 == 0) goto L48
            java.lang.String r4 = "com.android.vending.referral_url"
            java.lang.String r2 = r2.getString(r4)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r4 != 0) goto L48
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            goto L26
        L48:
            r5 = r3
        L49:
            if (r5 == 0) goto L98
            boolean r2 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r2 != 0) goto L52
            goto L98
        L52:
            qf5 r2 = r1.z0     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            defpackage.k85.f(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            java.lang.String r2 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r0 = r0.getStringExtra(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            java.lang.String r2 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r2 != 0) goto L7a
            java.lang.String r2 = "https://www.google.com"
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r2 != 0) goto L7a
            java.lang.String r2 = "android-app://com.google.appcrawler"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r0 == 0) goto L76
            goto L7a
        L76:
            java.lang.String r0 = "auto"
        L78:
            r6 = r0
            goto L7d
        L7a:
            java.lang.String r0 = "gs"
            goto L78
        L7d:
            java.lang.String r0 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            if (r10 != 0) goto L88
            r0 = 1
        L86:
            r4 = r0
            goto L8a
        L88:
            r0 = 0
            goto L86
        L8a:
            f85 r0 = r1.Z     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            defpackage.k85.h(r0)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            ia5 r2 = new ia5     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
            r0.e1(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2c
        L98:
            yb5 r8 = r1.C0
            defpackage.k85.g(r8)
            r8.d1(r9, r10)
            return
        La1:
            t65 r0 = r1.Y     // Catch: java.lang.Throwable -> L28
            defpackage.k85.h(r0)     // Catch: java.lang.Throwable -> L28
            q65 r0 = r0.z0     // Catch: java.lang.Throwable -> L28
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r0.b(r8, r2)     // Catch: java.lang.Throwable -> L28
            goto L98
        Lae:
            yb5 r0 = r1.C0
            defpackage.k85.g(r0)
            r0.d1(r9, r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a55.c(k45, android.os.Bundle):void");
    }

    public void d(k45 k45Var) {
        yb5 yb5Var = ((k85) ((ib5) this.f).f).C0;
        k85.g(yb5Var);
        synchronized (yb5Var.F0) {
            try {
                if (Objects.equals(yb5Var.A0, k45Var)) {
                    yb5Var.A0 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((k85) yb5Var.f).A.j1()) {
            yb5Var.z0.remove(Integer.valueOf(k45Var.b));
        }
    }

    public void e(k45 k45Var) {
        k85 k85Var = (k85) ((ib5) this.f).f;
        yb5 yb5Var = k85Var.C0;
        k85.g(yb5Var);
        synchronized (yb5Var.F0) {
            yb5Var.E0 = false;
            yb5Var.B0 = true;
        }
        k85 k85Var2 = (k85) yb5Var.f;
        k85Var2.B0.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (k85Var2.A.j1()) {
            rb5 rb5VarA1 = yb5Var.a1(k45Var);
            yb5Var.Z = yb5Var.Y;
            yb5Var.Y = null;
            f85 f85Var = k85Var2.Z;
            k85.h(f85Var);
            f85Var.e1(new yi3(yb5Var, rb5VarA1, jElapsedRealtime));
        } else {
            yb5Var.Y = null;
            f85 f85Var2 = k85Var2.Z;
            k85.h(f85Var2);
            f85Var2.e1(new n35(yb5Var, jElapsedRealtime));
        }
        zd5 zd5Var = k85Var.y0;
        k85.g(zd5Var);
        k85 k85Var3 = (k85) zd5Var.f;
        k85Var3.B0.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        f85 f85Var3 = k85Var3.Z;
        k85.h(f85Var3);
        f85Var3.e1(new nd5(zd5Var, jElapsedRealtime2, 1));
    }

    public void f(k45 k45Var) {
        k85 k85Var = (k85) ((ib5) this.f).f;
        zd5 zd5Var = k85Var.y0;
        k85.g(zd5Var);
        k85 k85Var2 = (k85) zd5Var.f;
        k85Var2.B0.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        f85 f85Var = k85Var2.Z;
        k85.h(f85Var);
        f85Var.e1(new nd5(zd5Var, jElapsedRealtime, 0));
        yb5 yb5Var = k85Var.C0;
        k85.g(yb5Var);
        Object obj = yb5Var.F0;
        synchronized (obj) {
            yb5Var.E0 = true;
            if (!Objects.equals(k45Var, yb5Var.A0)) {
                synchronized (obj) {
                    yb5Var.A0 = k45Var;
                    yb5Var.B0 = false;
                    k85 k85Var3 = (k85) yb5Var.f;
                    if (k85Var3.A.j1()) {
                        yb5Var.C0 = null;
                        f85 f85Var2 = k85Var3.Z;
                        k85.h(f85Var2);
                        f85Var2.e1(new vb5(yb5Var, 1));
                    }
                }
            }
        }
        k85 k85Var4 = (k85) yb5Var.f;
        if (!k85Var4.A.j1()) {
            yb5Var.Y = yb5Var.C0;
            f85 f85Var3 = k85Var4.Z;
            k85.h(f85Var3);
            f85Var3.e1(new vb5(yb5Var, 0));
            return;
        }
        yb5Var.e1(k45Var.f, yb5Var.a1(k45Var), false);
        d45 d45Var = ((k85) yb5Var.f).E0;
        k85.e(d45Var);
        k85 k85Var5 = (k85) d45Var.f;
        k85Var5.B0.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        f85 f85Var4 = k85Var5.Z;
        k85.h(f85Var4);
        f85Var4.e1(new n35(d45Var, jElapsedRealtime2));
    }

    public void g(k45 k45Var, Bundle bundle) {
        rb5 rb5Var;
        yb5 yb5Var = ((k85) ((ib5) this.f).f).C0;
        k85.g(yb5Var);
        if (!((k85) yb5Var.f).A.j1() || bundle == null || (rb5Var = (rb5) yb5Var.z0.get(Integer.valueOf(k45Var.b))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", rb5Var.c);
        bundle2.putString("name", rb5Var.a);
        bundle2.putString("referrer_name", rb5Var.b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.b) {
            case 0:
                ((b55) this.f).a(new n45(this, bundle, activity));
                break;
            default:
                c(k45.a(activity), bundle);
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.b) {
            case 0:
                ((b55) this.f).a(new w45(this, activity, 4));
                break;
            default:
                d(k45.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.b) {
            case 0:
                ((b55) this.f).a(new w45(this, activity, 2));
                break;
            default:
                e(k45.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.b) {
            case 0:
                ((b55) this.f).a(new w45(this, activity, 1));
                break;
            default:
                f(k45.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        switch (this.b) {
            case 0:
                q35 q35Var = new q35();
                ((b55) this.f).a(new n45(this, activity, q35Var));
                Bundle bundleB = q35Var.b(50L);
                if (bundleB != null) {
                    bundle.putAll(bundleB);
                }
                break;
            default:
                g(k45.a(activity), bundle);
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        switch (this.b) {
            case 0:
                ((b55) this.f).a(new w45(this, activity, 0));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        switch (this.b) {
            case 0:
                ((b55) this.f).a(new w45(this, activity, 3));
                break;
        }
    }

    private final void a(Activity activity) {
    }

    private final void b(Activity activity) {
    }
}
