package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nf4 extends o implements hf4 {
    public eg0 b;

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        int i = sk2Var.a;
        if (i == R.id.settings) {
            if (getContext() != null) {
                Context contextRequireContext = requireContext();
                contextRequireContext.getClass();
                fx3.I(contextRequireContext, null, false);
                return true;
            }
        } else if (i == R.id.debug && getContext() != null) {
            requireContext().getClass();
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_tools_container, viewGroup, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.container;
            if (((FragmentContainerView) vf2.l(viewInflate, R.id.container)) != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                if (toolbar != null) {
                    i = R.id.toolbar_divider;
                    MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                    if (materialDivider != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                        this.b = new eg0(coordinatorLayout, toolbar, materialDivider, 21);
                        coordinatorLayout.getClass();
                        return coordinatorLayout;
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        eg0 eg0Var = this.b;
        eg0Var.getClass();
        Menu menu = ((Toolbar) eg0Var.f).getMenu();
        if (menu instanceof nk2) {
            ((nk2) menu).s = true;
        }
        eg0 eg0Var2 = this.b;
        eg0Var2.getClass();
        ((Toolbar) eg0Var2.f).setOnMenuItemClickListener(this);
    }
}
