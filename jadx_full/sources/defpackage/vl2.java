package defpackage;

import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vl2 extends yx {
    public final /* synthetic */ int a = 1;
    public final Object b;

    public vl2(es4 es4Var) {
        this.b = new WeakReference(es4Var);
    }

    @Override // defpackage.yx
    public final void b(int i, fy fyVar) {
        switch (this.a) {
            case 0:
                wl2 wl2Var = (wl2) this.b;
                synchronized (wl2Var.b) {
                    try {
                        if (wl2Var.X) {
                            return;
                        }
                        wl2Var.z0.put(fyVar.c(), new gy(fyVar));
                        wl2Var.g();
                        return;
                    } finally {
                    }
                }
            default:
                es4 es4Var = (es4) ((WeakReference) this.b).get();
                if (es4Var != null) {
                    Iterator it = es4Var.b.iterator();
                    while (it.hasNext()) {
                        tt3 tt3Var = ((in4) it.next()).n;
                        Iterator it2 = tt3Var.g.d.iterator();
                        while (it2.hasNext()) {
                            ((yx) it2.next()).b(i, new fv0(fyVar, tt3Var.g.f, -1L));
                        }
                    }
                    return;
                }
                return;
        }
    }

    public vl2(wl2 wl2Var) {
        this.b = wl2Var;
    }
}
