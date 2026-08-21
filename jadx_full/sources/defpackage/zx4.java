package defpackage;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zx4 {
    public static final String a = ue2.i("WorkerWrapper");

    public static final Object a(nc2 nc2Var, tc2 tc2Var, v74 v74Var) {
        Object obj;
        try {
            if (!nc2Var.isDone()) {
                z00 z00Var = new z00(1, p95.u(v74Var));
                z00Var.w();
                nc2Var.a(new um1(10, nc2Var, z00Var), xu0.b);
                z00Var.y(new he0(2, tc2Var, nc2Var));
                return z00Var.u();
            }
            boolean z = false;
            while (true) {
                try {
                    obj = nc2Var.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return obj;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            cause.getClass();
            throw cause;
        }
    }
}
