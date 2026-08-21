package defpackage;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d85 extends Thread {
    public final /* synthetic */ f85 A;
    public final Object b;
    public final BlockingQueue f;
    public boolean z = false;

    public d85(f85 f85Var, String str, BlockingQueue blockingQueue) {
        this.A = f85Var;
        tj4.i(blockingQueue);
        this.b = new Object();
        this.f = blockingQueue;
        setName(str);
    }

    public final void a() {
        Object obj = this.b;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public final void b() {
        f85 f85Var = this.A;
        synchronized (f85Var.C0) {
            try {
                if (!this.z) {
                    f85Var.D0.release();
                    f85Var.C0.notifyAll();
                    if (this == f85Var.Y) {
                        f85Var.Y = null;
                    } else if (this == f85Var.Z) {
                        f85Var.Z = null;
                    } else {
                        t65 t65Var = ((k85) f85Var.f).Y;
                        k85.h(t65Var);
                        t65Var.z0.a("Current scheduler thread is neither worker nor network");
                    }
                    this.z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.A.D0.acquire();
                z = true;
            } catch (InterruptedException e) {
                t65 t65Var = ((k85) this.A.f).Y;
                k85.h(t65Var);
                t65Var.C0.b(e, String.valueOf(getName()).concat(" was interrupted"));
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.f;
                c85 c85Var = (c85) blockingQueue.poll();
                if (c85Var != null) {
                    Process.setThreadPriority(true != c85Var.f ? 10 : threadPriority);
                    c85Var.run();
                } else {
                    Object obj = this.b;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.A.getClass();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e2) {
                                t65 t65Var2 = ((k85) this.A.f).Y;
                                k85.h(t65Var2);
                                t65Var2.C0.b(e2, String.valueOf(getName()).concat(" was interrupted"));
                            }
                        }
                    }
                    synchronized (this.A.C0) {
                        if (this.f.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b();
            throw th;
        }
    }
}
