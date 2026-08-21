package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m05 extends y1 {
    public static final Parcelable.Creator<m05> CREATOR = new gl4(10);
    public final int b;
    public final ab0 f;
    public final t05 z;

    public m05(int i, ab0 ab0Var, t05 t05Var) {
        this.b = i;
        this.f = ab0Var;
        this.z = t05Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.P(parcel, 2, this.f, i);
        ye.P(parcel, 3, this.z, i);
        ye.W(parcel, iV);
    }
}
