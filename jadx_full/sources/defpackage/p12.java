package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p12 implements zk {
    public static final Parcelable.Creator<p12> CREATOR = new o3(27);
    public xf2 A;
    public final String X;
    public final String b;
    public final long f;
    public int z;

    public p12(String str, long j, int i, xf2 xf2Var, String str2) {
        str.getClass();
        this.b = str;
        this.f = j;
        this.z = i;
        this.A = xf2Var;
        this.X = str2;
    }

    public static p12 a(p12 p12Var, String str) {
        long j = p12Var.f;
        int i = p12Var.z;
        xf2 xf2Var = p12Var.A;
        String str2 = p12Var.X;
        str.getClass();
        return new p12(str, j, i, xf2Var, str2);
    }

    @Override // defpackage.zk
    public final int O() {
        return this.z;
    }

    @Override // defpackage.zk
    public final long W() {
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
        if (!p12.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        p12 p12Var = (p12) obj;
        if (n12.c(this.b, p12Var.b) && this.f == p12Var.f && n12.c(this.X, p12Var.X) && this.z == p12Var.z) {
            return n12.c(this.A, p12Var.A);
        }
        return false;
    }

    @Override // defpackage.zk
    public final String getName() {
        return this.b;
    }

    @Override // defpackage.zk
    public final void h() {
        this.A = null;
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        long j = this.f;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        String str = this.X;
        int iHashCode2 = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.z) * 31;
        xf2 xf2Var = this.A;
        return iHashCode2 + (xf2Var != null ? xf2Var.hashCode() : 0);
    }

    @Override // defpackage.zk
    public final xf2 j() {
        return this.A;
    }

    @Override // defpackage.zk
    public final void o(int i) {
        this.z = i;
    }

    public final String toString() {
        int i = this.z;
        xf2 xf2Var = this.A;
        StringBuilder sb = new StringBuilder("InvalidProfile(name=");
        sb.append(this.b);
        sb.append(", lastModified=");
        sb.append(this.f);
        sb.append(", contentHash=");
        sb.append(i);
        sb.append(", managedConfig=");
        sb.append(xf2Var);
        return fw.z(sb, ", invalidReason=", this.X, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeLong(this.f);
        parcel.writeInt(this.z);
        xf2 xf2Var = this.A;
        if (xf2Var == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            xf2Var.writeToParcel(parcel, i);
        }
        parcel.writeString(this.X);
    }
}
