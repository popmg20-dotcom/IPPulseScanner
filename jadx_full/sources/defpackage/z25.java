package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z25 extends y1 {
    public static final Parcelable.Creator<z25> CREATOR = new gl4(21);
    public final long A;
    public final String b;
    public final y25 f;
    public final String z;

    public z25(z25 z25Var, long j) {
        tj4.i(z25Var);
        this.b = z25Var.b;
        this.f = z25Var.f;
        this.z = z25Var.z;
        this.A = j;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f);
        String str = this.z;
        int length = String.valueOf(str).length();
        String str2 = this.b;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        ha0.v(sb, "origin=", str, ",name=", str2);
        return fw.y(sb, ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        gl4.b(this, parcel, i);
    }

    public z25(String str, y25 y25Var, String str2, long j) {
        this.b = str;
        this.f = y25Var;
        this.z = str2;
        this.A = j;
    }
}
