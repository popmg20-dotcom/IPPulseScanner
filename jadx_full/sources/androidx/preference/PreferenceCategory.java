package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.getsurfboard.R;
import defpackage.l72;
import defpackage.t33;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, l72.p(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle), 0);
    }

    @Override // androidx.preference.Preference
    public final boolean h() {
        return false;
    }

    @Override // androidx.preference.Preference
    public final void m(t33 t33Var) {
        super.m(t33Var);
        if (Build.VERSION.SDK_INT >= 28) {
            t33Var.a.setAccessibilityHeading(true);
        }
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return !super.h();
    }
}
