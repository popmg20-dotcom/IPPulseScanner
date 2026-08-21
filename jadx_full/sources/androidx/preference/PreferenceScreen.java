package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import com.getsurfboard.R;
import defpackage.j33;
import defpackage.l72;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean k1;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, l72.p(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle), 0);
        this.k1 = true;
    }

    @Override // androidx.preference.Preference
    public final void n() {
        j33 j33Var;
        if (this.D0 != null || this.E0 != null || this.f1.size() == 0 || (j33Var = this.f.j) == null) {
            return;
        }
        j33Var.onNavigateToScreen(this);
    }
}
