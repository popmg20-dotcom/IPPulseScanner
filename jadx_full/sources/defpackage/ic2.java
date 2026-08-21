package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ic2 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    public /* synthetic */ ic2(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                return new jc2(parcel);
            case 1:
                parcel.getClass();
                return new xf2(parcel.readString(), parcel.readInt() != 0, parcel.readLong());
            case 2:
                mi2 mi2Var = new mi2(parcel);
                mi2Var.b = ((Integer) parcel.readValue(mi2.class.getClassLoader())).intValue();
                return mi2Var;
            case 3:
                String string = parcel.readString();
                string.getClass();
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(i);
                for (int i2 = 0; i2 < i; i2++) {
                    String string2 = parcel.readString();
                    string2.getClass();
                    String string3 = parcel.readString();
                    string3.getClass();
                    linkedHashMap.put(string2, string3);
                }
                return new tj2(string, linkedHashMap);
            case 4:
                return new an2(parcel);
            case 5:
                np2 np2Var = new np2();
                np2Var.b = parcel.readInt();
                np2Var.f = (j03) parcel.readParcelable(np2.class.getClassLoader());
                return np2Var;
            case 6:
                vq2 vq2Var = new vq2(parcel);
                vq2Var.b = parcel.readInt();
                return vq2Var;
            case 7:
                parcel.getClass();
                return new h03(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : g03.valueOf(parcel.readString()));
            case 8:
                return new ParcelImpl(parcel);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                parcel.getClass();
                return new i23(parcel.readInt(), parcel.readInt());
            case 10:
                return new u23(parcel);
            case 11:
                return new k33(parcel);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                parcel.getClass();
                String string4 = parcel.readString();
                int i3 = parcel.readInt();
                xf2 xf2VarCreateFromParcel = parcel.readInt() == 0 ? null : xf2.CREATOR.createFromParcel(parcel);
                boolean z = parcel.readInt() != 0;
                InetSocketAddress inetSocketAddress = (InetSocketAddress) parcel.readSerializable();
                InetSocketAddress inetSocketAddress2 = (InetSocketAddress) parcel.readSerializable();
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                int i4 = parcel.readInt();
                ea3 ea3Var = (ea3) parcel.readParcelable(t53.class.getClassLoader());
                int i5 = parcel.readInt();
                ArrayList arrayList = new ArrayList(i5);
                for (int i6 = 0; i6 != i5; i6++) {
                    arrayList.add(parcel.readParcelable(t53.class.getClassLoader()));
                }
                int i7 = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(i7);
                for (int i8 = 0; i8 != i7; i8++) {
                    linkedHashSet.add(parcel.readSerializable());
                }
                ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                int i9 = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i9);
                for (int i10 = 0; i10 != i9; i10++) {
                    linkedHashMap2.put(parcel.readParcelable(t53.class.getClassLoader()), parcel.readParcelable(t53.class.getClassLoader()));
                }
                int i11 = parcel.readInt();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(i11);
                for (int i12 = 0; i12 != i11; i12++) {
                    linkedHashMap3.put(parcel.readString(), parcel.readParcelable(t53.class.getClassLoader()));
                }
                int i13 = parcel.readInt();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap(i13);
                int i14 = 0;
                while (i14 != i13) {
                    linkedHashMap4.put(parcel.readString(), parcel.readParcelable(t53.class.getClassLoader()));
                    i14++;
                    i13 = i13;
                }
                ka3 ka3VarCreateFromParcel = ka3.CREATOR.createFromParcel(parcel);
                int i15 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i15);
                int i16 = 0;
                while (i16 != i15) {
                    arrayList2.add(parcel.readParcelable(t53.class.getClassLoader()));
                    i16++;
                    i15 = i15;
                }
                tm3 tm3VarCreateFromParcel = parcel.readInt() == 0 ? null : tm3.CREATOR.createFromParcel(parcel);
                int i17 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(i17);
                int i18 = 0;
                while (i18 != i17) {
                    arrayList3.add(h03.CREATOR.createFromParcel(parcel));
                    i18++;
                    i17 = i17;
                }
                return new t53(string4, i3, xf2VarCreateFromParcel, z, inetSocketAddress, inetSocketAddress2, arrayListCreateStringArrayList, string5, string6, i4, ea3Var, arrayList, linkedHashSet, arrayListCreateStringArrayList2, linkedHashMap2, linkedHashMap3, linkedHashMap4, ka3VarCreateFromParcel, arrayList2, tm3VarCreateFromParcel, arrayList3, parcel.readLong());
            case 13:
                parcel.getClass();
                String string7 = parcel.readString();
                int i19 = parcel.readInt();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(i19);
                for (int i20 = 0; i20 != i19; i20++) {
                    linkedHashSet2.add(parcel.readString());
                }
                int i21 = parcel.readInt();
                LinkedHashSet linkedHashSet3 = new LinkedHashSet(i21);
                for (int i22 = 0; i22 != i21; i22++) {
                    linkedHashSet3.add(parcel.readString());
                }
                String string8 = parcel.readString();
                int i23 = parcel.readInt();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap(i23);
                for (int i24 = 0; i24 != i23; i24++) {
                    linkedHashMap5.put(parcel.readString(), parcel.readParcelable(ia3.class.getClassLoader()));
                }
                int i25 = parcel.readInt();
                String string9 = parcel.readString();
                int i26 = parcel.readInt();
                Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                boolean z2 = parcel.readInt() != 0;
                boolean z3 = parcel.readInt() != 0;
                boolean z4 = parcel.readInt() != 0;
                int i27 = parcel.readInt();
                LinkedHashSet linkedHashSet4 = new LinkedHashSet(i27);
                for (int i28 = 0; i28 != i27; i28++) {
                    linkedHashSet4.add(parcel.readString());
                }
                return new ia3(string7, linkedHashSet2, linkedHashSet3, string8, linkedHashMap5, i25, string9, i26, numValueOf, z2, z3, z4, linkedHashSet4, parcel.readInt() != 0);
            case 14:
                parcel.getClass();
                String string10 = parcel.readString();
                int i29 = parcel.readInt();
                LinkedHashSet linkedHashSet5 = new LinkedHashSet(i29);
                for (int i30 = 0; i30 != i29; i30++) {
                    linkedHashSet5.add(parcel.readString());
                }
                int i31 = parcel.readInt();
                LinkedHashSet linkedHashSet6 = new LinkedHashSet(i31);
                for (int i32 = 0; i32 != i31; i32++) {
                    linkedHashSet6.add(parcel.readString());
                }
                String string11 = parcel.readString();
                int i33 = parcel.readInt();
                LinkedHashMap linkedHashMap6 = new LinkedHashMap(i33);
                for (int i34 = 0; i34 != i33; i34++) {
                    linkedHashMap6.put(parcel.readString(), parcel.readParcelable(ja3.class.getClassLoader()));
                }
                int i35 = parcel.readInt();
                boolean z5 = parcel.readInt() != 0;
                boolean z6 = parcel.readInt() != 0;
                boolean z7 = parcel.readInt() != 0;
                boolean z8 = parcel.readInt() != 0;
                int i36 = parcel.readInt();
                LinkedHashSet linkedHashSet7 = new LinkedHashSet(i36);
                for (int i37 = 0; i37 != i36; i37++) {
                    linkedHashSet7.add(parcel.readString());
                }
                return new ja3(string10, linkedHashSet5, linkedHashSet6, string11, linkedHashMap6, i35, z5, z6, z7, z8, linkedHashSet7, parcel.readInt() != 0);
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                parcel.getClass();
                String string12 = parcel.readString();
                int i38 = parcel.readInt();
                LinkedHashSet linkedHashSet8 = new LinkedHashSet(i38);
                for (int i39 = 0; i39 != i38; i39++) {
                    linkedHashSet8.add(parcel.readString());
                }
                int i40 = parcel.readInt();
                LinkedHashSet linkedHashSet9 = new LinkedHashSet(i40);
                for (int i41 = 0; i41 != i40; i41++) {
                    linkedHashSet9.add(parcel.readString());
                }
                String string13 = parcel.readString();
                int i42 = parcel.readInt();
                LinkedHashMap linkedHashMap7 = new LinkedHashMap(i42);
                for (int i43 = 0; i43 != i42; i43++) {
                    linkedHashMap7.put(parcel.readString(), parcel.readParcelable(ka3.class.getClassLoader()));
                }
                int i44 = parcel.readInt();
                boolean z9 = parcel.readInt() != 0;
                boolean z10 = parcel.readInt() != 0;
                boolean z11 = parcel.readInt() != 0;
                int i45 = parcel.readInt();
                LinkedHashSet linkedHashSet10 = new LinkedHashSet(i45);
                for (int i46 = 0; i46 != i45; i46++) {
                    linkedHashSet10.add(parcel.readString());
                }
                return new ka3(string12, linkedHashSet8, linkedHashSet9, string13, linkedHashMap7, i44, z9, z10, z11, linkedHashSet10, parcel.readInt() != 0);
            case 16:
                parcel.getClass();
                String string14 = parcel.readString();
                int i47 = parcel.readInt();
                LinkedHashSet linkedHashSet11 = new LinkedHashSet(i47);
                for (int i48 = 0; i48 != i47; i48++) {
                    linkedHashSet11.add(parcel.readString());
                }
                String string15 = parcel.readString();
                int i49 = parcel.readInt();
                LinkedHashMap linkedHashMap8 = new LinkedHashMap(i49);
                for (int i50 = 0; i50 != i49; i50++) {
                    linkedHashMap8.put(parcel.readParcelable(la3.class.getClassLoader()), parcel.readString());
                }
                int i51 = parcel.readInt();
                LinkedHashSet linkedHashSet12 = new LinkedHashSet(i51);
                for (int i52 = 0; i52 != i51; i52++) {
                    linkedHashSet12.add(parcel.readString());
                }
                String string16 = parcel.readString();
                int i53 = parcel.readInt();
                LinkedHashMap linkedHashMap9 = new LinkedHashMap(i53);
                for (int i54 = 0; i54 != i53; i54++) {
                    linkedHashMap9.put(parcel.readString(), parcel.readParcelable(la3.class.getClassLoader()));
                }
                int i55 = parcel.readInt();
                boolean z12 = parcel.readInt() != 0;
                boolean z13 = parcel.readInt() != 0;
                boolean z14 = parcel.readInt() != 0;
                int i56 = parcel.readInt();
                LinkedHashSet linkedHashSet13 = new LinkedHashSet(i56);
                for (int i57 = 0; i57 != i56; i57++) {
                    linkedHashSet13.add(parcel.readString());
                }
                return new la3(string14, linkedHashSet11, string15, linkedHashMap8, linkedHashSet12, string16, linkedHashMap9, i55, z12, z13, z14, linkedHashSet13, parcel.readInt() != 0);
            case 17:
                parcel.getClass();
                String string17 = parcel.readString();
                int i58 = parcel.readInt();
                LinkedHashSet linkedHashSet14 = new LinkedHashSet(i58);
                for (int i59 = 0; i59 != i58; i59++) {
                    linkedHashSet14.add(parcel.readString());
                }
                int i60 = parcel.readInt();
                LinkedHashSet linkedHashSet15 = new LinkedHashSet(i60);
                for (int i61 = 0; i61 != i60; i61++) {
                    linkedHashSet15.add(parcel.readString());
                }
                String string18 = parcel.readString();
                int i62 = parcel.readInt();
                LinkedHashMap linkedHashMap10 = new LinkedHashMap(i62);
                for (int i63 = 0; i63 != i62; i63++) {
                    linkedHashMap10.put(parcel.readString(), parcel.readParcelable(ma3.class.getClassLoader()));
                }
                int i64 = parcel.readInt();
                String string19 = parcel.readString();
                int i65 = parcel.readInt();
                int i66 = parcel.readInt();
                Integer numValueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                boolean z15 = parcel.readInt() != 0;
                boolean z16 = parcel.readInt() != 0;
                boolean z17 = parcel.readInt() != 0;
                int i67 = parcel.readInt();
                LinkedHashSet linkedHashSet16 = new LinkedHashSet(i67);
                for (int i68 = 0; i68 != i67; i68++) {
                    linkedHashSet16.add(parcel.readString());
                }
                return new ma3(string17, linkedHashSet14, linkedHashSet15, string18, linkedHashMap10, i64, string19, i65, i66, numValueOf2, z15, z16, z17, linkedHashSet16, parcel.readInt() != 0);
            case 18:
                parcel.getClass();
                return new ii3(parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()));
            case 19:
                parcel.getClass();
                return new li3(parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()));
            case 20:
                parcel.getClass();
                return new fm3((InetAddress) parcel.readSerializable(), parcel.readInt());
            case 21:
                parcel.getClass();
                return new mm3(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
            case 22:
                parcel.getClass();
                return new nm3(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
            case 23:
                parcel.getClass();
                return new om3(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readString(), null, 128);
            case 24:
                parcel.getClass();
                return new pm3(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
            case 25:
                parcel.getClass();
                return new qm3(parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
            case 26:
                parcel.getClass();
                return new tm3(parcel.readString());
            case 27:
                parcel.getClass();
                return new um3(fm3.CREATOR.createFromParcel(parcel), parcel.readString());
            case 28:
                parcel.getClass();
                return new vm3(parcel.readString(), parcel.readString());
            default:
                parcel.getClass();
                int i69 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(i69);
                for (int i70 = 0; i70 != i69; i70++) {
                    arrayList4.add(parcel.readParcelable(xm3.class.getClassLoader()));
                }
                return new xm3(parcel.readString(), arrayList4);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new jc2[i];
            case 1:
                return new xf2[i];
            case 2:
                return new mi2[i];
            case 3:
                return new tj2[i];
            case 4:
                return new an2[i];
            case 5:
                return new np2[i];
            case 6:
                return new vq2[i];
            case 7:
                return new h03[i];
            case 8:
                return new ParcelImpl[i];
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new i23[i];
            case 10:
                return new u23[i];
            case 11:
                return new k33[i];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new t53[i];
            case 13:
                return new ia3[i];
            case 14:
                return new ja3[i];
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new ka3[i];
            case 16:
                return new la3[i];
            case 17:
                return new ma3[i];
            case 18:
                return new ii3[i];
            case 19:
                return new li3[i];
            case 20:
                return new fm3[i];
            case 21:
                return new mm3[i];
            case 22:
                return new nm3[i];
            case 23:
                return new om3[i];
            case 24:
                return new pm3[i];
            case 25:
                return new qm3[i];
            case 26:
                return new tm3[i];
            case 27:
                return new um3[i];
            case 28:
                return new vm3[i];
            default:
                return new xm3[i];
        }
    }
}
