package defpackage;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Scope;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class tk {
    public static final ic1[] O0 = new ic1[0];
    public final bg5 A;
    public sk A0;
    public IInterface B0;
    public r45 D0;
    public final qk F0;
    public final rk G0;
    public final int H0;
    public final String I0;
    public volatile String J0;
    public final mp1 X;
    public final p25 Y;
    public h6 f;
    public final Context z;
    public a15 z0;
    public volatile String b = null;
    public final Object Z = new Object();
    public final Object y0 = new Object();
    public final ArrayList C0 = new ArrayList();
    public int E0 = 1;
    public ab0 K0 = null;
    public boolean L0 = false;
    public volatile e95 M0 = null;
    public final AtomicInteger N0 = new AtomicInteger(0);

    public tk(Context context, Looper looper, bg5 bg5Var, mp1 mp1Var, int i, qk qkVar, rk rkVar, String str) {
        tj4.j(context, "Context must not be null");
        this.z = context;
        tj4.j(looper, "Looper must not be null");
        tj4.j(bg5Var, "Supervisor must not be null");
        this.A = bg5Var;
        tj4.j(mp1Var, "API availability must not be null");
        this.X = mp1Var;
        this.Y = new p25(this, looper);
        this.H0 = i;
        this.F0 = qkVar;
        this.G0 = rkVar;
        this.I0 = str;
    }

    public final void b(String str) {
        this.b = str;
        n();
    }

    public final boolean c() {
        boolean z;
        synchronized (this.Z) {
            int i = this.E0;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public final void d() {
        if (!isConnected() || this.f == null) {
            zo2.w("Failed to connect when checking package");
        }
    }

    public final void e(sk skVar) {
        this.A0 = skVar;
        y(2, null);
    }

    public final void f(rz4 rz4Var) {
        ((sz4) rz4Var.f).n.m.post(new qz4(0, rz4Var));
    }

    public abstract int g();

    public final ic1[] h() {
        e95 e95Var = this.M0;
        if (e95Var == null) {
            return null;
        }
        return e95Var.f;
    }

    public final String i() {
        return this.b;
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.Z) {
            z = this.E0 == 4;
        }
        return z;
    }

    public boolean j() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(lv1 lv1Var, Set set) {
        Bundle bundleQ = q();
        String str = this.J0;
        int i = this.H0;
        int i2 = mp1.a;
        Scope[] scopeArr = yo1.F0;
        Bundle bundle = new Bundle();
        ic1[] ic1VarArr = yo1.G0;
        yo1 yo1Var = new yo1(6, i, i2, null, null, scopeArr, bundle, null, ic1VarArr, ic1VarArr, true, 0, false, str);
        yo1Var.A = this.z.getPackageName();
        yo1Var.Z = bundleQ;
        if (set != null) {
            yo1Var.Y = (Scope[]) set.toArray(new Scope[0]);
        }
        if (j()) {
            Account accountO = o();
            if (accountO == null) {
                accountO = new Account("<<default account>>", "com.google");
            }
            yo1Var.y0 = accountO;
            if (lv1Var != 0) {
                yo1Var.X = ((mz4) lv1Var).d;
            }
        }
        yo1Var.z0 = O0;
        yo1Var.A0 = p();
        try {
            synchronized (this.y0) {
                try {
                    a15 a15Var = this.z0;
                    if (a15Var != null) {
                        a15Var.a(new z35(this, this.N0.get()), yo1Var);
                    } else {
                        a1.n("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e) {
            a1.o("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i3 = this.N0.get();
            p25 p25Var = this.Y;
            p25Var.sendMessage(p25Var.obtainMessage(6, i3, 3));
        } catch (RemoteException e2) {
            e = e2;
            a1.o("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i4 = this.N0.get();
            x45 x45Var = new x45(this, 8, null, null);
            p25 p25Var2 = this.Y;
            p25Var2.sendMessage(p25Var2.obtainMessage(1, i4, -1, x45Var));
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            a1.o("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i42 = this.N0.get();
            x45 x45Var2 = new x45(this, 8, null, null);
            p25 p25Var22 = this.Y;
            p25Var22.sendMessage(p25Var22.obtainMessage(1, i42, -1, x45Var2));
        }
    }

    public final void l() {
        int iB = this.X.b(this.z, g());
        if (iB == 0) {
            e(new cp1(this));
            return;
        }
        y(1, null);
        this.A0 = new cp1(this);
        int i = this.N0.get();
        p25 p25Var = this.Y;
        p25Var.sendMessage(p25Var.obtainMessage(3, i, iB, null));
    }

    public abstract IInterface m(IBinder iBinder);

    public final void n() {
        this.N0.incrementAndGet();
        ArrayList arrayList = this.C0;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((u05) arrayList.get(i)).d();
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.y0) {
            this.z0 = null;
        }
        y(1, null);
    }

    public Account o() {
        return null;
    }

    public ic1[] p() {
        return O0;
    }

    public Bundle q() {
        return new Bundle();
    }

    public Set r() {
        return Collections.EMPTY_SET;
    }

    public final IInterface s() {
        IInterface iInterface;
        synchronized (this.Z) {
            try {
                if (this.E0 == 5) {
                    throw new DeadObjectException();
                }
                if (!isConnected()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.B0;
                tj4.j(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String t();

    public abstract String u();

    public boolean v() {
        return g() >= 211700000;
    }

    public final /* synthetic */ boolean w(int i, int i2, IInterface iInterface) {
        synchronized (this.Z) {
            try {
                if (this.E0 != i) {
                    return false;
                }
                y(i2, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void x() {
        int i;
        int i2;
        synchronized (this.Z) {
            i = this.E0;
        }
        if (i == 3) {
            this.L0 = true;
            i2 = 5;
        } else {
            i2 = 4;
        }
        p25 p25Var = this.Y;
        p25Var.sendMessage(p25Var.obtainMessage(i2, this.N0.get(), 16));
    }

    public final void y(int i, IInterface iInterface) {
        h6 h6Var;
        tj4.d((i == 4) == (iInterface != null));
        synchronized (this.Z) {
            try {
                this.E0 = i;
                this.B0 = iInterface;
                Bundle bundle = null;
                if (i == 1) {
                    r45 r45Var = this.D0;
                    if (r45Var != null) {
                        bg5 bg5Var = this.A;
                        String str = this.f.c;
                        tj4.i(str);
                        this.f.getClass();
                        if (this.I0 == null) {
                            this.z.getClass();
                        }
                        bg5Var.d(str, r45Var, this.f.b);
                        this.D0 = null;
                    }
                } else if (i == 2 || i == 3) {
                    r45 r45Var2 = this.D0;
                    if (r45Var2 != null && (h6Var = this.f) != null) {
                        String str2 = h6Var.c;
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 70 + "com.google.android.gms".length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str2);
                        sb.append(" on com.google.android.gms");
                        a1.d("GmsClient", sb.toString());
                        bg5 bg5Var2 = this.A;
                        String str3 = this.f.c;
                        tj4.i(str3);
                        this.f.getClass();
                        if (this.I0 == null) {
                            this.z.getClass();
                        }
                        bg5Var2.d(str3, r45Var2, this.f.b);
                        this.N0.incrementAndGet();
                    }
                    r45 r45Var3 = new r45(this, this.N0.get());
                    this.D0 = r45Var3;
                    String strU = u();
                    boolean zV = v();
                    this.f = new h6(strU, zV, 3);
                    if (zV && g() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f.c)));
                    }
                    bg5 bg5Var3 = this.A;
                    String str4 = this.f.c;
                    tj4.i(str4);
                    this.f.getClass();
                    String name = this.I0;
                    if (name == null) {
                        name = this.z.getClass().getName();
                    }
                    ab0 ab0VarC = bg5Var3.c(new sc5(str4, this.f.b), r45Var3, name, null);
                    if (!(ab0VarC.f == 0)) {
                        String str5 = this.f.c;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 34 + "com.google.android.gms".length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str5);
                        sb2.append(" on com.google.android.gms");
                        a1.n("GmsClient", sb2.toString());
                        int i2 = ab0VarC.f;
                        if (i2 == -1) {
                            i2 = 16;
                        }
                        if (ab0VarC.z != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", ab0VarC.z);
                        }
                        int i3 = this.N0.get();
                        t55 t55Var = new t55(this, i2, bundle);
                        p25 p25Var = this.Y;
                        p25Var.sendMessage(p25Var.obtainMessage(7, i3, -1, t55Var));
                    }
                } else if (i == 4) {
                    tj4.i(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }
}
