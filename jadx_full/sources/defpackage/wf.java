package defpackage;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wf extends Thread {
    public final /* synthetic */ int b = 1;

    public /* synthetic */ wf(Runnable runnable, String str) {
        super(runnable, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        xf xfVarC;
        switch (this.b) {
            case 0:
                break;
            case 1:
                Process.setThreadPriority(10);
                super.run();
                return;
            default:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
                break;
        }
        while (true) {
            try {
                reentrantLock = xf.j;
                reentrantLock.lock();
                try {
                    xfVarC = uf2.c();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused2) {
                continue;
            }
            if (xfVarC == xf.i) {
                xf.i = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (xfVarC != null) {
                    xfVarC.j();
                }
            }
        }
    }

    public /* synthetic */ wf(String str) {
        super(str);
    }

    public /* synthetic */ wf(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
