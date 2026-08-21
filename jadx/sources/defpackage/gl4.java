package defpackage;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gl4 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ gl4(int i) {
        this.a = i;
    }

    public static void a(yo1 yo1Var, Parcel parcel, int i) {
        int iV = ye.V(parcel, 20293);
        int i2 = yo1Var.b;
        ye.U(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = yo1Var.f;
        ye.U(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = yo1Var.z;
        ye.U(parcel, 3, 4);
        parcel.writeInt(i4);
        ye.Q(parcel, 4, yo1Var.A);
        ye.O(parcel, 5, yo1Var.X);
        ye.R(parcel, 6, yo1Var.Y, i);
        ye.N(parcel, 7, yo1Var.Z);
        ye.P(parcel, 8, yo1Var.y0, i);
        ye.R(parcel, 10, yo1Var.z0, i);
        ye.R(parcel, 11, yo1Var.A0, i);
        boolean z = yo1Var.B0;
        ye.U(parcel, 12, 4);
        parcel.writeInt(z ? 1 : 0);
        int i5 = yo1Var.C0;
        ye.U(parcel, 13, 4);
        parcel.writeInt(i5);
        boolean z2 = yo1Var.D0;
        ye.U(parcel, 14, 4);
        parcel.writeInt(z2 ? 1 : 0);
        ye.Q(parcel, 15, yo1Var.E0);
        ye.W(parcel, iV);
    }

    public static void b(z25 z25Var, Parcel parcel, int i) {
        String str = z25Var.b;
        int iV = ye.V(parcel, 20293);
        ye.Q(parcel, 2, str);
        ye.P(parcel, 3, z25Var.f, i);
        ye.Q(parcel, 4, z25Var.z);
        long j = z25Var.A;
        ye.U(parcel, 5, 8);
        parcel.writeLong(j);
        ye.W(parcel, iV);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        long jY = 0;
        ArrayList arrayList = null;
        String strV = null;
        Bundle bundleS = null;
        String strV2 = null;
        String strV3 = null;
        String strV4 = null;
        Bundle bundleS2 = null;
        String strV5 = null;
        Bundle bundleS3 = null;
        PendingIntent pendingIntent = null;
        Account account = null;
        ab0 ab0Var = null;
        Intent intent = null;
        ArrayList arrayListX = null;
        int iX = 0;
        int iX2 = 0;
        int iX3 = 0;
        int iX4 = 0;
        int iX5 = 0;
        int iX6 = 0;
        int iX7 = 0;
        int iX8 = 0;
        int iX9 = 0;
        int iX10 = 0;
        int iX11 = 0;
        switch (this.a) {
            case 0:
                hl4 hl4Var = new hl4();
                for (int i = parcel.readInt(); i > 0; i--) {
                    hl4Var.f.add((dl4) parcel.readParcelable(hl4.class.getClassLoader()));
                }
                return hl4Var;
            case 1:
                il4 il4Var = new il4();
                il4Var.f = (fl4) parcel.readParcelable(il4.class.getClassLoader());
                il4Var.z = (el4) parcel.readParcelable(il4.class.getClassLoader());
                return il4Var;
            case 2:
                parcel.getClass();
                String string = parcel.readString();
                String string2 = parcel.readString();
                int i2 = parcel.readInt();
                String string3 = parcel.readString();
                boolean z = parcel.readInt() != 0;
                boolean z2 = parcel.readInt() != 0;
                String string4 = parcel.readString();
                int i3 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                return new ms4(string, string2, i2, string3, z, z2, string4, linkedHashMap, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 3:
                parcel.getClass();
                xw2 xw2VarValueOf = xw2.valueOf(parcel.readString());
                int i5 = parcel.readInt();
                HashMap map = new HashMap(i5);
                for (int i6 = 0; i6 != i5; i6++) {
                    map.put(parcel.readString(), parcel.readString());
                }
                boolean z3 = parcel.readInt() != 0;
                int i7 = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(i7);
                for (int i8 = 0; i8 != i7; i8++) {
                    linkedHashSet.add(parcel.readString());
                }
                boolean z4 = parcel.readInt() != 0;
                boolean z5 = parcel.readInt() != 0;
                boolean z6 = parcel.readInt() != 0;
                boolean z7 = parcel.readInt() != 0;
                boolean z8 = parcel.readInt() != 0;
                boolean z9 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    int i9 = parcel.readInt();
                    arrayList = new ArrayList(i9);
                    for (int i10 = 0; i10 != i9; i10++) {
                        arrayList.add(parcel.readSerializable());
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                xv1 xv1VarValueOf = xv1.valueOf(parcel.readString());
                boolean z10 = parcel.readInt() != 0;
                boolean z11 = parcel.readInt() != 0;
                boolean z12 = parcel.readInt() != 0;
                boolean z13 = parcel.readInt() != 0;
                int i11 = parcel.readInt();
                int i12 = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i12);
                for (int i13 = 0; i13 != i12; i13++) {
                    linkedHashMap2.put(parcel.readParcelable(rs4.class.getClassLoader()), parcel.readParcelable(rs4.class.getClassLoader()));
                }
                return new rs4(xw2VarValueOf, map, z3, linkedHashSet, z4, z5, z6, z7, z8, z9, arrayList2, arrayListCreateStringArrayList, xv1VarValueOf, z10, z11, z12, z13, i11, linkedHashMap2, parcel.readInt() != 0);
            case 4:
                parcel.getClass();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                int i14 = parcel.readInt();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(i14);
                for (int i15 = 0; i15 != i14; i15++) {
                    linkedHashSet2.add(parcel.readString());
                }
                return new fw4(string5, string6, string7, string8, linkedHashSet2, parcel.readInt(), ew4.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, tn.valueOf(parcel.readString()));
            case 5:
                parcel.getClass();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                int i16 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i16);
                for (int i17 = 0; i17 != i16; i17++) {
                    arrayList3.add(fm3.CREATOR.createFromParcel(parcel));
                }
                return new ew4(string9, string10, arrayList3, (e03) parcel.readSerializable(), parcel.readInt());
            case 6:
                int iI0 = je.i0(parcel);
                while (parcel.dataPosition() < iI0) {
                    int i18 = parcel.readInt();
                    char c = (char) i18;
                    if (c == 1) {
                        iX11 = je.X(parcel, i18);
                    } else if (c != 2) {
                        je.f0(parcel, i18);
                    } else {
                        arrayListX = je.x(parcel, i18, dm2.CREATOR);
                    }
                }
                je.B(parcel, iI0);
                return new eb4(iX11, arrayListX);
            case 7:
                int iI02 = je.i0(parcel);
                int iX12 = 0;
                while (parcel.dataPosition() < iI02) {
                    int i19 = parcel.readInt();
                    char c2 = (char) i19;
                    if (c2 == 1) {
                        iX10 = je.X(parcel, i19);
                    } else if (c2 == 2) {
                        iX12 = je.X(parcel, i19);
                    } else if (c2 != 3) {
                        je.f0(parcel, i19);
                    } else {
                        intent = (Intent) je.t(parcel, i19, Intent.CREATOR);
                    }
                }
                je.B(parcel, iI02);
                return new lz4(iX10, iX12, intent);
            case 8:
                int iI03 = je.i0(parcel);
                long jY2 = 0;
                String strV6 = null;
                String strV7 = null;
                String strV8 = null;
                String strV9 = null;
                Uri uri = null;
                String strV10 = null;
                String strV11 = null;
                ArrayList arrayListX2 = null;
                String strV12 = null;
                String strV13 = null;
                int iX13 = 0;
                while (parcel.dataPosition() < iI03) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            iX13 = je.X(parcel, i20);
                            break;
                        case 2:
                            strV6 = je.v(parcel, i20);
                            break;
                        case 3:
                            strV7 = je.v(parcel, i20);
                            break;
                        case 4:
                            strV8 = je.v(parcel, i20);
                            break;
                        case 5:
                            strV9 = je.v(parcel, i20);
                            break;
                        case 6:
                            uri = (Uri) je.t(parcel, i20, Uri.CREATOR);
                            break;
                        case 7:
                            strV10 = je.v(parcel, i20);
                            break;
                        case '\b':
                            jY2 = je.Y(parcel, i20);
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            strV11 = je.v(parcel, i20);
                            break;
                        case '\n':
                            arrayListX2 = je.x(parcel, i20, Scope.CREATOR);
                            break;
                        case 11:
                            strV12 = je.v(parcel, i20);
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            strV13 = je.v(parcel, i20);
                            break;
                        default:
                            je.f0(parcel, i20);
                            break;
                    }
                }
                je.B(parcel, iI03);
                return new GoogleSignInAccount(iX13, strV6, strV7, strV8, strV9, uri, strV10, jY2, strV11, arrayListX2, strV12, strV13);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                int iI04 = je.i0(parcel);
                ArrayList<String> arrayList4 = null;
                String strV14 = null;
                while (parcel.dataPosition() < iI04) {
                    int i21 = parcel.readInt();
                    char c3 = (char) i21;
                    if (c3 == 1) {
                        int iZ = je.Z(parcel, i21);
                        int iDataPosition = parcel.dataPosition();
                        if (iZ == 0) {
                            arrayList4 = null;
                        } else {
                            ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                            parcel.setDataPosition(iDataPosition + iZ);
                            arrayList4 = arrayListCreateStringArrayList2;
                        }
                    } else if (c3 != 2) {
                        je.f0(parcel, i21);
                    } else {
                        strV14 = je.v(parcel, i21);
                    }
                }
                je.B(parcel, iI04);
                return new i05(strV14, arrayList4);
            case 10:
                int iI05 = je.i0(parcel);
                t05 t05Var = null;
                while (parcel.dataPosition() < iI05) {
                    int i22 = parcel.readInt();
                    char c4 = (char) i22;
                    if (c4 == 1) {
                        iX9 = je.X(parcel, i22);
                    } else if (c4 == 2) {
                        ab0Var = (ab0) je.t(parcel, i22, ab0.CREATOR);
                    } else if (c4 != 3) {
                        je.f0(parcel, i22);
                    } else {
                        t05Var = (t05) je.t(parcel, i22, t05.CREATOR);
                    }
                }
                je.B(parcel, iI05);
                return new m05(iX9, ab0Var, t05Var);
            case 11:
                int iI06 = je.i0(parcel);
                int iX14 = -1;
                long jY3 = 0;
                long jY4 = 0;
                String strV15 = null;
                String strV16 = null;
                int iX15 = 0;
                int iX16 = 0;
                int iX17 = 0;
                int iX18 = 0;
                while (parcel.dataPosition() < iI06) {
                    int i23 = parcel.readInt();
                    switch ((char) i23) {
                        case 1:
                            iX15 = je.X(parcel, i23);
                            break;
                        case 2:
                            iX16 = je.X(parcel, i23);
                            break;
                        case 3:
                            iX17 = je.X(parcel, i23);
                            break;
                        case 4:
                            jY3 = je.Y(parcel, i23);
                            break;
                        case 5:
                            jY4 = je.Y(parcel, i23);
                            break;
                        case 6:
                            strV15 = je.v(parcel, i23);
                            break;
                        case 7:
                            strV16 = je.v(parcel, i23);
                            break;
                        case '\b':
                            iX18 = je.X(parcel, i23);
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            iX14 = je.X(parcel, i23);
                            break;
                        default:
                            je.f0(parcel, i23);
                            break;
                    }
                }
                je.B(parcel, iI06);
                return new dm2(iX15, iX16, iX17, jY3, jY4, strV15, strV16, iX18, iX14);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                int iI07 = je.i0(parcel);
                GoogleSignInAccount googleSignInAccount = null;
                int iX19 = 0;
                while (parcel.dataPosition() < iI07) {
                    int i24 = parcel.readInt();
                    char c5 = (char) i24;
                    if (c5 == 1) {
                        iX8 = je.X(parcel, i24);
                    } else if (c5 == 2) {
                        account = (Account) je.t(parcel, i24, Account.CREATOR);
                    } else if (c5 == 3) {
                        iX19 = je.X(parcel, i24);
                    } else if (c5 != 4) {
                        je.f0(parcel, i24);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) je.t(parcel, i24, GoogleSignInAccount.CREATOR);
                    }
                }
                je.B(parcel, iI07);
                return new r05(iX8, account, iX19, googleSignInAccount);
            case 13:
                int iI08 = je.i0(parcel);
                IBinder iBinderW = null;
                ab0 ab0Var2 = null;
                int iX20 = 0;
                boolean zV = false;
                boolean zV2 = false;
                while (parcel.dataPosition() < iI08) {
                    int i25 = parcel.readInt();
                    char c6 = (char) i25;
                    if (c6 == 1) {
                        iX20 = je.X(parcel, i25);
                    } else if (c6 == 2) {
                        iBinderW = je.W(parcel, i25);
                    } else if (c6 == 3) {
                        ab0Var2 = (ab0) je.t(parcel, i25, ab0.CREATOR);
                    } else if (c6 == 4) {
                        zV = je.V(parcel, i25);
                    } else if (c6 != 5) {
                        je.f0(parcel, i25);
                    } else {
                        zV2 = je.V(parcel, i25);
                    }
                }
                je.B(parcel, iI08);
                return new t05(iX20, iBinderW, ab0Var2, zV, zV2);
            case 14:
                int iI09 = je.i0(parcel);
                String strV17 = null;
                int iX21 = 0;
                while (parcel.dataPosition() < iI09) {
                    int i26 = parcel.readInt();
                    char c7 = (char) i26;
                    if (c7 == 1) {
                        iX7 = je.X(parcel, i26);
                    } else if (c7 == 2) {
                        iX21 = je.X(parcel, i26);
                    } else if (c7 == 3) {
                        pendingIntent = (PendingIntent) je.t(parcel, i26, PendingIntent.CREATOR);
                    } else if (c7 != 4) {
                        je.f0(parcel, i26);
                    } else {
                        strV17 = je.v(parcel, i26);
                    }
                }
                je.B(parcel, iI09);
                return new ab0(iX7, iX21, pendingIntent, strV17);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                int iI010 = je.i0(parcel);
                long jY5 = 0;
                long jY6 = 0;
                int iX22 = 0;
                while (parcel.dataPosition() < iI010) {
                    int i27 = parcel.readInt();
                    char c8 = (char) i27;
                    if (c8 == 1) {
                        jY5 = je.Y(parcel, i27);
                    } else if (c8 == 2) {
                        iX22 = je.X(parcel, i27);
                    } else if (c8 != 3) {
                        je.f0(parcel, i27);
                    } else {
                        jY6 = je.Y(parcel, i27);
                    }
                }
                je.B(parcel, iI010);
                return new k15(jY5, jY6, iX22);
            case 16:
                int iI011 = je.i0(parcel);
                int iX23 = 0;
                int iX24 = 0;
                int iX25 = 0;
                boolean zV3 = false;
                boolean zV4 = false;
                while (parcel.dataPosition() < iI011) {
                    int i28 = parcel.readInt();
                    char c9 = (char) i28;
                    if (c9 == 1) {
                        iX23 = je.X(parcel, i28);
                    } else if (c9 == 2) {
                        zV3 = je.V(parcel, i28);
                    } else if (c9 == 3) {
                        zV4 = je.V(parcel, i28);
                    } else if (c9 == 4) {
                        iX24 = je.X(parcel, i28);
                    } else if (c9 != 5) {
                        je.f0(parcel, i28);
                    } else {
                        iX25 = je.X(parcel, i28);
                    }
                }
                je.B(parcel, iI011);
                return new xl3(iX23, iX24, iX25, zV3, zV4);
            case 17:
                int iI012 = je.i0(parcel);
                long jY7 = 0;
                long jY8 = 0;
                long jY9 = 0;
                String strV18 = null;
                String strV19 = null;
                kf5 kf5Var = null;
                String strV20 = null;
                z25 z25Var = null;
                z25 z25Var2 = null;
                z25 z25Var3 = null;
                boolean zV5 = false;
                while (parcel.dataPosition() < iI012) {
                    int i29 = parcel.readInt();
                    switch ((char) i29) {
                        case 2:
                            strV18 = je.v(parcel, i29);
                            break;
                        case 3:
                            strV19 = je.v(parcel, i29);
                            break;
                        case 4:
                            kf5Var = (kf5) je.t(parcel, i29, kf5.CREATOR);
                            break;
                        case 5:
                            jY7 = je.Y(parcel, i29);
                            break;
                        case 6:
                            zV5 = je.V(parcel, i29);
                            break;
                        case 7:
                            strV20 = je.v(parcel, i29);
                            break;
                        case '\b':
                            z25Var = (z25) je.t(parcel, i29, z25.CREATOR);
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            jY8 = je.Y(parcel, i29);
                            break;
                        case '\n':
                            z25Var2 = (z25) je.t(parcel, i29, z25.CREATOR);
                            break;
                        case 11:
                            jY9 = je.Y(parcel, i29);
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            z25Var3 = (z25) je.t(parcel, i29, z25.CREATOR);
                            break;
                        default:
                            je.f0(parcel, i29);
                            break;
                    }
                }
                je.B(parcel, iI012);
                return new q15(strV18, strV19, kf5Var, jY7, zV5, strV20, z25Var, jY8, z25Var2, jY9, z25Var3);
            case 18:
                int iI013 = je.i0(parcel);
                while (parcel.dataPosition() < iI013) {
                    int i30 = parcel.readInt();
                    if (((char) i30) != 1) {
                        je.f0(parcel, i30);
                    } else {
                        bundleS3 = je.s(parcel, i30);
                    }
                }
                je.B(parcel, iI013);
                return new c25(bundleS3);
            case 19:
                int iI014 = je.i0(parcel);
                long jY10 = -1;
                while (parcel.dataPosition() < iI014) {
                    int i31 = parcel.readInt();
                    char c10 = (char) i31;
                    if (c10 == 1) {
                        strV5 = je.v(parcel, i31);
                    } else if (c10 == 2) {
                        iX6 = je.X(parcel, i31);
                    } else if (c10 != 3) {
                        je.f0(parcel, i31);
                    } else {
                        jY10 = je.Y(parcel, i31);
                    }
                }
                je.B(parcel, iI014);
                return new ic1(strV5, iX6, jY10);
            case 20:
                int iI015 = je.i0(parcel);
                while (parcel.dataPosition() < iI015) {
                    int i32 = parcel.readInt();
                    if (((char) i32) != 2) {
                        je.f0(parcel, i32);
                    } else {
                        bundleS2 = je.s(parcel, i32);
                    }
                }
                je.B(parcel, iI015);
                return new y25(bundleS2);
            case 21:
                int iI016 = je.i0(parcel);
                long jY11 = 0;
                String strV21 = null;
                y25 y25Var = null;
                String strV22 = null;
                while (parcel.dataPosition() < iI016) {
                    int i33 = parcel.readInt();
                    char c11 = (char) i33;
                    if (c11 == 2) {
                        strV21 = je.v(parcel, i33);
                    } else if (c11 == 3) {
                        y25Var = (y25) je.t(parcel, i33, y25.CREATOR);
                    } else if (c11 == 4) {
                        strV22 = je.v(parcel, i33);
                    } else if (c11 != 5) {
                        je.f0(parcel, i33);
                    } else {
                        jY11 = je.Y(parcel, i33);
                    }
                }
                je.B(parcel, iI016);
                return new z25(strV21, y25Var, strV22, jY11);
            case 22:
                int iI017 = je.i0(parcel);
                while (parcel.dataPosition() < iI017) {
                    int i34 = parcel.readInt();
                    char c12 = (char) i34;
                    if (c12 == 1) {
                        iX5 = je.X(parcel, i34);
                    } else if (c12 != 2) {
                        je.f0(parcel, i34);
                    } else {
                        strV4 = je.v(parcel, i34);
                    }
                }
                je.B(parcel, iI017);
                return new Scope(iX5, strV4);
            case 23:
                int iI018 = je.i0(parcel);
                long jY12 = 0;
                long jY13 = 0;
                Bundle bundleS4 = null;
                String strV23 = null;
                boolean zV6 = false;
                while (parcel.dataPosition() < iI018) {
                    int i35 = parcel.readInt();
                    char c13 = (char) i35;
                    if (c13 == 1) {
                        jY12 = je.Y(parcel, i35);
                    } else if (c13 == 2) {
                        jY13 = je.Y(parcel, i35);
                    } else if (c13 == 3) {
                        zV6 = je.V(parcel, i35);
                    } else if (c13 == 7) {
                        bundleS4 = je.s(parcel, i35);
                    } else if (c13 != '\b') {
                        je.f0(parcel, i35);
                    } else {
                        strV23 = je.v(parcel, i35);
                    }
                }
                je.B(parcel, iI018);
                return new j45(jY12, jY13, zV6, bundleS4, strV23);
            case 24:
                int iI019 = je.i0(parcel);
                Intent intent2 = null;
                while (parcel.dataPosition() < iI019) {
                    int i36 = parcel.readInt();
                    char c14 = (char) i36;
                    if (c14 == 1) {
                        iX4 = je.X(parcel, i36);
                    } else if (c14 == 2) {
                        strV3 = je.v(parcel, i36);
                    } else if (c14 != 3) {
                        je.f0(parcel, i36);
                    } else {
                        intent2 = (Intent) je.t(parcel, i36, Intent.CREATOR);
                    }
                }
                je.B(parcel, iI019);
                return new k45(iX4, strV3, intent2);
            case 25:
                int iI020 = je.i0(parcel);
                PendingIntent pendingIntent2 = null;
                ab0 ab0Var3 = null;
                while (parcel.dataPosition() < iI020) {
                    int i37 = parcel.readInt();
                    char c15 = (char) i37;
                    if (c15 == 1) {
                        iX3 = je.X(parcel, i37);
                    } else if (c15 == 2) {
                        strV2 = je.v(parcel, i37);
                    } else if (c15 == 3) {
                        pendingIntent2 = (PendingIntent) je.t(parcel, i37, PendingIntent.CREATOR);
                    } else if (c15 != 4) {
                        je.f0(parcel, i37);
                    } else {
                        ab0Var3 = (ab0) je.t(parcel, i37, ab0.CREATOR);
                    }
                }
                je.B(parcel, iI020);
                return new Status(iX3, strV2, pendingIntent2, ab0Var3);
            case 26:
                int iI021 = je.i0(parcel);
                ic1[] ic1VarArr = null;
                eb0 eb0Var = null;
                while (parcel.dataPosition() < iI021) {
                    int i38 = parcel.readInt();
                    char c16 = (char) i38;
                    if (c16 == 1) {
                        bundleS = je.s(parcel, i38);
                    } else if (c16 == 2) {
                        ic1VarArr = (ic1[]) je.w(parcel, i38, ic1.CREATOR);
                    } else if (c16 == 3) {
                        iX2 = je.X(parcel, i38);
                    } else if (c16 != 4) {
                        je.f0(parcel, i38);
                    } else {
                        eb0Var = (eb0) je.t(parcel, i38, eb0.CREATOR);
                    }
                }
                je.B(parcel, iI021);
                e95 e95Var = new e95();
                e95Var.b = bundleS;
                e95Var.f = ic1VarArr;
                e95Var.z = iX2;
                e95Var.A = eb0Var;
                return e95Var;
            case 27:
                int iI022 = je.i0(parcel);
                xl3 xl3Var = null;
                int[] iArr = null;
                int[] iArr2 = null;
                boolean zV7 = false;
                boolean zV8 = false;
                int iX26 = 0;
                while (parcel.dataPosition() < iI022) {
                    int i39 = parcel.readInt();
                    switch ((char) i39) {
                        case 1:
                            xl3Var = (xl3) je.t(parcel, i39, xl3.CREATOR);
                            break;
                        case 2:
                            zV7 = je.V(parcel, i39);
                            break;
                        case 3:
                            zV8 = je.V(parcel, i39);
                            break;
                        case 4:
                            int iZ2 = je.Z(parcel, i39);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iZ2 == 0) {
                                iArr = null;
                            } else {
                                int[] iArrCreateIntArray = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition2 + iZ2);
                                iArr = iArrCreateIntArray;
                            }
                            break;
                        case 5:
                            iX26 = je.X(parcel, i39);
                            break;
                        case 6:
                            int iZ3 = je.Z(parcel, i39);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iZ3 == 0) {
                                iArr2 = null;
                            } else {
                                int[] iArrCreateIntArray2 = parcel.createIntArray();
                                parcel.setDataPosition(iDataPosition3 + iZ3);
                                iArr2 = iArrCreateIntArray2;
                            }
                            break;
                        default:
                            je.f0(parcel, i39);
                            break;
                    }
                }
                je.B(parcel, iI022);
                return new eb0(xl3Var, zV7, zV8, iArr, iX26, iArr2);
            case 28:
                int iI023 = je.i0(parcel);
                Bundle bundle = new Bundle();
                Scope[] scopeArr = yo1.F0;
                ic1[] ic1VarArr2 = yo1.G0;
                ic1[] ic1VarArr3 = ic1VarArr2;
                String strV24 = null;
                IBinder iBinderW2 = null;
                Account account2 = null;
                String strV25 = null;
                int iX27 = 0;
                int iX28 = 0;
                int iX29 = 0;
                boolean zV9 = false;
                int iX30 = 0;
                boolean zV10 = false;
                while (parcel.dataPosition() < iI023) {
                    int i40 = parcel.readInt();
                    switch ((char) i40) {
                        case 1:
                            iX27 = je.X(parcel, i40);
                            break;
                        case 2:
                            iX28 = je.X(parcel, i40);
                            break;
                        case 3:
                            iX29 = je.X(parcel, i40);
                            break;
                        case 4:
                            strV24 = je.v(parcel, i40);
                            break;
                        case 5:
                            iBinderW2 = je.W(parcel, i40);
                            break;
                        case 6:
                            scopeArr = (Scope[]) je.w(parcel, i40, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = je.s(parcel, i40);
                            break;
                        case '\b':
                            account2 = (Account) je.t(parcel, i40, Account.CREATOR);
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        default:
                            je.f0(parcel, i40);
                            break;
                        case '\n':
                            ic1VarArr2 = (ic1[]) je.w(parcel, i40, ic1.CREATOR);
                            break;
                        case 11:
                            ic1VarArr3 = (ic1[]) je.w(parcel, i40, ic1.CREATOR);
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            zV9 = je.V(parcel, i40);
                            break;
                        case '\r':
                            iX30 = je.X(parcel, i40);
                            break;
                        case 14:
                            zV10 = je.V(parcel, i40);
                            break;
                        case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                            strV25 = je.v(parcel, i40);
                            break;
                    }
                }
                je.B(parcel, iI023);
                return new yo1(iX27, iX28, iX29, strV24, iBinderW2, scopeArr, bundle, account2, ic1VarArr2, ic1VarArr3, zV9, iX30, zV10, strV25);
            default:
                int iI024 = je.i0(parcel);
                while (parcel.dataPosition() < iI024) {
                    int i41 = parcel.readInt();
                    char c17 = (char) i41;
                    if (c17 == 1) {
                        strV = je.v(parcel, i41);
                    } else if (c17 == 2) {
                        jY = je.Y(parcel, i41);
                    } else if (c17 != 3) {
                        je.f0(parcel, i41);
                    } else {
                        iX = je.X(parcel, i41);
                    }
                }
                je.B(parcel, iI024);
                return new ee5(iX, jY, strV);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new hl4[i];
            case 1:
                return new il4[i];
            case 2:
                return new ms4[i];
            case 3:
                return new rs4[i];
            case 4:
                return new fw4[i];
            case 5:
                return new ew4[i];
            case 6:
                return new eb4[i];
            case 7:
                return new lz4[i];
            case 8:
                return new GoogleSignInAccount[i];
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new i05[i];
            case 10:
                return new m05[i];
            case 11:
                return new dm2[i];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new r05[i];
            case 13:
                return new t05[i];
            case 14:
                return new ab0[i];
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new k15[i];
            case 16:
                return new xl3[i];
            case 17:
                return new q15[i];
            case 18:
                return new c25[i];
            case 19:
                return new ic1[i];
            case 20:
                return new y25[i];
            case 21:
                return new z25[i];
            case 22:
                return new Scope[i];
            case 23:
                return new j45[i];
            case 24:
                return new k45[i];
            case 25:
                return new Status[i];
            case 26:
                return new e95[i];
            case 27:
                return new eb0[i];
            case 28:
                return new yo1[i];
            default:
                return new ee5[i];
        }
    }
}
