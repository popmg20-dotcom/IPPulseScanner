package defpackage;

import java.io.IOException;
import java.util.Currency;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class zi4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        String strQ = r62Var.q();
        try {
            return Currency.getInstance(strQ);
        } catch (IllegalArgumentException e) {
            StringBuilder sbD = fw.D("Failed parsing '", strQ, "' as Currency; at path ");
            sbD.append(r62Var.x(true));
            throw new l52(sbD.toString(), e);
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        v72Var.Z(((Currency) obj).getCurrencyCode());
    }
}
