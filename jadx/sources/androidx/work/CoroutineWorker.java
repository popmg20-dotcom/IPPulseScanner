package androidx.work;

import android.content.Context;
import defpackage.cf0;
import defpackage.fx3;
import defpackage.ge0;
import defpackage.je;
import defpackage.n12;
import defpackage.pf0;
import defpackage.qf0;
import defpackage.tc2;
import defpackage.tj4;
import defpackage.x32;
import defpackage.yv;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineWorker extends tc2 {
    public final WorkerParameters e;
    public final pf0 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.e = workerParameters;
        this.f = pf0.z;
    }

    @Override // defpackage.tc2
    public final yv a() {
        x32 x32VarB = je.b();
        pf0 pf0Var = this.f;
        pf0Var.getClass();
        return fx3.r(tj4.W(pf0Var, x32VarB), new qf0(this, null, 0));
    }

    @Override // defpackage.tc2
    public final yv b() {
        pf0 pf0Var = pf0.z;
        cf0 cf0Var = this.f;
        if (n12.c(cf0Var, pf0Var)) {
            cf0Var = this.e.d;
        }
        cf0Var.getClass();
        return fx3.r(cf0Var.X(je.b()), new qf0(this, null, 1));
    }

    public abstract Object c(ge0 ge0Var);
}
