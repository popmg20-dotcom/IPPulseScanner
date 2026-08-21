package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w00 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ xw4 f;

    public /* synthetic */ w00(xw4 xw4Var, int i) {
        this.b = i;
        this.f = xw4Var;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        xw4 xw4Var = this.f;
        switch (i) {
            case 0:
                WorkDatabase workDatabase = xw4Var.c;
                workDatabase.getClass();
                workDatabase.p(new fn(19, new s7(16, workDatabase, xw4Var)));
                fq3.b(xw4Var.b, workDatabase, xw4Var.e);
                break;
            default:
                WorkDatabase workDatabase2 = xw4Var.c;
                Context context = xw4Var.a;
                String str = o94.Y;
                if (Build.VERSION.SDK_INT >= 34) {
                    z32.a(context).cancelAll();
                }
                JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                ArrayList arrayListF = o94.f(context, jobScheduler);
                if (arrayListF != null && !arrayListF.isEmpty()) {
                    Iterator it = arrayListF.iterator();
                    while (it.hasNext()) {
                        o94.a(jobScheduler, ((JobInfo) it.next()).getId());
                    }
                }
                ((Number) ke0.r(workDatabase2.x().a, false, true, new q74(17))).intValue();
                fq3.b(xw4Var.b, workDatabase2, xw4Var.e);
                break;
        }
        return xl4Var;
    }
}
