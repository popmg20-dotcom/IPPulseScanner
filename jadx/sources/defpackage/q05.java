package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q05 extends hp1 {
    public final fb4 Q0;

    public q05(Context context, Looper looper, uf4 uf4Var, fb4 fb4Var, sz4 sz4Var, sz4 sz4Var2) {
        super(context, looper, 270, uf4Var, sz4Var, sz4Var2);
        this.Q0 = fb4Var;
    }

    @Override // defpackage.tk, defpackage.t9
    public final int g() {
        return 203400000;
    }

    @Override // defpackage.tk
    public final IInterface m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof l05 ? (l05) iInterfaceQueryLocalInterface : new l05(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // defpackage.tk
    public final ic1[] p() {
        return r25.i;
    }

    @Override // defpackage.tk
    public final Bundle q() {
        fb4 fb4Var = this.Q0;
        fb4Var.getClass();
        Bundle bundle = new Bundle();
        String str = fb4Var.a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // defpackage.tk
    public final String t() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // defpackage.tk
    public final String u() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // defpackage.tk
    public final boolean v() {
        return true;
    }
}
