package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class co0 implements Iterator, z72 {
    public b12 A;
    public int X;
    public final /* synthetic */ do0 Y;
    public int b = -1;
    public int f;
    public int z;

    public co0(do0 do0Var) {
        this.Y = do0Var;
        int iU = gb4.u(0, 0, do0Var.a.length());
        this.f = iU;
        this.z = iU;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r8 = this;
            do0 r0 = r8.Y
            java.lang.CharSequence r1 = r0.a
            int r2 = r8.z
            r3 = 0
            if (r2 >= 0) goto Lf
            r8.b = r3
            r0 = 0
            r8.A = r0
            return
        Lf:
            int r4 = r0.b
            r5 = -1
            r6 = 1
            if (r4 <= 0) goto L1c
            int r7 = r8.X
            int r7 = r7 + r6
            r8.X = r7
            if (r7 >= r4) goto L22
        L1c:
            int r4 = r1.length()
            if (r2 <= r4) goto L36
        L22:
            b12 r0 = new b12
            int r2 = r8.f
            r1.getClass()
            int r1 = r1.length()
            int r1 = r1 - r6
            r0.<init>(r2, r1, r6)
            r8.A = r0
            r8.z = r5
            goto L7b
        L36:
            kotlin.jvm.functions.Function2 r0 = r0.c
            int r2 = r8.z
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.k(r1, r2)
            e03 r0 = (defpackage.e03) r0
            if (r0 != 0) goto L5a
            b12 r0 = new b12
            int r2 = r8.f
            r1.getClass()
            int r1 = r1.length()
            int r1 = r1 - r6
            r0.<init>(r2, r1, r6)
            r8.A = r0
            r8.z = r5
            goto L7b
        L5a:
            java.lang.Object r1 = r0.b
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Object r0 = r0.f
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r2 = r8.f
            b12 r2 = defpackage.gb4.d0(r2, r1)
            r8.A = r2
            int r1 = r1 + r0
            r8.f = r1
            if (r0 != 0) goto L78
            r3 = r6
        L78:
            int r1 = r1 + r3
            r8.z = r1
        L7b:
            r8.b = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.co0.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.b == -1) {
            a();
        }
        return this.b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b == -1) {
            a();
        }
        if (this.b == 0) {
            vp1.g();
            return null;
        }
        b12 b12Var = this.A;
        b12Var.getClass();
        this.A = null;
        this.b = -1;
        return b12Var;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
