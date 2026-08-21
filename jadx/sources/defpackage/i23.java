package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i23 implements Parcelable {
    public static final Parcelable.Creator<i23> CREATOR = new ic2(9);
    public final int b;
    public final int f;

    public i23(int i, int i2) {
        this.b = i;
        this.f = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i23)) {
            return false;
        }
        i23 i23Var = (i23) obj;
        return this.b == i23Var.b && this.f == i23Var.f;
    }

    public final int hashCode() {
        return (this.b * 31) + this.f;
    }

    public final String toString() {
        int i = this.b;
        int i2 = this.f;
        if (i == i2) {
            return String.valueOf(i);
        }
        return i + "-" + i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
    }
}
