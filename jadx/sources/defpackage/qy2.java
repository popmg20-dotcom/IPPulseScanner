package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qy2 extends v74 implements em1 {
    public yn2 A0;
    public int B0;
    public int X;
    public /* synthetic */ ag1 Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ az2 y0;
    public final /* synthetic */ hd2 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qy2(ge0 ge0Var, az2 az2Var, hd2 hd2Var) {
        super(3, ge0Var);
        this.y0 = az2Var;
        this.z0 = hd2Var;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        qy2 qy2Var = new qy2((ge0) obj3, this.y0, this.z0);
        qy2Var.Y = (ag1) obj;
        qy2Var.Z = obj2;
        return qy2Var.p(xl4.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        if (defpackage.r25.v(r9, r0, r11) == r6) goto L34;
     */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r12) {
        /*
            r11 = this;
            hd2 r0 = r11.z0
            int r1 = r11.X
            az2 r2 = r11.y0
            r3 = 2
            r4 = 1
            r5 = 0
            mf0 r6 = defpackage.mf0.b
            if (r1 == 0) goto L2a
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L16
            defpackage.n12.S(r12)
            goto Lc0
        L16:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r11)
            return r5
        L1c:
            int r1 = r11.B0
            yn2 r7 = r11.A0
            java.lang.Object r8 = r11.Z
            bz2 r8 = (defpackage.bz2) r8
            ag1 r9 = r11.Y
            defpackage.n12.S(r12)
            goto L4d
        L2a:
            defpackage.n12.S(r12)
            ag1 r9 = r11.Y
            java.lang.Object r12 = r11.Z
            java.lang.Number r12 = (java.lang.Number) r12
            int r1 = r12.intValue()
            bz2 r8 = r2.h
            yn2 r7 = r8.a
            r11.Y = r9
            r11.Z = r8
            r11.A0 = r7
            r11.B0 = r1
            r11.X = r4
            java.lang.Object r12 = r7.g(r11)
            if (r12 != r6) goto L4d
            goto Lbf
        L4d:
            dz2 r12 = r8.b     // Catch: java.lang.Throwable -> L6a
            n02 r12 = r12.j     // Catch: java.lang.Throwable -> L6a
            fd2 r8 = r12.k(r0)     // Catch: java.lang.Throwable -> L6a
            ed2 r10 = defpackage.ed2.b     // Catch: java.lang.Throwable -> L6a
            boolean r8 = r8.equals(r10)     // Catch: java.lang.Throwable -> L6a
            r10 = 0
            if (r8 == 0) goto L6c
            do1[] r12 = new defpackage.do1[r10]     // Catch: java.lang.Throwable -> L6a
            av r0 = new av     // Catch: java.lang.Throwable -> L6a
            r1 = 5
            r0.<init>(r1, r12)     // Catch: java.lang.Throwable -> L6a
            r7.n(r5)
            goto Lb1
        L6a:
            r11 = move-exception
            goto Lc3
        L6c:
            fd2 r8 = r12.k(r0)     // Catch: java.lang.Throwable -> L6a
            boolean r8 = r8 instanceof defpackage.cd2     // Catch: java.lang.Throwable -> L6a
            if (r8 != 0) goto L79
            ed2 r8 = defpackage.ed2.c     // Catch: java.lang.Throwable -> L6a
            r12.N(r0, r8)     // Catch: java.lang.Throwable -> L6a
        L79:
            r7.n(r5)
            wn1 r12 = r2.e
            java.lang.Object r12 = r12.f
            iv1 r12 = (defpackage.iv1) r12
            int r0 = r0.ordinal()
            if (r0 == r4) goto L9a
            if (r0 != r3) goto L93
            java.lang.Object r12 = r12.z
            eg0 r12 = (defpackage.eg0) r12
            java.lang.Object r12 = r12.z
            hv3 r12 = (defpackage.hv3) r12
            goto La2
        L93:
            java.lang.String r12 = "invalid load type for hints"
            defpackage.xe.k(r12)
            r12 = r5
            goto La2
        L9a:
            java.lang.Object r12 = r12.f
            eg0 r12 = (defpackage.eg0) r12
            java.lang.Object r12 = r12.z
            hv3 r12 = (defpackage.hv3) r12
        La2:
            if (r1 != 0) goto La6
            r0 = r10
            goto La7
        La6:
            r0 = r4
        La7:
            ug1 r2 = new ug1
            r2.<init>(r12, r0, r10)
            ug1 r0 = new ug1
            r0.<init>(r2, r1, r4)
        Lb1:
            r11.Y = r5
            r11.Z = r5
            r11.A0 = r5
            r11.X = r3
            java.lang.Object r11 = defpackage.r25.v(r9, r0, r11)
            if (r11 != r6) goto Lc0
        Lbf:
            return r6
        Lc0:
            xl4 r11 = defpackage.xl4.a
            return r11
        Lc3:
            r7.n(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qy2.p(java.lang.Object):java.lang.Object");
    }
}
