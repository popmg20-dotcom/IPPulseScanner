package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t53 implements zk {
    public static final Parcelable.Creator<t53> CREATOR = new ic2(12);
    public boolean A;
    public int A0;
    public ea3 B0;
    public final ArrayList C0;
    public final LinkedHashSet D0;
    public final ArrayList E0;
    public final LinkedHashMap F0;
    public final LinkedHashMap G0;
    public final LinkedHashMap H0;
    public ka3 I0;
    public final ArrayList J0;
    public tm3 K0;
    public final ArrayList L0;
    public long M0;
    public InetSocketAddress X;
    public InetSocketAddress Y;
    public final ArrayList Z;
    public final String b;
    public int f;
    public String y0;
    public xf2 z;
    public String z0;

    public t53(String str, int i) {
        ArrayList arrayList = new ArrayList();
        ii3 ii3Var = lb3.b;
        ArrayList arrayList2 = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        String[] strArr = {lb3.a.b};
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(fh2.U(1));
        qe.r0(strArr, linkedHashSet2);
        this(str, i, null, false, null, null, arrayList, "http://www.gstatic.com/generate_204", "http://www.gstatic.cn/generate_204", 5, ii3Var, arrayList2, linkedHashSet, arrayList3, linkedHashMap, linkedHashMap2, linkedHashMap3, new ka3("Global Proxy", linkedHashSet2, (LinkedHashSet) null, (String) null, (LinkedHashMap) null, 0, false, false, false, (LinkedHashSet) null, 2044), new ArrayList(), null, new ArrayList(), System.currentTimeMillis());
    }

    public static t53 a(t53 t53Var, String str, int i) {
        String str2 = (i & 1) != 0 ? t53Var.b : str;
        int i2 = t53Var.f;
        xf2 xf2Var = t53Var.z;
        boolean z = t53Var.A;
        InetSocketAddress inetSocketAddress = t53Var.X;
        InetSocketAddress inetSocketAddress2 = t53Var.Y;
        ArrayList arrayList = t53Var.Z;
        String str3 = t53Var.y0;
        String str4 = t53Var.z0;
        int i3 = t53Var.A0;
        ea3 ea3Var = t53Var.B0;
        ArrayList arrayList2 = t53Var.C0;
        LinkedHashSet linkedHashSet = t53Var.D0;
        ArrayList arrayList3 = t53Var.E0;
        LinkedHashMap linkedHashMap = t53Var.F0;
        LinkedHashMap linkedHashMap2 = t53Var.G0;
        LinkedHashMap linkedHashMap3 = t53Var.H0;
        ka3 ka3Var = t53Var.I0;
        ArrayList arrayList4 = t53Var.J0;
        tm3 tm3Var = t53Var.K0;
        ArrayList arrayList5 = t53Var.L0;
        long j = t53Var.M0;
        str2.getClass();
        arrayList.getClass();
        str3.getClass();
        str4.getClass();
        ea3Var.getClass();
        arrayList2.getClass();
        linkedHashSet.getClass();
        arrayList3.getClass();
        linkedHashMap.getClass();
        linkedHashMap2.getClass();
        linkedHashMap3.getClass();
        ka3Var.getClass();
        arrayList4.getClass();
        arrayList5.getClass();
        return new t53(str2, i2, xf2Var, z, inetSocketAddress, inetSocketAddress2, arrayList, str3, str4, i3, ea3Var, arrayList2, linkedHashSet, arrayList3, linkedHashMap, linkedHashMap2, linkedHashMap3, ka3Var, arrayList4, tm3Var, arrayList5, j);
    }

    public static int d(tn3 tn3Var, HashSet hashSet) {
        int iD = 0;
        if (tn3Var instanceof jn3) {
            jn3 jn3Var = (jn3) tn3Var;
            if (!hashSet.add(jn3Var.f)) {
                return 0;
            }
            Iterator it = jn3Var.z.iterator();
            while (it.hasNext()) {
                iD += d((tn3) it.next(), hashSet);
            }
            return iD;
        }
        if (tn3Var instanceof bn3) {
            Iterator it2 = ((bn3) tn3Var).getRules().iterator();
            while (it2.hasNext()) {
                iD += d((tn3) it2.next(), hashSet);
            }
            return iD;
        }
        if (!(tn3Var instanceof om3)) {
            return 1;
        }
        int i = ((om3) tn3Var).Y;
        Integer numValueOf = Integer.valueOf(i);
        if (i <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 1;
    }

    public static LinkedHashSet n(t53 t53Var) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(t53Var.G0.values());
        Collection<na3> collectionValues = t53Var.H0.values();
        collectionValues.getClass();
        for (na3 na3Var : collectionValues) {
            if (!n12.c(na3Var.getName(), null)) {
                linkedHashSet.addAll(na3Var.y().values());
            }
        }
        return linkedHashSet;
    }

    public final void D(na3 na3Var) {
        na3Var.getClass();
        if (na3Var.p()) {
            return;
        }
        String strR = na3Var.r();
        strR.getClass();
        Pattern patternCompile = Pattern.compile(strR);
        patternCompile.getClass();
        Iterator it = na3Var.z().iterator();
        while (it.hasNext()) {
            na3 na3Var2 = (na3) this.H0.get((String) it.next());
            if (na3Var2 == null) {
                s53.n("decode [", na3Var.getName(), "] include-other-group failed: ", na3Var2, " not existed");
                return;
            }
            if (!na3Var2.p()) {
                D(na3Var2);
            }
            LinkedHashSet linkedHashSetW = na3Var.w();
            LinkedHashSet linkedHashSetW2 = na3Var2.w();
            ArrayList arrayList = new ArrayList();
            for (Object obj : linkedHashSetW2) {
                String str = (String) obj;
                str.getClass();
                if (patternCompile.matcher(str).find()) {
                    arrayList.add(obj);
                }
            }
            linkedHashSetW.addAll(arrayList);
            LinkedHashSet linkedHashSetW3 = na3Var.w();
            Set setKeySet = na3Var2.y().keySet();
            setKeySet.getClass();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : setKeySet) {
                String str2 = (String) obj2;
                str2.getClass();
                if (patternCompile.matcher(str2).find()) {
                    arrayList2.add(obj2);
                }
            }
            linkedHashSetW3.addAll(arrayList2);
        }
        na3Var.Y();
    }

    @Override // defpackage.zk
    public final int O() {
        return this.f;
    }

    @Override // defpackage.zk
    public final long W() {
        return this.M0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return k(obj, true);
    }

    @Override // defpackage.zk
    public final String getName() {
        return this.b;
    }

    @Override // defpackage.zk
    public final void h() {
        this.z = null;
    }

    public final int hashCode() {
        int iHashCode = ((this.b.hashCode() * 31) + this.f) * 31;
        xf2 xf2Var = this.z;
        int iHashCode2 = (((iHashCode + (xf2Var != null ? xf2Var.hashCode() : 0)) * 31) + (this.A ? 1231 : 1237)) * 31;
        InetSocketAddress inetSocketAddress = this.X;
        int iHashCode3 = (iHashCode2 + (inetSocketAddress != null ? inetSocketAddress.hashCode() : 0)) * 31;
        InetSocketAddress inetSocketAddress2 = this.Y;
        int iHashCode4 = (this.J0.hashCode() + ((this.I0.hashCode() + ((this.H0.hashCode() + ((this.G0.hashCode() + ((this.F0.hashCode() + ((this.E0.hashCode() + ((this.D0.hashCode() + ((this.C0.hashCode() + ((this.B0.hashCode() + ((dw2.w(dw2.w((this.Z.hashCode() + ((((iHashCode3 + (inetSocketAddress2 != null ? inetSocketAddress2.hashCode() : 0)) * 31) + (this.A ? 1231 : 1237)) * 31)) * 31, 31, this.y0), 31, this.z0) + this.A0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        tm3 tm3Var = this.K0;
        int iHashCode5 = tm3Var != null ? tm3Var.b.hashCode() : 0;
        int iHashCode6 = this.L0.hashCode();
        long j = this.M0;
        return ((iHashCode6 + ((iHashCode4 + iHashCode5) * 31)) * 31) + ((int) (j ^ (j >>> 32)));
    }

    @Override // defpackage.zk
    public final xf2 j() {
        return this.z;
    }

    public final boolean k(Object obj, boolean z) {
        if (this == obj) {
            return true;
        }
        if (!t53.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        t53 t53Var = (t53) obj;
        if (!n12.c(this.b, t53Var.b)) {
            return false;
        }
        if ((!z || this.f == t53Var.f) && n12.c(this.z, t53Var.z) && this.A == t53Var.A && n12.c(this.X, t53Var.X) && n12.c(this.Y, t53Var.Y) && n12.c(this.Z, t53Var.Z) && n12.c(this.y0, t53Var.y0) && n12.c(this.z0, t53Var.z0) && this.A0 == t53Var.A0 && n12.c(this.B0, t53Var.B0) && n12.c(this.C0, t53Var.C0) && n12.c(this.D0, t53Var.D0) && n12.c(this.E0, t53Var.E0) && n12.c(this.F0, t53Var.F0) && n12.c(this.G0, t53Var.G0) && n12.c(this.H0, t53Var.H0) && n12.c(this.I0, t53Var.I0) && n12.c(this.J0, t53Var.J0) && n12.c(this.K0, t53Var.K0) && n12.c(this.L0, t53Var.L0)) {
            return !z || this.M0 == t53Var.M0;
        }
        return false;
    }

    public final ea3 l(String str, Map map) {
        str.getClass();
        map.getClass();
        ea3 ea3VarS = s(str, map, 0);
        return (ea3VarS == null && (ea3VarS = s(p44.H0(str, "\""), map, 0)) == null) ? s(p44.H0(str, "'"), map, 0) : ea3VarS;
    }

    @Override // defpackage.zk
    public final void o(int i) {
        this.f = i;
    }

    public final ea3 s(String str, Map map, int i) {
        String str2;
        LinkedHashSet linkedHashSetW;
        if (i > 50) {
            String str3 = "getProxyInner() depth exceeded, name = " + str + ", depth = " + i;
            if (fy4.b) {
                Xlog.logWrite2(0L, 4, "Profile", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.e("Profile", str3, null);
                return null;
            }
        } else {
            if (n12.c(str, "direct") || n12.c(str, "DIRECT")) {
                return lb3.a;
            }
            if (n12.c(str, "reject") || n12.c(str, "REJECT")) {
                return lb3.b;
            }
            if (n12.c(str, "reject-tinygif") || n12.c(str, "REJECT-TINYGIF")) {
                return lb3.b;
            }
            if (n12.c(str, "reject-no-drop") || n12.c(str, "REJECT-NO-DROP")) {
                return lb3.b;
            }
            if (n12.c(str, "reject-drop") || n12.c(str, "REJECT-DROP")) {
                return lb3.c;
            }
            if (this.G0.containsKey(str)) {
                return (ea3) this.G0.get(str);
            }
            if (this.H0.containsKey(str) || n12.c(this.I0.b, str)) {
                if (this.H0.get(str) instanceof ja3) {
                    na3 na3Var = (na3) this.H0.get(str);
                    if (na3Var == null || (linkedHashSetW = na3Var.w()) == null) {
                        str2 = null;
                    } else {
                        hd3 hd3Var = id3.b;
                        str2 = (String) (linkedHashSetW.isEmpty() ? null : d70.Z(linkedHashSetW, id3.f.b(linkedHashSetW.size())));
                    }
                } else {
                    str2 = (String) map.get(str);
                }
                if (str2 != null) {
                    int i2 = i + 1;
                    ea3 ea3VarS = s(str2, map, i2);
                    return (ea3VarS == null && (ea3VarS = s(p44.H0(str2, "\""), map, i2)) == null) ? s(p44.H0(str2, "'"), map, i2) : ea3VarS;
                }
            } else {
                Collection<na3> collectionValues = this.H0.values();
                collectionValues.getClass();
                for (na3 na3Var2 : collectionValues) {
                    if (na3Var2.y().containsKey(str)) {
                        return (ea3) na3Var2.y().get(str);
                    }
                }
            }
        }
        return null;
    }

    public final LinkedHashSet t(boolean z) {
        LinkedHashSet linkedHashSetN = n(this);
        ArrayList arrayList = new ArrayList();
        for (Object obj : linkedHashSetN) {
            ea3 ea3Var = (ea3) obj;
            if (!z || (!(ea3Var instanceof tu0) && !(ea3Var instanceof ii3))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ea3) it.next()).getName());
        }
        return new LinkedHashSet(arrayList2);
    }

    public final String toString() {
        return "Profile(name=" + this.b + ", contentHash=" + this.f + ", managedConfig=" + this.z + ", ipv6=" + this.A + ", httpListen=" + this.X + ", socks5Listen=" + this.Y + ", dohServers=" + this.Z + ", proxyTestUrl=" + this.y0 + ", internetTestUrl=" + this.z0 + ", testTimeout=" + this.A0 + ", udpPolicyNotSupportedBehaviour=" + this.B0 + ", skipProxy=" + this.C0 + ", dnsServer=" + this.D0 + ", alwaysRealIP=" + this.E0 + ", hosts=" + this.F0 + ", proxies=" + this.G0 + ", groups=" + this.H0 + ", globalGroup=" + this.I0 + ", rules=" + this.J0 + ", finalRule=" + this.K0 + ", panels=" + this.L0 + ", lastModified=" + this.M0 + ")";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (r4.equals("reject-drop") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r4.equals("reject-tinygif") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r4.equals("reject-no-drop") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
    
        if (r4.equals("REJECT-DROP") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0040, code lost:
    
        return defpackage.lb3.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        if (r4.equals("reject") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        if (r4.equals("REJECT-TINYGIF") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        if (r4.equals("direct") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        return defpackage.lb3.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
    
        if (r4.equals("REJECT") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a0, code lost:
    
        return defpackage.lb3.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r4.equals("REJECT-NO-DROP") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
    
        if (r4.equals("DIRECT") == false) goto L38;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.ea3 u(java.lang.String r4) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t53.u(java.lang.String):ea3");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeInt(this.f);
        xf2 xf2Var = this.z;
        if (xf2Var == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            xf2Var.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.A ? 1 : 0);
        parcel.writeSerializable(this.X);
        parcel.writeSerializable(this.Y);
        parcel.writeStringList(this.Z);
        parcel.writeString(this.y0);
        parcel.writeString(this.z0);
        parcel.writeInt(this.A0);
        parcel.writeParcelable(this.B0, i);
        ArrayList arrayList = this.C0;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((Parcelable) it.next(), i);
        }
        LinkedHashSet linkedHashSet = this.D0;
        parcel.writeInt(linkedHashSet.size());
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            parcel.writeSerializable((Serializable) it2.next());
        }
        parcel.writeStringList(this.E0);
        LinkedHashMap linkedHashMap = this.F0;
        parcel.writeInt(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            parcel.writeParcelable((Parcelable) entry.getKey(), i);
            parcel.writeParcelable((Parcelable) entry.getValue(), i);
        }
        LinkedHashMap linkedHashMap2 = this.G0;
        parcel.writeInt(linkedHashMap2.size());
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            parcel.writeString((String) entry2.getKey());
            parcel.writeParcelable((Parcelable) entry2.getValue(), i);
        }
        LinkedHashMap linkedHashMap3 = this.H0;
        parcel.writeInt(linkedHashMap3.size());
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            parcel.writeString((String) entry3.getKey());
            parcel.writeParcelable((Parcelable) entry3.getValue(), i);
        }
        this.I0.writeToParcel(parcel, i);
        ArrayList arrayList2 = this.J0;
        parcel.writeInt(arrayList2.size());
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            parcel.writeParcelable((Parcelable) it3.next(), i);
        }
        tm3 tm3Var = this.K0;
        if (tm3Var == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(tm3Var.b);
        }
        ArrayList arrayList3 = this.L0;
        parcel.writeInt(arrayList3.size());
        Iterator it4 = arrayList3.iterator();
        while (it4.hasNext()) {
            ((h03) it4.next()).writeToParcel(parcel, i);
        }
        parcel.writeLong(this.M0);
    }

    public t53(String str, int i, xf2 xf2Var, boolean z, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, ArrayList arrayList, String str2, String str3, int i2, ea3 ea3Var, ArrayList arrayList2, LinkedHashSet linkedHashSet, ArrayList arrayList3, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, LinkedHashMap linkedHashMap3, ka3 ka3Var, ArrayList arrayList4, tm3 tm3Var, ArrayList arrayList5, long j) {
        str.getClass();
        arrayList.getClass();
        str2.getClass();
        str3.getClass();
        ea3Var.getClass();
        arrayList3.getClass();
        ka3Var.getClass();
        this.b = str;
        this.f = i;
        this.z = xf2Var;
        this.A = z;
        this.X = inetSocketAddress;
        this.Y = inetSocketAddress2;
        this.Z = arrayList;
        this.y0 = str2;
        this.z0 = str3;
        this.A0 = i2;
        this.B0 = ea3Var;
        this.C0 = arrayList2;
        this.D0 = linkedHashSet;
        this.E0 = arrayList3;
        this.F0 = linkedHashMap;
        this.G0 = linkedHashMap2;
        this.H0 = linkedHashMap3;
        this.I0 = ka3Var;
        this.J0 = arrayList4;
        this.K0 = tm3Var;
        this.L0 = arrayList5;
        this.M0 = j;
    }
}
