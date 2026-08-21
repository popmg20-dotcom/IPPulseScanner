package defpackage;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xc5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ dd5 f;

    public /* synthetic */ xc5(dd5 dd5Var, int i) {
        this.b = i;
        this.f = dd5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        dd5 dd5Var = this.f;
        switch (i) {
            case 0:
                dd5Var.b1();
                break;
            case 1:
                k85 k85Var = (k85) dd5Var.f;
                v55 v55Var = dd5Var.Z;
                if (v55Var == null) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.z0.a("Failed to send Dma consent settings to service");
                } else {
                    try {
                        v55Var.n(dd5Var.l1(false));
                        dd5Var.i1();
                    } catch (RemoteException e) {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.z0.b(e, "Failed to send Dma consent settings to the service");
                        return;
                    }
                }
                break;
            default:
                k85 k85Var2 = (k85) dd5Var.f;
                v55 v55Var2 = dd5Var.Z;
                if (v55Var2 == null) {
                    t65 t65Var3 = k85Var2.Y;
                    k85.h(t65Var3);
                    t65Var3.z0.a("Failed to send storage consent settings to service");
                } else {
                    try {
                        v55Var2.k(dd5Var.l1(false));
                        dd5Var.i1();
                    } catch (RemoteException e2) {
                        t65 t65Var4 = k85Var2.Y;
                        k85.h(t65Var4);
                        t65Var4.z0.b(e2, "Failed to send storage consent settings to the service");
                    }
                }
                break;
        }
    }
}
