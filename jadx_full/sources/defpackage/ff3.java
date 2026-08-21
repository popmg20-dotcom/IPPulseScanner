package defpackage;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.ui.activity.RecentRequestsActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ff3 implements mu2, br3 {
    public final /* synthetic */ RecentRequestsActivity b;

    public /* synthetic */ ff3(RecentRequestsActivity recentRequestsActivity) {
        this.b = recentRequestsActivity;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        int i = RecentRequestsActivity.X0;
        view.getClass();
        yu4 yu4Var = bv4Var.a;
        RecentRequestsActivity recentRequestsActivity = this.b;
        j80 j80Var = recentRequestsActivity.S0;
        if (j80Var == null) {
            n12.T("binding");
            throw null;
        }
        RecyclerView recyclerView = (RecyclerView) j80Var.c;
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), yu4Var.h(519).d);
        j80 j80Var2 = recentRequestsActivity.S0;
        if (j80Var2 == null) {
            n12.T("binding");
            throw null;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var2.a;
        coordinatorLayout.getClass();
        coordinatorLayout.setPadding(yu4Var.h(519).a, coordinatorLayout.getPaddingTop(), yu4Var.h(519).c, coordinatorLayout.getPaddingBottom());
        return bv4Var;
    }

    @Override // defpackage.br3
    public void a() {
        int i = RecentRequestsActivity.X0;
        this.b.e("");
    }
}
