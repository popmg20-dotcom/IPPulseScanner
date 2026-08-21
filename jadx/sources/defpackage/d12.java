package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d12 implements Parcelable {
    public static final Parcelable.Creator<d12> CREATOR = new o3(26);
    public final int A;
    public final IntentSender b;
    public final Intent f;
    public final int z;

    public d12(IntentSender intentSender, Intent intent, int i, int i2) {
        this.b = intentSender;
        this.f = intent;
        this.z = i;
        this.A = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.f, i);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
    }
}
