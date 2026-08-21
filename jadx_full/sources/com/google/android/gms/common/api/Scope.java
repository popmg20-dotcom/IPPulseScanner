package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.gl4;
import defpackage.tj4;
import defpackage.y1;
import defpackage.ye;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends y1 implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new gl4(22);
    public final int b;
    public final String f;

    public Scope(int i, String str) {
        tj4.g(str, "scopeUri must not be null or empty");
        this.b = i;
        this.f = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f.equals(((Scope) obj).f);
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final String toString() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(this.b);
        ye.Q(parcel, 2, this.f);
        ye.W(parcel, iV);
    }
}
