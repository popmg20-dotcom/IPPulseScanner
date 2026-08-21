package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s9 implements q94 {
    public static final Parcelable.Creator<s9> CREATOR = new o3(2);
    public final String A;
    public final tn A0;
    public final String B0;
    public final boolean X;
    public final String Y;
    public final String Z;
    public String b;
    public final String f;
    public final boolean y0;
    public final int z;
    public final boolean z0;

    public s9(String str, String str2, int i, String str3, boolean z, String str4, String str5, boolean z2, boolean z3, tn tnVar, String str6) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = str2;
        this.z = i;
        this.A = str3;
        this.X = z;
        this.Y = str4;
        this.Z = str5;
        this.y0 = z2;
        this.z0 = z3;
        this.A0 = tnVar;
        this.B0 = str6;
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
    public final /* bridge */ boolean U(boolean z) {
        return dw2.p(this, z);
    }

    @Override // defpackage.q94
    public final String V() {
        return this.Y;
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
        if (!(obj instanceof s9)) {
            return false;
        }
        s9 s9Var = (s9) obj;
        return n12.c(this.b, s9Var.b) && n12.c(this.f, s9Var.f) && this.z == s9Var.z && n12.c(this.A, s9Var.A) && this.X == s9Var.X && n12.c(this.Y, s9Var.Y) && n12.c(this.Z, s9Var.Z) && this.y0 == s9Var.y0 && this.z0 == s9Var.z0 && this.A0 == s9Var.A0 && n12.c(this.B0, s9Var.B0);
    }

    @Override // defpackage.q94
    public final boolean g() {
        return this.X;
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
        int iW = (dw2.w((dw2.w(this.b.hashCode() * 31, 31, this.f) + this.z) * 31, 31, this.A) + (this.X ? 1231 : 1237)) * 31;
        String str = this.Y;
        int iHashCode = (iW + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.Z;
        int iHashCode2 = (this.A0.hashCode() + ((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.y0 ? 1231 : 1237)) * 31) + (this.z0 ? 1231 : 1237)) * 31)) * 31;
        String str3 = this.B0;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // defpackage.ea3
    public final String q() {
        return this.B0;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("AnyTls(name=", this.b, ", host=", this.f, ", port=");
        sbE.append(this.z);
        sbE.append(", password=");
        sbE.append(this.A);
        sbE.append(", skipCertVerify=");
        sbE.append(this.X);
        sbE.append(", sni=");
        sbE.append(this.Y);
        sbE.append(", serverCertFingerprintSha256=");
        sbE.append(this.Z);
        sbE.append(", reuse=");
        sbE.append(this.y0);
        sbE.append(", udpRelay=");
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
        parcel.writeInt(this.X ? 1 : 0);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        parcel.writeInt(this.y0 ? 1 : 0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeString(this.A0.name());
        parcel.writeString(this.B0);
    }
}
