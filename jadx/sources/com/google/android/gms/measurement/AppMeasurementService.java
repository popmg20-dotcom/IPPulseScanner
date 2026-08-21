package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import defpackage.bt4;
import defpackage.ff5;
import defpackage.hd5;
import defpackage.i95;
import defpackage.k85;
import defpackage.rz4;
import defpackage.t65;
import defpackage.um1;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements hd5 {
    public rz4 b;

    @Override // defpackage.hd5
    public final boolean a(int i) {
        return stopSelfResult(i);
    }

    @Override // defpackage.hd5
    public final void b(Intent intent) {
        SparseArray sparseArray = bt4.a;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return;
        }
        SparseArray sparseArray2 = bt4.a;
        synchronized (sparseArray2) {
            try {
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) sparseArray2.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sparseArray2.remove(intExtra);
                } else {
                    a1.n("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hd5
    public final void c(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    public final rz4 d() {
        rz4 rz4Var = this.b;
        if (rz4Var != null) {
            return rz4Var;
        }
        rz4 rz4Var2 = new rz4(6, this);
        this.b = rz4Var2;
        return rz4Var2;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        rz4 rz4VarD = d();
        if (intent == null) {
            a1.d("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new i95(ff5.y((Service) rz4VarD.f));
        }
        a1.n("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.v("FA", ((Service) d().f).getClass().getSimpleName().concat(" is starting up."));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.v("FA", ((Service) d().f).getClass().getSimpleName().concat(" is shutting down."));
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        d();
        if (intent == null) {
            a1.d("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, final int i2) {
        final rz4 rz4VarD = d();
        if (intent == null) {
            a1.n("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Service service = (Service) rz4VarD.f;
        final t65 t65Var = k85.m(service, null, null).Y;
        k85.h(t65Var);
        String action = intent.getAction();
        t65Var.H0.c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        Runnable runnable = new Runnable() { // from class: kd5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                Service service2 = (Service) rz4VarD.f;
                hd5 hd5Var = (hd5) service2;
                int i3 = i2;
                if (hd5Var.a(i3)) {
                    t65Var.H0.b(Integer.valueOf(i3), "Local AppMeasurementService processed last upload request. StartId");
                    t65 t65Var2 = k85.m(service2, null, null).Y;
                    k85.h(t65Var2);
                    t65Var2.H0.a("Completed wakeful intent.");
                    hd5Var.b(intent);
                }
            }
        };
        ff5 ff5VarY = ff5.y(service);
        ff5VarY.C().e1(new um1(26, rz4VarD, ff5VarY, runnable));
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        d();
        if (intent == null) {
            a1.d("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }
}
