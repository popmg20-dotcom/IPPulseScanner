package defpackage;

import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ol4 {
    public static final du a;

    static {
        try {
            DataInputStream dataInputStreamQ = je.Q("CaseFold");
            int i = dataInputStreamQ.readInt();
            du duVar = new du(i, 3);
            for (int i2 = 0; i2 < i; i2++) {
                duVar.i(dataInputStreamQ.readInt(), new sl4(dataInputStreamQ));
            }
            dataInputStreamQ.close();
            a = duVar;
        } catch (IOException e) {
            vp1.p(e);
        }
    }
}
