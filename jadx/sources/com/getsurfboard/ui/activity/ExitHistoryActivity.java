package com.getsurfboard.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import defpackage.a81;
import defpackage.ca;
import defpackage.e03;
import defpackage.ed4;
import defpackage.ey3;
import defpackage.l72;
import defpackage.n12;
import defpackage.v71;
import defpackage.v9;
import defpackage.vf2;
import defpackage.w71;
import defpackage.x71;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ExitHistoryActivity extends ca {
    public static final /* synthetic */ int U0 = 0;
    public ed4 S0;
    public boolean T0;

    @Override // defpackage.ca, defpackage.i90, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        boolean z = configuration.screenWidthDp >= 720;
        if (z != this.T0) {
            this.T0 = z;
            x();
            o oVarC = u().C(R.id.list_pane);
            a81 a81Var = oVarC instanceof a81 ? (a81) oVarC : null;
            if (a81Var != null) {
                a81Var.f = z ? new w71(this, 0) : new x71(0);
            }
        }
    }

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_exit_container, (ViewGroup) null, false);
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) viewInflate;
        int i = R.id.detail_pane;
        FrameLayout frameLayout = (FrameLayout) vf2.l(viewInflate, R.id.detail_pane);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) vf2.l(viewInflate, R.id.list_pane);
            if (frameLayout2 != null) {
                this.S0 = new ed4(2, slidingPaneLayout, frameLayout, frameLayout2);
                setContentView(slidingPaneLayout);
                this.T0 = y();
                if (bundle == null && y()) {
                    a aVar = new a(u());
                    aVar.k(new v71(), R.id.detail_pane);
                    aVar.e();
                }
                x();
                o oVarC = u().C(R.id.list_pane);
                a81 a81Var = oVarC instanceof a81 ? (a81) oVarC : null;
                if (a81Var == null) {
                    a81Var = new a81();
                }
                a81Var.f = y() ? new w71(this, 1) : new x71(1);
                if (bundle == null) {
                    a aVar2 = new a(u());
                    aVar2.k(a81Var, R.id.list_pane);
                    aVar2.e();
                    return;
                }
                return;
            }
            i = R.id.list_pane;
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void x() {
        boolean zY = y();
        ed4 ed4Var = this.S0;
        if (zY) {
            if (ed4Var == null) {
                n12.T("binding");
                throw null;
            }
            ((FrameLayout) ed4Var.z).setVisibility(0);
            ed4 ed4Var2 = this.S0;
            if (ed4Var2 == null) {
                n12.T("binding");
                throw null;
            }
            ViewGroup.LayoutParams layoutParams = ((FrameLayout) ed4Var2.A).getLayoutParams();
            layoutParams.getClass();
            ey3 ey3Var = (ey3) layoutParams;
            ((ViewGroup.MarginLayoutParams) ey3Var).width = ContextUtilsKt.c(320.0f);
            ey3Var.a = 0.0f;
            ed4 ed4Var3 = this.S0;
            if (ed4Var3 != null) {
                ((FrameLayout) ed4Var3.A).setLayoutParams(ey3Var);
                return;
            } else {
                n12.T("binding");
                throw null;
            }
        }
        if (ed4Var == null) {
            n12.T("binding");
            throw null;
        }
        ((FrameLayout) ed4Var.z).setVisibility(8);
        ed4 ed4Var4 = this.S0;
        if (ed4Var4 == null) {
            n12.T("binding");
            throw null;
        }
        ViewGroup.LayoutParams layoutParams2 = ((FrameLayout) ed4Var4.A).getLayoutParams();
        layoutParams2.getClass();
        ey3 ey3Var2 = (ey3) layoutParams2;
        ((ViewGroup.MarginLayoutParams) ey3Var2).width = -1;
        ey3Var2.a = 0.0f;
        ed4 ed4Var5 = this.S0;
        if (ed4Var5 != null) {
            ((FrameLayout) ed4Var5.A).setLayoutParams(ey3Var2);
        } else {
            n12.T("binding");
            throw null;
        }
    }

    public final boolean y() {
        return getResources().getConfiguration().screenWidthDp >= 720;
    }

    public final void z(int i, long j) {
        a aVar = new a(u());
        aVar.b = android.R.anim.fade_in;
        aVar.c = android.R.anim.fade_out;
        aVar.d = 0;
        aVar.e = 0;
        ed4 ed4Var = this.S0;
        if (ed4Var == null) {
            n12.T("binding");
            throw null;
        }
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) ed4Var.f;
        if (slidingPaneLayout == null) {
            slidingPaneLayout = null;
        }
        boolean z = slidingPaneLayout != null ? slidingPaneLayout.y0 : false;
        v71 v71Var = new v71();
        v71Var.setArguments(n12.e(new e03("timestamp", Long.valueOf(j)), new e03("pid", Integer.valueOf(i)), new e03("show_nav_icon", Boolean.valueOf(z))));
        aVar.k(v71Var, R.id.detail_pane);
        aVar.e();
        ed4 ed4Var2 = this.S0;
        if (ed4Var2 == null) {
            n12.T("binding");
            throw null;
        }
        SlidingPaneLayout slidingPaneLayout2 = (SlidingPaneLayout) ed4Var2.f;
        SlidingPaneLayout slidingPaneLayout3 = slidingPaneLayout2 != null ? slidingPaneLayout2 : null;
        if (slidingPaneLayout3 != null) {
            slidingPaneLayout3.e();
        }
    }
}
