package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w14 implements Parcelable {
    public static final Parcelable.Creator<w14> CREATOR = new ym3(20);
    public boolean A;
    public int b;
    public int f;
    public int[] z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "FullSpanItem{mPosition=" + this.b + ", mGapDir=" + this.f + ", mHasUnwantedGapAfter=" + this.A + ", mGapPerSpan=" + Arrays.toString(this.z) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.f);
        parcel.writeInt(this.A ? 1 : 0);
        int[] iArr = this.z;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.z);
        }
    }
}
