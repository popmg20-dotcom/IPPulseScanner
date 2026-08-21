package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e95 extends y1 {
    public static final Parcelable.Creator<e95> CREATOR = new gl4(26);
    public eb0 A;
    public Bundle b;
    public ic1[] f;
    public int z;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.N(parcel, 1, this.b);
        ye.R(parcel, 2, this.f, i);
        int i2 = this.z;
        ye.U(parcel, 3, 4);
        parcel.writeInt(i2);
        ye.P(parcel, 4, this.A, i);
        ye.W(parcel, iV);
    }
}
