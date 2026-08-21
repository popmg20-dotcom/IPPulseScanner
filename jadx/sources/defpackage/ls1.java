package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ls1 implements Parcelable {
    public static final Parcelable.Creator<ls1> CREATOR = new o3(14);
    public int b;
    public final String f;
    public final String z;

    public ls1(String str, int i, String str2) {
        str.getClass();
        str2.getClass();
        this.b = i;
        this.f = str;
        this.z = str2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ls1)) {
            return false;
        }
        ls1 ls1Var = (ls1) obj;
        return this.b == ls1Var.b && n12.c(this.f, ls1Var.f) && n12.c(this.z, ls1Var.z);
    }

    public final int hashCode() {
        return this.z.hashCode() + dw2.w(this.b * 31, 31, this.f);
    }

    public final String toString() {
        int i = this.b;
        StringBuilder sb = new StringBuilder("Host(id=");
        sb.append(i);
        sb.append(", key=");
        sb.append(this.f);
        sb.append(", value=");
        return fw.y(sb, this.z, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.b);
        parcel.writeString(this.f);
        parcel.writeString(this.z);
    }
}
