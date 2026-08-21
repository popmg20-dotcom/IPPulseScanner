package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ne5 extends y1 {
    public static final Parcelable.Creator<ne5> CREATOR = new ke5(2);
    public final List b;

    public ne5(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.S(parcel, 1, this.b);
        ye.W(parcel, iV);
    }
}
