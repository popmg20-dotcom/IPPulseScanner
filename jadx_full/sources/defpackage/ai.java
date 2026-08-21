package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ai implements Parcelable {
    public static final Parcelable.Creator<ai> CREATOR = new o3(6);
    public final ArrayList b;
    public final ArrayList f;

    public ai(Parcel parcel) {
        this.b = parcel.createStringArrayList();
        this.f = parcel.createTypedArrayList(b.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.b);
        parcel.writeTypedList(this.f);
    }
}
