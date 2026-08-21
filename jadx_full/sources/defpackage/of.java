package defpackage;

import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class of {
    public static final nf h = new nf();
    public final zf2 a;
    public final lb b;
    public List e;
    public int g;
    public final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    public List f = Collections.EMPTY_LIST;
    public final nf c = h;

    public of(zf2 zf2Var, lb lbVar) {
        this.a = zf2Var;
        this.b = lbVar;
    }

    public final void a(Runnable runnable) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            rb2 rb2Var = ((qb2) it.next()).a;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void b(List list, Runnable runnable) {
        int i = this.g + 1;
        this.g = i;
        List list2 = this.e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        zf2 zf2Var = this.a;
        if (list == null) {
            int size = list2.size();
            this.e = null;
            this.f = Collections.EMPTY_LIST;
            zf2Var.P(0, size);
            a(runnable);
            return;
        }
        if (list2 != null) {
            ((Executor) this.b.f).execute(new mf(this, list2, list, i, runnable));
            return;
        }
        this.e = list;
        this.f = DesugarCollections.unmodifiableList(list);
        zf2Var.D(0, list.size());
        a(runnable);
    }
}
