package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k45 extends y1 {
    public static final Parcelable.Creator<k45> CREATOR = new gl4(24);
    public final int b;
    public final String f;
    public final Intent z;

    public k45(int i, String str, Intent intent) {
        this.b = i;
        this.f = str;
        this.z = intent;
    }

    public static k45 a(Activity activity) {
        return new k45(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k45)) {
            return false;
        }
        k45 k45Var = (k45) obj;
        return this.b == k45Var.b && Objects.equals(this.f, k45Var.f) && Objects.equals(this.z, k45Var.z);
    }

    public final int hashCode() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.Q(parcel, 2, this.f);
        ye.P(parcel, 3, this.z, i);
        ye.W(parcel, iV);
    }
}
