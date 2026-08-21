package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ie5 extends y1 {
    public static final Parcelable.Creator<ie5> CREATOR = new ke5(0);
    public final Bundle A;
    public final int X;
    public final long Y;
    public String Z;
    public final long b;
    public byte[] f;
    public final String z;

    public ie5(long j, byte[] bArr, String str, Bundle bundle, int i, long j2, String str2) {
        this.b = j;
        this.f = bArr;
        this.z = str;
        this.A = bundle;
        this.X = i;
        this.Y = j2;
        this.Z = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 8);
        parcel.writeLong(this.b);
        byte[] bArr = this.f;
        if (bArr != null) {
            int iV2 = ye.V(parcel, 2);
            parcel.writeByteArray(bArr);
            ye.W(parcel, iV2);
        }
        ye.Q(parcel, 3, this.z);
        ye.N(parcel, 4, this.A);
        ye.U(parcel, 5, 4);
        parcel.writeInt(this.X);
        ye.U(parcel, 6, 8);
        parcel.writeLong(this.Y);
        ye.Q(parcel, 7, this.Z);
        ye.W(parcel, iV);
    }
}
