package com.getsurfboard.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.o;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import defpackage.co4;
import defpackage.j33;
import defpackage.je;
import defpackage.mp4;
import defpackage.n4;
import defpackage.nf4;
import defpackage.of4;
import defpackage.q74;
import defpackage.r4;
import defpackage.t23;
import defpackage.wp4;
import defpackage.ws4;
import defpackage.x3;
import defpackage.z71;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ToolsFragment extends j33 {
    public r4 b;
    public r4 f;

    @Override // defpackage.j33, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r4 r4VarRegisterForActivityResult = registerForActivityResult(new n4(5), new of4(this, 2));
        r4VarRegisterForActivityResult.getClass();
        this.b = r4VarRegisterForActivityResult;
        r4 r4VarRegisterForActivityResult2 = registerForActivityResult(new n4(8), new of4(this, 3));
        r4VarRegisterForActivityResult2.getClass();
        this.f = r4VarRegisterForActivityResult2;
    }

    @Override // defpackage.j33
    public final void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.fragment_tools, str);
    }

    @Override // androidx.fragment.app.o
    public final void onResume() {
        super.onResume();
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_logcat_viewer_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.x(t23.i());
            preferenceFindPreference.Y = new of4(this, 0);
        }
        Preference preferenceFindPreference2 = findPreference(getString(R.string.setting_export_log_key));
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.x(!co4.H());
            preferenceFindPreference2.Y = new of4(this, 4);
        }
    }

    @Override // defpackage.j33, androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        RecyclerView listView = getListView();
        of4 of4Var = new of4(this, 5);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(listView, of4Var);
        getListView().setItemAnimator(null);
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_external_resources_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.Y = new of4(this, 6);
        }
        Preference preferenceFindPreference2 = findPreference(getString(R.string.setting_bypass_config_key));
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.Y = new of4(this, 7);
        }
        Preference preferenceFindPreference3 = findPreference(getString(R.string.setting_recent_requests_key));
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.Y = new of4(this, 8);
        }
        Preference preferenceFindPreference4 = findPreference(getString(R.string.setting_nat_detect_key));
        if (preferenceFindPreference4 != null) {
            preferenceFindPreference4.Y = new of4(this, 9);
        }
        Preference preferenceFindPreference5 = findPreference(getString(R.string.setting_cloudflare_speedtest_key));
        int i = 10;
        if (preferenceFindPreference5 != null) {
            preferenceFindPreference5.Y = new of4(this, i);
        }
        Preference preferenceFindPreference6 = findPreference(getString(R.string.setting_google_api_check_key));
        if (preferenceFindPreference6 != null) {
            preferenceFindPreference6.Y = new of4(this, 11);
        }
        Preference preferenceFindPreference7 = findPreference(getString(R.string.setting_switch_import_key));
        if (preferenceFindPreference7 != null) {
            if (Build.VERSION.SDK_INT < 29 || !je.I()) {
                preferenceFindPreference7.x(false);
            }
            preferenceFindPreference7.Y = new of4(this, 12);
        }
        Preference preferenceFindPreference8 = findPreference(getString(R.string.setting_geoip_query_key));
        if (preferenceFindPreference8 != null) {
            preferenceFindPreference8.Y = new of4(this, 1);
        }
        ws4.a.e(getViewLifecycleOwner(), new x3(10, new q74(this)));
        o parentFragment = getParentFragment();
        if (parentFragment instanceof nf4) {
            getListView().j(new z71(4, (nf4) parentFragment));
        }
    }
}
