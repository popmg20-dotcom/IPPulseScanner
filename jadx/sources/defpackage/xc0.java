package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xc0 extends tc0 {
    @Override // defpackage.rc0
    public final Object b(ds2 ds2Var) {
        String strSubstring = ((pp3) ds2Var).e;
        if (".inf".equals(strSubstring)) {
            return Double.valueOf(Double.POSITIVE_INFINITY);
        }
        if ("-.inf".equals(strSubstring)) {
            return Double.valueOf(Double.NEGATIVE_INFINITY);
        }
        if (".nan".equals(strSubstring)) {
            return Double.valueOf(Double.NaN);
        }
        char cCharAt = strSubstring.charAt(0);
        int i = 1;
        if (cCharAt == '-') {
            strSubstring = strSubstring.substring(1);
            i = -1;
        } else if (cCharAt == '+') {
            strSubstring = strSubstring.substring(1);
        }
        return Double.valueOf(Double.valueOf(strSubstring).doubleValue() * ((double) i));
    }
}
