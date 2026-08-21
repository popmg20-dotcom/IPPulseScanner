package defpackage;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lz4 extends y1 {
    public static final Parcelable.Creator<lz4> CREATOR = new gl4(7);
    public final int b;
    public final int f;
    public final Intent z;

    public lz4(int i, int i2, Intent intent) {
        this.b = i;
        this.f = i2;
        this.z = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.U(parcel, 2, 4);
        parcel.writeInt(this.f);
        ye.P(parcel, 3, this.z, i);
        ye.W(parcel, iV);
    }
}
