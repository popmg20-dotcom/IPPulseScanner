package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.PersistableBundle;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nb5 extends u55 {
    public JobScheduler Y;

    @Override // defpackage.u55
    public final boolean Y0() {
        return true;
    }

    public final void Z0(long j) {
        k85 k85Var = (k85) this.f;
        W0();
        V0();
        JobScheduler jobScheduler = this.Y;
        if (jobScheduler != null && jobScheduler.getPendingJob("measurement-client".concat(String.valueOf(k85Var.b.getPackageName())).hashCode()) != null) {
            t65 t65Var = k85Var.Y;
            k85.h(t65Var);
            t65Var.H0.a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        int iA1 = a1();
        if (iA1 != 2) {
            t65 t65Var2 = k85Var.Y;
            k85.h(t65Var2);
            t65Var2.H0.b(qe4.t(iA1), "[sgtm] Not eligible for Scion upload");
            return;
        }
        t65 t65Var3 = k85Var.Y;
        k85.h(t65Var3);
        t65Var3.H0.b(Long.valueOf(j), "[sgtm] Scheduling Scion upload, millis");
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder("measurement-client".concat(String.valueOf(k85Var.b.getPackageName())).hashCode(), new ComponentName(k85Var.b, "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build();
        JobScheduler jobScheduler2 = this.Y;
        tj4.i(jobScheduler2);
        int iSchedule = jobScheduler2.schedule(jobInfoBuild);
        t65 t65Var4 = k85Var.Y;
        k85.h(t65Var4);
        t65Var4.H0.b(iSchedule == 1 ? "SUCCESS" : "FAILURE", "[sgtm] Scion upload job scheduled with result");
    }

    public final int a1() {
        k85 k85Var = (k85) this.f;
        W0();
        V0();
        if (this.Y == null) {
            return 7;
        }
        Boolean boolH1 = k85Var.A.h1("google_analytics_sgtm_upload_enabled");
        if (!(boolH1 == null ? false : boolH1.booleanValue())) {
            return 8;
        }
        if (k85Var.l().D0 < 119000) {
            return 6;
        }
        if (!qf5.p1(k85Var.b, "com.google.android.gms.measurement.AppMeasurementJobService")) {
            return 3;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return !k85Var.j().c1() ? 5 : 2;
        }
        return 4;
    }
}
