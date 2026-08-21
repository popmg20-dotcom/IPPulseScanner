package defpackage;

import android.net.Uri;
import android.util.Base64;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bd1 extends k44 implements sw0 {
    public final String G0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd1(String str, pk3 pk3Var) {
        super(ez4.S(str), pk3Var, pk3Var);
        str.getClass();
        this.A0 = new fm0(((Number) nj3.b.a()).intValue(), 1);
        this.G0 = Uri.parse(str).getUserInfo();
    }

    @Override // defpackage.aj3
    public final Map e() {
        HashMap map = new HashMap();
        map.put("User-Agent", ye.A());
        String strW = ye.w();
        if (strW != null) {
            map.put("Locale", strW);
        }
        String str = this.G0;
        if (str != null) {
            uh3 uh3Var = xj.a;
            byte[] bytes = str.getBytes(y30.a);
            bytes.getClass();
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            strEncodeToString.getClass();
            map.put("Authorization", "Basic ".concat(strEncodeToString));
        }
        return map;
    }
}
