package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tm3 implements tn3 {
    public static final Parcelable.Creator<tm3> CREATOR = new ic2(26);
    public final String b;

    public tm3(String str) {
        str.getClass();
        this.b = str;
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof tm3) && n12.c(this.b, ((tm3) obj).b);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "FINAL";
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return ha0.o("Final(proxy=", this.b, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
    }
}
