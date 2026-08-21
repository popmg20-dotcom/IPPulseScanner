package defpackage;

import android.os.RemoteException;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ic5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ tg5 f;
    public final /* synthetic */ dd5 z;

    public ic5(dd5 dd5Var, tg5 tg5Var, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.f = tg5Var;
                Objects.requireNonNull(dd5Var);
                this.z = dd5Var;
                break;
            default:
                this.f = tg5Var;
                this.z = dd5Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i = this.b;
        tg5 tg5Var = this.f;
        dd5 dd5Var = this.z;
        switch (i) {
            case 0:
                v55 v55Var = dd5Var.Z;
                k85 k85Var = (k85) dd5Var.f;
                if (v55Var == null) {
                    t65 t65Var = k85Var.Y;
                    k85.h(t65Var);
                    t65Var.z0.a("Discarding data. Failed to send app launch");
                } else {
                    try {
                        x15 x15Var = k85Var.A;
                        q55 q55Var = r55.c1;
                        if (x15Var.f1(null, q55Var)) {
                            dd5Var.n1(v55Var, null, tg5Var);
                        }
                        v55Var.s(tg5Var);
                        k85Var.i().a1();
                        k85Var.A.f1(null, q55Var);
                        dd5Var.n1(v55Var, null, tg5Var);
                        dd5Var.i1();
                    } catch (RemoteException e) {
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.z0.b(e, "Failed to send app launch to the service");
                        return;
                    }
                }
                break;
            default:
                v55 v55Var2 = dd5Var.Z;
                k85 k85Var2 = (k85) dd5Var.f;
                if (v55Var2 == null) {
                    t65 t65Var3 = k85Var2.Y;
                    k85.h(t65Var3);
                    t65Var3.z0.a("Failed to send consent settings to service");
                } else {
                    try {
                        v55Var2.A(tg5Var);
                        dd5Var.i1();
                    } catch (RemoteException e2) {
                        t65 t65Var4 = k85Var2.Y;
                        k85.h(t65Var4);
                        t65Var4.z0.b(e2, "Failed to send consent settings to the service");
                    }
                }
                break;
        }
    }
}
