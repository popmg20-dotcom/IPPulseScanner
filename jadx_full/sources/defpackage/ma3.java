package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ma3 implements na3 {
    public static final Parcelable.Creator<ma3> CREATOR = new ic2(17);
    public final String A;
    public final Integer A0;
    public final boolean B0;
    public final boolean C0;
    public final boolean D0;
    public final LinkedHashSet E0;
    public boolean F0;
    public final LinkedHashMap X;
    public final int Y;
    public final String Z;
    public final String b;
    public final LinkedHashSet f;
    public final int y0;
    public final LinkedHashSet z;
    public final int z0;

    public ma3(String str, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, String str2, LinkedHashMap linkedHashMap, int i, String str3, int i2, int i3, Integer num, boolean z, boolean z2, boolean z3, LinkedHashSet linkedHashSet3, boolean z4) {
        str.getClass();
        str2.getClass();
        this.b = str;
        this.f = linkedHashSet;
        this.z = linkedHashSet2;
        this.A = str2;
        this.X = linkedHashMap;
        this.Y = i;
        this.Z = str3;
        this.y0 = i2;
        this.z0 = i3;
        this.A0 = num;
        this.B0 = z;
        this.C0 = z2;
        this.D0 = z3;
        this.E0 = linkedHashSet3;
        this.F0 = z4;
    }

    @Override // defpackage.na3
    public final boolean T() {
        return this.C0;
    }

    @Override // defpackage.na3
    public final void Y() {
        this.F0 = true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ma3)) {
            return false;
        }
        ma3 ma3Var = (ma3) obj;
        return n12.c(this.b, ma3Var.b) && this.f.equals(ma3Var.f) && this.z.equals(ma3Var.z) && n12.c(this.A, ma3Var.A) && this.X.equals(ma3Var.X) && this.Y == ma3Var.Y && n12.c(this.Z, ma3Var.Z) && this.y0 == ma3Var.y0 && this.z0 == ma3Var.z0 && n12.c(this.A0, ma3Var.A0) && this.B0 == ma3Var.B0 && this.C0 == ma3Var.C0 && this.D0 == ma3Var.D0 && this.E0.equals(ma3Var.E0) && this.F0 == ma3Var.F0;
    }

    @Override // defpackage.na3
    public final boolean f() {
        return this.D0;
    }

    @Override // defpackage.na3
    public final String getName() {
        return this.b;
    }

    public final int hashCode() {
        int iHashCode = (((this.X.hashCode() + dw2.w((this.z.hashCode() + ((this.f.hashCode() + (this.b.hashCode() * 31)) * 31)) * 31, 31, this.A)) * 31) + this.Y) * 31;
        String str = this.Z;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.y0) * 31) + this.z0) * 31;
        Integer num = this.A0;
        return ((this.E0.hashCode() + ((((((((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + (this.B0 ? 1231 : 1237)) * 31) + (this.C0 ? 1231 : 1237)) * 31) + (this.D0 ? 1231 : 1237)) * 31)) * 31) + (this.F0 ? 1231 : 1237);
    }

    @Override // defpackage.na3
    public final boolean p() {
        return this.F0;
    }

    @Override // defpackage.na3
    public final String r() {
        return this.A;
    }

    public final String toString() {
        return "UrlTest(name=" + this.b + ", group=" + this.f + ", policyPath=" + this.z + ", policyRegexFilter=" + this.A + ", external=" + this.X + ", updateInterval=" + this.Y + ", url=" + this.Z + ", interval=" + this.y0 + ", tolerance=" + this.z0 + ", timeout=" + this.A0 + ", noAlert=" + this.B0 + ", hidden=" + this.C0 + ", includeAllProxies=" + this.D0 + ", includeOtherGroup=" + this.E0 + ", otherGroupDecoded=" + this.F0 + ")";
    }

    @Override // defpackage.na3
    public final LinkedHashSet w() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iIntValue;
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
        parcel.writeString(this.Z);
        parcel.writeInt(this.y0);
        parcel.writeInt(this.z0);
        Integer num = this.A0;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeInt(this.B0 ? 1 : 0);
        parcel.writeInt(this.C0 ? 1 : 0);
        parcel.writeInt(this.D0 ? 1 : 0);
        LinkedHashSet linkedHashSet3 = this.E0;
        parcel.writeInt(linkedHashSet3.size());
        Iterator it3 = linkedHashSet3.iterator();
        while (it3.hasNext()) {
            parcel.writeString((String) it3.next());
        }
        parcel.writeInt(this.F0 ? 1 : 0);
    }

    @Override // defpackage.na3
    public final LinkedHashMap y() {
        return this.X;
    }

    @Override // defpackage.na3
    public final LinkedHashSet z() {
        return this.E0;
    }
}
