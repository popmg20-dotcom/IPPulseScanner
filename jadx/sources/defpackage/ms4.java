package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ms4 implements it4, q94 {
    public static final Parcelable.Creator<ms4> CREATOR = new gl4(2);
    public final String A;
    public final String A0;
    public final String B0;
    public final boolean C0;
    public final boolean D0;
    public final tn E0;
    public final String F0;
    public final boolean X;
    public final boolean Y;
    public final String Z;
    public String b;
    public final String f;
    public final Map y0;
    public final int z;
    public final boolean z0;

    public ms4(String str, String str2, int i, String str3, boolean z, boolean z2, String str4, Map map, boolean z3, String str5, String str6, boolean z4, boolean z5, tn tnVar, String str7) {
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
        this.Y = z2;
        this.Z = str4;
        this.y0 = map;
        this.z0 = z3;
        this.A0 = str5;
        this.B0 = str6;
        this.C0 = z4;
        this.D0 = z5;
        this.E0 = tnVar;
        this.F0 = str7;
        if (!lb3.c(i)) {
            e04.f(dw2.A(i, "not a valid port: "));
            throw null;
        }
        try {
            UUID.fromString(str3);
        } catch (IllegalArgumentException e) {
            st4.l(ha0.n("invalid vmess username: ", str3), e);
            throw null;
        }
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
        return this.A0;
    }

    @Override // defpackage.ea3
    public final tn X() {
        return this.E0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.ea3
    public final boolean e() {
        return this.C0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ms4)) {
            return false;
        }
        ms4 ms4Var = (ms4) obj;
        return n12.c(this.b, ms4Var.b) && n12.c(this.f, ms4Var.f) && this.z == ms4Var.z && n12.c(this.A, ms4Var.A) && this.X == ms4Var.X && this.Y == ms4Var.Y && n12.c(this.Z, ms4Var.Z) && n12.c(this.y0, ms4Var.y0) && this.z0 == ms4Var.z0 && n12.c(this.A0, ms4Var.A0) && n12.c(this.B0, ms4Var.B0) && this.C0 == ms4Var.C0 && this.D0 == ms4Var.D0 && this.E0 == ms4Var.E0 && n12.c(this.F0, ms4Var.F0);
    }

    @Override // defpackage.q94
    public final boolean g() {
        return this.z0;
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
        int iHashCode = (((this.y0.hashCode() + dw2.w((((dw2.w((dw2.w(this.b.hashCode() * 31, 31, this.f) + this.z) * 31, 31, this.A) + (this.X ? 1231 : 1237)) * 31) + (this.Y ? 1231 : 1237)) * 31, 31, this.Z)) * 31) + (this.z0 ? 1231 : 1237)) * 31;
        String str = this.A0;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.B0;
        int iHashCode3 = (this.E0.hashCode() + ((((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.C0 ? 1231 : 1237)) * 31) + (this.D0 ? 1231 : 1237)) * 31)) * 31;
        String str3 = this.F0;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // defpackage.it4
    public final boolean i() {
        return this.Y;
    }

    @Override // defpackage.ea3
    public final String q() {
        return this.F0;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Vmess(name=", this.b, ", host=", this.f, ", port=");
        sbE.append(this.z);
        sbE.append(", username=");
        sbE.append(this.A);
        sbE.append(", tls=");
        sbE.append(this.X);
        sbE.append(", ws=");
        sbE.append(this.Y);
        sbE.append(", wsPath=");
        sbE.append(this.Z);
        sbE.append(", wsHeaders=");
        sbE.append(this.y0);
        sbE.append(", skipCertVerify=");
        sbE.append(this.z0);
        sbE.append(", sni=");
        sbE.append(this.A0);
        sbE.append(", serverCertFingerprintSha256=");
        sbE.append(this.B0);
        sbE.append(", udpRelay=");
        sbE.append(this.C0);
        sbE.append(", aead=");
        sbE.append(this.D0);
        sbE.append(", blockQuic=");
        sbE.append(this.E0);
        sbE.append(", underlyingProxy=");
        return fw.y(sbE, this.F0, ")");
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
        parcel.writeInt(this.Y ? 1 : 0);
        parcel.writeString(this.Z);
        Map map = this.y0;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeString(this.A0);
        parcel.writeString(this.B0);
        parcel.writeInt(this.C0 ? 1 : 0);
        parcel.writeInt(this.D0 ? 1 : 0);
        parcel.writeString(this.E0.name());
        parcel.writeString(this.F0);
    }
}
