package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f82 implements Parcelable {
    public static final Parcelable.Creator<f82> CREATOR = new o3(28);
    public final String b;
    public final String f;
    public final String z;

    public f82(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.b = str;
        this.f = str2;
        this.z = str3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f82)) {
            return false;
        }
        f82 f82Var = (f82) obj;
        return n12.c(this.b, f82Var.b) && n12.c(this.f, f82Var.f) && n12.c(this.z, f82Var.z);
    }

    public final int hashCode() {
        return this.z.hashCode() + dw2.w(this.b.hashCode() * 31, 31, this.f);
    }

    public final String toString() {
        return fw.y(fw.E("Key(profileName=", this.b, ", groupName=", this.f, ", proxyName="), this.z, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        parcel.writeString(this.z);
    }
}
