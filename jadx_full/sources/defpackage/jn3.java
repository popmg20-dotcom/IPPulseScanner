package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jn3 implements tn3, sm3 {
    public static final Parcelable.Creator<jn3> CREATOR = new ym3(7);
    public final String b;
    public final String f;
    public final List z;

    public jn3(String str, String str2, List list) {
        str.getClass();
        str2.getClass();
        list.getClass();
        this.b = str;
        this.f = str2;
        this.z = list;
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.b;
    }

    @Override // defpackage.sm3
    public final String a() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof jn3)) {
            return false;
        }
        jn3 jn3Var = (jn3) obj;
        return n12.c(this.b, jn3Var.b) && n12.c(this.f, jn3Var.f) && n12.c(this.z, jn3Var.z);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "RULE-SET";
    }

    public final int hashCode() {
        return this.z.hashCode() + dw2.w(this.b.hashCode() * 31, 31, this.f);
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Set(proxy=", this.b, ", source=", this.f, ", rules=");
        sbE.append(this.z);
        sbE.append(")");
        return sbE.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        List list = this.z;
        parcel.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((Parcelable) it.next(), i);
        }
    }
}
