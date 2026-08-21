package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gn3 implements hn3 {
    public static final Parcelable.Creator<gn3> CREATOR = new ym3(5);
    public final String b;
    public final String f;

    public gn3(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.b = str;
        this.f = str2;
    }

    @Override // defpackage.hn3
    public final /* bridge */ boolean B(String str, Integer num, int i, int i2) {
        return dw2.k(this, str, num, i, i2);
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gn3)) {
            return false;
        }
        gn3 gn3Var = (gn3) obj;
        return n12.c(this.b, gn3Var.b) && n12.c(this.f, gn3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "MISC-SRC-IP";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return fw.v("SrcIP(srcIP=", this.b, ", proxy=", this.f, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
    }
}
