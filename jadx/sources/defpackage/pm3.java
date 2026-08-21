package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pm3 implements rm3 {
    public static final Parcelable.Creator<pm3> CREATOR = new ic2(24);
    public final boolean A;
    public final String b;
    public final String f;
    public final boolean z;

    public pm3(String str, String str2, boolean z, boolean z2) {
        str.getClass();
        str2.getClass();
        this.b = str;
        this.f = str2;
        this.z = z;
        this.A = z2;
    }

    @Override // defpackage.rm3
    public final boolean G() {
        return this.A;
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.f;
    }

    @Override // defpackage.rm3
    public final boolean b(String str) {
        str.getClass();
        String strConcat = this.b;
        if (str.equals(strConcat)) {
            return true;
        }
        if (!w44.j0(strConcat, ".", false)) {
            strConcat = ".".concat(strConcat);
        }
        return w44.d0(str, strConcat, false);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pm3)) {
            return false;
        }
        pm3 pm3Var = (pm3) obj;
        return n12.c(this.b, pm3Var.b) && n12.c(this.f, pm3Var.f) && this.z == pm3Var.z && this.A == pm3Var.A;
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "DOMAIN-SUFFIX";
    }

    public final int hashCode() {
        return ((dw2.w(this.b.hashCode() * 31, 31, this.f) + (this.z ? 1231 : 1237)) * 31) + (this.A ? 1231 : 1237);
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Suffix(rule=", this.b, ", proxy=", this.f, ", forceRemoteDns=");
        sbE.append(this.z);
        sbE.append(", enhancedMode=");
        sbE.append(this.A);
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
    }

    @Override // defpackage.rm3
    public final boolean x() {
        return this.z;
    }
}
