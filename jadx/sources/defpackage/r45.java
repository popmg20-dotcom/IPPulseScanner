package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r45 implements ServiceConnection {
    public final int b;
    public final /* synthetic */ tk f;

    public r45(tk tkVar, int i) {
        this.f = tkVar;
        this.b = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        tk tkVar = this.f;
        if (iBinder == null) {
            tkVar.x();
            return;
        }
        synchronized (tkVar.y0) {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                tkVar.z0 = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a15)) ? new a15(iBinder) : (a15) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        tk tkVar2 = this.f;
        int i = this.b;
        t55 t55Var = new t55(tkVar2, 0, null);
        p25 p25Var = tkVar2.Y;
        p25Var.sendMessage(p25Var.obtainMessage(7, i, -1, t55Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        tk tkVar = this.f;
        synchronized (tkVar.y0) {
            tkVar.z0 = null;
        }
        tk tkVar2 = this.f;
        int i = this.b;
        p25 p25Var = tkVar2.Y;
        p25Var.sendMessage(p25Var.obtainMessage(6, i, 1));
    }
}
