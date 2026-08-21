package io.sentry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r extends TimerTask {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ t f;

    public r(t tVar, ArrayList arrayList) {
        this.f = tVar;
        this.b = arrayList;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        p1 p1Var;
        this.b.clear();
        p3 p3Var = new p3(this.f.g.getDateProvider().a().d());
        Iterator it = this.f.d.iterator();
        while (it.hasNext()) {
            ((b1) it.next()).a(p3Var);
        }
        for (s sVar : this.f.c.values()) {
            synchronized (sVar.a) {
                sVar.a.add(p3Var);
            }
            if (sVar.b != null && sVar.d.g.getDateProvider().a().d() > sVar.c + 30000000000L && (p1Var = sVar.b) != null) {
                this.b.add(p1Var);
            }
        }
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            this.f.f((p1) it2.next());
        }
    }
}
