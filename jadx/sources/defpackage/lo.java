package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lo extends y {
    public static final Parcelable.Creator<lo> CREATOR = new x(1);
    public final int A;
    public final boolean X;
    public final boolean Y;
    public final boolean Z;
    public final int z;

    public lo(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.z = parcel.readInt();
        this.A = parcel.readInt();
        this.X = parcel.readInt() == 1;
        this.Y = parcel.readInt() == 1;
        this.Z = parcel.readInt() == 1;
    }

    @Override // defpackage.y, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.X ? 1 : 0);
        parcel.writeInt(this.Y ? 1 : 0);
        parcel.writeInt(this.Z ? 1 : 0);
    }

    public lo(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.z = bottomSheetBehavior.f1;
        this.A = bottomSheetBehavior.Y;
        this.X = bottomSheetBehavior.f;
        this.Y = bottomSheetBehavior.a1;
        this.Z = bottomSheetBehavior.b1;
    }
}
