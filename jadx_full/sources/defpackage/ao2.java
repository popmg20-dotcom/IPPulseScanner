package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ao2 {
    public static final int[] a;
    public static final int[] b;

    static {
        if (a != null) {
            return;
        }
        int[] iArr = new int[2048];
        b = iArr;
        a = new int[2048];
        Arrays.fill(iArr, 0);
        Arrays.fill(a, 0);
        for (int i = 0; i <= 65535; i++) {
            char c = (char) i;
            if (Character.isJavaIdentifierPart(c)) {
                int[] iArr2 = b;
                int i2 = i / 32;
                iArr2[i2] = iArr2[i2] | (1 << (i % 32));
            }
            if (Character.isJavaIdentifierStart(c)) {
                int[] iArr3 = a;
                int i3 = i / 32;
                iArr3[i3] = (1 << (i % 32)) | iArr3[i3];
            }
        }
    }

    public static boolean a(int[] iArr, int i) {
        return (iArr[i / 32] & (1 << (i % 32))) != 0;
    }
}
