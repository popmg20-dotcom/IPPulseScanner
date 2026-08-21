package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xl3 extends y1 {
    public static final Parcelable.Creator<xl3> CREATOR = new gl4(16);
    public final int A;
    public final int X;
    public final int b;
    public final boolean f;
    public final boolean z;

    public xl3(int i, int i2, int i3, boolean z, boolean z2) {
        this.b = i;
        this.f = z;
        this.z = z2;
        this.A = i2;
        this.X = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.U(parcel, 2, 4);
        parcel.writeInt(this.f ? 1 : 0);
        ye.U(parcel, 3, 4);
        parcel.writeInt(this.z ? 1 : 0);
        ye.U(parcel, 4, 4);
        parcel.writeInt(this.A);
        ye.U(parcel, 5, 4);
        parcel.writeInt(this.X);
        ye.W(parcel, iV);
    }
}
