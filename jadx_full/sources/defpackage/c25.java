package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c25 extends y1 {
    public static final Parcelable.Creator<c25> CREATOR = new gl4(18);
    public final Bundle b;

    public c25(Bundle bundle) {
        this.b = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.N(parcel, 1, this.b);
        ye.W(parcel, iV);
    }
}
