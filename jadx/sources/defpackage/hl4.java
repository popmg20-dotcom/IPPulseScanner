package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hl4 extends dl4 {
    public static final Parcelable.Creator<hl4> CREATOR = new gl4(0);
    public final ArrayList f = new ArrayList();

    @Override // defpackage.dl4
    public final boolean a(dl4 dl4Var) {
        return false;
    }

    @Override // defpackage.dl4
    public final void d(dl4 dl4Var) {
        throw new UnsupportedOperationException();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.dl4
    public final void k(ld0 ld0Var) {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f;
            if (i >= arrayList.size()) {
                return;
            }
            ((dl4) arrayList.get(i)).k(ld0Var);
            i++;
        }
    }

    @Override // defpackage.dl4
    public final void l(ld0 ld0Var) {
        ArrayList arrayList = this.f;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((dl4) arrayList.get(size)).l(ld0Var);
        }
    }

    public final void n(dl4 dl4Var) {
        ArrayList arrayList = this.f;
        if (arrayList.isEmpty()) {
            arrayList.add(dl4Var);
            return;
        }
        dl4 dl4Var2 = (dl4) fw.r(arrayList, 1);
        if (dl4Var2.a(dl4Var)) {
            dl4Var2.d(dl4Var);
        } else {
            arrayList.add(dl4Var);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ArrayList arrayList = this.f;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((dl4) it.next(), i);
        }
    }
}
