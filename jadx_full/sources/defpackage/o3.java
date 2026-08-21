package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.b;
import androidx.fragment.app.w;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Locale;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o3 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        ArrayList arrayList;
        switch (this.a) {
            case 0:
                p3 p3Var = new p3();
                p3Var.b = parcel.readInt();
                return p3Var;
            case 1:
                parcel.getClass();
                return new k4(parcel.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
            case 2:
                parcel.getClass();
                return new s9(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 3:
                zb zbVar = new zb(parcel);
                zbVar.b = parcel.readByte() != 0;
                return zbVar;
            case 4:
                parcel.getClass();
                parcel.readInt();
                return new bf();
            case 5:
                return new b(parcel);
            case 6:
                return new ai(parcel);
            case 7:
                qj qjVar = new qj();
                qjVar.z0 = DnsRecord.CLASS_ANY;
                qjVar.B0 = -2;
                qjVar.C0 = -2;
                qjVar.D0 = -2;
                qjVar.K0 = Boolean.TRUE;
                qjVar.b = parcel.readInt();
                qjVar.f = (Integer) parcel.readSerializable();
                qjVar.z = (Integer) parcel.readSerializable();
                qjVar.A = (Integer) parcel.readSerializable();
                qjVar.X = (Integer) parcel.readSerializable();
                qjVar.Y = (Integer) parcel.readSerializable();
                qjVar.Z = (Integer) parcel.readSerializable();
                qjVar.y0 = (Integer) parcel.readSerializable();
                qjVar.z0 = parcel.readInt();
                qjVar.A0 = parcel.readString();
                qjVar.B0 = parcel.readInt();
                qjVar.C0 = parcel.readInt();
                qjVar.D0 = parcel.readInt();
                qjVar.F0 = parcel.readString();
                qjVar.G0 = parcel.readString();
                qjVar.H0 = parcel.readInt();
                qjVar.J0 = (Integer) parcel.readSerializable();
                qjVar.L0 = (Integer) parcel.readSerializable();
                qjVar.M0 = (Integer) parcel.readSerializable();
                qjVar.N0 = (Integer) parcel.readSerializable();
                qjVar.O0 = (Integer) parcel.readSerializable();
                qjVar.P0 = (Integer) parcel.readSerializable();
                qjVar.Q0 = (Integer) parcel.readSerializable();
                qjVar.T0 = (Integer) parcel.readSerializable();
                qjVar.R0 = (Integer) parcel.readSerializable();
                qjVar.S0 = (Integer) parcel.readSerializable();
                qjVar.K0 = (Boolean) parcel.readSerializable();
                qjVar.E0 = (Locale) parcel.readSerializable();
                qjVar.U0 = (Boolean) parcel.readSerializable();
                qjVar.V0 = (Integer) parcel.readSerializable();
                return qjVar;
            case 8:
                parcel.getClass();
                return new tu0(parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()));
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new m01(parcel);
            case 10:
                wj1 wj1Var = new wj1();
                wj1Var.b = parcel.readString();
                wj1Var.f = parcel.readInt();
                return wj1Var;
            case 11:
                bk1 bk1Var = new bk1();
                bk1Var.X = null;
                bk1Var.Y = new ArrayList();
                bk1Var.Z = new ArrayList();
                bk1Var.b = parcel.createStringArrayList();
                bk1Var.f = parcel.createStringArrayList();
                bk1Var.z = (b[]) parcel.createTypedArray(b.CREATOR);
                bk1Var.A = parcel.readInt();
                bk1Var.X = parcel.readString();
                bk1Var.Y = parcel.createStringArrayList();
                bk1Var.Z = parcel.createTypedArrayList(ai.CREATOR);
                bk1Var.y0 = parcel.createTypedArrayList(wj1.CREATOR);
                return bk1Var;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new w(parcel);
            case 13:
                parcel.getClass();
                return new zm1((bf) parcel.readParcelable(zm1.class.getClassLoader()));
            case 14:
                parcel.getClass();
                return new ls1(parcel.readString(), parcel.readInt(), parcel.readString());
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                parcel.getClass();
                return new ps1(om3.CREATOR.createFromParcel(parcel));
            case 16:
                parcel.getClass();
                return new qs1(parcel.readString());
            case 17:
                parcel.getClass();
                return new rs1((tn3) parcel.readParcelable(rs1.class.getClassLoader()), parcel.readString());
            case 18:
                parcel.getClass();
                return new ts1(parcel.readString());
            case 19:
                parcel.getClass();
                return new us1(parcel.readString());
            case 20:
                parcel.getClass();
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(parcel.readSerializable());
                }
                return new vs1(arrayList2);
            case 21:
                parcel.getClass();
                return new ws1((InetSocketAddress) parcel.readSerializable());
            case 22:
                parcel.getClass();
                return new xs1(parcel.readString());
            case 23:
                parcel.getClass();
                return new ou1(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 24:
                parcel.getClass();
                return new gv1(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 25:
                parcel.getClass();
                String string = parcel.readString();
                String string2 = parcel.readString();
                int i3 = parcel.readInt();
                String string3 = parcel.readString();
                Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                if (parcel.readInt() == 0) {
                    arrayList = null;
                } else {
                    int i4 = parcel.readInt();
                    ArrayList arrayList3 = new ArrayList(i4);
                    for (int i5 = 0; i5 != i4; i5++) {
                        arrayList3.add(i23.CREATOR.createFromParcel(parcel));
                    }
                    arrayList = arrayList3;
                }
                return new jv1(string, string2, i3, string3, numValueOf, arrayList, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, tn.valueOf(parcel.readString()), parcel.readString());
            case 26:
                parcel.getClass();
                Parcelable parcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                parcelable.getClass();
                return new d12((IntentSender) parcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 27:
                parcel.getClass();
                return new p12(parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt() != 0 ? xf2.CREATOR.createFromParcel(parcel) : null, parcel.readString());
            case 28:
                parcel.getClass();
                return new f82(parcel.readString(), parcel.readString(), parcel.readString());
            default:
                db2 db2Var = new db2();
                db2Var.b = parcel.readInt();
                db2Var.f = parcel.readInt();
                db2Var.z = parcel.readInt() == 1;
                return db2Var;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new p3[i];
            case 1:
                return new k4[i];
            case 2:
                return new s9[i];
            case 3:
                return new zb[i];
            case 4:
                return new bf[i];
            case 5:
                return new b[i];
            case 6:
                return new ai[i];
            case 7:
                return new qj[i];
            case 8:
                return new tu0[i];
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return new m01[i];
            case 10:
                return new wj1[i];
            case 11:
                return new bk1[i];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new w[i];
            case 13:
                return new zm1[i];
            case 14:
                return new ls1[i];
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                return new ps1[i];
            case 16:
                return new qs1[i];
            case 17:
                return new rs1[i];
            case 18:
                return new ts1[i];
            case 19:
                return new us1[i];
            case 20:
                return new vs1[i];
            case 21:
                return new ws1[i];
            case 22:
                return new xs1[i];
            case 23:
                return new ou1[i];
            case 24:
                return new gv1[i];
            case 25:
                return new jv1[i];
            case 26:
                return new d12[i];
            case 27:
                return new p12[i];
            case 28:
                return new f82[i];
            default:
                return new db2[i];
        }
    }
}
