package defpackage;

import androidx.work.impl.WorkDatabase;
import io.sentry.o0;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bx1 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bx1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        int i2 = 0;
        Object obj = this.b;
        switch (i) {
            case 0:
                WorkDatabase workDatabase = ((cx1) obj).a;
                Long lA = workDatabase.t().a("next_job_scheduler_id");
                int iLongValue = lA != null ? (int) lA.longValue() : 0;
                int i3 = iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1;
                a33 a33VarT = workDatabase.t();
                int i4 = 12;
                ke0.r(a33VarT.a, false, true, new gj(i4, a33VarT, new z23("next_job_scheduler_id", Long.valueOf(i3))));
                if (iLongValue < 0 || iLongValue > Integer.MAX_VALUE) {
                    a33 a33VarT2 = workDatabase.t();
                    ke0.r(a33VarT2.a, false, true, new gj(i4, a33VarT2, new z23("next_job_scheduler_id", 1L)));
                } else {
                    i2 = iLongValue;
                }
                return Integer.valueOf(i2);
            case 1:
                o0 o0Var = (o0) obj;
                try {
                    o0Var.e.getClass();
                    o0Var.b = InetAddress.getLocalHost().getCanonicalHostName();
                    o0Var.c = System.currentTimeMillis() + o0Var.a;
                    o0Var.d.set(false);
                    return null;
                } catch (Throwable th) {
                    o0Var.d.set(false);
                    throw th;
                }
            case 2:
                return (Integer) ((AtomicReference) obj).get();
            default:
                return (Integer) obj;
        }
    }
}
