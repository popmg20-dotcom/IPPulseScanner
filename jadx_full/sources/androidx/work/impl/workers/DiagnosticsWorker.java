package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import defpackage.ax4;
import defpackage.cu0;
import defpackage.d84;
import defpackage.di0;
import defpackage.jx4;
import defpackage.ke0;
import defpackage.lx4;
import defpackage.m94;
import defpackage.pl3;
import defpackage.q74;
import defpackage.r81;
import defpackage.rc2;
import defpackage.ue2;
import defpackage.xw4;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @Override // androidx.work.Worker
    public final rc2 c() {
        xw4 xw4VarC = xw4.c(this.a);
        WorkDatabase workDatabase = xw4VarC.c;
        workDatabase.getClass();
        jx4 jx4VarX = workDatabase.x();
        ax4 ax4VarV = workDatabase.v();
        lx4 lx4VarY = workDatabase.y();
        m94 m94VarU = workDatabase.u();
        d84 d84Var = xw4VarC.b.d;
        List list = (List) ke0.r(jx4VarX.a, true, false, new r81(System.currentTimeMillis() - 86400000, 2));
        pl3 pl3Var = jx4VarX.a;
        List list2 = (List) ke0.r(pl3Var, true, false, new q74(11));
        List list3 = (List) ke0.r(pl3Var, true, false, new q74(16));
        if (!list.isEmpty()) {
            ue2 ue2VarG = ue2.g();
            String str = cu0.a;
            ue2VarG.h(str, "Recently completed work:\n\n");
            ue2.g().h(str, cu0.a(ax4VarV, lx4VarY, m94VarU, list));
        }
        if (!list2.isEmpty()) {
            ue2 ue2VarG2 = ue2.g();
            String str2 = cu0.a;
            ue2VarG2.h(str2, "Running work:\n\n");
            ue2.g().h(str2, cu0.a(ax4VarV, lx4VarY, m94VarU, list2));
        }
        if (!list3.isEmpty()) {
            ue2 ue2VarG3 = ue2.g();
            String str3 = cu0.a;
            ue2VarG3.h(str3, "Enqueued work:\n\n");
            ue2.g().h(str3, cu0.a(ax4VarV, lx4VarY, m94VarU, list3));
        }
        return new rc2(di0.b);
    }
}
