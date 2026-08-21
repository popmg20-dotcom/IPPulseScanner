package defpackage;

import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.replay.capture.a;
import io.sentry.android.replay.capture.b;
import io.sentry.android.replay.capture.d;
import io.sentry.android.replay.util.j;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.p6;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ij0 extends r82 implements am1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ij0(int i, Object obj) {
        super(1);
        this.f = i;
        this.z = obj;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.f;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.z;
        switch (i) {
            case 0:
                Throwable th = (Throwable) obj;
                lj0 lj0Var = (lj0) obj2;
                n84 n84Var = lj0Var.A0;
                if (th != null) {
                    lj0Var.y0.x(new qe1(th));
                }
                if (n84Var.c()) {
                    ((ee1) n84Var.getValue()).close();
                }
                break;
            case 1:
                ((nc2) obj2).cancel(false);
                break;
            default:
                Date date = (Date) obj;
                date.getClass();
                ReplayIntegration replayIntegration = (ReplayIntegration) obj2;
                d dVar = replayIntegration.E0;
                if (dVar != null) {
                    dVar.k(dVar.e() + 1);
                }
                d dVar2 = replayIntegration.E0;
                if (dVar2 != null) {
                    dVar2.m(date);
                }
                d dVar3 = replayIntegration.E0;
                if (dVar3 != null) {
                    b bVar = dVar3.p;
                    d82 d82Var = d.u[6];
                    Boolean bool = Boolean.TRUE;
                    bVar.getClass();
                    d82Var.getClass();
                    Object andSet = bVar.b.getAndSet(bool);
                    if (!n12.c(andSet, bool)) {
                        a aVar = new a(andSet, bool, bVar.d, 3);
                        d dVar4 = bVar.c;
                        p6 p6Var = dVar4.a;
                        if (!p6Var.getThreadChecker().c()) {
                            try {
                                aVar.a();
                            } catch (Throwable th2) {
                                p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th2);
                            }
                        } else {
                            dVar4.e.submit(new j(new p2(5, aVar), "CaptureStrategy.runInBackground"));
                        }
                    }
                }
                break;
        }
        return xl4Var;
    }
}
