package defpackage;

import android.os.SystemClock;
import android.text.TextUtils;
import io.sentry.android.core.internal.tombstone.b;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ka5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ long f;
    public final /* synthetic */ ib5 z;

    public ka5(ib5 ib5Var, long j, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.f = j;
                Objects.requireNonNull(ib5Var);
                this.z = ib5Var;
                break;
            default:
                this.f = j;
                Objects.requireNonNull(ib5Var);
                this.z = ib5Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        long j = this.f;
        ib5 ib5Var = this.z;
        switch (i) {
            case 0:
                k85 k85Var = (k85) ib5Var.f;
                l75 l75Var = k85Var.X;
                k85.f(l75Var);
                l75Var.E0.b(j);
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                t65Var.G0.b(Long.valueOf(j), "Session timeout duration set");
                break;
            default:
                ib5Var.V0();
                ib5Var.W0();
                k85 k85Var2 = (k85) ib5Var.f;
                t65 t65Var2 = k85Var2.Y;
                k85.h(t65Var2);
                t65Var2.G0.a("Resetting analytics data (FE)");
                zd5 zd5Var = k85Var2.y0;
                k85.g(zd5Var);
                zd5Var.V0();
                b bVar = zd5Var.z0;
                ((td5) bVar.c).c();
                ((k85) ((zd5) bVar.d).f).B0.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                bVar.a = jElapsedRealtime;
                bVar.b = jElapsedRealtime;
                k85Var2.l().a1();
                boolean z = !k85Var2.a();
                l75 l75Var2 = k85Var2.X;
                k85.f(l75Var2);
                l75Var2.z0.b(j);
                k85 k85Var3 = (k85) l75Var2.f;
                l75 l75Var3 = k85Var3.X;
                k85.f(l75Var3);
                if (!TextUtils.isEmpty(l75Var3.P0.B())) {
                    l75Var2.P0.C(null);
                }
                l75Var2.J0.b(0L);
                l75Var2.K0.b(0L);
                if (!k85Var3.A.i1()) {
                    l75Var2.e1(z);
                }
                l75Var2.Q0.C(null);
                l75Var2.R0.b(0L);
                l75Var2.S0.j(null);
                dd5 dd5VarJ = k85Var2.j();
                dd5VarJ.V0();
                dd5VarJ.W0();
                tg5 tg5VarL1 = dd5VarJ.l1(false);
                dd5VarJ.h1();
                ((k85) dd5VarJ.f).i().Z0();
                dd5VarJ.j1(new gc5(dd5VarJ, tg5VarL1, 0));
                k85.g(zd5Var);
                zd5Var.y0.e();
                ib5Var.M0 = z;
                k85Var2.j().Z0(new AtomicReference());
                break;
        }
    }
}
