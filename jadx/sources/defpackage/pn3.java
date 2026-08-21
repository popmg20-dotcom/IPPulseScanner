package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pn3 implements qn3 {
    public static final Parcelable.Creator<pn3> CREATOR = new ym3(12);
    public final on3 b;
    public final String f;

    public pn3(on3 on3Var, String str) {
        on3Var.getClass();
        str.getClass();
        this.b = on3Var;
        this.f = str;
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
        if (!(obj instanceof pn3)) {
            return false;
        }
        pn3 pn3Var = (pn3) obj;
        return this.b == pn3Var.b && n12.c(this.f, pn3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "SUBNET-TYPE";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "Type(network=" + this.b + ", proxy=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b.name());
        parcel.writeString(this.f);
    }
}
