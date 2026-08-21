package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zm3 implements bn3 {
    public static final Parcelable.Creator<zm3> CREATOR = new ym3(0);
    public final tn3 b;
    public final String f;
    public final List z;

    public zm3(tn3 tn3Var, String str) {
        tn3Var.getClass();
        str.getClass();
        this.b = tn3Var;
        this.f = str;
        this.z = p95.x(tn3Var);
    }

    @Override // defpackage.bn3
    public final /* bridge */ boolean H(String str, String str2, InetAddress inetAddress, String str3, String str4, List list, on3 on3Var, e03 e03Var, String str5, Integer num, Integer num2, Integer num3, String str6, int i) {
        return dw2.j(this, str, str2, inetAddress, str3, str4, list, on3Var, e03Var, str5, num, num2, num3, str6, i);
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
        if (!(obj instanceof zm3)) {
            return false;
        }
        zm3 zm3Var = (zm3) obj;
        return n12.c(this.b, zm3Var.b) && n12.c(this.f, zm3Var.f);
    }

    @Override // defpackage.bn3
    public final List getRules() {
        return this.z;
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "NOT";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "Not(rule=" + this.b + ", proxy=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.f);
    }
}
