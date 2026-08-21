package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import defpackage.hc3;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ImageCaptureFailedForVideoSnapshotQuirk implements hc3 {
    public static final HashSet a = new HashSet(Arrays.asList("itel l6006", "itel w6004", "moto g(20)", "moto e13", "moto e20", "rmx3231", "rmx3511", "sm-a032f", "sm-a035m", "sm-f946u1", "tecno mobile bf6"));

    public static boolean b() {
        String str = Build.MODEL;
        Locale locale = Locale.US;
        if (a.contains(str.toLowerCase(locale))) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 31 && "Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER)) {
            return true;
        }
        String str2 = Build.HARDWARE;
        if (str2.toLowerCase(locale).startsWith("ums")) {
            return true;
        }
        String str3 = Build.BRAND;
        if ("itel".equalsIgnoreCase(str3) && str2.toLowerCase(locale).startsWith("sp")) {
            return true;
        }
        return "HUAWEI".equalsIgnoreCase(str3) && "FIG-LX1".equalsIgnoreCase(str);
    }
}
