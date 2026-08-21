package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class um3 implements wm3 {
    public static final Parcelable.Creator<um3> CREATOR = new ic2(27);
    public final fm3 b;
    public final String f;

    public um3(fm3 fm3Var, String str) {
        fm3Var.getClass();
        str.getClass();
        this.b = fm3Var;
        this.f = str;
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.f;
    }

    public final boolean a() {
        fm3 fm3Var = this.b;
        int i = fm3Var.f;
        if (i < 0) {
            return false;
        }
        byte[] address = fm3Var.b.getAddress();
        if (address.length != 4 && address.length != 16) {
            return false;
        }
        if (address.length != 4 || i <= 32) {
            return address.length != 16 || i <= 128;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof um3)) {
            return false;
        }
        um3 um3Var = (um3) obj;
        return n12.c(this.b, um3Var.b) && n12.c(this.f, um3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "IP-CIDR";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    @Override // defpackage.wm3
    public final boolean m(InetAddress inetAddress) {
        inetAddress.getClass();
        return this.b.m(inetAddress);
    }

    public final String toString() {
        return "CIDR(route=" + this.b + ", proxy=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        this.b.writeToParcel(parcel, i);
        parcel.writeString(this.f);
    }
}
