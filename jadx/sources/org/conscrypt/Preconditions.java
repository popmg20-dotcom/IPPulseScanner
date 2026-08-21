package org.conscrypt;

import defpackage.dw2;
import defpackage.s53;
import defpackage.xe;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
final class Preconditions {
    private Preconditions() {
    }

    private static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return str + " (" + i + ") must not be negative";
        }
        if (i2 < 0) {
            xe.k(dw2.A(i2, "negative size: "));
            return null;
        }
        return str + " (" + i + ") must not be greater than size (" + i2 + ")";
    }

    private static String badPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return badPositionIndex(i, i3, "start index");
        }
        if (i2 < 0 || i2 > i3) {
            return badPositionIndex(i2, i3, "end index");
        }
        return "end index (" + i2 + ") must not be less than start index (" + i + ")";
    }

    public static void checkArgument(boolean z, String str, Object obj) {
        if (z) {
            return;
        }
        zo2.p(str, new Object[]{obj});
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        zo2.n(str);
        return null;
    }

    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            s53.k(badPositionIndexes(i, i2, i3));
        }
    }

    public static void checkArgument(boolean z, String str) {
        if (z) {
            return;
        }
        xe.k(str);
    }
}
