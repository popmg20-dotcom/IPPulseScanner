package com.getsurfboard.ui.activity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import defpackage.ca;
import defpackage.hf4;
import defpackage.jd;
import defpackage.l72;
import defpackage.lb;
import defpackage.mk;
import defpackage.mp4;
import defpackage.sk2;
import defpackage.v9;
import defpackage.vf2;
import defpackage.wp4;
import defpackage.zo2;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class DeveloperOptionsActivity extends ca implements hf4 {
    public static final /* synthetic */ int S0 = 0;

    @Override // defpackage.hf4
    public final boolean a(sk2 sk2Var) {
        if (sk2Var.a != R.id.fcm) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.gcm.GcmDiagnostics"));
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_developer_options, (ViewGroup) null, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.exit_reason;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) vf2.l(viewInflate, R.id.exit_reason);
            if (fragmentContainerView != null) {
                i = R.id.fd_counts;
                if (((FragmentContainerView) vf2.l(viewInflate, R.id.fd_counts)) != null) {
                    i = R.id.memory_usage;
                    if (((FragmentContainerView) vf2.l(viewInflate, R.id.memory_usage)) != null) {
                        i = R.id.scroll_view;
                        NestedScrollView nestedScrollView = (NestedScrollView) vf2.l(viewInflate, R.id.scroll_view);
                        if (nestedScrollView != null) {
                            i = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                            if (toolbar != null) {
                                i = R.id.toolbar_divider;
                                if (((MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider)) != null) {
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                    lb lbVar = new lb(coordinatorLayout, fragmentContainerView, nestedScrollView, toolbar);
                                    setContentView(coordinatorLayout);
                                    jd jdVar = new jd(8, lbVar);
                                    WeakHashMap weakHashMap = wp4.a;
                                    mp4.c(coordinatorLayout, jdVar);
                                    toolbar.setNavigationOnClickListener(new mk(4, this));
                                    toolbar.setOnMenuItemClickListener(this);
                                    if (Build.VERSION.SDK_INT >= 30) {
                                        fragmentContainerView.setVisibility(0);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
