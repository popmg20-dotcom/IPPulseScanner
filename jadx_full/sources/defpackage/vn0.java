package defpackage;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vn0 implements zn0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ yn0 b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;
    public final /* synthetic */ TimeUnit f;

    public /* synthetic */ vn0(yn0 yn0Var, Runnable runnable, long j, long j2, TimeUnit timeUnit, int i) {
        this.a = i;
        this.b = yn0Var;
        this.c = runnable;
        this.d = j;
        this.e = j2;
        this.f = timeUnit;
    }

    @Override // defpackage.zn0
    public final ScheduledFuture a(cp1 cp1Var) {
        int i = this.a;
        Runnable runnable = this.c;
        yn0 yn0Var = this.b;
        switch (i) {
            case 0:
                return yn0Var.f.scheduleAtFixedRate(new wn0(yn0Var, runnable, cp1Var, 0), this.d, this.e, this.f);
            default:
                return yn0Var.f.scheduleWithFixedDelay(new wn0(yn0Var, runnable, cp1Var, 2), this.d, this.e, this.f);
        }
    }
}
