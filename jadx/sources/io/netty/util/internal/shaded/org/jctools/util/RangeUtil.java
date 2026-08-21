package io.netty.util.internal.shaded.org.jctools.util;

import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class RangeUtil {
    public static int checkGreaterThanOrEqual(int i, int i2, String str) {
        if (i >= i2) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: >= " + i2 + ')');
    }

    public static int checkLessThan(int i, int i2, String str) {
        if (i < i2) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: < " + i2 + ')');
    }

    public static int checkLessThanOrEqual(int i, long j, String str) {
        if (i <= j) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: <= " + j + ')');
    }

    public static long checkPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        zo2.l(str, ": ", j, " (expected: > 0)");
        return 0L;
    }

    public static int checkPositiveOrZero(int i, String str) {
        if (i >= 0) {
            return i;
        }
        zo2.h(i, str, ": ", " (expected: >= 0)");
        return 0;
    }
}
