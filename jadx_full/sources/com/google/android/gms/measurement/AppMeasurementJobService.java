package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;
import defpackage.b55;
import defpackage.d84;
import defpackage.ff5;
import defpackage.g33;
import defpackage.hd5;
import defpackage.l45;
import defpackage.rz4;
import defpackage.t65;
import defpackage.tj4;
import defpackage.tm1;
import defpackage.um1;
import io.sentry.android.core.a1;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements hd5 {
    public rz4 b;

    @Override // defpackage.hd5
    public final boolean a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.hd5
    public final void c(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        JobParameters jobParameters2;
        rz4 rz4VarD = d();
        Service service = (Service) rz4VarD.f;
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            tj4.i(string);
            ff5 ff5VarY = ff5.y(service);
            t65 t65VarN = ff5VarY.n();
            d84 d84Var = ff5VarY.C0.z;
            t65VarN.H0.b(string, "Local AppMeasurementJobService called. action");
            jobParameters2 = jobParameters;
            ff5VarY.C().e1(new um1(26, rz4VarD, ff5VarY, new g33(rz4VarD, t65VarN, jobParameters2, 13, false)));
        } else {
            jobParameters2 = jobParameters;
        }
        if (Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            tj4.i(string);
            b55 b55VarC = b55.c(service, null);
            tm1 tm1Var = new tm1(22, rz4VarD, jobParameters2);
            b55VarC.getClass();
            b55VarC.a(new l45(b55VarC, tm1Var, 1));
        }
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
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

    @Override // defpackage.hd5
    public final void b(Intent intent) {
    }
}
