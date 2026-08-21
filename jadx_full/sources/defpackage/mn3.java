package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mn3 implements qn3 {
    public static final Parcelable.Creator<mn3> CREATOR = new ym3(10);
    public final InetAddress b;
    public final String f;

    public mn3(InetAddress inetAddress, String str) {
        inetAddress.getClass();
        str.getClass();
        this.b = inetAddress;
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
        if (!(obj instanceof mn3)) {
            return false;
        }
        mn3 mn3Var = (mn3) obj;
        return n12.c(this.b, mn3Var.b) && n12.c(this.f, mn3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "SUBNET-ROUTER";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "Router(ip=" + this.b + ", proxy=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeSerializable(this.b);
        parcel.writeString(this.f);
    }
}
