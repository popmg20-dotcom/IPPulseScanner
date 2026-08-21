package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.nk1;
import defpackage.o3;
import defpackage.xe;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new o3(5);
    public final int[] A;
    public final int A0;
    public final CharSequence B0;
    public final ArrayList C0;
    public final ArrayList D0;
    public final boolean E0;
    public final int X;
    public final String Y;
    public final int Z;
    public final int[] b;
    public final ArrayList f;
    public final int y0;
    public final int[] z;
    public final CharSequence z0;

    public b(a aVar) {
        int size = aVar.a.size();
        this.b = new int[size * 6];
        if (!aVar.g) {
            xe.q("Not on back stack");
            throw null;
        }
        this.f = new ArrayList(size);
        this.z = new int[size];
        this.A = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            nk1 nk1Var = (nk1) aVar.a.get(i2);
            int i3 = i + 1;
            this.b[i] = nk1Var.a;
            ArrayList arrayList = this.f;
            o oVar = nk1Var.b;
            arrayList.add(oVar != null ? oVar.mWho : null);
            int[] iArr = this.b;
            iArr[i3] = nk1Var.c ? 1 : 0;
            iArr[i + 2] = nk1Var.d;
            iArr[i + 3] = nk1Var.e;
            int i4 = i + 5;
            iArr[i + 4] = nk1Var.f;
            i += 6;
            iArr[i4] = nk1Var.g;
            this.z[i2] = nk1Var.h.ordinal();
            this.A[i2] = nk1Var.i.ordinal();
        }
        this.X = aVar.f;
        this.Y = aVar.i;
        this.Z = aVar.t;
        this.y0 = aVar.j;
        this.z0 = aVar.k;
        this.A0 = aVar.l;
        this.B0 = aVar.m;
        this.C0 = aVar.n;
        this.D0 = aVar.o;
        this.E0 = aVar.p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.b);
        parcel.writeStringList(this.f);
        parcel.writeIntArray(this.z);
        parcel.writeIntArray(this.A);
        parcel.writeInt(this.X);
        parcel.writeString(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeInt(this.y0);
        TextUtils.writeToParcel(this.z0, parcel, 0);
        parcel.writeInt(this.A0);
        TextUtils.writeToParcel(this.B0, parcel, 0);
        parcel.writeStringList(this.C0);
        parcel.writeStringList(this.D0);
        parcel.writeInt(this.E0 ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.b = parcel.createIntArray();
        this.f = parcel.createStringArrayList();
        this.z = parcel.createIntArray();
        this.A = parcel.createIntArray();
        this.X = parcel.readInt();
        this.Y = parcel.readString();
        this.Z = parcel.readInt();
        this.y0 = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.z0 = (CharSequence) creator.createFromParcel(parcel);
        this.A0 = parcel.readInt();
        this.B0 = (CharSequence) creator.createFromParcel(parcel);
        this.C0 = parcel.createStringArrayList();
        this.D0 = parcel.createStringArrayList();
        this.E0 = parcel.readInt() != 0;
    }
}
