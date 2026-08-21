package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zy3 implements ea3 {
    public static final Parcelable.Creator<zy3> CREATOR = new ym3(18);
    public final String A;
    public final String X;
    public final boolean Y;
    public final tn Z;
    public String b;
    public final String f;
    public final String y0;
    public final int z;

    public zy3(String str, String str2, int i, String str3, String str4, boolean z, tn tnVar, String str5) {
        str.getClass();
        str2.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = str2;
        this.z = i;
        this.A = str3;
        this.X = str4;
        this.Y = z;
        this.Z = tnVar;
        this.y0 = str5;
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

    @Override // defpackage.ea3
    public final tn X() {
        return this.Z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.ea3
    public final boolean e() {
        return this.Y;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zy3)) {
            return false;
        }
        zy3 zy3Var = (zy3) obj;
        return n12.c(this.b, zy3Var.b) && n12.c(this.f, zy3Var.f) && this.z == zy3Var.z && n12.c(this.A, zy3Var.A) && n12.c(this.X, zy3Var.X) && this.Y == zy3Var.Y && this.Z == zy3Var.Z && n12.c(this.y0, zy3Var.y0);
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
        int iHashCode2 = (this.Z.hashCode() + ((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + (this.Y ? 1231 : 1237)) * 31)) * 31;
        String str3 = this.y0;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // defpackage.ea3
    public final String q() {
        return this.y0;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Socks5(name=", this.b, ", host=", this.f, ", port=");
        sbE.append(this.z);
        sbE.append(", username=");
        sbE.append(this.A);
        sbE.append(", password=");
        sbE.append(this.X);
        sbE.append(", udpRelay=");
        sbE.append(this.Y);
        sbE.append(", blockQuic=");
        sbE.append(this.Z);
        sbE.append(", underlyingProxy=");
        sbE.append(this.y0);
        sbE.append(")");
        return sbE.toString();
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
        parcel.writeString(this.Z.name());
        parcel.writeString(this.y0);
    }
}
