package defpackage;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ct2 {
    public static final String a;

    static {
        String.valueOf(Long.MIN_VALUE).substring(1);
        a = String.valueOf(Long.MAX_VALUE);
        Pattern.compile("[+-]?[0-9]*[\\.]?[0-9]+([eE][+-]?[0-9]+)?");
        Pattern.compile("[+-]?[0-9]+[\\.]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0077, code lost:
    
        r10 = java.lang.Integer.parseInt(r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(String str) {
        int i;
        if (str.length() > 9) {
            return Long.parseLong(str);
        }
        char cCharAt = str.charAt(0);
        int length = str.length();
        int i2 = 1;
        boolean z = cCharAt == '-';
        if (z) {
            if (length == 1 || length > 10) {
                i = Integer.parseInt(str);
            } else {
                cCharAt = str.charAt(1);
                i2 = 2;
                if (cCharAt <= '9' || cCharAt < '0') {
                    i = Integer.parseInt(str);
                } else {
                    int i3 = cCharAt - '0';
                    if (i2 < length) {
                        int i4 = i2 + 1;
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 > '9' || cCharAt2 < '0') {
                            i = Integer.parseInt(str);
                        } else {
                            int i5 = (cCharAt2 - '0') + (i3 * 10);
                            if (i4 < length) {
                                int i6 = i2 + 2;
                                char cCharAt3 = str.charAt(i4);
                                if (cCharAt3 > '9' || cCharAt3 < '0') {
                                    i = Integer.parseInt(str);
                                } else {
                                    i3 = (cCharAt3 - '0') + (i5 * 10);
                                    if (i6 < length) {
                                        while (true) {
                                            int i7 = i6 + 1;
                                            char cCharAt4 = str.charAt(i6);
                                            if (cCharAt4 > '9' || cCharAt4 < '0') {
                                                break;
                                            }
                                            i3 = (i3 * 10) + (cCharAt4 - '0');
                                            if (i7 >= length) {
                                                break;
                                            }
                                            i6 = i7;
                                        }
                                    }
                                    i = i3;
                                    if (z) {
                                        i = -i;
                                    }
                                }
                            } else {
                                i = i5;
                                if (z) {
                                }
                            }
                        }
                    } else {
                        i = i3;
                        if (z) {
                        }
                    }
                }
            }
        } else if (length > 9) {
            i = Integer.parseInt(str);
        } else if (cCharAt <= '9') {
            i = Integer.parseInt(str);
        }
        return i;
    }
}
