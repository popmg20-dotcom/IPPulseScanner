package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bt implements mu2, br3 {
    public final /* synthetic */ BypassConfigActivity b;

    public /* synthetic */ bt(BypassConfigActivity bypassConfigActivity) {
        this.b = bypassConfigActivity;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        int i = BypassConfigActivity.Y0;
        view.getClass();
        yu4 yu4Var = bv4Var.a;
        BypassConfigActivity bypassConfigActivity = this.b;
        y3 y3Var = bypassConfigActivity.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        RecyclerView recyclerView = (RecyclerView) y3Var.g;
        recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), yu4Var.h(519).d);
        y3 y3Var2 = bypassConfigActivity.S0;
        if (y3Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) y3Var2.k;
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            zo2.n("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            return null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        y3 y3Var3 = bypassConfigActivity.S0;
        if (y3Var3 == null) {
            n12.T("binding");
            throw null;
        }
        marginLayoutParams.bottomMargin = bypassConfigActivity.getResources().getDimensionPixelOffset(R.dimen.fab_margin) + ((RecyclerView) y3Var3.g).getPaddingBottom();
        extendedFloatingActionButton.setLayoutParams(marginLayoutParams);
        y3 y3Var4 = bypassConfigActivity.S0;
        if (y3Var4 == null) {
            n12.T("binding");
            throw null;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var4.a;
        coordinatorLayout.getClass();
        coordinatorLayout.setPadding(yu4Var.h(519).a, coordinatorLayout.getPaddingTop(), yu4Var.h(519).c, coordinatorLayout.getPaddingBottom());
        return bv4Var;
    }

    @Override // defpackage.br3
    public void a() {
        int i = BypassConfigActivity.Y0;
        this.b.e("");
    }
}
