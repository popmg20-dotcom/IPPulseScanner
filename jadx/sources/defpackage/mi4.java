package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class mi4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        if (r62Var.X() != 9) {
            return Double.valueOf(r62Var.nextDouble());
        }
        r62Var.N();
        return null;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            v72Var.C();
        } else {
            v72Var.Q(number.doubleValue());
        }
    }
}
