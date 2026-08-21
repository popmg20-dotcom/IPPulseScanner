package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u35 extends mz4 implements v35 {
    public u35(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver", 2);
    }

    @Override // defpackage.v35
    public final void t(Bundle bundle) {
        Parcel parcelC = c();
        d35.b(parcelC, bundle);
        E(parcelC, 1);
    }
}
