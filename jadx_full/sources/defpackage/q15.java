package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q15 extends y1 {
    public static final Parcelable.Creator<q15> CREATOR = new gl4(17);
    public long A;
    public final long A0;
    public final z25 B0;
    public boolean X;
    public String Y;
    public final z25 Z;
    public String b;
    public String f;
    public long y0;
    public kf5 z;
    public z25 z0;

    public q15(q15 q15Var) {
        tj4.i(q15Var);
        this.b = q15Var.b;
        this.f = q15Var.f;
        this.z = q15Var.z;
        this.A = q15Var.A;
        this.X = q15Var.X;
        this.Y = q15Var.Y;
        this.Z = q15Var.Z;
        this.y0 = q15Var.y0;
        this.z0 = q15Var.z0;
        this.A0 = q15Var.A0;
        this.B0 = q15Var.B0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.Q(parcel, 2, this.b);
        ye.Q(parcel, 3, this.f);
        ye.P(parcel, 4, this.z, i);
        long j = this.A;
        ye.U(parcel, 5, 8);
        parcel.writeLong(j);
        boolean z = this.X;
        ye.U(parcel, 6, 4);
        parcel.writeInt(z ? 1 : 0);
        ye.Q(parcel, 7, this.Y);
        ye.P(parcel, 8, this.Z, i);
        long j2 = this.y0;
        ye.U(parcel, 9, 8);
        parcel.writeLong(j2);
        ye.P(parcel, 10, this.z0, i);
        ye.U(parcel, 11, 8);
        parcel.writeLong(this.A0);
        ye.P(parcel, 12, this.B0, i);
        ye.W(parcel, iV);
    }

    public q15(String str, String str2, kf5 kf5Var, long j, boolean z, String str3, z25 z25Var, long j2, z25 z25Var2, long j3, z25 z25Var3) {
        this.b = str;
        this.f = str2;
        this.z = kf5Var;
        this.A = j;
        this.X = z;
        this.Y = str3;
        this.Z = z25Var;
        this.y0 = j2;
        this.z0 = z25Var2;
        this.A0 = j3;
        this.B0 = z25Var3;
    }
}
