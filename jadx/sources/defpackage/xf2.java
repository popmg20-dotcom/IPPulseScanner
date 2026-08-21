package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xf2 implements Parcelable {
    public static final Parcelable.Creator<xf2> CREATOR = new ic2(1);
    public final String b;
    public final long f;
    public final boolean z;

    public xf2(String str, boolean z, long j) {
        str.getClass();
        this.b = str;
        this.f = j;
        this.z = z;
    }

    public final boolean a() {
        try {
            String host = new URL(this.b).getHost();
            if (!n12.c(host, "127.0.0.1")) {
                if (!n12.c(host, "localhost")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xf2)) {
            return false;
        }
        xf2 xf2Var = (xf2) obj;
        return n12.c(this.b, xf2Var.b) && this.f == xf2Var.f && this.z == xf2Var.z;
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        long j = this.f;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + (this.z ? 1231 : 1237);
    }

    public final String toString() {
        return "ManagedConfig(url=" + this.b + ", interval=" + this.f + ", strict=" + this.z + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeLong(this.f);
        parcel.writeInt(this.z ? 1 : 0);
    }
}
