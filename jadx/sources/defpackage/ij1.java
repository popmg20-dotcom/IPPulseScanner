package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ij1 implements Parcelable {
    public static final Parcelable.Creator<ij1> CREATOR = new x(5);
    public final Bundle b;

    public ij1(Parcel parcel, ClassLoader classLoader) {
        Bundle bundle = parcel.readBundle();
        this.b = bundle;
        if (classLoader == null || bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.b);
    }

    public ij1(Bundle bundle) {
        this.b = bundle;
    }
}
