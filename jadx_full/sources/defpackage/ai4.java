package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ai4 implements q94 {
    public static final Parcelable.Creator<ai4> CREATOR = new ym3(25);
    public final String A;
    public final String A0;
    public final String B0;
    public final boolean C0;
    public final tn D0;
    public final String E0;
    public final String X;
    public final String Y;
    public final List Z;
    public String b;
    public final String f;
    public final Integer y0;
    public final int z;
    public final boolean z0;

    public ai4(String str, String str2, int i, String str3, String str4, String str5, ArrayList arrayList, Integer num, boolean z, String str6, String str7, boolean z2, tn tnVar, String str8) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = str2;
        this.z = i;
        this.A = str3;
        this.X = str4;
        this.Y = str5;
        this.Z = arrayList;
        this.y0 = num;
        this.z0 = z;
        this.A0 = str6;
        this.B0 = str7;
        this.C0 = z2;
        this.D0 = tnVar;
        this.E0 = str8;
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
        return this.A0;
    }

    @Override // defpackage.ea3
    public final tn X() {
        return this.D0;
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
        if (!(obj instanceof ai4)) {
            return false;
        }
        ai4 ai4Var = (ai4) obj;
        return n12.c(this.b, ai4Var.b) && n12.c(this.f, ai4Var.f) && this.z == ai4Var.z && n12.c(this.A, ai4Var.A) && n12.c(this.X, ai4Var.X) && n12.c(this.Y, ai4Var.Y) && n12.c(this.Z, ai4Var.Z) && n12.c(this.y0, ai4Var.y0) && this.z0 == ai4Var.z0 && n12.c(this.A0, ai4Var.A0) && n12.c(this.B0, ai4Var.B0) && this.C0 == ai4Var.C0 && this.D0 == ai4Var.D0 && n12.c(this.E0, ai4Var.E0);
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
        int iW = dw2.w(dw2.w((dw2.w(this.b.hashCode() * 31, 31, this.f) + this.z) * 31, 31, this.A), 31, this.X);
        String str = this.Y;
        int iHashCode = (iW + (str == null ? 0 : str.hashCode())) * 31;
        List list = this.Z;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.y0;
        int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + (this.z0 ? 1231 : 1237)) * 31;
        String str2 = this.A0;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.B0;
        int iHashCode5 = (this.D0.hashCode() + ((((iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + (this.C0 ? 1231 : 1237)) * 31)) * 31;
        String str4 = this.E0;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    @Override // defpackage.ea3
    public final String q() {
        return this.E0;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("TuicV5(name=", this.b, ", host=", this.f, ", port=");
        sbE.append(this.z);
        sbE.append(", uuid=");
        sbE.append(this.A);
        sbE.append(", password=");
        ha0.v(sbE, this.X, ", alpn=", this.Y, ", portHopping=");
        sbE.append(this.Z);
        sbE.append(", portHoppingInterval=");
        sbE.append(this.y0);
        sbE.append(", skipCertVerify=");
        sbE.append(this.z0);
        sbE.append(", sni=");
        sbE.append(this.A0);
        sbE.append(", serverCertFingerprintSha256=");
        sbE.append(this.B0);
        sbE.append(", udpRelay=");
        sbE.append(this.C0);
        sbE.append(", blockQuic=");
        sbE.append(this.D0);
        sbE.append(", underlyingProxy=");
        sbE.append(this.E0);
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
        parcel.writeString(this.Y);
        List list = this.Z;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((i23) it.next()).writeToParcel(parcel, i);
            }
        }
        Integer num = this.y0;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeString(this.A0);
        parcel.writeString(this.B0);
        parcel.writeInt(this.C0 ? 1 : 0);
        parcel.writeString(this.D0.name());
        parcel.writeString(this.E0);
    }
}
