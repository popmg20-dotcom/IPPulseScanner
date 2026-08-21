package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x14 implements Parcelable {
    public static final Parcelable.Creator<x14> CREATOR = new ym3(21);
    public int[] A;
    public boolean A0;
    public int X;
    public int[] Y;
    public ArrayList Z;
    public int b;
    public int f;
    public boolean y0;
    public int z;
    public boolean z0;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
        parcel.writeInt(this.z);
        if (this.z > 0) {
            parcel.writeIntArray(this.A);
        }
        parcel.writeInt(this.X);
        if (this.X > 0) {
            parcel.writeIntArray(this.Y);
        }
        parcel.writeInt(this.y0 ? 1 : 0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeInt(this.A0 ? 1 : 0);
        parcel.writeList(this.Z);
    }
}
