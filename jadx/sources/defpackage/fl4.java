package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fl4 extends dl4 {
    public static final Parcelable.Creator<fl4> CREATOR = new ym3(29);
    public int A;
    public int X;
    public final transient long Y = System.currentTimeMillis();
    public CharSequence Z;
    public int f;
    public int z;

    @Override // defpackage.dl4
    public final boolean a(dl4 dl4Var) {
        if (!(dl4Var instanceof fl4)) {
            return false;
        }
        fl4 fl4Var = (fl4) dl4Var;
        if (fl4Var.A == this.X && fl4Var.f == this.z) {
            return this.Z.length() + fl4Var.Z.length() < 10000 && Math.abs(fl4Var.Y - this.Y) < 8000;
        }
        return false;
    }

    @Override // defpackage.dl4
    public final void d(dl4 dl4Var) {
        StringBuilder sb;
        if (!a(dl4Var)) {
            s53.d();
            return;
        }
        fl4 fl4Var = (fl4) dl4Var;
        this.X = fl4Var.X;
        this.z = fl4Var.z;
        CharSequence charSequence = this.Z;
        if (charSequence instanceof StringBuilder) {
            sb = (StringBuilder) charSequence;
        } else {
            StringBuilder sb2 = new StringBuilder(charSequence);
            this.Z = sb2;
            sb = sb2;
        }
        sb.append(fl4Var.Z);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // defpackage.dl4
    public final void k(ld0 ld0Var) {
        ld0Var.r(this.f, this.A, this.Z);
    }

    @Override // defpackage.dl4
    public final void l(ld0 ld0Var) {
        ld0Var.h(this.f, this.A, this.z, this.X);
    }

    public final String toString() {
        return "InsertAction{startLine=" + this.f + ", endLine=" + this.z + ", startColumn=" + this.A + ", endColumn=" + this.X + ", createTime=" + this.Y + ", text=" + ((Object) this.Z) + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeInt(this.A);
        parcel.writeInt(this.z);
        parcel.writeInt(this.X);
        parcel.writeString(this.Z.toString());
    }
}
