package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fw4 implements ea3 {
    public static final Parcelable.Creator<fw4> CREATOR = new gl4(4);
    public final String A;
    public final LinkedHashSet X;
    public final int Y;
    public final ew4 Z;
    public String b;
    public final String f;
    public final boolean y0;
    public final String z;
    public final tn z0;

    public fw4(String str, String str2, String str3, String str4, LinkedHashSet linkedHashSet, int i, ew4 ew4Var, boolean z, tn tnVar) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        ew4Var.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = str2;
        this.z = str3;
        this.A = str4;
        this.X = linkedHashSet;
        this.Y = i;
        this.Z = ew4Var;
        this.y0 = z;
        this.z0 = tnVar;
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
        return true;
    }

    @Override // defpackage.ea3
    public final tn X() {
        return this.z0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.ea3
    public final boolean e() {
        return this.y0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fw4)) {
            return false;
        }
        fw4 fw4Var = (fw4) obj;
        return n12.c(this.b, fw4Var.b) && n12.c(this.f, fw4Var.f) && n12.c(this.z, fw4Var.z) && n12.c(this.A, fw4Var.A) && n12.c(this.X, fw4Var.X) && this.Y == fw4Var.Y && n12.c(this.Z, fw4Var.Z) && this.y0 == fw4Var.y0 && this.z0 == fw4Var.z0;
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
        int iW = dw2.w(dw2.w(this.b.hashCode() * 31, 31, this.f), 31, this.z);
        String str = this.A;
        return this.z0.hashCode() + ((((this.Z.hashCode() + ((((this.X.hashCode() + ((iW + (str == null ? 0 : str.hashCode())) * 31)) * 31) + this.Y) * 31)) * 31) + (this.y0 ? 1231 : 1237)) * 31);
    }

    @Override // defpackage.ea3
    public final String q() {
        return null;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Wireguard(name=", this.b, ", privateKey=", this.f, ", selfIP=");
        ha0.v(sbE, this.z, ", selfIPv6=", this.A, ", dnsServer=");
        sbE.append(this.X);
        sbE.append(", mtu=");
        sbE.append(this.Y);
        sbE.append(", peer=");
        sbE.append(this.Z);
        sbE.append(", udpRelay=");
        sbE.append(this.y0);
        sbE.append(", blockQuic=");
        sbE.append(this.z0);
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
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        LinkedHashSet linkedHashSet = this.X;
        parcel.writeInt(linkedHashSet.size());
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            parcel.writeString((String) it.next());
        }
        parcel.writeInt(this.Y);
        this.Z.writeToParcel(parcel, i);
        parcel.writeInt(this.y0 ? 1 : 0);
        parcel.writeString(this.z0.name());
    }

    public /* synthetic */ fw4(String str, String str2, String str3, String str4, LinkedHashSet linkedHashSet, int i, ew4 ew4Var, tn tnVar) {
        this(str, str2, str3, str4, linkedHashSet, i, ew4Var, true, tnVar);
    }
}
