package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zs3 implements Executor {
    public static final Logger Y = Logger.getLogger(zs3.class.getName());
    public final Executor b;
    public final ArrayDeque f = new ArrayDeque();
    public int z = 1;
    public long A = 0;
    public final tm1 X = new tm1(this);

    public zs3(Executor executor) {
        tj4.i(executor);
        this.b = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        tj4.i(runnable);
        synchronized (this.f) {
            int i = this.z;
            if (i != 4 && i != 3) {
                long j = this.A;
                boolean z = false;
                ys3 ys3Var = new ys3(runnable, 0);
                this.f.add(ys3Var);
                this.z = 2;
                try {
                    this.b.execute(this.X);
                    if (this.z != 2) {
                        return;
                    }
                    synchronized (this.f) {
                        try {
                            if (this.A == j && this.z == 2) {
                                this.z = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e) {
                    synchronized (this.f) {
                        try {
                            int i2 = this.z;
                            if ((i2 == 1 || i2 == 2) && this.f.removeLastOccurrence(ys3Var)) {
                                z = true;
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
            this.f.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.b + "}";
    }
}
