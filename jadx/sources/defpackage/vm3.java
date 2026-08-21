package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vm3 implements wm3 {
    public static final Parcelable.Creator<vm3> CREATOR = new ic2(28);
    public final String b;
    public final String f;

    public vm3(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.b = str;
        this.f = str2;
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
        if (!(obj instanceof vm3)) {
            return false;
        }
        vm3 vm3Var = (vm3) obj;
        return n12.c(this.b, vm3Var.b) && n12.c(this.f, vm3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "GEOIP";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    @Override // defpackage.wm3
    public final boolean m(InetAddress inetAddress) {
        inetAddress.getClass();
        zm1 zm1Var = an1.a;
        zm1Var.getClass();
        String str = this.b;
        str.getClass();
        return str.equals(zm1Var.d(inetAddress));
    }

    public final String toString() {
        return fw.v("GEO(code=", this.b, ", proxy=", this.f, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
    }
}
