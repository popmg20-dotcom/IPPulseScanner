package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class d42 extends sk3 implements Function2 {
    public int A;
    public /* synthetic */ Object X;
    public final /* synthetic */ e42 Y;
    public gs2 f;
    public h40 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d42(e42 e42Var, ge0 ge0Var) {
        super(ge0Var);
        this.Y = e42Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((d42) n((ge0) obj2, (ts3) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        d42 d42Var = new d42(this.Y, ge0Var);
        d42Var.X = obj;
        return d42Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005f -> B:25:0x0071). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.A
            r1 = 2
            r2 = 1
            mf0 r3 = defpackage.mf0.b
            if (r0 == 0) goto L23
            if (r0 == r2) goto L1f
            if (r0 != r1) goto L18
            h40 r0 = r5.z
            gs2 r2 = r5.f
            java.lang.Object r4 = r5.X
            ts3 r4 = (defpackage.ts3) r4
            defpackage.n12.S(r6)
            goto L71
        L18:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            r5 = 0
            return r5
        L1f:
            defpackage.n12.S(r6)
            goto L76
        L23:
            defpackage.n12.S(r6)
            java.lang.Object r6 = r5.X
            ts3 r6 = (defpackage.ts3) r6
            e42 r0 = r5.Y
            java.lang.Object r0 = r0.H()
            boolean r4 = r0 instanceof defpackage.h40
            if (r4 == 0) goto L3e
            h40 r0 = (defpackage.h40) r0
            e42 r0 = r0.X
            r5.A = r2
            r6.b(r0, r5)
            return r3
        L3e:
            boolean r2 = r0 instanceof defpackage.oz1
            if (r2 == 0) goto L76
            oz1 r0 = (defpackage.oz1) r0
            gs2 r0 = r0.b()
            if (r0 == 0) goto L76
            java.lang.Object r2 = r0.g()
            r2.getClass()
            xd2 r2 = (defpackage.xd2) r2
            r4 = r2
            r2 = r0
            r0 = r4
            r4 = r6
        L57:
            boolean r6 = r0.equals(r2)
            if (r6 != 0) goto L76
            boolean r6 = r0 instanceof defpackage.h40
            if (r6 == 0) goto L71
            h40 r0 = (defpackage.h40) r0
            e42 r6 = r0.X
            r5.X = r4
            r5.f = r2
            r5.z = r0
            r5.A = r1
            r4.b(r6, r5)
            return r3
        L71:
            xd2 r0 = r0.h()
            goto L57
        L76:
            xl4 r5 = defpackage.xl4.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d42.p(java.lang.Object):java.lang.Object");
    }
}
