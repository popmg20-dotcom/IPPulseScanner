package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qs1 implements ss1 {
    public static final Parcelable.Creator<qs1> CREATOR = new o3(16);
    public final String b;

    public qs1(String str) {
        str.getClass();
        this.b = str;
    }

    @Override // defpackage.ss1
    public final List P() {
        return g41.b;
    }

    @Override // defpackage.ss1
    public final boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.b;
        return p44.p0(str2, '*') ? ji0.a0(str2, str) : str.equals(str2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof qs1) && n12.c(this.b, ((qs1) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return ha0.o("Pattern(rule=", this.b, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
    }

    @Override // defpackage.ss1
    public final void E() {
    }
}
