package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ge5 extends pe5 {
    public final AlarmManager Z;
    public td5 y0;
    public Integer z0;

    public ge5(ff5 ff5Var) {
        super(ff5Var);
        this.Z = (AlarmManager) ((k85) this.f).b.getSystemService("alarm");
    }

    @Override // defpackage.pe5
    public final void Y0() {
        AlarmManager alarmManager = this.Z;
        if (alarmManager != null) {
            alarmManager.cancel(c1());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            a1();
        }
    }

    public final void Z0() {
        W0();
        t65 t65Var = ((k85) this.f).Y;
        k85.h(t65Var);
        t65Var.H0.a("Unscheduling upload");
        AlarmManager alarmManager = this.Z;
        if (alarmManager != null) {
            alarmManager.cancel(c1());
        }
        td5 td5Var = this.y0;
        if (td5Var == null) {
            td5Var = new td5(this, this.X.C0, 1);
            this.y0 = td5Var;
        }
        td5Var.c();
        if (Build.VERSION.SDK_INT >= 24) {
            a1();
        }
    }

    public final void a1() {
        JobScheduler jobScheduler = (JobScheduler) ((k85) this.f).b.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(b1());
        }
    }

    public final int b1() {
        Integer numValueOf = this.z0;
        if (numValueOf == null) {
            numValueOf = Integer.valueOf("measurement".concat(String.valueOf(((k85) this.f).b.getPackageName())).hashCode());
            this.z0 = numValueOf;
        }
        return numValueOf.intValue();
    }

    public final PendingIntent c1() {
        Context context = ((k85) this.f).b;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), o35.a);
    }
}
