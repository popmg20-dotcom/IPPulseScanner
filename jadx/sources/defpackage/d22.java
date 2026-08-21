package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d22 implements Executor {
    public static volatile d22 z;
    public final /* synthetic */ int b;
    public final Object f;

    public d22() {
        this.b = 0;
        this.f = Executors.newFixedThreadPool(2, new hz(2));
    }

    public static Executor a() {
        if (z != null) {
            return z;
        }
        synchronized (d22.class) {
            try {
                if (z == null) {
                    z = new d22();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                ((ExecutorService) obj).execute(runnable);
                break;
            default:
                f85 f85Var = ((k85) ((ib5) obj).f).Z;
                k85.h(f85Var);
                f85Var.e1(runnable);
                break;
        }
    }

    public d22(ib5 ib5Var) {
        this.b = 1;
        this.f = ib5Var;
    }
}
