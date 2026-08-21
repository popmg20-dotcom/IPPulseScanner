package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class jj4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        try {
            return Integer.valueOf(r62Var.nextInt());
        } catch (NumberFormatException e) {
            throw new l52(e);
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        if (((Number) obj) == null) {
            v72Var.C();
        } else {
            v72Var.U(r4.intValue());
        }
    }
}
