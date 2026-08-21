package defpackage;

import android.util.Base64;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xj {
    public static final uh3 a = new uh3("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$");

    public static final String a(int i, String str) {
        str.getClass();
        try {
            byte[] bArrDecode = Base64.decode(str, i);
            bArrDecode.getClass();
            return new String(bArrDecode, y30.a);
        } catch (IllegalArgumentException e) {
            st4.l("origin: ".concat(str), e);
            return null;
        }
    }

    public static final boolean c(String str) {
        str.getClass();
        if (str.length() == 0) {
            return false;
        }
        return a.d(str);
    }
}
