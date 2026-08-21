package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.Looper;
import android.os.PersistableBundle;
import defpackage.e04;
import defpackage.e24;
import defpackage.ga5;
import defpackage.h24;
import defpackage.ha0;
import defpackage.n53;
import defpackage.p84;
import defpackage.u9;
import defpackage.ue2;
import defpackage.ut0;
import defpackage.vw4;
import defpackage.w61;
import defpackage.wn1;
import defpackage.xe;
import defpackage.xw4;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SystemJobService extends JobService implements w61 {
    public static final String X = ue2.i("SystemJobService");
    public e24 A;
    public xw4 b;
    public final HashMap f = new HashMap();
    public final wn1 z = new wn1(20);

    public static void a(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        xe.q(ha0.o("Cannot invoke ", str, " on a background thread"));
    }

    public static vw4 c(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new vw4(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // defpackage.w61
    public final void b(vw4 vw4Var, boolean z) {
        a("onExecuted");
        ue2.g().a(X, vw4Var.a + " executed on JobScheduler");
        JobParameters jobParameters = (JobParameters) this.f.remove(vw4Var);
        this.z.D(vw4Var);
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            xw4 xw4VarC = xw4.c(getApplicationContext());
            this.b = xw4VarC;
            n53 n53Var = xw4VarC.f;
            this.A = new e24(n53Var, xw4VarC.d);
            n53Var.a(this);
        } catch (IllegalStateException e) {
            if (Application.class.equals(getApplication().getClass())) {
                ue2.g().j(X, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
            } else {
                e04.l("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
            }
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        xw4 xw4Var = this.b;
        if (xw4Var != null) {
            xw4Var.f.g(this);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        p84 p84Var;
        a("onStartJob");
        xw4 xw4Var = this.b;
        String str = X;
        if (xw4Var == null) {
            ue2.g().a(str, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        vw4 vw4VarC = c(jobParameters);
        if (vw4VarC == null) {
            ue2.g().e(str, "WorkSpec id not found!");
            return false;
        }
        HashMap map = this.f;
        if (map.containsKey(vw4VarC)) {
            ue2.g().a(str, "Job is already being executed by SystemJobService: " + vw4VarC);
            return false;
        }
        ue2.g().a(str, "onStartJob for " + vw4VarC);
        map.put(vw4VarC, jobParameters);
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            p84Var = new p84(4);
            if (ga5.o(jobParameters) != null) {
                Arrays.asList(ga5.o(jobParameters));
            }
            if (ga5.n(jobParameters) != null) {
                Arrays.asList(ga5.n(jobParameters));
            }
            if (i >= 28) {
                u9.j(jobParameters);
            }
        } else {
            p84Var = null;
        }
        this.A.E(this.z.F(vw4VarC), p84Var);
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        a("onStopJob");
        if (this.b == null) {
            ue2.g().a(X, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        vw4 vw4VarC = c(jobParameters);
        if (vw4VarC == null) {
            ue2.g().e(X, "WorkSpec id not found!");
            return false;
        }
        ue2.g().a(X, "onStopJob for " + vw4VarC);
        this.f.remove(vw4VarC);
        h24 h24VarD = this.z.D(vw4VarC);
        if (h24VarD != null) {
            int iC = Build.VERSION.SDK_INT >= 31 ? ut0.c(jobParameters) : -512;
            e24 e24Var = this.A;
            e24Var.getClass();
            e24Var.F(h24VarD, iC);
        }
        n53 n53Var = this.b.f;
        String str = vw4VarC.a;
        synchronized (n53Var.k) {
            zContains = n53Var.i.contains(str);
        }
        return !zContains;
    }
}
