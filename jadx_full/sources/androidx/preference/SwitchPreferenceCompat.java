package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import androidx.appcompat.widget.SwitchCompat;
import com.getsurfboard.R;
import defpackage.ad3;
import defpackage.t33;
import defpackage.z30;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    public final z30 j1;
    public final String k1;
    public final String l1;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.switchPreferenceCompatStyle);
        this.j1 = new z30(this, 2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.m, R.attr.switchPreferenceCompatStyle, 0);
        String string = typedArrayObtainStyledAttributes.getString(7);
        this.f1 = string == null ? typedArrayObtainStyledAttributes.getString(0) : string;
        if (this.e1) {
            i();
        }
        String string2 = typedArrayObtainStyledAttributes.getString(6);
        this.g1 = string2 == null ? typedArrayObtainStyledAttributes.getString(1) : string2;
        if (!this.e1) {
            i();
        }
        String string3 = typedArrayObtainStyledAttributes.getString(9);
        this.k1 = string3 == null ? typedArrayObtainStyledAttributes.getString(3) : string3;
        i();
        String string4 = typedArrayObtainStyledAttributes.getString(8);
        this.l1 = string4 == null ? typedArrayObtainStyledAttributes.getString(4) : string4;
        i();
        this.i1 = typedArrayObtainStyledAttributes.getBoolean(5, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.e1);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.k1);
            switchCompat.setTextOff(this.l1);
            switchCompat.setOnCheckedChangeListener(this.j1);
        }
    }

    @Override // androidx.preference.Preference
    public final void m(t33 t33Var) {
        super.m(t33Var);
        C(t33Var.s(R.id.switchWidget));
        B(t33Var.s(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    public final void t(View view) {
        super.t(view);
        if (((AccessibilityManager) this.b.getSystemService("accessibility")).isEnabled()) {
            C(view.findViewById(R.id.switchWidget));
            B(view.findViewById(android.R.id.summary));
        }
    }
}
