package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class it2 extends hi4 {
    public static final ht2 b = new ht2(new it2(2), 0);
    public final int a;

    public it2(int i) {
        this.a = i;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        int iX = r62Var.X();
        int iG = fw.G(iX);
        if (iG == 5 || iG == 6) {
            return dw2.t(this.a, r62Var);
        }
        if (iG == 8) {
            r62Var.N();
            return null;
        }
        throw new l52("Expecting number, got: " + ha0.B(iX) + "; at path " + r62Var.x(false));
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        v72Var.X((Number) obj);
    }
}
