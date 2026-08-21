package defpackage;

import android.net.Uri;
import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class pu1 {
    public static final n84 a = new n84(new t4(7));

    public static final cm2 a(String str) {
        String strS = ez4.S(str);
        v92 v92Var = new v92(15);
        v92Var.w(strS);
        v92Var.l("User-Agent", ye.A());
        String strW = ye.w();
        if (strW != null) {
            v92Var.l("Locale", strW);
        }
        String userInfo = Uri.parse(str).getUserInfo();
        if (userInfo != null) {
            uh3 uh3Var = xj.a;
            byte[] bytes = userInfo.getBytes(y30.a);
            bytes.getClass();
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            strEncodeToString.getClass();
            v92Var.l("Authorization", "Basic ".concat(strEncodeToString));
        }
        return new cm2(v92Var);
    }
}
