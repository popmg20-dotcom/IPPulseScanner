package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p85 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ tg5 f;
    public final /* synthetic */ i95 z;

    public /* synthetic */ p85(i95 i95Var, tg5 tg5Var, int i) {
        this.b = i;
        this.f = tg5Var;
        this.z = i95Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i = this.b;
        tg5 tg5Var = this.f;
        i95 i95Var = this.z;
        switch (i) {
            case 0:
                ff5 ff5Var = i95Var.c;
                ff5Var.x();
                ff5Var.C().V0();
                ff5Var.j0();
                tj4.i(tg5Var);
                String str = tg5Var.b;
                tj4.f(str);
                int i2 = 0;
                if (ff5Var.c0().f1(null, r55.A0)) {
                    ff5Var.z0().getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int iD1 = ff5Var.c0().d1(null, r55.j0);
                    ff5Var.c0();
                    long jLongValue = jCurrentTimeMillis - ((Long) r55.e.a(null)).longValue();
                    while (i2 < iD1 && ff5Var.F(jLongValue, null)) {
                        i2++;
                    }
                } else {
                    ff5Var.c0();
                    long jIntValue = ((Integer) r55.l.a(null)).intValue();
                    while (i2 < jIntValue && ff5Var.F(0L, str)) {
                        i2++;
                    }
                }
                if (ff5Var.c0().f1(null, r55.B0)) {
                    ff5Var.C().V0();
                    ff5Var.E();
                }
                te5 te5Var = ff5Var.A0;
                int iM = qe4.m(tg5Var.V0);
                te5Var.V0();
                if (iM == 2 && !te5.Y0(str)) {
                    x75 x75Var = te5Var.X.b;
                    ff5.R(x75Var);
                    j65 j65VarH1 = x75Var.h1(str);
                    if (j65VarH1 != null && j65VarH1.B() && !j65VarH1.C().o().isEmpty()) {
                        ff5Var.n().H0.b(str, "[sgtm] Going background, trigger client side upload. appId");
                        ff5Var.z0().getClass();
                        ff5Var.m(System.currentTimeMillis(), str);
                        break;
                    }
                }
                break;
            case 1:
                ff5 ff5Var2 = i95Var.c;
                ff5Var2.x();
                ff5Var2.C().V0();
                ff5Var2.j0();
                tj4.f(tg5Var.b);
                ff5Var2.a0(tg5Var);
                break;
            case 2:
                ff5 ff5Var3 = i95Var.c;
                ff5Var3.x();
                ff5Var3.C().V0();
                ff5Var3.j0();
                tj4.f(tg5Var.b);
                ff5Var3.k0(tg5Var);
                ff5Var3.l0(tg5Var);
                break;
            default:
                ff5 ff5Var4 = i95Var.c;
                ff5Var4.x();
                ff5Var4.k0(tg5Var);
                break;
        }
    }
}
