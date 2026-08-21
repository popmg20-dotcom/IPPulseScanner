package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tu0 implements ea3 {
    public static final Parcelable.Creator<tu0> CREATOR = new o3(8);
    public String b;
    public final boolean f;
    public final tn z;

    public tu0(String str, boolean z, tn tnVar) {
        str.getClass();
        tnVar.getClass();
        this.b = str;
        this.f = z;
        this.z = tnVar;
    }

    @Override // defpackage.ea3
    public final /* bridge */ boolean A(t53 t53Var, Map map, boolean z) {
        return dw2.q(this, t53Var, map, z);
    }

    @Override // defpackage.ea3
    public final String C() {
        return this.b;
    }

    @Override // defpackage.ea3
    public final void K(String str) {
        str.getClass();
        this.b = str;
    }

    @Override // defpackage.ea3
    public final boolean U(boolean z) {
        return true;
    }

    @Override // defpackage.ea3
    public final tn X() {
        return this.z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.ea3
    public final boolean e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof tu0)) {
            return false;
        }
        tu0 tu0Var = (tu0) obj;
        return n12.c(this.b, tu0Var.b) && this.f == tu0Var.f && this.z == tu0Var.z;
    }

    @Override // defpackage.ea3
    public final String getName() {
        return this.b;
    }

    @Override // defpackage.ea3
    public final /* bridge */ String getType() {
        return dw2.g(this);
    }

    public final int hashCode() {
        return this.z.hashCode() + (((this.b.hashCode() * 31) + (this.f ? 1231 : 1237)) * 31);
    }

    @Override // defpackage.ea3
    public final String q() {
        return null;
    }

    public final String toString() {
        return "Direct(name=" + this.b + ", udpRelay=" + this.f + ", blockQuic=" + this.z + ")";
    }

    @Override // defpackage.ea3
    public final /* bridge */ boolean v() {
        return dw2.h(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.b);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeString(this.z.name());
    }

    public /* synthetic */ tu0(String str, tn tnVar, int i) {
        this(str, true, (i & 4) != 0 ? tn.z : tnVar);
    }
}
