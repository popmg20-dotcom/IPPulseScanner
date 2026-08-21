package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kn3 implements qn3 {
    public static final Parcelable.Creator<kn3> CREATOR = new ym3(8);
    public final String b;
    public final String f;

    public kn3(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.b = str;
        this.f = str2;
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.f;
    }

    @Override // defpackage.qn3
    public final /* bridge */ boolean c(String str, String str2, List list, on3 on3Var, e03 e03Var) {
        return dw2.l(this, str, str2, list, on3Var, e03Var);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kn3)) {
            return false;
        }
        kn3 kn3Var = (kn3) obj;
        return n12.c(this.b, kn3Var.b) && n12.c(this.f, kn3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "SUBNET-BSSID";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return fw.v("BSSID(bssid=", this.b, ", proxy=", this.f, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
    }
}
