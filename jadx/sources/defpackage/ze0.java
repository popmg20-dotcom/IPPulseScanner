package defpackage;

import io.sentry.android.replay.capture.g;
import io.sentry.android.replay.capture.j;
import io.sentry.android.replay.capture.l;
import io.sentry.android.replay.capture.o;
import io.sentry.f1;
import io.sentry.util.b;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ze0 extends r82 implements am1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ze0(int i, Object obj, Object obj2) {
        super(1);
        this.f = i;
        this.z = obj;
        this.A = obj2;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws InterruptedException {
        xl4 xl4Var;
        int i = this.f;
        xl4 xl4Var2 = xl4.a;
        Object obj2 = this.A;
        Object obj3 = this.z;
        switch (i) {
            case 0:
                Throwable th = (Throwable) obj;
                vv vvVar = (vv) obj3;
                if (th == null) {
                    vvVar.b(((gn0) obj2).A());
                } else if (!(th instanceof CancellationException)) {
                    vvVar.d(th);
                } else {
                    vvVar.c();
                }
                break;
            case 1:
                Throwable th2 = (Throwable) obj;
                ((ij0) obj3).g(th2);
                xp xpVar = (xp) ((iv1) obj2).A;
                xpVar.d(th2, false);
                do {
                    Object objI = xpVar.i();
                    if (objI instanceof k30) {
                        objI = null;
                    }
                    if (objI != null) {
                        ((kl2) objI).b.S(new r80(th2 == null ? new CancellationException("DataStore scope was cancelled before updateData could complete") : th2, false));
                        xl4Var = xl4Var2;
                    } else {
                        xl4Var = null;
                    }
                } while (xl4Var != null);
                break;
            case 2:
                l lVar = (l) obj;
                lVar.getClass();
                g gVar = (g) obj3;
                ArrayList arrayList = gVar.z;
                f1 f1Var = gVar.w;
                arrayList.getClass();
                j jVar = (j) (arrayList.isEmpty() ? null : arrayList.remove(0));
                while (jVar != null) {
                    j.a(jVar, f1Var);
                    jVar = (j) (arrayList.isEmpty() ? null : arrayList.remove(0));
                    Thread.sleep(100L);
                }
                if (lVar instanceof j) {
                    j jVar2 = (j) lVar;
                    j.a(jVar2, f1Var);
                    ((ij0) obj2).g(jVar2.a.L0);
                }
                break;
            default:
                l lVar2 = (l) obj;
                o oVar = (o) obj3;
                lVar2.getClass();
                if (lVar2 instanceof j) {
                    j.a((j) lVar2, oVar.w);
                }
                oVar.k(-1);
                b.g((File) obj2);
                break;
        }
        return xl4Var2;
    }
}
