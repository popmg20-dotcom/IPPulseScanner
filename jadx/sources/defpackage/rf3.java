package defpackage;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class rf3 {
    public final sf3 a = new sf3();
    public boolean b = false;
    public int c = 1;

    public abstract int b();

    public long c(int i) {
        return -1L;
    }

    public int d(int i) {
        return 0;
    }

    public final void e(int i) {
        this.a.d(i, 1, null);
    }

    public abstract void g(rg3 rg3Var, int i);

    public void h(rg3 rg3Var, int i, List list) {
        g(rg3Var, i);
    }

    public abstract rg3 i(ViewGroup viewGroup, int i);

    public boolean k(rg3 rg3Var) {
        return false;
    }

    public final void n(tf3 tf3Var) {
        this.a.registerObserver(tf3Var);
    }

    public final void o(boolean z) {
        if (this.a.a()) {
            xe.q("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else {
            this.b = z;
        }
    }

    public final void p(tf3 tf3Var) {
        this.a.unregisterObserver(tf3Var);
    }

    public void f(RecyclerView recyclerView) {
    }

    public void j(RecyclerView recyclerView) {
    }

    public void l(rg3 rg3Var) {
    }

    public void m(rg3 rg3Var) {
    }
}
