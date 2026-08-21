package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class uv extends b30 {
    public final Function2 A;
    public final Function2 X;

    public uv(Function2 function2, cf0 cf0Var, int i, jp jpVar) {
        super(cf0Var, i, jpVar);
        this.A = function2;
        this.X = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.b30
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(defpackage.q53 r6, defpackage.ge0 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof defpackage.tv
            if (r0 == 0) goto L13
            r0 = r7
            tv r0 = (defpackage.tv) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L1a
        L13:
            tv r0 = new tv
            ie0 r7 = (defpackage.ie0) r7
            r0.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r0.X
            int r1 = r0.Z
            r2 = 0
            xl4 r3 = defpackage.xl4.a
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 != r4) goto L2c
            q53 r6 = r0.A
            defpackage.n12.S(r7)
            goto L48
        L2c:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            return r2
        L32:
            defpackage.n12.S(r7)
            r0.A = r6
            r0.Z = r4
            kotlin.jvm.functions.Function2 r5 = r5.A
            java.lang.Object r5 = r5.k(r6, r0)
            mf0 r7 = defpackage.mf0.b
            if (r5 != r7) goto L44
            goto L45
        L44:
            r5 = r3
        L45:
            if (r5 != r7) goto L48
            return r7
        L48:
            xp r5 = r6.A
            boolean r5 = r5.y()
            if (r5 == 0) goto L51
            return r3
        L51:
            java.lang.String r5 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            defpackage.xe.q(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uv.d(q53, ge0):java.lang.Object");
    }

    @Override // defpackage.b30
    public final b30 e(cf0 cf0Var, int i, jp jpVar) {
        return new uv(this.X, cf0Var, i, jpVar);
    }

    @Override // defpackage.b30
    public final String toString() {
        return "block[" + this.A + "] -> " + super.toString();
    }
}
