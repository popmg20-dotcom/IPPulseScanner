package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wi0 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ lj0 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wi0(lj0 lj0Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = lj0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((wi0) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 1:
                return ((wi0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((wi0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        lj0 lj0Var = this.Z;
        switch (i) {
            case 0:
                return new wi0(lj0Var, ge0Var, 0);
            case 1:
                return new wi0(lj0Var, ge0Var, 1);
            default:
                return new wi0(lj0Var, ge0Var, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r10 == r6) goto L22;
     */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            int r0 = r9.X
            xl4 r1 = defpackage.xl4.a
            r2 = -1
            r3 = 2
            r4 = 0
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            mf0 r6 = defpackage.mf0.b
            lj0 r7 = r9.Z
            r8 = 1
            switch(r0) {
                case 0: goto L9c;
                case 1: goto L57;
                default: goto L11;
            }
        L11:
            w7 r0 = r7.y0
            int r1 = r9.Y
            if (r1 == 0) goto L29
            if (r1 == r8) goto L23
            if (r1 != r3) goto L1f
            defpackage.n12.S(r10)
            goto L4d
        L1f:
            defpackage.xe.q(r5)
            goto L56
        L23:
            defpackage.n12.S(r10)     // Catch: java.lang.Throwable -> L27
            goto L42
        L27:
            r9 = move-exception
            goto L51
        L29:
            defpackage.n12.S(r10)
            j24 r10 = r0.s()
            boolean r10 = r10 instanceof defpackage.qe1
            if (r10 == 0) goto L39
            j24 r4 = r0.s()
            goto L56
        L39:
            r9.Y = r8     // Catch: java.lang.Throwable -> L27
            java.lang.Object r10 = r7.f(r9)     // Catch: java.lang.Throwable -> L27
            if (r10 != r6) goto L42
            goto L4b
        L42:
            r9.Y = r3
            r10 = 0
            java.lang.Object r10 = r7.g(r10, r9)
            if (r10 != r6) goto L4d
        L4b:
            r4 = r6
            goto L56
        L4d:
            r4 = r10
            j24 r4 = (defpackage.j24) r4
            goto L56
        L51:
            wd3 r4 = new wd3
            r4.<init>(r9, r2)
        L56:
            return r4
        L57:
            int r0 = r9.Y
            if (r0 == 0) goto L6c
            if (r0 == r8) goto L68
            if (r0 != r3) goto L63
            defpackage.n12.S(r10)
            goto L9b
        L63:
            defpackage.xe.q(r5)
            r1 = r4
            goto L9b
        L68:
            defpackage.n12.S(r10)
            goto L82
        L6c:
            defpackage.n12.S(r10)
            iv1 r10 = r7.z0
            r9.Y = r8
            java.lang.Object r10 = r10.z
            o80 r10 = (defpackage.o80) r10
            java.lang.Object r10 = r10.j0(r9)
            if (r10 != r6) goto L7e
            goto L7f
        L7e:
            r10 = r1
        L7f:
            if (r10 != r6) goto L82
            goto L9a
        L82:
            nx3 r10 = r7.c()
            av r10 = r10.c
            zf1 r10 = defpackage.p95.b(r10, r2)
            xu r0 = new xu
            r2 = 4
            r0.<init>(r2, r7)
            r9.Y = r3
            java.lang.Object r9 = r10.a(r0, r9)
            if (r9 != r6) goto L9b
        L9a:
            r1 = r6
        L9b:
            return r1
        L9c:
            int r0 = r9.Y
            if (r0 == 0) goto Lab
            if (r0 != r8) goto La6
            defpackage.n12.S(r10)
            goto Lb7
        La6:
            defpackage.xe.q(r5)
            r1 = r4
            goto Lb7
        Lab:
            defpackage.n12.S(r10)
            r9.Y = r8
            java.lang.Object r9 = r7.e(r9)
            if (r9 != r6) goto Lb7
            r1 = r6
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wi0.p(java.lang.Object):java.lang.Object");
    }
}
