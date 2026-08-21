package io.sentry.android.replay;

import defpackage.n12;
import defpackage.pl1;
import defpackage.r82;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.n0;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ ReplayIntegration z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(ReplayIntegration replayIntegration, int i) {
        super(0);
        this.f = i;
        this.z = replayIntegration;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        ReplayIntegration replayIntegration = this.z;
        switch (i) {
            case 0:
                ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new n0(3));
                scheduledExecutorServiceNewSingleThreadScheduledExecutor.getClass();
                SentryAndroidOptions sentryAndroidOptions = replayIntegration.A;
                if (sentryAndroidOptions != null) {
                    return new io.sentry.android.replay.util.i(scheduledExecutorServiceNewSingleThreadScheduledExecutor, sentryAndroidOptions);
                }
                n12.T("options");
                throw null;
            default:
                ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor2 = Executors.newSingleThreadScheduledExecutor(new n0(2));
                scheduledExecutorServiceNewSingleThreadScheduledExecutor2.getClass();
                SentryAndroidOptions sentryAndroidOptions2 = replayIntegration.A;
                if (sentryAndroidOptions2 != null) {
                    return new io.sentry.android.replay.util.i(scheduledExecutorServiceNewSingleThreadScheduledExecutor2, sentryAndroidOptions2);
                }
                n12.T("options");
                throw null;
        }
    }
}
