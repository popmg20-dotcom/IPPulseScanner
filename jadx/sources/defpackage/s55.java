package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s55 extends mz4 implements v55 {
    public s55(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService", 2);
    }

    @Override // defpackage.v55
    public final void A(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        E(parcelC, 20);
    }

    @Override // defpackage.v55
    public final void B(kf5 kf5Var, tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, kf5Var);
        d35.b(parcelC, tg5Var);
        E(parcelC, 2);
    }

    @Override // defpackage.v55
    public final String C(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        Parcel parcelB = b(parcelC, 11);
        String string = parcelB.readString();
        parcelB.recycle();
        return string;
    }

    @Override // defpackage.v55
    public final List D(String str, String str2, boolean z, tg5 tg5Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        ClassLoader classLoader = d35.a;
        parcelC.writeInt(z ? 1 : 0);
        d35.b(parcelC, tg5Var);
        Parcel parcelB = b(parcelC, 14);
        ArrayList arrayListCreateTypedArrayList = parcelB.createTypedArrayList(kf5.CREATOR);
        parcelB.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.v55
    public final List e(String str, String str2, String str3, boolean z) {
        Parcel parcelC = c();
        parcelC.writeString(null);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        ClassLoader classLoader = d35.a;
        parcelC.writeInt(z ? 1 : 0);
        Parcel parcelB = b(parcelC, 15);
        ArrayList arrayListCreateTypedArrayList = parcelB.createTypedArrayList(kf5.CREATOR);
        parcelB.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.v55
    public final void f(z25 z25Var, tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, z25Var);
        d35.b(parcelC, tg5Var);
        E(parcelC, 1);
    }

    @Override // defpackage.v55
    public final void h(long j, String str, String str2, String str3) {
        Parcel parcelC = c();
        parcelC.writeLong(j);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        E(parcelC, 10);
    }

    @Override // defpackage.v55
    public final byte[] i(String str, z25 z25Var) {
        Parcel parcelC = c();
        d35.b(parcelC, z25Var);
        parcelC.writeString(str);
        Parcel parcelB = b(parcelC, 9);
        byte[] bArrCreateByteArray = parcelB.createByteArray();
        parcelB.recycle();
        return bArrCreateByteArray;
    }

    @Override // defpackage.v55
    public final List j(String str, String str2, String str3) {
        Parcel parcelC = c();
        parcelC.writeString(null);
        parcelC.writeString(str2);
        parcelC.writeString(str3);
        Parcel parcelB = b(parcelC, 17);
        ArrayList arrayListCreateTypedArrayList = parcelB.createTypedArrayList(q15.CREATOR);
        parcelB.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.v55
    public final void k(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        E(parcelC, 25);
    }

    @Override // defpackage.v55
    public final void l(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        E(parcelC, 6);
    }

    @Override // defpackage.v55
    public final void m(tg5 tg5Var, Bundle bundle, y55 y55Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        d35.b(parcelC, bundle);
        d35.c(parcelC, y55Var);
        E(parcelC, 31);
    }

    @Override // defpackage.v55
    public final void n(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        E(parcelC, 26);
    }

    @Override // defpackage.v55
    public final void o(tg5 tg5Var, k15 k15Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        d35.b(parcelC, k15Var);
        E(parcelC, 30);
    }

    @Override // defpackage.v55
    public final c25 p(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        Parcel parcelB = b(parcelC, 21);
        c25 c25Var = (c25) d35.a(parcelB, c25.CREATOR);
        parcelB.recycle();
        return c25Var;
    }

    @Override // defpackage.v55
    public final void q(Bundle bundle, tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, bundle);
        d35.b(parcelC, tg5Var);
        E(parcelC, 19);
    }

    @Override // defpackage.v55
    public final void r(q15 q15Var, tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, q15Var);
        d35.b(parcelC, tg5Var);
        E(parcelC, 12);
    }

    @Override // defpackage.v55
    public final void s(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        E(parcelC, 4);
    }

    @Override // defpackage.v55
    public final void u(tg5 tg5Var, le5 le5Var, b65 b65Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        d35.b(parcelC, le5Var);
        d35.c(parcelC, b65Var);
        E(parcelC, 29);
    }

    @Override // defpackage.v55
    public final List w(String str, String str2, tg5 tg5Var) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        d35.b(parcelC, tg5Var);
        Parcel parcelB = b(parcelC, 16);
        ArrayList arrayListCreateTypedArrayList = parcelB.createTypedArrayList(q15.CREATOR);
        parcelB.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // defpackage.v55
    public final void y(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        E(parcelC, 27);
    }

    @Override // defpackage.v55
    public final void z(tg5 tg5Var) {
        Parcel parcelC = c();
        d35.b(parcelC, tg5Var);
        E(parcelC, 18);
    }
}
