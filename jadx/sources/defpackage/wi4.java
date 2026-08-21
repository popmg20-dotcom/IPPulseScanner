package defpackage;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class wi4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        if (r62Var.X() == 9) {
            r62Var.N();
            return null;
        }
        try {
            String strQ = r62Var.q();
            if (strQ.equals("null")) {
                return null;
            }
            return new URI(strQ);
        } catch (URISyntaxException e) {
            throw new l52(e);
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        URI uri = (URI) obj;
        v72Var.Z(uri == null ? null : uri.toASCIIString());
    }
}
