package defpackage;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gc5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ tg5 f;
    public final /* synthetic */ dd5 z;

    public /* synthetic */ gc5(dd5 dd5Var, tg5 tg5Var, int i) {
        this.b = i;
        this.f = tg5Var;
        this.z = dd5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        tg5 tg5Var = this.f;
        dd5 dd5Var = this.z;
        switch (i) {
            case 0:
                k85 k85Var = (k85) dd5Var.f;
                v55 v55Var = dd5Var.Z;
                if (v55Var != null) {
                    try {
                        v55Var.z(tg5Var);
                    } catch (RemoteException e) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.z0.b(e, "Failed to reset data on the service: remote exception");
                    }
                    dd5Var.i1();
                } else {
                    t65 t65Var2 = k85Var.Y;
                    k85.h(t65Var2);
                    t65Var2.z0.a("Failed to reset data on the service: not connected to service");
                }
                break;
            case 1:
                k85 k85Var2 = (k85) dd5Var.f;
                v55 v55Var2 = dd5Var.Z;
                if (v55Var2 == null) {
                    t65 t65Var3 = k85Var2.Y;
                    k85.h(t65Var3);
                    t65Var3.C0.a("Failed to send app backgrounded");
                } else {
                    try {
                        v55Var2.y(tg5Var);
                        dd5Var.i1();
                    } catch (RemoteException e2) {
                        t65 t65Var4 = k85Var2.Y;
                        k85.h(t65Var4);
                        t65Var4.z0.b(e2, "Failed to send app backgrounded to the service");
                        return;
                    }
                }
                break;
            default:
                k85 k85Var3 = (k85) dd5Var.f;
                v55 v55Var3 = dd5Var.Z;
                if (v55Var3 == null) {
                    t65 t65Var5 = k85Var3.Y;
                    k85.h(t65Var5);
                    t65Var5.z0.a("Failed to send measurementEnabled to service");
                } else {
                    try {
                        v55Var3.l(tg5Var);
                        dd5Var.i1();
                    } catch (RemoteException e3) {
                        t65 t65Var6 = k85Var3.Y;
                        k85.h(t65Var6);
                        t65Var6.z0.b(e3, "Failed to send measurementEnabled to the service");
                    }
                }
                break;
        }
    }
}
