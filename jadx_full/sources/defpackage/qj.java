package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import io.netty.handler.codec.dns.DnsRecord;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qj implements Parcelable {
    public static final Parcelable.Creator<qj> CREATOR = new o3(7);
    public Integer A;
    public String A0;
    public Locale E0;
    public CharSequence F0;
    public CharSequence G0;
    public int H0;
    public int I0;
    public Integer J0;
    public Integer L0;
    public Integer M0;
    public Integer N0;
    public Integer O0;
    public Integer P0;
    public Integer Q0;
    public Integer R0;
    public Integer S0;
    public Integer T0;
    public Boolean U0;
    public Integer V0;
    public Integer X;
    public Integer Y;
    public Integer Z;
    public int b;
    public Integer f;
    public Integer y0;
    public Integer z;
    public int z0 = DnsRecord.CLASS_ANY;
    public int B0 = -2;
    public int C0 = -2;
    public int D0 = -2;
    public Boolean K0 = Boolean.TRUE;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeSerializable(this.f);
        parcel.writeSerializable(this.z);
        parcel.writeSerializable(this.A);
        parcel.writeSerializable(this.X);
        parcel.writeSerializable(this.Y);
        parcel.writeSerializable(this.Z);
        parcel.writeSerializable(this.y0);
        parcel.writeInt(this.z0);
        parcel.writeString(this.A0);
        parcel.writeInt(this.B0);
        parcel.writeInt(this.C0);
        parcel.writeInt(this.D0);
        CharSequence charSequence = this.F0;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.G0;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.H0);
        parcel.writeSerializable(this.J0);
        parcel.writeSerializable(this.L0);
        parcel.writeSerializable(this.M0);
        parcel.writeSerializable(this.N0);
        parcel.writeSerializable(this.O0);
        parcel.writeSerializable(this.P0);
        parcel.writeSerializable(this.Q0);
        parcel.writeSerializable(this.T0);
        parcel.writeSerializable(this.R0);
        parcel.writeSerializable(this.S0);
        parcel.writeSerializable(this.K0);
        parcel.writeSerializable(this.E0);
        parcel.writeSerializable(this.U0);
        parcel.writeSerializable(this.V0);
    }
}
