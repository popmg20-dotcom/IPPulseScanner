package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.fw;
import defpackage.o3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable {
    public static final Parcelable.Creator<w> CREATOR = new o3(12);
    public final boolean A;
    public final boolean A0;
    public final boolean B0;
    public final int C0;
    public final String D0;
    public final int E0;
    public final boolean F0;
    public final int X;
    public final int Y;
    public final String Z;
    public final String b;
    public final String f;
    public final boolean y0;
    public final boolean z;
    public final boolean z0;

    public w(Parcel parcel) {
        this.b = parcel.readString();
        this.f = parcel.readString();
        this.z = parcel.readInt() != 0;
        this.A = parcel.readInt() != 0;
        this.X = parcel.readInt();
        this.Y = parcel.readInt();
        this.Z = parcel.readString();
        this.y0 = parcel.readInt() != 0;
        this.z0 = parcel.readInt() != 0;
        this.A0 = parcel.readInt() != 0;
        this.B0 = parcel.readInt() != 0;
        this.C0 = parcel.readInt();
        this.D0 = parcel.readString();
        this.E0 = parcel.readInt();
        this.F0 = parcel.readInt() != 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sbB = fw.B(128, "FragmentState{");
        sbB.append(this.b);
        sbB.append(" (");
        sbB.append(this.f);
        sbB.append(")}:");
        if (this.z) {
            sbB.append(" fromLayout");
        }
        if (this.A) {
            sbB.append(" dynamicContainer");
        }
        int i = this.Y;
        if (i != 0) {
            sbB.append(" id=0x");
            sbB.append(Integer.toHexString(i));
        }
        String str = this.Z;
        if (str != null && !str.isEmpty()) {
            sbB.append(" tag=");
            sbB.append(str);
        }
        if (this.y0) {
            sbB.append(" retainInstance");
        }
        if (this.z0) {
            sbB.append(" removing");
        }
        if (this.A0) {
            sbB.append(" detached");
        }
        if (this.B0) {
            sbB.append(" hidden");
        }
        String str2 = this.D0;
        if (str2 != null) {
            sbB.append(" targetWho=");
            sbB.append(str2);
            sbB.append(" targetRequestCode=");
            sbB.append(this.E0);
        }
        if (this.F0) {
            sbB.append(" userVisibleHint");
        }
        return sbB.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.f);
        parcel.writeInt(this.z ? 1 : 0);
        parcel.writeInt(this.A ? 1 : 0);
        parcel.writeInt(this.X);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
        parcel.writeInt(this.y0 ? 1 : 0);
        parcel.writeInt(this.z0 ? 1 : 0);
        parcel.writeInt(this.A0 ? 1 : 0);
        parcel.writeInt(this.B0 ? 1 : 0);
        parcel.writeInt(this.C0);
        parcel.writeString(this.D0);
        parcel.writeInt(this.E0);
        parcel.writeInt(this.F0 ? 1 : 0);
    }

    public w(o oVar) {
        this.b = oVar.getClass().getName();
        this.f = oVar.mWho;
        this.z = oVar.mFromLayout;
        this.A = oVar.mInDynamicContainer;
        this.X = oVar.mFragmentId;
        this.Y = oVar.mContainerId;
        this.Z = oVar.mTag;
        this.y0 = oVar.mRetainInstance;
        this.z0 = oVar.mRemoving;
        this.A0 = oVar.mDetached;
        this.B0 = oVar.mHidden;
        this.C0 = oVar.mMaxState.ordinal();
        this.D0 = oVar.mTargetWho;
        this.E0 = oVar.mTargetRequestCode;
        this.F0 = oVar.mUserVisibleHint;
    }
}
