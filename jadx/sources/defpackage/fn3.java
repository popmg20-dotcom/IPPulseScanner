package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fn3 implements hn3 {
    public static final Parcelable.Creator<fn3> CREATOR = new ym3(4);
    public final en3 b;
    public final String f;

    public fn3(en3 en3Var, String str) {
        en3Var.getClass();
        str.getClass();
        this.b = en3Var;
        this.f = str;
    }

    @Override // defpackage.hn3
    public final /* bridge */ boolean B(String str, Integer num, int i, int i2) {
        return dw2.k(this, str, num, i, i2);
    }

    @Override // defpackage.tn3
    public final String S() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fn3)) {
            return false;
        }
        fn3 fn3Var = (fn3) obj;
        return this.b == fn3Var.b && n12.c(this.f, fn3Var.f);
    }

    @Override // defpackage.tn3
    public final String getType() {
        return "MISC-PROTOCOL";
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "Protocol(value=" + this.b + ", proxy=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b.name());
        parcel.writeString(this.f);
    }
}
