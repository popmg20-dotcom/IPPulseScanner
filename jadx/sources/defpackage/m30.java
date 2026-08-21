package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class m30 extends sr3 {
    public final xp Z;
    public final /* synthetic */ AtomicReferenceArray y0;

    public m30(long j, m30 m30Var, xp xpVar, int i) {
        super(j, m30Var, i);
        this.Z = xpVar;
        this.y0 = new AtomicReferenceArray(zp.b * 2);
    }

    @Override // defpackage.sr3
    public final int g() {
        return zp.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0048, code lost:
    
        n(r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004b, code lost:
    
        if (r1 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004d, code lost:
    
        r4.getClass();
        r6 = r4.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0052, code lost:
    
        if (r6 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0054, code lost:
    
        defpackage.ez4.g(r6, r0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // defpackage.sr3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r7, defpackage.cf0 r8) {
        /*
            r6 = this;
            int r0 = defpackage.zp.b
            if (r7 < r0) goto L6
            r1 = 1
            goto L7
        L6:
            r1 = 0
        L7:
            if (r1 == 0) goto La
            int r7 = r7 - r0
        La:
            int r0 = r7 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r6.y0
            java.lang.Object r0 = r2.get(r0)
        L12:
            java.lang.Object r2 = r6.l(r7)
            boolean r3 = r2 instanceof defpackage.xs4
            xp r4 = r6.Z
            r5 = 0
            if (r3 != 0) goto L58
            boolean r3 = r2 instanceof defpackage.ys4
            if (r3 == 0) goto L22
            goto L58
        L22:
            br1 r3 = defpackage.zp.j
            if (r2 == r3) goto L48
            br1 r3 = defpackage.zp.k
            if (r2 != r3) goto L2b
            goto L48
        L2b:
            br1 r3 = defpackage.zp.g
            if (r2 == r3) goto L12
            br1 r3 = defpackage.zp.f
            if (r2 != r3) goto L34
            goto L12
        L34:
            br1 r6 = defpackage.zp.i
            if (r2 == r6) goto L79
            br1 r6 = defpackage.zp.d
            if (r2 != r6) goto L3d
            goto L79
        L3d:
            br1 r6 = defpackage.zp.l
            if (r2 != r6) goto L42
            goto L79
        L42:
            java.lang.String r6 = "unexpected state: "
            defpackage.ad0.o(r2, r6)
            return
        L48:
            r6.n(r7, r5)
            if (r1 == 0) goto L79
            r4.getClass()
            am1 r6 = r4.f
            if (r6 == 0) goto L79
            defpackage.ez4.g(r6, r0, r8)
            return
        L58:
            if (r1 == 0) goto L5d
            br1 r3 = defpackage.zp.j
            goto L5f
        L5d:
            br1 r3 = defpackage.zp.k
        L5f:
            boolean r2 = r6.k(r7, r2, r3)
            if (r2 == 0) goto L12
            r6.n(r7, r5)
            r2 = r1 ^ 1
            r6.m(r7, r2)
            if (r1 == 0) goto L79
            r4.getClass()
            am1 r6 = r4.f
            if (r6 == 0) goto L79
            defpackage.ez4.g(r6, r0, r8)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m30.h(int, cf0):void");
    }

    public final boolean k(int i, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i2 = (i * 2) + 1;
        do {
            atomicReferenceArray = this.y0;
            if (atomicReferenceArray.compareAndSet(i2, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i2) == obj);
        return false;
    }

    public final Object l(int i) {
        return this.y0.get((i * 2) + 1);
    }

    public final void m(int i, boolean z) {
        if (z) {
            xp xpVar = this.Z;
            xpVar.getClass();
            xpVar.M((this.A * ((long) zp.b)) + ((long) i));
        }
        i();
    }

    public final void n(int i, Object obj) {
        this.y0.set(i * 2, obj);
    }

    public final void o(int i, Object obj) {
        this.y0.set((i * 2) + 1, obj);
    }
}
