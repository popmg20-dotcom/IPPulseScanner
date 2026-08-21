package defpackage;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class wd5 {
    public static final f45 a;
    public static final f45 b;
    public static volatile f15 c;
    public static final Object d;
    public static Context e;

    static {
        new f45(g95.H("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"), 0);
        new f45(g95.H("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"), 1);
        new f45(g95.H("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"), 2);
        new f45(g95.H("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"), 3);
        a = new f45(g95.H("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"), 4);
        b = new f45(g95.H("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"), 5);
        d = new Object();
    }

    public static synchronized void a(Context context) {
        if (e != null) {
            a1.n("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            e = context.getApplicationContext();
        }
    }

    public static void b() {
        f15 b15Var;
        if (c != null) {
            return;
        }
        tj4.i(e);
        synchronized (d) {
            try {
                if (c == null) {
                    IBinder iBinderB = yz0.c(e, yz0.d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = d15.d;
                    if (iBinderB == null) {
                        b15Var = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        b15Var = iInterfaceQueryLocalInterface instanceof f15 ? (f15) iInterfaceQueryLocalInterface : new b15(iBinderB, "com.google.android.gms.common.internal.IGoogleCertificatesApi", 1);
                    }
                    c = b15Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static fa5 c(String str, ja5 ja5Var, boolean z, boolean z2) {
        try {
            b();
            tj4.i(e);
            try {
                f15 f15Var = c;
                bu2 bu2Var = new bu2(e.getPackageManager());
                b15 b15Var = (b15) f15Var;
                Parcel parcelC = b15Var.c();
                int i = k35.a;
                boolean z3 = true;
                parcelC.writeInt(1);
                int iV = ye.V(parcelC, 20293);
                ye.Q(parcelC, 1, str);
                ye.O(parcelC, 2, ja5Var);
                ye.U(parcelC, 3, 4);
                parcelC.writeInt(z ? 1 : 0);
                ye.U(parcelC, 4, 4);
                parcelC.writeInt(z2 ? 1 : 0);
                ye.W(parcelC, iV);
                k35.b(parcelC, bu2Var);
                Parcel parcelA = b15Var.a(parcelC, 5);
                if (parcelA.readInt() == 0) {
                    z3 = false;
                }
                parcelA.recycle();
                return z3 ? fa5.X : new lh5(new cb5(z, str, ja5Var));
            } catch (RemoteException e2) {
                a1.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return fa5.B("module call", e2);
            }
        } catch (vz0 e3) {
            a1.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return fa5.B("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }
}
