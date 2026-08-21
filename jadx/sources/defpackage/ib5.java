package defpackage;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import j$.util.Comparator;
import j$.util.Objects;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a1(java.lang.String r13, java.lang.String r14, android.os.Bundle r15, boolean r16, boolean r17, long r18) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ib5.a1(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e1(java.lang.String r30, java.lang.String r31, long r32, android.os.Bundle r34, boolean r35, boolean r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 1375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ib5.e1(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f1(java.lang.String r12, java.lang.String r13, java.lang.Object r14, boolean r15, long r16) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ib5.f1(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g1(long r14, java.lang.Object r16, java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ib5.g1(long, java.lang.Object, java.lang.String, java.lang.String):void");
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
