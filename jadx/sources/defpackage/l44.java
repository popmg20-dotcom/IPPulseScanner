package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l44 {
    public static final Pattern a = Pattern.compile(".*/|\\..*");

    public static int a(int i, String str, boolean z) {
        int i2;
        if (z) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < str.length()) {
                if (i4 == i) {
                    return i3;
                }
                if (Character.isHighSurrogate(str.charAt(i3)) && (i2 = i3 + 1) < str.length() && Character.isLowSurrogate(str.charAt(i2))) {
                    i3 = i2;
                }
                i4++;
                i3++;
            }
        }
        return i;
    }
}
