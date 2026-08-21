package io.netty.util.internal.shaded.org.jctools.util;

import defpackage.dw2;
import defpackage.ha0;
import defpackage.xe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static long align(long j, int i) {
        if (isPowerOfTwo(i)) {
            int i2 = i - 1;
            return (j + ((long) i2)) & ((long) (~i2));
        }
        xe.k(dw2.A(i, "alignment must be a power of 2:"));
        return 0L;
    }

    public static boolean isPowerOfTwo(int i) {
        return (i & (i + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i) {
        if (i > 1073741824) {
            xe.k(ha0.k("There is no larger power of 2 int for value:", i, " since it exceeds 2^31."));
            return 0;
        }
        if (i >= 0) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        }
        xe.k(ha0.k("Given value:", i, ". Expecting value >= 0."));
        return 0;
    }
}
