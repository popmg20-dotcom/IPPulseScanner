package defpackage;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ig3 {
    public final ArrayList a;
    public ArrayList b;
    public final ArrayList c;
    public final List d;
    public int e;
    public int f;
    public hg3 g;
    public final /* synthetic */ RecyclerView h;

    public ig3(RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = null;
        this.c = new ArrayList();
        this.d = DesugarCollections.unmodifiableList(arrayList);
        this.e = 2;
        this.f = 2;
    }

    public final void a(rg3 rg3Var, boolean z) {
        RecyclerView.l(rg3Var);
        View view = rg3Var.a;
        RecyclerView recyclerView = this.h;
        tg3 tg3Var = recyclerView.F1;
        if (tg3Var != null) {
            h2 h2VarJ = tg3Var.j();
            wp4.n(view, h2VarJ instanceof sg3 ? (h2) ((sg3) h2VarJ).e.remove(view) : null);
        }
        if (z) {
            ArrayList arrayList = recyclerView.I0;
            if (arrayList.size() > 0) {
                throw qe4.r(arrayList, 0);
            }
            rf3 rf3Var = recyclerView.G0;
            if (rf3Var != null) {
                rf3Var.m(rg3Var);
            }
            if (recyclerView.y1 != null) {
                recyclerView.A0.D(rg3Var);
            }
            if (RecyclerView.U1) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + rg3Var);
            }
        }
        rg3Var.s = null;
        rg3Var.r = null;
        hg3 hg3VarC = c();
        hg3VarC.getClass();
        int i = rg3Var.f;
        ArrayList arrayList2 = hg3VarC.a(i).a;
        ((gg3) hg3VarC.a.get(i)).getClass();
        if (5 <= arrayList2.size()) {
            gb4.p(view);
        } else if (RecyclerView.T1 && arrayList2.contains(rg3Var)) {
            xe.k("this scrap item already exists");
        } else {
            rg3Var.o();
            arrayList2.add(rg3Var);
        }
    }

    public final int b(int i) {
        RecyclerView recyclerView = this.h;
        ng3 ng3Var = recyclerView.y1;
        if (i >= 0 && i < ng3Var.b()) {
            return !ng3Var.g ? i : recyclerView.y0.h(i, 0);
        }
        StringBuilder sbD = dw2.D("invalid position ", i, ". State item count is ");
        sbD.append(ng3Var.b());
        sbD.append(recyclerView.C());
        throw new IndexOutOfBoundsException(sbD.toString());
    }

    public final hg3 c() {
        if (this.g == null) {
            this.g = new hg3();
            e();
        }
        return this.g;
    }

    public final View d(int i) {
        return l(i, Long.MAX_VALUE).a;
    }

    public final void e() {
        RecyclerView recyclerView;
        rf3 rf3Var;
        hg3 hg3Var = this.g;
        if (hg3Var == null || (rf3Var = (recyclerView = this.h).G0) == null || !recyclerView.M0) {
            return;
        }
        hg3Var.c.add(rf3Var);
    }

    public final void f(rf3 rf3Var, boolean z) {
        hg3 hg3Var = this.g;
        if (hg3Var != null) {
            SparseArray sparseArray = hg3Var.a;
            Set set = hg3Var.c;
            set.remove(rf3Var);
            if (set.size() != 0 || z) {
                return;
            }
            for (int i = 0; i < sparseArray.size(); i++) {
                ArrayList arrayList = ((gg3) sparseArray.get(sparseArray.keyAt(i))).a;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    gb4.p(((rg3) arrayList.get(i2)).a);
                }
            }
        }
    }

    public final void g() {
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            h(size);
        }
        arrayList.clear();
        if (RecyclerView.Y1) {
            r02 r02Var = this.h.x1;
            int[] iArr = (int[]) r02Var.d;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            r02Var.c = 0;
        }
    }

    public final void h(int i) {
        if (RecyclerView.U1) {
            Log.d("RecyclerView", "Recycling cached view at index " + i);
        }
        ArrayList arrayList = this.c;
        rg3 rg3Var = (rg3) arrayList.get(i);
        if (RecyclerView.U1) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + rg3Var);
        }
        a(rg3Var, true);
        arrayList.remove(i);
    }

    public final void i(View view) {
        rg3 rg3VarO = RecyclerView.O(view);
        boolean zL = rg3VarO.l();
        RecyclerView recyclerView = this.h;
        if (zL) {
            recyclerView.removeDetachedView(view, false);
        }
        if (rg3VarO.k()) {
            rg3VarO.n.m(rg3VarO);
        } else if (rg3VarO.r()) {
            rg3VarO.j &= -33;
        }
        j(rg3VarO);
        if (recyclerView.g1 == null || rg3VarO.i()) {
            return;
        }
        recyclerView.g1.d(rg3VarO);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00dc, code lost:
    
        r6 = r6 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(defpackage.rg3 r13) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ig3.j(rg3):void");
    }

    public final void k(View view) {
        rg3 rg3VarO = RecyclerView.O(view);
        int i = rg3VarO.j & 12;
        RecyclerView recyclerView = this.h;
        if (i == 0 && rg3VarO.m() && recyclerView.g1 != null && rg3VarO.e().isEmpty() && !rg3VarO.h()) {
            ArrayList arrayList = this.b;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.b = arrayList;
            }
            rg3VarO.n = this;
            rg3VarO.o = true;
            arrayList.add(rg3VarO);
            return;
        }
        if (rg3VarO.h() && !rg3VarO.j() && !recyclerView.G0.b) {
            xe.k("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.".concat(recyclerView.C()));
            return;
        }
        rg3VarO.n = this;
        rg3VarO.o = false;
        this.a.add(rg3VarO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x061b  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0631 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v59 */
    /* JADX WARN: Type inference failed for: r7v70 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.rg3 l(int r29, long r30) {
        /*
            Method dump skipped, instruction units count: 1628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ig3.l(int, long):rg3");
    }

    public final void m(rg3 rg3Var) {
        if (rg3Var.o) {
            this.b.remove(rg3Var);
        } else {
            this.a.remove(rg3Var);
        }
        rg3Var.n = null;
        rg3Var.o = false;
        rg3Var.j &= -33;
    }

    public final void n() {
        ag3 ag3Var = this.h.H0;
        this.f = this.e + (ag3Var != null ? ag3Var.j : 0);
        ArrayList arrayList = this.c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f; size--) {
            h(size);
        }
    }
}
