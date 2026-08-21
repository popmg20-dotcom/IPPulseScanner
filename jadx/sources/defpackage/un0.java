package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class un0 implements zn0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ yn0 b;
    public final /* synthetic */ long c;
    public final /* synthetic */ TimeUnit d;
    public final /* synthetic */ Object e;

    public /* synthetic */ un0(yn0 yn0Var, Object obj, long j, TimeUnit timeUnit, int i) {
        this.a = i;
        this.b = yn0Var;
        this.e = obj;
        this.c = j;
        this.d = timeUnit;
    }

    @Override // defpackage.zn0
    public final ScheduledFuture a(cp1 cp1Var) {
        int i = this.a;
        TimeUnit timeUnit = this.d;
        long j = this.c;
        Object obj = this.e;
        yn0 yn0Var = this.b;
        switch (i) {
            case 0:
                return yn0Var.f.schedule(new wn0(yn0Var, (Runnable) obj, cp1Var, 1), j, timeUnit);
            default:
                return yn0Var.f.schedule(new xn0(0, yn0Var, (Callable) obj, cp1Var), j, timeUnit);
        }
    }
}
