package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.bp4;
import defpackage.cp4;
import defpackage.ic2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new ic2(8);
    public final cp4 b;

    public ParcelImpl(Parcel parcel) {
        this.b = new bp4(parcel).g();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new bp4(parcel).i(this.b);
    }
}
