package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class at3 implements Executor {
    public final Executor f;
    public final ArrayDeque b = new ArrayDeque();
    public final f33 z = new f33(21, this);
    public int A = 1;
    public long X = 0;

    public at3(Executor executor) {
        executor.getClass();
        this.f = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        synchronized (this.b) {
            int i = this.A;
            if (i != 4 && i != 3) {
                long j = this.X;
                boolean z = true;
                ys3 ys3Var = new ys3(runnable, 1);
                this.b.add(ys3Var);
                this.A = 2;
                try {
                    this.f.execute(this.z);
                    if (this.A != 2) {
                        return;
                    }
                    synchronized (this.b) {
                        try {
                            if (this.X == j && this.A == 2) {
                                this.A = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.b) {
                        try {
                            int i2 = this.A;
                            if ((i2 != 1 && i2 != 2) || !this.b.removeLastOccurrence(ys3Var)) {
                                z = false;
                            }
                            if (!(e instanceof RejectedExecutionException) || z) {
                                throw e;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.b.add(runnable);
        }
    }
}
