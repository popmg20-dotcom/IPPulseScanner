package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y25 extends y1 implements Iterable {
    public static final Parcelable.Creator<y25> CREATOR = new gl4(20);
    public final Bundle b;

    public y25(Bundle bundle) {
        this.b = bundle;
    }

    public final Object a(String str) {
        return this.b.get(str);
    }

    public final Double d() {
        return Double.valueOf(this.b.getDouble("value"));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c92(this);
    }

    public final String k() {
        return this.b.getString("currency");
    }

    public final Bundle l() {
        return new Bundle(this.b);
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.N(parcel, 2, l());
        ye.W(parcel, iV);
    }
}
