package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cn3 implements hn3 {
    public static final Parcelable.Creator<cn3> CREATOR = new ym3(2);
    public final int b;
    public final String f;

    public cn3(int i, String str) {
        str.getClass();
        this.b = i;
        this.f = str;
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
        if (!(obj instanceof cn3)) {
            return false;
        }
        cn3 cn3Var = (cn3) obj;
        return this.b == cn3Var.b && n12.c(this.f, cn3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "MISC-DEST-PORT";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b * 31);
    }

    public final String toString() {
        return "DestPort(destPort=" + this.b + ", proxy=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.b);
        parcel.writeString(this.f);
    }
}
