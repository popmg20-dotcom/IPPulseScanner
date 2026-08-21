package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ab3 implements mu2 {
    public final /* synthetic */ cb3 b;

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        view.getClass();
        cb3 cb3Var = this.b;
        uf4 uf4Var = cb3Var.b;
        uf4Var.getClass();
        FloatingActionButton floatingActionButton = (FloatingActionButton) uf4Var.e;
        ViewGroup.LayoutParams layoutParams = floatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            return null;
        }
        te0 te0Var = (te0) layoutParams;
        if (cb3Var.getResources().getBoolean(R.bool.bottom_bar_displayed)) {
            te0Var.setMargins(((ViewGroup.MarginLayoutParams) te0Var).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var).topMargin, ((ViewGroup.MarginLayoutParams) te0Var).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin));
        } else {
            te0Var.setMargins(((ViewGroup.MarginLayoutParams) te0Var).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var).topMargin, ((ViewGroup.MarginLayoutParams) te0Var).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin) + bv4Var.a.h(519).d);
        }
        floatingActionButton.setLayoutParams(te0Var);
        return bv4Var;
    }

    public void a(Bundle bundle) {
        int i = bundle.getInt("proxy_group_selection", -1);
        if (i != -1) {
            uf4 uf4Var = this.b.b;
            uf4Var.getClass();
            ((ViewPager2) uf4Var.a).c(i);
        }
    }
}
