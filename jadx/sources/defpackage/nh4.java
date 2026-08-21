package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nh4 implements ag1 {
    public final /* synthetic */ String[] A;
    public final /* synthetic */ int[] X;
    public final /* synthetic */ bh3 b;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ ag1 z;

    public nh4(bh3 bh3Var, boolean z, ag1 ag1Var, String[] strArr, int[] iArr) {
        this.b = bh3Var;
        this.f = z;
        this.z = ag1Var;
        this.A = strArr;
        this.X = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r9.h(r2, r3) == r10) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        if (r9.h(r2, r3) == r10) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ab, code lost:
    
        return r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // defpackage.ag1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(int[] r18, defpackage.ge0 r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof defpackage.mh4
            if (r3 == 0) goto L19
            r3 = r2
            mh4 r3 = (defpackage.mh4) r3
            int r4 = r3.y0
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.y0 = r4
            goto L1e
        L19:
            mh4 r3 = new mh4
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.Y
            int r4 = r3.y0
            r5 = 0
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L40
            if (r4 == r7) goto L32
            if (r4 != r6) goto L2c
            goto L32
        L2c:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r0)
            return r5
        L32:
            int[] r0 = r3.X
            nh4 r1 = r3.A
            defpackage.n12.S(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto Lac
        L40:
            defpackage.n12.S(r2)
            bh3 r2 = r0.b
            java.lang.Object r4 = r2.b
            java.lang.String[] r8 = r0.A
            ag1 r9 = r0.z
            mf0 r10 = defpackage.mf0.b
            if (r4 != 0) goto L64
            boolean r2 = r0.f
            if (r2 == 0) goto Lac
            java.util.Set r2 = defpackage.qe.t0(r8)
            r3.A = r0
            r3.X = r1
            r3.y0 = r7
            java.lang.Object r2 = r9.h(r2, r3)
            if (r2 != r10) goto Lac
            goto Lab
        L64:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r7 = r8.length
            r11 = 0
            r12 = r11
        L6c:
            if (r11 >= r7) goto L95
            r13 = r8[r11]
            int r14 = r12 + 1
            java.lang.Object r15 = r2.b
            if (r15 == 0) goto L8d
            int[] r15 = (int[]) r15
            r19 = r5
            int[] r5 = r0.X
            r5 = r5[r12]
            r12 = r15[r5]
            r5 = r1[r5]
            if (r12 == r5) goto L87
            r4.add(r13)
        L87:
            int r11 = r11 + 1
            r5 = r19
            r12 = r14
            goto L6c
        L8d:
            r19 = r5
            java.lang.String r0 = "Required value was null."
            defpackage.xe.q(r0)
            return r19
        L95:
            boolean r2 = r4.isEmpty()
            if (r2 != 0) goto Lac
            java.util.Set r2 = defpackage.d70.C0(r4)
            r3.A = r0
            r3.X = r1
            r3.y0 = r6
            java.lang.Object r2 = r9.h(r2, r3)
            if (r2 != r10) goto Lac
        Lab:
            return r10
        Lac:
            bh3 r0 = r0.b
            r0.b = r1
            xl4 r0 = defpackage.xl4.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nh4.h(int[], ge0):java.lang.Object");
    }
}
