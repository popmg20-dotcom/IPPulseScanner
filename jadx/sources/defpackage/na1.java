package defpackage;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ExternalResourcesManagerActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class na1 implements mu2, ha4 {
    public final /* synthetic */ ExternalResourcesManagerActivity b;

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        int i = ExternalResourcesManagerActivity.T0;
        view.getClass();
        yu4 yu4Var = bv4Var.a;
        iv1 iv1Var = this.b.S0;
        if (iv1Var == null) {
            n12.T("binding");
            throw null;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) iv1Var.f;
        coordinatorLayout.getClass();
        coordinatorLayout.setPadding(yu4Var.h(519).a, coordinatorLayout.getPaddingTop(), yu4Var.h(519).c, coordinatorLayout.getPaddingBottom());
        return bv4Var;
    }

    @Override // defpackage.ha4
    public void a(fa4 fa4Var, int i) {
        String string;
        int i2 = ExternalResourcesManagerActivity.T0;
        ExternalResourcesManagerActivity externalResourcesManagerActivity = this.b;
        if (i == 0) {
            string = externalResourcesManagerActivity.getString(R.string.policy_path);
        } else if (i == 1) {
            string = externalResourcesManagerActivity.getString(R.string.rule_set);
        } else {
            if (i != 2) {
                xe.q("Unknown external resource index");
                return;
            }
            string = externalResourcesManagerActivity.getString(R.string.domain_set);
        }
        fa4Var.a(string);
    }
}
