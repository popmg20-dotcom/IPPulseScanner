package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ln3 implements qn3 {
    public static final Parcelable.Creator<ln3> CREATOR = new ym3(9);
    public final int b;
    public final int f;
    public final String z;

    public ln3(int i, int i2, String str) {
        str.getClass();
        this.b = i;
        this.f = i2;
        this.z = str;
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.z;
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
        if (!(obj instanceof ln3)) {
            return false;
        }
        ln3 ln3Var = (ln3) obj;
        return this.b == ln3Var.b && this.f == ln3Var.f && n12.c(this.z, ln3Var.z);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "SUBNET-MCCMNC";
    }

    public final int hashCode() {
        return this.z.hashCode() + (((this.b * 31) + this.f) * 31);
    }

    public final String toString() {
        return fw.y(fw.A(this.b, this.f, "MCCMNC(mcc=", ", mnc=", ", proxy="), this.z, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
        parcel.writeString(this.z);
    }
}
