package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import defpackage.d44;
import defpackage.dw2;
import defpackage.hc3;
import defpackage.s64;
import defpackage.t64;
import defpackage.tj4;
import defpackage.v64;
import defpackage.w64;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ExtraSupportedSurfaceCombinationsQuirk implements hc3 {
    public static final s64 a;
    public static final s64 b;
    public static final HashSet c;
    public static final HashSet d;

    static {
        s64 s64Var = new s64();
        t64 t64Var = t64.VGA;
        d44 d44Var = w64.e;
        t64Var.getClass();
        d44 d44Var2 = w64.e;
        v64 v64Var = v64.f;
        s64Var.a(tj4.r(v64Var, t64Var, d44Var2));
        t64 t64Var2 = t64.PREVIEW;
        t64Var2.getClass();
        v64 v64Var2 = v64.b;
        s64Var.a(tj4.r(v64Var2, t64Var2, d44Var2));
        t64 t64Var3 = t64.MAXIMUM;
        t64Var3.getClass();
        s64Var.a(tj4.r(v64Var, t64Var3, d44Var2));
        a = s64Var;
        s64 s64Var2 = new s64();
        dw2.E(s64Var2, tj4.r(v64Var2, t64Var2, d44Var2), v64Var2, t64Var, d44Var2);
        s64Var2.a(tj4.r(v64Var, t64Var3, d44Var2));
        b = s64Var2;
        c = new HashSet(Arrays.asList("PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO", "PIXEL 9", "PIXEL 9 PRO", "PIXEL 9 PRO XL", "PIXEL 9 PRO FOLD"));
        d = new HashSet(Arrays.asList("SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26", "SM-S931", "SM-S936", "SM-S937", "SM-S938", "SCG31", "SCG32", "SC-51F", "SC-52F"));
    }

    public static boolean b() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String upperCase = Build.MODEL.toUpperCase(Locale.US);
        Iterator it = d.iterator();
        while (it.hasNext()) {
            if (upperCase.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
