package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kf5 extends y1 {
    public static final Parcelable.Creator<kf5> CREATOR = new ke5(3);
    public final Long A;
    public final String X;
    public final String Y;
    public final Double Z;
    public final int b;
    public final String f;
    public final long z;

    public kf5(long j, Object obj, String str, String str2) {
        tj4.f(str);
        this.b = 2;
        this.f = str;
        this.z = j;
        this.Y = str2;
        if (obj == null) {
            this.A = null;
            this.Z = null;
            this.X = null;
            return;
        }
        if (obj instanceof Long) {
            this.A = (Long) obj;
            this.Z = null;
            this.X = null;
        } else if (obj instanceof String) {
            this.A = null;
            this.Z = null;
            this.X = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                xe.k("User attribute given of un-supported type");
                throw null;
            }
            this.A = null;
            this.Z = (Double) obj;
            this.X = null;
        }
    }

    public final Object a() {
        Long l = this.A;
        if (l != null) {
            return l;
        }
        Double d = this.Z;
        if (d != null) {
            return d;
        }
        String str = this.X;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ke5.a(this, parcel);
    }

    public kf5(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.b = i;
        this.f = str;
        this.z = j;
        this.A = l;
        this.Z = i == 1 ? f != null ? Double.valueOf(f.doubleValue()) : null : d;
        this.X = str2;
        this.Y = str3;
    }

    public kf5(mf5 mf5Var) {
        this(mf5Var.d, mf5Var.e, mf5Var.c, mf5Var.b);
    }
}
