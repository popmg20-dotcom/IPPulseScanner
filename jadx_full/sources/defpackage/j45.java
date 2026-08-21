package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j45 extends y1 {
    public static final Parcelable.Creator<j45> CREATOR = new gl4(23);
    public final Bundle A;
    public final String X;
    public final long b;
    public final long f;
    public final boolean z;

    public j45(long j, long j2, boolean z, Bundle bundle, String str) {
        this.b = j;
        this.f = j2;
        this.z = z;
        this.A = bundle;
        this.X = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 8);
        parcel.writeLong(this.b);
        ye.U(parcel, 2, 8);
        parcel.writeLong(this.f);
        ye.U(parcel, 3, 4);
        parcel.writeInt(this.z ? 1 : 0);
        ye.N(parcel, 7, this.A);
        ye.Q(parcel, 8, this.X);
        ye.W(parcel, iV);
    }
}
