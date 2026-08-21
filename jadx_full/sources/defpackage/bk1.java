package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bk1 implements Parcelable {
    public static final Parcelable.Creator<bk1> CREATOR = new o3(11);
    public int A;
    public String X;
    public ArrayList Y;
    public ArrayList Z;
    public ArrayList b;
    public ArrayList f;
    public ArrayList y0;
    public b[] z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.b);
        parcel.writeStringList(this.f);
        parcel.writeTypedArray(this.z, i);
        parcel.writeInt(this.A);
        parcel.writeString(this.X);
        parcel.writeStringList(this.Y);
        parcel.writeTypedList(this.Z);
        parcel.writeTypedList(this.y0);
    }
}
