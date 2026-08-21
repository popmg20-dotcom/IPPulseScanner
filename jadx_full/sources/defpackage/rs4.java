package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rs4 implements Parcelable {
    public static final Parcelable.Creator<rs4> CREATOR = new gl4(3);
    public final Set A;
    public final boolean A0;
    public final List B0;
    public final List C0;
    public final xv1 D0;
    public final boolean E0;
    public final boolean F0;
    public final boolean G0;
    public final boolean H0;
    public final int I0;
    public final LinkedHashMap J0;
    public final boolean K0;
    public final boolean X;
    public final boolean Y;
    public final boolean Z;
    public xw2 b;
    public final HashMap f;
    public final boolean y0;
    public final boolean z;
    public final boolean z0;

    public rs4(xw2 xw2Var, HashMap map, boolean z, Set set, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, List list, List list2, xv1 xv1Var, boolean z8, boolean z9, boolean z10, boolean z11, int i, LinkedHashMap linkedHashMap, boolean z12) {
        xw2Var.getClass();
        xv1Var.getClass();
        this.b = xw2Var;
        this.f = map;
        this.z = z;
        this.A = set;
        this.X = z2;
        this.Y = z3;
        this.Z = z4;
        this.y0 = z5;
        this.z0 = z6;
        this.A0 = z7;
        this.B0 = list;
        this.C0 = list2;
        this.D0 = xv1Var;
        this.E0 = z8;
        this.F0 = z9;
        this.G0 = z10;
        this.H0 = z11;
        this.I0 = i;
        this.J0 = linkedHashMap;
        this.K0 = z12;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rs4)) {
            return false;
        }
        rs4 rs4Var = (rs4) obj;
        return this.b == rs4Var.b && n12.c(this.f, rs4Var.f) && this.z == rs4Var.z && n12.c(this.A, rs4Var.A) && this.X == rs4Var.X && this.Y == rs4Var.Y && this.Z == rs4Var.Z && this.y0 == rs4Var.y0 && this.z0 == rs4Var.z0 && this.A0 == rs4Var.A0 && n12.c(this.B0, rs4Var.B0) && n12.c(this.C0, rs4Var.C0) && this.D0 == rs4Var.D0 && this.E0 == rs4Var.E0 && this.F0 == rs4Var.F0 && this.G0 == rs4Var.G0 && this.H0 == rs4Var.H0 && this.I0 == rs4Var.I0 && n12.c(this.J0, rs4Var.J0) && this.K0 == rs4Var.K0;
    }

    public final int hashCode() {
        int iHashCode = (((((((((((((this.A.hashCode() + ((((this.f.hashCode() + (this.b.hashCode() * 31)) * 31) + (this.z ? 1231 : 1237)) * 31)) * 31) + (this.X ? 1231 : 1237)) * 31) + (this.Y ? 1231 : 1237)) * 31) + (this.Z ? 1231 : 1237)) * 31) + (this.y0 ? 1231 : 1237)) * 31) + (this.z0 ? 1231 : 1237)) * 31) + (this.A0 ? 1231 : 1237)) * 31;
        List list = this.B0;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List list2 = this.C0;
        return ((this.J0.hashCode() + ((((((((((((this.D0.hashCode() + ((iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31)) * 31) + (this.E0 ? 1231 : 1237)) * 31) + (this.F0 ? 1231 : 1237)) * 31) + (this.G0 ? 1231 : 1237)) * 31) + (this.H0 ? 1231 : 1237)) * 31) + this.I0) * 31)) * 31) + (this.K0 ? 1231 : 1237);
    }

    public final String toString() {
        return "VpnConfig(mode=" + this.b + ", groupSelection=" + this.f + ", whiteListMode=" + this.z + ", bypassList=" + this.A + ", allowLan=" + this.X + ", autoFixDnsPoisoning=" + this.Y + ", logEnabled=" + this.Z + ", bypassTlsVerify=" + this.y0 + ", forceUdpRelay=" + this.z0 + ", forceRemoteDns=" + this.A0 + ", overrideLocalProxies=" + this.B0 + ", overrideDoHServers=" + this.C0 + ", ipv6Override=" + this.D0 + ", bypassVpn=" + this.E0 + ", enableSSHDump=" + this.F0 + ", useUtls=" + this.G0 + ", tcpKeepAlive=" + this.H0 + ", mtuSize=" + this.I0 + ", appendHosts=" + this.J0 + ", enableVpnHttpProxy=" + this.K0 + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b.name());
        HashMap map = this.f;
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
        parcel.writeInt(this.z ? 1 : 0);
        Set set = this.A;
        parcel.writeInt(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            parcel.writeString((String) it.next());
        }
        parcel.writeInt(this.X ? 1 : 0);
        parcel.writeInt(this.Y ? 1 : 0);
        parcel.writeInt(this.Z ? 1 : 0);
        parcel.writeInt(this.y0 ? 1 : 0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeInt(this.A0 ? 1 : 0);
        List list = this.B0;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                parcel.writeSerializable((Serializable) it2.next());
            }
        }
        parcel.writeStringList(this.C0);
        parcel.writeString(this.D0.name());
        parcel.writeInt(this.E0 ? 1 : 0);
        parcel.writeInt(this.F0 ? 1 : 0);
        parcel.writeInt(this.G0 ? 1 : 0);
        parcel.writeInt(this.H0 ? 1 : 0);
        parcel.writeInt(this.I0);
        LinkedHashMap linkedHashMap = this.J0;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            parcel.writeParcelable((Parcelable) entry2.getKey(), i);
            parcel.writeParcelable((Parcelable) entry2.getValue(), i);
        }
        parcel.writeInt(this.K0 ? 1 : 0);
    }

    public /* synthetic */ rs4() {
        this(xw2.b, new HashMap(), false, new HashSet(), false, true, true, false, false, false, null, null, xv1.f, true, false, false, false, 32000, new LinkedHashMap(), false);
    }
}
