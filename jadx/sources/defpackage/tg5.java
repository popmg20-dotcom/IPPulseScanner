package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tg5 extends y1 {
    public static final Parcelable.Creator<tg5> CREATOR = new ke5(4);
    public final String A;
    public final long A0;
    public final String B0;
    public final long C0;
    public final int D0;
    public final boolean E0;
    public final boolean F0;
    public final Boolean G0;
    public final long H0;
    public final List I0;
    public final String J0;
    public final String K0;
    public final String L0;
    public final boolean M0;
    public final long N0;
    public final int O0;
    public final String P0;
    public final int Q0;
    public final long R0;
    public final String S0;
    public final String T0;
    public final long U0;
    public final int V0;
    public final long X;
    public final long Y;
    public final String Z;
    public final String b;
    public final String f;
    public final boolean y0;
    public final String z;
    public final boolean z0;

    public tg5(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, int i, boolean z3, boolean z4, Boolean bool, long j5, List list, String str7, String str8, String str9, boolean z5, long j6, int i2, String str10, int i3, long j7, String str11, String str12, long j8, int i4) {
        tj4.f(str);
        this.b = str;
        this.f = true == TextUtils.isEmpty(str2) ? null : str2;
        this.z = str3;
        this.A0 = j;
        this.A = str4;
        this.X = j2;
        this.Y = j3;
        this.Z = str5;
        this.y0 = z;
        this.z0 = z2;
        this.B0 = str6;
        this.C0 = j4;
        this.D0 = i;
        this.E0 = z3;
        this.F0 = z4;
        this.G0 = bool;
        this.H0 = j5;
        this.I0 = list;
        this.J0 = str7;
        this.K0 = str8;
        this.L0 = str9;
        this.M0 = z5;
        this.N0 = j6;
        this.O0 = i2;
        this.P0 = str10;
        this.Q0 = i3;
        this.R0 = j7;
        this.S0 = str11;
        this.T0 = str12;
        this.U0 = j8;
        this.V0 = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.Q(parcel, 2, this.b);
        ye.Q(parcel, 3, this.f);
        ye.Q(parcel, 4, this.z);
        ye.Q(parcel, 5, this.A);
        ye.U(parcel, 6, 8);
        parcel.writeLong(this.X);
        ye.U(parcel, 7, 8);
        parcel.writeLong(this.Y);
        ye.Q(parcel, 8, this.Z);
        ye.U(parcel, 9, 4);
        parcel.writeInt(this.y0 ? 1 : 0);
        ye.U(parcel, 10, 4);
        parcel.writeInt(this.z0 ? 1 : 0);
        ye.U(parcel, 11, 8);
        parcel.writeLong(this.A0);
        ye.Q(parcel, 12, this.B0);
        ye.U(parcel, 14, 8);
        parcel.writeLong(this.C0);
        ye.U(parcel, 15, 4);
        parcel.writeInt(this.D0);
        ye.U(parcel, 16, 4);
        parcel.writeInt(this.E0 ? 1 : 0);
        ye.U(parcel, 18, 4);
        parcel.writeInt(this.F0 ? 1 : 0);
        Boolean bool = this.G0;
        if (bool != null) {
            ye.U(parcel, 21, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        ye.U(parcel, 22, 8);
        parcel.writeLong(this.H0);
        List<String> list = this.I0;
        if (list != null) {
            int iV2 = ye.V(parcel, 23);
            parcel.writeStringList(list);
            ye.W(parcel, iV2);
        }
        ye.Q(parcel, 25, this.J0);
        ye.Q(parcel, 26, this.K0);
        ye.Q(parcel, 27, this.L0);
        ye.U(parcel, 28, 4);
        parcel.writeInt(this.M0 ? 1 : 0);
        ye.U(parcel, 29, 8);
        parcel.writeLong(this.N0);
        ye.U(parcel, 30, 4);
        parcel.writeInt(this.O0);
        ye.Q(parcel, 31, this.P0);
        ye.U(parcel, 32, 4);
        parcel.writeInt(this.Q0);
        ye.U(parcel, 34, 8);
        parcel.writeLong(this.R0);
        ye.Q(parcel, 35, this.S0);
        ye.Q(parcel, 36, this.T0);
        ye.U(parcel, 37, 8);
        parcel.writeLong(this.U0);
        ye.U(parcel, 38, 4);
        parcel.writeInt(this.V0);
        ye.W(parcel, iV);
    }

    public tg5(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, int i, boolean z3, boolean z4, Boolean bool, long j5, ArrayList arrayList, String str7, String str8, String str9, boolean z5, long j6, int i2, String str10, int i3, long j7, String str11, String str12, long j8, int i4) {
        this.b = str;
        this.f = str2;
        this.z = str3;
        this.A0 = j3;
        this.A = str4;
        this.X = j;
        this.Y = j2;
        this.Z = str5;
        this.y0 = z;
        this.z0 = z2;
        this.B0 = str6;
        this.C0 = j4;
        this.D0 = i;
        this.E0 = z3;
        this.F0 = z4;
        this.G0 = bool;
        this.H0 = j5;
        this.I0 = arrayList;
        this.J0 = str7;
        this.K0 = str8;
        this.L0 = str9;
        this.M0 = z5;
        this.N0 = j6;
        this.O0 = i2;
        this.P0 = str10;
        this.Q0 = i3;
        this.R0 = j7;
        this.S0 = str11;
        this.T0 = str12;
        this.U0 = j8;
        this.V0 = i4;
    }
}
