package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import com.getsurfboard.profile.SuffixTreeNative;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class om3 implements rm3, sm3 {
    public static final Parcelable.Creator<om3> CREATOR = new ic2(23);
    public final boolean A;
    public volatile boolean A0;
    public final String X;
    public final int Y;
    public final String Z;
    public final String b;
    public final String f;
    public final n54 y0;
    public final boolean z;
    public volatile SuffixTreeNative z0;

    public om3(String str, String str2, boolean z, boolean z2, String str3, int i, String str4, n54 n54Var, int i2) {
        str4 = (i2 & 64) != 0 ? "" : str4;
        n54Var = (i2 & 128) != 0 ? null : n54Var;
        str.getClass();
        str2.getClass();
        str4.getClass();
        this.b = str;
        this.f = str2;
        this.z = z;
        this.A = z2;
        this.X = str3;
        this.Y = i;
        this.Z = str4;
        this.y0 = n54Var;
    }

    @Override // defpackage.rm3
    public final boolean G() {
        return this.A;
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.f;
    }

    @Override // defpackage.sm3
    public final String a() {
        return this.b;
    }

    @Override // defpackage.rm3
    public final boolean b(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        str.getClass();
        n54 n54Var = this.y0;
        if (n54Var != null) {
            Object obj = n54Var.b;
            for (String str2 : yr2.l(str)) {
                m54 m54Var = (m54) obj;
                ArrayList arrayList = m54Var.f;
                int size = arrayList.size();
                e70.N(arrayList.size(), size);
                int i6 = size - 1;
                int i7 = 0;
                while (true) {
                    if (i7 > i6) {
                        i4 = -(i7 + 1);
                        break;
                    }
                    i4 = (i7 + i6) >>> 1;
                    int iF = ye.f(((m54) arrayList.get(i4)).b, str2);
                    if (iF >= 0) {
                        if (iF <= 0) {
                            break;
                        }
                        i6 = i4 - 1;
                    } else {
                        i7 = i4 + 1;
                    }
                }
                if (i4 >= 0) {
                    obj = m54Var.f.get(i4);
                } else if (n12.c(m54Var.b, ".")) {
                    ArrayList arrayList2 = m54Var.f;
                    int size2 = arrayList2.size();
                    e70.N(arrayList2.size(), size2);
                    int i8 = size2 - 1;
                    int i9 = 0;
                    while (true) {
                        if (i9 > i8) {
                            i5 = -(i9 + 1);
                            break;
                        }
                        i5 = (i9 + i8) >>> 1;
                        int iF2 = ye.f(((m54) arrayList2.get(i5)).b, "");
                        if (iF2 >= 0) {
                            if (iF2 <= 0) {
                                break;
                            }
                            i8 = i5 - 1;
                        } else {
                            i9 = i5 + 1;
                        }
                    }
                    if (i5 >= 0) {
                        return true;
                    }
                }
            }
            m54 m54Var2 = (m54) obj;
            ArrayList arrayList3 = m54Var2.f;
            int size3 = arrayList3.size();
            e70.N(arrayList3.size(), size3);
            int i10 = size3 - 1;
            int i11 = 0;
            while (true) {
                if (i11 > i10) {
                    i = -(i11 + 1);
                    break;
                }
                i = (i11 + i10) >>> 1;
                int iF3 = ye.f(((m54) arrayList3.get(i)).b, "");
                if (iF3 >= 0) {
                    if (iF3 <= 0) {
                        break;
                    }
                    i10 = i - 1;
                } else {
                    i11 = i + 1;
                }
            }
            if (i < 0) {
                ArrayList arrayList4 = m54Var2.f;
                int size4 = arrayList4.size();
                e70.N(arrayList4.size(), size4);
                int i12 = size4 - 1;
                int i13 = 0;
                while (true) {
                    if (i13 > i12) {
                        i2 = -(i13 + 1);
                        break;
                    }
                    i2 = (i13 + i12) >>> 1;
                    int iF4 = ye.f(((m54) arrayList4.get(i2)).b, ".");
                    if (iF4 >= 0) {
                        if (iF4 <= 0) {
                            break;
                        }
                        i12 = i2 - 1;
                    } else {
                        i13 = i2 + 1;
                    }
                }
                if (i2 >= 0) {
                    ArrayList arrayList5 = ((m54) m54Var2.f.get(i2)).f;
                    int size5 = arrayList5.size();
                    e70.N(arrayList5.size(), size5);
                    int i14 = size5 - 1;
                    int i15 = 0;
                    while (true) {
                        if (i15 > i14) {
                            i3 = -(i15 + 1);
                            break;
                        }
                        i3 = (i15 + i14) >>> 1;
                        int iF5 = ye.f(((m54) arrayList5.get(i3)).b, "");
                        if (iF5 >= 0) {
                            if (iF5 <= 0) {
                                break;
                            }
                            i14 = i3 - 1;
                        } else {
                            i15 = i3 + 1;
                        }
                    }
                    if (i3 >= 0) {
                    }
                }
            }
            return true;
        }
        if (!this.A0) {
            try {
                SuffixTreeNative suffixTreeNativeT = this.z0;
                if (suffixTreeNativeT == null) {
                    synchronized (this) {
                        suffixTreeNativeT = this.z0;
                        if (suffixTreeNativeT == null) {
                            suffixTreeNativeT = fx3.t(new File(this.Z));
                            this.z0 = suffixTreeNativeT;
                        }
                    }
                }
                return suffixTreeNativeT.s(str);
            } catch (Exception e) {
                StringBuilder sbE = fw.E("Domain.Set.match: tree and native tree both unavailable! source=", this.b, ", treeFilePath='", this.Z, "', host=");
                sbE.append(str);
                String string = sbE.toString();
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "Rule", "", "", 0, Process.myPid(), Process.myTid(), le2.b, ha0.o(string, "\n", Log.getStackTraceString(e)));
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.e("Rule", string, e);
                }
                this.A0 = true;
                return false;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof om3)) {
            return false;
        }
        om3 om3Var = (om3) obj;
        return n12.c(this.b, om3Var.b) && n12.c(this.f, om3Var.f) && this.z == om3Var.z && this.A == om3Var.A && n12.c(this.X, om3Var.X) && this.Y == om3Var.Y;
    }

    @Override // defpackage.tn3
    public final String getType() {
        String str = this.X;
        return str == null ? "DOMAIN-SET" : str;
    }

    public final int hashCode() {
        int iW = (((dw2.w(this.b.hashCode() * 31, 31, this.f) + (this.z ? 1231 : 1237)) * 31) + (this.A ? 1231 : 1237)) * 31;
        String str = this.X;
        return ((iW + (str != null ? str.hashCode() : 0)) * 31) + this.Y;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Set(source=", this.b, ", proxy=", this.f, ", forceRemoteDns=");
        sbE.append(this.z);
        sbE.append(", enhancedMode=");
        sbE.append(this.A);
        sbE.append(", typeOverride=");
        sbE.append(this.X);
        sbE.append(", domainCount=");
        sbE.append(this.Y);
        sbE.append(", treeFilePath=");
        sbE.append(this.Z);
        sbE.append(", tree=");
        sbE.append(this.y0);
        sbE.append(")");
        return sbE.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        parcel.writeInt(this.z ? 1 : 0);
        parcel.writeInt(this.A ? 1 : 0);
        parcel.writeString(this.X);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
    }

    @Override // defpackage.rm3
    public final boolean x() {
        return this.z;
    }
}
