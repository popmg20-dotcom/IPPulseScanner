package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yc5 implements ServiceConnection, qk, rk {
    public volatile boolean b;
    public volatile m65 f;
    public final /* synthetic */ dd5 z;

    public yc5(dd5 dd5Var) {
        this.z = dd5Var;
    }

    @Override // defpackage.rk
    public final void a(ab0 ab0Var) {
        boolean z;
        dd5 dd5Var = this.z;
        f85 f85Var = ((k85) dd5Var.f).Z;
        k85.h(f85Var);
        f85Var.a1();
        t65 t65Var = ((k85) dd5Var.f).Y;
        if (t65Var == null || !t65Var.X) {
            t65Var = null;
        }
        if (t65Var != null) {
            t65Var.H0.b(ab0Var, "Service connection failed");
        }
        synchronized (this) {
            z = false;
            this.b = false;
            this.f = null;
        }
        f85 f85Var2 = ((k85) this.z.f).Z;
        k85.h(f85Var2);
        f85Var2.e1(new tm1(21, this, ab0Var, z));
    }

    @Override // defpackage.qk
    public final void b(int i) {
        k85 k85Var = (k85) this.z.f;
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.a1();
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        t65Var.G0.a("Service connection suspended");
        f85 f85Var2 = k85Var.Z;
        k85.h(f85Var2);
        f85Var2.e1(new qz4(4, this));
    }

    @Override // defpackage.qk
    public final void c() {
        f85 f85Var = ((k85) this.z.f).Z;
        k85.h(f85Var);
        f85Var.a1();
        synchronized (this) {
            boolean z = false;
            try {
                tj4.i(this.f);
                v55 v55Var = (v55) this.f.s();
                f85 f85Var2 = ((k85) this.z.f).Z;
                k85.h(f85Var2);
                f85Var2.e1(new um1(25, this, v55Var, z));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f = null;
                this.b = false;
            }
        }
    }

    public final void d() {
        yc5 yc5Var;
        dd5 dd5Var = this.z;
        dd5Var.V0();
        Context context = ((k85) dd5Var.f).b;
        synchronized (this) {
            try {
                try {
                    if (this.b) {
                        t65 t65Var = ((k85) this.z.f).Y;
                        k85.h(t65Var);
                        t65Var.H0.a("Connection attempt already in progress");
                        return;
                    }
                    if (this.f != null && (this.f.c() || this.f.isConnected())) {
                        t65 t65Var2 = ((k85) this.z.f).Y;
                        k85.h(t65Var2);
                        t65Var2.H0.a("Already awaiting connection attempt");
                        return;
                    }
                    try {
                        try {
                            yc5Var = this;
                            try {
                                yc5Var.f = new m65(context, Looper.getMainLooper(), bg5.a(context), mp1.b, 93, yc5Var, this, null);
                                try {
                                    t65 t65Var3 = ((k85) yc5Var.z.f).Y;
                                    k85.h(t65Var3);
                                    t65Var3.H0.a("Connecting to remote service");
                                    yc5Var.b = true;
                                    tj4.i(yc5Var.f);
                                    yc5Var.f.l();
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            yc5Var = this;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        yc5Var = this;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    yc5Var = this;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f85 f85Var = ((k85) this.z.f).Z;
        k85.h(f85Var);
        f85Var.a1();
        synchronized (this) {
            boolean z = false;
            if (iBinder == null) {
                this.b = false;
                t65 t65Var = ((k85) this.z.f).Y;
                k85.h(t65Var);
                t65Var.z0.a("Service connected with null binder");
                return;
            }
            Object s55Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    s55Var = iInterfaceQueryLocalInterface instanceof v55 ? (v55) iInterfaceQueryLocalInterface : new s55(iBinder);
                    t65 t65Var2 = ((k85) this.z.f).Y;
                    k85.h(t65Var2);
                    t65Var2.H0.a("Bound to IMeasurementService interface");
                } else {
                    t65 t65Var3 = ((k85) this.z.f).Y;
                    k85.h(t65Var3);
                    t65Var3.z0.b(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                t65 t65Var4 = ((k85) this.z.f).Y;
                k85.h(t65Var4);
                t65Var4.z0.a("Service connect failed to get IMeasurementService");
            }
            if (s55Var == null) {
                this.b = false;
                try {
                    fb0 fb0VarA = fb0.a();
                    dd5 dd5Var = this.z;
                    fb0VarA.b(((k85) dd5Var.f).b, dd5Var.Y);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                f85 f85Var2 = ((k85) this.z.f).Z;
                k85.h(f85Var2);
                f85Var2.e1(new tm1(20, this, s55Var, z));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        k85 k85Var = (k85) this.z.f;
        f85 f85Var = k85Var.Z;
        k85.h(f85Var);
        f85Var.a1();
        t65 t65Var = k85Var.Y;
        k85.h(t65Var);
        t65Var.G0.a("Service disconnected");
        f85 f85Var2 = k85Var.Z;
        k85.h(f85Var2);
        f85Var2.e1(new um1(24, (Object) this, (Object) componentName, false));
    }
}
