package defpackage;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.background.systemjob.SystemJobService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n94 {
    public static final String b = ue2.i("SystemJobInfoConverter");
    public final ComponentName a;

    public n94(Context context, d84 d84Var) {
        this.a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
    
        if (r2 < 26) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
    
        if (r2 >= 24) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JobInfo a(gx4 gx4Var, int i) {
        int i2;
        String str;
        mc0 mc0Var = gx4Var.j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", gx4Var.a);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", gx4Var.t);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", gx4Var.c());
        JobInfo.Builder requiresCharging = new JobInfo.Builder(i, this.a).setRequiresCharging(mc0Var.c);
        boolean z = mc0Var.d;
        JobInfo.Builder extras = requiresCharging.setRequiresDeviceIdle(z).setExtras(persistableBundle);
        NetworkRequest networkRequestA = mc0Var.a();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28 || networkRequestA == null) {
            pr2 pr2Var = mc0Var.a;
            if (i3 < 30 || pr2Var != pr2.Y) {
                int iOrdinal = pr2Var.ordinal();
                if (iOrdinal == 0) {
                    i2 = 0;
                } else if (iOrdinal != 1) {
                    i2 = 2;
                    if (iOrdinal != 2) {
                        i2 = 3;
                        if (iOrdinal != 3) {
                            i2 = 4;
                            if (iOrdinal == 4) {
                            }
                            ue2.g().a(b, "API version too low. Cannot convert network type value " + pr2Var);
                            i2 = 1;
                        }
                    }
                } else {
                    i2 = 1;
                }
                extras.setRequiredNetworkType(i2);
            } else {
                extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
            }
        } else {
            extras.getClass();
            extras.setRequiredNetwork(networkRequestA);
        }
        if (!z) {
            extras.setBackoffCriteria(gx4Var.m, gx4Var.l == ei.f ? 0 : 1);
        }
        long jMax = Math.max(gx4Var.a() - System.currentTimeMillis(), 0L);
        if (i3 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!gx4Var.q) {
            extras.setImportantWhileForeground(true);
        }
        if (i3 >= 24 && mc0Var.b()) {
            for (lc0 lc0Var : mc0Var.i) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(lc0Var.a, lc0Var.b ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(mc0Var.g);
            extras.setTriggerContentMaxDelay(mc0Var.h);
        }
        extras.setPersisted(false);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            extras.setRequiresBatteryNotLow(mc0Var.e);
            extras.setRequiresStorageNotLow(mc0Var.f);
        }
        Object[] objArr = gx4Var.k > 0;
        boolean z2 = jMax > 0;
        if (i4 >= 31 && gx4Var.q && objArr == false && !z2) {
            extras.setExpedited(true);
        }
        if (i4 >= 35 && (str = gx4Var.x) != null) {
            extras.setTraceTag(str);
        }
        return extras.build();
    }
}
