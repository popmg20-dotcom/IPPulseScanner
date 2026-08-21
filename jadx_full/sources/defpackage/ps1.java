package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.getsurfboard.profile.SuffixTreeNative;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ps1 implements ss1, sm3 {
    public static final Parcelable.Creator<ps1> CREATOR = new o3(15);
    public final om3 b;

    public ps1(om3 om3Var) {
        om3Var.getClass();
        this.b = om3Var;
    }

    @Override // defpackage.ss1
    public final void E() {
        om3 om3Var = this.b;
        SuffixTreeNative suffixTreeNative = om3Var.z0;
        if (suffixTreeNative != null) {
            suffixTreeNative.close();
        }
        om3Var.z0 = null;
    }

    @Override // defpackage.ss1
    public final List P() {
        return fx3.h(this.b);
    }

    @Override // defpackage.sm3
    public final String a() {
        return this.b.b;
    }

    @Override // defpackage.ss1
    public final boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return this.b.b(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ps1) && n12.c(this.b, ((ps1) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "DomainSet(set=" + this.b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        this.b.writeToParcel(parcel, i);
    }
}
