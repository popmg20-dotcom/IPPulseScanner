package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.widget.MetroLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.tencent.mars.xlog.Xlog;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jh0 implements l4, hf4, mu2, uq2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ xh0 f;

    public /* synthetic */ jh0(xh0 xh0Var, int i) {
        this.b = i;
        this.f = xh0Var;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        view.getClass();
        yu4 yu4Var = bv4Var.a;
        xh0 xh0Var = this.f;
        j80 j80Var = xh0Var.b;
        j80Var.getClass();
        ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) j80Var.b;
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            zo2.n("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            return null;
        }
        te0 te0Var = (te0) layoutParams;
        if (xh0Var.getResources().getBoolean(R.bool.bottom_bar_displayed)) {
            te0Var.setMargins(((ViewGroup.MarginLayoutParams) te0Var).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var).topMargin, ((ViewGroup.MarginLayoutParams) te0Var).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin));
        } else {
            te0Var.setMargins(((ViewGroup.MarginLayoutParams) te0Var).leftMargin, ((ViewGroup.MarginLayoutParams) te0Var).topMargin, ((ViewGroup.MarginLayoutParams) te0Var).rightMargin, ContextUtilsKt.e(R.dimen.fab_margin) + yu4Var.h(519).d);
        }
        extendedFloatingActionButton.setLayoutParams(te0Var);
        j80 j80Var2 = xh0Var.b;
        j80Var2.getClass();
        ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) j80Var2.b;
        if (!extendedFloatingActionButton2.isLaidOut() || extendedFloatingActionButton2.isLayoutRequested()) {
            extendedFloatingActionButton2.addOnLayoutChangeListener(new wh0(0, xh0Var, bv4Var));
            return bv4Var;
        }
        boolean z = xh0Var.getResources().getBoolean(R.bool.bottom_bar_displayed);
        j80 j80Var3 = xh0Var.b;
        if (z) {
            j80Var3.getClass();
            MetroLayout metroLayout = (MetroLayout) ((oj1) j80Var3.c).f;
            j80 j80Var4 = xh0Var.b;
            j80Var4.getClass();
            metroLayout.setPadding(metroLayout.getPaddingLeft(), metroLayout.getPaddingTop(), metroLayout.getPaddingRight(), (ContextUtilsKt.e(R.dimen.fab_margin) * 2) + ((ExtendedFloatingActionButton) j80Var4.b).getHeight());
            return bv4Var;
        }
        j80Var3.getClass();
        MetroLayout metroLayout2 = (MetroLayout) ((oj1) j80Var3.c).f;
        j80 j80Var5 = xh0Var.b;
        j80Var5.getClass();
        metroLayout2.setPadding(metroLayout2.getPaddingLeft(), metroLayout2.getPaddingTop(), metroLayout2.getPaddingRight(), (ContextUtilsKt.e(R.dimen.fab_margin) * 2) + ((ExtendedFloatingActionButton) j80Var5.b).getHeight() + yu4Var.h(519).d);
        return bv4Var;
    }

    @Override // defpackage.hf4
    public boolean a(sk2 sk2Var) {
        int i = sk2Var.a;
        xh0 xh0Var = this.f;
        if (i == R.id.toggle_cards) {
            j80 j80Var = xh0Var.b;
            j80Var.getClass();
            ((MaterialButton) j80Var.e).callOnClick();
            return true;
        }
        if (i == R.id.settings) {
            Context contextRequireContext = xh0Var.requireContext();
            contextRequireContext.getClass();
            fx3.I(contextRequireContext, null, false);
            return true;
        }
        if (i != R.id.add_widgets || Build.VERSION.SDK_INT < 26) {
            return true;
        }
        new z5().m(xh0Var.getChildFragmentManager(), null);
        return true;
    }

    @Override // defpackage.l4
    public void h(Object obj) {
        int i = this.b;
        xh0 xh0Var = this.f;
        switch (i) {
            case 0:
                xh0.l(xh0Var, (uk3) obj);
                break;
            default:
                Boolean bool = (Boolean) obj;
                String str = "gpsPermission result " + bool;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "DashboardFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("DashboardFragment", str, null);
                }
                if (!bool.booleanValue()) {
                    j80 j80Var = xh0Var.b;
                    j80Var.getClass();
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var.a;
                    coordinatorLayout.getClass();
                    r25.R(coordinatorLayout, R.string.request_permission_failed, new Object[0]);
                } else {
                    xh0Var.Y.h(new uk3(Boolean.TRUE));
                }
                break;
        }
    }
}
