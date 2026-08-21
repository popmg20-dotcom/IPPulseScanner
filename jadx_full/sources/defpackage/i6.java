package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i6 {
    public xn a;
    public y45 b;
    public boolean c;
    public final Object d = new Object();
    public t25 e;
    public final Context f;
    public final long g;

    public i6(Context context) {
        tj4.i(context);
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext != null ? applicationContext : context;
        this.c = false;
        this.g = -1L;
    }

    public static h6 a(Context context) {
        i6 i6Var = new i6(context);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            i6Var.c();
            h6 h6VarE = i6Var.e();
            d(h6VarE, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return h6VarE;
        } finally {
        }
    }

    public static void d(h6 h6Var, long j, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (h6Var != null) {
                map.put("limit_ad_tracking", true != h6Var.b ? "0" : "1");
                String str = h6Var.c;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j));
            new re2(2, map).start();
        }
    }

    public final void b() {
        tj4.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f == null || this.a == null) {
                    return;
                }
                try {
                    if (this.c) {
                        fb0.a().b(this.f, this.a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.c = false;
                this.b = null;
                this.a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        tj4.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.c) {
                    b();
                }
                Context context = this.f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iB = mp1.b.b(context, 12451000);
                    if (iB != 0 && iB != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    xn xnVar = new xn();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!fb0.a().c(context, context.getClass().getName(), intent, xnVar, 1, null)) {
                            throw new IOException("Connection failure");
                        }
                        this.a = xnVar;
                        try {
                            IBinder iBinderA = xnVar.a();
                            int i = s45.c;
                            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.b = iInterfaceQueryLocalInterface instanceof y45 ? (y45) iInterfaceQueryLocalInterface : new b45(iBinderA);
                            this.c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new w9();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final h6 e() {
        h6 h6Var;
        tj4.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.c) {
                    synchronized (this.d) {
                        t25 t25Var = this.e;
                        if (t25Var == null || !t25Var.A) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c();
                        if (!this.c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                tj4.i(this.a);
                tj4.i(this.b);
                try {
                    b45 b45Var = (b45) this.b;
                    b45Var.getClass();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean z = true;
                    Parcel parcelA = b45Var.a(parcelObtain, 1);
                    String string = parcelA.readString();
                    parcelA.recycle();
                    b45 b45Var2 = (b45) this.b;
                    b45Var2.getClass();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int i = j35.a;
                    parcelObtain2.writeInt(1);
                    Parcel parcelA2 = b45Var2.a(parcelObtain2, 2);
                    if (parcelA2.readInt() == 0) {
                        z = false;
                    }
                    parcelA2.recycle();
                    h6Var = new h6(string, z, 0);
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
        return h6Var;
    }

    public final void f() {
        synchronized (this.d) {
            t25 t25Var = this.e;
            if (t25Var != null) {
                t25Var.z.countDown();
                try {
                    this.e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.g;
            if (j > 0) {
                this.e = new t25(this, j);
            }
        }
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
