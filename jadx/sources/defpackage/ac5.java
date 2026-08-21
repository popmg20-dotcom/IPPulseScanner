package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ac5 implements Runnable {
    public final /* synthetic */ tg5 A;
    public final /* synthetic */ boolean X;
    public final /* synthetic */ dd5 Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ String f;
    public final /* synthetic */ String z;

    public ac5(dd5 dd5Var, String str, String str2, tg5 tg5Var, boolean z, v35 v35Var) {
        this.f = str;
        this.z = str2;
        this.A = tg5Var;
        this.X = z;
        this.Z = v35Var;
        this.Y = dd5Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        qf5 qf5Var;
        v55 v55Var;
        AtomicReference atomicReference;
        dd5 dd5Var;
        v55 v55Var2;
        switch (this.b) {
            case 0:
                String str = this.z;
                String str2 = this.f;
                v35 v35Var = (v35) this.Z;
                dd5 dd5Var2 = this.Y;
                k85 k85Var = (k85) dd5Var2.f;
                Bundle bundle = new Bundle();
                try {
                    try {
                        v55Var = dd5Var2.Z;
                    } catch (RemoteException e) {
                        e = e;
                    }
                    if (v55Var == null) {
                        t65 t65Var = k85Var.Y;
                        k85.h(t65Var);
                        t65Var.z0.c("Failed to get user properties; not connected to service", str2, str);
                        qf5Var = k85Var.z0;
                        k85.f(qf5Var);
                        qf5Var.K1(v35Var, bundle);
                        return;
                    }
                    List<kf5> listD = v55Var.D(str2, str, this.X, this.A);
                    Bundle bundle2 = new Bundle();
                    if (listD != null) {
                        for (kf5 kf5Var : listD) {
                            String str3 = kf5Var.X;
                            String str4 = kf5Var.f;
                            if (str3 != null) {
                                bundle2.putString(str4, str3);
                            } else {
                                Long l = kf5Var.A;
                                if (l != null) {
                                    bundle2.putLong(str4, l.longValue());
                                } else {
                                    Double d = kf5Var.Z;
                                    if (d != null) {
                                        bundle2.putDouble(str4, d.doubleValue());
                                    }
                                }
                            }
                        }
                    }
                    try {
                        dd5Var2.i1();
                        qf5 qf5Var2 = k85Var.z0;
                        k85.f(qf5Var2);
                        qf5Var2.K1(v35Var, bundle2);
                        return;
                    } catch (RemoteException e2) {
                        e = e2;
                        bundle = bundle2;
                        t65 t65Var2 = k85Var.Y;
                        k85.h(t65Var2);
                        t65Var2.z0.c("Failed to get user properties; remote exception", str2, e);
                        qf5Var = k85Var.z0;
                        k85.f(qf5Var);
                        qf5Var.K1(v35Var, bundle);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bundle = bundle2;
                        qf5 qf5Var3 = k85Var.z0;
                        k85.f(qf5Var3);
                        qf5Var3.K1(v35Var, bundle);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
            default:
                AtomicReference atomicReference2 = (AtomicReference) this.Z;
                synchronized (atomicReference2) {
                    try {
                        try {
                            dd5Var = this.Y;
                            v55Var2 = dd5Var.Z;
                        } catch (RemoteException e3) {
                            t65 t65Var3 = ((k85) this.Y.f).Y;
                            k85.h(t65Var3);
                            t65Var3.z0.d("(legacy) Failed to get user properties; remote exception", null, this.f, e3);
                            ((AtomicReference) this.Z).set(Collections.EMPTY_LIST);
                            atomicReference = (AtomicReference) this.Z;
                        }
                        if (v55Var2 == null) {
                            t65 t65Var4 = ((k85) dd5Var.f).Y;
                            k85.h(t65Var4);
                            t65Var4.z0.d("(legacy) Failed to get user properties; not connected to service", null, this.f, this.z);
                            atomicReference2.set(Collections.EMPTY_LIST);
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            atomicReference2.set(v55Var2.D(this.f, this.z, this.X, this.A));
                        } else {
                            atomicReference2.set(v55Var2.e(null, this.f, this.z, this.X));
                        }
                        dd5Var.i1();
                        atomicReference = (AtomicReference) this.Z;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th3) {
                        ((AtomicReference) this.Z).notify();
                        throw th3;
                    }
                }
        }
    }

    public ac5(dd5 dd5Var, AtomicReference atomicReference, String str, String str2, tg5 tg5Var, boolean z) {
        this.Z = atomicReference;
        this.f = str;
        this.z = str2;
        this.A = tg5Var;
        this.X = z;
        this.Y = dd5Var;
    }
}
