package defpackage;

import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ct4 extends v12 {
    public final y12 b;
    public final WeakReference c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ct4(y12 y12Var, ul3 ul3Var) {
        super(ul3Var.a);
        ul3Var.getClass();
        this.b = y12Var;
        this.c = new WeakReference(ul3Var);
    }

    @Override // defpackage.v12
    public final void a(Set set) {
        set.getClass();
        v12 v12Var = (v12) this.c.get();
        if (v12Var != null) {
            v12Var.a(set);
            return;
        }
        y12 y12Var = this.b;
        ReentrantLock reentrantLock = y12Var.d;
        reentrantLock.lock();
        try {
            iu2 iu2Var = (iu2) y12Var.c.remove(this);
            if (iu2Var != null) {
                vh4 vh4Var = y12Var.b;
                int[] iArr = iu2Var.b;
                vh4Var.getClass();
                iArr.getClass();
                if (vh4Var.h.s(iArr)) {
                    co4.R(new w12(y12Var, null, 1));
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
