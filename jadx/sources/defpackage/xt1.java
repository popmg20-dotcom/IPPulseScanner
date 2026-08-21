package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xt1 {
    public static final bu a;
    public static final String[] b;
    public static final String[] c;
    public static final String[] d;

    static {
        bu buVar = bu.A;
        a = t60.n("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        c = new String[64];
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            binaryString.getClass();
            String strReplace = jz4.d("%8s", binaryString).replace(' ', '0');
            strReplace.getClass();
            strArr[i] = strReplace;
        }
        d = strArr;
        String[] strArr2 = c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = fw.y(new StringBuilder(), strArr2[i2], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = c;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + '|' + strArr3[i4];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i5]);
            sb.append('|');
            strArr3[i6 | 8] = fw.y(sb, strArr3[i4], "|PADDED");
        }
        int length = c.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = c;
            if (strArr4[i7] == null) {
                strArr4[i7] = d[i7];
            }
        }
    }

    public static String a(int i) {
        String[] strArr = b;
        return i < strArr.length ? strArr[i] : jz4.d("0x%02x", Integer.valueOf(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(int r9, int r10, int r11, boolean r12, int r13) {
        /*
            java.lang.String r0 = a(r11)
            r1 = 1
            r2 = 5
            r3 = 3
            r4 = 2
            r5 = 4
            if (r13 != 0) goto Le
            java.lang.String r11 = ""
            goto L57
        Le:
            java.lang.String[] r6 = defpackage.xt1.d
            if (r11 == r4) goto L55
            if (r11 == r3) goto L55
            if (r11 == r5) goto L4d
            r7 = 6
            if (r11 == r7) goto L4d
            r7 = 7
            if (r11 == r7) goto L55
            r7 = 8
            if (r11 == r7) goto L55
            java.lang.String[] r7 = defpackage.xt1.c
            int r8 = r7.length
            if (r13 >= r8) goto L2b
            r6 = r7[r13]
            r6.getClass()
            goto L2d
        L2b:
            r6 = r6[r13]
        L2d:
            if (r11 != r2) goto L3c
            r7 = r13 & 4
            if (r7 == 0) goto L3c
            java.lang.String r11 = "HEADERS"
            java.lang.String r13 = "PUSH_PROMISE"
            java.lang.String r11 = defpackage.w44.i0(r6, r11, r13)
            goto L57
        L3c:
            if (r11 != 0) goto L4b
            r11 = r13 & 32
            if (r11 == 0) goto L4b
            java.lang.String r11 = "PRIORITY"
            java.lang.String r13 = "COMPRESSED"
            java.lang.String r11 = defpackage.w44.i0(r6, r11, r13)
            goto L57
        L4b:
            r11 = r6
            goto L57
        L4d:
            if (r13 != r1) goto L52
            java.lang.String r11 = "ACK"
            goto L57
        L52:
            r11 = r6[r13]
            goto L57
        L55:
            r11 = r6[r13]
        L57:
            if (r12 == 0) goto L5c
            java.lang.String r12 = "<<"
            goto L5e
        L5c:
            java.lang.String r12 = ">>"
        L5e:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.Object[] r13 = new java.lang.Object[r2]
            r2 = 0
            r13[r2] = r12
            r13[r1] = r9
            r13[r4] = r10
            r13[r3] = r0
            r13[r5] = r11
            java.lang.String r9 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r9 = defpackage.jz4.d(r9, r13)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xt1.b(int, int, int, boolean, int):java.lang.String");
    }

    public static String c(int i, int i2, long j, boolean z) {
        return jz4.d("%s 0x%08x %5d %-13s %d", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), a(8), Long.valueOf(j));
    }
}
