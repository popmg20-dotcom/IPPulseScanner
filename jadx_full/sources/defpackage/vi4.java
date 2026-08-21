package defpackage;

import java.io.IOException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class vi4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        String strQ = r62Var.q();
        if (strQ.equals("null")) {
            return null;
        }
        return new URL(strQ);
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        URL url = (URL) obj;
        v72Var.Z(url == null ? null : url.toExternalForm());
    }
}
