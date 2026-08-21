package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vd5 implements ServiceConnection {
    public IBinder A;
    public final sc5 X;
    public ComponentName Y;
    public final /* synthetic */ bg5 Z;
    public final HashMap b = new HashMap();
    public int f = 2;
    public boolean z;

    public vd5(bg5 bg5Var, sc5 sc5Var) {
        this.Z = bg5Var;
        this.X = sc5Var;
    }

    public final ab0 a(String str, Executor executor) {
        try {
            Intent intentA = r15.a(this.Z.b, this.X);
            this.f = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(i35.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                bg5 bg5Var = this.Z;
                fb0 fb0Var = bg5Var.d;
                Context context = bg5Var.b;
                sc5 sc5Var = this.X;
                boolean zC = fb0Var.c(context, str, intentA, this, 4225, executor);
                this.z = zC;
                if (zC) {
                    bg5Var.c.sendMessageDelayed(bg5Var.c.obtainMessage(1, sc5Var), bg5Var.f);
                    ab0 ab0Var = ab0.X;
                    StrictMode.setVmPolicy(vmPolicy);
                    return ab0Var;
                }
                this.f = 2;
                try {
                    bg5Var.d.b(bg5Var.b, this);
                } catch (IllegalArgumentException unused) {
                }
                ab0 ab0Var2 = new ab0(16);
                StrictMode.setVmPolicy(vmPolicy);
                return ab0Var2;
            } catch (Throwable th) {
                StrictMode.setVmPolicy(vmPolicy);
                throw th;
            }
        } catch (l15 e) {
            return e.b;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        bg5 bg5Var = this.Z;
        synchronized (bg5Var.a) {
            try {
                bg5Var.c.removeMessages(1, this.X);
                this.A = iBinder;
                this.Y = componentName;
                Iterator it = this.b.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        bg5 bg5Var = this.Z;
        synchronized (bg5Var.a) {
            try {
                bg5Var.c.removeMessages(1, this.X);
                this.A = null;
                this.Y = componentName;
                Iterator it = this.b.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
