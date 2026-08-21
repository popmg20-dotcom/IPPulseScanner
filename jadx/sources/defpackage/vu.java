package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vu implements ag1 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ ag1 f;
    public final /* synthetic */ zg3 z;

    public vu(ag1 ag1Var, zg3 zg3Var) {
        this.f = ag1Var;
        this.z = zg3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(defpackage.tz1 r5, defpackage.ge0 r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof defpackage.uu
            if (r0 == 0) goto L13
            r0 = r6
            uu r0 = (defpackage.uu) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            uu r0 = new uu
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.X
            int r1 = r0.Z
            zg3 r2 = r4.z
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 != r3) goto L29
            tz1 r5 = r0.A
            defpackage.n12.S(r6)
            goto L4d
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            r4 = 0
            return r4
        L30:
            defpackage.n12.S(r6)
            r5.getClass()
            int r6 = r5.a
            int r1 = r2.b
            if (r6 <= r1) goto L51
            java.lang.Object r6 = r5.b
            r0.A = r5
            r0.Z = r3
            ag1 r4 = r4.f
            java.lang.Object r4 = r4.h(r6, r0)
            mf0 r6 = defpackage.mf0.b
            if (r4 != r6) goto L4d
            return r6
        L4d:
            int r4 = r5.a
            r2.b = r4
        L51:
            xl4 r4 = defpackage.xl4.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vu.a(tz1, ge0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.Object r6, defpackage.ge0 r7) {
        /*
            r5 = this;
            int r0 = r5.b
            switch(r0) {
                case 0: goto L5c;
                default: goto L5;
            }
        L5:
            boolean r0 = r7 instanceof defpackage.mh1
            if (r0 == 0) goto L18
            r0 = r7
            mh1 r0 = (defpackage.mh1) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.Y = r1
            goto L1d
        L18:
            mh1 r0 = new mh1
            r0.<init>(r5, r7)
        L1d:
            java.lang.Object r7 = r0.A
            int r1 = r0.Y
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L2a
            defpackage.n12.S(r7)
            goto L51
        L2a:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            r5 = 0
            goto L53
        L31:
            defpackage.n12.S(r7)
            tz1 r7 = new tz1
            zg3 r1 = r5.z
            int r3 = r1.b
            int r4 = r3 + 1
            r1.b = r4
            if (r3 < 0) goto L54
            r7.<init>(r3, r6)
            r0.Y = r2
            ag1 r5 = r5.f
            java.lang.Object r5 = r5.h(r7, r0)
            mf0 r6 = defpackage.mf0.b
            if (r5 != r6) goto L51
            r5 = r6
            goto L53
        L51:
            xl4 r5 = defpackage.xl4.a
        L53:
            return r5
        L54:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "Index overflow has happened"
            r5.<init>(r6)
            throw r5
        L5c:
            tz1 r6 = (defpackage.tz1) r6
            java.lang.Object r5 = r5.a(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vu.h(java.lang.Object, ge0):java.lang.Object");
    }

    public vu(zg3 zg3Var, ag1 ag1Var) {
        this.z = zg3Var;
        this.f = ag1Var;
    }
}
