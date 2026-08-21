package defpackage;

import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fr4 implements am1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ fr4(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.f;
        Object obj3 = this.z;
        Object obj4 = this.A;
        switch (i) {
            case 0:
                cf3 cf3Var = (cf3) obj2;
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) obj3;
                gr4 gr4Var = (gr4) obj4;
                if (!viewTreeObserver.isAlive()) {
                    cf3Var.a.getViewTreeObserver().removeOnPreDrawListener(gr4Var);
                } else {
                    viewTreeObserver.removeOnPreDrawListener(gr4Var);
                }
                break;
            default:
                gw4 gw4Var = (gw4) obj4;
                r92 r92Var = (r92) obj3;
                tq1 tq1Var = (tq1) obj2;
                c41 c41Var = c41.b;
                if (!tq1Var.q0(c41Var)) {
                    r92Var.c(gw4Var);
                } else {
                    tq1Var.j0(c41Var, new um1(12, r92Var, gw4Var));
                }
                break;
        }
        return xl4Var;
    }
}
