package io.sentry.android.core;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t implements io.sentry.android.core.internal.util.p {
    public final /* synthetic */ int a;
    public float b = 0.0f;
    public final /* synthetic */ Object c;

    public /* synthetic */ t(int i, Object obj) {
        this.a = i;
        this.c = obj;
    }

    @Override // io.sentry.android.core.internal.util.p
    public final void b(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                long jCurrentTimeMillis = System.currentTimeMillis();
                System.nanoTime();
                long j5 = jCurrentTimeMillis * 1000000;
                v vVar = (v) obj;
                long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() + (j2 - System.nanoTime())) - vVar.a;
                if (jElapsedRealtimeNanos >= 0) {
                    if (z2) {
                        vVar.j.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jElapsedRealtimeNanos), Long.valueOf(j3), j5));
                    } else if (z) {
                        vVar.i.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jElapsedRealtimeNanos), Long.valueOf(j3), j5));
                    }
                    if (f != this.b) {
                        this.b = f;
                        vVar.h.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jElapsedRealtimeNanos), Float.valueOf(f), j5));
                    }
                    break;
                }
                break;
            default:
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                System.nanoTime();
                long j6 = jCurrentTimeMillis2 * 1000000;
                j1 j1Var = (j1) obj;
                long jElapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() + (j2 - System.nanoTime())) - j1Var.h;
                if (jElapsedRealtimeNanos2 >= 0) {
                    if (z2) {
                        j1Var.f.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jElapsedRealtimeNanos2), Long.valueOf(j3), j6));
                    } else if (z) {
                        j1Var.e.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jElapsedRealtimeNanos2), Long.valueOf(j3), j6));
                    }
                    if (f != this.b) {
                        this.b = f;
                        j1Var.g.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jElapsedRealtimeNanos2), Float.valueOf(f), j6));
                    }
                    break;
                }
                break;
        }
    }
}
