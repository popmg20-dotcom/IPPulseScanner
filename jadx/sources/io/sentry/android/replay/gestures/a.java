package io.sentry.android.replay.gestures;

import android.view.MotionEvent;
import android.view.Window;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.replay.p;
import io.sentry.android.replay.q;
import io.sentry.android.replay.util.d;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d {
    public final SentryAndroidOptions f;
    public volatile ReplayIntegration z;

    public a(SentryAndroidOptions sentryAndroidOptions, ReplayIntegration replayIntegration, Window.Callback callback) {
        super(callback);
        this.f = sentryAndroidOptions;
        this.z = replayIntegration;
    }

    @Override // io.sentry.android.replay.util.d, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        io.sentry.android.replay.capture.d dVar;
        if (motionEvent != null) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            motionEventObtainNoHistory.getClass();
            try {
                ReplayIntegration replayIntegration = this.z;
                if (replayIntegration != null && replayIntegration.C0.get()) {
                    p pVar = replayIntegration.I0;
                    if ((pVar.a == q.STARTED || pVar.a == q.RESUMED) && (dVar = replayIntegration.E0) != null) {
                        dVar.i(motionEventObtainNoHistory);
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
