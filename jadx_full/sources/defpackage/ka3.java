package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import io.sentry.p6;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ka3 implements na3 {
    public static final Parcelable.Creator<ka3> CREATOR = new ic2(15);
    public final String A;
    public final LinkedHashSet A0;
    public boolean B0;
    public final LinkedHashMap X;
    public final int Y;
    public final boolean Z;
    public final String b;
    public final LinkedHashSet f;
    public final boolean y0;
    public final LinkedHashSet z;
    public final boolean z0;

    public /* synthetic */ ka3(String str, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, String str2, LinkedHashMap linkedHashMap, int i, boolean z, boolean z2, boolean z3, LinkedHashSet linkedHashSet3, int i2) {
        this(str, linkedHashSet, (i2 & 4) != 0 ? new LinkedHashSet() : linkedHashSet2, (i2 & 8) != 0 ? p6.DEFAULT_PROPAGATION_TARGETS : str2, (i2 & 16) != 0 ? new LinkedHashMap() : linkedHashMap, (i2 & 32) != 0 ? 86400 : i, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? false : z3, (i2 & 512) != 0 ? new LinkedHashSet() : linkedHashSet3, false);
    }

    @Override // defpackage.na3
    public final boolean T() {
        return this.y0;
    }

    @Override // defpackage.na3
    public final void Y() {
        this.B0 = true;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ka3)) {
            return false;
        }
        ka3 ka3Var = (ka3) obj;
        return n12.c(this.b, ka3Var.b) && n12.c(this.f, ka3Var.f) && n12.c(this.z, ka3Var.z) && n12.c(this.A, ka3Var.A) && n12.c(this.X, ka3Var.X) && this.Y == ka3Var.Y && this.Z == ka3Var.Z && this.y0 == ka3Var.y0 && this.z0 == ka3Var.z0 && n12.c(this.A0, ka3Var.A0) && this.B0 == ka3Var.B0;
    }

    @Override // defpackage.na3
    public final boolean f() {
        return this.z0;
    }

    @Override // defpackage.na3
    public final String getName() {
        return this.b;
    }

    public final int hashCode() {
        return ((this.A0.hashCode() + ((((((((((this.X.hashCode() + dw2.w((this.z.hashCode() + ((this.f.hashCode() + (this.b.hashCode() * 31)) * 31)) * 31, 31, this.A)) * 31) + this.Y) * 31) + (this.Z ? 1231 : 1237)) * 31) + (this.y0 ? 1231 : 1237)) * 31) + (this.z0 ? 1231 : 1237)) * 31)) * 31) + (this.B0 ? 1231 : 1237);
    }

    @Override // defpackage.na3
    public final boolean p() {
        return this.B0;
    }

    @Override // defpackage.na3
    public final String r() {
        return this.A;
    }

    public final String toString() {
        return "Select(name=" + this.b + ", group=" + this.f + ", policyPath=" + this.z + ", policyRegexFilter=" + this.A + ", external=" + this.X + ", updateInterval=" + this.Y + ", noAlert=" + this.Z + ", hidden=" + this.y0 + ", includeAllProxies=" + this.z0 + ", includeOtherGroup=" + this.A0 + ", otherGroupDecoded=" + this.B0 + ")";
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
        LinkedHashSet linkedHashSet3 = this.A0;
        parcel.writeInt(linkedHashSet3.size());
        Iterator it3 = linkedHashSet3.iterator();
        while (it3.hasNext()) {
            parcel.writeString((String) it3.next());
        }
        parcel.writeInt(this.B0 ? 1 : 0);
    }

    @Override // defpackage.na3
    public final LinkedHashMap y() {
        return this.X;
    }

    @Override // defpackage.na3
    public final LinkedHashSet z() {
        return this.A0;
    }

    public ka3(String str, LinkedHashSet linkedHashSet, LinkedHashSet linkedHashSet2, String str2, LinkedHashMap linkedHashMap, int i, boolean z, boolean z2, boolean z3, LinkedHashSet linkedHashSet3, boolean z4) {
        str.getClass();
        linkedHashSet2.getClass();
        str2.getClass();
        linkedHashMap.getClass();
        linkedHashSet3.getClass();
        this.b = str;
        this.f = linkedHashSet;
        this.z = linkedHashSet2;
        this.A = str2;
        this.X = linkedHashMap;
        this.Y = i;
        this.Z = z;
        this.y0 = z2;
        this.z0 = z3;
        this.A0 = linkedHashSet3;
        this.B0 = z4;
    }
}
