package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kw3 extends hp1 {
    public final boolean Q0;
    public final uf4 R0;
    public final Bundle S0;
    public final Integer T0;

    public kw3(Context context, Looper looper, uf4 uf4Var, Bundle bundle, rp1 rp1Var, sp1 sp1Var) {
        super(context, looper, 44, uf4Var, rp1Var, sp1Var);
        this.Q0 = true;
        this.R0 = uf4Var;
        this.S0 = bundle;
        this.T0 = (Integer) uf4Var.g;
    }

    @Override // defpackage.tk, defpackage.t9
    public final int g() {
        return 12451000;
    }

    @Override // defpackage.tk, defpackage.t9
    public final boolean j() {
        return this.Q0;
    }

    @Override // defpackage.tk
    public final IInterface m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof f05 ? (f05) iInterfaceQueryLocalInterface : new f05(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // defpackage.tk
    public final Bundle q() {
        uf4 uf4Var = this.R0;
        boolean zEquals = this.z.getPackageName().equals((String) uf4Var.d);
        Bundle bundle = this.S0;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) uf4Var.d);
        }
        return bundle;
    }

    @Override // defpackage.tk
    public final String t() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // defpackage.tk
    public final String u() {
        return "com.google.android.gms.signin.service.START";
    }
}
