package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.getsurfboard.R;
import defpackage.ad3;
import defpackage.l72;
import defpackage.t33;
import defpackage.z30;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    public final z30 j1;

    /* JADX WARN: Illegal instructions before constructor call */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        int iP = l72.p(context, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle);
        super(context, attributeSet, iP);
        this.j1 = new z30(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.b, iP, 0);
        String string = typedArrayObtainStyledAttributes.getString(5);
        this.f1 = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.e1) {
            i();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(4);
        this.g1 = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.e1) {
            i();
        }
        this.i1 = typedArrayObtainStyledAttributes.getBoolean(3, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.e1);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.j1);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(t33 t33Var) {
        super.m(t33Var);
        C(t33Var.s(android.R.id.checkbox));
        B(t33Var.s(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(android.R.id.checkbox));
            B(view.findViewById(android.R.id.summary));
        }
    }
}
