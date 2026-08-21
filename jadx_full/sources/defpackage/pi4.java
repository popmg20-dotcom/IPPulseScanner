package defpackage;

import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class pi4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        String strQ = r62Var.q();
        try {
            return fx3.z(strQ);
        } catch (NumberFormatException e) {
            StringBuilder sbD = fw.D("Failed parsing '", strQ, "' as BigDecimal; at path ");
            sbD.append(r62Var.x(true));
            throw new l52(sbD.toString(), e);
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        v72Var.X((BigDecimal) obj);
    }
}
