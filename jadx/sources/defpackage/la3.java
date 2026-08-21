package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class la3 implements na3 {
    public static final Parcelable.Creator<la3> CREATOR = new ic2(16);
    public final LinkedHashMap A;
    public final boolean A0;
    public final boolean B0;
    public final LinkedHashSet C0;
    public boolean D0;
    public final LinkedHashSet X;
    public final String Y;
    public final LinkedHashMap Z;
    public final String b;
    public final LinkedHashSet f;
    public final int y0;
    public final String z;
    public final boolean z0;

    public la3(String str, LinkedHashSet linkedHashSet, String str2, LinkedHashMap linkedHashMap, LinkedHashSet linkedHashSet2, String str3, LinkedHashMap linkedHashMap2, int i, boolean z, boolean z2, boolean z3, LinkedHashSet linkedHashSet3, boolean z4) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.b = str;
        this.f = linkedHashSet;
        this.z = str2;
        this.A = linkedHashMap;
        this.X = linkedHashSet2;
        this.Y = str3;
        this.Z = linkedHashMap2;
        this.y0 = i;
        this.z0 = z;
        this.A0 = z2;
        this.B0 = z3;
        this.C0 = linkedHashSet3;
        this.D0 = z4;
    }

    @Override // defpackage.na3
    public final boolean T() {
        return this.A0;
    }

    @Override // defpackage.na3
    public final void Y() {
        this.D0 = true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof la3)) {
            return false;
        }
        la3 la3Var = (la3) obj;
        return n12.c(this.b, la3Var.b) && this.f.equals(la3Var.f) && n12.c(this.z, la3Var.z) && this.A.equals(la3Var.A) && this.X.equals(la3Var.X) && n12.c(this.Y, la3Var.Y) && this.Z.equals(la3Var.Z) && this.y0 == la3Var.y0 && this.z0 == la3Var.z0 && this.A0 == la3Var.A0 && this.B0 == la3Var.B0 && this.C0.equals(la3Var.C0) && this.D0 == la3Var.D0;
    }

    @Override // defpackage.na3
    public final boolean f() {
        return this.B0;
    }

    @Override // defpackage.na3
    public final String getName() {
        return this.b;
    }

    public final int hashCode() {
        return ((this.C0.hashCode() + ((((((((((this.Z.hashCode() + dw2.w((this.X.hashCode() + ((this.A.hashCode() + dw2.w((this.f.hashCode() + (this.b.hashCode() * 31)) * 31, 31, this.z)) * 31)) * 31, 31, this.Y)) * 31) + this.y0) * 31) + (this.z0 ? 1231 : 1237)) * 31) + (this.A0 ? 1231 : 1237)) * 31) + (this.B0 ? 1231 : 1237)) * 31)) * 31) + (this.D0 ? 1231 : 1237);
    }

    @Override // defpackage.na3
    public final boolean p() {
        return this.D0;
    }

    @Override // defpackage.na3
    public final String r() {
        return this.Y;
    }

    public final String toString() {
        return "Subnet(name=" + this.b + ", group=" + this.f + ", default=" + this.z + ", conditions=" + this.A + ", policyPath=" + this.X + ", policyRegexFilter=" + this.Y + ", external=" + this.Z + ", updateInterval=" + this.y0 + ", noAlert=" + this.z0 + ", hidden=" + this.A0 + ", includeAllProxies=" + this.B0 + ", includeOtherGroup=" + this.C0 + ", otherGroupDecoded=" + this.D0 + ")";
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
        parcel.writeString(this.z);
        LinkedHashMap linkedHashMap = this.A;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            parcel.writeParcelable((Parcelable) entry.getKey(), i);
            parcel.writeString((String) entry.getValue());
        }
        LinkedHashSet linkedHashSet2 = this.X;
        parcel.writeInt(linkedHashSet2.size());
        Iterator it2 = linkedHashSet2.iterator();
        while (it2.hasNext()) {
            parcel.writeString((String) it2.next());
        }
        parcel.writeString(this.Y);
        LinkedHashMap linkedHashMap2 = this.Z;
        parcel.writeInt(linkedHashMap2.size());
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            parcel.writeString((String) entry2.getKey());
            parcel.writeParcelable((Parcelable) entry2.getValue(), i);
        }
        parcel.writeInt(this.y0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeInt(this.A0 ? 1 : 0);
        parcel.writeInt(this.B0 ? 1 : 0);
        LinkedHashSet linkedHashSet3 = this.C0;
        parcel.writeInt(linkedHashSet3.size());
        Iterator it3 = linkedHashSet3.iterator();
        while (it3.hasNext()) {
            parcel.writeString((String) it3.next());
        }
        parcel.writeInt(this.D0 ? 1 : 0);
    }

    @Override // defpackage.na3
    public final LinkedHashMap y() {
        return this.Z;
    }

    @Override // defpackage.na3
    public final LinkedHashSet z() {
        return this.C0;
    }
}
