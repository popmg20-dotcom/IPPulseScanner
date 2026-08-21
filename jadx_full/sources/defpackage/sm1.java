package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sm1 implements wv {
    public final /* synthetic */ nc2 b;
    public final /* synthetic */ xq1 f;
    public final /* synthetic */ long z;

    public /* synthetic */ sm1(nc2 nc2Var, xq1 xq1Var, long j) {
        this.b = nc2Var;
        this.f = xq1Var;
        this.z = j;
    }

    @Override // defpackage.wv
    public final Object n(final vv vvVar) {
        final nc2 nc2Var = this.b;
        n12.N(nc2Var, vvVar);
        if (!nc2Var.isDone()) {
            final long j = this.z;
            nc2Var.a(new ga1(4, this.f.schedule(new Callable() { // from class: qm1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return Boolean.valueOf(vvVar.d(new TimeoutException("Future[" + nc2Var + "] is not done within " + j + " ms.")));
                }
            }, j, TimeUnit.MILLISECONDS)), yu0.a());
        }
        return "TimeoutFuture[" + nc2Var + "]";
    }
}
