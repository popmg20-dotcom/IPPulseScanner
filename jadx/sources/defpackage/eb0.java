package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eb0 extends y1 {
    public static final Parcelable.Creator<eb0> CREATOR = new gl4(27);
    public final int[] A;
    public final int X;
    public final int[] Y;
    public final xl3 b;
    public final boolean f;
    public final boolean z;

    public eb0(xl3 xl3Var, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.b = xl3Var;
        this.f = z;
        this.z = z2;
        this.A = iArr;
        this.X = i;
        this.Y = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.P(parcel, 1, this.b, i);
        ye.U(parcel, 2, 4);
        parcel.writeInt(this.f ? 1 : 0);
        ye.U(parcel, 3, 4);
        parcel.writeInt(this.z ? 1 : 0);
        int[] iArr = this.A;
        if (iArr != null) {
            int iV2 = ye.V(parcel, 4);
            parcel.writeIntArray(iArr);
            ye.W(parcel, iV2);
        }
        ye.U(parcel, 5, 4);
        parcel.writeInt(this.X);
        int[] iArr2 = this.Y;
        if (iArr2 != null) {
            int iV3 = ye.V(parcel, 6);
            parcel.writeIntArray(iArr2);
            ye.W(parcel, iV3);
        }
        ye.W(parcel, iV);
    }
}
