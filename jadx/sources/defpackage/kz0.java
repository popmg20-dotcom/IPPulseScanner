package defpackage;

import android.os.Build;
import com.getsurfboard.R;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class kz0 {
    public static final int[] a = {R.attr.dynamicColorThemeOverlay};
    public static final Map b;
    public static final Map c;

    static {
        hz0 hz0Var = new hz0();
        iz0 iz0Var = new iz0();
        HashMap map = new HashMap();
        map.put("fcnt", hz0Var);
        map.put("google", hz0Var);
        map.put("hmd global", hz0Var);
        map.put("infinix", hz0Var);
        map.put("infinix mobility limited", hz0Var);
        map.put("itel", hz0Var);
        map.put("kyocera", hz0Var);
        map.put("lenovo", hz0Var);
        map.put("lge", hz0Var);
        map.put("meizu", hz0Var);
        map.put("motorola", hz0Var);
        map.put("nothing", hz0Var);
        map.put("oneplus", hz0Var);
        map.put("oppo", hz0Var);
        map.put("realme", hz0Var);
        map.put("robolectric", hz0Var);
        map.put("samsung", iz0Var);
        map.put("sharp", hz0Var);
        map.put("shift", hz0Var);
        map.put("sony", hz0Var);
        map.put("tcl", hz0Var);
        map.put("tecno", hz0Var);
        map.put("tecno mobile limited", hz0Var);
        map.put("vivo", hz0Var);
        map.put("wingtech", hz0Var);
        map.put("xiaomi", hz0Var);
        b = DesugarCollections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", hz0Var);
        map2.put("jio", hz0Var);
        c = DesugarCollections.unmodifiableMap(map2);
    }

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            int i2 = eq.a;
            if (i >= 33) {
                return true;
            }
            if (i >= 32) {
                String str = Build.VERSION.CODENAME;
                str.getClass();
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = str.toUpperCase(locale);
                    upperCase.getClass();
                    Integer num = upperCase.equals("BAKLAVA") ? num : null;
                    String upperCase2 = "Tiramisu".toUpperCase(locale);
                    upperCase2.getClass();
                    num = upperCase2.equals("BAKLAVA") ? 0 : null;
                    if (num == null || num == null) {
                        if (num == null && num == null) {
                            String upperCase3 = str.toUpperCase(locale);
                            upperCase3.getClass();
                            String upperCase4 = "Tiramisu".toUpperCase(locale);
                            upperCase4.getClass();
                            if (upperCase3.compareTo(upperCase4) >= 0) {
                                return true;
                            }
                        } else if (num != null) {
                            return true;
                        }
                    } else if (num.intValue() >= num.intValue()) {
                        return true;
                    }
                }
            }
            String str2 = Build.MANUFACTURER;
            Locale locale2 = Locale.ROOT;
            jz0 jz0Var = (jz0) b.get(str2.toLowerCase(locale2));
            if (jz0Var == null) {
                jz0Var = (jz0) c.get(Build.BRAND.toLowerCase(locale2));
            }
            if (jz0Var != null && jz0Var.g()) {
                return true;
            }
        }
        return false;
    }
}
