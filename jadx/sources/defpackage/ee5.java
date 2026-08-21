package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ee5 extends y1 {
    public static final Parcelable.Creator<ee5> CREATOR = new gl4(29);
    public final String b;
    public final long f;
    public final int z;

    public ee5(int i, long j, String str) {
        this.b = str;
        this.f = j;
        this.z = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.Q(parcel, 1, this.b);
        ye.U(parcel, 2, 8);
        parcel.writeLong(this.f);
        ye.U(parcel, 3, 4);
        parcel.writeInt(this.z);
        ye.W(parcel, iV);
    }
}
