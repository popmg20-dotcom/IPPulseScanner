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
    */
    public final void h(int i, cf0 cf0Var) {
        int i2 = zp.b;
        boolean z = i >= i2;
        if (z) {
            i -= i2;
        }
        Object obj = this.y0.get(i * 2);
        while (true) {
            Object objL = l(i);
            boolean z2 = objL instanceof xs4;
            xp xpVar = this.Z;
            if (z2 || (objL instanceof ys4)) {
                if (k(i, objL, z ? zp.j : zp.k)) {
                    n(i, null);
                    m(i, !z);
                    if (z) {
                        xpVar.getClass();
                        am1 am1Var = xpVar.f;
                        if (am1Var != null) {
                            ez4.g(am1Var, obj, cf0Var);
                            return;
                        }
                        return;
                    }
                    return;
                }
            } else {
                if (objL == zp.j || objL == zp.k) {
                    break;
                }
                if (objL != zp.g && objL != zp.f) {
                    if (objL == zp.i || objL == zp.d || objL == zp.l) {
                        return;
                    }
                    ad0.o(objL, "unexpected state: ");
                    return;
                }
            }
        }
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
