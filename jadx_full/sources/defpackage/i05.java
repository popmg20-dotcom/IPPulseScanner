package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i05 extends y1 {
    public static final Parcelable.Creator<i05> CREATOR = new gl4(9);
    public final List b;
    public final String f;

    public i05(String str, ArrayList arrayList) {
        this.b = arrayList;
        this.f = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        List<String> list = this.b;
        if (list != null) {
            int iV2 = ye.V(parcel, 1);
            parcel.writeStringList(list);
            ye.W(parcel, iV2);
        }
        ye.Q(parcel, 2, this.f);
        ye.W(parcel, iV);
    }
}
