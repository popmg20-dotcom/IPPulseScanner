package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ja3 implements na3 {
    public static final Parcelable.Creator<ja3> CREATOR = new ic2(14);
    public final String A;
    public final boolean A0;
    public final LinkedHashSet B0;
    public boolean C0;
    public final LinkedHashMap X;
    public final int Y;
    public final boolean Z;
    public final String b;
    public final LinkedHashSet f;
    public final boolean y0;
    public final LinkedHashSet z;
    public final boolean z0;

    public ja3(String str, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, String str2, LinkedHashMap linkedHashMap, int i, boolean z, boolean z2, boolean z3, boolean z4, LinkedHashSet linkedHashSet3, boolean z5) {
        str.getClass();
        str2.getClass();
        this.b = str;
        this.f = linkedHashSet;
        this.z = linkedHashSet2;
        this.A = str2;
        this.X = linkedHashMap;
        this.Y = i;
        this.Z = z;
        this.y0 = z2;
        this.z0 = z3;
        this.A0 = z4;
        this.B0 = linkedHashSet3;
        this.C0 = z5;
    }

    @Override // defpackage.na3
    public final boolean T() {
        return this.y0;
    }

    @Override // defpackage.na3
    public final void Y() {
        this.C0 = true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ja3)) {
            return false;
        }
        ja3 ja3Var = (ja3) obj;
        return n12.c(this.b, ja3Var.b) && this.f.equals(ja3Var.f) && this.z.equals(ja3Var.z) && n12.c(this.A, ja3Var.A) && this.X.equals(ja3Var.X) && this.Y == ja3Var.Y && this.Z == ja3Var.Z && this.y0 == ja3Var.y0 && this.z0 == ja3Var.z0 && this.A0 == ja3Var.A0 && this.B0.equals(ja3Var.B0) && this.C0 == ja3Var.C0;
    }

    @Override // defpackage.na3
    public final boolean f() {
        return this.A0;
    }

    @Override // defpackage.na3
    public final String getName() {
        return this.b;
    }

    public final int hashCode() {
        return ((this.B0.hashCode() + ((((((((((((this.X.hashCode() + dw2.w((this.z.hashCode() + ((this.f.hashCode() + (this.b.hashCode() * 31)) * 31)) * 31, 31, this.A)) * 31) + this.Y) * 31) + (this.Z ? 1231 : 1237)) * 31) + (this.y0 ? 1231 : 1237)) * 31) + (this.z0 ? 1231 : 1237)) * 31) + (this.A0 ? 1231 : 1237)) * 31)) * 31) + (this.C0 ? 1231 : 1237);
    }

    @Override // defpackage.na3
    public final boolean p() {
        return this.C0;
    }

    @Override // defpackage.na3
    public final String r() {
        return this.A;
    }

    public final String toString() {
        return "LoadBalance(name=" + this.b + ", group=" + this.f + ", policyPath=" + this.z + ", policyRegexFilter=" + this.A + ", external=" + this.X + ", updateInterval=" + this.Y + ", noAlert=" + this.Z + ", hidden=" + this.y0 + ", persistent=" + this.z0 + ", includeAllProxies=" + this.A0 + ", includeOtherGroup=" + this.B0 + ", otherGroupDecoded=" + this.C0 + ")";
    }

    @Override // defpackage.na3
    public final LinkedHashSet w() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        LinkedHashSet linkedHashSet = this.f;
        parcel.writeInt(linkedHashSet.size());
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            parcel.writeString((String) it.next());
        }
        LinkedHashSet linkedHashSet2 = this.z;
        parcel.writeInt(linkedHashSet2.size());
        Iterator it2 = linkedHashSet2.iterator();
        while (it2.hasNext()) {
            parcel.writeString((String) it2.next());
        }
        parcel.writeString(this.A);
        LinkedHashMap linkedHashMap = this.X;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeParcelable((Parcelable) entry.getValue(), i);
        }
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z ? 1 : 0);
        parcel.writeInt(this.y0 ? 1 : 0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeInt(this.A0 ? 1 : 0);
        LinkedHashSet linkedHashSet3 = this.B0;
        parcel.writeInt(linkedHashSet3.size());
        Iterator it3 = linkedHashSet3.iterator();
        while (it3.hasNext()) {
            parcel.writeString((String) it3.next());
        }
        parcel.writeInt(this.C0 ? 1 : 0);
    }

    @Override // defpackage.na3
    public final LinkedHashMap y() {
        return this.X;
    }

    @Override // defpackage.na3
    public final LinkedHashSet z() {
        return this.B0;
    }
}
