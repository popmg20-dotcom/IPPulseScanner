package defpackage;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class i12 {
    public static final Charset a = Charset.forName("UTF-8");
    public static final Charset b = Charset.forName("ISO-8859-1");
    public static final byte[] c;

    static {
        byte[] bArr = new byte[0];
        c = bArr;
        ByteBuffer.wrap(bArr);
        m60.d(bArr, 0, 0, false);
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(long j) {
        return (int) (j ^ (j >>> 32));
    }
}
