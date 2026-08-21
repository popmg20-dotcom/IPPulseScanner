package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class y implements Parcelable {
    public final Parcelable b;
    public static final w f = new w();
    public static final Parcelable.Creator<y> CREATOR = new x(0);

    public y(Parcelable parcelable) {
        if (parcelable != null) {
            this.b = parcelable == f ? null : parcelable;
        } else {
            xe.k("superState must not be null");
            throw null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.b, i);
    }

    public y() {
        this.b = null;
    }

    public y(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.b = parcelable == null ? f : parcelable;
    }
}
