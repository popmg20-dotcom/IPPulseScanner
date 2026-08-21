package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jl4 implements vd0, Parcelable {
    public static final Parcelable.Creator<jl4> CREATOR = new ym3(27);
    public boolean f;
    public boolean y0;
    public int z;
    public ic4 z0;
    public final ArrayList b = new ArrayList();
    public boolean X = false;
    public el4 A = null;
    public int Y = 0;
    public boolean Z = false;

    @Override // defpackage.vd0
    public final void F(ld0 ld0Var, int i, int i2, int i3, int i4, CharSequence charSequence) {
        el4 el4Var;
        if (this.Z) {
            return;
        }
        fl4 fl4Var = new fl4();
        fl4Var.f = i;
        fl4Var.A = i2;
        fl4Var.z = i3;
        fl4Var.X = i4;
        fl4Var.Z = charSequence;
        if (!this.X || (el4Var = this.A) == null) {
            fl4Var.b = this.z0;
            b0(ld0Var, fl4Var);
        } else {
            il4 il4Var = new il4();
            il4Var.z = el4Var;
            il4Var.f = fl4Var;
            il4Var.b = this.z0;
            b0(ld0Var, il4Var);
        }
        this.A = null;
        this.X = false;
    }

    @Override // defpackage.vd0
    public final void I(ld0 ld0Var) {
        if (!this.f || ld0Var.A0 == null) {
            return;
        }
        if (!this.X || this.A == null) {
            lg0 lg0VarM = ld0Var.m();
            this.z0 = new ic4(lg0VarM.c.a(), lg0VarM.d.a());
        }
    }

    @Override // defpackage.vd0
    public final void Q(ld0 ld0Var, int i, int i2, int i3, int i4, StringBuilder sb) {
        if (this.Z) {
            return;
        }
        el4 el4Var = new el4();
        this.A = el4Var;
        el4Var.X = i4;
        el4Var.A = i2;
        el4Var.z = i3;
        el4Var.f = i;
        el4Var.Z = sb;
        el4Var.b = this.z0;
        if (this.X) {
            return;
        }
        b0(ld0Var, el4Var);
    }

    @Override // defpackage.vd0
    public final void a(ld0 ld0Var) {
        if (this.Z) {
            return;
        }
        this.X = true;
    }

    public final void a0() {
        boolean z = this.f;
        ArrayList arrayList = this.b;
        if (!z) {
            arrayList.clear();
            this.Y = 0;
        } else {
            while (this.Y > 1 && arrayList.size() > this.z) {
                arrayList.remove(0);
                this.Y--;
            }
        }
    }

    public final void b0(ld0 ld0Var, dl4 dl4Var) {
        ArrayList arrayList;
        if (this.f) {
            while (true) {
                int i = this.Y;
                arrayList = this.b;
                if (i >= arrayList.size()) {
                    break;
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
            if (ld0Var.X > 0) {
                if (arrayList.isEmpty()) {
                    hl4 hl4Var = new hl4();
                    hl4Var.n(dl4Var);
                    hl4Var.b = dl4Var.b;
                    arrayList.add(hl4Var);
                    this.Y++;
                } else {
                    dl4 dl4Var2 = (dl4) fw.r(arrayList, 1);
                    if (!(dl4Var2 instanceof hl4) || this.y0) {
                        hl4 hl4Var2 = new hl4();
                        hl4Var2.n(dl4Var);
                        hl4Var2.b = dl4Var.b;
                        arrayList.add(hl4Var2);
                        this.Y++;
                    } else {
                        ((hl4) dl4Var2).n(dl4Var);
                    }
                }
            } else if (arrayList.isEmpty()) {
                arrayList.add(dl4Var);
                this.Y++;
            } else {
                dl4 dl4Var3 = (dl4) fw.r(arrayList, 1);
                if (dl4Var3.a(dl4Var)) {
                    dl4Var3.d(dl4Var);
                } else {
                    arrayList.add(dl4Var);
                    this.Y++;
                }
            }
            this.y0 = false;
            a0();
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.z);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.f ? 1 : 0);
        ArrayList arrayList = this.b;
        parcel.writeInt(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((dl4) it.next(), i);
        }
    }
}
