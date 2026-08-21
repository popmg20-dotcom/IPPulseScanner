package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ew4 implements Parcelable {
    public static final Parcelable.Creator<ew4> CREATOR = new gl4(5);
    public final e03 A;
    public final int X;
    public final String b;
    public final String f;
    public final ArrayList z;

    public ew4(String str, String str2, ArrayList arrayList, e03 e03Var, int i) {
        str.getClass();
        e03Var.getClass();
        this.b = str;
        this.f = str2;
        this.z = arrayList;
        this.A = e03Var;
        this.X = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ew4)) {
            return false;
        }
        ew4 ew4Var = (ew4) obj;
        return n12.c(this.b, ew4Var.b) && n12.c(this.f, ew4Var.f) && this.z.equals(ew4Var.z) && n12.c(this.A, ew4Var.A) && this.X == ew4Var.X;
    }

    public final int hashCode() {
        int iHashCode = this.b.hashCode() * 31;
        String str = this.f;
        return ((this.A.hashCode() + ((this.z.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31) + this.X;
    }

    public final String toString() {
        StringBuilder sbE = fw.E("Peer(publicKey=", this.b, ", preSharedKey=", this.f, ", allowIPs=");
        sbE.append(this.z);
        sbE.append(", endPoint=");
        sbE.append(this.A);
        sbE.append(", keepAlive=");
        return fw.w(")", sbE, this.X);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        ArrayList arrayList = this.z;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((fm3) it.next()).writeToParcel(parcel, i);
        }
        parcel.writeSerializable(this.A);
        parcel.writeInt(this.X);
    }
}
