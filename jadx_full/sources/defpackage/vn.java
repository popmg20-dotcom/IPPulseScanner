package defpackage;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vn extends i0 {
    public final Thread A;
    public final b61 X;

    public vn(cf0 cf0Var, Thread thread, b61 b61Var) {
        super(cf0Var, true);
        this.A = thread;
        this.X = b61Var;
    }

    @Override // defpackage.e42
    public final void o(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.A;
        if (n12.c(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
