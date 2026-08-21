package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.system.OsConstants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class az3 implements q94 {
    public static final Parcelable.Creator<az3> CREATOR = new ym3(19);
    public final String A;
    public final tn A0;
    public final String B0;
    public final String X;
    public final boolean Y;
    public final String Z;
    public String b;
    public final String f;
    public final String y0;
    public final int z;
    public final boolean z0;

    public az3(String str, String str2, int i, String str3, String str4, boolean z, String str5, String str6, boolean z2, tn tnVar, String str7) {
        str.getClass();
        str2.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = str2;
        this.z = i;
        this.A = str3;
        this.X = str4;
        this.Y = z;
        this.Z = str5;
        this.y0 = str6;
        this.z0 = z2;
        this.A0 = tnVar;
        this.B0 = str7;
        if (lb3.c(i)) {
            return;
        }
        e04.f(dw2.A(i, "not a valid port: "));
        throw null;
    }

    @Override // defpackage.ea3
    public final /* bridge */ boolean A(t53 t53Var, Map map, boolean z) {
        return dw2.q(this, t53Var, map, z);
    }

    @Override // defpackage.ea3
    public final String C() {
        return this.b;
    }

    @Override // defpackage.ea3
    public final void K(String str) {
        str.getClass();
        this.b = str;
    }

    @Override // defpackage.ea3
    public final boolean U(boolean z) {
        return 17 == OsConstants.IPPROTO_TCP;
    }

    @Override // defpackage.q94
    public final String V() {
        return this.Z;
    }

    @Override // defpackage.ea3
    public final tn X() {
        return this.A0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.ea3
    public final boolean e() {
        return this.z0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof az3)) {
            return false;
        }
        az3 az3Var = (az3) obj;
        return n12.c(this.b, az3Var.b) && n12.c(this.f, az3Var.f) && this.z == az3Var.z && n12.c(this.A, az3Var.A) && n12.c(this.X, az3Var.X) && this.Y == az3Var.Y && n12.c(this.Z, az3Var.Z) && n12.c(this.y0, az3Var.y0) && this.z0 == az3Var.z0 && this.A0 == az3Var.A0 && n12.c(this.B0, az3Var.B0);
    }

    @Override // defpackage.q94
    public final boolean g() {
        return this.Y;
    }

    @Override // defpackage.ea3
    public final String getName() {
        return this.b;
    }

    @Override // defpackage.ea3
    public final /* bridge */ String getType() {
        return dw2.g(this);
    }

    public final int hashCode() {
        int iW = (dw2.w(this.b.hashCode() * 31, 31, this.f) + this.z) * 31;
        String str = this.A;
        int iHashCode = (iW + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.X;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.Y ? 1231 : 1237)) * 31;
        String str3 = this.Z;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.y0;
        int iHashCode4 = (this.A0.hashCode() + ((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + (this.z0 ? 1231 : 1237)) * 31)) * 31;
        String str5 = this.B0;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    @Override // defpackage.ea3
    public final String q() {
        return this.B0;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Socks5Tls(name=", this.b, ", host=", this.f, ", port=");
        sbE.append(this.z);
        sbE.append(", username=");
        sbE.append(this.A);
        sbE.append(", password=");
        sbE.append(this.X);
        sbE.append(", skipCertVerify=");
        sbE.append(this.Y);
        sbE.append(", sni=");
        ha0.v(sbE, this.Z, ", serverCertFingerprintSha256=", this.y0, ", udpRelay=");
        sbE.append(this.z0);
        sbE.append(", blockQuic=");
        sbE.append(this.A0);
        sbE.append(", underlyingProxy=");
        return fw.y(sbE, this.B0, ")");
    }

    @Override // defpackage.ea3
    public final /* bridge */ boolean v() {
        return dw2.h(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        parcel.writeInt(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.X);
        parcel.writeInt(this.Y ? 1 : 0);
        parcel.writeString(this.Z);
        parcel.writeString(this.y0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeString(this.A0.name());
        parcel.writeString(this.B0);
    }

    public /* synthetic */ az3(String str, String str2, int i, String str3, String str4, boolean z, String str5, String str6, tn tnVar, String str7) {
        this(str, str2, i, str3, str4, z, str5, str6, false, tnVar, str7);
    }
}
