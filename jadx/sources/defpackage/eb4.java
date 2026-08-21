package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eb4 extends y1 {
    public static final Parcelable.Creator<eb4> CREATOR = new gl4(6);
    public final int b;
    public List f;

    public eb4(int i, List list) {
        this.b = i;
        this.f = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.S(parcel, 2, this.f);
        ye.W(parcel, iV);
    }
}
