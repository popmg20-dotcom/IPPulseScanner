package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gi3 extends gz1 {
    public static final gi3 Z = new gi3(null, new Object[0], 0);
    public final transient Object A;
    public final transient Object[] X;
    public final transient int Y;

    public gi3(Object obj, Object[] objArr, int i) {
        this.A = obj;
        this.X = objArr;
        this.Y = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0199  */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.gi3 a(int r19, java.lang.Object[] r20, defpackage.qt r21) {
        /*
            Method dump skipped, instruction units count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gi3.a(int, java.lang.Object[], qt):gi3");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0037->B:22:0x004d], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0062->B:32:0x0079], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0088->B:43:0x00a0]] */
    @Override // defpackage.gz1, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L6
        L3:
            r7 = r0
            goto L9c
        L6:
            java.lang.Object[] r1 = r7.X
            int r2 = r7.Y
            r3 = 1
            if (r2 != r3) goto L20
            r7 = 0
            r7 = r1[r7]
            j$.util.Objects.requireNonNull(r7)
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L3
            r7 = r1[r3]
            j$.util.Objects.requireNonNull(r7)
            goto L9c
        L20:
            java.lang.Object r7 = r7.A
            if (r7 != 0) goto L25
            goto L3
        L25:
            boolean r2 = r7 instanceof byte[]
            if (r2 == 0) goto L50
            r2 = r7
            byte[] r2 = (byte[]) r2
            int r7 = r2.length
            int r4 = r7 + (-1)
            int r7 = r8.hashCode()
            int r7 = defpackage.r25.P(r7)
        L37:
            r7 = r7 & r4
            r5 = r2[r7]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            if (r5 != r6) goto L40
            goto L3
        L40:
            r6 = r1[r5]
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L4d
            r7 = r5 ^ 1
            r7 = r1[r7]
            goto L9c
        L4d:
            int r7 = r7 + 1
            goto L37
        L50:
            boolean r2 = r7 instanceof short[]
            if (r2 == 0) goto L7c
            r2 = r7
            short[] r2 = (short[]) r2
            int r7 = r2.length
            int r4 = r7 + (-1)
            int r7 = r8.hashCode()
            int r7 = defpackage.r25.P(r7)
        L62:
            r7 = r7 & r4
            short r5 = r2[r7]
            r6 = 65535(0xffff, float:9.1834E-41)
            r5 = r5 & r6
            if (r5 != r6) goto L6c
            goto L3
        L6c:
            r6 = r1[r5]
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L79
            r7 = r5 ^ 1
            r7 = r1[r7]
            goto L9c
        L79:
            int r7 = r7 + 1
            goto L62
        L7c:
            int[] r7 = (int[]) r7
            int r2 = r7.length
            int r2 = r2 - r3
            int r4 = r8.hashCode()
            int r4 = defpackage.r25.P(r4)
        L88:
            r4 = r4 & r2
            r5 = r7[r4]
            r6 = -1
            if (r5 != r6) goto L90
            goto L3
        L90:
            r6 = r1[r5]
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto La0
            r7 = r5 ^ 1
            r7 = r1[r7]
        L9c:
            if (r7 != 0) goto L9f
            return r0
        L9f:
            return r7
        La0:
            int r4 = r4 + 1
            goto L88
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gi3.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public final int size() {
        return this.Y;
    }
}
