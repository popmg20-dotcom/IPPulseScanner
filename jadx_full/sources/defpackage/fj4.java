package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class fj4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        int iX = r62Var.X();
        if (iX != 9) {
            return iX == 6 ? Boolean.valueOf(Boolean.parseBoolean(r62Var.q())) : Boolean.valueOf(r62Var.I());
        }
        r62Var.N();
        return null;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            v72Var.C();
            return;
        }
        v72Var.i0();
        v72Var.g();
        v72Var.b.write(bool.booleanValue() ? "true" : "false");
    }
}
