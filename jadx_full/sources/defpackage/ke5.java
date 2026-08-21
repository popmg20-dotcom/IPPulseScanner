package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ke5 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ ke5(int i) {
        this.a = i;
    }

    public static void a(kf5 kf5Var, Parcel parcel) {
        int i = kf5Var.b;
        int iV = ye.V(parcel, 20293);
        ye.U(parcel, 1, 4);
        parcel.writeInt(i);
        ye.Q(parcel, 2, kf5Var.f);
        long j = kf5Var.z;
        ye.U(parcel, 3, 8);
        parcel.writeLong(j);
        Long l = kf5Var.A;
        if (l != null) {
            ye.U(parcel, 4, 8);
            parcel.writeLong(l.longValue());
        }
        ye.Q(parcel, 6, kf5Var.X);
        ye.Q(parcel, 7, kf5Var.Y);
        Double d = kf5Var.Z;
        if (d != null) {
            ye.U(parcel, 8, 8);
            parcel.writeDouble(d.doubleValue());
        }
        ye.W(parcel, iV);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayListX = null;
        switch (this.a) {
            case 0:
                int iI0 = je.i0(parcel);
                long jY = 0;
                long jY2 = 0;
                int iX = 0;
                byte[] bArr = null;
                String strV = null;
                Bundle bundleS = null;
                String strV2 = null;
                while (parcel.dataPosition() < iI0) {
                    int i = parcel.readInt();
                    switch ((char) i) {
                        case 1:
                            jY = je.Y(parcel, i);
                            break;
                        case 2:
                            int iZ = je.Z(parcel, i);
                            int iDataPosition = parcel.dataPosition();
                            if (iZ == 0) {
                                bArr = null;
                            } else {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iZ);
                                bArr = bArrCreateByteArray;
                            }
                            break;
                        case 3:
                            strV = je.v(parcel, i);
                            break;
                        case 4:
                            bundleS = je.s(parcel, i);
                            break;
                        case 5:
                            iX = je.X(parcel, i);
                            break;
                        case 6:
                            jY2 = je.Y(parcel, i);
                            break;
                        case 7:
                            strV2 = je.v(parcel, i);
                            break;
                        default:
                            je.f0(parcel, i);
                            break;
                    }
                }
                je.B(parcel, iI0);
                return new ie5(jY, bArr, strV, bundleS, iX, jY2, strV2);
            case 1:
                int iI02 = je.i0(parcel);
                while (true) {
                    ArrayList arrayList = null;
                    while (parcel.dataPosition() < iI02) {
                        int i2 = parcel.readInt();
                        if (((char) i2) != 1) {
                            je.f0(parcel, i2);
                        } else {
                            int iZ2 = je.Z(parcel, i2);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iZ2 == 0) {
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int i3 = parcel.readInt();
                            for (int i4 = 0; i4 < i3; i4++) {
                                arrayList2.add(Integer.valueOf(parcel.readInt()));
                            }
                            parcel.setDataPosition(iDataPosition2 + iZ2);
                            arrayList = arrayList2;
                        }
                        break;
                    }
                    je.B(parcel, iI02);
                    return new le5(arrayList);
                }
                break;
            case 2:
                int iI03 = je.i0(parcel);
                while (parcel.dataPosition() < iI03) {
                    int i5 = parcel.readInt();
                    if (((char) i5) != 1) {
                        je.f0(parcel, i5);
                    } else {
                        arrayListX = je.x(parcel, i5, ie5.CREATOR);
                    }
                }
                je.B(parcel, iI03);
                return new ne5(arrayListX);
            case 3:
                int iI04 = je.i0(parcel);
                long jY3 = 0;
                int iX2 = 0;
                String strV3 = null;
                Long lValueOf = null;
                Float fValueOf = null;
                String strV4 = null;
                String strV5 = null;
                Double dValueOf = null;
                while (parcel.dataPosition() < iI04) {
                    int i6 = parcel.readInt();
                    switch ((char) i6) {
                        case 1:
                            iX2 = je.X(parcel, i6);
                            break;
                        case 2:
                            strV3 = je.v(parcel, i6);
                            break;
                        case 3:
                            jY3 = je.Y(parcel, i6);
                            break;
                        case 4:
                            int iZ3 = je.Z(parcel, i6);
                            if (iZ3 == 0) {
                                lValueOf = null;
                            } else {
                                je.l0(parcel, iZ3, 8);
                                lValueOf = Long.valueOf(parcel.readLong());
                            }
                            break;
                        case 5:
                            int iZ4 = je.Z(parcel, i6);
                            if (iZ4 == 0) {
                                fValueOf = null;
                            } else {
                                je.l0(parcel, iZ4, 4);
                                fValueOf = Float.valueOf(parcel.readFloat());
                            }
                            break;
                        case 6:
                            strV4 = je.v(parcel, i6);
                            break;
                        case 7:
                            strV5 = je.v(parcel, i6);
                            break;
                        case '\b':
                            int iZ5 = je.Z(parcel, i6);
                            if (iZ5 == 0) {
                                dValueOf = null;
                            } else {
                                je.l0(parcel, iZ5, 8);
                                dValueOf = Double.valueOf(parcel.readDouble());
                            }
                            break;
                        default:
                            je.f0(parcel, i6);
                            break;
                    }
                }
                je.B(parcel, iI04);
                return new kf5(iX2, strV3, jY3, lValueOf, fValueOf, strV4, strV5, dValueOf);
            case 4:
                int iI05 = je.i0(parcel);
                long jY4 = 0;
                long jY5 = 0;
                long jY6 = 0;
                long jY7 = 0;
                long jY8 = 0;
                long jY9 = 0;
                long jY10 = 0;
                boolean zV = true;
                boolean zV2 = true;
                boolean zV3 = false;
                int iX3 = 0;
                boolean zV4 = false;
                boolean zV5 = false;
                int iX4 = 0;
                int iX5 = 0;
                String strV6 = null;
                String strV7 = null;
                String strV8 = null;
                String strV9 = null;
                String strV10 = null;
                String strV11 = null;
                Boolean boolValueOf = null;
                ArrayList<String> arrayList3 = null;
                String strV12 = null;
                String strV13 = null;
                String strV14 = "";
                String strV15 = strV14;
                String strV16 = strV15;
                String strV17 = strV16;
                int iX6 = 100;
                long jY11 = -2147483648L;
                while (parcel.dataPosition() < iI05) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 2:
                            strV6 = je.v(parcel, i7);
                            break;
                        case 3:
                            strV7 = je.v(parcel, i7);
                            break;
                        case 4:
                            strV8 = je.v(parcel, i7);
                            break;
                        case 5:
                            strV9 = je.v(parcel, i7);
                            break;
                        case 6:
                            jY4 = je.Y(parcel, i7);
                            break;
                        case 7:
                            jY5 = je.Y(parcel, i7);
                            break;
                        case '\b':
                            strV10 = je.v(parcel, i7);
                            break;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            zV = je.V(parcel, i7);
                            break;
                        case '\n':
                            zV3 = je.V(parcel, i7);
                            break;
                        case 11:
                            jY11 = je.Y(parcel, i7);
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            strV11 = je.v(parcel, i7);
                            break;
                        case '\r':
                        case 17:
                        case 19:
                        case 20:
                        case 24:
                        case '!':
                        default:
                            je.f0(parcel, i7);
                            break;
                        case 14:
                            jY6 = je.Y(parcel, i7);
                            break;
                        case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                            iX3 = je.X(parcel, i7);
                            break;
                        case 16:
                            zV2 = je.V(parcel, i7);
                            break;
                        case 18:
                            zV4 = je.V(parcel, i7);
                            break;
                        case 21:
                            int iZ6 = je.Z(parcel, i7);
                            if (iZ6 == 0) {
                                boolValueOf = null;
                            } else {
                                je.l0(parcel, iZ6, 4);
                                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                            }
                            break;
                        case 22:
                            jY7 = je.Y(parcel, i7);
                            break;
                        case 23:
                            int iZ7 = je.Z(parcel, i7);
                            int iDataPosition3 = parcel.dataPosition();
                            if (iZ7 == 0) {
                                arrayList3 = null;
                            } else {
                                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                                parcel.setDataPosition(iDataPosition3 + iZ7);
                                arrayList3 = arrayListCreateStringArrayList;
                            }
                            break;
                        case 25:
                            strV14 = je.v(parcel, i7);
                            break;
                        case 26:
                            strV15 = je.v(parcel, i7);
                            break;
                        case 27:
                            strV12 = je.v(parcel, i7);
                            break;
                        case 28:
                            zV5 = je.V(parcel, i7);
                            break;
                        case 29:
                            jY8 = je.Y(parcel, i7);
                            break;
                        case 30:
                            iX6 = je.X(parcel, i7);
                            break;
                        case 31:
                            strV16 = je.v(parcel, i7);
                            break;
                        case ' ':
                            iX4 = je.X(parcel, i7);
                            break;
                        case '\"':
                            jY9 = je.Y(parcel, i7);
                            break;
                        case '#':
                            strV13 = je.v(parcel, i7);
                            break;
                        case '$':
                            strV17 = je.v(parcel, i7);
                            break;
                        case '%':
                            jY10 = je.Y(parcel, i7);
                            break;
                        case '&':
                            iX5 = je.X(parcel, i7);
                            break;
                    }
                }
                je.B(parcel, iI05);
                return new tg5(strV6, strV7, strV8, strV9, jY4, jY5, strV10, zV, zV3, jY11, strV11, jY6, iX3, zV2, zV4, boolValueOf, jY7, arrayList3, strV14, strV15, strV12, zV5, jY8, iX6, strV16, iX4, jY9, strV13, strV17, jY10, iX5);
            default:
                int iI06 = je.i0(parcel);
                long jY12 = -1;
                boolean zV6 = false;
                int iX7 = 0;
                int iX8 = 0;
                String strV18 = null;
                while (parcel.dataPosition() < iI06) {
                    int i8 = parcel.readInt();
                    char c = (char) i8;
                    if (c == 1) {
                        zV6 = je.V(parcel, i8);
                    } else if (c == 2) {
                        strV18 = je.v(parcel, i8);
                    } else if (c == 3) {
                        iX7 = je.X(parcel, i8);
                    } else if (c == 4) {
                        iX8 = je.X(parcel, i8);
                    } else if (c != 5) {
                        je.f0(parcel, i8);
                    } else {
                        jY12 = je.Y(parcel, i8);
                    }
                }
                je.B(parcel, iI06);
                return new ug5(zV6, strV18, iX7, iX8, jY12);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new ie5[i];
            case 1:
                return new le5[i];
            case 2:
                return new ne5[i];
            case 3:
                return new kf5[i];
            case 4:
                return new tg5[i];
            default:
                return new ug5[i];
        }
    }
}
