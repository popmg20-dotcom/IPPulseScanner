package defpackage;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yc0 extends tc0 {
    @Override // defpackage.rc0
    public final Object b(ds2 ds2Var) {
        String str = ((pp3) ds2Var).e;
        try {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return new BigInteger(str);
            }
        } catch (NumberFormatException unused2) {
            return Long.valueOf(str);
        }
    }
}
