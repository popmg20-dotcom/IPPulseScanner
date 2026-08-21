package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import io.sentry.android.core.internal.tombstone.b;
import io.sentry.android.core.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qz4 implements Runnable {
    public final /* synthetic */ int b;
    public final Object f;

    public qz4(nz4 nz4Var, t6 t6Var) {
        this.b = 2;
        this.f = t6Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x01fe  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        int i = this.b;
        int i2 = 0;
        int i3 = 1;
        Object obj = this.f;
        switch (i) {
            case 0:
                t9 t9Var = ((sz4) ((rz4) obj).f).d;
                t9Var.b(t9Var.getClass().getName().concat(" disconnecting because it was signed out."));
                return;
            case 1:
                ((b05) obj).j.L(new ab0(4));
                return;
            case 2:
                throw null;
            case 3:
                ((e75) obj).a.K();
                return;
            case 4:
                dd5 dd5Var = ((yc5) obj).z;
                dd5Var.g1(new ComponentName(((k85) dd5Var.f).b, "com.google.android.gms.measurement.AppMeasurementService"));
                return;
            case 5:
                dd5 dd5Var2 = ((yc5) ((tm1) obj).z).z;
                f85 f85Var = ((k85) dd5Var2.f).Z;
                k85.h(f85Var);
                f85Var.e1(new xc5(dd5Var2, i2));
                return;
            case 6:
                rd5 rd5Var = (rd5) obj;
                zd5 zd5Var = (zd5) rd5Var.z.b;
                zd5Var.V0();
                k85 k85Var = (k85) zd5Var.f;
                t65 t65Var = k85Var.Y;
                Context context = k85Var.b;
                k85.h(t65Var);
                t65Var.G0.a("Application going to the background");
                l75 l75Var = k85Var.X;
                k85.f(l75Var);
                l75Var.M0.b(true);
                zd5Var.V0();
                zd5Var.Z = true;
                x15 x15Var = k85Var.A;
                if (!x15Var.j1()) {
                    long j = rd5Var.f;
                    b bVar = zd5Var.z0;
                    bVar.b(j, false, false);
                    ((td5) bVar.c).c();
                }
                long j2 = rd5Var.b;
                k85.h(t65Var);
                t65Var.F0.b(Long.valueOf(j2), "Application backgrounded at: timestamp_millis");
                ib5 ib5Var = k85Var.D0;
                k85.g(ib5Var);
                ib5Var.V0();
                k85 k85Var2 = (k85) ib5Var.f;
                ib5Var.W0();
                dd5 dd5VarJ = k85Var2.j();
                dd5VarJ.V0();
                dd5VarJ.W0();
                if (dd5VarJ.c1()) {
                    qf5 qf5Var = ((k85) dd5VarJ.f).z0;
                    k85.f(qf5Var);
                    if (qf5Var.D1() >= 242600) {
                    }
                } else {
                    dd5 dd5VarJ2 = k85Var2.j();
                    dd5VarJ2.V0();
                    dd5VarJ2.W0();
                    dd5VarJ2.j1(new gc5(dd5VarJ2, dd5VarJ2.l1(true), i3));
                }
                if (x15Var.f1(null, r55.O0)) {
                    qf5 qf5Var2 = k85Var.z0;
                    k85.f(qf5Var2);
                    long jC1 = qf5Var2.x1(context.getPackageName(), x15Var.Y) ? 1000L : x15Var.c1(context.getPackageName(), r55.E);
                    k85.h(t65Var);
                    t65Var.H0.b(Long.valueOf(jC1), "[sgtm] Scheduling batch upload with minimum latency in millis");
                    k85.e(k85Var.L0);
                    k85Var.L0.Z0(jC1);
                    return;
                }
                return;
            case 7:
                ff5 ff5Var = (ff5) obj;
                ff5Var.C().V0();
                ff5Var.B0 = new o75(ff5Var);
                m25 m25Var = new m25(ff5Var);
                m25Var.X0();
                ff5Var.z = m25Var;
                x75 x75Var = ff5Var.b;
                x15 x15VarC0 = ff5Var.c0();
                tj4.i(x75Var);
                x15VarC0.Z = x75Var;
                fd5 fd5Var = new fd5(ff5Var);
                fd5Var.X0();
                ff5Var.z0 = fd5Var;
                e15 e15Var = new e15(ff5Var);
                e15Var.X0();
                ff5Var.Y = e15Var;
                z65 z65Var = new z65(ff5Var, i3);
                z65Var.X0();
                ff5Var.y0 = z65Var;
                ge5 ge5Var = new ge5(ff5Var);
                ge5Var.X0();
                ff5Var.X = ge5Var;
                ff5Var.A = new e75(ff5Var);
                if (ff5Var.I0 != ff5Var.J0) {
                    ff5Var.n().z0.c("Not all upload components initialized", Integer.valueOf(ff5Var.I0), Integer.valueOf(ff5Var.J0));
                }
                ff5Var.D0.set(true);
                ff5Var.n().H0.a("UploadController is now fully initialized");
                ff5Var.C().V0();
                m25 m25Var2 = ff5Var.z;
                ff5.R(m25Var2);
                m25Var2.f1();
                m25 m25Var3 = ff5Var.z;
                ff5.R(m25Var3);
                m25Var3.V0();
                m25Var3.W0();
                if (m25Var3.C1()) {
                    q55 q55Var = r55.w0;
                    if (((Long) q55Var.a(null)).longValue() != 0) {
                        SQLiteDatabase sQLiteDatabaseK1 = m25Var3.K1();
                        k85 k85Var3 = (k85) m25Var3.f;
                        k85Var3.B0.getClass();
                        int iDelete = sQLiteDatabaseK1.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(q55Var.a(null))});
                        if (iDelete > 0) {
                            t65 t65Var2 = k85Var3.Y;
                            k85.h(t65Var2);
                            t65Var2.H0.b(Integer.valueOf(iDelete), "Deleted stale trigger uris. rowsDeleted");
                        }
                    }
                }
                if (ff5Var.z0.B0.a() == 0) {
                    u uVar = ff5Var.z0.B0;
                    ff5Var.z0().getClass();
                    uVar.b(System.currentTimeMillis());
                }
                ff5Var.K();
                return;
            case 8:
                k85 k85Var4 = (k85) ((wa) obj).b;
                k85.e(k85Var4.L0);
                k85Var4.L0.Z0(((Long) r55.D.a(null)).longValue());
                return;
            default:
                k85 k85Var5 = (k85) obj;
                qf5 qf5Var3 = k85Var5.z0;
                ib5 ib5Var2 = k85Var5.D0;
                k85.f(qf5Var3);
                qf5Var3.V0();
                if (qf5Var3.s1() != 1) {
                    t65 t65Var3 = k85Var5.Y;
                    k85.h(t65Var3);
                    t65Var3.C0.a("registerTrigger called but app not eligible");
                    return;
                }
                k85.g(ib5Var2);
                ib5Var2.V0();
                ba5 ba5Var = ib5Var2.F0;
                if (ba5Var != null) {
                    ba5Var.c();
                }
                k85.g(ib5Var2);
                new Thread(new z95(ib5Var2, 3)).start();
                return;
        }
    }

    public /* synthetic */ qz4(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    public qz4(e75 e75Var, boolean z) {
        this.b = 3;
        this.f = e75Var;
    }

    public qz4(ff5 ff5Var, m31 m31Var) {
        this.b = 7;
        this.f = ff5Var;
    }
}
