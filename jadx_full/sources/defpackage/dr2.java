package defpackage;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.android.core.a1;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dr2 extends Thread {
    public final w7 A;
    public volatile boolean X = false;
    public final PriorityBlockingQueue b;
    public final lb f;
    public final fv0 z;

    public dr2(PriorityBlockingQueue priorityBlockingQueue, lb lbVar, fv0 fv0Var, w7 w7Var) {
        this.b = priorityBlockingQueue;
        this.f = lbVar;
        this.z = fv0Var;
        this.A = w7Var;
    }

    private void a() {
        aj3 aj3Var = (aj3) this.b.take();
        w7 w7Var = this.A;
        SystemClock.elapsedRealtime();
        aj3Var.k();
        Object obj = null;
        try {
            try {
                aj3Var.a("network-queue-take");
                if (aj3Var.g()) {
                    aj3Var.d("network-discard-cancelled");
                    aj3Var.h();
                    aj3Var.k();
                    return;
                }
                TrafficStats.setThreadStatsTag(aj3Var.z);
                jr2 jr2VarH = this.f.H(aj3Var);
                aj3Var.a("network-http-complete");
                if (jr2VarH.b && aj3Var.f()) {
                    aj3Var.d("not-modified");
                    aj3Var.h();
                    aj3Var.k();
                    return;
                }
                ue1 ue1VarJ = aj3Var.j(jr2VarH);
                aj3Var.a("network-parse-complete");
                ju juVar = (ju) ue1VarJ.z;
                if (juVar != null) {
                    this.z.m(aj3Var.f, juVar);
                    aj3Var.a("network-cache-written");
                }
                synchronized (aj3Var.A) {
                    aj3Var.z0 = true;
                }
                w7Var.u(aj3Var, ue1VarJ, null);
                aj3Var.i(ue1VarJ);
                aj3Var.k();
            } catch (ns4 e) {
                SystemClock.elapsedRealtime();
                aj3Var.a("post-error");
                ((nf) w7Var.f).execute(new g33(aj3Var, new ue1(e), obj, 2, false));
                aj3Var.h();
                aj3Var.k();
            } catch (Exception e2) {
                a1.e("Volley", qs4.a("Unhandled exception %s", e2.toString()), e2);
                ns4 ns4Var = new ns4(e2);
                SystemClock.elapsedRealtime();
                aj3Var.a("post-error");
                ((nf) w7Var.f).execute(new g33(aj3Var, new ue1(ns4Var), obj, 2, false));
                aj3Var.h();
                aj3Var.k();
            }
        } catch (Throwable th) {
            aj3Var.k();
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.X) {
                    Thread.currentThread().interrupt();
                    return;
                }
                qs4.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
