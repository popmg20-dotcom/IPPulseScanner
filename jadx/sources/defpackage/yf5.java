package defpackage;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yf5 extends mz4 {
    public final wv1 G(bu2 bu2Var, String str, int i, bu2 bu2Var2) {
        Parcel parcelC = c();
        k35.b(parcelC, bu2Var);
        parcelC.writeString(str);
        parcelC.writeInt(i);
        k35.b(parcelC, bu2Var2);
        Parcel parcelA = a(parcelC, 2);
        wv1 wv1VarF = bu2.F(parcelA.readStrongBinder());
        parcelA.recycle();
        return wv1VarF;
    }

    public final wv1 H(bu2 bu2Var, String str, int i, bu2 bu2Var2) {
        Parcel parcelC = c();
        k35.b(parcelC, bu2Var);
        parcelC.writeString(str);
        parcelC.writeInt(i);
        k35.b(parcelC, bu2Var2);
        Parcel parcelA = a(parcelC, 3);
        wv1 wv1VarF = bu2.F(parcelA.readStrongBinder());
        parcelA.recycle();
        return wv1VarF;
    }
}
