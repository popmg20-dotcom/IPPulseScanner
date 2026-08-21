package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c30 extends b30 {
    public final zf1 A;

    public c30(int i, jp jpVar, cf0 cf0Var, zf1 zf1Var) {
        super(cf0Var, i, jpVar);
        this.A = zf1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    @Override // defpackage.b30, defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.ag1 r6, defpackage.ge0 r7) {
        /*
            r5 = this;
            int r0 = r5.f
            r1 = -3
            mf0 r2 = defpackage.mf0.b
            if (r0 != r1) goto L6d
            cf0 r0 = r7.j()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            dt r3 = new dt
            r4 = 3
            r3.<init>(r4)
            cf0 r4 = r5.b
            java.lang.Object r1 = r4.c0(r1, r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L26
            cf0 r1 = r0.X(r4)
            goto L2b
        L26:
            r1 = 0
            cf0 r1 = defpackage.co4.p(r0, r4, r1)
        L2b:
            boolean r3 = defpackage.n12.c(r1, r0)
            if (r3 == 0) goto L38
            java.lang.Object r5 = r5.h(r6, r7)
            if (r5 != r2) goto L74
            return r5
        L38:
            pr1 r3 = defpackage.pr1.f
            af0 r4 = r1.Z(r3)
            af0 r0 = r0.Z(r3)
            boolean r0 = defpackage.n12.c(r4, r0)
            if (r0 == 0) goto L6d
            cf0 r0 = r7.j()
            boolean r3 = r6 instanceof defpackage.rs3
            if (r3 != 0) goto L5b
            boolean r3 = r6 instanceof defpackage.os2
            if (r3 == 0) goto L55
            goto L5b
        L55:
            eg1 r3 = new eg1
            r3.<init>(r6, r0)
            r6 = r3
        L5b:
            hj r0 = new hj
            r3 = 0
            r4 = 6
            r0.<init>(r5, r3, r4)
            java.lang.Object r5 = defpackage.nd4.b(r1)
            java.lang.Object r5 = defpackage.l72.b0(r1, r6, r5, r0, r7)
            if (r5 != r2) goto L74
            return r5
        L6d:
            java.lang.Object r5 = super.a(r6, r7)
            if (r5 != r2) goto L74
            return r5
        L74:
            xl4 r5 = defpackage.xl4.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c30.a(ag1, ge0):java.lang.Object");
    }

    @Override // defpackage.b30
    public final Object d(q53 q53Var, ge0 ge0Var) {
        Object objH = h(new rs3(q53Var), ge0Var);
        return objH == mf0.b ? objH : xl4.a;
    }

    public abstract Object h(ag1 ag1Var, ge0 ge0Var);

    @Override // defpackage.b30
    public final String toString() {
        return this.A + " -> " + super.toString();
    }
}
