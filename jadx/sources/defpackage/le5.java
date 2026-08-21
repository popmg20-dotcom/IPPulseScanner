package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class le5 extends y1 {
    public static final Parcelable.Creator<le5> CREATOR = new ke5(1);
    public final List b;

    public le5(ArrayList arrayList) {
        this.b = arrayList;
    }

    public static le5 a(qb5... qb5VarArr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(qb5VarArr[0].b));
        return new le5(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        List list = this.b;
        if (list != null) {
            int iV2 = ye.V(parcel, 1);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(((Integer) list.get(i2)).intValue());
            }
            ye.W(parcel, iV2);
        }
        ye.W(parcel, iV);
    }
}
