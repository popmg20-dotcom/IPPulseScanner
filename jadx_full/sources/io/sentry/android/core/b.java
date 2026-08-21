package io.sentry.android.core;

import android.app.Activity;
import androidx.core.app.FrameMetricsAggregator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ d f;
    public final /* synthetic */ Activity z;

    public /* synthetic */ b(d dVar, Activity activity, int i) {
        this.b = i;
        this.f = dVar;
        this.z = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Activity activity = this.z;
        d dVar = this.f;
        switch (i) {
            case 0:
                ((FrameMetricsAggregator) ((io.sentry.util.f) dVar.a).a()).a.i(activity);
                break;
            default:
                ((FrameMetricsAggregator) ((io.sentry.util.f) dVar.a).a()).a.t(activity);
                break;
        }
    }
}
