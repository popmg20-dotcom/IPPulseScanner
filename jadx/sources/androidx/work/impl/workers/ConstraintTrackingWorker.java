package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import defpackage.ge0;
import defpackage.ji0;
import defpackage.mt;
import defpackage.n12;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ConstraintTrackingWorker extends CoroutineWorker {
    public final WorkerParameters g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
        this.g = workerParameters;
    }

    @Override // androidx.work.CoroutineWorker
    public final Object c(ge0 ge0Var) {
        ExecutorService executorService = this.b.c;
        executorService.getClass();
        return ji0.b0(n12.x(executorService), new mt(this, null, 1), ge0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(defpackage.tc2 r5, defpackage.m20 r6, defpackage.gx4 r7, defpackage.ie0 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof defpackage.ec0
            if (r0 == 0) goto L13
            r0 = r8
            ec0 r0 = (defpackage.ec0) r0
            int r1 = r0.Y
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Y = r1
            goto L18
        L13:
            ec0 r0 = new ec0
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r4 = r0.A
            int r8 = r0.Y
            r1 = 0
            r2 = 1
            if (r8 == 0) goto L2c
            if (r8 != r2) goto L26
            defpackage.n12.S(r4)
            goto L3f
        L26:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            return r1
        L2c:
            defpackage.n12.S(r4)
            aj r4 = new aj
            r4.<init>(r5, r6, r7, r1)
            r0.Y = r2
            java.lang.Object r4 = defpackage.p95.h(r4, r0)
            mf0 r5 = defpackage.mf0.b
            if (r4 != r5) goto L3f
            return r5
        L3f:
            r4.getClass()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker.d(tc2, m20, gx4, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(defpackage.ie0 r21) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorker.e(ie0):java.lang.Object");
    }
}
