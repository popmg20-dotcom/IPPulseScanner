package defpackage;

import io.sentry.android.core.internal.tombstone.b;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nd5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ long f;
    public final /* synthetic */ zd5 z;

    public nd5(zd5 zd5Var, long j, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.f = j;
                Objects.requireNonNull(zd5Var);
                this.z = zd5Var;
                break;
            default:
                this.f = j;
                Objects.requireNonNull(zd5Var);
                this.z = zd5Var;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i = this.b;
        zd5 zd5Var = this.z;
        switch (i) {
            case 0:
                b bVar = zd5Var.z0;
                zd5Var.V0();
                zd5Var.Z0();
                k85 k85Var = (k85) zd5Var.f;
                t65 t65Var = k85Var.Y;
                k85.h(t65Var);
                q65 q65Var = t65Var.H0;
                long j = this.f;
                q65Var.b(Long.valueOf(j), "Activity resumed, time");
                x15 x15Var = k85Var.A;
                if (x15Var.f1(null, r55.V0)) {
                    if (x15Var.j1() || zd5Var.Z) {
                        ((zd5) bVar.d).V0();
                        ((td5) bVar.c).c();
                        bVar.a = j;
                        bVar.b = j;
                    }
                } else if (!x15Var.j1()) {
                    l75 l75Var = k85Var.X;
                    k85.f(l75Var);
                    if (l75Var.M0.a()) {
                        ((zd5) bVar.d).V0();
                        ((td5) bVar.c).c();
                        bVar.a = j;
                        bVar.b = j;
                    }
                }
                ca5 ca5Var = zd5Var.A0;
                zd5 zd5Var2 = (zd5) ca5Var.b;
                zd5Var2.V0();
                k85 k85Var2 = (k85) zd5Var2.f;
                rd5 rd5Var = (rd5) ca5Var.a;
                if (rd5Var != null) {
                    zd5Var2.Y.removeCallbacks(rd5Var);
                }
                l75 l75Var2 = k85Var2.X;
                ib5 ib5Var = k85Var2.D0;
                k85.f(l75Var2);
                l75Var2.M0.b(false);
                zd5Var2.V0();
                zd5Var2.Z = false;
                if (k85Var2.A.f1(null, r55.U0)) {
                    k85.g(ib5Var);
                    if (ib5Var.H0) {
                        t65 t65Var2 = k85Var2.Y;
                        k85.h(t65Var2);
                        t65Var2.H0.a("Retrying trigger URI registration in foreground");
                        k85.g(ib5Var);
                        ib5Var.u1();
                    }
                }
                ub4 ub4Var = zd5Var.y0;
                zd5 zd5Var3 = (zd5) ub4Var.b;
                zd5Var3.V0();
                k85 k85Var3 = (k85) zd5Var3.f;
                if (k85Var3.a()) {
                    k85Var3.B0.getClass();
                    ub4Var.f(System.currentTimeMillis());
                    break;
                }
                break;
            default:
                zd5Var.V0();
                zd5Var.Z0();
                k85 k85Var4 = (k85) zd5Var.f;
                t65 t65Var3 = k85Var4.Y;
                k85.h(t65Var3);
                q65 q65Var2 = t65Var3.H0;
                long j2 = this.f;
                q65Var2.b(Long.valueOf(j2), "Activity paused, time");
                ca5 ca5Var2 = zd5Var.A0;
                zd5 zd5Var4 = (zd5) ca5Var2.b;
                ((k85) zd5Var4.f).B0.getClass();
                rd5 rd5Var2 = new rd5(ca5Var2, System.currentTimeMillis(), j2);
                ca5Var2.a = rd5Var2;
                zd5Var4.Y.postDelayed(rd5Var2, 2000L);
                if (k85Var4.A.j1()) {
                    ((td5) zd5Var.z0.c).c();
                }
                break;
        }
    }
}
