package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import io.sentry.android.core.internal.tombstone.b;
import j$.util.Comparator;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ib5 extends u55 {
    public final AtomicReference A0;
    public final Object B0;
    public boolean C0;
    public int D0;
    public ba5 E0;
    public ba5 F0;
    public PriorityQueue G0;
    public boolean H0;
    public t95 I0;
    public final AtomicLong J0;
    public long K0;
    public final o75 L0;
    public boolean M0;
    public ba5 N0;
    public gb5 O0;
    public ba5 P0;
    public final rz4 Q0;
    public a55 Y;
    public ca5 Z;
    public final CopyOnWriteArraySet y0;
    public boolean z0;

    public ib5(k85 k85Var) {
        super(k85Var);
        this.y0 = new CopyOnWriteArraySet();
        this.B0 = new Object();
        this.C0 = false;
        this.D0 = 1;
        this.M0 = true;
        this.Q0 = new rz4(5, this);
        this.A0 = new AtomicReference();
        this.I0 = t95.c;
        this.K0 = -1L;
        this.J0 = new AtomicLong(0L);
        this.L0 = new o75(k85Var);
    }

    @Override // defpackage.u55
    public final boolean Y0() {
        return false;
    }

    public final void Z0(t95 t95Var) {
        V0();
        boolean z = (t95Var.i(r95.ANALYTICS_STORAGE) && t95Var.i(r95.AD_STORAGE)) || ((k85) this.f).j().e1();
        k85 k85Var = (k85) this.f;
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.V0();
        if (z != k85Var.Q0) {
            f85 f85Var2 = k85Var.Z;
            k85.h(f85Var2);
            f85Var2.V0();
            k85Var.Q0 = z;
            l75 l75Var = ((k85) this.f).X;
            k85.f(l75Var);
            l75Var.V0();
            Boolean boolValueOf = l75Var.Z0().contains("measurement_enabled_from_api") ? Boolean.valueOf(l75Var.Z0().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                m1(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r14 > 500) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
    
        if (r3 > 500) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a1(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (!Objects.equals(str2, "screen_view")) {
            boolean z3 = !z2 || this.Z == null || qf5.v1(str2);
            if (str == null) {
                str = "app";
            }
            String str3 = str;
            Bundle bundle3 = new Bundle(bundle2);
            for (String str4 : bundle3.keySet()) {
                Object obj = bundle3.get(str4);
                if (obj instanceof Bundle) {
                    bundle3.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    for (int i = 0; i < parcelableArr.length; i++) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                    }
                }
            }
            f85 f85Var = ((k85) this.f).Z;
            k85.h(f85Var);
            f85Var.e1(new na5(this, str3, str2, j, bundle3, z2, z3, z));
            return;
        }
        yb5 yb5Var = ((k85) this.f).C0;
        k85.g(yb5Var);
        synchronized (yb5Var.F0) {
            try {
                if (!yb5Var.E0) {
                    t65 t65Var = ((k85) yb5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.E0.a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle2.getString("screen_name");
                if (string != null) {
                    if (string.length() > 0) {
                        int length = string.length();
                        ((k85) yb5Var.f).A.getClass();
                    }
                    t65 t65Var2 = ((k85) yb5Var.f).Y;
                    k85.h(t65Var2);
                    t65Var2.E0.b(Integer.valueOf(string.length()), "Invalid screen name length for screen view. Length");
                    return;
                }
                String string2 = bundle2.getString("screen_class");
                if (string2 != null) {
                    if (string2.length() > 0) {
                        int length2 = string2.length();
                        ((k85) yb5Var.f).A.getClass();
                    }
                    t65 t65Var3 = ((k85) yb5Var.f).Y;
                    k85.h(t65Var3);
                    t65Var3.E0.b(Integer.valueOf(string2.length()), "Invalid screen class length for screen view. Length");
                    return;
                }
                if (string2 == null) {
                    k45 k45Var = yb5Var.A0;
                    string2 = k45Var != null ? yb5Var.c1(k45Var.f) : "Activity";
                }
                String str5 = string2;
                rb5 rb5Var = yb5Var.Y;
                if (yb5Var.B0 && rb5Var != null) {
                    yb5Var.B0 = false;
                    boolean zEquals = Objects.equals(rb5Var.b, str5);
                    boolean zEquals2 = Objects.equals(rb5Var.a, string);
                    if (zEquals && zEquals2) {
                        t65 t65Var4 = ((k85) yb5Var.f).Y;
                        k85.h(t65Var4);
                        t65Var4.E0.a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                k85 k85Var = (k85) yb5Var.f;
                t65 t65Var5 = k85Var.Y;
                k85.h(t65Var5);
                t65Var5.H0.c("Logging screen view with name, class", string == null ? "null" : string, str5);
                rb5 rb5Var2 = yb5Var.Y == null ? yb5Var.Z : yb5Var.Y;
                qf5 qf5Var = k85Var.z0;
                k85.f(qf5Var);
                rb5 rb5Var3 = new rb5(string, str5, qf5Var.T1(), true, j);
                yb5Var.Y = rb5Var3;
                yb5Var.Z = rb5Var2;
                yb5Var.C0 = rb5Var3;
                k85Var.B0.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                f85 f85Var2 = k85Var.Z;
                k85.h(f85Var2);
                f85Var2.e1(new q85(yb5Var, bundle2, rb5Var3, rb5Var2, jElapsedRealtime));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b1() {
        t65 t65Var;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        ae5 ae5Var;
        ae5 ae5Var2;
        ib5 ib5Var;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String str2;
        ua5 ua5Var;
        gi3 gi3VarD;
        V0();
        k85 k85Var = (k85) this.f;
        t65 t65Var2 = k85Var.Y;
        wl3 wl3Var = k85Var.B0;
        k85.h(t65Var2);
        t65Var2.G0.a("Handle tcf update.");
        l75 l75Var = k85Var.X;
        k85.f(l75Var);
        SharedPreferences sharedPreferencesA1 = l75Var.a1();
        HashMap map = new HashMap();
        q55 q55Var = r55.a1;
        int i12 = 2;
        int i13 = 1;
        if (((Boolean) q55Var.a(null)).booleanValue()) {
            bi3 bi3Var = ce5.a;
            ta5 ta5Var = ta5.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            t65Var = t65Var2;
            be5 be5Var = be5.b;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(ta5Var, be5Var);
            ta5 ta5Var2 = ta5.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            be5 be5Var2 = be5.f;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(ta5Var2, be5Var2);
            ta5 ta5Var3 = ta5.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(ta5Var3, be5Var);
            ta5 ta5Var4 = ta5.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(ta5Var4, be5Var);
            ta5 ta5Var5 = ta5.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            List listAsList = Arrays.asList(simpleImmutableEntry, simpleImmutableEntry2, simpleImmutableEntry3, simpleImmutableEntry4, new AbstractMap.SimpleImmutableEntry(ta5Var5, be5Var2), new AbstractMap.SimpleImmutableEntry(ta5.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, be5Var2), new AbstractMap.SimpleImmutableEntry(ta5.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, be5Var2));
            qt qtVar = new qt(listAsList != null ? listAsList.size() : 4);
            qtVar.q(listAsList);
            gi3 gi3VarD2 = qtVar.d();
            int i14 = hz1.X;
            tx3 tx3Var = new tx3("CH");
            char[] cArr = new char[5];
            boolean zContains = sharedPreferencesA1.contains("IABTCF_TCString");
            try {
                i5 = sharedPreferencesA1.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused) {
                i5 = -1;
            }
            try {
                i6 = sharedPreferencesA1.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused2) {
                i6 = -1;
            }
            try {
                i7 = sharedPreferencesA1.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused3) {
                i7 = -1;
            }
            int i15 = i6;
            try {
                i8 = sharedPreferencesA1.getInt("IABTCF_PurposeOneTreatment", -1);
            } catch (ClassCastException unused4) {
                i8 = -1;
            }
            try {
                i9 = sharedPreferencesA1.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused5) {
                i9 = -1;
            }
            String strA = ce5.a(sharedPreferencesA1, "IABTCF_PublisherCC");
            int i16 = i5;
            qt qtVar2 = new qt(4);
            ei3 ei3Var = gi3VarD2.f;
            if (ei3Var == null) {
                str2 = strA;
                i10 = i8;
                i11 = i9;
                ei3 ei3Var2 = new ei3(gi3VarD2, new fi3(gi3VarD2.X, 0, gi3VarD2.Y));
                gi3VarD2.f = ei3Var2;
                ei3Var = ei3Var2;
            } else {
                i10 = i8;
                i11 = i9;
                str2 = strA;
            }
            hm4 hm4VarM = ei3Var.iterator();
            while (true) {
                boolean zHasNext = hm4VarM.hasNext();
                ua5Var = ua5.PURPOSE_RESTRICTION_UNDEFINED;
                if (!zHasNext) {
                    break;
                }
                ta5 ta5Var6 = (ta5) hm4VarM.next();
                int iA = ta5Var6.a();
                hm4 hm4Var = hm4VarM;
                gi3 gi3Var = gi3VarD2;
                StringBuilder sb = new StringBuilder(String.valueOf(iA).length() + 28);
                sb.append("IABTCF_PublisherRestrictions");
                sb.append(iA);
                String strA2 = ce5.a(sharedPreferencesA1, sb.toString());
                if (!TextUtils.isEmpty(strA2) && strA2.length() >= 755) {
                    int iDigit = Character.digit(strA2.charAt(754), 10);
                    ua5 ua5Var2 = ua5.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    if (iDigit < 0 || iDigit > ua5.values().length || iDigit == 0) {
                        ua5Var = ua5Var2;
                    } else if (iDigit == i13) {
                        ua5Var = ua5.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    } else if (iDigit == i12) {
                        ua5Var = ua5.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                    }
                }
                qtVar2.p(ta5Var6, ua5Var);
                hm4VarM = hm4Var;
                gi3VarD2 = gi3Var;
                i12 = 2;
                i13 = 1;
            }
            gi3 gi3Var2 = gi3VarD2;
            gi3 gi3VarD3 = qtVar2.d();
            String strA3 = ce5.a(sharedPreferencesA1, "IABTCF_PurposeConsents");
            String strA4 = ce5.a(sharedPreferencesA1, "IABTCF_VendorConsents");
            boolean z = !TextUtils.isEmpty(strA4) && strA4.length() >= 755 && strA4.charAt(754) == '1';
            String strA5 = ce5.a(sharedPreferencesA1, "IABTCF_PurposeLegitimateInterests");
            String strA6 = ce5.a(sharedPreferencesA1, "IABTCF_VendorLegitimateInterests");
            boolean z2 = !TextUtils.isEmpty(strA6) && strA6.length() >= 755 && strA6.charAt(754) == '1';
            cArr[0] = '2';
            if (zContains) {
                ua5 ua5Var3 = (ua5) gi3VarD3.get(ta5Var);
                ua5 ua5Var4 = (ua5) gi3VarD3.get(ta5Var3);
                ua5 ua5Var5 = (ua5) gi3VarD3.get(ta5Var4);
                ua5 ua5Var6 = (ua5) gi3VarD3.get(ta5Var5);
                qt qtVar3 = new qt(4);
                qtVar3.p("Version", "2");
                boolean z3 = z;
                qtVar3.p("VendorConsent", true != z ? "0" : "1");
                boolean z4 = z2;
                qtVar3.p("VendorLegitimateInterest", true != z2 ? "0" : "1");
                qtVar3.p("gdprApplies", i7 != 1 ? "0" : "1");
                int i17 = i11;
                qtVar3.p("EnableAdvertiserConsentMode", i17 != 1 ? "0" : "1");
                qtVar3.p("PolicyVersion", String.valueOf(i15));
                qtVar3.p("CmpSdkID", String.valueOf(i16));
                int i18 = i10;
                qtVar3.p("PurposeOneTreatment", i18 != 1 ? "0" : "1");
                String str3 = str2;
                qtVar3.p("PublisherCC", str3);
                qtVar3.p("PublisherRestrictions1", String.valueOf(ua5Var3 != null ? ua5Var3.a() : ua5Var.a()));
                qtVar3.p("PublisherRestrictions3", String.valueOf(ua5Var4 != null ? ua5Var4.a() : ua5Var.a()));
                qtVar3.p("PublisherRestrictions4", String.valueOf(ua5Var5 != null ? ua5Var5.a() : ua5Var.a()));
                qtVar3.p("PublisherRestrictions7", String.valueOf(ua5Var6 != null ? ua5Var6.a() : ua5Var.a()));
                qtVar3.q(gi3.a(4, new Object[]{"Purpose1", ce5.d(ta5Var, strA3, strA5), "Purpose3", ce5.d(ta5Var3, strA3, strA5), "Purpose4", ce5.d(ta5Var4, strA3, strA5), "Purpose7", ce5.d(ta5Var5, strA3, strA5)}, null).entrySet());
                int i19 = i7;
                qtVar3.q(gi3.a(5, new Object[]{"AuthorizePurpose1", true != ce5.b(ta5Var, gi3Var2, gi3VarD3, tx3Var, cArr, i17, i19, i18, str3, strA3, strA5, z3, z4) ? "0" : "1", "AuthorizePurpose3", true != ce5.b(ta5Var3, gi3Var2, gi3VarD3, tx3Var, cArr, i17, i19, i18, str3, strA3, strA5, z3, z4) ? "0" : "1", "AuthorizePurpose4", true != ce5.b(ta5Var4, gi3Var2, gi3VarD3, tx3Var, cArr, i17, i19, i18, str3, strA3, strA5, z3, z4) ? "0" : "1", "AuthorizePurpose7", true != ce5.b(ta5Var5, gi3Var2, gi3VarD3, tx3Var, cArr, i17, i19, i18, str3, strA3, strA5, z3, z4) ? "0" : "1", "PurposeDiagnostics", new String(cArr)}, null).entrySet());
                gi3VarD = qtVar3.d();
            } else {
                gi3VarD = gi3.Z;
            }
            ae5Var = new ae5(gi3VarD);
            str = "";
        } else {
            t65Var = t65Var2;
            String strA7 = ce5.a(sharedPreferencesA1, "IABTCF_VendorConsents");
            str = "";
            if (!str.equals(strA7) && strA7.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strA7.charAt(754)));
            }
            try {
                i = sharedPreferencesA1.getInt("IABTCF_gdprApplies", -1);
            } catch (ClassCastException unused6) {
                i = -1;
            }
            if (i != -1) {
                map.put("gdprApplies", String.valueOf(i));
            }
            try {
                i2 = sharedPreferencesA1.getInt("IABTCF_EnableAdvertiserConsentMode", -1);
            } catch (ClassCastException unused7) {
                i2 = -1;
            }
            if (i2 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(i2));
            }
            try {
                i3 = sharedPreferencesA1.getInt("IABTCF_PolicyVersion", -1);
            } catch (ClassCastException unused8) {
                i3 = -1;
            }
            if (i3 != -1) {
                map.put("PolicyVersion", String.valueOf(i3));
            }
            String strA8 = ce5.a(sharedPreferencesA1, "IABTCF_PurposeConsents");
            if (!str.equals(strA8)) {
                map.put("PurposeConsents", strA8);
            }
            try {
                i4 = sharedPreferencesA1.getInt("IABTCF_CmpSdkID", -1);
            } catch (ClassCastException unused9) {
                i4 = -1;
            }
            if (i4 != -1) {
                map.put("CmpSdkID", String.valueOf(i4));
            }
            ae5Var = new ae5(map);
        }
        k85.h(t65Var);
        t65 t65Var3 = t65Var;
        q65 q65Var = t65Var3.H0;
        q65Var.b(ae5Var, "Tcf preferences read");
        if (!k85Var.A.f1(null, q55Var)) {
            if (l75Var.d1(ae5Var)) {
                Bundle bundleB = ae5Var.b();
                k85.h(t65Var3);
                q65Var.b(bundleB, "Consent generated from Tcf");
                if (bundleB != Bundle.EMPTY) {
                    wl3Var.getClass();
                    p1(bundleB, -30, System.currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", ae5Var.c());
                c1("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        l75Var.V0();
        String string = l75Var.Z0().getString("stored_tcf_param", str);
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            ae5Var2 = new ae5(map2);
        } else {
            for (String str4 : string.split(";")) {
                String[] strArrSplit = str4.split("=");
                if (strArrSplit.length >= 2 && ce5.a.contains(strArrSplit[0])) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            ae5Var2 = new ae5(map2);
        }
        if (l75Var.d1(ae5Var)) {
            Bundle bundleB2 = ae5Var.b();
            k85.h(t65Var3);
            q65Var.b(bundleB2, "Consent generated from Tcf");
            if (bundleB2 != Bundle.EMPTY) {
                wl3Var.getClass();
                ib5Var = this;
                ib5Var.p1(bundleB2, -30, System.currentTimeMillis());
            } else {
                ib5Var = this;
            }
            Bundle bundle2 = new Bundle();
            HashMap map3 = ae5Var2.a;
            String str5 = (map3.isEmpty() || ((String) map3.get("Version")) != null) ? "0" : "1";
            Bundle bundleB3 = ae5Var.b();
            Bundle bundleB4 = ae5Var2.b();
            bundle2.putString("_tcfm", str5.concat((bundleB3.size() == bundleB4.size() && Objects.equals(bundleB3.getString("ad_storage"), bundleB4.getString("ad_storage")) && Objects.equals(bundleB3.getString("ad_personalization"), bundleB4.getString("ad_personalization")) && Objects.equals(bundleB3.getString("ad_user_data"), bundleB4.getString("ad_user_data"))) ? "0" : "1"));
            String str6 = (String) ae5Var.a.get("PurposeDiagnostics");
            if (TextUtils.isEmpty(str6)) {
                str6 = "200000";
            }
            bundle2.putString("_tcfd2", str6);
            bundle2.putString("_tcfd", ae5Var.c());
            ib5Var.c1("auto", "_tcf", bundle2);
        }
    }

    public final void c1(String str, String str2, Bundle bundle) {
        V0();
        ((k85) this.f).B0.getClass();
        d1(System.currentTimeMillis(), bundle, str, str2);
    }

    public final void d1(long j, Bundle bundle, String str, String str2) {
        V0();
        boolean z = true;
        if (this.Z != null && !qf5.v1(str2)) {
            z = false;
        }
        e1(str, str2, j, bundle, true, z, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0521 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014d  */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e1(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        boolean z4;
        l75 l75Var;
        wl3 wl3Var;
        t65 t65Var;
        x15 x15Var;
        ?? r15;
        ib5 ib5Var;
        qf5 qf5Var;
        qf5 qf5Var2;
        l75 l75Var2;
        k85 k85Var;
        boolean z5;
        long j2;
        boolean zA;
        ib5 ib5Var2;
        long j3;
        long j4;
        String str3;
        String str4;
        yb5 yb5Var;
        qf5 qf5Var3;
        int size;
        int i;
        int i2;
        boolean zC1;
        Iterator it;
        k85 k85Var2;
        y35 y35Var;
        Parcel parcelC;
        Bundle[] bundleArr;
        int i3;
        int i4;
        tj4.f(str);
        tj4.i(bundle);
        V0();
        W0();
        k85 k85Var3 = (k85) this.f;
        boolean zA2 = k85Var3.a();
        zd5 zd5Var = k85Var3.y0;
        x15 x15Var2 = k85Var3.A;
        Context context = k85Var3.b;
        qf5 qf5Var4 = k85Var3.z0;
        t65 t65Var2 = k85Var3.Y;
        if (!zA2) {
            k85.h(t65Var2);
            t65Var2.G0.a("Event not sent since app measurement is disabled");
            return;
        }
        List list = k85Var3.l().E0;
        if (list != null && !list.contains(str2)) {
            k85.h(t65Var2);
            t65Var2.G0.c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (this.z0) {
            z4 = false;
        } else {
            this.z0 = true;
            try {
                z4 = false;
                try {
                    try {
                        (!k85Var3.f ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, context.getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, context);
                    } catch (Exception e) {
                        k85.h(t65Var2);
                        t65Var2.C0.b(e, "Failed to invoke Tag Manager's initialize() method");
                    }
                } catch (ClassNotFoundException unused) {
                    k85.h(t65Var2);
                    t65Var2.F0.a("Tag Manager is not found and thus will not be used");
                }
            } catch (ClassNotFoundException unused2) {
                z4 = false;
            }
        }
        k65 k65Var = k85Var3.A0;
        l75 l75Var3 = k85Var3.X;
        wl3 wl3Var2 = k85Var3.B0;
        if (!x15Var2.f1(null, r55.g1) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
            String string = bundle.getString("gclid");
            wl3Var2.getClass();
            t65Var = t65Var2;
            x15Var = x15Var2;
            r15 = z4;
            qf5Var = qf5Var4;
            wl3Var = wl3Var2;
            l75Var = l75Var3;
            ib5Var = this;
            ib5Var.g1(System.currentTimeMillis(), string, "auto", "_lgclid");
        } else {
            l75Var = l75Var3;
            wl3Var = wl3Var2;
            t65Var = t65Var2;
            x15Var = x15Var2;
            r15 = z4;
            ib5Var = this;
            qf5Var = qf5Var4;
        }
        if (!z || qf5.D0[r15].equals(str2)) {
            qf5Var2 = qf5Var;
            l75Var2 = l75Var;
        } else {
            k85.f(qf5Var);
            k85.f(l75Var);
            l75Var2 = l75Var;
            qf5Var2 = qf5Var;
            qf5Var2.g1(bundle, l75Var2.S0.f());
        }
        rz4 rz4Var = ib5Var.Q0;
        if (!z3 && !"_iap".equals(str2)) {
            k85.f(qf5Var2);
            if (!qf5Var2.X1("event", str2)) {
                i4 = 2;
            } else if (qf5Var2.Z1("event", xb5.Z, xb5.y0, str2)) {
                x15 x15Var3 = ((k85) qf5Var2.f).A;
                i3 = 40;
                i4 = !qf5Var2.a2("event", 40, str2) ? 2 : 0;
                if (i4 != 0) {
                    k85.h(t65Var);
                    t65Var.B0.b(k65Var.a(str2), "Invalid public event name. Event will not be logged (FE)");
                    k85.f(qf5Var2);
                    qf5.l1(rz4Var, null, i4, "_ev", qf5.a1(i3, str2, true), str2 != null ? str2.length() : 0);
                    return;
                }
            } else {
                i4 = 13;
            }
            i3 = 40;
            if (i4 != 0) {
            }
        }
        t65 t65Var3 = t65Var;
        yb5 yb5Var2 = k85Var3.C0;
        k85.g(yb5Var2);
        rb5 rb5VarB1 = yb5Var2.b1(false);
        if (rb5VarB1 == null || bundle.containsKey("_sc")) {
            k85Var = k85Var3;
        } else {
            k85Var = k85Var3;
            rb5VarB1.d = true;
        }
        qf5.O1(rb5VarB1, bundle, z && !z3);
        boolean zEquals = "am".equals(str);
        boolean zV1 = qf5.v1(str2);
        if (z) {
            z5 = zEquals;
            if (ib5Var.Z != null && !zV1) {
                if (!z5) {
                    k85.h(t65Var3);
                    t65Var3.G0.c("Passing event to registered event handler (FE)", k65Var.a(str2), k65Var.e(bundle));
                    tj4.i(ib5Var.Z);
                    ca5 ca5Var = ib5Var.Z;
                    ca5Var.getClass();
                    try {
                        y35 y35Var2 = (y35) ((g45) ca5Var.a);
                        Parcel parcelC2 = y35Var2.c();
                        parcelC2.writeString(str);
                        parcelC2.writeString(str2);
                        d35.b(parcelC2, bundle);
                        parcelC2.writeLong(j);
                        y35Var2.E(parcelC2, 1);
                        return;
                    } catch (RemoteException e2) {
                        k85 k85Var4 = ((AppMeasurementDynamiteService) ca5Var.b).c;
                        if (k85Var4 != null) {
                            t65 t65Var4 = k85Var4.Y;
                            k85.h(t65Var4);
                            t65Var4.C0.b(e2, "Event interceptor threw exception");
                            return;
                        }
                        return;
                    }
                }
                z5 = true;
            }
        } else {
            z5 = zEquals;
        }
        if (k85Var.c()) {
            k85.f(qf5Var2);
            k85 k85Var5 = (k85) qf5Var2.f;
            int iB2 = qf5Var2.b2(str2);
            if (iB2 != 0) {
                k85.h(t65Var3);
                t65Var3.B0.b(k65Var.a(str2), "Invalid event name. Event will not be logged (FE)");
                String strA1 = qf5.a1(40, str2, true);
                int length = str2 != null ? str2.length() : 0;
                k85.f(qf5Var2);
                qf5.l1(rz4Var, null, iB2, "_ev", strA1, length);
                return;
            }
            Bundle bundleD1 = qf5Var2.d1(str2, bundle, DesugarCollections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si")), z3);
            tj4.i(bundleD1);
            k85.g(yb5Var2);
            if (yb5Var2.b1(false) == null || !"_ae".equals(str2)) {
                j2 = 0;
            } else {
                k85.g(zd5Var);
                b bVar = zd5Var.z0;
                j2 = 0;
                ((k85) ((zd5) bVar.d).f).B0.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j5 = jElapsedRealtime - bVar.b;
                bVar.b = jElapsedRealtime;
                if (j5 > 0) {
                    qf5Var2.E1(bundleD1, j5);
                }
            }
            if (!"auto".equals(str) && "_ssr".equals(str2)) {
                String string2 = bundleD1.getString("_ffr");
                int i5 = o44.a;
                if (string2 == null || string2.trim().isEmpty()) {
                    string2 = null;
                } else if (string2 != null) {
                    string2 = string2.trim();
                }
                l75 l75Var4 = k85Var5.X;
                k85.f(l75Var4);
                if (Objects.equals(string2, l75Var4.P0.B())) {
                    t65 t65Var5 = k85Var5.Y;
                    k85.h(t65Var5);
                    t65Var5.G0.a("Not logging duplicate session_start_with_rollout event");
                    return;
                } else {
                    l75 l75Var5 = k85Var5.X;
                    k85.f(l75Var5);
                    l75Var5.P0.C(string2);
                }
            } else if ("_ae".equals(str2)) {
                l75 l75Var6 = k85Var5.X;
                k85.f(l75Var6);
                String strB = l75Var6.P0.B();
                if (!TextUtils.isEmpty(strB)) {
                    bundleD1.putString("_ffr", strB);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleD1);
            if (x15Var.f1(null, r55.V0)) {
                k85.g(zd5Var);
                zd5Var.V0();
                zA = zd5Var.Z;
            } else {
                k85.f(l75Var2);
                zA = l75Var2.M0.a();
            }
            k85.f(l75Var2);
            if (l75Var2.J0.a() <= j2) {
                ib5Var2 = this;
                j3 = j;
                j4 = j2;
                str3 = "_o";
                str4 = "_ae";
                yb5Var = yb5Var2;
            } else {
                if (l75Var2.f1(j) && zA) {
                    k85.h(t65Var3);
                    t65Var3.H0.a("Current session is expired, remove the session number, ID, and engagement time");
                    wl3Var.getClass();
                    j3 = j;
                    j4 = j2;
                    str4 = "_ae";
                    yb5Var = yb5Var2;
                    qf5Var3 = qf5Var2;
                    str3 = "_o";
                    g1(System.currentTimeMillis(), null, "auto", "_sid");
                    g1(System.currentTimeMillis(), null, "auto", "_sno");
                    g1(System.currentTimeMillis(), null, "auto", "_se");
                    ib5Var2 = this;
                    l75Var2.K0.b(j4);
                    if (bundleD1.getLong("extend_session", j4) == 1) {
                        k85.h(t65Var3);
                        t65Var3.H0.a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                        k85.g(zd5Var);
                        zd5Var.y0.f(j3);
                    }
                    ArrayList arrayList2 = new ArrayList(bundleD1.keySet());
                    Collections.sort(arrayList2);
                    size = arrayList2.size();
                    for (i = 0; i < size; i++) {
                        String str5 = (String) arrayList2.get(i);
                        if (str5 != null) {
                            k85.f(qf5Var3);
                            Object obj = bundleD1.get(str5);
                            if (obj instanceof Bundle) {
                                bundleArr = new Bundle[]{(Bundle) obj};
                            } else if (obj instanceof Parcelable[]) {
                                Parcelable[] parcelableArr = (Parcelable[]) obj;
                                bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                            } else if (obj instanceof ArrayList) {
                                ArrayList arrayList3 = (ArrayList) obj;
                                bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                            } else {
                                bundleArr = null;
                            }
                            if (bundleArr != null) {
                                bundleD1.putParcelableArray(str5, bundleArr);
                            }
                        }
                    }
                    i2 = 0;
                    while (i2 < arrayList.size()) {
                        Bundle bundleY1 = (Bundle) arrayList.get(i2);
                        String str6 = i2 != 0 ? "_ep" : str2;
                        String str7 = str3;
                        bundleY1.putString(str7, str);
                        if (z2) {
                            bundleY1 = qf5Var3.y1(bundleY1);
                        }
                        Bundle bundle2 = bundleY1;
                        z25 z25Var = new z25(str6, new y25(bundle2), str, j3);
                        dd5 dd5VarJ = k85Var.j();
                        dd5VarJ.getClass();
                        dd5VarJ.V0();
                        dd5VarJ.W0();
                        dd5VarJ.h1();
                        i65 i65VarI = ((k85) dd5VarJ.f).i();
                        i65VarI.getClass();
                        Parcel parcelObtain = Parcel.obtain();
                        gl4.b(z25Var, parcelObtain, 0);
                        byte[] bArrMarshall = parcelObtain.marshall();
                        parcelObtain.recycle();
                        if (bArrMarshall.length > 131072) {
                            t65 t65Var6 = ((k85) i65VarI.f).Y;
                            k85.h(t65Var6);
                            t65Var6.A0.a("Event is too long for local database. Sending event directly to service");
                            zC1 = false;
                        } else {
                            zC1 = i65VarI.c1(0, bArrMarshall);
                        }
                        dd5VarJ.j1(new ec5(dd5VarJ, dd5VarJ.l1(true), zC1, z25Var, 1));
                        if (!z5) {
                            Iterator it2 = ib5Var2.y0.iterator();
                            while (it2.hasNext()) {
                                zf5 zf5Var = (zf5) it2.next();
                                Bundle bundle3 = new Bundle(bundle2);
                                zf5Var.getClass();
                                try {
                                    y35Var = (y35) zf5Var.a;
                                    parcelC = y35Var.c();
                                    parcelC.writeString(str);
                                    try {
                                        parcelC.writeString(str2);
                                        d35.b(parcelC, bundle3);
                                        parcelC.writeLong(j3);
                                        it = it2;
                                    } catch (RemoteException e3) {
                                        e = e3;
                                        it = it2;
                                        k85Var2 = zf5Var.b.c;
                                        if (k85Var2 == null) {
                                            t65 t65Var7 = k85Var2.Y;
                                            k85.h(t65Var7);
                                            t65Var7.C0.b(e, "Event listener threw exception");
                                        }
                                        it2 = it;
                                    }
                                } catch (RemoteException e4) {
                                    e = e4;
                                }
                                try {
                                    y35Var.E(parcelC, 1);
                                } catch (RemoteException e5) {
                                    e = e5;
                                    k85Var2 = zf5Var.b.c;
                                    if (k85Var2 == null) {
                                    }
                                }
                                it2 = it;
                            }
                        }
                        i2++;
                        str3 = str7;
                    }
                    k85.g(yb5Var);
                    if (yb5Var.b1(false) == null && str4.equals(str2)) {
                        k85.g(zd5Var);
                        wl3Var.getClass();
                        zd5Var.z0.b(SystemClock.elapsedRealtime(), true, true);
                        return;
                    }
                }
                j4 = j2;
                str3 = "_o";
                j3 = j;
                str4 = "_ae";
                yb5Var = yb5Var2;
                ib5Var2 = this;
            }
            qf5Var3 = qf5Var2;
            if (bundleD1.getLong("extend_session", j4) == 1) {
            }
            ArrayList arrayList22 = new ArrayList(bundleD1.keySet());
            Collections.sort(arrayList22);
            size = arrayList22.size();
            while (i < size) {
            }
            i2 = 0;
            while (i2 < arrayList.size()) {
            }
            k85.g(yb5Var);
            if (yb5Var.b1(false) == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f1(String str, String str2, Object obj, boolean z, long j) {
        int iC2;
        int length;
        k85 k85Var = (k85) this.f;
        if (z) {
            qf5 qf5Var = k85Var.z0;
            k85.f(qf5Var);
            iC2 = qf5Var.c2(str2);
        } else {
            qf5 qf5Var2 = k85Var.z0;
            k85.f(qf5Var2);
            if (qf5Var2.X1("user property", str2)) {
                if (qf5Var2.Z1("user property", ye.d, null, str2)) {
                    x15 x15Var = ((k85) qf5Var2.f).A;
                    iC2 = !qf5Var2.a2("user property", 24, str2) ? 6 : 0;
                } else {
                    iC2 = 15;
                }
            }
        }
        rz4 rz4Var = this.Q0;
        if (iC2 != 0) {
            k85.f(k85Var.z0);
            String strA1 = qf5.a1(24, str2, true);
            length = str2 != null ? str2.length() : 0;
            k85.f(k85Var.z0);
            qf5.l1(rz4Var, null, iC2, "_ev", strA1, length);
            return;
        }
        String str3 = str == null ? "app" : str;
        if (obj == null) {
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.e1(new q85(this, str3, str2, null, j, 1));
            return;
        }
        qf5 qf5Var3 = k85Var.z0;
        qf5 qf5Var4 = k85Var.z0;
        k85.f(qf5Var3);
        int iI1 = qf5Var3.i1(obj, str2);
        if (iI1 != 0) {
            k85.f(qf5Var4);
            String strA12 = qf5.a1(24, str2, true);
            length = ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0;
            k85.f(qf5Var4);
            qf5.l1(rz4Var, null, iI1, "_ev", strA12, length);
            return;
        }
        k85.f(qf5Var4);
        Object objJ1 = qf5Var4.j1(obj, str2);
        if (objJ1 != null) {
            f85 f85Var2 = k85Var.Z;
            k85.h(f85Var2);
            f85Var2.e1(new q85(this, str3, str2, objJ1, j, 1));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g1(long j, Object obj, String str, String str2) {
        String str3;
        boolean zC1;
        Object objValueOf = obj;
        k85 k85Var = (k85) this.f;
        tj4.f(str);
        tj4.f(str2);
        V0();
        W0();
        if ("allow_personalized_ads".equals(str2)) {
            String str4 = "_npa";
            if (objValueOf instanceof String) {
                String str5 = (String) objValueOf;
                if (!TextUtils.isEmpty(str5)) {
                    long j2 = true != "false".equals(str5.toLowerCase(Locale.ENGLISH)) ? 0L : 1L;
                    objValueOf = Long.valueOf(j2);
                    l75 l75Var = k85Var.X;
                    k85.f(l75Var);
                    l75Var.G0.C(j2 == 1 ? "true" : "false");
                } else if (objValueOf == null) {
                    l75 l75Var2 = k85Var.X;
                    k85.f(l75Var2);
                    l75Var2.G0.C("unset");
                } else {
                    str4 = str2;
                }
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.H0.c("Setting user property(FE)", "non_personalized_ads(_npa)", objValueOf);
                str3 = str4;
            }
        } else {
            str3 = str2;
        }
        Object obj2 = objValueOf;
        if (!k85Var.a()) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.H0.a("User property not set since app measurement is disabled");
            return;
        }
        if (k85Var.c()) {
            kf5 kf5Var = new kf5(j, obj2, str3, str);
            dd5 dd5VarJ = k85Var.j();
            dd5VarJ.V0();
            dd5VarJ.W0();
            dd5VarJ.h1();
            i65 i65VarI = ((k85) dd5VarJ.f).i();
            i65VarI.getClass();
            Parcel parcelObtain = Parcel.obtain();
            ke5.a(kf5Var, parcelObtain);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            if (bArrMarshall.length > 131072) {
                t65 t65Var3 = ((k85) i65VarI.f).Y;
                k85.h(t65Var3);
                t65Var3.A0.a("User property too long for local database. Sending directly to service");
                zC1 = false;
            } else {
                zC1 = i65VarI.c1(1, bArrMarshall);
            }
            dd5VarJ.j1(new ec5(dd5VarJ, dd5VarJ.l1(true), zC1, kf5Var, 0));
        }
    }

    public final void h1() {
        V0();
        W0();
        k85 k85Var = (k85) this.f;
        if (k85Var.c()) {
            x15 x15Var = k85Var.A;
            ((k85) x15Var.f).getClass();
            Boolean boolH1 = x15Var.h1("google_analytics_deferred_deep_link_enabled");
            if (boolH1 != null && boolH1.booleanValue()) {
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.G0.a("Deferred Deep Link feature enabled.");
                f85 f85Var = k85Var.Z;
                k85.h(f85Var);
                f85Var.e1(new z95(this, 2));
            }
            dd5 dd5VarJ = k85Var.j();
            dd5VarJ.V0();
            dd5VarJ.W0();
            tg5 tg5VarL1 = dd5VarJ.l1(true);
            dd5VarJ.h1();
            k85 k85Var2 = (k85) dd5VarJ.f;
            k85Var2.A.f1(null, r55.c1);
            k85Var2.i().c1(3, new byte[0]);
            dd5VarJ.j1(new ic5(dd5VarJ, tg5VarL1, 0));
            this.M0 = false;
            l75 l75Var = k85Var.X;
            k85.f(l75Var);
            l75Var.V0();
            String string = l75Var.Z0().getString("previous_os_version", null);
            ((k85) l75Var.f).k().X0();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = l75Var.Z0().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            k85Var.k().X0();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            c1("auto", "_ou", bundle);
        }
    }

    public final void i1(Bundle bundle, long j) {
        k85 k85Var = (k85) this.f;
        tj4.i(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.C0.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        ke0.L(bundle2, "app_id", String.class, null);
        ke0.L(bundle2, "origin", String.class, null);
        ke0.L(bundle2, "name", String.class, null);
        ke0.L(bundle2, "value", Object.class, null);
        ke0.L(bundle2, "trigger_event_name", String.class, null);
        ke0.L(bundle2, "trigger_timeout", Long.class, 0L);
        ke0.L(bundle2, "timed_out_event_name", String.class, null);
        ke0.L(bundle2, "timed_out_event_params", Bundle.class, null);
        ke0.L(bundle2, "triggered_event_name", String.class, null);
        ke0.L(bundle2, "triggered_event_params", Bundle.class, null);
        ke0.L(bundle2, "time_to_live", Long.class, 0L);
        ke0.L(bundle2, "expired_event_name", String.class, null);
        ke0.L(bundle2, "expired_event_params", Bundle.class, null);
        tj4.f(bundle2.getString("name"));
        tj4.f(bundle2.getString("origin"));
        tj4.i(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        qf5 qf5Var = k85Var.z0;
        k65 k65Var = k85Var.A0;
        t65 t65Var2 = k85Var.Y;
        k85.f(qf5Var);
        if (qf5Var.c2(string) != 0) {
            k85.h(t65Var2);
            t65Var2.z0.b(k65Var.c(string), "Invalid conditional user property name");
            return;
        }
        k85.f(qf5Var);
        if (qf5Var.i1(obj, string) != 0) {
            k85.h(t65Var2);
            t65Var2.z0.c("Invalid conditional user property value", k65Var.c(string), obj);
            return;
        }
        Object objJ1 = qf5Var.j1(obj, string);
        if (objJ1 == null) {
            k85.h(t65Var2);
            t65Var2.z0.c("Unable to normalize conditional user property value", k65Var.c(string), obj);
            return;
        }
        ke0.K(bundle2, objJ1);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
            k85.h(t65Var2);
            t65Var2.z0.c("Invalid conditional user property timeout", k65Var.c(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong("time_to_live");
        if (j3 > 15552000000L || j3 < 1) {
            k85.h(t65Var2);
            t65Var2.z0.c("Invalid conditional user property time to live", k65Var.c(string), Long.valueOf(j3));
        } else {
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.e1(new um1(18, (Object) this, (Object) bundle2, false));
        }
    }

    public final void j1(String str, String str2, Bundle bundle) {
        k85 k85Var = (k85) this.f;
        k85Var.B0.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        tj4.f(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.e1(new qa5(this, bundle2, 0));
    }

    public final String k1() {
        k85 k85Var = (k85) this.f;
        try {
            return n12.Y(k85Var.b, k85Var.G0);
        } catch (IllegalStateException e) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.z0.b(e, "getGoogleAppId failed with exception");
            return null;
        }
    }

    public final void l1(t95 t95Var, long j, boolean z) {
        int i = t95Var.b;
        V0();
        W0();
        k85 k85Var = (k85) this.f;
        l75 l75Var = k85Var.X;
        t65 t65Var = k85Var.Y;
        k85.f(l75Var);
        t95 t95VarC1 = l75Var.c1();
        if (j <= this.K0 && t95.l(t95VarC1.b, i)) {
            k85.h(t65Var);
            t65Var.F0.b(t95Var, "Dropped out-of-date consent setting, proposed settings");
            return;
        }
        l75 l75Var2 = k85Var.X;
        k85.f(l75Var2);
        l75Var2.V0();
        if (!t95.l(i, l75Var2.Z0().getInt("consent_source", 100))) {
            k85.h(t65Var);
            t65Var.F0.b(Integer.valueOf(i), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = l75Var2.Z0().edit();
        editorEdit.putString("consent_settings", t95Var.g());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        k85.h(t65Var);
        t65Var.H0.b(t95Var, "Setting storage consent(FE)");
        this.K0 = j;
        if (k85Var.j().f1()) {
            dd5 dd5VarJ = k85Var.j();
            dd5VarJ.V0();
            dd5VarJ.W0();
            dd5VarJ.j1(new xc5(dd5VarJ, 2));
        } else {
            dd5 dd5VarJ2 = k85Var.j();
            dd5VarJ2.V0();
            dd5VarJ2.W0();
            if (dd5VarJ2.e1()) {
                dd5VarJ2.j1(new ic5(dd5VarJ2, dd5VarJ2.l1(false), 1));
            }
        }
        if (z) {
            k85Var.j().Z0(new AtomicReference());
        }
    }

    public final void m1(Boolean bool, boolean z) {
        V0();
        W0();
        k85 k85Var = (k85) this.f;
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        t65Var.G0.b(bool, "Setting app measurement enabled (FE)");
        l75 l75Var = k85Var.X;
        k85.f(l75Var);
        l75Var.V0();
        SharedPreferences.Editor editorEdit = l75Var.Z0().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z) {
            l75Var.V0();
            SharedPreferences.Editor editorEdit2 = l75Var.Z0().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.V0();
        if (k85Var.Q0 || !(bool == null || bool.booleanValue())) {
            n1();
        }
    }

    public final void n1() {
        V0();
        k85 k85Var = (k85) this.f;
        l75 l75Var = k85Var.X;
        t65 t65Var = k85Var.Y;
        wl3 wl3Var = k85Var.B0;
        k85.f(l75Var);
        String strB = l75Var.G0.B();
        int i = 1;
        if (strB != null) {
            if ("unset".equals(strB)) {
                wl3Var.getClass();
                g1(System.currentTimeMillis(), null, "app", "_npa");
            } else {
                Long lValueOf = Long.valueOf(true != "true".equals(strB) ? 0L : 1L);
                wl3Var.getClass();
                g1(System.currentTimeMillis(), lValueOf, "app", "_npa");
            }
        }
        if (!k85Var.a() || !this.M0) {
            k85.h(t65Var);
            t65Var.G0.a("Updating Scion state (FE)");
            dd5 dd5VarJ = k85Var.j();
            dd5VarJ.V0();
            dd5VarJ.W0();
            dd5VarJ.j1(new gc5(dd5VarJ, dd5VarJ.l1(true), 2));
            return;
        }
        k85.h(t65Var);
        t65Var.G0.a("Recording app launch after enabling measurement for the first time (FE)");
        h1();
        zd5 zd5Var = k85Var.y0;
        k85.g(zd5Var);
        zd5Var.y0.e();
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.e1(new z95(this, i));
    }

    public final void o1() {
        k85 k85Var = (k85) this.f;
        if (!(k85Var.b.getApplicationContext() instanceof Application) || this.Y == null) {
            return;
        }
        ((Application) k85Var.b.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.Y);
    }

    public final void p1(Bundle bundle, int i, long j) {
        Boolean bool;
        String string;
        o95 o95Var;
        k85 k85Var = (k85) this.f;
        W0();
        t95 t95Var = t95.c;
        r95[] r95VarArr = q95.STORAGE.b;
        int length = r95VarArr.length;
        int i2 = 0;
        while (true) {
            bool = null;
            if (i2 >= length) {
                string = null;
                break;
            }
            String str = r95VarArr[i2].b;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if ((string.equals("granted") ? Boolean.TRUE : string.equals("denied") ? Boolean.FALSE : null) == null) {
                    break;
                }
            }
            i2++;
        }
        if (string != null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.E0.b(string, "Ignoring invalid consent setting");
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.E0.a("Valid consent values are 'granted', 'denied'");
        }
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        boolean zB1 = f85Var.b1();
        t95 t95VarB = t95.b(i, bundle);
        Iterator it = t95VarB.a.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            o95Var = o95.UNINITIALIZED;
            if (!zHasNext) {
                break;
            } else if (((o95) it.next()) != o95Var) {
                r1(t95VarB, zB1);
                break;
            }
        }
        o25 o25VarC = o25.c(i, bundle);
        Iterator it2 = o25VarC.e.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (((o95) it2.next()) != o95Var) {
                q1(o25VarC, zB1);
                break;
            }
        }
        if (bundle != null) {
            int iOrdinal = t95.d(bundle.getString("ad_personalization")).ordinal();
            if (iOrdinal == 2) {
                bool = Boolean.FALSE;
            } else if (iOrdinal == 3) {
                bool = Boolean.TRUE;
            }
        }
        if (bool != null) {
            String str2 = i == -30 ? "tcf" : "app";
            if (zB1) {
                g1(j, bool.toString(), str2, "allow_personalized_ads");
            } else {
                f1(str2, "allow_personalized_ads", bool.toString(), false, j);
            }
        }
    }

    public final void q1(o25 o25Var, boolean z) {
        um1 um1Var = new um1(20, (Object) this, (Object) o25Var, false);
        if (z) {
            V0();
            um1Var.run();
        } else {
            f85 f85Var = ((k85) this.f).Z;
            k85.h(f85Var);
            f85Var.e1(um1Var);
        }
    }

    public final void r1(t95 t95Var, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        t95 t95Var2;
        W0();
        int i = t95Var.b;
        if (i != -10) {
            o95 o95Var = (o95) t95Var.a.get(r95.AD_STORAGE);
            if (o95Var == null) {
                o95Var = o95.UNINITIALIZED;
            }
            o95 o95Var2 = o95.UNINITIALIZED;
            if (o95Var == o95Var2) {
                o95 o95Var3 = (o95) t95Var.a.get(r95.ANALYTICS_STORAGE);
                if (o95Var3 == null) {
                    o95Var3 = o95Var2;
                }
                if (o95Var3 == o95Var2) {
                    t65 t65Var = ((k85) this.f).Y;
                    k85.h(t65Var);
                    t65Var.E0.a("Ignoring empty consent settings");
                    return;
                }
            }
        }
        synchronized (this.B0) {
            try {
                z2 = false;
                if (t95.l(i, this.I0.b)) {
                    t95 t95Var3 = this.I0;
                    EnumMap enumMap = t95Var.a;
                    r95[] r95VarArr = (r95[]) enumMap.keySet().toArray(new r95[0]);
                    int length = r95VarArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z3 = false;
                            break;
                        }
                        r95 r95Var = r95VarArr[i2];
                        o95 o95Var4 = (o95) enumMap.get(r95Var);
                        o95 o95Var5 = (o95) t95Var3.a.get(r95Var);
                        o95 o95Var6 = o95.DENIED;
                        if (o95Var4 == o95Var6 && o95Var5 != o95Var6) {
                            z3 = true;
                            break;
                        }
                        i2++;
                    }
                    r95 r95Var2 = r95.ANALYTICS_STORAGE;
                    if (t95Var.i(r95Var2) && !this.I0.i(r95Var2)) {
                        z2 = true;
                    }
                    t95Var = t95Var.k(this.I0);
                    this.I0 = t95Var;
                    z4 = z2;
                    z2 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                t95Var2 = t95Var;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            t65 t65Var2 = ((k85) this.f).Y;
            k85.h(t65Var2);
            t65Var2.F0.b(t95Var2, "Ignoring lower-priority consent settings, proposed settings");
            return;
        }
        long andIncrement = this.J0.getAndIncrement();
        if (z3) {
            this.A0.set(null);
            wa5 wa5Var = new wa5(this, t95Var2, andIncrement, z4, 0);
            if (z) {
                V0();
                wa5Var.run();
                return;
            } else {
                f85 f85Var = ((k85) this.f).Z;
                k85.h(f85Var);
                f85Var.g1(wa5Var);
                return;
            }
        }
        wa5 wa5Var2 = new wa5(this, t95Var2, andIncrement, z4, 1);
        if (z) {
            V0();
            wa5Var2.run();
        } else if (i == 30 || i == -10) {
            f85 f85Var2 = ((k85) this.f).Z;
            k85.h(f85Var2);
            f85Var2.g1(wa5Var2);
        } else {
            f85 f85Var3 = ((k85) this.f).Z;
            k85.h(f85Var3);
            f85Var3.e1(wa5Var2);
        }
    }

    public final void s1() {
        mg5.a();
        k85 k85Var = (k85) this.f;
        x15 x15Var = k85Var.A;
        f85 f85Var = k85Var.Z;
        t65 t65Var = k85Var.Y;
        if (x15Var.f1(null, r55.R0)) {
            k85.h(f85Var);
            if (f85Var.b1()) {
                k85.h(t65Var);
                t65Var.z0.a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (d84.j()) {
                k85.h(t65Var);
                t65Var.z0.a("Cannot get trigger URIs from main thread");
                return;
            }
            W0();
            k85.h(t65Var);
            t65Var.H0.a("Getting trigger URIs (FE)");
            AtomicReference atomicReference = new AtomicReference();
            k85.h(f85Var);
            f85Var.f1(atomicReference, 10000L, "get trigger URIs", new sa5(this, atomicReference, 2));
            final List list = (List) atomicReference.get();
            if (list == null) {
                k85.h(t65Var);
                t65Var.B0.a("Timed out waiting for get trigger URIs");
            } else {
                k85.h(f85Var);
                f85Var.e1(new Runnable() { // from class: db5
                    @Override // java.lang.Runnable
                    public final void run() {
                        ib5 ib5Var = this.b;
                        ib5Var.V0();
                        if (Build.VERSION.SDK_INT < 30) {
                            return;
                        }
                        l75 l75Var = ((k85) ib5Var.f).X;
                        k85.f(l75Var);
                        SparseArray sparseArrayB1 = l75Var.b1();
                        for (ee5 ee5Var : list) {
                            int i = ee5Var.z;
                            if (!sparseArrayB1.contains(i) || ((Long) sparseArrayB1.get(i)).longValue() < ee5Var.f) {
                                ib5Var.t1().add(ee5Var);
                            }
                        }
                        ib5Var.u1();
                    }
                });
            }
        }
    }

    public final PriorityQueue t1() {
        PriorityQueue priorityQueue = this.G0;
        if (priorityQueue != null) {
            return priorityQueue;
        }
        PriorityQueue priorityQueue2 = new PriorityQueue(Comparator.CC.comparing(eb5.a, e1.f));
        this.G0 = priorityQueue2;
        return priorityQueue2;
    }

    public final void u1() {
        ee5 ee5Var;
        V0();
        int i = 0;
        this.H0 = false;
        if (t1().isEmpty() || this.C0 || (ee5Var = (ee5) t1().poll()) == null) {
            return;
        }
        k85 k85Var = (k85) this.f;
        qf5 qf5Var = k85Var.z0;
        k85.f(qf5Var);
        nj2 nj2VarQ1 = qf5Var.q1();
        if (nj2VarQ1 != null) {
            this.C0 = true;
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            q65 q65Var = t65Var.H0;
            String str = ee5Var.b;
            q65Var.b(str, "Registering trigger URI");
            nc2 nc2VarE = nj2VarQ1.e(Uri.parse(str));
            if (nc2VarE != null) {
                nc2VarE.a(new tm1(i, nc2VarE, new ca5(this, ee5Var)), new d22(this));
            } else {
                this.C0 = false;
                t1().add(ee5Var);
            }
        }
    }
}
