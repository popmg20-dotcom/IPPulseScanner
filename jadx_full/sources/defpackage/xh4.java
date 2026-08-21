package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xh4 implements q94, it4 {
    public static final Parcelable.Creator<xh4> CREATOR = new ym3(24);
    public final String A;
    public final String A0;
    public final boolean B0;
    public final tn C0;
    public final String D0;
    public final boolean X;
    public final String Y;
    public final Map Z;
    public String b;
    public final String f;
    public final boolean y0;
    public final int z;
    public final String z0;

    public xh4(String str, String str2, int i, String str3, boolean z, String str4, Map map, boolean z2, String str5, String str6, boolean z3, tn tnVar, String str7) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = str2;
        this.z = i;
        this.A = str3;
        this.X = z;
        this.Y = str4;
        this.Z = map;
        this.y0 = z2;
        this.z0 = str5;
        this.A0 = str6;
        this.B0 = z3;
        this.C0 = tnVar;
        this.D0 = str7;
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
        return this.z0;
    }

    @Override // defpackage.ea3
    public final tn X() {
        return this.C0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.ea3
    public final boolean e() {
        return this.B0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xh4)) {
            return false;
        }
        xh4 xh4Var = (xh4) obj;
        return n12.c(this.b, xh4Var.b) && n12.c(this.f, xh4Var.f) && this.z == xh4Var.z && n12.c(this.A, xh4Var.A) && this.X == xh4Var.X && n12.c(this.Y, xh4Var.Y) && n12.c(this.Z, xh4Var.Z) && this.y0 == xh4Var.y0 && n12.c(this.z0, xh4Var.z0) && n12.c(this.A0, xh4Var.A0) && this.B0 == xh4Var.B0 && this.C0 == xh4Var.C0 && n12.c(this.D0, xh4Var.D0);
    }

    @Override // defpackage.q94
    public final boolean g() {
        return this.y0;
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
        int iHashCode = (((this.Z.hashCode() + dw2.w((dw2.w((dw2.w(this.b.hashCode() * 31, 31, this.f) + this.z) * 31, 31, this.A) + (this.X ? 1231 : 1237)) * 31, 31, this.Y)) * 31) + (this.y0 ? 1231 : 1237)) * 31;
        String str = this.z0;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.A0;
        int iHashCode3 = (this.C0.hashCode() + ((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.B0 ? 1231 : 1237)) * 31)) * 31;
        String str3 = this.D0;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // defpackage.it4
    public final boolean i() {
        return this.X;
    }

    @Override // defpackage.ea3
    public final String q() {
        return this.D0;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Trojan(name=", this.b, ", host=", this.f, ", port=");
        sbE.append(this.z);
        sbE.append(", password=");
        sbE.append(this.A);
        sbE.append(", ws=");
        sbE.append(this.X);
        sbE.append(", wsPath=");
        sbE.append(this.Y);
        sbE.append(", wsHeaders=");
        sbE.append(this.Z);
        sbE.append(", skipCertVerify=");
        sbE.append(this.y0);
        sbE.append(", sni=");
        ha0.v(sbE, this.z0, ", serverCertFingerprintSha256=", this.A0, ", udpRelay=");
        sbE.append(this.B0);
        sbE.append(", blockQuic=");
        sbE.append(this.C0);
        sbE.append(", underlyingProxy=");
        return fw.y(sbE, this.D0, ")");
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
        Map map = this.Z;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
        parcel.writeInt(this.y0 ? 1 : 0);
        parcel.writeString(this.z0);
        parcel.writeString(this.A0);
        parcel.writeInt(this.B0 ? 1 : 0);
        parcel.writeString(this.C0.name());
        parcel.writeString(this.D0);
    }
}
