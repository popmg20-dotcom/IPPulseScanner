package com.getsurfboard.ui.fragment.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.u;
import androidx.preference.Preference;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.DeveloperOptionsActivity;
import com.getsurfboard.ui.fragment.settings.OthersSettingsFragment;
import defpackage.ed;
import defpackage.fn4;
import defpackage.gj;
import defpackage.jd;
import defpackage.k41;
import defpackage.l72;
import defpackage.nj3;
import defpackage.nk;
import defpackage.t23;
import defpackage.uf2;
import defpackage.vo;
import defpackage.w23;
import defpackage.xb5;
import defpackage.xl4;
import defpackage.yo4;
import defpackage.zg3;
import defpackage.zo2;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OthersSettingsFragment extends nk {
    public OthersSettingsFragment() {
        super(R.xml.fragment_others_settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xl4 onResume$lambda$0(Preference preference, OthersSettingsFragment othersSettingsFragment, yo4 yo4Var) {
        xl4 xl4Var = xl4.a;
        if (yo4Var == null) {
            preference.x(false);
            return xl4Var;
        }
        preference.x(true);
        preference.w(othersSettingsFragment.getString(R.string.setting_check_update_summary_template, yo4Var.a, yo4Var.b));
        preference.Y = new jd(27, yo4Var);
        return xl4Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onResume$lambda$0$0(yo4 yo4Var, Preference preference) {
        preference.getClass();
        Context context = preference.b;
        context.getClass();
        vo.F(context, yo4Var.c);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(OthersSettingsFragment othersSettingsFragment, Preference preference) {
        preference.getClass();
        xb5.c("settings do_not_kill_my_app clicked");
        Bundle bundle = new Bundle();
        bundle.putString(RtspHeaders.Values.URL, "https://dontkillmyapp.com/");
        fn4 fn4Var = new fn4();
        fn4Var.setArguments(bundle);
        u childFragmentManager = othersSettingsFragment.getChildFragmentManager();
        childFragmentManager.getClass();
        fn4Var.m(childFragmentManager, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$0(OthersSettingsFragment othersSettingsFragment, Preference preference) {
        preference.getClass();
        View viewP = t23.p(othersSettingsFragment, preference);
        if (viewP == null) {
            return true;
        }
        viewP.getContext().startActivity(new Intent(viewP.getContext(), (Class<?>) DeveloperOptionsActivity.class), l72.z(viewP));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2$0(zg3 zg3Var, OthersSettingsFragment othersSettingsFragment, Preference preference) {
        preference.getClass();
        int i = zg3Var.b + 1;
        zg3Var.b = i;
        if (i >= 5) {
            SharedPreferences.Editor editorEdit = t23.l().edit();
            editorEdit.putBoolean("develop_options_displayed", true);
            editorEdit.apply();
            Preference preferenceFindPreference = othersSettingsFragment.findPreference(othersSettingsFragment.getString(R.string.setting_developer_options_key));
            if (preferenceFindPreference != null) {
                preferenceFindPreference.x(true);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3$0(OthersSettingsFragment othersSettingsFragment, Preference preference) {
        preference.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(RtspHeaders.Values.URL, "https://getsurfboard.com/docs/agreement/privacy_policy/");
        fn4 fn4Var = new fn4();
        fn4Var.setArguments(bundle);
        u childFragmentManager = othersSettingsFragment.getChildFragmentManager();
        childFragmentManager.getClass();
        fn4Var.m(childFragmentManager, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4$0(OthersSettingsFragment othersSettingsFragment, Preference preference) {
        preference.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(RtspHeaders.Values.URL, "https://getsurfboard.com/docs/changelog/");
        fn4 fn4Var = new fn4();
        fn4Var.setArguments(bundle);
        u childFragmentManager = othersSettingsFragment.getChildFragmentManager();
        childFragmentManager.getClass();
        fn4Var.m(childFragmentManager, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$5$0(Preference preference) {
        preference.getClass();
        Context context = preference.b;
        context.getClass();
        vo.F(context, "https://t.me/surfboardnews");
        return true;
    }

    @Override // defpackage.nk
    public Set<Integer> getRestartVPNPreferenceKeys() {
        return k41.b;
    }

    @Override // defpackage.j33, androidx.fragment.app.o
    public void onDestroyView() {
        boolean z = nj3.a;
        nj3.e.d(this);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.o
    public void onResume() {
        super.onResume();
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_check_update_key));
        if (preferenceFindPreference == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        uf2.f(contextRequireContext, this, new gj(11, preferenceFindPreference, this));
    }

    @Override // defpackage.nk, defpackage.j33, androidx.fragment.app.o
    public void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_do_not_kill_my_app_key));
        final int i = 0;
        if (preferenceFindPreference != null) {
            preferenceFindPreference.Y = new w23(this) { // from class: vw2
                public final /* synthetic */ OthersSettingsFragment f;

                {
                    this.f = this;
                }

                @Override // defpackage.w23
                public final boolean k(Preference preference) {
                    int i2 = i;
                    OthersSettingsFragment othersSettingsFragment = this.f;
                    switch (i2) {
                        case 0:
                            return OthersSettingsFragment.onViewCreated$lambda$0(othersSettingsFragment, preference);
                        case 1:
                            return OthersSettingsFragment.onViewCreated$lambda$1$0(othersSettingsFragment, preference);
                        case 2:
                            return OthersSettingsFragment.onViewCreated$lambda$3$0(othersSettingsFragment, preference);
                        default:
                            return OthersSettingsFragment.onViewCreated$lambda$4$0(othersSettingsFragment, preference);
                    }
                }
            };
        }
        Preference preferenceFindPreference2 = findPreference(getString(R.string.setting_developer_options_key));
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.x(t23.d("develop_options_displayed", false));
            final int i2 = 1;
            preferenceFindPreference2.Y = new w23(this) { // from class: vw2
                public final /* synthetic */ OthersSettingsFragment f;

                {
                    this.f = this;
                }

                @Override // defpackage.w23
                public final boolean k(Preference preference) {
                    int i22 = i2;
                    OthersSettingsFragment othersSettingsFragment = this.f;
                    switch (i22) {
                        case 0:
                            return OthersSettingsFragment.onViewCreated$lambda$0(othersSettingsFragment, preference);
                        case 1:
                            return OthersSettingsFragment.onViewCreated$lambda$1$0(othersSettingsFragment, preference);
                        case 2:
                            return OthersSettingsFragment.onViewCreated$lambda$3$0(othersSettingsFragment, preference);
                        default:
                            return OthersSettingsFragment.onViewCreated$lambda$4$0(othersSettingsFragment, preference);
                    }
                }
            };
        }
        zg3 zg3Var = new zg3();
        Preference preferenceFindPreference3 = findPreference(getString(R.string.setting_version_key));
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.w("mobile-2.34.1 (Build 286)");
            preferenceFindPreference3.Y = new ed(11, zg3Var, this);
        }
        Preference preferenceFindPreference4 = findPreference(getString(R.string.setting_privacy_policy_key));
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.w("https://getsurfboard.com/docs/agreement/privacy_policy/");
            final int i3 = 2;
            preferenceFindPreference4.Y = new w23(this) { // from class: vw2
                public final /* synthetic */ OthersSettingsFragment f;

                {
                    this.f = this;
                }

                @Override // defpackage.w23
                public final boolean k(Preference preference) {
                    int i22 = i3;
                    OthersSettingsFragment othersSettingsFragment = this.f;
                    switch (i22) {
                        case 0:
                            return OthersSettingsFragment.onViewCreated$lambda$0(othersSettingsFragment, preference);
                        case 1:
                            return OthersSettingsFragment.onViewCreated$lambda$1$0(othersSettingsFragment, preference);
                        case 2:
                            return OthersSettingsFragment.onViewCreated$lambda$3$0(othersSettingsFragment, preference);
                        default:
                            return OthersSettingsFragment.onViewCreated$lambda$4$0(othersSettingsFragment, preference);
                    }
                }
            };
        }
        Preference preferenceFindPreference5 = findPreference(getString(R.string.setting_changelog_key));
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.w("https://getsurfboard.com/docs/changelog/");
            final int i4 = 3;
            preferenceFindPreference5.Y = new w23(this) { // from class: vw2
                public final /* synthetic */ OthersSettingsFragment f;

                {
                    this.f = this;
                }

                @Override // defpackage.w23
                public final boolean k(Preference preference) {
                    int i22 = i4;
                    OthersSettingsFragment othersSettingsFragment = this.f;
                    switch (i22) {
                        case 0:
                            return OthersSettingsFragment.onViewCreated$lambda$0(othersSettingsFragment, preference);
                        case 1:
                            return OthersSettingsFragment.onViewCreated$lambda$1$0(othersSettingsFragment, preference);
                        case 2:
                            return OthersSettingsFragment.onViewCreated$lambda$3$0(othersSettingsFragment, preference);
                        default:
                            return OthersSettingsFragment.onViewCreated$lambda$4$0(othersSettingsFragment, preference);
                    }
                }
            };
        }
        Preference preferenceFindPreference6 = findPreference(getString(R.string.setting_feedback_key));
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.Y = new zo2(20);
        }
    }
}
