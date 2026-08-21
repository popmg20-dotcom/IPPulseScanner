package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cz4 {
    public float a;
    public final float b;
    public final float c;
    public float d;

    public cz4(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public final float a() {
        return this.d;
    }

    public final float b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = r6.b
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            float r3 = r6.c
            if (r2 > 0) goto L29
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r4 < 0) goto L29
            r6.a = r0
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto L17
        L15:
            r0 = r5
            goto L26
        L17:
            if (r2 != 0) goto L1a
            goto L26
        L1a:
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 != 0) goto L1f
            goto L15
        L1f:
            float r1 = r0 / r1
            float r2 = r0 / r3
            float r0 = r0 - r2
            float r1 = r1 - r2
            float r0 = r0 / r1
        L26:
            r6.d = r0
            return
        L29:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Requested zoomRatio 1.0 is not within valid range ["
            r6.<init>(r0)
            r6.append(r3)
            java.lang.String r0 = " , "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r0 = "]"
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cz4.e():void");
    }
}
