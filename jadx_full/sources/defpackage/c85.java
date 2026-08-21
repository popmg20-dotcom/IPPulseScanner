package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c85 extends FutureTask implements Comparable {
    public final /* synthetic */ f85 A;
    public final long b;
    public final boolean f;
    public final String z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c85(f85 f85Var, Callable callable, boolean z) {
        super(callable);
        this.A = f85Var;
        long andIncrement = f85.E0.getAndIncrement();
        this.b = andIncrement;
        this.z = "Task exception on worker thread";
        this.f = z;
        if (andIncrement == Long.MAX_VALUE) {
            t65 t65Var = ((k85) f85Var.f).Y;
            k85.h(t65Var);
            t65Var.z0.a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        c85 c85Var = (c85) obj;
        boolean z = c85Var.f;
        boolean z2 = this.f;
        if (z2 != z) {
            return !z2 ? 1 : -1;
        }
        long j = c85Var.b;
        long j2 = this.b;
        if (j2 < j) {
            return -1;
        }
        if (j2 > j) {
            return 1;
        }
        t65 t65Var = ((k85) this.A.f).Y;
        k85.h(t65Var);
        t65Var.A0.b(Long.valueOf(j2), "Two tasks share the same index. index");
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        t65 t65Var = ((k85) this.A.f).Y;
        k85.h(t65Var);
        t65Var.z0.b(th, this.z);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c85(f85 f85Var, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.A = f85Var;
        long andIncrement = f85.E0.getAndIncrement();
        this.b = andIncrement;
        this.z = str;
        this.f = z;
        if (andIncrement == Long.MAX_VALUE) {
            t65 t65Var = ((k85) f85Var.f).Y;
            k85.h(t65Var);
            t65Var.z0.a("Tasks index overflow");
        }
    }
}
