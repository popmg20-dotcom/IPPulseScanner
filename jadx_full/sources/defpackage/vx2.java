package defpackage;

import android.widget.EditText;
import androidx.preference.Preference;
import com.getsurfboard.ui.fragment.settings.OverrideSettingsFragment;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vx2 implements w23, l01 {
    public final /* synthetic */ int b;
    public final /* synthetic */ OverrideSettingsFragment f;

    public /* synthetic */ vx2(OverrideSettingsFragment overrideSettingsFragment, int i) {
        this.b = i;
        this.f = overrideSettingsFragment;
    }

    @Override // defpackage.l01
    public void a(EditText editText) {
        OverrideSettingsFragment.onViewCreated$lambda$3$0$0(this.f, editText);
    }

    @Override // defpackage.w23
    public boolean k(Preference preference) {
        int i = this.b;
        OverrideSettingsFragment overrideSettingsFragment = this.f;
        switch (i) {
            case 0:
                return OverrideSettingsFragment.onViewCreated$lambda$0$0(overrideSettingsFragment, preference);
            default:
                return OverrideSettingsFragment.onViewCreated$lambda$1$0(overrideSettingsFragment, preference);
        }
    }
}
