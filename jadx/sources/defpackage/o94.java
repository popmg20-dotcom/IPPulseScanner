package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o94 implements dq3 {
    public static final String Y = ue2.i("SystemJobScheduler");
    public final WorkDatabase A;
    public final na0 X;
    public final Context b;
    public final JobScheduler f;
    public final n94 z;

    public o94(Context context, WorkDatabase workDatabase, na0 na0Var) {
        JobScheduler jobSchedulerA = z32.a(context);
        n94 n94Var = new n94(context, na0Var.d);
        this.b = context;
        this.f = jobSchedulerA;
        this.z = n94Var;
        this.A = workDatabase;
        this.X = na0Var;
    }

    public static void a(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            ue2.g().f(Y, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static ArrayList b(Context context, JobScheduler jobScheduler, String str) {
        ArrayList<JobInfo> arrayListF = f(context, jobScheduler);
        if (arrayListF == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : arrayListF) {
            vw4 vw4VarG = g(jobInfo);
            if (vw4VarG != null && str.equals(vw4VarG.a)) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    public static ArrayList f(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        String str = z32.a;
        jobScheduler.getClass();
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
            allPendingJobs.getClass();
        } catch (Throwable th) {
            ue2.g().f(z32.a, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static vw4 g(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new vw4(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // defpackage.dq3
    public final boolean c() {
        return true;
    }

    @Override // defpackage.dq3
    public final void d(String str) {
        Context context = this.b;
        JobScheduler jobScheduler = this.f;
        ArrayList arrayListB = b(context, jobScheduler, str);
        if (arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        Iterator it = arrayListB.iterator();
        while (it.hasNext()) {
            a(jobScheduler, ((Integer) it.next()).intValue());
        }
        m94 m94VarU = this.A.u();
        m94VarU.getClass();
        str.getClass();
        ke0.r(m94VarU.a, false, true, new ko0(str, 11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // defpackage.dq3
    public final void e(gx4... gx4VarArr) {
        int iIntValue;
        ?? r8;
        ArrayList arrayListB;
        boolean z;
        int iIntValue2;
        WorkDatabase workDatabase = this.A;
        cx1 cx1Var = new cx1(workDatabase);
        int length = gx4VarArr.length;
        ?? r5 = 0;
        int i = 0;
        while (i < length) {
            gx4 gx4Var = gx4VarArr[i];
            workDatabase.b();
            try {
                jx4 jx4VarX = workDatabase.x();
                String str = gx4Var.a;
                gx4 gx4VarC = jx4VarX.c(str);
                String str2 = Y;
                if (gx4VarC == null) {
                    ue2.g().j(str2, "Skipping scheduling " + str + " because it's no longer in the DB");
                    workDatabase.q();
                } else if (gx4VarC.b != ww4.b) {
                    ue2.g().j(str2, "Skipping scheduling " + str + " because it is no longer enqueued");
                    workDatabase.q();
                } else {
                    vw4 vw4VarM = l72.m(gx4Var);
                    int i2 = vw4VarM.b;
                    String str3 = vw4VarM.a;
                    m94 m94VarU = workDatabase.u();
                    m94VarU.getClass();
                    str3.getClass();
                    k94 k94Var = (k94) ke0.r(m94VarU.a, true, r5, new l94(str3, i2, r5));
                    int i3 = 18;
                    WorkDatabase workDatabase2 = cx1Var.a;
                    if (k94Var != null) {
                        iIntValue = k94Var.c;
                    } else {
                        Object objP = workDatabase2.p(new fn(i3, new bx1(r5, cx1Var)));
                        objP.getClass();
                        iIntValue = ((Number) objP).intValue();
                    }
                    if (k94Var == null) {
                        k94 k94Var2 = new k94(str3, i2, iIntValue);
                        m94 m94VarU2 = workDatabase.u();
                        m94VarU2.getClass();
                        ke0.r(m94VarU2.a, false, true, new gj(21, m94VarU2, k94Var2));
                    }
                    h(gx4Var, iIntValue);
                    if (Build.VERSION.SDK_INT != 23 || (arrayListB = b(this.b, this.f, str)) == null) {
                        r8 = 0;
                    } else {
                        int iIndexOf = arrayListB.indexOf(Integer.valueOf(iIntValue));
                        if (iIndexOf >= 0) {
                            arrayListB.remove(iIndexOf);
                        }
                        if (arrayListB.isEmpty()) {
                            z = false;
                            Object objP2 = workDatabase2.p(new fn(18, new bx1(0, cx1Var)));
                            objP2.getClass();
                            iIntValue2 = ((Number) objP2).intValue();
                        } else {
                            iIntValue2 = ((Integer) arrayListB.get(0)).intValue();
                            z = false;
                        }
                        h(gx4Var, iIntValue2);
                        r8 = z;
                    }
                    workDatabase.q();
                    i++;
                    r5 = r8;
                }
                workDatabase.m();
                r8 = r5;
                i++;
                r5 = r8;
            } finally {
                workDatabase.m();
            }
        }
    }

    public final void h(gx4 gx4Var, int i) {
        List<JobInfo> allPendingJobs;
        String str;
        JobInfo jobInfoA = this.z.a(gx4Var, i);
        ue2 ue2VarG = ue2.g();
        StringBuilder sb = new StringBuilder("Scheduling work ID ");
        String str2 = gx4Var.a;
        sb.append(str2);
        sb.append("Job ID ");
        sb.append(i);
        String string = sb.toString();
        String str3 = Y;
        ue2VarG.a(str3, string);
        try {
            if (this.f.schedule(jobInfoA) == 0) {
                ue2.g().j(str3, "Unable to schedule work ID " + str2);
                if (gx4Var.q && gx4Var.r == ww2.b) {
                    gx4Var.q = false;
                    ue2.g().a(str3, "Scheduling a non-expedited job (work ID " + str2 + ")");
                    h(gx4Var, i);
                }
            }
        } catch (IllegalStateException e) {
            String str4 = z32.a;
            Context context = this.b;
            context.getClass();
            int i2 = Build.VERSION.SDK_INT;
            int i3 = i2 >= 31 ? 150 : 100;
            int size = ((List) ke0.r(this.A.x().a, true, false, new q74(10))).size();
            String strJ0 = "<faulty JobScheduler failed to getPendingJobs>";
            if (i2 >= 34) {
                JobScheduler jobSchedulerA = z32.a(context);
                String str5 = null;
                try {
                    allPendingJobs = jobSchedulerA.getAllPendingJobs();
                    allPendingJobs.getClass();
                } catch (Throwable th) {
                    ue2.g().f(z32.a, "getAllPendingJobs() is not reliable on this device.", th);
                    allPendingJobs = null;
                }
                if (allPendingJobs != null) {
                    ArrayList arrayListF = f(context, jobSchedulerA);
                    int size2 = arrayListF != null ? allPendingJobs.size() - arrayListF.size() : 0;
                    if (size2 == 0) {
                        str = null;
                    } else {
                        str = size2 + " of which are not owned by WorkManager";
                    }
                    Object systemService = context.getSystemService("jobscheduler");
                    systemService.getClass();
                    ArrayList arrayListF2 = f(context, (JobScheduler) systemService);
                    int size3 = arrayListF2 != null ? arrayListF2.size() : 0;
                    if (size3 != 0) {
                        str5 = size3 + " from WorkManager in the default namespace";
                    }
                    strJ0 = d70.j0(qe.l0(new String[]{allPendingJobs.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", str, str5}), ",\n", null, null, null, 62);
                }
            } else {
                ArrayList arrayListF3 = f(context, z32.a(context));
                if (arrayListF3 != null) {
                    strJ0 = arrayListF3.size() + " jobs from WorkManager";
                }
            }
            StringBuilder sb2 = new StringBuilder("JobScheduler ");
            sb2.append(i3);
            sb2.append(" job limit exceeded.\nIn JobScheduler there are ");
            sb2.append(strJ0);
            sb2.append(".\nThere are ");
            sb2.append(size);
            sb2.append(" jobs tracked by WorkManager's database;\nthe Configuration limit is ");
            String strP = ha0.p(sb2, this.X.f, '.');
            ue2.g().e(str3, strP);
            e04.l(strP, e);
        } catch (Throwable th2) {
            ue2.g().f(str3, "Unable to schedule " + gx4Var, th2);
        }
    }
}
