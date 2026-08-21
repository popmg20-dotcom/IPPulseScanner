package org.conscrypt;

import defpackage.fw;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
final class ArrayUtils {
    private ArrayUtils() {
    }

    public static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            StringBuilder sbA = fw.A(i, i2, "length=", "; regionStart=", "; regionLength=");
            sbA.append(i3);
            throw new ArrayIndexOutOfBoundsException(sbA.toString());
        }
    }
}
