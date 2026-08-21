package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rs1 implements ss1, sm3 {
    public static final Parcelable.Creator<rs1> CREATOR = new o3(17);
    public final tn3 b;
    public final String f;

    public rs1(tn3 tn3Var, String str) {
        tn3Var.getClass();
        str.getClass();
        this.b = tn3Var;
        this.f = str;
    }

    @Override // defpackage.ss1
    public final void E() {
        fx3.g(this.b);
    }

    @Override // defpackage.ss1
    public final List P() {
        return fx3.h(this.b);
    }

    @Override // defpackage.sm3
    public final String a() {
        return this.f;
    }

    @Override // defpackage.ss1
    public final boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return ye.E(this.b, str, 0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof rs1)) {
            return false;
        }
        rs1 rs1Var = (rs1) obj;
        return n12.c(this.b, rs1Var.b) && n12.c(this.f, rs1Var.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "RuleSet(rule=" + this.b + ", source=" + this.f + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.f);
    }
}
