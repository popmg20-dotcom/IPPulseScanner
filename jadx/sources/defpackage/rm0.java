package defpackage;

import android.view.ViewGroup;
import androidx.fragment.app.g;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rm0 extends r82 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ ViewGroup X;
    public final /* synthetic */ int f = 0;
    public final /* synthetic */ g z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm0(g gVar, Object obj, ViewGroup viewGroup) {
        super(0);
        this.z = gVar;
        this.A = obj;
        this.X = viewGroup;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    @Override // defpackage.pl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a() {
        /*
            r9 = this;
            int r0 = r9.f
            xl4 r1 = defpackage.xl4.a
            android.view.ViewGroup r2 = r9.X
            java.lang.Object r3 = r9.A
            androidx.fragment.app.g r9 = r9.z
            switch(r0) {
                case 0: goto L75;
                default: goto Ld;
            }
        Ld:
            java.util.ArrayList r0 = r9.c
            uk1 r4 = r9.f
            boolean r5 = r0.isEmpty()
            java.lang.String r6 = "FragmentManager"
            r7 = 2
            if (r5 == 0) goto L1b
            goto L5a
        L1b:
            java.util.Iterator r5 = r0.iterator()
        L1f:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L5a
            java.lang.Object r8 = r5.next()
            tm0 r8 = (defpackage.tm0) r8
            androidx.fragment.app.a0 r8 = r8.a
            boolean r8 = r8.g
            if (r8 != 0) goto L1f
            boolean r2 = androidx.fragment.app.u.M(r7)
            if (r2 == 0) goto L3c
            java.lang.String r2 = "Completing animating immediately"
            android.util.Log.v(r6, r2)
        L3c:
            b10 r2 = new b10
            r2.<init>()
            r5 = 0
            java.lang.Object r0 = r0.get(r5)
            tm0 r0 = (defpackage.tm0) r0
            androidx.fragment.app.a0 r0 = r0.a
            androidx.fragment.app.o r0 = r0.c
            d4 r5 = new d4
            r6 = 18
            r5.<init>(r6, r9)
            r4.u(r0, r3, r2, r5)
            r2.a()
            goto L74
        L5a:
            boolean r0 = androidx.fragment.app.u.M(r7)
            if (r0 == 0) goto L65
            java.lang.String r0 = "Animating to start"
            android.util.Log.v(r6, r0)
        L65:
            java.lang.Object r0 = r9.q
            r0.getClass()
            s7 r3 = new s7
            r5 = 24
            r3.<init>(r5, r9, r2)
            r4.d(r0, r3)
        L74:
            return r1
        L75:
            uk1 r9 = r9.f
            r9.e(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rm0.a():java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm0(g gVar, ViewGroup viewGroup, Object obj) {
        super(0);
        this.z = gVar;
        this.X = viewGroup;
        this.A = obj;
    }
}
