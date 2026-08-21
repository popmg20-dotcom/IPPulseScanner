package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qr3 extends u23 {
    public static final Parcelable.Creator<qr3> CREATOR = new ym3(15);
    public int b;
    public int f;
    public int z;

    public qr3(Parcel parcel) {
        super(parcel);
        this.b = parcel.readInt();
        this.f = parcel.readInt();
        this.z = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
        parcel.writeInt(this.z);
    }
}
