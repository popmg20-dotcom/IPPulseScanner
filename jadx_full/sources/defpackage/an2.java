package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class an2 extends u23 {
    public static final Parcelable.Creator<an2> CREATOR = new ic2(4);
    public HashSet b;

    public an2(Parcel parcel) {
        super(parcel);
        int i = parcel.readInt();
        this.b = new HashSet();
        String[] strArr = new String[i];
        parcel.readStringArray(strArr);
        Collections.addAll(this.b, strArr);
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.b.size());
        HashSet hashSet = this.b;
        parcel.writeStringArray((String[]) hashSet.toArray(new String[hashSet.size()]));
    }
}
