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
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a(java.lang.String r10) {
        /*
            int r0 = r10.length()
            r1 = 9
            if (r0 > r1) goto L92
            r0 = 0
            char r2 = r10.charAt(r0)
            int r3 = r10.length()
            r4 = 45
            r5 = 1
            if (r2 != r4) goto L17
            r0 = r5
        L17:
            r4 = 2
            r6 = 10
            if (r0 == 0) goto L2d
            if (r3 == r5) goto L27
            if (r3 <= r6) goto L21
            goto L27
        L21:
            char r2 = r10.charAt(r5)
            r5 = r4
            goto L35
        L27:
            int r10 = java.lang.Integer.parseInt(r10)
            goto L90
        L2d:
            if (r3 <= r1) goto L35
            int r10 = java.lang.Integer.parseInt(r10)
            goto L90
        L35:
            r1 = 57
            if (r2 > r1) goto L8c
            r7 = 48
            if (r2 >= r7) goto L3e
            goto L8c
        L3e:
            int r2 = r2 - r7
            if (r5 >= r3) goto L73
            int r8 = r5 + 1
            char r9 = r10.charAt(r5)
            if (r9 > r1) goto L83
            if (r9 >= r7) goto L4c
            goto L83
        L4c:
            int r2 = r2 * 10
            int r9 = r9 - r7
            int r9 = r9 + r2
            if (r8 >= r3) goto L81
            int r5 = r5 + r4
            char r2 = r10.charAt(r8)
            if (r2 > r1) goto L7c
            if (r2 >= r7) goto L5c
            goto L7c
        L5c:
            int r9 = r9 * 10
            int r2 = r2 - r7
            int r2 = r2 + r9
            if (r5 >= r3) goto L73
        L62:
            int r4 = r5 + 1
            char r5 = r10.charAt(r5)
            if (r5 > r1) goto L77
            if (r5 >= r7) goto L6d
            goto L77
        L6d:
            int r2 = r2 * r6
            int r5 = r5 + (-48)
            int r2 = r2 + r5
            if (r4 < r3) goto L75
        L73:
            r10 = r2
            goto L88
        L75:
            r5 = r4
            goto L62
        L77:
            int r10 = java.lang.Integer.parseInt(r10)
            goto L90
        L7c:
            int r10 = java.lang.Integer.parseInt(r10)
            goto L90
        L81:
            r10 = r9
            goto L88
        L83:
            int r10 = java.lang.Integer.parseInt(r10)
            goto L90
        L88:
            if (r0 == 0) goto L90
            int r10 = -r10
            goto L90
        L8c:
            int r10 = java.lang.Integer.parseInt(r10)
        L90:
            long r0 = (long) r10
            return r0
        L92:
            long r0 = java.lang.Long.parseLong(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ct2.a(java.lang.String):long");
    }
}
