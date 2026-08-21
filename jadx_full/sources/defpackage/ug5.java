package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ug5 extends y1 {
    public static final Parcelable.Creator<ug5> CREATOR = new ke5(5);
    public final int A;
    public final long X;
    public final boolean b;
    public final String f;
    public final int z;

    public ug5(boolean z, String str, int i, int i2, long j) {
        this.b = z;
        this.f = str;
        this.z = fx3.R(i) - 1;
        this.A = r25.Z(i2) - 1;
        this.X = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b ? 1 : 0);
        ye.Q(parcel, 2, this.f);
        ye.U(parcel, 3, 4);
        parcel.writeInt(this.z);
        ye.U(parcel, 4, 4);
        parcel.writeInt(this.A);
        ye.U(parcel, 5, 8);
        parcel.writeLong(this.X);
        ye.W(parcel, iV);
    }
}
