package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gy3 extends y {
    public static final Parcelable.Creator<gy3> CREATOR = new x(13);
    public int A;
    public boolean z;

    public gy3(Parcel parcel) {
        super(parcel, null);
        this.z = parcel.readInt() != 0;
        this.A = parcel.readInt();
    }

    @Override // defpackage.y, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.z ? 1 : 0);
        parcel.writeInt(this.A);
    }
}
