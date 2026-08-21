package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tp2 extends y {
    public static final Parcelable.Creator<tp2> CREATOR = new x(7);
    public Bundle z;

    public tp2(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.z = parcel.readBundle(classLoader == null ? tp2.class.getClassLoader() : classLoader);
    }

    @Override // defpackage.y, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeBundle(this.z);
    }
}
