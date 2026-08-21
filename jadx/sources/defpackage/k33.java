package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k33 extends u23 {
    public static final Parcelable.Creator<k33> CREATOR = new ic2(11);
    public final int b;

    public k33(Parcel parcel) {
        super(parcel);
        this.b = parcel.readInt();
    }

    @Override // android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.b);
    }

    public k33(int i) {
        super(AbsSavedState.EMPTY_STATE);
        this.b = i;
    }
}
