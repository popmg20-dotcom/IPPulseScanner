package androidx.work;

import android.content.Context;
import defpackage.ed;
import defpackage.fn;
import defpackage.fx3;
import defpackage.rc2;
import defpackage.rw4;
import defpackage.tc2;
import defpackage.yv;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends tc2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @Override // defpackage.tc2
    public final yv a() {
        ExecutorService executorService = this.b.c;
        executorService.getClass();
        return fx3.m(new ed(21, executorService, new rw4(1, this)));
    }

    @Override // defpackage.tc2
    public final yv b() {
        ExecutorService executorService = this.b.c;
        executorService.getClass();
        return fx3.m(new ed(21, executorService, new fn(27, this)));
    }

    public abstract rc2 c();
}
