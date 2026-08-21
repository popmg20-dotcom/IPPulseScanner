package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ym3 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ ym3(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayList;
        boolean z;
        boolean z2;
        switch (this.a) {
            case 0:
                parcel.getClass();
                return new zm3((tn3) parcel.readParcelable(zm3.class.getClassLoader()), parcel.readString());
            case 1:
                parcel.getClass();
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(parcel.readParcelable(an3.class.getClassLoader()));
                }
                return new an3(parcel.readString(), arrayList2);
            case 2:
                parcel.getClass();
                return new cn3(parcel.readInt(), parcel.readString());
            case 3:
                parcel.getClass();
                return new dn3(parcel.readInt(), parcel.readString());
            case 4:
                parcel.getClass();
                return new fn3(en3.valueOf(parcel.readString()), parcel.readString());
            case 5:
                parcel.getClass();
                return new gn3(parcel.readString(), parcel.readString());
            case 6:
                parcel.getClass();
                return new in3(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
            case 7:
                parcel.getClass();
                String string = parcel.readString();
                String string2 = parcel.readString();
                int i3 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList3.add(parcel.readParcelable(jn3.class.getClassLoader()));
                }
                return new jn3(string, string2, arrayList3);
            case 8:
                parcel.getClass();
                return new kn3(parcel.readString(), parcel.readString());
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                parcel.getClass();
                return new ln3(parcel.readInt(), parcel.readInt(), parcel.readString());
            case 10:
                parcel.getClass();
                return new mn3((InetAddress) parcel.readSerializable(), parcel.readString());
            case 11:
                parcel.getClass();
                return new nn3(parcel.readString(), parcel.readString());
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                parcel.getClass();
                return new pn3(on3.valueOf(parcel.readString()), parcel.readString());
            case 13:
                parcel.getClass();
                return new rn3(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
            case 14:
                parcel.getClass();
                return new tp3(parcel.readInt(), parcel.readInt());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new qr3(parcel);
            case 16:
                parcel.getClass();
                return new mu3(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), lu3.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 17:
                parcel.getClass();
                return new sy3(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 18:
                parcel.getClass();
                return new zy3(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 19:
                parcel.getClass();
                return new az3(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 20:
                w14 w14Var = new w14();
                w14Var.b = parcel.readInt();
                w14Var.f = parcel.readInt();
                w14Var.A = parcel.readInt() == 1;
                int i5 = parcel.readInt();
                if (i5 > 0) {
                    int[] iArr = new int[i5];
                    w14Var.z = iArr;
                    parcel.readIntArray(iArr);
                }
                return w14Var;
            case 21:
                x14 x14Var = new x14();
                x14Var.b = parcel.readInt();
                x14Var.f = parcel.readInt();
                int i6 = parcel.readInt();
                x14Var.z = i6;
                if (i6 > 0) {
                    int[] iArr2 = new int[i6];
                    x14Var.A = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i7 = parcel.readInt();
                x14Var.X = i7;
                if (i7 > 0) {
                    int[] iArr3 = new int[i7];
                    x14Var.Y = iArr3;
                    parcel.readIntArray(iArr3);
                }
                x14Var.y0 = parcel.readInt() == 1;
                x14Var.z0 = parcel.readInt() == 1;
                x14Var.A0 = parcel.readInt() == 1;
                x14Var.Z = parcel.readArrayList(w14.class.getClassLoader());
                return x14Var;
            case 22:
                parcel.getClass();
                return new n54(m54.CREATOR.createFromParcel(parcel), parcel.readInt());
            case 23:
                parcel.getClass();
                String string3 = parcel.readString();
                int i8 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(i8);
                for (int i9 = 0; i9 != i8; i9++) {
                    arrayList4.add(m54.CREATOR.createFromParcel(parcel));
                }
                return new m54(string3, arrayList4);
            case 24:
                parcel.getClass();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                int i10 = parcel.readInt();
                String string6 = parcel.readString();
                boolean z3 = parcel.readInt() != 0;
                String string7 = parcel.readString();
                int i11 = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                return new xh4(string4, string5, i10, string6, z3, string7, linkedHashMap, parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 25:
                parcel.getClass();
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                int i13 = parcel.readInt();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i14 = parcel.readInt();
                    arrayList = new ArrayList(i14);
                    for (int i15 = 0; i15 != i14; i15++) {
                        arrayList.add(i23.CREATOR.createFromParcel(parcel));
                    }
                }
                Integer numValueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
                if (parcel.readInt() != 0) {
                    z = true;
                    z2 = true;
                } else {
                    z = false;
                    z2 = true;
                }
                ArrayList arrayList5 = arrayList;
                String string13 = parcel.readString();
                boolean z4 = z2;
                String string14 = parcel.readString();
                if (parcel.readInt() == 0) {
                    z4 = false;
                }
                return new ai4(string8, string9, i13, string10, string11, string12, arrayList5, numValueOf, z, string13, string14, z4, tn.valueOf(parcel.readString()), parcel.readString());
            case 26:
                return new di4(parcel);
            case 27:
                jl4 jl4Var = new jl4();
                jl4Var.z = parcel.readInt();
                jl4Var.Y = parcel.readInt();
                jl4Var.f = parcel.readInt() > 0;
                for (int i16 = parcel.readInt(); i16 > 0; i16--) {
                    jl4Var.b.add((dl4) parcel.readParcelable(jl4.class.getClassLoader()));
                }
                return jl4Var;
            case 28:
                el4 el4Var = new el4();
                el4Var.f = parcel.readInt();
                el4Var.A = parcel.readInt();
                el4Var.z = parcel.readInt();
                el4Var.X = parcel.readInt();
                el4Var.Z = parcel.readString();
                return el4Var;
            default:
                fl4 fl4Var = new fl4();
                fl4Var.f = parcel.readInt();
                fl4Var.A = parcel.readInt();
                fl4Var.z = parcel.readInt();
                fl4Var.X = parcel.readInt();
                fl4Var.Z = parcel.readString();
                return fl4Var;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new zm3[i];
            case 1:
                return new an3[i];
            case 2:
                return new cn3[i];
            case 3:
                return new dn3[i];
            case 4:
                return new fn3[i];
            case 5:
                return new gn3[i];
            case 6:
                return new in3[i];
            case 7:
                return new jn3[i];
            case 8:
                return new kn3[i];
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new ln3[i];
            case 10:
                return new mn3[i];
            case 11:
                return new nn3[i];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new pn3[i];
            case 13:
                return new rn3[i];
            case 14:
                return new tp3[i];
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new qr3[i];
            case 16:
                return new mu3[i];
            case 17:
                return new sy3[i];
            case 18:
                return new zy3[i];
            case 19:
                return new az3[i];
            case 20:
                return new w14[i];
            case 21:
                return new x14[i];
            case 22:
                return new n54[i];
            case 23:
                return new m54[i];
            case 24:
                return new xh4[i];
            case 25:
                return new ai4[i];
            case 26:
                return new di4[i];
            case 27:
                return new jl4[i];
            case 28:
                return new el4[i];
            default:
                return new fl4[i];
        }
    }
}
