package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ec5 implements Runnable {
    public final /* synthetic */ dd5 A;
    public final /* synthetic */ y1 X;
    public final /* synthetic */ int b;
    public final /* synthetic */ tg5 f;
    public final /* synthetic */ boolean z;

    public ec5(dd5 dd5Var, tg5 tg5Var, boolean z, q15 q15Var) {
        this.b = 2;
        this.f = tg5Var;
        this.z = z;
        this.X = q15Var;
        Objects.requireNonNull(dd5Var);
        this.A = dd5Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i = this.b;
        y1 y1Var = this.X;
        boolean z = this.z;
        tg5 tg5Var = this.f;
        dd5 dd5Var = this.A;
        switch (i) {
            case 0:
                v55 v55Var = dd5Var.Z;
                if (v55Var != null) {
                    dd5Var.n1(v55Var, z ? null : (kf5) y1Var, tg5Var);
                    dd5Var.i1();
                } else {
                    t65 t65Var = ((k85) dd5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.z0.a("Discarding data. Failed to set user property");
                }
                break;
            case 1:
                v55 v55Var2 = dd5Var.Z;
                if (v55Var2 != null) {
                    dd5Var.n1(v55Var2, z ? null : (z25) y1Var, tg5Var);
                    dd5Var.i1();
                } else {
                    t65 t65Var2 = ((k85) dd5Var.f).Y;
                    k85.h(t65Var2);
                    t65Var2.z0.a("Discarding data. Failed to send event to service");
                }
                break;
            default:
                v55 v55Var3 = dd5Var.Z;
                if (v55Var3 != null) {
                    dd5Var.n1(v55Var3, z ? null : (q15) y1Var, tg5Var);
                    dd5Var.i1();
                } else {
                    t65 t65Var3 = ((k85) dd5Var.f).Y;
                    k85.h(t65Var3);
                    t65Var3.z0.a("Discarding data. Failed to send conditional user property to service");
                }
                break;
        }
    }

    public /* synthetic */ ec5(dd5 dd5Var, tg5 tg5Var, boolean z, y1 y1Var, int i) {
        this.b = i;
        this.f = tg5Var;
        this.z = z;
        this.X = y1Var;
        this.A = dd5Var;
    }
}
