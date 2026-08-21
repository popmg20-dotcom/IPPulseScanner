package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gi2 extends y {
    public static final Parcelable.Creator<gi2> CREATOR = new x(6);
    public boolean z;

    public gi2(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        if (classLoader == null) {
            gi2.class.getClassLoader();
        }
        this.z = parcel.readInt() == 1;
    }

    @Override // defpackage.y, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.z ? 1 : 0);
    }
}
