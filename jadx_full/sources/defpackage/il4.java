package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class il4 extends dl4 {
    public static final Parcelable.Creator<il4> CREATOR = new gl4(1);
    public fl4 f;
    public el4 z;

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
        this.z.k(ld0Var);
        this.f.k(ld0Var);
    }

    @Override // defpackage.dl4
    public final void l(ld0 ld0Var) {
        this.f.l(ld0Var);
        this.z.l(ld0Var);
    }

    public final String toString() {
        return "ReplaceAction{insert=" + this.f + ", delete=" + this.z + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.z, i);
    }
}
