package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gh2 implements Serializable {
    public final int A;
    public final int b;
    public final int f;
    public final int[] z;

    public gh2(int i, int i2, int[] iArr, int i3) {
        this.b = i;
        this.f = i2;
        this.z = iArr;
        this.A = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r6 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r12 = this;
            int r0 = r12.A
            r1 = r0
        L3:
            java.lang.String r2 = " ... "
            int[] r3 = r12.z
            r4 = 1108475904(0x42120000, float:36.5)
            java.lang.String r5 = ""
            if (r1 <= 0) goto L28
            int r6 = r1 + (-1)
            r6 = r3[r6]
            p30 r7 = defpackage.p30.c
            boolean r6 = r7.b(r6)
            if (r6 != 0) goto L28
            int r6 = r1 + (-1)
            int r7 = r0 - r6
            float r7 = (float) r7
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 <= 0) goto L26
            int r1 = r1 + 4
            r6 = r2
            goto L29
        L26:
            r1 = r6
            goto L3
        L28:
            r6 = r5
        L29:
            r7 = r0
        L2a:
            int r8 = r3.length
            if (r7 >= r8) goto L45
            r8 = r3[r7]
            p30 r9 = defpackage.p30.c
            boolean r8 = r9.b(r8)
            if (r8 != 0) goto L45
            int r8 = r7 + 1
            int r9 = r8 - r0
            float r9 = (float) r9
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 <= 0) goto L43
            int r7 = r7 + (-4)
            goto L46
        L43:
            r7 = r8
            goto L2a
        L45:
            r2 = r5
        L46:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 0
            r8 = r5
        L4d:
            r9 = 4
            java.lang.String r10 = " "
            if (r8 >= r9) goto L58
            r4.append(r10)
            int r8 = r8 + 1
            goto L4d
        L58:
            r4.append(r6)
            r8 = r1
        L5c:
            if (r8 >= r7) goto L66
            r11 = r3[r8]
            r4.appendCodePoint(r11)
            int r8 = r8 + 1
            goto L5c
        L66:
            r4.append(r2)
            java.lang.String r2 = "\n"
            r4.append(r2)
        L6e:
            int r2 = r9 + r0
            int r2 = r2 - r1
            int r3 = r6.length()
            int r3 = r3 + r2
            if (r5 >= r3) goto L7e
            r4.append(r10)
            int r5 = r5 + 1
            goto L6e
        L7e:
            java.lang.String r0 = "^"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            int r1 = r12.b
            int r1 = r1 + 1
            int r12 = r12.f
            int r12 = r12 + 1
            java.lang.String r2 = ", column "
            java.lang.String r3 = ":\n"
            java.lang.String r4 = " in reader, line "
            java.lang.StringBuilder r12 = defpackage.fw.A(r1, r12, r4, r2, r3)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gh2.toString():java.lang.String");
    }
}
