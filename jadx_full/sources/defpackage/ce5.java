package defpackage;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ce5 {
    public static final bi3 a;

    static {
        cz1 cz1Var = ez1.A;
        Object[] objArr = new Object[24];
        objArr[0] = "Version";
        objArr[1] = "GoogleConsent";
        objArr[2] = "VendorConsent";
        objArr[3] = "VendorLegitimateInterest";
        objArr[4] = "gdprApplies";
        objArr[5] = "EnableAdvertiserConsentMode";
        objArr[6] = "PolicyVersion";
        objArr[7] = "PurposeConsents";
        objArr[8] = "PurposeOneTreatment";
        objArr[9] = "Purpose1";
        objArr[10] = "Purpose3";
        objArr[11] = "Purpose4";
        System.arraycopy(new String[]{"Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics"}, 0, objArr, 12, 12);
        for (int i = 0; i < 24; i++) {
            if (objArr[i] == null) {
                zo2.n(dw2.A(i, "at index "));
                return;
            }
        }
        a = new bi3(24, objArr);
    }

    public static String a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static final boolean b(ta5 ta5Var, gi3 gi3Var, gi3 gi3Var2, tx3 tx3Var, char[] cArr, int i, int i2, int i3, String str, String str2, String str3, boolean z, boolean z2) {
        be5 be5Var;
        char c;
        int iC = c(ta5Var);
        if (iC > 0 && (i2 != 1 || i != 1)) {
            cArr[iC] = '2';
        }
        if (g(ta5Var, gi3Var2) == ua5.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c = '3';
        } else {
            if (ta5Var == ta5.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE && i3 == 1 && tx3Var.Y.equals(str)) {
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = '1';
                }
                return true;
            }
            if (gi3Var.containsKey(ta5Var) && (be5Var = (be5) gi3Var.get(ta5Var)) != null) {
                int iOrdinal = be5Var.ordinal();
                ua5 ua5Var = ua5.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                if (iOrdinal != 0) {
                    ua5 ua5Var2 = ua5.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return g(ta5Var, gi3Var2) == ua5Var ? f(ta5Var, cArr, str3, z2) : e(ta5Var, cArr, str2, z);
                        }
                        if (iOrdinal == 3) {
                            return g(ta5Var, gi3Var2) == ua5Var2 ? e(ta5Var, cArr, str2, z) : f(ta5Var, cArr, str3, z2);
                        }
                        c = '0';
                    } else if (g(ta5Var, gi3Var2) != ua5Var2) {
                        return f(ta5Var, cArr, str3, z2);
                    }
                } else if (g(ta5Var, gi3Var2) != ua5Var) {
                    return e(ta5Var, cArr, str2, z);
                }
                c = '8';
            } else {
                c = '0';
            }
        }
        if (iC <= 0 || cArr[iC] == '2') {
            return false;
        }
        cArr[iC] = c;
        return false;
    }

    public static final int c(ta5 ta5Var) {
        if (ta5Var == ta5.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (ta5Var == ta5.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (ta5Var == ta5.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return ta5Var == ta5.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    public static final String d(ta5 ta5Var, String str, String str2) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str) || str.length() < ta5Var.a()) ? "0" : String.valueOf(str.charAt(ta5Var.a() - 1));
        if (!TextUtils.isEmpty(str2) && str2.length() >= ta5Var.a()) {
            strValueOf = String.valueOf(str2.charAt(ta5Var.a() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    public static final boolean e(ta5 ta5Var, char[] cArr, String str, boolean z) {
        char c;
        int iC = c(ta5Var);
        if (!z) {
            c = '4';
        } else {
            if (str.length() >= ta5Var.a()) {
                char cCharAt = str.charAt(ta5Var.a() - 1);
                boolean z2 = cCharAt == '1';
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = cCharAt != '1' ? '6' : '1';
                }
                return z2;
            }
            c = '0';
        }
        if (iC > 0 && cArr[iC] != '2') {
            cArr[iC] = c;
        }
        return false;
    }

    public static final boolean f(ta5 ta5Var, char[] cArr, String str, boolean z) {
        char c;
        int iC = c(ta5Var);
        if (!z) {
            c = '5';
        } else {
            if (str.length() >= ta5Var.a()) {
                char cCharAt = str.charAt(ta5Var.a() - 1);
                boolean z2 = cCharAt == '1';
                if (iC > 0 && cArr[iC] != '2') {
                    cArr[iC] = cCharAt != '1' ? '7' : '1';
                }
                return z2;
            }
            c = '0';
        }
        if (iC > 0 && cArr[iC] != '2') {
            cArr[iC] = c;
        }
        return false;
    }

    public static final ua5 g(ta5 ta5Var, gi3 gi3Var) {
        Object obj = gi3Var.get(ta5Var);
        if (obj == null) {
            obj = ua5.PURPOSE_RESTRICTION_UNDEFINED;
        }
        return (ua5) obj;
    }
}
