package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qj3 extends fm2 {
    public final /* synthetic */ int c = 1;
    public final Context d;

    public qj3(Context context) {
        super(9, 10);
        this.d = context;
    }

    @Override // defpackage.fm2
    public final void a(gl1 gl1Var) {
        int i = this.c;
        Context context = this.d;
        gl1Var.getClass();
        switch (i) {
            case 0:
                if (this.b >= 10) {
                    gl1Var.F(new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    context.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
            default:
                gl1Var.C("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j2 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    gl1Var.g();
                    try {
                        gl1Var.F(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j)});
                        gl1Var.F(new Object[]{"reschedule_needed", Long.valueOf(j2)});
                        sharedPreferences.edit().clear().apply();
                        gl1Var.M();
                    } finally {
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i2 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i3 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    gl1Var.g();
                    try {
                        gl1Var.F(new Object[]{"next_job_scheduler_id", Integer.valueOf(i2)});
                        gl1Var.F(new Object[]{"next_alarm_manager_id", Integer.valueOf(i3)});
                        sharedPreferences2.edit().clear().apply();
                        gl1Var.M();
                        return;
                    } finally {
                    }
                }
                return;
        }
    }

    public qj3(Context context, int i, int i2) {
        super(i, i2);
        this.d = context;
    }
}
