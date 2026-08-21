package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m65 extends tk {
    @Override // defpackage.tk, defpackage.t9
    public final int g() {
        return 12451000;
    }

    @Override // defpackage.tk
    public final /* synthetic */ IInterface m(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof v55 ? (v55) iInterfaceQueryLocalInterface : new s55(iBinder);
    }

    @Override // defpackage.tk
    public final String t() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // defpackage.tk
    public final String u() {
        return "com.google.android.gms.measurement.START";
    }
}
