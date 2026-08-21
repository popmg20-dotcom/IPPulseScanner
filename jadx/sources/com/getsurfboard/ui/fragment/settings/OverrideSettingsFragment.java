package com.getsurfboard.ui.fragment.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import defpackage.d70;
import defpackage.ed;
import defpackage.l72;
import defpackage.n12;
import defpackage.nj3;
import defpackage.nk;
import defpackage.oy3;
import defpackage.qe;
import defpackage.ri;
import defpackage.t23;
import defpackage.vx2;
import defpackage.zo2;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OverrideSettingsFragment extends nk {
    public OverrideSettingsFragment() {
        super(R.xml.fragment_override_settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0$0(OverrideSettingsFragment overrideSettingsFragment, Preference preference) {
        preference.getClass();
        View viewP = t23.p(overrideSettingsFragment, preference);
        if (viewP == null) {
            return true;
        }
        int i = OverrideDoHActivity.X0;
        viewP.getContext().startActivity(new Intent(viewP.getContext(), (Class<?>) OverrideDoHActivity.class), l72.z(viewP));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$0(OverrideSettingsFragment overrideSettingsFragment, Preference preference) {
        preference.getClass();
        View viewP = t23.p(overrideSettingsFragment, preference);
        if (viewP == null) {
            return true;
        }
        int i = HostsListActivity.a1;
        viewP.getContext().startActivity(new Intent(viewP.getContext(), (Class<?>) HostsListActivity.class), l72.z(viewP));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2$0(Set set, OverrideSettingsFragment overrideSettingsFragment, Preference preference, Object obj) {
        preference.getClass();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Preference preference2 = (Preference) it.next();
            if (preference2 != null) {
                obj.getClass();
                preference2.x(((Boolean) obj).booleanValue());
            }
        }
        return overrideSettingsFragment.getRestartListener().i(preference, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$0$0(OverrideSettingsFragment overrideSettingsFragment, EditText editText) {
        editText.getClass();
        editText.setSelection(editText.length());
        editText.addTextChangedListener(new ri(3, overrideSettingsFragment, editText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3$0$1(OverrideSettingsFragment overrideSettingsFragment, EditTextPreference editTextPreference, Preference preference, Object obj) {
        preference.getClass();
        if (!overrideSettingsFragment.validatePortRange(obj)) {
            oy3.g(overrideSettingsFragment.requireView(), R.string.setting_override_lan_share_port_hint, -1).j();
            return false;
        }
        String str = editTextPreference.C0;
        str.getClass();
        if (overrideSettingsFragment.validatePortDuplication(str, Integer.parseInt(obj.toString()))) {
            return overrideSettingsFragment.getRestartListener().i(preference, obj);
        }
        oy3.h(overrideSettingsFragment.requireView(), overrideSettingsFragment.getString(R.string.setting_override_lan_share_port_duplication_template, n12.c(editTextPreference.C0, overrideSettingsFragment.getString(R.string.setting_override_lan_share_http_port_key)) ? "HTTP" : "SOCKS5"), -1).j();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4$0(Preference preference, Object obj) {
        preference.getClass();
        boolean z = nj3.a;
        obj.getClass();
        nj3.a = ((Boolean) obj).booleanValue();
        return true;
    }

    private final void updateDoHSummary(Preference preference) {
        List listR = t23.r();
        preference.w((listR == null || listR.isEmpty()) ? getString(R.string.setting_override_doh_summary_none) : listR.size() == 1 ? (CharSequence) d70.d0(listR) : getResources().getQuantityString(R.plurals.override_doh_summary_multiple, listR.size(), d70.d0(listR), Integer.valueOf(listR.size())));
    }

    private final boolean validatePortDuplication(String str, int i) {
        return n12.c(str, getString(R.string.setting_override_lan_share_http_port_key)) ? i != t23.v() : i != t23.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean validatePortRange(Object obj) {
        try {
            int i = Integer.parseInt(String.valueOf(obj));
            return 1025 <= i && i < 65536;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // defpackage.nk
    public Set<Integer> getRestartVPNPreferenceKeys() {
        return qe.t0(new Integer[]{Integer.valueOf(R.string.setting_override_lan_share_listen_key), Integer.valueOf(R.string.setting_bypass_tls_verify_key), Integer.valueOf(R.string.setting_force_udp_relay_key), Integer.valueOf(R.string.setting_force_remote_dns_key), Integer.valueOf(R.string.setting_override_ipv6_key)});
    }

    @Override // androidx.fragment.app.o
    public void onResume() {
        super.onResume();
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_override_doh_v2_key));
        if (preferenceFindPreference != null) {
            updateDoHSummary(preferenceFindPreference);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.nk, defpackage.j33, androidx.fragment.app.o
    public void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_override_doh_v2_key));
        int i = 0;
        if (preferenceFindPreference != null) {
            updateDoHSummary(preferenceFindPreference);
            preferenceFindPreference.Y = new vx2(this, i);
        }
        Preference preferenceFindPreference2 = findPreference(getString(R.string.setting_hosts_key));
        int i2 = 1;
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.Y = new vx2(this, i2);
        }
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_override_lan_share_key));
        int i3 = 2;
        if (switchPreferenceCompat != null) {
            Set<Preference> setT0 = qe.t0(new Preference[]{findPreference(getString(R.string.setting_override_lan_share_listen_key)), findPreference(getString(R.string.setting_override_lan_share_http_port_key)), findPreference(getString(R.string.setting_override_lan_share_socks5_port_key))});
            switchPreferenceCompat.X = new ed(12, setT0, this);
            for (Preference preference : setT0) {
                if (preference != null) {
                    preference.x(switchPreferenceCompat.e1);
                }
            }
        }
        for (EditTextPreference editTextPreference : qe.t0(new EditTextPreference[]{findPreference(getString(R.string.setting_override_lan_share_http_port_key)), findPreference(getString(R.string.setting_override_lan_share_socks5_port_key))})) {
            if (editTextPreference != null) {
                editTextPreference.l1 = new vx2(this, i3);
                editTextPreference.X = new ed(13, this, editTextPreference);
            }
        }
        Preference preferenceFindPreference3 = findPreference(getString(R.string.setting_bypass_tls_verify_key));
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.X = new zo2(21);
        }
    }
}
