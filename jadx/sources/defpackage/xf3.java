package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xf3 {
    public qf3 a;
    public ArrayList b;
    public long c;
    public long d;
    public long e;
    public long f;

    public static void b(rg3 rg3Var) {
        int i = rg3Var.j;
        if (!rg3Var.h() && (i & 4) == 0) {
            rg3Var.b();
        }
    }

    public abstract boolean a(rg3 rg3Var, rg3 rg3Var2, hm2 hm2Var, hm2 hm2Var2);

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.rg3 r10) {
        /*
            r9 = this;
            qf3 r9 = r9.a
            if (r9 == 0) goto Lb0
            androidx.recyclerview.widget.RecyclerView r9 = r9.b
            r0 = 1
            r10.p(r0)
            android.view.View r1 = r10.a
            rg3 r2 = r10.h
            r3 = 0
            if (r2 == 0) goto L17
            rg3 r2 = r10.i
            if (r2 != 0) goto L17
            r10.h = r3
        L17:
            r10.i = r3
            int r2 = r10.j
            r2 = r2 & 16
            if (r2 == 0) goto L21
            goto Lb0
        L21:
            ig3 r2 = r9.z
            r9.p0()
            j40 r3 = r9.z0
            java.lang.Object r4 = r3.d
            i40 r4 = (defpackage.i40) r4
            java.lang.Object r5 = r3.c
            gk1 r5 = (defpackage.gk1) r5
            int r6 = r3.b
            r7 = 0
            if (r6 != r0) goto L43
            java.lang.Object r0 = r3.f
            android.view.View r0 = (android.view.View) r0
            if (r0 != r1) goto L3d
        L3b:
            r0 = r7
            goto L6c
        L3d:
            java.lang.String r9 = "Cannot call removeViewIfHidden within removeView(At) for a different view"
            defpackage.xe.q(r9)
            return
        L43:
            r8 = 2
            if (r6 == r8) goto Lab
            r3.b = r8     // Catch: java.lang.Throwable -> L57
            androidx.recyclerview.widget.RecyclerView r6 = r5.a     // Catch: java.lang.Throwable -> L57
            int r6 = r6.indexOfChild(r1)     // Catch: java.lang.Throwable -> L57
            r8 = -1
            if (r6 != r8) goto L59
            r3.j(r1)     // Catch: java.lang.Throwable -> L57
        L54:
            r3.b = r7
            goto L6c
        L57:
            r9 = move-exception
            goto La8
        L59:
            boolean r8 = r4.e(r6)     // Catch: java.lang.Throwable -> L57
            if (r8 == 0) goto L69
            r4.h(r6)     // Catch: java.lang.Throwable -> L57
            r3.j(r1)     // Catch: java.lang.Throwable -> L57
            r5.a(r6)     // Catch: java.lang.Throwable -> L57
            goto L54
        L69:
            r3.b = r7
            goto L3b
        L6c:
            if (r0 == 0) goto L97
            rg3 r3 = androidx.recyclerview.widget.RecyclerView.O(r1)
            r2.m(r3)
            r2.j(r3)
            boolean r2 = androidx.recyclerview.widget.RecyclerView.U1
            if (r2 == 0) goto L97
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "after removing animated view: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r3 = ", "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "RecyclerView"
            android.util.Log.d(r3, r2)
        L97:
            r2 = r0 ^ 1
            r9.r0(r2)
            if (r0 != 0) goto Lb0
            boolean r10 = r10.l()
            if (r10 == 0) goto Lb0
            r9.removeDetachedView(r1, r7)
            return
        La8:
            r3.b = r7
            throw r9
        Lab:
            java.lang.String r9 = "Cannot call removeViewIfHidden within removeViewIfHidden"
            defpackage.xe.q(r9)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xf3.c(rg3):void");
    }

    public abstract void d(rg3 rg3Var);

    public abstract void e();

    public abstract boolean f();
}
