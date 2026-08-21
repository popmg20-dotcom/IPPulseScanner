package defpackage;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mi1 implements Runnable {
    public static final String X = ue2.i("ForceStopRunnable");
    public static final long Y = 315360000000L;
    public int A = 0;
    public final Context b;
    public final xw4 f;
    public final cx1 z;

    public mi1(Context context, xw4 xw4Var) {
        this.b = context.getApplicationContext();
        this.f = xw4Var;
        this.z = xw4Var.g;
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
        long jCurrentTimeMillis = System.currentTimeMillis() + Y;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        boolean z;
        int i;
        PendingIntent broadcast;
        cx1 cx1Var = this.z;
        xw4 xw4Var = this.f;
        na0 na0Var = xw4Var.b;
        cx1 cx1Var2 = xw4Var.g;
        WorkDatabase workDatabase = xw4Var.c;
        String str = o94.Y;
        Context context = this.b;
        JobScheduler jobSchedulerA = z32.a(context);
        ArrayList<JobInfo> arrayListF = o94.f(context, jobSchedulerA);
        List list = (List) ke0.r(workDatabase.u().a, true, false, new q74(3));
        HashSet hashSet = new HashSet(arrayListF != null ? arrayListF.size() : 0);
        if (arrayListF != null && !arrayListF.isEmpty()) {
            for (JobInfo jobInfo : arrayListF) {
                vw4 vw4VarG = o94.g(jobInfo);
                if (vw4VarG != null) {
                    hashSet.add(vw4VarG.a);
                } else {
                    o94.a(jobSchedulerA, jobInfo.getId());
                }
            }
        }
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!hashSet.contains((String) it.next())) {
                    ue2.g().a(o94.Y, "Reconciling jobs");
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            workDatabase.b();
            try {
                jx4 jx4VarX = workDatabase.x();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    jx4VarX.e(-1L, (String) it2.next());
                }
                workDatabase.q();
                workDatabase.m();
            } catch (Throwable th) {
                throw th;
            }
        }
        jx4 jx4VarX2 = workDatabase.x();
        bx4 bx4VarW = workDatabase.w();
        workDatabase.b();
        try {
            List<gx4> list2 = (List) ke0.r(jx4VarX2.a, true, false, new q74(11));
            boolean z2 = (list2 == null || list2.isEmpty()) ? false : true;
            if (z2) {
                for (gx4 gx4Var : list2) {
                    ww4 ww4Var = ww4.b;
                    String str2 = gx4Var.a;
                    jx4VarX2.h(ww4Var, str2);
                    jx4VarX2.i(-512, str2);
                    jx4VarX2.e(-1L, str2);
                }
            }
            ke0.r(bx4VarW.a, false, true, new q74(9));
            workDatabase.q();
            workDatabase.m();
            boolean z3 = z2 || z;
            Long lA = cx1Var2.a.t().a("reschedule_needed");
            int i2 = 12;
            String str3 = X;
            if (lA != null && lA.longValue() == 1) {
                ue2.g().a(str3, "Rescheduling Workers.");
                xw4Var.e();
                cx1Var2.getClass();
                z23 z23Var = new z23("reschedule_needed", 0L);
                a33 a33VarT = cx1Var2.a.t();
                ke0.r(a33VarT.a, false, true, new gj(i2, a33VarT, z23Var));
                return;
            }
            try {
                i = Build.VERSION.SDK_INT;
                int i3 = i >= 31 ? 570425344 : 536870912;
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
                intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
                broadcast = PendingIntent.getBroadcast(context, -1, intent, i3);
            } catch (IllegalArgumentException e) {
                e = e;
                if (ue2.g().b <= 5) {
                    a1.o(str3, "Ignoring exception", e);
                }
            } catch (SecurityException e2) {
                e = e2;
                if (ue2.g().b <= 5) {
                }
            }
            if (i >= 30) {
                if (broadcast != null) {
                    broadcast.cancel();
                }
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) context.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    Long lA2 = cx1Var.a.t().a("last_force_stop_ms");
                    long jLongValue = lA2 != null ? lA2.longValue() : 0L;
                    for (int i4 = 0; i4 < historicalProcessExitReasons.size(); i4++) {
                        ApplicationExitInfo applicationExitInfoA = a71.a(historicalProcessExitReasons.get(i4));
                        if (applicationExitInfoA.getReason() == 10 && applicationExitInfoA.getTimestamp() >= jLongValue) {
                            ue2.g().a(str3, "Application was force-stopped, rescheduling.");
                            xw4Var.e();
                            d84 d84Var = na0Var.d;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            cx1Var.getClass();
                            z23 z23Var2 = new z23("last_force_stop_ms", Long.valueOf(jCurrentTimeMillis));
                            a33 a33VarT2 = cx1Var.a.t();
                            ke0.r(a33VarT2.a, false, true, new gj(i2, a33VarT2, z23Var2));
                            return;
                        }
                    }
                }
                if (z3) {
                    return;
                }
                ue2.g().a(str3, "Found unfinished work, scheduling it.");
                fq3.b(na0Var, workDatabase, xw4Var.e);
                return;
            }
            if (broadcast == null) {
                c(context);
                ue2.g().a(str3, "Application was force-stopped, rescheduling.");
                xw4Var.e();
                d84 d84Var2 = na0Var.d;
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                cx1Var.getClass();
                z23 z23Var22 = new z23("last_force_stop_ms", Long.valueOf(jCurrentTimeMillis2));
                a33 a33VarT22 = cx1Var.a.t();
                ke0.r(a33VarT22.a, false, true, new gj(i2, a33VarT22, z23Var22));
                return;
            }
            if (z3) {
            }
        } finally {
            workDatabase.m();
        }
    }

    public final boolean b() {
        na0 na0Var = this.f.b;
        na0Var.getClass();
        boolean zIsEmpty = TextUtils.isEmpty(null);
        String str = X;
        if (zIsEmpty) {
            ue2.g().a(str, "The default process name was not specified.");
            return true;
        }
        boolean zA = m53.a(this.b, na0Var);
        ue2.g().a(str, "Is default app process = " + zA);
        return zA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.b;
        String str = X;
        xw4 xw4Var = this.f;
        na0 na0Var = xw4Var.b;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                try {
                    ek0.y(context);
                    ue2.g().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteFullException | SQLiteTableLockedException e) {
                        int i = this.A + 1;
                        this.A = i;
                        if (i >= 3) {
                            String str2 = p95.v(context) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            ue2.g().f(str, str2, e);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e);
                            na0Var.getClass();
                            throw illegalStateException;
                        }
                        ue2.g().d(str, "Retrying after " + (((long) i) * 300), e);
                        try {
                            Thread.sleep(((long) this.A) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e2) {
                    ue2.g().e(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e2);
                    na0Var.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            xw4Var.d();
        }
    }
}
