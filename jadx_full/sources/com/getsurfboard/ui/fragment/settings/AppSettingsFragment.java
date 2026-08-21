package com.getsurfboard.ui.fragment.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.ui.activity.AppThemeConfigActivity;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import defpackage.cd;
import defpackage.d70;
import defpackage.da2;
import defpackage.dd;
import defpackage.ed;
import defpackage.f70;
import defpackage.fd;
import defpackage.g;
import defpackage.ge0;
import defpackage.hd;
import defpackage.ji0;
import defpackage.jj;
import defpackage.k41;
import defpackage.ka;
import defpackage.l72;
import defpackage.li;
import defpackage.ma;
import defpackage.mi;
import defpackage.n12;
import defpackage.n4;
import defpackage.ni;
import defpackage.nk;
import defpackage.p6;
import defpackage.p95;
import defpackage.r4;
import defpackage.r90;
import defpackage.rd2;
import defpackage.t23;
import defpackage.td2;
import defpackage.u6;
import defpackage.ud2;
import defpackage.uf2;
import defpackage.vf2;
import defpackage.w0;
import defpackage.wh2;
import defpackage.xb5;
import defpackage.xl4;
import defpackage.z0;
import defpackage.zf2;
import defpackage.zo2;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppSettingsFragment extends nk {
    public static final fd Companion = new fd();
    private static final String STATE_EXPORT_PASSWORD = "state_export_password";
    private static final String STATE_EXPORT_SECTIONS = "state_export_sections";
    private final r4 exportLauncher;
    private final jj importHelper;
    private char[] pendingExportPassword;
    private Set<? extends BackupSection> pendingExportSections;

    public AppSettingsFragment() {
        super(R.xml.fragment_app_settings);
        this.pendingExportSections = k41.b;
        r4 r4VarRegisterForActivityResult = registerForActivityResult(new n4(0), new dd(this, 1));
        r4VarRegisterForActivityResult.getClass();
        this.exportLauncher = r4VarRegisterForActivityResult;
        this.importHelper = new jj(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exportLauncher$lambda$0(AppSettingsFragment appSettingsFragment, Uri uri) {
        if (uri != null) {
            appSettingsFragment.runExport(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$2(Preference preference, Object obj) {
        preference.getClass();
        xb5.c("settings app_locale clicked: " + obj);
        if (n12.c(obj, "default")) {
            ma.j(rd2.b);
            return true;
        }
        obj.getClass();
        ma.j(rd2.b((String) obj));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$10(AppSettingsFragment appSettingsFragment, Preference preference) {
        preference.getClass();
        Context contextRequireContext = appSettingsFragment.requireContext();
        contextRequireContext.getClass();
        zf2 zf2Var = new zf2(7, contextRequireContext);
        int i = 0;
        cd cdVar = new cd(i, appSettingsFragment);
        r90 r90VarH = r90.h(LayoutInflater.from(contextRequireContext));
        wh2 wh2Var = new wh2(contextRequireContext);
        wh2Var.x(R.string.backup_export);
        wh2Var.y((LinearLayout) r90VarH.a);
        wh2Var.u(R.string.cancel, null);
        wh2Var.w(R.string.export, new li(r90VarH, cdVar, zf2Var));
        u6 u6VarH = wh2Var.h();
        ni niVar = new ni(zf2Var, r90VarH, u6VarH);
        ((MaterialCheckBox) r90VarH.f).setOnCheckedChangeListener(niVar);
        ((MaterialCheckBox) r90VarH.g).setOnCheckedChangeListener(niVar);
        ((MaterialCheckBox) r90VarH.e).setOnCheckedChangeListener(niVar);
        ((MaterialCheckBox) r90VarH.d).setOnCheckedChangeListener(niVar);
        u6VarH.setOnShowListener(new mi(zf2Var, r90VarH, u6VarH, i));
        u6VarH.show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xl4 onViewCreated$lambda$10$0(AppSettingsFragment appSettingsFragment, Set set, char[] cArr) {
        set.getClass();
        appSettingsFragment.pendingExportSections = set;
        appSettingsFragment.pendingExportPassword = cArr;
        appSettingsFragment.exportLauncher.a("surfboard-backup-" + new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.US).format(new Date()) + ".zip");
        return xl4.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$11(AppSettingsFragment appSettingsFragment, Preference preference) {
        preference.getClass();
        appSettingsFragment.importHelper.b.a(new String[]{"application/zip", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE, "*/*"});
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2$0(AppSettingsFragment appSettingsFragment, Preference preference, Preference preference2) {
        preference2.getClass();
        View viewP = t23.p(appSettingsFragment, preference);
        if (viewP == null) {
            return true;
        }
        viewP.getContext().startActivity(new Intent(viewP.getContext(), (Class<?>) AppThemeConfigActivity.class), l72.z(viewP));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3$0(Preference preference, Object obj) {
        preference.getClass();
        p95.C(R.string.pls_restart_app_to_take_effect, new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4$0(Preference preference, Object obj) {
        preference.getClass();
        p95.C(R.string.pls_restart_app_to_take_effect, new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$5$0(AppSettingsFragment appSettingsFragment, Preference preference, Object obj) {
        preference.getClass();
        obj.getClass();
        if (((Boolean) obj).booleanValue()) {
            appSettingsFragment.requireActivity().getWindow().addFlags(8192);
            return true;
        }
        appSettingsFragment.requireActivity().getWindow().clearFlags(8192);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$9$0(EditText editText) {
        editText.getClass();
        editText.setInputType(2);
        editText.setSelection(editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onViewCreated$lambda$9$1(AppSettingsFragment appSettingsFragment, Preference preference) {
        preference.getClass();
        return appSettingsFragment.getString(R.string.profile_fetch_timeout_summary_template, String.valueOf(((EditTextPreference) preference).k1));
    }

    private final void runExport(Uri uri) {
        if (this.pendingExportSections.isEmpty()) {
            String string = getString(R.string.backup_export_failed, "no content selected");
            string.getClass();
            p95.D(string);
            return;
        }
        Context contextRequireContext = requireContext();
        contextRequireContext.getClass();
        ge0 ge0Var = null;
        View viewInflate = LayoutInflater.from(contextRequireContext).inflate(R.layout.dialog_backup_progress, (ViewGroup) null, false);
        int i = R.id.progress;
        if (((ProgressBar) vf2.l(viewInflate, R.id.progress)) != null) {
            i = R.id.stage;
            MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.stage);
            if (materialTextView != null) {
                materialTextView.setText(R.string.backup_export);
                wh2 wh2Var = new wh2(contextRequireContext);
                wh2Var.x(R.string.backup_export);
                wh2Var.y((LinearLayout) viewInflate);
                ((p6) wh2Var.z).n = false;
                u6 u6VarR = wh2Var.r();
                da2 viewLifecycleOwner = getViewLifecycleOwner();
                viewLifecycleOwner.getClass();
                ji0.B(uf2.t(viewLifecycleOwner), null, null, new hd(this, u6VarR, uri, ge0Var, 0), 3);
                return;
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // defpackage.nk
    public Set<Integer> getRestartVPNPreferenceKeys() {
        return k41.b;
    }

    @Override // defpackage.j33, androidx.fragment.app.o
    public void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        Set<? extends BackupSection> set = this.pendingExportSections;
        ArrayList arrayList = new ArrayList(f70.Q(10, set));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((BackupSection) it.next()).name());
        }
        bundle.putStringArray(STATE_EXPORT_SECTIONS, (String[]) arrayList.toArray(new String[0]));
        char[] cArr = this.pendingExportPassword;
        bundle.putString(STATE_EXPORT_PASSWORD, cArr != null ? new String(cArr) : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x018c  */
    @Override // defpackage.nk, defpackage.j33, androidx.fragment.app.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle bundle) {
        int i;
        int i2;
        String str;
        rd2 rd2Var;
        td2 td2Var;
        String languageTag;
        String string;
        Set<? extends BackupSection> setC0;
        Object next;
        view.getClass();
        super.onViewCreated(view, bundle);
        int i3 = 0;
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray(STATE_EXPORT_SECTIONS);
            char[] charArray = null;
            if (stringArray != null) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : stringArray) {
                    z0 z0Var = (z0) BackupSection.getEntries();
                    z0Var.getClass();
                    w0 w0Var = new w0(i3, z0Var);
                    while (true) {
                        if (w0Var.hasNext()) {
                            next = w0Var.next();
                            if (n12.c(((BackupSection) next).name(), str2)) {
                                break;
                            }
                        } else {
                            next = null;
                            break;
                        }
                    }
                    BackupSection backupSection = (BackupSection) next;
                    if (backupSection != null) {
                        arrayList.add(backupSection);
                    }
                }
                setC0 = d70.C0(arrayList);
            } else {
                setC0 = k41.b;
            }
            this.pendingExportSections = setC0;
            String string2 = bundle.getString(STATE_EXPORT_PASSWORD);
            if (string2 != null) {
                charArray = string2.toCharArray();
                charArray.getClass();
            }
            this.pendingExportPassword = charArray;
        }
        ListPreference listPreference = (ListPreference) findPreference(getString(R.string.setting_app_locale_key));
        int i4 = 2;
        if (listPreference != null) {
            i = 4;
            i2 = 3;
            rd2[] rd2VarArr = {rd2.b, rd2.b("en-US"), rd2.b("es-ES"), rd2.b("fa-IR"), rd2.b("in-ID"), rd2.b("ja-JP"), rd2.b("ru-RU"), rd2.b("tr-TR"), rd2.b("vi-RN"), rd2.b("zh-CN"), rd2.b("zh-HK"), rd2.b("zh-TW"), rd2.b("ko-KR")};
            ArrayList arrayList2 = new ArrayList(13);
            for (int i5 = 0; i5 < 13; i5++) {
                Locale locale = rd2VarArr[i5].a.get(0);
                if (locale == null || (string = locale.getDisplayName()) == null) {
                    string = getString(R.string.default_locale);
                    string.getClass();
                }
                arrayList2.add(string);
            }
            listPreference.B((CharSequence[]) arrayList2.toArray(new String[0]));
            ArrayList arrayList3 = new ArrayList(13);
            int i6 = 0;
            while (true) {
                str = "default";
                if (i6 >= 13) {
                    break;
                }
                Locale locale2 = rd2VarArr[i6].a.get(0);
                if (locale2 != null && (languageTag = locale2.toLanguageTag()) != null) {
                    str = languageTag;
                }
                arrayList3.add(str);
                i6++;
            }
            listPreference.l1 = (CharSequence[]) arrayList3.toArray(new String[0]);
            listPreference.X = new g(26);
            if (Build.VERSION.SDK_INT >= 33) {
                Object objB = ma.b();
                rd2Var = objB != null ? new rd2(new ud2(ka.a(objB))) : rd2.b;
                rd2Var.getClass();
                td2Var = rd2Var.a;
                if (!td2Var.isEmpty()) {
                    Locale locale3 = td2Var.get(0);
                    locale3.getClass();
                    str = locale3.getLanguage() + "-" + locale3.getCountry();
                }
                listPreference.setValue(str);
                xb5.c("settings app_locale read value: " + listPreference.m1);
            } else {
                rd2Var = ma.z;
                if (rd2Var == null) {
                }
                rd2Var.getClass();
                td2Var = rd2Var.a;
                if (!td2Var.isEmpty()) {
                }
                listPreference.setValue(str);
                xb5.c("settings app_locale read value: " + listPreference.m1);
            }
        } else {
            i = 4;
            i2 = 3;
        }
        Preference preferenceFindPreference = findPreference(getString(R.string.setting_app_theme_config_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.Y = new ed(i3, this, preferenceFindPreference);
        }
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_logout_output_key));
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.X = new g(27);
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_profile_list_actions_key));
        if (switchPreferenceCompat2 != null) {
            switchPreferenceCompat2.X = new g(28);
        }
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_masked_from_recent_task_key));
        if (switchPreferenceCompat3 != null) {
            switchPreferenceCompat3.X = new dd(this, i4);
        }
        SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_use_external_editor_key));
        if (switchPreferenceCompat4 != null) {
            switchPreferenceCompat4.w(getString(R.string.setting_use_external_editor_summary, getString(R.string.app_name)));
        }
        SwitchPreferenceCompat switchPreferenceCompat5 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_hide_from_recent_task_key));
        if (switchPreferenceCompat5 != null) {
            switchPreferenceCompat5.w(getString(R.string.setting_hide_from_recent_task_summary, getString(R.string.app_name)));
        }
        SwitchPreferenceCompat switchPreferenceCompat6 = (SwitchPreferenceCompat) findPreference(getString(R.string.setting_masked_from_recent_task_key));
        if (switchPreferenceCompat6 != null) {
            switchPreferenceCompat6.w(getString(R.string.setting_masked_from_recent_task_summary, getString(R.string.app_name)));
        }
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(getString(R.string.setting_profile_fetch_timeout));
        if (editTextPreference != null) {
            editTextPreference.l1 = new g(29);
            editTextPreference.c1 = new dd(this, i2);
            editTextPreference.i();
        }
        Preference preferenceFindPreference2 = findPreference("backup_export");
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.Y = new dd(this, i);
        }
        Preference preferenceFindPreference3 = findPreference("backup_import");
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.Y = new dd(this, i3);
        }
    }
}
