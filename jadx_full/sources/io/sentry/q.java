package io.sentry;

import java.util.Iterator;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q extends TimerTask {
    public final /* synthetic */ t b;

    public q(t tVar) {
        this.b = tVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Iterator it = this.b.d.iterator();
        while (it.hasNext()) {
            ((b1) it.next()).c();
        }
    }
}
