package defpackage;

import android.os.Process;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lu extends Thread {
    public static final boolean Z = qs4.a;
    public final w7 A;
    public volatile boolean X = false;
    public final ih4 Y;
    public final PriorityBlockingQueue b;
    public final PriorityBlockingQueue f;
    public final fv0 z;

    public lu(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, fv0 fv0Var, w7 w7Var) {
        this.b = priorityBlockingQueue;
        this.f = priorityBlockingQueue2;
        this.z = fv0Var;
        this.A = w7Var;
        this.Y = new ih4(this, priorityBlockingQueue2, w7Var);
    }

    private void a() {
        aj3 aj3Var = (aj3) this.b.take();
        aj3Var.a("cache-queue-take");
        aj3Var.k();
        try {
            if (aj3Var.g()) {
                aj3Var.d("cache-discard-canceled");
                return;
            }
            ju juVarD = this.z.d(aj3Var.f);
            if (juVarD == null) {
                aj3Var.a("cache-miss");
                if (!this.Y.b(aj3Var)) {
                    this.f.put(aj3Var);
                }
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            if (juVarD.e < jCurrentTimeMillis) {
                aj3Var.a("cache-hit-expired");
                aj3Var.B0 = juVarD;
                if (!this.Y.b(aj3Var)) {
                    this.f.put(aj3Var);
                }
                return;
            }
            aj3Var.a("cache-hit");
            ue1 ue1VarJ = aj3Var.j(new jr2(juVarD.a, juVarD.g));
            aj3Var.a("cache-hit-parsed");
            if (((ns4) ue1VarJ.A) == null) {
                if (juVarD.f < jCurrentTimeMillis) {
                    aj3Var.a("cache-hit-refresh-needed");
                    aj3Var.B0 = juVarD;
                    ue1VarJ.f = true;
                    boolean zB = this.Y.b(aj3Var);
                    w7 w7Var = this.A;
                    if (zB) {
                        w7Var.u(aj3Var, ue1VarJ, null);
                    } else {
                        w7Var.u(aj3Var, ue1VarJ, new tm1(4, this, aj3Var, z));
                    }
                } else {
                    this.A.u(aj3Var, ue1VarJ, null);
                }
                return;
            }
            aj3Var.a("cache-parsing-failed");
            fv0 fv0Var = this.z;
            String str = aj3Var.f;
            synchronized (fv0Var) {
                ju juVarD2 = fv0Var.d(str);
                if (juVarD2 != null) {
                    juVarD2.f = 0L;
                    juVarD2.e = 0L;
                    fv0Var.m(str, juVarD2);
                }
            }
            aj3Var.B0 = null;
            if (!this.Y.b(aj3Var)) {
                this.f.put(aj3Var);
            }
        } finally {
            aj3Var.k();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (Z) {
            qs4.d("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.z.i();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.X) {
                    Thread.currentThread().interrupt();
                    return;
                }
                qs4.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
