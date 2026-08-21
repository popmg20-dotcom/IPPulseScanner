package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n75 implements ServiceConnection {
    public final String b;
    public final /* synthetic */ o75 f;

    public n75(o75 o75Var, String str) {
        Objects.requireNonNull(o75Var);
        this.f = o75Var;
        this.b = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        o75 o75Var = this.f;
        if (iBinder == null) {
            t65 t65Var = o75Var.a.Y;
            k85.h(t65Var);
            t65Var.C0.a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = f35.c;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            g35 e35Var = iInterfaceQueryLocalInterface instanceof g35 ? (g35) iInterfaceQueryLocalInterface : new e35(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService", 2);
            k85 k85Var = o75Var.a;
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.H0.a("Install Referrer Service connected");
            f85 f85Var = k85Var.Z;
            k85.h(f85Var);
            f85Var.e1(new um1(this, e35Var, this));
        } catch (RuntimeException e) {
            t65 t65Var3 = o75Var.a.Y;
            k85.h(t65Var3);
            t65Var3.C0.b(e, "Exception occurred while calling Install Referrer API");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        t65 t65Var = this.f.a.Y;
        k85.h(t65Var);
        t65Var.H0.a("Install Referrer Service disconnected");
    }
}
