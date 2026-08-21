package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dm2 extends y1 {
    public static final Parcelable.Creator<dm2> CREATOR = new gl4(11);
    public final long A;
    public final long X;
    public final String Y;
    public final String Z;
    public final int b;
    public final int f;
    public final int y0;
    public final int z;
    public final int z0;

    public dm2(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.b = i;
        this.f = i2;
        this.z = i3;
        this.A = j;
        this.X = j2;
        this.Y = str;
        this.Z = str2;
        this.y0 = i4;
        this.z0 = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.U(parcel, 2, 4);
        parcel.writeInt(this.f);
        ye.U(parcel, 3, 4);
        parcel.writeInt(this.z);
        ye.U(parcel, 4, 8);
        parcel.writeLong(this.A);
        ye.U(parcel, 5, 8);
        parcel.writeLong(this.X);
        ye.Q(parcel, 6, this.Y);
        ye.Q(parcel, 7, this.Z);
        ye.U(parcel, 8, 4);
        parcel.writeInt(this.y0);
        ye.U(parcel, 9, 4);
        parcel.writeInt(this.z0);
        ye.W(parcel, iV);
    }
}
