package defpackage;

import android.net.ConnectivityManager;
import android.view.View;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b4 implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ b4(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    @Override // defpackage.pl1
    public final Object a() {
        Object obj;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.A;
        Object obj3 = this.z;
        Object obj4 = this.f;
        switch (i) {
            case 0:
                ((c4) obj4).b((View) obj3);
                ((pl1) obj2).a();
                return xl4Var;
            case 1:
                ek0 ek0Var = ((n20) obj4).b;
                ek0Var.getClass();
                return ek0Var.d(((a6) obj2).i.d, ((zq1) obj3).a());
            case 2:
                ConnectivityManager connectivityManager = (ConnectivityManager) obj3;
                wz1 wz1Var = (wz1) obj2;
                if (((xg3) obj4).b) {
                    ue2.g().a(mw4.a, "NetworkRequestConstraintController unregister callback");
                    connectivityManager.unregisterNetworkCallback(wz1Var);
                }
                return xl4Var;
            default:
                xw4 xw4Var = (xw4) obj4;
                String str = (String) obj3;
                c13 c13Var = (c13) obj2;
                final WorkDatabase workDatabase = xw4Var.c;
                jx4 jx4VarX = workDatabase.x();
                List listD = jx4VarX.d(str);
                if (listD.size() <= 1) {
                    fx4 fx4Var = (fx4) d70.e0(listD);
                    obj = null;
                    o71 o71Var = o71.f;
                    if (fx4Var == null) {
                        h51.a(new nw4(xw4Var, str, o71Var, p95.x(c13Var), 0));
                        return xl4Var;
                    }
                    String str2 = fx4Var.a;
                    gx4 gx4VarC = jx4VarX.c(str2);
                    if (gx4VarC == null) {
                        xe.q(fw.v("WorkSpec with ", str2, ", that matches a name \"", str, "\", wasn't found"));
                    } else if (!gx4VarC.c()) {
                        vp1.n("Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
                    } else {
                        if (fx4Var.b == ww4.Y) {
                            jx4VarX.a(str2);
                            h51.a(new nw4(xw4Var, str, o71Var, p95.x(c13Var), 0));
                            return xl4Var;
                        }
                        final gx4 gx4VarB = gx4.b(c13Var.b, fx4Var.a, null, null, null, 0, 0L, 0, 0, 0L, 0, 33554430);
                        n53 n53Var = xw4Var.f;
                        n53Var.getClass();
                        workDatabase.getClass();
                        na0 na0Var = xw4Var.b;
                        na0Var.getClass();
                        final List list = xw4Var.e;
                        list.getClass();
                        final Set set = c13Var.c;
                        final String str3 = gx4VarB.a;
                        final gx4 gx4VarC2 = workDatabase.x().c(str3);
                        if (gx4VarC2 != null) {
                            if (gx4VarC2.b.a()) {
                                return xl4Var;
                            }
                            if (gx4VarC2.c() ^ gx4VarB.c()) {
                                StringBuilder sb = new StringBuilder("Can't update ");
                                sb.append(gx4VarC2.c() ? "Periodic" : "OneTime");
                                sb.append(" Worker to ");
                                throw new UnsupportedOperationException(fw.y(sb, gx4VarB.c() ? "Periodic" : "OneTime", " Worker. Update operation must preserve worker's type."));
                            }
                            final boolean zF = n53Var.f(str3);
                            if (!zF) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    ((dq3) it.next()).d(str3);
                                }
                            }
                            workDatabase.p(new fn(19, new Runnable() { // from class: ox4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WorkDatabase workDatabase2 = workDatabase;
                                    jx4 jx4VarX2 = workDatabase2.x();
                                    lx4 lx4VarY = workDatabase2.y();
                                    gx4 gx4Var = gx4VarC2;
                                    ww4 ww4Var = gx4Var.b;
                                    int i2 = gx4Var.k;
                                    long j = gx4Var.n;
                                    int i3 = 1;
                                    int i4 = gx4Var.t + 1;
                                    int i5 = gx4Var.s;
                                    long j2 = gx4Var.u;
                                    int i6 = gx4Var.v;
                                    gx4 gx4Var2 = gx4VarB;
                                    gx4 gx4VarB2 = gx4.b(gx4Var2, null, ww4Var, null, null, i2, j, i5, i4, j2, i6, 29613053);
                                    if (gx4Var2.v == 1) {
                                        gx4VarB2.u = gx4Var2.u;
                                        gx4VarB2.v++;
                                    }
                                    gx4 gx4VarG = p95.G(list, gx4VarB2);
                                    jx4VarX2.getClass();
                                    ke0.r(jx4VarX2.a, false, true, new ix4(jx4VarX2, gx4VarG, i3));
                                    lx4VarY.getClass();
                                    String str4 = str3;
                                    str4.getClass();
                                    ke0.r(lx4VarY.a, false, true, new ko0(str4, 25));
                                    lx4VarY.a(str4, set);
                                    if (zF) {
                                        return;
                                    }
                                    jx4VarX2.e(-1L, str4);
                                    bx4 bx4VarW = workDatabase2.w();
                                    bx4VarW.getClass();
                                    ke0.r(bx4VarW.a, false, true, new ko0(str4, 13));
                                }
                            }));
                            if (zF) {
                                return xl4Var;
                            }
                            fq3.b(na0Var, workDatabase, list);
                            return xl4Var;
                        }
                        xe.k(ha0.o("Worker with ", str3, " doesn't exist"));
                    }
                } else {
                    obj = null;
                    vp1.n("Can't apply UPDATE policy to the chains of work.");
                }
                return obj;
        }
    }
}
