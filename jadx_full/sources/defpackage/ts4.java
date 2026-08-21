package defpackage;

import androidx.preference.Preference;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ts4 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ VpnSettingsFragment f;
    public final /* synthetic */ Preference z;

    public /* synthetic */ ts4(VpnSettingsFragment vpnSettingsFragment, Preference preference, int i) {
        this.b = i;
        this.f = vpnSettingsFragment;
        this.z = preference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Preference preference = this.z;
        VpnSettingsFragment vpnSettingsFragment = this.f;
        switch (i) {
            case 0:
                VpnSettingsFragment.attemptScrollAndFlick$lambda$2(vpnSettingsFragment, preference);
                break;
            case 1:
                vpnSettingsFragment.attemptScrollAndFlick(preference);
                break;
            default:
                VpnSettingsFragment.attemptScrollAndFlick$lambda$2$1(vpnSettingsFragment, preference);
                break;
        }
    }
}
