package defpackage;

import android.net.Uri;
import androidx.preference.Preference;
import com.getsurfboard.ui.fragment.settings.AppSettingsFragment;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dd implements w23, l4, v23, y23 {
    public final /* synthetic */ int b;
    public final /* synthetic */ AppSettingsFragment f;

    public /* synthetic */ dd(AppSettingsFragment appSettingsFragment, int i) {
        this.b = i;
        this.f = appSettingsFragment;
    }

    @Override // defpackage.y23
    public CharSequence e(Preference preference) {
        return AppSettingsFragment.onViewCreated$lambda$9$1(this.f, preference);
    }

    @Override // defpackage.l4
    public void h(Object obj) {
        AppSettingsFragment.exportLauncher$lambda$0(this.f, (Uri) obj);
    }

    @Override // defpackage.v23
    public boolean i(Preference preference, Object obj) {
        return AppSettingsFragment.onViewCreated$lambda$5$0(this.f, preference, obj);
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        int i = this.b;
        AppSettingsFragment appSettingsFragment = this.f;
        switch (i) {
            case 0:
                return AppSettingsFragment.onViewCreated$lambda$11(appSettingsFragment, preference);
            default:
                return AppSettingsFragment.onViewCreated$lambda$10(appSettingsFragment, preference);
        }
    }
}
