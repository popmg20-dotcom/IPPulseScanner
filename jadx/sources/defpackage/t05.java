package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t05 extends y1 {
    public static final Parcelable.Creator<t05> CREATOR = new gl4(13);
    public final boolean A;
    public final boolean X;
    public final int b;
    public final IBinder f;
    public final ab0 z;

    public t05(int i, IBinder iBinder, ab0 ab0Var, boolean z, boolean z2) {
        this.b = i;
        this.f = iBinder;
        this.z = ab0Var;
        this.A = z;
        this.X = z2;
    }

    public final boolean equals(Object obj) {
        Object jh5Var;
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            if (!(obj instanceof t05)) {
                return false;
            }
            t05 t05Var = (t05) obj;
            if (!this.z.equals(t05Var.z)) {
                return false;
            }
            Object jh5Var2 = null;
            IBinder iBinder = this.f;
            if (iBinder == null) {
                jh5Var = null;
            } else {
                int i = a3.d;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                jh5Var = iInterfaceQueryLocalInterface instanceof lv1 ? (lv1) iInterfaceQueryLocalInterface : new jh5(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            IBinder iBinder2 = t05Var.f;
            if (iBinder2 != null) {
                int i2 = a3.d;
                IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                jh5Var2 = iInterfaceQueryLocalInterface2 instanceof lv1 ? (lv1) iInterfaceQueryLocalInterface2 : new jh5(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 1);
            }
            if (!gb4.I(jh5Var, jh5Var2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.O(parcel, 2, this.f);
        ye.P(parcel, 3, this.z, i);
        ye.U(parcel, 4, 4);
        parcel.writeInt(this.A ? 1 : 0);
        ye.U(parcel, 5, 4);
        parcel.writeInt(this.X ? 1 : 0);
        ye.W(parcel, iV);
    }
}
