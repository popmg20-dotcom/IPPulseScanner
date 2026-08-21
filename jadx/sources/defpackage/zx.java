package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zx extends yx {
    public final ArrayList a = new ArrayList();

    public zx(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            yx yxVar = (yx) it.next();
            if (!(yxVar instanceof ay)) {
                this.a.add(yxVar);
            }
        }
    }

    @Override // defpackage.yx
    public final void a(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((yx) it.next()).a(i);
        }
    }

    @Override // defpackage.yx
    public final void b(int i, fy fyVar) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((yx) it.next()).b(i, fyVar);
        }
    }

    @Override // defpackage.yx
    public final void c(int i, d7 d7Var) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((yx) it.next()).c(i, d7Var);
        }
    }

    @Override // defpackage.yx
    public final void d(int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((yx) it.next()).d(i);
        }
    }
}
