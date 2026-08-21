package defpackage;

import android.content.ClipData;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b83 extends v74 implements Function2 {
    public int X;
    public final /* synthetic */ d83 Y;
    public final /* synthetic */ ClipData Z;
    public final /* synthetic */ int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b83(d83 d83Var, ClipData clipData, int i, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = d83Var;
        this.Z = clipData;
        this.y0 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((b83) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new b83(this.Y, this.Z, this.y0, ge0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r11) {
        /*
            r10 = this;
            int r0 = r10.X
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L12
            if (r0 != r2) goto Lc
            defpackage.n12.S(r11)
            goto L6b
        Lc:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r10)
            return r1
        L12:
            defpackage.n12.S(r11)
            d83 r11 = r10.Y
            r92 r3 = r11.getLifecycle()
            gm0 r0 = defpackage.qv0.a
            tq1 r0 = defpackage.qf2.a
            tq1 r6 = r0.X
            cf0 r0 = r10.f
            r0.getClass()
            boolean r5 = r6.q0(r0)
            android.content.ClipData r0 = r10.Z
            int r4 = r10.y0
            r7 = r4
            q92 r4 = defpackage.q92.X
            if (r5 != 0) goto L54
            q92 r8 = r3.b()
            q92 r9 = defpackage.q92.b
            if (r8 == r9) goto L56
            q92 r1 = r3.b()
            int r1 = r1.compareTo(r4)
            if (r1 < 0) goto L54
            android.content.ClipData$Item r10 = r0.getItemAt(r7)
            android.net.Uri r10 = r10.getUri()
            r10.getClass()
            r11.j(r10)
            goto L6b
        L54:
            r1 = r7
            goto L5a
        L56:
            defpackage.vp1.m()
            return r1
        L5a:
            a83 r7 = new a83
            r7.<init>(r11, r0, r1)
            r10.X = r2
            r8 = r10
            java.lang.Object r10 = defpackage.ji0.V(r3, r4, r5, r6, r7, r8)
            mf0 r11 = defpackage.mf0.b
            if (r10 != r11) goto L6b
            return r11
        L6b:
            xl4 r10 = defpackage.xl4.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b83.p(java.lang.Object):java.lang.Object");
    }
}
