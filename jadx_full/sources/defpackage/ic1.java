package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ic1 extends y1 {
    public static final Parcelable.Creator<ic1> CREATOR = new gl4(19);
    public final String b;
    public final int f;
    public final long z;

    public ic1() {
        this.b = "CLIENT_TELEMETRY";
        this.z = 1L;
        this.f = -1;
    }

    public final long a() {
        long j = this.z;
        return j == -1 ? this.f : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ic1) {
            ic1 ic1Var = (ic1) obj;
            String str = ic1Var.b;
            String str2 = this.b;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && a() == ic1Var.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Long.valueOf(a())});
    }

    public final String toString() {
        v62 v62Var = new v62(this);
        v62Var.o(this.b, "name");
        v62Var.o(Long.valueOf(a()), "version");
        return v62Var.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.Q(parcel, 1, this.b);
        ye.U(parcel, 2, 4);
        parcel.writeInt(this.f);
        long jA = a();
        ye.U(parcel, 3, 8);
        parcel.writeLong(jA);
        ye.W(parcel, iV);
    }

    public ic1(String str, int i, long j) {
        this.b = str;
        this.f = i;
        this.z = j;
    }
}
