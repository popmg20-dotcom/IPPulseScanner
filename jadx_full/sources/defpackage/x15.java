package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x15 extends k70 {
    public Boolean X;
    public String Y;
    public w15 Z;
    public Boolean y0;

    public final boolean W0(String str) {
        return "1".equals(this.Z.j0(str, "gaia_collection_enabled"));
    }

    public final boolean X0(String str) {
        return "1".equals(this.Z.j0(str, "measurement.event_sampling_enabled"));
    }

    public final boolean Y0() {
        Boolean boolH1 = this.X;
        if (boolH1 == null) {
            boolH1 = h1("app_measurement_lite");
            this.X = boolH1;
            if (boolH1 == null) {
                boolH1 = Boolean.FALSE;
                this.X = boolH1;
            }
        }
        return boolH1.booleanValue() || !((k85) this.f).f;
    }

    public final String Z0(String str) {
        k85 k85Var = (k85) this.f;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            tj4.i(str2);
            return str2;
        } catch (ClassNotFoundException e) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.b(e, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e2) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.b(e2, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e3) {
            t65 t65Var3 = k85Var.Y;
            k85.h(t65Var3);
            t65Var3.z0.b(e3, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e4) {
            t65 t65Var4 = k85Var.Y;
            k85.h(t65Var4);
            t65Var4.z0.b(e4, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final void a1() {
        ((k85) this.f).getClass();
    }

    public final String b1(String str, q55 q55Var) {
        return TextUtils.isEmpty(str) ? (String) q55Var.a(null) : (String) q55Var.a(this.Z.j0(str, q55Var.a));
    }

    public final long c1(String str, q55 q55Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) q55Var.a(null)).longValue();
        }
        String strJ0 = this.Z.j0(str, q55Var.a);
        if (TextUtils.isEmpty(strJ0)) {
            return ((Long) q55Var.a(null)).longValue();
        }
        try {
            return ((Long) q55Var.a(Long.valueOf(Long.parseLong(strJ0)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) q55Var.a(null)).longValue();
        }
    }

    public final int d1(String str, q55 q55Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) q55Var.a(null)).intValue();
        }
        String strJ0 = this.Z.j0(str, q55Var.a);
        if (TextUtils.isEmpty(strJ0)) {
            return ((Integer) q55Var.a(null)).intValue();
        }
        try {
            return ((Integer) q55Var.a(Integer.valueOf(Integer.parseInt(strJ0)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) q55Var.a(null)).intValue();
        }
    }

    public final double e1(String str, q55 q55Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) q55Var.a(null)).doubleValue();
        }
        String strJ0 = this.Z.j0(str, q55Var.a);
        if (TextUtils.isEmpty(strJ0)) {
            return ((Double) q55Var.a(null)).doubleValue();
        }
        try {
            return ((Double) q55Var.a(Double.valueOf(Double.parseDouble(strJ0)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) q55Var.a(null)).doubleValue();
        }
    }

    public final boolean f1(String str, q55 q55Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) q55Var.a(null)).booleanValue();
        }
        String strJ0 = this.Z.j0(str, q55Var.a);
        return TextUtils.isEmpty(strJ0) ? ((Boolean) q55Var.a(null)).booleanValue() : ((Boolean) q55Var.a(Boolean.valueOf("1".equals(strJ0)))).booleanValue();
    }

    public final Bundle g1() {
        k85 k85Var = (k85) this.f;
        try {
            Context context = k85Var.b;
            t65 t65Var = k85Var.Y;
            if (context.getPackageManager() == null) {
                k85.h(t65Var);
                t65Var.z0.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ey2 ey2VarA = ay4.a(context);
            ApplicationInfo applicationInfo = ey2VarA.a.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            k85.h(t65Var);
            t65Var.z0.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.z0.b(e, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean h1(String str) {
        tj4.f(str);
        Bundle bundleG1 = g1();
        if (bundleG1 != null) {
            if (bundleG1.containsKey(str)) {
                return Boolean.valueOf(bundleG1.getBoolean(str));
            }
            return null;
        }
        t65 t65Var = ((k85) this.f).Y;
        k85.h(t65Var);
        t65Var.z0.a("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final boolean i1() {
        ((k85) this.f).getClass();
        Boolean boolH1 = h1("firebase_analytics_collection_deactivated");
        return boolH1 != null && boolH1.booleanValue();
    }

    public final boolean j1() {
        Boolean boolH1 = h1("google_analytics_automatic_screen_reporting_enabled");
        return boolH1 == null || boolH1.booleanValue();
    }

    public final o95 k1(String str, boolean z) {
        Object obj;
        tj4.f(str);
        k85 k85Var = (k85) this.f;
        Bundle bundleG1 = g1();
        if (bundleG1 == null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleG1.get(str);
        }
        o95 o95Var = o95.UNINITIALIZED;
        if (obj == null) {
            return o95Var;
        }
        if (Boolean.TRUE.equals(obj)) {
            return o95.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return o95.DENIED;
        }
        if (z && "eu_consent_policy".equals(obj)) {
            return o95.POLICY;
        }
        t65 t65Var2 = k85Var.Y;
        k85.h(t65Var2);
        t65Var2.C0.b(str, "Invalid manifest metadata for");
        return o95Var;
    }
}
