package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h03 implements Parcelable {
    public static final Parcelable.Creator<h03> CREATOR = new ic2(7);
    public final g03 A;
    public final String b;
    public final String f;
    public final String z;

    public h03(String str, String str2, String str3, g03 g03Var) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.b = str;
        this.f = str2;
        this.z = str3;
        this.A = g03Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h03)) {
            return false;
        }
        h03 h03Var = (h03) obj;
        return n12.c(this.b, h03Var.b) && n12.c(this.f, h03Var.f) && n12.c(this.z, h03Var.z) && this.A == h03Var.A;
    }

    public final int hashCode() {
        int iW = dw2.w(dw2.w(this.b.hashCode() * 31, 31, this.f), 31, this.z);
        g03 g03Var = this.A;
        return iW + (g03Var == null ? 0 : g03Var.hashCode());
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Panel(name=", this.b, ", title=", this.f, ", content=");
        sbE.append(this.z);
        sbE.append(", style=");
        sbE.append(this.A);
        sbE.append(")");
        return sbE.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        parcel.writeString(this.z);
        g03 g03Var = this.A;
        if (g03Var == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(g03Var.name());
        }
    }
}
