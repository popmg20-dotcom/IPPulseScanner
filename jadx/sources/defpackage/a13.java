package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class a13 implements lz3 {
    public int A;
    public boolean X;
    public long Y;
    public final cq b;
    public final hp f;
    public rr3 z;

    public a13(cq cqVar) {
        this.b = cqVar;
        hp hpVarH = cqVar.h();
        this.f = hpVarH;
        rr3 rr3Var = hpVarH.b;
        this.z = rr3Var;
        this.A = rr3Var != null ? rr3Var.b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.X = true;
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.b.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r3 == r5.b) goto L15;
     */
    @Override // defpackage.lz3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long t0(defpackage.hp r9, long r10) {
        /*
            r8 = this;
            r9.getClass()
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L65
            boolean r3 = r8.X
            if (r3 != 0) goto L5f
            rr3 r3 = r8.z
            hp r4 = r8.f
            if (r3 == 0) goto L27
            rr3 r5 = r4.b
            if (r3 != r5) goto L21
            int r3 = r8.A
            r5.getClass()
            int r5 = r5.b
            if (r3 != r5) goto L21
            goto L27
        L21:
            java.lang.String r8 = "Peek source is invalid because upstream source was used"
            defpackage.xe.q(r8)
            return r0
        L27:
            if (r2 != 0) goto L2a
            return r0
        L2a:
            long r0 = r8.Y
            r2 = 1
            long r0 = r0 + r2
            cq r2 = r8.b
            boolean r0 = r2.request(r0)
            if (r0 != 0) goto L3a
            r8 = -1
            return r8
        L3a:
            rr3 r0 = r8.z
            if (r0 != 0) goto L48
            rr3 r0 = r4.b
            if (r0 == 0) goto L48
            r8.z = r0
            int r0 = r0.b
            r8.A = r0
        L48:
            long r0 = r4.f
            long r2 = r8.Y
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            hp r2 = r8.f
            long r4 = r8.Y
            r3 = r9
            r2.n(r3, r4, r6)
            long r9 = r8.Y
            long r9 = r9 + r6
            r8.Y = r9
            return r6
        L5f:
            java.lang.String r8 = "closed"
            defpackage.xe.q(r8)
            return r0
        L65:
            java.lang.String r8 = "byteCount < 0: "
            java.lang.String r8 = defpackage.ha0.j(r10, r8)
            defpackage.e04.f(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a13.t0(hp, long):long");
    }
}
