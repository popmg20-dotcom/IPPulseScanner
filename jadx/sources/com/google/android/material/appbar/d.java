package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.y;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d extends y {
    public static final Parcelable.Creator<d> CREATOR = new c();
    public boolean A;
    public int X;
    public float Y;
    public boolean Z;
    public boolean z;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.z = parcel.readByte() != 0;
        this.A = parcel.readByte() != 0;
        this.X = parcel.readInt();
        this.Y = parcel.readFloat();
        this.Z = parcel.readByte() != 0;
    }

    @Override // defpackage.y, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.z ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.X);
        parcel.writeFloat(this.Y);
        parcel.writeByte(this.Z ? (byte) 1 : (byte) 0);
    }
}
