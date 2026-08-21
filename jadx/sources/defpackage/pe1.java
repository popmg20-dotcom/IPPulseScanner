package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class pe1 {
    public static final uj0 a = new uj0(2);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0171 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0177  */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v26 */
    /* JADX WARN: Type inference failed for: r17v27 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.vm1 a(java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, java.lang.String r39, defpackage.wm1 r40) {
        /*
            Method dump skipped, instruction units count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pe1.a(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, wm1):vm1");
    }

    public static final vm1 b(int i, String str, String str2, String str3, String str4) {
        char cCharAt;
        char cCharAt2;
        str2.getClass();
        str4.getClass();
        wm1 wm1Var = wm1.b;
        vm1 vm1VarA = a(str, str2, i, str3, str4, wm1Var);
        if (str.length() >= 3) {
            int length = str.length() - 1;
            if (7 <= length) {
                length = 7;
            }
            int i2 = i + 1;
            while (i2 < length) {
                int i3 = i2 + 1;
                String str5 = null;
                if (i3 < str.length() && (cCharAt = str.charAt(i2)) != (cCharAt2 = str.charAt(i3))) {
                    str5 = p44.T0(i2, str) + cCharAt2 + cCharAt + str.substring(i2 + 2);
                }
                String str6 = str5;
                if (str6 != null) {
                    String lowerCase = str6.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    vm1 vm1VarA2 = a(str6, lowerCase, i, str3, str4, wm1Var);
                    if (vm1VarA2 != null) {
                        int i4 = vm1VarA2.a - 3;
                        vm1VarA2.a = i4;
                        if (vm1VarA == null || i4 > vm1VarA.a) {
                            vm1VarA = vm1VarA2;
                        }
                    }
                }
                i2 = i3;
            }
        }
        return vm1VarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x004d A[FALL_THROUGH, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(int r2, java.lang.String r3) {
        /*
            r3.getClass()
            r0 = 0
            if (r2 < 0) goto L4e
            int r1 = r3.length()
            if (r2 < r1) goto Ld
            goto L4e
        Ld:
            int r2 = r3.codePointAt(r2)
            r3 = 32
            r1 = 1
            if (r2 == r3) goto L4d
            r3 = 34
            if (r2 == r3) goto L4d
            r3 = 36
            if (r2 == r3) goto L4d
            r3 = 58
            if (r2 == r3) goto L4d
            r3 = 60
            if (r2 == r3) goto L4d
            r3 = 62
            if (r2 == r3) goto L4d
            r3 = 95
            if (r2 == r3) goto L4d
            r3 = 123(0x7b, float:1.72E-43)
            if (r2 == r3) goto L4d
            r3 = 125(0x7d, float:1.75E-43)
            if (r2 == r3) goto L4d
            switch(r2) {
                case 39: goto L4d;
                case 40: goto L4d;
                case 41: goto L4d;
                default: goto L39;
            }
        L39:
            switch(r2) {
                case 45: goto L4d;
                case 46: goto L4d;
                case 47: goto L4d;
                default: goto L3c;
            }
        L3c:
            switch(r2) {
                case 91: goto L4d;
                case 92: goto L4d;
                case 93: goto L4d;
                default: goto L3f;
            }
        L3f:
            int[] r3 = defpackage.ao2.a
            r3 = 126976(0x1f000, float:1.77931E-40)
            if (r2 < r3) goto L4c
            r3 = 129791(0x1faff, float:1.81876E-40)
            if (r2 > r3) goto L4c
            return r1
        L4c:
            return r0
        L4d:
            return r1
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pe1.c(int, java.lang.String):boolean");
    }

    public static final boolean d(String str, int i, String str2) {
        str2.getClass();
        return str.charAt(i) != str2.charAt(i);
    }
}
