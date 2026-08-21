package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
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
import androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mi1.a():void");
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
