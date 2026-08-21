package io.sentry.android.core.internal.util;

import android.os.Handler;
import android.view.Window;
import io.sentry.p5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ r f;
    public final /* synthetic */ Window z;

    public /* synthetic */ l(r rVar, Window window, int i) {
        this.b = i;
        this.f = rVar;
        this.z = window;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                r rVar = this.f;
                Window window = this.z;
                if (rVar.f.add(window)) {
                    try {
                        c cVar = rVar.z0;
                        m mVar = rVar.A0;
                        Handler handler = rVar.A;
                        cVar.getClass();
                        q.a(window, mVar, handler);
                    } catch (Throwable th) {
                        rVar.z.d(p5.ERROR, "Failed to add frameMetricsAvailableListener", th);
                        return;
                    }
                }
                break;
            default:
                r rVar2 = this.f;
                Window window2 = this.z;
                try {
                    if (rVar2.f.remove(window2)) {
                        c cVar2 = rVar2.z0;
                        m mVar2 = rVar2.A0;
                        cVar2.getClass();
                        q.b(window2, mVar2);
                    }
                } catch (Throwable th2) {
                    rVar2.z.d(p5.ERROR, "Failed to remove frameMetricsAvailableListener", th2);
                }
                break;
        }
    }
}
