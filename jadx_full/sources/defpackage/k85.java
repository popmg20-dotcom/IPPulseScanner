package defpackage;

import android.app.Application;
import android.app.BroadcastOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k85 implements m95 {
    public static volatile k85 V0;
    public final x15 A;
    public final k65 A0;
    public final wl3 B0;
    public final yb5 C0;
    public final ib5 D0;
    public final d45 E0;
    public final mb5 F0;
    public final String G0;
    public i65 H0;
    public dd5 I0;
    public u25 J0;
    public d65 K0;
    public nb5 L0;
    public Boolean N0;
    public long O0;
    public volatile Boolean P0;
    public volatile boolean Q0;
    public int R0;
    public int S0;
    public final long U0;
    public final l75 X;
    public final t65 Y;
    public final f85 Z;
    public final Context b;
    public final boolean f;
    public final zd5 y0;
    public final d84 z;
    public final qf5 z0;
    public boolean M0 = false;
    public final AtomicInteger T0 = new AtomicInteger(0);

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0079, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        throw r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k85(y95 y95Var) {
        boolean z = false;
        Context context = y95Var.a;
        d84 d84Var = new d84(5);
        this.z = d84Var;
        p95.m = d84Var;
        this.b = context;
        this.f = y95Var.e;
        this.P0 = y95Var.b;
        this.G0 = y95Var.g;
        int i = 1;
        this.Q0 = true;
        if (oa5.h == null) {
            Object obj = oa5.g;
            synchronized (obj) {
                try {
                    if (oa5.h == null) {
                        synchronized (obj) {
                            v95 v95Var = oa5.h;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext == null) {
                                applicationContext = context;
                            }
                            if (v95Var == null || v95Var.a != applicationContext) {
                                if (v95Var != null) {
                                    x95.c();
                                    ra5.a();
                                    fa5.A();
                                }
                                jf4 jf4Var = new jf4(7, applicationContext);
                                oa5.h = new v95(applicationContext, jf4Var instanceof Serializable ? new t54(jf4Var) : new u54(jf4Var));
                                oa5.i.incrementAndGet();
                            }
                        }
                    }
                } finally {
                }
            }
        }
        this.B0 = wl3.A;
        Long l = y95Var.f;
        this.U0 = l != null ? l.longValue() : System.currentTimeMillis();
        x15 x15Var = new x15(this);
        x15Var.Z = o84.f;
        this.A = x15Var;
        l75 l75Var = new l75(this);
        l75Var.Y0();
        this.X = l75Var;
        t65 t65Var = new t65(this);
        t65Var.Y0();
        this.Y = t65Var;
        qf5 qf5Var = new qf5(this);
        qf5Var.Y0();
        this.z0 = qf5Var;
        this.A0 = new k65(new i85(y95Var, this));
        this.E0 = new d45(this);
        yb5 yb5Var = new yb5(this);
        yb5Var.X0();
        this.C0 = yb5Var;
        ib5 ib5Var = new ib5(this);
        ib5Var.X0();
        this.D0 = ib5Var;
        zd5 zd5Var = new zd5(this);
        zd5Var.X0();
        this.y0 = zd5Var;
        mb5 mb5Var = new mb5(this);
        ((k85) mb5Var.f).R0++;
        mb5Var.Y0();
        this.F0 = mb5Var;
        f85 f85Var = new f85(this);
        f85Var.Y0();
        this.Z = f85Var;
        j45 j45Var = y95Var.d;
        boolean z2 = j45Var == null || j45Var.f == 0;
        if (context.getApplicationContext() instanceof Application) {
            g(ib5Var);
            if (((k85) ib5Var.f).b.getApplicationContext() instanceof Application) {
                Application application = (Application) ((k85) ib5Var.f).b.getApplicationContext();
                a55 a55Var = ib5Var.Y;
                if (a55Var == null) {
                    a55Var = new a55(i, ib5Var);
                    ib5Var.Y = a55Var;
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(a55Var);
                    application.registerActivityLifecycleCallbacks(ib5Var.Y);
                    t65 t65Var2 = ((k85) ib5Var.f).Y;
                    h(t65Var2);
                    t65Var2.H0.a("Registered activity lifecycle callback");
                }
            }
        } else {
            h(t65Var);
            t65Var.C0.a("Application context is not an Application");
        }
        f85Var.e1(new tm1(17, this, y95Var, z));
    }

    public static final void e(z45 z45Var) {
        if (z45Var != null) {
            return;
        }
        xe.q("Component not created");
    }

    public static final void f(k70 k70Var) {
        if (k70Var != null) {
            return;
        }
        xe.q("Component not created");
    }

    public static final void g(u55 u55Var) {
        if (u55Var == null) {
            xe.q("Component not created");
        } else {
            if (u55Var.X) {
                return;
            }
            xe.q("Component not initialized: ".concat(String.valueOf(u55Var.getClass())));
        }
    }

    public static final void h(k95 k95Var) {
        if (k95Var == null) {
            xe.q("Component not created");
        } else {
            if (k95Var.X) {
                return;
            }
            xe.q("Component not initialized: ".concat(String.valueOf(k95Var.getClass())));
        }
    }

    public static k85 m(Context context, j45 j45Var, Long l) {
        Bundle bundle;
        if (j45Var != null) {
            Bundle bundle2 = j45Var.A;
            j45Var = new j45(j45Var.b, j45Var.f, j45Var.z, bundle2, null);
        }
        tj4.i(context);
        tj4.i(context.getApplicationContext());
        if (V0 == null) {
            synchronized (k85.class) {
                try {
                    if (V0 == null) {
                        V0 = new k85(new y95(context, j45Var, l));
                    }
                } finally {
                }
            }
        } else if (j45Var != null && (bundle = j45Var.A) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            tj4.i(V0);
            V0.P0 = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        tj4.i(V0);
        return V0;
    }

    @Override // defpackage.m95
    public final f85 C() {
        f85 f85Var = this.Z;
        h(f85Var);
        return f85Var;
    }

    @Override // defpackage.m95
    public final d84 U() {
        return this.z;
    }

    public final boolean a() {
        return b() == 0;
    }

    public final int b() {
        f85 f85Var = this.Z;
        h(f85Var);
        f85Var.V0();
        x15 x15Var = this.A;
        if (x15Var.i1()) {
            return 1;
        }
        h(f85Var);
        f85Var.V0();
        if (!this.Q0) {
            return 8;
        }
        l75 l75Var = this.X;
        f(l75Var);
        l75Var.V0();
        Boolean boolValueOf = l75Var.Z0().contains("measurement_enabled") ? Boolean.valueOf(l75Var.Z0().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        d84 d84Var = ((k85) x15Var.f).z;
        Boolean boolH1 = x15Var.h1("firebase_analytics_collection_enabled");
        return boolH1 != null ? boolH1.booleanValue() ? 0 : 4 : (this.P0 == null || this.P0.booleanValue()) ? 0 : 7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c() {
        boolean z = false;
        if (!this.M0) {
            xe.q("AppMeasurement is not initialized");
            return false;
        }
        f85 f85Var = this.Z;
        h(f85Var);
        f85Var.V0();
        Boolean bool = this.N0;
        wl3 wl3Var = this.B0;
        if (bool == null || this.O0 == 0) {
            wl3Var.getClass();
            this.O0 = SystemClock.elapsedRealtime();
            qf5 qf5Var = this.z0;
            f(qf5Var);
            if (qf5Var.u1("android.permission.INTERNET") && qf5Var.u1("android.permission.ACCESS_NETWORK_STATE")) {
                Context context = this.b;
                if (ay4.a(context).b() || this.A.Y0() || (qf5.N1(context) && qf5.o1(context))) {
                    z = true;
                }
            }
            this.N0 = Boolean.valueOf(z);
            if (z) {
                this.N0 = Boolean.valueOf(qf5Var.Z0(l().c1()));
            }
        } else if (!bool.booleanValue()) {
            wl3Var.getClass();
            if (Math.abs(SystemClock.elapsedRealtime() - this.O0) > 1000) {
            }
        }
        return this.N0.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(int i, Throwable th, byte[] bArr) {
        t65 t65Var;
        t65 t65Var2;
        int i2 = i;
        t65 t65Var3 = this.Y;
        if (i2 == 200 || i2 == 204) {
            if (th == null) {
                l75 l75Var = this.X;
                f(l75Var);
                l75Var.N0.b(true);
                if (bArr == null || bArr.length == 0) {
                    h(t65Var3);
                    t65Var3.G0.a("Deferred Deep Link response empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String strOptString = jSONObject.optString("deeplink", "");
                    if (TextUtils.isEmpty(strOptString)) {
                        h(t65Var3);
                        t65Var3.G0.a("Deferred Deep Link is empty.");
                        return;
                    }
                    String strOptString2 = jSONObject.optString("gclid", "");
                    String strOptString3 = jSONObject.optString("gbraid", "");
                    String strOptString4 = jSONObject.optString("gad_source", "");
                    double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
                    Bundle bundle = new Bundle();
                    qf5 qf5Var = this.z0;
                    f(qf5Var);
                    k85 k85Var = (k85) qf5Var.f;
                    if (TextUtils.isEmpty(strOptString)) {
                        t65Var2 = t65Var3;
                    } else {
                        Context context = k85Var.b;
                        t65Var2 = t65Var3;
                        try {
                            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0);
                            if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                                if (!TextUtils.isEmpty(strOptString3)) {
                                    bundle.putString("gbraid", strOptString3);
                                }
                                if (!TextUtils.isEmpty(strOptString4)) {
                                    bundle.putString("gad_source", strOptString4);
                                }
                                bundle.putString("gclid", strOptString2);
                                bundle.putString("_cis", "ddp");
                                this.D0.c1("auto", "_cmp", bundle);
                                if (TextUtils.isEmpty(strOptString)) {
                                    return;
                                }
                                try {
                                    SharedPreferences.Editor editorEdit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                    editorEdit.putString("deeplink", strOptString);
                                    editorEdit.putLong("timestamp", Double.doubleToRawLongBits(dOptDouble));
                                    if (editorEdit.commit()) {
                                        Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                        Context context2 = k85Var.b;
                                        if (Build.VERSION.SDK_INT < 34) {
                                            context2.sendBroadcast(intent);
                                            return;
                                        } else {
                                            context2.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
                                            return;
                                        }
                                    }
                                    return;
                                } catch (RuntimeException e) {
                                    t65 t65Var4 = ((k85) qf5Var.f).Y;
                                    h(t65Var4);
                                    t65Var4.z0.b(e, "Failed to persist Deferred Deep Link. exception");
                                    return;
                                }
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            t65Var = t65Var2;
                            h(t65Var);
                            t65Var.z0.b(e, "Failed to parse the Deferred Deep Link response. exception");
                            return;
                        }
                    }
                    h(t65Var2);
                    t65Var = t65Var2;
                    try {
                        t65Var.C0.d("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                        return;
                    } catch (JSONException e3) {
                        e = e3;
                        h(t65Var);
                        t65Var.z0.b(e, "Failed to parse the Deferred Deep Link response. exception");
                        return;
                    }
                } catch (JSONException e4) {
                    e = e4;
                    t65Var = t65Var3;
                }
            }
        } else if (i2 == 304) {
            i2 = 304;
            if (th == null) {
            }
        }
        h(t65Var3);
        t65Var3.C0.c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i2), th);
    }

    public final i65 i() {
        g(this.H0);
        return this.H0;
    }

    public final dd5 j() {
        g(this.I0);
        return this.I0;
    }

    public final u25 k() {
        h(this.J0);
        return this.J0;
    }

    public final d65 l() {
        g(this.K0);
        return this.K0;
    }

    @Override // defpackage.m95
    public final t65 n() {
        t65 t65Var = this.Y;
        h(t65Var);
        return t65Var;
    }

    @Override // defpackage.m95
    public final Context r0() {
        return this.b;
    }

    @Override // defpackage.m95
    public final wl3 z0() {
        return this.B0;
    }
}
