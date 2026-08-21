package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k15 extends y1 {
    public static final Parcelable.Creator<k15> CREATOR = new gl4(15);
    public final long b;
    public final int f;
    public final long z;

    public k15(long j, long j2, int i) {
        this.b = j;
        this.f = i;
        this.z = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 8);
        parcel.writeLong(this.b);
        ye.U(parcel, 2, 4);
        parcel.writeInt(this.f);
        ye.U(parcel, 3, 8);
        parcel.writeLong(this.z);
        ye.W(parcel, iV);
    }
}
