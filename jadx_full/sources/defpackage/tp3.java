package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tp3 implements Parcelable {
    public static final Parcelable.Creator<tp3> CREATOR = new ym3(14);
    public final int b;
    public final int f;

    public tp3(int i, int i2) {
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
        if (!(obj instanceof tp3)) {
            return false;
        }
        tp3 tp3Var = (tp3) obj;
        return this.b == tp3Var.b && this.f == tp3Var.f;
    }

    public final int hashCode() {
        return (this.b * 31) + this.f;
    }

    public final String toString() {
        return "ScanConfig(titleResId=" + this.b + ", iconResId=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
    }
}
