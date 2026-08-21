package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zq4 extends View.BaseSavedState {
    public static final Parcelable.Creator<zq4> CREATOR = new x(16);
    public int b;
    public int f;
    public Parcelable z;

    public zq4(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.b = parcel.readInt();
        this.f = parcel.readInt();
        this.z = parcel.readParcelable(classLoader);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
        parcel.writeParcelable(this.z, i);
    }
}
