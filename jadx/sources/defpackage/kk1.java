package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class kk1 extends rf3 {
    public final r92 d;
    public final u e;
    public final ff2 f = new ff2();
    public final ff2 g = new ff2();
    public final ff2 h = new ff2();
    public jk1 i;
    public final ha1 j;
    public boolean k;
    public boolean l;

    public kk1(u uVar, r92 r92Var) {
        ha1 ha1Var = new ha1(6);
        ha1Var.f = new CopyOnWriteArrayList();
        this.j = ha1Var;
        this.k = false;
        this.l = false;
        this.e = uVar;
        this.d = r92Var;
        o(true);
    }

    public static void q(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            xe.q("Design assumption violated.");
            return;
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    @Override // defpackage.rf3
    public final long c(int i) {
        return i;
    }

    @Override // defpackage.rf3
    public final void f(RecyclerView recyclerView) {
        int i = 0;
        r25.e(this.i == null);
        jk1 jk1Var = new jk1(this);
        this.i = jk1Var;
        ViewPager2 viewPager2A = jk1.a(recyclerView);
        jk1Var.d = viewPager2A;
        x90 x90Var = new x90(jk1Var);
        jk1Var.a = x90Var;
        ((ArrayList) viewPager2A.z.b).add(x90Var);
        ik1 ik1Var = new ik1(i, jk1Var);
        jk1Var.b = ik1Var;
        n(ik1Var);
        nf3 nf3Var = new nf3(3, jk1Var);
        jk1Var.c = nf3Var;
        this.d.a(nf3Var);
    }

    @Override // defpackage.rf3
    public final void g(rg3 rg3Var, int i) {
        al1 al1Var = (al1) rg3Var;
        long j = al1Var.e;
        FrameLayout frameLayout = (FrameLayout) al1Var.a;
        int id = frameLayout.getId();
        Long lU = u(id);
        ff2 ff2Var = this.h;
        if (lU != null && lU.longValue() != j) {
            w(lU.longValue());
            ff2Var.i(lU.longValue());
        }
        ff2Var.h(j, Integer.valueOf(id));
        long j2 = i;
        ff2 ff2Var2 = this.f;
        if (ff2Var2.f(j2) < 0) {
            o oVarS = s(i);
            oVarS.setInitialSavedState((ij1) this.g.d(j2));
            ff2Var2.h(j2, oVarS);
        }
        WeakHashMap weakHashMap = wp4.a;
        if (frameLayout.isAttachedToWindow()) {
            v(al1Var);
        }
        t();
    }

    @Override // defpackage.rf3
    public final rg3 i(ViewGroup viewGroup, int i) {
        int i2 = al1.u;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        WeakHashMap weakHashMap = wp4.a;
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new al1(frameLayout);
    }

    @Override // defpackage.rf3
    public final void j(RecyclerView recyclerView) {
        jk1 jk1Var = this.i;
        jk1Var.getClass();
        ViewPager2 viewPager2A = jk1.a(recyclerView);
        ((ArrayList) viewPager2A.z.b).remove(jk1Var.a);
        kk1 kk1Var = jk1Var.f;
        kk1Var.p(jk1Var.b);
        kk1Var.d.c(jk1Var.c);
        jk1Var.d = null;
        this.i = null;
    }

    @Override // defpackage.rf3
    public final boolean k(rg3 rg3Var) {
        return true;
    }

    @Override // defpackage.rf3
    public final void l(rg3 rg3Var) {
        v((al1) rg3Var);
        t();
    }

    @Override // defpackage.rf3
    public final void m(rg3 rg3Var) {
        Long lU = u(((FrameLayout) ((al1) rg3Var).a).getId());
        if (lU != null) {
            w(lU.longValue());
            this.h.i(lU.longValue());
        }
    }

    public final boolean r(long j) {
        return j >= 0 && j < ((long) b());
    }

    public abstract o s(int i);

    public final void t() {
        ff2 ff2Var;
        ff2 ff2Var2;
        o oVar;
        View view;
        if (!this.l || this.e.Q()) {
            return;
        }
        me meVar = new me(0);
        int i = 0;
        while (true) {
            ff2Var = this.f;
            int iJ = ff2Var.j();
            ff2Var2 = this.h;
            if (i >= iJ) {
                break;
            }
            long jG = ff2Var.g(i);
            if (!r(jG)) {
                meVar.add(Long.valueOf(jG));
                ff2Var2.i(jG);
            }
            i++;
        }
        if (!this.k) {
            this.l = false;
            for (int i2 = 0; i2 < ff2Var.j(); i2++) {
                long jG2 = ff2Var.g(i2);
                if (ff2Var2.f(jG2) < 0 && ((oVar = (o) ff2Var.d(jG2)) == null || (view = oVar.getView()) == null || view.getParent() == null)) {
                    meVar.add(Long.valueOf(jG2));
                }
            }
        }
        ee eeVar = new ee(meVar);
        while (eeVar.hasNext()) {
            w(((Long) eeVar.next()).longValue());
        }
    }

    public final Long u(int i) {
        int i2 = 0;
        Long lValueOf = null;
        while (true) {
            ff2 ff2Var = this.h;
            if (i2 >= ff2Var.j()) {
                return lValueOf;
            }
            if (((Integer) ff2Var.k(i2)).intValue() == i) {
                if (lValueOf != null) {
                    xe.q("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                    return null;
                }
                lValueOf = Long.valueOf(ff2Var.g(i2));
            }
            i2++;
        }
    }

    public final void v(al1 al1Var) {
        o oVar = (o) this.f.d(al1Var.e);
        if (oVar == null) {
            xe.q("Design assumption violated.");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) al1Var.a;
        View view = oVar.getView();
        if (!oVar.isAdded() && view != null) {
            xe.q("Design assumption violated.");
            return;
        }
        boolean zIsAdded = oVar.isAdded();
        u uVar = this.e;
        if (zIsAdded && view == null) {
            hk1 hk1Var = new hk1(this, oVar, frameLayout);
            eg0 eg0Var = uVar.p;
            eg0Var.getClass();
            ((CopyOnWriteArrayList) eg0Var.z).add(new qj1(hk1Var, false));
            return;
        }
        if (oVar.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayout) {
                q(view, frameLayout);
                return;
            }
            return;
        }
        if (oVar.isAdded()) {
            q(view, frameLayout);
            return;
        }
        if (uVar.Q()) {
            if (uVar.K) {
                return;
            }
            this.d.a(new bm0(this, al1Var));
            return;
        }
        hk1 hk1Var2 = new hk1(this, oVar, frameLayout);
        eg0 eg0Var2 = uVar.p;
        eg0Var2.getClass();
        ((CopyOnWriteArrayList) eg0Var2.z).add(new qj1(hk1Var2, false));
        ha1 ha1Var = this.j;
        ha1Var.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = ((CopyOnWriteArrayList) ha1Var.f).iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        try {
            oVar.setMenuVisibility(false);
            a aVar = new a(uVar);
            aVar.g(0, oVar, "f" + al1Var.e, 1);
            aVar.m(oVar, q92.A);
            if (aVar.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            aVar.h = false;
            aVar.r.A(aVar, false);
            this.i.b(false);
        } finally {
            ha1.x(arrayList);
        }
    }

    public final void w(long j) {
        ViewParent parent;
        ff2 ff2Var = this.f;
        o oVar = (o) ff2Var.d(j);
        if (oVar == null) {
            return;
        }
        if (oVar.getView() != null && (parent = oVar.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        boolean zR = r(j);
        ff2 ff2Var2 = this.g;
        if (!zR) {
            ff2Var2.i(j);
        }
        if (!oVar.isAdded()) {
            ff2Var.i(j);
            return;
        }
        u uVar = this.e;
        if (uVar.Q()) {
            this.l = true;
            return;
        }
        boolean zIsAdded = oVar.isAdded();
        ha1 ha1Var = this.j;
        if (zIsAdded && r(j)) {
            ha1Var.getClass();
            ArrayList arrayList = new ArrayList();
            Iterator it = ((CopyOnWriteArrayList) ha1Var.f).iterator();
            if (it.hasNext()) {
                throw dw2.z(it);
            }
            ij1 ij1VarC0 = uVar.c0(oVar);
            ha1.x(arrayList);
            ff2Var2.h(j, ij1VarC0);
        }
        ha1Var.getClass();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = ((CopyOnWriteArrayList) ha1Var.f).iterator();
        if (it2.hasNext()) {
            throw dw2.z(it2);
        }
        try {
            a aVar = new a(uVar);
            aVar.j(oVar);
            if (aVar.g) {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
            aVar.h = false;
            aVar.r.A(aVar, false);
            ff2Var.i(j);
        } finally {
            ha1.x(arrayList2);
        }
    }
}
