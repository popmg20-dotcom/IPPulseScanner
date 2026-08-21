package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ik1 extends tf3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ik1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.tf3
    public void a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((jk1) obj).b(true);
                break;
            case 1:
                ((se2) obj).k();
                break;
            case 3:
                RecyclerView recyclerView = (RecyclerView) obj;
                recyclerView.k(null);
                recyclerView.y1.f = true;
                recyclerView.c0(true);
                if (!recyclerView.y0.k()) {
                    recyclerView.requestLayout();
                }
                break;
            case 4:
                ((wt2) obj).f();
                break;
        }
    }

    @Override // defpackage.tf3
    public void b() {
        switch (this.a) {
            case 0:
                a();
                break;
            case 4:
                ((wt2) this.b).f();
                break;
        }
    }

    @Override // defpackage.tf3
    public void c(int i, int i2, Object obj) {
        int i3 = this.a;
        Object obj2 = this.b;
        switch (i3) {
            case 0:
                a();
                break;
            case 1:
            case 2:
            default:
                super.c(i, i2, obj);
                break;
            case 3:
                RecyclerView recyclerView = (RecyclerView) obj2;
                recyclerView.k(null);
                k5 k5Var = recyclerView.y0;
                ArrayList arrayList = (ArrayList) k5Var.c;
                if (i2 >= 1) {
                    arrayList.add(k5Var.n(obj, 4, i, i2));
                    k5Var.a |= 4;
                    if (arrayList.size() == 1) {
                        h();
                    }
                    break;
                }
                break;
            case 4:
                ((wt2) obj2).f();
                break;
        }
    }

    @Override // defpackage.tf3
    public final void d(int i, int i2) {
        int i3 = this.a;
        Object obj = this.b;
        switch (i3) {
            case 0:
                a();
                return;
            case 1:
                se2 se2Var = (se2) obj;
                se2Var.k();
                te2 te2Var = se2Var.b;
                if (te2Var == null) {
                    n12.T("binding");
                    throw null;
                }
                ag3 layoutManager = te2Var.f.getLayoutManager();
                layoutManager.getClass();
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                View viewU0 = linearLayoutManager.U0(0, linearLayoutManager.v(), true, false);
                int iK = viewU0 == null ? -1 : ag3.K(viewU0);
                if (iK == -1 || iK == 0) {
                    linearLayoutManager.h1(0, 0);
                    return;
                }
                return;
            case 2:
                mf3 mf3Var = (mf3) obj;
                mf3.q(mf3Var);
                mf3Var.p(this);
                return;
            case 3:
                RecyclerView recyclerView = (RecyclerView) obj;
                recyclerView.k(null);
                k5 k5Var = recyclerView.y0;
                ArrayList arrayList = (ArrayList) k5Var.c;
                if (i2 < 1) {
                    return;
                }
                arrayList.add(k5Var.n(null, 1, i, i2));
                k5Var.a |= 1;
                if (arrayList.size() == 1) {
                    h();
                    return;
                }
                return;
            default:
                ((wt2) obj).f();
                return;
        }
    }

    @Override // defpackage.tf3
    public void e(int i, int i2) {
        int i3 = this.a;
        Object obj = this.b;
        switch (i3) {
            case 0:
                a();
                break;
            case 3:
                RecyclerView recyclerView = (RecyclerView) obj;
                recyclerView.k(null);
                k5 k5Var = recyclerView.y0;
                ArrayList arrayList = (ArrayList) k5Var.c;
                if (i != i2) {
                    arrayList.add(k5Var.n(null, 8, i, i2));
                    k5Var.a |= 8;
                    if (arrayList.size() == 1) {
                        h();
                    }
                    break;
                }
                break;
            case 4:
                ((wt2) obj).f();
                break;
        }
    }

    @Override // defpackage.tf3
    public void f(int i, int i2) {
        int i3 = this.a;
        Object obj = this.b;
        switch (i3) {
            case 0:
                a();
                break;
            case 1:
                ((se2) obj).k();
                break;
            case 3:
                RecyclerView recyclerView = (RecyclerView) obj;
                recyclerView.k(null);
                k5 k5Var = recyclerView.y0;
                ArrayList arrayList = (ArrayList) k5Var.c;
                if (i2 >= 1) {
                    arrayList.add(k5Var.n(null, 2, i, i2));
                    k5Var.a |= 2;
                    if (arrayList.size() == 1) {
                        h();
                    }
                    break;
                }
                break;
            case 4:
                ((wt2) obj).f();
                break;
        }
    }

    @Override // defpackage.tf3
    public void g() {
        rf3 rf3Var;
        switch (this.a) {
            case 3:
                RecyclerView recyclerView = (RecyclerView) this.b;
                if (recyclerView.A != null && (rf3Var = recyclerView.G0) != null) {
                    int iG = fw.G(rf3Var.c);
                    if (iG != 1) {
                        if (iG == 2) {
                        }
                    } else if (rf3Var.b() <= 0) {
                    }
                    recyclerView.requestLayout();
                }
                break;
        }
    }

    public void h() {
        RecyclerView recyclerView = (RecyclerView) this.b;
        if (!recyclerView.N0 || !recyclerView.M0) {
            recyclerView.U0 = true;
            recyclerView.requestLayout();
        } else {
            of3 of3Var = recyclerView.C0;
            WeakHashMap weakHashMap = wp4.a;
            recyclerView.postOnAnimation(of3Var);
        }
    }
}
