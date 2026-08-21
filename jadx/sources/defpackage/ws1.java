package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ws1 implements ys1 {
    public static final Parcelable.Creator<ws1> CREATOR = new o3(21);
    public final InetSocketAddress b;

    public ws1(InetSocketAddress inetSocketAddress) {
        inetSocketAddress.getClass();
        this.b = inetSocketAddress;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ws1) && n12.c(this.b, ((ws1) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "Server(socketAddress=" + this.b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeSerializable(this.b);
    }
}
