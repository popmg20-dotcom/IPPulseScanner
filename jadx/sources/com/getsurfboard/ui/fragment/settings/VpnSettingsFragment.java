package com.getsurfboard.ui.fragment.settings;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;
import com.getsurfboard.ui.receiver.BootCompleteReceiver;
import defpackage.ag3;
import defpackage.b0;
import defpackage.e04;
import defpackage.hu0;
import defpackage.li;
import defpackage.m33;
import defpackage.n12;
import defpackage.nk;
import defpackage.p82;
import defpackage.pf2;
import defpackage.po1;
import defpackage.pv2;
import defpackage.qe;
import defpackage.rf3;
import defpackage.s10;
import defpackage.t23;
import defpackage.ts4;
import defpackage.um1;
import defpackage.vf2;
import defpackage.w23;
import defpackage.wh2;
import defpackage.xb5;
import defpackage.zo2;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class VpnSettingsFragment extends nk {
    public VpnSettingsFragment() {
        super(R.xml.fragment_vpn_settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptScrollAndFlick(Preference preference) {
        rf3 adapter = getListView().getAdapter();
        m33 m33Var = adapter instanceof m33 ? (m33) adapter : null;
        Integer numValueOf = m33Var != null ? Integer.valueOf(m33Var.t(preference)) : null;
        if (numValueOf == null || numValueOf.intValue() == -1) {
            RecyclerView listView = getListView();
            listView.getClass();
            pv2.a(listView, new um1(11, listView, this, preference));
        } else {
            ag3 layoutManager = getListView().getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return;
            }
            getListView().postDelayed(new b0(17, this, numValueOf, linearLayoutManager), 300L);
            getListView().postDelayed(new ts4(this, preference, 0), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attemptScrollAndFlick$lambda$1(VpnSettingsFragment vpnSettingsFragment, Integer num, LinearLayoutManager linearLayoutManager) {
        s10 s10Var = new s10(vpnSettingsFragment.requireContext());
        s10Var.a = num.intValue();
        linearLayoutManager.H0(s10Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attemptScrollAndFlick$lambda$2(VpnSettingsFragment vpnSettingsFragment, Preference preference) {
        View viewP = t23.p(vpnSettingsFragment, preference);
        if (viewP != null) {
            vpnSettingsFragment.playFlickAnimation(viewP);
        } else {
            vpnSettingsFragment.getListView().postDelayed(new ts4(vpnSettingsFragment, preference, 2), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attemptScrollAndFlick$lambda$2$1(VpnSettingsFragment vpnSettingsFragment, Preference preference) {
        View viewP = t23.p(vpnSettingsFragment, preference);
        if (viewP != null) {
            vpnSettingsFragment.playFlickAnimation(viewP);
        }
    }

    private final void highlightPreference(String str) {
        Preference preferenceFindPreference = findPreference(str);
        if (preferenceFindPreference == null) {
            return;
        }
        getListView().post(new ts4(this, preferenceFindPreference, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(Preference preference) {
        preference.getClass();
        xb5.c("settings allow_lan clicked");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$0(Preference preference, Object obj) {
        preference.getClass();
        ContextUtilsKt.h().setComponentEnabledSetting(new ComponentName(preference.b, (Class<?>) BootCompleteReceiver.class), n12.c(obj, Boolean.TRUE) ? 1 : 2, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4$0(VpnSettingsFragment vpnSettingsFragment, Preference preference) {
        preference.getClass();
        new po1().m(vpnSettingsFragment.getChildFragmentManager(), null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$5$0(VpnSettingsFragment vpnSettingsFragment, Preference preference) {
        preference.getClass();
        View viewInflate = vpnSettingsFragment.getLayoutInflater().inflate(R.layout.dialog_mtu, (ViewGroup) null, false);
        NumberPicker numberPicker = (NumberPicker) vf2.l(viewInflate, R.id.picker);
        if (numberPicker == null) {
            zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.picker)));
            return false;
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        hu0 hu0Var = new hu0(frameLayout, numberPicker);
        numberPicker.setMaxValue(32000);
        numberPicker.setMinValue(1400);
        numberPicker.setValue(t23.j());
        wh2 wh2Var = new wh2(preference.b);
        wh2Var.x(R.string.setting_mtu_title);
        wh2Var.y(frameLayout);
        wh2Var.w(R.string.save, new li(11, hu0Var, vpnSettingsFragment));
        wh2Var.u(R.string.cancel, null);
        wh2Var.r();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$0$0(hu0 hu0Var, VpnSettingsFragment vpnSettingsFragment, DialogInterface dialogInterface, int i) {
        int value = hu0Var.a.getValue();
        SharedPreferences.Editor editorEdit = t23.l().edit();
        editorEdit.putInt(ContextUtilsKt.k(R.string.setting_mtu_key), value);
        editorEdit.apply();
        vpnSettingsFragment.promptRestartVPN();
    }

    private final void playFlickAnimation(View view) {
        TypedValue typedValue = new TypedValue();
        requireContext().getTheme().resolveAttribute(android.R.attr.colorControlHighlight, typedValue, true);
        int i = typedValue.data;
        Drawable background = view.getBackground();
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, Integer.valueOf(i), 0, Integer.valueOf(i), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new p82(view, 1));
        valueAnimatorOfObject.addListener(new pf2(2, view, background));
        valueAnimatorOfObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playFlickAnimation$lambda$0(View view, ValueAnimator valueAnimator) {
        valueAnimator.getClass();
        Object animatedValue = valueAnimator.getAnimatedValue();
        animatedValue.getClass();
        view.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    @Override // defpackage.nk
    public Set<Integer> getRestartVPNPreferenceKeys() {
        return qe.t0(new Integer[]{Integer.valueOf(R.string.setting_allow_lan_key), Integer.valueOf(R.string.setting_allow_bypass_key), Integer.valueOf(R.string.setting_tls_fingerprint_key), Integer.valueOf(R.string.setting_tcp_keep_alive_key), Integer.valueOf(R.string.setting_sshdump_key), Integer.valueOf(R.string.setting_auto_fix_dns_poisoning_key), Integer.valueOf(R.string.setting_enable_vpn_http_proxy_key)});
    }

    @Override // defpackage.nk, defpackage.j33, androidx.fragment.app.o
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        view.getClass();
        super.onViewCreated(view, bundle);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_allow_lan_key));
        int i = 25;
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.Y = new e04(i);
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_start_when_boot_key));
        if (switchPreferenceCompat2 != null) {
            switchPreferenceCompat2.X = new e04(26);
        }
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_sshdump_key));
        final int i2 = 0;
        if (switchPreferenceCompat3 != null && Build.VERSION.SDK_INT <= 25) {
            switchPreferenceCompat3.x(false);
        }
        SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_enable_vpn_http_proxy_key));
        if (switchPreferenceCompat4 != null && Build.VERSION.SDK_INT < 29) {
            switchPreferenceCompat4.x(false);
        }
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_geoip_config_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.Y = new w23(this) { // from class: us4
                public final /* synthetic */ VpnSettingsFragment f;

                {
                    this.f = this;
                }

                @Override // defpackage.w23
                public final boolean k(Preference preference) {
                    int i3 = i2;
                    VpnSettingsFragment vpnSettingsFragment = this.f;
                    switch (i3) {
                        case 0:
                            return VpnSettingsFragment.onViewCreated$lambda$4$0(vpnSettingsFragment, preference);
                        default:
                            return VpnSettingsFragment.onViewCreated$lambda$5$0(vpnSettingsFragment, preference);
                    }
                }
            };
        }
        Preference preferenceFindPreference2 = findPreference(getString(R.string.setting_mtu_key));
        if (preferenceFindPreference2 != null) {
            final int i3 = 1;
            preferenceFindPreference2.Y = new w23(this) { // from class: us4
                public final /* synthetic */ VpnSettingsFragment f;

                {
                    this.f = this;
                }

                @Override // defpackage.w23
                public final boolean k(Preference preference) {
                    int i32 = i3;
                    VpnSettingsFragment vpnSettingsFragment = this.f;
                    switch (i32) {
                        case 0:
                            return VpnSettingsFragment.onViewCreated$lambda$4$0(vpnSettingsFragment, preference);
                        default:
                            return VpnSettingsFragment.onViewCreated$lambda$5$0(vpnSettingsFragment, preference);
                    }
                }
            };
        }
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("highlight_key")) == null) {
            return;
        }
        highlightPreference(string);
    }
}
