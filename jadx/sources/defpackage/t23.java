package defpackage;

import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import androidx.preference.Preference;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class t23 {
    public static final String[] a;
    public static final String[] b;
    public static final String[] c;
    public static final on2 d;
    public static final n84 e;

    static {
        String[] stringArray = ContextUtilsKt.getContext().getResources().getStringArray(R.array.setting_traffic_statistics_entry_values);
        stringArray.getClass();
        a = stringArray;
        String[] stringArray2 = ContextUtilsKt.getContext().getResources().getStringArray(R.array.setting_override_lan_share_listen_entry_values);
        stringArray2.getClass();
        b = stringArray2;
        String[] stringArray3 = ContextUtilsKt.getContext().getResources().getStringArray(R.array.setting_tls_fingerprint_entry_values);
        stringArray3.getClass();
        c = stringArray3;
        d = new on2((xw2) xw2.X.get(l().getInt("proxy_outbound_mode", 0)));
        e = new n84(new t4(16));
    }

    public static final void A(ih0 ih0Var) {
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.putString("dark_mode", ih0Var.name());
        editorEdit.apply();
    }

    public static final void B(mb3 mb3Var) {
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.putInt("proxy_list_sort", mb3Var.ordinal());
        editorEdit.apply();
    }

    public static final void C(boolean z) {
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.putBoolean("quick_tile_added", z);
        editorEdit.apply();
    }

    public static final void D(boolean z) {
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.putBoolean("using_white_list_mode", z);
        editorEdit.apply();
    }

    public static final boolean E() {
        String strK = ContextUtilsKt.k(R.string.setting_traffic_statistics_key);
        String[] strArr = a;
        String strO = o(strK, strArr[0]);
        strO.getClass();
        return strO.equals(strArr[0]);
    }

    public static final void F(String str) {
        str.getClass();
        SharedPreferences.Editor editorEdit = l().edit();
        HashSet hashSet = new HashSet(k());
        hashSet.remove(str);
        editorEdit.putStringSet("pinned_profile_list", hashSet);
        editorEdit.apply();
    }

    public static final boolean G() {
        SharedPreferences sharedPreferencesL = l();
        String strK = ContextUtilsKt.k(R.string.setting_tls_fingerprint_key);
        String[] strArr = c;
        return n12.c(sharedPreferencesL.getString(strK, strArr[0]), strArr[1]);
    }

    public static final boolean H() {
        return d("using_white_list_mode", false);
    }

    public static final boolean a() {
        if (Build.VERSION.SDK_INT <= 25) {
            return false;
        }
        return c(R.string.setting_sshdump_key, false);
    }

    public static final boolean b() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        return c(R.string.setting_enable_vpn_http_proxy_key, false);
    }

    public static final boolean c(int i, boolean z) {
        return d(ContextUtilsKt.k(i), z);
    }

    public static final boolean d(String str, boolean z) {
        return l().getBoolean(str, z);
    }

    public static final HashSet e(boolean z) {
        Set<String> stringSet = l().getStringSet(z ? "white_list" : "black_list", new HashSet());
        stringSet.getClass();
        return new HashSet(stringSet);
    }

    public static final boolean f(p10 p10Var) {
        p10Var.getClass();
        String lowerCase = p10Var.name().toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return d(String.format("%s_card_display", Arrays.copyOf(new Object[]{lowerCase}, 1)), true);
    }

    public static final cd4 g() {
        String string = l().getString("color_palette_theme_key", "AUTO");
        string.getClass();
        return cd4.valueOf(string);
    }

    public static final int h() {
        String strO = o(ContextUtilsKt.k(R.string.setting_profile_fetch_timeout), "5000");
        Integer numM0 = w44.m0(strO != null ? strO : "5000");
        if (numM0 != null) {
            return numM0.intValue();
        }
        return 5000;
    }

    public static final boolean i() {
        return ((Boolean) e.getValue()).booleanValue();
    }

    public static final int j() {
        return l().getInt(ContextUtilsKt.k(R.string.setting_mtu_key), 32000);
    }

    public static final Set k() {
        Set<String> stringSet = l().getStringSet("pinned_profile_list", new HashSet());
        stringSet.getClass();
        return stringSet;
    }

    public static final SharedPreferences l() {
        Object value = gd0.a.getValue();
        value.getClass();
        return (SharedPreferences) value;
    }

    public static final v70 m() {
        return (v70) v70.X.get(l().getInt("proxy_column_size", 1));
    }

    public static final mb3 n() {
        return (mb3) mb3.X.get(l().getInt("proxy_list_sort", 0));
    }

    public static final String o(String str, String str2) {
        return l().getString(str, str2);
    }

    public static final View p(j33 j33Var, Preference preference) {
        rg3 rg3VarJ;
        j33Var.getClass();
        preference.getClass();
        if (j33Var.getListView().getAdapter() instanceof m33) {
            rf3 adapter = j33Var.getListView().getAdapter();
            adapter.getClass();
            int iT = ((m33) adapter).t(preference);
            if (iT != -1 && (rg3VarJ = j33Var.getListView().J(iT)) != null) {
                return rg3VarJ.a;
            }
        }
        return null;
    }

    public static final boolean q() {
        return d("bypass_list_enabled", true);
    }

    public static final List r() {
        String strK = ContextUtilsKt.k(R.string.setting_override_doh_v2_key);
        if (l().contains(strK)) {
            Set<String> stringSet = l().getStringSet(strK, null);
            if (stringSet != null) {
                return d70.y0(stringSet);
            }
            return null;
        }
        String strK2 = ContextUtilsKt.k(R.string.setting_override_doh_key);
        String string = l().getString(strK2, null);
        if (string == null || p44.x0(string)) {
            return null;
        }
        List listX = p95.x(p44.U0(string).toString());
        x(listX);
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.remove(strK2);
        editorEdit.apply();
        return listX;
    }

    public static final int s() {
        String strO = o(ContextUtilsKt.k(R.string.setting_override_lan_share_http_port_key), "1234");
        strO.getClass();
        return Integer.parseInt(strO);
    }

    public static final xv1 t() {
        String strO = o(ContextUtilsKt.k(R.string.setting_override_ipv6_key), "follow_profile");
        xv1.b.getClass();
        return n12.c(strO, "enable") ? xv1.z : n12.c(strO, "disable") ? xv1.A : xv1.f;
    }

    public static final String u() {
        return o(ContextUtilsKt.k(R.string.setting_override_lan_share_listen_key), b[0]);
    }

    public static final int v() {
        String strO = o(ContextUtilsKt.k(R.string.setting_override_lan_share_socks5_port_key), "1235");
        strO.getClass();
        return Integer.parseInt(strO);
    }

    public static final void w(boolean z, Set set) {
        set.getClass();
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.putStringSet(z ? "white_list" : "black_list", set);
        editorEdit.apply();
    }

    public static final void x(List list) {
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.putStringSet(ContextUtilsKt.k(R.string.setting_override_doh_v2_key), list != null ? d70.C0(list) : null);
        editorEdit.apply();
    }

    public static final void y(ot otVar) {
        otVar.getClass();
        SharedPreferences.Editor editorEdit = l().edit();
        editorEdit.putInt("bypass_list_sort_mode", otVar.ordinal());
        editorEdit.apply();
    }

    public static final void z(p10 p10Var, boolean z) {
        p10Var.getClass();
        SharedPreferences.Editor editorEdit = l().edit();
        String lowerCase = p10Var.name().toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        editorEdit.putBoolean(String.format("%s_card_display", Arrays.copyOf(new Object[]{lowerCase}, 1)), z);
        editorEdit.apply();
    }
}
