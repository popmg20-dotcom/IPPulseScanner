package defpackage;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i95 extends b35 implements v55 {
    public final ff5 c;
    public Boolean d;
    public String e;

    public i95(ff5 ff5Var) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        tj4.i(ff5Var);
        this.c = ff5Var;
        this.e = null;
    }

    @Override // defpackage.v55
    public final void A(tg5 tg5Var) {
        tj4.f(tg5Var.b);
        tj4.i(tg5Var.J0);
        b(new p85(this, tg5Var, 2));
    }

    @Override // defpackage.v55
    public final void B(kf5 kf5Var, tg5 tg5Var) {
        tj4.i(kf5Var);
        c(tg5Var);
        F(new g33(8, this, kf5Var, tg5Var));
    }

    @Override // defpackage.v55
    public final String C(tg5 tg5Var) {
        c(tg5Var);
        ff5 ff5Var = this.c;
        try {
            return (String) ff5Var.C().c1(new m85(ff5Var, tg5Var)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            ff5Var.n().z0.c("Failed to get app instance id. appId", t65.Z0(tg5Var.b), e);
            return null;
        }
    }

    @Override // defpackage.v55
    public final List D(String str, String str2, boolean z, tg5 tg5Var) {
        c(tg5Var);
        String str3 = tg5Var.b;
        tj4.i(str3);
        ff5 ff5Var = this.c;
        try {
            List<mf5> list = (List) ff5Var.C().c1(new u85(this, str3, str, str2, 0)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (mf5 mf5Var : list) {
                if (z || !qf5.v1(mf5Var.c)) {
                    arrayList.add(new kf5(mf5Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            ff5Var.n().z0.c("Failed to query user properties. appId", t65.Z0(str3), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e2) {
            e = e2;
            ff5Var.n().z0.c("Failed to query user properties. appId", t65.Z0(str3), e);
            return Collections.EMPTY_LIST;
        }
    }

    public final void E(String str, boolean z) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        ff5 ff5Var = this.c;
        if (zIsEmpty) {
            ff5Var.n().z0.a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                Boolean boolValueOf = this.d;
                if (boolValueOf == null) {
                    boolean z2 = true;
                    if (!"com.google.android.gms".equals(this.e) && !yr2.M(ff5Var.C0.b, Binder.getCallingUid()) && !wp1.a(ff5Var.C0.b).b(Binder.getCallingUid())) {
                        z2 = false;
                    }
                    boolValueOf = Boolean.valueOf(z2);
                    this.d = boolValueOf;
                }
                if (boolValueOf.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                ff5Var.n().z0.b(t65.Z0(str), "Measurement Service called with invalid calling package. appId");
                throw e;
            }
        }
        if (this.e == null) {
            Context context = ff5Var.C0.b;
            int callingUid = Binder.getCallingUid();
            int i = up1.e;
            if (yr2.q0(callingUid, context, str)) {
                this.e = str;
            }
        }
        if (str.equals(this.e)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    public final void F(Runnable runnable) {
        ff5 ff5Var = this.c;
        if (ff5Var.C().b1()) {
            runnable.run();
        } else {
            ff5Var.C().e1(runnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.b35
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        List list;
        ff5 ff5Var = this.c;
        ArrayList arrayList = null;
        y55 w55Var = null;
        b65 z55Var = null;
        int i2 = 1;
        switch (i) {
            case 1:
                z25 z25Var = (z25) d35.a(parcel, z25.CREATOR);
                tg5 tg5Var = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                f(z25Var, tg5Var);
                parcel2.writeNoException();
                return true;
            case 2:
                kf5 kf5Var = (kf5) d35.a(parcel, kf5.CREATOR);
                tg5 tg5Var2 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                B(kf5Var, tg5Var2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            case 28:
            default:
                return false;
            case 4:
                tg5 tg5Var3 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                s(tg5Var3);
                parcel2.writeNoException();
                return true;
            case 5:
                z25 z25Var2 = (z25) d35.a(parcel, z25.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                d35.d(parcel);
                tj4.i(z25Var2);
                tj4.f(string);
                E(string, true);
                F(new g33(7, this, z25Var2, string));
                parcel2.writeNoException();
                return true;
            case 6:
                tg5 tg5Var4 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                l(tg5Var4);
                parcel2.writeNoException();
                return true;
            case 7:
                tg5 tg5Var5 = (tg5) d35.a(parcel, tg5.CREATOR);
                Object[] objArr = parcel.readInt() != 0;
                d35.d(parcel);
                c(tg5Var5);
                String str = tg5Var5.b;
                tj4.i(str);
                try {
                    List<mf5> list2 = (List) ff5Var.C().c1(new m85(this, str, z ? 1 : 0)).get();
                    ArrayList arrayList2 = new ArrayList(list2.size());
                    for (mf5 mf5Var : list2) {
                        if (objArr != false || !qf5.v1(mf5Var.c)) {
                            arrayList2.add(new kf5(mf5Var));
                        }
                        break;
                    }
                    arrayList = arrayList2;
                } catch (InterruptedException e) {
                    e = e;
                    ff5Var.n().z0.c("Failed to get user properties. appId", t65.Z0(str), e);
                } catch (ExecutionException e2) {
                    e = e2;
                    ff5Var.n().z0.c("Failed to get user properties. appId", t65.Z0(str), e);
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                z25 z25Var3 = (z25) d35.a(parcel, z25.CREATOR);
                String string2 = parcel.readString();
                d35.d(parcel);
                byte[] bArrI = i(string2, z25Var3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrI);
                return true;
            case 10:
                long j = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                d35.d(parcel);
                h(j, string3, string4, string5);
                parcel2.writeNoException();
                return true;
            case 11:
                tg5 tg5Var6 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                String strC = C(tg5Var6);
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                q15 q15Var = (q15) d35.a(parcel, q15.CREATOR);
                tg5 tg5Var7 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                r(q15Var, tg5Var7);
                parcel2.writeNoException();
                return true;
            case 13:
                q15 q15Var2 = (q15) d35.a(parcel, q15.CREATOR);
                d35.d(parcel);
                tj4.i(q15Var2);
                tj4.i(q15Var2.z);
                tj4.f(q15Var2.b);
                E(q15Var2.b, true);
                F(new um1(16, this, new q15(q15Var2), z));
                parcel2.writeNoException();
                return true;
            case 14:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                ClassLoader classLoader = d35.a;
                z = parcel.readInt() != 0;
                tg5 tg5Var8 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                List listD = D(string6, string7, z, tg5Var8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listD);
                return true;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                ClassLoader classLoader2 = d35.a;
                boolean z = parcel.readInt() != 0;
                d35.d(parcel);
                List listE = e(string8, string9, string10, z);
                parcel2.writeNoException();
                parcel2.writeTypedList(listE);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                tg5 tg5Var9 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                List listW = w(string11, string12, tg5Var9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listW);
                return true;
            case 17:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                d35.d(parcel);
                List listJ = j(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listJ);
                return true;
            case 18:
                tg5 tg5Var10 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                z(tg5Var10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) d35.a(parcel, Bundle.CREATOR);
                tg5 tg5Var11 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                q(bundle, tg5Var11);
                parcel2.writeNoException();
                return true;
            case 20:
                tg5 tg5Var12 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                A(tg5Var12);
                parcel2.writeNoException();
                return true;
            case 21:
                tg5 tg5Var13 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                c25 c25VarP = p(tg5Var13);
                parcel2.writeNoException();
                if (c25VarP == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeInt(1);
                c25VarP.writeToParcel(parcel2, 1);
                return true;
            case 24:
                tg5 tg5Var14 = (tg5) d35.a(parcel, tg5.CREATOR);
                Bundle bundle2 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                d35.d(parcel);
                c(tg5Var14);
                String str2 = tg5Var14.b;
                tj4.i(str2);
                if (!ff5Var.c0().f1(null, r55.Z0)) {
                    try {
                        list = (List) ff5Var.C().c1(new b95(this, tg5Var14, bundle2, i2)).get();
                    } catch (InterruptedException | ExecutionException e3) {
                        ff5Var.n().z0.c("Failed to get trigger URIs. appId", t65.Z0(str2), e3);
                        list = Collections.EMPTY_LIST;
                    }
                    break;
                } else {
                    try {
                        list = (List) ff5Var.C().d1(new b95(this, tg5Var14, bundle2, z ? 1 : 0)).get(10000L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException | ExecutionException | TimeoutException e4) {
                        ff5Var.n().z0.c("Failed to get trigger URIs. appId", t65.Z0(str2), e4);
                        list = Collections.EMPTY_LIST;
                    }
                    break;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(list);
                return true;
            case 25:
                tg5 tg5Var15 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                k(tg5Var15);
                parcel2.writeNoException();
                return true;
            case 26:
                tg5 tg5Var16 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                n(tg5Var16);
                parcel2.writeNoException();
                return true;
            case 27:
                tg5 tg5Var17 = (tg5) d35.a(parcel, tg5.CREATOR);
                d35.d(parcel);
                y(tg5Var17);
                parcel2.writeNoException();
                return true;
            case 29:
                tg5 tg5Var18 = (tg5) d35.a(parcel, tg5.CREATOR);
                le5 le5Var = (le5) d35.a(parcel, le5.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    z55Var = iInterfaceQueryLocalInterface instanceof b65 ? (b65) iInterfaceQueryLocalInterface : new z55(strongBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback", 2);
                }
                d35.d(parcel);
                u(tg5Var18, le5Var, z55Var);
                parcel2.writeNoException();
                return true;
            case 30:
                tg5 tg5Var19 = (tg5) d35.a(parcel, tg5.CREATOR);
                k15 k15Var = (k15) d35.a(parcel, k15.CREATOR);
                d35.d(parcel);
                o(tg5Var19, k15Var);
                parcel2.writeNoException();
                return true;
            case 31:
                tg5 tg5Var20 = (tg5) d35.a(parcel, tg5.CREATOR);
                Bundle bundle3 = (Bundle) d35.a(parcel, Bundle.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    w55Var = iInterfaceQueryLocalInterface2 instanceof y55 ? (y55) iInterfaceQueryLocalInterface2 : new w55(strongBinder2, "com.google.android.gms.measurement.internal.ITriggerUrisCallback", 2);
                }
                d35.d(parcel);
                m(tg5Var20, bundle3, w55Var);
                parcel2.writeNoException();
                return true;
        }
    }

    public final void b(Runnable runnable) {
        ff5 ff5Var = this.c;
        if (ff5Var.C().b1()) {
            runnable.run();
        } else {
            ff5Var.C().g1(runnable);
        }
    }

    public final void c(tg5 tg5Var) {
        tj4.i(tg5Var);
        String str = tg5Var.b;
        tj4.f(str);
        E(str, false);
        this.c.i0().Z0(tg5Var.f);
    }

    @Override // defpackage.v55
    public final List e(String str, String str2, String str3, boolean z) {
        E(str, true);
        ff5 ff5Var = this.c;
        try {
            List<mf5> list = (List) ff5Var.C().c1(new u85(this, str, str2, str3, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (mf5 mf5Var : list) {
                if (z || !qf5.v1(mf5Var.c)) {
                    arrayList.add(new kf5(mf5Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            ff5Var.n().z0.c("Failed to get user properties as. appId", t65.Z0(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e2) {
            e = e2;
            ff5Var.n().z0.c("Failed to get user properties as. appId", t65.Z0(str), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // defpackage.v55
    public final void f(z25 z25Var, tg5 tg5Var) {
        tj4.i(z25Var);
        c(tg5Var);
        F(new g33(6, this, z25Var, tg5Var));
    }

    @Override // defpackage.v55
    public final void h(long j, String str, String str2, String str3) {
        F(new q85(this, str2, str3, str, j, 0));
    }

    @Override // defpackage.v55
    public final byte[] i(String str, z25 z25Var) {
        tj4.f(str);
        tj4.i(z25Var);
        E(str, true);
        ff5 ff5Var = this.c;
        q65 q65Var = ff5Var.n().G0;
        k85 k85Var = ff5Var.C0;
        k65 k65Var = k85Var.A0;
        String str2 = z25Var.b;
        q65Var.b(k65Var.a(str2), "Log and bundle. event");
        ff5Var.z0().getClass();
        long jNanoTime = System.nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) ff5Var.C().d1(new vq1(this, z25Var, str)).get();
            if (bArr == null) {
                ff5Var.n().z0.b(t65.Z0(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            ff5Var.z0().getClass();
            ff5Var.n().G0.d("Log and bundle processed. event, size, time_ms", k85Var.A0.a(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            ff5Var.n().z0.d("Failed to log and bundle. appId, event, error", t65.Z0(str), k85Var.A0.a(str2), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            ff5Var.n().z0.d("Failed to log and bundle. appId, event, error", t65.Z0(str), k85Var.A0.a(str2), e);
            return null;
        }
    }

    @Override // defpackage.v55
    public final List j(String str, String str2, String str3) {
        E(str, true);
        ff5 ff5Var = this.c;
        try {
            return (List) ff5Var.C().c1(new u85(this, str, str2, str3, 3)).get();
        } catch (InterruptedException | ExecutionException e) {
            ff5Var.n().z0.b(e, "Failed to get conditional user properties as");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // defpackage.v55
    public final void k(tg5 tg5Var) {
        tj4.f(tg5Var.b);
        tj4.i(tg5Var.J0);
        b(new p85(this, tg5Var, 3));
    }

    @Override // defpackage.v55
    public final void l(tg5 tg5Var) {
        c(tg5Var);
        F(new p85(this, tg5Var, 1));
    }

    @Override // defpackage.v55
    public final void m(tg5 tg5Var, Bundle bundle, y55 y55Var) {
        c(tg5Var);
        String str = tg5Var.b;
        tj4.i(str);
        this.c.C().e1(new w11(this, tg5Var, bundle, y55Var, str));
    }

    @Override // defpackage.v55
    public final void n(tg5 tg5Var) {
        tj4.f(tg5Var.b);
        tj4.i(tg5Var.J0);
        b(new o85(this, tg5Var, 2));
    }

    @Override // defpackage.v55
    public final void o(tg5 tg5Var, k15 k15Var) {
        c(tg5Var);
        F(new g33(this, tg5Var, k15Var, 9, false));
    }

    @Override // defpackage.v55
    public final c25 p(tg5 tg5Var) {
        c(tg5Var);
        String str = tg5Var.b;
        tj4.f(str);
        ff5 ff5Var = this.c;
        try {
            return (c25) ff5Var.C().d1(new m85(this, tg5Var, 1)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            ff5Var.n().z0.c("Failed to get consent. appId", t65.Z0(str), e);
            return new c25(null);
        }
    }

    @Override // defpackage.v55
    public final void q(Bundle bundle, tg5 tg5Var) {
        c(tg5Var);
        String str = tg5Var.b;
        tj4.i(str);
        F(new d20(this, bundle, str, tg5Var, 4, false));
    }

    @Override // defpackage.v55
    public final void r(q15 q15Var, tg5 tg5Var) {
        tj4.i(q15Var);
        tj4.i(q15Var.z);
        c(tg5Var);
        q15 q15Var2 = new q15(q15Var);
        q15Var2.b = tg5Var.b;
        F(new g33(5, this, q15Var2, tg5Var));
    }

    @Override // defpackage.v55
    public final void s(tg5 tg5Var) {
        c(tg5Var);
        F(new o85(this, tg5Var, 0));
    }

    @Override // defpackage.v55
    public final void u(tg5 tg5Var, le5 le5Var, b65 b65Var) {
        c(tg5Var);
        String str = tg5Var.b;
        tj4.i(str);
        this.c.C().e1(new d20(this, str, le5Var, b65Var, 2, false));
    }

    @Override // defpackage.v55
    public final List w(String str, String str2, tg5 tg5Var) {
        c(tg5Var);
        String str3 = tg5Var.b;
        tj4.i(str3);
        ff5 ff5Var = this.c;
        try {
            return (List) ff5Var.C().c1(new u85(this, str3, str, str2, 2)).get();
        } catch (InterruptedException | ExecutionException e) {
            ff5Var.n().z0.b(e, "Failed to get conditional user properties");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // defpackage.v55
    public final void y(tg5 tg5Var) {
        c(tg5Var);
        F(new p85(this, tg5Var, 0));
    }

    @Override // defpackage.v55
    public final void z(tg5 tg5Var) {
        String str = tg5Var.b;
        tj4.f(str);
        E(str, false);
        F(new o85(this, tg5Var, 1));
    }
}
