package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class na implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ za f;

    public /* synthetic */ na(za zaVar, int i) {
        this.b = i;
        this.f = zaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        int i = this.b;
        za zaVar = this.f;
        switch (i) {
            case 0:
                if ((zaVar.p1 & 1) != 0) {
                    zaVar.y(0);
                }
                if ((zaVar.p1 & 4096) != 0) {
                    zaVar.y(108);
                }
                zaVar.o1 = false;
                zaVar.p1 = 0;
                break;
            default:
                zaVar.M0.showAtLocation(zaVar.L0, 55, 0, 0);
                cr4 cr4Var = zaVar.O0;
                if (cr4Var != null) {
                    cr4Var.b();
                }
                if (zaVar.P0 && (viewGroup = zaVar.Q0) != null && viewGroup.isLaidOut()) {
                    zaVar.L0.setAlpha(0.0f);
                    cr4 cr4VarA = wp4.a(zaVar.L0);
                    cr4VarA.a(1.0f);
                    zaVar.O0 = cr4VarA;
                    cr4VarA.d(new pa(0, this));
                } else {
                    zaVar.L0.setAlpha(1.0f);
                    zaVar.L0.setVisibility(0);
                }
                break;
        }
    }
}
