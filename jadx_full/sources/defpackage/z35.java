package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z35 extends oz4 {
    public tk d;
    public final int e;

    public z35(tk tkVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.d = tkVar;
        this.e = i;
    }

    @Override // defpackage.oz4
    public final boolean E(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int i2 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) k35.a(parcel, Bundle.CREATOR);
            k35.c(parcel);
            tj4.j(this.d, "onPostInitComplete can be called only once per call to getRemoteService");
            tk tkVar = this.d;
            int i3 = this.e;
            tkVar.getClass();
            x45 x45Var = new x45(tkVar, i2, strongBinder, bundle);
            p25 p25Var = tkVar.Y;
            p25Var.sendMessage(p25Var.obtainMessage(1, i3, -1, x45Var));
            this.d = null;
        } else if (i == 2) {
            parcel.readInt();
            k35.c(parcel);
            a1.p("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i4 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            e95 e95Var = (e95) k35.a(parcel, e95.CREATOR);
            k35.c(parcel);
            tk tkVar2 = this.d;
            tj4.j(tkVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            tj4.i(e95Var);
            tkVar2.M0 = e95Var;
            Bundle bundle2 = e95Var.b;
            tj4.j(this.d, "onPostInitComplete can be called only once per call to getRemoteService");
            tk tkVar3 = this.d;
            int i5 = this.e;
            tkVar3.getClass();
            x45 x45Var2 = new x45(tkVar3, i4, strongBinder2, bundle2);
            p25 p25Var2 = tkVar3.Y;
            p25Var2.sendMessage(p25Var2.obtainMessage(1, i5, -1, x45Var2));
            this.d = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
