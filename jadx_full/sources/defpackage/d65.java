package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d65 extends u55 {
    public String A0;
    public long B0;
    public final long C0;
    public final long D0;
    public List E0;
    public String F0;
    public int G0;
    public String H0;
    public String I0;
    public long J0;
    public String K0;
    public String Y;
    public String Z;
    public int y0;
    public String z0;

    public d65(k85 k85Var, long j, long j2) {
        super(k85Var);
        this.J0 = 0L;
        this.K0 = null;
        this.C0 = j;
        this.D0 = j2;
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x025d  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final tg5 Z0(String str) {
        String str2;
        long j;
        char c;
        long j2;
        long j3;
        boolean z;
        String str3;
        Class<?> clsLoadClass;
        long jA;
        String strP1;
        long j4;
        String str4;
        k85 k85Var;
        boolean z2;
        int i;
        long j5;
        ApplicationInfo applicationInfo;
        q55 q55Var;
        int iR1;
        V0();
        String strB1 = b1();
        String strC1 = c1();
        W0();
        String str5 = this.Z;
        W0();
        long j6 = this.y0;
        W0();
        tj4.i(this.z0);
        String str6 = this.z0;
        k85 k85Var2 = (k85) this.f;
        x15 x15Var = k85Var2.A;
        t65 t65Var = k85Var2.Y;
        x15 x15Var2 = k85Var2.A;
        Context context = k85Var2.b;
        qf5 qf5Var = k85Var2.z0;
        l75 l75Var = k85Var2.X;
        x15Var.a1();
        W0();
        V0();
        long j7 = this.B0;
        long jS1 = 0;
        if (j7 == 0) {
            k85.f(qf5Var);
            k85 k85Var3 = (k85) qf5Var.f;
            String packageName = context.getPackageName();
            qf5Var.V0();
            tj4.f(packageName);
            PackageManager packageManager = context.getPackageManager();
            c = 0;
            MessageDigest messageDigestM1 = qf5.m1();
            long jN1 = -1;
            if (messageDigestM1 == null) {
                t65 t65Var2 = k85Var3.Y;
                k85.h(t65Var2);
                t65Var2.z0.a("Could not get MD5 instance");
                str2 = str5;
                j = j6;
            } else {
                if (packageManager != null) {
                    try {
                        if (qf5Var.A1(context, packageName)) {
                            str2 = str5;
                            j = j6;
                            jN1 = 0;
                        } else {
                            str2 = str5;
                            try {
                                j = j6;
                                try {
                                    Signature[] signatureArr = ay4.a(context).a(64, k85Var3.b.getPackageName()).signatures;
                                    if (signatureArr == null || signatureArr.length <= 0) {
                                        t65 t65Var3 = k85Var3.Y;
                                        k85.h(t65Var3);
                                        t65Var3.C0.a("Could not get signatures");
                                    } else {
                                        jN1 = qf5.n1(messageDigestM1.digest(signatureArr[0].toByteArray()));
                                    }
                                } catch (PackageManager.NameNotFoundException e) {
                                    e = e;
                                    t65 t65Var4 = k85Var3.Y;
                                    k85.h(t65Var4);
                                    t65Var4.z0.b(e, "Package name not found");
                                    j2 = 0;
                                }
                            } catch (PackageManager.NameNotFoundException e2) {
                                e = e2;
                                j = j6;
                                t65 t65Var42 = k85Var3.Y;
                                k85.h(t65Var42);
                                t65Var42.z0.b(e, "Package name not found");
                                j2 = 0;
                                this.B0 = j2;
                                boolean zA = k85Var2.a();
                                k85.f(l75Var);
                                boolean z3 = !l75Var.L0;
                                V0();
                                if (k85Var2.a()) {
                                }
                                k85.f(l75Var);
                                jA = l75Var.z0.a();
                                long jMin = k85Var2.U0;
                                if (jA != 0) {
                                }
                                W0();
                                int i2 = this.G0;
                                Boolean boolH1 = x15Var2.h1("google_analytics_adid_collection_enabled");
                                if (boolH1 != null) {
                                }
                                k85.f(l75Var);
                                l75Var.V0();
                                boolean z4 = l75Var.Z0().getBoolean("deferred_analytics_collection", c);
                                String str7 = str3;
                                Boolean boolValueOf = Boolean.valueOf(x15Var2.k1("google_analytics_default_allow_ad_personalization_signals", true) == o95.GRANTED);
                                List list = this.E0;
                                String strG = l75Var.c1().g();
                                strP1 = this.F0;
                                if (strP1 == null) {
                                }
                                String str8 = strP1;
                                boolean z5 = c;
                                if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
                                }
                                Boolean boolH12 = x15Var2.h1("google_analytics_sgtm_upload_enabled");
                                if (boolH12 != null) {
                                }
                                k85.f(qf5Var);
                                k85Var = (k85) qf5Var.f;
                                String strB12 = b1();
                                String str9 = str4;
                                if (k85Var.b.getPackageManager() != null) {
                                }
                                k85.f(l75Var);
                                int i3 = l75Var.c1().b;
                                k85.f(l75Var);
                                l75Var.V0();
                                String str10 = o25.b(l75Var.Z0().getString("dma_consent_settings", null)).b;
                                mg5.a();
                                q55Var = r55.R0;
                                if (x15Var2.f1(null, q55Var)) {
                                }
                                mg5.a();
                                if (x15Var2.f1(null, q55Var)) {
                                }
                                String str11 = x15Var2.Y;
                                String strValueOf = String.valueOf(t95.h(x15Var2.k1("google_analytics_default_allow_ad_personalization_signals", true)));
                                long j8 = k85Var2.U0;
                                k85.e(k85Var2.L0);
                                return new tg5(strB1, strC1, str2, j, str6, 133005L, j3, str, z, z3, str7, j4, i2, z5, z4, boolValueOf, this.C0, list, strG, str8, str9, z2, j5, i3, str10, iR1, jS1, str11, strValueOf, j8, qe4.n(k85Var2.L0.a1()));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e3) {
                        e = e3;
                        str2 = str5;
                    }
                } else {
                    str2 = str5;
                    j = j6;
                }
                j2 = 0;
                this.B0 = j2;
            }
            j2 = jN1;
            this.B0 = j2;
        } else {
            str2 = str5;
            j = j6;
            c = 0;
            j2 = j7;
        }
        boolean zA2 = k85Var2.a();
        k85.f(l75Var);
        boolean z32 = !l75Var.L0;
        V0();
        if (k85Var2.a()) {
            z = zA2;
            j3 = j2;
            str3 = null;
        } else {
            if (x15Var2.f1(null, r55.I0)) {
                k85.h(t65Var);
                t65Var.H0.a("Disabled IID for tests.");
                z = zA2;
                j3 = j2;
                str3 = null;
            } else {
                try {
                    clsLoadClass = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                } catch (ClassNotFoundException unused) {
                }
                if (clsLoadClass == null) {
                    z = zA2;
                    j3 = j2;
                } else {
                    z = zA2;
                    j3 = j2;
                    try {
                        Class<?>[] clsArr = new Class[1];
                        clsArr[c] = Context.class;
                        Method declaredMethod = clsLoadClass.getDeclaredMethod("getInstance", clsArr);
                        Object[] objArr = new Object[1];
                        objArr[c] = context;
                        str3 = null;
                        Object objInvoke = declaredMethod.invoke(null, objArr);
                        if (objInvoke != null) {
                            try {
                                str3 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                            } catch (Exception unused2) {
                                k85.h(t65Var);
                                t65Var.E0.a("Failed to retrieve Firebase Instance Id");
                                str3 = null;
                            }
                        }
                    } catch (Exception unused3) {
                        k85.h(t65Var);
                        t65Var.D0.a("Failed to obtain Firebase Analytics instance");
                    }
                }
                str3 = null;
            }
        }
        k85.f(l75Var);
        jA = l75Var.z0.a();
        long jMin2 = k85Var2.U0;
        if (jA != 0) {
            jMin2 = Math.min(jMin2, jA);
        }
        W0();
        int i22 = this.G0;
        Boolean boolH13 = x15Var2.h1("google_analytics_adid_collection_enabled");
        char c2 = (boolH13 != null || boolH13.booleanValue()) ? (char) 1 : c;
        k85.f(l75Var);
        l75Var.V0();
        boolean z42 = l75Var.Z0().getBoolean("deferred_analytics_collection", c);
        String str72 = str3;
        Boolean boolValueOf2 = Boolean.valueOf(x15Var2.k1("google_analytics_default_allow_ad_personalization_signals", true) == o95.GRANTED);
        List list2 = this.E0;
        String strG2 = l75Var.c1().g();
        strP1 = this.F0;
        if (strP1 == null) {
            k85.f(qf5Var);
            strP1 = qf5Var.P1();
            this.F0 = strP1;
        }
        String str82 = strP1;
        boolean z52 = c2;
        if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
            j4 = jMin2;
            str4 = null;
        } else {
            V0();
            j4 = jMin2;
            if (this.J0 != 0) {
                k85Var2.B0.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis() - this.J0;
                if (this.I0 != null && jCurrentTimeMillis > 86400000 && this.K0 == null) {
                    a1();
                }
            }
            if (this.I0 == null) {
                a1();
            }
            str4 = this.I0;
        }
        Boolean boolH122 = x15Var2.h1("google_analytics_sgtm_upload_enabled");
        boolean zBooleanValue = boolH122 != null ? false : boolH122.booleanValue();
        k85.f(qf5Var);
        k85Var = (k85) qf5Var.f;
        String strB122 = b1();
        String str92 = str4;
        if (k85Var.b.getPackageManager() != null) {
            z2 = zBooleanValue;
            j5 = 0;
        } else {
            try {
                z2 = zBooleanValue;
                i = 0;
                try {
                    applicationInfo = ay4.a(k85Var.b).a.getPackageManager().getApplicationInfo(strB122, 0);
                } catch (PackageManager.NameNotFoundException unused4) {
                    t65 t65Var5 = k85Var.Y;
                    k85.h(t65Var5);
                    t65Var5.F0.b(strB122, "PackageManager failed to find running app: app_id");
                }
            } catch (PackageManager.NameNotFoundException unused5) {
                z2 = zBooleanValue;
                i = 0;
            }
            int i4 = applicationInfo != null ? applicationInfo.targetSdkVersion : i;
            j5 = i4;
        }
        k85.f(l75Var);
        int i32 = l75Var.c1().b;
        k85.f(l75Var);
        l75Var.V0();
        String str102 = o25.b(l75Var.Z0().getString("dma_consent_settings", null)).b;
        mg5.a();
        q55Var = r55.R0;
        if (x15Var2.f1(null, q55Var)) {
            iR1 = 0;
        } else {
            k85.f(qf5Var);
            iR1 = qf5.r1();
        }
        mg5.a();
        if (x15Var2.f1(null, q55Var)) {
            k85.f(qf5Var);
            jS1 = qf5Var.s1();
        }
        String str112 = x15Var2.Y;
        String strValueOf2 = String.valueOf(t95.h(x15Var2.k1("google_analytics_default_allow_ad_personalization_signals", true)));
        long j82 = k85Var2.U0;
        k85.e(k85Var2.L0);
        return new tg5(strB1, strC1, str2, j, str6, 133005L, j3, str, z, z32, str72, j4, i22, z52, z42, boolValueOf2, this.C0, list2, strG2, str82, str92, z2, j5, i32, str102, iR1, jS1, str112, strValueOf2, j82, qe4.n(k85Var2.L0.a1()));
    }

    public final void a1() {
        String str;
        V0();
        k85 k85Var = (k85) this.f;
        l75 l75Var = k85Var.X;
        t65 t65Var = k85Var.Y;
        k85.f(l75Var);
        if (l75Var.c1().i(r95.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            qf5 qf5Var = k85Var.z0;
            k85.f(qf5Var);
            qf5Var.U1().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            k85.h(t65Var);
            t65Var.G0.a("Analytics Storage consent is not granted");
            str = null;
        }
        k85.h(t65Var);
        t65Var.G0.a("Resetting session stitching token to ".concat(str == null ? "null" : "not null"));
        this.I0 = str;
        k85Var.B0.getClass();
        this.J0 = System.currentTimeMillis();
    }

    public final String b1() {
        W0();
        tj4.i(this.Y);
        return this.Y;
    }

    public final String c1() {
        V0();
        W0();
        tj4.i(this.H0);
        return this.H0;
    }
}
