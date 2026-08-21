package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xm3 implements bn3 {
    public static final Parcelable.Creator<xm3> CREATOR = new ic2(29);
    public final ArrayList b;
    public final String f;

    public xm3(String str, ArrayList arrayList) {
        str.getClass();
        this.b = arrayList;
        this.f = str;
    }

    @Override // defpackage.bn3
    public final /* bridge */ boolean H(String str, String str2, InetAddress inetAddress, String str3, String str4, List list, on3 on3Var, e03 e03Var, String str5, Integer num, Integer num2, Integer num3, String str6, int i) {
        return dw2.j(this, str, str2, inetAddress, str3, str4, list, on3Var, e03Var, str5, num, num2, num3, str6, i);
    }

    @Override // defpackage.tn3
    public final String S() {
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
        if (!(obj instanceof xm3)) {
            return false;
        }
        xm3 xm3Var = (xm3) obj;
        return this.b.equals(xm3Var.b) && n12.c(this.f, xm3Var.f);
    }

    @Override // defpackage.bn3
    public final List getRules() {
        return this.b;
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "AND";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "And(rules=" + this.b + ", proxy=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        ArrayList arrayList = this.b;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((Parcelable) it.next(), i);
        }
        parcel.writeString(this.f);
    }
}
