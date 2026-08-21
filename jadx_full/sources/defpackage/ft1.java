package defpackage;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.HostsListActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ft1 extends i22 {
    public View d;
    public final /* synthetic */ HostsListActivity e;

    public ft1(HostsListActivity hostsListActivity) {
        this.e = hostsListActivity;
    }

    @Override // defpackage.i22
    public final int d(RecyclerView recyclerView, rg3 rg3Var) {
        recyclerView.getClass();
        rg3Var.getClass();
        return 199695;
    }

    @Override // defpackage.i22
    public final void k(Canvas canvas, RecyclerView recyclerView, rg3 rg3Var, float f, float f2, int i, boolean z) {
        float f3;
        canvas.getClass();
        rg3Var.getClass();
        View view = rg3Var.a;
        if (i == 0) {
            view.setAlpha(1.0f);
        } else if (i == 1) {
            if (f < 0.0f) {
                float width = ((2.0f * f) / view.getWidth()) + 1.0f;
                f3 = width >= 0.0f ? width : 0.0f;
                view.setAlpha(f3 <= 1.0f ? f3 : 1.0f);
            } else if (f > 0.0f) {
                float width2 = 1.0f - ((2.0f * f) / view.getWidth());
                f3 = width2 >= 0.0f ? width2 : 0.0f;
                view.setAlpha(f3 <= 1.0f ? f3 : 1.0f);
            }
        }
        super.k(canvas, recyclerView, rg3Var, f, f2, i, z);
    }

    @Override // defpackage.i22
    public final boolean l(RecyclerView recyclerView, rg3 rg3Var, rg3 rg3Var2) {
        recyclerView.getClass();
        rg3Var.getClass();
        int iC = rg3Var.c();
        int iC2 = rg3Var2.c();
        int i = HostsListActivity.a1;
        bt1 bt1Var = this.e.W0;
        List list = bt1Var.d.f;
        list.getClass();
        ArrayList arrayList = new ArrayList(list);
        ls1 ls1Var = (ls1) arrayList.get(iC);
        arrayList.set(iC, (ls1) arrayList.get(iC2));
        arrayList.set(iC2, ls1Var);
        bt1Var.r(arrayList);
        return true;
    }

    @Override // defpackage.i22
    public final void m(rg3 rg3Var, int i) {
        View view;
        HostsListActivity hostsListActivity = this.e;
        if (i == 2 && rg3Var != null) {
            hostsListActivity.U0 = true;
            View view2 = rg3Var.a;
            this.d = view2;
            if (view2 != null) {
                view2.setElevation(ContextUtilsKt.c(8.0f));
                return;
            }
            return;
        }
        if (i != 0 || (view = this.d) == null) {
            return;
        }
        hostsListActivity.U0 = false;
        view.setElevation(0.0f);
        this.d = null;
        ji0.B(uf2.t(hostsListActivity), null, null, new mt(hostsListActivity, null, 7), 3);
    }

    @Override // defpackage.i22
    public final void n(rg3 rg3Var) {
        rg3Var.getClass();
        rg3Var.a.setAlpha(1.0f);
        int iC = rg3Var.c();
        bt1 bt1Var = this.e.W0;
        Object obj = bt1Var.d.f.get(iC);
        obj.getClass();
        bt1Var.g.g((ls1) obj);
    }
}
