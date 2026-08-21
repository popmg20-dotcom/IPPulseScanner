package com.getsurfboard.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import com.getsurfboard.R;
import com.getsurfboard.ui.fragment.settings.TwoPanePreferenceFragment;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.divider.MaterialDivider;
import defpackage.ca;
import defpackage.ge0;
import defpackage.ji0;
import defpackage.mk;
import defpackage.mt;
import defpackage.uf;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vf2;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SettingsActivity extends ca {
    public static final /* synthetic */ int S0 = 0;

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        v9.e(getWindow());
        super.onCreate(bundle);
        ge0 ge0Var = null;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_settings, (ViewGroup) null, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.fragment_settings;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) vf2.l(viewInflate, R.id.fragment_settings);
            if (fragmentContainerView != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                if (toolbar != null) {
                    i = R.id.toolbar_divider;
                    if (((MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider)) != null) {
                        setContentView((CoordinatorLayout) viewInflate);
                        toolbar.setNavigationOnClickListener(new mk(24, this));
                        ji0.B(uf2.t(this), null, null, new mt(this, ge0Var, 17), 3);
                        if (getIntent().getBooleanExtra("open_vpn_settings", false)) {
                            String stringExtra = getIntent().getStringExtra("highlight_key");
                            TwoPanePreferenceFragment twoPanePreferenceFragment = (TwoPanePreferenceFragment) fragmentContainerView.getFragment();
                            String name = VpnSettingsFragment.class.getName();
                            twoPanePreferenceFragment.getClass();
                            ji0.B(uf2.t(twoPanePreferenceFragment), null, null, new uf(twoPanePreferenceFragment, name, stringExtra, ge0Var, 27), 3);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
