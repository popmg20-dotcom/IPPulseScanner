package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t25 extends Thread {
    public final WeakReference b;
    public final long f;
    public final CountDownLatch z = new CountDownLatch(1);
    public boolean A = false;

    public t25(i6 i6Var, long j) {
        this.b = new WeakReference(i6Var);
        this.f = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        i6 i6Var;
        WeakReference weakReference = this.b;
        try {
            if (this.z.await(this.f, TimeUnit.MILLISECONDS) || (i6Var = (i6) weakReference.get()) == null) {
                return;
            }
            i6Var.b();
            this.A = true;
        } catch (InterruptedException unused) {
            i6 i6Var2 = (i6) weakReference.get();
            if (i6Var2 != null) {
                i6Var2.b();
                this.A = true;
            }
        }
    }
}
