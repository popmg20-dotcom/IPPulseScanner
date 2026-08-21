package defpackage;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class o20 {
    public static final int[] a;

    static {
        byte[] bytes = "expand 32-byte k".getBytes(StandardCharsets.US_ASCII);
        int[] iArr = new int[4];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < 4) {
            iArr[i2] = ((bytes[i3 + 1] & 255) << 8) | (bytes[i3] & 255) | ((bytes[i3 + 2] & 255) << 16) | ((bytes[i3 + 3] & 255) << 24);
            i3 += 4;
            i++;
            i2++;
        }
        a = iArr;
    }

    public o20() {
        System.arraycopy(a, 0, new int[16], 0, 4);
    }
}
