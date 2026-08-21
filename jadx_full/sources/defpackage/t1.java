package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t1 extends yr2 {
    public final AtomicReferenceFieldUpdater g;
    public final AtomicReferenceFieldUpdater h;
    public final AtomicReferenceFieldUpdater i;
    public final AtomicReferenceFieldUpdater j;
    public final AtomicReferenceFieldUpdater k;

    public t1(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.g = atomicReferenceFieldUpdater;
        this.h = atomicReferenceFieldUpdater2;
        this.i = atomicReferenceFieldUpdater3;
        this.j = atomicReferenceFieldUpdater4;
        this.k = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.yr2
    public final boolean d(x1 x1Var, s1 s1Var, s1 s1Var2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.j;
            if (atomicReferenceFieldUpdater.compareAndSet(x1Var, s1Var, s1Var2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(x1Var) == s1Var);
        return false;
    }

    @Override // defpackage.yr2
    public final void d0(w1 w1Var, w1 w1Var2) {
        this.h.lazySet(w1Var, w1Var2);
    }

    @Override // defpackage.yr2
    public final boolean e(x1 x1Var, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.k;
            if (atomicReferenceFieldUpdater.compareAndSet(x1Var, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(x1Var) == obj);
        return false;
    }

    @Override // defpackage.yr2
    public final void e0(w1 w1Var, Thread thread) {
        this.g.lazySet(w1Var, thread);
    }

    @Override // defpackage.yr2
    public final boolean f(x1 x1Var, w1 w1Var, w1 w1Var2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.i;
            if (atomicReferenceFieldUpdater.compareAndSet(x1Var, w1Var, w1Var2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(x1Var) == w1Var);
        return false;
    }
}
