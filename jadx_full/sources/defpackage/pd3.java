package defpackage;

import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class pd3 {
    public static final pr1 a = new pr1();

    public static od3 a(pv1 pv1Var) throws IOException {
        od3 od3Var;
        ov1 ov1Var = (ov1) pv1Var;
        ov1Var.getClass();
        StringReader stringReader = new StringReader(ov1Var.a.toString());
        try {
            int iG = fw.G(((ov1) pv1Var).c);
            pr1 pr1Var = a;
            if (iG == 0) {
                od3Var = (od3) u94.a.c(stringReader, pr1Var);
            } else if (iG != 1) {
                y94.b.getClass();
                od3Var = (od3) y94.a(stringReader, pr1Var);
            } else {
                od3Var = (od3) aa4.c.c(stringReader, pr1Var);
            }
            stringReader.close();
            return od3Var;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
