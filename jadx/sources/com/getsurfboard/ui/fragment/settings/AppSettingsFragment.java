package com.getsurfboard.ui.fragment.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.getsurfboard.R;
import com.getsurfboard.backup.model.BackupSection;
import com.getsurfboard.ui.activity.AppThemeConfigActivity;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import defpackage.cd;
import defpackage.da2;
import defpackage.dd;
import defpackage.f70;
import defpackage.fd;
import defpackage.ge0;
import defpackage.hd;
import defpackage.ji0;
import defpackage.jj;
import defpackage.k41;
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
import defpackage.u6;
import defpackage.uf2;
import defpackage.vf2;
import defpackage.wh2;
import defpackage.xb5;
import defpackage.xl4;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instruction units count: 716
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.ui.fragment.settings.AppSettingsFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
